package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.speedtest.SpeedtestEngineError;

public class RP3 extends RBR implements Cloneable {
    public long AvgValue;
    public z BatteryInfoOnEnd;
    public z BatteryInfoOnStart;
    public String CampaignId;
    public z0[] CellInfoOnEnd;
    public z0[] CellInfoOnStart;
    public long ConnectingTimeControlServer;
    public long ConnectingTimeTestServerControl;
    public long ConnectingTimeTestServerSockets;
    public String CustomerID;
    public a2 DeviceInfo;
    public String IMEI;
    public String IMSI;
    public d4 IpVersion = d4.Unknown;
    public int IsAppInForeground;
    public e4 IspInfo;
    public q4 LocationInfoOnEnd;
    public q4 LocationInfoOnStart;
    public long MaxValue;
    public m5 MeasurementType = m5.Unknown;
    public long MedValue;
    public n5 MemoryInfoOnEnd;
    public n5 MemoryInfoOnStart;
    public String Meta;
    public long MinValue;
    public k7[] QuestionAnswerList;
    public String QuestionnaireName = "";
    public DRI RadioInfoOnEnd;
    public DRI RadioInfoOnStart;
    public double RatShare2G;
    public double RatShare3G;
    public double RatShare4G;
    public double RatShare4G5G;
    public double RatShare5GSA;
    public double RatShareUnknown;
    public double RatShareWiFi;
    public String SequenceID;
    public String Server = "";
    public String ServerUrl = "";
    public boolean Success;
    public t9 TestEndState = t9.Unknown;
    public String TestErrorReason;
    public transient SpeedtestEngineError TestErrorReasonType;
    public String TestsInProgress;
    public ub TimeInfoOnEnd;
    public ub TimeInfoOnStart;
    public nc TrafficInfoOnEnd;
    public nc TrafficInfoOnStart;
    public a Trigger;
    public DWI WifiInfoOnEnd;
    public DWI WifiInfoOnStart;

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
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.RP3.a.<clinit>():void");
        }
    }

    public RP3(String str, String str2) {
        super(str, str2);
        SpeedtestEngineError speedtestEngineError = SpeedtestEngineError.OK;
        this.TestErrorReason = speedtestEngineError.name();
        this.TestErrorReasonType = speedtestEngineError;
        this.ConnectingTimeControlServer = -1;
        this.ConnectingTimeTestServerControl = -1;
        this.ConnectingTimeTestServerSockets = -1;
        this.IMSI = "";
        this.IMEI = "";
        this.Meta = "";
        this.CampaignId = "";
        this.CustomerID = "";
        this.SequenceID = "";
        this.IsAppInForeground = -1;
        this.TestsInProgress = "";
        this.Trigger = a.Unknown;
        this.TimeInfoOnStart = new ub();
        this.TimeInfoOnEnd = new ub();
        this.QuestionAnswerList = new k7[0];
        this.BatteryInfoOnEnd = new z();
        this.BatteryInfoOnStart = new z();
        this.LocationInfoOnEnd = new q4();
        this.LocationInfoOnStart = new q4();
        this.MemoryInfoOnEnd = new n5();
        this.MemoryInfoOnStart = new n5();
        this.RadioInfoOnEnd = new DRI();
        this.RadioInfoOnStart = new DRI();
        this.TrafficInfoOnEnd = new nc();
        this.TrafficInfoOnStart = new nc();
        this.WifiInfoOnEnd = new DWI();
        this.WifiInfoOnStart = new DWI();
        this.DeviceInfo = new a2();
        this.IspInfo = new e4();
        this.CellInfoOnStart = new z0[0];
        this.CellInfoOnEnd = new z0[0];
    }

    public void a(d5[] d5VarArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (d5 d5Var : d5VarArr) {
            ConnectionTypes connectionTypes = d5Var.ConnectionType;
            if (connectionTypes != ConnectionTypes.Unknown) {
                if (connectionTypes == ConnectionTypes.Mobile) {
                    int i9 = a.a[l7.a(d5Var.NetworkType, d5Var.NrState, d5Var.DisplayNetworkType).ordinal()];
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
    }

    public Object clone() throws CloneNotSupportedException {
        RP3 rp3 = (RP3) super.clone();
        rp3.DeviceInfo = (a2) this.DeviceInfo.clone();
        rp3.BatteryInfoOnStart = (z) this.BatteryInfoOnStart.clone();
        rp3.LocationInfoOnStart = (q4) this.LocationInfoOnStart.clone();
        rp3.MemoryInfoOnStart = (n5) this.MemoryInfoOnStart.clone();
        rp3.TrafficInfoOnStart = (nc) this.TrafficInfoOnStart.clone();
        rp3.WifiInfoOnStart = (DWI) this.WifiInfoOnStart.clone();
        rp3.RadioInfoOnStart = (DRI) this.RadioInfoOnStart.clone();
        rp3.TimeInfoOnStart = (ub) this.TimeInfoOnStart.clone();
        rp3.BatteryInfoOnEnd = (z) this.BatteryInfoOnEnd.clone();
        rp3.LocationInfoOnEnd = (q4) this.LocationInfoOnEnd.clone();
        rp3.MemoryInfoOnEnd = (n5) this.MemoryInfoOnEnd.clone();
        rp3.RadioInfoOnEnd = (DRI) this.RadioInfoOnEnd.clone();
        rp3.TimeInfoOnEnd = (ub) this.TimeInfoOnEnd.clone();
        rp3.TrafficInfoOnEnd = (nc) this.TrafficInfoOnEnd.clone();
        rp3.WifiInfoOnEnd = (DWI) this.WifiInfoOnEnd.clone();
        rp3.IspInfo = (e4) this.IspInfo.clone();
        rp3.QuestionAnswerList = new k7[this.QuestionAnswerList.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            k7[] k7VarArr = this.QuestionAnswerList;
            if (i2 >= k7VarArr.length) {
                break;
            }
            rp3.QuestionAnswerList[i2] = (k7) k7VarArr[i2].clone();
            i2++;
        }
        rp3.CellInfoOnStart = new z0[this.CellInfoOnStart.length];
        int i3 = 0;
        while (true) {
            z0[] z0VarArr = this.CellInfoOnStart;
            if (i3 >= z0VarArr.length) {
                break;
            }
            rp3.CellInfoOnStart[i3] = (z0) z0VarArr[i3].clone();
            i3++;
        }
        rp3.CellInfoOnEnd = new z0[this.CellInfoOnEnd.length];
        while (true) {
            z0[] z0VarArr2 = this.CellInfoOnEnd;
            if (i >= z0VarArr2.length) {
                return rp3;
            }
            rp3.CellInfoOnEnd[i] = (z0) z0VarArr2[i].clone();
            i++;
        }
    }
}
