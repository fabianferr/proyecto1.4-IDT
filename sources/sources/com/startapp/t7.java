package com.startapp;

import android.app.Activity;
import android.content.Context;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.adsbase.remoteconfig.c;
import java.util.Map;
import java.util.UUID;

/* compiled from: Sta */
public class t7 {
    public static final t7 d = new t7();
    public String a = "";
    public long b = 0;
    public MetaDataRequest.RequestReason c = MetaDataRequest.RequestReason.LAUNCH;

    public String a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public synchronized void a(Context context, MetaDataRequest.RequestReason requestReason) {
        this.a = UUID.randomUUID().toString();
        this.b = System.currentTimeMillis();
        this.c = requestReason;
        Map<Activity, Integer> map = k9.a;
        f fVar = f.d;
        fVar.a.clear();
        fVar.b.clear();
        fVar.c.clear();
        MetaData.k.a(context, new AdPreferences(), requestReason, false, (c) null, true);
    }
}
