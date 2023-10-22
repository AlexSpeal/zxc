package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    @DisplayName("Первый вложен во второй")
    void test1() {
        int[] mas1 = {1, 2, 3, 4};
        int[] mas2 = {0, 6};
        boolean actual = Task3.isNestable(mas1, mas2);
        boolean expected = true;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Первый не вложен во второй")
    void test2() {
        int[] mas1 = new int[] {9, 9, 8};
        int[] mas2 = new int[] {8, 9};
        boolean actual = Task3.isNestable(mas1, mas2);
        boolean expected = false;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Пустые массивы")
    void test3() {
        int[] mas1 = new int[] {};
        int[] mas2 = new int[] {};
        boolean actual = Task3.isNestable(mas1, mas2);
        boolean expected = false;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Один из массивов пуст")
    void test4() {
        int[] mas1 = new int[] {};
        int[] mas2 = new int[] {1, 2};
        boolean actual = Task3.isNestable(mas1, mas2);
        boolean expected = false;
        assertEquals(expected, actual);

    }

}
