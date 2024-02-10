package com.cellrebel.sdk;

import android.content.Context;
import com.cellrebel.sdk.utils.Utils;
import com.cellrebel.sdk.workers.TrackingManager;

public class CRMeasurementSDK {
    public static void clearUserData(Context context, TrackingManager.OnCompleteListener onCompleteListener) {
        TrackingManager.clearUserData(context, onCompleteListener);
    }

    public static void init(Context context, String str) {
        TrackingManager.init(context, str);
    }

    public static void setBackgroundMeasurementsEnabled(boolean z) {
        TrackingManager.setBackgroundMeasurementsEnabled(z);
    }

    public static void startMeasuring(Context context) {
        TrackingManager.startTracking(context);
    }

    public static void startMeasuring(Context context, TrackingManager.OnCompleteListener onCompleteListener) {
        if (onCompleteListener != null) {
            TrackingManager.startTracking(context, onCompleteListener);
        } else {
            TrackingManager.startTracking(context);
        }
    }

    public static void stopMeasuring(Context context) {
        TrackingManager.stopTracking(context);
    }

    public static String version(Context context) {
        return Utils.d(context);
    }
}
