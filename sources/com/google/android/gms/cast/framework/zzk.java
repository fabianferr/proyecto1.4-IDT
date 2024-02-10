package com.google.android.gms.cast.framework;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final /* synthetic */ class zzk implements OnCompleteListener {
    public final /* synthetic */ zzm zza;

    public /* synthetic */ zzk(zzm zzm) {
        this.zza = zzm;
    }

    public final void onComplete(Task task) {
        CastSession.zzh(this.zza.zza, "joinApplication", task);
    }
}
