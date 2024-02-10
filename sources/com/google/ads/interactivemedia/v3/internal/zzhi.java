package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.signals.SecureSignalsInitializeCallback;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzhi implements SecureSignalsInitializeCallback {
    final /* synthetic */ zzhk zza;

    zzhi(zzhk zzhk) {
        this.zza = zzhk;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzd.trySetException(exc);
    }

    public final void onSuccess() {
        this.zza.zzd.trySetResult(null);
    }
}
