package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class p extends RBR {
    public i AppCategory = i.Unknown;
    public long AppUsageTime = -1;
    public String AusId = "";
    public z BatteryInfoOnEnd = new z();
    public z BatteryInfoOnStart = new z();
    public c3 ForegroundDetectionMode = c3.Unknown;
    public e4 IspInfoOnEnd = new e4();
    public e4 IspInfoOnStart = new e4();
    public q4 LocationInfoOnEnd = new q4();
    public q4 LocationInfoOnStart = new q4();
    public int OverallRxMaxValue;
    public long OverallTotalRxBytes = 0;
    public long OverallTotalTxBytes = 0;
    public int OverallTxMaxValue;
    public String PackageName = "";
    public DRI RadioInfoOnEnd = new DRI();
    public DRI RadioInfoOnStart = new DRI();
    public long ScreenSession = -1;
    public int SessionRxMaxValue;
    public long SessionTotalRxBytes = -1;
    public long SessionTotalTxBytes = -1;
    public int SessionTxMaxValue;
    public ub TimeInfoOnEnd = new ub();
    public ub TimeInfoOnStart = new ub();
    public String TimestampOnEnd = "";
    public String TimestampOnStart = "";
    public DWI WifiInfoOnEnd = new DWI();
    public DWI WifiInfoOnStart = new DWI();

    public p(String str, String str2) {
        super(str, str2);
    }

    public void a(c5 c5Var) {
        this.SessionRxMaxValue = Math.max(this.SessionRxMaxValue, c5Var.ThroughputRateRx);
        this.SessionTxMaxValue = Math.max(this.SessionTxMaxValue, c5Var.ThroughputRateTx);
        this.OverallRxMaxValue = Math.max(this.OverallRxMaxValue, c5Var.ThroughputRateRxOverall);
        this.OverallTxMaxValue = Math.max(this.OverallTxMaxValue, c5Var.ThroughputRateTxOverall);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("App: " + this.PackageName + "\n");
        sb.append("Usage: " + this.AppUsageTime + " ms\n");
        sb.append("RX bytes: " + this.SessionTotalRxBytes + "\n");
        sb.append("TX bytes: " + this.SessionTotalTxBytes + "\n");
        sb.append("Max TX bit/s: " + this.SessionTxMaxValue + "\n");
        sb.append("Max RX bit/s: " + this.SessionRxMaxValue + "\n");
        return sb.toString();
    }

    public String a() {
        return JsonUtils.toJson(w2.AUS, (RBR) this);
    }
}
