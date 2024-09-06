package ru.daniel.servlets.util;

import ru.daniel.servlets.config.Config;
import ru.daniel.servlets.config.impl.JavaConfig;

import java.lang.reflect.InvocationTargetException;

public class ObjectFactory {
    private static final ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig("ru.daniel");

    private ObjectFactory() {}

    public static ObjectFactory getInstance() {
        return instance;
    }

    public <T> T create(Class<T> type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends T> implClass = type;

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }

        return implClass.getDeclaredConstructor().newInstance();
    }
}
