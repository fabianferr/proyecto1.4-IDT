package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaej {
    private final zzef zza = new zzef(8);
    private int zzb;

    private final long zzb(zzzj zzzj) throws IOException {
        zzyy zzyy = (zzyy) zzzj;
        int i = 0;
        zzyy.zzm(this.zza.zzH(), 0, 1, false);
        byte b = this.zza.zzH()[0] & 255;
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
        zzyy.zzm(this.zza.zzH(), 1, i3, false);
        while (i < i3) {
            i++;
            i4 = (this.zza.zzH()[i] & 255) + (i4 << 8);
        }
        this.zzb += i3 + 1;
        return (long) i4;
    }

    public final boolean zza(zzzj zzzj) throws IOException {
        long zzd = zzzj.zzd();
        long j = 1024;
        if (zzd != -1 && zzd <= 1024) {
            j = zzd;
        }
        int i = (int) j;
        zzyy zzyy = (zzyy) zzzj;
        zzyy.zzm(this.zza.zzH(), 0, 4, false);
        long zzs = this.zza.zzs();
        this.zzb = 4;
        while (zzs != 440786851) {
            int i2 = this.zzb + 1;
            this.zzb = i2;
            if (i2 == i) {
                return false;
            }
            zzyy.zzm(this.zza.zzH(), 0, 1, false);
            zzs = ((zzs << 8) & -256) | ((long) (this.zza.zzH()[0] & 255));
        }
        long zzb2 = zzb(zzzj);
        long j2 = (long) this.zzb;
        if (zzb2 != Long.MIN_VALUE && (zzd == -1 || j2 + zzb2 < zzd)) {
            while (true) {
                long j3 = (long) this.zzb;
                long j4 = j2 + zzb2;
                if (j3 < j4) {
                    if (zzb(zzzj) == Long.MIN_VALUE) {
                        return false;
                    }
                    long zzb3 = zzb(zzzj);
                    if (zzb3 < 0) {
                        return false;
                    }
                    if (zzb3 != 0) {
                        int i3 = (int) zzb3;
                        zzyy.zzl(i3, false);
                        this.zzb += i3;
                    }
                } else if (j3 == j4) {
                    return true;
                }
            }
        }
        return false;
    }
}
