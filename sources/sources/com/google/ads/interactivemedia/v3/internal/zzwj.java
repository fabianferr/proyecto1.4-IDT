package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzwj extends zzxi {
    final /* synthetic */ zzxi zza;

    zzwj(zzxi zzxi) {
        this.zza = zzxi;
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        return new AtomicLong(((Number) this.zza.read(zzacv)).longValue());
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        this.zza.write(zzacx, Long.valueOf(((AtomicLong) obj).get()));
    }
}
