package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzwl<T> extends zzaah<T> {
    private zzxi zza = null;

    zzwl() {
    }

    private final zzxi zzc() {
        zzxi zzxi = this.zza;
        if (zzxi != null) {
            return zzxi;
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    public final T read(zzacv zzacv) throws IOException {
        return zzc().read(zzacv);
    }

    public final void write(zzacx zzacx, T t) throws IOException {
        zzc().write(zzacx, t);
    }

    public final zzxi zza() {
        return zzc();
    }

    public final void zzb(zzxi zzxi) {
        if (this.zza == null) {
            this.zza = zzxi;
            return;
        }
        throw new AssertionError("Delegate is already set");
    }
}
