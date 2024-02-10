package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzaac<T, A> extends zzxi<T> {
    final Map zza;

    zzaac(Map map) {
        this.zza = map;
    }

    public final T read(zzacv zzacv) throws IOException {
        if (zzacv.zzt() == 9) {
            zzacv.zzn();
            return null;
        }
        Object zza2 = zza();
        try {
            zzacv.zzk();
            while (zzacv.zzq()) {
                zzaad zzaad = (zzaad) this.zza.get(zzacv.zzh());
                if (zzaad != null) {
                    if (zzaad.zzm) {
                        zzc(zza2, zzacv, zzaad);
                    }
                }
                zzacv.zzp();
            }
            zzacv.zzm();
            return zzb(zza2);
        } catch (IllegalStateException e) {
            throw new zzwz((Throwable) e);
        } catch (IllegalAccessException e2) {
            throw zzacg.zzb(e2);
        }
    }

    public final void write(zzacx zzacx, T t) throws IOException {
        if (t == null) {
            zzacx.zzf();
            return;
        }
        zzacx.zzb();
        try {
            for (zzaad zzc : this.zza.values()) {
                zzc.zzc(zzacx, t);
            }
            zzacx.zzd();
        } catch (IllegalAccessException e) {
            throw zzacg.zzb(e);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza();

    /* access modifiers changed from: package-private */
    public abstract Object zzb(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzc(Object obj, zzacv zzacv, zzaad zzaad) throws IllegalAccessException, IOException;
}
