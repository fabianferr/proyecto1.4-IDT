package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.NetworkTypes;
import com.umlaut.crowd.utils.JsonUtils;

public class h6 extends RBR {
    public v0 CallState = v0.Unknown;
    public double CellIdDeltaDistance = -1.0d;
    public z0[] CellInfo = new z0[0];
    public q4 LocationInfo = new q4();
    public String NirId = "";
    public String PrevCellId = "";
    public String PrevLAC = "";
    public String PrevMCC = "";
    public String PrevMNC = "";
    public NetworkTypes PrevNetworkType = NetworkTypes.Unknown;
    public String PrevNirId = "";
    public int PrevRXLevel;
    public DRI RadioInfo = new DRI();
    public z8 ScreenState = z8.Unknown;
    public ub TimeInfo = new ub();
    public String Timestamp = "";
    public rc TriggerEvent = rc.Unknown;
    public DWI WifiInfo = new DWI();
    public transient long timestampMillis;

    public h6(String str, String str2) {
        super(str, str2);
    }

    public String a() {
        return JsonUtils.toJson(w2.NIR, (RBR) this);
    }
}
