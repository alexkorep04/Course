package edu.hw10.task2;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handler<T> implements InvocationHandler {
    private final Object object;
    private final Map<Method, Map<List<Object>, Object>> runtimeCachedValues = new HashMap<>();

    public Handler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        if (method.isAnnotationPresent(Cache.class)) {
            Cache cache = method.getAnnotation(Cache.class);
            if (cache.persist()) {
                return computePersistCache(method, args);
            } else {
                return computeInMemoryCache(method, args);
            }
        }
        return method.invoke(object, args);
    }

    private Object computeInMemoryCache(Method method, Object[] args) throws Exception {
        List<Object> argsList = args == null ? null : Arrays.asList(args);
        if (!runtimeCachedValues.containsKey(method)) {
            runtimeCachedValues.put(method, new HashMap<>());
        }
        if (!runtimeCachedValues.get(method).containsKey(argsList)) {
            Object ans = method.invoke(object, args);
            runtimeCachedValues.get(method).put(argsList, ans);
            return ans;
        }
        return runtimeCachedValues.get(method).get(argsList);
    }

    private Object computePersistCache(Method method, Object[] args) throws Exception {
        Path path = Path.of("cache_" + method.getName());
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        Object result = getCacheFromFile(method, args, path);
        if (result == null) {
            result = method.invoke(object, args);
            writeResultToDiskCache(args, result, path);
        }
        return result;
    }

    private Object getCacheFromFile(Method method, Object[] args, Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] split = line.split(":");
                String required = split[0];
                if (required.equals(Arrays.toString(args))) {
                    return convertResultFromString(split[1], method.getReturnType());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return null;
    }

    private void writeResultToDiskCache(Object[] args, Object result, Path methodFile) throws Exception {
        Files.writeString(
            methodFile,
            Arrays.toString(args) + ":" + String.valueOf(result) + "\n",
            StandardOpenOption.APPEND
        );
    }

    @SuppressWarnings("ReturnCount")
    private Object convertResultFromString(String resultString, Class<?> returnType) {
        if (returnType == int.class || returnType == Integer.class) {
            return Integer.parseInt(resultString);
        } else if (returnType == long.class || returnType == Long.class) {
            return Long.parseLong(resultString);
        } else if (returnType == double.class || returnType == Double.class) {
            return Double.parseDouble(resultString);
        } else if (returnType == float.class || returnType == Float.class) {
            return Float.parseFloat(resultString);
        } else if (returnType == boolean.class || returnType == Boolean.class) {
            return Boolean.parseBoolean(resultString);
        } else {
            return resultString;
        }
    }
}
