package com.google.android.gms.internal.cast;

import android.graphics.Bitmap;
import com.google.android.gms.cast.framework.media.internal.zza;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzbv implements zza {
    final /* synthetic */ zzbw zza;

    zzbv(zzbw zzbw) {
        this.zza = zzbw;
    }

    public final void zza(Bitmap bitmap) {
        if (bitmap != null) {
            this.zza.zza.setImageBitmap(bitmap);
        }
    }
}
