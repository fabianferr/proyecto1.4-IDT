package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.v3.impl.data.NetworkRequestData;
import com.google.ads.interactivemedia.v3.impl.data.zzbj;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzgc {
    private final zzga zza;
    /* access modifiers changed from: private */
    public final zzfr zzb;
    private final zzvr zzc;

    zzgc(Context context, zzfr zzfr, ExecutorService executorService, zzga zzga) {
        this.zzc = zzvw.zza(executorService);
        this.zza = zzga;
        this.zzb = zzfr;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbj zzb(NetworkRequestData networkRequestData) throws Exception {
        return this.zza.zza(networkRequestData);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzfe zzfe, String str, NetworkRequestData networkRequestData) {
        zzfe zzfe2 = zzfe.activate;
        if (zzfe.ordinal() != 35) {
            zzhd.zzc("Unexpected network request of type".concat(String.valueOf(String.valueOf(zzfe))));
        } else {
            zzvd.zzd(this.zzc.zza(new zzfv(this, networkRequestData)), new zzfw(this, str), this.zzc);
        }
    }
}
