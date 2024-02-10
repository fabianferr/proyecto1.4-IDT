package com.umlaut.crowd.internal;

import java.io.Serializable;
import java.util.HashMap;

public class BGT implements Serializable, Comparable<BGT> {
    public int BufferSize;
    public String Condition = "";
    private int CurrentAPHash;
    public int CurrentMonth;
    public int CurrentQuota;
    public boolean ForceFirstTest = false;
    public String Headers = "";
    public int Height = -1;
    public int Id;
    public long Interval;
    private final HashMap<Integer, Long> LastTestTimestamp = new HashMap<>();
    public int Length;
    public int MaxMonthlyQuota = Integer.MAX_VALUE;
    public int Pause;
    public long Payload;
    public int Pings;
    public int Port = -1;
    public int Priority = 0;
    public double Probability = 1.0d;
    public int Reporting;
    public String RequestMethod = "";
    public int Sockets;
    public boolean TestPerAP = false;
    public boolean TotalInterfaceTraffic = false;
    public int Type;
    public String Url = "";
    public int Width = -1;

    public long nextTestTimestamp() {
        Long l = this.LastTestTimestamp.get(Integer.valueOf(this.CurrentAPHash));
        if (l == null) {
            l = 0L;
        }
        return l.longValue() + this.Interval;
    }

    public void setAPHash(int i) {
        this.CurrentAPHash = i;
    }

    public void setLastTestTimestamp(long j) {
        this.LastTestTimestamp.put(Integer.valueOf(this.CurrentAPHash), Long.valueOf(j));
    }

    public int compareTo(BGT bgt) {
        int i = this.Priority;
        int i2 = bgt.Priority;
        if (i < i2) {
            return 1;
        }
        if (i > i2) {
            return -1;
        }
        return Long.compare(nextTestTimestamp(), bgt.nextTestTimestamp());
    }
}
