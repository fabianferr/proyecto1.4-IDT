package com.mbridge.msdk.foundation.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.u;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CandidateEntity */
public final class b {
    private String a;
    private String b;
    private String c;
    private CopyOnWriteArrayList<CampaignEx> d;
    private long e;
    private double f;
    private int g;
    private int h;
    private long i;

    public final long a() {
        return this.i;
    }

    public final void a(long j) {
        this.i = j;
    }

    public final String b() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String c() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final String d() {
        return this.c;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final CopyOnWriteArrayList<CampaignEx> e() {
        return this.d;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.d = copyOnWriteArrayList;
    }

    public final long f() {
        return this.e;
    }

    public final void b(long j) {
        this.e = j;
    }

    public final double g() {
        return this.f;
    }

    public final void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            String b2 = u.b(str);
            if (!TextUtils.isEmpty(b2)) {
                try {
                    double parseDouble = Double.parseDouble(b2);
                    if (parseDouble > 0.0d) {
                        this.f = parseDouble;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final int h() {
        return this.g;
    }

    public final void a(int i2) {
        this.g = i2;
    }

    public final int i() {
        return this.h;
    }

    public final void b(int i2) {
        this.h = i2;
    }
}
