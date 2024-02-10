package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzacv;
import com.google.ads.interactivemedia.v3.internal.zzacx;
import com.google.ads.interactivemedia.v3.internal.zzxi;
import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzbs extends zzxi {
    zzbs() {
    }

    public zzbt read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() != 9) {
            return new zzbt(zzacv.zzi());
        }
        zzacv.zzn();
        return null;
    }

    public void write(zzacx zzacx, zzbt zzbt) throws IOException {
        if (zzbt == null) {
            zzacx.zzf();
        } else {
            zzacx.zzk(zzbt.getName());
        }
    }
}
