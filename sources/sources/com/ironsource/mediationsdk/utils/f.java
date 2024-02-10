package com.ironsource.mediationsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.ironsource.environment.a;
import com.ironsource.environment.c;
import com.ironsource.environment.g;
import com.ironsource.environment.h;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.z;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class f implements Runnable {
    private final String A = ThroughputConfigUtil.SHARED_PREFS_KEY_MNC;
    private final String B = "icc";
    private final String C = "tz";
    private final String D = JsonStorageKeyNames.AUID_ID_KEY;
    private final String E = "userLat";
    private final String F = "publisherAPI";
    private final String G = "missingDependencies";
    private final String H = "missingManifest";
    private final String I = "other";
    private Context J;
    private final String a = getClass().getSimpleName();
    private final String b = "bundleId";
    private final String c = "advertisingId";
    private final String d = "isLimitAdTrackingEnabled";
    private final String e = "appKey";
    private final String f = "deviceOS";
    private final String g = "osVersion";
    private final String h = "connectionType";
    private final String i = "language";
    private final String j = "deviceOEM";
    private final String k = "deviceModel";
    private final String l = "mobileCarrier";
    private final String m = "externalFreeMemory";
    private final String n = "internalFreeMemory";
    private final String o = "battery";
    private final String p = "gmtMinutesOffset";
    private final String q = "appVersion";
    private final String r = JsonStorageKeyNames.SESSION_ID_KEY;
    private final String s = "pluginType";
    private final String t = "pluginVersion";
    private final String u = "plugin_fw_v";
    private final String v = "jb";
    private final String w = "advertisingIdType";
    private final String x = "mt";
    private final String y = "firstSession";
    private final String z = ThroughputConfigUtil.SHARED_PREFS_KEY_MCC;

    private f() {
    }

    public f(Context context) {
        this.J = context.getApplicationContext();
    }

    private static String a() {
        try {
            return ConfigFile.getConfigFile().getPluginType();
        } catch (Exception e2) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginType()", e2);
            return "";
        }
    }

    private static String b() {
        try {
            return ConfigFile.getConfigFile().getPluginVersion();
        } catch (Exception e2) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginVersion()", e2);
            return "";
        }
    }

    private static String c() {
        try {
            return ConfigFile.getConfigFile().getPluginFrameworkVersion();
        } catch (Exception e2) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginFrameworkVersion()", e2);
            return "";
        }
    }

    private String d() {
        try {
            return this.J.getPackageName();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String e() {
        try {
            String str = Build.VERSION.RELEASE;
            int i2 = Build.VERSION.SDK_INT;
            return i2 + "(" + str + ")";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String f() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String g() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String h() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    private String i() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.J.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            return !networkOperatorName.equals("") ? networkOperatorName : "";
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.a + ":getMobileCarrier()", e2);
            return "";
        }
    }

    private static boolean j() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    private static long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        } catch (Exception unused) {
            return -1;
        }
    }

    private int l() {
        try {
            Intent registerReceiver = this.J.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i2 = 0;
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : 0;
            if (registerReceiver != null) {
                i2 = registerReceiver.getIntExtra("scale", -1);
            }
            if (intExtra == -1 || i2 == -1) {
                return -1;
            }
            return (int) ((((float) intExtra) / ((float) i2)) * 100.0f);
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.a + ":getBatteryLevel()", e2);
            return -1;
        }
    }

    private int m() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            return Math.round((float) (((timeZone.getOffset(GregorianCalendar.getInstance(timeZone).getTimeInMillis()) / 1000) / 60) / 15)) * 15;
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.a + ":getGmtMinutesOffset()", e2);
            return 0;
        }
    }

    public final void run() {
        boolean z2;
        boolean z3;
        long j2;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(JsonStorageKeyNames.SESSION_ID_KEY, IronSourceUtils.getSessionId());
            String d2 = d();
            if (!TextUtils.isEmpty(d2)) {
                hashMap.put("bundleId", d2);
                String c2 = c.c(this.J, d2);
                if (!TextUtils.isEmpty(c2)) {
                    hashMap.put("appVersion", c2);
                }
            }
            hashMap.put("appKey", z.a().g);
            String str = "";
            String C2 = h.C(this.J);
            String D2 = h.D(this.J);
            boolean z4 = true;
            if (!TextUtils.isEmpty(C2)) {
                str = IronSourceConstants.TYPE_GAID;
                z2 = false;
            } else {
                C2 = h.x(this.J);
                if (!TextUtils.isEmpty(C2)) {
                    str = IronSourceConstants.TYPE_UUID;
                }
                z2 = true;
            }
            if (!TextUtils.isEmpty(C2)) {
                hashMap.put("advertisingId", C2);
                hashMap.put("advertisingIdType", str);
            }
            if (!TextUtils.isEmpty(D2)) {
                z3 = Boolean.parseBoolean(D2);
                hashMap.put("isLimitAdTrackingEnabled", Boolean.valueOf(z3));
            } else {
                z3 = false;
            }
            if (z2 || z3) {
                String str2 = "other";
                if (TextUtils.isEmpty(D2)) {
                    str2 = "missingDependencies";
                } else {
                    g gVar = g.a;
                    if (!g.b()) {
                        str2 = "publisherAPI";
                    } else if (!h.G(this.J)) {
                        str2 = "missingManifest";
                    } else if (Boolean.parseBoolean(D2)) {
                        str2 = "userLat";
                    }
                }
                hashMap.put("AdvIdOptOutReason", str2);
            }
            hashMap.put("deviceOS", "Android");
            if (!TextUtils.isEmpty(e())) {
                hashMap.put("osVersion", e());
            }
            String connectionType = IronSourceUtils.getConnectionType(this.J);
            if (!TextUtils.isEmpty(connectionType)) {
                hashMap.put("connectionType", connectionType);
            }
            hashMap.put("sdkVersion", IronSourceUtils.getSDKVersion());
            String f2 = f();
            if (!TextUtils.isEmpty(f2)) {
                hashMap.put("language", f2);
            }
            String g2 = g();
            if (!TextUtils.isEmpty(g2)) {
                hashMap.put("deviceOEM", g2);
            }
            String h2 = h();
            if (!TextUtils.isEmpty(h2)) {
                hashMap.put("deviceModel", h2);
            }
            String i2 = i();
            if (!TextUtils.isEmpty(i2)) {
                hashMap.put("mobileCarrier", i2);
            }
            hashMap.put("internalFreeMemory", Long.valueOf(k()));
            if (j()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j2 = (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            } else {
                j2 = -1;
            }
            hashMap.put("externalFreeMemory", Long.valueOf(j2));
            hashMap.put("battery", Integer.valueOf(l()));
            int m2 = m();
            if (m2 > 840 || m2 < -720 || m2 % 15 != 0) {
                z4 = false;
            }
            if (z4) {
                hashMap.put("gmtMinutesOffset", Integer.valueOf(m2));
            }
            String a2 = a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put("pluginType", a2);
            }
            String b2 = b();
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("pluginVersion", b2);
            }
            String c3 = c();
            if (!TextUtils.isEmpty(c3)) {
                hashMap.put("plugin_fw_v", c3);
            }
            String valueOf = String.valueOf(h.j());
            if (!TextUtils.isEmpty(valueOf)) {
                hashMap.put("jb", valueOf);
            }
            String str3 = z.a().k;
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("mt", str3);
            }
            String valueOf2 = String.valueOf(IronSourceUtils.getFirstSession(this.J));
            if (!TextUtils.isEmpty(valueOf2)) {
                hashMap.put("firstSession", valueOf2);
            }
            String y2 = h.y(this.J);
            if (!TextUtils.isEmpty(y2)) {
                hashMap.put(JsonStorageKeyNames.AUID_ID_KEY, y2);
            }
            hashMap.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC, Integer.valueOf(a.AnonymousClass1.c(this.J)));
            hashMap.put(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC, Integer.valueOf(a.AnonymousClass1.d(this.J)));
            String j3 = h.j(this.J);
            if (!TextUtils.isEmpty(j3)) {
                hashMap.put("icc", j3);
            }
            String c4 = h.c();
            if (!TextUtils.isEmpty(c4)) {
                hashMap.put("tz", c4);
            }
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("collecting data for events: " + hashMap);
            com.ironsource.mediationsdk.sdk.c.a().a((Map<String, Object>) hashMap);
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, "Thread name = " + getClass().getSimpleName(), e2);
        }
    }
}
