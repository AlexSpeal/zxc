package edu.hw2.Task2;

public class Task2 {
    private Task2() {

    }

    @SuppressWarnings("uncommentedmain")
    public static class Rectangle {
        private int width;
        private int height;

        public Rectangle() {
        }

        public Rectangle(int height, int width) {
            this.height = height;
            this.width = width;
        }

        public Rectangle setWidth(int width) {
            this.width=width;
            return this;
        }

        public Rectangle setHeight(int height) {
            this.height=height;
            return this;
        }

        double area() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        public Square() {
        }

        public Square(int side) {
            super(side, side);
        }

        public Square setSide(int side) {
            return new Square(side);
        }
    }
}
