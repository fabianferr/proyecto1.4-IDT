package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaap extends zzxi {
    zzaap() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() != 9) {
            return Float.valueOf((float) zzacv.zza());
        }
        zzacv.zzn();
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            zzacx.zzf();
            return;
        }
        if (!(number instanceof Float)) {
            number = Float.valueOf(number.floatValue());
        }
        zzacx.zzj(number);
    }
}
