package com.startapp;

import com.facebook.internal.security.CertificateUtil;
import java.lang.Comparable;
import java.util.regex.Pattern;

/* compiled from: Sta */
public class q9<T extends Comparable<T>> implements Comparable<q9<T>> {
    public static Pattern c = Pattern.compile("\\d{2}:\\d{2}:\\d{2}(.\\d{3})?");
    public static Pattern d = Pattern.compile("((\\d{1,2})|(100))%");
    public final String a;
    public final T b;

    public q9(String str, T t) {
        this.a = str;
        this.b = t;
    }

    public static boolean a(String str) {
        return c.matcher(str).matches();
    }

    public static Integer b(String str) {
        String[] split = str.split(CertificateUtil.DELIMITER);
        if (split.length != 3) {
            return null;
        }
        try {
            return Integer.valueOf((Integer.parseInt(split[1]) * 60 * 1000) + (Integer.parseInt(split[0]) * 60 * 60 * 1000) + ((int) (Float.parseFloat(split[2]) * 1000.0f)));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public int compareTo(Object obj) {
        return this.b.compareTo(((q9) obj).b);
    }
}
