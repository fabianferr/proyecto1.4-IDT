package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AnalyticsClient$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ Sdk.SDKMetric.SDKMetricType f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ String f$4;
    public final /* synthetic */ String f$5;

    public /* synthetic */ AnalyticsClient$$ExternalSyntheticLambda3(Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, String str, String str2, String str3, String str4) {
        this.f$0 = sDKMetricType;
        this.f$1 = j;
        this.f$2 = str;
        this.f$3 = str2;
        this.f$4 = str3;
        this.f$5 = str4;
    }

    public final void run() {
        AnalyticsClient.m251logMetric$lambda3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
