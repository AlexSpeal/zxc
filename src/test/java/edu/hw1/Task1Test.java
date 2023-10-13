package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    @DisplayName("Секунды без минут")
    void test1() {
        int actual = Task1.minuteToSeconds(":11");
        int expected = -1;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Минуты без секунд")
    void test2() {
        int actual = Task1.minuteToSeconds("11:");
        int expected = -1;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Корректный ввод")
    void test3() {
        int actual = Task1.minuteToSeconds("01:00");
        int expected = 60;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Число не в формате mm:ss")
    void test4() {
        int actual = Task1.minuteToSeconds("1:00");
        int expected = -1;
        assertEquals(expected, actual);

        assertEquals(expected, actual);
        actual = Task1.minuteToSeconds("01:1");
        expected = -1;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Пустая строка")
    void test5() {
        int actual = Task1.minuteToSeconds(" ");
        int expected = -1;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Отрицательные числа")
    void test6() {
        int actual = Task1.minuteToSeconds("-04:00");
        int expected = -1;
        assertEquals(expected, actual);

        actual = Task1.minuteToSeconds("04:-04");
        expected = -1;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("60 секунд")
    void test7() {
        int actual = Task1.minuteToSeconds("01:60");
        int expected = -1;
        assertEquals(expected, actual);

    }

}
