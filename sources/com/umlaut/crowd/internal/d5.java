package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.enums.NetworkTypes;

public class d5 implements Cloneable {
    public ConnectionTypes ConnectionType = ConnectionTypes.Unknown;
    public long Delta;
    public NetworkTypes DisplayNetworkType;
    public NetworkTypes NetworkType;
    public tb NrAvailable;
    public o6 NrState;
    public int RxLev;

    public d5() {
        NetworkTypes networkTypes = NetworkTypes.Unknown;
        this.NetworkType = networkTypes;
        this.DisplayNetworkType = networkTypes;
        this.NrState = o6.Unknown;
        this.NrAvailable = tb.Unknown;
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
