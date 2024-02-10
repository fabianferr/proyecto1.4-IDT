package com.mbridge.msdk.foundation.same.net.e;

import com.mbridge.msdk.foundation.same.net.b.a;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.f.c;
import com.mbridge.msdk.foundation.same.net.g.b;
import com.mbridge.msdk.foundation.same.net.j;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.UnsupportedEncodingException;

/* compiled from: StringRequest */
public class f extends j<String> {
    private static final String c = "f";
    private String d;

    public f(int i, String str, String str2, e<String> eVar) {
        super(i, str, eVar);
        this.d = str2;
    }

    public final byte[] f() {
        try {
            String str = this.d;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            String str2 = c;
            aa.d(str2, "Unsupported Encoding while trying to get the bytes of " + this.d + " using utf-8");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final l<String> a(c cVar) {
        try {
            return l.a(new String(cVar.b, b.a(cVar.d)), cVar);
        } catch (UnsupportedEncodingException e) {
            aa.d(c, e.getMessage());
            return l.a(new a(8, cVar));
        }
    }
}
