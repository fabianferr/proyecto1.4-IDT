package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final /* synthetic */ class zzf implements RemoteCall {
    public final /* synthetic */ zzn zza;
    public final /* synthetic */ String[] zzb;

    public /* synthetic */ zzf(zzn zzn, String[] strArr) {
        this.zza = zzn;
        this.zzb = strArr;
    }

    public final void accept(Object obj, Object obj2) {
        zzn zzn = this.zza;
        String[] strArr = this.zzb;
        ((zzaj) ((zzo) obj).getService()).zzh(new zzl(zzn, (TaskCompletionSource) obj2), strArr);
    }
}
