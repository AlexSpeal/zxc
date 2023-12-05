package edu.project4;

import edu.project4.Samples.CYLINDER;
import edu.project4.Samples.DISC;
import edu.project4.Samples.HANDKERCHIEF;
import edu.project4.Samples.HEART;
import java.util.List;

public class Run {
    private Run() {
    }

    @SuppressWarnings({"UncommentedMain", "MagicNumber"})
    public static void main(String[] args) {
        //var start = System.nanoTime();
        FractalImage canvas = new FractalImage();
        canvas.create(1920, 1080);
        Render render = new Render();
        render.render(canvas, 3000, 3000, 1,
            List.of(new HANDKERCHIEF(), new HEART(), new CYLINDER(), new DISC())
        );
        render.correction(canvas);
        //var end = System.nanoTime() - start;
        //System.out.println(end);
        Drawer drawerFlame = new Drawer(1920, 1080);
        drawerFlame.drawFlame(canvas.getData());
        drawerFlame.saveToFile();
    }
}
