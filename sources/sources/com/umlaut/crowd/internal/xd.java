package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xd extends RBR {
    public String CampaignId = "";
    public z0[] CellInfo = new z0[0];
    public long ConnectEnd;
    public long ConnectStart;
    public long ConnectionDuration;
    public String CustomerID = "";
    public long DecodedBodySize;
    public a2 DeviceInfo = new a2();
    public long DnsLookupDuration;
    public long DomComplete;
    public long DomContentLoadedEventEnd;
    public long DomContentLoadedEventStart;
    public long DomInteractive;
    public long DomLoadingDuration;
    public long DomainLookupEnd;
    public long DomainLookupStart;
    public long EncodedBodySize;
    public long FetchCacheDuration;
    public long FetchStart;
    public String FinalUrl = "";
    public int IsAppInForeground = -1;
    public boolean IsCachingEnabled;
    public e4 IspInfo = new e4();
    public long LoadEventEnd;
    public long LoadEventStart;
    public long LoadingDuration;
    public q4 LocationInfo = new q4();
    public k5[] MeasurementPointsThroughput = new k5[0];
    public String Meta = "";
    public int NumberOfRedirects;
    public int NumberOfResources;
    public String OriginalUrl = "";
    public long OverallDuration;
    public DRI RadioInfo = new DRI();
    public DRI RadioInfoOnEnd = new DRI();
    public double RatShare2G;
    public double RatShare3G;
    public double RatShare4G;
    public double RatShare4G5G;
    public double RatShare5GSA;
    public double RatShareUnknown;
    public double RatShareWiFi;
    public long RedirectDuration;
    public long RedirectEnd;
    public long RedirectStart;
    public long RequestDuration;
    public long RequestRxAvgValue;
    public long RequestRxMaxValue;
    public long RequestRxMedValue;
    public long RequestStart;
    public long RequestTotalRxBytes = -1;
    public long RequestTotalTxBytes = -1;
    public long RequestTxAvgValue;
    public long RequestTxMaxValue;
    public long RequestTxMedValue;
    public u7[] ResourceMeasurement = new u7[0];
    public long ResponseDuration;
    public long ResponseEnd;
    public long ResponseStart;
    public long SecureConnectionDuration;
    public long SecureConnectionStart;
    public String SequenceID = "";
    public long StartTime;
    public boolean Success;
    public String TestsInProgress = "";
    public ub TimeInfoOnEnd = new ub();
    public ub TimeInfoOnStart = new ub();
    public long TransferSize;
    public a Trigger = a.Unknown;
    public long UnloadEventEnd;
    public long UnloadEventStart;
    public int WebViewHeight;
    public long WebViewLoadingTime;
    public int WebViewWidth;
    public DWI WifiInfo = new DWI();
    public DWI WifiInfoOnEnd = new DWI();
    public long WorkerStart;

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
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.xd.a.<clinit>():void");
        }
    }

    public xd(String str, String str2) {
        super(str, str2);
    }

    public void a(ArrayList<k5> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<k5> it = arrayList.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (it.hasNext()) {
            k5 next = it.next();
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
        this.MeasurementPointsThroughput = (k5[]) arrayList.toArray(new k5[arrayList.size()]);
    }

    public String a() {
        return JsonUtils.toJson(w2.WWW, (RBR) this);
    }
}
