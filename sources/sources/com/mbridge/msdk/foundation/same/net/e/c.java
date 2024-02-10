package com.mbridge.msdk.foundation.same.net.e;

import com.mbridge.msdk.foundation.same.net.b.a;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.g.b;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: JsonArrayRequest */
public class c extends e<JSONArray> {
    private static final String c = "c";

    public c(int i, String str, String str2, e<JSONArray> eVar) {
        super(i, str, str2, eVar);
    }

    /* access modifiers changed from: protected */
    public final l<JSONArray> a(com.mbridge.msdk.foundation.same.net.f.c cVar) {
        try {
            return l.a(new JSONArray(new String(cVar.b, b.a(cVar.d))), cVar);
        } catch (UnsupportedEncodingException e) {
            aa.d(c, e.getMessage());
            return l.a(new a(8, cVar));
        } catch (JSONException e2) {
            aa.d(c, e2.getMessage());
            return l.a(new a(8, cVar));
        }
    }
}
