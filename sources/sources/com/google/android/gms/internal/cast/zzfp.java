package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzfp extends zzfh {
    final /* synthetic */ zzfq zza;

    zzfp(zzfq zzfq) {
        this.zza = zzfq;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzeu.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzfq zzfq = this.zza;
        int i2 = i + i;
        Object obj = zzfq.zzb[i2];
        obj.getClass();
        Object obj2 = zzfq.zzb[i2 + 1];
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
