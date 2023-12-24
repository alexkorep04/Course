package edu.hw2.third;

public interface Connection extends AutoCloseable {
    void execute(String command);
}
