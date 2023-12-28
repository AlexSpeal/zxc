package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {
    @RepeatedTest(4)
    @DisplayName("Программа не падает и корректно считает")
    void test() {
        assertEquals(3, Task1.parallelIncrement());
    }
}
