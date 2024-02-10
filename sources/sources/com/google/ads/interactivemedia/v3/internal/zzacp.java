package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzacp extends zzxi {
    static final zzxj zza = new zzacn();
    private final zzxi zzb;

    /* synthetic */ zzacp(zzxi zzxi, zzaco zzaco) {
        this.zzb = zzxi;
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        Date date = (Date) this.zzb.read(zzacv);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    public final /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        this.zzb.write(zzacx, (Timestamp) obj);
    }
}
