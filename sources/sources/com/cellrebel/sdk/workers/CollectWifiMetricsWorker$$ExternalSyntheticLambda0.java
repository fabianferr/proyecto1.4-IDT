package com.cellrebel.sdk.workers;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectWifiMetricsWorker$$ExternalSyntheticLambda0 implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((ScanResult) obj2).level, ((ScanResult) obj).level);
    }
}
