package com.startapp.sdk.components;

import com.startapp.sdk.adsbase.crashreport.ANRRemoteConfig;
import com.startapp.sdk.adsbase.crashreport.b;
import com.startapp.sdk.components.ComponentLocator;

/* compiled from: Sta */
public class i implements b.e {
    public final /* synthetic */ ANRRemoteConfig a;

    public i(ComponentLocator.v vVar, ANRRemoteConfig aNRRemoteConfig) {
        this.a = aNRRemoteConfig;
    }

    public long a(long j) {
        return this.a.b() - j;
    }
}
