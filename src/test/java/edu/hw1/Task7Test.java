package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @Test
    @DisplayName("Положительные числа, сдвиг вправо")
    void test1() {
        int actual = Task7.rotateRight(8, 1);
        int expected = 4;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Отрицательные числа, сдвиг вправо")
    void test2() {
        int actual = Task7.rotateRight(-5, -2);
        int expected = -1;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Положительные числа, сдвиг влево ")
    void test3() {
        int actual = Task7.rotateLeft(16, 1);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Положительные числа, сдвиг влево ")
    void test4() {
        int actual = Task7.rotateLeft(17, 2);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Отрицательные числа, сдвиг влево ")
    void test5() {
        int actual = Task7.rotateLeft(-5, -2);
        int expected = -1;
        assertEquals(expected, actual);
    }

}
