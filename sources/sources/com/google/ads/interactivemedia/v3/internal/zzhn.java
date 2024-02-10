package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzhn implements Continuation {
    public final /* synthetic */ zzhu zza;

    public /* synthetic */ zzhn(zzhu zzhu) {
        this.zza = zzhu;
    }

    public final Object then(Task task) {
        return zzhu.zza(this.zza, task);
    }
}
