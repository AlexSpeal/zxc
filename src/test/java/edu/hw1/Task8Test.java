package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task8Test {
    @Test
    @DisplayName("Конь бьет другого коня")
    void test1() {
        int[][] board = {{0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}};

        boolean actual = Task8.knightBoardCapture(board);
        boolean expected = true;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Конь не бьет коня")
    void test2() {
        int[][] board = new int[][] {{1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}};

        boolean actual = Task8.knightBoardCapture(board);
        boolean expected = false;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Коней нет на доске")
    void test3() {
        int[][] board = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}};

        boolean actual = Task8.knightBoardCapture(board);
        boolean expected = false;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Доска null")
    void test4() {
        int[][] board = null;
        boolean actual = Task8.knightBoardCapture(board);
        boolean expected = false;
        assertEquals(expected, actual);

    }

}
