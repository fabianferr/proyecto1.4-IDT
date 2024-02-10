package com.google.android.tv.ads;

import android.content.Context;
import com.google.ads.interactivemedia.pal.PlatformSignalCollector;
import com.google.android.gms.internal.atv_ads_framework.zzd;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public final class SignalCollector implements PlatformSignalCollector {
    private final zzd zza = new zzd();

    public Task<Map<String, String>> collectSignals(Context context, ExecutorService executorService) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        context.getClass();
        executorService.getClass();
        executorService.execute(new zzg(this, taskCompletionSource, context));
        return taskCompletionSource.getTask();
    }
}
