package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class RVR extends RBR implements Cloneable {
    public g[] ApnInfoOnEnd = new g[0];
    public g[] ApnInfoOnStart = new g[0];
    public String BMSISDN = "";
    public z BatteryInfoOnEnd = new z();
    public z BatteryInfoOnStart = new z();
    public long CallAlertingTime = -1;
    public r0 CallDirection = r0.Unknown;
    public String CallDisconnectCause = "";
    public long CallDuration;
    public s0 CallEndType = s0.Unknown;
    public String CallPreciseDisconnectCause = "";
    public int CallReestablishments;
    public long CallSetupTime;
    public u0 CallStateRecognition = u0.Default;
    public boolean CallSuccessful;
    public z0[] CellInfoOnEnd = new z0[0];
    public z0[] CellInfoOnStart = new z0[0];
    public a2 DeviceInfo = new a2();
    public int DropInWindowTime = -1;
    public boolean IsIdenticalBParty = false;
    public boolean IsVoLteEnabled;
    public boolean IsVoWiFiEnabled;
    public q4 LocationInfoOnEnd = new q4();
    public q4 LocationInfoOnStart = new q4();
    public boolean MissingPermissionCallLog = false;
    public int MultiCalls;
    public String PreviousVcId = "";
    public DRI RadioInfoOnEnd = new DRI();
    public DRI RadioInfoOnStart = new DRI();
    public o9 SimInfo = new o9();
    public ub TimeInfoOnEnd = new ub();
    public ub TimeInfoOnEstablished = new ub();
    public ub TimeInfoOnStart = new ub();
    public long TimeToConnect;
    public String TimestampOnEnd = "";
    public String TimestampOnEstablished = "";
    public String TimestampOnStart = "";
    public String VcId = "";
    public double VoiceRatShare2G;
    public double VoiceRatShare3G;
    public double VoiceRatShare4G;
    public double VoiceRatShare5G;
    public double VoiceRatShareUnknown;
    public double VoiceRatShareVoWiFi;
    public DWI WifiInfoOnEnd;
    public DWI WifiInfoOnStart;

    public RVR(String str, String str2) {
        super(str, str2);
    }

    public String a() {
        return JsonUtils.toJson(w2.VC, (RBR) this);
    }

    public Object clone() throws CloneNotSupportedException {
        RVR rvr = (RVR) super.clone();
        rvr.DeviceInfo = (a2) this.DeviceInfo.clone();
        rvr.BatteryInfoOnStart = (z) this.BatteryInfoOnStart.clone();
        rvr.LocationInfoOnStart = (q4) this.LocationInfoOnStart.clone();
        rvr.LocationInfoOnEnd = (q4) this.LocationInfoOnEnd.clone();
        rvr.RadioInfoOnStart = (DRI) this.RadioInfoOnStart.clone();
        rvr.RadioInfoOnEnd = (DRI) this.RadioInfoOnEnd.clone();
        rvr.TimeInfoOnStart = (ub) this.TimeInfoOnStart.clone();
        rvr.TimeInfoOnEnd = (ub) this.TimeInfoOnEnd.clone();
        rvr.TimeInfoOnEstablished = (ub) this.TimeInfoOnEstablished.clone();
        rvr.BatteryInfoOnEnd = (z) this.BatteryInfoOnEnd.clone();
        rvr.SimInfo = (o9) this.SimInfo.clone();
        rvr.CellInfoOnStart = new z0[this.CellInfoOnStart.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            z0[] z0VarArr = this.CellInfoOnStart;
            if (i2 >= z0VarArr.length) {
                break;
            }
            rvr.CellInfoOnStart[i2] = (z0) z0VarArr[i2].clone();
            i2++;
        }
        rvr.CellInfoOnEnd = new z0[this.CellInfoOnEnd.length];
        int i3 = 0;
        while (true) {
            z0[] z0VarArr2 = this.CellInfoOnEnd;
            if (i3 >= z0VarArr2.length) {
                break;
            }
            rvr.CellInfoOnEnd[i3] = (z0) z0VarArr2[i3].clone();
            i3++;
        }
        rvr.ApnInfoOnStart = new g[this.ApnInfoOnStart.length];
        int i4 = 0;
        while (true) {
            g[] gVarArr = this.ApnInfoOnStart;
            if (i4 >= gVarArr.length) {
                break;
            }
            rvr.ApnInfoOnStart[i4] = (g) gVarArr[i4].clone();
            i4++;
        }
        rvr.ApnInfoOnEnd = new g[this.ApnInfoOnEnd.length];
        while (true) {
            g[] gVarArr2 = this.ApnInfoOnEnd;
            if (i >= gVarArr2.length) {
                return rvr;
            }
            rvr.ApnInfoOnEnd[i] = (g) gVarArr2[i].clone();
            i++;
        }
    }
}
