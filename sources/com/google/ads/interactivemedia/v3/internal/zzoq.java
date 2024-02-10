package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzoq extends zznz {
    final /* synthetic */ TaskCompletionSource zza;

    zzoq(zzor zzor, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(int i) {
        this.zza.trySetException(new zzol(i));
    }

    public final void zzc(zzoi zzoi) {
        this.zza.trySetResult(zzoi.zza());
    }
}
