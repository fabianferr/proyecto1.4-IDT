package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzahl implements zzahc {
    private final zzaid zza;
    private final zzahr zzb = new zzahr(7, 128);
    private final zzahr zzc = new zzahr(8, 128);
    private final zzahr zzd = new zzahr(6, 128);
    private long zze;
    private final boolean[] zzf = new boolean[3];
    private String zzg;
    private zzaap zzh;
    private zzahk zzi;
    private boolean zzj;
    private long zzk = -9223372036854775807L;
    private boolean zzl;
    private final zzef zzm = new zzef();

    public zzahl(zzaid zzaid, boolean z, boolean z2) {
        this.zza = zzaid;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i, int i2) {
        if (!this.zzj) {
            this.zzb.zza(bArr, i, i2);
            this.zzc.zza(bArr, i, i2);
        }
        this.zzd.zza(bArr, i, i2);
    }

    public final void zza(zzef zzef) {
        zzdd.zzb(this.zzh);
        int i = zzen.zza;
        int zzc2 = zzef.zzc();
        int zzd2 = zzef.zzd();
        byte[] zzH = zzef.zzH();
        this.zze += (long) zzef.zza();
        this.zzh.zzq(zzef, zzef.zza());
        while (true) {
            int zza2 = zzaaf.zza(zzH, zzc2, zzd2, this.zzf);
            if (zza2 != zzd2) {
                int i2 = zza2 + 3;
                byte b = zzH[i2] & Ascii.US;
                int i3 = zza2 - zzc2;
                if (i3 > 0) {
                    zzf(zzH, zzc2, zza2);
                }
                int i4 = zzd2 - zza2;
                long j = this.zze - ((long) i4);
                int i5 = i3 < 0 ? -i3 : 0;
                long j2 = this.zzk;
                if (!this.zzj) {
                    this.zzb.zzd(i5);
                    this.zzc.zzd(i5);
                    if (this.zzj) {
                        zzahr zzahr = this.zzb;
                        if (zzahr.zze()) {
                            this.zzi.zzb(zzaaf.zzd(zzahr.zza, 4, zzahr.zzb));
                            this.zzb.zzb();
                        } else {
                            zzahr zzahr2 = this.zzc;
                            if (zzahr2.zze()) {
                                this.zzi.zza(zzaaf.zzc(zzahr2.zza, 4, zzahr2.zzb));
                                this.zzc.zzb();
                            }
                        }
                    } else if (this.zzb.zze() && this.zzc.zze()) {
                        ArrayList arrayList = new ArrayList();
                        zzahr zzahr3 = this.zzb;
                        arrayList.add(Arrays.copyOf(zzahr3.zza, zzahr3.zzb));
                        zzahr zzahr4 = this.zzc;
                        arrayList.add(Arrays.copyOf(zzahr4.zza, zzahr4.zzb));
                        zzahr zzahr5 = this.zzb;
                        zzaae zzd3 = zzaaf.zzd(zzahr5.zza, 4, zzahr5.zzb);
                        zzahr zzahr6 = this.zzc;
                        zzaad zzc3 = zzaaf.zzc(zzahr6.zza, 4, zzahr6.zzb);
                        String zza3 = zzdf.zza(zzd3.zza, zzd3.zzb, zzd3.zzc);
                        zzaap zzaap = this.zzh;
                        zzad zzad = new zzad();
                        zzad.zzH(this.zzg);
                        zzad.zzS("video/avc");
                        zzad.zzx(zza3);
                        zzad.zzX(zzd3.zze);
                        zzad.zzF(zzd3.zzf);
                        zzad.zzP(zzd3.zzg);
                        zzad.zzI(arrayList);
                        zzaap.zzk(zzad.zzY());
                        this.zzj = true;
                        this.zzi.zzb(zzd3);
                        this.zzi.zza(zzc3);
                        this.zzb.zzb();
                        this.zzc.zzb();
                    }
                }
                if (this.zzd.zzd(i5)) {
                    zzahr zzahr7 = this.zzd;
                    this.zzm.zzD(this.zzd.zza, zzaaf.zzb(zzahr7.zza, zzahr7.zzb));
                    this.zzm.zzF(4);
                    this.zza.zza(j2, this.zzm);
                }
                if (this.zzi.zze(j, i4, this.zzj, this.zzl)) {
                    this.zzl = false;
                }
                long j3 = this.zzk;
                if (!this.zzj) {
                    this.zzb.zzc(b);
                    this.zzc.zzc(b);
                }
                this.zzd.zzc(b);
                this.zzi.zzd(j, b, j3);
                zzc2 = i2;
            } else {
                zzf(zzH, zzc2, zzd2);
                return;
            }
        }
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        zzaio.zzc();
        this.zzg = zzaio.zzb();
        zzaap zzv = zzzl.zzv(zzaio.zza(), 2);
        this.zzh = zzv;
        this.zzi = new zzahk(zzv, false, false);
        this.zza.zzb(zzzl, zzaio);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        if (j != -9223372036854775807L) {
            this.zzk = j;
        }
        this.zzl |= (i & 2) != 0;
    }

    public final void zze() {
        this.zze = 0;
        this.zzl = false;
        this.zzk = -9223372036854775807L;
        zzaaf.zze(this.zzf);
        this.zzb.zzb();
        this.zzc.zzb();
        this.zzd.zzb();
        zzahk zzahk = this.zzi;
        if (zzahk != null) {
            zzahk.zzc();
        }
    }
}
