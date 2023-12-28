package edu.hw3.Task5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @Test
    @DisplayName("Тесты с сайта Тинькофф")
    void test1() {
        ArrayList<String> list;
        list = new ArrayList<>(Arrays.asList("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"));
        String actual = Task5.parseContacts(list, "ASC").toString();
        String expected = "[Thomas Aquinas, Rene Descartes, David Hume, John Locke]";
        assertEquals(expected, actual);

        list = new ArrayList<>(Arrays.asList("Paul Erdos", "Leonhard Euler", "Carl Gauss"));
        actual = Task5.parseContacts(list, "DESC").toString();
        expected = "[Carl Gauss, Leonhard Euler, Paul Erdos]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Фамилия отсутствует")
    void test2() {
        ArrayList<String> list;
        list = new ArrayList<>(Arrays.asList("John", "Thomas", "David Hume", "Rene Descartes"));
        String actual = Task5.parseContacts(list, "ASC").toString();
        String expected = "[Rene Descartes, David Hume, John, Thomas]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("пустая строка")
    void test3() {
        ArrayList<String> list;
        list = new ArrayList<>(Arrays.asList(""));
        String actual = Task5.parseContacts(list, "ASC").toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Null")
    void test4() {
        ArrayList<String> list;
        list = null;
        String actual = Task5.parseContacts(list, "ASC").toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }

}
