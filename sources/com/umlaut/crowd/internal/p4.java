package com.umlaut.crowd.internal;

import java.util.ArrayList;
import java.util.List;

public class p4 extends RP3 implements Cloneable {
    public String AirportCode;
    public v0 CallStateOnEnd;
    public v0 CallStateOnStart;
    public long DurationOverall = -1;
    public long DurationOverallNoSleep = -1;
    public double Jitter;
    public String LtrId = "";
    public e5[] MeasurementPoints;
    public int Pause;
    public int Pings;
    public String Rdns;
    public z8 ScreenStateOnEnd;
    public z8 ScreenStateOnStart;
    public int SuccessfulPings;

    public p4(String str, String str2) {
        super(str, str2);
        z8 z8Var = z8.Unknown;
        this.ScreenStateOnStart = z8Var;
        this.ScreenStateOnEnd = z8Var;
        this.AirportCode = "";
        this.Rdns = "";
        v0 v0Var = v0.Unknown;
        this.CallStateOnStart = v0Var;
        this.CallStateOnEnd = v0Var;
        this.MeasurementPoints = new e5[0];
    }

    public void a(ArrayList<e5> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).Rtt != -1) {
                arrayList2.add(Long.valueOf((long) arrayList.get(i).Rtt));
            }
        }
        this.MinValue = (long) i1.a(v9.e(arrayList2));
        this.MaxValue = (long) i1.a(v9.c(arrayList2));
        this.AvgValue = (long) i1.a(v9.a((List<Long>) arrayList2));
        this.MedValue = (long) i1.a(v9.d(arrayList2));
        this.Jitter = v9.b(arrayList2);
        e5[] e5VarArr = (e5[]) arrayList.toArray(new e5[arrayList.size()]);
        this.MeasurementPoints = e5VarArr;
        a(e5VarArr);
    }

    public Object clone() throws CloneNotSupportedException {
        p4 p4Var = (p4) super.clone();
        p4Var.MeasurementPoints = new e5[this.MeasurementPoints.length];
        int i = 0;
        while (true) {
            e5[] e5VarArr = this.MeasurementPoints;
            if (i >= e5VarArr.length) {
                return p4Var;
            }
            p4Var.MeasurementPoints[i] = (e5) e5VarArr[i].clone();
            i++;
        }
    }
}
