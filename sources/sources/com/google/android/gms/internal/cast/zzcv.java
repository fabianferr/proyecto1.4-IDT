package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzcv extends UIController implements RemoteMediaClient.ProgressListener {
    private final TextView zza;
    private final zza zzb;

    public zzcv(TextView textView, zza zza2) {
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
            return;
        }
        long approximateStreamPosition = remoteMediaClient.getApproximateStreamPosition();
        if (approximateStreamPosition == MediaInfo.zza) {
            approximateStreamPosition = remoteMediaClient.getStreamDuration();
        }
        this.zza.setText(this.zzb.zzl(approximateStreamPosition));
    }
}
