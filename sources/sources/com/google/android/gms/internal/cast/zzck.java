package com.google.android.gms.internal.cast;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.SeekBar;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzck extends UIController implements RemoteMediaClient.ProgressListener {
    private final SeekBar zza;
    private final long zzb;
    private final zza zzc;
    private boolean zzd = true;
    private Boolean zze;
    private Drawable zzf = null;

    public zzck(SeekBar seekBar, long j, zza zza2) {
        this.zza = seekBar;
        this.zzb = j;
        this.zzc = zza2;
        seekBar.setEnabled(false);
        this.zzf = seekBar.getThumb();
    }

    public final void onMediaStatusUpdated() {
        zzb();
    }

    public final void onProgressUpdated(long j, long j2) {
        zzb();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.addProgressListener(this, this.zzb);
        }
        zzb();
    }

    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.removeProgressListener(this);
        }
        super.onSessionEnded();
        zzb();
    }

    public final void zza(boolean z) {
        this.zzd = z;
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            this.zza.setMax(this.zzc.zzb());
            this.zza.setProgress(this.zzc.zza());
            this.zza.setEnabled(false);
        } else if (this.zzd) {
            this.zza.setMax(this.zzc.zzb());
            if (!remoteMediaClient.isLiveStream() || !this.zzc.zzm()) {
                this.zza.setProgress(this.zzc.zza());
            } else {
                this.zza.setProgress(this.zzc.zzc());
            }
            if (remoteMediaClient.isPlayingAd()) {
                this.zza.setEnabled(false);
            } else {
                this.zza.setEnabled(true);
            }
            RemoteMediaClient remoteMediaClient2 = getRemoteMediaClient();
            if (remoteMediaClient2 != null && remoteMediaClient2.hasMediaSession()) {
                Boolean bool = this.zze;
                if (bool == null || bool.booleanValue() != remoteMediaClient2.zzv()) {
                    Boolean valueOf = Boolean.valueOf(remoteMediaClient2.zzv());
                    this.zze = valueOf;
                    if (valueOf.booleanValue()) {
                        Drawable drawable = this.zzf;
                        if (drawable != null) {
                            this.zza.setThumb(drawable);
                        }
                        this.zza.setClickable(true);
                        this.zza.setOnTouchListener((View.OnTouchListener) null);
                        return;
                    }
                    this.zza.setThumb(new ColorDrawable(0));
                    this.zza.setClickable(false);
                    this.zza.setOnTouchListener(new zzcj(this));
                }
            }
        }
    }
}
