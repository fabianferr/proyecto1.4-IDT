package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.f.f;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.p;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.appnext.core.Ad;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umlaut.crowd.internal.ia;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class o {
    /* access modifiers changed from: private */
    public static final AtomicReference<a> h = new AtomicReference<>();
    /* access modifiers changed from: private */
    public static final AtomicReference<b> j = new AtomicReference<>();
    private final m a;
    private final u b;
    private final Context c;
    private final Map<String, Object> d;
    private final Object e = new Object();
    private final Map<String, Object> f;
    private boolean g;
    /* access modifiers changed from: private */
    public final AtomicReference<Integer> i = new AtomicReference<>();

    public static class a {
        public boolean a;
        public String b = "";
    }

    public static class b {
        public final String a;
        public final int b;

        public b(String str, int i) {
            this.a = str;
            this.b = i;
        }
    }

    public static class c {
        public int a = -1;
        public int b = -1;
    }

    protected o(m mVar) {
        if (mVar != null) {
            this.a = mVar;
            this.b = mVar.A();
            this.c = mVar.L();
            this.d = q();
            this.f = s();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: private */
    public Integer A() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Integer.valueOf((int) (((float) audioManager.getStreamVolume(3)) * ((Float) this.a.a(com.applovin.impl.sdk.d.b.dO)).floatValue()));
    }

    private double B() {
        double offset = (double) TimeZone.getDefault().getOffset(new Date().getTime());
        Double.isNaN(offset);
        double round = (double) Math.round((offset * 10.0d) / 3600000.0d);
        Double.isNaN(round);
        return round / 10.0d;
    }

    private boolean C() {
        SensorManager sensorManager = (SensorManager) this.c.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    private String D() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    private String E() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(0, Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!u.a()) {
                return "";
            }
            this.b.b("DataCollector", "Unable to collect mobile country code", th);
            return "";
        }
    }

    private String F() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!u.a()) {
                return "";
            }
            this.b.b("DataCollector", "Unable to collect mobile network code", th);
            return "";
        }
    }

    private String G() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            if (!u.a()) {
                return "";
            }
            this.b.b("DataCollector", "Unable to collect carrier", th);
            return "";
        }
    }

    private boolean H() {
        try {
            return I() || J();
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean I() {
        String str = Build.TAGS;
        return str != null && str.contains(b("lz}$blpz"));
    }

    private boolean J() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i2 = 0; i2 < 9; i2++) {
            if (new File(b(strArr[i2])).exists()) {
                return true;
            }
        }
        return false;
    }

    private String a(int i2) {
        if (i2 == 1) {
            return "receiver";
        }
        if (i2 == 2) {
            return "speaker";
        }
        if (i2 == 4 || i2 == 3) {
            return "headphones";
        }
        if (i2 == 8) {
            return "bluetootha2dpoutput";
        }
        if (i2 == 13 || i2 == 19 || i2 == 5 || i2 == 6 || i2 == 12 || i2 == 11) {
            return "lineout";
        }
        if (i2 == 9 || i2 == 10) {
            return "hdmioutput";
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0390  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01bd A[SYNTHETIC, Splitter:B:54:0x01bd] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.Object> a(java.util.Map<java.lang.String, java.lang.Object> r10, boolean r11) {
        /*
            r9 = this;
            java.lang.String r0 = "lmt"
            java.lang.String r1 = "tm"
            java.lang.String r2 = "fm"
            java.lang.String r3 = "tds"
            java.lang.String r4 = "fs"
            java.lang.String r5 = "DataCollector"
            java.util.Map r10 = com.applovin.impl.sdk.utils.CollectionUtils.map(r10)
            android.content.Context r6 = r9.c
            android.graphics.Point r6 = com.applovin.impl.sdk.utils.g.a(r6)
            int r7 = r6.x
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "dx"
            r10.put(r8, r7)
            int r6 = r6.y
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "dy"
            r10.put(r7, r6)
            if (r11 == 0) goto L_0x0052
            java.util.concurrent.atomic.AtomicReference<com.applovin.impl.sdk.o$a> r6 = h
            java.lang.Object r6 = r6.get()
            com.applovin.impl.sdk.o$a r6 = (com.applovin.impl.sdk.o.a) r6
            if (r6 == 0) goto L_0x003c
            r9.m()
            goto L_0x005c
        L_0x003c:
            boolean r6 = com.applovin.impl.sdk.utils.Utils.isMainThread()
            if (r6 == 0) goto L_0x0052
            com.applovin.impl.sdk.o$a r6 = new com.applovin.impl.sdk.o$a
            r6.<init>()
            r7 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = "inc"
            r10.put(r8, r7)
            goto L_0x005c
        L_0x0052:
            com.applovin.impl.sdk.m r6 = r9.a
            com.applovin.impl.sdk.o r6 = r6.V()
            com.applovin.impl.sdk.o$a r6 = r6.k()
        L_0x005c:
            java.lang.String r7 = r6.b
            boolean r8 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r7)
            if (r8 == 0) goto L_0x0069
            java.lang.String r8 = "idfa"
            r10.put(r8, r7)
        L_0x0069:
            boolean r6 = r6.a
            java.lang.String r7 = "dnt"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r10.put(r7, r6)
            java.util.concurrent.atomic.AtomicReference<com.applovin.impl.sdk.o$b> r6 = j
            java.lang.Object r6 = r6.get()
            com.applovin.impl.sdk.o$b r6 = (com.applovin.impl.sdk.o.b) r6
            com.applovin.impl.sdk.m r7 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.d.b.dr
            java.lang.Object r7 = r7.a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x00a0
            if (r6 == 0) goto L_0x00a0
            java.lang.String r7 = "idfv"
            java.lang.String r8 = r6.a
            r10.put(r7, r8)
            int r6 = r6.b
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "idfv_scope"
            r10.put(r7, r6)
        L_0x00a0:
            com.applovin.impl.sdk.j$a r6 = com.applovin.impl.sdk.j.b()
            android.content.Context r7 = r9.c
            java.lang.Boolean r6 = r6.a((android.content.Context) r7)
            if (r6 == 0) goto L_0x00b1
            java.lang.String r7 = "huc"
            r10.put(r7, r6)
        L_0x00b1:
            com.applovin.impl.sdk.j$a r6 = com.applovin.impl.sdk.j.a()
            android.content.Context r7 = r9.c
            java.lang.Boolean r6 = r6.a((android.content.Context) r7)
            if (r6 == 0) goto L_0x00c2
            java.lang.String r7 = "aru"
            r10.put(r7, r6)
        L_0x00c2:
            com.applovin.impl.sdk.j$a r6 = com.applovin.impl.sdk.j.c()
            android.content.Context r7 = r9.c
            java.lang.Boolean r6 = r6.a((android.content.Context) r7)
            if (r6 == 0) goto L_0x00d3
            java.lang.String r7 = "dns"
            r10.put(r7, r6)
        L_0x00d3:
            com.applovin.impl.sdk.m r6 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r7 = com.applovin.impl.sdk.d.b.dD
            java.lang.Object r6 = r6.a(r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x00fd
            com.applovin.impl.sdk.o$c r6 = r9.v()
            int r7 = r6.a
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "act"
            r10.put(r8, r7)
            int r6 = r6.b
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "acm"
            r10.put(r7, r6)
        L_0x00fd:
            com.applovin.impl.sdk.m r6 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r7 = com.applovin.impl.sdk.d.b.dL
            java.lang.Object r6 = r6.a(r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0120
            com.applovin.impl.sdk.m r6 = r9.a
            com.applovin.impl.sdk.x r6 = r6.ad()
            int r6 = r6.b()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "mtl"
            r10.put(r7, r6)
        L_0x0120:
            com.applovin.impl.sdk.m r6 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r7 = com.applovin.impl.sdk.d.b.dN
            java.lang.Object r6 = r6.a(r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x013d
            boolean r6 = r9.H()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r7 = "adr"
            r10.put(r7, r6)
        L_0x013d:
            if (r11 == 0) goto L_0x0148
            java.util.concurrent.atomic.AtomicReference<java.lang.Integer> r11 = r9.i
            java.lang.Object r11 = r11.get()
            java.lang.Integer r11 = (java.lang.Integer) r11
            goto L_0x014c
        L_0x0148:
            java.lang.Integer r11 = r9.A()
        L_0x014c:
            if (r11 == 0) goto L_0x0153
            java.lang.String r6 = "volume"
            r10.put(r6, r11)
        L_0x0153:
            android.content.Context r11 = r9.c     // Catch:{ SettingNotFoundException -> 0x0172 }
            android.content.ContentResolver r11 = r11.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0172 }
            java.lang.String r6 = "screen_brightness"
            int r11 = android.provider.Settings.System.getInt(r11, r6)     // Catch:{ SettingNotFoundException -> 0x0172 }
            float r11 = (float) r11     // Catch:{ SettingNotFoundException -> 0x0172 }
            r6 = 1132396544(0x437f0000, float:255.0)
            float r11 = r11 / r6
            java.lang.String r6 = "sb"
            r7 = 1120403456(0x42c80000, float:100.0)
            float r11 = r11 * r7
            int r11 = (int) r11     // Catch:{ SettingNotFoundException -> 0x0172 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ SettingNotFoundException -> 0x0172 }
            r10.put(r6, r11)     // Catch:{ SettingNotFoundException -> 0x0172 }
            goto L_0x0180
        L_0x0172:
            r11 = move-exception
            boolean r6 = com.applovin.impl.sdk.u.a()
            if (r6 == 0) goto L_0x0180
            com.applovin.impl.sdk.u r6 = r9.b
            java.lang.String r7 = "Unable to collect screen brightness"
            r6.b(r5, r7, r11)
        L_0x0180:
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r6 = com.applovin.impl.sdk.d.b.dQ
            java.lang.Object r11 = r11.a(r6)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x01ac
            com.applovin.impl.sdk.m r11 = r9.a
            boolean r11 = com.applovin.impl.sdk.utils.Utils.isUserAgentCollectionEnabled(r11)
            if (r11 == 0) goto L_0x01ac
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.aa.b(r11)
            java.lang.String r11 = com.applovin.impl.sdk.aa.a()
            boolean r6 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r11)
            if (r6 == 0) goto L_0x01ac
            java.lang.String r6 = "ua"
            r10.put(r6, r11)
        L_0x01ac:
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r6 = com.applovin.impl.sdk.d.b.dF
            java.lang.Object r11 = r11.a(r6)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            r6 = -1
            if (r11 == 0) goto L_0x01f8
            java.io.File r11 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x01dc }
            long r7 = r11.getFreeSpace()     // Catch:{ all -> 0x01dc }
            java.lang.Long r11 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x01dc }
            r10.put(r4, r11)     // Catch:{ all -> 0x01dc }
            java.io.File r11 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x01dc }
            long r7 = r11.getTotalSpace()     // Catch:{ all -> 0x01dc }
            java.lang.Long r11 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x01dc }
            r10.put(r3, r11)     // Catch:{ all -> 0x01dc }
            goto L_0x01f8
        L_0x01dc:
            r11 = move-exception
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r10.put(r4, r7)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r10.put(r3, r4)
            boolean r3 = com.applovin.impl.sdk.u.a()
            if (r3 == 0) goto L_0x01f8
            com.applovin.impl.sdk.u r3 = r9.b
            java.lang.String r4 = "Unable to collect total & free space."
            r3.b(r5, r4, r11)
        L_0x01f8:
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r3 = com.applovin.impl.sdk.d.b.dG
            java.lang.Object r11 = r11.a(r3)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0266
            android.content.Context r11 = r9.c
            java.lang.String r3 = "activity"
            java.lang.Object r11 = r11.getSystemService(r3)
            android.app.ActivityManager r11 = (android.app.ActivityManager) r11
            android.app.ActivityManager$MemoryInfo r3 = new android.app.ActivityManager$MemoryInfo
            r3.<init>()
            if (r11 == 0) goto L_0x0266
            r11.getMemoryInfo(r3)     // Catch:{ all -> 0x0243 }
            long r7 = r3.availMem     // Catch:{ all -> 0x0243 }
            java.lang.Long r11 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0243 }
            r10.put(r2, r11)     // Catch:{ all -> 0x0243 }
            long r7 = r3.totalMem     // Catch:{ all -> 0x0243 }
            java.lang.Long r11 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0243 }
            r10.put(r1, r11)     // Catch:{ all -> 0x0243 }
            long r7 = r3.threshold     // Catch:{ all -> 0x0243 }
            java.lang.Long r11 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0243 }
            r10.put(r0, r11)     // Catch:{ all -> 0x0243 }
            java.lang.String r11 = "lm"
            boolean r3 = r3.lowMemory     // Catch:{ all -> 0x0243 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0243 }
            r10.put(r11, r3)     // Catch:{ all -> 0x0243 }
            goto L_0x0266
        L_0x0243:
            r11 = move-exception
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r10.put(r2, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            r10.put(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r10.put(r0, r1)
            boolean r0 = com.applovin.impl.sdk.u.a()
            if (r0 == 0) goto L_0x0266
            com.applovin.impl.sdk.u r0 = r9.b
            java.lang.String r1 = "Unable to collect memory info."
            r0.b(r5, r1, r11)
        L_0x0266:
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r0 = com.applovin.impl.sdk.d.b.dH
            java.lang.Object r11 = r11.a(r0)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x029d
            java.lang.String r11 = "android.permission.READ_PHONE_STATE"
            android.content.Context r0 = r9.c
            boolean r11 = com.applovin.impl.sdk.utils.g.a(r11, r0)
            if (r11 == 0) goto L_0x029d
            boolean r11 = com.applovin.impl.sdk.utils.g.f()
            if (r11 == 0) goto L_0x029d
            android.content.Context r11 = r9.c
            java.lang.String r0 = "phone"
            java.lang.Object r11 = r11.getSystemService(r0)
            android.telephony.TelephonyManager r11 = (android.telephony.TelephonyManager) r11
            int r11 = r11.getDataNetworkType()
            java.lang.String r0 = "rat"
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.put(r0, r11)
        L_0x029d:
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r0 = com.applovin.impl.sdk.d.b.dE
            java.lang.Object r11 = r11.a(r0)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x02bc
            java.lang.String r11 = r9.y()
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x02bc
            java.lang.String r0 = "so"
            r10.put(r0, r11)
        L_0x02bc:
            java.lang.String r11 = "orientation_lock"
            java.lang.String r0 = r9.r()
            r10.put(r11, r0)
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r0 = com.applovin.impl.sdk.d.b.dI
            java.lang.Object r11 = r11.a(r0)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x02e2
            boolean r11 = com.applovin.impl.sdk.utils.Utils.isVPNConnected()
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            java.lang.String r0 = "vs"
            r10.put(r0, r11)
        L_0x02e2:
            boolean r11 = com.applovin.impl.sdk.utils.g.d()
            if (r11 == 0) goto L_0x0301
            android.content.Context r11 = r9.c
            java.lang.String r0 = "power"
            java.lang.Object r11 = r11.getSystemService(r0)
            android.os.PowerManager r11 = (android.os.PowerManager) r11
            if (r11 == 0) goto L_0x0301
            boolean r11 = r11.isPowerSaveMode()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.String r0 = "lpm"
            r10.put(r0, r11)
        L_0x0301:
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r0 = com.applovin.impl.sdk.d.b.dR
            java.lang.Object r11 = r11.a(r0)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x032c
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.utils.n r11 = r11.ah()
            if (r11 == 0) goto L_0x032c
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.utils.n r11 = r11.ah()
            float r11 = r11.c()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            java.lang.String r0 = "da"
            r10.put(r0, r11)
        L_0x032c:
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r0 = com.applovin.impl.sdk.d.b.dS
            java.lang.Object r11 = r11.a(r0)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0357
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.utils.n r11 = r11.ah()
            if (r11 == 0) goto L_0x0357
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.utils.n r11 = r11.ah()
            float r11 = r11.b()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            java.lang.String r0 = "dm"
            r10.put(r0, r11)
        L_0x0357:
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.h r11 = r11.ai()
            int r11 = r11.a()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.String r0 = "mute_switch"
            r10.put(r0, r11)
            com.applovin.impl.sdk.m r11 = r9.a
            java.lang.String r11 = com.applovin.impl.sdk.utils.h.f(r11)
            java.lang.String r0 = "network"
            r10.put(r0, r11)
            java.lang.String r11 = r9.z()
            boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r11)
            if (r0 == 0) goto L_0x0384
            java.lang.String r0 = "kb"
            r10.put(r0, r11)
        L_0x0384:
            com.applovin.impl.sdk.m r11 = r9.a
            com.applovin.impl.sdk.a.c r11 = r11.an()
            boolean r0 = r11.b()
            if (r0 == 0) goto L_0x03b7
            long r0 = r11.c()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "ah_sdk_version_code"
            r10.put(r1, r0)
            boolean r0 = r11.d()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r1 = "ah_dd_enabled"
            r10.put(r1, r0)
            java.lang.String r11 = r11.e()
            java.lang.String r11 = com.applovin.impl.sdk.utils.StringUtils.emptyIfNull(r11)
            java.lang.String r0 = "ah_random_user_token"
            r10.put(r0, r11)
        L_0x03b7:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.o.a(java.util.Map, boolean):java.util.Map");
    }

    public static void a(final Context context) {
        new Thread(new Runnable() {
            public void run() {
                o.h.set(com.applovin.impl.sdk.utils.c.a(context));
            }
        }).start();
    }

    private void a(Map<String, Object> map) {
        if (((Boolean) this.a.a(com.applovin.impl.sdk.d.b.dJ)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(w()));
        }
        if (((Boolean) this.a.a(com.applovin.impl.sdk.d.b.dK)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(x()));
        }
        if (((Boolean) this.a.a(com.applovin.impl.sdk.d.b.dQ)).booleanValue() && Utils.isUserAgentCollectionEnabled(this.a)) {
            aa.b(this.a);
        }
        if (((Boolean) this.a.a(com.applovin.impl.sdk.d.b.dP)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.a.a(com.applovin.impl.sdk.d.b.dM)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(u()));
        }
    }

    private boolean a(String str) {
        try {
            return Settings.Secure.getInt(this.c.getContentResolver(), str) == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    private String b(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = str.charAt(i2);
            for (int i3 = 9; i3 >= 0; i3--) {
                cArr[i2] = (char) (cArr[i2] ^ iArr[i3]);
            }
        }
        return new String(cArr);
    }

    public static void b(final Context context) {
        if (Utils.checkClassExistence("com.google.android.gms.appset.AppSet")) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        AppSet.getClient(context).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() {
                            /* renamed from: a */
                            public void onSuccess(AppSetIdInfo appSetIdInfo) {
                                o.j.set(new b(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                            }
                        });
                    } catch (Throwable unused) {
                        if (u.a()) {
                            u.f("DataCollector", "Could not collect AppSet ID.");
                        }
                    }
                }
            }).start();
        } else if (u.a()) {
            u.f("DataCollector", "Could not collect AppSet ID.");
        }
    }

    private Map<String, String> p() {
        return Utils.stringifyObjectMap(a((Map<String, String>) null, true, false));
    }

    private Map<String, Object> q() {
        Map<String, Object> map = CollectionUtils.map(32);
        map.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        map.put("brand", Build.MANUFACTURER);
        map.put("brand_name", Build.BRAND);
        map.put("hardware", Build.HARDWARE);
        map.put("sim", Boolean.valueOf(AppLovinSdkUtils.isEmulator()));
        map.put("aida", Boolean.valueOf(com.applovin.impl.sdk.utils.c.a()));
        map.put("locale", Locale.getDefault().toString());
        map.put("model", Build.MODEL);
        map.put("os", Build.VERSION.RELEASE);
        map.put("platform", f());
        map.put("revision", Build.DEVICE);
        map.put("tz_offset", Double.valueOf(B()));
        map.put("gy", Boolean.valueOf(C()));
        map.put("country_code", D());
        map.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, E());
        map.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC, F());
        map.put("carrier", G());
        map.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.c)));
        map.put("tv", Boolean.valueOf(AppLovinSdkUtils.isTv(this.c)));
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            map.put("adns", Float.valueOf(displayMetrics.density));
            map.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            map.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            map.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            Point a2 = g.a(this.c);
            double sqrt = Math.sqrt(Math.pow((double) a2.x, 2.0d) + Math.pow((double) a2.y, 2.0d));
            double d2 = (double) displayMetrics.xdpi;
            Double.isNaN(d2);
            map.put("screen_size_in", Double.valueOf(sqrt / d2));
        }
        map.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        a(map);
        return map;
    }

    private String r() {
        int orientation = AppLovinSdkUtils.getOrientation(this.c);
        return orientation == 1 ? Ad.ORIENTATION_PORTRAIT : orientation == 2 ? Ad.ORIENTATION_LANDSCAPE : "none";
    }

    private Map<String, Object> s() {
        PackageInfo packageInfo;
        Map<String, Object> map = CollectionUtils.map();
        PackageManager packageManager = this.c.getPackageManager();
        ApplicationInfo applicationInfo = this.c.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        String str = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.c.getPackageName(), 0);
            try {
                str = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        map.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, packageManager.getApplicationLabel(applicationInfo));
        Object obj = "";
        map.put("app_version", packageInfo != null ? packageInfo.versionName : obj);
        map.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        map.put(CampaignEx.JSON_KEY_PACKAGE_NAME, applicationInfo.packageName);
        map.put("vz", StringUtils.toShortSHA1Hash(applicationInfo.packageName));
        if (str == null) {
            str = obj;
        }
        map.put("installer_name", str);
        map.put("tg", p.a(this.a));
        map.put("debug", Boolean.valueOf(Utils.isPubInDebugMode(this.a.L(), this.a)));
        map.put(ia.j, Long.valueOf(lastModified));
        Long l = (Long) this.a.a(d.d);
        if (l != null) {
            map.put("ia_v2", l);
        } else {
            this.a.a(d.d, Long.valueOf(lastModified));
        }
        map.put("sdk_version", AppLovinSdk.VERSION);
        map.put("omid_sdk_version", this.a.al().c());
        String userEngagementSdkVersion = Utils.getUserEngagementSdkVersion();
        if (StringUtils.isValidString(userEngagementSdkVersion)) {
            map.put("ue_sdk_version", userEngagementSdkVersion);
        }
        map.put("api_did", this.a.a(com.applovin.impl.sdk.d.b.V));
        if (packageInfo != null) {
            obj = Long.valueOf(packageInfo.firstInstallTime);
        }
        map.put("first_install_v3_ms", obj);
        map.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        map.put("epv", Integer.valueOf(Utils.tryToGetExoPlayerVersionCode()));
        return map;
    }

    private Map<String, Object> t() {
        Map<String, Object> map = CollectionUtils.map();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.c);
        String str = (String) this.a.b(d.n, null, defaultSharedPreferences);
        if (StringUtils.isValidString(str)) {
            map.put("IABTCF_TCString", str);
        }
        Object obj = defaultSharedPreferences.getAll().get(d.o.a());
        if ((obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean)) {
            map.put("IABTCF_gdprApplies", obj);
        }
        return map;
    }

    private boolean u() {
        ConnectivityManager connectivityManager;
        if (g.f() && (connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th) {
                if (u.a()) {
                    this.a.A().b("DataCollector", "Unable to collect constrained network info.", th);
                }
            }
        }
        return false;
    }

    private c v() {
        c cVar = new c();
        Intent registerReceiver = this.c.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i2 = -1;
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : -1;
        int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            cVar.b = -1;
        } else {
            cVar.b = (int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f);
        }
        if (registerReceiver != null) {
            i2 = registerReceiver.getIntExtra("status", -1);
        }
        cVar.a = i2;
        return cVar;
    }

    private long w() {
        List asList = Arrays.asList(StringUtils.emptyIfNull(Settings.Secure.getString(this.c.getContentResolver(), "enabled_accessibility_services")).split(CertificateUtil.DELIMITER));
        long j2 = asList.contains("AccessibilityMenuService") ? 256 : 0;
        if (asList.contains("SelectToSpeakService")) {
            j2 |= 512;
        }
        if (asList.contains("SoundAmplifierService")) {
            j2 |= 2;
        }
        if (asList.contains("SpeechToTextAccessibilityService")) {
            j2 |= 128;
        }
        if (asList.contains("SwitchAccessService")) {
            j2 |= 4;
        }
        if ((this.c.getResources().getConfiguration().uiMode & 48) == 32) {
            j2 |= 1024;
        }
        if (a("accessibility_enabled")) {
            j2 |= 8;
        }
        if (a("touch_exploration_enabled")) {
            j2 |= 16;
        }
        if (!g.d()) {
            return j2;
        }
        if (a("accessibility_display_inversion_enabled")) {
            j2 |= 32;
        }
        return a("skip_first_use_hints") ? j2 | 64 : j2;
    }

    private float x() {
        try {
            return Settings.System.getFloat(this.c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e2) {
            if (!u.a()) {
                return -1.0f;
            }
            this.b.b("DataCollector", "Error collecting font scale", e2);
            return -1.0f;
        }
    }

    private String y() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (g.e()) {
            for (AudioDeviceInfo type : audioManager.getDevices(2)) {
                String a2 = a(type.getType());
                if (!TextUtils.isEmpty(a2)) {
                    sb.append(a2);
                    sb.append(",");
                }
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append("headphones,");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append("bluetootha2dpoutput");
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sb2 = sb.toString();
        if (u.a() && TextUtils.isEmpty(sb2)) {
            this.b.b("DataCollector", "No sound outputs detected");
        }
        return sb2;
    }

    private String z() {
        if (!g.f()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            LocaleList locales = this.c.getResources().getConfiguration().getLocales();
            for (int i2 = 0; i2 < locales.size(); i2++) {
                sb.append(locales.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String a() {
        String encodeToString = Base64.encodeToString(new JSONObject(p()).toString().getBytes(Charset.defaultCharset()), 2);
        if (!((Boolean) this.a.a(com.applovin.impl.sdk.d.b.et)).booleanValue()) {
            return encodeToString;
        }
        return m.a(encodeToString, this.a.z(), Utils.getServerAdjustedUnixTimestampMillis(this.a));
    }

    public Map<String, Object> a(Map<String, String> map, boolean z, boolean z2) {
        Map<String, Object> map2 = CollectionUtils.map(64);
        Map<String, Object> a2 = a(z);
        Map<String, Object> h2 = h();
        Map<String, Object> j2 = j();
        Map<String, String> allData = this.a.r().getAllData();
        if (z2) {
            map2.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, a2);
            map2.put("app_info", h2);
            if (map != null) {
                map2.put("ad_info", map);
            }
            if (j2 != null) {
                map2.put("location_info", j2);
            }
            if (!allData.isEmpty()) {
                map2.put("targeting_data", allData);
            }
        } else {
            map2.putAll(a2);
            map2.putAll(h2);
            if (map != null) {
                map2.putAll(map);
            }
            if (j2 != null) {
                map2.putAll(j2);
            }
            if (!allData.isEmpty()) {
                map2.putAll(allData);
            }
        }
        map2.put("accept", "custom_size,launch_app,video");
        map2.put("format", "json");
        Utils.putObjectForStringIfValid("mediation_provider", this.a.t(), map2);
        Utils.putObjectForStringIfValid("plugin_version", (String) this.a.a(com.applovin.impl.sdk.d.b.dC), map2);
        if (!((Boolean) this.a.a(com.applovin.impl.sdk.d.b.es)).booleanValue()) {
            map2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.a.z());
        }
        map2.putAll(i());
        if (((Boolean) this.a.a(com.applovin.impl.sdk.d.b.ec)).booleanValue()) {
            com.applovin.impl.sdk.e.g T = this.a.T();
            map2.put("li", Long.valueOf(T.b(f.b)));
            map2.put("si", Long.valueOf(T.b(f.e)));
            map2.put("mad", Long.valueOf(T.b(f.c)));
            map2.put("msad", Long.valueOf(T.b(f.f)));
            map2.put("pf", Long.valueOf(T.b(f.j)));
            map2.put("mpf", Long.valueOf(T.b(f.q)));
            map2.put("gpf", Long.valueOf(T.b(f.k)));
            map2.put("asoac", Long.valueOf(T.b(f.o)));
        }
        map2.put("rid", UUID.randomUUID().toString());
        return map2;
    }

    public Map<String, Object> a(boolean z) {
        Map<String, Object> map;
        synchronized (this.e) {
            map = CollectionUtils.map(this.d);
        }
        return a(map, z);
    }

    public Map<String, Object> b() {
        return CollectionUtils.map(this.d);
    }

    public Map<String, Object> c() {
        return CollectionUtils.map(this.f);
    }

    public Map<String, Object> d() {
        return a(false);
    }

    public void e() {
        synchronized (this.e) {
            a(this.d);
        }
    }

    public String f() {
        return AppLovinSdkUtils.isFireOS(this.c) ? "fireos" : "android";
    }

    public boolean g() {
        return this.g;
    }

    public Map<String, Object> h() {
        Map<String, Object> map = CollectionUtils.map(this.f);
        map.put("first_install", Boolean.valueOf(this.a.P()));
        map.put("first_install_v2", Boolean.valueOf(!this.a.Q()));
        map.put("test_ads", Boolean.valueOf(this.g));
        map.put("muted", Boolean.valueOf(this.a.p().isMuted()));
        if (((Boolean) this.a.a(com.applovin.impl.sdk.d.b.ds)).booleanValue()) {
            Utils.putObjectForStringIfValid("cuid", this.a.m(), map);
        }
        if (((Boolean) this.a.a(com.applovin.impl.sdk.d.b.dv)).booleanValue()) {
            map.put("compass_random_token", this.a.n());
        }
        if (((Boolean) this.a.a(com.applovin.impl.sdk.d.b.dx)).booleanValue()) {
            map.put("applovin_random_token", this.a.o());
        }
        String name = this.a.q().getName();
        if (StringUtils.isValidString(name)) {
            map.put("user_segment_name", name);
        }
        map.putAll(t());
        return map;
    }

    public Map<String, Object> i() {
        Map<String, Object> map = CollectionUtils.map();
        map.put("sc", this.a.a(com.applovin.impl.sdk.d.b.aa));
        map.put("sc2", this.a.a(com.applovin.impl.sdk.d.b.ab));
        map.put("sc3", this.a.a(com.applovin.impl.sdk.d.b.ac));
        map.put("server_installed_at", this.a.a(com.applovin.impl.sdk.d.b.ad));
        Utils.putObjectForStringIfValid("persisted_data", (String) this.a.a(d.z), map);
        return map;
    }

    public Map<String, Object> j() {
        if (!this.a.p().isLocationCollectionEnabled() || !((Boolean) this.a.a(com.applovin.impl.sdk.d.b.dZ)).booleanValue()) {
            return null;
        }
        Map<String, Object> map = CollectionUtils.map();
        t am = this.a.am();
        boolean b2 = am.b();
        map.put("loc_services_enabled", Boolean.valueOf(b2));
        if (!b2) {
            return map;
        }
        map.put("loc_auth", Boolean.valueOf(am.a()));
        if (am.c()) {
            map.put("loc_lat", Utils.formatDoubleValue(am.d(), ((Integer) this.a.a(com.applovin.impl.sdk.d.b.eb)).intValue()));
            map.put("loc_long", Utils.formatDoubleValue(am.e(), ((Integer) this.a.a(com.applovin.impl.sdk.d.b.eb)).intValue()));
        }
        return map;
    }

    public a k() {
        List<String> testDeviceAdvertisingIds;
        a a2 = com.applovin.impl.sdk.utils.c.a(this.c);
        if (a2 == null) {
            return new a();
        }
        if (((Boolean) this.a.a(com.applovin.impl.sdk.d.b.dq)).booleanValue()) {
            if (a2.a && !((Boolean) this.a.a(com.applovin.impl.sdk.d.b.dp)).booleanValue()) {
                a2.b = "";
            }
            h.set(a2);
        } else {
            a2 = new a();
        }
        boolean z = false;
        if (StringUtils.isValidString(a2.b) && (testDeviceAdvertisingIds = this.a.p().getTestDeviceAdvertisingIds()) != null && testDeviceAdvertisingIds.contains(a2.b)) {
            z = true;
        }
        this.g = z;
        return a2;
    }

    public b l() {
        return j.get();
    }

    public void m() {
        this.a.S().a((com.applovin.impl.sdk.f.a) new com.applovin.impl.sdk.f.f(this.a, new f.a() {
            public void a(a aVar) {
                o.h.set(aVar);
            }
        }), o.a.ADVERTISING_INFO_COLLECTION);
        this.a.S().a((com.applovin.impl.sdk.f.a) new z(this.a, true, new Runnable() {
            public void run() {
                o.this.i.set(o.this.A());
            }
        }), o.a.CACHING_OTHER);
    }
}
