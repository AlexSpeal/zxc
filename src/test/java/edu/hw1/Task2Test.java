package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    void countDigits() {
        int actual = Task2.countDigits(1234);
        int expected = 4;
        assertEquals(expected, actual);

        actual = Task2.countDigits(-1234);
        expected = 4;
        assertEquals(expected, actual);

        actual = Task2.countDigits(0);
        expected = 1;
        assertEquals(expected, actual);
    }

}
