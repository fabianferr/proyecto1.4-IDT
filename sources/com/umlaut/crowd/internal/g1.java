package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.NetworkTypes;
import com.umlaut.crowd.utils.JsonUtils;

public class g1 extends RBR {
    public String AirportCode;
    public String AmazonId = "";
    public g[] ApnInfo;
    public z BatteryInfo;
    public long BytesRead = -1;
    public v0 CallState;
    public z0[] CellInfo;
    public c1[] ConnectedDevicesInfo;
    public String CtId = "";
    public a2 DeviceInfo;
    public String DnsServer = "";
    public long DurationDNS = -1;
    public long DurationHttpGetCommand = -1;
    public long DurationHttpReceive = -1;
    public long DurationHttpResponse = -1;
    public long DurationOverall = -1;
    public long DurationOverallNoSleep = -1;
    public long DurationSSL = -1;
    public long DurationTcpConnect = -1;
    public String ErrorReason;
    public int HTTPStatus = -1;
    public long HeaderBytesRead = -1;
    public int HeaderContentLength = -1;
    public long HeaderLastModified = -1;
    public w3 IdleStateOnEnd;
    public w3 IdleStateOnStart;
    public int IsAppInForeground = -1;
    public boolean IsKeepAlive = false;
    public e4 IspInfo;
    public boolean LocalhostPingSuccess = false;
    public q4 LocationInfo;
    public n5 MemoryInfo;
    public x5[] MultiCdnInfo;
    public j6[] NetworkRegistrationInfo;
    public q1 ProtocolType = q1.Unknown;
    public DRI RadioInfo;
    public DRI RadioInfoOnEnd;
    public z8 ScreenState = z8.Unknown;
    public String ServerFilename = "";
    public String ServerHostname = "";
    public String ServerIp = "";
    public long ServerMultiSuccess;
    public o9 SimInfo;
    public String SslException;
    public y9 StorageInfo;
    public boolean Success = false;
    public String TestTimestamp = "";
    public s1 TestType = s1.Unknown;
    public String TestsInProgress = "";
    public ub TimeInfo;
    public nc TrafficInfo;
    public a Trigger = a.Unknown;
    public long TruststoreTimestamp;
    public NetworkTypes VoiceNetworkType;
    public DWI WifiInfo;

    public g1(String str, String str2) {
        super(str, str2);
        w3 w3Var = w3.Unknown;
        this.IdleStateOnStart = w3Var;
        this.IdleStateOnEnd = w3Var;
        this.ErrorReason = "";
        this.SslException = "";
        this.CallState = v0.Unknown;
        this.VoiceNetworkType = NetworkTypes.Unknown;
        this.ServerMultiSuccess = -1;
        this.AirportCode = "";
        this.BatteryInfo = new z();
        this.DeviceInfo = new a2();
        this.LocationInfo = new q4();
        this.MemoryInfo = new n5();
        this.RadioInfo = new DRI();
        this.RadioInfoOnEnd = new DRI();
        this.StorageInfo = new y9();
        this.TrafficInfo = new nc();
        this.WifiInfo = new DWI();
        this.TimeInfo = new ub();
        this.IspInfo = new e4();
        this.SimInfo = new o9();
        this.MultiCdnInfo = new x5[0];
        this.CellInfo = new z0[0];
        this.ApnInfo = new g[0];
        this.NetworkRegistrationInfo = new j6[0];
        this.ConnectedDevicesInfo = new c1[0];
    }

    public String a() {
        return JsonUtils.toJson(w2.CT, (RBR) this);
    }
}
