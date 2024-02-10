package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzgp implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzgq zze;

    zzgp(zzgq zzgq, String str, String str2, String str3, long j) {
        this.zze = zzgq;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        String str = this.zza;
        if (str == null) {
            this.zze.zza.zzR(this.zzb, (zzik) null);
            return;
        }
        this.zze.zza.zzR(this.zzb, new zzik(this.zzc, str, this.zzd));
    }
}
