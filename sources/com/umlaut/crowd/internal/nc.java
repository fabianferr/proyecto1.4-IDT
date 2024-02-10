package com.umlaut.crowd.internal;

public class nc implements Cloneable {
    public long MobileRxBytes;
    public long MobileTxBytes;
    public long TotalRxBytes;
    public long TotalTxBytes;
    public long WifiRxBytes;
    public long WifiTxBytes;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
