package com.google.android.gms.internal.cast;

import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final /* synthetic */ class zzee implements Choreographer.FrameCallback {
    public final /* synthetic */ zzef zza;

    public /* synthetic */ zzee(zzef zzef) {
        this.zza = zzef;
    }

    public final void doFrame(long j) {
        this.zza.zza(j);
    }
}
