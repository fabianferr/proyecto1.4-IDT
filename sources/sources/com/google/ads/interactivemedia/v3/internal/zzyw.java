package com.google.ads.interactivemedia.v3.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
abstract class zzyw implements Iterator {
    zzyx zza;
    zzyx zzb = null;
    int zzc;
    final /* synthetic */ zzyy zzd;

    zzyw(zzyy zzyy) {
        this.zzd = zzyy;
        this.zza = zzyy.zzd.zzd;
        this.zzc = zzyy.zzc;
    }

    public final boolean hasNext() {
        return this.zza != this.zzd.zzd;
    }

    public final void remove() {
        zzyx zzyx = this.zzb;
        if (zzyx != null) {
            this.zzd.zze(zzyx, true);
            this.zzb = null;
            this.zzc = this.zzd.zzc;
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    public final zzyx zza() {
        zzyx zzyx = this.zza;
        zzyy zzyy = this.zzd;
        if (zzyx == zzyy.zzd) {
            throw new NoSuchElementException();
        } else if (zzyy.zzc == this.zzc) {
            this.zza = zzyx.zzd;
            this.zzb = zzyx;
            return zzyx;
        } else {
            throw new ConcurrentModificationException();
        }
    }
}
