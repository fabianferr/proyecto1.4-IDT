package com.unity3d.services.core.device;

import android.util.SparseArray;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.unity3d.services.core.webview.bridge.IEventSender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/unity3d/services/core/device/VolumeChangeMonitor;", "", "eventSender", "Lcom/unity3d/services/core/webview/bridge/IEventSender;", "volumeChange", "Lcom/unity3d/services/core/device/VolumeChange;", "(Lcom/unity3d/services/core/webview/bridge/IEventSender;Lcom/unity3d/services/core/device/VolumeChange;)V", "volumeChangeListeners", "Landroid/util/SparseArray;", "Lcom/unity3d/services/core/device/VolumeChangeListener;", "registerVolumeChangeListener", "", "streamType", "", "unregisterVolumeChangeListener", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VolumeChangeMonitor.kt */
public final class VolumeChangeMonitor {
    /* access modifiers changed from: private */
    public final IEventSender eventSender;
    private final VolumeChange volumeChange;
    private final SparseArray<VolumeChangeListener> volumeChangeListeners = new SparseArray<>();

    public VolumeChangeMonitor(IEventSender iEventSender, VolumeChange volumeChange2) {
        Intrinsics.checkNotNullParameter(iEventSender, "eventSender");
        Intrinsics.checkNotNullParameter(volumeChange2, "volumeChange");
        this.eventSender = iEventSender;
        this.volumeChange = volumeChange2;
    }

    public final void registerVolumeChangeListener(int i) {
        if (this.volumeChangeListeners.get(i) == null) {
            VolumeChangeMonitor$registerVolumeChangeListener$listener$1 volumeChangeMonitor$registerVolumeChangeListener$listener$1 = new VolumeChangeMonitor$registerVolumeChangeListener$listener$1(this, i);
            this.volumeChangeListeners.append(i, volumeChangeMonitor$registerVolumeChangeListener$listener$1);
            this.volumeChange.registerListener(volumeChangeMonitor$registerVolumeChangeListener$listener$1);
        }
    }

    public final void unregisterVolumeChangeListener(int i) {
        if (this.volumeChangeListeners.get(i) != null) {
            VolumeChangeListener volumeChangeListener = this.volumeChangeListeners.get(i);
            VolumeChange volumeChange2 = this.volumeChange;
            Intrinsics.checkNotNullExpressionValue(volumeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            volumeChange2.unregisterListener(volumeChangeListener);
            this.volumeChangeListeners.remove(i);
        }
    }
}
