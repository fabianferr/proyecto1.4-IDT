package com.startapp;

import android.app.Activity;
import com.startapp.z5;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: Sta */
public class n {
    public static Pattern m;
    public final String a;
    public final z5.a b;
    public final boolean c;
    public final boolean d;
    public boolean e;
    public boolean f;
    public long g;
    public long h;
    public long i;
    public long j;
    public int k;
    public boolean l;

    public n(String str, z5.a aVar, boolean z, boolean z2) {
        this.a = str;
        this.b = aVar;
        this.c = z;
        this.d = z2;
    }

    public static void a(StringBuilder sb, String str, String str2, boolean z) {
        if (str != null) {
            sb.append(str);
            sb.append('=');
        }
        if (z) {
            sb.append('(');
            sb.append(str2);
            sb.append(')');
        } else {
            sb.append(str2);
        }
        sb.append(", ");
    }

    public static void a(StringBuilder sb) {
        if (sb.length() >= 2 && sb.substring(sb.length() - 2, sb.length()).equals(", ")) {
            sb.delete(sb.length() - 2, sb.length());
        }
    }

    public static String a(long j2) {
        boolean z = true;
        String format = String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(((float) j2) / 1000000.0f)});
        Map<Activity, Integer> map = k9.a;
        int length = format.length() - 1;
        int i2 = 0;
        while (length >= 0) {
            char charAt = format.charAt(length);
            if (charAt == '0') {
                if (z) {
                    i2++;
                }
            } else if (charAt == '.') {
                if (!z) {
                    length = format.length() - i2;
                }
                return format.substring(0, length);
            } else {
                z = false;
            }
            length--;
        }
        return format;
    }
}
