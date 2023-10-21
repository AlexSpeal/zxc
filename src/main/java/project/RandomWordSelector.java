package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

@SuppressWarnings("RegexpSinglelineJava")
public class RandomWordSelector {
    private String[] words = new String[0];

    public RandomWordSelector() {
        scanWordsFromFile();
    }

    private void scanWordsFromFile() {
        StringBuilder strbuild = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(
            "C:\\Users\\alexs\\IdeaProjects\\java-course-2023-main\\project-template\\src"
                + "\\main\\java\\Project1\\resources\\text.txt"))) {
            br.lines().forEach(strbuild::append);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String wordsSeparate = strbuild.toString();
        words = wordsSeparate.split(", ");
    }

    public String getRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}
