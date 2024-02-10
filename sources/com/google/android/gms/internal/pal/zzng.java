package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
final class zzng implements zzjw {
    private final zzlb zza;
    private final zzrc zzb;
    private final zzrc zzc;

    public zzng(zzlb zzlb) {
        zzrc zzrc;
        this.zza = zzlb;
        if (zzlb.zze()) {
            zzrd zzb2 = zzpi.zza().zzb();
            zzri zza2 = zzpf.zza(zzlb);
            this.zzb = zzb2.zza(zza2, "daead", "encrypt");
            zzrc = zzb2.zza(zza2, "daead", "decrypt");
        } else {
            zzrc = zzpf.zza;
            this.zzb = zzrc;
        }
        this.zzc = zzrc;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            byte[] zzc2 = zzxo.zzc(this.zza.zza().zzd(), ((zzjw) this.zza.zza().zzc()).zza(bArr, bArr2));
            this.zza.zza().zza();
            int length = bArr.length;
            return zzc2;
        } catch (GeneralSecurityException e) {
            throw e;
        }
    }
}