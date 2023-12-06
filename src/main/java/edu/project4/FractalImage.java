package edu.project4;

public class FractalImage {
    final static int width = 1920;
    final static int height = 1080;
    private Pixel[][] data;

    public void create() {
        data = new Pixel[width][height];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                data[i][j] = new Pixel();
            }
        }
    }

    ;

    boolean contains(double x, double y) {
        return ((x < width)) && ((y < height)
            && (x >= 0) && (y >= 0));
    }

    public void setData(Pixel[][] data) {
        this.data = data;
    }

    public Pixel[][] getData() {
        return data;
    }
}

