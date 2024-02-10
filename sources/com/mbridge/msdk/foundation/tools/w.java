package com.mbridge.msdk.foundation.tools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.a;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ac;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* compiled from: SameDiTool */
public final class w extends g {
    private static int a = -1;
    private static int b = -1;
    /* access modifiers changed from: private */
    public static volatile int c = -1;
    /* access modifiers changed from: private */
    public static String d = "";
    private static String e = "";
    private static String f = "";
    private static String g = "";
    private static int h = 0;
    private static String i = "";
    /* access modifiers changed from: private */
    public static String j = "";
    private static int k = -1;
    private static String l = "";
    private static int m = 0;
    private static String n = "";
    private static String o = null;
    private static int p = 0;
    private static int q = -1;
    private static int r = -1;
    private static Object s = null;
    private static int t = 0;
    private static int u = 0;
    private static int v = -1;
    private static String w = "";
    private static String x = "";
    private static String y = "";
    private static int z;

    public static int c(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                return 0;
        }
    }

    private static String w(Context context) {
        try {
            if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                y = "";
            } else if (TextUtils.isEmpty(y)) {
                y = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            y = "";
        }
        return y;
    }

    public static String d(Context context) {
        try {
            if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                w = "";
            } else if (TextUtils.isEmpty(w)) {
                if (context == null) {
                    w = "";
                    return "";
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (af.b(simOperator)) {
                    w = simOperator.substring(0, Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            w = "";
        }
        return w;
    }

    public static String e(Context context) {
        try {
            if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                x = "";
            } else if (TextUtils.isEmpty(x)) {
                if (context == null) {
                    x = "";
                    return w;
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (af.b(simOperator)) {
                    x = simOperator.substring(Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            x = "";
        }
        return x;
    }

    public static int f(Context context) {
        if (q == -1) {
            q = af.c(context, "com.tencent.mm") ? 1 : 0;
        }
        return q;
    }

    public static int g() {
        if (r == -1) {
            r = af.d() ? 1 : 0;
        }
        return r;
    }

    public static Object b(String str) {
        if (s == null) {
            s = af.e(str);
        }
        return s;
    }

    public static int c(String str) {
        if (t == 0) {
            t = af.f(str);
        }
        return t;
    }

    public static int h() {
        if (u == 0) {
            u = af.e();
        }
        return u;
    }

    public static String i() {
        if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MODEL;
    }

    public static String j() {
        if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static String k() {
        if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.BRAND;
    }

    public static String g(Context context) {
        if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(i)) {
            if (context == null) {
                return "en-US";
            }
            try {
                if (context.getResources() != null) {
                    if (context.getResources().getConfiguration() != null) {
                        Locale locale = context.getResources().getConfiguration().locale;
                        if (locale == null) {
                            return "en-US";
                        }
                        if (Build.VERSION.SDK_INT >= 21) {
                            i = locale.toLanguageTag();
                        } else {
                            i = locale.getLanguage() + "-" + locale.getCountry();
                        }
                        return i;
                    }
                }
                return "en-US";
            } catch (Throwable th) {
                aa.a("SameDiTool", th.getMessage());
                i = "en-US";
            }
        }
        return i;
    }

    public static int h(Context context) {
        Configuration configuration;
        if (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null || configuration.orientation != 2) {
            return 1;
        }
        return 2;
    }

    public static int i(Context context) {
        if (context == null) {
            return h;
        }
        int i2 = h;
        if (i2 != 0) {
            return i2;
        }
        try {
            int i3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            h = i3;
            return i3;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String j(Context context) {
        if (context == null) {
            return g;
        }
        try {
            if (!TextUtils.isEmpty(g)) {
                return g;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            g = str;
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int k(Context context) {
        if (context == null) {
            return m;
        }
        if (m == 0) {
            try {
                m = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e2) {
                aa.d("SameDiTool", e2.getMessage());
            }
        }
        return m;
    }

    public static int l(Context context) {
        if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap n2 = n(context);
            return n2.get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) == null ? displayMetrics.widthPixels : ((Integer) n2.get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int m(Context context) {
        if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap n2 = n(context);
            return n2.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) == null ? displayMetrics.heightPixels : ((Integer) n2.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static HashMap n(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            hashMap.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, Integer.valueOf(displayMetrics.widthPixels));
        } catch (Exception e2) {
            aa.b("SameDiTool", e2.getMessage(), e2);
        }
        return hashMap;
    }

    public static String o(Context context) {
        if (context == null) {
            return f;
        }
        try {
            if (!TextUtils.isEmpty(f)) {
                return f;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            f = str;
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void p(final Context context) {
        if (context != null) {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    a(context);
                } else {
                    new Handler(context.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            g.a(context);
                        }
                    });
                }
            } catch (Exception e2) {
                aa.b("SameDiTool", "", e2);
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0052 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String q(android.content.Context r8) {
        /*
            com.mbridge.msdk.foundation.controller.authoritycontroller.a r0 = com.mbridge.msdk.foundation.controller.authoritycontroller.a.a()
            java.lang.String r1 = "authority_general_data"
            boolean r0 = r0.a((java.lang.String) r1)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.String r0 = d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "SameDiTool"
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = "mbridge_ua"
            java.lang.String r3 = ""
            java.lang.Object r0 = com.mbridge.msdk.foundation.tools.ai.b(r8, r0, r3)     // Catch:{ all -> 0x0027 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0027 }
            d = r0     // Catch:{ all -> 0x0027 }
            goto L_0x002f
        L_0x0027:
            r0 = move-exception
            java.lang.String r3 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r2, r3, r0)
        L_0x002f:
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch:{ all -> 0x00c3 }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x00c3 }
            r4 = 1
            r5 = 0
            if (r0 != r3) goto L_0x003d
            r0 = 1
            goto L_0x003e
        L_0x003d:
            r0 = 0
        L_0x003e:
            if (r0 == 0) goto L_0x00b4
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DNT_GUA_ON_UI     // Catch:{ all -> 0x00c3 }
            if (r0 != 0) goto L_0x00b4
            java.lang.String r0 = d     // Catch:{ all -> 0x00c3 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = android.webkit.WebSettings.getDefaultUserAgent(r8)     // Catch:{ all -> 0x0052 }
            d = r0     // Catch:{ all -> 0x0052 }
        L_0x0052:
            java.lang.String r0 = d     // Catch:{ all -> 0x00c3 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x00cb
            java.lang.Class<android.webkit.WebSettings> r0 = android.webkit.WebSettings.class
            r3 = 2
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ all -> 0x0084 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r5] = r7     // Catch:{ all -> 0x0084 }
            java.lang.Class<android.webkit.WebView> r7 = android.webkit.WebView.class
            r6[r4] = r7     // Catch:{ all -> 0x0084 }
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r6)     // Catch:{ all -> 0x0084 }
            r0.setAccessible(r4)     // Catch:{ all -> 0x0084 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0084 }
            r3[r5] = r8     // Catch:{ all -> 0x0084 }
            r3[r4] = r1     // Catch:{ all -> 0x0084 }
            java.lang.Object r1 = r0.newInstance(r3)     // Catch:{ all -> 0x0084 }
            android.webkit.WebSettings r1 = (android.webkit.WebSettings) r1     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = r1.getUserAgentString()     // Catch:{ all -> 0x0084 }
            d = r1     // Catch:{ all -> 0x0084 }
            r0.setAccessible(r5)     // Catch:{ all -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00c3 }
        L_0x0088:
            java.lang.String r0 = d     // Catch:{ all -> 0x00c3 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x00a4
            android.webkit.WebView r0 = new android.webkit.WebView     // Catch:{ all -> 0x00a0 }
            r0.<init>(r8)     // Catch:{ all -> 0x00a0 }
            android.webkit.WebSettings r0 = r0.getSettings()     // Catch:{ all -> 0x00a0 }
            java.lang.String r0 = r0.getUserAgentString()     // Catch:{ all -> 0x00a0 }
            d = r0     // Catch:{ all -> 0x00a0 }
            goto L_0x00a4
        L_0x00a0:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00c3 }
        L_0x00a4:
            java.lang.String r0 = d     // Catch:{ all -> 0x00c3 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x00cb
            B()     // Catch:{ all -> 0x00c3 }
            goto L_0x00cb
        L_0x00b0:
            x(r8)     // Catch:{ all -> 0x00c3 }
            goto L_0x00cb
        L_0x00b4:
            java.lang.String r0 = d     // Catch:{ all -> 0x00c3 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x00bf
            B()     // Catch:{ all -> 0x00c3 }
        L_0x00bf:
            x(r8)     // Catch:{ all -> 0x00c3 }
            goto L_0x00cb
        L_0x00c3:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r2, r1, r0)
        L_0x00cb:
            y(r8)
            java.lang.String r8 = d
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.w.q(android.content.Context):java.lang.String");
    }

    private static void x(final Context context) {
        try {
            new Thread(new Runnable() {
                public final void run() {
                    String str;
                    try {
                        str = WebSettings.getDefaultUserAgent(context);
                    } catch (Throwable unused) {
                        str = null;
                    }
                    try {
                        if (!TextUtils.isEmpty(str) && !str.equals(w.d)) {
                            String unused2 = w.d = str;
                            w.y(context);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static void y(Context context) {
        try {
            ai.a(context, "mbridge_ua", d);
        } catch (Throwable th) {
            aa.b("SameDiTool", th.getMessage(), th);
        }
    }

    public static String l() {
        if (TextUtils.isEmpty(d)) {
            q(b.d().g());
        }
        return d;
    }

    private static void B() {
        String str = Build.VERSION.RELEASE;
        String i2 = i();
        String str2 = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(i2)) {
            d = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
            return;
        }
        StringBuilder sb = new StringBuilder("Mozilla/5.0 (Linux; Android ");
        sb.append(str);
        sb.append("; ");
        sb.append(i2);
        sb.append(" Build/");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
        d = sb.toString();
    }

    public static int r(Context context) {
        try {
            final Context g2 = b.d().g();
            if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return c;
            }
            if (g2 == null) {
                return c;
            }
            if (c != -1) {
                try {
                    AnonymousClass3 r2 = new Runnable() {
                        public final void run() {
                            try {
                                ConnectivityManager connectivityManager = (ConnectivityManager) g2.getSystemService("connectivity");
                                if (connectivityManager != null && com.mbridge.msdk.foundation.same.a.c) {
                                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                    if (activeNetworkInfo == null) {
                                        int unused = w.c = 0;
                                    } else if (activeNetworkInfo.getType() == 1) {
                                        int unused2 = w.c = 9;
                                    } else {
                                        TelephonyManager telephonyManager = (TelephonyManager) g2.getSystemService("phone");
                                        if (telephonyManager == null) {
                                            int unused3 = w.c = 0;
                                        } else {
                                            int unused4 = w.c = w.c(telephonyManager.getNetworkType());
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                aa.b("SameDiTool", e.getMessage(), e);
                                int unused5 = w.c = 0;
                            }
                        }
                    };
                    if (com.mbridge.msdk.foundation.same.f.b.c().getActiveCount() < 1) {
                        com.mbridge.msdk.foundation.same.f.b.c().execute(r2);
                    }
                } catch (Throwable th) {
                    aa.d("SameDiTool", th.getMessage());
                }
                return c;
            }
            c = 0;
            return c;
        } catch (Exception e2) {
            aa.b("SameDiTool", e2.getMessage(), e2);
            c = 0;
            return c;
        }
    }

    public static String a(Context context, int i2) {
        TelephonyManager telephonyManager;
        if (i2 == 0 || i2 == 9) {
            return "";
        }
        try {
            if (!com.mbridge.msdk.foundation.same.a.c || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                return "";
            }
            return String.valueOf(telephonyManager.getNetworkType());
        } catch (Throwable th) {
            aa.b("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    public static String m() {
        try {
            if (!a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                return "";
            }
            if (TextUtils.isEmpty(j)) {
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            String unused = w.j = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }).start();
                return j;
            }
            return j;
        } catch (Throwable th) {
            aa.b("SameDiTool", th.getMessage(), th);
        }
    }

    public static String n() {
        if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(e)) {
            int o2 = o();
            e = o2 + "";
        }
        return e;
    }

    public static int o() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int p() {
        if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return -1;
        }
        return Build.VERSION.SDK_INT;
    }

    public static String a(String str, Context context) {
        try {
            if (!TextUtils.isEmpty(l)) {
                return l;
            }
            if (!TextUtils.isEmpty(str) && context != null) {
                l = context.getPackageManager().getInstallerPackageName(str);
                aa.a("SameDiTool", "PKGSource:" + l);
            }
            return l;
        } catch (Exception e2) {
            aa.b("SameDiTool", e2.getMessage(), e2);
        }
    }

    public static boolean s(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static String q() {
        if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MANUFACTURER;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x006b */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008a A[SYNTHETIC, Splitter:B:31:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0091 A[SYNTHETIC, Splitter:B:35:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a2 A[SYNTHETIC, Splitter:B:42:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a9 A[SYNTHETIC, Splitter:B:46:0x00a9] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0081=Splitter:B:28:0x0081, B:39:0x0099=Splitter:B:39:0x0099} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String r() {
        /*
            java.lang.String r0 = "SameDiTool"
            com.mbridge.msdk.foundation.controller.authoritycontroller.a r1 = com.mbridge.msdk.foundation.controller.authoritycontroller.a.a()
            java.lang.String r2 = "authority_general_data"
            boolean r1 = r1.a((java.lang.String) r2)
            if (r1 != 0) goto L_0x0011
            java.lang.String r0 = ""
            return r0
        L_0x0011:
            int r1 = p
            java.lang.String r2 = "GB"
            if (r1 <= 0) goto L_0x0029
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = p
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0029:
            java.lang.String r1 = "/proc/meminfo"
            r3 = 0
            p = r3
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x0095, all -> 0x007d }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0095, all -> 0x007d }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0078, all -> 0x0073 }
            r5 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r4, r5)     // Catch:{ Exception -> 0x0078, all -> 0x0073 }
            java.lang.String r3 = r1.readLine()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r5 = 1
            r3 = r3[r5]     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r1.close()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            if (r3 == 0) goto L_0x0068
            java.lang.Float r5 = new java.lang.Float     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            float r3 = r3.floatValue()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r6 = 1233125376(0x49800000, float:1048576.0)
            float r3 = r3 / r6
            r5.<init>(r3)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            double r5 = r5.doubleValue()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            double r5 = java.lang.Math.ceil(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            int r3 = (int) r5     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            p = r3     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        L_0x0068:
            r4.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            r1.close()     // Catch:{ IOException -> 0x00ad }
            goto L_0x00b1
        L_0x006f:
            r3 = move-exception
            goto L_0x0081
        L_0x0071:
            r3 = move-exception
            goto L_0x0099
        L_0x0073:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0081
        L_0x0078:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0099
        L_0x007d:
            r1 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
        L_0x0081:
            java.lang.String r5 = r3.getMessage()     // Catch:{ all -> 0x00c3 }
            com.mbridge.msdk.foundation.tools.aa.b(r0, r5, r3)     // Catch:{ all -> 0x00c3 }
            if (r4 == 0) goto L_0x008f
            r4.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x008f
        L_0x008e:
        L_0x008f:
            if (r1 == 0) goto L_0x00b1
            r1.close()     // Catch:{ IOException -> 0x00ad }
            goto L_0x00b1
        L_0x0095:
            r1 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
        L_0x0099:
            java.lang.String r5 = r3.getMessage()     // Catch:{ all -> 0x00c3 }
            com.mbridge.msdk.foundation.tools.aa.b(r0, r5, r3)     // Catch:{ all -> 0x00c3 }
            if (r4 == 0) goto L_0x00a7
            r4.close()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00a7
        L_0x00a6:
        L_0x00a7:
            if (r1 == 0) goto L_0x00b1
            r1.close()     // Catch:{ IOException -> 0x00ad }
            goto L_0x00b1
        L_0x00ad:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = p
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00c3:
            r0 = move-exception
            if (r4 == 0) goto L_0x00cb
            r4.close()     // Catch:{ IOException -> 0x00ca }
            goto L_0x00cb
        L_0x00ca:
        L_0x00cb:
            if (r1 == 0) goto L_0x00d5
            r1.close()     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00d5
        L_0x00d1:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00d5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.w.r():java.lang.String");
    }

    public static String t(Context context) {
        if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return "";
        }
        try {
            return Settings.System.getString(context.getContentResolver(), "time_12_24");
        } catch (Exception e2) {
            aa.b("SameDiTool", e2.getMessage(), e2);
            return "";
        } catch (Throwable th) {
            aa.b("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.io.FileReader} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b A[SYNTHETIC, Splitter:B:36:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0089 A[SYNTHETIC, Splitter:B:41:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0098 A[SYNTHETIC, Splitter:B:48:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a6 A[SYNTHETIC, Splitter:B:53:0x00a6] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0072=Splitter:B:33:0x0072, B:45:0x008f=Splitter:B:45:0x008f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String u(android.content.Context r9) {
        /*
            java.lang.String r0 = "SameDiTool"
            com.mbridge.msdk.foundation.controller.authoritycontroller.a r1 = com.mbridge.msdk.foundation.controller.authoritycontroller.a.a()
            java.lang.String r2 = "authority_general_data"
            boolean r1 = r1.a((java.lang.String) r2)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0011
            return r2
        L_0x0011:
            if (r9 != 0) goto L_0x0014
            return r2
        L_0x0014:
            java.lang.String r1 = o
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x001f
            java.lang.String r9 = o
            return r9
        L_0x001f:
            java.lang.String r1 = "/proc/meminfo"
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x008d, all -> 0x0070 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x008d, all -> 0x0070 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r5 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            java.lang.String r3 = r1.readLine()     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r5 = 1
            r3 = r3[r5]     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            long r5 = r3.longValue()     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r7 = 1024(0x400, double:5.06E-321)
            long r5 = r5 * r7
            java.lang.String r9 = android.text.format.Formatter.formatFileSize(r9, r5)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            o = r9     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r1.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0059
        L_0x0051:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r0, r2, r1)
        L_0x0059:
            r4.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0065
        L_0x005d:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r0, r2, r1)
        L_0x0065:
            return r9
        L_0x0066:
            r9 = move-exception
            r3 = r1
            goto L_0x0072
        L_0x0069:
            r9 = move-exception
            r3 = r1
            goto L_0x008f
        L_0x006c:
            r9 = move-exception
            goto L_0x0072
        L_0x006e:
            r9 = move-exception
            goto L_0x008f
        L_0x0070:
            r9 = move-exception
            r4 = r3
        L_0x0072:
            java.lang.String r1 = r9.getMessage()     // Catch:{ all -> 0x00b3 }
            com.mbridge.msdk.foundation.tools.aa.b(r0, r1, r9)     // Catch:{ all -> 0x00b3 }
            if (r3 == 0) goto L_0x0087
            r3.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x0087
        L_0x007f:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r0, r1, r9)
        L_0x0087:
            if (r4 == 0) goto L_0x00b2
            r4.close()     // Catch:{ IOException -> 0x00aa }
            goto L_0x00b2
        L_0x008d:
            r9 = move-exception
            r4 = r3
        L_0x008f:
            java.lang.String r1 = r9.getMessage()     // Catch:{ all -> 0x00b3 }
            com.mbridge.msdk.foundation.tools.aa.b(r0, r1, r9)     // Catch:{ all -> 0x00b3 }
            if (r3 == 0) goto L_0x00a4
            r3.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x00a4
        L_0x009c:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r0, r1, r9)
        L_0x00a4:
            if (r4 == 0) goto L_0x00b2
            r4.close()     // Catch:{ IOException -> 0x00aa }
            goto L_0x00b2
        L_0x00aa:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r0, r1, r9)
        L_0x00b2:
            return r2
        L_0x00b3:
            r9 = move-exception
            if (r3 == 0) goto L_0x00c2
            r3.close()     // Catch:{ IOException -> 0x00ba }
            goto L_0x00c2
        L_0x00ba:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r0, r2, r1)
        L_0x00c2:
            if (r4 == 0) goto L_0x00d0
            r4.close()     // Catch:{ IOException -> 0x00c8 }
            goto L_0x00d0
        L_0x00c8:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r0, r2, r1)
        L_0x00d0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.w.u(android.content.Context):java.lang.String");
    }

    public static String s() {
        String str = "";
        try {
            Context g2 = b.d().g();
            long a2 = v.a();
            long C = C();
            String w2 = w(g2);
            String str2 = "app_tki_" + a2 + "_" + C + "_" + w2;
            String str3 = (String) ai.b(g2, str2, str);
            try {
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("1", w2);
                    jSONObject.put("2", String.valueOf(C));
                    jSONObject.put(ExifInterface.GPS_MEASUREMENT_3D, String.valueOf(a2));
                    jSONObject.put("4", str);
                    jSONObject.put(CampaignEx.CLICKMODE_ON, str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                str = a.a(jSONObject.toString());
                ai.a(g2, str2, str);
                return str;
            } catch (Exception e3) {
                e = e3;
                str = str3;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static int t() {
        try {
            if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return 0;
            }
            Context g2 = b.d().g();
            long j2 = 0;
            long longValue = ((Long) ai.b(g2, "FreeRamSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || b == -1) {
                Context g3 = b.d().g();
                if (g3 != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) g3.getSystemService("activity")).getMemoryInfo(memoryInfo);
                    j2 = memoryInfo.availMem;
                }
                b = Long.valueOf((j2 / 1000) / 1000).intValue();
                ai.a(g2, "FreeRamSize", Long.valueOf(currentTimeMillis));
            }
            return b;
        } catch (Throwable th) {
            aa.b("SameDiTool", th.getMessage(), th);
        }
    }

    private static long C() {
        Context g2 = b.d().g();
        if (g2 == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) g2.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static String u() {
        a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA);
        return "";
    }

    public static int v() {
        if (!a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return 0;
        }
        if (a < 1) {
            try {
                Context g2 = b.d().g();
                long longValue = ((Long) ai.b(g2, "TotalRamSize", 0L)).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - longValue > 1800000 || a == -1) {
                    a = Long.valueOf((C() / 1000) / 1000).intValue();
                    ai.a(g2, "TotalRamSize", Long.valueOf(currentTimeMillis));
                }
            } catch (Throwable th) {
                aa.b("SameDiTool", th.getMessage(), th);
            }
        }
        return a;
    }

    public static int w() {
        return k;
    }

    private static String D() {
        String str;
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable th) {
            aa.d("SameDiTool", th.getMessage());
            str = null;
        }
        try {
            if (TextUtils.isEmpty(str) || !str.equals("harmony")) {
                n = "android";
                return n;
            }
            jSONObject.put("osType", str);
            Class<?> cls2 = Class.forName("ohos.system.version.SystemVersion");
            jSONObject.put("version", (String) cls2.getMethod(MobileAdsBridge.versionMethodName, new Class[0]).invoke(cls2, new Object[0]));
            try {
                jSONObject.put("pure_state", Settings.Secure.getInt(b.d().g().getContentResolver(), "pure_mode_state", -1));
            } catch (Throwable th2) {
                aa.d("SameDiTool", th2.getMessage());
            }
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                jSONObject2 = u.a(jSONObject2);
            }
            n = jSONObject2;
            return n;
        } catch (Throwable th3) {
            aa.d("SameDiTool", th3.getMessage());
        }
    }

    public static void d(int i2) {
        v = i2;
    }

    public static int x() {
        return v;
    }

    public static void z() {
        try {
            Object b2 = ai.b(b.d().g(), MBridgeConstans.SP_GA_ID, "");
            Object b3 = ai.b(b.d().g(), MBridgeConstans.SP_GA_ID_LIMIT, 0);
            if (b2 instanceof String) {
                String str = (String) b2;
                if (!TextUtils.isEmpty(str)) {
                    a(str);
                }
                if (b3 instanceof Integer) {
                    a(((Integer) b3).intValue());
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.d("SameDiTool", e2.getMessage());
            }
        }
    }

    public static void c(Context context) {
        try {
            g.b(context);
            n();
            o(context);
            j(context);
            i(context);
            h(context);
            i();
            k();
            g(context);
            m();
            com.mbridge.msdk.foundation.same.a.d = false;
            com.mbridge.msdk.foundation.same.a.c = af.a("android.permission.ACCESS_NETWORK_STATE", context);
            k(context);
            D();
            d();
        } catch (Throwable th) {
            aa.d("SameDiTool", th.getMessage());
        }
    }

    public static int y() {
        try {
            if (!ac.a.a.a("v_a_d_p", false)) {
                return 0;
            }
            if (af.h()) {
                z = 1;
            } else if (af.i()) {
                z = 2;
            } else {
                z = 0;
            }
            return z;
        } catch (Exception e2) {
            z = 0;
            aa.d("SameDiTool", e2.getMessage());
        }
    }
}
