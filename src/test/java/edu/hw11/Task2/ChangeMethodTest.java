package edu.hw11.Task2;

import edu.hw11.Task2.Sample.Adder;
import edu.hw11.Task2.Sample.Multiplier;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChangeMethodTest {
    @Test
    @DisplayName("Изменение поведения метода класса")
    void runtimeMethodDelegating()
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final int A = 3;
        final int B = 10;

        assertEquals(
            Multiplier.multiply(A, B),
            ((Adder) ChangeMethod.changeMethodImplementation(
                Adder.class,
                Adder.class.getDeclaredMethod("sum", int.class, int.class),
                Multiplier.class
            )).sum(A, B)
        );
    }
}
