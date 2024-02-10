package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzfg extends zzfh {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzfh zzc;

    zzfg(zzfh zzfh, int i, int i2) {
        this.zzc = zzfh;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzeu.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
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

    public final zzfh zzh(int i, int i2) {
        zzeu.zzd(i, i2, this.zzb);
        zzfh zzfh = this.zzc;
        int i3 = this.zza;
        return zzfh.subList(i + i3, i2 + i3);
    }
}
