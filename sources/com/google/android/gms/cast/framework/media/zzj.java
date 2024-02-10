package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzj extends zzc {
    final /* synthetic */ ImagePicker zza;

    /* synthetic */ zzj(ImagePicker imagePicker, zzi zzi) {
        this.zza = imagePicker;
    }

    public final WebImage zze(MediaMetadata mediaMetadata, int i) {
        return this.zza.onPickImage(mediaMetadata, i);
    }

    public final WebImage zzf(MediaMetadata mediaMetadata, ImageHints imageHints) {
        return this.zza.onPickImage(mediaMetadata, imageHints);
    }

    public final IObjectWrapper zzg() {
        return ObjectWrapper.wrap(this.zza);
    }
}
