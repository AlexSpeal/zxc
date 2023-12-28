package edu.project4;

public class FractalImage {
    final static int WIDTH = 1920;
    final static int HEIGHT = 1080;
    private Pixel[][] data;

    public void create() {
        data = new Pixel[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; ++i) {
            for (int j = 0; j < HEIGHT; ++j) {
                data[i][j] = new Pixel();
            }
        }
    }

    boolean contains(double x, double y) {
        return ((x < WIDTH)) && ((y < HEIGHT)
            && (x >= 0) && (y >= 0));
    }

    public void setData(Pixel[][] data) {
        this.data = data;
    }

    public Pixel[][] getData() {
        return data;
    }
}

