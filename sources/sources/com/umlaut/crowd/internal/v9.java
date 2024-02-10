package com.umlaut.crowd.internal;

import com.umlaut.crowd.speedtest.SpeedtestEngineError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class v9 {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.internal.r5[] r0 = com.umlaut.crowd.internal.r5.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.ARGUMENT_NULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.BROKEN_PIPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.CLOSED_BY_PEER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.CONNECTION_REFUSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.INVALID_SIGNATURE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.IOEXCEPTION     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.SERVER_NOT_REACHABLE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.TESTSERVER_NOT_READY     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.UNEXPECTED_ANSWER     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.UNEXPECTED_ERROR     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.UNKNOWN_HOST     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.INVALID_PARAMETER     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.UNKNOWN_REQUEST     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.REQUEST_FAILED     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.WRONG_CONNECTION     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.umlaut.crowd.internal.r5 r1 = com.umlaut.crowd.internal.r5.NO_FREE_SLOTS     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.v9.a.<clinit>():void");
        }
    }

    public static long a(List<Long> list) {
        long j = 0;
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).longValue();
        }
        for (int i = 0; i < list.size(); i++) {
            j += list.get(i).longValue();
        }
        double d = (double) j;
        double size = (double) list.size();
        Double.isNaN(d);
        Double.isNaN(size);
        return Math.round(d / size);
    }

    public static double b(List<Long> list) {
        long j = 0;
        for (int i = 0; i < list.size(); i++) {
            j += list.get(i).longValue();
        }
        double d = (double) j;
        double size = (double) list.size();
        Double.isNaN(d);
        Double.isNaN(size);
        double d2 = d / size;
        double d3 = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            double longValue = (double) list.get(i2).longValue();
            Double.isNaN(longValue);
            d3 += Math.pow(longValue - d2, 2.0d);
        }
        double size2 = (double) list.size();
        Double.isNaN(size2);
        double sqrt = Math.sqrt(d3 / size2);
        if (Double.isNaN(sqrt)) {
            return 0.0d;
        }
        return sqrt;
    }

    public static long c(List<Long> list) {
        long j = 0;
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).longValue();
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).longValue() > j) {
                j = list.get(i).longValue();
            }
        }
        return j;
    }

    public static long d(List<Long> list) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).longValue();
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        if (arrayList.size() % 2 != 0) {
            return ((Long) arrayList.get(arrayList.size() / 2)).longValue();
        }
        double longValue = (double) ((Long) arrayList.get(arrayList.size() / 2)).longValue();
        double longValue2 = (double) ((Long) arrayList.get((arrayList.size() / 2) - 1)).longValue();
        Double.isNaN(longValue);
        Double.isNaN(longValue2);
        return Math.round((longValue + longValue2) / 2.0d);
    }

    public static long e(List<Long> list) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).longValue();
        }
        long j = Long.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).longValue() < j) {
                j = list.get(i).longValue();
            }
        }
        return j;
    }

    public static long a(ArrayList<Long> arrayList, int i) {
        int size = arrayList.size();
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return arrayList.get(0).longValue();
        }
        double d = (double) i;
        Double.isNaN(d);
        int i2 = size - 1;
        double d2 = (double) i2;
        Double.isNaN(d2);
        double d3 = (d / 100.0d) * d2;
        int i3 = (int) d3;
        double longValue = (double) arrayList.get(i3).longValue();
        double d4 = (double) i3;
        Double.isNaN(d4);
        double d5 = d3 - d4;
        if (i3 == i2 || d5 == 0.0d) {
            return Math.round(longValue);
        }
        double longValue2 = (double) arrayList.get(i3 + 1).longValue();
        Double.isNaN(longValue2);
        Double.isNaN(longValue);
        Double.isNaN(longValue);
        return Math.round(longValue + (d5 * (longValue2 - longValue)));
    }

    public static DWI b(int i, int i2, List<DWI> list) {
        int i3 = i / i2;
        if (i3 >= list.size()) {
            i3 = list.size() - 1;
        }
        return list.get(i3);
    }

    public static void b(ArrayList<?> arrayList, int i) {
        arrayList.ensureCapacity(i);
        while (arrayList.size() < i) {
            arrayList.add((Object) null);
        }
    }

    public static g5 a(long j, long j2, DRI dri, DWI dwi, long j3) {
        if (j2 == 0) {
            return null;
        }
        double d = (double) j2;
        Double.isNaN(d);
        double d2 = (double) (8 * j);
        Double.isNaN(d2);
        long j4 = (long) (d2 / (d / 1000.0d));
        g5 g5Var = new g5();
        g5Var.BytesTransmitted = j;
        g5Var.DisplayNetworkType = dri.DisplayNetworkType;
        g5Var.ConnectionType = dri.ConnectionType;
        g5Var.NetworkType = dri.NetworkType;
        g5Var.NrAvailable = dri.NrAvailable;
        g5Var.NrState = dri.NrState;
        g5Var.RxLev = dri.RXLevel;
        g5Var.WifiInfo = dwi;
        g5Var.Delta = j3;
        g5Var.ThroughputRate = j4;
        return g5Var;
    }

    public static e5 a(long j, DRI dri, long j2) {
        e5 e5Var = new e5();
        e5Var.Rtt = (int) j;
        e5Var.DisplayNetworkType = dri.DisplayNetworkType;
        e5Var.ConnectionType = dri.ConnectionType;
        e5Var.NetworkType = dri.NetworkType;
        e5Var.NrAvailable = dri.NrAvailable;
        e5Var.NrState = dri.NrState;
        e5Var.RxLev = dri.RXLevel;
        e5Var.Delta = j2;
        return e5Var;
    }

    public static i5 a(long j, long j2, int i, long j3, long j4, long j5, DRI dri, DWI dwi, int i2) {
        i5 i5Var = new i5();
        i5Var.PackagesReceived = j3;
        i5Var.JitterSum = j4;
        i5Var.JitterPackagesCount = j5;
        double d = (double) (j3 * ((long) i) * 8);
        double d2 = (double) (j2 - j);
        Double.isNaN(d2);
        Double.isNaN(d);
        i5Var.ThroughputRate = (long) (d / (d2 / 1.0E9d));
        i5Var.DisplayNetworkType = dri.DisplayNetworkType;
        i5Var.ConnectionType = dri.ConnectionType;
        i5Var.NetworkType = dri.NetworkType;
        i5Var.NrAvailable = dri.NrAvailable;
        i5Var.NrState = dri.NrState;
        i5Var.RxLev = dri.RXLevel;
        i5Var.Delta = (long) i2;
        i5Var.RadioInfo = dri;
        i5Var.WifiInfo = dwi;
        return i5Var;
    }

    public static DRI a(int i, int i2, List<DRI> list) {
        int i3 = i / i2;
        if (i3 >= list.size()) {
            i3 = list.size() - 1;
        }
        return list.get(i3);
    }

    public static SpeedtestEngineError a(r5 r5Var) {
        switch (a.a[r5Var.ordinal()]) {
            case 1:
                return SpeedtestEngineError.ARGUMENT_NULL;
            case 2:
                return SpeedtestEngineError.BROKEN_PIPE;
            case 3:
                return SpeedtestEngineError.CLOSED_BY_PEER;
            case 4:
                return SpeedtestEngineError.CONNECTION_REFUSED;
            case 5:
                return SpeedtestEngineError.INVALID_SIGNATURE;
            case 6:
                return SpeedtestEngineError.IOEXCEPTION;
            case 7:
                return SpeedtestEngineError.SERVER_NOT_REACHABLE;
            case 8:
                return SpeedtestEngineError.OK;
            case 9:
                return SpeedtestEngineError.TESTSERVER_NOT_READY;
            case 10:
                return SpeedtestEngineError.TIMEOUT;
            case 11:
                return SpeedtestEngineError.UNEXPECTED_ANSWER;
            case 12:
                return SpeedtestEngineError.UNEXPECTED_ERROR;
            case 13:
                return SpeedtestEngineError.UNKNOWN_HOST;
            case 14:
                return SpeedtestEngineError.INVALID_PARAMETER;
            case 15:
                return SpeedtestEngineError.UNKNOWN_ERROR;
            case 16:
                return SpeedtestEngineError.CLIENT_REQUEST_ERROR;
            case 17:
                return SpeedtestEngineError.CONTROL_SERVER_REQUEST_ERROR;
            case 18:
                return SpeedtestEngineError.WRONG_CONNECTION;
            case 19:
                return SpeedtestEngineError.NO_TESTSERVER_AVAILABLE;
            default:
                return SpeedtestEngineError.UNKNOWN_ERROR;
        }
    }
}
