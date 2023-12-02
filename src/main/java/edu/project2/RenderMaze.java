package edu.project2;

import java.util.Collections;
import java.util.List;
import static edu.project2.Cell.Type.PASSAGE;
import static edu.project2.Cell.Type.WALL;

public class RenderMaze implements Render {
    private static final String WALLS = "[=]";
    private static final String PASSAGES = "   ";

    @Override
    public StringBuilder print(Maze maze) {
        return print(maze, Collections.emptyList());
    }

    @Override
    public StringBuilder print(Maze maze, List<Cell> way) {
        String ansiReset = "\u001B[0m";
        String ansiRed = "\u001B[31m";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getGrid()[i][j].type == WALL) {
                    result.append(WALLS);
                }
                if (way.contains(maze.getGrid()[i][j])) {
                    result.append(ansiRed).append(" * ").append(ansiReset);
                } else if (maze.getGrid()[i][j].type == PASSAGE) {
                    result.append(PASSAGES);
                }
            }
            result.append("\n");
        }
        return result;

    }
}
