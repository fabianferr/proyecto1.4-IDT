package com.bytedance.sdk.openadsdk.api.factory;

import android.util.Log;

public class SDKTypeConfig {
    private static ISDKTypeFactory a;

    public static ISDKTypeFactory getSdkTypeFactory() {
        Log.i("SDKTypeConfig", "getSdkTypeFactory: ");
        return a;
    }

    public static void setSdkTypeFactory(ISDKTypeFactory iSDKTypeFactory) {
        Log.i("SDKTypeConfig", "setSdkTypeFactory: ");
        a = iSDKTypeFactory;
    }
}
