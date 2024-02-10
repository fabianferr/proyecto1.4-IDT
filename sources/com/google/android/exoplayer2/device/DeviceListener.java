package com.google.android.exoplayer2.device;

import com.android.tools.r8.annotations.SynthesizedClassV2;

@Deprecated
public interface DeviceListener {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.android.exoplayer2.device.DeviceListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onDeviceInfoChanged(DeviceListener _this, DeviceInfo deviceInfo) {
        }

        public static void $default$onDeviceVolumeChanged(DeviceListener _this, int i, boolean z) {
        }
    }

    void onDeviceInfoChanged(DeviceInfo deviceInfo);

    void onDeviceVolumeChanged(int i, boolean z);
}
