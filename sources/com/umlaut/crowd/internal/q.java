package com.umlaut.crowd.internal;

import java.util.Arrays;

public class q {
    public static <T> T[] a(T[] tArr, T[] tArr2) {
        T[] copyOf = Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, copyOf, tArr.length, tArr2.length);
        return copyOf;
    }
}
