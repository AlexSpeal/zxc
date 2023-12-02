package edu.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import static edu.project2.Cell.Type.PASSAGE;
import static edu.project2.Cell.Type.WALL;

public class GeneratorMaze implements Generator {
    private static final int THREE = 3;
    private static final int FOUR = 4;

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
        Random random = new Random();
        do {
            List<Cell> neighbours = getNeighbours(maze, currentCell);
            if (!neighbours.isEmpty()) {
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
    public Maze generate(int height, int width, StringBuilder test) {
        Maze maze = generateM(height, width);
        int k = 0;
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (test.charAt(k) == '0') {
                    maze.getGrid()[i][j] = new Cell(i, j, WALL, false);
                } else if (test.charAt(k) == '1') {
                    maze.getGrid()[i][j] = new Cell(i, j, PASSAGE, false);
                }
                ++k;
            }
        }
        return maze;
    }
}
