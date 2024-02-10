package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzyg {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzyf zza(byte[] bArr) throws zzbu {
        return zzb(new zzee(bArr, bArr.length), false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b5, code lost:
        if (r11 != 3) goto L_0x00d2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzyf zzb(com.google.android.gms.internal.ads.zzee r11, boolean r12) throws com.google.android.gms.internal.ads.zzbu {
        /*
            int r0 = zzc(r11)
            int r1 = zzd(r11)
            r2 = 4
            int r3 = r11.zzc(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "mp4a.40."
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r5 = 5
            r6 = 22
            if (r0 == r5) goto L_0x0024
            r5 = 29
            if (r0 != r5) goto L_0x0032
        L_0x0024:
            int r1 = zzd(r11)
            int r0 = zzc(r11)
            if (r0 != r6) goto L_0x0032
            int r3 = r11.zzc(r2)
        L_0x0032:
            if (r12 == 0) goto L_0x00d2
            r12 = 17
            r5 = 6
            r7 = 1
            r8 = 2
            r9 = 3
            if (r0 == r7) goto L_0x005f
            if (r0 == r8) goto L_0x005f
            if (r0 == r9) goto L_0x005f
            if (r0 == r2) goto L_0x005f
            if (r0 == r5) goto L_0x005f
            r2 = 7
            if (r0 == r2) goto L_0x005f
            if (r0 == r12) goto L_0x005f
            switch(r0) {
                case 19: goto L_0x005f;
                case 20: goto L_0x005f;
                case 21: goto L_0x005f;
                case 22: goto L_0x005f;
                case 23: goto L_0x005f;
                default: goto L_0x004c;
            }
        L_0x004c:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Unsupported audio object type: "
            r11.<init>(r12)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.google.android.gms.internal.ads.zzbu r11 = com.google.android.gms.internal.ads.zzbu.zzc(r11)
            throw r11
        L_0x005f:
            boolean r2 = r11.zzl()
            if (r2 == 0) goto L_0x006c
            java.lang.String r2 = "AacUtil"
            java.lang.String r10 = "Unexpected frameLengthFlag = 1"
            com.google.android.gms.internal.ads.zzdw.zze(r2, r10)
        L_0x006c:
            boolean r2 = r11.zzl()
            if (r2 == 0) goto L_0x0077
            r2 = 14
            r11.zzj(r2)
        L_0x0077:
            boolean r2 = r11.zzl()
            if (r3 == 0) goto L_0x00cc
            r10 = 20
            if (r0 == r5) goto L_0x008a
            if (r0 != r10) goto L_0x0088
            r0 = 20
            r5 = 20
            goto L_0x008b
        L_0x0088:
            r5 = r0
            goto L_0x008e
        L_0x008a:
            r5 = r0
        L_0x008b:
            r11.zzj(r9)
        L_0x008e:
            if (r2 == 0) goto L_0x00ab
            if (r0 != r6) goto L_0x0098
            r0 = 16
            r11.zzj(r0)
            goto L_0x0099
        L_0x0098:
            r6 = r0
        L_0x0099:
            if (r6 == r12) goto L_0x00a5
            r12 = 19
            if (r6 == r12) goto L_0x00a5
            if (r6 == r10) goto L_0x00a5
            r12 = 23
            if (r6 != r12) goto L_0x00a8
        L_0x00a5:
            r11.zzj(r9)
        L_0x00a8:
            r11.zzj(r7)
        L_0x00ab:
            switch(r5) {
                case 17: goto L_0x00af;
                case 18: goto L_0x00ae;
                case 19: goto L_0x00af;
                case 20: goto L_0x00af;
                case 21: goto L_0x00af;
                case 22: goto L_0x00af;
                case 23: goto L_0x00af;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            goto L_0x00d2
        L_0x00af:
            int r11 = r11.zzc(r8)
            if (r11 == r8) goto L_0x00b8
            if (r11 == r9) goto L_0x00b9
            goto L_0x00d2
        L_0x00b8:
            r9 = r11
        L_0x00b9:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Unsupported epConfig: "
            r11.<init>(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            com.google.android.gms.internal.ads.zzbu r11 = com.google.android.gms.internal.ads.zzbu.zzc(r11)
            throw r11
        L_0x00cc:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            r11.<init>()
            throw r11
        L_0x00d2:
            int[] r11 = zzc
            r11 = r11[r3]
            r12 = -1
            r0 = 0
            if (r11 == r12) goto L_0x00e0
            com.google.android.gms.internal.ads.zzyf r12 = new com.google.android.gms.internal.ads.zzyf
            r12.<init>(r1, r11, r4, r0)
            return r12
        L_0x00e0:
            com.google.android.gms.internal.ads.zzbu r11 = com.google.android.gms.internal.ads.zzbu.zza(r0, r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyg.zzb(com.google.android.gms.internal.ads.zzee, boolean):com.google.android.gms.internal.ads.zzyf");
    }

    private static int zzc(zzee zzee) {
        int zzc2 = zzee.zzc(5);
        return zzc2 == 31 ? zzee.zzc(6) + 32 : zzc2;
    }

    private static int zzd(zzee zzee) throws zzbu {
        int zzc2 = zzee.zzc(4);
        if (zzc2 == 15) {
            return zzee.zzc(24);
        }
        if (zzc2 < 13) {
            return zzb[zzc2];
        }
        throw zzbu.zza((String) null, (Throwable) null);
    }
}
