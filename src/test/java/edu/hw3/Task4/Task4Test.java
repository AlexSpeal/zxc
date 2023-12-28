package edu.hw3.Task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @Test
    @DisplayName("Число 123")
    void test1() throws Exception {
        String actual = Task4.convertToRoman(123);
        String expected = "CXXIII";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Число 0")
    void test2() throws Exception {
        String actual = Task4.convertToRoman(0);
        String expected = "N";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Число 4")
    void test3() throws Exception {
        String actual = Task4.convertToRoman(4);
        String expected = "IV";
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {4000, -5})
    @DisplayName("Число больше 3999 или меньше нуля")
    void test4(int ints) throws Exception {
        boolean actual;
        boolean expected = false;
        try {
            actual = true;
            Task4.convertToRoman(ints);
        } catch (RuntimeException e) {
            actual = false;
        }
        assertEquals(expected, actual);
    }

}
