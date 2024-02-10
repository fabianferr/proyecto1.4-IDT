package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.RssItemTypes;
import com.umlaut.crowd.enums.RssRequestTypes;
import com.umlaut.crowd.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;

public class b8 extends RBR {
    public a2 DeviceInfo = new a2();
    public String FeedCategory = "";
    public boolean IsCached;
    public long ItemLoadingTime;
    public q4 LocationInfo = new q4();
    public f5[] MeasurementPointsThroughput = new f5[0];
    public DRI RadioInfo = new DRI();
    public int RequestRxAvgValue;
    public int RequestRxMaxValue;
    public int RequestRxMedValue;
    public long RequestTotalRxBytes = -1;
    public long RequestTotalTxBytes = -1;
    public int RequestTxAvgValue;
    public int RequestTxMaxValue;
    public int RequestTxMedValue;
    public RssItemTypes RssItemType = RssItemTypes.Unknown;
    public RssRequestTypes RssRequestType = RssRequestTypes.Unknown;
    public ub TimeInfoOnLoad = new ub();
    public ub TimeInfoOnStart = new ub();
    public String TimestampOnLoad = "";
    public String TimestampOnStart = "";
    public String Title = "";
    public String Url = "";

    public b8(String str, String str2) {
        super(str, str2);
    }

    public void a(ArrayList<f5> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            f5 f5Var = arrayList.get(i);
            arrayList2.add(Long.valueOf((long) f5Var.ThroughputRateRx));
            arrayList3.add(Long.valueOf((long) f5Var.ThroughputRateTx));
            this.RequestRxMaxValue = Math.max(this.RequestRxMaxValue, f5Var.ThroughputRateRx);
            this.RequestTxMaxValue = Math.max(this.RequestTxMaxValue, f5Var.ThroughputRateTx);
        }
        this.RequestRxAvgValue = i1.a(v9.a((List<Long>) arrayList2));
        this.RequestRxMedValue = i1.a(v9.c(arrayList2));
        this.RequestTxAvgValue = i1.a(v9.a((List<Long>) arrayList3));
        this.RequestTxMedValue = i1.a(v9.c(arrayList3));
        this.MeasurementPointsThroughput = (f5[]) arrayList.toArray(new f5[arrayList.size()]);
    }

    public String a() {
        return JsonUtils.toJson(w2.RSS, (RBR) this);
    }
}
