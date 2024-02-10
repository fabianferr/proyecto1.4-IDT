package com.google.android.gms.cast.framework.media;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.images.WebImage;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzn {
    public final Uri zza;
    public Bitmap zzb;

    public zzn(WebImage webImage) {
        this.zza = webImage == null ? null : webImage.getUrl();
    }
}
