package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.core.setup.ZombieInitializationSDKReceiver;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SDKZombieManager.kt */
public final class b6 {
    public static void a(Context context, long j, long j2) {
        Intrinsics.checkNotNullParameter(context, "context");
        a.a(context, ZombieInitializationSDKReceiver.class, ZombieInitializationSDKReceiver.AUTOCHECK_ACTION, j, j2, 0, 0, true);
        String a = o1.a(j);
        r1.a("Setup zombie SDK checker for " + a + " every " + (j2 / ((long) 60000)) + " minutes", context, (String) null, true);
    }

    public static void a(Context context) {
        Long l;
        long j;
        Intrinsics.checkNotNullParameter(context, "context");
        if (r2.j == null) {
            r2.j = new r2();
        }
        r2 r2Var = r2.j;
        Intrinsics.checkNotNull(r2Var);
        z5 a = r2Var.a();
        a6 a6Var = a6.NEXT_TIME_SDK_INITIALIZATION_ALARM;
        long j2 = 0;
        long j3 = 0L;
        String str = a6Var.a;
        if (a.a.getAll().containsKey(str)) {
            j3 = a.a.getAll().get(str);
        }
        Long l2 = (Long) j3;
        if (l2 != null) {
            j2 = l2.longValue();
        }
        if (j2 > System.currentTimeMillis()) {
            l = Long.valueOf(j2);
        } else {
            int i = 0;
            int i2 = 0;
            String str2 = a6.SDK_INITIALIZATION_ALARM_TRIES.a;
            if (a.a.getAll().containsKey(str2)) {
                i2 = a.a.getAll().get(str2);
            }
            Integer num = (Integer) i2;
            if (num != null) {
                i = num.intValue();
            }
            if (i > 9) {
                l = null;
            } else {
                float pow = ((float) 120000) * ((float) Math.pow((double) 2.2f, (double) i));
                if (pow > 8.64E7f) {
                    j = System.currentTimeMillis() + 86400000;
                } else {
                    j = System.currentTimeMillis() + ((long) pow);
                }
                a.a(a6Var, Long.valueOf(j));
                l = Long.valueOf(j);
            }
        }
        if (l != null) {
            long longValue = l.longValue();
            a.a(context, ZombieInitializationSDKReceiver.class, ZombieInitializationSDKReceiver.INITIALIZE_ACTION, longValue, 0, 0, 0, true);
            String a2 = o1.a(longValue);
            r1.a("Setup zombie SDK Initialize Alarm for " + a2, context, (String) null, true);
        }
    }
}
