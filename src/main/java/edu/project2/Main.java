package edu.project2;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze();
        maze=maze.generate(11, 11);
        Cell x=new Cell(1,1, Cell.Type.PASSAGE,false);
        Cell y=new Cell(7,7, Cell.Type.PASSAGE,false);
        maze.print(maze,maze.solve(maze,x,y));
    }
}
