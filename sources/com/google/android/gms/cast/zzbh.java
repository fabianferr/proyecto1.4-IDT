package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final /* synthetic */ class zzbh implements RemoteCall {
    public final /* synthetic */ zzbt zza;
    public final /* synthetic */ double zzb;

    public /* synthetic */ zzbh(zzbt zzbt, double d) {
        this.zza = zzbt;
        this.zzb = d;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzM(this.zzb, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
