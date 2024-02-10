package com.google.android.gms.internal.cast;

import android.content.Context;
import androidx.mediarouter.media.MediaRouter;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzax {
    public MediaRouter zza;
    private final Context zzb;

    zzax(Context context) {
        this.zzb = context;
    }

    public final MediaRouter zza() {
        if (this.zza == null) {
            this.zza = MediaRouter.getInstance(this.zzb);
        }
        return this.zza;
    }

    public final void zzb(MediaRouter.Callback callback) {
        MediaRouter zza2 = zza();
        if (zza2 != null) {
            zza2.removeCallback(callback);
        }
    }
}
