package edu.project4;

public class FractalImage {
    final static int width = 1920;
    final static int height = 1080;
    private Pixel[][] data;

    public void create(int width, int height) {
        data=new Pixel[width][height];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                data[i][j] = new Pixel();
            }
        }
    }

    ;

    boolean contains(int x, int y) {
        return false;
    }

    Pixel pixel(int x, int y) {
        return null;
    }

    public void setData(Pixel[][] data) {
        this.data = data;
    }

    public Pixel[][] getData() {
        return data;
    }
}

