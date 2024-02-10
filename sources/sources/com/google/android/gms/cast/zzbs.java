package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzab;
import com.google.android.gms.cast.internal.zzah;
import com.google.android.gms.cast.internal.zzq;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzbs extends zzah {
    final /* synthetic */ zzbt zza;

    zzbs(zzbt zzbt) {
        this.zza = zzbt;
    }

    public final void zzb(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
        this.zza.zzp = applicationMetadata;
        this.zza.zzq = str;
        zzbt.zzD(this.zza, new zzq(new Status(0), applicationMetadata, str, str2, z));
    }

    public final void zzc(int i) {
        this.zza.zzU(i);
    }

    public final void zzd(int i) {
        zzbt.zzF(this.zza, i);
        zzbt zzbt = this.zza;
        if (zzbt.zzx != null) {
            zzbt.zzo(zzbt).post(new zzbm(this, i));
        }
    }

    public final void zze(int i) {
        zzbt.zzF(this.zza, i);
    }

    public final void zzf(zza zza2) {
        zzbt.zzo(this.zza).post(new zzbl(this, zza2));
    }

    public final void zzg(int i) {
        zzbt.zzF(this.zza, i);
    }

    public final void zzh(String str, byte[] bArr) {
        zzbt.zzg.d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    public final void zzi(int i) {
        zzbt.zzo(this.zza).post(new zzbr(this, i));
    }

    public final void zzj(zzab zzab) {
        zzbt.zzo(this.zza).post(new zzbn(this, zzab));
    }

    public final void zzk(int i) {
        zzbt.zzo(this.zza).post(new zzbo(this, i));
    }

    public final void zzl(String str, long j) {
        zzbt.zzE(this.zza, j, 0);
    }

    public final void zzm(String str, long j, int i) {
        zzbt.zzE(this.zza, j, i);
    }

    public final void zzn(String str, double d, boolean z) {
        zzbt.zzg.d("Deprecated callback: \"onStatusReceived\"", new Object[0]);
    }

    public final void zzo(int i) {
        zzbt.zzo(this.zza).post(new zzbp(this, i));
    }

    public final void zzp(String str, String str2) {
        zzbt.zzg.d("Receive (type=text, ns=%s) %s", str, str2);
        zzbt.zzo(this.zza).post(new zzbq(this, str, str2));
    }
}
