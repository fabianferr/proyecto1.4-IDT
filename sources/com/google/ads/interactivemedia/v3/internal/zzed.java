package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdsManager;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.data.zzbr;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzed extends zzep implements AdsManager, AdErrorEvent.AdErrorListener {
    private final List zza;
    private final zzgo zzb;
    private zzeu zzc;
    private zzev zzd;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzed(java.lang.String r16, com.google.ads.interactivemedia.v3.internal.zzfm r17, com.google.ads.interactivemedia.v3.api.AdDisplayContainer r18, com.google.ads.interactivemedia.v3.internal.zzev r19, java.util.List r20, java.util.SortedSet r21, com.google.ads.interactivemedia.v3.internal.zzge r22, com.google.ads.interactivemedia.v3.internal.zzex r23, android.content.Context r24, boolean r25) {
        /*
            r15 = this;
            r10 = r15
            r11 = r16
            r12 = r17
            r13 = r19
            com.google.ads.interactivemedia.v3.internal.zzfu r6 = new com.google.ads.interactivemedia.v3.internal.zzfu
            r0 = r6
            r1 = r16
            r2 = r17
            r3 = r23
            r4 = r18
            r5 = r24
            r0.<init>(r1, r2, r3, r4, r5)
            com.google.ads.interactivemedia.v3.internal.zzdj r5 = new com.google.ads.interactivemedia.v3.internal.zzdj
            android.view.ViewGroup r0 = r18.getAdContainer()
            r5.<init>(r11, r12, r0)
            com.google.ads.interactivemedia.v3.internal.zzgo r14 = new com.google.ads.interactivemedia.v3.internal.zzgo
            android.webkit.WebView r0 = r17.zza()
            android.view.ViewGroup r1 = r18.getAdContainer()
            r14.<init>(r0, r1)
            r0 = r15
            r1 = r16
            r3 = r6
            r6 = r22
            r7 = r23
            r8 = r24
            r9 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r20
            r10.zza = r0
            r10.zzd = r13
            r10.zzb = r14
            if (r13 == 0) goto L_0x0055
            com.google.ads.interactivemedia.v3.internal.zzeu r0 = new com.google.ads.interactivemedia.v3.internal.zzeu
            r1 = r21
            r0.<init>(r12, r1, r11)
            r10.zzc = r0
            r13.zzc(r0)
            r19.zze()
        L_0x0055:
            r15.addAdErrorListener(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzed.<init>(java.lang.String, com.google.ads.interactivemedia.v3.internal.zzfm, com.google.ads.interactivemedia.v3.api.AdDisplayContainer, com.google.ads.interactivemedia.v3.internal.zzev, java.util.List, java.util.SortedSet, com.google.ads.interactivemedia.v3.internal.zzge, com.google.ads.interactivemedia.v3.internal.zzex, android.content.Context, boolean):void");
    }

    public final void clicked() {
        zzn(zzfe.click);
    }

    public final void destroy() {
        super.destroy();
        zzev zzev = this.zzd;
        if (zzev != null) {
            zzev.zzf();
            this.zzd = null;
        }
        this.zzb.zza();
        zzn(zzfe.destroy);
    }

    public final void discardAdBreak() {
        zzn(zzfe.discardAdBreak);
    }

    public final List<Float> getAdCuePoints() {
        return this.zza;
    }

    public final boolean isCustomPlaybackUsed() {
        zzfu zzfu = (zzfu) zzc();
        return true;
    }

    public final void onAdError(AdErrorEvent adErrorEvent) {
        this.zzb.zza();
    }

    public final void pause() {
        zzn(zzfe.pause);
    }

    public final void requestNextAdBreak() {
        if (this.zzd != null) {
            zzm(zzfd.contentTimeUpdate, zzfe.contentTimeUpdate, zzbr.create(this.zzd.zza()));
            zzn(zzfe.requestNextAdBreak);
        }
    }

    public final void resume() {
        zzn(zzfe.resume);
    }

    public final void skip() {
        zzn(zzfe.skip);
    }

    public final void start() {
        zzn(zzfe.start);
    }

    /* access modifiers changed from: package-private */
    public final Map zza(AdsRenderingSettings adsRenderingSettings) {
        Map zza2 = super.zza(adsRenderingSettings);
        zzev zzev = this.zzd;
        if (zzev != null) {
            VideoProgressUpdate zza3 = zzev.zza();
            if (!zza3.equals(VideoProgressUpdate.VIDEO_TIME_NOT_READY)) {
                StringBuilder sb = new StringBuilder("AdsManager.init -> Setting contentStartTime ");
                double currentTimeMs = (double) (((float) zza3.getCurrentTimeMs()) / 1000.0f);
                sb.append(currentTimeMs);
                zzhd.zzc(sb.toString());
                zza2.put("contentStartTime", Double.valueOf(currentTimeMs));
            }
        }
        return zza2;
    }

    public final void zzb(zzfj zzfj) {
        zzfu zzfu = (zzfu) zzc();
        AdEvent.AdEventType adEventType = zzfj.zza;
        AdEvent.AdEventType adEventType2 = AdEvent.AdEventType.ALL_ADS_COMPLETED;
        int ordinal = adEventType.ordinal();
        if (ordinal != 0) {
            if (ordinal == 5) {
                zzev zzev = this.zzd;
                if (zzev != null) {
                    zzev.zzf();
                }
            } else if (ordinal == 6) {
                this.zzb.zza();
                zzfu.zze();
                zzev zzev2 = this.zzd;
                if (zzev2 != null) {
                    zzev2.zze();
                }
            } else if (ordinal == 14) {
                this.zzb.zza();
            } else if (ordinal == 15) {
                this.zzb.zzb();
            }
            super.zzb(zzfj);
            return;
        }
        super.destroy();
        zzev zzev3 = this.zzd;
        if (zzev3 != null) {
            zzev3.zzf();
            this.zzd = null;
        }
        this.zzb.zza();
        zzn(zzfe.destroy);
        super.zzb(zzfj);
        zzl();
    }
}
