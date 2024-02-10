package com.teragence.library;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import com.teragence.library.b3;

public class a3 implements b3 {
    private final Context a;

    public a3(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        return ((java.lang.Boolean) r5.getClass().getMethod("getMeteredHint", new java.lang.Class[0]).invoke(r5, new java.lang.Object[0])).booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r5 = ((android.net.wifi.WifiManager) r4.a.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.net.NetworkInfo r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.Class r1 = r5.getClass()     // Catch:{ Exception -> 0x001a }
            java.lang.String r2 = "isMetered"
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x001a }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch:{ Exception -> 0x001a }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x001a }
            java.lang.Object r5 = r1.invoke(r5, r2)     // Catch:{ Exception -> 0x001a }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x001a }
            boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x001a }
            return r5
        L_0x001a:
            android.content.Context r5 = r4.a     // Catch:{ Exception -> 0x0046 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ Exception -> 0x0046 }
            java.lang.String r1 = "wifi"
            java.lang.Object r5 = r5.getSystemService(r1)     // Catch:{ Exception -> 0x0046 }
            android.net.wifi.WifiManager r5 = (android.net.wifi.WifiManager) r5     // Catch:{ Exception -> 0x0046 }
            android.net.wifi.WifiInfo r5 = r5.getConnectionInfo()     // Catch:{ Exception -> 0x0046 }
            java.lang.Class r1 = r5.getClass()     // Catch:{ Exception -> 0x0046 }
            java.lang.String r2 = "getMeteredHint"
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0046 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch:{ Exception -> 0x0046 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0046 }
            java.lang.Object r5 = r1.invoke(r5, r2)     // Catch:{ Exception -> 0x0046 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x0046 }
            boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x0046 }
            return r5
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.a3.a(android.net.NetworkInfo):boolean");
    }

    public void a(b3.a aVar) {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        int i = 0;
        if (Build.VERSION.SDK_INT >= 21) {
            Network[] allNetworks = connectivityManager.getAllNetworks();
            int length = allNetworks.length;
            while (i < length) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i]);
                if (networkInfo.getType() != 1 || a(networkInfo)) {
                    i++;
                } else {
                    aVar.a();
                    return;
                }
            }
        } else {
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            int length2 = allNetworkInfo.length;
            while (i < length2) {
                NetworkInfo networkInfo2 = allNetworkInfo[i];
                if (networkInfo2.getType() != 1 || a(networkInfo2)) {
                    i++;
                } else {
                    aVar.a();
                    return;
                }
            }
        }
        aVar.a(new Exception("No WiFi connected"));
    }
}
