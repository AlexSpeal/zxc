package edu.project;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("RegexpSinglelineJava")
public class Game {
    public Game() {
        scanner = new Scanner(System.in);
    }

    public Game(String in) {
        scanner = new Scanner(in);
        outputStream = new ByteArrayOutputStream();
        stream = new PrintStream(outputStream);
        System.setOut(stream);
    }

    public String getOut() {
        return outputStream.toString();
    }

    final static int WRONG_COUNT_MISTAKES = -1;
    final static int MAX_COUNT_MISTAKES = 5;
    private final RandomWordSelector wordSelector = new RandomWordSelector();
    private final WordMask maskOperator = new WordMask();
    int mistakesCount;
    private Scanner scanner;
    private ByteArrayOutputStream outputStream;
    private PrintStream stream;
    private String letter;

    private void input() {
        boolean flag = true;
        do {
            letter = scanner.nextLine();
            if (letter.length() == 1 && Character.isLetter(letter.charAt(0))) {
                flag = false;
            } else {
                if (letter.equals("give up")) {
                    mistakesCount = WRONG_COUNT_MISTAKES;
                    letter = " ";
                    return;
                }
                System.out.print(">Input correct letter:\n<");
            }
        } while (flag);
    }

    private String inputVubor() {
        String result;
        do {
            result = scanner.nextLine();
            if (result.length() == 1 && (result.equals("N") || result.equals("E"))) {
                return result;
            } else {
                System.out.print(">Input correct vubor:\n<");
            }
        } while (true);
    }

    private boolean win(int numberGuessletter, Set<String> wordUniqueLetters) {
        return numberGuessletter == wordUniqueLetters.size();
    }

    public boolean start(String guessedWord) {
        if (!guessedWord.isEmpty()) {
            boolean flag;
            mistakesCount = 0;
            flag = false;
            maskOperator.clearBuffer();
            maskOperator.setWord(guessedWord);
            System.out.print(">A word has been guessed!\n>If you want to give up, enter - give up\n");
            while (!win(maskOperator.getNumberGuessletter(), maskOperator.getWordUniqueLetters())) {
                System.out.print("\n>Guess a letter: \n<");
                input();
                if (mistakesCount == WRONG_COUNT_MISTAKES) {
                    System.out.print("\n>You give up!");
                    flag = true;
                    break;
                }
                if (maskOperator.isLetterbeused(letter)) {
                    System.out.print(">\n>This letter is already by used!");
                } else {
                    maskOperator.inputLetterInSet(letter);
                    if (maskOperator.checkLetterinSet(letter)) {
                        System.out.print(">Hit!\n");
                        maskOperator.updateMask(letter);
                        maskOperator.printMask();
                    } else {
                        mistakesCount++;
                        System.out.print(">Missed, mistake " + mistakesCount + " out of "
                            + MAX_COUNT_MISTAKES + ".\n");
                        maskOperator.printMask();

                    }
                }
                if (mistakesCount == MAX_COUNT_MISTAKES) {
                    System.out.print("\n>You lost!");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.print("\n>You won!");
            }
            System.out.print("\n>Menu: [N]ew game/ [E]xit\n<");
            String vubor = inputVubor();
            if (vubor.equals("N")) {
                return start(wordSelector.getRandomWord());
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
