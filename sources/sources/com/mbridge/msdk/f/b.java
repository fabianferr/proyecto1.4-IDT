package com.mbridge.msdk.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.GoogleApiAvailability;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CronetEnvironmentCheckUtil */
public final class b {
    public static String a = "";
    private static boolean b = false;

    private static String d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create(1, "org.chromium.net.impl.JavaCronetProvider"));
        arrayList.add(Pair.create(2, "org.chromium.net.impl.NativeCronetProvider"));
        arrayList.add(Pair.create(3, "com.google.android.gms.net.PlayServicesCronetProvider"));
        arrayList.add(Pair.create(4, "com.google.android.gms.net.GmsCoreCronetProvider"));
        try {
            StringBuilder sb = new StringBuilder();
            ClassLoader classLoader = com.mbridge.msdk.foundation.controller.b.d().g().getClassLoader();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (!TextUtils.isEmpty(classLoader.loadClass((String) pair.second).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{com.mbridge.msdk.foundation.controller.b.d().g()}).getClass().getName())) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(pair.first);
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            aa.d("CronetEnvCheckUtil", th.getMessage());
            return "";
        }
    }

    public static boolean b() {
        if (!ac.a().a("cronet_engine_open", false) || !b) {
            return false;
        }
        return true;
    }

    public static boolean c() {
        return b;
    }

    public static boolean a(boolean z) {
        return b && z;
    }

    public static void a() {
        boolean z = true;
        if (ac.a().a("cronet_env_check", true)) {
            try {
                Class.forName("com.google.android.gms.common.GoogleApiAvailability");
                GoogleApiAvailability.getInstance().getApkVersion(com.mbridge.msdk.foundation.controller.b.d().g());
                GoogleApiAvailability.getInstance().verifyGooglePlayServicesIsAvailable(com.mbridge.msdk.foundation.controller.b.d().g(), 11925000);
                try {
                    String d = d();
                    if (TextUtils.isEmpty(d)) {
                        z = false;
                    }
                    b = z;
                    if (z) {
                        a = d;
                    }
                } catch (Throwable th) {
                    aa.d("CronetEnvCheckUtil", th.getMessage());
                }
            } catch (Throwable th2) {
                aa.d("CronetEnvCheckUtil", th2.getMessage());
                b = false;
            }
        }
    }
}
