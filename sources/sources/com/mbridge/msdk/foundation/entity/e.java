package com.mbridge.msdk.foundation.entity;

import java.util.Map;

/* compiled from: DescExceptionData */
public final class e {
    private String a;
    private int b;
    private String c;
    private int d;
    private int e;
    private String f;
    private boolean g;
    private Map<String, String> h;

    public final boolean a() {
        return this.g;
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final int b() {
        return this.e;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final String c() {
        return this.f;
    }

    public final void a(String str) {
        this.f = str;
    }

    public e(int i, String str, Map<String, String> map) {
        this.e = -1;
        this.g = false;
        this.b = i;
        this.c = str;
        this.h = map;
        h();
    }

    public e(int i, String str, boolean z) {
        this.b = 0;
        this.e = -1;
        this.g = false;
        if (z) {
            if (i == 200) {
                this.b = 4;
            } else if (i == 201) {
                this.b = 7;
            } else if (i == 203) {
                this.b = 6;
            } else if (i == 205) {
                this.b = 5;
            }
        }
        this.c = str;
        h();
    }

    private void h() {
        try {
            switch (this.b) {
                case 0:
                    this.a = "v3 params invalid";
                    return;
                case 1:
                    this.a = "v3 request error";
                    return;
                case 2:
                    this.a = "v3 time out";
                    return;
                case 3:
                    this.a = "v3 response error";
                    return;
                case 4:
                    this.a = "video download error";
                    return;
                case 5:
                    this.a = "big template download error";
                    return;
                case 6:
                    this.a = "template download error";
                    return;
                case 7:
                    this.a = "endcard template download error";
                    return;
                case 8:
                    this.a = "big template render error";
                    return;
                case 9:
                    this.a = "template render error";
                    return;
                case 10:
                    this.a = " load time out error";
                    return;
                case 11:
                    this.a = " no fill";
                    return;
                case 15:
                    this.a = " isready false error";
                    return;
                case 16:
                    this.a = "current unit is loading";
                    return;
                case 17:
                    this.a = "adn no offer fill";
                    return;
                case 18:
                    this.a = "app already install";
                    return;
                case 19:
                    this.a = "ad over cap ";
                    return;
                case 20:
                    this.a = "load exception";
                    return;
                case 21:
                    this.a = "candidate failed";
                    return;
                default:
                    return;
            }
        } catch (Exception unused) {
            this.a = " unknown error";
        }
    }

    public e(int i, String str) {
        this.e = -1;
        this.g = false;
        this.b = i;
        this.c = str;
        h();
    }

    public final int d() {
        return this.b;
    }

    public final void b(int i) {
        this.b = i;
    }

    public final String e() {
        return this.c;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final int f() {
        return this.d;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final Map<String, String> g() {
        return this.h;
    }
}
