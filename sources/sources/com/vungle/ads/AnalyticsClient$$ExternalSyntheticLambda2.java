package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AnalyticsClient$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ Sdk.SDKError.Reason f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ String f$4;

    public /* synthetic */ AnalyticsClient$$ExternalSyntheticLambda2(Sdk.SDKError.Reason reason, String str, String str2, String str3, String str4) {
        this.f$0 = reason;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = str3;
        this.f$4 = str4;
    }

    public final void run() {
        AnalyticsClient.m250logError$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
