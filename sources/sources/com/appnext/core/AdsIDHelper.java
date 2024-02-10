package com.appnext.core;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

public class AdsIDHelper {
    protected static String a(Context context, boolean z) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return "";
        }
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context.getApplicationContext());
            if (advertisingIdInfo != null) {
                if (z) {
                    if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        return "";
                    }
                }
                return advertisingIdInfo.getId();
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
        }
        return "";
    }

    public static boolean isOptOut(Context context) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                return advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
