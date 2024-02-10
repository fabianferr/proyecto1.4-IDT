package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaar extends zzxi {
    zzaar() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        String zzi = zzacv.zzi();
        if (zzi.length() == 1) {
            return Character.valueOf(zzi.charAt(0));
        }
        String zzf = zzacv.zzf();
        throw new zzwz("Expecting character, got: " + zzi + "; at " + zzf);
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String str;
        Character ch = (Character) obj;
        if (ch == null) {
            str = null;
        } else {
            str = ch.toString();
        }
        zzacx.zzk(str);
    }
}
