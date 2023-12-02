package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.List;
import static edu.hw5.Task1.getDuration;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    @DisplayName("Корректый ввод")
    void validInput() {
        Duration actual = getDuration(List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        ));
        String expected = "PT3H40M";
        assertEquals(expected, actual.toString());
    }

    @Test
    @DisplayName("Некорректный ввод")
    void invalidInput() {
        assertThrows(RuntimeException.class, () -> getDuration(List.of(
            "2022-03-12, 25:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        )));

    }

    @Test
    @DisplayName("Ввод пустого листа")
    void emptyList() {
        assertThrows(RuntimeException.class, () -> getDuration(List.of()));

    }
}
