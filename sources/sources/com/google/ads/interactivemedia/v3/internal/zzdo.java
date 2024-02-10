package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.data.zzbr;
import com.google.ads.interactivemedia.v3.impl.data.zzbw;
import java.util.HashMap;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzdo implements VideoAdPlayer.VideoAdPlayerCallback {
    private final HashMap zza = zztd.zzb(2);
    private zzdn zzb;
    private boolean zzc = false;

    zzdo() {
    }

    private final void zzd(zzfe zzfe, AdMediaInfo adMediaInfo, Object obj) {
        zzdn zzdn = this.zzb;
        if (zzdn != null) {
            zzdn.zzb(zzfe, adMediaInfo, obj);
        }
    }

    public final void onAdProgress(AdMediaInfo adMediaInfo, VideoProgressUpdate videoProgressUpdate) {
        if (this.zzc && videoProgressUpdate != null && videoProgressUpdate.getDuration() > 0.0f) {
            if (this.zza.get(adMediaInfo) == null && videoProgressUpdate.getCurrentTime() > 0.0f) {
                zzd(zzfe.start, adMediaInfo, (Object) null);
                this.zza.put(adMediaInfo, true);
            }
            zzd(zzfe.timeupdate, adMediaInfo, zzbr.create(videoProgressUpdate));
        }
    }

    public final void onBuffering(AdMediaInfo adMediaInfo) {
        if (this.zzc) {
            zzd(zzfe.waiting, adMediaInfo, (Object) null);
        }
    }

    public final void onContentComplete() {
        zzdn zzdn = this.zzb;
        if (zzdn != null) {
            zzdn.zza(zzfd.adsLoader, zzfe.contentComplete);
        }
    }

    public final void onEnded(AdMediaInfo adMediaInfo) {
        if (this.zzc) {
            zzd(zzfe.end, adMediaInfo, (Object) null);
            this.zza.remove(adMediaInfo);
        }
    }

    public final void onError(AdMediaInfo adMediaInfo) {
        if (this.zzc) {
            zzd(zzfe.error, adMediaInfo, (Object) null);
            this.zza.remove(adMediaInfo);
        }
    }

    public final void onLoaded(AdMediaInfo adMediaInfo) {
        if (this.zzc) {
            zzd(zzfe.loaded, adMediaInfo, (Object) null);
        }
    }

    public final void onPause(AdMediaInfo adMediaInfo) {
        if (this.zzc) {
            zzd(zzfe.pause, adMediaInfo, (Object) null);
        }
    }

    public final void onPlay(AdMediaInfo adMediaInfo) {
    }

    public final void onResume(AdMediaInfo adMediaInfo) {
        if (this.zzc) {
            zzd(zzfe.play, adMediaInfo, (Object) null);
        }
    }

    public final void onVolumeChanged(AdMediaInfo adMediaInfo, int i) {
        if (this.zzc) {
            zzd(zzfe.volumeChange, adMediaInfo, zzbw.builder().volumePercentage(i).build());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdn zzdn) {
        this.zzb = zzdn;
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        this.zzc = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzc = false;
    }
}
