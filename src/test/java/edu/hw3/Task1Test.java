package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    @DisplayName("Пустая строка")
    void task1() {
        String actual = Task1.atbash("");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Строка английских букв")
    void test2() {
        String actual = Task1.atbash("Hello world!");
        String expected = "Svool dliow!";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Строка английских букв + русские")
    void test3() {
        String actual = Task1.atbash("Hello ворлд!");
        String expected = "Svool ворлд!";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("строка цифр")
    void test4() {
        String actual = Task1.atbash("123");
        String expected = "123";
        assertEquals(expected, actual);
    }
}
