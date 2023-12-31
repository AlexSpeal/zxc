package edu.hw3.Task6;

import java.util.PriorityQueue;

public class Market implements StockMarket {
    private final PriorityQueue<Stock> priorityQueue = new PriorityQueue<>();

    public PriorityQueue<Stock> getPriorityQueue() {
        return priorityQueue;
    }

    public void add(Stock stock) {
        priorityQueue.add(stock);
    }

    public void remove(Stock stock) {
        if (!priorityQueue.isEmpty()) {
            priorityQueue.remove(stock);
        }
    }

    public Stock mostValuableStock() {
        return priorityQueue.peek();
    }
}
