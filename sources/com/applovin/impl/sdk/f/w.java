package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.c.c;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.NativeProtocol;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import org.json.JSONObject;

public abstract class w extends y {
    protected w(String str, m mVar) {
        super(str, mVar);
    }

    private JSONObject a(c cVar) {
        JSONObject i = i();
        JsonUtils.putString(i, IronSourceConstants.EVENTS_RESULT, cVar.b());
        Map<String, String> a = cVar.a();
        if (a != null) {
            JsonUtils.putJSONObject(i, NativeProtocol.WEB_DIALOG_PARAMS, new JSONObject(a));
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public abstract c b();

    /* access modifiers changed from: protected */
    public abstract void b(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public abstract void c();

    /* access modifiers changed from: protected */
    public int h() {
        return ((Integer) this.b.a(b.bv)).intValue();
    }

    public void run() {
        c b = b();
        if (b != null) {
            if (u.a()) {
                a("Reporting pending reward: " + b + "...");
            }
            a(a(b), new b.c<JSONObject>() {
                public void a(int i, String str, JSONObject jSONObject) {
                    w.this.a(i);
                }

                public void a(JSONObject jSONObject, int i) {
                    w.this.b(jSONObject);
                }
            });
            return;
        }
        if (u.a()) {
            d("Pending reward not found");
        }
        c();
    }
}
