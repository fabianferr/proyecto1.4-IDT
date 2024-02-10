package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.d;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppLovinSdk {
    private static final String TAG = "AppLovinSdk";
    public static final String VERSION = getVersion();
    public static final int VERSION_CODE = getVersionCode();
    private static final Map<String, AppLovinSdk> sdkInstances = new HashMap(1);
    private static final Object sdkInstancesLock = new Object();
    public final m coreSdk;

    public interface SdkInitializationListener {
        void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration);
    }

    private static class a extends AppLovinSdkSettings {
        a(Context context) {
            super(context);
        }
    }

    private AppLovinSdk(m mVar) {
        this.coreSdk = mVar;
    }

    public static List<AppLovinSdk> a() {
        return new ArrayList(sdkInstances.values());
    }

    public static AppLovinSdk getInstance(Context context) {
        return getInstance(new a(context), context);
    }

    public static AppLovinSdk getInstance(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (context != null) {
            return getInstance(d.a(context).a("applovin.sdk.key", ""), appLovinSdkSettings, context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    public static AppLovinSdk getInstance(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (appLovinSdkSettings == null) {
            throw new IllegalArgumentException("No userSettings specified");
        } else if (context != null) {
            synchronized (sdkInstancesLock) {
                Map<String, AppLovinSdk> map = sdkInstances;
                if (map.containsKey(str)) {
                    AppLovinSdk appLovinSdk = map.get(str);
                    return appLovinSdk;
                }
                if (!TextUtils.isEmpty(str) && str.contains(File.separator)) {
                    if (u.a()) {
                        u.i(TAG, "\n**************************************************\nINVALID SDK KEY: " + str + "\n**************************************************\n");
                    }
                    if (!map.isEmpty()) {
                        AppLovinSdk next = map.values().iterator().next();
                        return next;
                    }
                    str = str.replace(File.separator, "");
                }
                m mVar = new m();
                mVar.a(str, appLovinSdkSettings, context);
                AppLovinSdk appLovinSdk2 = new AppLovinSdk(mVar);
                mVar.a(appLovinSdk2);
                appLovinSdkSettings.attachAppLovinSdk(mVar);
                map.put(str, appLovinSdk2);
                return appLovinSdk2;
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    private static String getVersion() {
        return "11.4.6";
    }

    private static int getVersionCode() {
        return 11040699;
    }

    public static void initializeSdk(Context context) {
        initializeSdk(context, (SdkInitializationListener) null);
    }

    public static void initializeSdk(Context context, SdkInitializationListener sdkInitializationListener) {
        if (context != null) {
            AppLovinSdk instance = getInstance(context);
            if (instance != null) {
                instance.initializeSdk(sdkInitializationListener);
            } else if (u.a()) {
                u.i(TAG, "Unable to initialize AppLovin SDK: SDK object not created");
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    static void reinitializeAll(Boolean bool, Boolean bool2, Boolean bool3) {
        synchronized (sdkInstancesLock) {
            for (AppLovinSdk next : sdkInstances.values()) {
                next.coreSdk.b();
                next.coreSdk.i();
                if (bool != null) {
                    if (u.a()) {
                        u A = next.coreSdk.A();
                        A.c(TAG, "Toggled 'huc' to " + bool);
                    }
                    next.getEventService().trackEvent(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, CollectionUtils.map("value", bool.toString()));
                }
                if (bool2 != null) {
                    if (u.a()) {
                        u A2 = next.coreSdk.A();
                        A2.c(TAG, "Toggled 'aru' to " + bool2);
                    }
                    next.getEventService().trackEvent(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, CollectionUtils.map("value", bool2.toString()));
                }
                if (bool3 != null) {
                    if (u.a()) {
                        u A3 = next.coreSdk.A();
                        A3.c(TAG, "Toggled 'dns' to " + bool3);
                    }
                    next.getEventService().trackEvent(AppLovinSdkExtraParameterKey.DO_NOT_SELL, CollectionUtils.map("value", bool3.toString()));
                }
            }
        }
    }

    public AppLovinAdService getAdService() {
        return this.coreSdk.u();
    }

    public List<MaxMediatedNetworkInfo> getAvailableMediatedNetworks() {
        JSONArray a2 = c.a(this.coreSdk);
        ArrayList arrayList = new ArrayList(a2.length());
        for (int i = 0; i < a2.length(); i++) {
            arrayList.add(new MaxMediatedNetworkInfoImpl(JsonUtils.getJSONObject(a2, i, (JSONObject) null)));
        }
        return arrayList;
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.coreSdk.s();
    }

    public AppLovinEventService getEventService() {
        return this.coreSdk.w();
    }

    public String getMediationProvider() {
        return this.coreSdk.t();
    }

    public AppLovinPostbackService getPostbackService() {
        return this.coreSdk.X();
    }

    public String getSdkKey() {
        return this.coreSdk.z();
    }

    public AppLovinSdkSettings getSettings() {
        return this.coreSdk.p();
    }

    public AppLovinTargetingData getTargetingData() {
        return this.coreSdk.r();
    }

    public String getUserIdentifier() {
        return this.coreSdk.m();
    }

    public AppLovinUserSegment getUserSegment() {
        return this.coreSdk.q();
    }

    public AppLovinUserService getUserService() {
        return this.coreSdk.x();
    }

    public AppLovinVariableService getVariableService() {
        return this.coreSdk.y();
    }

    public void initializeSdk() {
    }

    public void initializeSdk(SdkInitializationListener sdkInitializationListener) {
        this.coreSdk.a(sdkInitializationListener);
    }

    public boolean isEnabled() {
        return this.coreSdk.d();
    }

    public boolean isInitialized() {
        return this.coreSdk.d();
    }

    public void setMediationProvider(String str) {
        this.coreSdk.c(str);
    }

    public void setPluginVersion(String str) {
        this.coreSdk.a(str);
    }

    public void setUserIdentifier(String str) {
        this.coreSdk.b(str);
    }

    public void showMediationDebugger() {
        this.coreSdk.l();
    }

    public void showMediationDebugger(Map<String, List<?>> map) {
        this.coreSdk.a(map);
    }

    public String toString() {
        return "AppLovinSdk{sdkKey='" + getSdkKey() + "', isEnabled=" + isEnabled() + ", isFirstSession=" + this.coreSdk.P() + AbstractJsonLexerKt.END_OBJ;
    }
}
