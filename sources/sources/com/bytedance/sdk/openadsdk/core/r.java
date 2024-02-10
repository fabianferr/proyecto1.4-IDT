package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.q;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: RitInfo */
public class r {
    public static ConcurrentHashMap<Integer, r> a = new ConcurrentHashMap<>();
    private String b = "";
    private String c = "";
    private int d;
    private int e;
    private String f;

    public String a() {
        return this.f;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int e() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    private void f() {
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = 0;
    }

    public void a(q qVar) {
        if (qVar != null) {
            String bc = qVar.bc();
            if (!TextUtils.isEmpty(bc)) {
                this.f = bc;
            }
            String P = qVar.P();
            if (TextUtils.isEmpty(P) && qVar.at()) {
                P = qVar.au().i();
            }
            if (!TextUtils.isEmpty(P)) {
                String[] split = P.split("/");
                if (split.length >= 3) {
                    this.b = split[2];
                }
            }
            if (qVar.aa() != null && !TextUtils.isEmpty(qVar.aa().c())) {
                this.c = qVar.aa().c();
            }
        }
    }

    public static void b(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.ac())) {
            Integer valueOf = Integer.valueOf(qVar.aZ());
            if (valueOf.intValue() != 0) {
                if (a == null) {
                    a = new ConcurrentHashMap<>();
                }
                r rVar = a.containsKey(valueOf) ? a.get(valueOf) : null;
                if (rVar == null) {
                    rVar = new r();
                }
                String bc = qVar.bc();
                if (TextUtils.isEmpty(bc) || !bc.equals(rVar.a())) {
                    rVar.f();
                    rVar.a(qVar);
                    a.put(valueOf, rVar);
                }
            }
        }
    }

    public static void c(int i) {
        r rVar;
        if (i != 0) {
            if (a == null) {
                a = new ConcurrentHashMap<>();
            }
            if (a.containsKey(Integer.valueOf(i)) && (rVar = a.get(Integer.valueOf(i))) != null) {
                rVar.b(1);
            }
        }
    }

    public static void c(q qVar) {
        r rVar;
        if (qVar != null) {
            Integer valueOf = Integer.valueOf(qVar.aZ());
            if (valueOf.intValue() != 0) {
                if (a == null) {
                    a = new ConcurrentHashMap<>();
                }
                if (a.containsKey(valueOf) && (rVar = a.get(valueOf)) != null) {
                    rVar.a(1);
                }
            }
        }
    }
}
