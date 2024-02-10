package com.google.android.gms.internal.cast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class zzdz extends AnimatorListenerAdapter {
    private final SimpleArrayMap zza = new SimpleArrayMap();

    public final void onAnimationCancel(Animator animator) {
        this.zza.put(animator, true);
    }

    public final void onAnimationStart(Animator animator) {
        this.zza.put(animator, false);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(Animator animator) {
        return this.zza.containsKey(animator) && ((Boolean) this.zza.get(animator)).booleanValue();
    }
}
