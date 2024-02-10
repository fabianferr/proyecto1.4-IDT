package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzabg implements zzaay {
    public final zzfvn zza;
    private final int zzb;

    private zzabg(int i, zzfvn zzfvn) {
        this.zzb = i;
        this.zza = zzfvn;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzabg zzc(int r16, com.google.android.gms.internal.ads.zzef r17) {
        /*
            r0 = r17
            com.google.android.gms.internal.ads.zzfvk r1 = new com.google.android.gms.internal.ads.zzfvk
            r1.<init>()
            int r2 = r17.zzd()
            r3 = -2
        L_0x000c:
            int r4 = r17.zza()
            r5 = 8
            if (r4 <= r5) goto L_0x0186
            int r4 = r17.zzg()
            int r5 = r17.zzg()
            int r6 = r17.zzc()
            int r6 = r6 + r5
            r0.zzE(r6)
            r5 = 1414744396(0x5453494c, float:3.62987127E12)
            r7 = 2
            r8 = 1
            if (r4 != r5) goto L_0x0035
            int r4 = r17.zzg()
            com.google.android.gms.internal.ads.zzabg r4 = zzc(r4, r0)
            goto L_0x0142
        L_0x0035:
            r5 = 0
            switch(r4) {
                case 1718776947: goto L_0x004e;
                case 1751742049: goto L_0x0048;
                case 1752331379: goto L_0x0042;
                case 1852994675: goto L_0x003c;
                default: goto L_0x0039;
            }
        L_0x0039:
            r4 = r5
            goto L_0x0142
        L_0x003c:
            com.google.android.gms.internal.ads.zzabi r4 = com.google.android.gms.internal.ads.zzabi.zzb(r17)
            goto L_0x0142
        L_0x0042:
            com.google.android.gms.internal.ads.zzabe r4 = com.google.android.gms.internal.ads.zzabe.zzb(r17)
            goto L_0x0142
        L_0x0048:
            com.google.android.gms.internal.ads.zzabd r4 = com.google.android.gms.internal.ads.zzabd.zzb(r17)
            goto L_0x0142
        L_0x004e:
            java.lang.String r4 = "StreamFormatChunk"
            if (r3 != r7) goto L_0x00a4
            r9 = 4
            r0.zzG(r9)
            int r10 = r17.zzg()
            int r11 = r17.zzg()
            r0.zzG(r9)
            int r9 = r17.zzg()
            switch(r9) {
                case 808802372: goto L_0x0076;
                case 826496577: goto L_0x0073;
                case 828601953: goto L_0x0073;
                case 842289229: goto L_0x0070;
                case 859066445: goto L_0x006d;
                case 875967048: goto L_0x0073;
                case 877677894: goto L_0x0076;
                case 1145656883: goto L_0x0076;
                case 1145656920: goto L_0x0076;
                case 1196444237: goto L_0x006a;
                case 1482049860: goto L_0x0076;
                case 1684633208: goto L_0x0076;
                case 1735420525: goto L_0x006a;
                case 2021026148: goto L_0x0076;
                default: goto L_0x0068;
            }
        L_0x0068:
            r12 = r5
            goto L_0x0078
        L_0x006a:
            java.lang.String r12 = "video/mjpeg"
            goto L_0x0078
        L_0x006d:
            java.lang.String r12 = "video/mp43"
            goto L_0x0078
        L_0x0070:
            java.lang.String r12 = "video/mp42"
            goto L_0x0078
        L_0x0073:
            java.lang.String r12 = "video/avc"
            goto L_0x0078
        L_0x0076:
            java.lang.String r12 = "video/mp4v-es"
        L_0x0078:
            if (r12 != 0) goto L_0x008c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Ignoring track with unsupported compression "
            r10.<init>(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r4, r9)
            goto L_0x0039
        L_0x008c:
            com.google.android.gms.internal.ads.zzad r4 = new com.google.android.gms.internal.ads.zzad
            r4.<init>()
            r4.zzX(r10)
            r4.zzF(r11)
            r4.zzS(r12)
            com.google.android.gms.internal.ads.zzabh r5 = new com.google.android.gms.internal.ads.zzabh
            com.google.android.gms.internal.ads.zzaf r4 = r4.zzY()
            r5.<init>(r4)
            goto L_0x0039
        L_0x00a4:
            if (r3 != r8) goto L_0x0133
            int r9 = r17.zzi()
            java.lang.String r10 = "audio/mp4a-latm"
            java.lang.String r11 = "audio/raw"
            if (r9 == r8) goto L_0x00cd
            r12 = 85
            if (r9 == r12) goto L_0x00ca
            r12 = 255(0xff, float:3.57E-43)
            if (r9 == r12) goto L_0x00c8
            r12 = 8192(0x2000, float:1.14794E-41)
            if (r9 == r12) goto L_0x00c5
            r12 = 8193(0x2001, float:1.1481E-41)
            if (r9 == r12) goto L_0x00c2
            r12 = r5
            goto L_0x00ce
        L_0x00c2:
            java.lang.String r12 = "audio/vnd.dts"
            goto L_0x00ce
        L_0x00c5:
            java.lang.String r12 = "audio/ac3"
            goto L_0x00ce
        L_0x00c8:
            r12 = r10
            goto L_0x00ce
        L_0x00ca:
            java.lang.String r12 = "audio/mpeg"
            goto L_0x00ce
        L_0x00cd:
            r12 = r11
        L_0x00ce:
            if (r12 != 0) goto L_0x00e3
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Ignoring track with unsupported format tag "
            r10.<init>(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r4, r9)
            goto L_0x0039
        L_0x00e3:
            int r4 = r17.zzi()
            int r5 = r17.zzg()
            r9 = 6
            r0.zzG(r9)
            int r9 = r17.zzo()
            int r9 = com.google.android.gms.internal.ads.zzen.zzn(r9)
            int r13 = r17.zzi()
            byte[] r14 = new byte[r13]
            r15 = 0
            r0.zzB(r14, r15, r13)
            com.google.android.gms.internal.ads.zzad r15 = new com.google.android.gms.internal.ads.zzad
            r15.<init>()
            r15.zzS(r12)
            r15.zzw(r4)
            r15.zzT(r5)
            boolean r4 = r11.equals(r12)
            if (r4 == 0) goto L_0x011a
            if (r9 == 0) goto L_0x011a
            r15.zzN(r9)
        L_0x011a:
            boolean r4 = r10.equals(r12)
            if (r4 == 0) goto L_0x0129
            if (r13 <= 0) goto L_0x0129
            com.google.android.gms.internal.ads.zzfvn r4 = com.google.android.gms.internal.ads.zzfvn.zzp(r14)
            r15.zzI(r4)
        L_0x0129:
            com.google.android.gms.internal.ads.zzabh r4 = new com.google.android.gms.internal.ads.zzabh
            com.google.android.gms.internal.ads.zzaf r5 = r15.zzY()
            r4.<init>(r5)
            goto L_0x0142
        L_0x0133:
            java.lang.String r9 = "Ignoring strf box for unsupported track type: "
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzO(r3)
            java.lang.String r9 = r9.concat(r10)
            com.google.android.gms.internal.ads.zzdw.zze(r4, r9)
            goto L_0x0039
        L_0x0142:
            if (r4 == 0) goto L_0x017e
            int r5 = r4.zza()
            r9 = 1752331379(0x68727473, float:4.5798432E24)
            if (r5 != r9) goto L_0x017b
            r3 = r4
            com.google.android.gms.internal.ads.zzabe r3 = (com.google.android.gms.internal.ads.zzabe) r3
            int r3 = r3.zza
            r5 = 1935960438(0x73646976, float:1.809666E31)
            if (r3 == r5) goto L_0x017a
            r5 = 1935963489(0x73647561, float:1.8100348E31)
            if (r3 == r5) goto L_0x0178
            r5 = 1937012852(0x73747874, float:1.936895E31)
            if (r3 == r5) goto L_0x0176
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "Found unsupported streamType fourCC: "
            java.lang.String r3 = r5.concat(r3)
            java.lang.String r5 = "AviStreamHeaderChunk"
            com.google.android.gms.internal.ads.zzdw.zze(r5, r3)
            r3 = -1
            goto L_0x017b
        L_0x0176:
            r3 = 3
            goto L_0x017b
        L_0x0178:
            r3 = 1
            goto L_0x017b
        L_0x017a:
            r3 = 2
        L_0x017b:
            r1.zze(r4)
        L_0x017e:
            r0.zzF(r6)
            r0.zzE(r2)
            goto L_0x000c
        L_0x0186:
            com.google.android.gms.internal.ads.zzabg r0 = new com.google.android.gms.internal.ads.zzabg
            com.google.android.gms.internal.ads.zzfvn r1 = r1.zzg()
            r2 = r16
            r0.<init>(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabg.zzc(int, com.google.android.gms.internal.ads.zzef):com.google.android.gms.internal.ads.zzabg");
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzaay zzb(Class cls) {
        zzfvn zzfvn = this.zza;
        int size = zzfvn.size();
        int i = 0;
        while (i < size) {
            zzaay zzaay = (zzaay) zzfvn.get(i);
            i++;
            if (zzaay.getClass() == cls) {
                return zzaay;
            }
        }
        return null;
    }
}
