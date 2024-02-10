package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaeh {
    public int zzA = 1000;
    public int zzB = 200;
    public float zzC = -1.0f;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public byte[] zzM;
    public int zzN = 1;
    public int zzO = -1;
    public int zzP = 8000;
    public long zzQ = 0;
    public long zzR = 0;
    public zzaaq zzS;
    public boolean zzT;
    public boolean zzU = true;
    public zzaap zzV;
    public int zzW;
    /* access modifiers changed from: private */
    public int zzX;
    /* access modifiers changed from: private */
    public String zzY = "eng";
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzaao zzi;
    public byte[] zzj;
    public zzx zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = 0;
    public int zzq = -1;
    public float zzr = 0.0f;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public byte[] zzu = null;
    public int zzv = -1;
    public boolean zzw = false;
    public int zzx = -1;
    public int zzy = -1;
    public int zzz = -1;

    protected zzaeh() {
    }

    private static Pair zzf(zzef zzef) throws zzbu {
        try {
            zzef.zzG(16);
            long zzq2 = zzef.zzq();
            if (zzq2 == 1482049860) {
                return new Pair("video/divx", (Object) null);
            }
            if (zzq2 == 859189832) {
                return new Pair("video/3gpp", (Object) null);
            }
            if (zzq2 == 826496599) {
                int zzc2 = zzef.zzc() + 20;
                byte[] zzH2 = zzef.zzH();
                while (true) {
                    int length = zzH2.length;
                    if (zzc2 >= length - 4) {
                        throw zzbu.zza("Failed to find FourCC VC1 initialization data", (Throwable) null);
                    } else if (zzH2[zzc2] == 0 && zzH2[zzc2 + 1] == 0 && zzH2[zzc2 + 2] == 1 && zzH2[zzc2 + 3] == 15) {
                        return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(zzH2, zzc2, length)));
                    } else {
                        zzc2++;
                    }
                }
            } else {
                zzdw.zze("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", (Object) null);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbu.zza("Error parsing FourCC private data", (Throwable) null);
        }
    }

    private static List zzg(byte[] bArr) throws zzbu {
        byte b;
        byte b2;
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (true) {
                    b = bArr[i] & 255;
                    if (b != 255) {
                        break;
                    }
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + b;
                int i5 = 0;
                while (true) {
                    b2 = bArr[i3] & 255;
                    if (b2 != 255) {
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
                        throw zzbu.zza("Error parsing vorbis codec private", (Throwable) null);
                    }
                    throw zzbu.zza("Error parsing vorbis codec private", (Throwable) null);
                }
                throw zzbu.zza("Error parsing vorbis codec private", (Throwable) null);
            }
            throw zzbu.zza("Error parsing vorbis codec private", (Throwable) null);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbu.zza("Error parsing vorbis codec private", (Throwable) null);
        }
    }

    private static boolean zzh(zzef zzef) throws zzbu {
        try {
            int zzi2 = zzef.zzi();
            if (zzi2 == 1) {
                return true;
            }
            if (zzi2 == 65534) {
                zzef.zzF(24);
                return zzef.zzr() == zzaei.zzf.getMostSignificantBits() && zzef.zzr() == zzaei.zzf.getLeastSignificantBits();
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbu.zza("Error parsing MS/ACM codec private", (Throwable) null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzbu {
        byte[] bArr = this.zzj;
        if (bArr != null) {
            return bArr;
        }
        throw zzbu.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), (Throwable) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0249, code lost:
        r1 = -1;
        r2 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0281, code lost:
        r17 = "audio/x-unknown";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02b1, code lost:
        r1 = 4096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0342, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0343, code lost:
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0344, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0375, code lost:
        r3 = r2;
        r9 = -1;
        r2 = r1;
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0392, code lost:
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0393, code lost:
        r2 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0395, code lost:
        r9 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0396, code lost:
        r4 = r0.zzM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0398, code lost:
        if (r4 == null) goto L_0x03a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x039a, code lost:
        r4 = com.google.android.gms.internal.ads.zzze.zza(new com.google.android.gms.internal.ads.zzef(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03a3, code lost:
        if (r4 == null) goto L_0x03a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03a5, code lost:
        r2 = r4.zza;
        r17 = "video/dolby-vision";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03a9, code lost:
        r4 = r17;
        r5 = r0.zzU;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03af, code lost:
        if (true == r0.zzT) goto L_0x03b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03b1, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03b3, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03b4, code lost:
        r5 = r5 | r7;
        r7 = new com.google.android.gms.internal.ads.zzad();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03be, code lost:
        if (com.google.android.gms.internal.ads.zzbt.zzg(r4) == false) goto L_0x03cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03c0, code lost:
        r7.zzw(r0.zzN);
        r7.zzT(r0.zzP);
        r7.zzN(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03d3, code lost:
        if (com.google.android.gms.internal.ads.zzbt.zzh(r4) == false) goto L_0x0564;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03d7, code lost:
        if (r0.zzp != 0) goto L_0x03e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03d9, code lost:
        r6 = r0.zzn;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03db, code lost:
        if (r6 != -1) goto L_0x03df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03dd, code lost:
        r6 = r0.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03df, code lost:
        r0.zzn = r6;
        r6 = r0.zzo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03e3, code lost:
        if (r6 != -1) goto L_0x03e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03e5, code lost:
        r6 = r0.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03e7, code lost:
        r0.zzo = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03e9, code lost:
        r6 = r0.zzn;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x03ed, code lost:
        if (r6 == -1) goto L_0x03ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03ef, code lost:
        r9 = r0.zzo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03f1, code lost:
        if (r9 == -1) goto L_0x03ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x03f3, code lost:
        r6 = ((float) (r0.zzm * r6)) / ((float) (r0.zzl * r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x03ff, code lost:
        r6 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0403, code lost:
        if (r0.zzw == false) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0409, code lost:
        if (r0.zzC == -1.0f) goto L_0x04c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x040f, code lost:
        if (r0.zzD == -1.0f) goto L_0x04c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0415, code lost:
        if (r0.zzE == -1.0f) goto L_0x04c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x041b, code lost:
        if (r0.zzF == -1.0f) goto L_0x04c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0421, code lost:
        if (r0.zzG == -1.0f) goto L_0x04c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0427, code lost:
        if (r0.zzH == -1.0f) goto L_0x04c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x042d, code lost:
        if (r0.zzI == -1.0f) goto L_0x04c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0433, code lost:
        if (r0.zzJ == -1.0f) goto L_0x04c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0439, code lost:
        if (r0.zzK == -1.0f) goto L_0x04c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x043f, code lost:
        if (r0.zzL != -1.0f) goto L_0x0443;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0443, code lost:
        r8 = new byte[25];
        r9 = java.nio.ByteBuffer.wrap(r8).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        r9.put((byte) 0);
        r9.putShort((short) ((int) ((r0.zzC * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r0.zzD * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r0.zzE * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r0.zzF * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r0.zzG * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r0.zzH * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r0.zzI * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r0.zzJ * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) (r0.zzK + 0.5f)));
        r9.putShort((short) ((int) (r0.zzL + 0.5f)));
        r9.putShort((short) r0.zzA);
        r9.putShort((short) r0.zzB);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x04c6, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x04c7, code lost:
        r9 = new com.google.android.gms.internal.ads.zzq(r0.zzx, r0.zzz, r0.zzy, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x04d3, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x04d6, code lost:
        if (r0.zza == null) goto L_0x04f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x04e2, code lost:
        if (com.google.android.gms.internal.ads.zzaei.zzg.containsKey(r0.zza) == false) goto L_0x04f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x04e4, code lost:
        r12 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzaei.zzg.get(r0.zza)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x04f6, code lost:
        if (r0.zzq != 0) goto L_0x0544;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x04ff, code lost:
        if (java.lang.Float.compare(r0.zzr, 0.0f) != 0) goto L_0x0544;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0507, code lost:
        if (java.lang.Float.compare(r0.zzs, 0.0f) != 0) goto L_0x0544;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x050f, code lost:
        if (java.lang.Float.compare(r0.zzt, 0.0f) != 0) goto L_0x0512;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x051a, code lost:
        if (java.lang.Float.compare(r0.zzs, 90.0f) != 0) goto L_0x051f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x051c, code lost:
        r10 = 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0527, code lost:
        if (java.lang.Float.compare(r0.zzs, -180.0f) == 0) goto L_0x0541;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0531, code lost:
        if (java.lang.Float.compare(r0.zzs, 180.0f) != 0) goto L_0x0534;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x053c, code lost:
        if (java.lang.Float.compare(r0.zzs, -90.0f) != 0) goto L_0x0544;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x053e, code lost:
        r10 = 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0541, code lost:
        r10 = 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0544, code lost:
        r10 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0545, code lost:
        r7.zzX(r0.zzl);
        r7.zzF(r0.zzm);
        r7.zzP(r6);
        r7.zzR(r10);
        r7.zzQ(r0.zzu);
        r7.zzV(r0.zzv);
        r7.zzy(r9);
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0568, code lost:
        if ("application/x-subrip".equals(r4) != false) goto L_0x0597;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x056e, code lost:
        if ("text/x-ssa".equals(r4) != false) goto L_0x0597;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0574, code lost:
        if ("text/vtt".equals(r4) != false) goto L_0x0597;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x057c, code lost:
        if ("application/vobsub".equals(r4) != false) goto L_0x0597;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0584, code lost:
        if ("application/pgs".equals(r4) != false) goto L_0x0597;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x058c, code lost:
        if ("application/dvbsubs".equals(r4) == false) goto L_0x058f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0596, code lost:
        throw com.google.android.gms.internal.ads.zzbu.zza("Unexpected MIME type.", (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0597, code lost:
        r6 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x059a, code lost:
        if (r0.zza == null) goto L_0x05ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x05a6, code lost:
        if (com.google.android.gms.internal.ads.zzaei.zzg.containsKey(r0.zza) != false) goto L_0x05ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x05a8, code lost:
        r7.zzJ(r0.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x05ad, code lost:
        r7.zzG(r21);
        r7.zzS(r4);
        r7.zzL(r1);
        r7.zzK(r0.zzY);
        r7.zzU(r5);
        r7.zzI(r3);
        r7.zzx(r2);
        r7.zzB(r0.zzk);
        r1 = r7.zzY();
        r2 = r20.zzv(r0.zzc, r6);
        r0.zzV = r2;
        r2.zzk(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x05dc, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.internal.ads.zzzl r20, int r21) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = r0.zzb
            int r2 = r1.hashCode()
            r4 = 16
            r5 = 32
            r6 = 1
            r8 = 8
            r9 = 4
            r10 = 0
            r11 = 3
            r12 = -1
            switch(r2) {
                case -2095576542: goto L_0x0189;
                case -2095575984: goto L_0x017f;
                case -1985379776: goto L_0x0174;
                case -1784763192: goto L_0x0169;
                case -1730367663: goto L_0x015e;
                case -1482641358: goto L_0x0153;
                case -1482641357: goto L_0x0148;
                case -1373388978: goto L_0x013d;
                case -933872740: goto L_0x0132;
                case -538363189: goto L_0x0127;
                case -538363109: goto L_0x011c;
                case -425012669: goto L_0x0110;
                case -356037306: goto L_0x0104;
                case 62923557: goto L_0x00f8;
                case 62923603: goto L_0x00ec;
                case 62927045: goto L_0x00e0;
                case 82318131: goto L_0x00d5;
                case 82338133: goto L_0x00ca;
                case 82338134: goto L_0x00bf;
                case 99146302: goto L_0x00b3;
                case 444813526: goto L_0x00a7;
                case 542569478: goto L_0x009b;
                case 635596514: goto L_0x008f;
                case 725948237: goto L_0x0083;
                case 725957860: goto L_0x0077;
                case 738597099: goto L_0x006b;
                case 855502857: goto L_0x005f;
                case 1045209816: goto L_0x0053;
                case 1422270023: goto L_0x0047;
                case 1809237540: goto L_0x003c;
                case 1950749482: goto L_0x0030;
                case 1950789798: goto L_0x0024;
                case 1951062397: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x0193
        L_0x0018:
            java.lang.String r2 = "A_OPUS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 12
            goto L_0x0194
        L_0x0024:
            java.lang.String r2 = "A_FLAC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 22
            goto L_0x0194
        L_0x0030:
            java.lang.String r2 = "A_EAC3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 17
            goto L_0x0194
        L_0x003c:
            java.lang.String r2 = "V_MPEG2"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 3
            goto L_0x0194
        L_0x0047:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 27
            goto L_0x0194
        L_0x0053:
            java.lang.String r2 = "S_TEXT/WEBVTT"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 29
            goto L_0x0194
        L_0x005f:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 8
            goto L_0x0194
        L_0x006b:
            java.lang.String r2 = "S_TEXT/ASS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 28
            goto L_0x0194
        L_0x0077:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 24
            goto L_0x0194
        L_0x0083:
            java.lang.String r2 = "A_PCM/INT/BIG"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 25
            goto L_0x0194
        L_0x008f:
            java.lang.String r2 = "A_PCM/FLOAT/IEEE"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 26
            goto L_0x0194
        L_0x009b:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 20
            goto L_0x0194
        L_0x00a7:
            java.lang.String r2 = "V_THEORA"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 10
            goto L_0x0194
        L_0x00b3:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 31
            goto L_0x0194
        L_0x00bf:
            java.lang.String r2 = "V_VP9"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 1
            goto L_0x0194
        L_0x00ca:
            java.lang.String r2 = "V_VP8"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 0
            goto L_0x0194
        L_0x00d5:
            java.lang.String r2 = "V_AV1"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 2
            goto L_0x0194
        L_0x00e0:
            java.lang.String r2 = "A_DTS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 19
            goto L_0x0194
        L_0x00ec:
            java.lang.String r2 = "A_AC3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 16
            goto L_0x0194
        L_0x00f8:
            java.lang.String r2 = "A_AAC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 13
            goto L_0x0194
        L_0x0104:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 21
            goto L_0x0194
        L_0x0110:
            java.lang.String r2 = "S_VOBSUB"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 30
            goto L_0x0194
        L_0x011c:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 7
            goto L_0x0194
        L_0x0127:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 5
            goto L_0x0194
        L_0x0132:
            java.lang.String r2 = "S_DVBSUB"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 32
            goto L_0x0194
        L_0x013d:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 9
            goto L_0x0194
        L_0x0148:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 15
            goto L_0x0194
        L_0x0153:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 14
            goto L_0x0194
        L_0x015e:
            java.lang.String r2 = "A_VORBIS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 11
            goto L_0x0194
        L_0x0169:
            java.lang.String r2 = "A_TRUEHD"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 18
            goto L_0x0194
        L_0x0174:
            java.lang.String r2 = "A_MS/ACM"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 23
            goto L_0x0194
        L_0x017f:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 4
            goto L_0x0194
        L_0x0189:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0193
            r2 = 6
            goto L_0x0194
        L_0x0193:
            r2 = -1
        L_0x0194:
            java.lang.String r13 = "text/vtt"
            java.lang.String r14 = "text/x-ssa"
            java.lang.String r15 = "application/x-subrip"
            r16 = 4096(0x1000, float:5.74E-42)
            java.lang.String r17 = "audio/raw"
            java.lang.String r18 = "audio/x-unknown"
            java.lang.String r7 = "MatroskaExtractor"
            java.lang.String r3 = ". Setting mimeType to audio/x-unknown"
            switch(r2) {
                case 0: goto L_0x0390;
                case 1: goto L_0x038d;
                case 2: goto L_0x038a;
                case 3: goto L_0x0387;
                case 4: goto L_0x037a;
                case 5: goto L_0x037a;
                case 6: goto L_0x037a;
                case 7: goto L_0x035e;
                case 8: goto L_0x0346;
                case 9: goto L_0x032b;
                case 10: goto L_0x0327;
                case 11: goto L_0x0317;
                case 12: goto L_0x02d3;
                case 13: goto L_0x02b5;
                case 14: goto L_0x02af;
                case 15: goto L_0x02ac;
                case 16: goto L_0x02a8;
                case 17: goto L_0x02a4;
                case 18: goto L_0x0299;
                case 19: goto L_0x0295;
                case 20: goto L_0x0295;
                case 21: goto L_0x0291;
                case 22: goto L_0x0285;
                case 23: goto L_0x024e;
                case 24: goto L_0x022a;
                case 25: goto L_0x0206;
                case 26: goto L_0x01eb;
                case 27: goto L_0x01e7;
                case 28: goto L_0x01d4;
                case 29: goto L_0x01d0;
                case 30: goto L_0x01c4;
                case 31: goto L_0x01c0;
                case 32: goto L_0x01af;
                default: goto L_0x01a7;
            }
        L_0x01a7:
            java.lang.String r1 = "Unrecognized codec identifier."
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x01af:
            byte[] r2 = new byte[r9]
            byte[] r1 = r0.zzi(r1)
            java.lang.System.arraycopy(r1, r10, r2, r10, r9)
            com.google.android.gms.internal.ads.zzfvn r1 = com.google.android.gms.internal.ads.zzfvn.zzp(r2)
            java.lang.String r17 = "application/dvbsubs"
            goto L_0x0342
        L_0x01c0:
            java.lang.String r17 = "application/pgs"
            goto L_0x0392
        L_0x01c4:
            byte[] r1 = r0.zzi(r1)
            com.google.android.gms.internal.ads.zzfvn r1 = com.google.android.gms.internal.ads.zzfvn.zzp(r1)
            java.lang.String r17 = "application/vobsub"
            goto L_0x0342
        L_0x01d0:
            r17 = r13
            goto L_0x0392
        L_0x01d4:
            byte[] r1 = com.google.android.gms.internal.ads.zzaei.zzc
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            com.google.android.gms.internal.ads.zzfvn r1 = com.google.android.gms.internal.ads.zzfvn.zzq(r1, r2)
            r3 = r1
            r17 = r14
            goto L_0x0343
        L_0x01e7:
            r17 = r15
            goto L_0x0392
        L_0x01eb:
            int r1 = r0.zzO
            if (r1 != r5) goto L_0x01f0
            goto L_0x0249
        L_0x01f0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unsupported floating point PCM bit depth: "
            r2.<init>(r4)
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r7, r1)
            goto L_0x0281
        L_0x0206:
            int r1 = r0.zzO
            if (r1 != r8) goto L_0x0210
            r1 = -1
            r2 = 0
            r3 = 0
            r9 = 3
            goto L_0x0396
        L_0x0210:
            if (r1 != r4) goto L_0x0215
            r9 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0249
        L_0x0215:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unsupported big endian PCM bit depth: "
            r2.<init>(r4)
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r7, r1)
            goto L_0x0281
        L_0x022a:
            int r1 = r0.zzO
            int r9 = com.google.android.gms.internal.ads.zzen.zzn(r1)
            if (r9 != 0) goto L_0x0249
            int r1 = r0.zzO
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unsupported little endian PCM bit depth: "
            r2.<init>(r4)
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r7, r1)
            goto L_0x0281
        L_0x0249:
            r1 = -1
            r2 = 0
            r3 = 0
            goto L_0x0396
        L_0x024e:
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            boolean r1 = zzh(r2)
            if (r1 == 0) goto L_0x027c
            int r1 = r0.zzO
            int r9 = com.google.android.gms.internal.ads.zzen.zzn(r1)
            if (r9 != 0) goto L_0x0249
            int r1 = r0.zzO
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unsupported PCM bit depth: "
            r2.<init>(r4)
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r7, r1)
            goto L_0x0281
        L_0x027c:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown"
            com.google.android.gms.internal.ads.zzdw.zze(r7, r1)
        L_0x0281:
            r17 = r18
            goto L_0x0392
        L_0x0285:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r17 = "audio/flac"
            goto L_0x0342
        L_0x0291:
            java.lang.String r17 = "audio/vnd.dts.hd"
            goto L_0x0392
        L_0x0295:
            java.lang.String r17 = "audio/vnd.dts"
            goto L_0x0392
        L_0x0299:
            com.google.android.gms.internal.ads.zzaaq r1 = new com.google.android.gms.internal.ads.zzaaq
            r1.<init>()
            r0.zzS = r1
            java.lang.String r17 = "audio/true-hd"
            goto L_0x0392
        L_0x02a4:
            java.lang.String r17 = "audio/eac3"
            goto L_0x0392
        L_0x02a8:
            java.lang.String r17 = "audio/ac3"
            goto L_0x0392
        L_0x02ac:
            java.lang.String r17 = "audio/mpeg"
            goto L_0x02b1
        L_0x02af:
            java.lang.String r17 = "audio/mpeg-L2"
        L_0x02b1:
            r1 = 4096(0x1000, float:5.74E-42)
            goto L_0x0393
        L_0x02b5:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            byte[] r2 = r0.zzj
            com.google.android.gms.internal.ads.zzyf r2 = com.google.android.gms.internal.ads.zzyg.zza(r2)
            int r3 = r2.zza
            r0.zzP = r3
            int r3 = r2.zzb
            r0.zzN = r3
            java.lang.String r2 = r2.zzc
            java.lang.String r17 = "audio/mp4a-latm"
            r3 = r1
            r1 = -1
            goto L_0x0395
        L_0x02d3:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r11)
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r8)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r3 = r0.zzQ
            java.nio.ByteBuffer r2 = r2.putLong(r3)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r8)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r3 = r0.zzR
            java.nio.ByteBuffer r2 = r2.putLong(r3)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.lang.String r17 = "audio/opus"
            r16 = 5760(0x1680, float:8.071E-42)
            r3 = r1
            r1 = 5760(0x1680, float:8.071E-42)
            goto L_0x0344
        L_0x0317:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = zzg(r1)
            java.lang.String r17 = "audio/vorbis"
            r16 = 8192(0x2000, float:1.14794E-41)
            r3 = r1
            r1 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0344
        L_0x0327:
            java.lang.String r17 = "video/x-unknown"
            goto L_0x0392
        L_0x032b:
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            android.util.Pair r1 = zzf(r2)
            java.lang.Object r2 = r1.first
            r17 = r2
            java.lang.String r17 = (java.lang.String) r17
            java.lang.Object r1 = r1.second
            java.util.List r1 = (java.util.List) r1
        L_0x0342:
            r3 = r1
        L_0x0343:
            r1 = -1
        L_0x0344:
            r2 = 0
            goto L_0x0395
        L_0x0346:
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            com.google.android.gms.internal.ads.zzzy r1 = com.google.android.gms.internal.ads.zzzy.zza(r2)
            java.util.List r2 = r1.zza
            int r3 = r1.zzb
            r0.zzW = r3
            java.lang.String r1 = r1.zzd
            java.lang.String r17 = "video/hevc"
            goto L_0x0375
        L_0x035e:
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            com.google.android.gms.internal.ads.zzyn r1 = com.google.android.gms.internal.ads.zzyn.zza(r2)
            java.util.List r2 = r1.zza
            int r3 = r1.zzb
            r0.zzW = r3
            java.lang.String r1 = r1.zzf
            java.lang.String r17 = "video/avc"
        L_0x0375:
            r3 = r2
            r9 = -1
            r2 = r1
            r1 = -1
            goto L_0x0396
        L_0x037a:
            byte[] r1 = r0.zzj
            if (r1 != 0) goto L_0x0380
            r1 = 0
            goto L_0x0384
        L_0x0380:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x0384:
            java.lang.String r17 = "video/mp4v-es"
            goto L_0x0342
        L_0x0387:
            java.lang.String r17 = "video/mpeg2"
            goto L_0x0392
        L_0x038a:
            java.lang.String r17 = "video/av01"
            goto L_0x0392
        L_0x038d:
            java.lang.String r17 = "video/x-vnd.on2.vp9"
            goto L_0x0392
        L_0x0390:
            java.lang.String r17 = "video/x-vnd.on2.vp8"
        L_0x0392:
            r1 = -1
        L_0x0393:
            r2 = 0
            r3 = 0
        L_0x0395:
            r9 = -1
        L_0x0396:
            byte[] r4 = r0.zzM
            if (r4 == 0) goto L_0x03a9
            com.google.android.gms.internal.ads.zzef r5 = new com.google.android.gms.internal.ads.zzef
            r5.<init>((byte[]) r4)
            com.google.android.gms.internal.ads.zzze r4 = com.google.android.gms.internal.ads.zzze.zza(r5)
            if (r4 == 0) goto L_0x03a9
            java.lang.String r2 = r4.zza
            java.lang.String r17 = "video/dolby-vision"
        L_0x03a9:
            r4 = r17
            boolean r5 = r0.zzU
            boolean r7 = r0.zzT
            if (r6 == r7) goto L_0x03b3
            r7 = 0
            goto L_0x03b4
        L_0x03b3:
            r7 = 2
        L_0x03b4:
            r5 = r5 | r7
            com.google.android.gms.internal.ads.zzad r7 = new com.google.android.gms.internal.ads.zzad
            r7.<init>()
            boolean r8 = com.google.android.gms.internal.ads.zzbt.zzg(r4)
            if (r8 == 0) goto L_0x03cf
            int r8 = r0.zzN
            r7.zzw(r8)
            int r8 = r0.zzP
            r7.zzT(r8)
            r7.zzN(r9)
            goto L_0x0598
        L_0x03cf:
            boolean r6 = com.google.android.gms.internal.ads.zzbt.zzh(r4)
            if (r6 == 0) goto L_0x0564
            int r6 = r0.zzp
            if (r6 != 0) goto L_0x03e9
            int r6 = r0.zzn
            if (r6 != r12) goto L_0x03df
            int r6 = r0.zzl
        L_0x03df:
            r0.zzn = r6
            int r6 = r0.zzo
            if (r6 != r12) goto L_0x03e7
            int r6 = r0.zzm
        L_0x03e7:
            r0.zzo = r6
        L_0x03e9:
            int r6 = r0.zzn
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r6 == r12) goto L_0x03ff
            int r9 = r0.zzo
            if (r9 == r12) goto L_0x03ff
            int r11 = r0.zzm
            int r11 = r11 * r6
            float r6 = (float) r11
            int r11 = r0.zzl
            int r11 = r11 * r9
            float r9 = (float) r11
            float r6 = r6 / r9
            goto L_0x0401
        L_0x03ff:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0401:
            boolean r9 = r0.zzw
            if (r9 == 0) goto L_0x04d3
            float r9 = r0.zzC
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x04c6
            float r9 = r0.zzD
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x04c6
            float r9 = r0.zzE
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x04c6
            float r9 = r0.zzF
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x04c6
            float r9 = r0.zzG
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x04c6
            float r9 = r0.zzH
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x04c6
            float r9 = r0.zzI
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x04c6
            float r9 = r0.zzJ
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x04c6
            float r9 = r0.zzK
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x04c6
            float r9 = r0.zzL
            int r8 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x0443
            goto L_0x04c6
        L_0x0443:
            r8 = 25
            byte[] r8 = new byte[r8]
            java.nio.ByteBuffer r9 = java.nio.ByteBuffer.wrap(r8)
            java.nio.ByteOrder r11 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r9 = r9.order(r11)
            r9.put(r10)
            float r11 = r0.zzC
            r13 = 1195593728(0x47435000, float:50000.0)
            float r11 = r11 * r13
            r14 = 1056964608(0x3f000000, float:0.5)
            float r11 = r11 + r14
            int r11 = (int) r11
            short r11 = (short) r11
            r9.putShort(r11)
            float r11 = r0.zzD
            float r11 = r11 * r13
            float r11 = r11 + r14
            int r11 = (int) r11
            short r11 = (short) r11
            r9.putShort(r11)
            float r11 = r0.zzE
            float r11 = r11 * r13
            float r11 = r11 + r14
            int r11 = (int) r11
            short r11 = (short) r11
            r9.putShort(r11)
            float r11 = r0.zzF
            float r11 = r11 * r13
            float r11 = r11 + r14
            int r11 = (int) r11
            short r11 = (short) r11
            r9.putShort(r11)
            float r11 = r0.zzG
            float r11 = r11 * r13
            float r11 = r11 + r14
            int r11 = (int) r11
            short r11 = (short) r11
            r9.putShort(r11)
            float r11 = r0.zzH
            float r11 = r11 * r13
            float r11 = r11 + r14
            int r11 = (int) r11
            short r11 = (short) r11
            r9.putShort(r11)
            float r11 = r0.zzI
            float r11 = r11 * r13
            float r11 = r11 + r14
            int r11 = (int) r11
            short r11 = (short) r11
            r9.putShort(r11)
            float r11 = r0.zzJ
            float r11 = r11 * r13
            float r11 = r11 + r14
            int r11 = (int) r11
            short r11 = (short) r11
            r9.putShort(r11)
            float r11 = r0.zzK
            float r11 = r11 + r14
            int r11 = (int) r11
            short r11 = (short) r11
            r9.putShort(r11)
            float r11 = r0.zzL
            float r11 = r11 + r14
            int r11 = (int) r11
            short r11 = (short) r11
            r9.putShort(r11)
            int r11 = r0.zzA
            short r11 = (short) r11
            r9.putShort(r11)
            int r11 = r0.zzB
            short r11 = (short) r11
            r9.putShort(r11)
            goto L_0x04c7
        L_0x04c6:
            r8 = 0
        L_0x04c7:
            com.google.android.gms.internal.ads.zzq r9 = new com.google.android.gms.internal.ads.zzq
            int r11 = r0.zzx
            int r13 = r0.zzz
            int r14 = r0.zzy
            r9.<init>(r11, r13, r14, r8)
            goto L_0x04d4
        L_0x04d3:
            r9 = 0
        L_0x04d4:
            java.lang.String r8 = r0.zza
            if (r8 == 0) goto L_0x04f4
            java.util.Map r8 = com.google.android.gms.internal.ads.zzaei.zzg
            java.lang.String r11 = r0.zza
            boolean r8 = r8.containsKey(r11)
            if (r8 == 0) goto L_0x04f4
            java.util.Map r8 = com.google.android.gms.internal.ads.zzaei.zzg
            java.lang.String r11 = r0.zza
            java.lang.Object r8 = r8.get(r11)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r12 = r8.intValue()
        L_0x04f4:
            int r8 = r0.zzq
            if (r8 != 0) goto L_0x0544
            float r8 = r0.zzr
            r11 = 0
            int r8 = java.lang.Float.compare(r8, r11)
            if (r8 != 0) goto L_0x0544
            float r8 = r0.zzs
            int r8 = java.lang.Float.compare(r8, r11)
            if (r8 != 0) goto L_0x0544
            float r8 = r0.zzt
            int r8 = java.lang.Float.compare(r8, r11)
            if (r8 != 0) goto L_0x0512
            goto L_0x0545
        L_0x0512:
            float r8 = r0.zzs
            r10 = 1119092736(0x42b40000, float:90.0)
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x051f
            r10 = 90
            goto L_0x0545
        L_0x051f:
            float r8 = r0.zzs
            r10 = -1020002304(0xffffffffc3340000, float:-180.0)
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 == 0) goto L_0x0541
            float r8 = r0.zzs
            r10 = 1127481344(0x43340000, float:180.0)
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x0534
            goto L_0x0541
        L_0x0534:
            float r8 = r0.zzs
            r10 = -1028390912(0xffffffffc2b40000, float:-90.0)
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x0544
            r10 = 270(0x10e, float:3.78E-43)
            goto L_0x0545
        L_0x0541:
            r10 = 180(0xb4, float:2.52E-43)
            goto L_0x0545
        L_0x0544:
            r10 = r12
        L_0x0545:
            int r8 = r0.zzl
            r7.zzX(r8)
            int r8 = r0.zzm
            r7.zzF(r8)
            r7.zzP(r6)
            r7.zzR(r10)
            byte[] r6 = r0.zzu
            r7.zzQ(r6)
            int r6 = r0.zzv
            r7.zzV(r6)
            r7.zzy(r9)
            r6 = 2
            goto L_0x0598
        L_0x0564:
            boolean r6 = r15.equals(r4)
            if (r6 != 0) goto L_0x0597
            boolean r6 = r14.equals(r4)
            if (r6 != 0) goto L_0x0597
            boolean r6 = r13.equals(r4)
            if (r6 != 0) goto L_0x0597
            java.lang.String r6 = "application/vobsub"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L_0x0597
            java.lang.String r6 = "application/pgs"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L_0x0597
            java.lang.String r6 = "application/dvbsubs"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x058f
            goto L_0x0597
        L_0x058f:
            java.lang.String r1 = "Unexpected MIME type."
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x0597:
            r6 = 3
        L_0x0598:
            java.lang.String r8 = r0.zza
            if (r8 == 0) goto L_0x05ad
            java.util.Map r8 = com.google.android.gms.internal.ads.zzaei.zzg
            java.lang.String r9 = r0.zza
            boolean r8 = r8.containsKey(r9)
            if (r8 != 0) goto L_0x05ad
            java.lang.String r8 = r0.zza
            r7.zzJ(r8)
        L_0x05ad:
            r8 = r21
            r7.zzG(r8)
            r7.zzS(r4)
            r7.zzL(r1)
            java.lang.String r1 = r0.zzY
            r7.zzK(r1)
            r7.zzU(r5)
            r7.zzI(r3)
            r7.zzx(r2)
            com.google.android.gms.internal.ads.zzx r1 = r0.zzk
            r7.zzB(r1)
            com.google.android.gms.internal.ads.zzaf r1 = r7.zzY()
            int r2 = r0.zzc
            r3 = r20
            com.google.android.gms.internal.ads.zzaap r2 = r3.zzv(r2, r6)
            r0.zzV = r2
            r2.zzk(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeh.zze(com.google.android.gms.internal.ads.zzzl, int):void");
    }
}
