package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.Cast;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzl extends Cast.Listener {
    final /* synthetic */ ExpandedControllerActivity zza;

    zzl(ExpandedControllerActivity expandedControllerActivity) {
        this.zza = expandedControllerActivity;
    }

    public final void onDeviceNameChanged() {
        this.zza.zzn();
    }
}
