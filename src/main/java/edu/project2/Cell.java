package edu.project2;

public class Cell {

    public enum Type { WALL, PASSAGE }

    private final int row;
    private final int col;
    private boolean isVisited;
    Type type;

    Cell(int row, int col, Type type, boolean isVisited) {
        this.row = row;
        this.col = col;
        this.isVisited = isVisited;
        this.type = type;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
