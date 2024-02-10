package com.startapp;

import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import java.util.List;

/* compiled from: Sta */
public class g8 extends TelephonyManager.CellInfoCallback {
    public final /* synthetic */ h8 a;

    public g8(h8 h8Var) {
        this.a = h8Var;
    }

    public void onCellInfo(List<CellInfo> list) {
        this.a.b(false);
    }
}
