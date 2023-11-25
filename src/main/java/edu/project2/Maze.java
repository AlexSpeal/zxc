package edu.project2;

public class Maze {
    private int height;
    private int width;
    private Cell[][] grid;

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

}
