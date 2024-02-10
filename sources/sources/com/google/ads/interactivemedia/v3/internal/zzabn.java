package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabn extends zzxi {
    final /* synthetic */ Class zza;
    final /* synthetic */ zzabo zzb;

    zzabn(zzabo zzabo, Class cls) {
        this.zzb = zzabo;
        this.zza = cls;
    }

    public final Object read(zzacv zzacv) throws IOException {
        Object read = this.zzb.zzb.read(zzacv);
        if (read == null || this.zza.isInstance(read)) {
            return read;
        }
        String name = this.zza.getName();
        String name2 = read.getClass().getName();
        String zzf = zzacv.zzf();
        throw new zzwz("Expected a " + name + " but was " + name2 + "; at path " + zzf);
    }

    public final void write(zzacx zzacx, Object obj) throws IOException {
        this.zzb.zzb.write(zzacx, obj);
    }
}
