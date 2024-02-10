package com.m2catalyst.m2sdk.testing.business;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.m2catalyst.m2sdk.b5;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.models.Wifi;
import com.m2catalyst.m2sdk.q;
import com.m2catalyst.m2sdk.s1;
import com.m2catalyst.m2sdk.t4;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002J\u0014\u0010\u000b\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/m2catalyst/m2sdk/testing/business/DataQualityValidator;", "", "", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "mnsi", "Lcom/m2catalyst/m2sdk/t4;", "validateMNSICollectionAndGetReport", "Lcom/m2catalyst/m2sdk/business/models/M2Location;", "locations", "validateLocationCollectionAndGetReport", "Lcom/m2catalyst/m2sdk/business/models/Wifi;", "validateWifiCollectionAndGetReport", "Lcom/m2catalyst/m2sdk/q;", "cellInfoStrategyManager", "Lcom/m2catalyst/m2sdk/q;", "<init>", "(Lcom/m2catalyst/m2sdk/q;)V", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: DataQualityValidator.kt */
public final class DataQualityValidator {
    private final q cellInfoStrategyManager;

    public DataQualityValidator(q qVar) {
        Intrinsics.checkNotNullParameter(qVar, "cellInfoStrategyManager");
        this.cellInfoStrategyManager = qVar;
    }

    public final t4 validateLocationCollectionAndGetReport(List<M2Location> list) {
        Intrinsics.checkNotNullParameter(list, "locations");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (M2Location m2Location : list) {
            b5 b5Var = new b5((int) m2Location.getId());
            if (m2Location.getAccuracy() <= 0.0f) {
                Intrinsics.checkNotNullParameter("INVALID_ACCURACY", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("INVALID_ACCURACY");
                b5Var.c = false;
            }
            boolean z = true;
            if (m2Location.getLongitude() == 0.0d) {
                Intrinsics.checkNotNullParameter("LONGITUDE", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("LONGITUDE");
                b5Var.c = false;
            }
            if (m2Location.getLatitude() != 0.0d) {
                z = false;
            }
            if (z) {
                Intrinsics.checkNotNullParameter("LATITUDE", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("LATITUDE");
                b5Var.c = false;
            }
            if (m2Location.getTime() <= 0 || m2Location.getTimeStamp() <= 0) {
                Intrinsics.checkNotNullParameter("LOCATION_TIMESTAMP", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("LOCATION_TIMESTAMP");
                b5Var.c = false;
            }
            if (b5Var.c) {
                arrayList.add(Integer.valueOf((int) m2Location.getId()));
            } else {
                arrayList2.add(b5Var);
            }
        }
        return new t4(arrayList, arrayList2);
    }

    public final t4 validateMNSICollectionAndGetReport(List<? extends MNSI> list) {
        Intrinsics.checkNotNullParameter(list, "mnsi");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        MNSI mnsi = null;
        for (MNSI mnsi2 : list) {
            b5 a = this.cellInfoStrategyManager.a(mnsi, mnsi2);
            if (a != null) {
                if (a.c) {
                    arrayList.add(Integer.valueOf(a.a));
                } else {
                    arrayList2.add(a);
                }
            }
            mnsi = mnsi2;
        }
        return new t4(arrayList, arrayList2);
    }

    public final t4 validateWifiCollectionAndGetReport(List<Wifi> list) {
        Intrinsics.checkNotNullParameter(list, "locations");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Wifi wifi : list) {
            b5 b5Var = new b5((int) wifi.getId());
            if (wifi.getWifiSignalStrength() >= 0) {
                Intrinsics.checkNotNullParameter("WIFI_SIGNAL_STRENGTH", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("WIFI_SIGNAL_STRENGTH");
                b5Var.c = false;
            }
            Float accuracy = wifi.getAccuracy();
            Set<String> set = s1.a;
            if ((accuracy != null ? accuracy.floatValue() : 0.0f) <= 0.0f) {
                Intrinsics.checkNotNullParameter("INVALID_ACCURACY", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("INVALID_ACCURACY");
                b5Var.c = false;
            }
            if (wifi.getDataRx() == null) {
                Intrinsics.checkNotNullParameter("DATA_RX", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("DATA_RX");
                b5Var.c = false;
            }
            if (wifi.getDataTx() == null) {
                Intrinsics.checkNotNullParameter("DATA_TX", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("DATA_TX");
                b5Var.c = false;
            }
            if (wifi.getConnectionSpeed() < 0) {
                Intrinsics.checkNotNullParameter("WIFI_CONNECTION_SPEED", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("WIFI_CONNECTION_SPEED");
                b5Var.c = false;
            }
            boolean z = true;
            if (wifi.getIpAddress().length() == 0) {
                Intrinsics.checkNotNullParameter("IP_ADDRESS", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("IP_ADDRESS");
                b5Var.c = false;
            }
            if (wifi.getConnectedWifiBandFrequency() < 0) {
                Intrinsics.checkNotNullParameter("WIFI_BAND_FREQUENCY", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("WIFI_BAND_FREQUENCY");
                b5Var.c = false;
            }
            String[] strArr = {"gps", "network", "fused", "generated"};
            String locationProvider = wifi.getLocationProvider();
            if (locationProvider == null) {
                locationProvider = "";
            }
            if (!ArraysKt.contains((T[]) strArr, locationProvider)) {
                Intrinsics.checkNotNullParameter("LOCATION_PROVIDER", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("LOCATION_PROVIDER");
                b5Var.c = false;
            }
            if (wifi.getLatitude() == null) {
                Intrinsics.checkNotNullParameter("LATITUDE", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("LATITUDE");
                b5Var.c = false;
            }
            if (wifi.getLongitude() == null) {
                Intrinsics.checkNotNullParameter("LONGITUDE", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("LONGITUDE");
                b5Var.c = false;
            }
            if (wifi.getSsid().length() != 0) {
                z = false;
            }
            if (z) {
                Intrinsics.checkNotNullParameter("WIFI_SSID", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("WIFI_SSID");
                b5Var.c = false;
            }
            if (wifi.getTimeStamp() <= 0) {
                Intrinsics.checkNotNullParameter("WIFI_TIMESTAMP", IronSourceConstants.EVENTS_ERROR_REASON);
                b5Var.b.add("WIFI_TIMESTAMP");
                b5Var.c = false;
            }
            if (b5Var.c) {
                arrayList.add(Integer.valueOf((int) wifi.getId()));
            } else {
                arrayList2.add(b5Var);
            }
        }
        return new t4(arrayList, arrayList2);
    }
}
