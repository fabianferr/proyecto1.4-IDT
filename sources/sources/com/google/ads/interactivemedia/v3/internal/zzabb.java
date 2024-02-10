package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.InetAddress;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabb extends zzxi {
    zzabb() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() != 9) {
            return InetAddress.getByName(zzacv.zzi());
        }
        zzacv.zzn();
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String str;
        InetAddress inetAddress = (InetAddress) obj;
        if (inetAddress == null) {
            str = null;
        } else {
            str = inetAddress.getHostAddress();
        }
        zzacx.zzk(str);
    }
}
