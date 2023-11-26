package edu.hw7;

import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task2Test {

    @Test
    @DisplayName("Факториал числа считается правильно")
    void test1() {
        int num = 5;
        assertEquals(new BigInteger("120"), Task2.factorial(num));
    }

    @Test
    @DisplayName("Факториал числа 1")
    void test2() {
        int num = 1;
        assertEquals(new BigInteger("1"), Task2.factorial(num));
    }

    @Test
    @DisplayName("Факториал числа 0")
    void test3() {
        int num = 0;
        assertEquals(new BigInteger("1"), Task2.factorial(num));
    }

    @Test
    @DisplayName("Факториал отрицательного числа")
    void test4() {
        int num = -1;
        assertThrows(RuntimeException.class, () -> Task2.factorial(num));
    }
}
