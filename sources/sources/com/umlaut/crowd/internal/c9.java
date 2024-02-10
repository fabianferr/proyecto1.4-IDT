package com.umlaut.crowd.internal;

public class c9 implements Cloneable {
    public boolean SensorIsWakeUp;
    public int SensorMaxDelay;
    public float SensorMaximumRange;
    public int SensorMinDelay;
    public String SensorName = "";
    public float SensorPower;
    public d9 SensorReportingMode = d9.Unknown;
    public float SensorResolution;
    public e9 SensorType = e9.Unknown;
    public String SensorVendor = "";
    public int SensorVersion = 0;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
