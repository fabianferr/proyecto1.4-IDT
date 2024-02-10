package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import com.mbridge.msdk.foundation.same.net.e.b;

/* compiled from: VolleyManager */
public final class o {
    private static o d;
    private k a;
    private k b;
    private b c;

    private o() {
    }

    public static void a(Context context) {
        if (d == null) {
            o oVar = new o();
            d = oVar;
            oVar.a = new k(context.getApplicationContext());
            d.c = new b(b(), 3);
        }
    }

    public static void b(j jVar) {
        b().a(jVar);
    }

    private static k b() {
        o oVar = d;
        if (oVar != null) {
            k kVar = oVar.a;
            if (kVar != null) {
                return kVar;
            }
            oVar.a = new k(com.mbridge.msdk.foundation.controller.b.d().g());
            return d.a;
        }
        o oVar2 = new o();
        d = oVar2;
        if (oVar2.a == null) {
            oVar2.a = new k(com.mbridge.msdk.foundation.controller.b.d().g());
        }
        return d.a;
    }

    public static b a() {
        o oVar = d;
        if (oVar != null) {
            b bVar = oVar.c;
            if (bVar != null) {
                return bVar;
            }
            oVar.c = new b(b(), 3);
            return d.c;
        }
        o oVar2 = new o();
        d = oVar2;
        if (oVar2.c == null) {
            oVar2.c = new b(b(), 3);
        }
        return d.c;
    }

    public static void a(j jVar) {
        o oVar = d;
        if (oVar == null) {
            o oVar2 = new o();
            d = oVar2;
            if (oVar2.b == null) {
                oVar2.b = new k(com.mbridge.msdk.foundation.controller.b.d().g(), (com.mbridge.msdk.foundation.same.net.stack.b) null);
            }
        } else if (oVar.b == null) {
            oVar.b = new k(com.mbridge.msdk.foundation.controller.b.d().g(), (com.mbridge.msdk.foundation.same.net.stack.b) null);
        }
        d.b.a(jVar);
    }
}
