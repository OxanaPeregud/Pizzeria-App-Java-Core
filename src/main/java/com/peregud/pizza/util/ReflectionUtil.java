package com.peregud.pizza.util;

import com.peregud.pizza.annotations.DBFieldName;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public class ReflectionUtil {

    public String annotatedField(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            if (field.isAnnotationPresent(DBFieldName.class)) {
                fieldName = field.getAnnotation(DBFieldName.class).key();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return fieldName;
    }
}
