package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MazeTest {
    @Test
    @DisplayName("Введены корректные значения лабиринта")
    void test1() {
        Maze maze = new Maze();
        boolean actual = false;
        boolean expected = false;
        try {
            maze = maze.generate(33, 33);
        } catch (RuntimeException e) {
            actual = true;
        }
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Введены некорректные значения лабиринта")
    void test2() {
        Maze maze = new Maze();
        boolean actual = false;
        boolean expected = true;
        try {
            maze = maze.generate(-4, 33);
        } catch (RuntimeException e) {
            actual = true;
        }
        assertEquals(expected, actual);
    }

}
