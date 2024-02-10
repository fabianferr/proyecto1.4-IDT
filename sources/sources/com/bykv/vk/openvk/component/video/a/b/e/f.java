package com.bykv.vk.openvk.component.video.a.b.e;

import com.bykv.vk.openvk.component.video.a.b.i;
import com.bytedance.sdk.component.b.a.n;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VolleyResponseWrapper */
public class f extends a {
    private n c;

    public f(n nVar, e eVar) {
        com.bytedance.sdk.component.b.a.f g;
        this.c = nVar;
        this.a = new ArrayList();
        if (!(nVar == null || (g = nVar.g()) == null)) {
            for (int i = 0; i < g.a(); i++) {
                this.a.add(new i.b(g.a(i), g.b(i)));
            }
        }
        this.b = eVar;
    }

    public int a() {
        return this.c.c();
    }

    public boolean b() {
        return this.c.c() >= 200 && this.c.c() < 300;
    }

    public String a(String str, String str2) {
        return a(str) != null ? a(str).b : str2;
    }

    public List<i.b> c() {
        return this.a;
    }

    public InputStream d() {
        return this.c.f().c();
    }

    public String e() {
        n nVar = this.c;
        return (nVar == null || nVar.h() == null) ? "http/1.1" : this.c.h().toString();
    }

    public String f() {
        return a(this.c.c());
    }
}
