package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.impl.data.zzbd;
import java.util.concurrent.Callable;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzgy implements Callable {
    public final /* synthetic */ zzha zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbd zzc;

    public /* synthetic */ zzgy(zzha zzha, String str, zzbd zzbd) {
        this.zza = zzha;
        this.zzb = str;
        this.zzc = zzbd;
    }

    public final Object call() {
        return this.zza.zza(this.zzb, this.zzc);
    }
}
