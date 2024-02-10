package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.enums.NetworkTypes;

public class k5 {
    public ConnectionTypes ConnectionType = ConnectionTypes.Unknown;
    public long Delta;
    public NetworkTypes DisplayNetworkType;
    public NetworkTypes NetworkType;
    public o6 NrState;
    public long RxBytes = -1;
    public int RxLevel;
    public long ThroughputRateRx;
    public long ThroughputRateRxBackground = -1;
    public long ThroughputRateTx;
    public long ThroughputRateTxBackground = -1;
    public long TxBytes = -1;

    public k5() {
        NetworkTypes networkTypes = NetworkTypes.Unknown;
        this.NetworkType = networkTypes;
        this.NrState = o6.Unknown;
        this.DisplayNetworkType = networkTypes;
    }
}
