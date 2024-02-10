package com.google.ads.interactivemedia.v3.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzsf implements Iterator {
    final /* synthetic */ zzsg zza;
    private int zzb;
    private int zzc = -1;
    private int zzd;
    private int zze;

    zzsf(zzsg zzsg) {
        this.zza = zzsg;
        this.zzb = zzsg.zzb.zzi;
        zzsh zzsh = zzsg.zzb;
        this.zzd = zzsh.zzd;
        this.zze = zzsh.zzc;
    }

    private final void zza() {
        if (this.zza.zzb.zzd != this.zzd) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean hasNext() {
        zza();
        return this.zzb != -2 && this.zze > 0;
    }

    public final Object next() {
        if (hasNext()) {
            Object zza2 = this.zza.zza(this.zzb);
            this.zzc = this.zzb;
            this.zzb = this.zza.zzb.zzl[this.zzb];
            this.zze--;
            return zza2;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        zza();
        zzrm.zzh(this.zzc != -1, "no calls to next() since the last call to remove()");
        zzsh zzsh = this.zza.zzb;
        int i = this.zzc;
        zzsh.zzl(i, zzsi.zzc(zzsh.zza[i]));
        int i2 = this.zzb;
        zzsh zzsh2 = this.zza.zzb;
        if (i2 == zzsh2.zzc) {
            this.zzb = this.zzc;
        }
        this.zzc = -1;
        this.zzd = zzsh2.zzd;
    }
}
