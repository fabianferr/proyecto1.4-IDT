package com.ironsource.sdk.f;

import android.text.TextUtils;
import java.util.HashSet;

public class a {
    private boolean a = false;
    private HashSet<String> b = new HashSet<>();
    private String c;
    private String d;
    private boolean e = false;
    private int f;
    private boolean g = true;

    /* renamed from: com.ironsource.sdk.f.a$a  reason: collision with other inner class name */
    public static class C0120a {
        public String a;
        public String b;
        public String c;
    }

    public HashSet<String> a() {
        return this.b;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b.add(str);
        }
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void b(String str) {
        this.c = str;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.a;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public String d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }
}
