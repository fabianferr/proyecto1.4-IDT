package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.c;
import com.bytedance.sdk.openadsdk.core.settings.e;
import com.bytedance.sdk.openadsdk.i.g;
import com.bytedance.sdk.openadsdk.utils.e;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceUtils {
    public static String a = "";
    /* access modifiers changed from: private */
    public static volatile boolean b = false;
    private static volatile boolean c = false;
    private static volatile boolean d = true;
    private static long e;
    private static int f;
    /* access modifiers changed from: private */
    public static int g;
    /* access modifiers changed from: private */
    public static int h;
    /* access modifiers changed from: private */
    public static int i;
    /* access modifiers changed from: private */
    public static int j;
    /* access modifiers changed from: private */
    public static int k;

    @JProtect
    public static JSONObject a(Context context, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sys_adb_status", e(context));
            a(jSONObject);
            jSONObject.put("type", c(context));
            int i2 = 1;
            jSONObject.put("os", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("conn_type", ac.m(context));
            jSONObject.put("app_set_id", c.c());
            jSONObject.put("app_set_id_scope", c.b());
            jSONObject.put("installed_source", c.d());
            jSONObject.put("screen_width", ad.c(context));
            jSONObject.put("screen_height", ad.d(context));
            jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.core.e.c.c());
            e d2 = o.d();
            if (d2.A("boot")) {
                jSONObject.put("boot", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
                jSONObject.put("power_on_time", String.valueOf(SystemClock.elapsedRealtime()));
            }
            jSONObject.put("uuid", j.c(context));
            jSONObject.put("rom_version", t.a());
            jSONObject.put("sys_compiling_time", j.b(context));
            jSONObject.put("timezone", ac.r());
            jSONObject.put("language", j.a());
            jSONObject.put("carrier_name", u.a());
            jSONObject.put("total_mem", String.valueOf(Long.parseLong(z ? ac.a(context) : ac.b(context)) * 1024));
            jSONObject.put("locale_language", c());
            jSONObject.put("screen_bright", Math.ceil((double) (d() * 10.0f)) / 10.0d);
            if (a()) {
                i2 = 0;
            }
            jSONObject.put("is_screen_off", i2);
            jSONObject.put("cpu_num", f.a(context));
            jSONObject.put("cpu_max_freq", f.b(context));
            jSONObject.put("cpu_min_freq", f.c(context));
            e.a a2 = e.a();
            jSONObject.put("battery_remaining_pct", (int) a2.b);
            jSONObject.put("is_charging", a2.a);
            jSONObject.put("total_space", String.valueOf(ac.c(context)));
            jSONObject.put("free_space_in", String.valueOf(ac.d(context)));
            jSONObject.put("sdcard_size", String.valueOf(ac.e(context)));
            jSONObject.put("rooted", ac.f(context));
            jSONObject.put("enable_assisted_clicking", e());
            jSONObject.put("force_language", s.a(context, "tt_choose_language"));
            jSONObject.put("airplane", f(context));
            jSONObject.put("darkmode", m(context));
            jSONObject.put("headset", n(context));
            jSONObject.put("ringmute", g(context));
            jSONObject.put("screenscale", (double) o(context));
            jSONObject.put(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, g());
            jSONObject.put("low_power_mode", p(context));
            if (d2.A(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC)) {
                jSONObject.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC, u.c());
            }
            if (d2.A(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC)) {
                jSONObject.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, u.b());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        b(jSONObject);
    }

    @JProtect
    public static boolean a() {
        if (SystemClock.elapsedRealtime() - e >= 20000) {
            e = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) o.a().getSystemService("power");
                if (powerManager != null) {
                    d = Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
                }
            } catch (Throwable th) {
                l.e("TTAD.DeviceUtils", th.getMessage());
            }
        }
        return d;
    }

    public static boolean a(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int b() {
        return com.bytedance.sdk.openadsdk.core.c.a(o.a()).b("limit_ad_track", -1);
    }

    private static void b(JSONObject jSONObject) throws JSONException {
        jSONObject.put("model", Build.MODEL);
        if (o.d().A("gaid")) {
            jSONObject.put("gaid", com.com.bytedance.overseas.sdk.b.a.a().b());
        }
    }

    public static boolean b(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int c(Context context) {
        if (b(context)) {
            return 3;
        }
        return a(context) ? 2 : 1;
    }

    public static String c() {
        if (Build.VERSION.SDK_INT < 21) {
            return Locale.getDefault().getLanguage();
        }
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    public static float d() {
        int i2 = -1;
        try {
            Context a2 = o.a();
            if (a2 != null) {
                i2 = Settings.System.getInt(a2.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            l.e("TTAD.DeviceUtils", th.getMessage());
        }
        if (i2 < 0) {
            return -1.0f;
        }
        return ((float) Math.round((((float) i2) / 255.0f) * 10.0f)) / 10.0f;
    }

    public static JSONObject d(Context context) {
        return a(context, false);
    }

    public static int e() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) o.a().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        return accessibilityManager.isEnabled() ? 1 : 0;
    }

    public static int e(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", -1);
        } catch (Throwable th) {
            l.e("TTAD.DeviceUtils", th.getMessage());
            return -1;
        }
    }

    public static int f() {
        return h;
    }

    public static int f(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int g() {
        return i;
    }

    public static int g(Context context) {
        return f;
    }

    public static int h() {
        return g;
    }

    public static String h(Context context) {
        if (TextUtils.isEmpty(a)) {
            a = com.bytedance.sdk.openadsdk.core.c.a(context).b("framework_name", "");
        }
        return a;
    }

    @JProtect
    public static void i() {
        new b().run();
        Context a2 = o.a();
        if (a2 != null) {
            com.bytedance.sdk.openadsdk.core.c.a(a2).a("cpu_count", f.a());
            com.bytedance.sdk.openadsdk.core.c.a(a2).a("cpu_max_frequency", f.a(f.a()));
            com.bytedance.sdk.openadsdk.core.c.a(a2).a("cpu_min_frequency", f.b(f.a()));
            String i2 = ac.i();
            if (i2 != null) {
                com.bytedance.sdk.openadsdk.core.c.a(a2).a("total_memory", i2);
            }
            com.bytedance.sdk.openadsdk.core.c.a(a2).a("total_internal_storage", ac.j());
            com.bytedance.sdk.openadsdk.core.c.a(a2).a("free_internal_storage", m.a());
            com.bytedance.sdk.openadsdk.core.c.a(a2).a("total_sdcard_storage", ac.k());
            com.bytedance.sdk.openadsdk.core.c.a(a2).a("is_root", ac.l() ? 1 : 0);
            if (TextUtils.isEmpty(h(a2))) {
                try {
                    Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
                    a = "unity";
                } catch (ClassNotFoundException unused) {
                    a = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE;
                }
                com.bytedance.sdk.openadsdk.core.c.a(a2).a("framework_name", a);
            }
            j();
            q(a2);
            k = s(a2);
        }
    }

    public static void i(Context context) {
        AudioInfoReceiver.b(context);
    }

    public static void j() {
        try {
            int ringerMode = ((AudioManager) o.a().getSystemService("audio")).getRingerMode();
            if (ringerMode == 2) {
                f = 1;
            } else if (ringerMode == 1) {
                f = 2;
            } else {
                f = 0;
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(Context context) {
        Context applicationContext;
        if (!c && context != null && (applicationContext = context.getApplicationContext()) != null) {
            try {
                if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
                    u(applicationContext);
                } else {
                    a.b(applicationContext);
                }
                c = true;
            } catch (Throwable unused) {
            }
        }
    }

    private static int m(Context context) {
        try {
            int i2 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
            if (i2 == 32) {
                return 1;
            }
            return i2 == 16 ? 0 : -1;
        } catch (Throwable unused) {
        }
    }

    private static int n(Context context) {
        return j;
    }

    private static float o(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static int p(Context context) {
        return k;
    }

    private static void q(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            g = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            h = streamVolume;
            double d2 = (double) streamVolume;
            double d3 = (double) g;
            Double.isNaN(d2);
            Double.isNaN(d3);
            i = (int) ((d2 / d3) * 100.0d);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void r(Context context) {
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            aa.b(new h("DeviceUtils_get_low_power_mode") {
                public void run() {
                    int unused = DeviceUtils.k = DeviceUtils.s(applicationContext);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static int s(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
                if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                    return (Build.VERSION.SDK_INT < 21 || !((PowerManager) context.getSystemService("power")).isPowerSaveMode()) ? 0 : 1;
                }
            }
            return t(context);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (android.provider.Settings.System.getInt(r4.getContentResolver(), "SmartModeStatus") == 4) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int t(android.content.Context r4) {
        /*
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = "XIAOMI"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ all -> 0x0035 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001c
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "POWER_SAVE_MODE_OPEN"
            int r4 = android.provider.Settings.System.getInt(r4, r0)     // Catch:{ all -> 0x0035 }
            if (r4 != r1) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            r2 = r1
            goto L_0x0034
        L_0x001c:
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0035 }
            java.lang.String r3 = "HUAWEI"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0034
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "SmartModeStatus"
            int r4 = android.provider.Settings.System.getInt(r4, r0)     // Catch:{ all -> 0x0035 }
            r0 = 4
            if (r4 != r0) goto L_0x0019
            goto L_0x001a
        L_0x0034:
            return r2
        L_0x0035:
            r4 = -1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.DeviceUtils.t(android.content.Context):int");
    }

    private static void u(Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context.getContentResolver().registerContentObserver(Uri.parse("content://settings/system/POWER_SAVE_MODE_OPEN"), false, new ContentObserver((Handler) null) {
                public void onChange(boolean z) {
                    super.onChange(z);
                    DeviceUtils.r(applicationContext);
                }
            });
        }
    }

    public static class b implements Runnable {
        public void run() {
            int i;
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(o.a());
                if (advertisingIdInfo != null) {
                    i = advertisingIdInfo.isLimitAdTrackingEnabled() ? 1 : 0;
                    if (o.d().A("gaid")) {
                        String id = advertisingIdInfo.getId();
                        if (!TextUtils.isEmpty(id)) {
                            com.com.bytedance.overseas.sdk.b.a.a().b(id);
                            com.com.bytedance.overseas.sdk.b.a.a(id);
                        }
                    }
                } else {
                    i = -1;
                }
                if (i != -1) {
                    com.bytedance.sdk.openadsdk.core.c.a(o.a()).a("limit_ad_track", i);
                }
            } catch (IOException e) {
                l.c("TTAD.DeviceUtils", "getLmtTask error : signaling connection to Google Play Services failed.", e);
            } catch (Throwable th) {
                l.e("TTAD.DeviceUtils", th.getMessage());
            }
        }
    }

    public static class AudioInfoReceiver extends BroadcastReceiver {
        static final CopyOnWriteArrayList<g> a = new CopyOnWriteArrayList<>();

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if (SystemMediaRouteProvider.LegacyImpl.VolumeChangeReceiver.VOLUME_CHANGED_ACTION.equals(intent.getAction())) {
                        if (intent.getIntExtra(SystemMediaRouteProvider.LegacyImpl.VolumeChangeReceiver.EXTRA_VOLUME_STREAM_TYPE, -1) == 3) {
                            int unused = DeviceUtils.h = intent.getIntExtra(SystemMediaRouteProvider.LegacyImpl.VolumeChangeReceiver.EXTRA_VOLUME_STREAM_VALUE, 0);
                            Iterator<g> it = a.iterator();
                            while (it.hasNext()) {
                                it.next().a(DeviceUtils.h);
                            }
                            if (DeviceUtils.g != 0) {
                                double k = (double) DeviceUtils.h;
                                double l = (double) DeviceUtils.g;
                                Double.isNaN(k);
                                Double.isNaN(l);
                                int unused2 = DeviceUtils.i = (int) ((k / l) * 100.0d);
                            }
                        }
                    } else if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                        int unused3 = DeviceUtils.j = intent.getIntExtra("state", 0);
                    }
                } catch (Exception unused4) {
                }
            }
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (!DeviceUtils.b && context != null) {
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(SystemMediaRouteProvider.LegacyImpl.VolumeChangeReceiver.VOLUME_CHANGED_ACTION);
                    intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                    context.registerReceiver(new AudioInfoReceiver(), intentFilter);
                    boolean unused = DeviceUtils.b = true;
                } catch (Throwable unused2) {
                }
            }
        }

        public static void a(g gVar) {
            if (gVar != null) {
                CopyOnWriteArrayList<g> copyOnWriteArrayList = a;
                if (!copyOnWriteArrayList.contains(gVar)) {
                    copyOnWriteArrayList.add(gVar);
                }
            }
        }

        public static void b(g gVar) {
            if (gVar != null) {
                a.remove(gVar);
            }
        }
    }

    private static class a extends BroadcastReceiver {
        private a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && context != null) {
                if ("android.os.action.POWER_SAVE_MODE_CHANGED".equals(intent.getAction())) {
                    DeviceUtils.r(context);
                } else if ("huawei.intent.action.POWER_MODE_CHANGED_ACTION".equals(intent.getAction())) {
                    int i = 0;
                    if (intent.getIntExtra("state", 0) == 1) {
                        i = 1;
                    }
                    int unused = DeviceUtils.k = i;
                }
            }
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (Build.VERSION.SDK_INT >= 21 && context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                intentFilter.addAction("huawei.intent.action.POWER_MODE_CHANGED_ACTION");
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(new a(), intentFilter, 2);
                } else {
                    context.registerReceiver(new a(), intentFilter);
                }
            }
        }
    }
}
