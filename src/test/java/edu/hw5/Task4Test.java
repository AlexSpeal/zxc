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
        boolean actual = Task4.isPassword(strings);
        assertTrue(actual);

    }

    @Test
    @DisplayName("Пароль не содержит требуемые символы")
    void isNotValid() {
        boolean actual = Task4.isPassword("qwerty");
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустой пароль")
    void empty() {
        boolean actual = Task4.isPassword(" ");
        assertFalse(actual);
    }

    @Test
    @DisplayName("Null строка")
    void nullString() {
        boolean actual = Task4.isPassword(null);
        assertFalse(actual);
    }

}
