package com.bytedance.sdk.openadsdk.core.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.sdk.AppLovinMediationProvider;
import com.bytedance.sdk.component.adexpress.a.b.c;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.settings.d;
import com.bytedance.sdk.openadsdk.core.settings.m;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TTSdkSettings */
public class o implements e, m.a {
    public static String a = "";
    public static String b = "IABTCF_TCString";
    static final ConcurrentHashMap<String, Integer> c = new ConcurrentHashMap<>();
    private static final String e = ac.n();
    /* access modifiers changed from: private */
    public static final h g = new h("TemplateReInitTask") {
        public void run() {
            c.a().g();
            c.a().b(false);
            com.bytedance.sdk.component.adexpress.a.b.a.b();
            c.a().b();
        }
    };
    private static final j q = new j();
    final d.b<ConcurrentHashMap<String, Integer>> d;
    private Set<String> f;
    private final i h;
    private final l i;
    private final AtomicBoolean j;
    private volatile boolean k;
    private boolean l;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public int n;
    private boolean o;
    private h p;
    private final BroadcastReceiver r;
    private final Runnable s;
    private final Set<String> t;
    private final d.b<Set<String>> u;

    /* compiled from: TTSdkSettings */
    private static final class a {
        static final o a = new o();
    }

    private static int b(boolean z) {
        return z ? 20 : 5;
    }

