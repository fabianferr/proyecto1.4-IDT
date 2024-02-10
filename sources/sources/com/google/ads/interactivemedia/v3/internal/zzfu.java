package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.data.AdPodInfoImpl;
import com.google.ads.interactivemedia.v3.impl.data.JavaScriptMsgData;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzfu implements zzgn, zzdn {
    private final AdDisplayContainer zza;
    private final VideoAdPlayer zzb;
    private final zzex zzc;
    private final zzfm zzd;
    private final String zze;
    private final zzdo zzf;
    private final zzsh zzg = zzsh.zzf(2);

    public zzfu(String str, zzfm zzfm, zzex zzex, AdDisplayContainer adDisplayContainer, Context context) {
        this.zza = adDisplayContainer;
        VideoAdPlayer player = adDisplayContainer.getPlayer();
        this.zzb = player;
        this.zzc = zzex;
        this.zzd = zzfm;
        this.zze = str;
        zzdo zzdo = new zzdo();
        this.zzf = zzdo;
        zzdo.zza(this);
        player.addCallback(zzdo);
    }

    public final VideoProgressUpdate getAdProgress() {
        return this.zzb.getAdProgress();
    }

    public final void zza(zzfd zzfd, zzfe zzfe) {
        this.zzd.zzp(new zzff(zzfd, zzfe, "*", (Object) null));
    }

    public final void zzb(zzfe zzfe, AdMediaInfo adMediaInfo, Object obj) {
        zzfd zzfd = (zzfd) this.zzg.zze().get(adMediaInfo);
        if (zzfd == null) {
            String valueOf = String.valueOf(zzfe);
            zzhd.zzd("The adMediaInfo for the " + valueOf + " event is not active. This may occur if callbacks are triggered after the ad is unloaded.");
            return;
        }
        this.zzd.zzp(new zzff(zzfd, zzfe, this.zze, obj));
    }

    public final void zzc() {
        zzhd.zzc("Destroying NativeVideoDisplay");
        this.zzb.removeCallback(this.zzf);
        this.zzb.release();
    }

    public final void zzd() {
    }

    public final void zze() {
        this.zzf.zzc();
    }

    public final void zzf(zzfd zzfd, zzfe zzfe, JavaScriptMsgData javaScriptMsgData) {
        AdMediaInfo adMediaInfo = (AdMediaInfo) this.zzg.get(zzfd);
        zzfe zzfe2 = zzfe.activate;
        int ordinal = zzfe.ordinal();
        if (ordinal != 34) {
            if (ordinal != 43) {
                if (ordinal != 72) {
                    if (ordinal == 52) {
                        this.zzb.pauseAd(adMediaInfo);
                        return;
                    } else if (ordinal == 53) {
                        this.zzb.playAd(adMediaInfo);
                        this.zzf.zzb();
                        return;
                    } else {
                        return;
                    }
                }
            } else if (javaScriptMsgData == null || javaScriptMsgData.videoUrl == null) {
                this.zzc.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Load message must contain video url.")));
                return;
            } else {
                this.zzf.zzb();
                AdMediaInfo adMediaInfo2 = new AdMediaInfo(javaScriptMsgData.videoUrl);
                AdPodInfoImpl adPodInfoImpl = javaScriptMsgData.adPodInfo;
                if (adPodInfoImpl == null) {
                    adPodInfoImpl = null;
                }
                this.zzg.put(zzfd, adMediaInfo2);
                this.zzb.loadAd(adMediaInfo2, adPodInfoImpl);
                return;
            }
        }
        this.zzb.stopAd(adMediaInfo);
        this.zzg.remove(zzfd);
    }

    public final void zzg(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        if (!(this.zzb instanceof ResizablePlayer)) {
            zzhd.zza("Video player does not support resizing.");
        } else if (!zzhh.zza(this.zza, resizeAndPositionVideoMsgData)) {
            zzhd.zza("Creative resize parameters were not within the containers bounds.");
        } else {
            int width = this.zza.getAdContainer().getWidth();
            int height = this.zza.getAdContainer().getHeight();
            ((ResizablePlayer) this.zzb).resize(resizeAndPositionVideoMsgData.x().intValue(), resizeAndPositionVideoMsgData.y().intValue(), (width - resizeAndPositionVideoMsgData.x().intValue()) - resizeAndPositionVideoMsgData.width().intValue(), (height - resizeAndPositionVideoMsgData.y().intValue()) - resizeAndPositionVideoMsgData.height().intValue());
        }
    }

    public final void zzh() {
        VideoAdPlayer videoAdPlayer = this.zzb;
        if (videoAdPlayer instanceof ResizablePlayer) {
            ((ResizablePlayer) videoAdPlayer).resize(0, 0, 0, 0);
        }
    }
}
