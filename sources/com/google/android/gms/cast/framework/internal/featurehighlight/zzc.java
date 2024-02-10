package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzc implements View.OnLayoutChangeListener {
    final /* synthetic */ zzh zza;

    zzc(zzh zzh, Runnable runnable) {
        this.zza = zzh;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.zza.zzk();
        this.zza.removeOnLayoutChangeListener(this);
    }
}
