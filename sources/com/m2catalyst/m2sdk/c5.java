package com.m2catalyst.m2sdk;

import java.lang.reflect.Field;

/* compiled from: ReflectionMethods */
public final class c5 {
    public static Integer a(String str, Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return (Integer) declaredField.get(obj);
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }
}
