package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzagn {
    private final ArrayDeque zza = new ArrayDeque();

    private zzagn() {
    }

    static /* bridge */ /* synthetic */ zzadr zza(zzagn zzagn, zzadr zzadr, zzadr zzadr2) {
        zzagn.zzb(zzadr);
        zzagn.zzb(zzadr2);
        zzadr zzadr3 = (zzadr) zzagn.zza.pop();
        while (!zzagn.zza.isEmpty()) {
            zzadr3 = new zzagr((zzadr) zzagn.zza.pop(), zzadr3);
        }
        return zzadr3;
    }

    private final void zzb(zzadr zzadr) {
        if (zzadr.zzh()) {
            int zzc = zzc(zzadr.zzd());
            int zzc2 = zzagr.zzc(zzc + 1);
            if (this.zza.isEmpty() || ((zzadr) this.zza.peek()).zzd() >= zzc2) {
                this.zza.push(zzadr);
                return;
            }
            int zzc3 = zzagr.zzc(zzc);
            zzadr zzadr2 = (zzadr) this.zza.pop();
            while (!this.zza.isEmpty() && ((zzadr) this.zza.peek()).zzd() < zzc3) {
                zzadr2 = new zzagr((zzadr) this.zza.pop(), zzadr2);
            }
            zzagr zzagr = new zzagr(zzadr2, zzadr);
            while (!this.zza.isEmpty() && ((zzadr) this.zza.peek()).zzd() < zzagr.zzc(zzc(zzagr.zzd()) + 1)) {
                zzagr = new zzagr((zzadr) this.zza.pop(), zzagr);
            }
            this.zza.push(zzagr);
        } else if (zzadr instanceof zzagr) {
            zzagr zzagr2 = (zzagr) zzadr;
            zzb(zzagr2.zzd);
            zzb(zzagr2.zze);
        } else {
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzadr.getClass()))));
        }
    }

    private static final int zzc(int i) {
        int binarySearch = Arrays.binarySearch(zzagr.zza, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzagn(zzagm zzagm) {
    }
}
