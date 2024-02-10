package com.teragence.library;

import android.os.Build;
import com.teragence.client.i;
import com.teragence.client.service.CoreInfo;
import com.teragence.client.service.k;
import com.teragence.library.h3;
import java.util.Map;

public class g3 implements h3 {
    /* access modifiers changed from: private */
    public static final String i = "g3";
    /* access modifiers changed from: private */
    public final w3 a;
    /* access modifiers changed from: private */
    public final m0 b;
    /* access modifiers changed from: private */
    public final f c;
    /* access modifiers changed from: private */
    public final e0 d;
    /* access modifiers changed from: private */
    public final m e;
    /* access modifiers changed from: private */
    public final v3 f;
    /* access modifiers changed from: private */
    public final b2 g;
    private final q1 h;

    class a extends com.teragence.client.a<k> {
        final /* synthetic */ h3.a a;

        a(h3.a aVar) {
            this.a = aVar;
        }

        public void a(k kVar) {
            k kVar2 = kVar;
            try {
                Map<String, Object> a2 = g3.this.g.a();
                g1 g1Var = new g1(new h1(g3.this.a.a(true, 5000)));
                h3.a aVar = this.a;
                String fVar = g3.this.c.toString();
                long c = g3.this.d.b().c();
                i b2 = g3.this.e.b();
                boolean d = g3.this.b.d();
                boolean g = g3.this.b();
                h3.a aVar2 = aVar;
                boolean z = d;
                boolean z2 = g;
                long j = c;
                i iVar = b2;
                l7 l7Var = new l7(kVar2.a, kVar2.b, kVar2.c, kVar2.d, kVar2.e);
                o7 o7Var = new o7(new n7("", "", (String) a2.remove("SSID"), "WiFi"), "", "", "", false, g1Var.a(), g1Var.b(), Integer.valueOf((String) a2.remove("dbmSignalStrength")).intValue());
                String str = Build.MANUFACTURER;
                String str2 = Build.MODEL;
                j7 j7Var = new j7(str, str2, "Android " + Build.VERSION.RELEASE, Build.VERSION.SDK_INT, CoreInfo.VERSION, Double.toString(g3.this.f.b()), g3.this.f.a());
                l3 l3Var = r7;
                l3 l3Var2 = new l3(fVar, j, iVar, z, z2, l7Var, o7Var, j7Var, new v7("", ""), o6.a(a2));
                aVar2.a((i3) l3Var);
            } catch (Exception e) {
                i.a(g3.i, "execute: ", e);
                this.a.a(e);
            }
        }
    }

    public g3(w3 w3Var, m0 m0Var, f fVar, e0 e0Var, m mVar, v3 v3Var, b2 b2Var, q1 q1Var) {
        this.a = w3Var;
        this.b = m0Var;
        this.c = fVar;
        this.d = e0Var;
        this.e = mVar;
        this.f = v3Var;
        this.g = b2Var;
        this.h = q1Var;
    }

    /* access modifiers changed from: private */
    public boolean b() {
        return System.currentTimeMillis() - this.b.b("WiFi") > this.e.b().d();
    }

    public void a(h3.a aVar) {
        this.h.a(new a(aVar), this.e.b().l());
    }
}
