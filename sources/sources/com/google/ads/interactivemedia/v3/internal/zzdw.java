package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.StreamRequest;
import java.util.concurrent.Callable;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzdw implements Callable {
    public final /* synthetic */ zzgx zza;
    public final /* synthetic */ StreamRequest zzb;

    public /* synthetic */ zzdw(zzgx zzgx, StreamRequest streamRequest) {
        this.zza = zzgx;
        this.zzb = streamRequest;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
