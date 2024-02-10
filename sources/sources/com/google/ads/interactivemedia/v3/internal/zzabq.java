package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabq extends zzxi {
    zzabq() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() != 9) {
            return Boolean.valueOf(zzacv.zzi());
        }
        zzacv.zzn();
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String str;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            str = AbstractJsonLexerKt.NULL;
        } else {
            str = bool.toString();
        }
        zzacx.zzk(str);
    }
}
