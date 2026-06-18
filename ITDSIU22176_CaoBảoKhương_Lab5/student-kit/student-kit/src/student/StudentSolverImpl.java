package student;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import mazechallenge.api.CellType;
import mazechallenge.api.CellView;
import mazechallenge.api.Direction;
import mazechallenge.api.MouseAction;
import mazechallenge.api.MousePerception;
import mazechallenge.api.RunPhase;
import mazechallenge.api.StudentSolver;

// ITDSIU22176 - Cao Bao Khuong
//
// Algorithm:
// SEARCH_RUN - DFS to explore the whole maze and find the goal
//   * use a stack to remember where we came from so we can backtrack
//   * record which directions are open at each cell
//
// SPEED_RUN - BFS on the map we learned to find shortest path to goal
//   * follow that path directly
//
// Since we can only do one action per step (turn or move),
// we queue up the needed turns + MOVE_FORWARD and execute one per call.

public class StudentSolverImpl implements StudentSolver {

    // for each cell we visit, store which directions are open
    // key = "row:col", value = map of Direction -> [neighborRow, neighborCol]
    private Map<String, Map<Direction, int[]>> openNeighbors = new HashMap<>();

    // cells visited during SEARCH_RUN
    private Map<String, Boolean> visited = new HashMap<>();

    // backtrack stack: stores cells we passed through on the way to current cell
    private Deque<int[]> backStack = new ArrayDeque<>();

    // actions to execute one by one (turns + move forward)
    private Deque<MouseAction> actionQueue = new ArrayDeque<>();

    // maps direction delta to Direction enum (e.g. (-1, 0) -> NORTH)
    // built from perception data so we don't hardcode which way NORTH is
    private Map<String, Direction> deltaMap = new HashMap<>();

    private int[] goalCell = null;    // discovered goal position
    private int[] startCell = null;   // position at start of SEARCH_RUN
    private int lastRow = -1;
    private int lastCol = -1;

    private RunPhase currentPhase = RunPhase.SEARCH_RUN;

    // BFS result for speed run
    private List<int[]> speedRunPath = null;
    private int pathIndex = 1; // skip index 0 (start), we are already there

    @Override
    public String getName() {
        return "ITDSIU22176 - Cao Bao Khuong";
    }

    @Override
    public void reset(int rows, int cols) {
        openNeighbors.clear();
        visited.clear();
        backStack.clear();
        actionQueue.clear();
        deltaMap.clear();
        goalCell = null;
        startCell = null;
        lastRow = -1;
        lastCol = -1;
        currentPhase = RunPhase.SEARCH_RUN;
        speedRunPath = null;
        pathIndex = 1;
    }

    @Override
    public void beginRun(RunPhase phase, int rows, int cols) {
        currentPhase = phase;
        actionQueue.clear();

        if (phase == RunPhase.SPEED_RUN) {
            // if goal was never spotted in sight lines, the last position
            // before this call is where SEARCH_RUN ended -> that's the goal
            if (goalCell == null && lastRow >= 0) {
                goalCell = new int[]{lastRow, lastCol};
            }

            if (startCell != null && goalCell != null) {
                speedRunPath = bfsPath(startCell, goalCell);
            }
            pathIndex = 1;
        }
    }

    @Override
    public MouseAction nextAction(MousePerception perception) {
        int row = perception.getRow();
        int col = perception.getCol();
        lastRow = row;
        lastCol = col;

        // remember where we started
        if (startCell == null && currentPhase == RunPhase.SEARCH_RUN) {
            startCell = new int[]{row, col};
        }

        // record open directions from this cell (once per cell)
        scanCurrentCell(perception);

        // try to spot the goal in any sight line
        if (goalCell == null) {
            lookForGoal(perception);
        }

        // execute any already-queued action
        if (!actionQueue.isEmpty()) {
            return actionQueue.poll();
        }

        if (currentPhase == RunPhase.SEARCH_RUN) {
            return dfsStep(row, col, perception.getDirection());
        } else {
            return speedStep(row, col, perception.getDirection());
        }
    }

    // -------------------------------------------------------------------------
    // SEARCH_RUN logic (DFS)
    // -------------------------------------------------------------------------

    private MouseAction dfsStep(int row, int col, Direction facing) {
        String key = key(row, col);
        visited.put(key, true);

        // check if any neighbor is unvisited
        Map<Direction, int[]> neighbors = openNeighbors.getOrDefault(key, Collections.emptyMap());
        for (Map.Entry<Direction, int[]> entry : neighbors.entrySet()) {
            int[] nb = entry.getValue();
            if (!visited.containsKey(key(nb[0], nb[1]))) {
                // go to this unvisited neighbor
                backStack.push(new int[]{row, col});
                queueTurnsAndMove(facing, entry.getKey());
                return actionQueue.poll();
            }
        }

        // all neighbors visited -> backtrack
        if (!backStack.isEmpty()) {
            int[] prev = backStack.pop();
            Direction dir = getDirectionTo(row, col, prev[0], prev[1]);
            if (dir != null) {
                queueTurnsAndMove(facing, dir);
                return actionQueue.poll();
            }
        }

        // nothing left to explore
        return MouseAction.WAIT;
    }

