package com.bytedance.sdk.component.d.d;

import com.bytedance.sdk.component.d.b;
import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.d.c.f;
import com.bytedance.sdk.component.d.d;

/* compiled from: NetVisitor */
public class k extends a {
    public String a() {
        return "net_request";
    }

    public void a(final c cVar) {
        final f r = cVar.r();
        d c = r.c();
        cVar.a(false);
        try {
            com.bytedance.sdk.component.d.f a = c.a(new com.bytedance.sdk.component.d.b.c(cVar.a(), cVar.l(), cVar.m()));
            int b = a.b();
            cVar.a(a.a());
            if (a.b() == 200) {
                final byte[] bArr = (byte[]) a.c();
                cVar.a((i) new b(bArr, a));
                r.e().submit(new Runnable() {
                    public void run() {
                        String i = cVar.i();
                        b s = cVar.s();
                        if (s.c()) {
                            r.b(cVar.s()).a(i, bArr);
                        }
                        if (s.d()) {
                            r.c(cVar.s()).a(i, bArr);
                        }
                    }
                });
                return;
            }
            r.g().a(String.valueOf(a));
            Object c2 = a.c();
            a(b, a.d(), c2 instanceof Throwable ? (Throwable) c2 : null, cVar);
        } catch (Throwable th) {
            a(1004, "net request failed!", th, cVar);
        }
    }

    private void a(int i, String str, Throwable th, c cVar) {
        cVar.a((i) new h(i, str, th));
    }
}
