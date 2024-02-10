package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdsManager;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamManager;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import java.util.List;
import java.util.SortedSet;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzea implements zzfi {
    final /* synthetic */ zzec zza;

    zzea(zzec zzec) {
        this.zza = zzec;
    }

    public final void zza(String str, AdError.AdErrorType adErrorType, int i, String str2) {
        Object obj;
        if (this.zza.zzh.get(str) != null) {
            obj = ((AdsRequest) this.zza.zzh.get(str)).getUserRequestContext();
        } else {
            obj = this.zza.zzi.get(str) != null ? ((StreamRequest) this.zza.zzi.get(str)).getUserRequestContext() : new Object();
        }
        this.zza.zzf.zzc(new zzdl(new AdError(adErrorType, i, str2), obj));
    }

    public final void zzb(String str, AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode, String str2) {
        Object obj;
        if (this.zza.zzh.get(str) != null) {
            obj = ((AdsRequest) this.zza.zzh.get(str)).getUserRequestContext();
        } else {
            obj = this.zza.zzi.get(str) != null ? ((StreamRequest) this.zza.zzi.get(str)).getUserRequestContext() : new Object();
        }
        this.zza.zzf.zzc(new zzdl(new AdError(adErrorType, adErrorCode, "adsLoaded message did not contain cue points."), obj));
    }

    public final void zzc(String str, List list, SortedSet sortedSet, boolean z) {
        zzec zzec = this.zza;
        AdDisplayContainer adDisplayContainer = (AdDisplayContainer) zzec.zzl;
        AdsRequest adsRequest = (AdsRequest) zzec.zzh.get(str);
        if (adsRequest == null) {
            this.zza.zzf.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Request not found for session id: ".concat(String.valueOf(str))), new Object()));
            return;
        }
        ContentProgressProvider contentProgressProvider = adsRequest.getContentProgressProvider();
        AdError adError = null;
        zzev zzev = contentProgressProvider != null ? new zzev(contentProgressProvider, 200) : null;
        this.zza.zzj.zze(adsRequest.getContentUrl());
        if (sortedSet != null && !sortedSet.isEmpty() && zzev == null) {
            adError = new AdError(AdError.AdErrorType.PLAY, AdError.AdErrorCode.PLAYLIST_NO_CONTENT_TRACKING, "Unable to handle cue points, no content progress provider configured.");
        }
        if (adError != null) {
            this.zza.zzf.zzc(new zzdl(adError, adsRequest.getUserRequestContext()));
            return;
        }
        zzec zzec2 = this.zza;
        zzed zzed = r3;
        zzed zzed2 = new zzed(str, zzec2.zzd, adDisplayContainer, zzev, list, sortedSet, zzec2.zzj, new zzex(zzec2.zzq), this.zza.zzb, z);
        zzec.zzm(zzec2, new zzee((AdsManager) zzed, adsRequest.getUserRequestContext()));
    }

    public final void zzd(String str, String str2, boolean z) {
        String str3 = str;
        zzec zzec = this.zza;
        StreamDisplayContainer streamDisplayContainer = (StreamDisplayContainer) zzec.zzl;
        StreamRequest streamRequest = (StreamRequest) zzec.zzi.get(str3);
        if (streamRequest == null) {
            this.zza.zzf.zzc(new zzdl(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Request not found for session id: ".concat(String.valueOf(str))), new Object()));
            return;
        }
        this.zza.zzj.zze(streamRequest.getContentUrl());
        this.zza.zzj.zzf(true);
        zzec zzec2 = this.zza;
        zzfm zzd = zzec2.zzd;
        String manifestSuffix = streamRequest.getManifestSuffix();
        zzec zzec3 = this.zza;
        zzge zze = zzec3.zzj;
        zzex zzex = new zzex(zzec3.zzq);
        Context zza2 = this.zza.zzb;
        String str4 = str;
        zzfm zzfm = zzd;
        StreamDisplayContainer streamDisplayContainer2 = streamDisplayContainer;
        zzgm zzgm = new zzgm(str4, zzfm, zzex, streamDisplayContainer, manifestSuffix, zza2);
        zzec.zzm(zzec2, new zzee((StreamManager) new zzgj(str4, zzfm, streamDisplayContainer2, zzgm, new zzdj(str3, zzd, streamDisplayContainer.getAdContainer()), zze, zzex, zza2, str2, z), streamRequest.getUserRequestContext()));
    }
}
