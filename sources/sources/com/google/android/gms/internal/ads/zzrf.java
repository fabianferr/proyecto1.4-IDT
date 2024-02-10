package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzrf {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();
    private static int zzd = -1;

    public static int zza() throws zzqz {
        int i;
        int i2 = zzd;
        if (i2 == -1) {
            zzqn zzc2 = zzc("video/avc", false, false);
            if (zzc2 != null) {
                int i3 = 0;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzc2.zzg()) {
                    int i4 = codecProfileLevel.level;
                    if (i4 != 1 && i4 != 2) {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i = 35651584;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    i3 = Math.max(i, i3);
                }
                i2 = Math.max(i3, zzen.zza >= 21 ? 345600 : 172800);
            } else {
                i2 = 0;
            }
            zzd = i2;
        }
        return i2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x03a7, code lost:
        r0 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x03ab, code lost:
        if (r5 != r0) goto L_0x03c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x03ad, code lost:
        com.google.android.gms.internal.ads.zzdw.zze("MediaCodecUtil", "Unknown AV1 level: " + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:480:?, code lost:
        return new android.util.Pair(java.lang.Integer.valueOf(r2), java.lang.Integer.valueOf(r5));
     */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x02c5 A[Catch:{ NumberFormatException -> 0x02d5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair zzb(com.google.android.gms.internal.ads.zzaf r19) {
        /*
            r0 = r19
            java.lang.String r1 = "Ignoring malformed AVC codec string: "
            java.lang.String r2 = r0.zzj
            r3 = 0
            if (r2 != 0) goto L_0x000a
            return r3
        L_0x000a:
            java.lang.String r4 = "\\."
            java.lang.String[] r2 = r2.split(r4)
            java.lang.String r4 = "video/dolby-vision"
            java.lang.String r5 = r0.zzm
            boolean r4 = r4.equals(r5)
            r8 = 512(0x200, float:7.175E-43)
            r9 = 256(0x100, float:3.59E-43)
            r10 = 128(0x80, float:1.794E-43)
            r12 = 64
            r13 = 32
            r6 = 16
            r3 = 8
            r11 = 3
            r14 = 4
            r5 = 2
            java.lang.String r7 = "MediaCodecUtil"
            r15 = 1
            if (r4 == 0) goto L_0x01fa
            java.lang.String r0 = r0.zzj
            int r1 = r2.length
            if (r1 >= r11) goto L_0x0043
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
        L_0x0040:
            r3 = 0
            goto L_0x01f9
        L_0x0043:
            java.util.regex.Pattern r1 = zzb
            r4 = r2[r15]
            java.util.regex.Matcher r1 = r1.matcher(r4)
            boolean r4 = r1.matches()
            if (r4 != 0) goto L_0x005f
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x0040
        L_0x005f:
            java.lang.String r0 = r1.group(r15)
            if (r0 != 0) goto L_0x0068
        L_0x0065:
            r1 = 0
            goto L_0x010d
        L_0x0068:
            int r1 = r0.hashCode()
            switch(r1) {
                case 1536: goto L_0x00cd;
                case 1537: goto L_0x00c3;
                case 1538: goto L_0x00b9;
                case 1539: goto L_0x00af;
                case 1540: goto L_0x00a5;
                case 1541: goto L_0x009b;
                case 1542: goto L_0x0091;
                case 1543: goto L_0x0087;
                case 1544: goto L_0x007c;
                case 1545: goto L_0x0071;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x00d7
        L_0x0071:
            java.lang.String r1 = "09"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00d7
            r1 = 9
            goto L_0x00d8
        L_0x007c:
            java.lang.String r1 = "08"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00d7
            r1 = 8
            goto L_0x00d8
        L_0x0087:
            java.lang.String r1 = "07"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00d7
            r1 = 7
            goto L_0x00d8
        L_0x0091:
            java.lang.String r1 = "06"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00d7
            r1 = 6
            goto L_0x00d8
        L_0x009b:
            java.lang.String r1 = "05"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00d7
            r1 = 5
            goto L_0x00d8
        L_0x00a5:
            java.lang.String r1 = "04"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00d7
            r1 = 4
            goto L_0x00d8
        L_0x00af:
            java.lang.String r1 = "03"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00d7
            r1 = 3
            goto L_0x00d8
        L_0x00b9:
            java.lang.String r1 = "02"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00d7
            r1 = 2
            goto L_0x00d8
        L_0x00c3:
            java.lang.String r1 = "01"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00d7
            r1 = 1
            goto L_0x00d8
        L_0x00cd:
            java.lang.String r1 = "00"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00d7
            r1 = 0
            goto L_0x00d8
        L_0x00d7:
            r1 = -1
        L_0x00d8:
            switch(r1) {
                case 0: goto L_0x0109;
                case 1: goto L_0x0104;
                case 2: goto L_0x00ff;
                case 3: goto L_0x00fa;
                case 4: goto L_0x00f5;
                case 5: goto L_0x00f0;
                case 6: goto L_0x00eb;
                case 7: goto L_0x00e6;
                case 8: goto L_0x00e1;
                case 9: goto L_0x00dc;
                default: goto L_0x00db;
            }
        L_0x00db:
            goto L_0x0065
        L_0x00dc:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            goto L_0x010d
        L_0x00e1:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            goto L_0x010d
        L_0x00e6:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            goto L_0x010d
        L_0x00eb:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            goto L_0x010d
        L_0x00f0:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            goto L_0x010d
        L_0x00f5:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            goto L_0x010d
        L_0x00fa:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x010d
        L_0x00ff:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            goto L_0x010d
        L_0x0104:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x010d
        L_0x0109:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r15)
        L_0x010d:
            if (r1 != 0) goto L_0x011e
            java.lang.String r1 = "Unknown Dolby Vision profile string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x0040
        L_0x011e:
            r0 = r2[r5]
            if (r0 != 0) goto L_0x0125
        L_0x0122:
            r2 = 0
            goto L_0x01e3
        L_0x0125:
            int r2 = r0.hashCode()
            switch(r2) {
                case 1537: goto L_0x01d7;
                case 1538: goto L_0x01ca;
                case 1539: goto L_0x01bd;
                case 1540: goto L_0x01b0;
                case 1541: goto L_0x01a3;
                case 1542: goto L_0x0196;
                case 1543: goto L_0x0189;
                case 1544: goto L_0x017c;
                case 1545: goto L_0x016e;
                default: goto L_0x012c;
            }
        L_0x012c:
            switch(r2) {
                case 1567: goto L_0x0160;
                case 1568: goto L_0x0150;
                case 1569: goto L_0x0140;
                case 1570: goto L_0x0130;
                default: goto L_0x012f;
            }
        L_0x012f:
            goto L_0x0122
        L_0x0130:
            java.lang.String r2 = "13"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            r2 = 4096(0x1000, float:5.74E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x01e3
        L_0x0140:
            java.lang.String r2 = "12"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x01e3
        L_0x0150:
            java.lang.String r2 = "11"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            r2 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x01e3
        L_0x0160:
            java.lang.String r2 = "10"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x01e3
        L_0x016e:
            java.lang.String r2 = "09"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            goto L_0x01e3
        L_0x017c:
            java.lang.String r2 = "08"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            goto L_0x01e3
        L_0x0189:
            java.lang.String r2 = "07"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            goto L_0x01e3
        L_0x0196:
            java.lang.String r2 = "06"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            goto L_0x01e3
        L_0x01a3:
            java.lang.String r2 = "05"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            goto L_0x01e3
        L_0x01b0:
            java.lang.String r2 = "04"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            goto L_0x01e3
        L_0x01bd:
            java.lang.String r2 = "03"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            goto L_0x01e3
        L_0x01ca:
            java.lang.String r2 = "02"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            goto L_0x01e3
        L_0x01d7:
            java.lang.String r2 = "01"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0122
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
        L_0x01e3:
            if (r2 != 0) goto L_0x01f4
            java.lang.String r1 = "Unknown Dolby Vision level string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x0040
        L_0x01f4:
            android.util.Pair r3 = new android.util.Pair
            r3.<init>(r1, r2)
        L_0x01f9:
            return r3
        L_0x01fa:
            r4 = 0
            r12 = r2[r4]
            int r4 = r12.hashCode()
            switch(r4) {
                case 3004662: goto L_0x0241;
                case 3006243: goto L_0x0237;
                case 3006244: goto L_0x022d;
                case 3199032: goto L_0x0223;
                case 3214780: goto L_0x0219;
                case 3356560: goto L_0x020f;
                case 3624515: goto L_0x0205;
                default: goto L_0x0204;
            }
        L_0x0204:
            goto L_0x024b
        L_0x0205:
            java.lang.String r4 = "vp09"
            boolean r4 = r12.equals(r4)
            if (r4 == 0) goto L_0x024b
            r4 = 2
            goto L_0x024c
        L_0x020f:
            java.lang.String r4 = "mp4a"
            boolean r4 = r12.equals(r4)
            if (r4 == 0) goto L_0x024b
            r4 = 6
            goto L_0x024c
        L_0x0219:
            java.lang.String r4 = "hvc1"
            boolean r4 = r12.equals(r4)
            if (r4 == 0) goto L_0x024b
            r4 = 4
            goto L_0x024c
        L_0x0223:
            java.lang.String r4 = "hev1"
            boolean r4 = r12.equals(r4)
            if (r4 == 0) goto L_0x024b
            r4 = 3
            goto L_0x024c
        L_0x022d:
            java.lang.String r4 = "avc2"
            boolean r4 = r12.equals(r4)
            if (r4 == 0) goto L_0x024b
            r4 = 1
            goto L_0x024c
        L_0x0237:
            java.lang.String r4 = "avc1"
            boolean r4 = r12.equals(r4)
            if (r4 == 0) goto L_0x024b
            r4 = 0
            goto L_0x024c
        L_0x0241:
            java.lang.String r4 = "av01"
            boolean r4 = r12.equals(r4)
            if (r4 == 0) goto L_0x024b
            r4 = 5
            goto L_0x024c
        L_0x024b:
            r4 = -1
        L_0x024c:
            r12 = 8192(0x2000, float:1.14794E-41)
            r9 = 20
            switch(r4) {
                case 0: goto L_0x071b;
                case 1: goto L_0x071b;
                case 2: goto L_0x063d;
                case 3: goto L_0x03de;
                case 4: goto L_0x03de;
                case 5: goto L_0x02e4;
                case 6: goto L_0x0255;
                default: goto L_0x0253;
            }
        L_0x0253:
            r0 = 0
            return r0
        L_0x0255:
            java.lang.String r0 = r0.zzj
            int r1 = r2.length
            if (r1 == r11) goto L_0x026a
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
        L_0x0267:
            r3 = 0
            goto L_0x02e3
        L_0x026a:
            java.lang.String r1 = "audio/mp4a-latm"
            r3 = r2[r15]     // Catch:{ NumberFormatException -> 0x02d5 }
            int r3 = java.lang.Integer.parseInt(r3, r6)     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r3 = com.google.android.gms.internal.ads.zzbt.zzd(r3)     // Catch:{ NumberFormatException -> 0x02d5 }
            boolean r1 = r1.equals(r3)     // Catch:{ NumberFormatException -> 0x02d5 }
            if (r1 == 0) goto L_0x0267
            r1 = r2[r5]     // Catch:{ NumberFormatException -> 0x02d5 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x02d5 }
            r2 = 17
            if (r1 == r2) goto L_0x02c0
            if (r1 == r9) goto L_0x02bc
            r2 = 23
            if (r1 == r2) goto L_0x02b9
            r2 = 29
            if (r1 == r2) goto L_0x02b6
            r2 = 39
            if (r1 == r2) goto L_0x02b3
            r2 = 42
            if (r1 == r2) goto L_0x02b0
            switch(r1) {
                case 1: goto L_0x02ad;
                case 2: goto L_0x02aa;
                case 3: goto L_0x02a7;
                case 4: goto L_0x02a4;
                case 5: goto L_0x02a1;
                case 6: goto L_0x029e;
                default: goto L_0x029b;
            }     // Catch:{ NumberFormatException -> 0x02d5 }
        L_0x029b:
            r1 = -1
            r6 = -1
            goto L_0x02c3
        L_0x029e:
            r1 = -1
            r6 = 6
            goto L_0x02c3
        L_0x02a1:
            r1 = -1
            r6 = 5
            goto L_0x02c3
        L_0x02a4:
            r1 = -1
            r6 = 4
            goto L_0x02c3
        L_0x02a7:
            r1 = -1
            r6 = 3
            goto L_0x02c3
        L_0x02aa:
            r1 = -1
            r6 = 2
            goto L_0x02c3
        L_0x02ad:
            r1 = -1
            r6 = 1
            goto L_0x02c3
        L_0x02b0:
            r6 = 42
            goto L_0x02c2
        L_0x02b3:
            r6 = 39
            goto L_0x02c2
        L_0x02b6:
            r6 = 29
            goto L_0x02c2
        L_0x02b9:
            r6 = 23
            goto L_0x02c2
        L_0x02bc:
            r1 = -1
            r6 = 20
            goto L_0x02c3
        L_0x02c0:
            r6 = 17
        L_0x02c2:
            r1 = -1
        L_0x02c3:
            if (r6 == r1) goto L_0x0267
            android.util.Pair r1 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ NumberFormatException -> 0x02d5 }
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x02d5 }
            r1.<init>(r2, r3)     // Catch:{ NumberFormatException -> 0x02d5 }
            r3 = r1
            goto L_0x02e3
        L_0x02d5:
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x0267
        L_0x02e3:
            return r3
        L_0x02e4:
            java.lang.String r1 = r0.zzj
            com.google.android.gms.internal.ads.zzq r0 = r0.zzy
            int r4 = r2.length
            if (r4 >= r14) goto L_0x02fb
            java.lang.String r0 = "Ignoring malformed AV1 codec string: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r0 = r0.concat(r1)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
        L_0x02f8:
            r3 = 0
            goto L_0x03dd
        L_0x02fb:
            r4 = r2[r15]     // Catch:{ NumberFormatException -> 0x03ce }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x03ce }
            r9 = r2[r5]     // Catch:{ NumberFormatException -> 0x03ce }
            r6 = 0
            java.lang.String r6 = r9.substring(r6, r5)     // Catch:{ NumberFormatException -> 0x03ce }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x03ce }
            r2 = r2[r11]     // Catch:{ NumberFormatException -> 0x03ce }
            int r1 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x03ce }
            if (r4 == 0) goto L_0x0326
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown AV1 profile: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x02f8
        L_0x0326:
            if (r1 == r3) goto L_0x0351
            r2 = 10
            if (r1 == r2) goto L_0x033e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown AV1 bit depth: "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x02f8
        L_0x033e:
            if (r0 == 0) goto L_0x034f
            byte[] r1 = r0.zze
            if (r1 != 0) goto L_0x034c
            int r0 = r0.zzd
            r1 = 7
            if (r0 == r1) goto L_0x034c
            r1 = 6
            if (r0 != r1) goto L_0x034f
        L_0x034c:
            r2 = 4096(0x1000, float:5.74E-42)
            goto L_0x0352
        L_0x034f:
            r2 = 2
            goto L_0x0352
        L_0x0351:
            r2 = 1
        L_0x0352:
            switch(r6) {
                case 0: goto L_0x03a9;
                case 1: goto L_0x03a7;
                case 2: goto L_0x03a4;
                case 3: goto L_0x03a0;
                case 4: goto L_0x039c;
                case 5: goto L_0x0398;
                case 6: goto L_0x0394;
                case 7: goto L_0x0390;
                case 8: goto L_0x038c;
                case 9: goto L_0x0388;
                case 10: goto L_0x0384;
                case 11: goto L_0x0380;
                case 12: goto L_0x037c;
                case 13: goto L_0x0378;
                case 14: goto L_0x0375;
                case 15: goto L_0x0371;
                case 16: goto L_0x036e;
                case 17: goto L_0x036b;
                case 18: goto L_0x0368;
                case 19: goto L_0x0365;
                case 20: goto L_0x0362;
                case 21: goto L_0x035f;
                case 22: goto L_0x035c;
                case 23: goto L_0x0359;
                default: goto L_0x0355;
            }
        L_0x0355:
            r0 = -1
            r5 = -1
            goto L_0x03ab
        L_0x0359:
            r5 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x03a7
        L_0x035c:
            r5 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x03a7
        L_0x035f:
            r5 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x03a7
        L_0x0362:
            r5 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x03a7
        L_0x0365:
            r5 = 524288(0x80000, float:7.34684E-40)
            goto L_0x03a7
        L_0x0368:
            r5 = 262144(0x40000, float:3.67342E-40)
            goto L_0x03a7
        L_0x036b:
            r5 = 131072(0x20000, float:1.83671E-40)
            goto L_0x03a7
        L_0x036e:
            r5 = 65536(0x10000, float:9.18355E-41)
            goto L_0x03a7
        L_0x0371:
            r5 = 32768(0x8000, float:4.5918E-41)
            goto L_0x03a7
        L_0x0375:
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x03a7
        L_0x0378:
            r0 = -1
            r5 = 8192(0x2000, float:1.14794E-41)
            goto L_0x03ab
        L_0x037c:
            r0 = -1
            r5 = 4096(0x1000, float:5.74E-42)
            goto L_0x03ab
        L_0x0380:
            r0 = -1
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x03ab
        L_0x0384:
            r0 = -1
            r5 = 1024(0x400, float:1.435E-42)
            goto L_0x03ab
        L_0x0388:
            r0 = -1
            r5 = 512(0x200, float:7.175E-43)
            goto L_0x03ab
        L_0x038c:
            r0 = -1
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x03ab
        L_0x0390:
            r0 = -1
            r5 = 128(0x80, float:1.794E-43)
            goto L_0x03ab
        L_0x0394:
            r0 = -1
            r5 = 64
            goto L_0x03ab
        L_0x0398:
            r0 = -1
            r5 = 32
            goto L_0x03ab
        L_0x039c:
            r0 = -1
            r5 = 16
            goto L_0x03ab
        L_0x03a0:
            r0 = -1
            r5 = 8
            goto L_0x03ab
        L_0x03a4:
            r0 = -1
            r5 = 4
            goto L_0x03ab
        L_0x03a7:
            r0 = -1
            goto L_0x03ab
        L_0x03a9:
            r0 = -1
            r5 = 1
        L_0x03ab:
            if (r5 != r0) goto L_0x03c0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown AV1 level: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x02f8
        L_0x03c0:
            android.util.Pair r3 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r3.<init>(r0, r1)
            goto L_0x03dd
        L_0x03ce:
            java.lang.String r0 = "Ignoring malformed AV1 codec string: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r0 = r0.concat(r1)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x02f8
        L_0x03dd:
            return r3
        L_0x03de:
            java.lang.String r0 = r0.zzj
            int r1 = r2.length
            if (r1 >= r14) goto L_0x03f3
            java.lang.String r1 = "Ignoring malformed HEVC codec string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
        L_0x03f0:
            r3 = 0
            goto L_0x063c
        L_0x03f3:
            java.util.regex.Pattern r1 = zzb
            r4 = r2[r15]
            java.util.regex.Matcher r1 = r1.matcher(r4)
            boolean r4 = r1.matches()
            if (r4 != 0) goto L_0x040f
            java.lang.String r1 = "Ignoring malformed HEVC codec string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x03f0
        L_0x040f:
            java.lang.String r0 = r1.group(r15)
            java.lang.String r1 = "1"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x041d
            r0 = 1
            goto L_0x0426
        L_0x041d:
            java.lang.String r1 = "2"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x062d
            r0 = 2
        L_0x0426:
            r1 = r2[r11]
            if (r1 != 0) goto L_0x042d
        L_0x042a:
            r2 = 0
            goto L_0x0612
        L_0x042d:
            int r2 = r1.hashCode()
            switch(r2) {
                case 70821: goto L_0x0551;
                case 70914: goto L_0x0546;
                case 70917: goto L_0x053b;
                case 71007: goto L_0x0530;
                case 71010: goto L_0x0525;
                case 74665: goto L_0x051b;
                case 74758: goto L_0x0511;
                case 74761: goto L_0x0507;
                case 74851: goto L_0x04fd;
                case 74854: goto L_0x04f3;
                case 2193639: goto L_0x04e7;
                case 2193642: goto L_0x04db;
                case 2193732: goto L_0x04cf;
                case 2193735: goto L_0x04c3;
                case 2193738: goto L_0x04b7;
                case 2193825: goto L_0x04ab;
                case 2193828: goto L_0x049f;
                case 2193831: goto L_0x0493;
                case 2312803: goto L_0x0488;
                case 2312806: goto L_0x047d;
                case 2312896: goto L_0x0472;
                case 2312899: goto L_0x0466;
                case 2312902: goto L_0x045a;
                case 2312989: goto L_0x044e;
                case 2312992: goto L_0x0442;
                case 2312995: goto L_0x0436;
                default: goto L_0x0434;
            }
        L_0x0434:
            goto L_0x055c
        L_0x0436:
            java.lang.String r2 = "L186"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 12
            goto L_0x055d
        L_0x0442:
            java.lang.String r2 = "L183"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 11
            goto L_0x055d
        L_0x044e:
            java.lang.String r2 = "L180"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 10
            goto L_0x055d
        L_0x045a:
            java.lang.String r2 = "L156"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 9
            goto L_0x055d
        L_0x0466:
            java.lang.String r2 = "L153"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 8
            goto L_0x055d
        L_0x0472:
            java.lang.String r2 = "L150"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 7
            goto L_0x055d
        L_0x047d:
            java.lang.String r2 = "L123"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 6
            goto L_0x055d
        L_0x0488:
            java.lang.String r2 = "L120"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 5
            goto L_0x055d
        L_0x0493:
            java.lang.String r2 = "H186"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 25
            goto L_0x055d
        L_0x049f:
            java.lang.String r2 = "H183"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 24
            goto L_0x055d
        L_0x04ab:
            java.lang.String r2 = "H180"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 23
            goto L_0x055d
        L_0x04b7:
            java.lang.String r2 = "H156"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 22
            goto L_0x055d
        L_0x04c3:
            java.lang.String r2 = "H153"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 21
            goto L_0x055d
        L_0x04cf:
            java.lang.String r2 = "H150"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 20
            goto L_0x055d
        L_0x04db:
            java.lang.String r2 = "H123"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 19
            goto L_0x055d
        L_0x04e7:
            java.lang.String r2 = "H120"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 18
            goto L_0x055d
        L_0x04f3:
            java.lang.String r2 = "L93"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 4
            goto L_0x055d
        L_0x04fd:
            java.lang.String r2 = "L90"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 3
            goto L_0x055d
        L_0x0507:
            java.lang.String r2 = "L63"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 2
            goto L_0x055d
        L_0x0511:
            java.lang.String r2 = "L60"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 1
            goto L_0x055d
        L_0x051b:
            java.lang.String r2 = "L30"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 0
            goto L_0x055d
        L_0x0525:
            java.lang.String r2 = "H93"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 17
            goto L_0x055d
        L_0x0530:
            java.lang.String r2 = "H90"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 16
            goto L_0x055d
        L_0x053b:
            java.lang.String r2 = "H63"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 15
            goto L_0x055d
        L_0x0546:
            java.lang.String r2 = "H60"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 14
            goto L_0x055d
        L_0x0551:
            java.lang.String r2 = "H30"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x055c
            r6 = 13
            goto L_0x055d
        L_0x055c:
            r6 = -1
        L_0x055d:
            switch(r6) {
                case 0: goto L_0x060e;
                case 1: goto L_0x0609;
                case 2: goto L_0x0602;
                case 3: goto L_0x05fb;
                case 4: goto L_0x05f4;
                case 5: goto L_0x05ed;
                case 6: goto L_0x05e6;
                case 7: goto L_0x05df;
                case 8: goto L_0x05d8;
                case 9: goto L_0x05d1;
                case 10: goto L_0x05ca;
                case 11: goto L_0x05c3;
                case 12: goto L_0x05bc;
                case 13: goto L_0x05b7;
                case 14: goto L_0x05b2;
                case 15: goto L_0x05ad;
                case 16: goto L_0x05a7;
                case 17: goto L_0x05a1;
                case 18: goto L_0x0599;
                case 19: goto L_0x0593;
                case 20: goto L_0x058a;
                case 21: goto L_0x0582;
                case 22: goto L_0x057a;
                case 23: goto L_0x0572;
                case 24: goto L_0x056a;
                case 25: goto L_0x0562;
                default: goto L_0x0560;
            }
        L_0x0560:
            goto L_0x042a
        L_0x0562:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x056a:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x0572:
            r2 = 2097152(0x200000, float:2.938736E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x057a:
            r2 = 524288(0x80000, float:7.34684E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x0582:
            r2 = 131072(0x20000, float:1.83671E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x058a:
            r2 = 32768(0x8000, float:4.5918E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x0593:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            goto L_0x0612
        L_0x0599:
            r4 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            goto L_0x0612
        L_0x05a1:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x0612
        L_0x05a7:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            goto L_0x0612
        L_0x05ad:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            goto L_0x0612
        L_0x05b2:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            goto L_0x0612
        L_0x05b7:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            goto L_0x0612
        L_0x05bc:
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x05c3:
            r2 = 4194304(0x400000, float:5.877472E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x05ca:
            r2 = 1048576(0x100000, float:1.469368E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x05d1:
            r2 = 262144(0x40000, float:3.67342E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x05d8:
            r2 = 65536(0x10000, float:9.18355E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x05df:
            r2 = 16384(0x4000, float:2.2959E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x05e6:
            r6 = 4096(0x1000, float:5.74E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            goto L_0x0612
        L_0x05ed:
            r9 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            goto L_0x0612
        L_0x05f4:
            r16 = 256(0x100, float:3.59E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)
            goto L_0x0612
        L_0x05fb:
            r17 = 64
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            goto L_0x0612
        L_0x0602:
            r2 = 16
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0612
        L_0x0609:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            goto L_0x0612
        L_0x060e:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
        L_0x0612:
            if (r2 != 0) goto L_0x0623
            java.lang.String r0 = "Unknown HEVC level string: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r0 = r0.concat(r1)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x03f0
        L_0x0623:
            android.util.Pair r3 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3.<init>(r0, r2)
            goto L_0x063c
        L_0x062d:
            java.lang.String r1 = "Unknown HEVC profile string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x03f0
        L_0x063c:
            return r3
        L_0x063d:
            r4 = 2048(0x800, float:2.87E-42)
            r6 = 4096(0x1000, float:5.74E-42)
            r16 = 256(0x100, float:3.59E-43)
            r17 = 64
            java.lang.String r0 = r0.zzj
            int r1 = r2.length
            if (r1 >= r11) goto L_0x065a
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
        L_0x0657:
            r3 = 0
            goto L_0x071a
        L_0x065a:
            r1 = r2[r15]     // Catch:{ NumberFormatException -> 0x070b }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x070b }
            r2 = r2[r5]     // Catch:{ NumberFormatException -> 0x070b }
            int r0 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x070b }
            if (r1 == 0) goto L_0x0677
            if (r1 == r15) goto L_0x0675
            if (r1 == r5) goto L_0x0673
            if (r1 == r11) goto L_0x0670
            r2 = -1
            goto L_0x0678
        L_0x0670:
            r2 = 8
            goto L_0x0678
        L_0x0673:
            r2 = 4
            goto L_0x0678
        L_0x0675:
            r2 = 2
            goto L_0x0678
        L_0x0677:
            r2 = 1
        L_0x0678:
            r11 = -1
            if (r2 != r11) goto L_0x068d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown VP9 profile: "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x0657
        L_0x068d:
            r1 = 10
            if (r0 == r1) goto L_0x06e5
            r1 = 11
            if (r0 == r1) goto L_0x06e2
            if (r0 == r9) goto L_0x06df
            r1 = 21
            if (r0 == r1) goto L_0x06dd
            r1 = 30
            if (r0 == r1) goto L_0x06d9
            r1 = 31
            if (r0 == r1) goto L_0x06d5
            r1 = 40
            if (r0 == r1) goto L_0x06d1
            r1 = 41
            if (r0 == r1) goto L_0x06cd
            r1 = 50
            if (r0 == r1) goto L_0x06c9
            r1 = 51
            if (r0 == r1) goto L_0x06c5
            switch(r0) {
                case 60: goto L_0x06c1;
                case 61: goto L_0x06bd;
                case 62: goto L_0x06b9;
                default: goto L_0x06b6;
            }
        L_0x06b6:
            r1 = -1
            r3 = -1
            goto L_0x06e7
        L_0x06b9:
            r1 = -1
            r3 = 8192(0x2000, float:1.14794E-41)
            goto L_0x06e7
        L_0x06bd:
            r1 = -1
            r3 = 4096(0x1000, float:5.74E-42)
            goto L_0x06e7
        L_0x06c1:
            r1 = -1
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x06e7
        L_0x06c5:
            r1 = -1
            r3 = 512(0x200, float:7.175E-43)
            goto L_0x06e7
        L_0x06c9:
            r1 = -1
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x06e7
        L_0x06cd:
            r1 = -1
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x06e7
        L_0x06d1:
            r1 = -1
            r3 = 64
            goto L_0x06e7
        L_0x06d5:
            r1 = -1
            r3 = 32
            goto L_0x06e7
        L_0x06d9:
            r1 = -1
            r3 = 16
            goto L_0x06e7
        L_0x06dd:
            r1 = -1
            goto L_0x06e7
        L_0x06df:
            r1 = -1
            r3 = 4
            goto L_0x06e7
        L_0x06e2:
            r1 = -1
            r3 = 2
            goto L_0x06e7
        L_0x06e5:
            r1 = -1
            r3 = 1
        L_0x06e7:
            if (r3 != r1) goto L_0x06fc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown VP9 level: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x0657
        L_0x06fc:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r0.<init>(r1, r2)
            r3 = r0
            goto L_0x071a
        L_0x070b:
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x0657
        L_0x071a:
            return r3
        L_0x071b:
            r4 = 2048(0x800, float:2.87E-42)
            r6 = 4096(0x1000, float:5.74E-42)
            r9 = 1024(0x400, float:1.435E-42)
            r16 = 256(0x100, float:3.59E-43)
            r17 = 64
            java.lang.String r0 = r0.zzj
            int r3 = r2.length
            if (r3 >= r5) goto L_0x073a
            java.lang.String r1 = "Ignoring malformed AVC codec string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
        L_0x0737:
            r3 = 0
            goto L_0x0838
        L_0x073a:
            r18 = r2[r15]     // Catch:{ NumberFormatException -> 0x0829 }
            int r4 = r18.length()     // Catch:{ NumberFormatException -> 0x0829 }
            r6 = 6
            if (r4 != r6) goto L_0x075b
            r1 = r2[r15]     // Catch:{ NumberFormatException -> 0x0829 }
            r3 = 0
            java.lang.String r1 = r1.substring(r3, r5)     // Catch:{ NumberFormatException -> 0x0829 }
            r4 = 16
            int r1 = java.lang.Integer.parseInt(r1, r4)     // Catch:{ NumberFormatException -> 0x0829 }
            r2 = r2[r15]     // Catch:{ NumberFormatException -> 0x0829 }
            java.lang.String r2 = r2.substring(r14)     // Catch:{ NumberFormatException -> 0x0829 }
            int r0 = java.lang.Integer.parseInt(r2, r4)     // Catch:{ NumberFormatException -> 0x0829 }
            goto L_0x076b
        L_0x075b:
            r4 = 16
            if (r3 < r11) goto L_0x0818
            r1 = r2[r15]     // Catch:{ NumberFormatException -> 0x0829 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0829 }
            r2 = r2[r5]     // Catch:{ NumberFormatException -> 0x0829 }
            int r0 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0829 }
        L_0x076b:
            r2 = 66
            if (r1 == r2) goto L_0x079f
            r2 = 77
            if (r1 == r2) goto L_0x079d
            r2 = 88
            if (r1 == r2) goto L_0x079a
            r2 = 100
            if (r1 == r2) goto L_0x0796
            r2 = 110(0x6e, float:1.54E-43)
            if (r1 == r2) goto L_0x0792
            r2 = 122(0x7a, float:1.71E-43)
            if (r1 == r2) goto L_0x078e
            r2 = 244(0xf4, float:3.42E-43)
            if (r1 == r2) goto L_0x078a
            r2 = -1
            r5 = -1
            goto L_0x07a1
        L_0x078a:
            r2 = -1
            r5 = 64
            goto L_0x07a1
        L_0x078e:
            r2 = -1
            r5 = 32
            goto L_0x07a1
        L_0x0792:
            r2 = -1
            r5 = 16
            goto L_0x07a1
        L_0x0796:
            r2 = -1
            r5 = 8
            goto L_0x07a1
        L_0x079a:
            r2 = -1
            r5 = 4
            goto L_0x07a1
        L_0x079d:
            r2 = -1
            goto L_0x07a1
        L_0x079f:
            r2 = -1
            r5 = 1
        L_0x07a1:
            if (r5 != r2) goto L_0x07b5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown AVC profile: "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x0737
        L_0x07b5:
            switch(r0) {
                case 10: goto L_0x07f3;
                case 11: goto L_0x07f1;
                case 12: goto L_0x07ee;
                case 13: goto L_0x07eb;
                default: goto L_0x07b8;
            }
        L_0x07b8:
            switch(r0) {
                case 20: goto L_0x07e8;
                case 21: goto L_0x07e5;
                case 22: goto L_0x07e2;
                default: goto L_0x07bb;
            }
        L_0x07bb:
            switch(r0) {
                case 30: goto L_0x07df;
                case 31: goto L_0x07dc;
                case 32: goto L_0x07d9;
                default: goto L_0x07be;
            }
        L_0x07be:
            switch(r0) {
                case 40: goto L_0x07d6;
                case 41: goto L_0x07d3;
                case 42: goto L_0x07d0;
                default: goto L_0x07c1;
            }
        L_0x07c1:
            switch(r0) {
                case 50: goto L_0x07cd;
                case 51: goto L_0x07c9;
                case 52: goto L_0x07c6;
                default: goto L_0x07c4;
            }
        L_0x07c4:
            r1 = -1
            goto L_0x07f4
        L_0x07c6:
            r1 = 65536(0x10000, float:9.18355E-41)
            goto L_0x07f4
        L_0x07c9:
            r1 = 32768(0x8000, float:4.5918E-41)
            goto L_0x07f4
        L_0x07cd:
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x07f4
        L_0x07d0:
            r1 = 8192(0x2000, float:1.14794E-41)
            goto L_0x07f4
        L_0x07d3:
            r1 = 4096(0x1000, float:5.74E-42)
            goto L_0x07f4
        L_0x07d6:
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x07f4
        L_0x07d9:
            r1 = 1024(0x400, float:1.435E-42)
            goto L_0x07f4
        L_0x07dc:
            r1 = 512(0x200, float:7.175E-43)
            goto L_0x07f4
        L_0x07df:
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x07f4
        L_0x07e2:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x07f4
        L_0x07e5:
            r1 = 64
            goto L_0x07f4
        L_0x07e8:
            r1 = 32
            goto L_0x07f4
        L_0x07eb:
            r1 = 16
            goto L_0x07f4
        L_0x07ee:
            r1 = 8
            goto L_0x07f4
        L_0x07f1:
            r1 = 4
            goto L_0x07f4
        L_0x07f3:
            r1 = 1
        L_0x07f4:
            r2 = -1
            if (r1 != r2) goto L_0x080a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown AVC level: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x0737
        L_0x080a:
            android.util.Pair r3 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.<init>(r0, r1)
            goto L_0x0838
        L_0x0818:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0829 }
            r2.<init>(r1)     // Catch:{ NumberFormatException -> 0x0829 }
            r2.append(r0)     // Catch:{ NumberFormatException -> 0x0829 }
            java.lang.String r1 = r2.toString()     // Catch:{ NumberFormatException -> 0x0829 }
            com.google.android.gms.internal.ads.zzdw.zze(r7, r1)     // Catch:{ NumberFormatException -> 0x0829 }
            goto L_0x0737
        L_0x0829:
            java.lang.String r1 = "Ignoring malformed AVC codec string: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzdw.zze(r7, r0)
            goto L_0x0737
        L_0x0838:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrf.zzb(com.google.android.gms.internal.ads.zzaf):android.util.Pair");
    }

    public static zzqn zzc(String str, boolean z, boolean z2) throws zzqz {
        List zzf = zzf(str, false, false);
        if (zzf.isEmpty()) {
            return null;
        }
        return (zzqn) zzf.get(0);
    }

    public static zzqn zzd() throws zzqz {
        return zzc("audio/raw", false, false);
    }

    public static String zze(zzaf zzaf) {
        Pair zzb2;
        if ("audio/eac3-joc".equals(zzaf.zzm)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(zzaf.zzm) || (zzb2 = zzb(zzaf)) == null) {
            return null;
        }
        int intValue = ((Integer) zzb2.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return "video/hevc";
        }
        if (intValue == 512) {
            return "video/avc";
        }
        return null;
    }

    public static synchronized List zzf(String str, boolean z, boolean z2) throws zzqz {
        zzra zzra;
        int i;
        String str2 = str;
        boolean z3 = z;
        boolean z4 = z2;
        synchronized (zzrf.class) {
            zzqx zzqx = new zzqx(str2, z3, z4);
            HashMap hashMap = zzc;
            List list = (List) hashMap.get(zzqx);
            if (list != null) {
                return list;
            }
            if (zzen.zza >= 21) {
                zzra = new zzrd(z3, z4);
            } else {
                zzra = new zzrc((zzrb) null);
            }
            ArrayList zzh = zzh(zzqx, zzra);
            if (z3 && zzh.isEmpty() && (i = zzen.zza) >= 21 && i <= 23) {
                zzh = zzh(zzqx, new zzrc((zzrb) null));
                if (!zzh.isEmpty()) {
                    String str3 = ((zzqn) zzh.get(0)).zza;
                    zzdw.zze("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str2 + ". Assuming: " + str3);
                }
            }
            if ("audio/raw".equals(str2)) {
                if (zzen.zza < 26 && zzen.zzb.equals("R9") && zzh.size() == 1 && ((zzqn) zzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    zzh.add(zzqn.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
                }
                zzi(zzh, zzqv.zza);
            }
            if (zzen.zza < 21 && zzh.size() > 1) {
                String str4 = ((zzqn) zzh.get(0)).zza;
                if ("OMX.SEC.mp3.dec".equals(str4) || "OMX.SEC.MP3.Decoder".equals(str4) || "OMX.brcm.audio.mp3.decoder".equals(str4)) {
                    zzi(zzh, zzqw.zza);
                }
            }
            if (zzen.zza < 32 && zzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzqn) zzh.get(0)).zza)) {
                zzh.add((zzqn) zzh.remove(0));
            }
            zzfvn zzm = zzfvn.zzm(zzh);
            hashMap.put(zzqx, zzm);
            return zzm;
        }
    }

    public static List zzg(List list, zzaf zzaf) {
        ArrayList arrayList = new ArrayList(list);
        zzi(arrayList, new zzqt(zzaf));
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x024e, code lost:
        if (r2 != r8) goto L_0x0250;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0254, code lost:
        if (r1.zzb == false) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0256, code lost:
        r22 = r12;
        r18 = r13;
        r20 = r14;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (r12.endsWith(".secure") == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        r6.add(com.google.android.gms.internal.ads.zzqn.zzc(r12, r15, r5, r10, r11, r21, r0, false, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0272, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0273, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0093, code lost:
        if ("OMX.Exynos.AAC.Decoder".equals(r12) == false) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00eb, code lost:
        if ("SCV31".equals(com.google.android.gms.internal.ads.zzen.zzb) == false) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0133, code lost:
        if (com.google.android.gms.internal.ads.zzen.zzb.startsWith("t0") != false) goto L_0x002c;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x02c1 A[SYNTHETIC, Splitter:B:186:0x02c1] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x02e1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList zzh(com.google.android.gms.internal.ads.zzqx r23, com.google.android.gms.internal.ads.zzra r24) throws com.google.android.gms.internal.ads.zzqz {
        /*
            r1 = r23
            r2 = r24
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x030f }
            r6.<init>()     // Catch:{ Exception -> 0x030f }
            java.lang.String r15 = r1.zza     // Catch:{ Exception -> 0x030f }
            int r14 = r24.zza()     // Catch:{ Exception -> 0x030f }
            boolean r16 = r24.zze()     // Catch:{ Exception -> 0x030f }
            r17 = 0
            r13 = 0
        L_0x001a:
            if (r13 >= r14) goto L_0x030e
            android.media.MediaCodecInfo r0 = r2.zzb(r13)     // Catch:{ Exception -> 0x030f }
            int r7 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x030f }
            r8 = 29
            if (r7 < r8) goto L_0x0033
            boolean r7 = r0.isAlias()     // Catch:{ Exception -> 0x030f }
            if (r7 == 0) goto L_0x0033
        L_0x002c:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x0303
        L_0x0033:
            java.lang.String r12 = r0.getName()     // Catch:{ Exception -> 0x030f }
            boolean r7 = r0.isEncoder()     // Catch:{ Exception -> 0x030f }
            if (r7 != 0) goto L_0x002c
            java.lang.String r7 = ".secure"
            if (r16 != 0) goto L_0x0047
            boolean r9 = r12.endsWith(r7)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
        L_0x0047:
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x030f }
            r10 = 21
            if (r9 >= r10) goto L_0x007d
            java.lang.String r9 = "CIPAACDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "CIPMP3Decoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "CIPVorbisDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "CIPAMRNBDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "AACDecoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "MP3Decoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
        L_0x007d:
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x030f }
            r10 = 24
            java.lang.String r11 = "samsung"
            if (r9 >= r10) goto L_0x00ed
            java.lang.String r9 = "OMX.SEC.aac.dec"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x0095
            java.lang.String r9 = "OMX.Exynos.AAC.Decoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r9 == 0) goto L_0x00ed
        L_0x0095:
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzc     // Catch:{ Exception -> 0x030f }
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x030f }
            if (r9 == 0) goto L_0x00ed
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            java.lang.String r10 = "zeroflte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            java.lang.String r10 = "zerolte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            java.lang.String r10 = "zenlte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "SC-05G"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "marinelteatt"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "404SC"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "SC-04G"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = "SCV31"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
        L_0x00ed:
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x030f }
            java.lang.String r10 = "jflte"
            r5 = 19
            if (r9 > r5) goto L_0x0135
            java.lang.String r9 = "OMX.SEC.vp8.dec"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r9 == 0) goto L_0x0135
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzc     // Catch:{ Exception -> 0x030f }
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x030f }
            if (r9 == 0) goto L_0x0135
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            java.lang.String r11 = "d2"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            java.lang.String r11 = "serrano"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            java.lang.String r11 = "santos"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
            java.lang.String r9 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            java.lang.String r11 = "t0"
            boolean r9 = r9.startsWith(r11)     // Catch:{ Exception -> 0x030f }
            if (r9 != 0) goto L_0x002c
        L_0x0135:
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x030f }
            if (r9 > r5) goto L_0x0149
            java.lang.String r5 = com.google.android.gms.internal.ads.zzen.zzb     // Catch:{ Exception -> 0x030f }
            boolean r5 = r5.startsWith(r10)     // Catch:{ Exception -> 0x030f }
            if (r5 == 0) goto L_0x0149
            java.lang.String r5 = "OMX.qcom.video.decoder.vp8"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r5 != 0) goto L_0x002c
        L_0x0149:
            int r5 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x030f }
            r11 = 23
            if (r5 > r11) goto L_0x015f
            java.lang.String r5 = "audio/eac3-joc"
            boolean r5 = r5.equals(r15)     // Catch:{ Exception -> 0x030f }
            if (r5 == 0) goto L_0x015f
            java.lang.String r5 = "OMX.MTK.AUDIO.DECODER.DSPAC3"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r5 != 0) goto L_0x002c
        L_0x015f:
            java.lang.String[] r5 = r0.getSupportedTypes()     // Catch:{ Exception -> 0x030f }
            int r9 = r5.length     // Catch:{ Exception -> 0x030f }
            r10 = 0
        L_0x0165:
            if (r10 >= r9) goto L_0x0176
            r11 = r5[r10]     // Catch:{ Exception -> 0x030f }
            boolean r19 = r11.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x030f }
            if (r19 == 0) goto L_0x0171
        L_0x016f:
            r5 = r11
            goto L_0x01d6
        L_0x0171:
            int r10 = r10 + 1
            r11 = 23
            goto L_0x0165
        L_0x0176:
            java.lang.String r5 = "video/dolby-vision"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x030f }
            if (r5 == 0) goto L_0x019c
            java.lang.String r5 = "OMX.MS.HEVCDV.Decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r5 == 0) goto L_0x0189
            java.lang.String r11 = "video/hevcdv"
            goto L_0x016f
        L_0x0189:
            java.lang.String r5 = "OMX.RTK.video.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r5 != 0) goto L_0x0199
            java.lang.String r5 = "OMX.realtek.video.decoder.tunneled"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r5 == 0) goto L_0x01d5
        L_0x0199:
            java.lang.String r11 = "video/dv_hevc"
            goto L_0x016f
        L_0x019c:
            java.lang.String r5 = "audio/alac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x030f }
            if (r5 == 0) goto L_0x01af
            java.lang.String r5 = "OMX.lge.alac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r5 == 0) goto L_0x01af
            java.lang.String r11 = "audio/x-lg-alac"
            goto L_0x016f
        L_0x01af:
            java.lang.String r5 = "audio/flac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x030f }
            if (r5 == 0) goto L_0x01c2
            java.lang.String r5 = "OMX.lge.flac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r5 == 0) goto L_0x01c2
            java.lang.String r11 = "audio/x-lg-flac"
            goto L_0x016f
        L_0x01c2:
            java.lang.String r5 = "audio/ac3"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x030f }
            if (r5 == 0) goto L_0x01d5
            java.lang.String r5 = "OMX.lge.ac3.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x030f }
            if (r5 == 0) goto L_0x01d5
            java.lang.String r11 = "audio/lg-ac3"
            goto L_0x016f
        L_0x01d5:
            r5 = 0
        L_0x01d6:
            if (r5 == 0) goto L_0x002c
            android.media.MediaCodecInfo$CodecCapabilities r10 = r0.getCapabilitiesForType(r5)     // Catch:{ Exception -> 0x02b2 }
            boolean r9 = r2.zzd(r4, r5, r10)     // Catch:{ Exception -> 0x02b2 }
            boolean r11 = r2.zzc(r4, r5, r10)     // Catch:{ Exception -> 0x02b2 }
            boolean r8 = r1.zzc     // Catch:{ Exception -> 0x02b2 }
            if (r8 != 0) goto L_0x01eb
            if (r11 != 0) goto L_0x002c
            goto L_0x01ef
        L_0x01eb:
            if (r9 != 0) goto L_0x01ef
            goto L_0x002c
        L_0x01ef:
            boolean r8 = r2.zzd(r3, r5, r10)     // Catch:{ Exception -> 0x02b2 }
            boolean r9 = r2.zzc(r3, r5, r10)     // Catch:{ Exception -> 0x02b2 }
            boolean r11 = r1.zzb     // Catch:{ Exception -> 0x02b2 }
            r20 = 1
            if (r11 != 0) goto L_0x0200
            if (r9 != 0) goto L_0x002c
            goto L_0x0203
        L_0x0200:
            if (r8 == 0) goto L_0x002c
            r8 = 1
        L_0x0203:
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x02b2 }
            r11 = 29
            if (r9 < r11) goto L_0x020f
            boolean r9 = r0.isHardwareAccelerated()     // Catch:{ Exception -> 0x02b2 }
            r11 = r9
            goto L_0x0218
        L_0x020f:
            boolean r9 = zzj(r0, r15)     // Catch:{ Exception -> 0x02b2 }
            if (r9 != 0) goto L_0x0217
            r11 = 1
            goto L_0x0218
        L_0x0217:
            r11 = 0
        L_0x0218:
            boolean r21 = zzj(r0, r15)     // Catch:{ Exception -> 0x02b2 }
            int r9 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x02b2 }
            r2 = 29
            if (r9 < r2) goto L_0x0227
            boolean r0 = r0.isVendor()     // Catch:{ Exception -> 0x02b2 }
            goto L_0x024a
        L_0x0227:
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x02b2 }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfse.zza(r0)     // Catch:{ Exception -> 0x02b2 }
            java.lang.String r2 = "omx.google."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x02b2 }
            if (r2 != 0) goto L_0x0249
            java.lang.String r2 = "c2.android."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x02b2 }
            if (r2 != 0) goto L_0x0249
            java.lang.String r2 = "c2.google."
            boolean r0 = r0.startsWith(r2)     // Catch:{ Exception -> 0x02b2 }
            if (r0 != 0) goto L_0x0249
            r0 = 1
            goto L_0x024a
        L_0x0249:
            r0 = 0
        L_0x024a:
            if (r16 == 0) goto L_0x0250
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x02b2 }
            if (r2 == r8) goto L_0x0256
        L_0x0250:
            if (r16 != 0) goto L_0x027e
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x0276 }
            if (r2 != 0) goto L_0x027e
        L_0x0256:
            r2 = 0
            r19 = 0
            r7 = r12
            r8 = r15
            r9 = r5
            r22 = r12
            r12 = r21
            r18 = r13
            r13 = r0
            r20 = r14
            r14 = r2
            r2 = r15
            r15 = r19
            com.google.android.gms.internal.ads.zzqn r0 = com.google.android.gms.internal.ads.zzqn.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0272 }
            r6.add(r0)     // Catch:{ Exception -> 0x0272 }
            goto L_0x0303
        L_0x0272:
            r0 = move-exception
            r1 = r22
            goto L_0x02b9
        L_0x0276:
            r0 = move-exception
            r18 = r13
            r20 = r14
            r2 = r15
            r1 = r12
            goto L_0x02b9
        L_0x027e:
            r22 = r12
            r18 = r13
            r20 = r14
            r2 = r15
            if (r16 != 0) goto L_0x0303
            if (r8 == 0) goto L_0x0303
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0272 }
            r8.<init>()     // Catch:{ Exception -> 0x0272 }
            r15 = r22
            r8.append(r15)     // Catch:{ Exception -> 0x02af }
            r8.append(r7)     // Catch:{ Exception -> 0x02af }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x02af }
            r14 = 0
            r19 = 1
            r8 = r2
            r9 = r5
            r12 = r21
            r13 = r0
            r1 = r15
            r15 = r19
            com.google.android.gms.internal.ads.zzqn r0 = com.google.android.gms.internal.ads.zzqn.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x02ad }
            r6.add(r0)     // Catch:{ Exception -> 0x02ad }
            return r6
        L_0x02ad:
            r0 = move-exception
            goto L_0x02b9
        L_0x02af:
            r0 = move-exception
            r1 = r15
            goto L_0x02b9
        L_0x02b2:
            r0 = move-exception
            r1 = r12
            r18 = r13
            r20 = r14
            r2 = r15
        L_0x02b9:
            int r7 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x030f }
            java.lang.String r8 = "MediaCodecUtil"
            r9 = 23
            if (r7 > r9) goto L_0x02e1
            boolean r7 = r6.isEmpty()     // Catch:{ Exception -> 0x030f }
            if (r7 != 0) goto L_0x02e1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x030f }
            r0.<init>()     // Catch:{ Exception -> 0x030f }
            java.lang.String r5 = "Skipping codec "
            r0.append(r5)     // Catch:{ Exception -> 0x030f }
            r0.append(r1)     // Catch:{ Exception -> 0x030f }
            java.lang.String r1 = " (failed to query capabilities)"
            r0.append(r1)     // Catch:{ Exception -> 0x030f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x030f }
            com.google.android.gms.internal.ads.zzdw.zzb(r8, r0)     // Catch:{ Exception -> 0x030f }
            goto L_0x0303
        L_0x02e1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x030f }
            r2.<init>()     // Catch:{ Exception -> 0x030f }
            java.lang.String r3 = "Failed to query codec "
            r2.append(r3)     // Catch:{ Exception -> 0x030f }
            r2.append(r1)     // Catch:{ Exception -> 0x030f }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x030f }
            r2.append(r5)     // Catch:{ Exception -> 0x030f }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x030f }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x030f }
            com.google.android.gms.internal.ads.zzdw.zzb(r8, r1)     // Catch:{ Exception -> 0x030f }
            throw r0     // Catch:{ Exception -> 0x030f }
        L_0x0303:
            int r13 = r18 + 1
            r1 = r23
            r15 = r2
            r14 = r20
            r2 = r24
            goto L_0x001a
        L_0x030e:
            return r6
        L_0x030f:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzqz r1 = new com.google.android.gms.internal.ads.zzqz
            r2 = 0
            r1.<init>(r0, r2)
            goto L_0x0318
        L_0x0317:
            throw r1
        L_0x0318:
            goto L_0x0317
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrf.zzh(com.google.android.gms.internal.ads.zzqx, com.google.android.gms.internal.ads.zzra):java.util.ArrayList");
    }

    private static void zzi(List list, zzre zzre) {
        Collections.sort(list, new zzqu(zzre));
    }

    private static boolean zzj(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzen.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzbt.zzg(str)) {
            return true;
        }
        String zza2 = zzfse.zza(mediaCodecInfo.getName());
        if (zza2.startsWith("arc.")) {
            return false;
        }
        if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google.")) {
            return true;
        }
        if (zza2.startsWith("omx.") || zza2.startsWith("c2.")) {
            return false;
        }
        return true;
    }
}
