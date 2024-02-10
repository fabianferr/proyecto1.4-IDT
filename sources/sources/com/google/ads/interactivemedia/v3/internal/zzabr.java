package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabr extends zzxi {
    zzabr() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        try {
            int zzc = zzacv.zzc();
            if (zzc <= 255 && zzc >= -128) {
                return Byte.valueOf((byte) zzc);
            }
            String zzf = zzacv.zzf();
            throw new zzwz("Lossy conversion from " + zzc + " to byte; at path " + zzf);
        } catch (NumberFormatException e) {
            throw new zzwz((Throwable) e);
        }
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            zzacx.zzf();
        } else {
            zzacx.zzh((long) number.byteValue());
        }
    }
}
