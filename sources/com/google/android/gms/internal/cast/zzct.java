package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzct extends UIController implements RemoteMediaClient.ProgressListener {
    private final TextView zza;
    private final zza zzb;

    public zzct(TextView textView, zza zza2) {
        this.zza = textView;
        this.zzb = zza2;
        textView.setText(textView.getContext().getString(R.string.cast_invalid_stream_duration_text));
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onProgressUpdated(long j, long j2) {
        zza();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.addProgressListener(this, 1000);
        }
        zza();
    }

    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.removeProgressListener(this);
        }
        super.onSessionEnded();
        zza();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            TextView textView = this.zza;
            textView.setText(textView.getContext().getString(R.string.cast_invalid_stream_duration_text));
        } else if (!remoteMediaClient.isLiveStream() || this.zzb.zzi() != null) {
            this.zza.setVisibility(0);
            TextView textView2 = this.zza;
            zza zza2 = this.zzb;
            textView2.setText(zza2.zzl(((long) zza2.zzb()) + zza2.zze()));
        } else {
            this.zza.setVisibility(8);
        }
    }
}
