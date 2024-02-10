package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzmb extends zzmh {
    private final zzla zzi;
    private long zzj;

    public zzmb(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2, zzla zzla) {
        super(zzkt, "lCoSMtrkOMYJWh7dS4CLhg/wqcWGOjemoO3bkIYH9oxmZbfKpryPLU6SBl2LuPWy", "5+3RGFY/3g50LDQYKc9yn9Kppn7/XDOIF0fA47Siqs0=", zzaf, i, 53);
        this.zzi = zzla;
        if (zzla != null) {
            this.zzj = zzla.zza();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            this.zze.zzP(((Long) this.zzf.invoke((Object) null, new Object[]{Long.valueOf(this.zzj)})).longValue());
        }
    }
}
