package com.umlaut.crowd.internal;

import java.util.ArrayList;
import java.util.List;

public class RUT extends RSS implements Cloneable {
    public long AvgValue;
    public long MaxValue;
    public g5[] MeasurementPointsUpload = new g5[0];
    public long MedValue;
    public long MinValue;

    public void a(ArrayList<g5> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(Long.valueOf(arrayList.get(i).ThroughputRate));
        }
        this.MinValue = v9.e(arrayList2);
        this.MaxValue = v9.c(arrayList2);
        this.AvgValue = v9.a((List<Long>) arrayList2);
        this.MedValue = v9.d(arrayList2);
        this.MeasurementPointsUpload = (g5[]) arrayList.toArray(new g5[arrayList.size()]);
    }

    public Object clone() throws CloneNotSupportedException {
        RUT rut = (RUT) super.clone();
        rut.MeasurementPointsUpload = new g5[this.MeasurementPointsUpload.length];
        int i = 0;
        while (true) {
            g5[] g5VarArr = this.MeasurementPointsUpload;
            if (i >= g5VarArr.length) {
                return rut;
            }
            rut.MeasurementPointsUpload[i] = (g5) g5VarArr[i].clone();
            i++;
        }
    }
}
