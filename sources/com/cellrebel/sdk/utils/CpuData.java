package com.cellrebel.sdk.utils;

import java.util.Collections;
import java.util.List;

public class CpuData {
    private final String a;
    private final int b;
    private final List c;
    private final boolean d;

    public CpuData(String str, int i, List list) {
        this(str, i, list, false);
    }

    public CpuData(String str, int i, List list, boolean z) {
        this.a = str;
        this.b = i;
        this.c = list;
        this.d = z;
    }

    public CpuData(String str, boolean z) {
        this(str, -1, Collections.emptyList(), z);
    }

    public final int a() {
        return this.b;
    }
}
