package com.umlaut.crowd.speedtest;

import com.umlaut.crowd.internal.RDT;
import com.umlaut.crowd.internal.RLT;
import com.umlaut.crowd.internal.RUT;

public interface ISpeedtestListener {
    void onDownloadTestResult(RDT rdt);

    void onLatencyTestResult(RLT rlt);

    void onPingProgress(float f, int i);

    void onTestStatusChanged(SpeedtestStatus speedtestStatus);

    void onTransferProgress(float f, long j);

    void onUploadTestResult(RUT rut);
}
