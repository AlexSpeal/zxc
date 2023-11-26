package edu.hw7.Task4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

@SuppressWarnings({"UncommentedMain", "RegexpSinglelineJava", "MagicNumber"})
public class Task4 {

    private Task4() {

    }
    // 6 потоков
    // Показатель ускорения колебался от 1.07 до 2.45,
    // максимальный показатель был при количестве точек: 1_000_000_000

    // Уровень погрешности для симуляции:
    // в 10млн симуляций - 0.0005818032799895789
    // в 100млн симуляций - 0.0002598879364823503
    // в 1млрд симуляций - 0.00002120297666241555
    //10000000
    public static void main(String[] args) {
        var first = System.nanoTime();
        System.out.printf("One Thread PI: %s%n", oneThreadPI(10000000));
        var second = System.nanoTime() - first;
        //System.out.println(second);
        first = System.nanoTime();
        System.out.printf("Multi Thread PI: %s%n", multiThreadPI(10000000));
        var second1 = System.nanoTime() - first;
        //System.out.println(second1);
        System.out.println((double) second / second1);
        System.out.println(Math.abs(multiThreadPI(10000000) - Math.PI));
    }

    public static double oneThreadPI(long numberOfIterations) {
        long totalCount = 0;
        long circleCount = 0;
        Circle circle = new Circle();
        for (int i = 1; i <= numberOfIterations; ++i) {
            var point = new Point(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble());
            if (circle.isPointOfCircle(point)) {
                circleCount++;
            }
            totalCount++;
        }
        return (4.0 * circleCount) / totalCount;
    }

    public static double multiThreadPI(long numberOfIterations) {
        LongAdder totalCount = new LongAdder();
        LongAdder circleCount = new LongAdder();
        Circle circle = new Circle();
        int numberOfThread = 6;
        Runnable lambda = (() -> {
            for (int i = 1; i <= numberOfIterations / numberOfThread; ++i) {
                var point =
                    new Point(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble());
                if (circle.isPointOfCircle(point)) {
                    circleCount.increment();
                }
                totalCount.increment();
            }
        });
        var thread1 = new Thread(lambda);
        var thread2 = new Thread(lambda);
        var thread3 = new Thread(lambda);
        var thread4 = new Thread(lambda);
        var thread5 = new Thread(lambda);
        var thread6 = new Thread(lambda);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 4.0 * circleCount.longValue() / totalCount.longValue();
    }
}
