package edu.project4;

public class Run {
    private Run() {
    }

    @SuppressWarnings({"UncommentedMain", "MagicNumber"})
    public static void main(String[] args) {
        //var start = System.nanoTime();
        FractalImage canvas = new FractalImage();
        canvas.create(1920, 1080);
        Render render = new Render();
        render.render(canvas, 10000, 2000, 1);
        render.correction(canvas);
        //var end = System.nanoTime() - start;
        //System.out.println(end);
        Drawer drawerFlame = new Drawer(1920, 1080);
        drawerFlame.drawFlame(canvas.getData());
        //drawerFlame.saveToFile();
    }
}
