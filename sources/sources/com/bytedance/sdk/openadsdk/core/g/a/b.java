package com.bytedance.sdk.openadsdk.core.g.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.g.b.c;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import org.json.JSONObject;

/* compiled from: VastXmlParser */
public abstract class b {
    public int a;
    protected final Context b;
    protected int c = 0;
    protected double d = 0.0d;
    public int e;
    public a f;

    /* compiled from: VastXmlParser */
    public static class a {
        public int a;
        public int b;
        public boolean c;
    }

    public abstract com.bytedance.sdk.openadsdk.core.g.a a(String str, List<c> list);

    public b(Context context, int i, int i2) {
        if (i2 > 0 && i > 0) {
            double d2 = (double) i;
            double d3 = (double) i2;
            Double.isNaN(d2);
            Double.isNaN(d3);
            this.d = d2 / d3;
        }
        float e2 = ad.e(context);
        if (e2 != 0.0f && i > 0) {
            this.c = (int) (((float) i) / e2);
        }
        this.b = context.getApplicationContext();
    }

    /* access modifiers changed from: protected */
    public void a(Exception exc, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", exc.getMessage());
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i);
            com.bytedance.sdk.openadsdk.j.b.a().a("load_vast", jSONObject);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            if (Integer.parseInt(str) < 2) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public String b(String str, List<c> list) {
        String str2;
        int i = this.a;
        if (i >= 5) {
            return null;
        }
        this.a = i + 1;
        if (str == null) {
            return null;
        }
        try {
            com.bytedance.sdk.component.f.b.b c2 = com.bytedance.sdk.openadsdk.k.c.a().b().c();
            c2.a(str);
            com.bytedance.sdk.component.f.b a2 = c2.a();
            str2 = a2.d();
            try {
                a2.a();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = null;
            a(e, 0);
            if (!list.isEmpty()) {
                c.b(list, a.WRAPPER_TIMEOUT, -1, (String) null);
            }
            return str2;
        }
        return str2;
    }
}
