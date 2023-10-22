package edu.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @DisplayName("Проверка что состояние игры при угадывании корректо изменяется")
    void guess() {
        Game initialization = new Game("a\nd\nh\na\nn\ne");
        initialization.start("adhan");
        String str = initialization.getOut();
        String actual = str.substring(103, 125);
        String expected = "You gueses the letter!";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Пустая строка")
    void emptyStr() {
        Game initialization = new Game();
        boolean actual = initialization.start("");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Превышено количество попыток")
    void maxCount() {
        Game initialization = new Game("a\ny\ni\no\nf\ng\nE");
        initialization.start("abcd");
        String str = initialization.getOut();
        String actual = str.substring(str.length() - 48, str.length() - 39);
        String expected = "You lose!";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка что состояние игры при не угадывании корректо изменяется")
    void notGuess() {
        Game initialization = new Game("a\ny\ni\no\nf\nE");
        initialization.start("zxc");
        String str = initialization.getOut();
        String actual = str.substring(101, 136);
        String expected = "You didn't goess\r\nYour mistakes 1/5";
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Ввод стринги >1 длины")
    void wrongLetter() {
        Game initialization = new Game("ty\nr\ne\nc\nt\nE");
        initialization.start("rect");
        String str=initialization.getOut();
        String actual = str.substring(102,123);
        String expected = "Input correct letter:";
        assertEquals(expected, actual);
    }

}
