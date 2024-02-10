package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: AESUtils */
public class a {

    /* renamed from: com.bytedance.sdk.component.utils.a$a  reason: collision with other inner class name */
    /* compiled from: AESUtils */
    static class C0058a {
        static final Random a = a.c();
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return a(jSONObject.toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r2.put(com.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MESSAGE, r6);
        r2.put("cypher", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        com.bytedance.sdk.component.utils.l.b(r6.getMessage());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(java.lang.String r6) {
        /*
            java.lang.String r0 = "cypher"
            java.lang.String r1 = "message"
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            boolean r3 = android.text.TextUtils.isEmpty(r6)
            if (r3 == 0) goto L_0x0010
            return r2
        L_0x0010:
            r3 = 0
            java.lang.String r4 = b(r6)     // Catch:{ all -> 0x002a }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x002a }
            if (r5 != 0) goto L_0x0023
            r2.put(r1, r4)     // Catch:{ all -> 0x002a }
            r4 = 3
            r2.put(r0, r4)     // Catch:{ all -> 0x002a }
            goto L_0x0039
        L_0x0023:
            r2.put(r1, r6)     // Catch:{ all -> 0x002a }
            r2.put(r0, r3)     // Catch:{ all -> 0x002a }
            goto L_0x0039
        L_0x002a:
            r2.put(r1, r6)     // Catch:{ all -> 0x0031 }
            r2.put(r0, r3)     // Catch:{ all -> 0x0031 }
            goto L_0x0039
        L_0x0031:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.bytedance.sdk.component.utils.l.b(r6)
        L_0x0039:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.a.a(java.lang.String):org.json.JSONObject");
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a = a();
        String a2 = a(a, 32);
        String b = b();
        String a3 = (a2 == null || b == null) ? null : com.bytedance.sdk.component.c.a.a(str, b, a2);
        return ExifInterface.GPS_MEASUREMENT_3D + a + b + a3;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String a = a(str.substring(1, 33), 32);
        String substring = str.substring(33, 49);
        return (substring == null || a == null) ? str : com.bytedance.sdk.component.c.a.b(str.substring(49), substring, a);
    }

    public static String a() {
        String a = a(16);
        if (a == null || a.length() != 32) {
            return null;
        }
        return a;
    }

    public static String a(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String b() {
        String a = a(8);
        if (a == null || a.length() != 16) {
            return null;
        }
        return a;
    }

    public static String a(int i) {
        try {
            byte[] bArr = new byte[i];
            C0058a.a.nextBytes(bArr);
            return e.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Random c() {
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }
}
