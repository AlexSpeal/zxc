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
        List<String> list = Arrays.asList("a", "bb", "a", "bb");
        String actual = Task3.freqDict(list).toString();
        String expected = "{a:=2, bb:=2}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Разный повторения слов")
    void task2() {
        List<String> list = Arrays.asList("this", "and", "that", "and");
        String actual = Task3.freqDict(list).toString();
        String expected = "{that:=1, and:=2, this:=1}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("пустая строка")
    void task3() {
        List<String> list = Arrays.asList();
        String actual = Task3.freqDict(list).toString();
        String expected = "{}";
        assertEquals(expected, actual);
    }
}
