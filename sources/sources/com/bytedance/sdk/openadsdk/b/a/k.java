package com.bytedance.sdk.openadsdk.b.a;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.e.a.d.a;
import com.bytedance.sdk.component.e.a.e.c;
import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.e.a.g;
import com.bytedance.sdk.component.e.a.h;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.j.b;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: OverSeaLogDepend */
public class k implements f {
    private final String a = "[5509]";

    public a a(JSONObject jSONObject) {
        return null;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public String c() {
        return "[5509]";
    }

    public boolean d() {
        return true;
    }

    public int g() {
        return 1;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return true;
    }

    public h m() {
        return null;
    }

    public boolean a(Context context) {
        return o.a(context);
    }

    public String a(String str) {
        return com.bytedance.sdk.component.c.a.b(str, com.bytedance.sdk.openadsdk.core.a.a());
    }

    public String b(String str) {
        return com.bytedance.sdk.component.c.a.a(str, com.bytedance.sdk.openadsdk.core.a.a());
    }

    public String j() {
        return ac.c();
    }

    public c k() {
        return new g();
    }

    public Executor e() {
        return aa.c();
    }

    public Executor f() {
        return aa.g();
    }

    public g l() {
        g a2;
        synchronized (this) {
            a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(com.bytedance.sdk.openadsdk.core.o.a());
        }
        return a2;
    }

    public void a(boolean z, int i, String str, String str2, long j) {
        a.a(a.c, z, i, j);
        final boolean z2 = z;
        final String str3 = str2;
        final int i2 = i;
        final String str4 = str;
        b.a("track_link_result", false, (com.bytedance.sdk.openadsdk.j.a) new com.bytedance.sdk.openadsdk.j.a() {
            public com.bytedance.sdk.openadsdk.j.a.a getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", z2);
                jSONObject.put("url", str3);
                if (!z2) {
                    jSONObject.put("code", i2);
                    jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str4);
                }
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("track_link_result").b(jSONObject.toString());
            }
        });
    }

    public void a(boolean z) {
        a.a(a.f, z);
    }

    public boolean o() {
        return BinderPoolService.a;
    }

    public void n() {
        a.a(a.f);
    }
}
