package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.enums.NetworkTypes;
import com.umlaut.crowd.utils.JsonUtils;

public class c5 extends RBR {
    public z BatteryInfo;
    public ConnectionTypes ConnectionType = ConnectionTypes.Unknown;
    public n1 CpuLoadInfo;
    public long Delta;
    public NetworkTypes DisplayNetworkType;
    public String FkAusId = "";
    public String GsmCellId;
    public String GsmLAC;
    public int IPv4;
    public int IPv6;
    public q4 LocationInfo;
    public String MCC;
    public String MNC;
    public NetworkTypes NetworkType;
    public tb NrAvailable;
    public o6 NrState;
    public int RxLevel;
    public int ThroughputRateRx;
    public int ThroughputRateRxBackground = -1;
    public int ThroughputRateRxOverall = 0;
    public int ThroughputRateTx;
    public int ThroughputRateTxBackground = -1;
    public int ThroughputRateTxOverall = 0;
    public NetworkTypes VoiceNetworkType;

    public c5(String str, String str2) {
        super(str, str2);
        NetworkTypes networkTypes = NetworkTypes.Unknown;
        this.NetworkType = networkTypes;
        this.DisplayNetworkType = networkTypes;
        this.VoiceNetworkType = networkTypes;
        this.MCC = "";
        this.MNC = "";
        this.GsmLAC = "";
        this.GsmCellId = "";
        this.IPv4 = -1;
        this.IPv6 = -1;
        this.NrState = o6.Unknown;
        this.NrAvailable = tb.Unknown;
        this.LocationInfo = new q4();
        this.BatteryInfo = new z();
        this.CpuLoadInfo = new n1();
    }

    public String a() {
        return JsonUtils.toJson(w2.MPA, (RBR) this);
    }
}
