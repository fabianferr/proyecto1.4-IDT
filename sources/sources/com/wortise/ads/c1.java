package com.wortise.ads;

import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import com.wortise.ads.cellular.CellConnection;
import com.wortise.ads.cellular.CellType;
import com.wortise.ads.network.models.CellNetworkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\n"}, d2 = {"Lcom/wortise/ads/c1;", "", "Landroid/telephony/CellInfo;", "info", "Lcom/wortise/ads/network/models/CellNetworkType;", "networkType", "Lcom/wortise/ads/b1;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CellDataFactory.kt */
public final class c1 {
    public static final c1 a = new c1();

    private c1() {
    }

    public final b1 a(CellInfo cellInfo, CellNetworkType cellNetworkType) {
        CellConnection cellConnection;
        Object obj;
        d1 d1Var;
        CellSignalStrength cellSignalStrength;
        g1 g1Var;
        Intrinsics.checkNotNullParameter(cellInfo, "info");
        int i = Build.VERSION.SDK_INT;
        CellType cellType = null;
        Integer valueOf = i >= 28 ? Integer.valueOf(cellInfo.getCellConnectionStatus()) : null;
        if (valueOf == null) {
            cellConnection = null;
        } else {
            cellConnection = CellConnection.Companion.a(valueOf.intValue());
        }
        boolean z = cellInfo instanceof CellInfoCdma;
        if (z) {
            obj = ((CellInfoCdma) cellInfo).getCellIdentity();
        } else if (cellInfo instanceof CellInfoGsm) {
            obj = ((CellInfoGsm) cellInfo).getCellIdentity();
        } else if (cellInfo instanceof CellInfoLte) {
            obj = ((CellInfoLte) cellInfo).getCellIdentity();
        } else if (i >= 29 && (cellInfo instanceof CellInfoNr)) {
            obj = ((CellInfoNr) cellInfo).getCellIdentity();
        } else if (i < 29 || !(cellInfo instanceof CellInfoTdscdma)) {
            obj = cellInfo instanceof CellInfoWcdma ? ((CellInfoWcdma) cellInfo).getCellIdentity() : null;
        } else {
            obj = ((CellInfoTdscdma) cellInfo).getCellIdentity();
        }
        if (obj == null) {
            d1Var = null;
        } else {
            d1Var = f1.a.a(obj);
        }
        if (z) {
            cellSignalStrength = ((CellInfoCdma) cellInfo).getCellSignalStrength();
        } else if (cellInfo instanceof CellInfoGsm) {
            cellSignalStrength = ((CellInfoGsm) cellInfo).getCellSignalStrength();
        } else if (cellInfo instanceof CellInfoLte) {
            cellSignalStrength = ((CellInfoLte) cellInfo).getCellSignalStrength();
        } else if (cellInfo instanceof CellInfoNr) {
            cellSignalStrength = ((CellInfoNr) cellInfo).getCellSignalStrength();
        } else {
            cellSignalStrength = cellInfo instanceof CellInfoWcdma ? ((CellInfoWcdma) cellInfo).getCellSignalStrength() : null;
        }
        if (cellSignalStrength == null) {
            g1Var = null;
        } else {
            g1Var = h1.a.a(cellSignalStrength, cellNetworkType);
        }
        if (z) {
            cellType = CellType.CDMA;
        } else if (cellInfo instanceof CellInfoGsm) {
            cellType = CellType.GSM;
        } else if (cellInfo instanceof CellInfoLte) {
            cellType = CellType.LTE;
        } else if (i >= 29 && (cellInfo instanceof CellInfoNr)) {
            cellType = CellType.NR;
        } else if (i >= 29 && (cellInfo instanceof CellInfoTdscdma)) {
            cellType = CellType.TDSCDMA;
        } else if (cellInfo instanceof CellInfoWcdma) {
            cellType = CellType.WCDMA;
        }
        return new b1(cellConnection, d1Var, g1Var, cellType);
    }
}
