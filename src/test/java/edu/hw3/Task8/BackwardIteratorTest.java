package edu.hw3.Task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BackwardIteratorTest {
    @Test
    @DisplayName("Ввод: 1,2,3")
    void test1() {
        BackwardIterator<Integer> it = new BackwardIterator<>(List.of(1, 2, 3));
        List<Integer> list = List.of(1, 2, 3);
        boolean actual = false;
        boolean expected = false;
        int i = list.size() - 1;
        while (it.hasNext() && !actual) {
            if (!it.next().equals(list.get(i))) {
                actual = true;
            }
            --i;
        }
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Ввод: 5,6,7,8")
    void test2() {
        BackwardIterator<Integer> iterator = new BackwardIterator<>(List.of(5, 6, 7, 8));
        List<Integer> list = List.of(5, 6, 7, 8);
        boolean actual = false;
        boolean expected = false;
        int i = list.size() - 1;
        while (iterator.hasNext() && !actual) {
            if (!iterator.next().equals(list.get(i))) {
                actual = true;
            }
            --i;
        }
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Коллекция типа string")
    void test3() {
        List<String> list = List.of("hello", "world", "!");
        BackwardIterator<String> backwardIterator = new BackwardIterator<>(list);
        int i = list.size() - 1;
        boolean fl = true;
        while (backwardIterator.hasNext()) {
            if (!list.get(i).equals(backwardIterator.next())) {
                fl = false;
            }
            i--;
        }
        assertTrue(fl);
    }
}
