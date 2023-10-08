package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    void isNestable() {
        int[] mas1 = {1, 2, 3, 4};
        int[] mas2 = {0, 6};
        Boolean actual = Task3.isNestable(mas1, mas2);
        Boolean expected = true;
        assertEquals(expected, actual);

        mas1 = new int[] {9, 9, 8};
        mas2 = new int[] {8, 9};
        actual = Task3.isNestable(mas1, mas2);
        expected = false;
        assertEquals(expected, actual);

        mas1 = new int[] {};
        mas2 = new int[] {};
        actual = Task3.isNestable(mas1, mas2);
        expected = false;
        assertEquals(expected, actual);

        mas1 = new int[] {};
        mas2 = new int[] {1, 2};
        actual = Task3.isNestable(mas1, mas2);
        expected = false;
        assertEquals(expected, actual);
    }

}
