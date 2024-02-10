package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zza extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ zzh zza;

    zza(zzh zzh) {
        this.zza = zzh;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        zzh zzh = this.zza;
        if (zzh.zzk == null) {
            return true;
        }
        if (zzh.zzd.contains(Math.round(x), Math.round(y)) && this.zza.zze.zzg(x, y)) {
            return true;
        }
        this.zza.zzk.zza();
        return true;
    }
}
