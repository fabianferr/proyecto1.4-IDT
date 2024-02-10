package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;
import com.google.ads.interactivemedia.v3.impl.data.AdImpl;
import com.google.ads.interactivemedia.v3.impl.data.JavaScriptMsgData;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;
import com.google.ads.interactivemedia.v3.impl.data.zzbr;
import com.google.ads.interactivemedia.v3.impl.data.zzbw;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzgm implements VideoStreamPlayer.VideoStreamPlayerCallback, zzgn, zzgg {
    private final VideoStreamPlayer zza;
    private final zzfm zzb;
    private final zzex zzc;
    private boolean zzd = false;
    private final zzev zze;
    private final zzgo zzf;
    private final String zzg;
    private final String zzh;
    private final StreamDisplayContainer zzi;

    zzgm(String str, zzfm zzfm, zzex zzex, StreamDisplayContainer streamDisplayContainer, String str2, Context context) {
        zzev zzev = new zzev(streamDisplayContainer.getVideoStreamPlayer(), 200);
        zzgo zzgo = new zzgo(zzfm.zza(), streamDisplayContainer.getAdContainer());
        this.zza = streamDisplayContainer.getVideoStreamPlayer();
        this.zzc = zzex;
        this.zzg = str;
        this.zzb = zzfm;
        this.zzh = str2;
        this.zzd = false;
        this.zzi = streamDisplayContainer;
        this.zze = zzev;
        this.zzf = zzgo;
    }

    private final void zzo(zzfe zzfe, Object obj) {
        this.zzb.zzp(new zzff(zzfd.videoDisplay1, zzfe, this.zzg, obj));
    }

    public final VideoProgressUpdate getAdProgress() {
        return this.zza.getContentProgress();
    }

    public final void onContentComplete() {
        this.zzb.zzp(new zzff(zzfd.adsLoader, zzfe.contentComplete, "*", (Object) null));
    }

    public final void onPause() {
        zzo(zzfe.pause, (Object) null);
    }

    public final void onResume() {
        zzo(zzfe.play, (Object) null);
    }

    public final void onUserTextReceived(String str) {
        zzo(zzfe.timedMetadata, zzgl.create(str));
    }

    public final void onVolumeChanged(int i) {
        zzo(zzfe.volumeChange, zzbw.builder().volumePercentage(i).build());
    }

    public final void zza(VideoProgressUpdate videoProgressUpdate) {
        if (!this.zzd) {
            zzo(zzfe.start, zzbw.builder().volumePercentage(this.zza.getVolume()).build());
            this.zzd = true;
        }
        zzo(zzfe.timeupdate, zzbr.create(videoProgressUpdate));
    }

    public final void zzb() {
        this.zza.onAdBreakEnded();
        this.zzf.zza();
    }

    public final void zzc() {
        zzhd.zzc("Destroying StreamVideoDisplay");
        this.zza.removeCallback(this);
        this.zze.zzf();
        this.zze.zzd(this);
        this.zzf.zza();
    }

    public final void zzd() {
        this.zze.zzc(this);
        this.zze.zze();
    }

    public final void zze() {
        this.zza.onAdBreakStarted();
    }

    public final void zzf(zzfd zzfd, zzfe zzfe, JavaScriptMsgData javaScriptMsgData) {
        String str;
        zzfe zzfe2 = zzfe.activate;
        int ordinal = zzfe.ordinal();
        if (ordinal != 45) {
            if (ordinal == 52) {
                this.zza.pause();
            } else if (ordinal == 53) {
                this.zza.resume();
            }
        } else if (javaScriptMsgData == null || (str = javaScriptMsgData.streamUrl) == null) {
            this.zzc.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Load message must contain video url.")));
        } else {
            int i = 0;
            this.zzd = false;
            String str2 = this.zzh;
            if (!(str2 == null || str2.length() == 0)) {
                String str3 = "";
                String replaceAll = str2.trim().replaceAll("\\s+", str3);
                if (replaceAll.charAt(0) == '?') {
                    replaceAll = replaceAll.substring(1);
                }
                if (replaceAll.length() != 0) {
                    Map zza2 = zzhx.zza(Uri.parse(str));
                    HashMap hashMap = new HashMap();
                    Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                    buildUpon.clearQuery();
                    Map zza3 = zzhx.zza(Uri.parse("http://www.dom.com/path?".concat(String.valueOf(replaceAll))));
                    hashMap.putAll(zza3);
                    if (!zza2.isEmpty()) {
                        for (String str4 : zza2.keySet()) {
                            if (!zza3.containsKey(str4)) {
                                hashMap.put(str4, (String) zza2.get(str4));
                            }
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        for (Map.Entry entry : hashMap.entrySet()) {
                            sb.append((String) entry.getKey());
                            sb.append("=");
                            sb.append((String) entry.getValue());
                            if (i < hashMap.size() - 1) {
                                sb.append("&");
                            }
                            i++;
                        }
                        str3 = sb.toString();
                    }
                    buildUpon.encodedQuery(str3);
                    str = buildUpon.build().toString();
                }
            }
            this.zza.loadUrl(str, javaScriptMsgData.subtitles);
        }
    }

    public final void zzg(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        if (!(this.zza instanceof ResizablePlayer)) {
            zzhd.zza("Stream player does not support resizing.");
        } else if (!zzhh.zza(this.zzi, resizeAndPositionVideoMsgData)) {
            zzhd.zza("Video resize parameters were not within the container bounds.");
        } else {
            int width = this.zzi.getAdContainer().getWidth();
            int height = this.zzi.getAdContainer().getHeight();
            ((ResizablePlayer) this.zza).resize(resizeAndPositionVideoMsgData.x().intValue(), resizeAndPositionVideoMsgData.y().intValue(), (width - resizeAndPositionVideoMsgData.x().intValue()) - resizeAndPositionVideoMsgData.width().intValue(), (height - resizeAndPositionVideoMsgData.y().intValue()) - resizeAndPositionVideoMsgData.height().intValue());
        }
    }

    public final void zzh() {
        VideoStreamPlayer videoStreamPlayer = this.zza;
        if (videoStreamPlayer instanceof ResizablePlayer) {
            ((ResizablePlayer) videoStreamPlayer).resize(0, 0, 0, 0);
        }
    }

    public final void zzi() {
        this.zza.onAdPeriodEnded();
    }

    public final void zzj() {
        this.zza.onAdPeriodStarted();
    }

    public final void zzk() {
        this.zza.addCallback(this);
    }

    public final void zzl(long j) {
        this.zza.seek(j);
    }

    /* access modifiers changed from: package-private */
    public final void zzm(AdImpl adImpl) {
        if (adImpl.isLinear()) {
            this.zzf.zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzn() {
        this.zzf.zza();
    }
}
