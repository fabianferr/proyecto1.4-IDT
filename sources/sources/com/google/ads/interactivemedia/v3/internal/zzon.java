package com.google.ads.interactivemedia.v3.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzon implements RemoteCall {
    public final /* synthetic */ zzor zza;
    public final /* synthetic */ Bundle zzb;

    public /* synthetic */ zzon(zzor zzor, Bundle bundle) {
        this.zza = zzor;
        this.zzb = bundle;
    }

    public final void accept(Object obj, Object obj2) {
        zzor zzor = this.zza;
        ((zzof) ((zzos) obj).getService()).zzf(this.zzb, new zzop(zzor, (TaskCompletionSource) obj2));
    }
}
