package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.signals.SecureSignalsCollectSignalsCallback;
import com.google.ads.interactivemedia.v3.impl.data.zzbo;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzhj implements SecureSignalsCollectSignalsCallback {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzhk zzb;

    zzhj(zzhk zzhk, TaskCompletionSource taskCompletionSource) {
        this.zzb = zzhk;
        this.zza = taskCompletionSource;
    }

    public final void onFailure(Exception exc) {
        this.zza.trySetException(exc);
    }

    public final void onSuccess(String str) {
        this.zza.trySetResult(zzbo.createBy3rdPartyData(this.zzb.zza.getVersion(), this.zzb.zza.getSDKVersion(), this.zzb.zze(), str));
    }
}
