package com.mbridge.msdk.foundation.same.report;

import com.mbridge.msdk.e.a.a.e;
import com.mbridge.msdk.e.a.k;
import com.mbridge.msdk.e.a.o;
import com.mbridge.msdk.e.v;
import java.io.UnsupportedEncodingException;

/* compiled from: StringReportResponseHandler */
public final class u extends v {
    /* access modifiers changed from: protected */
    public final o<String> a(k kVar) {
        String str;
        try {
            str = new String(kVar.b, e.a(kVar.c, "ISO-8859-1"));
        } catch (UnsupportedEncodingException unused) {
            str = new String(kVar.b);
        }
        return o.a(str, e.a(kVar));
    }
}
