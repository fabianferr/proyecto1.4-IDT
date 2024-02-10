package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzavq {
    public float zzA = -1.0f;
    public float zzB = -1.0f;
    public float zzC = -1.0f;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public int zzG = 1;
    public int zzH = -1;
    public int zzI = 8000;
    public long zzJ = 0;
    public long zzK = 0;
    public boolean zzL;
    public boolean zzM = true;
    public zzavi zzN;
    public int zzO;
    /* access modifiers changed from: private */
    public String zzP = "eng";
    public String zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public boolean zze;
    public byte[] zzf;
    public zzavh zzg;
    public byte[] zzh;
    public zzauv zzi;
    public int zzj = -1;
    public int zzk = -1;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = 0;
    public byte[] zzo = null;
    public int zzp = -1;
    public boolean zzq = false;
    public int zzr = -1;
    public int zzs = -1;
    public int zzt = -1;
    public int zzu = 1000;
    public int zzv = 200;
    public float zzw = -1.0f;
    public float zzx = -1.0f;
    public float zzy = -1.0f;
    public float zzz = -1.0f;

    private zzavq() {
    }

    /* synthetic */ zzavq(zzavp zzavp) {
    }

    private static List zzc(zzbak zzbak) throws zzasz {
        try {
            zzbak.zzw(16);
            if (zzbak.zzk() != 826496599) {
                return null;
            }
            int zzc2 = zzbak.zzc() + 20;
            byte[] bArr = zzbak.zza;
            while (true) {
                int length = bArr.length;
                if (zzc2 >= length - 4) {
                    throw new zzasz("Failed to find FourCC VC1 initialization data");
                } else if (bArr[zzc2] == 0 && bArr[zzc2 + 1] == 0 && bArr[zzc2 + 2] == 1 && bArr[zzc2 + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, zzc2, length));
                } else {
                    zzc2++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzasz("Error parsing FourCC VC1 codec private");
        }
    }

    private static List zzd(byte[] bArr) throws zzasz {
        byte b;
        byte b2;
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (true) {
                    b = bArr[i];
                    if (b != -1) {
                        break;
                    }
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + b;
                int i5 = 0;
                while (true) {
                    b2 = bArr[i3];
                    if (b2 != -1) {
                        break;
                    }
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + b2;
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            int length = bArr.length - i9;
                            byte[] bArr3 = new byte[length];
                            System.arraycopy(bArr, i9, bArr3, 0, length);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzasz("Error parsing vorbis codec private");
                    }
                    throw new zzasz("Error parsing vorbis codec private");
                }
                throw new zzasz("Error parsing vorbis codec private");
            }
            throw new zzasz("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzasz("Error parsing vorbis codec private");
        }
    }

    private static boolean zze(zzbak zzbak) throws zzasz {
        try {
            int zzf2 = zzbak.zzf();
            if (zzf2 == 1) {
                return true;
            }
            if (zzf2 == 65534) {
                zzbak.zzv(24);
                return zzbak.zzl() == zzavr.zzd.getMostSignificantBits() && zzbak.zzl() == zzavr.zzd.getLeastSignificantBits();
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzasz("Error parsing MS/ACM codec private");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01f3, code lost:
        r11 = "audio/x-unknown";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x021a, code lost:
        r1 = null;
        r27 = -1;
        r32 = 4096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02c3, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02db, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02dd, code lost:
        r27 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02df, code lost:
        r32 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02e1, code lost:
        r2 = r0.zzM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02e5, code lost:
        if (true == r0.zzL) goto L_0x02e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02e7, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02e9, code lost:
        r3 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02ea, code lost:
        r2 = r2 | r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02ef, code lost:
        if (com.google.android.gms.internal.ads.zzbah.zza(r11) == false) goto L_0x031e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02f1, code lost:
        r1 = com.google.android.gms.internal.ads.zzasw.zzh(java.lang.Integer.toString(r45), r11, (java.lang.String) null, -1, r32, r0.zzG, r0.zzI, r27, -1, -1, r1, r0.zzi, r2 ? 1 : 0, r0.zzP, (com.google.android.gms.internal.ads.zzaxh) null);
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0322, code lost:
        if (com.google.android.gms.internal.ads.zzbah.zzb(r11) == false) goto L_0x044f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0326, code lost:
        if (r0.zzn != 0) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0328, code lost:
        r2 = r0.zzl;
        r3 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x032b, code lost:
        if (r2 != -1) goto L_0x032f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x032d, code lost:
        r2 = r0.zzj;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x032f, code lost:
        r0.zzl = r2;
        r2 = r0.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0333, code lost:
        if (r2 != -1) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0335, code lost:
        r2 = r0.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0337, code lost:
        r0.zzm = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x033a, code lost:
        r3 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x033b, code lost:
        r2 = r0.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x033f, code lost:
        if (r2 == r3) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0341, code lost:
        r5 = r0.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0343, code lost:
        if (r5 == r3) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0345, code lost:
        r38 = ((float) (r0.zzk * r2)) / ((float) (r0.zzj * r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0353, code lost:
        r38 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0357, code lost:
        if (r0.zzq == false) goto L_0x0424;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x035d, code lost:
        if (r0.zzw == -1.0f) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0363, code lost:
        if (r0.zzx == -1.0f) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0369, code lost:
        if (r0.zzy == -1.0f) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x036f, code lost:
        if (r0.zzz == -1.0f) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0375, code lost:
        if (r0.zzA == -1.0f) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x037b, code lost:
        if (r0.zzB == -1.0f) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0381, code lost:
        if (r0.zzC == -1.0f) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0387, code lost:
        if (r0.zzD == -1.0f) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x038d, code lost:
        if (r0.zzE == -1.0f) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0393, code lost:
        if (r0.zzF != -1.0f) goto L_0x0397;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0397, code lost:
        r2 = new byte[25];
        r3 = java.nio.ByteBuffer.wrap(r2);
        r3.put((byte) 0);
        r3.putShort((short) ((int) ((r0.zzw * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzx * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzy * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzz * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzA * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzB * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzC * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzD * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) (r0.zzE + 0.5f)));
        r3.putShort((short) ((int) (r0.zzF + 0.5f)));
        r3.putShort((short) r0.zzu);
        r3.putShort((short) r0.zzv);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0414, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0416, code lost:
        r41 = new com.google.android.gms.internal.ads.zzbau(r0.zzr, r0.zzt, r0.zzs, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0424, code lost:
        r41 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0426, code lost:
        r1 = com.google.android.gms.internal.ads.zzasw.zzl(java.lang.Integer.toString(r45), r11, (java.lang.String) null, -1, r32, r0.zzj, r0.zzk, -1.0f, r1, -1, r38, r0.zzo, r0.zzp, r41, r0.zzi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0453, code lost:
        if ("application/x-subrip".equals(r11) == false) goto L_0x047a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0455, code lost:
        r1 = com.google.android.gms.internal.ads.zzasw.zzk(java.lang.Integer.toString(r45), r11, (java.lang.String) null, -1, r2 ? 1 : 0, r0.zzP, -1, r0.zzi, Long.MAX_VALUE, java.util.Collections.emptyList());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0478, code lost:
        r6 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x047e, code lost:
        if ("application/vobsub".equals(r11) != false) goto L_0x0495;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0484, code lost:
        if ("application/pgs".equals(r11) != false) goto L_0x0495;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x048a, code lost:
        if ("application/dvbsubs".equals(r11) == false) goto L_0x048d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0494, code lost:
        throw new com.google.android.gms.internal.ads.zzasz("Unexpected MIME type.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0495, code lost:
        r1 = com.google.android.gms.internal.ads.zzasw.zzi(java.lang.Integer.toString(r45), r11, (java.lang.String) null, -1, r1, r0.zzP, r0.zzi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x04ae, code lost:
        r2 = r44.zzbi(r0.zzb, r6);
        r0.zzN = r2;
        r2.zza(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04bb, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01be, code lost:
        r27 = r1;
        r1 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.internal.ads.zzava r44, int r45) throws com.google.android.gms.internal.ads.zzasz {
        /*
            r43 = this;
            r0 = r43
            java.lang.String r1 = r0.zza
            int r2 = r1.hashCode()
            r4 = 4
            r5 = 8
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = 3
            switch(r2) {
                case -2095576542: goto L_0x0149;
                case -2095575984: goto L_0x013f;
                case -1985379776: goto L_0x0134;
                case -1784763192: goto L_0x0129;
                case -1730367663: goto L_0x011e;
                case -1482641358: goto L_0x0113;
                case -1482641357: goto L_0x0108;
                case -1373388978: goto L_0x00fd;
                case -933872740: goto L_0x00f2;
                case -538363189: goto L_0x00e7;
                case -538363109: goto L_0x00dc;
                case -425012669: goto L_0x00d0;
                case -356037306: goto L_0x00c4;
                case 62923557: goto L_0x00b8;
                case 62923603: goto L_0x00ac;
                case 62927045: goto L_0x00a0;
                case 82338133: goto L_0x0095;
                case 82338134: goto L_0x008a;
                case 99146302: goto L_0x007e;
                case 444813526: goto L_0x0072;
                case 542569478: goto L_0x0066;
                case 725957860: goto L_0x005a;
                case 855502857: goto L_0x004f;
                case 1422270023: goto L_0x0043;
                case 1809237540: goto L_0x0038;
                case 1950749482: goto L_0x002c;
                case 1950789798: goto L_0x0020;
                case 1951062397: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0153
        L_0x0014:
            java.lang.String r2 = "A_OPUS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 11
            goto L_0x0154
        L_0x0020:
            java.lang.String r2 = "A_FLAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 21
            goto L_0x0154
        L_0x002c:
            java.lang.String r2 = "A_EAC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 16
            goto L_0x0154
        L_0x0038:
            java.lang.String r2 = "V_MPEG2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 2
            goto L_0x0154
        L_0x0043:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 24
            goto L_0x0154
        L_0x004f:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 7
            goto L_0x0154
        L_0x005a:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 23
            goto L_0x0154
        L_0x0066:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 19
            goto L_0x0154
        L_0x0072:
            java.lang.String r2 = "V_THEORA"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 9
            goto L_0x0154
        L_0x007e:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 26
            goto L_0x0154
        L_0x008a:
            java.lang.String r2 = "V_VP9"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 1
            goto L_0x0154
        L_0x0095:
            java.lang.String r2 = "V_VP8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 0
            goto L_0x0154
        L_0x00a0:
            java.lang.String r2 = "A_DTS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 18
            goto L_0x0154
        L_0x00ac:
            java.lang.String r2 = "A_AC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 15
            goto L_0x0154
        L_0x00b8:
            java.lang.String r2 = "A_AAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 12
            goto L_0x0154
        L_0x00c4:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 20
            goto L_0x0154
        L_0x00d0:
            java.lang.String r2 = "S_VOBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 25
            goto L_0x0154
        L_0x00dc:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 6
            goto L_0x0154
        L_0x00e7:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 4
            goto L_0x0154
        L_0x00f2:
            java.lang.String r2 = "S_DVBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 27
            goto L_0x0154
        L_0x00fd:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 8
            goto L_0x0154
        L_0x0108:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 14
            goto L_0x0154
        L_0x0113:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 13
            goto L_0x0154
        L_0x011e:
            java.lang.String r2 = "A_VORBIS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 10
            goto L_0x0154
        L_0x0129:
            java.lang.String r2 = "A_TRUEHD"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 17
            goto L_0x0154
        L_0x0134:
            java.lang.String r2 = "A_MS/ACM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 22
            goto L_0x0154
        L_0x013f:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 3
            goto L_0x0154
        L_0x0149:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0153
            r1 = 5
            goto L_0x0154
        L_0x0153:
            r1 = -1
        L_0x0154:
            java.lang.String r2 = "Unsupported PCM bit depth: "
            java.lang.String r11 = "audio/raw"
            java.lang.String r12 = "application/dvbsubs"
            java.lang.String r13 = "application/pgs"
            java.lang.String r14 = "application/vobsub"
            java.lang.String r15 = "application/x-subrip"
            r16 = 4096(0x1000, float:5.74E-42)
            java.lang.String r17 = "video/x-unknown"
            java.lang.String r18 = "audio/x-unknown"
            java.lang.String r3 = "MatroskaExtractor"
            r19 = 0
            java.lang.String r10 = ". Setting mimeType to audio/x-unknown"
            switch(r1) {
                case 0: goto L_0x02d9;
                case 1: goto L_0x02d6;
                case 2: goto L_0x02d3;
                case 3: goto L_0x02c5;
                case 4: goto L_0x02c5;
                case 5: goto L_0x02c5;
                case 6: goto L_0x02b0;
                case 7: goto L_0x029c;
                case 8: goto L_0x0284;
                case 9: goto L_0x0281;
                case 10: goto L_0x0272;
                case 11: goto L_0x022c;
                case 12: goto L_0x0222;
                case 13: goto L_0x0218;
                case 14: goto L_0x0215;
                case 15: goto L_0x0211;
                case 16: goto L_0x020d;
                case 17: goto L_0x0209;
                case 18: goto L_0x0205;
                case 19: goto L_0x0205;
                case 20: goto L_0x0201;
                case 21: goto L_0x01f7;
                case 22: goto L_0x01c4;
                case 23: goto L_0x01a1;
                case 24: goto L_0x019e;
                case 25: goto L_0x0195;
                case 26: goto L_0x0192;
                case 27: goto L_0x0177;
                default: goto L_0x016f;
            }
        L_0x016f:
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Unrecognized codec identifier."
            r1.<init>(r2)
            throw r1
        L_0x0177:
            byte[] r1 = new byte[r4]
            byte[] r2 = r0.zzh
            byte r3 = r2[r8]
            r1[r8] = r3
            byte r3 = r2[r7]
            r1[r7] = r3
            byte r3 = r2[r6]
            r1[r6] = r3
            byte r2 = r2[r9]
            r1[r9] = r2
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r11 = r12
            goto L_0x02dd
        L_0x0192:
            r11 = r13
            goto L_0x02db
        L_0x0195:
            byte[] r1 = r0.zzh
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r11 = r14
            goto L_0x02dd
        L_0x019e:
            r11 = r15
            goto L_0x02db
        L_0x01a1:
            int r1 = r0.zzH
            int r1 = com.google.android.gms.internal.ads.zzbar.zzh(r1)
            if (r1 != 0) goto L_0x01be
            int r1 = r0.zzH
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            r4.append(r1)
            r4.append(r10)
            java.lang.String r1 = r4.toString()
            android.util.Log.w(r3, r1)
            goto L_0x01f3
        L_0x01be:
            r27 = r1
            r1 = r19
            goto L_0x02df
        L_0x01c4:
            com.google.android.gms.internal.ads.zzbak r1 = new com.google.android.gms.internal.ads.zzbak
            byte[] r4 = r0.zzh
            r1.<init>((byte[]) r4)
            boolean r1 = zze(r1)
            if (r1 == 0) goto L_0x01ee
            int r1 = r0.zzH
            int r1 = com.google.android.gms.internal.ads.zzbar.zzh(r1)
            if (r1 != 0) goto L_0x01be
            int r1 = r0.zzH
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            r4.append(r1)
            r4.append(r10)
            java.lang.String r1 = r4.toString()
            android.util.Log.w(r3, r1)
            goto L_0x01f3
        L_0x01ee:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown"
            android.util.Log.w(r3, r1)
        L_0x01f3:
            r11 = r18
            goto L_0x02db
        L_0x01f7:
            byte[] r1 = r0.zzh
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r11 = "audio/x-flac"
            goto L_0x02dd
        L_0x0201:
            java.lang.String r11 = "audio/vnd.dts.hd"
            goto L_0x02db
        L_0x0205:
            java.lang.String r11 = "audio/vnd.dts"
            goto L_0x02db
        L_0x0209:
            java.lang.String r11 = "audio/true-hd"
            goto L_0x02db
        L_0x020d:
            java.lang.String r11 = "audio/eac3"
            goto L_0x02db
        L_0x0211:
            java.lang.String r11 = "audio/ac3"
            goto L_0x02db
        L_0x0215:
            java.lang.String r11 = "audio/mpeg"
            goto L_0x021a
        L_0x0218:
            java.lang.String r11 = "audio/mpeg-L2"
        L_0x021a:
            r1 = r19
            r27 = -1
            r32 = 4096(0x1000, float:5.74E-42)
            goto L_0x02e1
        L_0x0222:
            byte[] r1 = r0.zzh
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r11 = "audio/mp4a-latm"
            goto L_0x02dd
        L_0x022c:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r9)
            byte[] r2 = r0.zzh
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r3 = r0.zzJ
            java.nio.ByteBuffer r2 = r2.putLong(r3)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r3 = r0.zzK
            java.nio.ByteBuffer r2 = r2.putLong(r3)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.lang.String r11 = "audio/opus"
            r16 = 5760(0x1680, float:8.071E-42)
            r27 = -1
            r32 = 5760(0x1680, float:8.071E-42)
            goto L_0x02e1
        L_0x0272:
            byte[] r1 = r0.zzh
            java.util.List r1 = zzd(r1)
            java.lang.String r11 = "audio/vorbis"
            r16 = 8192(0x2000, float:1.14794E-41)
            r27 = -1
            r32 = 8192(0x2000, float:1.14794E-41)
            goto L_0x02e1
        L_0x0281:
            r11 = r17
            goto L_0x02db
        L_0x0284:
            com.google.android.gms.internal.ads.zzbak r1 = new com.google.android.gms.internal.ads.zzbak
            byte[] r2 = r0.zzh
            r1.<init>((byte[]) r2)
            java.util.List r1 = zzc(r1)
            if (r1 == 0) goto L_0x0294
            java.lang.String r11 = "video/wvc1"
            goto L_0x02dd
        L_0x0294:
            java.lang.String r2 = "Unsupported FourCC. Setting mimeType to video/x-unknown"
            android.util.Log.w(r3, r2)
            r11 = r17
            goto L_0x02dd
        L_0x029c:
            com.google.android.gms.internal.ads.zzbak r1 = new com.google.android.gms.internal.ads.zzbak
            byte[] r2 = r0.zzh
            r1.<init>((byte[]) r2)
            com.google.android.gms.internal.ads.zzbay r1 = com.google.android.gms.internal.ads.zzbay.zza(r1)
            java.util.List r2 = r1.zza
            int r1 = r1.zzb
            r0.zzO = r1
            java.lang.String r11 = "video/hevc"
            goto L_0x02c3
        L_0x02b0:
            com.google.android.gms.internal.ads.zzbak r1 = new com.google.android.gms.internal.ads.zzbak
            byte[] r2 = r0.zzh
            r1.<init>((byte[]) r2)
            com.google.android.gms.internal.ads.zzbas r1 = com.google.android.gms.internal.ads.zzbas.zza(r1)
            java.util.List r2 = r1.zza
            int r1 = r1.zzb
            r0.zzO = r1
            java.lang.String r11 = "video/avc"
        L_0x02c3:
            r1 = r2
            goto L_0x02dd
        L_0x02c5:
            byte[] r1 = r0.zzh
            if (r1 != 0) goto L_0x02cc
            r1 = r19
            goto L_0x02d0
        L_0x02cc:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x02d0:
            java.lang.String r11 = "video/mp4v-es"
            goto L_0x02dd
        L_0x02d3:
            java.lang.String r11 = "video/mpeg2"
            goto L_0x02db
        L_0x02d6:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            goto L_0x02db
        L_0x02d9:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
        L_0x02db:
            r1 = r19
        L_0x02dd:
            r27 = -1
        L_0x02df:
            r32 = -1
        L_0x02e1:
            boolean r2 = r0.zzM
            boolean r3 = r0.zzL
            if (r7 == r3) goto L_0x02e9
            r3 = 0
            goto L_0x02ea
        L_0x02e9:
            r3 = 2
        L_0x02ea:
            r2 = r2 | r3
            boolean r3 = com.google.android.gms.internal.ads.zzbah.zza(r11)
            if (r3 == 0) goto L_0x031e
            java.lang.String r20 = java.lang.Integer.toString(r45)
            r22 = 0
            r23 = -1
            int r3 = r0.zzG
            int r4 = r0.zzI
            r28 = -1
            r29 = -1
            com.google.android.gms.internal.ads.zzauv r5 = r0.zzi
            java.lang.String r6 = r0.zzP
            r34 = 0
            r21 = r11
            r24 = r32
            r25 = r3
            r26 = r4
            r30 = r1
            r31 = r5
            r32 = r2
            r33 = r6
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzh(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            r6 = 1
            goto L_0x04ae
        L_0x031e:
            boolean r3 = com.google.android.gms.internal.ads.zzbah.zzb(r11)
            if (r3 == 0) goto L_0x044f
            int r2 = r0.zzn
            if (r2 != 0) goto L_0x033a
            int r2 = r0.zzl
            r3 = -1
            if (r2 != r3) goto L_0x032f
            int r2 = r0.zzj
        L_0x032f:
            r0.zzl = r2
            int r2 = r0.zzm
            if (r2 != r3) goto L_0x0337
            int r2 = r0.zzk
        L_0x0337:
            r0.zzm = r2
            goto L_0x033b
        L_0x033a:
            r3 = -1
        L_0x033b:
            int r2 = r0.zzl
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == r3) goto L_0x0353
            int r5 = r0.zzm
            if (r5 == r3) goto L_0x0353
            int r3 = r0.zzk
            int r3 = r3 * r2
            float r2 = (float) r3
            int r3 = r0.zzj
            int r3 = r3 * r5
            float r3 = (float) r3
            float r2 = r2 / r3
            r38 = r2
            goto L_0x0355
        L_0x0353:
            r38 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0355:
            boolean r2 = r0.zzq
            if (r2 == 0) goto L_0x0424
            float r2 = r0.zzw
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0414
            float r2 = r0.zzx
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0414
            float r2 = r0.zzy
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0414
            float r2 = r0.zzz
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0414
            float r2 = r0.zzA
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0414
            float r2 = r0.zzB
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0414
            float r2 = r0.zzC
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0414
            float r2 = r0.zzD
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0414
            float r2 = r0.zzE
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0414
            float r2 = r0.zzF
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0397
            goto L_0x0414
        L_0x0397:
            r2 = 25
            byte[] r2 = new byte[r2]
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r2)
            r3.put(r8)
            float r4 = r0.zzw
            r5 = 1195593728(0x47435000, float:50000.0)
            float r4 = r4 * r5
            r7 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzx
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzy
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzz
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzA
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzB
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzC
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzD
            float r4 = r4 * r5
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzE
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzF
            float r4 = r4 + r7
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            int r4 = r0.zzu
            short r4 = (short) r4
            r3.putShort(r4)
            int r4 = r0.zzv
            short r4 = (short) r4
            r3.putShort(r4)
            goto L_0x0416
        L_0x0414:
            r2 = r19
        L_0x0416:
            com.google.android.gms.internal.ads.zzbau r3 = new com.google.android.gms.internal.ads.zzbau
            int r4 = r0.zzr
            int r5 = r0.zzt
            int r7 = r0.zzs
            r3.<init>(r4, r5, r7, r2)
            r41 = r3
            goto L_0x0426
        L_0x0424:
            r41 = r19
        L_0x0426:
            java.lang.String r28 = java.lang.Integer.toString(r45)
            r30 = 0
            r31 = -1
            int r2 = r0.zzj
            int r3 = r0.zzk
            r35 = -1082130432(0xffffffffbf800000, float:-1.0)
            r37 = -1
            byte[] r4 = r0.zzo
            int r5 = r0.zzp
            com.google.android.gms.internal.ads.zzauv r7 = r0.zzi
            r29 = r11
            r33 = r2
            r34 = r3
            r36 = r1
            r39 = r4
            r40 = r5
            r42 = r7
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzl(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            goto L_0x04ae
        L_0x044f:
            boolean r3 = r15.equals(r11)
            if (r3 == 0) goto L_0x047a
            java.lang.String r28 = java.lang.Integer.toString(r45)
            r30 = 0
            r31 = -1
            java.lang.String r1 = r0.zzP
            r34 = -1
            com.google.android.gms.internal.ads.zzauv r3 = r0.zzi
            r36 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.util.List r38 = java.util.Collections.emptyList()
            r29 = r11
            r32 = r2
            r33 = r1
            r35 = r3
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzk(r28, r29, r30, r31, r32, r33, r34, r35, r36, r38)
        L_0x0478:
            r6 = 3
            goto L_0x04ae
        L_0x047a:
            boolean r2 = r14.equals(r11)
            if (r2 != 0) goto L_0x0495
            boolean r2 = r13.equals(r11)
            if (r2 != 0) goto L_0x0495
            boolean r2 = r12.equals(r11)
            if (r2 == 0) goto L_0x048d
            goto L_0x0495
        L_0x048d:
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            java.lang.String r2 = "Unexpected MIME type."
            r1.<init>(r2)
            throw r1
        L_0x0495:
            java.lang.String r20 = java.lang.Integer.toString(r45)
            r22 = 0
            r23 = -1
            java.lang.String r2 = r0.zzP
            com.google.android.gms.internal.ads.zzauv r3 = r0.zzi
            r21 = r11
            r24 = r1
            r25 = r2
            r26 = r3
            com.google.android.gms.internal.ads.zzasw r1 = com.google.android.gms.internal.ads.zzasw.zzi(r20, r21, r22, r23, r24, r25, r26)
            goto L_0x0478
        L_0x04ae:
            int r2 = r0.zzb
            r3 = r44
            com.google.android.gms.internal.ads.zzavi r2 = r3.zzbi(r2, r6)
            r0.zzN = r2
            r2.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavq.zzb(com.google.android.gms.internal.ads.zzava, int):void");
    }
}
