package com.bytedance.sdk.openadsdk.core.e;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MSSdkImpl */
class a {
    /* access modifiers changed from: private */
    public PglSSManager a;
    private volatile boolean b;
    private volatile boolean c = true;

    public a() {
        a();
    }

    public synchronized void a() {
        if (!this.b) {
            try {
                Context a2 = o.a();
                String d = h.b().d();
                if (TextUtils.isEmpty(d)) {
                    d = h.a("app_id", Long.MAX_VALUE);
                }
                if (!TextUtils.isEmpty(d)) {
                    String a3 = j.a(a2);
                    PglSSManager.init(a2, PglSSConfig.builder().setAppId(d).setOVRegionType(0).build());
                    e();
                    PglSSManager pglSSManager = this.a;
                    if (pglSSManager != null) {
                        pglSSManager.setDeviceId(a3);
                    }
                    l.c("mssdk", "init: success");
                    this.b = true;
                } else {
                    return;
                }
            } catch (Throwable th) {
                l.c("mssdk", "init: fail");
                l.b("MSSdkImpl", "appid is empty, initialization failed! or without the mssdk module", th);
                f();
                this.b = false;
            }
        }
        return;
    }

    public boolean b() {
        return this.b;
    }

    private boolean d() {
        if (!this.b && this.c) {
            a();
        }
        return this.b;
    }

    private void e() {
        if (this.a == null) {
            this.a = PglSSManager.getInstance();
        }
    }

    public void a(final String str) {
        if (d()) {
            e();
            if (this.a == null) {
                return;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                aa.b(new com.bytedance.sdk.component.g.h("updateDid") {
                    public void run() {
                        if (a.this.a != null) {
                            a.this.a.setDeviceId(str);
                        }
                    }
                });
            } else {
                this.a.setDeviceId(str);
            }
        }
    }

    public void b(String str) {
        if (d()) {
            e();
            PglSSManager pglSSManager = this.a;
            if (pglSSManager != null) {
                pglSSManager.reportNow(str);
            }
        }
    }

    public String c() {
        if (!d()) {
            return "";
        }
        e();
        PglSSManager pglSSManager = this.a;
        if (pglSSManager != null) {
            return pglSSManager.getToken();
        }
        return "";
    }

    public Map<String, String> a(String str, byte[] bArr) {
        Map<String, String> featureHash;
        if (!d() || (featureHash = this.a.getFeatureHash(str, bArr)) == null) {
            return new HashMap();
        }
        return featureHash;
    }

    private Class f() {
        Class<?> cls = null;
        try {
            cls = Class.forName("com.pgl.ssdk.ces.out.PglSSManager");
            this.c = true;
            l.c("mssdk", "class found");
            return cls;
        } catch (Throwable unused) {
            l.c("mssdk", "class not found ");
            this.c = false;
            return cls;
        }
    }
}
