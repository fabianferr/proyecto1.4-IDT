package com.google.android.gms.cast.framework.media.widget;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ CastSeekBar zza;

    public /* synthetic */ zza(CastSeekBar castSeekBar) {
        this.zza = castSeekBar;
    }

    public final void run() {
        this.zza.sendAccessibilityEvent(4);
    }
}
