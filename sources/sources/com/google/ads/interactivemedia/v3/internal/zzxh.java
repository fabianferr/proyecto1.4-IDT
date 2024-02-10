package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzxh extends zzxi {
    final /* synthetic */ zzxi zza;

    zzxh(zzxi zzxi) {
        this.zza = zzxi;
    }

    public final Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() != 9) {
            return this.zza.read(zzacv);
        }
        zzacv.zzn();
        return null;
    }

    public final void write(zzacx zzacx, Object obj) throws IOException {
        if (obj == null) {
            zzacx.zzf();
        } else {
            this.zza.write(zzacx, obj);
        }
    }
}
