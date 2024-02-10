package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabp extends zzxi {
    zzabp() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        int zzt = zzacv.zzt();
        if (zzt == 9) {
            zzacv.zzn();
            return null;
        } else if (zzt == 6) {
            return Boolean.valueOf(Boolean.parseBoolean(zzacv.zzi()));
        } else {
            return Boolean.valueOf(zzacv.zzs());
        }
    }

    public final /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        zzacx.zzi((Boolean) obj);
    }
}
