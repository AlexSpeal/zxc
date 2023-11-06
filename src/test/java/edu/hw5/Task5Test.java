package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @ParameterizedTest
    @ValueSource(strings = {"А123ВЕ777", "О777ОО177", "О888ОО167", "В456ВЕ678","В456ВЕ67"})
    @DisplayName("Правильный номер")
    void isValid(String strings) {
        boolean actual = Task5.isCarNumber(strings, Task5.carNumberPattern);
        assertTrue(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"123АВЕ777", "А123ВГ77", "А123ВЕ7777"})
    @DisplayName("Неправильный номер")
    void isNotValid(String strings) {
        boolean actual = Task5.isCarNumber(strings, Task5.carNumberPattern);
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустой номер")
    void empty() {
        boolean actual = Task5.isCarNumber(" ", Task5.carNumberPattern);
        assertFalse(actual);
    }

    @Test
    @DisplayName("Null строка")
    void nullString() {
        boolean actual = Task5.isCarNumber(null, Task5.carNumberPattern);
        assertFalse(actual);
    }
}
