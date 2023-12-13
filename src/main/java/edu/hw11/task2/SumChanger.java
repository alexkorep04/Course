package edu.hw11.task2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.pool.TypePool;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static net.bytebuddy.matcher.ElementMatchers.returns;

public class SumChanger {
    private static String methodName = "sum";

    private SumChanger() {
    }

    public static void change() throws Exception {
        TypeDescription typeDescription = TypePool.Default.ofSystemLoader()
            .describe("edu.hw11.task2.Arithmetic")
            .resolve();
        new ByteBuddy()
            .redefine(typeDescription, ClassFileLocator.ForClassLoader.ofSystemLoader())
            .method(named("sum"))
            .intercept(MethodCall.invoke(typeDescription.getDeclaredMethods().getLast()).withAllArguments())
            .make()
            .load(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.Default.INJECTION);
    }
}
