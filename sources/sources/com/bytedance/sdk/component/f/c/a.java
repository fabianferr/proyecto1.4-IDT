package com.bytedance.sdk.component.f.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.a;
import com.bytedance.sdk.component.f.b.c;
import com.bytedance.sdk.component.f.d.b;
import com.bytedance.sdk.component.f.d.e;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.x;
import com.facebook.share.internal.ShareConstants;
import com.umlaut.crowd.CCS;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: AppConfig */
public class a implements x.a {
    private static boolean h;
    private static ThreadPoolExecutor i;
    final x a = com.bytedance.sdk.component.g.a.a.a().a((x.a) this, "tt-net");
    private final boolean b;
    private volatile boolean c = false;
    private boolean d = true;
    private boolean e = false;
    private long f = 0;
    /* access modifiers changed from: private */
    public long g = 0;
    /* access modifiers changed from: private */
    public AtomicBoolean j = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final Context k;
    private volatile boolean l = false;
    private com.bytedance.sdk.component.f.a m;
    private int n;

    public a(Context context, int i2) {
        this.k = context;
        this.b = q.a(context);
        this.n = i2;
    }

    public void a() {
        a(false);
    }

    public synchronized void a(boolean z) {
        if (this.b) {
            d(z);
        } else if (this.f <= 0) {
            try {
                g().execute(new Runnable() {
                    public void run() {
                        a.this.b();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(boolean z) {
        h = z;
    }

    public static void a(Context context, int i2) {
        a a2;
        if (!h || (a2 = g.a().a(i2, context)) == null) {
            return;
        }
        if (q.a(context)) {
            a2.a(true);
        } else {
            a2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        if (System.currentTimeMillis() - this.f > CCS.a) {
            this.f = System.currentTimeMillis();
            try {
                if (g.a().a(this.n).h() != null) {
                    g.a().a(this.n).h().b();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void d(boolean z) {
        if (!this.e) {
            if (this.d) {
                this.d = false;
                this.f = 0;
                this.g = 0;
            }
            long j2 = z ? 360000 : 43200000;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f <= j2) {
                return;
            }
            if (currentTimeMillis - this.g > 120000 || !this.l) {
                c();
            }
        }
    }

    public boolean c() {
        b.b("TNCManager", "doRefresh: updating state " + this.j.get());
        g().execute(new Runnable() {
            public void run() {
                boolean a2 = e.a(a.this.k);
                if (a2) {
                    long unused = a.this.g = System.currentTimeMillis();
                    if (!a.this.j.compareAndSet(false, true)) {
                        b.b("TNCManager", "doRefresh, already running");
                    } else {
                        a.this.c(a2);
                    }
                }
            }
        });
        return true;
    }

    public void a(Message message) {
        int i2 = message.what;
        if (i2 == 101) {
            this.e = false;
            this.f = System.currentTimeMillis();
            b.b("TNCManager", "doRefresh, succ");
            if (this.d) {
                a();
            }
            this.j.set(false);
        } else if (i2 == 102) {
            this.e = false;
            if (this.d) {
                a();
            }
            b.b("TNCManager", "doRefresh, error");
            this.j.set(false);
        }
    }

    public synchronized void d() {
        if (!this.l) {
            this.l = true;
            long j2 = this.k.getSharedPreferences("ss_app_config", 0).getLong("last_refresh_time", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (j2 > currentTimeMillis) {
                j2 = currentTimeMillis;
            }
            this.f = j2;
            try {
                if (g.a().a(this.n).h() != null) {
                    g.a().a(this.n).h().a();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void e() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                if (this.b) {
                    d();
                } else {
                    b();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z) {
        b.b("TNCManager", "doRefresh, actual request");
        d();
        this.e = true;
        if (!z) {
            this.a.sendEmptyMessage(102);
            return;
        }
        try {
            h();
        } catch (Exception unused) {
            this.j.set(false);
        }
    }

    public String[] f() {
        String[] f2 = g.a().a(this.n).d() != null ? g.a().a(this.n).d().f() : null;
        return (f2 == null || f2.length <= 0) ? new String[0] : f2;
    }

    /* access modifiers changed from: private */
    public boolean a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor edit = this.k.getSharedPreferences("ss_app_config", 0).edit();
            edit.putLong("last_refresh_time", System.currentTimeMillis());
            edit.apply();
        }
        if (g.a().a(this.n).h() == null) {
            return true;
        }
        g.a().a(this.n).h().a(jSONObject2);
        return true;
    }

    private boolean h() {
        String[] f2 = f();
        if (!(f2 == null || f2.length == 0)) {
            a(0);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void a(final int i2) {
        String[] f2 = f();
        if (f2 == null || f2.length <= i2) {
            b(102);
            return;
        }
        String str = f2[i2];
        if (TextUtils.isEmpty(str)) {
            b(102);
            return;
        }
        try {
            String a2 = a(str);
            if (TextUtils.isEmpty(a2)) {
                b(102);
                return;
            }
            com.bytedance.sdk.component.f.b.b c2 = i().c();
            c2.a(a2);
            a(c2);
            c2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                public void a(c cVar, com.bytedance.sdk.component.f.b bVar) {
                    JSONObject jSONObject;
                    if (bVar == null || !bVar.f()) {
                        a.this.a(i2 + 1);
                        return;
                    }
                    String str = null;
                    try {
                        jSONObject = new JSONObject(bVar.d());
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        a.this.a(i2 + 1);
                        return;
                    }
                    try {
                        str = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    } catch (Exception unused2) {
                    }
                    if (!"success".equals(str)) {
                        a.this.a(i2 + 1);
                        return;
                    }
                    try {
                        if (a.this.a((Object) jSONObject)) {
                            a.this.b(101);
                        } else {
                            a.this.a(i2 + 1);
                        }
                    } catch (Exception unused3) {
                    }
                }

                public void a(c cVar, IOException iOException) {
                    a.this.a(i2 + 1);
                }
            });
        } catch (Throwable th) {
            b.b("AppConfig", "try app config exception: " + th);
        }
    }

    private com.bytedance.sdk.component.f.a i() {
        if (this.m == null) {
            this.m = new a.C0054a().a(10, TimeUnit.SECONDS).b(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).a();
        }
        return this.m;
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        x xVar = this.a;
        if (xVar != null) {
            xVar.sendEmptyMessage(i2);
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "https://" + str + "/get_domains/v4/";
    }

    private void a(com.bytedance.sdk.component.f.b.b bVar) {
        String str;
        if (bVar != null) {
            Address a2 = g.a().a(this.n).d() != null ? g.a().a(this.n).d().a(this.k) : null;
            if (a2 != null && a2.hasLatitude() && a2.hasLongitude()) {
                bVar.a("latitude", a2.getLatitude() + "");
                bVar.a("longitude", a2.getLongitude() + "");
                String locality = a2.getLocality();
                if (!TextUtils.isEmpty(locality)) {
                    bVar.a("city", Uri.encode(locality));
                }
            }
            if (this.c) {
                bVar.a("force", "1");
            }
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    str = Build.CPU_ABI;
                } else {
                    str = Build.SUPPORTED_ABIS[0];
                }
                bVar.a("abi", str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (g.a().a(this.n).d() != null) {
                bVar.a("aid", g.a().a(this.n).d().a() + "");
                bVar.a("device_platform", g.a().a(this.n).d().c());
                bVar.a("channel", g.a().a(this.n).d().b());
                bVar.a("version_code", g.a().a(this.n).d().d() + "");
                bVar.a("custom_info_1", g.a().a(this.n).d().e());
            }
        }
    }

    public static ThreadPoolExecutor g() {
        if (i == null) {
            synchronized (a.class) {
                if (i == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    i = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return i;
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor) {
        i = threadPoolExecutor;
    }
}
