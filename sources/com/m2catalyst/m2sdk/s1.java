package com.m2catalyst.m2sdk;

import java.util.Set;
import kotlin.collections.SetsKt;

/* compiled from: GeneralUtils.kt */
public final class s1 {
    public static final Set<String> a = SetsKt.setOf("com.m2catalyst.signaltracker", "com.m2catalyst.sdk_integration", "com.wilysis.cellinfolite", "com.wilysis.cellinfo", "com.geekyouup.android.widgets.battery", "com.elvison.batterywidget", "com.universetoday.moon.free", "com.universetoday.moon.phases");

    public static final float a(Float f) {
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public static final double a(Double d) {
        if (d != null) {
            return d.doubleValue();
        }
        return 0.0d;
    }

    public static final int a(Integer num, int i) {
        return num != null ? num.intValue() : i;
    }
}
