package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.StartAppSDKInternal;

/* compiled from: Sta */
public class c8 implements Runnable {
    public final /* synthetic */ Context a;

    public c8(Context context) {
        this.a = context;
    }

    public void run() {
        Object obj = StartAppSDKInternal.E;
        synchronized (StartAppSDKInternal.E) {
            StartAppSDKInternal.a(this.a);
        }
    }
}
