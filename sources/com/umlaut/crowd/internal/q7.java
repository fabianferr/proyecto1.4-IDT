package com.umlaut.crowd.internal;

import android.util.Base64;
import android.util.Log;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.database.metrics.SignalStrengthLocationShare;
import com.umlaut.crowd.database.metrics.TTRLocation;
import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.enums.NetworkGenerations;
import com.umlaut.crowd.enums.NetworkTypes;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.utils.DateUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class q7 implements Serializable, Cloneable {
    private static final long q = -3820823297211962244L;
    private static final String r = "q7";
    private static final boolean s = false;
    private static final int t = 10;
    private static final int u = 1;
    private static final int v = 2;
    private ArrayList<p0> a;
    private long b;
    private long c;
    private ArrayList<p0> d;
    private long e;
    private long f;
    private e6 g;
    private Calendar h;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n;
    private n7 o;
    /* access modifiers changed from: private */
    public transient boolean p = false;

    class a implements Runnable {
        final /* synthetic */ q7 a;

        a(q7 q7Var) {
            this.a = q7Var;
        }

        public void run() {
            String a2 = q7.this.a((Object) this.a);
            if (!a2.isEmpty()) {
                kc.a(a2);
            }
            boolean unused = q7.this.p = false;
        }
    }

    private class b implements Comparator<p0> {
        private b() {
        }

        /* renamed from: a */
        public int compare(p0 p0Var, p0 p0Var2) {
            return Long.valueOf(p0Var.a).compareTo(Long.valueOf(p0Var2.a));
        }

        /* synthetic */ b(q7 q7Var, a aVar) {
            this();
        }
    }

    private class c implements Comparator<p0> {
        private c() {
        }

        /* renamed from: a */
        public int compare(p0 p0Var, p0 p0Var2) {
            return Long.valueOf(p0Var.b).compareTo(Long.valueOf(p0Var2.b));
        }

        /* synthetic */ c(q7 q7Var, a aVar) {
            this();
        }
    }

    private void b() {
        this.a = new ArrayList<>();
        this.b = 0;
        this.c = 0;
        this.d = new ArrayList<>();
        this.e = 0;
        this.f = 0;
        this.g = new e6();
        this.n = 0;
    }

    private void c() {
        this.p = true;
        try {
            ThreadManager.getInstance().getIOThreadExecutor().execute(new a((q7) clone()));
        } catch (Exception e2) {
            String str = r;
            Log.e(str, "saveTrafficAnalyzerRPVLAsync: " + e2.toString());
            this.p = false;
        }
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        q7 q7Var = (q7) super.clone();
        q7Var.h = (Calendar) this.h.clone();
        q7Var.o = (n7) this.o.clone();
        q7Var.g = (e6) this.g.clone();
        q7Var.a = new ArrayList<>(this.a.size());
        Iterator<p0> it = this.a.iterator();
        while (it.hasNext()) {
            q7Var.a.add((p0) it.next().clone());
        }
        return q7Var;
    }

    /* access modifiers changed from: package-private */
    public void a(ub ubVar, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, DRI dri, DWI dwi, q4 q4Var, n7 n7Var, z zVar, n1 n1Var, e4 e4Var) {
        DRI dri2 = dri;
        if (this.h == null) {
            this.h = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        }
        this.h.setTimeInMillis(ubVar.TimestampMillis);
        int i2 = this.h.get(5);
        int i3 = this.h.get(11);
        int i4 = (this.h.get(12) / 15) + 1;
        boolean z = false;
        boolean z2 = (i3 != this.j) | (i2 != this.k);
        if (this.i != i4) {
            z = true;
        }
        if (z2 || z) {
            a();
            b();
            this.l = this.h.get(1);
            this.k = i2;
            this.j = i3;
            this.i = i4;
        }
        this.o = n7Var;
        if ((j2 > 0 || j3 > 0) && dwi != null) {
            p0 p0Var = r1;
            ArrayList<p0> arrayList = this.a;
            p0 p0Var2 = new p0(j2, j3, dwi, dri, q4Var, ubVar, zVar, n1Var, e4Var);
            arrayList.add(p0Var);
        }
        this.b += j12;
        this.c += j13;
        if (j8 > 0 || j9 > 0) {
            this.d.add(new p0(j8, j9, dwi, dri, q4Var, ubVar, zVar, n1Var, e4Var));
        }
        if (dri2.ConnectionType == ConnectionTypes.Unknown) {
            this.n++;
        }
        this.e += j10;
        this.f += j11;
        NetworkGenerations a2 = l7.a(dri2.NetworkType, dri2.NrState, dri2.DisplayNetworkType);
        if (a2 != null) {
            this.g.a(dri2.MCC, dri2.MNC, j4, j5, a2, j6, j7, dri, dwi, q4Var, ubVar, zVar, n1Var, e4Var);
            int i5 = this.m;
            this.m = i5 + 1;
            if (i5 % 5 == 0 && !this.p) {
                c();
            }
        }
    }

    private int b(ArrayList<p0> arrayList, int i2) {
        int i3 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<p0> it = arrayList.iterator();
        while (it.hasNext()) {
            p0 next = it.next();
            if (i2 == 1) {
                if (next.a <= 0) {
                }
            } else if (i2 == 2) {
                if (next.b <= 0) {
                }
            }
            i3++;
        }
        return i3;
    }

    /* access modifiers changed from: private */
    public String a(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 11);
        } catch (Exception e2) {
            String str = r;
            Log.e(str, "toBase64String: " + e2.toString(), e2);
            return "";
        }
    }

    static q7 a(String str) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 11)));
            q7 q7Var = (q7) objectInputStream.readObject();
            objectInputStream.close();
            return q7Var;
        } catch (Exception e2) {
            String str2 = r;
            Log.d(str2, "loadFromBase64: " + e2.toString(), e2);
            return null;
        }
    }

    private void a() {
        long j2;
        long j3;
        int i2;
        int i3;
        int i4;
        TTRLocation tTRLocation;
        int i5;
        d6[] d6VarArr;
        int i6;
        oc ocVar;
        d6 d6Var;
        if (this.l != 0 && this.g != null && this.a != null && this.d != null) {
            boolean v1 = InsightCore.getInsightConfig().v1();
            int b2 = b(this.a, 1);
            p0 a2 = a(this.a, 1);
            long j4 = a2.a;
            int b3 = b(this.a, 2);
            p0 a3 = a(this.a, 2);
            long j5 = a3.b;
            int b4 = b(this.d, 1);
            p0 a4 = a(this.d, 1);
            int b5 = b(this.d, 2);
            p0 a5 = a(this.d, 2);
            TTRLocation tTRLocation2 = new TTRLocation();
            int i7 = 10;
            if (b2 >= 10) {
                tTRLocation = tTRLocation2;
                j3 = j4;
                i4 = b5;
                i3 = b4;
                j2 = j5;
                m6 a6 = a(l6.WiFi, b5.Downlink, a2, b2, this.b);
                InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a6);
                q4 q4Var = a6.LocationInfo;
                tTRLocation.RvWifiLat = q4Var.LocationLatitude;
                tTRLocation.RvWifiLong = q4Var.LocationLongitude;
                i2 = b3;
                i7 = 10;
            } else {
                tTRLocation = tTRLocation2;
                j2 = j5;
                j3 = j4;
                i4 = b5;
                i3 = b4;
                i2 = b3;
            }
            if (i2 >= i7) {
                InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a(l6.WiFi, b5.Uplink, a3, i2, this.c));
            }
            if (v1) {
                InsightCore.getDatabaseHelper().a(w2.MPT, (RBR[]) a(this.a, l6.WiFi));
            }
            int i8 = 10;
            if (i3 >= 10) {
                InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a(l6.Ethernet, b5.Downlink, a4, i3, this.e));
                i8 = 10;
            }
            if (i4 >= i8) {
                InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a(l6.Ethernet, b5.Uplink, a5, i4, this.f));
            }
            if (v1) {
                InsightCore.getDatabaseHelper().a(w2.MPT, (RBR[]) a(this.d, l6.Ethernet));
            }
            d6[] a7 = this.g.a();
            int length = a7.length;
            int i9 = 0;
            while (i9 < length) {
                d6 d6Var2 = a7[i9];
                oc ocVar2 = new oc(InsightCore.getInsightConfig().f1(), InsightCore.getGUID());
                GregorianCalendar gregorianCalendar = (GregorianCalendar) this.h.clone();
                gregorianCalendar.setTimeZone(TimeZone.getDefault());
                ocVar2.Day = gregorianCalendar.get(5);
                ocVar2.Hour = gregorianCalendar.get(11);
                ocVar2.Quarter = (gregorianCalendar.get(12) / 15) + 1;
                ocVar2.Month = gregorianCalendar.get(2) + 1;
                ocVar2.Year = gregorianCalendar.get(1);
                int offset = gregorianCalendar.getTimeZone().getOffset(gregorianCalendar.getTimeInMillis());
                int i10 = ocVar2.Year;
                int i11 = ocVar2.Month;
                int i12 = ocVar2.Day;
                ocVar2.TimestampBin = DateUtils.simpleFormatDateTime(i10, i11, i12, ocVar2.Hour, (ocVar2.Quarter - 1) * 15, 0, 0, true, offset);
                ocVar2.MCC = d6Var2.a;
                ocVar2.MNC = d6Var2.b;
                int b6 = b(d6Var2.c, 1);
                if (b6 >= 10) {
                    ocVar2.RvMobile2gRxSamples = b6;
                    p0 a8 = a(d6Var2.c, 1);
                    ocVar2.RvMobile2gRx = a8.a;
                    i6 = length;
                    d6VarArr = a7;
                    i5 = i9;
                    d6Var = d6Var2;
                    ocVar = ocVar2;
                    m6 a9 = a(l6.Mobile2G, b5.Downlink, a8, b6, d6Var2.j);
                    InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a9);
                    q4 q4Var2 = a9.LocationInfo;
                    tTRLocation.RvMobile2gLat = q4Var2.LocationLatitude;
                    tTRLocation.RvMobile2gLong = q4Var2.LocationLongitude;
                } else {
                    d6Var = d6Var2;
                    d6VarArr = a7;
                    i6 = length;
                    i5 = i9;
                    ocVar = ocVar2;
                }
                int b7 = b(d6Var.d, 1);
                if (b7 >= 10) {
                    ocVar.RvMobile3gRxSamples = b7;
                    p0 a10 = a(d6Var.d, 1);
                    ocVar.RvMobile3gRx = a10.a;
                    m6 a11 = a(l6.Mobile3G, b5.Downlink, a10, b7, d6Var.l);
                    InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a11);
                    q4 q4Var3 = a11.LocationInfo;
                    tTRLocation.RvMobile3gLat = q4Var3.LocationLatitude;
                    tTRLocation.RvMobile3gLong = q4Var3.LocationLongitude;
                }
                int b8 = b(d6Var.e, 1);
                if (b8 >= 10) {
                    ocVar.RvMobile4gRxSamples = b8;
                    p0 a12 = a(d6Var.e, 1);
                    ocVar.RvMobile4gRx = a12.a;
                    m6 a13 = a(l6.Mobile4G, b5.Downlink, a12, b8, d6Var.n);
                    InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a13);
                    q4 q4Var4 = a13.LocationInfo;
                    tTRLocation.RvMobile4gLat = q4Var4.LocationLatitude;
                    tTRLocation.RvMobile4gLong = q4Var4.LocationLongitude;
                }
                int b9 = b(d6Var.f, 1);
                if (b9 >= 10) {
                    InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a(l6.Mobile4G5G, b5.Downlink, a(d6Var.f, 1), b9, d6Var.p));
                }
                int b10 = b(d6Var.g, 1);
                if (b10 >= 10) {
                    InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a(l6.Mobile5GSA, b5.Downlink, a(d6Var.g, 1), b10, d6Var.r));
                }
                int b11 = b(d6Var.g, 1) + b(d6Var.f, 1);
                if (b11 >= 10) {
                    ocVar.RvMobile5gRxSamples = b11;
                    ArrayList arrayList = new ArrayList(d6Var.f.size() + d6Var.g.size());
                    arrayList.addAll(d6Var.f);
                    arrayList.addAll(d6Var.g);
                    p0 a14 = a((ArrayList<p0>) arrayList, 1);
                    ocVar.RvMobile5gRx = a14.a;
                    q4 q4Var5 = a14.e;
                    tTRLocation.RvMobile5gLat = q4Var5.LocationLatitude;
                    tTRLocation.RvMobile5gLong = q4Var5.LocationLongitude;
                }
                int b12 = b(d6Var.c, 2);
                if (b12 >= 10) {
                    ocVar.RvMobile2gTxSamples = b12;
                    p0 a15 = a(d6Var.c, 2);
                    ocVar.RvMobile2gTx = a15.b;
                    InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a(l6.Mobile2G, b5.Uplink, a15, b12, d6Var.k));
                }
                int b13 = b(d6Var.d, 2);
                if (b13 >= 10) {
                    ocVar.RvMobile3gTxSamples = b13;
                    p0 a16 = a(d6Var.d, 2);
                    ocVar.RvMobile3gTx = a16.b;
                    InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a(l6.Mobile3G, b5.Uplink, a16, b13, d6Var.m));
                }
                int b14 = b(d6Var.e, 2);
                if (b14 >= 10) {
                    ocVar.RvMobile4gTxSamples = b14;
                    p0 a17 = a(d6Var.e, 2);
                    ocVar.RvMobile4gTx = a17.b;
                    InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a(l6.Mobile4G, b5.Uplink, a17, b14, d6Var.o));
                }
                int b15 = b(d6Var.f, 2);
                if (b15 >= 10) {
                    InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a(l6.Mobile4G5G, b5.Uplink, a(d6Var.f, 2), b15, d6Var.q));
                }
                int b16 = b(d6Var.g, 2);
                if (b16 >= 10) {
                    InsightCore.getDatabaseHelper().a(w2.NTR, (RBR) a(l6.Mobile5GSA, b5.Uplink, a(d6Var.g, 2), b16, d6Var.s));
                }
                int b17 = b(d6Var.g, 2) + b(d6Var.f, 2);
                if (b17 >= 10) {
                    ocVar.RvMobile5gTxSamples = b17;
                    ArrayList arrayList2 = new ArrayList(d6Var.f.size() + d6Var.g.size());
                    arrayList2.addAll(d6Var.f);
                    arrayList2.addAll(d6Var.g);
                    ocVar.RvMobile5gTx = a((ArrayList<p0>) arrayList2, 2).b;
                }
                ocVar.TrafficBytesRxMobile = d6Var.h;
                ocVar.TrafficBytesTxMobile = d6Var.i;
                if (v1) {
                    h5[] a18 = a(d6Var.c, l6.Mobile2G);
                    u1 databaseHelper = InsightCore.getDatabaseHelper();
                    w2 w2Var = w2.MPT;
                    databaseHelper.a(w2Var, (RBR[]) a18);
                    InsightCore.getDatabaseHelper().a(w2Var, (RBR[]) a(d6Var.d, l6.Mobile3G));
                    InsightCore.getDatabaseHelper().a(w2Var, (RBR[]) a(d6Var.e, l6.Mobile4G));
                    InsightCore.getDatabaseHelper().a(w2Var, (RBR[]) a(d6Var.f, l6.Mobile4G5G));
                    InsightCore.getDatabaseHelper().a(w2Var, (RBR[]) a(d6Var.g, l6.Mobile5GSA));
                }
                long j6 = j3;
                if (b2 >= 10) {
                    ocVar.RvWifiRx = j6;
                    ocVar.RvWifiRxSamples = b2;
                    ocVar.TrafficBytesRxWifi = this.b;
                }
                long j7 = j2;
                if (i2 >= 10) {
                    ocVar.RvWifiTx = j7;
                    ocVar.RvWifiTxSamples = i2;
                    ocVar.TrafficBytesTxWifi = this.c;
                }
                if (InsightCore.getInsightConfig().m1()) {
                    InsightCore.getStatsDatabase().a(ocVar, tTRLocation);
                }
                i9 = i5 + 1;
                j3 = j6;
                j2 = j7;
                length = i6;
                a7 = d6VarArr;
            }
            d6[] d6VarArr2 = a7;
            if (InsightCore.getInsightConfig().m1() && InsightCore.getInsightConfig().t1()) {
                ub ubVar = new ub();
                ubVar.setMillis(this.h.getTimeInMillis());
                k9 k9Var = new k9();
                k9 k9Var2 = new k9();
                ArrayList arrayList3 = new ArrayList();
                Iterator<p0> it = this.a.iterator();
                while (it.hasNext()) {
                    p0 next = it.next();
                    k9Var.addMeasurement(ee.a(next.c));
                    arrayList3.add(SignalStrengthLocationShare.a(ConnectionTypes.WiFi, next.e, next.d, next.c));
                    DRI dri = next.d;
                    if (!(dri.RXLevel == 0 || dri.NetworkType == NetworkTypes.Unknown)) {
                        k9Var2.addMeasurement(l7.b(dri));
                        arrayList3.add(SignalStrengthLocationShare.a(ConnectionTypes.Mobile, next.e, next.d, next.c));
                    }
                }
                d6[] d6VarArr3 = d6VarArr2;
                int length2 = d6VarArr3.length;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                while (i17 < length2) {
                    d6 d6Var3 = d6VarArr3[i17];
                    Iterator<p0> it2 = d6Var3.c.iterator();
                    while (it2.hasNext()) {
                        p0 next2 = it2.next();
                        i13 += d6Var3.c.size();
                        k9Var2.addMeasurement(l7.b(next2.d));
                        arrayList3.add(SignalStrengthLocationShare.a(ConnectionTypes.Mobile, next2.e, next2.d, next2.c));
                        length2 = length2;
                        d6VarArr3 = d6VarArr3;
                    }
                    int i18 = length2;
                    d6[] d6VarArr4 = d6VarArr3;
                    Iterator<p0> it3 = d6Var3.d.iterator();
                    while (it3.hasNext()) {
                        p0 next3 = it3.next();
                        i14 += d6Var3.d.size();
                        k9Var2.addMeasurement(l7.b(next3.d));
                        arrayList3.add(SignalStrengthLocationShare.a(ConnectionTypes.Mobile, next3.e, next3.d, next3.c));
                    }
                    Iterator<p0> it4 = d6Var3.e.iterator();
                    while (it4.hasNext()) {
                        p0 next4 = it4.next();
                        i15 += d6Var3.e.size();
                        k9Var2.addMeasurement(l7.b(next4.d));
                        arrayList3.add(SignalStrengthLocationShare.a(ConnectionTypes.Mobile, next4.e, next4.d, next4.c));
                    }
                    Iterator<p0> it5 = d6Var3.f.iterator();
                    while (it5.hasNext()) {
                        p0 next5 = it5.next();
                        i16 += d6Var3.f.size();
                        k9Var2.addMeasurement(l7.b(next5.d));
                        arrayList3.add(SignalStrengthLocationShare.a(ConnectionTypes.Mobile, next5.e, next5.d, next5.c));
                    }
                    Iterator<p0> it6 = d6Var3.g.iterator();
                    while (it6.hasNext()) {
                        p0 next6 = it6.next();
                        i16 += d6Var3.g.size();
                        k9Var2.addMeasurement(l7.b(next6.d));
                        arrayList3.add(SignalStrengthLocationShare.a(ConnectionTypes.Mobile, next6.e, next6.d, next6.c));
                    }
                    i17++;
                    length2 = i18;
                    d6VarArr3 = d6VarArr4;
                }
                InsightCore.getStatsDatabase().a(ubVar, k9Var2, k9Var);
                InsightCore.getStatsDatabase().a(ubVar, (List<SignalStrengthLocationShare>) arrayList3);
                InsightCore.getStatsDatabase().a(ubVar, i13, i14, i15, i16, this.a.size(), this.n);
            }
            kc.a("");
        }
    }

    private p0 a(ArrayList<p0> arrayList, int i2) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<p0> it = arrayList.iterator();
        while (it.hasNext()) {
            p0 next = it.next();
            if (i2 == 1) {
                if (next.a > 0) {
                    arrayList2.add(next);
                }
            } else if (i2 == 2 && next.b > 0) {
                arrayList2.add(next);
            }
        }
        int size = arrayList2.size();
        if (size == 0) {
            return new p0();
        }
        if (i2 == 1) {
            Collections.sort(arrayList2, new b(this, (a) null));
        } else if (i2 == 2) {
            Collections.sort(arrayList2, new c(this, (a) null));
        }
        double d2 = size > 50 ? 0.99d : size > 20 ? 0.95d : 0.8d;
        double d3 = (double) size;
        Double.isNaN(d3);
        double d4 = d2 * (d3 - 1.0d);
        int i3 = (int) d4;
        double d5 = (double) i3;
        Double.isNaN(d5);
        double d6 = d4 - d5;
        if (d4 < 1.0d) {
            return (p0) arrayList2.get(0);
        }
        if (d4 >= d3) {
            return (p0) arrayList2.get(size - 1);
        }
        if (size > i3 + 1) {
            return (p0) arrayList2.get(i3 + ((int) Math.round(d6)));
        }
        return (p0) arrayList2.get(i3);
    }

    private m6 a(l6 l6Var, b5 b5Var, p0 p0Var, int i2, long j2) {
        m6 m6Var = new m6(InsightCore.getInsightConfig().f1(), InsightCore.getGUID());
        m6Var.TimestampBin = a(p0Var.h);
        n7 n7Var = this.o;
        if (n7Var != null) {
            m6Var.DeviceInfoOS = n7Var.a;
            m6Var.DeviceInfoOSVersion = n7Var.b;
            m6Var.DeviceInfoSimOperator = n7Var.c;
            m6Var.DeviceInfoSimOperatorName = n7Var.d;
            m6Var.DeviceInfoSimState = n7Var.g;
            m6Var.DeviceInfoPowerSaveMode = n7Var.i;
        }
        m6Var.Technology = l6Var;
        m6Var.TrafficDirection = b5Var;
        if (b5Var == b5.Downlink) {
            m6Var.ThroughputRv = p0Var.a;
            m6Var.ThroughputRvConcurrent = p0Var.b;
        } else if (b5Var == b5.Uplink) {
            m6Var.ThroughputRv = p0Var.b;
            m6Var.ThroughputRvConcurrent = p0Var.a;
        }
        m6Var.Samples = i2;
        m6Var.TrafficBytes = j2;
        DRI dri = p0Var.d;
        if (dri != null) {
            m6Var.RadioInfo = dri;
        }
        DWI dwi = p0Var.c;
        if (dwi != null) {
            m6Var.WifiInfo = dwi;
        }
        q4 q4Var = p0Var.e;
        if (q4Var != null) {
            m6Var.LocationInfo = q4Var;
        }
        ub ubVar = p0Var.h;
        if (ubVar != null) {
            m6Var.TimeInfo = ubVar;
        }
        e4 e4Var = p0Var.i;
        if (e4Var != null) {
            m6Var.IspInfoWifi = e4Var;
        }
        return m6Var;
    }

    private String a(ub ubVar) {
        int i2 = (int) (ubVar.TimestampOffset * 1000.0d * 60.0d * 60.0d);
        v1 millisToDate = DateUtils.millisToDate(ubVar.TimestampMillis, i2);
        return DateUtils.simpleFormatDateTime(millisToDate.a, millisToDate.b, millisToDate.c, millisToDate.d, (((millisToDate.e / 15) + 1) - 1) * 15, 0, 0, true, i2);
    }

    private h5[] a(ArrayList<p0> arrayList, l6 l6Var) {
        ArrayList arrayList2 = new ArrayList();
        String f1 = InsightCore.getInsightConfig().f1();
        String guid = InsightCore.getGUID();
        Iterator<p0> it = arrayList.iterator();
        while (it.hasNext()) {
            p0 next = it.next();
            h5 h5Var = new h5(f1, guid);
            h5Var.FkTimestampBin = a(next.h);
            DRI dri = next.d;
            h5Var.ConnectionType = dri.ConnectionType;
            h5Var.NetworkType = dri.NetworkType;
            h5Var.DisplayNetworkType = dri.DisplayNetworkType;
            h5Var.NrAvailable = dri.NrAvailable;
            h5Var.NrState = dri.NrState;
            h5Var.LocationInfo = next.e;
            h5Var.GsmCellId = dri.GsmCellId;
            h5Var.GsmLAC = dri.GsmLAC;
            h5Var.MCC = dri.MCC;
            h5Var.MNC = dri.MNC;
            h5Var.RxLevel = dri.RXLevel;
            h5Var.ThroughputRateRx = next.a;
            h5Var.ThroughputRateTx = next.b;
            ub ubVar = next.h;
            h5Var.TimestampMillis = ubVar.TimestampMillis;
            h5Var.Technology = l6Var;
            h5Var.Timestamp = ubVar.TimestampTableau;
            z zVar = next.f;
            h5Var.BatteryChargePlug = zVar.BatteryChargePlug;
            h5Var.BatteryLevel = zVar.BatteryLevel;
            h5Var.ARFCN = dri.ARFCN;
            h5Var.OperatorName = dri.OperatorName;
            h5Var.GsmCellIdAge = dri.GsmCellIdAge;
            h5Var.RXLevelAge = dri.RXLevelAge;
            n1 n1Var = next.g;
            h5Var.CpuLoad = n1Var.CpuLoad;
            h5Var.GpuLoad = n1Var.GpuLoad;
            n7 n7Var = this.o;
            if (n7Var != null) {
                h5Var.SimOperator = n7Var.c;
                h5Var.SimOperatorName = n7Var.d;
                h5Var.DeviceManufacturer = n7Var.e;
                h5Var.DeviceName = n7Var.f;
                h5Var.TAC = n7Var.h;
                h5Var.OSVersion = n7Var.b;
                h5Var.SimState = n7Var.g;
                h5Var.SimInfoCarrierName = n7Var.j;
                h5Var.SimInfoDataRoaming = n7Var.k;
                h5Var.SimInfoMcc = n7Var.l;
                h5Var.SimInfoMnc = n7Var.m;
            }
            arrayList2.add(h5Var);
        }
        return (h5[]) arrayList2.toArray(new h5[arrayList2.size()]);
    }
}
