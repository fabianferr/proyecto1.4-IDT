package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final /* synthetic */ class zzbc implements RemoteCall {
    public final /* synthetic */ zzbt zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzbc(zzbt zzbt, boolean z) {
        this.zza = zzbt;
        this.zzb = z;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzL(this.zzb, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
