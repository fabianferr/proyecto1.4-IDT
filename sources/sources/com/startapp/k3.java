package com.startapp;

import com.startapp.sdk.adsbase.remoteconfig.AnalyticsCategoryConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Sta */
public class k3 {
    public final double a;
    public final int b;
    public final int c;
    public final boolean d;
    public final long e;
    public final long f;
    public final List<m3> g;

    /* compiled from: Sta */
    public static class a {
        public double a = 1.0d;
        public int b;
        public int c;
        public boolean d;
        public String e;
        public String f;
        public List<m3> g;

        public double a() {
            return this.a;
        }

        public List<m3> b() {
            return this.g;
        }

        public String c() {
            return this.f;
        }

        public int d() {
            return this.b;
        }

        public int e() {
            return this.c;
        }

        public String f() {
            return this.e;
        }

        public boolean g() {
            return this.d;
        }

        public a a(m3 m3Var) {
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(m3Var);
            return this;
        }
    }

    public k3(a aVar) {
        this.a = aVar.a();
        this.b = aVar.d();
        this.c = aVar.e();
        this.d = aVar.g();
        this.e = Math.max(60000, k9.e(aVar.f()));
        this.f = Math.max(0, k9.e(aVar.c()));
        this.g = k9.b(aVar.b());
    }

    public static <T> T a(T t, T t2) {
        return t2 != null ? t2 : t;
    }

    public double a() {
        return this.a;
    }

    public List<m3> b() {
        return this.g;
    }

    public long c() {
        return this.f;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }

    public long f() {
        return this.e;
    }

    public boolean g() {
        return this.d;
    }

    public k3(k3 k3Var, AnalyticsCategoryConfig analyticsCategoryConfig) {
        this.a = ((Double) a(Double.valueOf(k3Var.a()), analyticsCategoryConfig.a())).doubleValue();
        this.b = ((Integer) a(Integer.valueOf(k3Var.d()), analyticsCategoryConfig.d())).intValue();
        this.c = ((Integer) a(Integer.valueOf(k3Var.e()), analyticsCategoryConfig.e())).intValue();
        this.d = ((Boolean) a(Boolean.valueOf(k3Var.g()), analyticsCategoryConfig.f())).booleanValue();
        this.e = analyticsCategoryConfig.g() == null ? k3Var.f() : Math.max(60000, k9.e(analyticsCategoryConfig.g()));
        this.f = analyticsCategoryConfig.c() == null ? k3Var.c() : Math.max(0, k9.e(analyticsCategoryConfig.c()));
        this.g = (List) a(k3Var.b(), m3.a(analyticsCategoryConfig.b()));
    }
}
