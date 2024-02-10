package com.umlaut.crowd.internal;

import java.io.Serializable;

public class DWI implements Cloneable, Serializable {
    private static final long a = 8111287616823344527L;
    public String DefaultGatewayMacAddress = "";
    public o3 HotspotState = o3.Unknown;
    public boolean MissingPermission = false;
    public String RouterManufacturer = "";
    public String RouterModel = "";
    public String RouterName = "";
    public ce WifiAuthAlgorithm = ce.Unknown;
    public String WifiBSSID = "";
    public transient String WifiBSSID_Full;
    public fe WifiDetailedState = fe.Unknown;
    public int WifiFrequency = 0;
    public ie WifiGroupCipher = ie.Unknown;
    public je WifiKeyManagement = je.Unknown;
    public int WifiLinkQuality = -1;
    public String WifiLinkSpeed = "";
    public transient long WifiLinkSpeedBps;
    public transient String WifiMacAddress = "";
    public ke WifiPairwiseCipher = ke.Unknown;
    public le WifiProtocol = le.Unknown;
    public int WifiRxLev;
    public String WifiSSID = "";
    public transient String WifiSSID_Full;
    public qe WifiStandard = qe.Unknown;
    public re WifiState = re.Unknown;
    public se WifiSupplicantState = se.Unknown;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WifiState: " + this.WifiState + "\n");
        sb.append("WifiDetailedState: " + this.WifiDetailedState + "\n");
        sb.append("WifiSupplicantState: " + this.WifiSupplicantState + "\n");
        sb.append("WifiProtocol: " + this.WifiProtocol + "\n");
        sb.append("WifiGroupCipher: " + this.WifiGroupCipher + "\n");
        sb.append("WifiAuthAlgorithm: " + this.WifiAuthAlgorithm + "\n");
        sb.append("WifiPairwiseCipher: " + this.WifiPairwiseCipher + "\n");
        sb.append("WifiFrequency: " + this.WifiFrequency + "\n");
        sb.append("WifiLinkQuality: " + this.WifiLinkQuality + "\n");
        sb.append("WifiLinkSpeed: " + this.WifiLinkSpeed + "\n");
        sb.append("WifiRxLev: " + this.WifiRxLev + "\n");
        sb.append("WifiBSSID: " + this.WifiBSSID + "\n");
        sb.append("WifiSSID: " + this.WifiSSID + "\n");
        sb.append("WifiMacAddress: " + this.WifiMacAddress + "\n");
        return sb.toString();
    }
}
