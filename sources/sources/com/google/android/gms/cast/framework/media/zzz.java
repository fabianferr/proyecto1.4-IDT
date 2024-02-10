package com.google.android.gms.cast.framework.media;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzz extends zzf {
    final /* synthetic */ NotificationActionsProvider zza;

    /* synthetic */ zzz(NotificationActionsProvider notificationActionsProvider, zzy zzy) {
        this.zza = notificationActionsProvider;
    }

    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final List zzf() {
        return this.zza.getNotificationActions();
    }

    public final int[] zzg() {
        return this.zza.getCompactViewActionIndices();
    }
}
