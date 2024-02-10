package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaia implements zzzi {
    public static final zzzp zza = zzahy.zza;
    private final zzel zzb = new zzel(0);
    private final SparseArray zzc = new SparseArray();
    private final zzef zzd = new zzef(4096);
    private final zzahx zze = new zzahx();
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private long zzi;
    private zzahw zzj;
    private zzzl zzk;
    private boolean zzl;

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzzj r14, com.google.android.gms.internal.ads.zzaai r15) throws java.io.IOException {
        /*
            r13 = this;
            com.google.android.gms.internal.ads.zzzl r0 = r13.zzk
            com.google.android.gms.internal.ads.zzdd.zzb(r0)
            long r7 = r14.zzd()
            r9 = -1
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x001d
            com.google.android.gms.internal.ads.zzahx r0 = r13.zze
            boolean r1 = r0.zze()
            if (r1 == 0) goto L_0x0018
            goto L_0x001d
        L_0x0018:
            int r14 = r0.zza(r14, r15)
            return r14
        L_0x001d:
            boolean r0 = r13.zzl
            r11 = 1
            if (r0 != 0) goto L_0x005e
            r13.zzl = r11
            com.google.android.gms.internal.ads.zzahx r0 = r13.zze
            long r1 = r0.zzb()
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x004e
            com.google.android.gms.internal.ads.zzahw r12 = new com.google.android.gms.internal.ads.zzahw
            com.google.android.gms.internal.ads.zzel r2 = r0.zzd()
            long r3 = r0.zzb()
            r1 = r12
            r5 = r7
            r1.<init>(r2, r3, r5)
            r13.zzj = r12
            com.google.android.gms.internal.ads.zzzl r0 = r13.zzk
            com.google.android.gms.internal.ads.zzaal r1 = r12.zzb()
            r0.zzN(r1)
            goto L_0x005e
        L_0x004e:
            com.google.android.gms.internal.ads.zzzl r1 = r13.zzk
            com.google.android.gms.internal.ads.zzaak r2 = new com.google.android.gms.internal.ads.zzaak
            long r3 = r0.zzb()
            r5 = 0
            r2.<init>(r3, r5)
            r1.zzN(r2)
        L_0x005e:
            com.google.android.gms.internal.ads.zzahw r0 = r13.zzj
            if (r0 == 0) goto L_0x006e
            boolean r1 = r0.zze()
            if (r1 != 0) goto L_0x0069
            goto L_0x006e
        L_0x0069:
            int r14 = r0.zza(r14, r15)
            return r14
        L_0x006e:
            r14.zzj()
            int r15 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r15 == 0) goto L_0x007b
            long r0 = r14.zze()
            long r7 = r7 - r0
            goto L_0x007c
        L_0x007b:
            r7 = r9
        L_0x007c:
            r15 = -1
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0089
            r0 = 4
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            return r15
        L_0x0089:
            com.google.android.gms.internal.ads.zzef r0 = r13.zzd
            byte[] r0 = r0.zzH()
            r1 = 4
            r2 = 0
            boolean r0 = r14.zzm(r0, r2, r1, r11)
            if (r0 != 0) goto L_0x0098
            return r15
        L_0x0098:
            com.google.android.gms.internal.ads.zzef r0 = r13.zzd
            r0.zzF(r2)
            com.google.android.gms.internal.ads.zzef r0 = r13.zzd
            int r0 = r0.zze()
            r1 = 441(0x1b9, float:6.18E-43)
            if (r0 != r1) goto L_0x00a8
            return r15
        L_0x00a8:
            r15 = 442(0x1ba, float:6.2E-43)
            if (r0 != r15) goto L_0x00ce
            com.google.android.gms.internal.ads.zzef r15 = r13.zzd
            byte[] r15 = r15.zzH()
            com.google.android.gms.internal.ads.zzyy r14 = (com.google.android.gms.internal.ads.zzyy) r14
            r0 = 10
            r14.zzm(r15, r2, r0, r2)
            com.google.android.gms.internal.ads.zzef r15 = r13.zzd
            r0 = 9
            r15.zzF(r0)
            com.google.android.gms.internal.ads.zzef r15 = r13.zzd
            int r15 = r15.zzk()
            r15 = r15 & 7
            int r15 = r15 + 14
            r14.zzo(r15, r2)
            return r2
        L_0x00ce:
            r15 = 443(0x1bb, float:6.21E-43)
            r1 = 2
            r3 = 6
            if (r0 != r15) goto L_0x00ef
            com.google.android.gms.internal.ads.zzef r15 = r13.zzd
            byte[] r15 = r15.zzH()
            com.google.android.gms.internal.ads.zzyy r14 = (com.google.android.gms.internal.ads.zzyy) r14
            r14.zzm(r15, r2, r1, r2)
            com.google.android.gms.internal.ads.zzef r15 = r13.zzd
            r15.zzF(r2)
            com.google.android.gms.internal.ads.zzef r15 = r13.zzd
            int r15 = r15.zzo()
            int r15 = r15 + r3
            r14.zzo(r15, r2)
            return r2
        L_0x00ef:
            int r15 = r0 >> 8
            if (r15 == r11) goto L_0x00f9
            com.google.android.gms.internal.ads.zzyy r14 = (com.google.android.gms.internal.ads.zzyy) r14
            r14.zzo(r11, r2)
            return r2
        L_0x00f9:
            r15 = r0 & 255(0xff, float:3.57E-43)
            android.util.SparseArray r0 = r13.zzc
            java.lang.Object r0 = r0.get(r15)
            com.google.android.gms.internal.ads.zzahz r0 = (com.google.android.gms.internal.ads.zzahz) r0
            boolean r4 = r13.zzf
            if (r4 != 0) goto L_0x0180
            if (r0 != 0) goto L_0x0161
            r4 = 189(0xbd, float:2.65E-43)
            r5 = 0
            if (r15 != r4) goto L_0x011d
            com.google.android.gms.internal.ads.zzags r4 = new com.google.android.gms.internal.ads.zzags
            r4.<init>(r5)
            r13.zzg = r11
            long r5 = r14.zzf()
            r13.zzi = r5
        L_0x011b:
            r5 = r4
            goto L_0x0145
        L_0x011d:
            r4 = r15 & 224(0xe0, float:3.14E-43)
            r6 = 192(0xc0, float:2.69E-43)
            if (r4 != r6) goto L_0x0131
            com.google.android.gms.internal.ads.zzahq r4 = new com.google.android.gms.internal.ads.zzahq
            r4.<init>(r5)
            r13.zzg = r11
            long r5 = r14.zzf()
            r13.zzi = r5
            goto L_0x011b
        L_0x0131:
            r4 = r15 & 240(0xf0, float:3.36E-43)
            r6 = 224(0xe0, float:3.14E-43)
            if (r4 != r6) goto L_0x0145
            com.google.android.gms.internal.ads.zzahe r4 = new com.google.android.gms.internal.ads.zzahe
            r4.<init>(r5)
            r13.zzh = r11
            long r5 = r14.zzf()
            r13.zzi = r5
            goto L_0x011b
        L_0x0145:
            if (r5 == 0) goto L_0x0161
            com.google.android.gms.internal.ads.zzaio r0 = new com.google.android.gms.internal.ads.zzaio
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 256(0x100, float:3.59E-43)
            r0.<init>(r4, r15, r6)
            com.google.android.gms.internal.ads.zzzl r4 = r13.zzk
            r5.zzb(r4, r0)
            com.google.android.gms.internal.ads.zzahz r0 = new com.google.android.gms.internal.ads.zzahz
            com.google.android.gms.internal.ads.zzel r4 = r13.zzb
            r0.<init>(r5, r4)
            android.util.SparseArray r4 = r13.zzc
            r4.put(r15, r0)
        L_0x0161:
            boolean r15 = r13.zzg
            r4 = 1048576(0x100000, double:5.180654E-318)
            if (r15 == 0) goto L_0x0171
            boolean r15 = r13.zzh
            if (r15 == 0) goto L_0x0171
            long r4 = r13.zzi
            r6 = 8192(0x2000, double:4.0474E-320)
            long r4 = r4 + r6
        L_0x0171:
            long r6 = r14.zzf()
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 <= 0) goto L_0x0180
            r13.zzf = r11
            com.google.android.gms.internal.ads.zzzl r15 = r13.zzk
            r15.zzC()
        L_0x0180:
            com.google.android.gms.internal.ads.zzef r15 = r13.zzd
            byte[] r15 = r15.zzH()
            com.google.android.gms.internal.ads.zzyy r14 = (com.google.android.gms.internal.ads.zzyy) r14
            r14.zzm(r15, r2, r1, r2)
            com.google.android.gms.internal.ads.zzef r15 = r13.zzd
            r15.zzF(r2)
            com.google.android.gms.internal.ads.zzef r15 = r13.zzd
            int r15 = r15.zzo()
            int r15 = r15 + r3
            if (r0 != 0) goto L_0x019d
            r14.zzo(r15, r2)
            goto L_0x01be
        L_0x019d:
            com.google.android.gms.internal.ads.zzef r1 = r13.zzd
            r1.zzC(r15)
            com.google.android.gms.internal.ads.zzef r1 = r13.zzd
            byte[] r1 = r1.zzH()
            r14.zzn(r1, r2, r15, r2)
            com.google.android.gms.internal.ads.zzef r14 = r13.zzd
            r14.zzF(r3)
            com.google.android.gms.internal.ads.zzef r14 = r13.zzd
            r0.zza(r14)
            com.google.android.gms.internal.ads.zzef r14 = r13.zzd
            int r15 = r14.zzb()
            r14.zzE(r15)
        L_0x01be:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaia.zza(com.google.android.gms.internal.ads.zzzj, com.google.android.gms.internal.ads.zzaai):int");
    }

    public final void zzb(zzzl zzzl) {
        this.zzk = zzzl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r0 != r7) goto L_0x0021;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[LOOP:0: B:12:0x002c->B:14:0x0034, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(long r5, long r7) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzel r5 = r4.zzb
            long r0 = r5.zze()
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0021
            long r0 = r5.zzc()
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
            int r6 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
        L_0x0021:
            r5.zzf(r7)
        L_0x0024:
            com.google.android.gms.internal.ads.zzahw r5 = r4.zzj
            r6 = 0
            if (r5 == 0) goto L_0x002c
            r5.zzd(r7)
        L_0x002c:
            android.util.SparseArray r5 = r4.zzc
            int r5 = r5.size()
            if (r6 >= r5) goto L_0x0042
            android.util.SparseArray r5 = r4.zzc
            java.lang.Object r5 = r5.valueAt(r6)
            com.google.android.gms.internal.ads.zzahz r5 = (com.google.android.gms.internal.ads.zzahz) r5
            r5.zzb()
            int r6 = r6 + 1
            goto L_0x002c
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaia.zzc(long, long):void");
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        byte[] bArr = new byte[14];
        zzyy zzyy = (zzyy) zzzj;
        zzyy.zzm(bArr, 0, 14, false);
        if ((((bArr[0] & 255) << Ascii.CAN) | ((bArr[1] & 255) << Ascii.DLE) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzyy.zzl(bArr[13] & 7, false);
        zzyy.zzm(bArr, 0, 3, false);
        return ((((bArr[0] & 255) << Ascii.DLE) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255)) == 1;
    }
}
