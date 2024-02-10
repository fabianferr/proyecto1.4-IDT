package com.startapp.sdk.adsbase.remoteconfig;

import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;

/* compiled from: Sta */
public class b implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ MetaDataRequest.RequestReason b;
    public final /* synthetic */ boolean c;

    public b(c cVar, MetaDataRequest.RequestReason requestReason, boolean z) {
        this.a = cVar;
        this.b = requestReason;
        this.c = z;
    }

    public void run() {
        this.a.a(this.b, this.c);
    }
}
