package com.umlaut.crowd.internal;

public class me implements Cloneable {
    public long Age;
    public String BSSID = "";
    public String Capabilities = "";
    public int ChannelWidth;
    public boolean Connected = false;
    public int DistanceMm;
    public int DistanceStdDevMm;
    public int Frequency;
    public boolean RangingSuccessful = false;
    public int RxLev;
    public String SSID = "";
    public qe Standard = qe.Unknown;
    public long Timestamp;

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
