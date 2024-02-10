package com.google.android.gms.internal.cast;

import android.view.View;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzcr extends UIController {
    private final View zza;
    private final int zzb;

    public zzcr(View view, int i) {
        this.zza = view;
        this.zzb = i;
    }

    private final void zza() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            this.zza.setVisibility(this.zzb);
        } else if (((MediaStatus) Preconditions.checkNotNull(remoteMediaClient.getMediaStatus())).getPreloadedItemId() == 0) {
            this.zza.setVisibility(this.zzb);
        } else {
            this.zza.setVisibility(0);
        }
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        zza();
    }

    public final void onSessionEnded() {
        this.zza.setVisibility(this.zzb);
        super.onSessionEnded();
    }
}
