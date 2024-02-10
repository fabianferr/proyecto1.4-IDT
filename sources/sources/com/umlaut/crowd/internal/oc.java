package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class oc extends RBR {
    public int Day;
    public int Hour;
    public String MCC = "";
    public String MNC = "";
    public int Month;
    public int Quarter;
    public long RvMobile2gRx;
    public int RvMobile2gRxSamples;
    public long RvMobile2gTx;
    public int RvMobile2gTxSamples;
    public long RvMobile3gRx;
    public int RvMobile3gRxSamples;
    public long RvMobile3gTx;
    public int RvMobile3gTxSamples;
    public long RvMobile4gRx;
    public int RvMobile4gRxSamples;
    public long RvMobile4gTx;
    public int RvMobile4gTxSamples;
    public long RvMobile5gRx;
    public int RvMobile5gRxSamples;
    public long RvMobile5gTx;
    public int RvMobile5gTxSamples;
    public long RvWifiRx;
    public int RvWifiRxSamples;
    public long RvWifiTx;
    public int RvWifiTxSamples;
    public String TimestampBin = "";
    public long TrafficBytesRxMobile = -1;
    public long TrafficBytesRxWifi = -1;
    public long TrafficBytesTxMobile = -1;
    public long TrafficBytesTxWifi = -1;
    public int Year;

    public oc(String str, String str2) {
        super(str, str2);
    }

    public String a() {
        return JsonUtils.toJson(w2.TTR, (RBR) this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TrafficThroughputResult] " + this.TimestampBin + " MCC: " + this.MCC + " MNC: " + this.MNC + "\n");
        StringBuilder sb2 = new StringBuilder("2G   RX: ");
        sb2.append(this.RvMobile2gRx);
        sb2.append(" #: ");
        sb2.append(this.RvMobile2gRxSamples);
        sb2.append("\n");
        sb.append(sb2.toString());
        sb.append("2G   TX: " + this.RvMobile2gTx + " #: " + this.RvMobile2gTxSamples + "\n");
        sb.append("3G   RX: " + this.RvMobile3gRx + " #: " + this.RvMobile3gRxSamples + "\n");
        sb.append("3G   TX: " + this.RvMobile3gTx + " #: " + this.RvMobile3gTxSamples + "\n");
        sb.append("4G   RX: " + this.RvMobile4gRx + " #: " + this.RvMobile4gRxSamples + "\n");
        sb.append("4G   TX: " + this.RvMobile4gTx + " #: " + this.RvMobile4gTxSamples + "\n");
        sb.append("5G   RX: " + this.RvMobile5gRx + " #: " + this.RvMobile5gRxSamples + "\n");
        sb.append("5G   TX: " + this.RvMobile5gTx + " #: " + this.RvMobile5gTxSamples + "\n");
        sb.append("WiFi RX: " + this.RvWifiRx + " #: " + this.RvWifiRxSamples + "\n");
        StringBuilder sb3 = new StringBuilder("WiFi TX: ");
        sb3.append(this.RvWifiTx);
        sb3.append(" #: ");
        sb3.append(this.RvWifiTxSamples);
        sb.append(sb3.toString());
        return sb.toString();
    }
}
