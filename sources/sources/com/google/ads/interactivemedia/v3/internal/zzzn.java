package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzzn extends zzxi {
    private final zzxi zza;
    private final zzyz zzb;

    public zzzn(zzwm zzwm, Type type, zzxi zzxi, zzyz zzyz) {
        this.zza = new zzaam(zzwm, zzxi, type);
        this.zzb = zzyz;
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        Collection collection = (Collection) this.zzb.zza();
        zzacv.zzj();
        while (zzacv.zzq()) {
            collection.add(this.zza.read(zzacv));
        }
        zzacv.zzl();
        return collection;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        Collection<Object> collection = (Collection) obj;
        if (collection == null) {
            zzacx.zzf();
            return;
        }
        zzacx.zza();
        for (Object write : collection) {
            this.zza.write(zzacx, write);
        }
        zzacx.zzc();
    }
}
