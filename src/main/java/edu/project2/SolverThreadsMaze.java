package edu.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.RecursiveTask;
import static edu.project2.Cell.Type.PASSAGE;
import static edu.project2.Cell.Type.WALL;

public class SolverThreadsMaze extends RecursiveTask<List<Cell>> implements Solver {
    private static final int[] ROW = {-1, 0, 0, 1};
    private static final int[] COL = {0, -1, 1, 0};
    private static final int FOUR = 4;
    private final Stack<Cell> cellStack;
    private final Maze maze;
    private final Cell start;
    private final Cell end;

    SolverThreadsMaze(Stack<Cell> cellStack, Maze maze, Cell start, Cell end) {
        this.cellStack = new Stack<>();
        this.cellStack.addAll(cellStack);
        this.maze = maze;
        this.start = start;
        this.end = end;
    }

    @Override
    protected List<Cell> compute() {
        return solve(maze, start, end);
    }

    @Override
    public List<Cell> solve(Maze maze, Cell start, Cell end) {

        if (maze.getGrid()[start.getRow()][start.getCol()].type == WALL
            || maze.getGrid()[end.getRow()][end.getCol()].type == WALL) {
            throw new RuntimeException("Точки не могут быть стенами!");
        }
        Stack<Cell> stack = new Stack<>();
        List<Cell> result = new ArrayList<>();

        maze.getGrid()[start.getRow()][start.getCol()].setVisited(true);
        Cell cell = maze.getGrid()[start.getRow()][start.getCol()];
        stack.add(cell);
        int count;
        while (!stack.isEmpty()) {
            count = 0;
            if (cell.getRow() == end.getRow() && cell.getCol() == end.getCol()) {
                result.addFirst(stack.pop());
            } else {
                for (int i = 0; i < FOUR; ++i) {
                    int x = cell.getRow() + ROW[i];
                    int y = cell.getCol() + COL[i];
                    cell = maze.getGrid()[x][y];
                    //actionsForDifferentCountOfDirections(, cell, stack);

                    if (maze.getGrid()[x][y].type == PASSAGE && !maze.getGrid()[x][y].isVisited()) {
                        ++count;
                        stack.add(maze.getGrid()[x][y]);
                        maze.getGrid()[x][y].setVisited(true);
                        cell = stack.peek();

                    }

                }
                if (count == 0) {
                    stack.pop();
                    cell = stack.peek();
                }
            }
        }

        return result;
    }

    private void actionsForDifferentCountOfDirections(List<Integer> directions, Cell currentCell, Stack<Cell> path) {
        if (directions.size() <= 1) {
            cellStack.add(currentCell);
            currentCell.setVisited(true);
        } else {
            SolverThreadsMaze solverThreadsMaze =
                new SolverThreadsMaze(
                    cellStack,
                    maze,
                    new Cell(
                        currentCell.getRow(),
                        currentCell.getCol(),
                        currentCell.getType(),
                        currentCell.isVisited()
                    ),
                    end
                );
            solverThreadsMaze.fork();
            path.addAll(solverThreadsMaze.join());
        }
    }

}
