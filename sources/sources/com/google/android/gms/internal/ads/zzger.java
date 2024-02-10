package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzger {
    private static final byte[] zza = new byte[0];
    private final zzgeq zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private BigInteger zzg = BigInteger.ZERO;

    private zzger(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zzgeq zzgeq) {
        this.zzf = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzgeq;
    }

    static zzger zzc(byte[] bArr, byte[] bArr2, zzgeu zzgeu, zzgep zzgep, zzgeq zzgeq, byte[] bArr3) throws GeneralSecurityException {
        zzgep zzgep2 = zzgep;
        byte[] zzb2 = zzgfd.zzb(zzgeu.zzb(), zzgep.zzc(), zzgeq.zzb());
        byte[] bArr4 = zzgfd.zzl;
        byte[] bArr5 = zza;
        byte[] zzc2 = zzgnv.zzc(zzgfd.zza, zzgep2.zze(bArr4, bArr5, "psk_id_hash", zzb2), zzgep2.zze(zzgfd.zzl, bArr3, "info_hash", zzb2));
        zzgep zzgep3 = zzgep;
        byte[] zze2 = zzgep2.zze(bArr2, bArr5, "secret", zzb2);
        byte[] bArr6 = zzc2;
        byte[] bArr7 = zzb2;
        return new zzger(bArr, zzgep3.zzd(zze2, bArr6, "key", bArr7, zzgeq.zza()), zzgep3.zzd(zze2, bArr6, "base_nonce", bArr7, 12), BigInteger.ONE.shiftLeft(96).subtract(BigInteger.ONE), zzgeq);
    }

    private final synchronized byte[] zzd() throws GeneralSecurityException {
        byte[] zzd2;
        byte[] bArr = this.zze;
        byte[] byteArray = this.zzg.toByteArray();
        int length = byteArray.length;
        if (length != 12) {
            if (length > 13) {
                throw new GeneralSecurityException("integer too large");
            } else if (length != 13) {
                byte[] bArr2 = new byte[12];
                System.arraycopy(byteArray, 0, bArr2, 12 - length, length);
                byteArray = bArr2;
            } else if (byteArray[0] == 0) {
                byteArray = Arrays.copyOfRange(byteArray, 1, 13);
            } else {
                throw new GeneralSecurityException("integer too large");
            }
        }
        zzd2 = zzgnv.zzd(bArr, byteArray);
        if (this.zzg.compareTo(this.zzc) < 0) {
            this.zzg = this.zzg.add(BigInteger.ONE);
        } else {
            throw new GeneralSecurityException("message limit reached");
        }
        return zzd2;
    }

    /* access modifiers changed from: package-private */
    public final byte[] zza() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zzc(this.zzd, zzd(), bArr, bArr2);
    }
}
