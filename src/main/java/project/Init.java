package project;

@SuppressWarnings("uncommentedmain")
public class Init {
    private Init() {

    }

    private static final RandomWordSelector WORDSELECTOR = new RandomWordSelector();

    public static void main(String[] args) {
        Game initialization = new Game();
        initialization.start(WORDSELECTOR.getRandomWord());
    }
}
