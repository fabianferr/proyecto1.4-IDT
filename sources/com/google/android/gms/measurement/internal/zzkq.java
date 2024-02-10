package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzkq implements zzeq {
    final /* synthetic */ String zza;
    final /* synthetic */ zzkz zzb;

    zzkq(zzkz zzkz, String str) {
        this.zzb = zzkz;
        this.zza = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.zzb.zzK(i, th, bArr, this.zza);
    }
}
