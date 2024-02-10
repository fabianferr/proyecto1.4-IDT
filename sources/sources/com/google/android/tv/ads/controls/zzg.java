package com.google.android.tv.ads.controls;

import android.animation.AnimatorSet;
import androidx.activity.OnBackPressedCallback;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
final class zzg extends OnBackPressedCallback {
    final /* synthetic */ AnimatorSet zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzg(WhyThisAdFragment whyThisAdFragment, boolean z, AnimatorSet animatorSet) {
        super(true);
        this.zza = animatorSet;
    }

    public final void handleOnBackPressed() {
        this.zza.start();
    }
}