    // -------------------------------------------------------------------------
    // SPEED_RUN logic (follow BFS path)
    // -------------------------------------------------------------------------

    private MouseAction speedStep(int row, int col, Direction facing) {
        if (speedRunPath == null || pathIndex >= speedRunPath.size()) {
            return MouseAction.WAIT;
        }

        int[] next = speedRunPath.get(pathIndex);
        Direction dir = getDirectionTo(row, col, next[0], next[1]);

        if (dir == null) {
            return MouseAction.WAIT;
        }

        pathIndex++;
        queueTurnsAndMove(facing, dir);
        return actionQueue.poll();
    }

    // -------------------------------------------------------------------------
    // Helpers
    // -------------------------------------------------------------------------

    // scan open directions at current cell and store them
    private void scanCurrentCell(MousePerception perception) {
        int row = perception.getRow();
        int col = perception.getCol();
        String key = key(row, col);

        if (openNeighbors.containsKey(key)) return; // already scanned

        Map<Direction, int[]> dirs = new HashMap<>();
        for (Direction d : Direction.values()) {
            if (perception.canMove(d)) {
                int nr = perception.getNeighbor(d).getRow();
                int nc = perception.getNeighbor(d).getCol();
                dirs.put(d, new int[]{nr, nc});
                // also save delta -> Direction so we can look it up later
                deltaMap.put((nr - row) + "," + (nc - col), d);
            }
        }
        openNeighbors.put(key, dirs);
    }

    // look at neighbors and sight lines to find the goal cell
    private void lookForGoal(MousePerception perception) {
        for (Direction d : Direction.values()) {
            if (perception.canMove(d)) {
                CellView nb = perception.getNeighbor(d);
                if (nb.getType() == CellType.GOAL) {
                    goalCell = new int[]{nb.getRow(), nb.getCol()};
                    return;
                }
            }
            for (CellView cell : perception.getSightLine(d)) {
                if (cell.getType() == CellType.GOAL) {
                    goalCell = new int[]{cell.getRow(), cell.getCol()};
                    return;
                }
            }
        }
    }

    // queue the minimum number of turns + one MOVE_FORWARD
    private void queueTurnsAndMove(Direction facing, Direction target) {
        // count left turns needed
        int leftTurns = 0;
        Direction tmp = facing;
        while (tmp != target && leftTurns < 4) {
            tmp = tmp.turnLeft();
            leftTurns++;
        }

        // count right turns needed
        int rightTurns = 0;
        tmp = facing;
        while (tmp != target && rightTurns < 4) {
            tmp = tmp.turnRight();
            rightTurns++;
        }

        // use whichever is fewer
        if (leftTurns <= rightTurns) {
            for (int i = 0; i < leftTurns; i++) {
                actionQueue.add(MouseAction.TURN_LEFT);
            }
        } else {
            for (int i = 0; i < rightTurns; i++) {
                actionQueue.add(MouseAction.TURN_RIGHT);
            }
        }
        actionQueue.add(MouseAction.MOVE_FORWARD);
    }

    // find which Direction to move from (fromRow, fromCol) to reach (toRow, toCol)
    private Direction getDirectionTo(int fromRow, int fromCol, int toRow, int toCol) {
        // try the delta cache first
        Direction d = deltaMap.get((toRow - fromRow) + "," + (toCol - fromCol));
        if (d != null) return d;

        // fallback: search stored neighbors of the from-cell
        Map<Direction, int[]> nbrs = openNeighbors.get(key(fromRow, fromCol));
        if (nbrs != null) {
            for (Map.Entry<Direction, int[]> e : nbrs.entrySet()) {
                if (e.getValue()[0] == toRow && e.getValue()[1] == toCol) {
                    return e.getKey();
                }
            }
        }
        return null;
    }

    // BFS on the learned map, returns list of cells from src to dst
    private List<int[]> bfsPath(int[] src, int[] dst) {
        String srcKey = key(src[0], src[1]);
        String dstKey = key(dst[0], dst[1]);

        Map<String, String> prev = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        q.offer(srcKey);
        prev.put(srcKey, null);

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals(dstKey)) break;

            Map<Direction, int[]> nbrs = openNeighbors.getOrDefault(cur, Collections.emptyMap());
            for (int[] nb : nbrs.values()) {
                String nk = key(nb[0], nb[1]);
                if (!prev.containsKey(nk)) {
                    prev.put(nk, cur);
                    q.offer(nk);
                }
            }
        }

        if (!prev.containsKey(dstKey)) {
            return new ArrayList<>(); // no path found (shouldn't happen)
        }

        // reconstruct path from dst back to src, then reverse
        List<String> keys = new ArrayList<>();
        for (String k = dstKey; k != null; k = prev.get(k)) {
            keys.add(k);
        }
        Collections.reverse(keys);

        List<int[]> path = new ArrayList<>();
        for (String k : keys) {
            String[] parts = k.split(":");
            path.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
        }
        return path;
    }

    private String key(int row, int col) {
        return row + ":" + col;
    }
}
