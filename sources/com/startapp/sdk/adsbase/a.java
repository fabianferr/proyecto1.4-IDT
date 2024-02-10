package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.browser.customtabs.CustomTabsIntent;
import com.applovin.impl.sdk.utils.Utils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.startapp.a0;
import com.startapp.h2;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.k9;
import com.startapp.sdk.ads.interstitials.OverlayActivity;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.common.Constants;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.t8;
import com.startapp.z5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public class a {
    public static Handler a;
    public static ProgressDialog b;

    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.CharSequence] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r2, java.lang.String r3) {
        /*
            android.content.res.Resources r0 = r2.getResources()     // Catch:{ all -> 0x000f }
            android.content.pm.ApplicationInfo r1 = r2.getApplicationInfo()     // Catch:{ all -> 0x000f }
            int r1 = r1.labelRes     // Catch:{ all -> 0x000f }
            java.lang.String r2 = r0.getString(r1)     // Catch:{ all -> 0x000f }
            return r2
        L_0x000f:
            android.content.pm.PackageManager r0 = r2.getPackageManager()
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo()     // Catch:{ all -> 0x001f }
            java.lang.String r2 = r2.packageName     // Catch:{ all -> 0x001f }
            r1 = 0
            android.content.pm.ApplicationInfo r2 = r0.getApplicationInfo(r2, r1)     // Catch:{ all -> 0x001f }
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            if (r2 == 0) goto L_0x0026
            java.lang.CharSequence r3 = r0.getApplicationLabel(r2)
        L_0x0026:
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static boolean b(String str) {
        return str.startsWith(Utils.PLAY_STORE_SCHEME) || str.startsWith("http://play.google.com") || str.startsWith("https://play.google.com");
    }

    public static boolean c(String str) {
        return str != null && (str.startsWith("http://") || str.startsWith("https://"));
    }

    public static void b(Context context, String str, String str2) {
        boolean c = c(str);
        if (context != null) {
            int i = (AdsCommonMetaData.h.J() || !(context instanceof Activity)) ? 344457216 : 76021760;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(i);
            boolean a2 = a(context, intent);
            if (!a2) {
                try {
                    if (MetaData.k.k() && ComponentLocator.a(context).e().getBoolean("chromeTabs", false)) {
                        a(context, str, c);
                        return;
                    }
                } catch (Throwable th) {
                    i3.a(th);
                    return;
                }
            }
            if (c && !a2) {
                a(context, intent, i);
            }
            context.startActivity(intent);
        }
    }

    public static void c(Context context) {
        if (context != null && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            Map<Activity, Integer> map = k9.a;
            k9.a(activity, activity.getResources().getConfiguration().orientation, false);
        }
        ProgressDialog progressDialog = b;
        if (progressDialog != null) {
            synchronized (progressDialog) {
                ProgressDialog progressDialog2 = b;
                if (progressDialog2 != null && progressDialog2.isShowing()) {
                    try {
                        b.cancel();
                    } catch (Throwable th) {
                        i3.a(th);
                    }
                    b = null;
                }
            }
        }
    }

    public static boolean a(Activity activity) {
        boolean z = activity.getTheme().obtainStyledAttributes(new int[]{16843277}).getBoolean(0, false);
        if ((activity.getWindow().getAttributes().flags & 1024) != 0) {
            return true;
        }
        return z;
    }

    public static int a(String str) {
        String[] split = str.split("&");
        return Integer.parseInt(split[split.length - 1].split("=")[1]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r18, java.lang.String r19, java.lang.String[] r20, java.lang.String r21, com.startapp.sdk.adsbase.commontracking.TrackingParams r22, long r23, long r25, boolean r27, java.lang.Boolean r28, boolean r29, java.lang.Runnable r30) {
        /*
            r15 = r18
            r0 = r21
            com.startapp.sdk.adsbase.AdsCommonMetaData r1 = com.startapp.sdk.adsbase.AdsCommonMetaData.h
            boolean r1 = r1.N()
            if (r1 == 0) goto L_0x01b7
            r2 = r19
            r3 = r20
            r4 = r22
            r6 = r29
            android.util.Pair r1 = a((android.content.Context) r15, (java.lang.String[]) r3, (java.lang.String) r2, (com.startapp.sdk.adsbase.commontracking.TrackingParams) r4, (boolean) r6)
            java.lang.Object r3 = r1.first
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.second
            r14 = r1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.StringBuilder r1 = com.startapp.p0.a(r19)
            com.startapp.sdk.adsbase.AdsCommonMetaData r2 = com.startapp.sdk.adsbase.AdsCommonMetaData.h
            boolean r2 = r2.M()
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x0038
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r2 = 0
            goto L_0x0039
        L_0x0038:
            r2 = 1
        L_0x0039:
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0042
            java.lang.String r2 = com.startapp.a.c(r14)
            goto L_0x0043
        L_0x0042:
            r2 = r3
        L_0x0043:
            r1.append(r2)
            java.lang.String r13 = r1.toString()
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "com.startapp.android.OnClickCallback"
            r1.<init>(r2)
            java.lang.String r2 = "dParam"
            r1.putExtra(r2, r14)
            com.startapp.w4 r2 = com.startapp.w4.a((android.content.Context) r18)
            r2.a((android.content.Intent) r1)
            boolean r1 = b((java.lang.String) r13)
            if (r1 == 0) goto L_0x00ab
            if (r0 == 0) goto L_0x00a1
            boolean r1 = r0.equals(r3)
            if (r1 != 0) goto L_0x00a1
            java.lang.String r1 = r13.toLowerCase()
            java.lang.String r2 = r21.toLowerCase()
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x00a1
            com.startapp.i3 r1 = new com.startapp.i3
            com.startapp.j3 r2 = com.startapp.j3.e
            r1.<init>((com.startapp.j3) r2)
            java.lang.String r2 = "Wrong package reached"
            r1.d = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = ", Link: "
            r2.append(r0)
            r2.append(r13)
            java.lang.String r0 = r2.toString()
            r1.e = r0
            r1.g = r14
            r1.a()
        L_0x00a1:
            b(r15, r13, r14)
            if (r30 == 0) goto L_0x01c7
            r30.run()
            goto L_0x01c7
        L_0x00ab:
            boolean r1 = r15 instanceof android.app.Activity
            if (r1 == 0) goto L_0x00b5
            r1 = r15
            android.app.Activity r1 = (android.app.Activity) r1
            com.startapp.k9.a((android.app.Activity) r1, (boolean) r5)
        L_0x00b5:
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r18)     // Catch:{ all -> 0x01a3 }
            com.startapp.va r1 = r1.x()     // Catch:{ all -> 0x01a3 }
            android.webkit.WebView r12 = r1.b()     // Catch:{ all -> 0x01a3 }
            android.app.ProgressDialog r1 = b     // Catch:{ all -> 0x01a3 }
            if (r1 != 0) goto L_0x014e
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01a3 }
            r2 = 22
            if (r1 < r2) goto L_0x00d6
            android.app.ProgressDialog r2 = new android.app.ProgressDialog     // Catch:{ all -> 0x01a3 }
            r3 = 16974545(0x10302d1, float:2.406292E-38)
            r2.<init>(r15, r3)     // Catch:{ all -> 0x01a3 }
            b = r2     // Catch:{ all -> 0x01a3 }
            goto L_0x00dd
        L_0x00d6:
            android.app.ProgressDialog r2 = new android.app.ProgressDialog     // Catch:{ all -> 0x01a3 }
            r2.<init>(r15)     // Catch:{ all -> 0x01a3 }
            b = r2     // Catch:{ all -> 0x01a3 }
        L_0x00dd:
            android.app.ProgressDialog r2 = b     // Catch:{ all -> 0x01a3 }
            r3 = 0
            r2.setTitle(r3)     // Catch:{ all -> 0x01a3 }
            android.app.ProgressDialog r2 = b     // Catch:{ all -> 0x01a3 }
            java.lang.String r3 = "Loading...."
            r2.setMessage(r3)     // Catch:{ all -> 0x01a3 }
            android.app.ProgressDialog r2 = b     // Catch:{ all -> 0x01a3 }
            r2.setIndeterminate(r4)     // Catch:{ all -> 0x01a3 }
            android.app.ProgressDialog r2 = b     // Catch:{ all -> 0x01a3 }
            r2.setCancelable(r4)     // Catch:{ all -> 0x01a3 }
            android.app.ProgressDialog r2 = b     // Catch:{ all -> 0x01a3 }
            com.startapp.s r3 = new com.startapp.s     // Catch:{ all -> 0x01a3 }
            r3.<init>(r12)     // Catch:{ all -> 0x01a3 }
            r2.setOnCancelListener(r3)     // Catch:{ all -> 0x01a3 }
            boolean r2 = r15 instanceof android.app.Activity     // Catch:{ all -> 0x01a3 }
            if (r2 == 0) goto L_0x0111
            r2 = r15
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ all -> 0x01a3 }
            boolean r2 = r2.isFinishing()     // Catch:{ all -> 0x01a3 }
            if (r2 != 0) goto L_0x0111
            android.app.ProgressDialog r1 = b     // Catch:{ all -> 0x01a3 }
            r1.show()     // Catch:{ all -> 0x01a3 }
            goto L_0x014e
        L_0x0111:
            boolean r2 = r15 instanceof android.app.Activity     // Catch:{ all -> 0x01a3 }
            if (r2 != 0) goto L_0x014e
            r2 = 23
            if (r1 < r2) goto L_0x011e
            boolean r2 = android.provider.Settings.canDrawOverlays(r18)     // Catch:{ all -> 0x01a3 }
            goto L_0x0124
        L_0x011e:
            java.lang.String r2 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r2 = com.startapp.a0.a((android.content.Context) r15, (java.lang.String) r2)     // Catch:{ all -> 0x01a3 }
        L_0x0124:
            if (r2 == 0) goto L_0x014e
            android.app.ProgressDialog r2 = b     // Catch:{ all -> 0x01a3 }
            android.view.Window r2 = r2.getWindow()     // Catch:{ all -> 0x01a3 }
            if (r2 == 0) goto L_0x014e
            r2 = 26
            if (r1 < r2) goto L_0x013e
            android.app.ProgressDialog r1 = b     // Catch:{ all -> 0x01a3 }
            android.view.Window r1 = r1.getWindow()     // Catch:{ all -> 0x01a3 }
            r2 = 2038(0x7f6, float:2.856E-42)
            r1.setType(r2)     // Catch:{ all -> 0x01a3 }
            goto L_0x0149
        L_0x013e:
            android.app.ProgressDialog r1 = b     // Catch:{ all -> 0x01a3 }
            android.view.Window r1 = r1.getWindow()     // Catch:{ all -> 0x01a3 }
            r2 = 2003(0x7d3, float:2.807E-42)
            r1.setType(r2)     // Catch:{ all -> 0x01a3 }
        L_0x0149:
            android.app.ProgressDialog r1 = b     // Catch:{ all -> 0x01a3 }
            r1.show()     // Catch:{ all -> 0x01a3 }
        L_0x014e:
            android.webkit.WebSettings r1 = r12.getSettings()     // Catch:{ all -> 0x01a3 }
            r1.setJavaScriptEnabled(r5)     // Catch:{ all -> 0x01a3 }
            android.webkit.WebChromeClient r1 = new android.webkit.WebChromeClient     // Catch:{ all -> 0x01a3 }
            r1.<init>()     // Catch:{ all -> 0x01a3 }
            r12.setWebChromeClient(r1)     // Catch:{ all -> 0x01a3 }
            com.startapp.q5 r11 = new com.startapp.q5     // Catch:{ all -> 0x01a3 }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r18)     // Catch:{ all -> 0x01a3 }
            com.startapp.sdk.adsbase.e r3 = r1.e()     // Catch:{ all -> 0x01a3 }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r18)     // Catch:{ all -> 0x01a3 }
            java.util.concurrent.Executor r4 = r1.l()     // Catch:{ all -> 0x01a3 }
            android.os.Handler r5 = new android.os.Handler     // Catch:{ all -> 0x01a3 }
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x01a3 }
            r5.<init>(r1)     // Catch:{ all -> 0x01a3 }
            r1 = r11
            r2 = r18
            r6 = r23
            r8 = r25
            r10 = r27
            r0 = r11
            r11 = r28
            r16 = r12
            r12 = r13
            r17 = r13
            r13 = r21
            r19 = r14
            r15 = r30
            r1.<init>(r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x019f }
            r1 = r16
            r1.setWebViewClient(r0)     // Catch:{ all -> 0x019f }
            r2 = r17
            r1.loadUrl(r2)     // Catch:{ all -> 0x019d }
            goto L_0x01c7
        L_0x019d:
            r0 = move-exception
            goto L_0x01a7
        L_0x019f:
            r0 = move-exception
            r2 = r17
            goto L_0x01a7
        L_0x01a3:
            r0 = move-exception
            r2 = r13
            r19 = r14
        L_0x01a7:
            com.startapp.i3.a((java.lang.Throwable) r0)
            r1 = r18
            r3 = r19
            b(r1, r2, r3)
            if (r30 == 0) goto L_0x01c7
            r30.run()
            goto L_0x01c7
        L_0x01b7:
            r2 = r19
            r3 = r20
            r4 = r22
            r6 = r29
            r1 = r15
            r1 = r18
            r5 = r27
            a((android.content.Context) r1, (java.lang.String) r2, (java.lang.String[]) r3, (com.startapp.sdk.adsbase.commontracking.TrackingParams) r4, (boolean) r5, (boolean) r6)
        L_0x01c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.a.a(android.content.Context, java.lang.String, java.lang.String[], java.lang.String, com.startapp.sdk.adsbase.commontracking.TrackingParams, long, long, boolean, java.lang.Boolean, boolean, java.lang.Runnable):void");
    }

    public static boolean b(Context context) {
        ComponentLocator a2 = ComponentLocator.a(context);
        if (a2.a().a().c) {
            return false;
        }
        long j = a2.e().getLong("shared_prefs_CookieFeatureTS", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (j == 0 || (((long) AdsCommonMetaData.h.e()) * 86400000) + j <= currentTimeMillis) {
            return true;
        }
        return false;
    }

    public static void a(String[] strArr, String str, int i, String str2) {
        TrackingParams a2 = new TrackingParams(str).a(i).a(str2);
        if (strArr == null || strArr.length == 0) {
            i3 i3Var = new i3(j3.e);
            i3Var.d = "Non-impression without trackingUrls";
            i3Var.i = str2;
            i3Var.e = k9.a(a2.d());
            i3Var.a();
            return;
        }
        for (String str3 : strArr) {
            if (str3 != null && str3.length() > 0) {
                i3 i3Var2 = new i3(j3.k);
                i3Var2.e = t8.a(str3, a2);
                i3Var2.a();
            }
        }
    }

    public static List<String> a(List<String> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            int i2 = i + 5;
            List<String> subList = list.subList(i, Math.min(i2, list.size()));
            StringBuilder sb = new StringBuilder();
            sb.append(AdsConstants.e);
            sb.append("?");
            sb.append(TextUtils.join("&", subList));
            sb.append("&isShown=");
            sb.append(str);
            sb.append("&appPresence=" + str2);
            arrayList.add(sb.toString());
            i = i2;
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020 A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0085 A[Catch:{ all -> 0x0089 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r2, java.lang.String r3, java.lang.String[] r4, com.startapp.sdk.adsbase.commontracking.TrackingParams r5, boolean r6, boolean r7) {
        /*
            android.util.Pair r4 = a((android.content.Context) r2, (java.lang.String[]) r4, (java.lang.String) r3, (com.startapp.sdk.adsbase.commontracking.TrackingParams) r5, (boolean) r7)
            java.lang.Object r5 = r4.first
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.second
            java.lang.String r4 = (java.lang.String) r4
            com.startapp.sdk.adsbase.AdsCommonMetaData r7 = com.startapp.sdk.adsbase.AdsCommonMetaData.h     // Catch:{ all -> 0x0089 }
            boolean r7 = r7.M()     // Catch:{ all -> 0x0089 }
            if (r7 != 0) goto L_0x001d
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0089 }
            if (r7 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r7 = 0
            goto L_0x001e
        L_0x001d:
            r7 = 1
        L_0x001e:
            if (r7 == 0) goto L_0x0033
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            r7.<init>()     // Catch:{ all -> 0x0089 }
            r7.append(r3)     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = com.startapp.a.c(r4)     // Catch:{ all -> 0x0089 }
            r7.append(r3)     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x0089 }
        L_0x0033:
            com.startapp.sdk.adsbase.remoteconfig.MetaData r7 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k     // Catch:{ all -> 0x0089 }
            boolean r7 = r7.U()     // Catch:{ all -> 0x0089 }
            if (r7 == 0) goto L_0x0041
            if (r6 == 0) goto L_0x0041
            a((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0089 }
            goto L_0x008d
        L_0x0041:
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0089 }
            r5 = 0
            if (r4 == 0) goto L_0x0085
            boolean r4 = b((android.content.Context) r2)     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x0085
            com.startapp.sdk.components.ComponentLocator r4 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r2)     // Catch:{ all -> 0x0089 }
            com.startapp.sdk.adsbase.e r4 = r4.e()     // Catch:{ all -> 0x0089 }
            com.startapp.sdk.adsbase.e$a r4 = r4.edit()     // Catch:{ all -> 0x0089 }
            java.lang.String r6 = "shared_prefs_CookieFeatureTS"
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0089 }
            java.lang.Long r7 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0089 }
            r4.a((java.lang.String) r6, r7)     // Catch:{ all -> 0x0089 }
            android.content.SharedPreferences$Editor r7 = r4.a     // Catch:{ all -> 0x0089 }
            r7.putLong(r6, r0)     // Catch:{ all -> 0x0089 }
            r4.apply()     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            r4.<init>()     // Catch:{ all -> 0x0089 }
            r4.append(r3)     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = "&cki=1"
            r4.append(r3)     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0089 }
            b(r2, r3, r5)     // Catch:{ all -> 0x0089 }
            goto L_0x008d
        L_0x0085:
            b(r2, r3, r5)     // Catch:{ all -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r2 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r2)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.a.a(android.content.Context, java.lang.String, java.lang.String[], com.startapp.sdk.adsbase.commontracking.TrackingParams, boolean, boolean):void");
    }

    public static Pair<String, String> a(Context context, String[] strArr, String str, TrackingParams trackingParams, boolean z) {
        String str2;
        String str3;
        int i = 0;
        if (strArr != null) {
            for (String str4 : strArr) {
                if (!TextUtils.isEmpty(str4)) {
                    a(context, str4, trackingParams);
                }
            }
        }
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
        startAppSDKInternal.m = true;
        startAppSDKInternal.e = true;
        String str5 = null;
        if (z || strArr == null) {
            str2 = null;
        } else {
            try {
                int length = strArr.length;
                str2 = null;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    try {
                        str3 = strArr[i];
                        str2 = a(str, str3);
                        if (str2 != null || k9.c(str3)) {
                            str5 = str3;
                        } else {
                            i++;
                        }
                    } catch (Throwable th) {
                        th = th;
                        i3.a(th);
                        return new Pair<>(str5, str2);
                    }
                }
                str5 = str3;
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
                i3.a(th);
                return new Pair<>(str5, str2);
            }
        }
        return new Pair<>(str5, str2);
    }

    public static void a(Context context, String str, TrackingParams trackingParams) {
        if (context != null) {
            if (str != null && str.length() > 0) {
                t8.a(context, str, trackingParams, (h2<String, z5.a, Throwable, Void>) null);
            }
            k9.a(context, 4, TextUtils.isEmpty(str) ? "Closed Ad" : "Clicked Ad", true);
        }
    }

    public static void a(Context context, Intent intent, int i) {
        String[] strArr = {"com.android.chrome", "com.android.browser", "com.opera.mini.native", "org.mozilla.firefox", "com.opera.browser"};
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, i);
            if (queryIntentActivities != null && queryIntentActivities.size() > 1) {
                for (int i2 = 0; i2 < 5; i2++) {
                    String str = strArr[i2];
                    if (a0.a(context, str, 0)) {
                        intent.setPackage(str);
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            i3.a(th);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            i3 i3Var = new i3(j3.e);
            i3Var.d = "Can not open in app browser, clickUrl is empty";
            if (str2 != null) {
                i3Var.g = str2;
            }
            i3Var.a();
        } else if (!b(str)) {
            Map<Activity, Integer> map = k9.a;
            try {
                if (MetaData.k.l() && ComponentLocator.a(context).e().getBoolean("chromeTabs", false)) {
                    a(context, str, true);
                    return;
                }
            } catch (Throwable th) {
                i3.a(th);
            }
            Intent intent = new Intent(context, OverlayActivity.class);
            if (Build.VERSION.SDK_INT >= 21) {
                intent.addFlags(524288);
            }
            intent.addFlags(32768);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setData(Uri.parse(str));
            intent.putExtra("placement", AdPreferences.Placement.INAPP_BROWSER.a());
            intent.putExtra("activityShouldLockOrientation", false);
            try {
                context.startActivity(intent);
            } catch (Throwable th2) {
                i3.a(th2);
            }
        } else {
            b(context, str, str2);
        }
    }

    public static void a(Context context, String str, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        Bundle bundle = new Bundle();
        bundle.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
        intent.putExtras(bundle);
        if (z) {
            try {
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities != null && queryIntentActivities.size() > 1) {
                    intent.setPackage(queryIntentActivities.get(0).activityInfo.packageName);
                }
            } catch (Throwable th) {
                i3.a(th);
            }
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (Throwable th2) {
            i3.a(th2);
        }
    }

    public static void a(String str, String str2, String str3, Context context, TrackingParams trackingParams) {
        t8.a(context, str3, trackingParams, (h2<String, z5.a, Throwable, Void>) null);
        Intent a2 = k9.a(context, str);
        if (!(a2 == null || str2 == null)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    a2.putExtra(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
            }
        }
        if (a2 != null) {
            try {
                context.startActivity(a2);
            } catch (Throwable th) {
                i3.a(th);
            }
        }
    }

    public static String a(String str, String str2) {
        if (str2 != null) {
            try {
                if (!str2.equals("")) {
                    str = str2;
                }
            } catch (Exception unused) {
            }
        }
        if (str != null) {
            String[] split = str.split("[?&]d=");
            if (split.length >= 2) {
                return split[1].split("[?&]")[0];
            }
        }
        return null;
    }

    public static boolean a(Context context, Intent intent) {
        for (ResolveInfo next : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (next.activityInfo.packageName.equalsIgnoreCase(Constants.a)) {
                ActivityInfo activityInfo = next.activityInfo;
                intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                return true;
            }
        }
        return false;
    }

    public static void a(Context context, String[] strArr, String str, int i, String str2, JSONObject jSONObject) {
        try {
            AnalyticsConfig analyticsConfig = MetaData.k.analytics;
            if (!(analyticsConfig == null || !analyticsConfig.l() || jSONObject == null)) {
                i3 i3Var = new i3(j3.d);
                i3Var.d = "viewability_info";
                i3Var.i = str2;
                i3Var.e = k9.b(jSONObject.toString());
                i3Var.a();
            }
        } catch (Throwable th) {
            i3.a(th);
        }
        try {
            String str3 = "Dropped impression because " + str2;
            if (jSONObject != null) {
                str3 = str3 + ", view hierarchy: " + jSONObject.toString(2);
            }
            k9.a(context, 6, str3, false);
        } catch (Throwable th2) {
            i3.a(th2);
        }
        a(strArr, str, i, str2);
    }

    public static String a() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (int i = 0; i < 8; i++) {
            if (stackTrace[i].getMethodName().compareTo("doHome") == 0) {
                return "home";
            }
            if (stackTrace[i].getMethodName().compareTo("onBackPressed") == 0) {
                Object obj = StartAppSDKInternal.E;
                StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
                Activity activity = startAppSDKInternal.l;
                if (!(activity != null ? activity.isTaskRoot() : true)) {
                    return IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE;
                }
                startAppSDKInternal.d = false;
                startAppSDKInternal.f = true;
                return "back";
            }
        }
        return IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE;
    }

    public static String[] a(d dVar) {
        if (dVar instanceof HtmlAd) {
            return ((HtmlAd) dVar).trackingUrls;
        }
        return dVar instanceof JsonAd ? a(((JsonAd) dVar).g()) : new String[0];
    }

    public static String[] a(List<AdDetails> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (AdDetails w : list) {
                arrayList.addAll(Arrays.asList(w.w()));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean a(Context context, AdPreferences.Placement placement) {
        if (placement.equals(AdPreferences.Placement.INAPP_SPLASH) || !AdsCommonMetaData.h.a()) {
            return false;
        }
        return b(context);
    }

    public static void a(Runnable runnable) {
        if (runnable != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null || mainLooper.getThread() == Thread.currentThread()) {
                runnable.run();
                return;
            }
            Handler handler = a;
            if (handler == null) {
                handler = new Handler(mainLooper);
                a = handler;
            }
            handler.post(runnable);
        }
    }

    public static String a(Context context, Object obj) {
        return a(context.getPackageName(), obj.getClass().getName(), a(context), (String) null);
    }

    public static String a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return context.getClass().getName();
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static String a(String str, String str2, String str3, String str4) {
        String str5;
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.ROOT;
        sb.append(String.format(locale, "10%08x", new Object[]{Integer.valueOf((str + str2).hashCode())}));
        String str6 = "";
        if (str3 != null) {
            str5 = String.format(locale, "ac%08x", new Object[]{Integer.valueOf(str3.hashCode())});
        } else {
            str5 = str6;
        }
        sb.append(str5);
        if (str4 != null) {
            str6 = String.format(locale, "b1%08x", new Object[]{Integer.valueOf(str4.hashCode())});
        }
        sb.append(str6);
        return sb.toString();
    }
}
