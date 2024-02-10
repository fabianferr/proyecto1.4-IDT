package com.bytedance.sdk.openadsdk.core.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SecSdkHelper */
class b {
    private static a a;
    private String b;

    /* compiled from: SecSdkHelper */
    private static class a {
        /* access modifiers changed from: private */
        public static final b a = new b();
    }

    private b() {
        this.b = null;
        a = new a();
    }

    public void a(String str) {
        a aVar;
        if (!TextUtils.isEmpty(str) && (aVar = a) != null) {
            aVar.a(str);
        }
    }

    public static b a() {
        return a.a;
    }

    public void b(String str) {
        a aVar = a;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    public boolean b() {
        a aVar = a;
        if (aVar == null) {
            return false;
        }
        return aVar.b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c() {
        /*
            r1 = this;
            com.bytedance.sdk.openadsdk.core.e.a r0 = a
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.c()
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.e.b.c():java.lang.String");
    }

    public Map<String, String> a(String str, byte[] bArr) {
        a aVar = a;
        if (aVar != null) {
            return aVar.a(str, bArr);
        }
        return new HashMap();
    }
}
