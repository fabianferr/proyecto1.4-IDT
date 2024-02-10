package com.google.android.tv.ads.controls;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
final class zzb extends AnimatorListenerAdapter {
    final /* synthetic */ ErrorMessageFragment zza;

    zzb(ErrorMessageFragment errorMessageFragment) {
        this.zza = errorMessageFragment;
    }

    public final void onAnimationEnd(Animator animator) {
        this.zza.requireActivity().finish();
    }
}
