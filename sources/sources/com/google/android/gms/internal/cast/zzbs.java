package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.framework.media.widget.zzb;
import com.google.android.gms.cast.framework.media.widget.zzc;
import com.google.android.gms.cast.framework.media.widget.zze;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzbs extends UIController implements RemoteMediaClient.ProgressListener {
    private final CastSeekBar zza;
    private final long zzb;
    private final zza zzc;

    public zzbs(CastSeekBar castSeekBar, long j, zza zza2) {
        this.zza = castSeekBar;
        this.zzb = j;
        this.zzc = zza2;
        castSeekBar.setEnabled(false);
        castSeekBar.zzd((List) null);
        castSeekBar.zzb = null;
        castSeekBar.postInvalidate();
    }

    public final RemoteMediaClient getRemoteMediaClient() {
        return super.getRemoteMediaClient();
    }

    public final void onMediaStatusUpdated() {
        zzc();
    }

    public final void onProgressUpdated(long j, long j2) {
        zzb();
        zza();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.addProgressListener(this, this.zzb);
        }
        zzc();
    }

    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.removeProgressListener(this);
        }
        super.onSessionEnded();
        zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        AdBreakClipInfo adBreakClipInfo = null;
        if (remoteMediaClient == null || !remoteMediaClient.isPlayingAd()) {
            CastSeekBar castSeekBar = this.zza;
            castSeekBar.zzb = null;
            castSeekBar.postInvalidate();
            return;
        }
        int approximateAdBreakClipPositionMs = (int) remoteMediaClient.getApproximateAdBreakClipPositionMs();
        MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
        if (mediaStatus != null) {
            adBreakClipInfo = mediaStatus.getCurrentAdBreakClip();
        }
        int durationInMs = adBreakClipInfo != null ? (int) adBreakClipInfo.getDurationInMs() : approximateAdBreakClipPositionMs;
        if (approximateAdBreakClipPositionMs < 0) {
            approximateAdBreakClipPositionMs = 0;
        }
        if (durationInMs < 0) {
            durationInMs = 1;
        }
        CastSeekBar castSeekBar2 = this.zza;
        if (approximateAdBreakClipPositionMs > durationInMs) {
            durationInMs = approximateAdBreakClipPositionMs;
        }
        castSeekBar2.zzb = new zzc(approximateAdBreakClipPositionMs, durationInMs);
        castSeekBar2.postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        int i;
        int i2;
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        boolean z = true;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || remoteMediaClient.isPlayingAd()) {
            this.zza.setEnabled(false);
        } else {
            this.zza.setEnabled(true);
        }
        zze zze = new zze();
        zze.zza = this.zzc.zza();
        zze.zzb = this.zzc.zzb();
        zze.zzc = (int) (-this.zzc.zze());
        RemoteMediaClient remoteMediaClient2 = super.getRemoteMediaClient();
        if (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !remoteMediaClient2.zzv()) {
            i = this.zzc.zza();
        } else {
            i = this.zzc.zzd();
        }
        zze.zzd = i;
        RemoteMediaClient remoteMediaClient3 = super.getRemoteMediaClient();
        if (remoteMediaClient3 == null || !remoteMediaClient3.hasMediaSession() || !remoteMediaClient3.zzv()) {
            i2 = this.zzc.zza();
        } else {
            i2 = this.zzc.zzc();
        }
        zze.zze = i2;
        RemoteMediaClient remoteMediaClient4 = super.getRemoteMediaClient();
        if (remoteMediaClient4 == null || !remoteMediaClient4.hasMediaSession() || !remoteMediaClient4.zzv()) {
            z = false;
        }
        zze.zzf = z;
        this.zza.zze(zze);
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        MediaInfo mediaInfo;
        int i;
        zzb();
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        ArrayList arrayList = null;
        if (remoteMediaClient == null) {
            mediaInfo = null;
        } else {
            mediaInfo = remoteMediaClient.getMediaInfo();
        }
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || remoteMediaClient.isLoadingNextItem() || mediaInfo == null) {
            this.zza.zzd((List) null);
        } else {
            CastSeekBar castSeekBar = this.zza;
            List<AdBreakInfo> adBreaks = mediaInfo.getAdBreaks();
            if (adBreaks != null) {
                arrayList = new ArrayList();
                for (AdBreakInfo next : adBreaks) {
                    if (next != null) {
                        long playbackPositionInMs = next.getPlaybackPositionInMs();
                        if (playbackPositionInMs == -1000) {
                            i = this.zzc.zzb();
                        } else {
                            i = Math.min((int) (playbackPositionInMs - this.zzc.zze()), this.zzc.zzb());
                        }
                        if (i >= 0) {
                            arrayList.add(new zzb(i, (int) next.getDurationInMs(), next.isExpanded()));
                        }
                    }
                }
            }
            castSeekBar.zzd(arrayList);
        }
        zza();
    }
}
