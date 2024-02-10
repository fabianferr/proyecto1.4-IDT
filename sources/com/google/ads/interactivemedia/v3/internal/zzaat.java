package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.math.BigDecimal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaat extends zzxi {
    zzaat() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        String zzi = zzacv.zzi();
        try {
            return new BigDecimal(zzi);
        } catch (NumberFormatException e) {
            String zzf = zzacv.zzf();
            throw new zzwz("Failed parsing '" + zzi + "' as BigDecimal; at path " + zzf, e);
        }
    }

    public final /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        zzacx.zzj((BigDecimal) obj);
    }
}
