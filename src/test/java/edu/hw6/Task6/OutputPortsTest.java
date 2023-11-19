package edu.hw6.Task6;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task6.OutputPorts.outputPorts;
import static edu.hw6.Task6.OutputPorts.putServices;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OutputPortsTest {
    @BeforeAll
    static void putAllPorts() {
        putServices();
    }

    @Test
    @DisplayName("Не нулевой")
    void test() {
        String actual = outputPorts().toString();

        assertNotNull(actual);
    }
}
