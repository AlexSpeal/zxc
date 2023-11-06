package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @ParameterizedTest
    @ValueSource(strings = {"~qwerty~", "!qwerty!", "@qwerty@", "#qwerty#", "$qwerty$",
        "%qwerty%", "^qwerty^", "&qwerty&", "*qwerty*", "|qwerty|", "qwerty~ ! @ # $ % ^ & * |"})
    @DisplayName("Пароль содержит требуемые символы")
    void isValid(String strings) {
        boolean actual = Task4.isPassword(strings, Task4.passwordPattern);
        assertTrue(actual);

    }

    @Test
    @DisplayName("Пароль не содержит требуемые символы")
    void isNotValid() {
        boolean actual = Task4.isPassword("qwerty", Task4.passwordPattern);
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустой пароль")
    void empty() {
        boolean actual = Task4.isPassword(" ", Task4.passwordPattern);
        assertFalse(actual);
    }

    @Test
    @DisplayName("Null строка")
    void nullString() {
        boolean actual = Task4.isPassword(null, Task4.passwordPattern);
        assertFalse(actual);
    }

}
