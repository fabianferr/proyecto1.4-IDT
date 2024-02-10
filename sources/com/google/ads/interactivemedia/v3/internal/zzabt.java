package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabt extends zzxi {
    zzabt() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        try {
            return Integer.valueOf(zzacv.zzc());
        } catch (NumberFormatException e) {
            throw new zzwz((Throwable) e);
        }
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            zzacx.zzf();
        } else {
            zzacx.zzh((long) number.intValue());
        }
    }
}
