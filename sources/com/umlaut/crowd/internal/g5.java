package com.umlaut.crowd.internal;

public class g5 extends d5 implements Cloneable {
    public long BytesTransmitted;
    public long ThroughputRate;
    public DWI WifiInfo = new DWI();

    public Object clone() throws CloneNotSupportedException {
        g5 g5Var = (g5) super.clone();
        g5Var.WifiInfo = (DWI) this.WifiInfo.clone();
        return g5Var;
    }
}
