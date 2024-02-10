package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabu extends zzxi {
    zzabu() {
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        try {
            return new AtomicInteger(zzacv.zzc());
        } catch (NumberFormatException e) {
            throw new zzwz((Throwable) e);
        }
    }

    public final /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        zzacx.zzh((long) ((AtomicInteger) obj).get());
    }
}
