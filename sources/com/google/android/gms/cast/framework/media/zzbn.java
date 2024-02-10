package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.zzan;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzbn implements zzan {
    final /* synthetic */ RemoteMediaClient zza;

    /* synthetic */ zzbn(RemoteMediaClient remoteMediaClient, zzbm zzbm) {
        this.zza = remoteMediaClient;
    }

    private final void zzn() {
        MediaStatus mediaStatus;
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient.zzm != null && (mediaStatus = remoteMediaClient.getMediaStatus()) != null) {
            mediaStatus.getWriter().setIsPlayingAd(this.zza.zzm.parseIsPlayingAdFromMediaStatus(mediaStatus));
            List<AdBreakInfo> parseAdBreaksFromMediaStatus = this.zza.zzm.parseAdBreaksFromMediaStatus(mediaStatus);
            MediaInfo mediaInfo = this.zza.getMediaInfo();
            if (mediaInfo != null) {
                mediaInfo.getWriter().setAdBreaks(parseAdBreaksFromMediaStatus);
            }
        }
    }

    public final void zza() {
        for (RemoteMediaClient.Listener onAdBreakStatusUpdated : this.zza.zzj) {
            onAdBreakStatusUpdated.onAdBreakStatusUpdated();
        }
        for (RemoteMediaClient.Callback onAdBreakStatusUpdated2 : this.zza.zza) {
            onAdBreakStatusUpdated2.onAdBreakStatusUpdated();
        }
    }

    public final void zzb(MediaError mediaError) {
        for (RemoteMediaClient.Callback onMediaError : this.zza.zza) {
            onMediaError.onMediaError(mediaError);
        }
    }

    public final void zzc() {
        zzn();
        for (RemoteMediaClient.Listener onMetadataUpdated : this.zza.zzj) {
            onMetadataUpdated.onMetadataUpdated();
        }
        for (RemoteMediaClient.Callback onMetadataUpdated2 : this.zza.zza) {
            onMetadataUpdated2.onMetadataUpdated();
        }
    }

    public final void zzd() {
        for (RemoteMediaClient.Listener onPreloadStatusUpdated : this.zza.zzj) {
            onPreloadStatusUpdated.onPreloadStatusUpdated();
        }
        for (RemoteMediaClient.Callback onPreloadStatusUpdated2 : this.zza.zza) {
            onPreloadStatusUpdated2.onPreloadStatusUpdated();
        }
    }

    public final void zze(int[] iArr) {
        for (RemoteMediaClient.Callback zza2 : this.zza.zza) {
            zza2.zza(iArr);
        }
    }

    public final void zzf(int[] iArr, int i) {
        for (RemoteMediaClient.Callback zzb : this.zza.zza) {
            zzb.zzb(iArr, i);
        }
    }

    public final void zzg(MediaQueueItem[] mediaQueueItemArr) {
        for (RemoteMediaClient.Callback zzc : this.zza.zza) {
            zzc.zzc(mediaQueueItemArr);
        }
    }

    public final void zzh(int[] iArr) {
        for (RemoteMediaClient.Callback zzd : this.zza.zza) {
            zzd.zzd(iArr);
        }
    }

    public final void zzi(List list, List list2, int i) {
        for (RemoteMediaClient.Callback zze : this.zza.zza) {
            zze.zze(list, list2, i);
        }
    }

    public final void zzj(int[] iArr) {
        for (RemoteMediaClient.Callback zzf : this.zza.zza) {
            zzf.zzf(iArr);
        }
    }

    public final void zzk() {
        for (RemoteMediaClient.Listener onQueueStatusUpdated : this.zza.zzj) {
            onQueueStatusUpdated.onQueueStatusUpdated();
        }
        for (RemoteMediaClient.Callback onQueueStatusUpdated2 : this.zza.zza) {
            onQueueStatusUpdated2.onQueueStatusUpdated();
        }
    }

    public final void zzl() {
        for (RemoteMediaClient.Callback zzg : this.zza.zza) {
            zzg.zzg();
        }
    }

    public final void zzm() {
        zzn();
        RemoteMediaClient.zzn(this.zza);
        for (RemoteMediaClient.Listener onStatusUpdated : this.zza.zzj) {
            onStatusUpdated.onStatusUpdated();
        }
        for (RemoteMediaClient.Callback onStatusUpdated2 : this.zza.zza) {
            onStatusUpdated2.onStatusUpdated();
        }
    }
}
