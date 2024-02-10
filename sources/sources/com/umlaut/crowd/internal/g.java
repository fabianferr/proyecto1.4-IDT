package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.NetworkTypes;
import java.io.Serializable;

public class g implements Cloneable, Serializable {
    public String Apn = "";
    public String ApnTypes = "";
    public String Capabilities = "";
    public transient String InterfaceName = "";
    public fe MobileDataConnectionState = fe.Unknown;
    public NetworkTypes NetworkType = NetworkTypes.Unknown;
    public String PcscfAddresses = "";
    public transient String PcscfAddresses_Full = "";
    public String Reason = "";
    public long RxBytes = -1;
    public String SamsungImsServices = "";
    public int SamsungSipError = -1;
    public int SubscriptionId = -1;
    public long TxBytes = -1;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
