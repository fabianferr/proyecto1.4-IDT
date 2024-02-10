package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Build;
import com.google.ads.interactivemedia.pal.PlatformSignalCollector;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.ads.interactivemedia.v3.impl.data.zzbe;
import com.google.ads.interactivemedia.v3.impl.data.zzbf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.tv.ads.SignalCollector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzhg {
    private final Context zza;
    private final ExecutorService zzb;
    private final PlatformSignalCollector zzc;
    private final zzhc zzd;
    private final TaskCompletionSource zze;

    public zzhg(Context context, ExecutorService executorService, zzhc zzhc, TestingConfiguration testingConfiguration) {
        SignalCollector signalCollector = null;
        if (Build.VERSION.SDK_INT >= 26 && zzgq.zzb(context, testingConfiguration)) {
            signalCollector = new SignalCollector();
        }
        this.zze = new TaskCompletionSource();
        this.zza = context;
        this.zzb = executorService;
        this.zzd = zzhc;
        this.zzc = signalCollector;
    }

    public final Task zza() {
        return this.zze.getTask();
    }

    public final void zzb(Integer num) {
        PlatformSignalCollector platformSignalCollector = this.zzc;
        if (platformSignalCollector == null || num == null) {
            this.zze.setResult(null);
            return;
        }
        Task<T> withTimeout = Tasks.withTimeout(platformSignalCollector.collectSignals(this.zza, this.zzb), (long) num.intValue(), TimeUnit.MILLISECONDS);
        withTimeout.addOnSuccessListener(new zzhe(this.zze));
        withTimeout.addOnFailureListener(new zzhf(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Exception exc) {
        this.zzd.zzb(zzbe.PLATFORM_SIGNAL_COLLECTOR, zzbf.PLATFORM_COLLECT_SIGNALS, exc);
        this.zze.setException(exc);
    }
}
