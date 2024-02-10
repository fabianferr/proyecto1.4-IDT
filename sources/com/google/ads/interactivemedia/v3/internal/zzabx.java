package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabx extends zzxi {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Map zzc = new HashMap();

    public zzabx(Class cls) {
        try {
            for (Field field : (Field[]) AccessController.doPrivileged(new zzabw(this, cls))) {
                Enum enumR = (Enum) field.get((Object) null);
                String name = enumR.name();
                String str = enumR.toString();
                zzxl zzxl = (zzxl) field.getAnnotation(zzxl.class);
                if (zzxl != null) {
                    name = zzxl.zza();
                    for (String put : zzxl.zzb()) {
                        this.zza.put(put, enumR);
                    }
                }
                this.zza.put(name, enumR);
                this.zzb.put(str, enumR);
                this.zzc.put(enumR, name);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        String zzi = zzacv.zzi();
        Enum enumR = (Enum) this.zza.get(zzi);
        if (enumR != null) {
            return enumR;
        }
        return (Enum) this.zzb.get(zzi);
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        String str;
        Enum enumR = (Enum) obj;
        if (enumR == null) {
            str = null;
        } else {
            str = (String) this.zzc.get(enumR);
        }
        zzacx.zzk(str);
    }
}
