package com.google.android.gms.internal.cast;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzfr extends zzfl {
    private final transient zzfk zza;
    private final transient zzfh zzb;

    zzfr(zzfk zzfk, zzfh zzfh) {
        this.zza = zzfk;
        this.zzb = zzfh;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    public final zzfh zzd() {
        return this.zzb;
    }

    public final zzfx zze() {
        return this.zzb.listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        throw null;
    }
}
