package com.m2catalyst.m2sdk.speed_test.legacy;

import com.m2catalyst.m2sdk.business.models.MNSI;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ThroughputConfigUtil$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ ThroughputConfigUtil f$1;
    public final /* synthetic */ NetworkDiagnosticTestConfig f$2;
    public final /* synthetic */ MNSI f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ long f$5;

    public /* synthetic */ ThroughputConfigUtil$$ExternalSyntheticLambda0(boolean z, ThroughputConfigUtil throughputConfigUtil, NetworkDiagnosticTestConfig networkDiagnosticTestConfig, MNSI mnsi, boolean z2, long j) {
        this.f$0 = z;
        this.f$1 = throughputConfigUtil;
        this.f$2 = networkDiagnosticTestConfig;
        this.f$3 = mnsi;
        this.f$4 = z2;
        this.f$5 = j;
    }

    public final void run() {
        ThroughputConfigUtil.initiateTest$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
