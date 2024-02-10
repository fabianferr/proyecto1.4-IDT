package com.google.android.gms.internal.cast;

import android.content.Context;
import android.view.View;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzbt extends UIController {
    private final View zza;
    private final String zzb;
    private final String zzc;

    public zzbt(View view, Context context) {
        this.zza = view;
        this.zzb = context.getString(R.string.cast_closed_captions);
        this.zzc = context.getString(R.string.cast_closed_captions_unavailable);
        view.setEnabled(false);
    }

    private final void zza() {
        MediaInfo mediaInfo;
        List<MediaTrack> mediaTracks;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && (mediaInfo = remoteMediaClient.getMediaInfo()) != null && (mediaTracks = mediaInfo.getMediaTracks()) != null && !mediaTracks.isEmpty()) {
            Iterator<MediaTrack> it = mediaTracks.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MediaTrack next = it.next();
                if (next.getType() == 2) {
                    i++;
                    if (i > 1) {
                        break;
                    }
                } else if (next.getType() == 1) {
                    break;
                }
            }
            if (!remoteMediaClient.isPlayingAd()) {
                this.zza.setEnabled(true);
                this.zza.setContentDescription(this.zzb);
                return;
            }
        }
        this.zza.setEnabled(false);
        this.zza.setContentDescription(this.zzc);
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        this.zza.setEnabled(true);
        zza();
    }

    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        super.onSessionEnded();
    }
}
