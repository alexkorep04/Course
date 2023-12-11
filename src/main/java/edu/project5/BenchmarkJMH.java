package edu.project5;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Thread)
public class BenchmarkJMH {
    @SuppressWarnings({"MagicNumber", "UncommentedMain"})
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(BenchmarkJMH.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(1)
            .warmupTime(TimeValue.seconds(5))
            .measurementIterations(1)
            .measurementTime(TimeValue.seconds(5))
            .build();

        new Runner(options).run();
    }

    private Student student;
    private Method method;
    private MethodHandle methodHandle;
    private Function<Student, Object> function;

    @Setup
    public void setup() throws Throwable {
        String methodName = "name";
        student = new Student("Alexander", "Korepanov");
        method = Student.class.getMethod(methodName);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(String.class);
        methodHandle = lookup.findVirtual(Student.class, methodName, methodType);
        CallSite secondSite = LambdaMetafactory.metafactory(
            lookup,
            "apply",
            MethodType.methodType(Function.class),
            MethodType.methodType(Object.class, Object.class),
            methodHandle,
            MethodType.methodType(Object.class, Student.class)
        );
        function = (Function<Student, Object>) secondSite.getTarget().invokeExact();
    }

    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = student.name();
        bh.consume(name);
    }

    @Benchmark
    public void reflection(Blackhole bh) throws InvocationTargetException, IllegalAccessException {
        String name = (String) method.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void methodHandle(Blackhole bh) throws Throwable {
        String name = (String) methodHandle.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void lambdaMetaFactory(Blackhole bh) {
        String name = (String) function.apply(student);
        bh.consume(name);
    }
}
