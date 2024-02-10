package com.umlaut.crowd.speedtest;

public interface IBandwidthListener {
    void onPingProgress(float f, int i);

    void onTestStatusChanged(SpeedtestEngineStatus speedtestEngineStatus, SpeedtestEngineError speedtestEngineError, long j);

    void onTracerouteProgress(float f, String str, int i, int i2);

    void onTransferProgress(float f, long j);

    void onTransferProgressRemote(float f, long j);
}
