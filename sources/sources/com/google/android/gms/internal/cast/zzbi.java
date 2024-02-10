package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final /* synthetic */ class zzbi implements OnSuccessListener {
    public final /* synthetic */ zzbm zza;

    public /* synthetic */ zzbi(zzbm zzbm) {
        this.zza = zzbm;
    }

    public final void onSuccess(Object obj) {
        zzbm.zzd(this.zza, (SessionState) obj);
    }
}
