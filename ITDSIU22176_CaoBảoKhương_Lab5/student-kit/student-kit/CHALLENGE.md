# Micromouse Challenge Requirements

## Objective

Your team must implement a maze-solving algorithm for a Micromouse-style simulator.

The mouse must:

1. explore an unknown maze
2. find the blue goal room during the `SEARCH_RUN`
3. keep the knowledge it learned
4. return from the start and reach the goal room again during the `SPEED_RUN`

The final goal is not only to finish, but to finish well.

## What You Receive

You are given:

- a compiled simulator framework
- a starter solver file
- a GUI to test your algorithm

You are **not** given the hidden maze generator or hidden evaluation maps.

## What You Must Implement

You must implement your algorithm inside:

- `src/student/StudentSolverImpl.java`

Your code should decide how the mouse:

- explores
- backtracks
- stores discovered information
- chooses directions
- controls speed
- improves performance in the speed run

## Allowed Algorithm Ideas

You may use any suitable algorithm, including:

- DFS
- BFS
- recursive backtracking
- flood fill
- shortest path
- heuristic search
- hybrid approaches

You are encouraged to design your own strategy.

## Rules

- The maze is initially unknown to your solver.
- The solver only receives local perception from the API.
- There is no direct `BACKWARD` action.
- To go back, the mouse must turn around and move forward.
- The solver must work on many different mazes, not only one maze.
- Hard-coding a fixed path is not acceptable.

## Deliverables

Each team submits:

- `StudentSolverImpl.java`

Optional:

- a short explanation of the algorithm used
- important design decisions
- any known limitations

## Minimum Correctness Requirement

A valid solution should:

- compile successfully
- run inside the provided simulator
- complete the search run on non-trivial mazes
- attempt a meaningful speed run using discovered information

## Evaluation

Your solution will be evaluated using hidden maps.

Evaluation criteria may include:

- whether the search run is completed
- whether the speed run is completed
- total time
- search run time
- speed run time
- number of actions
- path efficiency
- collision count
- speed control quality

## Competition / Winner

To determine the winner, we will test each solution on at least:

- `5 hidden maps`, and possibly
- `10 hidden maps`

These hidden maps will include:

- very difficult mazes
- multi-route mazes
- loop-heavy mazes
- extremely hard “hell level” mazes

The winner will be the team whose solver performs best overall on the hidden evaluation set, not only on the example mazes provided in class.

## Important Advice

- Do not optimize only for one map.
- Make your solver robust.
- Make your solver able to recover from dead ends.
- Make your solver remember useful information between search and speed run.
- Think about both correctness and performance.

## Academic Integrity

- You may discuss high-level ideas with classmates if your instructor allows it.
- You must write your own team’s final implementation.
- Copying another team’s solver is not allowed.
