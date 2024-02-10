package com.ironsource.environment;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import com.appnext.core.Ad;
import com.ironsource.environment.l;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

public final class h {
    public static boolean a = false;
    private static String b = null;
    private static String c = null;
    /* access modifiers changed from: private */
    public static String d = "";
    /* access modifiers changed from: private */
    public static String e = "";
    private static volatile String f;
    private static volatile String g;

    public static String A(Context context) {
        return c(context) ? "Tablet" : "Phone";
    }

    public static String B(Context context) {
        g gVar = g.a;
        if (!g.a()) {
            return "";
        }
        try {
            Class<?> cls = Class.forName("com.google.android.gms.appset.AppSet");
            Object invoke = cls.getMethod("getClient", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            Object invoke2 = invoke.getClass().getMethod("getAppSetIdInfo", new Class[0]).invoke(invoke, new Object[0]);
            Class<?> cls2 = Class.forName("com.google.android.gms.tasks.OnSuccessListener");
            invoke2.getClass().getMethod("addOnSuccessListener", new Class[]{cls2}).invoke(invoke2, new Object[]{Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls2}, new InvocationHandler() {
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    Object obj2;
                    if (objArr == null) {
                        return null;
                    }
                    try {
                        if (objArr.length <= 0 || (obj2 = objArr[0]) == null) {
                            return null;
                        }
                        String obj3 = obj2.getClass().getMethod("getId", new Class[0]).invoke(objArr[0], new Object[0]).toString();
                        if (TextUtils.isEmpty(obj3)) {
                            return null;
                        }
                        String unused = h.e = obj3;
                        return null;
                    } catch (Exception unused2) {
                        return null;
                    }
                }
            })});
            return !TextUtils.isEmpty(e) ? e : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String C(Context context) {
        g gVar = g.a;
        if (!g.b()) {
            return null;
        }
        try {
            g gVar2 = g.a;
            if (!g.c()) {
                return J(context);
            }
            if (g != null) {
                return g;
            }
            String J = J(context);
            if (TextUtils.isEmpty(J)) {
                return J;
            }
            g = J;
            return J;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String D(Context context) {
        try {
            g gVar = g.a;
            if (!g.c()) {
                return I(context);
            }
            if (f != null) {
                return f;
            }
            String I = I(context);
            try {
                if (TextUtils.isEmpty(I)) {
                    return I;
                }
                f = I;
                return I;
            } catch (Exception unused) {
                return I;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static int E(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getIntFromDefaultSharedPrefs(context, "IABTCF_gdprApplies", -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String F(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromDefaultSharedPrefs(context, "IABTCF_TCString", (String) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean G(Context context) {
        try {
            for (String equalsIgnoreCase : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (equalsIgnoreCase.equalsIgnoreCase("com.google.android.gms.permission.AD_ID")) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static Object H(Context context) {
        Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
        return cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(cls, new Object[]{context});
    }

    private static String I(Context context) {
        Object H = H(context);
        return String.valueOf(((Boolean) H.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(H, new Object[0])).booleanValue());
    }

    private static String J(Context context) {
        Object H = H(context);
        return H.getClass().getMethod("getId", new Class[0]).invoke(H, new Object[0]).toString();
    }

    private static long K(Context context) {
        try {
            return Long.parseLong(IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "Mediation_Shared_Preferences", "browser_user_agent_time", "-1"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private static String L(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "Mediation_Shared_Preferences", "browser_user_agent", "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static long a() {
        return Calendar.getInstance(TimeZone.getDefault()).getTime().getTime();
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    public static long a(String str) {
        return a(new File(str));
    }

    public static String a(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    public static void a(Context context, long j) {
        if (context != null) {
            if (!new n(new l.a()).a(K(context), j)) {
                String L = L(context);
                d = L;
                a = !L.isEmpty();
            }
            if (d.isEmpty()) {
                try {
                    String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    d = defaultUserAgent;
                    a(context, defaultUserAgent);
                    if (j > 0) {
                        b(context, System.currentTimeMillis());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static void a(Context context, String str) {
        try {
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, "Mediation_Shared_Preferences", "browser_user_agent", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(Activity activity) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (systemUiVisibility | 4096) == systemUiVisibility || (systemUiVisibility | 2048) == systemUiVisibility;
    }

    public static int b() {
        return -(TimeZone.getDefault().getOffset(a()) / 60000);
    }

    public static String b(Context context) {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    static void b(Context context, long j) {
        try {
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, "Mediation_Shared_Preferences", "browser_user_agent_time", String.valueOf(j));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String c() {
        String id = TimeZone.getDefault().getID();
        return id != null ? id : "";
    }

    public static boolean c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f) {
                return true;
            }
        }
        return false;
    }

    public static long d(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return -1;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static boolean d() {
        try {
            return "mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean d(String str) {
        try {
            String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (int i = 0; i < 8; i++) {
                String str2 = strArr[i];
                if (new File(str2 + str).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    public static boolean e(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = -1;
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("status", -1);
        }
        return i == 2 || i == 5;
    }

    public static int f() {
        return Build.VERSION.SDK_INT;
    }

    public static int f(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra("plugged", -1);
        }
        return -1;
    }

    public static String g() {
        return Build.MODEL;
    }

    public static boolean g(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String h() {
        return Build.MANUFACTURER;
    }

    public static boolean h(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) != 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String i() {
        return "android";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = (android.telephony.TelephonyManager) r2.getSystemService("phone");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x0013
            java.lang.String r1 = "phone"
            java.lang.Object r2 = r2.getSystemService(r1)
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2
            if (r2 == 0) goto L_0x0013
            java.lang.String r2 = r2.getNetworkOperatorName()
            return r2
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.h.i(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = (android.telephony.TelephonyManager) r2.getSystemService("phone");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String j(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x0013
            java.lang.String r1 = "phone"
            java.lang.Object r2 = r2.getSystemService(r1)
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2
            if (r2 == 0) goto L_0x0013
            java.lang.String r2 = r2.getNetworkCountryIso()
            return r2
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.h.j(android.content.Context):java.lang.String");
    }

    public static boolean j() {
        return d(DownloadCommon.DOWNLOAD_REPORT_SUCCESS);
    }

    public static int k() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int k(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static float l(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        try {
            return ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1.0f;
        }
    }

    public static int l() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int m() {
        return k();
    }

    public static int m(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getRequestedOrientation();
        }
        return -1;
    }

    public static int n() {
        return l();
    }

    public static String n(Context context) {
        if (context == null) {
            return "";
        }
        int m = m(context);
        if (m != 0) {
            if (m != 1) {
                if (m != 11) {
                    if (m != 12) {
                        switch (m) {
                            case 6:
                            case 8:
                                break;
                            case 7:
                            case 9:
                                break;
                            default:
                                return "none";
                        }
                    }
                }
            }
            return Ad.ORIENTATION_PORTRAIT;
        }
        return Ad.ORIENTATION_LANDSCAPE;
    }

    public static float o() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int o(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static long p() {
        return a(Environment.getDataDirectory());
    }

    public static List<ApplicationInfo> p(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    public static String q() {
        try {
            return d.isEmpty() ? L(ContextProvider.getInstance().getApplicationContext()) : d;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean q(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    public static File r(Context context) {
        return context.getExternalCacheDir();
    }

    public static File s(Context context) {
        return context.getExternalFilesDir((String) null);
    }

    public static File t(Context context) {
        return context.getCacheDir();
    }

    public static File u(Context context) {
        return context.getFilesDir();
    }

    public static int v(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i = 0;
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : 0;
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra("scale", -1);
            }
            if (intExtra == -1 || i == -1) {
                return -1;
            }
            return (int) ((((float) intExtra) / ((float) i)) * 100.0f);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static boolean w(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((PowerManager) context.getSystemService("power")).isPowerSaveMode();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static synchronized String x(Context context) {
        synchronized (h.class) {
            if (!TextUtils.isEmpty(b)) {
                String str = b;
                return str;
            }
            if (IronSourceSharedPreferencesUtilities.a(context, "Mediation_Shared_Preferences", "uuidEnabled", true)) {
                String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "Mediation_Shared_Preferences", "cachedUUID", "");
                if (TextUtils.isEmpty(stringFromSharedPrefs)) {
                    String uuid = UUID.randomUUID().toString();
                    b = uuid;
                    IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, "Mediation_Shared_Preferences", "cachedUUID", uuid);
                } else {
                    b = stringFromSharedPrefs;
                }
            }
            String str2 = b;
            return str2;
        }
    }

    public static synchronized String y(Context context) {
        synchronized (h.class) {
            if (!TextUtils.isEmpty(c)) {
                String str = c;
                return str;
            } else if (context == null) {
                return "";
            } else {
                String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "supersonic_shared_preferen", JsonStorageKeyNames.AUID_ID_KEY, "");
                c = stringFromSharedPrefs;
                if (TextUtils.isEmpty(stringFromSharedPrefs)) {
                    String uuid = UUID.randomUUID().toString();
                    c = uuid;
                    IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, "supersonic_shared_preferen", JsonStorageKeyNames.AUID_ID_KEY, uuid);
                }
                String str2 = c;
                return str2;
            }
        }
    }

    public static int z(Context context) {
        if (context != null) {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }
}
