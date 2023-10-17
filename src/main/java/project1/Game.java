package project1;

import java.awt.Window;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private final RandomWordSelector wordSelector = new RandomWordSelector();
    private final WordMask maskOperator = new WordMask();
    private String letter = "";

    private void input() {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        do {
            letter = scanner.nextLine();
            if (letter.length() == 1 && Character.isLetter(letter.charAt(0))) {
                flag = false;
            } else {
                System.out.println("Input correct letter:");
                letter = scanner.nextLine();
            }
        } while (flag);
    }

    private boolean Win(int numberGuessletter, Set<String> wordUniqueLetters) {
        return numberGuessletter == wordUniqueLetters.size();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String vubor;
        int mistakesCount = 0;
        while (true) {
            System.out.println("Menu: [N]ew game/ [E]xit");
            vubor = scanner.nextLine();
            if (vubor.equalsIgnoreCase("N")) {
                mistakesCount = 0;
                maskOperator.clearBuffer();
                String guessedWord = wordSelector.getRandomWord();
                maskOperator.setWord(guessedWord);
                System.out.println("A word has been guessed!");
                maskOperator.printMask();

                while (!Win(maskOperator.getNumberGuessletter(), maskOperator.getWordUniqueLetters())) {
                    System.out.println("Guess the letter: ");
                    input();
                    //letter = scanner.nextLine();
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
                            System.out.println("You didn't goess");
                            mistakesCount++;
                            System.out.printf("Your mistakes %s/5\n", mistakesCount);
                            maskOperator.printMask();

                        }
                    }
                    if (mistakesCount == 5) {
                        System.out.println("You lose!");
                        System.out.printf("Word %s\n", guessedWord);
                        break;
                    }
                }
                System.out.println("congratulations!!!!");
            } else {
                System.exit(0);
            }

        }
    }
}
