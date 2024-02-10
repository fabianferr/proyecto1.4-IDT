package com.unity3d.services.core.device;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import com.unity3d.services.core.properties.ClientProperties;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/unity3d/services/core/device/VolumeChangeContentObserver;", "Lcom/unity3d/services/core/device/VolumeChange;", "()V", "contentObserver", "Landroid/database/ContentObserver;", "listeners", "", "Lcom/unity3d/services/core/device/VolumeChangeListener;", "clearAllListeners", "", "registerListener", "volumeChangeListener", "startObserving", "stopObserving", "triggerListeners", "unregisterListener", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VolumeChangeContentObserver.kt */
public final class VolumeChangeContentObserver implements VolumeChange {
    private ContentObserver contentObserver;
    private List<VolumeChangeListener> listeners = new ArrayList();

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void startObserving() {
        /*
            r4 = this;
            monitor-enter(r4)
            android.database.ContentObserver r0 = r4.contentObserver     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            android.os.Handler r0 = new android.os.Handler     // Catch:{ all -> 0x0034 }
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0034 }
            r0.<init>(r1)     // Catch:{ all -> 0x0034 }
            com.unity3d.services.core.device.VolumeChangeContentObserver$startObserving$1 r1 = new com.unity3d.services.core.device.VolumeChangeContentObserver$startObserving$1     // Catch:{ all -> 0x0034 }
            r1.<init>(r4, r0)     // Catch:{ all -> 0x0034 }
            android.database.ContentObserver r1 = (android.database.ContentObserver) r1     // Catch:{ all -> 0x0034 }
            r4.contentObserver = r1     // Catch:{ all -> 0x0034 }
            android.content.Context r0 = com.unity3d.services.core.properties.ClientProperties.getApplicationContext()     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0032
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0032
            android.net.Uri r1 = android.provider.Settings.System.CONTENT_URI     // Catch:{ all -> 0x0034 }
            android.database.ContentObserver r2 = r4.contentObserver     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "null cannot be cast to non-null type android.database.ContentObserver"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)     // Catch:{ all -> 0x0034 }
            r3 = 1
            r0.registerContentObserver(r1, r3, r2)     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r4)
            return
        L_0x0034:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.device.VolumeChangeContentObserver.startObserving():void");
    }

    public synchronized void stopObserving() {
        ContentResolver contentResolver;
        if (this.contentObserver != null) {
            Context applicationContext = ClientProperties.getApplicationContext();
            if (!(applicationContext == null || (contentResolver = applicationContext.getContentResolver()) == null)) {
                ContentObserver contentObserver2 = this.contentObserver;
                Intrinsics.checkNotNull(contentObserver2);
                contentResolver.unregisterContentObserver(contentObserver2);
            }
            this.contentObserver = null;
        }
    }

    public synchronized void registerListener(VolumeChangeListener volumeChangeListener) {
        Intrinsics.checkNotNullParameter(volumeChangeListener, "volumeChangeListener");
        if (!this.listeners.contains(volumeChangeListener)) {
            startObserving();
            this.listeners.add(volumeChangeListener);
        }
    }

    public synchronized void unregisterListener(VolumeChangeListener volumeChangeListener) {
        Intrinsics.checkNotNullParameter(volumeChangeListener, "volumeChangeListener");
        this.listeners.remove(volumeChangeListener);
        if (this.listeners.isEmpty()) {
            stopObserving();
        }
    }

    public synchronized void clearAllListeners() {
        this.listeners.clear();
        stopObserving();
    }

    /* access modifiers changed from: private */
    public final synchronized void triggerListeners() {
        for (VolumeChangeListener next : this.listeners) {
            next.onVolumeChanged(Device.getStreamVolume(next.getStreamType()));
        }
    }
}
