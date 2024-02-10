package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.URL;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaaz extends zzxi {
    zzaaz() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        String zzi = zzacv.zzi();
        if (!AbstractJsonLexerKt.NULL.equals(zzi)) {
            return new URL(zzi);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String str;
        URL url = (URL) obj;
        if (url == null) {
            str = null;
        } else {
            str = url.toExternalForm();
        }
        zzacx.zzk(str);
    }
}
