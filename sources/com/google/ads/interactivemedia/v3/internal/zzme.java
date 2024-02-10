package com.google.ads.interactivemedia.v3.internal;

import android.util.DisplayMetrics;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzme extends zzmh {
    private final View zzi;

    public zzme(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2, View view) {
        super(zzkt, "Ej2yGS8iLSerXuRH5SXMZhSv1h5iR+OEGG+Xroye4W9DaMYcNZrsfxI3jn+hN5N5", "FGSCgbeH3B6hvI00LjJ/IoouVDBI0HGtRb22Hc3rgt8=", zzaf, i, 57);
        this.zzi = view;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            Boolean bool = (Boolean) zznc.zzc().zzb(zznr.zzcY);
            Boolean bool2 = (Boolean) zznc.zzc().zzb(zznr.zzjq);
            DisplayMetrics displayMetrics = this.zzb.zzb().getResources().getDisplayMetrics();
            zzkx zzkx = new zzkx((String) this.zzf.invoke((Object) null, new Object[]{this.zzi, displayMetrics, bool, bool2}));
            zzba zza = zzbb.zza();
            zza.zzb(zzkx.zza.longValue());
            zza.zzd(zzkx.zzb.longValue());
            zza.zze(zzkx.zzc.longValue());
            if (bool2.booleanValue()) {
                zza.zzc(zzkx.zze.longValue());
            }
            if (bool.booleanValue()) {
                zza.zza(zzkx.zzd.longValue());
            }
            this.zze.zzY((zzbb) zza.zzak());
        }
    }
}
