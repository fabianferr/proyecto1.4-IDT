package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Currency;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabd extends zzxi {
    zzabd() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        String zzi = zzacv.zzi();
        try {
            return Currency.getInstance(zzi);
        } catch (IllegalArgumentException e) {
            String zzf = zzacv.zzf();
            throw new zzwz("Failed parsing '" + zzi + "' as Currency; at path " + zzf, e);
        }
    }

    public final /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        zzacx.zzk(((Currency) obj).getCurrencyCode());
    }
}
