package com.umlaut.crowd.internal;

public class y7 implements Cloneable {
    public int Hop;
    public String Host = "";
    public String Ip = "";
    public boolean IsIntermediate;
    public double Latency = -1.0d;
    public double LatencyMax = -1.0d;
    public double LatencyMin = -1.0d;
    public q4 LocationInfo = new q4();
    public int Pings = 0;
    public DRI RadioInfo = new DRI();
    public int SuccessfulPings = 0;
    public ub TimeInfo = new ub();
    public DWI WifiInfo = new DWI();

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
