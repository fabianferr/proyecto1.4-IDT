package com.google.ads.interactivemedia.v3.internal;

import java.sql.Timestamp;
import java.util.Date;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzacn implements zzxj {
    zzacn() {
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        if (zzact.zzc() == Timestamp.class) {
            return new zzacp(zzwm.zza(zzact.zza(Date.class)), (zzaco) null);
        }
        return null;
    }
}
