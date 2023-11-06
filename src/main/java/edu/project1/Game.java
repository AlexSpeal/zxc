package edu.project1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("RegexpSinglelineJava")
public class Game {
    final static int MISTAKES = 5;
    private final WordMask maskOperator = new WordMask();
    private String letter = "";
    private boolean giveUp = false;
    private Scanner scanner;
    private ByteArrayOutputStream outputStream;
    private PrintStream stream;

    public String getOut() {
        return outputStream.toString();
    }

    public Game() {
        scanner = new Scanner(System.in);
    }

    public Game(String in) {
        scanner = new Scanner(in);
        outputStream = new ByteArrayOutputStream();
        stream = new PrintStream(outputStream);
        System.setOut(stream);
    }

    private void input() {
        boolean flag = true;
        do {
            letter = scanner.nextLine();
            if (letter.length() == 1 && Character.isLetter(letter.charAt(0))) {
                flag = false;
            } else if (letter.equals("give up")) {
                giveUp = true;
                flag = false;
            } else {
                System.out.println("Input correct letter:");
            }
        } while (flag);
    }

    private boolean win(int numberGuessletter, Set<String> wordUniqueLetters) {
        return numberGuessletter == wordUniqueLetters.size();
    }

    public boolean start(String guessedWord) {

        String choice;
        int mistakesCount;
        if (!guessedWord.isEmpty()) {
            while (true) {
                mistakesCount = 0;
                maskOperator.clearBuffer();
                maskOperator.setWord(guessedWord);
                System.out.print("A word has been guessed!\n");
                maskOperator.printMask();
                System.out.print("If you want to give up, enter command - give up:\n");

                while (!win(maskOperator.getNumberGuessletter(), maskOperator.getWordUniqueLetters())) {
                    System.out.print("Guess the letter: \n");
                    input();
                    if (maskOperator.isLetterbeused(letter)) {
                        System.out.print("This letter is already by used!\n");
                    } else {
                        maskOperator.inputLetterInSet(letter);
                        if (maskOperator.checkLetterinSet(letter)) {
                            System.out.print("You gueses the letter!\n");
                            System.out.print("Word:\n");
                            maskOperator.updateMask(letter);
                            maskOperator.printMask();
                        } else {
                            if (!giveUp) {
                                System.out.print("You didn't goess\n");
                                mistakesCount++;
                                System.out.printf("Your mistakes %s/5\n", mistakesCount);
                                maskOperator.printMask();
                            }

                        }
                    }
                    if (mistakesCount == MISTAKES || giveUp) {
                        if (giveUp) {
                            System.out.print("\nYou give up!\n");
                            giveUp = false;
                        } else {
                            System.out.print("You lose!\n");
                        }
                        System.out.printf("Word: %s\n", guessedWord);
                        break;
                    }
                }
                System.out.print("Menu: [N]ew game/ [E]xit\n");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("N")) {
                    System.out.print("Game:\n");
                    return start(new RandomWordSelector().getRandomWord());

                } else if (choice.equalsIgnoreCase("E")) {

                    return true;

                } else {
                    System.out.print("Input correct letter\n");
                }
            }
        } else {
            return false;
        }
    }
}
