package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzzm extends zzxi {
    public static final zzxj zza = new zzzl();
    private final Class zzb;
    private final zzxi zzc;

    public zzzm(zzwm zzwm, zzxi zzxi, Class cls) {
        this.zzc = new zzaam(zzwm, zzxi, cls);
        this.zzb = cls;
    }

    public final Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        zzacv.zzj();
        while (zzacv.zzq()) {
            arrayList.add(this.zzc.read(zzacv));
        }
        zzacv.zzl();
        int size = arrayList.size();
        if (!this.zzb.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance(this.zzb, size));
        }
        Object newInstance = Array.newInstance(this.zzb, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    public final void write(zzacx zzacx, Object obj) throws IOException {
        if (obj == null) {
            zzacx.zzf();
            return;
        }
        zzacx.zza();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.zzc.write(zzacx, Array.get(obj, i));
        }
        zzacx.zzc();
    }
}
