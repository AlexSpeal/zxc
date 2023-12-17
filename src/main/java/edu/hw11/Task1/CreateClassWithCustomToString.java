package edu.hw11.Task1;

import java.lang.reflect.InvocationTargetException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class CreateClassWithCustomToString {
    private CreateClassWithCustomToString() {

    }

    public static Object createClassWithCustomToStringImplementation(String toStringReturnValue)
        throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        DynamicType.Unloaded<Object> unloadedType = new ByteBuddy()
            .subclass(Object.class)
            .method(ElementMatchers.isToString())
            .intercept(FixedValue.value(toStringReturnValue))
            .make();

        Class<?> dynamicType = unloadedType.load(CreateClassWithCustomToString.class.getClassLoader())
            .getLoaded();

        return dynamicType.getDeclaredConstructor().newInstance();
    }
}
