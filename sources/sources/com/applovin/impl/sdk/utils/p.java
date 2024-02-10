package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.d.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.facebook.AccessToken;

public final class p {
    private final m a;
    private String b;
    private final String c;
    private final String d;

    public p(m mVar) {
        this.a = mVar;
        this.c = a(d.g, (String) e.b(d.f, null, mVar.L()));
        this.d = a(d.h, (String) mVar.a(b.V));
        a(d());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.applovin.impl.sdk.d.d, com.applovin.impl.sdk.d.d<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(com.applovin.impl.sdk.d.d<java.lang.String> r3, java.lang.String r4) {
        /*
            r2 = this;
            com.applovin.impl.sdk.m r0 = r2.a
            android.content.Context r0 = r0.L()
            r1 = 0
            java.lang.Object r0 = com.applovin.impl.sdk.d.e.b(r3, r1, (android.content.Context) r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)
            if (r1 == 0) goto L_0x0014
            return r0
        L_0x0014:
            boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r4)
            if (r0 == 0) goto L_0x001b
            goto L_0x0029
        L_0x001b:
            java.util.UUID r4 = java.util.UUID.randomUUID()
            java.lang.String r4 = r4.toString()
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r4 = r4.toLowerCase(r0)
        L_0x0029:
            com.applovin.impl.sdk.m r0 = r2.a
            android.content.Context r0 = r0.L()
            com.applovin.impl.sdk.d.e.a(r3, r4, (android.content.Context) r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.p.a(com.applovin.impl.sdk.d.d, java.lang.String):java.lang.String");
    }

    public static String a(m mVar) {
        String str = (String) mVar.a(d.i);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String valueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
        mVar.a(d.i, valueOf);
        return valueOf;
    }

    private String d() {
        if (!((Boolean) this.a.a(b.dB)).booleanValue()) {
            this.a.b(d.e);
        }
        String str = (String) this.a.a(d.e);
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        if (u.a()) {
            u A = this.a.A();
            A.b("AppLovinSdk", "Using identifier (" + str + ") from previous session");
        }
        return str;
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        if (((Boolean) this.a.a(b.dB)).booleanValue()) {
            this.a.a(d.e, str);
        }
        this.b = str;
        Bundle bundle = new Bundle(2);
        bundle.putString(AccessToken.USER_ID_KEY, StringUtils.emptyIfNull(str));
        bundle.putString("applovin_random_token", c());
        this.a.ag().a(bundle, "user_info");
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }
}
