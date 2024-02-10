package com.google.android.tv.ads.controls;

import android.animation.AnimatorSet;
import android.view.View;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public final /* synthetic */ class zzd implements View.OnClickListener {
    public final /* synthetic */ AnimatorSet zza;

    public /* synthetic */ zzd(AnimatorSet animatorSet) {
        this.zza = animatorSet;
    }

    public final void onClick(View view) {
        AnimatorSet animatorSet = this.zza;
        int i = WhyThisAdFragment.zza;
        animatorSet.start();
    }
}
