package edu.project2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze();
        maze=maze.generate(33, 33);
        Cell x=new Cell(1,1, Cell.Type.PASSAGE,false);
        Cell y=new Cell(7,7, Cell.Type.PASSAGE,false);
        List<Cell> solve=maze.solve(maze,x,y);
        maze.print(maze,solve);
    }
}
