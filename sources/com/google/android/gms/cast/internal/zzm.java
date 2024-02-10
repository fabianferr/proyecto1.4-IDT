package com.google.android.gms.cast.internal;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzm extends zzae {
    final /* synthetic */ TaskCompletionSource zza;

    zzm(zzn zzn, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Bundle bundle) {
        this.zza.setResult(bundle);
    }
}
