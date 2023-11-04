package edu.project2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public interface Solver {
    List<Cell> solve(Maze maze, Cell start, Cell end);
}
