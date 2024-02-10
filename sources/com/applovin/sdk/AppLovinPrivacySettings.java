package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.u;

public class AppLovinPrivacySettings {
    public static boolean hasUserConsent(Context context) {
        u.f("AppLovinPrivacySettings", "hasUserConsent()");
        Boolean a = j.b().a(context);
        if (a != null) {
            return a.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUser(Context context) {
        u.f("AppLovinPrivacySettings", "isAgeRestrictedUser()");
        Boolean a = j.a().a(context);
        if (a != null) {
            return a.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUserSet(Context context) {
        u.f("AppLovinPrivacySettings", "isAgeRestrictedUserSet()");
        return j.a().a(context) != null;
    }

    public static boolean isDoNotSell(Context context) {
        u.f("AppLovinPrivacySettings", "isDoNotSell()");
        Boolean a = j.c().a(context);
        if (a != null) {
            return a.booleanValue();
        }
        return false;
    }

    public static boolean isDoNotSellSet(Context context) {
        u.f("AppLovinPrivacySettings", "isDoNotSellSet()");
        return j.c().a(context) != null;
    }

    public static boolean isUserConsentSet(Context context) {
        u.f("AppLovinPrivacySettings", "isUserConsentSet()");
        return j.b().a(context) != null;
    }

    public static void setDoNotSell(boolean z, Context context) {
        u.f("AppLovinPrivacySettings", "setDoNotSell()");
        if (j.c(z, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, (Boolean) null, Boolean.valueOf(z));
        }
    }

    public static void setHasUserConsent(boolean z, Context context) {
        u.f("AppLovinPrivacySettings", "setHasUserConsent()");
        if (j.b(z, context)) {
            AppLovinSdk.reinitializeAll(Boolean.valueOf(z), (Boolean) null, (Boolean) null);
        }
    }

    public static void setIsAgeRestrictedUser(boolean z, Context context) {
        u.f("AppLovinPrivacySettings", "setIsAgeRestrictedUser()");
        if (j.a(z, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, Boolean.valueOf(z), (Boolean) null);
        }
    }
}
