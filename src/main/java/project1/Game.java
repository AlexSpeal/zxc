package project1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("RegexpSinglelineJava")
public class Game {
    final static int MISTAKES = 5;
    private final RandomWordSelector wordSelector = new RandomWordSelector();
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
                System.out.println("A word has been guessed!");
                maskOperator.printMask();
                System.out.println("If you want to give up, enter command - give up:");

                while (!win(maskOperator.getNumberGuessletter(), maskOperator.getWordUniqueLetters())) {
                    System.out.println("Guess the letter: ");
                    input();
                    if (maskOperator.isLetterbeused(letter)) {
                        System.out.println("This letter is already by used!");
                    } else {
                        maskOperator.inputLetterInSet(letter);
                        if (maskOperator.checkLetterinSet(letter)) {
                            System.out.println("You gueses the letter!");
                            System.out.println("Word:");
                            maskOperator.updateMask(letter);
                            maskOperator.printMask();
                        } else {
                            if (!giveUp) {
                                System.out.println("You didn't goess");
                                mistakesCount++;
                                System.out.printf("Your mistakes %s/5\n", mistakesCount);
                                maskOperator.printMask();
                            }

                        }
                    }
                    if (mistakesCount == MISTAKES || giveUp) {
                        if (giveUp) {
                            System.out.println("\nYou give up!");
                            giveUp = false;
                        } else {
                            System.out.println("You lose!");
                        }
                        System.out.printf("Word: %s\n", guessedWord);
                        break;
                    }
                }
                System.out.println("Menu: [N]ew game/ [E]xit");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("N")) {
                    System.out.println("Game:");
                    return start(new RandomWordSelector().getRandomWord());

                } else if (choice.equalsIgnoreCase("E")) {

                    return true;

                } else {
                    System.out.println("Input correct letter");
                }
            }
        } else {
            return false;
        }
    }
}
