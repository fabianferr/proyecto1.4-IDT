package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.device.Device;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/unity3d/services/core/device/reader/DeviceInfoReaderWithAuid;", "Lcom/unity3d/services/core/device/reader/IDeviceInfoReader;", "_deviceInfoReader", "(Lcom/unity3d/services/core/device/reader/IDeviceInfoReader;)V", "getDeviceInfoData", "", "", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DeviceInfoReaderWithAuid.kt */
public final class DeviceInfoReaderWithAuid implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;

    public DeviceInfoReaderWithAuid(IDeviceInfoReader iDeviceInfoReader) {
        Intrinsics.checkNotNullParameter(iDeviceInfoReader, "_deviceInfoReader");
        this._deviceInfoReader = iDeviceInfoReader;
    }

    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        Intrinsics.checkNotNullExpressionValue(deviceInfoData, "_deviceInfoReader.deviceInfoData");
        String auid = Device.getAuid();
        if (auid != null) {
            deviceInfoData.put(JsonStorageKeyNames.AUID_ID_KEY, auid);
        }
        return deviceInfoData;
    }
}
