package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaay extends zzxi {
    zzaay() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() != 9) {
            return new StringBuffer(zzacv.zzi());
        }
        zzacv.zzn();
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String str;
        StringBuffer stringBuffer = (StringBuffer) obj;
        if (stringBuffer == null) {
            str = null;
        } else {
            str = stringBuffer.toString();
        }
        zzacx.zzk(str);
    }
}
