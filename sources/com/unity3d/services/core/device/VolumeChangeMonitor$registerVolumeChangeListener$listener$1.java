package com.unity3d.services.core.device;

import com.unity3d.services.core.webview.WebViewEventCategory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/unity3d/services/core/device/VolumeChangeMonitor$registerVolumeChangeListener$listener$1", "Lcom/unity3d/services/core/device/VolumeChangeListener;", "getStreamType", "", "onVolumeChanged", "", "volume", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VolumeChangeMonitor.kt */
public final class VolumeChangeMonitor$registerVolumeChangeListener$listener$1 implements VolumeChangeListener {
    final /* synthetic */ int $streamType;
    final /* synthetic */ VolumeChangeMonitor this$0;

    VolumeChangeMonitor$registerVolumeChangeListener$listener$1(VolumeChangeMonitor volumeChangeMonitor, int i) {
        this.this$0 = volumeChangeMonitor;
        this.$streamType = i;
    }

    public void onVolumeChanged(int i) {
        this.this$0.eventSender.sendEvent(WebViewEventCategory.DEVICEINFO, DeviceInfoEvent.VOLUME_CHANGED, Integer.valueOf(getStreamType()), Integer.valueOf(i), Integer.valueOf(Device.getStreamMaxVolume(this.$streamType)));
    }

    public int getStreamType() {
        return this.$streamType;
    }
}
