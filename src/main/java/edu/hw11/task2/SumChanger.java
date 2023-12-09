package edu.hw11.task2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import static net.bytebuddy.matcher.ElementMatchers.named;

public class SumChanger {
    private static String methodName = "sum";

    private SumChanger() {
    }

    public static int change(int a, int b) throws Exception {
        Class<?> dynamicType = new ByteBuddy()
            .subclass(Arithmetic.class)
            .method(named(methodName))
            .intercept(FixedValue.value(a * b))
            .make()
            .load(SumChanger.class.getClassLoader())
            .getLoaded();
        Object instance = dynamicType.getDeclaredConstructor().newInstance();
        return (int) instance.getClass().getMethod(methodName, int.class, int.class).invoke(instance, a, b);
    }
}
