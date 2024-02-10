package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zznd {
    public static final zznd zza = new zznd(new int[]{2}, 8);
    private static final zznd zzb = new zznd(new int[]{2, 5, 6}, 8);
    /* access modifiers changed from: private */
    public static final zzfvq zzc;
    private final int[] zzd;
    private final int zze = 8;

    static {
        zzfvp zzfvp = new zzfvp();
        zzfvp.zza(5, 6);
        zzfvp.zza(17, 6);
        zzfvp.zza(7, 6);
        zzfvp.zza(18, 6);
        zzfvp.zza(6, 8);
        zzfvp.zza(8, 8);
        zzfvp.zza(14, 8);
        zzc = zzfvp.zzc();
    }

    public zznd(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.zzd = copyOf;
        Arrays.sort(copyOf);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zznd)) {
            return false;
        }
        zznd zznd = (zznd) obj;
        if (!Arrays.equals(this.zzd, zznd.zzd)) {
            return false;
        }
        int i = zznd.zze;
        return true;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzd) * 31) + 8;
    }

    public final String toString() {
        String arrays = Arrays.toString(this.zzd);
        return "AudioCapabilities[maxChannelCount=8, supportedEncodings=" + arrays + "]";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0080, code lost:
        if (r7 != 5) goto L_0x0083;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair zza(com.google.android.gms.internal.ads.zzaf r10) {
        /*
            r9 = this;
            java.lang.String r0 = r10.zzm
            r0.getClass()
            java.lang.String r1 = r10.zzj
            int r0 = com.google.android.gms.internal.ads.zzbt.zza(r0, r1)
            com.google.android.gms.internal.ads.zzfvq r1 = zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r2 = r1.containsKey(r2)
            r3 = 0
            if (r2 != 0) goto L_0x0019
            return r3
        L_0x0019:
            r2 = 7
            r4 = 6
            r5 = 8
            r6 = 18
            if (r0 != r6) goto L_0x002b
            boolean r0 = r9.zzc(r6)
            if (r0 != 0) goto L_0x0029
            r0 = 6
            goto L_0x0034
        L_0x0029:
            r0 = 18
        L_0x002b:
            if (r0 != r5) goto L_0x0034
            boolean r7 = r9.zzc(r5)
            if (r7 != 0) goto L_0x0034
            r0 = 7
        L_0x0034:
            boolean r7 = r9.zzc(r0)
            if (r7 != 0) goto L_0x003b
            return r3
        L_0x003b:
            int r7 = r10.zzz
            r8 = -1
            if (r7 == r8) goto L_0x0046
            if (r0 != r6) goto L_0x0043
            goto L_0x0046
        L_0x0043:
            if (r7 <= r5) goto L_0x006e
            return r3
        L_0x0046:
            int r10 = r10.zzA
            if (r10 != r8) goto L_0x004d
            r10 = 48000(0xbb80, float:6.7262E-41)
        L_0x004d:
            int r6 = com.google.android.gms.internal.ads.zzen.zza
            r7 = 29
            if (r6 < r7) goto L_0x0058
            int r7 = com.google.android.gms.internal.ads.zznc.zza(r0, r10)
            goto L_0x006e
        L_0x0058:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r10 = r1.getOrDefault(r10, r6)
            java.lang.Integer r10 = (java.lang.Integer) r10
            r10.getClass()
            int r7 = r10.intValue()
        L_0x006e:
            int r10 = com.google.android.gms.internal.ads.zzen.zza
            r1 = 28
            if (r10 > r1) goto L_0x0083
            if (r7 != r2) goto L_0x0079
            r4 = 8
            goto L_0x0084
        L_0x0079:
            r10 = 3
            if (r7 == r10) goto L_0x0084
            r10 = 4
            if (r7 == r10) goto L_0x0084
            r10 = 5
            if (r7 != r10) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r4 = r7
        L_0x0084:
            int r10 = com.google.android.gms.internal.ads.zzen.zza
            r1 = 26
            if (r10 > r1) goto L_0x0098
            java.lang.String r10 = "fugu"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzen.zzb
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x0098
            r10 = 1
            if (r4 != r10) goto L_0x0098
            r4 = 2
        L_0x0098:
            int r10 = com.google.android.gms.internal.ads.zzen.zzj(r4)
            if (r10 != 0) goto L_0x009f
            return r3
        L_0x009f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            android.util.Pair r10 = android.util.Pair.create(r0, r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznd.zza(com.google.android.gms.internal.ads.zzaf):android.util.Pair");
    }

    public final boolean zzc(int i) {
        return Arrays.binarySearch(this.zzd, i) >= 0;
    }
}
