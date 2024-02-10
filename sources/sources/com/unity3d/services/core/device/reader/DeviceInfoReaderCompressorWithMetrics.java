package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DeviceInfoReaderCompressorWithMetrics implements IDeviceInfoDataCompressor {
    private final IDeviceInfoDataCompressor _deviceInfoDataCompressor;
    private long _endTime;
    private final SDKMetricsSender _sdkMetricsSender = ((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class));
    private long _startTimeCompression;
    private long _startTimeInfo;

    public DeviceInfoReaderCompressorWithMetrics(IDeviceInfoDataCompressor iDeviceInfoDataCompressor) {
        this._deviceInfoDataCompressor = iDeviceInfoDataCompressor;
    }

    public byte[] getDeviceData() {
        if (this._deviceInfoDataCompressor == null) {
            return new byte[0];
        }
        this._startTimeInfo = System.nanoTime();
        byte[] compressDeviceInfo = compressDeviceInfo(getDeviceInfo());
        sendDeviceInfoMetrics();
        return compressDeviceInfo;
    }

    public Map<String, Object> getDeviceInfo() {
        return this._deviceInfoDataCompressor.getDeviceInfo();
    }

    public byte[] compressDeviceInfo(Map<String, Object> map) {
        this._startTimeCompression = System.nanoTime();
        byte[] compressDeviceInfo = this._deviceInfoDataCompressor.compressDeviceInfo(map);
        this._endTime = System.nanoTime();
        return compressDeviceInfo;
    }

    private long getDeviceInfoCollectionDuration() {
        return TimeUnit.NANOSECONDS.toMillis(this._startTimeCompression - this._startTimeInfo);
    }

    private long getCompressionDuration() {
        return TimeUnit.NANOSECONDS.toMillis(this._endTime - this._startTimeCompression);
    }

    private void sendDeviceInfoMetrics() {
        this._sdkMetricsSender.sendMetric(TSIMetric.newDeviceInfoCollectionLatency(Long.valueOf(getDeviceInfoCollectionDuration())));
        this._sdkMetricsSender.sendMetric(TSIMetric.newDeviceInfoCompressionLatency(Long.valueOf(getCompressionDuration())));
    }
}
