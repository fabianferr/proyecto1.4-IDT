package com.unity3d.services.core.device;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/unity3d/services/core/device/VolumeChangeContentObserver$startObserving$1", "Landroid/database/ContentObserver;", "deliverSelfNotifications", "", "onChange", "", "selfChange", "uri", "Landroid/net/Uri;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VolumeChangeContentObserver.kt */
public final class VolumeChangeContentObserver$startObserving$1 extends ContentObserver {
    final /* synthetic */ VolumeChangeContentObserver this$0;

    public boolean deliverSelfNotifications() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VolumeChangeContentObserver$startObserving$1(VolumeChangeContentObserver volumeChangeContentObserver, Handler handler) {
        super(handler);
        this.this$0 = volumeChangeContentObserver;
    }

    public void onChange(boolean z, Uri uri) {
        this.this$0.triggerListeners();
    }
}
