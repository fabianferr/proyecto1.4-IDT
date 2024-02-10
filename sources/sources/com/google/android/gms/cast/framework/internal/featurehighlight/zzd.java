package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzd extends AnimatorListenerAdapter {
    final /* synthetic */ zzh zza;

    zzd(zzh zzh) {
        this.zza = zzh;
    }

    public final void onAnimationEnd(Animator animator) {
        zzh zzh = this.zza;
        zzh.zza = zzh.zza(zzh);
        this.zza.zza.start();
    }
}
