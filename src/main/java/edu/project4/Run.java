package edu.project4;

public class Run {
    private Run() {
    }

    private static final int SAMPLES = 3000;
    private static final int ITER_PER_SAMPLE = 1000;
    private static final int SYMMETRY = 5;
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;

    @SuppressWarnings({"UncommentedMain"})
    public static void main(String[] args) {
        FractalImage canvas = new FractalImage();
        canvas.create();
        Render render = new Render();
        render.render(canvas, SAMPLES, ITER_PER_SAMPLE, SYMMETRY);
        render.correction(canvas);
        Drawer drawerFlame = new Drawer(WIDTH, HEIGHT);
        drawerFlame.drawFlame(canvas.getData());
        drawerFlame.saveToFile();

        //6 потоков 10107135400
        //5 потоков 9796012000
        //4 потоков 8733594700
        //3 потоков 7556467900
        //2 потоков 8944794700
        //1 потоков 5599083700
        // не могу понять почему в однопотоке работает быстрее всего...

    }
}
