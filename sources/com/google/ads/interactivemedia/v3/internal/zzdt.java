package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import java.util.concurrent.Callable;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzdt implements Callable {
    public final /* synthetic */ zzec zza;
    public final /* synthetic */ AdsRequest zzb;
    public final /* synthetic */ zzvq zzc;
    public final /* synthetic */ AdDisplayContainer zzd;
    public final /* synthetic */ zzvq zze;
    public final /* synthetic */ zzvq zzf;
    public final /* synthetic */ zzvq zzg;
    public final /* synthetic */ String zzh;

    public /* synthetic */ zzdt(zzec zzec, AdsRequest adsRequest, zzvq zzvq, AdDisplayContainer adDisplayContainer, zzvq zzvq2, zzvq zzvq3, zzvq zzvq4, String str) {
        this.zza = zzec;
        this.zzb = adsRequest;
        this.zzc = zzvq;
        this.zzd = adDisplayContainer;
        this.zze = zzvq2;
        this.zzf = zzvq3;
        this.zzg = zzvq4;
        this.zzh = str;
    }

    public final Object call() {
        this.zza.zzi(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh);
        return null;
    }
}
