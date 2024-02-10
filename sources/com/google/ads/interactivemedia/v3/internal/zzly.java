package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzly extends zzmh {
    private final boolean zzi;

    public zzly(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2) {
        super(zzkt, "JJbNN7XyofoYaARMXQW5DKeTyphTd+fR1lwPgm3YPVKPRzCxxynyFTxvoAQx19eb", "B3bWp0EAkYrByBBJaWCAWLXOEGZHdUcl2VYPVWjxp/Y=", zzaf, i, 61);
        this.zzi = zzkt.zzs();
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb(), Boolean.valueOf(this.zzi)})).longValue();
        synchronized (this.zze) {
            this.zze.zzE(longValue);
        }
    }
}
