package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaaw extends zzxi {
    zzaaw() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() != 9) {
            return new StringBuilder(zzacv.zzi());
        }
        zzacv.zzn();
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String str;
        StringBuilder sb = (StringBuilder) obj;
        if (sb == null) {
            str = null;
        } else {
            str = sb.toString();
        }
        zzacx.zzk(str);
    }
}
