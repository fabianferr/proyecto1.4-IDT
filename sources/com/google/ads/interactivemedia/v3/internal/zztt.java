package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zztt extends zzst {
    final transient Object zza;

    zztt(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final /* synthetic */ Iterator iterator() {
        return new zztb(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "[" + obj + "]";
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }

    public final zzso zzd() {
        Object obj = this.zza;
        int i = zzso.zzd;
        Object[] objArr = {obj};
        zztg.zzb(objArr, 1);
        return zzso.zzj(objArr, 1);
    }

    public final zztw zze() {
        return new zztb(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return false;
    }
}
