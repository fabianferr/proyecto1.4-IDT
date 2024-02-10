package com.ironsource.sdk.g;

import com.ironsource.sdk.b;
import com.ironsource.sdk.j.a;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public String a;
    public String b;
    public int c;
    public Map<String, String> d;
    public int e;
    public boolean f;
    public a g;
    public b h;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(com.ironsource.sdk.b r7) {
        /*
            r6 = this;
            java.lang.String r0 = r7.b
            java.lang.String r1 = r7.c
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = "instanceId"
            java.lang.String r4 = r7.b
            r2.put(r3, r4)
            java.lang.String r3 = "instanceName"
            java.lang.String r4 = r7.c
            r2.put(r3, r4)
            boolean r3 = r7.a
            java.lang.String r3 = java.lang.Boolean.toString(r3)
            java.lang.String r4 = "rewarded"
            r2.put(r4, r3)
            boolean r3 = r7.d
            java.lang.String r3 = java.lang.Boolean.toString(r3)
            java.lang.String r4 = "inAppBidding"
            r2.put(r4, r3)
            boolean r3 = r7.h
            java.lang.String r3 = java.lang.Boolean.toString(r3)
            java.lang.String r4 = "isOneFlow"
            r2.put(r4, r3)
            java.lang.String r3 = "apiVersion"
            java.lang.String r4 = "2"
            r2.put(r3, r4)
            com.ironsource.sdk.a r3 = r7.e
            java.lang.String r4 = "0"
            if (r3 == 0) goto L_0x004e
            com.ironsource.sdk.a r3 = r7.e
            int r3 = r3.a
            java.lang.String r3 = java.lang.Integer.toString(r3)
            goto L_0x004f
        L_0x004e:
            r3 = r4
        L_0x004f:
            java.lang.String r5 = "width"
            r2.put(r5, r3)
            com.ironsource.sdk.a r3 = r7.e
            if (r3 == 0) goto L_0x0061
            com.ironsource.sdk.a r3 = r7.e
            int r3 = r3.b
            java.lang.String r4 = java.lang.Integer.toString(r3)
        L_0x0061:
            java.lang.String r3 = "height"
            r2.put(r3, r4)
            com.ironsource.sdk.a r3 = r7.e
            if (r3 == 0) goto L_0x006f
            com.ironsource.sdk.a r3 = r7.e
            java.lang.String r3 = r3.c
            goto L_0x0071
        L_0x006f:
            java.lang.String r3 = ""
        L_0x0071:
            java.lang.String r4 = "label"
            r2.put(r4, r3)
            boolean r3 = r7.a()
            java.lang.String r3 = java.lang.Boolean.toString(r3)
            java.lang.String r4 = "isBanner"
            r2.put(r4, r3)
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.f
            if (r3 == 0) goto L_0x008c
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.f
            r2.putAll(r3)
        L_0x008c:
            com.ironsource.sdk.j.a r3 = r7.g
            r6.<init>(r0, r1, r2, r3)
            r6.h = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.g.c.<init>(com.ironsource.sdk.b):void");
    }

    private c(String str, String str2, Map<String, String> map, a aVar) {
        this.c = -1;
        this.b = str;
        this.a = str2;
        this.d = map;
        this.g = aVar;
        this.e = 0;
        this.f = false;
        this.h = null;
    }

    public final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("demandSourceId", this.b);
        hashMap.put("demandSourceName", this.a);
        Map<String, String> map = this.d;
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public final synchronized void a(int i) {
        this.e = i;
    }
}
