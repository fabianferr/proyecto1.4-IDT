package com.startapp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Sta */
public class y {
    public static final String c = k9.a(71, 13, -10, 14, -3, -6, -5, -54, 66, -11, 13, -5, -4, 10, 0, -10, 6, -1, -64, 19, 2, 0, 2, 14, 0, 12);
    public static final String d = k9.a(66, 3, 5, -9);
    public static final String e = k9.a(61, 12, -14, 17, 1, -14);
    public static final String f = k9.a(56, -1, 2, 8, -4, 11, -3, 6, -7, -10);
    public static final String g = k9.a(86, -19, 3, -12, -2, 19, -11, 6, -1);
    public final Context a;
    public final AtomicInteger b = new AtomicInteger(0);

    public y(Context context) {
        this.a = context;
    }

    public void a(int i) {
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[3];
        int i2 = 0;
        objArr[0] = Integer.valueOf(this.b.incrementAndGet());
        Context context = this.a;
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("com_startapp_sdk_aar", TypedValues.Custom.S_INT, context.getPackageName());
            if (identifier != 0) {
                i2 = resources.getInteger(identifier);
            }
        } catch (Throwable unused) {
        }
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i);
        String format = String.format(locale, "cnt=%d,aar=%d,mds=%d", objArr);
        i3 i3Var = new i3(j3.d);
        i3Var.d = MobileAdsBridgeBase.initializeMethodName;
        i3Var.e = format;
        i3Var.a();
    }

    public String a() {
        Context context = this.a;
        StringBuilder sb = new StringBuilder();
        String str = c;
        sb.append(str);
        sb.append(e);
        String str2 = g;
        sb.append(str2);
        StringBuilder a2 = p0.a(str);
        a2.append(d);
        a2.append(str2);
        StringBuilder a3 = p0.a(str);
        a3.append(f);
        a3.append(str2);
        String[] strArr = {sb.toString(), a2.toString(), a3.toString()};
        int[] iArr = new int[3];
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            String[] strArr2 = packageInfo.requestedPermissions;
            if (strArr2 != null) {
                int length = strArr2.length;
                for (int i = 0; i < length; i++) {
                    for (int i2 = 0; i2 < 3; i2++) {
                        if (strArr[i2].equals(packageInfo.requestedPermissions[i])) {
                            if ((packageInfo.requestedPermissionsFlags[i] & 2) == 2) {
                                iArr[i2] = 2;
                            } else {
                                iArr[i2] = 1;
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        StringBuilder sb2 = new StringBuilder(3);
        for (int i3 = 0; i3 < 3; i3++) {
            sb2.append(iArr[i3]);
        }
        return sb2.toString();
    }
}
