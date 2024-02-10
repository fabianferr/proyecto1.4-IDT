package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzacu extends zzyp {
    zzacu() {
    }

    public final void zza(zzacv zzacv) throws IOException {
        int i;
        int i2 = zzacv.zza;
        if (i2 == 0) {
            i2 = zzacv.zzb();
        }
        if (i2 == 13) {
            i = 9;
        } else if (i2 == 12) {
            i = 8;
        } else if (i2 == 14) {
            i = 10;
        } else {
            throw new IllegalStateException(zzacw.zzb(zzacv, "Expected a name but was "));
        }
        zzacv.zza = i;
    }
}
