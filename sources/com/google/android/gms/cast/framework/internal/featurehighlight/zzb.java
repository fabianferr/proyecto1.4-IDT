package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzb extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ View zza;
    final /* synthetic */ zzg zzb;

    zzb(zzh zzh, View view, boolean z, zzg zzg) {
        this.zza = view;
        this.zzb = zzg;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.zza.getParent() != null) {
            this.zza.performClick();
        }
        this.zzb.zzb();
        return true;
    }
}
