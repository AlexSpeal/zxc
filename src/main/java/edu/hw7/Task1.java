package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private Task1() {

    }

    public static int parallelIncrement() {
        AtomicInteger integer = new AtomicInteger(0);
        Thread thread1 = new Thread(integer::incrementAndGet);
        Thread thread2 = new Thread(integer::incrementAndGet);
        Thread thread3 = new Thread(integer::incrementAndGet);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return integer.get();
    }
}
