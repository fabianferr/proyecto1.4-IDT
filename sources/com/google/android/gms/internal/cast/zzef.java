package com.google.android.gms.internal.cast;

import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class zzef {
    private Runnable zza;
    private Choreographer.FrameCallback zzb;

    public abstract void zza(long j);

    /* access modifiers changed from: package-private */
    public final Choreographer.FrameCallback zzb() {
        if (this.zzb == null) {
            this.zzb = new zzee(this);
        }
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final Runnable zzc() {
        if (this.zza == null) {
            this.zza = new zzed(this);
        }
        return this.zza;
    }
}
