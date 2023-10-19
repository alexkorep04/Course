package edu.hw2.first;

public record Addition(Expr left, Expr right) implements  Expr {
    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }
}
