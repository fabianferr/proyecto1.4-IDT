package com.umlaut.crowd.internal;

import java.util.Arrays;

public class pb implements s5 {
    public double cpuLoad;
    public int currTests;
    public i6[] networkInterfaces;
    public long ramFree;
    public long ramTotal;
    public String[] testIdsDone;

    public v5 c() {
        return v5.MESSAGETYPE_INTERNAL_TESTSERVERSTATUS;
    }

    public String toString() {
        return "TestserverStatus [currTests=" + this.currTests + ", cpuLoad=" + this.cpuLoad + ", ramTotal=" + this.ramTotal + ", ramFree=" + this.ramFree + ", testIdsDone=" + Arrays.toString(this.testIdsDone) + "]";
    }
}
