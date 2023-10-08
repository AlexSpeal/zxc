package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    void minuteToSeconds() {
        int actual = Task1.minuteToSeconds("::11");
        int expected = -1;
        assertEquals(expected, actual);
        actual = Task1.minuteToSeconds("01:00");
        expected = 60;
        assertEquals(expected, actual);
        actual = Task1.minuteToSeconds("1:00");
        expected = -1;
        assertEquals(expected, actual);
        actual = Task1.minuteToSeconds("01:1");
        expected = -1;
        assertEquals(expected, actual);
    }
}
