package edu.hw2.first;

public sealed interface Expr permits Constant, Negate, Exponent, Addition, Multiplication {
    double evaluate();

}
