package com.umlaut.crowd.internal;

public class qd extends RBR {
    public a2 DeviceInfo;
    public boolean EPDGHandshakeSuccessful;
    public String EPDGResponse1 = "";
    public int EPDGResponse1FirstPayload = -1;
    public int EPDGResponse1NotifyMessageCode = -1;
    public x3 EPDGResponse1NotifyMessageType;
    public String EPDGResponse2 = "";
    public int EPDGResponse2FirstPayload = -1;
    public int EPDGResponse2NotifyMessageCode = -1;
    public x3 EPDGResponse2NotifyMessageType;
    public String EPDGServerIp = "";
    public String FirmwareCSC = "";
    public e4 IspInfo;
    public q4 LocationInfoOnEnd;
    public q4 LocationInfoOnStart;
    public boolean Port10000Open;
    public boolean Port4500Open;
    public boolean Port500Open;
    public boolean Port5060Open;
    public boolean Port5061Open;
    public DRI RadioInfoOnEnd;
    public DRI RadioInfoOnStart;
    public ub TimeInfoOnEnd;
    public ub TimeInfoOnStart;
    public rc TriggerEvent = rc.Unknown;
    public String VwtId = "";
    public DWI WifiInfoOnEnd;
    public DWI WifiInfoOnStart;

    public qd(String str, String str2) {
        super(str, str2);
        x3 x3Var = x3.UNKNOWN;
        this.EPDGResponse1NotifyMessageType = x3Var;
        this.EPDGResponse2NotifyMessageType = x3Var;
        this.EPDGHandshakeSuccessful = false;
        this.DeviceInfo = new a2();
        this.TimeInfoOnStart = new ub();
        this.WifiInfoOnStart = new DWI();
        this.RadioInfoOnStart = new DRI();
        this.LocationInfoOnStart = new q4();
        this.TimeInfoOnEnd = new ub();
        this.WifiInfoOnEnd = new DWI();
        this.RadioInfoOnEnd = new DRI();
        this.LocationInfoOnEnd = new q4();
        this.IspInfo = new e4();
    }
}
