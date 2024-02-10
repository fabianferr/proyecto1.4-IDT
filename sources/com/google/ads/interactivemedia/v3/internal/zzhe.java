package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzhe implements OnSuccessListener {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzhe(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onSuccess(Object obj) {
        this.zza.setResult((Map) obj);
    }
}
