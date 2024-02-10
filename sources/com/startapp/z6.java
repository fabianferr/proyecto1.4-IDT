package com.startapp;

import android.app.Activity;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: Sta */
public class z6 extends f7 {
    public final List<j3> a;

    public z6(List<j3> list) {
        this.a = list;
    }

    public boolean a(Object obj) {
        if (obj instanceof r3) {
            return this.a.contains(((r3) obj).j0.a);
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z6.class != obj.getClass()) {
            return false;
        }
        return k9.a(this.a, ((z6) obj).a);
    }

    public int hashCode() {
        Object[] objArr = {this.a};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }
}
