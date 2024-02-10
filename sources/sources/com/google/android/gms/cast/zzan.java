package com.google.android.gms.cast;

import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzan implements OnCompleteListener {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    zzan(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    public final void onComplete(Task task) {
        if (!task.isSuccessful()) {
            this.zza.zzv("Unable to stop the remote display, result unsuccessful");
            CastRemoteDisplayLocalService.Callbacks callbacks = (CastRemoteDisplayLocalService.Callbacks) this.zza.zzg.get();
            if (callbacks != null) {
                callbacks.onRemoteDisplaySessionError(new Status(2202));
            }
        } else {
            this.zza.zzv("remote display stopped");
        }
        this.zza.zzn = null;
    }
}
