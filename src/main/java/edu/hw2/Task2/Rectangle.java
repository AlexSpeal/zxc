package edu.hw2.Task2;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle setWidth(int width) {
        this.width = width;
        return this;
    }

    public Rectangle setHeight(int height) {
        this.height = height;
        return this;
    }

    public double area() {
        return width * height;
    }
}
