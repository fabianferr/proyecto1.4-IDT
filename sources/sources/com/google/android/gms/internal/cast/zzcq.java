package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class zzcq extends UIController {
    private boolean zza = true;

    public void zza(boolean z) {
        this.zza = z;
    }

    public abstract void zzb(long j);

    public final boolean zzc() {
        return this.zza;
    }
}
