package com.google.android.gms.cast.internal;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzas {
    public static boolean zza(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
    }
}
