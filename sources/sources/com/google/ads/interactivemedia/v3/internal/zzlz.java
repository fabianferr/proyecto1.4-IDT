package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzlz extends zzmh {
    private final StackTraceElement[] zzi;

    public zzlz(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzkt, "c1kwIqDUt3eWAvCNkbABb9gMelky1LQri6Meuw58pR9sFDLpUMniqwXzwcy1jftP", "HqknIq5XGienhA1/6NdBPO+lKaPIpkMOC/sqE+FKLYc=", zzaf, i, 45);
        this.zzi = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        Object obj = this.zzi;
        if (obj != null) {
            int i = 1;
            zzkk zzkk = new zzkk((String) this.zzf.invoke((Object) null, new Object[]{obj}));
            synchronized (this.zze) {
                this.zze.zzF(zzkk.zza.longValue());
                if (zzkk.zzb.booleanValue()) {
                    zzaf zzaf = this.zze;
                    if (true != zzkk.zzc.booleanValue()) {
                        i = 2;
                    }
                    zzaf.zzac(i);
                } else {
                    this.zze.zzac(3);
                }
            }
        }
    }
}
