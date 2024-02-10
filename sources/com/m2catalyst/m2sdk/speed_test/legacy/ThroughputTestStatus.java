package com.m2catalyst.m2sdk.speed_test.legacy;

import com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults;
import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import com.m2catalyst.m2sdk.ndt.models.LatencyTestResults;

public class ThroughputTestStatus implements ThroughputTestSystemListener {
    boolean connected = false;
    boolean downloadTestCompleted = false;
    BandwidthTestResults downloadTestResults;
    DiagnosticsResults finalResults;
    boolean latencyTestCompleted = false;
    LatencyTestResults latencyTestResults;
    boolean testFailed = false;
    int testFailureErrorCode;
    String testFailureReason;
    boolean testsCompleted = false;
    boolean uploadTestCompleted = false;
    BandwidthTestResults uploadTestResults;

    public void downloadTestComplete(BandwidthTestResults bandwidthTestResults) {
        this.downloadTestResults = bandwidthTestResults;
        this.downloadTestCompleted = true;
    }

    public void downloadTestUpdate(int i, long j, long j2, double d) {
    }

    public void finishTesting() {
    }

    public void latencyTestComplete(LatencyTestResults latencyTestResults2) {
        this.latencyTestResults = latencyTestResults2;
        this.latencyTestCompleted = true;
    }

    public void latencyUpdate(double d, int i, int i2, double d2) {
    }

    public void setTestFailedCalledFalse() {
    }

    public void setTestFailedCalledTrue() {
    }

    public void testFailed(String str, int i, boolean z) {
        this.testFailed = true;
        this.testFailureReason = str;
        this.testFailureErrorCode = i;
    }

    public void throughputTestComplete(DiagnosticsResults diagnosticsResults) {
        this.finalResults = diagnosticsResults;
        this.testsCompleted = true;
    }

    public void uploadTestComplete(BandwidthTestResults bandwidthTestResults) {
        this.uploadTestResults = bandwidthTestResults;
        this.uploadTestCompleted = true;
    }

    public void uploadTestUpdate(double d, double d2, double d3, double d4) {
    }

    public void webSocketClientOpened() {
        this.connected = true;
    }
}
