package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzln extends zzmh {
    private final zzku zzi;

    public zzln(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2, zzku zzku) {
        super(zzkt, "p/A/ccj2XwTk/fSo3C/ujSOOKIukuf4p49eNYdQ49ojJfAAu/oSJpyibltiC1SFr", "awBf5sggk7Iiel8IwPwvWHZPhdA85Ytk82R2/ib4oV8=", zzaf, i, 85);
        this.zzi = zzku;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long[] jArr = (long[]) this.zzf.invoke((Object) null, new Object[]{Long.valueOf(this.zzi.zzd()), Long.valueOf(this.zzi.zzh()), Long.valueOf(this.zzi.zzb()), Long.valueOf(this.zzi.zzf())});
        synchronized (this.zze) {
            this.zze.zzv(jArr[0]);
            this.zze.zzu(jArr[1]);
        }
    }
}
