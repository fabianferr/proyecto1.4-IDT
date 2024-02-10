package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaam<T> extends zzxi<T> {
    private final zzwm zza;
    private final zzxi zzb;
    private final Type zzc;

    zzaam(zzwm zzwm, zzxi zzxi, Type type) {
        this.zza = zzwm;
        this.zzb = zzxi;
        this.zzc = type;
    }

    public final T read(zzacv zzacv) throws IOException {
        return this.zzb.read(zzacv);
    }

    public final void write(zzacx zzacx, T t) throws IOException {
        zzxi zza2;
        zzxi zzxi = this.zzb;
        Type type = this.zzc;
        Type type2 = (t == null || (!(type instanceof Class) && !(type instanceof TypeVariable))) ? type : t.getClass();
        if (type2 != type) {
            zzxi = this.zza.zza(zzact.zzb(type2));
            if (zzxi instanceof zzaac) {
                zzxi zzxi2 = this.zzb;
                while ((zzxi2 instanceof zzaah) && (zza2 = ((zzaah) zzxi2).zza()) != zzxi2) {
                    zzxi2 = zza2;
                }
                if (!(zzxi2 instanceof zzaac)) {
                    zzxi = this.zzb;
                }
            }
        }
        zzxi.write(zzacx, t);
    }
}
