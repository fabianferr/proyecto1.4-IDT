package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.UUID;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabc extends zzxi {
    zzabc() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        String zzi = zzacv.zzi();
        try {
            return UUID.fromString(zzi);
        } catch (IllegalArgumentException e) {
            String zzf = zzacv.zzf();
            throw new zzwz("Failed parsing '" + zzi + "' as UUID; at path " + zzf, e);
        }
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String str;
        UUID uuid = (UUID) obj;
        if (uuid == null) {
            str = null;
        } else {
            str = uuid.toString();
        }
        zzacx.zzk(str);
    }
}
