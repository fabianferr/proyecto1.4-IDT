package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzmp extends zzmn {
    zzmp() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zza(Object obj) {
        return ((zzmo) obj).zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzmo) obj).zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj) {
        return ((zzke) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzd(Object obj, Object obj2) {
        zzmo zzmo = (zzmo) obj2;
        if (zzmo.equals(zzmo.zzc())) {
            return obj;
        }
        return zzmo.zzd((zzmo) obj, zzmo);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zze() {
        return zzmo.zze();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, long j) {
        ((zzmo) obj).zzh(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final void zzg(Object obj) {
        ((zzke) obj).zzc.zzf();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzke) obj).zzc = (zzmo) obj2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(Object obj, zznf zznf) throws IOException {
        ((zzmo) obj).zzi(zznf);
    }
}
