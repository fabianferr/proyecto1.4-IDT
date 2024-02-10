package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.enums.NetworkTypes;
import com.umlaut.crowd.utils.JsonUtils;

public class h5 extends RBR {
    public int ARFCN;
    public w BatteryChargePlug;
    public float BatteryLevel;
    public ConnectionTypes ConnectionType = ConnectionTypes.Unknown;
    public double CpuLoad;
    public String DeviceManufacturer;
    public String DeviceName;
    public NetworkTypes DisplayNetworkType;
    public String FkTimestampBin = "";
    public double GpuLoad;
    public String GsmCellId;
    public int GsmCellIdAge;
    public String GsmLAC;
    public q4 LocationInfo;
    public String MCC;
    public String MNC;
    public NetworkTypes NetworkType;
    public tb NrAvailable;
    public o6 NrState;
    public String OSVersion;
    public String OperatorName;
    public int RXLevelAge;
    public int RxLevel;
    public String SimInfoCarrierName;
    public boolean SimInfoDataRoaming;
    public int SimInfoMcc;
    public int SimInfoMnc;
    public String SimOperator;
    public String SimOperatorName;
    public p9 SimState;
    public String TAC;
    public l6 Technology = l6.Unknown;
    public long ThroughputRateRx;
    public long ThroughputRateTx;
    public String Timestamp = "";
    public long TimestampMillis;

    public h5(String str, String str2) {
        super(str, str2);
        NetworkTypes networkTypes = NetworkTypes.Unknown;
        this.NetworkType = networkTypes;
        this.DisplayNetworkType = networkTypes;
        this.NrState = o6.Unknown;
        this.NrAvailable = tb.Unknown;
        this.MCC = "";
        this.MNC = "";
        this.SimOperator = "";
        this.SimOperatorName = "";
        this.GsmLAC = "";
        this.GsmCellId = "";
        this.DeviceManufacturer = "";
        this.DeviceName = "";
        this.OSVersion = "";
        this.SimState = p9.Unknown;
        this.TAC = "";
        this.OperatorName = "";
        this.GsmCellIdAge = -1;
        this.RXLevelAge = -1;
        this.ARFCN = -1;
        this.BatteryChargePlug = w.Unknown;
        this.SimInfoCarrierName = "";
        this.SimInfoDataRoaming = false;
        this.SimInfoMcc = -1;
        this.SimInfoMnc = -1;
        this.LocationInfo = new q4();
    }

    public String a() {
        return JsonUtils.toJson(w2.MPT, (RBR) this);
    }
}
