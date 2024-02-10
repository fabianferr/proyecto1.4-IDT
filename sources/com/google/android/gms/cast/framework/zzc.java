package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final /* synthetic */ class zzc implements OnSuccessListener {
    public final /* synthetic */ CastContext zza;

    public /* synthetic */ zzc(CastContext castContext) {
        this.zza = castContext;
    }

    public final void onSuccess(Object obj) {
        this.zza.zzh((Bundle) obj);
    }
}
