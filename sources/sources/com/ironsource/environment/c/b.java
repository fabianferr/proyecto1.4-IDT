package com.ironsource.environment.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.environment.a;
import com.ironsource.environment.c;
import com.ironsource.environment.h;
import com.ironsource.environment.k;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class b {
    final ConcurrentHashMap<String, Object> a;
    final AtomicBoolean b;
    private final AtomicBoolean c;

    static class a {
        static volatile b a = new b((byte) 0);
    }

    private b() {
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.a = new ConcurrentHashMap<>();
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    private void a(String str) {
        try {
            this.a.remove(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean b(String str) {
        try {
            return this.a.containsKey(str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void c(Context context) {
        if (context != null) {
            d(context);
            String B = h.B(context);
            if (!TextUtils.isEmpty(B)) {
                a("asid", B);
            } else if (b("asid")) {
                a("asid");
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                a("lang", language.toUpperCase());
            }
            String c2 = h.c();
            if (!TextUtils.isEmpty(c2)) {
                a("tz", c2);
            }
            String a2 = com.ironsource.d.a.a(context);
            if (!TextUtils.isEmpty(a2) && !a2.equals("none")) {
                a("connt", a2);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                a("vpn", Boolean.valueOf(com.ironsource.d.a.c(context)));
            }
            String j = h.j(context);
            if (!TextUtils.isEmpty(j)) {
                a("icc", j);
            }
            a("vol", Float.valueOf(h.l(context)));
            a("dfs", String.valueOf(h.p()));
            a("scrnw", Integer.valueOf(h.k()));
            a("scrnh", Integer.valueOf(h.l()));
            a("ltime", String.valueOf(h.a()));
            a("tzoff", String.valueOf(h.b()));
            a(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, Integer.valueOf(a.AnonymousClass1.c(context)));
            a(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC, Integer.valueOf(a.AnonymousClass1.d(context)));
            a("sdcrd", Boolean.valueOf(h.d()));
            a("chrg", Boolean.valueOf(h.e(context)));
            a("chrgt", Integer.valueOf(h.f(context)));
            a("apm", Boolean.valueOf(h.g(context)));
            a("owp", Boolean.valueOf(h.h(context)));
            a("rt", Boolean.valueOf(h.j()));
            a("sscl", String.valueOf(h.o()));
            a("bat", Integer.valueOf(h.v(context)));
            a("lpm", Boolean.valueOf(h.w(context)));
            a("apor", h.n(context));
            a("ua", h.q());
            int E = h.E(context);
            if (E >= 0) {
                a("tca", Integer.valueOf(E));
            }
            String F = h.F(context);
            if (F != null) {
                a("tcs", F);
            }
        }
    }

    private void d(final Context context) {
        if (!this.b.get()) {
            try {
                this.b.set(true);
                IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new Runnable() {
                    public final void run() {
                        try {
                            b bVar = b.this;
                            Context context = context;
                            if (context != null) {
                                String C = h.C(context);
                                if (!TextUtils.isEmpty(C)) {
                                    bVar.a("gaid", C);
                                }
                                String D = h.D(context);
                                if (!TextUtils.isEmpty(D)) {
                                    bVar.a("lat", Boolean.valueOf(Boolean.parseBoolean(D)));
                                }
                            }
                        } catch (Exception unused) {
                        }
                        b.this.b.set(false);
                    }
                });
            } catch (Exception unused) {
                this.b.set(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(Context context) {
        c(context);
        return new JSONObject(d.a(this.a));
    }

    /* access modifiers changed from: package-private */
    public void a(String str, Object obj) {
        if (str != null && obj != null) {
            try {
                if (obj instanceof Boolean) {
                    obj = Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                }
                this.a.put(str, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b(Context context) {
        if (context != null) {
            try {
                if (!this.c.getAndSet(true)) {
                    a(JsonStorageKeyNames.AUID_ID_KEY, h.y(context));
                    a("model", h.g());
                    a("make", h.h());
                    a("os", h.i());
                    String e = h.e();
                    if (e != null) {
                        a("osv", e.replaceAll("[^0-9/.]", ""));
                        a("osvf", e);
                    }
                    a("apilvl", String.valueOf(h.f()));
                    String i = h.i(context);
                    if (!TextUtils.isEmpty(i)) {
                        a("carrier", i);
                    }
                    String d = c.d(context);
                    if (!TextUtils.isEmpty(d)) {
                        a("instlr", d);
                    }
                    String A = h.A(context);
                    if (!TextUtils.isEmpty(A)) {
                        a("dt", A);
                    }
                    a("bid", context.getPackageName());
                    a("mem", String.valueOf(h.d(context)));
                    a("tkv", MBridgeConstans.NATIVE_VIDEO_VERSION);
                    a("tsu", Long.valueOf(c.b(context)));
                    a("tai", Long.valueOf(c.a(context)));
                    a("apv", c.c(context));
                    a("ptype", Integer.valueOf(a.AnonymousClass1.f(context)));
                    a("simop", a.AnonymousClass1.e(context));
                    a("stid", k.b(context));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        c(context);
    }
}
