package edu.hw10.task1;

import edu.hw10.task1.generators.BooleanGenerator;
import edu.hw10.task1.generators.ByteGenerator;
import edu.hw10.task1.generators.CharGenerator;
import edu.hw10.task1.generators.DoubleGenerator;
import edu.hw10.task1.generators.FloatGenerator;
import edu.hw10.task1.generators.Generator;
import edu.hw10.task1.generators.IntGenerator;
import edu.hw10.task1.generators.LongGenerator;
import edu.hw10.task1.generators.StringGenerator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomObjectGenerator {
    private final Map<Class<?>, Generator<?>> generators;

    public RandomObjectGenerator() {
        generators = new HashMap<>();
        generators.put(int.class, new IntGenerator());
        generators.put(Integer.class, new IntGenerator());
        generators.put(long.class, new LongGenerator());
        generators.put(Long.class, new LongGenerator());
        generators.put(boolean.class, new BooleanGenerator());
        generators.put(Boolean.class, new BooleanGenerator());
        generators.put(byte.class, new ByteGenerator());
        generators.put(ByteGenerator.class, new ByteGenerator());
        generators.put(float.class, new FloatGenerator());
        generators.put(Float.class, new FloatGenerator());
        generators.put(double.class, new DoubleGenerator());
        generators.put(Double.class, new DoubleGenerator());
        generators.put(char.class, new CharGenerator());
        generators.put(Character.class, new CharGenerator());
        generators.put(String.class, new StringGenerator());
    }

    public <V> V nextObject(Class<V> cl) {
        Constructor<?> constructor = getConstructor(cl);
        Parameter[] parameters = constructor.getParameters();
        Object[] values = getRandomValues(parameters);
        try {
            return cl.cast(constructor.newInstance(values));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public <V> V nextObject(Class<V> cl, String methodName) {
        Method fabricMethod = getFabricMethod(cl);
        Parameter[] parameters = fabricMethod.getParameters();
        Object[] values = getRandomValues(parameters);
        try {
            return cl.cast(fabricMethod.invoke(null, values));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Constructor<?> getConstructor(Class<?> cl) {
        Constructor<?>[] allConstructors = cl.getDeclaredConstructors();
        if (allConstructors.length < 1) {
            throw new IllegalArgumentException();
        }
        Constructor<?> answer = allConstructors[0];
        for (int i = 1; i < allConstructors.length; i++) {
            Constructor<?> current = allConstructors[i];
            if (current.getParameterCount() > answer.getParameterCount()) {
                answer = current;
            }
        }
        return answer;
    }

    private Object[] getRandomValues(Parameter[] parameters) {
        List<Object> values = new ArrayList<>();
        for (Parameter parameter: parameters) {
            Class<?> type = parameter.getType();
            if (!generators.containsKey(type)) {
                throw new IllegalArgumentException("Generator does not support this type!");
            }
            Generator<?> generator = generators.get(type);
            values.add(generator.generate(parameter.getAnnotations()));
        }
        return values.toArray();
    }

    private static Method getFabricMethod(Class<?> cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method method: methods) {
            if ("create".equals(method.getName())) {
                return method;
            }
        }
        throw new IllegalArgumentException();
    }
}
