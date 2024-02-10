package com.google.android.gms.internal.cast;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final /* synthetic */ class zzbj implements OnFailureListener {
    public final /* synthetic */ zzbm zza;

    public /* synthetic */ zzbj(zzbm zzbm) {
        this.zza = zzbm;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzk(exc);
    }
}
