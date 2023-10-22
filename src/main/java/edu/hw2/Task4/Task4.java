package edu.hw2.Task4;

import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task4 {
    private Task4() {

    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String str1 = stackTrace[2].toString();
        String str = str1.substring(0, str1.indexOf('('));
        return new CallingInfo(str.substring(0, str.lastIndexOf('.')), str.substring(str.lastIndexOf('.') + 1));
    }

    public static void main(String[] args) {
        LOGGER.info(callingInfo());
    }

}
