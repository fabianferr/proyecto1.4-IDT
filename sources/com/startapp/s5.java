package com.startapp;

import android.app.Activity;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* compiled from: Sta */
public class s5 {
    public String a;
    public String b;
    public Set<String> c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s5.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((s5) obj).a);
    }

    public int hashCode() {
        Object[] objArr = {this.a};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }

    public String toString() {
        StringBuilder a2 = p0.a("NameValueObject [name=");
        a2.append(this.a);
        a2.append(", value=");
        a2.append(this.b);
        a2.append(", valueSet=");
        a2.append(this.c);
        a2.append("]");
        return a2.toString();
    }
}