    private o() {
        this.f = Collections.synchronizedSet(new HashSet());
        this.h = new i();
        this.i = new l();
        this.j = new AtomicBoolean(false);
        this.k = false;
        this.l = false;
        this.m = 5000;
        this.n = 10;
        AnonymousClass6 r0 = new BroadcastReceiver() {
            /* access modifiers changed from: private */
            public final Runnable b = new Runnable() {
                public void run() {
                    aa.b(new h("LoadLocalData") {
                        public void run() {
                            try {
                                o.this.b();
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            };

            public void onReceive(Context context, final Intent intent) {
                if (intent != null) {
                    aa.b(new h("setting_receiver") {
                        public void run() {
                            String action = intent.getAction();
                            l.b("TTAD.SdkSettings", "onReceive: action=" + action);
                            if ("_tryFetRemoDat".equals(action)) {
                                o.this.a(intent.getIntExtra("_source", 0), intent.getBooleanExtra("_force", false));
                            } else if ("_dataChanged".equals(action)) {
                                com.bytedance.sdk.component.utils.h.a().removeCallbacks(AnonymousClass6.this.b);
                                com.bytedance.sdk.component.utils.h.a().postDelayed(AnonymousClass6.this.b, 10000);
                            }
                        }
                    });
                }
            }
        };
        this.r = r0;
        this.s = new Runnable() {
            public void run() {
                l.b("TTAD.SdkSettings", "auto fetch task active, try fetch remote data");
                o.this.d(2);
                o.this.aj();
            }
        };
        this.d = new d.b<ConcurrentHashMap<String, Integer>>() {
            /* renamed from: a */
            public ConcurrentHashMap<String, Integer> b(String str) {
                if (TextUtils.isEmpty(str)) {
                    return o.c;
                }
                ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        int optInt = jSONObject.optInt(next, 100);
                        if (!TextUtils.isEmpty(next) && optInt >= 0 && optInt <= 100) {
                            concurrentHashMap.put(next, Integer.valueOf(optInt));
                        }
                    }
                } catch (JSONException e) {
                    Log.i("TTAD.SdkSettings", e.getMessage());
                }
                return concurrentHashMap;
            }
        };
        this.t = new HashSet();
        this.u = new d.b<Set<String>>() {
            /* renamed from: a */
            public Set<String> b(String str) {
                HashSet hashSet = new HashSet();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt("applog_count");
                        if (optInt >= 2 && optInt <= 100) {
                            int unused = o.this.n = optInt;
                        }
                        int optInt2 = jSONObject.optInt("applog_interval");
                        if (optInt2 >= 100 && optInt2 <= 30000) {
                            int unused2 = o.this.m = optInt2;
                        }
                        JSONArray jSONArray = jSONObject.getJSONArray("core_label_arr");
                        if (jSONArray != null) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                String string = jSONArray.getString(i);
                                if (!TextUtils.isEmpty(string)) {
                                    hashSet.add(string);
                                }
                            }
                        }
                    } catch (JSONException e) {
                        Log.i("TTAD.SdkSettings", e.getMessage());
                    }
                }
                return hashSet.size() == 0 ? new HashSet(Arrays.asList(new String[]{CampaignEx.JSON_NATIVE_VIDEO_CLICK, "show", "insight_log", "mrc_show"})) : hashSet;
            }
        };
        try {
            Context a2 = com.bytedance.sdk.openadsdk.core.o.a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("_dataChanged");
            if (Build.VERSION.SDK_INT >= 33) {
                a2.registerReceiver(r0, intentFilter, 4);
            } else {
                a2.registerReceiver(r0, intentFilter);
            }
        } catch (Exception e2) {
            l.c("TTAD.SdkSettings", "", e2);
        }
    }

    public void a() {
        File file;
        try {
            b.a();
            this.i.c();
            this.h.c();
            Context a2 = com.bytedance.sdk.openadsdk.core.o.a();
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(a2.getDataDir(), "shared_prefs");
            } else {
                file = new File(a2.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            File file2 = new File(file, "tt_sdk_settings.xml");
            if (file2.exists() && file2.isFile()) {
                String replace = file2.getName().replace(".xml", "");
                if (Build.VERSION.SDK_INT >= 24) {
                    a2.deleteSharedPreferences(replace);
                    return;
                }
                a2.getSharedPreferences(replace, 0).edit().clear().apply();
                f.c(file2);
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(int i2, boolean z) {
        Context a2 = com.bytedance.sdk.openadsdk.core.o.a();
        if (a2 != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(a2.getPackageName());
                intent.setAction("_tryFetRemoDat");
                intent.putExtra("_force", z);
                intent.putExtra("_source", i2);
                a2.sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    private static void am() {
        Context a2 = com.bytedance.sdk.openadsdk.core.o.a();
        if (a2 != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(a2.getPackageName());
                intent.setAction("_dataChanged");
                a2.sendBroadcast(intent);
            } catch (Throwable th) {
                l.c("TTAD.SdkSettings", "", th);
            }
        }
    }

    public static int b(Context context) {
        SharedPreferences d2;
        if (context == null || (d2 = d(context)) == null) {
            return -2;
        }
        if ((d2.getInt("IABTCF_CmpSdkID", Integer.MIN_VALUE) == Integer.MIN_VALUE && d2.getInt("IABTCF_CmpSdkVersion", Integer.MIN_VALUE) == Integer.MIN_VALUE) ? false : true) {
            return d2.getInt("IABTCF_gdprApplies", -1);
        }
        return -2;
    }

    public static String c(Context context) {
        SharedPreferences d2;
        if (context == null || (d2 = d(context)) == null) {
            return "";
        }
        return d2.getString(b, "");
    }

    private static SharedPreferences d(Context context) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context);
        } catch (Exception unused) {
            return null;
        }
    }

    public static e ai() {
        if (com.bytedance.sdk.openadsdk.core.o.a() != null) {
            return a.a;
        }
        IllegalStateException illegalStateException = new IllegalStateException("context is null");
        Log.e("Pangle", "context is null", illegalStateException);
        ApmHelper.reportCustomError("context is null", "context is null", illegalStateException);
        return q;
    }

    public synchronized void b() {
        l.b("TTAD.SdkSettings", "loadLocalData: ");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = !this.k;
        this.h.a(this.k);
        this.i.a(this.k);
        b.a(z);
        com.bytedance.sdk.openadsdk.core.h.b().d(ao());
        this.k = true;
        l.a("TTAD.SdkSettings", "loadLocalData: finished, used", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), "ms");
        if (z) {
            com.bytedance.sdk.openadsdk.core.l.b().postDelayed(new Runnable() {
                public void run() {
                    if (m.a()) {
                        o.this.d(1);
                        o.this.aj();
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.a.a().b();
                }
            }, 1000);
        }
    }

    public String c() {
        return this.i.a("aes_key", "");
    }

    public int d() {
        return this.i.a("max_tpl_cnts", 100);
    }

    public JSONObject e() {
        return (JSONObject) this.i.a("digest", null, d.a);
    }

    public long f() {
        return this.i.a("data_time", 0);
    }

    public void g() {
        this.i.a().a("tt_sdk_settings").a("ab_test_param").a();
    }

    public void a(JSONObject jSONObject, d.a aVar) {
        if (jSONObject != null && jSONObject.has("dyn_draw_engine_url")) {
            l lVar = this.i;
            String str = e;
            String a2 = lVar.a("dyn_draw_engine_url", str);
            String optString = jSONObject.optString("dyn_draw_engine_url", str);
            if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(optString) && !optString.equals(a2)) {
                com.bytedance.sdk.openadsdk.core.l.b().postDelayed(new Runnable() {
                    public void run() {
                        aa.a(o.g);
                    }
                }, 5000);
            }
            aVar.a("dyn_draw_engine_url", optString);
        }
    }

    public int a(String str) {
        if (str == null) {
            return 0;
        }
        return com.bytedance.sdk.openadsdk.core.o.d().z(str).r;
    }

    public void b(JSONObject jSONObject, d.a aVar) {
        if (jSONObject.has("is_gdpr_user")) {
            int i2 = -1;
            int optInt = jSONObject.optInt("is_gdpr_user", -1);
            if (optInt == -1 || optInt == 1 || optInt == 0) {
                i2 = optInt;
            }
            aVar.a("isGdprUser", i2);
        }
    }

    public boolean h() {
        return this.i.a("if_both_open", 0) == 1;
    }

    public boolean i() {
        return !(this.i.a("support_tnc", 1) == 0);
    }

    public String j() {
        return this.i.a("ab_test_version", "");
    }

    public int k() {
        return this.i.a("load_callback_strategy", 0);
    }

    public boolean l() {
        return this.i.a("support_mem_dynamic", 0) == 1;
    }

    public int b(String str) {
        Integer num;
        Map map = (Map) this.i.a("perf_con_stats_rate", c, this.d);
        if (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) {
            return 100;
        }
        return num.intValue();
    }

    public Set<String> m() {
        return ar();
    }

    public int n() {
        ar();
        return this.n;
    }

    public int o() {
        ar();
        return this.m;
    }

    public boolean p() {
        return this.i.a("allow_blind_mode_request_ad", false);
    }

    public boolean q() {
        return this.i.a("support_gzip", false);
    }

    public boolean r() {
        return this.i.a("ad_revenue_enable", false);
    }

    public int s() {
        return this.i.a("loadedCallbackOpportunity", 0);
    }

    public String t() {
        return this.i.a("ab_test_param", "");
    }

    public h u() {
        h hVar = this.p;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = (h) this.h.a("mediation_init_conf", h.a, new d.b<h>() {
            /* renamed from: a */
            public h b(String str) {
                return new h(str);
            }
        });
        this.p = hVar2;
        return hVar2;
    }

    public boolean v() {
        return this.i.a("landingpage_new_style", -1) == 1;
    }

    public long w() {
        return this.i.a("duration", 10000);
    }

    public int x() {
        return this.i.a(AppLovinMediationProvider.MAX, 50);
    }

    public String y() {
        return this.i.a("pyload_h5", (String) null);
    }

    public f z() {
        return (f) this.i.a("insert_js_config", f.a, new d.b<f>() {
            /* renamed from: a */
            public f b(String str) {
                return new f(str);
            }
        });
    }

    public String A() {
        return this.i.a("playableLoadH5Url", "");
    }

    public int B() {
        int a2 = this.i.a("fetch_tpl_timeout_ctrl", 3000);
        if (a2 <= 0) {
            return 3000;
        }
        return a2;
    }

    public int C() {
        int a2 = this.i.a("fetch_tpl_second", 0);
        if (a2 <= 0) {
            return 0;
        }
        return a2;
    }

    public void D() {
        String an = an();
        if (!TextUtils.isEmpty(an)) {
            if (an.equals("zh-Hant")) {
                i.a(com.bytedance.sdk.openadsdk.core.o.a(), "zh", "tw");
            } else {
                i.a(com.bytedance.sdk.openadsdk.core.o.a(), an, (String) null);
            }
            try {
                TTAdDislikeToast.a();
            } catch (Throwable th) {
                l.e("TTAD.SdkSettings", th.getMessage());
            }
        }
    }

    private String an() {
        return this.i.a("force_language", "");
    }

    public int E() {
        return this.i.a("disable_rotate_banner_on_dislike", Integer.MAX_VALUE);
    }

    public boolean c(String str) {
        return z(str).c == 1;
    }

    public boolean d(String str) {
        return z(str).B;
    }

    public boolean e(String str) {
        int i2 = z(str).e;
        if (i2 == 1) {
            return com.bytedance.sdk.component.utils.o.d(com.bytedance.sdk.openadsdk.core.o.a());
        }
        if (i2 == 2 && com.bytedance.sdk.component.utils.o.c(com.bytedance.sdk.openadsdk.core.o.a()) != 0) {
            return true;
        }
        return false;
    }

    public boolean f(String str) {
        return z(str).g == 1;
    }

    public int g(String str) {
        return z(str).q;
    }

    public boolean h(String str) {
        if (str == null || z(str).m == 1) {
            return true;
        }
        return false;
    }

    public int i(String str) {
        if (str == null) {
            return 1500;
        }
        return z(str).o;
    }

    public int j(String str) {
        return z(str).k;
    }

    public boolean k(String str) {
        try {
            return z(str).v != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean F() {
        return this.i.b();
    }

    public int l(String str) {
        return z(String.valueOf(str)).h;
    }

    public boolean m(String str) {
        return l(str) != 1;
    }

    public int n(String str) {
        return z(str).j;
    }

    public int a(String str, boolean z) {
        if (str == null) {
            return b(z);
        }
        a z2 = z(str);
        return z2.x != -1 ? z2.x : b(z);
    }

    public boolean o(String str) {
        return z(str).u == 0;
    }

    public boolean p(String str) {
        if (str == null || DeviceUtils.g(com.bytedance.sdk.openadsdk.core.o.a()) == 0 || z(str).l == 1) {
            return true;
        }
        return false;
    }

    public String G() {
        return this.i.a("ads_url", "");
    }

    public String H() {
        return this.i.a("app_log_url", "");
    }

    public String I() {
        return this.i.a("apm_url", "");
    }

    private int ao() {
        return this.i.a("coppa", -99);
    }

    public String J() {
        return this.i.a("policy_url", "");
    }

    public int K() {
        return this.i.a("ivrv_downward", 0);
    }

    public String L() {
        return this.i.a("dyn_draw_engine_url", e);
    }

    public String M() {
        return this.i.a("dc", "");
    }

    public int N() {
        return this.i.a("isGdprUser", -1);
    }

    public int a(int i2) {
        return z(String.valueOf(i2)).F;
    }

    public int b(int i2) {
        return z(String.valueOf(i2)).b;
    }

    public int c(int i2) {
        return z(String.valueOf(i2)).i;
    }

    public int O() {
        return this.i.a("vbtt", 5);
    }

    public int q(String str) {
        return z(str).s;
    }

    public boolean r(String str) {
        return z(str).t;
    }

    public int s(String str) {
        return z(str).y;
    }

    public int t(String str) {
        return z(str).z;
    }

    public int u(String str) {
        return z(str).A;
    }

    public boolean v(String str) {
        return z(str).C;
    }

    public boolean w(String str) {
        return z(str).D;
    }

    public int x(String str) {
        return z(str).E;
    }

    public boolean y(String str) {
        return com.bytedance.sdk.openadsdk.core.o.d().z(str).n == 1;
    }

    public a z(String str) {
        return b.a(str);
    }

    public boolean P() {
        int a2 = this.i.a("privacy_ad_enable", Integer.MAX_VALUE);
        if (a2 == 1) {
            return true;
        }
        if (a2 == 0) {
            return false;
        }
        int p2 = ac.p();
        return p2 == 1 || p2 == 2 || p2 == 3;
    }

    public int Q() {
        int a2 = this.i.a("privacy_personalized_ad", Integer.MAX_VALUE);
        if (a2 != Integer.MAX_VALUE) {
            return a2;
        }
        int p2 = ac.p();
        if (p2 == 1 || p2 == 2) {
            return 2;
        }
        return p2 != 3 ? 0 : 1;
    }

    public boolean R() {
        return this.i.a("privacy_sladar_enable", Integer.MAX_VALUE) == 1;
    }

    public boolean ag() {
        return this.i.a("perf_con_apm_native", Integer.MAX_VALUE) == 1;
    }

    public boolean S() {
        boolean z = this.i.a("bus_con_sec_type", Integer.MAX_VALUE) != 0;
        l.b("TTAD.SdkSettings", "secSdk type: ", Boolean.valueOf(z));
        return z;
    }

    public boolean T() {
        return this.i.a("bus_con_dislike_report_raw", false);
    }

    public boolean U() {
        return this.i.a("privacy_debug_unlock", 1) != 0;
    }

    public boolean A(String str) {
        Set set = (Set) this.i.a("privacy_fields_allowed", Collections.emptySet(), d.b);
        if (!set.isEmpty()) {
            return set.contains(str);
        }
        int p2 = ac.p();
        if (p2 == 1) {
            return true;
        }
        if (p2 != 2 && p2 != 3) {
            return false;
        }
        if (ThroughputConfigUtil.SHARED_PREFS_KEY_MCC.equals(str) || ThroughputConfigUtil.SHARED_PREFS_KEY_MNC.equals(str)) {
            return true;
        }
        return false;
    }

    public boolean V() {
        return this.k;
    }

    public boolean W() {
        return this.i.a("global_rate", 1.0f) == 1.0f;
    }

    public boolean X() {
        return this.i.a("read_video_from_cache", 1) == 1;
    }

    public int Y() {
        int a2 = this.i.a("perf_con_webview_cache_count", 0);
        if (a2 < 0) {
            return 0;
        }
        return a2;
    }

    public int Z() {
        int a2 = this.i.a("perf_con_webview_preload_cache", 0);
        if (a2 < 0) {
            return 0;
        }
        if (a2 > 5) {
            return 5;
        }
        return a2 > Y() ? Y() : a2;
    }

    public String[] aa() {
        try {
            Set<String> set = this.f;
            if (set == null || set.size() == 0) {
                JSONArray jSONArray = new JSONArray(this.i.a("gecko_hosts", (String) null));
                if (jSONArray.length() != 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        this.f.add(jSONArray.getString(i2));
                    }
                }
                Set<String> a2 = l.a(this.f);
                this.f = a2;
                if (a2 != null) {
                    if (a2.size() == 0) {
                    }
                }
                return null;
            }
            return (String[]) this.f.toArray(new String[0]);
        } catch (Throwable unused) {
        }
    }

    public int ab() {
        return this.i.a("blank_detect_rate", 30);
    }

    public JSONObject ac() {
        return (JSONObject) this.i.a("video_cache_config", null, d.a);
    }

    private long ap() {
        long a2 = this.i.a("req_inter_min", 600000);
        if (a2 < 0 || a2 > 86400000) {
            return 600000;
        }
        return a2;
    }

    private long aq() {
        return this.i.a("last_req_time", 0);
    }

    public void a(long j2) {
        this.i.a().a("last_req_time", j2).a();
    }

    public void ad() {
        this.l = true;
    }

    /* access modifiers changed from: package-private */
    public void aj() {
        if (m.a()) {
            com.bytedance.sdk.openadsdk.core.l.b().removeCallbacks(this.s);
            com.bytedance.sdk.openadsdk.core.l.b().postDelayed(this.s, ap());
        }
    }

    public void d(int i2) {
        a(i2, false);
    }

    public void a(int i2, boolean z) {
        if (com.bytedance.sdk.openadsdk.core.l.e() || i2 == 1 || i2 == 2) {
            try {
                if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.h.b().d())) {
                    if (this.o) {
                        this.o = false;
                        if (!z) {
                            z = true;
                        }
                    }
                    long aq = aq();
                    long currentTimeMillis = System.currentTimeMillis();
                    long ap = ap();
                    long j2 = currentTimeMillis - aq;
                    if (!z && j2 < ap) {
                        com.bytedance.sdk.openadsdk.core.f.a.a();
                    } else if (!m.a()) {
                        b(i2, z);
                    } else if (this.j.compareAndSet(false, true)) {
                        aa.b(new m(this, this.i, this.h));
                        com.bytedance.sdk.openadsdk.core.l.b().removeCallbacks(this.s);
                    }
                }
            } catch (Throwable th) {
                l.a("TTAD.SdkSettings", "load sdk settings error: ", th);
            }
        } else if (z) {
            this.o = true;
        }
    }

    public void a(boolean z) {
        this.j.set(false);
        aj();
        if (z) {
            am();
        }
    }

    public static void ak() {
        am();
    }

    public void a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("_tryFetRemoDat");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.r, intentFilter, 4);
            } else {
                context.registerReceiver(this.r, intentFilter);
            }
        } catch (Exception e2) {
            l.c("TTAD.SdkSettings", "", e2);
        }
        if (V()) {
            d(1);
            aj();
        }
    }

    public boolean ae() {
        if (!b.a(com.bytedance.sdk.openadsdk.core.o.a())) {
            return false;
        }
        return this.i.a("support_rtl", false);
    }

    public int af() {
        return this.i.a("bus_con_send_log_type", 1);
    }

    private Set<String> ar() {
        return (Set) this.i.a("perf_con_applog_send", this.t, this.u);
    }

    public int ah() {
        return this.i.a("perf_con_thread_stack_size", 0);
    }
}
