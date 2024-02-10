package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzmh implements Callable {
    protected final String zza = getClass().getSimpleName();
    protected final zzkt zzb;
    protected final String zzc;
    protected final String zzd;
    protected final zzaf zze;
    protected Method zzf;
    protected final int zzg;
    protected final int zzh;

    public zzmh(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2) {
        this.zzb = zzkt;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzaf;
        this.zzg = i;
        this.zzh = i2;
    }

    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzd();
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzd() throws Exception {
        int i;
        try {
            long nanoTime = System.nanoTime();
            Method zzj = this.zzb.zzj(this.zzc, this.zzd);
            this.zzf = zzj;
            if (zzj == null) {
                return null;
            }
            zza();
            zzjk zzd2 = this.zzb.zzd();
            if (!(zzd2 == null || (i = this.zzg) == Integer.MIN_VALUE)) {
                zzd2.zzc(this.zzh, i, (System.nanoTime() - nanoTime) / 1000, (String) null, (Exception) null);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
