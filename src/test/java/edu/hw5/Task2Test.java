package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    @DisplayName("Подсчет всех пятниц 13 в году(корректный ввод)")
    void validInput1() {
        String actual = Task2.getFridaysOnYear(1925).toString();
        String expected = "[1925-02-13, 1925-03-13, 1925-11-13]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Подсчет всех пятниц 13 в году(некорректный ввод)")
    void invalidInput1() {
        assertThrows(RuntimeException.class, () -> Task2.getFridaysOnYear(-2024));
    }

    @Test
    @DisplayName("Следующая пятница 13(корректный ввод)")
    void validInput2() {
        LocalDate actual = Task2.getNextFriday("2004-01-01");
        LocalDate expected = LocalDate.of(2004, 2, 13);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Следующая пятница 13(некорректный ввод)")
    void invalidInput2() {
        LocalDate actual = Task2.getNextFriday("2004-1-1");
        assertNull(actual);
    }

}
