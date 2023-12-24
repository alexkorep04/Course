package edu.hw2.third;

public class FaultyConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}
