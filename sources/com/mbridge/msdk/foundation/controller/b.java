package com.mbridge.msdk.foundation.controller;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.d;
import com.mbridge.msdk.foundation.tools.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MBSDKContext */
public class b {
    public static final String a = "b";
    public static List<String> b = new ArrayList();
    public static HashMap<String, String> c = new HashMap<>();
    private static b d;
    /* access modifiers changed from: private */
    public Context e;
    /* access modifiers changed from: private */
    public String f;
    private String g;
    private String h;
    private int i = 0;
    private JSONObject j;
    private int k;
    private boolean l = false;
    private int m;
    private WeakReference<Context> n;
    private WeakReference<Activity> o;
    private JSONObject p = new JSONObject();
    private ConcurrentHashMap<String, String> q = new ConcurrentHashMap<>();
    private String r;
    private final d s = new d();

    /* compiled from: MBSDKContext */
    public interface a {
    }

    public final void a(String str) {
        try {
            if (this.q != null && !TextUtils.isEmpty(str)) {
                if (this.q.containsKey(str)) {
                    this.q.remove(str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final BitmapDrawable a(String str, int i2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.q) == null || !concurrentHashMap.containsKey(str) || !ac.a().a("w_m_r_l", true)) {
            return null;
        }
        String str2 = this.q.get(str);
        BitmapDrawable n2 = af.n(str2);
        q.a(str, i2, TextUtils.isEmpty(str2) ? 2 : 1, TextUtils.isEmpty(str2) ? "get watermark failed" : n2 != null ? "" : "str to bitmap failed", n2 == null ? 2 : 1, str2);
        return n2;
    }

    public final void a(String str, JSONObject jSONObject) {
        if (ac.a().a("w_m_r_l", true)) {
            try {
                if (this.p == null) {
                    this.p = jSONObject;
                } else if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.p.put(next, jSONObject.get(next));
                    }
                }
                if (this.p.has(MBridgeConstans.EXTRA_KEY_WM)) {
                    if (this.q == null) {
                        this.q = new ConcurrentHashMap<>();
                    }
                    this.q.put(str, this.p.getString(MBridgeConstans.EXTRA_KEY_WM));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final WeakReference<Activity> a() {
        return this.o;
    }

    public final void a(WeakReference<Activity> weakReference) {
        this.o = weakReference;
    }

    public final void a(int i2) {
        this.k = i2;
    }

    public final String b() {
        try {
            Context context = this.e;
            if (context != null) {
                return context.getPackageName();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final Context c() {
        WeakReference<Context> weakReference = this.n;
        if (weakReference == null) {
            return null;
        }
        return (Context) weakReference.get();
    }

    public final void a(Context context) {
        if (context instanceof Activity) {
            this.n = new WeakReference<>(context);
        }
    }

    public final void a(Activity activity) {
        if (activity != null) {
            try {
                String name = activity.getClass().getName();
                WeakReference<Context> weakReference = this.n;
                if (weakReference != null) {
                    Context context = (Context) weakReference.get();
                    if ((context instanceof Activity) && ((Activity) context).getClass().getName().equals(name)) {
                        this.n.clear();
                    }
                }
            } catch (Throwable th) {
                aa.d(a, th.getMessage());
            }
        }
    }

    public final void b(String str) {
        Context context;
        try {
            this.r = str;
            if (!TextUtils.isEmpty(str) && (context = this.e) != null) {
                ai.a(context, "applicationIds", str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private b() {
    }

    public static synchronized b d() {
        b bVar;
        synchronized (b.class) {
            if (d == null) {
                d = new b();
            }
            bVar = d;
        }
        return bVar;
    }

    public final int e() {
        return this.m;
    }

    public final void b(int i2) {
        this.m = i2;
    }

    public final d f() {
        return this.s;
    }

    public final void a(a aVar, final Handler handler) {
        if (!this.l) {
            try {
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g() && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    Object b2 = ai.b(this.e, MBridgeConstans.SP_GA_ID, "");
                    Object b3 = ai.b(this.e, MBridgeConstans.SP_GA_ID_LIMIT, 0);
                    if (b2 instanceof String) {
                        String str = (String) b2;
                        if (!TextUtils.isEmpty(str)) {
                            w.a(str);
                        } else {
                            w.a();
                        }
                        if (b3 instanceof Integer) {
                            w.a(((Integer) b3).intValue());
                        }
                    }
                }
            } catch (Exception e2) {
                aa.d(a, e2.getMessage());
            }
            try {
                JSONObject jSONObject = new JSONObject();
                this.j = jSONObject;
                jSONObject.put("webgl", 0);
            } catch (JSONException e3) {
                aa.d(a, e3.getMessage());
            }
            new Thread(new Runnable() {
                public final void run() {
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                        try {
                            w.d(b.this.e.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled ? 1 : 2);
                        } catch (PackageManager.NameNotFoundException unused) {
                            w.d(0);
                        } catch (Throwable th) {
                            aa.d(b.a, th.getMessage());
                        }
                    }
                    try {
                        e b2 = f.a().b(b.d().h());
                        if (b2 == null) {
                            b2 = f.a().b();
                        }
                        Message obtain = Message.obtain();
                        obtain.obj = b2;
                        obtain.what = 9;
                        handler.sendMessage(obtain);
                    } catch (Exception e) {
                        aa.d(b.a, e.getMessage());
                    }
                    try {
                        w.c(b.this.e);
                        f.a(b.this.e, b.this.f);
                    } catch (Exception e2) {
                        aa.d(b.a, e2.getMessage());
                    }
                }
            }).start();
        }
    }

    public final Context g() {
        return this.e;
    }

    public final void b(Context context) {
        this.e = context;
    }

    public final String h() {
        try {
            if (!TextUtils.isEmpty(this.f)) {
                return this.f;
            }
            Context context = this.e;
            if (context != null) {
                return (String) ai.b(context, "sp_appId", "");
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c(String str) {
        Context context;
        try {
            this.f = str;
            if (!TextUtils.isEmpty(str) && (context = this.e) != null) {
                ai.a(context, "sp_appId", str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String i() {
        if (!TextUtils.isEmpty(this.h)) {
            return this.h;
        }
        Context context = this.e;
        if (context != null) {
            return (String) ai.b(context, "sp_wx_appKey", "");
        }
        return null;
    }

    public final void d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.h = str;
                Context context = this.e;
                if (context != null) {
                    ai.a(context, "sp_wx_appKey", str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String j() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        Context context = this.e;
        if (context != null) {
            return (String) ai.b(context, "sp_appKey", "");
        }
        return null;
    }

    public final void e(String str) {
        Context context;
        try {
            this.g = str;
            if (!TextUtils.isEmpty(str) && (context = this.e) != null) {
                ai.a(context, "sp_appKey", str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final int k() {
        return this.i;
    }

    public final void c(int i2) {
        this.i = i2;
    }

    public final JSONObject l() {
        return this.j;
    }

    public final void a(JSONObject jSONObject) {
        this.j = jSONObject;
    }
}
