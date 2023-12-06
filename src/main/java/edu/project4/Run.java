package edu.project4;

public class Run {
    private Run() {
    }

    @SuppressWarnings({"UncommentedMain", "MagicNumber"})
    public static void main(String[] args) {
        var start = System.nanoTime();
        FractalImage canvas = new FractalImage();
        canvas.create();
        Render render = new Render();
        render.render(canvas, 3000, 10000, 1);
        render.correction(canvas);
        var end = System.nanoTime() - start;
        System.out.println(end);
        Drawer drawerFlame = new Drawer(1920, 1080);
        drawerFlame.drawFlame(canvas.getData());
        //drawerFlame.saveToFile();
        //8389836300
        //5238249700
    }
}
