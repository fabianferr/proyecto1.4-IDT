package com.google.android.gms.cast.framework;

import android.content.Context;
import android.preference.PreferenceManager;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzav {
    public static void zza(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("googlecast-introOverlayShown", true).apply();
    }
}
