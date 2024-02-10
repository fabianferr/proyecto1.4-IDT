package com.google.android.gms.internal.ads;

import androidx.media3.exoplayer.dash.DashMediaSource;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcjv {
    private final zzazp zza = new zzazp(true, 65536);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US;
    private int zzf;
    private boolean zzg;

    zzcjv() {
    }

    public final void zza() {
        zze(false);
    }

    public final void zzb() {
        zze(true);
    }

    public final void zzc() {
        zze(true);
    }

    public final void zzd(zzatb[] zzatbArr, zzayt zzayt, zzazf zzazf) {
        this.zzf = 0;
        for (int i = 0; i < 2; i++) {
            if (zzazf.zza(i) != null) {
                this.zzf += zzbar.zzf(zzatbArr[i].zzc());
            }
        }
        this.zza.zzf(this.zzf);
    }

    /* access modifiers changed from: package-private */
    public final void zze(boolean z) {
        this.zzf = 0;
        this.zzg = false;
        if (z) {
            this.zza.zze();
        }
    }

    public final synchronized void zzf(int i) {
        this.zzd = ((long) i) * 1000;
    }

    public final synchronized void zzg(int i) {
        this.zze = ((long) i) * 1000;
    }

    public final synchronized void zzh(int i) {
        this.zzc = ((long) i) * 1000;
    }

    public final synchronized void zzi(int i) {
        this.zzb = ((long) i) * 1000;
    }

    public final synchronized boolean zzj(long j) {
        boolean z;
        z = true;
        char c = j > this.zzc ? 0 : j < this.zzb ? (char) 2 : 1;
        int zza2 = this.zza.zza();
        int i = this.zzf;
        if (c != 2) {
            if (c != 1 || !this.zzg || zza2 >= i) {
                z = false;
            }
        }
        this.zzg = z;
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzk(long r5, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r7 == 0) goto L_0x0006
            long r0 = r4.zze     // Catch:{ all -> 0x0019 }
            goto L_0x0008
        L_0x0006:
            long r0 = r4.zzd     // Catch:{ all -> 0x0019 }
        L_0x0008:
            r2 = 0
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0016
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 < 0) goto L_0x0013
            goto L_0x0016
        L_0x0013:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x0016:
            monitor-exit(r4)
            r5 = 1
            return r5
        L_0x0019:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjv.zzk(long, boolean):boolean");
    }

    public final zzazp zzl() {
        return this.zza;
    }
}
