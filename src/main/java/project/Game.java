package project;

import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("RegexpSinglelineJava")
public class Game {
    final static int MISTAKES = 5;
    private final RandomWordSelector wordSelector = new RandomWordSelector();
    private final WordMask maskOperator = new WordMask();
    private String letter = "";
    private boolean giveUp = false;

    private void input() {
        Scanner scanner = new Scanner(System.in);

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

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        int mistakesCount;
        while (true) {
            System.out.println("Menu: [N]ew game/ [E]xit");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                mistakesCount = 0;
                maskOperator.clearBuffer();
                String guessedWord = wordSelector.getRandomWord();
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

            } else if (choice.equalsIgnoreCase("Y")) {
                System.exit(0);

            } else {
                System.out.println("Input correct letter");
            }
        }
    }
}
