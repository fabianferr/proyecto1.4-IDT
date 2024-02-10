package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzlx extends zzmh {
    private List zzi = null;
    private final Context zzj;

    public zzlx(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2, Context context) {
        super(zzkt, "K2yt7sMugiuzyW5oDmhKskHNQBBOsHDDPcpPCPcBdPJWVC2ztIWYwYMcSE9mqAdn", "qN3ycr+d8i2SnhKKiTJ61fKGYnOxAv7mkp7XRiCE7xg=", zzaf, i, 31);
        this.zzj = context;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzW(-1);
        this.zze.zzS(-1);
        Context context = this.zzj;
        if (context == null) {
            context = this.zzb.zzb();
        }
        if (this.zzi == null) {
            this.zzi = (List) this.zzf.invoke((Object) null, new Object[]{context});
        }
        List list = this.zzi;
        if (list != null && list.size() == 2) {
            synchronized (this.zze) {
                this.zze.zzW(((Long) this.zzi.get(0)).longValue());
                this.zze.zzS(((Long) this.zzi.get(1)).longValue());
            }
        }
    }
}
