package edu.project2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import static edu.project2.Cell.Type.PASSAGE;
import static edu.project2.Cell.Type.WALL;

public class Maze implements Generator, Solver {
    private int height;
    private int width;
    private Cell[][] grid;
    private static final int[] row = {-1, 0, 0, 1};
    private static final int[] col = {0, -1, 1, 0};

    Maze() {
    }

    Maze(int height, int width, Cell[][] grid) {
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
        //создаем матрицу - двумерный массив
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i % 2 != 0 && j % 2 != 0) && //если ячейка нечетная по x и y,
                    (i < height - 1 && j < width - 1))   //и при этом находится в пределах стен лабиринта
                {
                    cell[i][j] = new Cell(i, j, PASSAGE, false); //то это КЛЕТКА
                } else {
                    cell[i][j] = new Cell(i, j, WALL, false);           //в остальных случаях это СТЕНА.
                }
            }
        }
        return new Maze(height, width, cell);
    }

    private List<Cell> getNeighbours(Maze maze, Cell cell) {
        int x = cell.getRow();
        int y = cell.getCol();

        Cell up = (x >= 3 ? maze.getGrid()[x - 2][y] : maze.getGrid()[x][y]);
        Cell rt = (y < maze.getWidth() - 3 ? maze.getGrid()[x][y + 2] : maze.getGrid()[x][y]);
        Cell dw = (x < maze.getHeight() - 3 ? maze.getGrid()[x + 2][y] : maze.getGrid()[x][y]);
        Cell lt = (y >= 3 ? maze.getGrid()[x][y - 2] : maze.getGrid()[x][y]);
        Cell[] neighboursArray = {dw, rt, up, lt};
        List<Cell> neighboursList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (neighboursArray[i] != maze.getGrid()[x][y] && neighboursArray[i].getRow() > 0 &&
                neighboursArray[i].getRow() < maze.getWidth() &&
                neighboursArray[i].getCol() > 0 &&
                neighboursArray[i].getCol() < maze.getHeight()) { //если не выходит за границы лабиринта
                if (neighboursArray[i].type == PASSAGE &&
                    !neighboursArray[i].isVisited()) { //и не посещена\является стеной
                    neighboursList.add(neighboursArray[i]);
                }
            }
        }
        return neighboursList;
    }

    private Maze removeWall(Cell currentCell, Cell neighbourCell, Maze maze) {

        int xDiff = neighbourCell.getRow() - currentCell.getRow();
        int yDiff = neighbourCell.getCol() - currentCell.getCol();
        int addX, addY;

        addX = (xDiff != 0) ? (xDiff / Math.abs(xDiff)) : 0;
        addY = (yDiff != 0) ? (yDiff / Math.abs(yDiff)) : 0;

        maze.getGrid()[currentCell.getRow() + addX][currentCell.getCol() + addY].type = PASSAGE;
        maze.getGrid()[currentCell.getRow() + addX][currentCell.getCol() + addY].setVisited(true);
        return maze;
    }

    public void print(Maze maze, List<Cell> way) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GR = "\u001B[32m";
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getGrid()[i][j].type == WALL) {
                    System.out.print("[=]");
                }
                if (way.contains(maze.getGrid()[i][j] )) {
                    System.out.print(ANSI_RED + " * " + ANSI_RESET);
                } else if (maze.getGrid()[i][j].type == PASSAGE) {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

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

    private Maze unvisitedClean(Maze maze) {
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getGrid()[i][j].isVisited() && maze.getGrid()[i][j].type == PASSAGE) {
                    maze.getGrid()[i][j].setVisited(false);
                }
            }
        }
        return maze;
    }

    @Override
    public Maze generate(int height, int width) {
        Maze maze = generateM(height, width);
        Cell currentCell = new Cell(1, 1, PASSAGE, true);
        Cell neighbourCell;
        Stack<Cell> neighboursStack = new Stack<>();
        Random random;
        do {
            List<Cell> Neighbours = getNeighbours(maze, currentCell);
            if (!Neighbours.isEmpty()) { //если у клетки есть непосещенные соседи
                random = new Random();
                int randoms = random.nextInt(0, Neighbours.size()); //тут починить если сломается
                neighbourCell = Neighbours.get(randoms); //выбираем случайного соседа
                neighboursStack.push(neighbourCell);
                maze = removeWall(currentCell, neighbourCell, maze); //убираем стену между текущей и соседней точками
                currentCell = neighbourCell; //делаем соседнюю точку текущей и отмечаем ее посещенной
                maze.getGrid()[currentCell.getRow()][currentCell.getCol()].setVisited(true);
            } else if (!neighboursStack.isEmpty()) {
                neighboursStack.pop();
                // if (neighboursStack.isEmpty()) {
                //  print(maze);
                //break;
                // }
                currentCell = maze.getGrid()[neighboursStack.peek().getRow()][neighboursStack.peek().getCol()];
            }
        } while (unvisitedCount(maze) > 0);
        maze = unvisitedClean(maze);
        neighboursStack.clear();
        return maze;
    }

    @Override
    public List<Cell> solve(Maze maze, Cell start, Cell end) {
        Stack<Cell> queue = new Stack<>();
        List<Cell> result = new ArrayList<>();

        maze.getGrid()[start.getRow()][start.getCol()].setVisited(true);
        Cell cell = maze.getGrid()[start.getRow()][start.getCol()];
        queue.add(cell);
        int count = 0;
        while (!queue.isEmpty()) {
            count = 0;
            if (cell.getRow() == end.getRow() && cell.getCol() == end.getCol()) {
                result.addFirst(queue.pop());
            } else {
                for (int i = 0; i < 4; ++i) {
                    int x = cell.getRow() + row[i];
                    int y = cell.getCol() + col[i];
                    if (maze.getGrid()[x][y].type == PASSAGE && !maze.getGrid()[x][y].isVisited()) {
                        ++count;
                        queue.add(maze.getGrid()[x][y]);
                        maze.getGrid()[x][y].setVisited(true);
                        cell = queue.peek();

                    }

                }
                if (count == 0) {
                    queue.pop();
                    cell = queue.peek();
                }
            }
        }
        result.reversed();

        return result;
    }
}
