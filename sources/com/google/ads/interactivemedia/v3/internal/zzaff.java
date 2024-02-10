package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public class zzaff {
    private static final zzaef zzb = zzaef.zza;
    protected volatile zzafz zza;
    private volatile zzadr zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaff)) {
            return false;
        }
        zzaff zzaff = (zzaff) obj;
        zzafz zzafz = this.zza;
        zzafz zzafz2 = zzaff.zza;
        if (zzafz == null && zzafz2 == null) {
            return zzb().equals(zzaff.zzb());
        }
        if (zzafz != null && zzafz2 != null) {
            return zzafz.equals(zzafz2);
        }
        if (zzafz != null) {
            zzaff.zzc(zzafz.zzaR());
            return zzafz.equals(zzaff.zza);
        }
        zzc(zzafz2.zzaR());
        return this.zza.equals(zzafz2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzado) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzax();
        }
        return 0;
    }

    public final zzadr zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzadr zzadr = this.zzc;
                return zzadr;
            }
            if (this.zza == null) {
                this.zzc = zzadr.zzb;
            } else {
                this.zzc = this.zza.zzau();
            }
            zzadr zzadr2 = this.zzc;
            return zzadr2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.ads.interactivemedia.v3.internal.zzafz r2) {
        /*
            r1 = this;
            com.google.ads.interactivemedia.v3.internal.zzafz r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.ads.interactivemedia.v3.internal.zzafz r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzafc -> 0x0011 }
            com.google.ads.interactivemedia.v3.internal.zzadr r0 = com.google.ads.interactivemedia.v3.internal.zzadr.zzb     // Catch:{ zzafc -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzafc -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.ads.interactivemedia.v3.internal.zzadr r2 = com.google.ads.interactivemedia.v3.internal.zzadr.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaff.zzc(com.google.ads.interactivemedia.v3.internal.zzafz):void");
    }
}
