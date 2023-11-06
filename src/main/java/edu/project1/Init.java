package edu.project1;

@SuppressWarnings("uncommentedmain")
public class Init {
    private Init() {

    }

    public static void main(String[] args) {
        Game initialization = new Game();
        RandomWordSelector wordSelector = new RandomWordSelector();
        initialization.start(wordSelector.getRandomWord());
    }
}
