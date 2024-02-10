package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.StreamRequest;
import java.util.concurrent.Callable;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzdy implements Callable {
    public final /* synthetic */ zzec zza;
    public final /* synthetic */ StreamRequest zzb;
    public final /* synthetic */ zzvq zzc;
    public final /* synthetic */ zzvq zzd;
    public final /* synthetic */ zzvq zze;
    public final /* synthetic */ zzvq zzf;
    public final /* synthetic */ String zzg;

    public /* synthetic */ zzdy(zzec zzec, StreamRequest streamRequest, zzvq zzvq, zzvq zzvq2, zzvq zzvq3, zzvq zzvq4, String str) {
        this.zza = zzec;
        this.zzb = streamRequest;
        this.zzc = zzvq;
        this.zzd = zzvq2;
        this.zze = zzvq3;
        this.zzf = zzvq4;
        this.zzg = str;
    }

    public final Object call() {
        this.zza.zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        return null;
    }
}
