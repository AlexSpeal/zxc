package edu.hw3.Task6;

import edu.hw3.Task3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @Test
    @DisplayName("Тинькофф стоит дороже всего")
    void task1() {
        Market st = new Market();
        st.add(new Stock("Gas", 12));
        st.add(new Stock("Yandex", 100));
        st.add(new Stock("Tinkoff", 200));
        String actual = st.mostValuableStock().getName() + ": " + st.mostValuableStock().getPriceOfAStock();
        String expected = "Tinkoff: 200";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Нету названия акции")
    void task2() {
        Market st = new Market();
        st.add(new Stock("Gas", 12));
        st.add(new Stock("Yandex", 100));
        boolean actual = false;
        boolean expected = true;
        try {
            actual = false;
            st.add(new Stock("", 200));

        } catch (RuntimeException e) {
            actual = true;
        }
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Удаление акции")
    void task3() {
        Market st = new Market();
        Stock Gas = new Stock("Gas", 12);
        st.add(Gas);
        st.remove(Gas);
        assertTrue(st.getPriorityQueue().isEmpty());
    }

    @Test
    @DisplayName("добавление акции")
    void task4() {
        Market st = new Market();
        Stock Gas = new Stock("Gas", 12);
        st.add(Gas);
        assertFalse(st.getPriorityQueue().isEmpty());
    }
}
