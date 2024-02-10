package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzqv implements OnCompleteListener {
    public final /* synthetic */ zzqw zza;

    public /* synthetic */ zzqv(zzqw zzqw) {
        this.zza = zzqw;
    }

    public final void onComplete(Task task) {
        zzqw zzqw = this.zza;
        if (task.isCanceled()) {
            zzqw.cancel(false);
        } else if (task.isSuccessful()) {
            zzqw.zzc(task.getResult());
        } else {
            Exception exception = task.getException();
            if (exception != null) {
                zzqw.zzd(exception);
                return;
            }
            throw new IllegalStateException();
        }
    }
}
