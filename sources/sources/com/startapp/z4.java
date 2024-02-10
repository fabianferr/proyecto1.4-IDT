package com.startapp;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* compiled from: Sta */
public class z4 {
    public String a;
    public boolean b = true;
    public boolean c = true;
    public Boolean d;
    public Boolean e;

    public z4(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    Object obj = bundle.get("com.startapp.sdk.APPLICATION_ID");
                    if (obj != null) {
                        this.a = obj.toString();
                        Log.i("StartAppSDK", "appId is " + this.a);
                    } else {
                        Log.i("StartAppSDK", "appId hasn't been provided in the Manifest");
                    }
                    if (applicationInfo.metaData.containsKey("com.startapp.sdk.RETURN_ADS_ENABLED")) {
                        this.b = applicationInfo.metaData.getBoolean("com.startapp.sdk.RETURN_ADS_ENABLED");
                        Log.i("StartAppSDK", "returnAds enabled: " + this.b);
                    }
                    if (applicationInfo.metaData.containsKey("com.startapp.sdk.SPLASH_ENABLED")) {
                        this.c = applicationInfo.metaData.getBoolean("com.startapp.sdk.SPLASH_ENABLED");
                        Log.i("StartAppSDK", "splash enabled: " + this.c);
                    }
                    if (applicationInfo.metaData.containsKey("com.startapp.sdk.MIXED_AUDIENCE")) {
                        this.d = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.startapp.sdk.MIXED_AUDIENCE"));
                        Log.i("StartAppSDK", "is mixed audience: " + this.d);
                    }
                    if (applicationInfo.metaData.containsKey("com.startapp.sdk.CHILD_DIRECTED")) {
                        this.e = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.startapp.sdk.CHILD_DIRECTED"));
                        Log.i("StartAppSDK", "is child directed: " + this.e);
                    }
                }
            } catch (Throwable th) {
                i3.a(th);
            }
        }
    }
}
