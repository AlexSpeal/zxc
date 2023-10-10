package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    @DisplayName("Положительное число")
    void test1() {
        int actual = Task2.countDigits(1234);
        int expected = 4;
        assertEquals(expected, actual);

        actual = Task2.countDigits(0);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Отрицательное число")
    void test2() {
        int actual = Task2.countDigits(-1234);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Ввод нуля")
    void test3() {
        int actual = Task2.countDigits(0);
        int expected = 1;
        assertEquals(expected, actual);
    }


}
