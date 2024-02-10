package com.startapp;

import com.appnext.core.Ad;
import java.util.Arrays;
import java.util.List;

/* compiled from: Sta */
public final class l5 {
    public static final List<String> c = Arrays.asList(new String[]{Ad.ORIENTATION_PORTRAIT, Ad.ORIENTATION_LANDSCAPE, "none"});
    public boolean a;
    public int b;

    public l5() {
        this(true, 2);
    }

    public static int a(String str) {
        int indexOf = c.indexOf(str);
        if (indexOf != -1) {
            return indexOf;
        }
        return 2;
    }

    public l5(boolean z, int i) {
        this.a = z;
        this.b = i;
    }
}
