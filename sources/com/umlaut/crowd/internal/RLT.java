package com.umlaut.crowd.internal;

import java.util.ArrayList;
import java.util.List;

public class RLT extends RSS implements Cloneable {
    public double Jitter;
    public e5[] MeasurementPointsLatency = new e5[0];
    public y6 PingType = y6.Unknown;
    public int RttAvg;
    public int RttMax;
    public int RttMed;
    public int RttMin;

    public void a(ArrayList<e5> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(Long.valueOf((long) arrayList.get(i).Rtt));
        }
        this.RttMin = i1.a(v9.e(arrayList2));
        this.RttMax = i1.a(v9.c(arrayList2));
        this.RttAvg = i1.a(v9.a((List<Long>) arrayList2));
        this.RttMed = i1.a(v9.d(arrayList2));
        this.Jitter = v9.b(arrayList2);
        this.MeasurementPointsLatency = (e5[]) arrayList.toArray(new e5[arrayList.size()]);
    }

    public Object clone() throws CloneNotSupportedException {
        RLT rlt = (RLT) super.clone();
        rlt.MeasurementPointsLatency = new e5[this.MeasurementPointsLatency.length];
        int i = 0;
        while (true) {
            e5[] e5VarArr = this.MeasurementPointsLatency;
            if (i >= e5VarArr.length) {
                return rlt;
            }
            rlt.MeasurementPointsLatency[i] = (e5) e5VarArr[i].clone();
            i++;
        }
    }
}
