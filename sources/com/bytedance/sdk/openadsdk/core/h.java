package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.bannerexpress.a;
import com.bytedance.sdk.openadsdk.core.settings.o;
import com.bytedance.sdk.openadsdk.core.video.b.c;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.d;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.s;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GlobalInfo */
public class h {
    public static k a = null;
    public static final Set<String> b = new HashSet<String>() {
        {
            add("8025677");
            add("5001121");
        }
    };
    private static boolean q = false;
    private boolean c;
    private String d;
    private String e;
    private int f;
    private boolean g;
    private String h;
    private String i;
    private int j;
    private boolean k;
    private boolean l;
    private Bitmap m;
    private Integer n;
    private Integer o;
    private Integer p;
    private int r;
    private boolean s;
    private String t;
    private c u;
    private volatile ConcurrentHashMap<String, a.C0062a> v;

    /* compiled from: GlobalInfo */
    private static class a {
        /* access modifiers changed from: private */
        public static final h a = new h();
    }

    public static void a(k kVar) {
        a = kVar;
    }

    public boolean a() {
        return this.s;
    }

    public void a(boolean z) {
        this.s = z;
    }

    private h() {
        this.c = false;
        this.j = 0;
        this.k = true;
        this.l = false;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.r = 0;
        this.v = null;
        try {
            com.bykv.vk.openvk.component.video.api.f.a.a(o.a());
        } catch (Throwable unused) {
        }
    }

    public static h b() {
        return a.a;
    }

    public boolean c() {
        return d.a("sp_global_file", "sdk_activate_init", true);
    }

    public void b(boolean z) {
        d.a("sp_global_file", "sdk_activate_init", Boolean.valueOf(z));
    }

    public String d() {
        if (b.c()) {
            return a("app_id", Long.MAX_VALUE);
        }
        return this.d;
    }

    public void a(String str) {
        f(str);
        this.d = str;
        if (!TextUtils.isEmpty(str)) {
            a("app_id", str);
            o.ai().d(7);
        }
    }

