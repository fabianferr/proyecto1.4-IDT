package com.google.ads.interactivemedia.v3.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzsn extends zzso {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzso zzc;

    zzsn(zzso zzso, int i, int i2) {
        this.zzc = zzso;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzrm.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    public final zzso zzi(int i, int i2) {
        zzrm.zzg(i, i2, this.zzb);
        zzso zzso = this.zzc;
        int i3 = this.zza;
        return zzso.subList(i + i3, i2 + i3);
    }
}
