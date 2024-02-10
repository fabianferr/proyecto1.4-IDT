package com.startapp;

import android.util.Pair;
import java.util.List;

/* compiled from: Sta */
public class e7 {
    public final l1 a;
    public final List<Pair<f7, Boolean>> b;
    public final int c;
    public final int[] d;
    public final Integer e;
    public final Integer f;
    public final int g;
    public final int h;

    public e7(l1 l1Var, List<Pair<f7, Boolean>> list, int i, int[] iArr, Integer num, Integer num2, int i2, int i3) {
        this.a = l1Var;
        this.b = list;
        this.c = i;
        this.d = iArr;
        this.e = num;
        this.f = num2;
        this.g = i2;
        this.h = i3;
    }

    public boolean a(int i) {
        return (i & this.h) != 0;
    }
}
