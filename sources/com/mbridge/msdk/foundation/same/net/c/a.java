package com.mbridge.msdk.foundation.same.net.c;

import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: CommonStringResponseHandler */
public abstract class a extends f<String> {
    private static final String a = "a";

    public abstract void a(String str);

    public abstract void b(String str);

    public void onSuccess(l<String> lVar) {
        if (lVar != null) {
            a((String) lVar.a);
        }
    }

    public void onError(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        String str = a;
        aa.d(str, "errorCode = " + aVar.a);
        b(com.mbridge.msdk.foundation.same.net.g.a.a(aVar));
    }
}
