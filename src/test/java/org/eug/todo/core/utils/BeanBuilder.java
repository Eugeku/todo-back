package org.eug.todo.core.utils;

public class BeanBuilder {

    public static <T> T buildByClass(Class<T> tClass) {
        T object;
        try {
            object = tClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}