package com.teragence.library;

import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyDisplayInfo;
import java.util.List;

class x1 extends PhoneStateListener {
    private final PhoneStateListener a;

    x1(PhoneStateListener phoneStateListener) {
        this.a = phoneStateListener;
    }

    public void onCellInfoChanged(List<CellInfo> list) {
        if (list != null) {
            this.a.onCellInfoChanged(list);
        }
    }

    public void onCellLocationChanged(CellLocation cellLocation) {
        if (cellLocation != null) {
            this.a.onCellLocationChanged(cellLocation);
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
        if (serviceState != null) {
            this.a.onServiceStateChanged(serviceState);
        }
    }

    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        if (signalStrength != null) {
            this.a.onSignalStrengthsChanged(signalStrength);
        }
    }
}
