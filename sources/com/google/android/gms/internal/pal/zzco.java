package com.google.android.gms.internal.pal;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
final class zzco implements Runnable {
    final /* synthetic */ zzcp zza;

    zzco(zzcp zzcp) {
        this.zza = zzcp;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:10|11|12|(2:16|17)|18|19|20|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0038 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            com.google.android.gms.internal.pal.zzcp r0 = r6.zza
            java.lang.Boolean r0 = r0.zzb
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            android.os.ConditionVariable r0 = com.google.android.gms.internal.pal.zzcp.zzc
            monitor-enter(r0)
            com.google.android.gms.internal.pal.zzcp r1 = r6.zza     // Catch:{ all -> 0x0049 }
            java.lang.Boolean r1 = r1.zzb     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x0014:
            r1 = 0
            com.google.android.gms.internal.pal.zzgm r2 = com.google.android.gms.internal.pal.zzgk.zzcc     // Catch:{ IllegalStateException -> 0x0022 }
            java.lang.Object r2 = r2.zzb()     // Catch:{ IllegalStateException -> 0x0022 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ IllegalStateException -> 0x0022 }
            boolean r2 = r2.booleanValue()     // Catch:{ IllegalStateException -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            r2 = 0
        L_0x0024:
            if (r2 == 0) goto L_0x0037
            com.google.android.gms.internal.pal.zzcp r3 = r6.zza     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.pal.zzdu r3 = r3.zze     // Catch:{ all -> 0x0038 }
            android.content.Context r3 = r3.zza     // Catch:{ all -> 0x0038 }
            java.lang.String r4 = "ADSHIELD"
            r5 = 0
            com.google.android.gms.internal.pal.zzhp r3 = com.google.android.gms.internal.pal.zzhp.zzb(r3, r4, r5)     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.pal.zzcp.zza = r3     // Catch:{ all -> 0x0038 }
        L_0x0037:
            r1 = r2
        L_0x0038:
            com.google.android.gms.internal.pal.zzcp r2 = r6.zza     // Catch:{ all -> 0x0049 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0049 }
            r2.zzb = r1     // Catch:{ all -> 0x0049 }
            android.os.ConditionVariable r1 = com.google.android.gms.internal.pal.zzcp.zzc     // Catch:{ all -> 0x0049 }
            r1.open()     // Catch:{ all -> 0x0049 }
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x0049:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzco.run():void");
    }
}
