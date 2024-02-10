package com.google.android.gms.cast.framework.media.uicontroller;

import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.framework.media.widget.zzd;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzh extends zzd {
    final /* synthetic */ UIMediaController zza;

    zzh(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    public final void zza(CastSeekBar castSeekBar, int i, boolean z) {
        this.zza.zzc(castSeekBar, i, z);
    }

    public final void zzb(CastSeekBar castSeekBar) {
        this.zza.zzd(castSeekBar);
    }

    public final void zzc(CastSeekBar castSeekBar) {
        this.zza.zze(castSeekBar);
    }
}
