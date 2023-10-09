package edu.hw1;

import java.util.Scanner;
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
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static boolean left(int[][] board, int i, int j) {
        final int n = 8;
        final int ONE = 1;
        final int TWO = 2;
        boolean result = false;
        if ((i - ONE >= 0 && j - TWO >= 0 && board[i - ONE][j - TWO] == ONE)
            || (i - TWO >= 0 && j - ONE >= 0 && board[i - TWO][j - ONE] == ONE)) {
            result = true;
        }
        return result;
    }

    public static boolean top(int[][] board, int i, int j) {
        final int n = 8;
        final int ONE = 1;
        final int TWO = 2;
        boolean result = false;
        if ((i - ONE >= 0 && j + TWO < n && board[i - ONE][j + TWO] == ONE)
            || (i - TWO >= 0 && j + ONE < n && board[i - TWO][j + ONE] == ONE)) {
            result = true;
        }
        return result;
    }

    public static boolean right(int[][] board, int i, int j) {
        final int n = 8;
        final int ONE = 1;
        final int TWO = 2;
        boolean result = false;
        if ((i - ONE >= 0 && j + TWO < n && board[i - ONE][j + TWO] == ONE)
            || (i + ONE < n && j + TWO < n && board[i + ONE][j + TWO] == ONE)) {
            result = true;
        }
        return result;
    }

    public static boolean down(int[][] board, int i, int j) {
        final int n = 8;
        final int ONE = 1;
        final int TWO = 2;
        boolean result = false;
        if ((i + TWO < n && j - ONE >= 0 && board[i + TWO][j - ONE] == ONE)
            || (i + ONE < n && j - TWO >= 0 && board[i + ONE][j - TWO] == ONE)) {
            result = true;
        }
        return result;
    }

    public static boolean knightBoardCapture(int[][] board) {
        final int n = 8;
        boolean result = true;
        for (int i = 0; i < n && result; ++i) {
            for (int j = 0; j < n && result; ++j) {
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
        Scanner cin = new Scanner(System.in);
        //LOGGER.info("Input number: ");
        //Integer number = cin.nextInt();
        //int[][] board = new int[8][8];
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
