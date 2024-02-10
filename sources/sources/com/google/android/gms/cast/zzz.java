package com.google.android.gms.cast;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.cast.zzdn;
import com.google.android.gms.internal.cast.zzds;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final /* synthetic */ class zzz implements RemoteCall {
    public final /* synthetic */ CastRemoteDisplayClient zza;

    public /* synthetic */ zzz(CastRemoteDisplayClient castRemoteDisplayClient) {
        this.zza = castRemoteDisplayClient;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzds) ((zzdn) obj).getService()).zzi(new zzad(this.zza, (TaskCompletionSource) obj2));
    }
}
