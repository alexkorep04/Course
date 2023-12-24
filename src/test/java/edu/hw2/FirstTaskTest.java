package edu.hw2;

import edu.hw2.first.Addition;
import edu.hw2.first.Constant;
import edu.hw2.first.Exponent;
import edu.hw2.first.Expr;
import edu.hw2.first.Multiplication;
import edu.hw2.first.Negate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstTaskTest {
    @Test
    @DisplayName("Test work of constant")
    public void testWorkOfConstant()
    {
        Expr constant = new Constant(-11.2);

        double expected = -11.2;

        double response = constant.evaluate();

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test work of addition")
    public void testWorkOfAddition()
    {
        Expr constant1 = new Constant(1);
        Expr constant2 = new Constant(2);
        Expr addition = new Addition(constant1, constant2);

        double expected = 3;

        double response = addition.evaluate();

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test work of negate")
    public void testWorkOfNegate()
    {
        Expr constant = new Constant(3);
        Expr negate = new Negate(constant);

        double expected = -3;

        double response = negate.evaluate();

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test work of exponent")
    public void testWorkOfExponent()
    {
        Expr number = new Constant(3);
        Expr exponent = new Exponent(number, 4);

        double expected = 81;

        double response = exponent.evaluate();

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test work of multiplication")
    public void testWorkOfMultiplication()
    {
        Expr constant1 = new Constant(5);
        Expr constant2 = new Constant(3);

        Expr multiplication = new Multiplication(constant1, constant2);

        double expected = 15;

        double response = multiplication.evaluate();

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test work of sample test")
    public void testWorkOfSampleTest()
    {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        double expected = 37;

        double response = res.evaluate();

        assertThat(expected).isEqualTo(response);
    }
}
