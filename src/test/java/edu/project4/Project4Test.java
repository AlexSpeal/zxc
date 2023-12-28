package edu.project4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Project4Test {
    @Test
    @DisplayName("Изображение меняется после render")
    void test() {
        FractalImage canvas = new FractalImage();
        canvas.create();
        FractalImage canvasFirst = new FractalImage();
        canvasFirst.create();
        boolean isNotEquals = false;

        Render render = new Render();
        render.render(canvas, 3000, 1000, 5);
        for (int i = 0; i < 1920; ++i) {
            for (int j = 0; j < 1080; ++j) {
                if (canvasFirst.getData()[i][j].getCountHit() != canvas.getData()[i][j].getCountHit()) {
                    isNotEquals = true;
                }
            }
        }
        assertTrue(isNotEquals);
    }
}
