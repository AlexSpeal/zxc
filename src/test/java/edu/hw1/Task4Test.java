package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @Test
    @DisplayName("Строка с пробелами")
    void test1() {
        String actual = Task4.fixString("hTsii  s aimex dpus rtni.g");
        String expected = "This is a mixed up string.";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Строка без пробелов")
    void test2() {
        String actual = Task4.fixString("123456");
        String expected = "214365";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Пустая строка")
    void test3() {
        String actual = Task4.fixString("");
        String expected = "";
        assertEquals(expected, actual);
    }

}
