package edu.project;

@SuppressWarnings("uncommentedmain")
public class Init {
    private Init() {

    }

    public static void main(String[] args) {
        Game initialization = new Game();
        RandomWordSelector WORDSELECTOR = new RandomWordSelector();
        initialization.start(WORDSELECTOR.getRandomWord());
    }
}
