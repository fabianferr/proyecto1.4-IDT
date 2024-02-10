package com.m2catalyst.m2sdk.speed_test.legacy;

import com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults;
import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import com.m2catalyst.m2sdk.ndt.models.LatencyTestResults;

public interface ThroughputTestSystemListener {
    void downloadTestComplete(BandwidthTestResults bandwidthTestResults);

    void downloadTestUpdate(int i, long j, long j2, double d);

    void finishTesting();

    void latencyTestComplete(LatencyTestResults latencyTestResults);

    void latencyUpdate(double d, int i, int i2, double d2);

    void setTestFailedCalledFalse();

    void setTestFailedCalledTrue();

    void testFailed(String str, int i, boolean z);

    void throughputTestComplete(DiagnosticsResults diagnosticsResults);

    void uploadTestComplete(BandwidthTestResults bandwidthTestResults);

    void uploadTestUpdate(double d, double d2, double d3, double d4);

    void webSocketClientOpened();
}
