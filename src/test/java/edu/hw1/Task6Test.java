package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @Test
    @DisplayName("Корректное число")
    void test1() {
        int actual = Task6.countK(3524);
        int expected = 3;
        assertEquals(expected, actual);


    }
    @Test
    @DisplayName("Число с одинаковыми числами")
    void test2() {
        int actual = Task6.countK(5555);
        int expected = -1;
        assertEquals(expected, actual);
    }



}
