package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final /* synthetic */ class zzbi implements RemoteCall {
    public final /* synthetic */ zzbt zza;
    public final /* synthetic */ Cast.MessageReceivedCallback zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbi(zzbt zzbt, Cast.MessageReceivedCallback messageReceivedCallback, String str) {
        this.zza = zzbt;
        this.zzb = messageReceivedCallback;
        this.zzc = str;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzI(this.zzb, this.zzc, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
