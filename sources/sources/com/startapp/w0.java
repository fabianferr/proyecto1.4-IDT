package com.startapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.StatFs;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.security.CertificateUtil;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.components.x;
import com.startapp.t1;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: Sta */
public abstract class w0 {
    public static final Collection<Integer> i0;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K = "android";
    public int L;
    public int M;
    public float N;
    public Boolean O;
    public int P = 3;
    public String Q;
    public String R;
    public int S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public String X;
    public String Y;
    public final int Z;
    public String a;
    public Long a0;
    public String b;
    public Integer b0;
    public String c = "4.11.0";
    public Boolean c0;
    public Map<String, String> d = new TreeMap();
    public Boolean d0;
    public Map<String, ?> e;
    public Boolean e0;
    public String f;
    public Boolean f0;
    public u g;
    public e0 g0;
    public String h;
    public boolean h0;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public Boolean q;
    public Boolean r;
    public String s;
    public boolean t;
    public int u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    static {
        ArrayList arrayList = new ArrayList();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            arrayList.add(23);
        }
        if (i2 >= 26) {
            arrayList.add(22);
        }
        if (i2 >= 23) {
            arrayList.add(3);
            arrayList.add(4);
            arrayList.add(7);
            arrayList.add(8);
        }
        i0 = Collections.unmodifiableCollection(arrayList);
    }

    public w0(int i2) {
        new HashMap();
        this.Z = i2;
    }

    public void a(String str) {
        this.Y = str;
    }

    public boolean a() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009b, code lost:
        r2 = r2.getActiveNetworkInfo();
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012c A[SYNTHETIC, Splitter:B:52:0x012c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r5, com.startapp.sdk.adsbase.model.AdPreferences r6) {
        /*
            r4 = this;
            com.startapp.t7 r0 = com.startapp.t7.d
            com.startapp.t7 r0 = com.startapp.t7.d
            java.lang.String r0 = r0.a
            r4.Q = r0
            java.lang.String r0 = android.os.Build.MANUFACTURER
            r4.l = r0
            java.lang.String r0 = android.os.Build.MODEL
            r4.k = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r0 = java.lang.Integer.toString(r0)
            r4.m = r0
            if (r6 == 0) goto L_0x0020
            java.lang.String r6 = r6.getAge(r5)
            r4.f = r6
        L_0x0020:
            com.startapp.sdk.components.ComponentLocator r6 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r5)
            com.startapp.n4<com.startapp.b8> r6 = r6.o
            java.lang.Object r6 = r6.a()
            com.startapp.b8 r6 = (com.startapp.b8) r6
            java.lang.Object r6 = r6.b()
            com.startapp.a8 r6 = (com.startapp.a8) r6
            java.lang.String r6 = r6.a
            r4.i = r6
            int r6 = com.startapp.a0.a
            r6 = 0
            r0 = 0
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = r5.getPackageName()     // Catch:{ all -> 0x0049 }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = r1.versionName     // Catch:{ all -> 0x0049 }
            goto L_0x004a
        L_0x0049:
            r1 = r6
        L_0x004a:
            r4.R = r1
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch:{ all -> 0x005b }
            java.lang.String r2 = r5.getPackageName()     // Catch:{ all -> 0x005b }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r0)     // Catch:{ all -> 0x005b }
            int r1 = r1.versionCode     // Catch:{ all -> 0x005b }
            goto L_0x005c
        L_0x005b:
            r1 = 0
        L_0x005c:
            r4.S = r1
            boolean r1 = com.startapp.a0.b((android.content.Context) r5)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r4.q = r1
            r1 = 1
            android.content.ContentResolver r2 = r5.getContentResolver()     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "adb_enabled"
            int r2 = android.provider.Settings.Global.getInt(r2, r3, r0)     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x0077
            r2 = 1
            goto L_0x0078
        L_0x0077:
            r2 = 0
        L_0x0078:
            r4.T = r2
            boolean r2 = com.startapp.v6.a(r5)     // Catch:{ all -> 0x007f }
            goto L_0x0081
        L_0x007f:
            r2 = 0
        L_0x0081:
            r4.U = r2
            boolean r2 = com.startapp.a0.c(r5)
            r4.V = r2
            java.lang.String r2 = "connectivity"
            java.lang.Object r2 = r5.getSystemService(r2)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            if (r2 == 0) goto L_0x00b0
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r3 = com.startapp.a0.a((android.content.Context) r5, (java.lang.String) r3)
            if (r3 == 0) goto L_0x00b0
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()
            if (r2 == 0) goto L_0x00b0
            boolean r3 = r2.isConnected()
            if (r3 == 0) goto L_0x00b0
            boolean r2 = r2.isRoaming()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x00b1
        L_0x00b0:
            r2 = r6
        L_0x00b1:
            r4.r = r2
            boolean r2 = com.startapp.k9.f((android.content.Context) r5)
            r4.W = r2
            java.lang.String r2 = "uimode"
            java.lang.Object r2 = r5.getSystemService(r2)     // Catch:{ all -> 0x00cf }
            boolean r3 = r2 instanceof android.app.UiModeManager     // Catch:{ all -> 0x00cf }
            if (r3 == 0) goto L_0x00d3
            android.app.UiModeManager r2 = (android.app.UiModeManager) r2     // Catch:{ all -> 0x00cf }
            int r2 = r2.getCurrentModeType()     // Catch:{ all -> 0x00cf }
            r3 = 4
            if (r2 != r3) goto L_0x00d3
            r0 = 1
            goto L_0x00d3
        L_0x00cf:
            r1 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r1)
        L_0x00d3:
            r4.h0 = r0
            android.content.res.Resources r0 = r5.getResources()
            if (r0 == 0) goto L_0x00ed
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            if (r0 == 0) goto L_0x00ed
            int r1 = r0.widthPixels
            r4.L = r1
            int r1 = r0.heightPixels
            r4.M = r1
            float r0 = r0.density
            r4.N = r0
        L_0x00ed:
            com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r5)
            com.startapp.y4 r1 = r0.p()
            java.lang.Object r1 = r1.b()
            com.startapp.x4 r1 = (com.startapp.x4) r1
            java.lang.String r2 = r1.a
            r4.n = r2
            java.lang.String r1 = r1.b
            r4.o = r1
            com.startapp.n4<com.startapp.x3> r1 = r0.d
            java.lang.Object r1 = r1.a()
            com.startapp.x3 r1 = (com.startapp.x3) r1
            java.lang.Object r1 = r1.b()
            com.startapp.w3 r1 = (com.startapp.w3) r1
            java.lang.String r1 = r1.a
            r4.p = r1
            com.startapp.sdk.adsbase.e r0 = r0.e()
            java.lang.String r1 = "USER_CONSENT_PERSONALIZED_ADS_SERVING"
            java.lang.String r1 = r0.getString(r1, r6)
            r4.X = r1
            java.util.Map<java.lang.String, java.lang.String> r1 = r4.d
            java.lang.String r2 = "sharedPrefsWrappers"
            java.lang.String r6 = r0.getString(r2, r6)
            if (r6 != 0) goto L_0x012c
            goto L_0x014b
        L_0x012c:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x014b }
            r0.<init>(r6)     // Catch:{ JSONException -> 0x014b }
            java.util.Iterator r6 = r0.keys()     // Catch:{ JSONException -> 0x014b }
        L_0x0135:
            boolean r2 = r6.hasNext()     // Catch:{ JSONException -> 0x014b }
            if (r2 == 0) goto L_0x014b
            java.lang.Object r2 = r6.next()     // Catch:{ JSONException -> 0x014b }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x014b }
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x014b }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x014b }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x014b }
            goto L_0x0135
        L_0x014b:
            boolean r5 = com.startapp.k9.e((android.content.Context) r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r4.O = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.w0.b(android.content.Context, com.startapp.sdk.adsbase.model.AdPreferences):void");
    }

    public void c(Context context) {
        if (!(this.b != null)) {
            b0 c2 = ComponentLocator.a(context).c();
            String str = c2.c;
            if (str == null) {
                synchronized (c2.a) {
                    str = c2.c;
                    if (str == null) {
                        str = c2.b.getString("c88d4eab540fab77", (String) null);
                    }
                }
            }
            this.a = str;
            String str2 = c2.d;
            if (str2 == null) {
                synchronized (c2.a) {
                    str2 = c2.d;
                    if (str2 == null && (str2 = c2.b.getString("2696a7f502faed4b", (String) null)) == null) {
                        str2 = c2.b.getString("31721150b470a3b9", (String) null);
                    }
                }
            }
            this.b = str2;
        }
        this.h = context.getPackageName();
    }

    public void e(Context context) {
        f8 f8Var = (f8) ComponentLocator.a(context).v().b();
        if (f8Var.a(7) == 5) {
            this.w = f8Var.b(8);
            this.x = f8Var.b(9);
            this.y = f8Var.b(15);
            this.z = f8Var.b(16);
        }
        int a2 = f8Var.a(10);
        if (!(a2 == 0 || a2 == 2)) {
            this.A = f8Var.b(11);
            this.B = f8Var.b(12);
        }
        this.C = f8Var.b(4);
        this.D = f8Var.b(3);
        this.E = f8Var.b(5);
        boolean z2 = true;
        this.F = f8Var.b(1);
        this.G = f8Var.b(2);
        this.I = f8Var.b(13);
        if (f8Var.a(14) != 1) {
            z2 = false;
        }
        this.t = z2;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r2, com.startapp.sdk.adsbase.model.AdPreferences r3) {
        /*
            r1 = this;
            com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r2)     // Catch:{ all -> 0x000b }
            com.startapp.e0 r0 = r0.d()     // Catch:{ all -> 0x000b }
            r1.g0 = r0     // Catch:{ all -> 0x000b }
            goto L_0x000f
        L_0x000b:
            r0 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r0)
        L_0x000f:
            r1.c(r2)
            r1.b(r2, r3)     // Catch:{ all -> 0x0015 }
        L_0x0015:
            r1.d(r2)     // Catch:{ all -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r3 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r3)
        L_0x001d:
            r1.e(r2)     // Catch:{ all -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r3 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r3)
        L_0x0025:
            com.startapp.sdk.components.ComponentLocator r3 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r2)     // Catch:{ all -> 0x0034 }
            com.startapp.c7 r3 = r3.s()     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = r3.a((java.lang.Object) r1)     // Catch:{ all -> 0x0034 }
            r1.J = r3     // Catch:{ all -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r3 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r3)
        L_0x0038:
            r1.a((android.content.Context) r2)     // Catch:{ all -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r3 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r3)
        L_0x0040:
            r1.b(r2)     // Catch:{ all -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r2 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r2)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.w0.a(android.content.Context, com.startapp.sdk.adsbase.model.AdPreferences):void");
    }

    public void d(Context context) {
        int i2;
        NetworkCapabilities networkCapabilities;
        String str = "e105";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                str = "e100";
            } else if (a0.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Network activeNetwork = connectivityManager.getActiveNetwork();
                    if (!(activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null)) {
                        if (!networkCapabilities.hasTransport(1)) {
                            if (networkCapabilities.hasTransport(0)) {
                                str = z5.a(context);
                            }
                        }
                    }
                    str = "e102";
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        String typeName = activeNetworkInfo.getTypeName();
                        if (typeName.toLowerCase().compareTo("WIFI".toLowerCase()) != 0) {
                            if (typeName.toLowerCase().compareTo("MOBILE".toLowerCase()) == 0) {
                                str = z5.a(context);
                            }
                        }
                    }
                    str = "e102";
                }
                str = "WIFI";
            }
        } catch (Exception unused) {
        }
        this.s = str;
        String str2 = ComponentLocator.a(context).w().h;
        this.H = str2;
        this.v = str2;
        try {
            t1.a aVar = ComponentLocator.a(context).f().e;
            if (aVar != null) {
                i2 = aVar.a();
                this.u = i2;
            }
        } catch (Throwable th) {
            if (!k9.a(th, (Class<? extends Throwable>) RemoteException.class)) {
                i3.a(th);
            }
        }
        i2 = -1;
        this.u = i2;
    }

    public void a(r6 r6Var) throws SDKException {
        Map<String, ?> map = this.e;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                r6Var.a((String) next.getKey(), next.getValue(), false, true);
            }
        }
        r6Var.a("publisherId", (Object) this.a, false, true);
        r6Var.a(InAppPurchaseMetaData.KEY_PRODUCT_ID, (Object) this.b, a(), true);
        r6Var.a("os", (Object) this.K, true, true);
        r6Var.a("sdkVersion", (Object) this.c, false, true);
        r6Var.a("flavor", (Object) 1023, false, true);
        Map<String, String> map2 = this.d;
        if (map2 != null && !map2.isEmpty()) {
            String str = "";
            for (String next2 : this.d.keySet()) {
                str = str + next2 + CertificateUtil.DELIMITER + this.d.get(next2) + ";";
            }
            r6Var.a("frameworksData", (Object) str.substring(0, str.length() - 1), false, false);
        }
        r6Var.a("packageId", (Object) this.h, false, true);
        r6Var.a("installerPkg", (Object) this.i, false, true);
        r6Var.a(IronSourceSegment.AGE, (Object) this.f, false, true);
        u uVar = this.g;
        if (uVar != null) {
            r6Var.a("userAdvertisingId", (Object) uVar.a, false, true);
            boolean z2 = this.g.c;
            if (z2) {
                r6Var.a("limat", (Object) Boolean.valueOf(z2), false, true);
            }
            r6Var.a("advertisingIdSource", (Object) this.g.b, false, true);
        }
        String str2 = this.j;
        if (str2 != null) {
            r6Var.a("duid", (Object) str2, false, true);
        }
        r6Var.a("model", (Object) this.k, false, true);
        r6Var.a("manufacturer", (Object) this.l, false, true);
        r6Var.a("deviceVersion", (Object) this.m, false, true);
        r6Var.a("locale", (Object) this.n, false, true);
        r6Var.a("localeList", (Object) this.o, false, true);
        r6Var.a("inputLangs", (Object) this.p, false, true);
        r6Var.a("isp", (Object) this.w, false, true);
        r6Var.a("ispName", (Object) this.x, false, true);
        r6Var.a("ispCarrId", (Object) this.y, false, true);
        r6Var.a("ispCarrIdName", (Object) this.z, false, true);
        r6Var.a("netOper", (Object) this.A, false, true);
        r6Var.a("networkOperName", (Object) this.B, false, true);
        r6Var.a(CmcdConfiguration.KEY_CONTENT_ID, (Object) this.C, false, true);
        r6Var.a("lac", (Object) this.D, false, true);
        r6Var.a("tac", (Object) this.E, false, true);
        r6Var.a("blat", (Object) this.F, false, true);
        r6Var.a("blon", (Object) this.G, false, true);
        r6Var.a("subPublisherId", (Object) null, false, true);
        r6Var.a("subProductId", (Object) null, false, true);
        r6Var.a("retryCount", (Object) null, false, true);
        r6Var.a("roaming", (Object) this.r, false, true);
        r6Var.a("grid", (Object) this.s, false, true);
        if (this.t) {
            r6Var.a("c5g", (Object) "1", false, false);
        }
        int i2 = this.u;
        if (i2 >= 0) {
            r6Var.a(NotificationCompat.CATEGORY_TRANSPORT, (Object) String.valueOf(i2), false, false);
        }
        if (this.h0) {
            r6Var.a("tv", (Object) Boolean.TRUE, false, false);
        }
        r6Var.a("silev", (Object) this.v, false, true);
        r6Var.a("cellSignalLevel", (Object) this.H, false, true);
        r6Var.a("cellTimingAdv", (Object) this.I, false, true);
        r6Var.a("outsource", (Object) this.q, false, true);
        r6Var.a(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, (Object) String.valueOf(this.L), false, true);
        r6Var.a(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, (Object) String.valueOf(this.M), false, true);
        r6Var.a("density", (Object) String.valueOf(this.N), false, true);
        r6Var.a("fgApp", (Object) this.O, false, true);
        r6Var.a("sdkId", (Object) String.valueOf(this.P), true, true);
        r6Var.a("clientSessionId", (Object) this.Q, false, true);
        r6Var.a("appVersion", (Object) this.R, false, true);
        r6Var.a("appCode", (Object) Integer.valueOf(this.S), false, true);
        r6Var.a("timeSinceBoot", (Object) Long.valueOf(SystemClock.elapsedRealtime()), false, true);
        r6Var.a("udbg", (Object) Boolean.valueOf(this.T), false, true);
        r6Var.a("root", (Object) Boolean.valueOf(this.U), false, true);
        r6Var.a("smltr", (Object) Boolean.valueOf(this.V), false, true);
        r6Var.a("isddbg", (Object) Boolean.valueOf(this.W), false, true);
        r6Var.a("pas", (Object) this.X, false, true);
        r6Var.a("prm", (Object) this.Y, false, false);
        r6Var.a("free", (Object) this.a0, false, false);
        r6Var.a("chr", (Object) this.c0, false, false);
        r6Var.a("blp", (Object) this.b0, false, false);
        r6Var.a("hs", (Object) this.d0, false, false);
        r6Var.a("lpm", (Object) this.e0, false, false);
        r6Var.a("dm", (Object) this.f0, false, false);
        e0 e0Var = this.g0;
        if (e0Var != null) {
            long j2 = 0;
            if (e0Var.d > 0) {
                ((x) e0Var.a).getClass();
                j2 = SystemClock.elapsedRealtime() - e0Var.d;
            }
            r6Var.a("appSessionDuration", (Object) Long.valueOf(j2 / 1000), false, false);
        }
        r6Var.a("rsc", (Object) this.J, false, true);
    }

    public void b(Context context) {
        boolean z2;
        try {
            this.a0 = null;
            this.a0 = Long.valueOf(new StatFs(Environment.getRootDirectory().getAbsolutePath()).getFreeBytes());
        } catch (Throwable th) {
            i3.a(th);
        }
        boolean z3 = true;
        try {
            this.c0 = null;
            this.b0 = null;
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                if (registerReceiver.hasExtra("status")) {
                    int intExtra = registerReceiver.getIntExtra("status", -1);
                    if (intExtra != 2) {
                        if (intExtra != 5) {
                            z2 = false;
                            this.c0 = Boolean.valueOf(z2);
                        }
                    }
                    z2 = true;
                    this.c0 = Boolean.valueOf(z2);
                }
                if (registerReceiver.hasExtra("level") && registerReceiver.hasExtra("scale")) {
                    int intExtra2 = registerReceiver.getIntExtra("level", -1);
                    int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                    if (intExtra2 >= 0 && intExtra3 > 0) {
                        this.b0 = Integer.valueOf((intExtra2 * 100) / intExtra3);
                    }
                }
            }
        } catch (Throwable th2) {
            i3.a(th2);
        }
        try {
            this.d0 = null;
            Object systemService = context.getSystemService("audio");
            if (systemService instanceof AudioManager) {
                AudioManager audioManager = (AudioManager) systemService;
                if (Build.VERSION.SDK_INT >= 23) {
                    AudioDeviceInfo[] devices = audioManager.getDevices(2);
                    if (devices != null) {
                        int length = devices.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                AudioDeviceInfo audioDeviceInfo = devices[i2];
                                if (audioDeviceInfo != null && i0.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                        this.d0 = Boolean.valueOf(z3);
                    }
                    z3 = false;
                    this.d0 = Boolean.valueOf(z3);
                }
            }
        } catch (Throwable th3) {
            i3.a(th3);
        }
        try {
            this.e0 = null;
            Object systemService2 = context.getSystemService("power");
            if (systemService2 instanceof PowerManager) {
                PowerManager powerManager = (PowerManager) systemService2;
                if (Build.VERSION.SDK_INT >= 21) {
                    this.e0 = Boolean.valueOf(powerManager.isPowerSaveMode());
                }
            }
        } catch (Throwable th4) {
            i3.a(th4);
        }
        try {
            this.f0 = null;
            int i3 = context.getResources().getConfiguration().uiMode & 48;
            if (i3 == 32) {
                this.f0 = Boolean.TRUE;
            } else if (i3 == 16) {
                this.f0 = Boolean.FALSE;
            }
        } catch (Throwable th5) {
            i3.a(th5);
        }
    }

    public void a(Context context) {
        if (!MetaData.k.p()) {
            this.g = ComponentLocator.a(context).a().a();
            try {
                this.j = ComponentLocator.a(context).j.a().a();
            } catch (Throwable th) {
                i3.a(th);
            }
            try {
                this.e = ComponentLocator.a(context).k().getAll();
            } catch (Throwable th2) {
                i3.a(th2);
            }
        }
    }
}
