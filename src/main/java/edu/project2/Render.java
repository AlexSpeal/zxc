package edu.project2;

import java.util.List;

public interface Render {
    StringBuilder print(Maze maze);

    StringBuilder print(Maze maze, List<Cell> way);
}
