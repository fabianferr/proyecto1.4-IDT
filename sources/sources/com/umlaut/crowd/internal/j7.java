package com.umlaut.crowd.internal;

public class j7 {
    public long firstPkgTime;
    public long jitterPkgCnt;
    public long jitterSum;
    public long lastPkgTime;
    public long pkgsReceived;

    public String toString() {
        return "ProgressUDPStatusSlot [pkgsReceived=" + this.pkgsReceived + ", jitterSum=" + this.jitterSum + ", jitterPkgCnt=" + this.jitterPkgCnt + ", firstPkgTime=" + this.firstPkgTime + ", lastPkgTime=" + this.lastPkgTime + "]";
    }
}
