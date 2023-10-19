package edu.hw2.first;

public record Negate(Expr num) implements Expr {
    @Override
    public double evaluate() {
        return -num().evaluate();
    }

    @Override
    public String toString() {
        return "-" + num;
    }
}
