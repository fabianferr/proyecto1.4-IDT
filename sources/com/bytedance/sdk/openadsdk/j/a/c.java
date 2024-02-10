package com.bytedance.sdk.openadsdk.j.a;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.b.a.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.j.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

/* compiled from: RequestMonitor */
public class c {
    public static String a = "response is null";
    public static int b = -10;
    private String c;
    private long d;
    private long e;
    private long f;
    private int g;
    private int h;
    private boolean i = false;
    private String j;
    private int k;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.c);
            jSONObject.put("duration", this.e);
            jSONObject.put("request_size", this.g);
            jSONObject.put("response_size", this.h);
            jSONObject.put(IronSourceConstants.EVENTS_RESULT, this.i ? 1 : 0);
            if (!this.i && !TextUtils.isEmpty(this.j)) {
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, this.j);
            }
            jSONObject.put("conn_type", ac.m(o.a()));
            jSONObject.put("timezone", ac.r());
            long j2 = this.f;
            if (j2 > 0) {
                jSONObject.put("net_duration", j2);
            }
            jSONObject.put("code", this.k);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public c a(String str) {
        this.c = str;
        return this;
    }

    public c b(String str) {
        byte[] bytes;
        if (!TextUtils.isEmpty(str) && (bytes = str.getBytes()) != null) {
            this.g = bytes.length;
        }
        return this;
    }

    public c a(m mVar) {
        if (mVar != null) {
            if (mVar.f == m.a.STRING_TYPE && !TextUtils.isEmpty(mVar.a())) {
                this.g = mVar.a().getBytes().length;
            }
            if (mVar.f == m.a.BYTE_ARRAY_TYPE && mVar.e != null) {
                this.g = mVar.e.length;
            }
        }
        return this;
    }

    public void a() {
        this.d = SystemClock.elapsedRealtime();
    }

    public c c(String str) {
        byte[] bytes;
        if (!TextUtils.isEmpty(str) && (bytes = str.getBytes()) != null) {
            this.h = bytes.length;
        }
        return this;
    }

    public c a(int i2) {
        this.k = i2;
        return this;
    }

    public void b() {
        this.f = SystemClock.elapsedRealtime() - this.d;
    }

    public c d(String str) {
        this.j = str;
        return this;
    }

    public c a(boolean z) {
        this.i = z;
        return this;
    }

    public void c() {
        this.e = SystemClock.elapsedRealtime() - this.d;
        b.a(this);
    }
}
