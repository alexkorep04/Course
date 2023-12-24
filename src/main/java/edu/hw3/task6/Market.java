package edu.hw3.task6;

import java.util.PriorityQueue;

public class Market implements StockMarket {
    PriorityQueue<Stock> stocks;

    public Market() {
        stocks = new PriorityQueue<>((stock1, stock2) -> Double.compare(stock2.getPrice(), stock1.getPrice()));
    }

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
