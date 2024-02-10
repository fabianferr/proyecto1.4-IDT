package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.impl.data.NetworkRequestData;
import java.util.concurrent.Callable;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzfv implements Callable {
    public final /* synthetic */ zzgc zza;
    public final /* synthetic */ NetworkRequestData zzb;

    public /* synthetic */ zzfv(zzgc zzgc, NetworkRequestData networkRequestData) {
        this.zza = zzgc;
        this.zzb = networkRequestData;
    }

    public final Object call() {
        return this.zza.zzb(this.zzb);
    }
}
