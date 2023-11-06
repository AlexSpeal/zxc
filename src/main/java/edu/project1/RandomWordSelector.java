package edu.project1;

import java.util.Random;

@SuppressWarnings("RegexpSinglelineJava")
public class RandomWordSelector {
    private String[] words = {"zxc", "asd", "qwerty"};

    public String getRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}

