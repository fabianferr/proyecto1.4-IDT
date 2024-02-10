package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzag;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final /* synthetic */ class zzbb implements RemoteCall {
    public static final /* synthetic */ zzbb zza = new zzbb();

    private /* synthetic */ zzbb() {
    }

    public final void accept(Object obj, Object obj2) {
        int i = zzbt.zzf;
        ((zzag) ((zzx) obj).getService()).zzl();
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
