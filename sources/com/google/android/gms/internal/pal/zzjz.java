package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
public final class zzjz implements zzkn {
    private static final Charset zza = Charset.forName("UTF-8");
    private final InputStream zzb;

    private zzjz(InputStream inputStream) {
        this.zzb = inputStream;
    }

    public static zzkn zza(InputStream inputStream) throws IOException {
        return new zzjz(inputStream);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0202 A[Catch:{ zzzc | IllegalStateException -> 0x022a, all -> 0x0228 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e4 A[Catch:{ zzzc | IllegalStateException -> 0x022a, all -> 0x0228 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012b A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x014c A[Catch:{ zzzc | IllegalStateException -> 0x022a, all -> 0x0228 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0166 A[Catch:{ zzzc | IllegalStateException -> 0x022a, all -> 0x0228 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.pal.zzwb zzb() throws java.io.IOException {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "keyMaterialType"
            java.lang.String r2 = "value"
            java.lang.String r3 = "typeUrl"
            java.lang.String r4 = "outputPrefixType"
            java.lang.String r5 = "keyId"
            java.lang.String r6 = "status"
            java.lang.String r7 = "keyData"
            java.lang.String r8 = "primaryKeyId"
            java.lang.String r9 = "key"
            com.google.android.gms.internal.pal.zzabc r10 = new com.google.android.gms.internal.pal.zzabc     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.io.StringReader r11 = new java.io.StringReader     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r12 = new java.lang.String     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.io.InputStream r13 = r1.zzb     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            byte[] r13 = com.google.android.gms.internal.pal.zzlh.zzc(r13)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.nio.charset.Charset r14 = zza     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r12.<init>(r13, r14)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r11.<init>(r12)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r10.<init>(r11)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzyy r10 = com.google.android.gms.internal.pal.zzzs.zza(r10)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzzb r10 = r10.zzf()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            boolean r11 = r10.zzi(r9)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            if (r11 == 0) goto L_0x0220
            com.google.android.gms.internal.pal.zzyx r11 = r10.zzb(r9)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            int r11 = r11.zzb()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            if (r11 == 0) goto L_0x0220
            com.google.android.gms.internal.pal.zzvy r11 = com.google.android.gms.internal.pal.zzwb.zzd()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            boolean r12 = r10.zzi(r8)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            if (r12 == 0) goto L_0x0058
            com.google.android.gms.internal.pal.zzyy r8 = r10.zzc(r8)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            int r8 = r8.zza()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r11.zzb(r8)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
        L_0x0058:
            com.google.android.gms.internal.pal.zzyx r8 = r10.zzb(r9)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r10 = 0
        L_0x005d:
            int r12 = r8.zzb()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            if (r10 >= r12) goto L_0x0212
            com.google.android.gms.internal.pal.zzyy r12 = r8.zzc(r10)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzzb r12 = r12.zzf()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            boolean r13 = r12.zzi(r7)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            if (r13 == 0) goto L_0x020a
            boolean r13 = r12.zzi(r6)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            if (r13 == 0) goto L_0x020a
            boolean r13 = r12.zzi(r5)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            if (r13 == 0) goto L_0x020a
            boolean r13 = r12.zzi(r4)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            if (r13 == 0) goto L_0x020a
            com.google.android.gms.internal.pal.zzvz r13 = com.google.android.gms.internal.pal.zzwa.zzd()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzyy r14 = r12.zzc(r6)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r14 = r14.zzd()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            int r15 = r14.hashCode()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r9 = -891611359(0xffffffffcadb1721, float:-7179152.5)
            r16 = -1
            r17 = r6
            r6 = 1
            if (r15 == r9) goto L_0x00bc
            r9 = 478389753(0x1c83a5f9, float:8.711756E-22)
            if (r15 == r9) goto L_0x00b2
            r9 = 1053567612(0x3ecc2a7c, float:0.39876163)
            if (r15 == r9) goto L_0x00a8
            goto L_0x00c6
        L_0x00a8:
            java.lang.String r9 = "DISABLED"
            boolean r9 = r14.equals(r9)
            if (r9 == 0) goto L_0x00c6
            r9 = 1
            goto L_0x00c7
        L_0x00b2:
            java.lang.String r9 = "DESTROYED"
            boolean r9 = r14.equals(r9)
            if (r9 == 0) goto L_0x00c6
            r9 = 2
            goto L_0x00c7
        L_0x00bc:
            java.lang.String r9 = "ENABLED"
            boolean r9 = r14.equals(r9)
            if (r9 == 0) goto L_0x00c6
            r9 = 0
            goto L_0x00c7
        L_0x00c6:
            r9 = -1
        L_0x00c7:
            r18 = 4
            if (r9 == 0) goto L_0x00e4
            if (r9 == r6) goto L_0x00e2
            r15 = 2
            if (r9 != r15) goto L_0x00d2
            r9 = 5
            goto L_0x00e5
        L_0x00d2:
            com.google.android.gms.internal.pal.zzzc r0 = new com.google.android.gms.internal.pal.zzzc     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r2 = "unknown status: "
            java.lang.String r3 = java.lang.String.valueOf(r14)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r0.<init>((java.lang.String) r2)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            throw r0     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
        L_0x00e2:
            r9 = 4
            goto L_0x00e5
        L_0x00e4:
            r9 = 3
        L_0x00e5:
            r13.zzd(r9)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzyy r9 = r12.zzc(r5)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            int r9 = r9.zza()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r13.zzb(r9)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzyy r9 = r12.zzc(r4)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r9 = r9.zzd()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            int r14 = r9.hashCode()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            switch(r14) {
                case -2053249079: goto L_0x0121;
                case 80904: goto L_0x0117;
                case 2575090: goto L_0x010d;
                case 1761684556: goto L_0x0103;
                default: goto L_0x0102;
            }
        L_0x0102:
            goto L_0x012b
        L_0x0103:
            java.lang.String r14 = "CRUNCHY"
            boolean r14 = r9.equals(r14)
            if (r14 == 0) goto L_0x012b
            r14 = 3
            goto L_0x012c
        L_0x010d:
            java.lang.String r14 = "TINK"
            boolean r14 = r9.equals(r14)
            if (r14 == 0) goto L_0x012b
            r14 = 0
            goto L_0x012c
        L_0x0117:
            java.lang.String r14 = "RAW"
            boolean r14 = r9.equals(r14)
            if (r14 == 0) goto L_0x012b
            r14 = 1
            goto L_0x012c
        L_0x0121:
            java.lang.String r14 = "LEGACY"
            boolean r14 = r9.equals(r14)
            if (r14 == 0) goto L_0x012b
            r14 = 2
            goto L_0x012c
        L_0x012b:
            r14 = -1
        L_0x012c:
            if (r14 == 0) goto L_0x014c
            if (r14 == r6) goto L_0x014a
            r15 = 2
            if (r14 == r15) goto L_0x0148
            r15 = 3
            if (r14 != r15) goto L_0x0138
            r15 = 6
            goto L_0x014d
        L_0x0138:
            com.google.android.gms.internal.pal.zzzc r0 = new com.google.android.gms.internal.pal.zzzc     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r2 = "unknown output prefix type: "
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r0.<init>((java.lang.String) r2)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            throw r0     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
        L_0x0148:
            r15 = 4
            goto L_0x014d
        L_0x014a:
            r15 = 5
            goto L_0x014d
        L_0x014c:
            r15 = 3
        L_0x014d:
            r13.zzc(r15)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzzb r9 = r12.zze(r7)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            boolean r12 = r9.zzi(r3)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            if (r12 == 0) goto L_0x0202
            boolean r12 = r9.zzi(r2)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            if (r12 == 0) goto L_0x0202
            boolean r12 = r9.zzi(r0)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            if (r12 == 0) goto L_0x0202
            com.google.android.gms.internal.pal.zzyy r12 = r9.zzc(r2)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r12 = r12.zzd()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r14 = 2
            byte[] r12 = com.google.android.gms.internal.pal.zzxn.zza(r12, r14)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzvl r14 = com.google.android.gms.internal.pal.zzvo.zza()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzyy r15 = r9.zzc(r3)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r15 = r15.zzd()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r14.zzb(r15)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzaby r12 = com.google.android.gms.internal.pal.zzaby.zzn(r12)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r14.zzc(r12)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzyy r9 = r9.zzc(r0)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r9 = r9.zzd()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            int r12 = r9.hashCode()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            switch(r12) {
                case -1881281466: goto L_0x01b7;
                case -1609477353: goto L_0x01ad;
                case 249237018: goto L_0x01a3;
                case 1534613202: goto L_0x0199;
                default: goto L_0x0198;
            }
        L_0x0198:
            goto L_0x01c1
        L_0x0199:
            java.lang.String r12 = "ASYMMETRIC_PUBLIC"
            boolean r12 = r9.equals(r12)
            if (r12 == 0) goto L_0x01c1
            r12 = 2
            goto L_0x01c2
        L_0x01a3:
            java.lang.String r12 = "ASYMMETRIC_PRIVATE"
            boolean r12 = r9.equals(r12)
            if (r12 == 0) goto L_0x01c1
            r12 = 1
            goto L_0x01c2
        L_0x01ad:
            java.lang.String r12 = "SYMMETRIC"
            boolean r12 = r9.equals(r12)
            if (r12 == 0) goto L_0x01c1
            r12 = 0
            goto L_0x01c2
        L_0x01b7:
            java.lang.String r12 = "REMOTE"
            boolean r12 = r9.equals(r12)
            if (r12 == 0) goto L_0x01c1
            r12 = 3
            goto L_0x01c2
        L_0x01c1:
            r12 = -1
        L_0x01c2:
            if (r12 == 0) goto L_0x01e5
            if (r12 == r6) goto L_0x01e2
            r6 = 2
            if (r12 == r6) goto L_0x01df
            r6 = 3
            if (r12 != r6) goto L_0x01cf
            com.google.android.gms.internal.pal.zzvn r6 = com.google.android.gms.internal.pal.zzvn.REMOTE     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            goto L_0x01e7
        L_0x01cf:
            com.google.android.gms.internal.pal.zzzc r0 = new com.google.android.gms.internal.pal.zzzc     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r2 = "unknown key material type: "
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r0.<init>((java.lang.String) r2)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            throw r0     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
        L_0x01df:
            com.google.android.gms.internal.pal.zzvn r6 = com.google.android.gms.internal.pal.zzvn.ASYMMETRIC_PUBLIC     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            goto L_0x01e7
        L_0x01e2:
            com.google.android.gms.internal.pal.zzvn r6 = com.google.android.gms.internal.pal.zzvn.ASYMMETRIC_PRIVATE     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            goto L_0x01e7
        L_0x01e5:
            com.google.android.gms.internal.pal.zzvn r6 = com.google.android.gms.internal.pal.zzvn.SYMMETRIC     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
        L_0x01e7:
            r14.zza(r6)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzacz r6 = r14.zzan()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzvo r6 = (com.google.android.gms.internal.pal.zzvo) r6     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r13.zza(r6)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzacz r6 = r13.zzan()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzwa r6 = (com.google.android.gms.internal.pal.zzwa) r6     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            r11.zza(r6)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            int r10 = r10 + 1
            r6 = r17
            goto L_0x005d
        L_0x0202:
            com.google.android.gms.internal.pal.zzzc r0 = new com.google.android.gms.internal.pal.zzzc     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r2 = "invalid keyData"
            r0.<init>((java.lang.String) r2)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            throw r0     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
        L_0x020a:
            com.google.android.gms.internal.pal.zzzc r0 = new com.google.android.gms.internal.pal.zzzc     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r2 = "invalid key"
            r0.<init>((java.lang.String) r2)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            throw r0     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
        L_0x0212:
            com.google.android.gms.internal.pal.zzacz r0 = r11.zzan()     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            com.google.android.gms.internal.pal.zzwb r0 = (com.google.android.gms.internal.pal.zzwb) r0     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.io.InputStream r2 = r1.zzb
            if (r2 == 0) goto L_0x021f
            r2.close()
        L_0x021f:
            return r0
        L_0x0220:
            com.google.android.gms.internal.pal.zzzc r0 = new com.google.android.gms.internal.pal.zzzc     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            java.lang.String r2 = "invalid keyset"
            r0.<init>((java.lang.String) r2)     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
            throw r0     // Catch:{ zzzc -> 0x022c, IllegalStateException -> 0x022a }
        L_0x0228:
            r0 = move-exception
            goto L_0x0233
        L_0x022a:
            r0 = move-exception
            goto L_0x022d
        L_0x022c:
            r0 = move-exception
        L_0x022d:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x0228 }
            r2.<init>(r0)     // Catch:{ all -> 0x0228 }
            throw r2     // Catch:{ all -> 0x0228 }
        L_0x0233:
            java.io.InputStream r2 = r1.zzb
            if (r2 == 0) goto L_0x023a
            r2.close()
        L_0x023a:
            goto L_0x023c
        L_0x023b:
            throw r0
        L_0x023c:
            goto L_0x023b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzjz.zzb():com.google.android.gms.internal.pal.zzwb");
    }
}
