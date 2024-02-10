package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.ConnectionTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bf extends RBR {
    public z BatteryInfoOnEnd = new z();
    public z BatteryInfoOnStart = new z();
    public String CampaignId = "";
    public z0[] CellInfoOnEnd = new z0[0];
    public z0[] CellInfoOnStart = new z0[0];
    public String CustomerID = "";
    public a2 DeviceInfo = new a2();
    public String ErrorCode = "";
    public int IsAppInForeground = -1;
    public boolean IsLiveStream;
    public boolean IsSSL;
    public e4 IspInfo = new e4();
    public int LiveReadaheadChunk = -1;
    public int LiveReadaheadSec = -1;
    public q4 LocationInfoOnEnd = new q4();
    public q4 LocationInfoOnStart = new q4();
    public float Loudness = 0.0f;
    public l5[] MeasurementPointsThroughput = new l5[0];
    public String Meta = "";
    public int NumberOfResources = -1;
    public int PlayerEndTime = -1;
    public int PlayerStartTime = -1;
    public DRI RadioInfoOnEnd = new DRI();
    public DRI RadioInfoOnStart = new DRI();
    public double RatShare2G;
    public double RatShare3G;
    public double RatShare4G;
    public double RatShare4G5G;
    public double RatShare5GSA;
    public double RatShareUnknown;
    public double RatShareWiFi;
    public int ReportingInterval = -1;
    public long RequestRxAvgValue = -1;
    public long RequestRxMaxValue = -1;
    public long RequestRxMedValue = -1;
    public long RequestTotalRxBytes = -1;
    public long RequestTotalTxBytes = -1;
    public long RequestTxAvgValue = -1;
    public long RequestTxMaxValue = -1;
    public long RequestTxMedValue = -1;
    public String SequenceID = "";
    public boolean Success;
    public ye SuggestedQuality = ye.Unknown;
    public l2 TestEndState = l2.UNKNOWN;
    public String TestsInProgress = "";
    public ub TimeInfoOnEnd = new ub();
    public ub TimeInfoOnStart = new ub();
    public int TotalDroppedFrames = -1;
    public long TotalDuration = -1;
    public a Trigger = a.Unknown;
    public String VideoAuthor = "";
    public String VideoId = "";
    public long VideoLoadTime = -1;
    public long VideoStartTime = -1;
    public String VideoTitle = "";
    public int WebViewHeight = -1;
    public int WebViewWidth = -1;
    public DWI WifiInfoOnEnd = new DWI();
    public DWI WifiInfoOnStart = new DWI();
    public cf YoutubeTestType = cf.Unknown;
    public df[] YoutubeVideoInfo = new df[0];

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.enums.NetworkGenerations[] r0 = com.umlaut.crowd.enums.NetworkGenerations.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen2     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen3     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen4     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen5NSA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen5SA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Unknown     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.bf.a.<clinit>():void");
        }
    }

    public bf(String str, String str2) {
        super(str, str2);
    }

    public void a(ArrayList<l5> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<l5> it = arrayList.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (it.hasNext()) {
            l5 next = it.next();
            arrayList2.add(Long.valueOf(next.ThroughputRateRx));
            arrayList3.add(Long.valueOf(next.ThroughputRateTx));
            ConnectionTypes connectionTypes = next.ConnectionType;
            if (connectionTypes != ConnectionTypes.Unknown) {
                if (connectionTypes == ConnectionTypes.Mobile) {
                    int i9 = a.a[l7.a(next.NetworkType, next.NrState, next.DisplayNetworkType).ordinal()];
                    if (i9 == 1) {
                        i8++;
                    } else if (i9 == 2) {
                        i7++;
                    } else if (i9 == 3) {
                        i6++;
                    } else if (i9 == 4) {
                        i5++;
                    } else if (i9 == 5) {
                        i4++;
                    }
                } else {
                    i3++;
                }
                i++;
            }
            i2++;
            i++;
        }
        if (i > 0) {
            double d = (double) i8;
            double d2 = (double) i;
            Double.isNaN(d);
            Double.isNaN(d2);
            this.RatShare2G = d / d2;
            double d3 = (double) i7;
            Double.isNaN(d3);
            Double.isNaN(d2);
            this.RatShare3G = d3 / d2;
            double d4 = (double) i6;
            Double.isNaN(d4);
            Double.isNaN(d2);
            this.RatShare4G = d4 / d2;
            double d5 = (double) i5;
            Double.isNaN(d5);
            Double.isNaN(d2);
            this.RatShare4G5G = d5 / d2;
            double d6 = (double) i4;
            Double.isNaN(d6);
            Double.isNaN(d2);
            this.RatShare5GSA = d6 / d2;
            double d7 = (double) i3;
            Double.isNaN(d7);
            Double.isNaN(d2);
            this.RatShareWiFi = d7 / d2;
            double d8 = (double) i2;
            Double.isNaN(d8);
            Double.isNaN(d2);
            this.RatShareUnknown = d8 / d2;
        }
        this.RequestRxAvgValue = v9.a((List<Long>) arrayList2);
        this.RequestRxMedValue = v9.d(arrayList2);
        this.RequestRxMaxValue = v9.c(arrayList2);
        this.RequestTxAvgValue = v9.a((List<Long>) arrayList3);
        this.RequestTxMedValue = v9.d(arrayList3);
        this.RequestTxMaxValue = v9.c(arrayList3);
        this.NumberOfResources = arrayList.size();
        this.MeasurementPointsThroughput = (l5[]) arrayList.toArray(new l5[arrayList.size()]);
    }
}
