package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzbr {
    public static PendingResult zza(Task task, zzbq zzbq, zzbq zzbq2) {
        zzbp zzbp = new zzbp(zzbq2);
        task.addOnSuccessListener(new zzbn(zzbp, zzbq)).addOnFailureListener(new zzbo(zzbp, zzbq2));
        return zzbp;
    }
}
