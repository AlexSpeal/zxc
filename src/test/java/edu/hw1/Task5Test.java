package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @Test
    @DisplayName("Это палиндром")
    void test1() {
        boolean actual = Task5.isPalindromeDescendant(11);
        boolean expected = true;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Это не палиндром")
    void test2() {
        boolean actual = Task5.isPalindromeDescendant(123);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Число нечетное")
    void test3() {
        boolean actual = Task5.isPalindromeDescendant(123);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Нечетный потомок")
    void test5() {
        boolean actual = Task5.isPalindromeDescendant(123451);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Число нечетное")
    void test6() {
        boolean actual = Task5.isPalindromeDescendant(123);
        boolean expected = false;
        assertEquals(expected, actual);
    }

}
