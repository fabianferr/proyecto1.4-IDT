package com.bytedance.sdk.component.f.c;

import com.bytedance.sdk.component.b.a.h;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.a.n;
import java.io.IOException;

/* compiled from: TncHostInterceptor */
public class f implements h {
    private int a;

    public void a(int i) {
        this.a = i;
    }

    public n a(h.a aVar) throws IOException {
        IOException iOException;
        l a2 = aVar.a();
        if (g.a().a(this.a).b() != null) {
            g.a().a(this.a).b().e();
        }
        String gVar = a2.b().toString();
        String a3 = g.a().a(this.a).a(gVar);
        if (!gVar.equals(a3)) {
            a2 = a2.g().a(a3).b();
        }
        n nVar = null;
        try {
            iOException = null;
            nVar = aVar.a(a2);
        } catch (Exception e) {
            iOException = new IOException(e.getMessage());
            g.a().a(this.a).a(a2, e);
        }
        g.a().a(this.a).a(a2, nVar);
        if (iOException == null) {
            return nVar == null ? aVar.a(a2) : nVar;
        }
        throw iOException;
    }
}
