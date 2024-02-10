package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzls extends zzmh {
    private final zzjw zzi;
    private final long zzj;
    private final long zzk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzls(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2, zzjw zzjw, long j, long j2) {
        super(zzkt, "pWAUg19KAgbwvVb08UZ+WRVtI+wSJ32ythZZQ+2Q8wdPNCcfyqxe0xECFWJWfihd", "co+8KyXO1IB0hjlJbthCyJFCHnQQRnPimPVhit2qc2E=", zzaf, i, 11);
        this.zzi = zzjw;
        this.zzj = j;
        this.zzk = j2;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzjw zzjw = this.zzi;
        if (zzjw != null) {
            zzju zzju = new zzju((String) this.zzf.invoke((Object) null, new Object[]{zzjw.zzb(), Long.valueOf(this.zzj), Long.valueOf(this.zzk)}));
            synchronized (this.zze) {
                this.zze.zzz(zzju.zza.longValue());
                if (zzju.zzb.longValue() >= 0) {
                    this.zze.zzQ(zzju.zzb.longValue());
                }
                if (zzju.zzc.longValue() >= 0) {
                    this.zze.zzf(zzju.zzc.longValue());
                }
            }
        }
    }
}
