package ru.daniel.servlets.config.impl;

import org.reflections.Reflections;
import ru.daniel.servlets.config.Config;

import java.util.Set;

public class JavaConfig implements Config {
    private Reflections scanner;

    public JavaConfig(String packageToScan) {
        scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> interfaceClass) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(interfaceClass);
        if (classes.size() != 1) throw new RuntimeException("There can be only one implementation of " + interfaceClass.getName());
        return classes.iterator().next();
    }
}
