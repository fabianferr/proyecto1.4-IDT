package com.umlaut.crowd.manager;

import android.content.Context;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CDC;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.internal.DRI;
import com.umlaut.crowd.internal.RBR;
import com.umlaut.crowd.internal.RDT;
import com.umlaut.crowd.internal.RLT;
import com.umlaut.crowd.internal.RUT;
import com.umlaut.crowd.internal.f6;
import com.umlaut.crowd.internal.g6;
import com.umlaut.crowd.internal.k7;
import com.umlaut.crowd.internal.q4;
import com.umlaut.crowd.internal.w2;
import com.umlaut.crowd.internal.x;
import com.umlaut.crowd.speedtest.ISpeedtestListener;
import com.umlaut.crowd.speedtest.SpeedtestStatus;
import com.umlaut.crowd.timeserver.TimeServer;
import java.util.ArrayList;

public class NetworkFeedbackManager implements ISpeedtestListener {
    private static final String m = "NetworkFeedbackManager";
    private static final boolean n = false;
    private g6 a;
    private CLC b;
    private x c;
    private ArrayList<k7> d;
    private Context e;
    private String f;
    private SpeedtestManager g;
    private ISpeedtestListener h;
    private boolean i;
    private boolean j = false;
    private String k;
    private IS l;

    public NetworkFeedbackManager(Context context, String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("feedbackName is NULL or empty");
        }
        this.e = context;
        this.f = str;
        this.k = InsightCore.getInsightConfig().f1();
        this.l = new IS(this.e);
        a();
    }

    private void a() {
        this.b = new CLC(this.e);
        this.c = new x(this.e);
        this.d = new ArrayList<>();
    }

    public void addAnswer(String str) {
        if (this.a != null) {
            ArrayList<k7> arrayList = this.d;
            arrayList.add(new k7(arrayList.size() + 1, str));
            return;
        }
        throw new IllegalStateException("Trying to add Answer before the NetworkFeedback was started");
    }

    public void cancelFeedback() {
        stopListening();
    }

    public void endFeedback() {
        this.a.TimeInfoOnEnd = TimeServer.getTimeInfo();
        g6 g6Var = this.a;
        g6Var.TimestampOnEnd = g6Var.TimeInfoOnEnd.TimestampTableau;
        g6Var.BatteryInfoOnEnd = this.c.a();
        this.a.LocationInfoOnEnd = this.b.getLastLocationInfo();
        this.a.MemoryInfoOnEnd = CDC.d(this.e);
        this.a.RadioInfoOnEnd = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
        this.a.TrafficInfoOnEnd = CDC.f();
        this.a.WifiInfoOnEnd = InsightCore.getWifiController().getWifiInfo();
        g6 g6Var2 = this.a;
        ArrayList<k7> arrayList = this.d;
        g6Var2.QuestionAnswerList = (k7[]) arrayList.toArray(new k7[arrayList.size()]);
        stopListening();
        if (InsightCore.getInsightConfig().C()) {
            this.a.LocationInfoOnStart = new q4();
            this.a.LocationInfoOnEnd = new q4();
        }
        if (this.j) {
            if (this.a != null) {
                InsightCore.getDatabaseHelper().a(w2.NFST, (RBR) this.a);
            }
        } else if (this.a != null) {
            InsightCore.getDatabaseHelper().a(w2.NF, (RBR) this.a);
        }
        if (InsightCore.getInsightConfig().o1()) {
            InsightCore.getStatsDatabase().a((f6) this.a);
        }
    }

    @Deprecated
    public DRI getRadioInfo() {
        return InsightCore.getRadioController().h();
    }

    public g6 getResult() {
        return this.a;
    }

    public boolean isListening() {
        return this.i;
    }

    public void onDownloadTestResult(RDT rdt) {
        this.a.DownloadTest = rdt;
        ISpeedtestListener iSpeedtestListener = this.h;
        if (iSpeedtestListener != null) {
            iSpeedtestListener.onDownloadTestResult(rdt);
        }
    }

    public void onLatencyTestResult(RLT rlt) {
        this.a.LatencyTest = rlt;
        ISpeedtestListener iSpeedtestListener = this.h;
        if (iSpeedtestListener != null) {
            iSpeedtestListener.onLatencyTestResult(rlt);
        }
    }

    public void onPingProgress(float f2, int i2) {
        ISpeedtestListener iSpeedtestListener = this.h;
        if (iSpeedtestListener != null) {
            iSpeedtestListener.onPingProgress(f2, i2);
        }
    }

    public void onTestStatusChanged(SpeedtestStatus speedtestStatus) {
        if (speedtestStatus == SpeedtestStatus.FINISH || speedtestStatus == SpeedtestStatus.ERROR || speedtestStatus == SpeedtestStatus.ABORTED) {
            this.a.IspInfo = this.g.getResult().IspInfo;
        }
        ISpeedtestListener iSpeedtestListener = this.h;
        if (iSpeedtestListener != null) {
            iSpeedtestListener.onTestStatusChanged(speedtestStatus);
        }
    }

    public void onTransferProgress(float f2, long j2) {
        ISpeedtestListener iSpeedtestListener = this.h;
        if (iSpeedtestListener != null) {
            iSpeedtestListener.onTransferProgress(f2, j2);
        }
    }

    public void onUploadTestResult(RUT rut) {
        this.a.UploadTest = rut;
        ISpeedtestListener iSpeedtestListener = this.h;
        if (iSpeedtestListener != null) {
            iSpeedtestListener.onUploadTestResult(rut);
        }
    }

    public void startFeedback(CLC.ProviderMode providerMode) {
        startListening(providerMode);
        g6 g6Var = new g6(this.k, this.l.q());
        this.a = g6Var;
        g6Var.TimeInfoOnStart = TimeServer.getTimeInfo();
        g6 g6Var2 = this.a;
        g6Var2.TimestampOnStart = g6Var2.TimeInfoOnStart.TimestampTableau;
        g6Var2.FeedbackName = this.f;
        g6Var2.DeviceInfo = CDC.getDeviceInfo(this.e);
        this.a.StorageInfo = CDC.j(this.e);
        this.a.BatteryInfoOnStart = this.c.a();
        this.a.LocationInfoOnStart = this.b.getLastLocationInfo();
        this.a.MemoryInfoOnStart = CDC.d(this.e);
        this.a.RadioInfoOnStart = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
        this.a.TrafficInfoOnStart = CDC.f();
        this.a.WifiInfoOnStart = InsightCore.getWifiController().getWifiInfo();
    }

    public void startListening(CLC.ProviderMode providerMode) {
        if (!this.i) {
            if (this.b != null) {
                if (InsightCore.getWifiController().getWifiInfo().WifiSSID.equals(InsightCore.getInsightConfig().h1())) {
                    this.b.startListening(CLC.ProviderMode.RailNet);
                } else {
                    this.b.startListening(providerMode);
                }
            }
            this.i = true;
        }
    }

    public void startSpeedtest(ISpeedtestListener iSpeedtestListener) {
        startSpeedtest(iSpeedtestListener, InsightCore.getInsightConfig().d1(), InsightCore.getInsightConfig().b1(), InsightCore.getInsightConfig().c1());
    }

    public void stopListening() {
        CLC clc = this.b;
        if (clc != null) {
            clc.stopListening();
        }
        this.i = false;
    }

    public void startSpeedtest(ISpeedtestListener iSpeedtestListener, boolean z, boolean z2, boolean z3) {
        this.h = iSpeedtestListener;
        if (this.g == null) {
            this.g = new SpeedtestManager(this, this.e);
        }
        this.g.startSpeedtest(z, z2, z3, false);
        this.j = true;
    }

    public void startFeedback() {
        startFeedback(CLC.ProviderMode.GpsAndNetwork);
    }

    public void startListening() {
        startListening(CLC.ProviderMode.GpsAndNetwork);
    }
}
