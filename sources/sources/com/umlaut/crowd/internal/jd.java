package com.umlaut.crowd.internal;

import java.util.ArrayList;
import java.util.Collections;

public class jd extends RP3 implements Cloneable {
    public long ClientP10 = -1;
    public long ClientP90 = -1;
    public b5 MeasurementDirection = b5.Unknown;
    public long MeasurementDurationClient;
    public long MeasurementDurationServer;
    public long MeasurementLengthClient;
    public long MeasurementLengthServer;
    public int MeasurementPackageSizeClient;
    public int MeasurementPackageSizeServer;
    public int MeasurementPackagesClient;
    public int MeasurementPackagesServer;
    public i5[] MeasurementPointsClient = new i5[0];
    public i5[] MeasurementPointsServer;
    public long OverallJitterPackagesCountClient;
    public long OverallJitterPackagesCountServer;
    public long OverallJitterSumClient;
    public long OverallJitterSumServer;
    public long OverallPackagesReceivedClient;
    public long OverallPackagesReceivedServer;
    public long OverallThroughputClient;
    public long OverallThroughputServer;
    public long ServerP10 = -1;
    public long ServerP90 = -1;
    public int UDPTestStatus;
    public String UdpId = "";
    public long WelcomePackageDelay;

    public jd(String str, String str2) {
        super(str, str2);
    }

    public void a(ArrayList<i5> arrayList) {
        i5[] i5VarArr = (i5[]) arrayList.toArray(new i5[arrayList.size()]);
        this.MeasurementPointsClient = i5VarArr;
        a(i5VarArr);
        double d = (double) (this.OverallPackagesReceivedClient * ((long) this.MeasurementPackageSizeClient) * 8);
        double d2 = (double) this.MeasurementDurationClient;
        Double.isNaN(d2);
        Double.isNaN(d);
        this.OverallThroughputClient = (long) ((int) (d / (d2 / 1000.0d)));
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(Long.valueOf(arrayList.get(i).ThroughputRate));
        }
        Collections.sort(arrayList2);
        this.ClientP10 = v9.a(arrayList2, 10);
        this.ClientP90 = v9.a(arrayList2, 90);
    }

    public void b(ArrayList<i5> arrayList) {
        i5[] i5VarArr = (i5[]) arrayList.toArray(new i5[arrayList.size()]);
        this.MeasurementPointsServer = i5VarArr;
        a(i5VarArr);
        double d = (double) (this.OverallPackagesReceivedServer * ((long) this.MeasurementPackageSizeServer) * 8);
        double d2 = (double) this.MeasurementDurationServer;
        Double.isNaN(d2);
        Double.isNaN(d);
        this.OverallThroughputServer = (long) ((int) (d / (d2 / 1000.0d)));
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(Long.valueOf(arrayList.get(i).ThroughputRate));
        }
        Collections.sort(arrayList2);
        this.ServerP10 = v9.a(arrayList2, 10);
        this.ServerP90 = v9.a(arrayList2, 90);
    }

    public Object clone() throws CloneNotSupportedException {
        jd jdVar = (jd) super.clone();
        jdVar.MeasurementPointsClient = new i5[this.MeasurementPointsClient.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            i5[] i5VarArr = this.MeasurementPointsClient;
            if (i2 >= i5VarArr.length) {
                break;
            }
            jdVar.MeasurementPointsClient[i2] = (i5) i5VarArr[i2].clone();
            i2++;
        }
        jdVar.MeasurementPointsServer = new i5[this.MeasurementPointsServer.length];
        while (true) {
            i5[] i5VarArr2 = this.MeasurementPointsServer;
            if (i >= i5VarArr2.length) {
                return jdVar;
            }
            jdVar.MeasurementPointsServer[i] = (i5) i5VarArr2[i].clone();
            i++;
        }
    }
}
