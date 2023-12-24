package edu.hw10.task2;

import java.lang.reflect.Proxy;

public class CacheProxy {

    private CacheProxy() {
    }

    public static <T> T create(T object, Class<? extends T> cl) {
        return (T) Proxy.newProxyInstance(
            cl.getClassLoader(),
            cl.getInterfaces(),
            new Handler<>(object)
        );
    }
}
