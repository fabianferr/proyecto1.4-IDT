package com.mbridge.msdk.foundation.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.a;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.tools.b;
import org.json.JSONObject;

/* compiled from: DomainSameDiTool */
public class g {
    private static volatile String a = null;
    private static String b = null;
    private static String c = "";
    private static String d = "";
    private static boolean e = false;
    private static boolean f = false;
    /* access modifiers changed from: private */
    public static int g;

    public static void a(Context context) {
        if (context != null) {
            try {
                Class<?> cls = Class.forName("com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebEnvCheckEntry");
                Object newInstance = cls.newInstance();
                cls.getMethod("check", new Class[]{Context.class}).invoke(newInstance, new Object[]{context});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String a() {
        if (!a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!a.g()) {
            if (TextUtils.isEmpty(a)) {
                return "";
            }
            return a;
        } else if (TextUtils.isEmpty(a)) {
            w.z();
            if (!f) {
                b(b.d().g());
                f = true;
            }
            if (TextUtils.isEmpty(a)) {
                return "";
            }
            return a;
        } else if (a.h()) {
            return a;
        } else {
            if (g == 0) {
                return a;
            }
            return "";
        }
    }

    public static int b() {
        return g;
    }

    public static void a(int i) {
        g = i;
    }

    public static void a(String str) {
        b = u.a(str);
        a = str;
    }

    public static String c() {
        if (!a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!a.g()) {
            if (TextUtils.isEmpty(b)) {
                return "";
            }
            return b;
        } else if (TextUtils.isEmpty(b)) {
            if (!f) {
                b(b.d().g());
                f = true;
            }
            return "";
        } else if (a.h()) {
            return b;
        } else {
            if (g == 0) {
                return b;
            }
            return "";
        }
    }

    public static void b(final Context context) {
        new Thread(new Runnable() {
            public final void run() {
                if (a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID) && a.g()) {
                    int i = 1;
                    try {
                        Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                        g.a(advertisingIdInfo.getId());
                        int unused = g.g = advertisingIdInfo.isLimitAdTrackingEnabled() ? 1 : 0;
                        g.a(context, advertisingIdInfo.getId(), g.g);
                    } catch (Exception e) {
                        aa.c("DomainSameDiTool", e.getMessage());
                        try {
                            b.a a2 = new b().a(context);
                            g.a(a2.a());
                            if (!a2.b()) {
                                i = 0;
                            }
                            int unused2 = g.g = i;
                            g.a(context, a2.a(), g.g);
                        } catch (Exception e2) {
                            aa.c("DomainSameDiTool", e2.getMessage());
                        }
                    } catch (Throwable th) {
                        aa.d("DomainSameDiTool", th.getMessage());
                    }
                }
            }
        }).start();
    }

    public static String d() {
        if (!a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (e) {
            return c;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ContentResolver contentResolver = com.mbridge.msdk.foundation.controller.b.d().g().getContentResolver();
            int i = Settings.Secure.getInt(contentResolver, "limit_ad_tracking");
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            jSONObject.put("status", i);
            jSONObject.put("amazonId", string);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                d = jSONObject2;
                c = u.a(jSONObject2);
            }
        } catch (Settings.SettingNotFoundException e2) {
            aa.d("DomainSameDiTool", e2.getMessage());
        } catch (Throwable th) {
            aa.d("DomainSameDiTool", th.getMessage());
        }
        e = true;
        return c;
    }

    public static String e() {
        if (TextUtils.isEmpty(d) && !e) {
            d();
        }
        return d;
    }

    static /* synthetic */ void a(Context context, String str, int i) {
        try {
            if (ak.b(str)) {
                ai.a(context, MBridgeConstans.SP_GA_ID, str);
            }
            ai.a(context, MBridgeConstans.SP_GA_ID_LIMIT, Integer.valueOf(i));
        } catch (Exception e2) {
            aa.d("DomainSameDiTool", e2.getMessage());
        }
    }
}
