package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;

/* compiled from: MediationConfig */
public class g implements Comparable<g> {
    private final String a;
    private final String b;
    private final int c;
    private final int d;
    private String e;
    private final int f;
    private final int g;
    private final String h;

    public g(String str, String str2, int i, int i2, String str3, int i3, int i4, String str4) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
        this.e = str3;
        if (TextUtils.isEmpty(str3)) {
            this.e = "0";
        }
        this.f = i3;
        this.g = i4;
        this.h = str4;
    }

    public int a() {
        return this.f;
    }

    /* renamed from: a */
    public int compareTo(g gVar) {
        if (this.f < gVar.a()) {
            return -1;
        }
        return this.f == gVar.a() ? 0 : 1;
    }
}
