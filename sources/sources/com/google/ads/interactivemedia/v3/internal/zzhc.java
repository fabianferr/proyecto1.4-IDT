package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.impl.data.zzbe;
import com.google.ads.interactivemedia.v3.impl.data.zzbf;
import com.google.ads.interactivemedia.v3.impl.data.zzbg;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzhc {
    private final Queue zza = new ConcurrentLinkedQueue();
    private final zzfr zzb;
    private int zzc = 1;
    private final zzhw zzd;

    public zzhc(zzfr zzfr) {
        zzhw zzhw = new zzhw();
        this.zzd = zzhw;
        this.zzb = zzfr;
    }

    private final void zze(zzbg zzbg) {
        zzff zzff = new zzff(zzfd.adsLoader, zzfe.nativeInstrumentation, "*", zzbg);
        int i = this.zzc;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        } else if (i2 != 0) {
            if (i2 == 1) {
                this.zzb.zzp(zzff);
            }
        } else if (this.zza.size() > 2) {
            this.zzc = 3;
        } else {
            this.zza.add(zzff);
        }
    }

    public final void zza(AdErrorEvent adErrorEvent) {
        zze(zzbg.create(System.currentTimeMillis(), adErrorEvent));
    }

    public final void zzb(zzbe zzbe, zzbf zzbf, Exception exc) {
        zze(zzbg.create(System.currentTimeMillis(), zzbe, zzbf, exc));
    }

    public final void zzc(zzvq zzvq, zzvr zzvr, zzbe zzbe, zzbf zzbf) {
        zzvq.zzm(new zzhb(this, zzvq, zzbe, zzbf), zzvr);
    }

    public final void zzd(boolean z) {
        if (z) {
            this.zzc = 2;
            zzff zzff = (zzff) this.zza.poll();
            while (zzff != null) {
                this.zzb.zzp(zzff);
                zzff = (zzff) this.zza.poll();
            }
            return;
        }
        this.zzc = 3;
        this.zza.clear();
    }
}
