package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.omid.library.adsession.zze;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzbx {
    private static final zzbx zza = new zzbx();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzbx() {
    }

    public static zzbx zza() {
        return zza;
    }

    public final Collection zzb() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final Collection zzc() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final void zzd(zze zze) {
        this.zzb.add(zze);
    }

    public final void zze(zze zze) {
        boolean zzg = zzg();
        this.zzb.remove(zze);
        this.zzc.remove(zze);
        if (zzg && !zzg()) {
            zzcd.zzb().zzf();
        }
    }

    public final void zzf(zze zze) {
        boolean zzg = zzg();
        this.zzc.add(zze);
        if (!zzg) {
            zzcd.zzb().zze();
        }
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
