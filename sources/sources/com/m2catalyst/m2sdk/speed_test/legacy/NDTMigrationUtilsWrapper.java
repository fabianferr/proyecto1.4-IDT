package com.m2catalyst.m2sdk.speed_test.legacy;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/m2catalyst/m2sdk/speed_test/legacy/NDTMigrationUtilsWrapper;", "", "()V", "getActiveDataNetworkType", "", "context", "Landroid/content/Context;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NDTMigrationUtilsWrapper.kt */
public final class NDTMigrationUtilsWrapper {
    public static final NDTMigrationUtilsWrapper INSTANCE = new NDTMigrationUtilsWrapper();

    private NDTMigrationUtilsWrapper() {
    }

    public final int getActiveDataNetworkType(Context context) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        NetworkInfo networkInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType();
            }
            return -1;
        } else if (i <= 27) {
            Network activeNetwork2 = connectivityManager.getActiveNetwork();
            if (activeNetwork2 == null || (networkInfo = connectivityManager.getNetworkInfo(activeNetwork2)) == null) {
                return -1;
            }
            return networkInfo.getType();
        } else if (i < 28 || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return -1;
        } else {
            if (networkCapabilities.hasTransport(0)) {
                return 0;
            }
            if (networkCapabilities.hasTransport(1)) {
                return 1;
            }
            if (networkCapabilities.hasTransport(2)) {
                return 2;
            }
            if (networkCapabilities.hasTransport(3)) {
                return 9;
            }
            if (networkCapabilities.hasTransport(4)) {
                return 17;
            }
            if (!networkCapabilities.hasTransport(5) && !networkCapabilities.hasTransport(6)) {
                return -1;
            }
            return 9;
        }
    }
}
