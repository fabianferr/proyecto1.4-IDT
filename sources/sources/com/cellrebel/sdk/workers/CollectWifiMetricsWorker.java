package com.cellrebel.sdk.workers;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.networking.beans.request.WifiInfoMetric;
import com.cellrebel.sdk.utils.TrackingHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectWifiMetricsWorker extends BaseMetricsWorker {
    String j;

    public void a(Context context) {
        WifiManager wifiManager;
        super.a(context);
        try {
            if ((Build.VERSION.SDK_INT <= 32 || ActivityCompat.checkSelfPermission(context, "android.permission.NEARBY_WIFI_DEVICES") == 0) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
                BaseMetric baseMetric = new BaseMetric();
                BaseMetricsWorker.a(context, baseMetric);
                ArrayList arrayList = new ArrayList();
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                ArrayList arrayList2 = new ArrayList(wifiManager.getScanResults());
                Collections.sort(arrayList2, new CollectWifiMetricsWorker$$ExternalSyntheticLambda0());
                TrackingHelper.a().k(context);
                int i = 0;
                boolean z = false;
                while (i < arrayList2.size() && i < 3) {
                    ScanResult scanResult = (ScanResult) arrayList2.get(i);
                    WifiInfoMetric wifiInfoMetric = new WifiInfoMetric();
                    wifiInfoMetric.fill(scanResult);
                    if (connectionInfo.getBSSID() == null || connectionInfo.getBSSID().isEmpty() || connectionInfo.getBSSID().equals("02:00:00:00:00:00") || !connectionInfo.getBSSID().equals(scanResult.BSSID)) {
                        wifiInfoMetric.isConnected = Boolean.FALSE;
                    } else {
                        wifiInfoMetric.isConnected = Boolean.TRUE;
                        wifiInfoMetric.fill(connectionInfo);
                        z = true;
                    }
                    wifiInfoMetric.fill(baseMetric);
                    wifiInfoMetric.measurementSequenceId = this.j;
                    arrayList.add(wifiInfoMetric);
                    i++;
                }
                if (connectionInfo.getBSSID() != null && !connectionInfo.getBSSID().isEmpty() && !connectionInfo.getBSSID().equals("02:00:00:00:00:00") && !z) {
                    WifiInfoMetric wifiInfoMetric2 = new WifiInfoMetric();
                    wifiInfoMetric2.isConnected = Boolean.TRUE;
                    wifiInfoMetric2.fill(connectionInfo);
                    wifiInfoMetric2.fill(baseMetric);
                    wifiInfoMetric2.measurementSequenceId = this.j;
                    arrayList.add(wifiInfoMetric2);
                }
                if (arrayList.size() > 0 && DatabaseClient.a() != null) {
                    DatabaseClient.a().x().a((List<WifiInfoMetric>) arrayList);
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }
}
