# Micromouse Student Starter

This package contains the student-facing starter for the Micromouse lab.

Also read:

- `CHALLENGE.md`

## What You Need To Edit

Only edit:

- `src/student/StudentSolverImpl.java`

Do not rename the package or class unless your instructor tells you to.

## What Is Hidden

The simulator framework is already compiled into:

- `lib/micromouse-framework.jar`

That JAR contains:

- the GUI
- the simulator engine
- the maze generator
- the public API you use from your solver

## Compile Your Solver

macOS / Linux:

```bash
./compile.sh
```

Windows:

```bat
compile.bat
```

This creates:

- `out/student/StudentSolverImpl.class`

## Run The GUI

macOS / Linux:

```bash
./run_gui.sh
```

Windows:

```bat
run_gui.bat
```

The GUI lets you:

- test your solver
- generate new mazes
- change the seed
- step or run the simulation

## Example Seeds

Try these seeds in the GUI seed box:

- `1000`
- `1001`
- `1002`
- `1003`
- `1004`

## VS Code

Recommended:

- install a JDK 17 or newer
- open the `student-kit` folder in VS Code
- use `Terminal` to run the scripts above

This package also includes:

- `.vscode/tasks.json`
- `.vscode/launch.json`

So in VS Code you can:

- run the build task: `Compile Solver`
- run the launch configuration: `Run Micromouse GUI`

## What You Can Use In Code

Your solver can inspect:

- current position
- current direction
- current speed
- current run phase
- adjacent cells
- short sight lines forward/left/right/back

Look at:

- `StudentSolver`
- `MousePerception`
- `CellView`
- `Direction`
- `MouseAction`
- `RunPhase`

These are available from the framework JAR.

## Movement API

Your solver returns one `MouseAction` each step.

Available actions:

- `MouseAction.TURN_LEFT`
- `MouseAction.TURN_RIGHT`
- `MouseAction.MOVE_FORWARD`
- `MouseAction.ACCELERATE`
- `MouseAction.DECELERATE`
- `MouseAction.WAIT`

Useful movement-related API from `MousePerception`:

- `getDirection()`
- `canMove(direction)`
- `canMoveSteps(direction, steps)`
- `clearDistance(direction)`
- `getNeighbor(direction)`
- `getSightLine(direction)`

Useful directions:

- `Direction.NORTH`
- `Direction.EAST`
- `Direction.SOUTH`
- `Direction.WEST`
- `direction.turnLeft()`
- `direction.turnRight()`

Note:

- there is no special `RETURN` action in the API
- to return to somewhere, your solver must decide how to turn and move there by itself

## Dead End Example

If the mouse is at a dead end:

- forward is blocked
- left is blocked
- right is blocked

Then it can still go back by turning around:

1. `TURN_LEFT`
2. `TURN_LEFT`
3. `MOVE_FORWARD`

That is how backtracking works in this simulator.

Very simple idea:

```java
Direction facing = perception.getDirection();
boolean forwardBlocked = !perception.canMove(facing);
boolean leftBlocked = !perception.canMove(facing.turnLeft());
boolean rightBlocked = !perception.canMove(facing.turnRight());

if (forwardBlocked && leftBlocked && rightBlocked) {
    return MouseAction.TURN_LEFT;
}
```

On the next step, the solver can turn left again, then move forward to return to the previous cell.

## Submission Suggestion

Submit only:

- `src/student/StudentSolverImpl.java`
