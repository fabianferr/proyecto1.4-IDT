package com.google.android.tv.ads.controls;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
final class zze extends CustomViewTarget {
    final /* synthetic */ WhyThisAdFragment zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zze(WhyThisAdFragment whyThisAdFragment, ImageView imageView) {
        super(imageView);
        this.zza = whyThisAdFragment;
    }

    public final void onLoadFailed(Drawable drawable) {
        this.zza.getParentFragmentManager().beginTransaction().setReorderingAllowed(true).replace(16908290, (Class<? extends Fragment>) ErrorMessageFragment.class, (Bundle) null).commit();
    }

    /* access modifiers changed from: protected */
    public final void onResourceCleared(Drawable drawable) {
        this.zza.zzb.setImageDrawable(drawable);
    }

    public final /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        this.zza.zzb.setImageDrawable((Drawable) obj);
    }
}
