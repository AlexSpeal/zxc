package edu.hw3.Task2;

import edu.hw3.Task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    @DisplayName("Скобки правильно расставлены")
    void Test1() {
        List<String> actual = Task2.cluster("(())");
        List<String> expected = new ArrayList<>(Arrays.asList("(())"));
        assertEquals(expected, actual);

        actual = Task2.cluster("()()()");
        expected = new ArrayList<>(Arrays.asList("()", "()", "()"));
        assertEquals(expected, actual);

        actual = Task2.cluster("((()))(())()()(()())");
        expected = new ArrayList<>(Arrays.asList("((()))", "(())", "()", "()", "(()())"));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Строка с пробелом")
    void Test2() {
        List<String> actual = Task2.cluster(" ");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Строка с одной лишней скобкой")
    void Test3() {
        List<String> actual = Task2.cluster("(()))");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("(())"));
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Строка")
    void Test4() {
        List<String> actual = Task2.cluster(")()(");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList());
        assertEquals(expected, actual);
    }
}
