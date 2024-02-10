package com.startapp.sdk.adsbase.remoteconfig;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.startapp.c8;
import com.startapp.h0;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.components.ComponentLocator;

/* compiled from: Sta */
public class BootCompleteListener extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Object obj = StartAppSDKInternal.E;
        Context a = h0.a(context);
        if (a != null) {
            context = a;
        }
        StartAppSDKInternal.d.a.g(context);
        ComponentLocator.a(context).h().execute(new c8(context));
    }
}
