package edu.hw5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class Task3Test {

    @Test
    @DisplayName("Программа верно обрабатывает время: 2023-11-13")
    void test1() {
        String string = "2023-11-13";
        LocalDate expectedDate = LocalDate.of(2023, 11, 13);

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertEquals(expectedDate, actualDate);
    }

    @Test
    @DisplayName("Программа верно обрабатывает время: 2023-1-3")
    void test2() {
        String string = "2023-1-3";
        LocalDate expectedDate = LocalDate.of(2023, 1, 3);

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertEquals(expectedDate, actualDate);
    }

    @Test
    @DisplayName("Программа верно обрабатывает время в стиле: 1/3/2023")
    void test3() {
        String string = "1/3/2023";
        LocalDate expectedDate = LocalDate.of(2023, 1, 3);

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertEquals(expectedDate, actualDate);
    }

    @Test
    @DisplayName("Программа верно обрабатывает время в стиле: 1/3/23")
    void test4() {
        String string = "1/3/23";
        LocalDate expectedDate = LocalDate.of(2023, 1, 3);

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertEquals(expectedDate, actualDate);
    }

    @Test
    @DisplayName("Программа верно обрабатывает время в стиле: tomorrow")
    void test5() {
        String string = "tomorrow";
        LocalDate expectedDate = LocalDate.now().plusDays(1);

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertEquals(expectedDate, actualDate);
    }

    @Test
    @DisplayName("Программа верно обрабатывает время в стиле: today")
    void test6() {
        String string = "today";
        LocalDate expectedDate = LocalDate.now();

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertEquals(expectedDate, actualDate);
    }

    @Test
    @DisplayName("Программа верно обрабатывает время в стиле: yesterday")
    void test7() {
        String string = "yesterday";
        LocalDate expectedDate = LocalDate.now().minusDays(1);

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertEquals(expectedDate, actualDate);
    }

    @Test
    @DisplayName("Программа верно обрабатывает время в стиле: 1 day ago")
    void test8() {
        String string = "1 day ago";
        LocalDate expectedDate = LocalDate.now().minusDays(1);

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertEquals(expectedDate, actualDate);
    }

    @Test
    @DisplayName("Программа верно обрабатывает время в стиле: 2234 days ago")
    void test9() {
        String string = "2234 days ago";
        LocalDate expectedDate = LocalDate.now().minusDays(2234);

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertEquals(expectedDate, actualDate);
    }

    @Test
    @DisplayName("Поведение программы, если она получила формат времени, который не умеет обрабатывать")
    void test10() {
        String string = "2023-11";

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertNull(actualDate);
    }

    @Test
    @DisplayName("Поведение программы, если она получила пустую строку")
    void test11() {
        String string = "";

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertNull(actualDate);
    }

    @Test
    @DisplayName("Поведение программы, если она получила null")
    void test12() {
        String string = null;

        LocalDate actualDate = Task3.parseDate(string).orElse(null);

        assertNull(actualDate);
    }
}
