package com.umlaut.crowd.internal;

public class i5 extends d5 implements Cloneable {
    public long JitterPackagesCount;
    public long JitterSum;
    public long PackagesReceived;
    public DRI RadioInfo = new DRI();
    public long ThroughputRate;
    public DWI WifiInfo = new DWI();

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
