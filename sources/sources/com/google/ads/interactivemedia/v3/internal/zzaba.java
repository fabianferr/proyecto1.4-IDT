package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaba extends zzxi {
    zzaba() {
    }

    public static final URI zza(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        try {
            String zzi = zzacv.zzi();
            if (AbstractJsonLexerKt.NULL.equals(zzi)) {
                return null;
            }
            return new URI(zzi);
        } catch (URISyntaxException e) {
            throw new zzws((Throwable) e);
        }
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        return zza(zzacv);
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String str;
        URI uri = (URI) obj;
        if (uri == null) {
            str = null;
        } else {
            str = uri.toASCIIString();
        }
        zzacx.zzk(str);
    }
}
