package com.umlaut.crowd.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class u extends RP3 implements Cloneable {
    public String BwrId = "";
    public long BytesTransmitted;
    public long MeasurementBytes;
    public b5 MeasurementDirection = b5.Unknown;
    public int MeasurementDuration;
    public int MeasurementLength;
    public g5[] MeasurementPoints = new g5[0];
    public int NumberOfMPs;
    public long P10 = -1;
    public long P90 = -1;
    public x7[] ResponseHeaders = new x7[0];
    public int TestSockets;
    public long TimeToFirstByte = -1;

    public u(String str, String str2) {
        super(str, str2);
    }

    public void a(ArrayList<g5> arrayList) {
        g5[] g5VarArr = (g5[]) arrayList.toArray(new g5[arrayList.size()]);
        this.MeasurementPoints = g5VarArr;
        this.NumberOfMPs = g5VarArr.length;
        a(g5VarArr);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(Long.valueOf(arrayList.get(i).ThroughputRate));
        }
        this.MinValue = v9.e(arrayList2);
        this.MaxValue = v9.c(arrayList2);
        this.AvgValue = v9.a((List<Long>) arrayList2);
        this.MedValue = v9.d(arrayList2);
        Collections.sort(arrayList2);
        this.P10 = v9.a(arrayList2, 10);
        this.P90 = v9.a(arrayList2, 90);
    }

    public Object clone() throws CloneNotSupportedException {
        u uVar = (u) super.clone();
        uVar.MeasurementPoints = new g5[this.MeasurementPoints.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            g5[] g5VarArr = this.MeasurementPoints;
            if (i2 >= g5VarArr.length) {
                break;
            }
            uVar.MeasurementPoints[i2] = (g5) g5VarArr[i2].clone();
            i2++;
        }
        uVar.ResponseHeaders = new x7[this.ResponseHeaders.length];
        while (true) {
            x7[] x7VarArr = this.ResponseHeaders;
            if (i >= x7VarArr.length) {
                return uVar;
            }
            uVar.ResponseHeaders[i] = (x7) x7VarArr[i].clone();
            i++;
        }
    }
}
