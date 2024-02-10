package com.google.android.gms.internal.atv_ads_framework;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
final class zzah extends zzab {
    final /* synthetic */ zzai zza;

    zzah(zzai zzai) {
        this.zza = zzai;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzn.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzai zzai = this.zza;
        int i2 = i + i;
        Object obj = zzai.zzb[i2];
        obj.getClass();
        Object obj2 = zzai.zzb[i2 + 1];
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
