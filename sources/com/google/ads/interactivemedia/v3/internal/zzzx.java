package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzzx extends zzxi {
    private static final zzxj zza = zzb(zzxf.LAZILY_PARSED_NUMBER);
    private final zzxg zzb;

    private zzzx(zzxg zzxg) {
        this.zzb = zzxg;
    }

    public static zzxj zza(zzxg zzxg) {
        return zzxg == zzxf.LAZILY_PARSED_NUMBER ? zza : zzb(zzxg);
    }

    private static zzxj zzb(zzxg zzxg) {
        return new zzzw(new zzzx(zzxg));
    }

    public final /* bridge */ /* synthetic */ Object read(zzacv zzacv) throws IOException {
        int zzt = zzacv.zzt();
        int i = zzt - 1;
        if (i == 5 || i == 6) {
            return this.zzb.zza(zzacv);
        }
        if (i == 8) {
            zzacv.zzn();
            return null;
        }
        throw new zzwz("Expecting number, got: " + zzacw.zza(zzt) + "; at path " + zzacv.zze());
    }

    public final /* synthetic */ void write(zzacx zzacx, Object obj) throws IOException {
        zzacx.zzj((Number) obj);
    }
}
