package com.google.android.tv.ads.controls;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
final class zzf extends AnimatorListenerAdapter {
    final /* synthetic */ WhyThisAdFragment zza;

    zzf(WhyThisAdFragment whyThisAdFragment) {
        this.zza = whyThisAdFragment;
    }

    public final void onAnimationEnd(Animator animator) {
        this.zza.requireActivity().finish();
    }
}
