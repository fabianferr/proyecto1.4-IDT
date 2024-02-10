package com.google.ads.interactivemedia.v3.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zztj extends zzso {
    final /* synthetic */ zztk zza;

    zztj(zztk zztk) {
        this.zza = zztk;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzrm.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zztk zztk = this.zza;
        int i2 = i + i;
        Object obj = zztk.zzb[i2];
        obj.getClass();
        Object obj2 = zztk.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
