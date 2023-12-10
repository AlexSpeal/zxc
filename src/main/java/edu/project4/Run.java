package edu.project4;

public class Run {
    private Run() {
    }

    @SuppressWarnings({"UncommentedMain", "MagicNumber"})
    public static void main(String[] args) {
        FractalImage canvas = new FractalImage();
        canvas.create();
        Render render = new Render();
        render.render(canvas, 3000, 1000, 5);
        render.correction(canvas);
        Drawer drawerFlame = new Drawer(1920, 1080);
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
