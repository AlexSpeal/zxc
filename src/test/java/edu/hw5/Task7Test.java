package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @ParameterizedTest
    @ValueSource(strings = {"1001", "110111", "110", "000", "010"})
    @DisplayName("Правильная строка(1й пункт)")
    void isValid1(String strings) {
        boolean actual = Task7.isValidString(strings, Task7.STRING_PATTERN_1);
        assertTrue(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"101", "111323", "111111", "001", "22232323"})
    @DisplayName("Неправильная строка(1й пункт)")
    void isNotValid1(String strings) {
        boolean actual = Task7.isValidString(strings, Task7.STRING_PATTERN_1);
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустая строка(1й пункт)")
    void empty1() {
        boolean actual = Task7.isValidString(" ", Task7.STRING_PATTERN_1);
        assertFalse(actual);

    }

    @Test
    @DisplayName("Null(1 пункт)")
    void null1() {
        boolean actual = Task7.isValidString(null, Task7.STRING_PATTERN_1);
        assertFalse(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1010101", "11", "1"})
    @DisplayName("Правильная строка(2й пункт)")
    void isValid2(String strings) {
        boolean actual = Task7.isValidString(strings, Task7.STRING_PATTERN_2);
        assertTrue(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "011", "101001010", "10120023010"})
    @DisplayName("Неправильная строка(2й пункт)")
    void isNotValid2(String strings) {
        boolean actual = Task7.isValidString(strings, Task7.STRING_PATTERN_2);
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустая строка(2й пункт)")
    void empty2() {
        boolean actual = Task7.isValidString(" ", Task7.STRING_PATTERN_2);
        assertFalse(actual);

    }

    @Test
    @DisplayName("Null(2 пункт)")
    void null2() {
        boolean actual = Task7.isValidString(null, Task7.STRING_PATTERN_2);
        assertFalse(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "000", "101", "11", "00"})
    @DisplayName("Правильная строка(3й пункт)")
    void isValid3(String strings) {
        boolean actual = Task7.isValidString(strings, Task7.STRING_PATTERN_3);
        assertTrue(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1101", "101010", "323"})
    @DisplayName("Неправильная строка(3й пункт)")
    void isNotValid3(String strings) {
        boolean actual = Task7.isValidString(strings, Task7.STRING_PATTERN_3);
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустая строка(3й пункт)")
    void empty3() {
        boolean actual = Task7.isValidString(" ", Task7.STRING_PATTERN_3);
        assertFalse(actual);

    }

    @Test
    @DisplayName("Null(3 пункт)")
    void null3() {
        boolean actual = Task7.isValidString(null, Task7.STRING_PATTERN_3);
        assertFalse(actual);

    }

}
