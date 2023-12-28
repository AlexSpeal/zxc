package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @Test
    @DisplayName("Является подпоследовательностью")
    void isValid() {
        boolean actual = Task6.isSubsequence("abc", "achfdbaabgabcaabg");
        assertTrue(actual);

    }

    @Test
    @DisplayName("Не является подпоследовательностью")
    void isNotValid() {
        boolean actual = Task6.isSubsequence("qwe", "achfdbaabgabcaabg");
        assertFalse(actual);

    }

    @Test
    @DisplayName("Null")
    void nullStr() {
        boolean actual = Task6.isSubsequence(null, "achfdbaabgabcaabg");
        assertFalse(actual);

    }
}
