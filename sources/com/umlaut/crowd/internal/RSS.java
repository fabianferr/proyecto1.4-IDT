package com.umlaut.crowd.internal;

class RSS implements Cloneable {
    public z BatteryInfoOnEnd = new z();
    public z BatteryInfoOnStart = new z();
    public d4 IpVersion = d4.Unknown;
    public q4 LocationInfoOnEnd = new q4();
    public q4 LocationInfoOnStart = new q4();
    public m5 MeasurementType = m5.Unknown;
    public n5 MemoryInfoOnEnd = new n5();
    public n5 MemoryInfoOnStart = new n5();
    public DRI RadioInfoOnEnd = new DRI();
    public DRI RadioInfoOnStart = new DRI();
    public double RatShare2G;
    public double RatShare3G;
    public double RatShare4G;
    public double RatShare4G5G;
    public double RatShare5GSA;
    public double RatShareUnknown;
    public double RatShareWiFi;
    public String Server = "";
    public boolean Success = false;
    public ub TimeInfoOnEnd = new ub();
    public ub TimeInfoOnStart = new ub();
    public String TimestampOnEnd = "";
    public String TimestampOnStart = "";
    public nc TrafficInfoOnEnd = new nc();
    public nc TrafficInfoOnStart = new nc();
    public DWI WifiInfoOnEnd = new DWI();
    public DWI WifiInfoOnStart = new DWI();

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        RSS rss = (RSS) super.clone();
        rss.BatteryInfoOnEnd = (z) this.BatteryInfoOnEnd.clone();
        rss.BatteryInfoOnStart = (z) this.BatteryInfoOnStart.clone();
        rss.LocationInfoOnEnd = (q4) this.LocationInfoOnEnd.clone();
        rss.LocationInfoOnStart = (q4) this.LocationInfoOnStart.clone();
        rss.RadioInfoOnEnd = (DRI) this.RadioInfoOnEnd.clone();
        rss.RadioInfoOnStart = (DRI) this.RadioInfoOnStart.clone();
        rss.MemoryInfoOnStart = (n5) this.MemoryInfoOnStart.clone();
        rss.MemoryInfoOnEnd = (n5) this.MemoryInfoOnEnd.clone();
        rss.WifiInfoOnStart = (DWI) this.WifiInfoOnStart.clone();
        rss.WifiInfoOnEnd = (DWI) this.WifiInfoOnEnd.clone();
        rss.TrafficInfoOnEnd = (nc) this.TrafficInfoOnEnd.clone();
        rss.TrafficInfoOnStart = (nc) this.TrafficInfoOnStart.clone();
        rss.TimeInfoOnStart = (ub) this.TimeInfoOnStart.clone();
        rss.TimeInfoOnEnd = (ub) this.TimeInfoOnEnd.clone();
        return rss;
    }
}
