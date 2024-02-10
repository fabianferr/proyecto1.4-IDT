package com.mbridge.msdk.foundation.same.net.e;

import com.mbridge.msdk.foundation.same.net.b.a;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.f.c;
import com.mbridge.msdk.foundation.same.net.g.b;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonObjectRequest */
public class d extends e<JSONObject> {
    private static final String c = "d";

    public d(int i, String str, String str2, e<JSONObject> eVar) {
        super(i, str, str2, eVar);
    }

    public d(int i, String str, String str2, e<JSONObject> eVar, boolean z) {
        super(i, str, str2, eVar, z);
    }

    /* access modifiers changed from: protected */
    public final l<JSONObject> a(c cVar) {
        try {
            String str = new String(cVar.b, b.a(cVar.d));
            if (cVar.a == 204) {
                return l.a(new JSONObject(), cVar);
            }
            return l.a(new JSONObject(str), cVar);
        } catch (UnsupportedEncodingException e) {
            aa.d(c, e.getMessage());
            return l.a(new a(8, cVar));
        } catch (JSONException e2) {
            aa.d(c, e2.getMessage());
            return l.a(new a(8, cVar));
        }
    }
}
