package edu.hw2.first;

public record Constant(double value) implements Expr {
    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
