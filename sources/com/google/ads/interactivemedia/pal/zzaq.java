package com.google.ads.interactivemedia.pal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
public final /* synthetic */ class zzaq implements Continuation {
    public final /* synthetic */ NonceManager zza;

    public /* synthetic */ zzaq(NonceManager nonceManager) {
        this.zza = nonceManager;
    }

    public final Object then(Task task) {
        this.zza.zzg(task);
        return null;
    }
}
