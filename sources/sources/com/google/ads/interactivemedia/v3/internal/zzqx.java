package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzqx {
    public static zzvq zza(Task task) {
        zzqw zzqw = new zzqw(task);
        task.addOnCompleteListener(zzvw.zzb(), new zzqv(zzqw));
        return zzqw;
    }
}