    public String e() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = a(o.a());
        }
        return this.e;
    }

    private String a(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public void a(int i2) {
        if (b.c()) {
            d.a("sp_global_icon_id", "icon_id", Integer.valueOf(i2));
        }
        this.f = i2;
    }

    public int f() {
        if (b.c()) {
            return d.a("sp_global_icon_id", "icon_id", 0);
        }
        return this.f;
    }

    public void b(final int i2) {
        if (i2 == 0 || i2 == 1 || i2 == -1) {
            final Integer num = this.n;
            if (num == null || num.intValue() != i2) {
                this.n = Integer.valueOf(i2);
                if (!aa.e()) {
                    a(num, i2);
                } else {
                    l.b().post(new Runnable() {
                        public void run() {
                            h.this.a(num, i2);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Integer num, int i2) {
        if (num != null) {
            d.a("sp_global_privacy", "sdk_coppa", Integer.valueOf(i2));
            o.ai().a(3, true);
        } else if (d.a("sp_global_privacy", "sdk_coppa", -1) != i2) {
            d.a("sp_global_privacy", "sdk_coppa", Integer.valueOf(i2));
            o.ai().a(3, true);
        }
    }

    public int g() {
        Integer num = this.n;
        if (num != null) {
            return num.intValue();
        }
        return d.a("sp_global_privacy", "sdk_coppa", -1);
    }

    public int h() {
        Integer num = this.o;
        if (num != null) {
            return num.intValue();
        }
        return d.a("sp_global_privacy", "tt_gdpr", -1);
    }

    public void c(final int i2) {
        if (i2 == 1) {
            i2 = 0;
        } else if (i2 == 0) {
            i2 = 1;
        }
        if (i2 == 0 || i2 == 1 || i2 == -1) {
            final Integer num = this.o;
            if (num == null || num.intValue() != i2) {
                this.o = Integer.valueOf(i2);
                if (!aa.e()) {
                    b(num, i2);
                } else {
                    l.b().post(new Runnable() {
                        public void run() {
                            h.this.b(num, i2);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(Integer num, int i2) {
        if (num != null) {
            d.a("sp_global_privacy", "tt_gdpr", Integer.valueOf(i2));
            o.ai().a(4, true);
        } else if (d.a("sp_global_privacy", "tt_gdpr", -1) != i2) {
            d.a("sp_global_privacy", "tt_gdpr", Integer.valueOf(i2));
            o.ai().a(4, true);
        }
    }

    public void d(int i2) {
        if (!(i2 == 0 || i2 == 1)) {
            i2 = -99;
        }
        d.a("sp_global_privacy", "global_coppa", Integer.valueOf(i2));
        this.r = i2;
    }

    public int i() {
        int a2 = d.a("sp_global_privacy", "global_coppa", -99);
        this.r = a2;
        if (a2 == -99) {
            this.r = g();
        }
        return this.r;
    }

    public boolean j() {
        if (b.c()) {
            return d.a("sp_global_file", "is_paid", false);
        }
        return this.g;
    }

    public String k() {
        if (b.c()) {
            return d.b("sp_global_file", "keywords", (String) null);
        }
        return this.h;
    }

    public String l() {
        if (b.c()) {
            return d.b("sp_global_file", "extra_data", (String) null);
        }
        return this.i;
    }

    public void b(final String str) {
        g(str);
        if (aa.e()) {
            l.b().post(new Runnable() {
                public void run() {
                    if (b.c()) {
                        d.a("sp_global_file", "extra_data", str);
                    }
                }
            });
        } else if (b.c()) {
            d.a("sp_global_file", "extra_data", str);
        }
        this.i = str;
    }

    public void e(int i2) {
        if (b.c()) {
            d.a("sp_global_file", "title_bar_theme", Integer.valueOf(i2));
        }
        this.j = i2;
    }

    public int m() {
        if (b.c()) {
            return d.a("sp_global_file", "title_bar_theme", 0);
        }
        return this.j;
    }

    private static void f(String str) {
        k kVar;
        if (TextUtils.isEmpty(str) && (kVar = a) != null) {
            kVar.fail(4000, "appid cannot be empty");
        }
        l.e("TTAD.GlobalInfo", "appid cannot be empty");
    }

    private static void g(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 1000) {
            k kVar = a;
            if (kVar != null) {
                kVar.fail(4000, "Data is very long, the longest is 1000");
            }
            l.e("TTAD.GlobalInfo", "Data is very long, the longest is 1000");
        }
    }

    public c n() {
        if (this.u == null) {
            this.u = new c(10, 8);
        }
        return this.u;
    }

    public boolean o() {
        if (b.c()) {
            return d.a("sp_global_file", "is_use_texture", false);
        }
        return this.l;
    }

    public void c(boolean z) {
        if (b.c()) {
            d.a("sp_global_file", "is_use_texture", Boolean.valueOf(z));
        }
        this.l = z;
    }

    public Bitmap p() {
        if (b.c()) {
            return com.bytedance.sdk.component.utils.d.a(d.b("sp_global_file", "pause_icon", (String) null));
        }
        return this.m;
    }

    public boolean q() {
        return b.contains(this.d);
    }

    public boolean r() {
        return "com.union_test.internationad".equals(ac.e());
    }

    public String s() {
        if (!TextUtils.isEmpty(this.t)) {
            return this.t;
        }
        String a2 = g.a();
        this.t = a2;
        if (!TextUtils.isEmpty(a2)) {
            return this.t;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        g.a(valueOf);
        this.t = valueOf;
        return valueOf;
    }

    private static JSONObject h(String str) {
        String b2 = d.b("sp_global_file", str, (String) null);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            return new JSONObject(b2);
        } catch (JSONException e2) {
            l.e("TTAD.GlobalInfo", e2.getMessage());
            return null;
        }
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("value", str2);
                jSONObject.put("time", System.currentTimeMillis());
                d.a("sp_global_file", str, jSONObject.toString());
            } catch (JSONException e2) {
                l.e("TTAD.GlobalInfo", e2.getMessage());
            }
        }
    }

    public static String a(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject h2 = h(str);
            if (h2 == null) {
                return null;
            }
            if (System.currentTimeMillis() - h2.getLong("time") <= j2) {
                return h2.getString("value");
            }
            return null;
        } catch (JSONException e2) {
            l.e("TTAD.GlobalInfo", e2.getMessage());
        }
    }

    public int t() {
        Integer num = this.p;
        if (num != null) {
            return num.intValue();
        }
        return d.a("sp_global_privacy", "global_ccpa", -1);
    }

    public void f(final int i2) {
        if (i2 == 0 || i2 == 1 || i2 == -1) {
            final Integer num = this.p;
            if (num == null || num.intValue() != i2) {
                this.p = Integer.valueOf(i2);
                if (!aa.e()) {
                    c(num, i2);
                } else {
                    l.b().post(new Runnable() {
                        public void run() {
                            h.this.c(num, i2);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(Integer num, int i2) {
        if (num != null) {
            d.a("sp_global_privacy", "global_ccpa", Integer.valueOf(i2));
            o.ai().a(5, true);
        } else if (d.a("sp_global_privacy", "global_ccpa", -1) != i2) {
            d.a("sp_global_privacy", "global_ccpa", Integer.valueOf(i2));
            o.ai().a(5, true);
        }
    }

    public a.C0062a c(String str) {
        if (this.v == null || str == null) {
            return null;
        }
        return this.v.get(str);
    }

    public void a(String str, a.C0062a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            if (b.c()) {
                TTDislikeListView.a(6, str, aVar);
                return;
            }
            if (this.v == null) {
                synchronized (h.class) {
                    if (this.v == null) {
                        this.v = new ConcurrentHashMap<>();
                    }
                }
            }
            this.v.put(str, aVar);
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (b.c()) {
            TTDislikeListView.a(6, str);
        } else if (this.v != null) {
            this.v.remove(str);
        }
    }

    public void u() {
        if (this.v != null && this.v.size() == 0) {
            this.v = null;
        }
    }

    public void d(boolean z) {
        this.c = z;
    }

    public static boolean v() {
        return q;
    }

    public static void w() {
        if (Build.VERSION.SDK_INT == 26 && "MI 6".equals(Build.MODEL)) {
            q = true;
        }
    }

    public static boolean e(String str) {
        return s.a && !str.contains("sp_full_screen_video") && !str.contains("sp_reward_video") && !str.contains("tt_openad") && !str.contains("pag_sp_bad_par");
    }
}
