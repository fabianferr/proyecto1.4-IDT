package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.ThreeState;
import com.umlaut.crowd.utils.JsonUtils;

public class m6 extends RBR {
    public r6 DeviceInfoOS = r6.Android;
    public String DeviceInfoOSVersion = "";
    public ThreeState DeviceInfoPowerSaveMode = ThreeState.Unknown;
    public String DeviceInfoSimOperator = "";
    public String DeviceInfoSimOperatorName = "";
    public p9 DeviceInfoSimState = p9.Unknown;
    public e4 IspInfoWifi = new e4();
    public q4 LocationInfo = new q4();
    public DRI RadioInfo = new DRI();
    public int Samples = -1;
    public l6 Technology = l6.Unknown;
    public long ThroughputRv = -1;
    public long ThroughputRvConcurrent = -1;
    public ub TimeInfo = new ub();
    public String TimestampBin = "";
    public long TrafficBytes = -1;
    public b5 TrafficDirection = b5.Unknown;
    public DWI WifiInfo = new DWI();

    public m6(String str, String str2) {
        super(str, str2);
    }

    public String a() {
        return JsonUtils.toJson(w2.NTR, (RBR) this);
    }
}
