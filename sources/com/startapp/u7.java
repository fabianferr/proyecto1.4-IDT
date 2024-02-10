package com.startapp;

import android.app.Activity;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Sta */
public class u7 {
    public final Map<a, String> a = new ConcurrentHashMap();

    /* compiled from: Sta */
    public static class a {
        public final AdPreferences.Placement a;
        public final int b;

        public a(AdPreferences.Placement placement, int i) {
            this.a = placement;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b == aVar.b && this.a == aVar.a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object[] objArr = {this.a, Integer.valueOf(this.b)};
            Map<Activity, Integer> map = k9.a;
            return Arrays.deepHashCode(objArr);
        }
    }
}
