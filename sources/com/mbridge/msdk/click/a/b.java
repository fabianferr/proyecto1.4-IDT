package com.mbridge.msdk.click.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;

/* compiled from: RetryUrlRecordData */
public final class b {
    public static int a = 0;
    public static int b = 1;
    private String c;
    private int d;
    private HashSet<String> e = new HashSet<>();
    private long f = System.currentTimeMillis();
    private CampaignEx g;
    private String h;
    private int i;
    private boolean j;
    private boolean k;
    private int l;

    public final boolean a() {
        return this.j;
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final boolean b() {
        return this.k;
    }

    public final void b(boolean z) {
        this.k = z;
    }

    public final int c() {
        return this.l;
    }

    public final void a(int i2) {
        this.l = i2;
    }

    public final int d() {
        return this.i;
    }

    public final void b(int i2) {
        this.i = i2;
    }

    public b(String str, String str2) {
        this.c = str;
        b(str2);
    }

    public final String e() {
        return this.h;
    }

    public final void a(String str) {
        this.h = str;
    }

    public final CampaignEx f() {
        return this.g;
    }

    public final void a(CampaignEx campaignEx) {
        this.g = campaignEx;
    }

    public final String g() {
        return this.c;
    }

    public final int h() {
        return this.d;
    }

    public final HashSet<String> i() {
        return this.e;
    }

    public final void b(String str) {
        this.d++;
        this.e.add(str);
    }

    public final long j() {
        return this.f;
    }
}
