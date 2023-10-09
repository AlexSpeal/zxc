package edu.hw1;

import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task8 {
    private Task8() {

    }

    // public static boolean check(int[][] board) {
    //   boolean result = false;
    //   if () {
    //     return result;
    //  }
    // }
    final static int ONE = 1;
    final static int TWO = 2;
    final static int N = 8;
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static boolean left(int[][] board, int i, int j) {
        return (i - ONE >= 0 && j - TWO >= 0 && board[i - ONE][j - TWO] == ONE)
            || (i - TWO >= 0 && j - ONE >= 0 && board[i - TWO][j - ONE] == ONE);
    }

    public static boolean top(int[][] board, int i, int j) {

        return (i - ONE >= 0 && j + TWO < N && board[i - ONE][j + TWO] == ONE)
            || (i - TWO >= 0 && j + ONE < N && board[i - TWO][j + ONE] == ONE);
    }

    public static boolean right(int[][] board, int i, int j) {
        return (i - ONE >= 0 && j + TWO < N && board[i - ONE][j + TWO] == ONE)
            || (i + ONE < N && j + TWO < N && board[i + ONE][j + TWO] == ONE);
    }

    public static boolean down(int[][] board, int i, int j) {

        return (i + TWO < N && j - ONE >= 0 && board[i + TWO][j - ONE] == ONE)
            || (i + ONE < N && j - TWO >= 0 && board[i + ONE][j - TWO] == ONE);
    }

    public static boolean knightBoardCapture(int[][] board) {

        boolean result = true;
        for (int i = 0; i < N && result; ++i) {
            for (int j = 0; j < N && result; ++j) {
                if (board[i][j] == 1) {
                    if (left(board, i, j) || right(board, i, j) || top(board, i, j) || down(board, i, j)) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] board = {{1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}};
        LOGGER.info(knightBoardCapture(board));
    }
}
