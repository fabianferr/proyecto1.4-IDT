package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzavs {
    private final zzbak zza = new zzbak(8);
    private int zzb;

    private final long zzb(zzauy zzauy) throws IOException, InterruptedException {
        int i = 0;
        zzauy.zzg(this.zza.zza, 0, 1, false);
        byte b = this.zza.zza[0] & 255;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (i2 ^ -1);
        zzauy.zzg(this.zza.zza, 1, i3, false);
        while (i < i3) {
            i++;
            i4 = (this.zza.zza[i] & 255) + (i4 << 8);
        }
        this.zzb += i3 + 1;
        return (long) i4;
    }

    public final boolean zza(zzauy zzauy) throws IOException, InterruptedException {
        long zzc = zzauy.zzc();
        long j = 1024;
        if (zzc != -1 && zzc <= 1024) {
            j = zzc;
        }
        int i = (int) j;
        zzauy.zzg(this.zza.zza, 0, 4, false);
        long zzm = this.zza.zzm();
        this.zzb = 4;
        while (zzm != 440786851) {
            int i2 = this.zzb + 1;
            this.zzb = i2;
            if (i2 == i) {
                return false;
            }
            zzauy.zzg(this.zza.zza, 0, 1, false);
            zzm = ((zzm << 8) & -256) | ((long) (this.zza.zza[0] & 255));
        }
        long zzb2 = zzb(zzauy);
        long j2 = (long) this.zzb;
        if (zzb2 != Long.MIN_VALUE && (zzc == -1 || j2 + zzb2 < zzc)) {
            while (true) {
                long j3 = (long) this.zzb;
                long j4 = j2 + zzb2;
                if (j3 < j4) {
                    if (zzb(zzauy) == Long.MIN_VALUE) {
                        return false;
                    }
                    long zzb3 = zzb(zzauy);
                    if (zzb3 < 0) {
                        return false;
                    }
                    if (zzb3 != 0) {
                        zzauy.zzf((int) zzb3, false);
                        this.zzb = (int) (((long) this.zzb) + zzb3);
                    }
                } else if (j3 == j4) {
                    return true;
                }
            }
        }
        return false;
    }
}
