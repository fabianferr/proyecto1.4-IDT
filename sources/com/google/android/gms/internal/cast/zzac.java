package com.google.android.gms.internal.cast;

import android.os.Bundle;
import com.facebook.login.widget.ToolTipPopup;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzac {
    private static long zza = 6000;
    private static boolean zzb = false;

    public static long zza() {
        return zza;
    }

    public static /* synthetic */ void zzb(Bundle bundle) {
        bundle.getLong("com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_UPDATE_DEVICES_DELAY_MS", 300);
        bundle.getLong("com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_DISCOVERY_TIMEOUT_MS", 10000);
        zza = bundle.getLong("com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_ZERO_DEVICE_TIMEOUT_MS", ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        zzb = bundle.getBoolean("com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_ENABLE_WIFI_WARNING", false);
    }

    public static boolean zzc() {
        return zzb;
    }
}
