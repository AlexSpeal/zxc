package edu.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import static edu.project2.Cell.Type.PASSAGE;
import static edu.project2.Cell.Type.WALL;

public class Maze implements Generator, Solver, Render {
    private int height;
    private int width;
    private Cell[][] grid;
    private static final int[] ROW = {-1, 0, 0, 1};
    private static final int[] COL = {0, -1, 1, 0};
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final String WALLS = "[=]";
    private static final String PASSAGES = "   ";

    Maze() {
    }

    Maze(int height, int width, Cell[][] grid) {
        if (height <= 0 || width <= 0 || grid == null) {
            throw new RuntimeException("Введены некорректные значения!");
        }
        this.height = height;
        this.width = width;
        this.grid = grid;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private Maze generateM(int height, int width) {
        Cell[][] cell = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i % 2 != 0 && j % 2 != 0) && (i < height - 1 && j < width - 1)) {
                    cell[i][j] = new Cell(i, j, PASSAGE, false);
                } else {
                    cell[i][j] = new Cell(i, j, WALL, false);
                }
            }
        }
        return new Maze(height, width, cell);
    }

    private List<Cell> getNeighbours(Maze maze, Cell cell) {
        int x = cell.getRow();
        int y = cell.getCol();

        Cell up = (x >= THREE ? maze.getGrid()[x - 2][y] : maze.getGrid()[x][y]);
        Cell rt = (y < maze.getWidth() - THREE ? maze.getGrid()[x][y + 2] : maze.getGrid()[x][y]);
        Cell dw = (x < maze.getHeight() - THREE ? maze.getGrid()[x + 2][y] : maze.getGrid()[x][y]);
        Cell lt = (y >= THREE ? maze.getGrid()[x][y - 2] : maze.getGrid()[x][y]);
        Cell[] neighboursArray = {dw, rt, up, lt};
        List<Cell> neighboursList = new ArrayList<>();
        for (int i = 0; i < FOUR; i++) {
            if (neighboursArray[i] != maze.getGrid()[x][y] && neighboursArray[i].getRow() > 0
                && neighboursArray[i].getRow() < maze.getWidth() && neighboursArray[i].getCol() > 0
                && neighboursArray[i].getCol() < maze.getHeight()) {
                if (neighboursArray[i].type == PASSAGE && !neighboursArray[i].isVisited()) {
                    neighboursList.add(neighboursArray[i]);
                }
            }
        }
        return neighboursList;
    }

    private void removeWall(Cell currentCell, Cell neighbourCell, Maze maze) {

        int xDiff = neighbourCell.getRow() - currentCell.getRow();
        int yDiff = neighbourCell.getCol() - currentCell.getCol();
        int addX;
        int addY;

        addX = (xDiff != 0) ? (xDiff / Math.abs(xDiff)) : 0;
        addY = (yDiff != 0) ? (yDiff / Math.abs(yDiff)) : 0;

        maze.getGrid()[currentCell.getRow() + addX][currentCell.getCol() + addY].type = PASSAGE;
        maze.getGrid()[currentCell.getRow() + addX][currentCell.getCol() + addY].setVisited(true);
    }

    @Override
    public StringBuilder print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j].type == WALL) {
                    result.append(WALLS);
                } else if (grid[i][j].type == PASSAGE) {
                    result.append(PASSAGES);
                }
            }
            result.append("\n");
        }
        return result;
    }

    @Override
    public StringBuilder print(List<Cell> way) {
        String ansiReset = "\u001B[0m";
        String ansiRed = "\u001B[31m";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j].type == WALL) {
                    result.append(WALLS);
                }
                if (way.contains(grid[i][j])) {
                    result.append(ansiRed).append(" * ").append(ansiReset);
                } else if (grid[i][j].type == PASSAGE) {
                    result.append(PASSAGES);
                }
            }
            result.append("\n");
        }
        return result;

    }

    private int unvisitedCount(Maze maze) {
        int count = 0;
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (!maze.getGrid()[i][j].isVisited() && maze.getGrid()[i][j].type == PASSAGE) {
                    ++count;
                }
            }
        }
        return count;
    }

    private void unvisitedClean(Maze maze) {
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getGrid()[i][j].isVisited() && maze.getGrid()[i][j].type == PASSAGE) {
                    maze.getGrid()[i][j].setVisited(false);
                }
            }
        }
    }

    @Override
    public Maze generate(int height, int width) {
        Maze maze = generateM(height, width);
        Cell currentCell = new Cell(1, 1, PASSAGE, true);
        Cell neighbourCell;
        Stack<Cell> neighboursStack = new Stack<>();
        Random random;
        do {
            List<Cell> neighbours = getNeighbours(maze, currentCell);
            if (!neighbours.isEmpty()) {
                random = new Random();
                int randoms = random.nextInt(0, neighbours.size());
                neighbourCell = neighbours.get(randoms);
                neighboursStack.push(neighbourCell);
                removeWall(currentCell, neighbourCell, maze);
                currentCell = neighbourCell;
                maze.getGrid()[currentCell.getRow()][currentCell.getCol()].setVisited(true);
            } else if (!neighboursStack.isEmpty()) {
                neighboursStack.pop();
                currentCell = maze.getGrid()[neighboursStack.peek().getRow()][neighboursStack.peek().getCol()];
            }
        } while (unvisitedCount(maze) > 0);
        unvisitedClean(maze);
        neighboursStack.clear();
        return maze;
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
}
