package edu.hw2.first;

public record Exponent(Expr base, int exponent) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(base.evaluate(), exponent);
    }

    @Override
    public String toString() {
        return "(" + base + "^" + exponent + ")";
    }
}
