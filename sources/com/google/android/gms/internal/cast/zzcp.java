package com.google.android.gms.internal.cast;

import android.text.format.DateUtils;
import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzcp extends zzcq implements RemoteMediaClient.ProgressListener {
    private final TextView zza;
    private final long zzb;
    private final String zzc;
    private boolean zzd = true;

    public zzcp(TextView textView, long j, String str) {
        this.zza = textView;
        this.zzb = j;
        this.zzc = str;
    }

    public final void onProgressUpdated(long j, long j2) {
        if (this.zzd) {
            TextView textView = this.zza;
            if (j == -1000) {
                j = j2;
            }
            textView.setText(DateUtils.formatElapsedTime(j / 1000));
        }
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.addProgressListener(this, this.zzb);
            if (remoteMediaClient.hasMediaSession()) {
                this.zza.setText(DateUtils.formatElapsedTime(remoteMediaClient.getApproximateStreamPosition() / 1000));
            } else {
                this.zza.setText(this.zzc);
            }
        }
    }

    public final void onSessionEnded() {
        this.zza.setText(this.zzc);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.removeProgressListener(this);
        }
        super.onSessionEnded();
    }

    public final void zza(boolean z) {
        this.zzd = z;
    }

    public final void zzb(long j) {
        this.zza.setText(DateUtils.formatElapsedTime(j / 1000));
    }
}
