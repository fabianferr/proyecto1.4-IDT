package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Bitmap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzfa implements OnCompleteListener {
    public final /* synthetic */ zzfb zza;

    public /* synthetic */ zzfa(zzfb zzfb) {
        this.zza = zzfb;
    }

    public final void onComplete(Task task) {
        zzfb zzfb = this.zza;
        if (task.isSuccessful()) {
            zzfb.setImageBitmap((Bitmap) task.getResult());
        } else {
            zzhd.zzb("Image companion error", task.getException());
        }
    }
}
