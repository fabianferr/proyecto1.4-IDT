package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public class zzjt {
    private static final zzio zza = zzio.zzb();
    private zzht zzb;
    private volatile zzkk zzc;
    private volatile zzht zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjt)) {
            return false;
        }
        zzjt zzjt = (zzjt) obj;
        zzkk zzkk = this.zzc;
        zzkk zzkk2 = zzjt.zzc;
        if (zzkk == null && zzkk2 == null) {
            return zzc().equals(zzjt.zzc());
        }
        if (zzkk != null && zzkk2 != null) {
            return zzkk.equals(zzkk2);
        }
        if (zzkk != null) {
            return zzkk.equals(zzjt.zzb(zzkk.zzr()));
        }
        return zzb(zzkk2.zzr()).equals(zzkk2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.vision.zzkk zzb(com.google.android.gms.internal.vision.zzkk r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.vision.zzkk r0 = r1.zzc
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.vision.zzkk r0 = r1.zzc     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzc = r2     // Catch:{ zzjk -> 0x0012 }
            com.google.android.gms.internal.vision.zzht r0 = com.google.android.gms.internal.vision.zzht.zza     // Catch:{ zzjk -> 0x0012 }
            r1.zzd = r0     // Catch:{ zzjk -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzc = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.vision.zzht r2 = com.google.android.gms.internal.vision.zzht.zza     // Catch:{ all -> 0x001a }
            r1.zzd = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.vision.zzkk r2 = r1.zzc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjt.zzb(com.google.android.gms.internal.vision.zzkk):com.google.android.gms.internal.vision.zzkk");
    }

    public final zzkk zza(zzkk zzkk) {
        zzkk zzkk2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzkk;
        return zzkk2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzm();
        }
        return 0;
    }

    public final zzht zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzht zzht = this.zzd;
                return zzht;
            }
            if (this.zzc == null) {
                this.zzd = zzht.zza;
            } else {
                this.zzd = this.zzc.zzg();
            }
            zzht zzht2 = this.zzd;
            return zzht2;
        }
    }
}
