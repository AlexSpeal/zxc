package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    void checkkoll() {
        int actual = Task2.checkkoll(1234);
        int expected = 4;
        assertEquals(expected, actual);

        actual = Task2.checkkoll(-1234);
        expected = 4;
        assertEquals(expected, actual);

        actual = Task2.checkkoll(0);
        expected = 1;
        assertEquals(expected, actual);
    }

}
