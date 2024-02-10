package com.teragence.library;

import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyDisplayInfo;
import java.util.List;

class v1 extends PhoneStateListener {
    private final w1 a;

    v1(w1 w1Var) {
        this.a = w1Var;
    }

    public void onCellInfoChanged(List<CellInfo> list) {
        try {
            this.a.onCellInfoChanged(list);
        } catch (SecurityException unused) {
        }
    }

    public void onCellLocationChanged(CellLocation cellLocation) {
        try {
            this.a.onCellLocationChanged(cellLocation);
        } catch (SecurityException unused) {
        }
    }

    public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                this.a.onDisplayInfoChanged(telephonyDisplayInfo);
            } catch (SecurityException unused) {
            }
        }
    }

    public void onServiceStateChanged(ServiceState serviceState) {
        this.a.onServiceStateChanged(serviceState);
    }

    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        this.a.onSignalStrengthsChanged(signalStrength);
    }
}
