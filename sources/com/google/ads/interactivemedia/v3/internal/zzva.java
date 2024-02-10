package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzva implements Runnable {
    final Future zza;
    final zzuz zzb;

    zzva(Future future, zzuz zzuz) {
        this.zza = future;
        this.zzb = zzuz;
    }

    public final void run() {
        Throwable zza2;
        Future future = this.zza;
        if (!(future instanceof zzwb) || (zza2 = zzwc.zza((zzwb) future)) == null) {
            try {
                this.zzb.zzb(zzvd.zzc(this.zza));
            } catch (ExecutionException e) {
                this.zzb.zza(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.zzb.zza(e2);
            }
        } else {
            this.zzb.zza(zza2);
        }
    }

    public final String toString() {
        zzrg zza2 = zzrh.zza(this);
        zza2.zza(this.zzb);
        return zza2.toString();
    }
}
