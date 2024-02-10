package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzza extends zzzd {
    final /* synthetic */ Method zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzza(Method method) {
        super((zzzc) null);
        this.zza = method;
    }

    public final boolean zza(AccessibleObject accessibleObject, Object obj) {
        try {
            return ((Boolean) this.zza.invoke(accessibleObject, new Object[]{obj})).booleanValue();
        } catch (Exception e) {
            throw new RuntimeException("Failed invoking canAccess", e);
        }
    }
}
