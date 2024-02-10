package com.google.android.gms.internal.pal;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
public final class zzcz {
    /* access modifiers changed from: private */
    public NetworkCapabilities zza;

    zzcz(ConnectivityManager connectivityManager) {
        if (connectivityManager != null && Build.VERSION.SDK_INT >= 24) {
            try {
                connectivityManager.registerDefaultNetworkCallback(new zzcy(this));
            } catch (RuntimeException unused) {
                synchronized (zzcz.class) {
                    this.zza = null;
                }
            }
        }
    }

    public final NetworkCapabilities zza() {
        return this.zza;
    }
}
