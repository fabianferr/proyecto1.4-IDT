package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzr extends zzad {
    private final CastStateListener zza;

    public zzr(CastStateListener castStateListener) {
        this.zza = castStateListener;
    }

    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final void zzc(int i) {
        this.zza.onCastStateChanged(i);
    }
}
