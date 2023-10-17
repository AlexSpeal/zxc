package project1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class RandomWordSelector {
private String[] words=new String[0];
public RandomWordSelector(){
    ScanWordsFromFile();
}
private void ScanWordsFromFile(){
    StringBuilder strbuild=new StringBuilder();
    try(BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\alexs\\IdeaProjects\\java-course-2023-main\\" +
        "project-template\\src\\main\\java\\project1\\words.txt"))){
        br.lines().forEach(strbuild::append);
    } catch (FileNotFoundException e) {
        System.out.println("File not found!");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    String wordsSeparate=strbuild.toString();
    words=wordsSeparate.split(", ");
}
public String getRandomWord(){
    Random random= new Random();
    return words[random.nextInt(words.length)];
}
}
