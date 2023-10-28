package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    @DisplayName("2 повторения слов")
    void task1() {
        var actual = Task3.freqDict(new ArrayList<>(Arrays.asList("a", "bb", "a", "bb")));
        String expected = "{a:=2, bb:=2}";
        assertEquals(expected, actual.toString());
    }

    @Test
    @DisplayName("Разные повторения слов")
    void task2() {
        var actual = Task3.freqDict(new ArrayList<>(Arrays.asList("this", "and", "that", "and")));
        String expected = "{that:=1, and:=2, this:=1}";
        assertEquals(expected, actual.toString());
    }

    @Test
    @DisplayName("пустая строка")
    void task3() {
        var actual = Task3.freqDict(new ArrayList<>(List.of()));
        String expected = "{}";
        assertEquals(expected, actual.toString());
    }

    @Test
    @DisplayName("цифры")
    void task4() {
        var actual = Task3.freqDict(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1)));
        String expected = "{3:=1, 2:=2, 1:=2}";
        assertEquals(expected, actual.toString());
    }
}
