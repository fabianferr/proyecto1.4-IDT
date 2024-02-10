package com.bykv.vk.openvk.component.video.api.c;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: VideoUrlModel */
public class c implements Serializable {
    public String a;
    public int b;
    public final HashMap<String, Object> c = new HashMap<>();
    public int d;
    private b e;
    private b f;
    private String g;
    private int h = 204800;
    private int i = 0;
    private int j = 0;
    private String k;
    private int l;
    private int m;
    private String n;
    private long o;
    private boolean p;
    private boolean q;
    private int r = 0;
    private int s = 0;
    private int t = 10000;
    private int u = 10000;
    private int v = 10000;
    private int w = 0;
    private JSONObject x = new JSONObject();

    public c(String str, b bVar, b bVar2, int i2, int i3) {
        this.g = str;
        this.e = bVar;
        this.f = bVar2;
        this.r = i2;
        this.s = i3;
    }

    public int a() {
        return this.x.optInt("pitaya_cache_size", 0);
    }

    public String b() {
        return this.g;
    }

    public void a(String str) {
        this.g = str;
    }

    public int c() {
        if (k()) {
            return this.f.o();
        }
        b bVar = this.e;
        if (bVar != null) {
            return bVar.o();
        }
        return 0;
    }

    public boolean d() {
        return this.q;
    }

    public void b(String str) {
        this.k = str;
    }

    public int e() {
        return this.l;
    }

    public void a(int i2) {
        this.l = i2;
    }

    public int f() {
        return this.m;
    }

    public void b(int i2) {
        this.m = i2;
    }

    public void c(String str) {
        this.n = str;
    }

    public long g() {
        return this.o;
    }

    public void a(long j2) {
        this.o = j2;
    }

    public boolean h() {
        return this.p;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public long i() {
        if (k()) {
            return this.f.e();
        }
        b bVar = this.e;
        if (bVar != null) {
            return bVar.e();
        }
        return 0;
    }

    public boolean j() {
        if (k()) {
            return this.f.v();
        }
        b bVar = this.e;
        if (bVar != null) {
            return bVar.v();
        }
        return true;
    }

    public void d(String str) {
        this.a = str;
    }

    public void c(int i2) {
        this.b = i2;
    }

    public boolean k() {
        b bVar;
        if (this.s == 1 && (bVar = this.f) != null && !TextUtils.isEmpty(bVar.k())) {
            if (com.bykv.vk.openvk.component.video.api.c.f() == 2) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
            } else if (this.r == 1) {
                return true;
            }
        }
        return false;
    }

    public float l() {
        if (k()) {
            return this.f.h();
        }
        b bVar = this.e;
        if (bVar != null) {
            return bVar.h();
        }
        return -1.0f;
    }

    public String m() {
        if (k()) {
            return this.f.k();
        }
        b bVar = this.e;
        if (bVar != null) {
            return bVar.k();
        }
        return null;
    }

    public String n() {
        if (k()) {
            return this.f.n();
        }
        b bVar = this.e;
        if (bVar != null) {
            return bVar.n();
        }
        return null;
    }

    public int o() {
        return this.r;
    }

    public synchronized void a(String str, Object obj) {
        this.c.put(str, obj);
    }

    public synchronized Object e(String str) {
        return this.c.get(str);
    }

    public int p() {
        return this.t;
    }

    public void d(int i2) {
        this.t = i2;
    }

    public int q() {
        return this.u;
    }

    public void e(int i2) {
        this.u = i2;
    }

    public int r() {
        return this.v;
    }

    public void f(int i2) {
        this.v = i2;
    }

    public int s() {
        return this.w;
    }

    public void g(int i2) {
        this.w = i2;
    }

    public b t() {
        return this.e;
    }

    public b u() {
        return this.f;
    }
}
