package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.enums.NetworkTypes;

public class l5 {
    public float BufferedPercent = -1.0f;
    public ConnectionTypes ConnectionType = ConnectionTypes.Unknown;
    public long Delta = 0;
    public NetworkTypes DisplayNetworkType;
    public String Mime = "";
    public NetworkTypes NetworkType;
    public o6 NrState;
    public long PlayedTime = -1;
    public xe PlayerState = xe.Unknown;
    public long RequestedBytesFrom = -1;
    public long RequestedBytesTo = -1;
    public long RxBytes = -1;
    public int RxLevel = 0;
    public long ThroughputRateRx = 0;
    public long ThroughputRateTx = 0;
    public long TxBytes = -1;
    public int VideoInfoTag = -1;
    public ye VideoQuality = ye.Unknown;

    public l5() {
        NetworkTypes networkTypes = NetworkTypes.Unknown;
        this.NetworkType = networkTypes;
        this.NrState = o6.Unknown;
        this.DisplayNetworkType = networkTypes;
    }
}
