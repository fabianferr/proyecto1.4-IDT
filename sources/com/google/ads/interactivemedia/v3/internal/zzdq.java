package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdsRequest;
import java.util.concurrent.Callable;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzdq implements Callable {
    public final /* synthetic */ zzgx zza;
    public final /* synthetic */ AdsRequest zzb;

    public /* synthetic */ zzdq(zzgx zzgx, AdsRequest adsRequest) {
        this.zza = zzgx;
        this.zzb = adsRequest;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
