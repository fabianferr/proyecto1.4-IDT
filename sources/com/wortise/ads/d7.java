package com.wortise.ads;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.os.Build;
import com.wortise.ads.consent.ConsentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\n"}, d2 = {"Lcom/wortise/ads/d7;", "", "Landroid/content/Context;", "context", "Landroid/net/wifi/WifiInfo;", "b", "Lcom/wortise/ads/c7;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: WifiFactory.kt */
public final class d7 {
    public static final d7 a = new d7();

    private d7() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[Catch:{ all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0053 A[Catch:{ all -> 0x005f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.net.wifi.WifiInfo b(android.content.Context r4) {
        /*
            r3 = this;
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x005f }
            r2 = 31
            if (r1 >= r2) goto L_0x001d
            java.lang.String r1 = "wifi"
            java.lang.Object r4 = r4.getSystemService(r1)     // Catch:{ all -> 0x005f }
            boolean r1 = r4 instanceof android.net.wifi.WifiManager     // Catch:{ all -> 0x005f }
            if (r1 != 0) goto L_0x0013
            r4 = r0
        L_0x0013:
            android.net.wifi.WifiManager r4 = (android.net.wifi.WifiManager) r4     // Catch:{ all -> 0x005f }
            if (r4 != 0) goto L_0x0018
            goto L_0x001c
        L_0x0018:
            android.net.wifi.WifiInfo r0 = r4.getConnectionInfo()     // Catch:{ all -> 0x005f }
        L_0x001c:
            return r0
        L_0x001d:
            java.lang.String r1 = "connectivity"
            java.lang.Object r4 = r4.getSystemService(r1)     // Catch:{ all -> 0x005f }
            boolean r1 = r4 instanceof android.net.ConnectivityManager     // Catch:{ all -> 0x005f }
            if (r1 != 0) goto L_0x0028
            r4 = r0
        L_0x0028:
            android.net.ConnectivityManager r4 = (android.net.ConnectivityManager) r4     // Catch:{ all -> 0x005f }
            if (r4 != 0) goto L_0x002d
            return r0
        L_0x002d:
            android.net.Network r1 = r4.getActiveNetwork()     // Catch:{ all -> 0x005f }
            android.net.NetworkCapabilities r4 = r4.getNetworkCapabilities(r1)     // Catch:{ all -> 0x005f }
            if (r4 != 0) goto L_0x0038
            goto L_0x0040
        L_0x0038:
            r1 = 1
            boolean r2 = r4.hasTransport(r1)     // Catch:{ all -> 0x005f }
            if (r2 != r1) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r1 = 0
        L_0x0041:
            if (r1 == 0) goto L_0x0053
            if (r4 != 0) goto L_0x0047
            r4 = r0
            goto L_0x004b
        L_0x0047:
            android.net.TransportInfo r4 = r4.getTransportInfo()     // Catch:{ all -> 0x005f }
        L_0x004b:
            boolean r1 = r4 instanceof android.net.wifi.WifiInfo     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x005f
            android.net.wifi.WifiInfo r4 = (android.net.wifi.WifiInfo) r4     // Catch:{ all -> 0x005f }
            r0 = r4
            goto L_0x005f
        L_0x0053:
            java.lang.String r4 = "Failed requirement."
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x005f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005f }
            r1.<init>(r4)     // Catch:{ all -> 0x005f }
            throw r1     // Catch:{ all -> 0x005f }
        L_0x005f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.d7.b(android.content.Context):android.net.wifi.WifiInfo");
    }

    public final c7 a(Context context) {
        WifiInfo b;
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = null;
        if (!ConsentManager.canCollectData(context) || (b = b(context)) == null || Intrinsics.areEqual((Object) b.getSSID(), (Object) "<unknown ssid>")) {
            return null;
        }
        String bssid = b.getBSSID();
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 21) {
            Integer valueOf = Integer.valueOf(b.getFrequency());
            if (valueOf.intValue() <= 0) {
                z = false;
            }
            if (z) {
                num = valueOf;
            }
        }
        return new c7(bssid, num, Integer.valueOf(b.getRssi()), b.getSSID());
    }
}
