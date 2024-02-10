package com.umlaut.crowd.internal;

public class p6 {
    public static float a(float f) {
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return 0.0f;
        }
        return f;
    }

    public static float a(float f, float f2) {
        return (Float.isNaN(f) || Float.isInfinite(f)) ? f2 : f;
    }
}
