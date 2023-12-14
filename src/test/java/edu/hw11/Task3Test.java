package edu.hw11;

import edu.hw11.task3.FibonacciClassGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    private static Class<?> dynamicClass;

    @BeforeEach
    public void create() {
        dynamicClass = FibonacciClassGenerator.createClass();
    }

    @Test
    @DisplayName("Test Fibonacci when n >= 2")
    public void testFibonacci()
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object instance = dynamicClass.newInstance();
        Method method = dynamicClass.getDeclaredMethod("calculateFibonacci", int.class);
        long expected = 55;

        long response = (long) method.invoke(instance, 10);

        assertThat(expected).isEqualTo(response);

    }

    @Test
    @DisplayName("Test Fibonacci when n < 2")
    public void testFibonacciWhenArgIsLow()
        throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Object instance = dynamicClass.newInstance();
        Method method = dynamicClass.getDeclaredMethod("calculateFibonacci", int.class);
        long expected = 1;

        long response = (long) method.invoke(instance, 1);

        assertThat(expected).isEqualTo(response);
    }

}
