package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaeu implements zzaes {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long[] zzf;

    private zzaeu(long j, int i, long j2, long j3, long[] jArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = j3;
        this.zze = j3 != -1 ? j + j3 : -1;
    }

    public static zzaeu zza(long j, long j2, zzaab zzaab, zzef zzef) {
        int zzn;
        long j3 = j;
        zzaab zzaab2 = zzaab;
        int i = zzaab2.zzg;
        int i2 = zzaab2.zzd;
        int zze2 = zzef.zze();
        if ((zze2 & 1) != 1 || (zzn = zzef.zzn()) == 0) {
            return null;
        }
        long zzw = zzen.zzw((long) zzn, ((long) i) * 1000000, (long) i2);
        if ((zze2 & 6) != 6) {
            return new zzaeu(j2, zzaab2.zzc, zzw, -1, (long[]) null);
        }
        long zzs = zzef.zzs();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = (long) zzef.zzk();
        }
        if (j3 != -1) {
            long j4 = j2 + zzs;
            if (j3 != j4) {
                zzdw.zze("XingSeeker", "XING data size mismatch: " + j3 + ", " + j4);
            }
        }
        return new zzaeu(j2, zzaab2.zzc, zzw, zzs, jArr);
    }

    private final long zzd(int i) {
        return (this.zzc * ((long) i)) / 100;
    }

    public final long zzb() {
        return this.zze;
    }

    public final long zzc(long j) {
        long j2;
        double d;
        long j3 = j - this.zza;
        if (!zzh() || j3 <= ((long) this.zzb)) {
            return 0;
        }
        long[] jArr = (long[]) zzdd.zzb(this.zzf);
        double d2 = (double) j3;
        Double.isNaN(d2);
        double d3 = (double) this.zzd;
        Double.isNaN(d3);
        double d4 = (d2 * 256.0d) / d3;
        int zzd2 = zzen.zzd(jArr, (long) d4, true, true);
        long zzd3 = zzd(zzd2);
        long j4 = jArr[zzd2];
        int i = zzd2 + 1;
        long zzd4 = zzd(i);
        if (zzd2 == 99) {
            j2 = 256;
        } else {
            j2 = jArr[i];
        }
        if (j4 == j2) {
            d = 0.0d;
        } else {
            double d5 = (double) j4;
            Double.isNaN(d5);
            double d6 = (double) (j2 - j4);
            Double.isNaN(d6);
            d = (d4 - d5) / d6;
        }
        double d7 = (double) (zzd4 - zzd3);
        Double.isNaN(d7);
        return zzd3 + Math.round(d * d7);
    }

    public final long zze() {
        return this.zzc;
    }

    public final zzaaj zzg(long j) {
        double d;
        if (!zzh()) {
            zzaam zzaam = new zzaam(0, this.zza + ((long) this.zzb));
            return new zzaaj(zzaam, zzaam);
        }
        long zzr = zzen.zzr(j, 0, this.zzc);
        double d2 = (double) zzr;
        Double.isNaN(d2);
        double d3 = (double) this.zzc;
        Double.isNaN(d3);
        double d4 = (d2 * 100.0d) / d3;
        double d5 = 0.0d;
        if (d4 > 0.0d) {
            if (d4 >= 100.0d) {
                d5 = 256.0d;
            } else {
                int i = (int) d4;
                long[] jArr = (long[]) zzdd.zzb(this.zzf);
                double d6 = (double) jArr[i];
                if (i == 99) {
                    d = 256.0d;
                } else {
                    d = (double) jArr[i + 1];
                }
                double d7 = (double) i;
                Double.isNaN(d7);
                Double.isNaN(d6);
                Double.isNaN(d6);
                d5 = d6 + ((d4 - d7) * (d - d6));
            }
        }
        double d8 = (double) this.zzd;
        Double.isNaN(d8);
        zzaam zzaam2 = new zzaam(zzr, this.zza + zzen.zzr(Math.round((d5 / 256.0d) * d8), (long) this.zzb, this.zzd - 1));
        return new zzaaj(zzaam2, zzaam2);
    }

    public final boolean zzh() {
        return this.zzf != null;
    }
}
