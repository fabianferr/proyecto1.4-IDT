package com.applovin.mediation;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MediationUtils;
import java.util.ArrayList;

public class AppLovinUtils {
    private static final String DEFAULT_ZONE = "";

    public static class ServerParameterKeys {
        public static final String SDK_KEY = "sdkKey";
        public static final String ZONE_ID = "zone_id";

        private ServerParameterKeys() {
        }
    }

    public static AppLovinSdk retrieveSdk(Bundle bundle, Context context) {
        AppLovinSdk appLovinSdk;
        String string = bundle != null ? bundle.getString(ServerParameterKeys.SDK_KEY) : null;
        AppLovinSdkSettings sdkSettings = AppLovinMediationAdapter.getSdkSettings(context);
        if (!TextUtils.isEmpty(string)) {
            appLovinSdk = AppLovinSdk.getInstance(string, sdkSettings, context);
        } else {
            appLovinSdk = AppLovinSdk.getInstance(sdkSettings, context);
        }
        appLovinSdk.setPluginVersion(BuildConfig.ADAPTER_VERSION);
        appLovinSdk.setMediationProvider(AppLovinMediationProvider.ADMOB);
        return appLovinSdk;
    }

    public static String retrieveSdkKey(Context context, Bundle bundle) {
        Bundle retrieveMetadata;
        String string = bundle != null ? bundle.getString(ServerParameterKeys.SDK_KEY) : null;
        return (!TextUtils.isEmpty(string) || (retrieveMetadata = retrieveMetadata(context)) == null) ? string : retrieveMetadata.getString("applovin.sdk.key");
    }

    private static Bundle retrieveMetadata(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String retrieveZoneId(Bundle bundle) {
        return bundle.containsKey(ServerParameterKeys.ZONE_ID) ? bundle.getString(ServerParameterKeys.ZONE_ID) : "";
    }

    public static boolean shouldMuteAudio(Bundle bundle) {
        return bundle != null && bundle.getBoolean("mute_audio");
    }

    public static AdError getAdError(int i) {
        String str = "AppLovin error code " + i;
        if (i == -8) {
            str = "INVALID_AD_TOKEN";
        } else if (i == -7) {
            str = "INVALID_ZONE";
        } else if (i != -6) {
            switch (i) {
                case -1009:
                    str = "NO_NETWORK";
                    break;
                case -1001:
                    str = "FETCH_AD_TIMEOUT";
                    break;
                case AppLovinErrorCodes.INVALID_URL /*-900*/:
                    str = "INVALID_URL";
                    break;
                case AppLovinErrorCodes.INVALID_RESPONSE /*-800*/:
                    str = "INVALID_RESPONSE";
                    break;
                case AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO /*-600*/:
                    str = "INCENTIVIZED_USER_CLOSED_VIDEO";
                    break;
                case AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT /*-500*/:
                    str = "INCENTIVIZED_SERVER_TIMEOUT";
                    break;
                case AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR /*-400*/:
                    str = "INCENTIVIZED_UNKNOWN_SERVER_ERROR";
                    break;
                case AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED /*-300*/:
                    str = "INCENTIVIZED_NO_AD_PRELOADED";
                    break;
                case -22:
                    str = "SDK_DISABLED";
                    break;
                case -1:
                    str = "UNSPECIFIED_ERROR";
                    break;
                case 204:
                    str = "NO_FILL";
                    break;
                default:
                    switch (i) {
                        case AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES /*-202*/:
                            str = "UNABLE_TO_PRECACHE_VIDEO_RESOURCES";
                            break;
                        case AppLovinErrorCodes.UNABLE_TO_PRECACHE_IMAGE_RESOURCES /*-201*/:
                            str = "UNABLE_TO_PRECACHE_IMAGE_RESOURCES";
                            break;
                        case AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES /*-200*/:
                            str = "UNABLE_TO_PRECACHE_RESOURCES";
                            break;
                    }
            }
        } else {
            str = "UNABLE_TO_RENDER_AD";
        }
        return new AdError(i, "AppLovin SDK returned a load failure callback with reason: " + str, AppLovinMediationAdapter.ERROR_DOMAIN);
    }

    public static AppLovinAdSize appLovinAdSizeFromAdMobAdSize(Context context, AdSize adSize) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AdSize.BANNER);
        arrayList.add(AdSize.LEADERBOARD);
        AdSize findClosestSize = MediationUtils.findClosestSize(context, adSize, arrayList);
        if (AdSize.BANNER.equals(findClosestSize)) {
            return AppLovinAdSize.BANNER;
        }
        if (AdSize.LEADERBOARD.equals(findClosestSize)) {
            return AppLovinAdSize.LEADER;
        }
        return null;
    }
}
