package com.google.android.tv.ads;

import android.content.Context;
import com.google.android.gms.internal.atv_ads_framework.zzd;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public final /* synthetic */ class zzg implements Runnable {
    public final /* synthetic */ SignalCollector zza;
    public final /* synthetic */ TaskCompletionSource zzb;
    public final /* synthetic */ Context zzc;

    public /* synthetic */ zzg(SignalCollector signalCollector, TaskCompletionSource taskCompletionSource, Context context) {
        this.zza = signalCollector;
        this.zzb = taskCompletionSource;
        this.zzc = context;
    }

    public final void run() {
        TaskCompletionSource taskCompletionSource = this.zzb;
        try {
            taskCompletionSource.setResult(zzd.zzb(this.zzc));
        } catch (IllegalStateException e) {
            taskCompletionSource.setException(e);
        }
    }
}
