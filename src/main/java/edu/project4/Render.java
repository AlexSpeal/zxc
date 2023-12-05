package edu.project4;

import java.util.List;
import java.util.Random;
import static java.lang.Math.log10;

public class Render {
    private static final double X_MIN = -1.777;
    private static final double X_MAX = 1.777;
    private static final double Y_MIN = -1;
    private static final double Y_MAX = 1;
    private static final int RES_X = 1920;
    private static final int RES_Y = 1080;
    private static final int MINIMAL_ITERATION = 20;

    public void render(
        FractalImage canvas,
        int samples,
        long iterPerSample,
        int symmetry, List<Fractal> fractalList
    ) {
        Random r = new Random();
        Coefficients[] coefficients = getRandomCoefficients(samples);
        for (int i = 0; i < samples; ++i) {

            double newX = Math.random() * (X_MAX - X_MIN) + X_MIN;
            double newY = Math.random() * (Y_MAX - Y_MIN) + Y_MIN;
            for (int step = -MINIMAL_ITERATION; step < iterPerSample; ++step) {
                int randCoeff = r.nextInt(samples);
                int randFunc = r.nextInt(fractalList.size());
                Coefficients oneCoefficients = coefficients[randCoeff];
                Point point = AffineTransformation(newX, newY, oneCoefficients);

                for (var func : fractalList) {
                    point = func.apply(point);
                }

                //Fractal function = fractalList.get(randFunc);
                //point = function.apply(point);
                if (step >= 0 && containedInTheArea(point)) {
                    double theta = 0;
                    for (int s = 0; s < symmetry; ++s) {
                        theta += 2 * Math.PI / symmetry;
                        point = getRotatedPoint(point, theta);
                        double xInCanvas = (point.x() - X_MIN) / (X_MAX - X_MIN) * RES_X;
                        double yInCanvas = (point.y() - Y_MIN) / (Y_MAX - Y_MIN) * RES_Y;
                        if (!canvas.contains(xInCanvas, yInCanvas)) {
                            continue;
                        }
                        int x = (int) xInCanvas;
                        int y = (int) yInCanvas;
                        if (canvas.getData()[x][y].getCountHit() == 0) {
                            canvas.getData()[x][y].getRgb().setBlue(coefficients[randCoeff].rgb().getBlue());
                            canvas.getData()[x][y].getRgb().setRed(coefficients[randCoeff].rgb().getRed());
                            canvas.getData()[x][y].getRgb().setGreen(coefficients[randCoeff].rgb().getGreen());
                        } else {
                            canvas.getData()[x][y].getRgb().setBlue((canvas.getData()[x][y].getRgb().getBlue()
                                + coefficients[randCoeff].rgb().getBlue()) / 2);
                            canvas.getData()[x][y].getRgb().setRed((canvas.getData()[x][y].getRgb().getRed()
                                + coefficients[randCoeff].rgb().getRed()) / 2);
                            canvas.getData()[x][y].getRgb().setGreen((canvas.getData()[x][y].getRgb().getGreen()
                                + coefficients[randCoeff].rgb().getGreen()) / 2);
                        }
                        canvas.getData()[x][y].incrementCountHit();
                    }
                    //}
                }
            }
        }

    }

    void correction(FractalImage canvas) {
        double max = 0.0;
        double gamma = 2.2;
        for (int row = 0; row < RES_X; row++) {
            for (int col = 0; col < RES_Y; col++) {
                if (canvas.getData()[row][col].getCountHit() != 0) {
                    double newNormal = log10(canvas.getData()[row][col].getCountHit());
                    canvas.getData()[row][col].setNormal(newNormal);
                    if (canvas.getData()[row][col].getNormal() > max) {
                        max = canvas.getData()[row][col].getNormal();
                    }
                }
            }
        }
        for (int row = 0; row < RES_X; row++) {
            for (int col = 0; col < RES_Y; col++) {
                double normal = canvas.getData()[row][col].getNormal();
                canvas.getData()[row][col].setNormal(normal / max);
                int newColor = (int) (canvas.getData()[row][col].getRgb().getRed()
                    * Math.pow(canvas.getData()[row][col].getNormal(), (1.0 / gamma)));
                canvas.getData()[row][col].getRgb().setRed(newColor);
                newColor = (int) (canvas.getData()[row][col].getRgb().getGreen()
                    * Math.pow(canvas.getData()[row][col].getNormal(), (1.0 / gamma)));
                canvas.getData()[row][col].getRgb().setGreen(newColor);
                newColor = (int) (canvas.getData()[row][col].getRgb().getBlue()
                    * Math.pow(canvas.getData()[row][col].getNormal(), (1.0 / gamma)));
                canvas.getData()[row][col].getRgb().setBlue(newColor);
            }
        }
    }

    Coefficients[] getRandomCoefficients(int samples) {
        Coefficients[] coefficients = new Coefficients[samples];
        for (int i = 0; i < samples; ++i) {
            coefficients[i] = Coefficients.randomCoefficients();
        }
        return coefficients;
    }

    Point getRotatedPoint(Point point, double theta) {
        double xRot = point.x() * Math.cos(theta) - point.y() * Math.sin(theta);
        double yRot = point.x() * Math.sin(theta) + point.y() * Math.cos(theta);
        return new Point(xRot, yRot);
    }

    boolean containedInTheArea(Point point) {
        if (point.x() >= X_MIN && point.x() <= X_MAX) {
            return point.y() >= Y_MIN && point.y() <= Y_MAX;
        }
        return false;
    }

    Point AffineTransformation(double x, double y, Coefficients coefficients) {
        double newX;
        double newY;
        newX = coefficients.a() * x + coefficients.b() * y + coefficients.c();
        newY = coefficients.d() * x + coefficients.e() * y + coefficients.f();
        return new Point(newX, newY);
    }

}
