package com.umlaut.crowd.manager;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.enums.RssItemTypes;
import com.umlaut.crowd.enums.RssRequestTypes;
import com.umlaut.crowd.internal.CDC;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.internal.DRI;
import com.umlaut.crowd.internal.RBR;
import com.umlaut.crowd.internal.aa;
import com.umlaut.crowd.internal.b8;
import com.umlaut.crowd.internal.f5;
import com.umlaut.crowd.internal.w2;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RssManager {
    private static final long p = 200;
    private static final long q = 20000;
    private Context a;
    private String b;
    private b8 c;
    private IS d;
    /* access modifiers changed from: private */
    public CLC e;
    /* access modifiers changed from: private */
    public boolean f = false;
    /* access modifiers changed from: private */
    public long g;
    /* access modifiers changed from: private */
    public int h;
    protected long i;
    protected long j;
    protected long k;
    private long l;
    private long m;
    /* access modifiers changed from: private */
    public ArrayList<f5> n;
    private Runnable o = new a();

    class a implements Runnable {
        a() {
        }

        public void run() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long a2 = elapsedRealtime - RssManager.this.g;
            if (a2 <= 20000) {
                f5 f5Var = new f5();
                f5Var.Delta = a2;
                long uidRxBytes = TrafficStats.getUidRxBytes(RssManager.this.h);
                long uidTxBytes = TrafficStats.getUidTxBytes(RssManager.this.h);
                DRI radioInfoForDefaultDataSim = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
                f5Var.ConnectionType = radioInfoForDefaultDataSim.ConnectionType;
                f5Var.NetworkType = radioInfoForDefaultDataSim.NetworkType;
                f5Var.RxLevel = radioInfoForDefaultDataSim.RXLevel;
                RssManager rssManager = RssManager.this;
                double d = (double) (elapsedRealtime - rssManager.i);
                double d2 = (double) (uidRxBytes - rssManager.j);
                Double.isNaN(d2);
                Double.isNaN(d);
                f5Var.ThroughputRateRx = (int) Math.round((d2 / d) * 8.0d * 1000.0d);
                double d3 = (double) (uidTxBytes - RssManager.this.k);
                Double.isNaN(d3);
                Double.isNaN(d);
                f5Var.ThroughputRateTx = (int) Math.round((d3 / d) * 8.0d * 1000.0d);
                if (!InsightCore.getInsightConfig().E()) {
                    f5Var.LocationInfo = RssManager.this.e.getLastLocationInfo();
                }
                RssManager.this.n.add(f5Var);
                RssManager rssManager2 = RssManager.this;
                rssManager2.i = elapsedRealtime;
                rssManager2.j = uidRxBytes;
                rssManager2.k = uidTxBytes;
                if (rssManager2.f) {
                    ThreadManager.getInstance().getSingleThreadScheduledExecutor().schedule(this, RssManager.p, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public RssManager(Context context) {
        this.a = context;
        this.b = InsightCore.getInsightConfig().f1();
        this.d = new IS(this.a);
        this.e = new CLC(this.a);
        this.n = new ArrayList<>();
        this.h = Process.myUid();
    }

    public void onNewRssItemRequest(String str, String str2, String str3, boolean z, RssItemTypes rssItemTypes, RssRequestTypes rssRequestTypes) {
        b8 b8Var = new b8(this.b, this.d.q());
        this.c = b8Var;
        b8Var.DeviceInfo = CDC.getDeviceInfo(this.a);
        this.c.FeedCategory = aa.a(str3);
        this.c.IsCached = z;
        if (!InsightCore.getInsightConfig().E()) {
            this.c.LocationInfo = this.e.getLastLocationInfo();
        }
        this.c.RadioInfo = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
        b8 b8Var2 = this.c;
        b8Var2.RssItemType = rssItemTypes;
        b8Var2.RssRequestType = rssRequestTypes;
        b8Var2.TimeInfoOnStart = TimeServer.getTimeInfo();
        b8 b8Var3 = this.c;
        b8Var3.TimestampOnStart = b8Var3.TimeInfoOnStart.TimestampTableau;
        b8Var3.Title = aa.a(str);
        this.c.Url = aa.a(str2);
        this.g = SystemClock.elapsedRealtime();
        this.l = TrafficStats.getUidRxBytes(this.h);
        long uidTxBytes = TrafficStats.getUidTxBytes(this.h);
        this.m = uidTxBytes;
        this.j = this.l;
        this.k = uidTxBytes;
        this.f = true;
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().schedule(this.o, p, TimeUnit.MILLISECONDS);
    }

    public void onRssItemRequestFinished() {
        b8 b8Var = this.c;
        if (b8Var != null) {
            this.f = false;
            b8Var.ItemLoadingTime = SystemClock.elapsedRealtime() - this.g;
            this.c.TimeInfoOnLoad = TimeServer.getTimeInfo();
            b8 b8Var2 = this.c;
            b8Var2.TimestampOnLoad = b8Var2.TimeInfoOnLoad.TimestampTableau;
            b8Var2.RequestTotalRxBytes = TrafficStats.getUidRxBytes(this.h) - this.l;
            this.c.RequestTotalTxBytes = TrafficStats.getUidTxBytes(this.h) - this.m;
            this.c.a(this.n);
            InsightCore.getDatabaseHelper().a(w2.RSS, (RBR) this.c);
        }
    }

    public void setRssItemTitle(String str) {
        b8 b8Var = this.c;
        if (b8Var != null) {
            b8Var.Title = aa.a(str);
        }
    }

    public void startListening() {
        this.e.startListening(CLC.ProviderMode.Passive);
    }

    public void stopListening() {
        this.e.stopListening();
    }
}
