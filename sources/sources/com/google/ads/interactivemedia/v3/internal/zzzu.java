package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzzu extends zzxi {
    final /* synthetic */ zzzv zza;
    private final zzxi zzb;
    private final zzxi zzc;
    private final zzyz zzd;

    public zzzu(zzzv zzzv, zzwm zzwm, Type type, zzxi zzxi, Type type2, zzxi zzxi2, zzyz zzyz) {
        this.zza = zzzv;
        this.zzb = new zzaam(zzwm, zzxi, type);
        this.zzc = new zzaam(zzwm, zzxi2, type2);
        this.zzd = zzyz;
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        int zzt = zzacv.zzt();
        if (zzt == 9) {
            zzacv.zzn();
            return null;
        }
        Map map = (Map) this.zzd.zza();
        if (zzt == 1) {
            zzacv.zzj();
            while (zzacv.zzq()) {
                zzacv.zzj();
                Object read = this.zzb.read(zzacv);
                if (map.put(read, this.zzc.read(zzacv)) == null) {
                    zzacv.zzl();
                } else {
                    throw new zzwz("duplicate key: ".concat(String.valueOf(String.valueOf(read))));
                }
            }
            zzacv.zzl();
        } else {
            zzacv.zzk();
            while (zzacv.zzq()) {
                zzyp.zza.zza(zzacv);
                Object read2 = this.zzb.read(zzacv);
                if (map.put(read2, this.zzc.read(zzacv)) != null) {
                    throw new zzwz("duplicate key: ".concat(String.valueOf(String.valueOf(read2))));
                }
            }
            zzacv.zzm();
        }
        return map;
    }

    public final /* bridge */ /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        Map map = (Map) obj;
        if (map == null) {
            zzacx.zzf();
            return;
        }
        zzacx.zzb();
        for (Map.Entry entry : map.entrySet()) {
            zzacx.zze(String.valueOf(entry.getKey()));
            this.zzc.write(zzacx, entry.getValue());
        }
        zzacx.zzd();
    }
}
