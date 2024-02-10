package com.startapp;

import android.app.Activity;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Sta */
public class y6 extends f7 {
    public final j3 a;
    public final String b;

    public y6(j3 j3Var, String str) {
        this.a = j3Var;
        this.b = str;
    }

    public boolean a(Object obj) {
        if (!(obj instanceof r3)) {
            return false;
        }
        j3 j3Var = this.a;
        i3 i3Var = ((r3) obj).j0;
        if (j3Var != i3Var.a) {
            return false;
        }
        String str = this.b;
        if (str == null || str.equals(i3Var.d)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y6.class != obj.getClass()) {
            return false;
        }
        y6 y6Var = (y6) obj;
        if (!k9.a(this.a, y6Var.a) || !k9.a(this.b, y6Var.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.a, this.b};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }
}
