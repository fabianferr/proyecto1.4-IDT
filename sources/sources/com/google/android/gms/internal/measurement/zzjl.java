package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
public abstract class zzjl extends zzit {
    private static final Logger zzb = Logger.getLogger(zzjl.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzmx.zzx();
    zzjm zza;

    private zzjl() {
    }

    /* synthetic */ zzjl(zzjk zzjk) {
    }

    public static int zzA(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzB(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static zzjl zzC(byte[] bArr) {
        return new zzji(bArr, 0, bArr.length);
    }

    public static int zzt(zzjd zzjd) {
        int zzd = zzjd.zzd();
        return zzA(zzd) + zzd;
    }

    @Deprecated
    static int zzu(int i, zzll zzll, zzlw zzlw) {
        int zzA = zzA(i << 3);
        int i2 = zzA + zzA;
        zzin zzin = (zzin) zzll;
        int zzbr = zzin.zzbr();
        if (zzbr == -1) {
            zzbr = zzlw.zza(zzin);
            zzin.zzbu(zzbr);
        }
        return i2 + zzbr;
    }

    public static int zzv(int i) {
        if (i >= 0) {
            return zzA(i);
        }
        return 10;
    }

    public static int zzw(zzkr zzkr) {
        int zza2 = zzkr.zza();
        return zzA(zza2) + zza2;
    }

    static int zzx(zzll zzll, zzlw zzlw) {
        zzin zzin = (zzin) zzll;
        int zzbr = zzin.zzbr();
        if (zzbr == -1) {
            zzbr = zzlw.zza(zzin);
            zzin.zzbu(zzbr);
        }
        return zzA(zzbr) + zzbr;
    }

    public static int zzy(String str) {
        int i;
        try {
            i = zznc.zzc(str);
        } catch (zznb unused) {
            i = str.getBytes(zzkm.zzb).length;
        }
        return zzA(i) + i;
    }

    public static int zzz(int i) {
        return zzA(i << 3);
    }

    public final void zzD() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(String str, zznb zznb) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zznb);
        byte[] bytes = str.getBytes(zzkm.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzjj(e);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b) throws IOException;

    public abstract void zzd(int i, boolean z) throws IOException;

    public abstract void zze(int i, zzjd zzjd) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(int i) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(long j) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzl(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzm(int i, String str) throws IOException;

    public abstract void zzo(int i, int i2) throws IOException;

    public abstract void zzp(int i, int i2) throws IOException;

    public abstract void zzq(int i) throws IOException;

    public abstract void zzr(int i, long j) throws IOException;

    public abstract void zzs(long j) throws IOException;
}
