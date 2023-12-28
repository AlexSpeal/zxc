package edu.hw3.Task6;

import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable<Stock> {
    private int priceOfAStock;
    private String name;

    public Stock(String name, int priceOfAStock) {
        if (priceOfAStock >= 0 && !name.isEmpty()) {
            this.priceOfAStock = priceOfAStock;
            this.name = name;
        } else {
            throw new RuntimeException("Отсутсвует имя или цена акции<0");
        }
    }

    int getPriceOfAStock() {
        return priceOfAStock;
    }

    String getName() {
        return name;
    }

    public int compareTo(@NotNull Stock comparable) {
        if (comparable.getPriceOfAStock() > priceOfAStock) {
            return 1;
        } else if (comparable.getPriceOfAStock() < priceOfAStock) {
            return -1;
        } else {
            return 0;
        }

    }
}
