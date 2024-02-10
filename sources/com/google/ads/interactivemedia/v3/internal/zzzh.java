package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Method;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzzh extends zzzk {
    final /* synthetic */ Method zza;
    final /* synthetic */ int zzb;

    zzzh(Method method, int i) {
        this.zza = method;
        this.zzb = i;
    }

    public final Object zza(Class cls) throws Exception {
        zzzk.zzb(cls);
        return this.zza.invoke((Object) null, new Object[]{cls, Integer.valueOf(this.zzb)});
    }
}
