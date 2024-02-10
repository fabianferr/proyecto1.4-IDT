package com.google.android.gms.internal.cast;

import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzeh extends zzei {
    private final Choreographer zza = Choreographer.getInstance();

    public final void zza(zzef zzef) {
        this.zza.postFrameCallback(zzef.zzb());
    }
}
