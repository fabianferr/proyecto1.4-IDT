package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzox implements Continuation {
    public final /* synthetic */ zzr zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzox(zzr zzr, int i) {
        this.zza = zzr;
        this.zzb = i;
    }

    public final Object then(Task task) {
        zzr zzr = this.zza;
        int i = this.zzb;
        int i2 = zzoy.zza;
        if (!task.isSuccessful()) {
            return false;
        }
        zzqn zza2 = ((zzqo) task.getResult()).zza(((zzv) zzr.zzak()).zzav());
        zza2.zza(i);
        zza2.zzc();
        return true;
    }
}
