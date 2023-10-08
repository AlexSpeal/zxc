package edu.hw1;

import org.apache.logging.log4j.LogManager;
import java.util.logging.Logger;

@SuppressWarnings("uncommentedmain")
public class Task0 {

    private Task0() {

    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        LOGGER.info("Привет, мир!");
    }
}
