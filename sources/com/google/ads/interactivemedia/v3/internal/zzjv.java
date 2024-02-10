package com.google.ads.interactivemedia.v3.internal;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzjv extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzjw zza;

    zzjv(zzjw zzjw) {
        this.zza = zzjw;
    }

    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzjw.class) {
            this.zza.zza = networkCapabilities;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzjw.class) {
            this.zza.zza = null;
        }
    }
}
