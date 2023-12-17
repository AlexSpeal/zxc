package edu.hw11.Task1;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateClassWithCustomToStringTest {
    @Test
    @DisplayName("Создание класса с переопределенным методом toString()")
    void runtimeToStringImplementation()
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String customToStringReturnValue = "Hello, ByteBuddy!";

        assertEquals(
            customToStringReturnValue,
            CreateClassWithCustomToString.createClassWithCustomToStringImplementation(customToStringReturnValue)
                .toString()
        );
    }

}
