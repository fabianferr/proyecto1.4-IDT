package com.google.android.gms.internal.cast;

import android.view.View;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzcb extends UIController {
    private final View zza;

    public zzcb(View view) {
        this.zza = view;
    }

    private final void zza() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || remoteMediaClient.isBuffering()) {
            this.zza.setVisibility(0);
        } else {
            this.zza.setVisibility(8);
        }
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onSendingRemoteMediaRequest() {
        this.zza.setVisibility(0);
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        zza();
    }

    public final void onSessionEnded() {
        this.zza.setVisibility(8);
        super.onSessionEnded();
    }
}
