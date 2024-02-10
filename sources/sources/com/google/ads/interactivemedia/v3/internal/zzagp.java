package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzagp implements Iterator {
    private final ArrayDeque zza;
    private zzadn zzb;

    /* synthetic */ zzagp(zzadr zzadr, zzago zzago) {
        if (zzadr instanceof zzagr) {
            zzagr zzagr = (zzagr) zzadr;
            ArrayDeque arrayDeque = new ArrayDeque(zzagr.zzf());
            this.zza = arrayDeque;
            arrayDeque.push(zzagr);
            this.zzb = zzb(zzagr.zzd);
            return;
        }
        this.zza = null;
        this.zzb = (zzadn) zzadr;
    }

    private final zzadn zzb(zzadr zzadr) {
        while (zzadr instanceof zzagr) {
            zzagr zzagr = (zzagr) zzadr;
            this.zza.push(zzagr);
            zzadr = zzagr.zzd;
        }
        return (zzadn) zzadr;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: zza */
    public final zzadn next() {
        zzadn zzadn;
        zzadn zzadn2 = this.zzb;
        if (zzadn2 != null) {
            do {
                ArrayDeque arrayDeque = this.zza;
                zzadn = null;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    this.zzb = zzadn;
                } else {
                    zzadn = zzb(((zzagr) this.zza.pop()).zze);
                }
            } while (zzadn.zzd() == 0);
            this.zzb = zzadn;
            return zzadn2;
        }
        throw new NoSuchElementException();
    }
}
