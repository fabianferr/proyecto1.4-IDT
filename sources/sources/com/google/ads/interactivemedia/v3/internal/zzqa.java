package com.google.ads.interactivemedia.v3.internal;

import java.io.File;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzqa {
    private final zzmp zza;
    private final File zzb;
    private final File zzc;
    private final File zzd;
    private byte[] zze;

    public zzqa(zzmp zzmp, File file, File file2, File file3) {
        this.zza = zzmp;
        this.zzb = file;
        this.zzc = file3;
        this.zzd = file2;
    }

    public final zzmp zza() {
        return this.zza;
    }

    public final File zzb() {
        return this.zzc;
    }

    public final File zzc() {
        return this.zzb;
    }

    public final boolean zzd(long j) {
        return this.zza.zzb() - (System.currentTimeMillis() / 1000) < 3600;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zze() {
        /*
            r3 = this;
            byte[] r0 = r3.zze
            r1 = 0
            if (r0 != 0) goto L_0x0027
            java.io.File r0 = r3.zzd
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0020, all -> 0x001b }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0020, all -> 0x001b }
            com.google.ads.interactivemedia.v3.internal.zzadr r0 = com.google.ads.interactivemedia.v3.internal.zzadr.zzt(r2)     // Catch:{ IOException -> 0x0021, all -> 0x0018 }
            byte[] r0 = r0.zzx()     // Catch:{ IOException -> 0x0021, all -> 0x0018 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)
            goto L_0x0025
        L_0x0018:
            r0 = move-exception
            r1 = r2
            goto L_0x001c
        L_0x001b:
            r0 = move-exception
        L_0x001c:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r1)
            throw r0
        L_0x0020:
            r2 = r1
        L_0x0021:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)
            r0 = r1
        L_0x0025:
            r3.zze = r0
        L_0x0027:
            byte[] r0 = r3.zze
            if (r0 != 0) goto L_0x002c
            return r1
        L_0x002c:
            int r1 = r0.length
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzqa.zze():byte[]");
    }
}
