package com.google.android.gms.cast.framework.media;

import android.graphics.Bitmap;
import com.google.android.gms.cast.framework.media.internal.zza;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzl implements zza {
    final /* synthetic */ zzn zza;
    final /* synthetic */ MediaNotificationService zzb;

    zzl(MediaNotificationService mediaNotificationService, zzn zzn) {
        this.zzb = mediaNotificationService;
        this.zza = zzn;
    }

    public final void zza(Bitmap bitmap) {
        zzn zzn = this.zza;
        zzn.zzb = bitmap;
        this.zzb.zzn = zzn;
        this.zzb.zzd();
    }
}
