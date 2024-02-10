package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.NetworkTypes;
import com.umlaut.crowd.enums.ThreeState;
import com.umlaut.crowd.utils.JsonUtils;

public class j5 extends RBR {
    public t0 CallPhase = t0.Unknown;
    public long Delta;
    public String FkVcId = "";
    public ThreeState IsVoWiFiAvailable = ThreeState.Unknown;
    public q4 LocationInfo = new q4();
    public DRI RadioInfo = new DRI();
    public z8 ScreenState = z8.Unknown;
    public ub TimeInfo = new ub();
    public NetworkTypes VoiceNetworkType = NetworkTypes.Unknown;
    public DWI WifiInfo = new DWI();

    public j5(String str, String str2) {
        super(str, str2);
    }

    public String a() {
        return JsonUtils.toJson(w2.MPV, (RBR) this);
    }

    public Object clone() throws CloneNotSupportedException {
        j5 j5Var = (j5) super.clone();
        j5Var.RadioInfo = (DRI) this.RadioInfo.clone();
        j5Var.WifiInfo = (DWI) this.WifiInfo.clone();
        j5Var.LocationInfo = (q4) this.LocationInfo.clone();
        j5Var.TimeInfo = (ub) this.TimeInfo.clone();
        return j5Var;
    }
}
