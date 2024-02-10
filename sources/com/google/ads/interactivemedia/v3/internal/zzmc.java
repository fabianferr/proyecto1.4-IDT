package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzmc extends zzmh {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzmc(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2) {
        super(zzkt, "G4HwREIoiCx6D6Knjk8GQVRbuasfQrt56+TObFi9Ix4nWk1CG0hj6JTdJX3CIa7h", "t/7YlZ4nfipM+/xy58jm5M2tTyuTDvSiYT2ZDkTlVNY=", zzaf, i, 33);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (Long) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzV(zzi.longValue());
        }
    }
}
