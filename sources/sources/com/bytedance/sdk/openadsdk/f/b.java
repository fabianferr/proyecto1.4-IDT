package com.bytedance.sdk.openadsdk.f;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.openadsdk.b.b.a;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ImageLoaderLogListenerWrapper */
public class b<T> implements o<T> {
    private final long a = SystemClock.elapsedRealtime();
    /* access modifiers changed from: private */
    public final String b;
    private final o<T> c;
    private final q d;

    public b(q qVar, String str, o<T> oVar) {
        this.c = oVar;
        this.d = qVar;
        this.b = str;
    }

    public void a(k<T> kVar) {
        o<T> oVar = this.c;
        k<T> kVar2 = kVar;
        if (oVar != null) {
            oVar.a(kVar2);
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime() - this.a;
        String a2 = ac.a(this.d);
        if (!TextUtils.isEmpty(a2)) {
            final int f = kVar.f() / 1024;
            boolean e = kVar.e();
            long currentTimeMillis = System.currentTimeMillis();
            q qVar = this.d;
            final int i = e ? 1 : 0;
            c.a(currentTimeMillis, qVar, a2, "load_image_success", (JSONObject) null, (g) null, (a) new a() {
                public void a(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("duration", elapsedRealtime);
                    jSONObject2.put("url", b.this.b);
                    jSONObject2.put("preload_size", f);
                    jSONObject2.put("local_cache", i);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", elapsedRealtime);
                }
            });
        }
    }

    public void a(int i, String str, Throwable th) {
        o<T> oVar = this.c;
        int i2 = i;
        String str2 = str;
        if (oVar != null) {
            oVar.a(i2, str2, th);
        }
        q qVar = this.d;
        if (qVar != null) {
            String a2 = ac.a(qVar);
            if (!TextUtils.isEmpty(a2)) {
                final long elapsedRealtime = SystemClock.elapsedRealtime() - this.a;
                final int i3 = i;
                final String str3 = str;
                c.a(System.currentTimeMillis(), this.d, a2, "load_image_error", (JSONObject) null, (g) null, (a) new a() {
                    public void a(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i3);
                        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str3);
                        jSONObject2.put("duration", elapsedRealtime);
                        jSONObject2.put("url", b.this.b);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        jSONObject.put("duration", elapsedRealtime);
                    }
                });
            }
        }
    }
}
