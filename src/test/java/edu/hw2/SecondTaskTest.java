package edu.hw2;

import edu.hw2.second.Rectangle;
import edu.hw2.second.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SecondTaskTest {
    @Test
    @DisplayName("Test LCP principle")
    public void testSampleInput()
    {
        Rectangle rectangle = new Rectangle(0, 0);
        rectangle = rectangle.setWidth(20);
        rectangle = rectangle.setHeight(10);

        double expected = 200;

        double response = rectangle.area();

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test getting correct area of square")
    public void testSquareArea()
    {
        Rectangle rectangle = new Square(0);
        rectangle = rectangle.setWidth(20);

        double expected = 400;

        double response= rectangle.area();

        assertThat(expected).isEqualTo(response);
    }
}
