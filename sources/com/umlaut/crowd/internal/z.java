package com.umlaut.crowd.internal;

import java.io.Serializable;

public class z implements Cloneable, Serializable {
    private static final long a = -937846764179533362L;
    public int BatteryCapacity;
    public w BatteryChargePlug = w.Unknown;
    public int BatteryCurrent;
    public y BatteryHealth = y.Unknown;
    public float BatteryLevel;
    public long BatteryRemainingEnergy;
    public a0 BatteryStatus = a0.Unknown;
    public String BatteryTechnology = "";
    public String BatteryTemp = "";
    public int BatteryVoltage;
    public boolean MissingPermission = false;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "BatteryLevel: " + this.BatteryLevel + "% BatteryStatus: " + this.BatteryStatus + " BatteryHealth: " + this.BatteryHealth + " BatteryVoltage: " + this.BatteryVoltage + " mV BatteryTemp: " + this.BatteryTemp + " °C BatteryChargePlug: " + this.BatteryChargePlug + " BatteryTechnology: " + this.BatteryTechnology + " Battery Current " + this.BatteryCurrent + " mA BatteryCapacity " + this.BatteryCapacity + " mAh BatteryRemainingEnergy " + this.BatteryRemainingEnergy + " nWh";
    }
}
