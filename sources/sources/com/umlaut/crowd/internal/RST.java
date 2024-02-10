package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.JsonUtils;

public class RST extends RBR implements Cloneable {
    public z BatteryInfoOnEnd = new z();
    public z BatteryInfoOnStart = new z();
    public a2 DeviceInfo = new a2();
    public RDT DownloadTest = new RDT();
    public e4 IspInfo = new e4();
    public RLT LatencyTest = new RLT();
    public q4 LocationInfoOnEnd = new q4();
    public q4 LocationInfoOnStart = new q4();
    public n5 MemoryInfoOnEnd = new n5();
    public n5 MemoryInfoOnStart = new n5();
    public k7[] QuestionAnswerList = new k7[0];
    public String QuestionnaireName = "";
    public DRI RadioInfoOnEnd = new DRI();
    public DRI RadioInfoOnStart = new DRI();
    public t9 SpeedtestEndState = t9.Unknown;
    public y9 StorageInfo = new y9();
    public String TestTimestamp = "";
    public ub TimeInfoOnEnd = new ub();
    public ub TimeInfoOnStart = new ub();
    public zb TraceRoute = new zb();
    public nc TrafficInfoOnEnd = new nc();
    public nc TrafficInfoOnStart = new nc();
    public RUT UploadTest = new RUT();
    public DWI WifiInfoOnEnd = new DWI();
    public DWI WifiInfoOnStart = new DWI();

    public RST(String str, String str2) {
        super(str, str2);
    }

    public String a() {
        return JsonUtils.toJson(w2.ST, (RBR) this);
    }

    public Object clone() throws CloneNotSupportedException {
        RST rst = (RST) super.clone();
        rst.DownloadTest = (RDT) this.DownloadTest.clone();
        rst.UploadTest = (RUT) this.UploadTest.clone();
        rst.LatencyTest = (RLT) this.LatencyTest.clone();
        rst.DeviceInfo = (a2) this.DeviceInfo.clone();
        rst.StorageInfo = (y9) this.StorageInfo.clone();
        rst.TraceRoute = (zb) this.TraceRoute.clone();
        rst.BatteryInfoOnStart = (z) this.BatteryInfoOnStart.clone();
        rst.LocationInfoOnStart = (q4) this.LocationInfoOnStart.clone();
        rst.MemoryInfoOnStart = (n5) this.MemoryInfoOnStart.clone();
        rst.TrafficInfoOnStart = (nc) this.TrafficInfoOnStart.clone();
        rst.WifiInfoOnStart = (DWI) this.WifiInfoOnStart.clone();
        rst.RadioInfoOnStart = (DRI) this.RadioInfoOnStart.clone();
        rst.TimeInfoOnStart = (ub) this.TimeInfoOnStart.clone();
        rst.BatteryInfoOnEnd = (z) this.BatteryInfoOnEnd.clone();
        rst.LocationInfoOnEnd = (q4) this.LocationInfoOnEnd.clone();
        rst.MemoryInfoOnEnd = (n5) this.MemoryInfoOnEnd.clone();
        rst.RadioInfoOnEnd = (DRI) this.RadioInfoOnEnd.clone();
        rst.TimeInfoOnEnd = (ub) this.TimeInfoOnEnd.clone();
        rst.TrafficInfoOnEnd = (nc) this.TrafficInfoOnEnd.clone();
        rst.WifiInfoOnEnd = (DWI) this.WifiInfoOnEnd.clone();
        rst.IspInfo = (e4) this.IspInfo.clone();
        rst.QuestionAnswerList = new k7[this.QuestionAnswerList.length];
        int i = 0;
        while (true) {
            k7[] k7VarArr = this.QuestionAnswerList;
            if (i >= k7VarArr.length) {
                return rst;
            }
            rst.QuestionAnswerList[i] = (k7) k7VarArr[i].clone();
            i++;
        }
    }
}
