package com.startapp;

import android.app.Activity;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Sta */
public class w6 extends f7 {
    public final int a;

    public w6(int i) {
        this.a = i;
    }

    public boolean a(Object obj) {
        if (!(obj instanceof w0)) {
            return false;
        }
        int i = ((w0) obj).Z;
        if ((this.a & i) == i) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && w6.class == obj.getClass() && this.a == ((w6) obj).a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object[] objArr = {Integer.valueOf(this.a)};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }
}
