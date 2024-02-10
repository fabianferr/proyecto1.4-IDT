package com.umlaut.crowd.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.HashMap;

class m {
    private static HashMap<String, Integer> a = new HashMap<>();
    private static final String[] b = {"com.samsung.android.providers.context", "com.android.systemui", "com.google.android.gms", "android.process.acore", "android.process.media", "<pre-initialized>", "system", "system:ui", "com.google.android.gms.persistent"};

    m() {
    }

    static boolean a(String str) {
        for (String equals : b) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static int a(String str, Context context) {
        Integer num = a.get(str);
        if (num == null) {
            try {
                Integer valueOf = Integer.valueOf(context.getPackageManager().getPackageInfo(str, 0).applicationInfo.uid);
                a.put(str, valueOf);
                num = valueOf;
            } catch (PackageManager.NameNotFoundException unused) {
                return 0;
            }
        }
        return num.intValue();
    }
}
