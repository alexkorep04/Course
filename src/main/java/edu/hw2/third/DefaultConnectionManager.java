package edu.hw2.third;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    Random random = new Random();

    @Override
    public Connection getConnection() {
        if (random.nextInt() % 2 == 0) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
