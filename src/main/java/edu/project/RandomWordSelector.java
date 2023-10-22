package edu.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

@SuppressWarnings("RegexpSinglelineJava")
public class RandomWordSelector {
    private String[] words = {"zxc", "asd", "qwerty"};

    public String getRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}

