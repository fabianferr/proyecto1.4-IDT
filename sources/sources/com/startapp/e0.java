package com.startapp;

import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.AppSessionConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Sta */
public class e0 {
    public final a a;
    public final i2<AppSessionConfig> b;
    public final Map<AdPreferences.Placement, Integer> c = new ConcurrentHashMap();
    public long d;
    public long e;

    /* compiled from: Sta */
    public interface a {
    }

    public e0(a aVar, i2<AppSessionConfig> i2Var) {
        this.a = aVar;
        this.b = i2Var;
    }
}
