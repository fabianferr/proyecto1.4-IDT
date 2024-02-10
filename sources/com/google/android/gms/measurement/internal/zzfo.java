package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzfo implements zzo {
    final /* synthetic */ String zza;
    final /* synthetic */ zzfp zzb;

    zzfo(zzfp zzfp, String str) {
        this.zzb = zzfp;
        this.zza = str;
    }

    public final String zza(String str) {
        Map map = (Map) this.zzb.zzg.get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
