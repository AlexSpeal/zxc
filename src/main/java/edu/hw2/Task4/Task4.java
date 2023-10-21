package edu.hw2.Task4;

import org.apache.logging.log4j.LogManager;

public class Task4 {
    private Task4() {

    }

    public record CallingInfo(String className, String methodName) {
    }

    public static CallingInfo callingInfo() {
        try {
            throw new Exception();
        } catch (Throwable e) {
            StackTraceElement[] stacktrace = e.getStackTrace();
            String str1 = stacktrace[1].toString();
            String str = str1.substring(0, str1.indexOf('('));
            return new CallingInfo(str.substring(0, str.lastIndexOf('.')), str.substring(str.lastIndexOf('.') + 1));

        }
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info(callingInfo());
    }

}
