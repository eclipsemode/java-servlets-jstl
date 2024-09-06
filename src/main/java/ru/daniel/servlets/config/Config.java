package ru.daniel.servlets.config;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> interfaceClass);
}
