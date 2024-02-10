package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.k9;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.t7;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* compiled from: Sta */
public class StartAppSDK {
    public static void addWrapper(Context context, String str, String str2) {
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
        startAppSDKInternal.getClass();
        if (context != null && str != null && str2 != null) {
            if (startAppSDKInternal.q == null) {
                startAppSDKInternal.q = new TreeMap();
            }
            startAppSDKInternal.q.put(str, str2);
            e e = ComponentLocator.a(context).e();
            Map<String, String> map = startAppSDKInternal.q;
            Map<Activity, Integer> map2 = k9.a;
            String jSONObject = new JSONObject(map).toString();
            e.a a = e.edit();
            a.a("sharedPrefsWrappers", jSONObject);
            a.a.putString("sharedPrefsWrappers", jSONObject);
            a.apply();
        }
    }

    public static void enableMediationMode(Context context, String str, String str2) {
        StartAppAd.disableSplash();
        StartAppAd.disableAutoInterstitial();
        enableReturnAds(false);
        addWrapper(context, str, str2);
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal.d.a.v = true;
    }

    public static void enableReturnAds(boolean z) {
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal.d.a.a(z);
    }

    public static SharedPreferences getExtras(Context context) {
        return ComponentLocator.a(context).k();
    }

    public static String getVersion() {
        return "4.11.0";
    }

    public static void inAppPurchaseMade(Context context) {
        inAppPurchaseMade(context, 0.0d);
    }

    public static void init(Context context, String str) {
        init(context, str, new SDKAdPreferences());
    }

    public static void setTestAdsEnabled(boolean z) {
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal.d.a.D = z;
    }

    public static void setUserConsent(Context context, String str, long j, boolean z) {
        String str2;
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal.d.a.getClass();
        if ("pas".equalsIgnoreCase(str)) {
            e e = ComponentLocator.a(context).e();
            String string = e.getString("USER_CONSENT_PERSONALIZED_ADS_SERVING", (String) null);
            String str3 = "1";
            if (string != null) {
                if (string.equals(z ? str3 : "0")) {
                    return;
                }
            }
            if (z) {
                str2 = str3;
            } else {
                str2 = "0";
            }
            String concat = str2.concat("M");
            i3 i3Var = new i3(j3.d);
            i3Var.d = "User consent: " + str;
            i3Var.e = concat;
            i3Var.a();
            e.a a = e.edit();
            if (!z) {
                str3 = "0";
            }
            a.a("USER_CONSENT_PERSONALIZED_ADS_SERVING", str3);
            a.a.putString("USER_CONSENT_PERSONALIZED_ADS_SERVING", str3);
            a.apply();
            t7 t7Var = t7.d;
            t7.d.a(context, MetaDataRequest.RequestReason.PAS);
        }
    }

    public static void startNewSession(Context context) {
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal.d.a.b(context, MetaDataRequest.RequestReason.CUSTOM);
    }

    public static void inAppPurchaseMade(Context context, double d) {
        e e = ComponentLocator.a(context).e();
        float f = e.getFloat("inAppPurchaseAmount", 0.0f);
        e.a a = e.edit();
        double d2 = (double) f;
        Double.isNaN(d2);
        float f2 = (float) (d2 + d);
        a.a("inAppPurchaseAmount", Float.valueOf(f2));
        a.a.putFloat("inAppPurchaseAmount", f2);
        a.a("payingUser", Boolean.TRUE);
        a.a.putBoolean("payingUser", true);
        a.apply();
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal.d.a.b(context, MetaDataRequest.RequestReason.IN_APP_PURCHASE);
    }

    public static void init(Context context, String str, SDKAdPreferences sDKAdPreferences) {
        init(context, (String) null, str, sDKAdPreferences);
    }

    public static void init(Context context, String str, String str2) {
        init(context, str, str2, new SDKAdPreferences());
    }

    public static void init(Context context, String str, String str2, SDKAdPreferences sDKAdPreferences) {
        init(context, str, str2, sDKAdPreferences, true);
    }

    public static void init(Context context, String str, boolean z) {
        init(context, (String) null, str, z);
    }

    public static void init(Context context, String str, String str2, boolean z) {
        init(context, str, str2, new SDKAdPreferences(), z);
    }

    public static void init(Context context, String str, SDKAdPreferences sDKAdPreferences, boolean z) {
        init(context, (String) null, str, sDKAdPreferences, z);
    }

    public static void init(Context context, String str, String str2, SDKAdPreferences sDKAdPreferences, boolean z) {
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal.d.a.a(context, str, str2, sDKAdPreferences, z);
    }
}
