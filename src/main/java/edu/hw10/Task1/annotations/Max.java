package edu.hw10.Task1.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Max {
    int value() default Integer.MAX_VALUE;
}