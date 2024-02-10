package com.umlaut.crowd.internal;

import android.content.Context;
import android.content.Intent;
import android.net.MacAddress;
import android.net.wifi.ScanResult;
import android.net.wifi.rtt.RangingResult;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import com.umlaut.crowd.IC;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import java.util.ArrayList;
import java.util.List;

public class oe implements ne {
    private static final String k = "oe";
    private static final boolean l = false;
    private long a = 60000;
    private boolean b = false;
    /* access modifiers changed from: private */
    public final CLC c;
    private final Handler d;
    private final String e;
    private final long f;
    private final IS g;
    private final Context h;
    private final ArrayList<me> i;
    private final Runnable j = new c();

    class a implements Runnable {
        a() {
        }

        public void run() {
            oe.this.c.startListening(CLC.ProviderMode.Passive);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            oe.this.c.stopListening();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            InsightCore.getWifiController().k();
        }
    }

    class d implements Runnable {
        final /* synthetic */ Intent a;

        d(Intent intent) {
            this.a = intent;
        }

        public void run() {
            oe.this.b(this.a);
        }
    }

    static /* synthetic */ class e {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.umlaut.crowd.internal.d[] r0 = com.umlaut.crowd.internal.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Full     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Anonymized     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Hashed     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.None     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.oe.e.<clinit>():void");
        }
    }

    public oe(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.h = applicationContext;
        this.d = new Handler(applicationContext.getMainLooper());
        IC insightConfig = InsightCore.getInsightConfig();
        this.e = insightConfig.f1();
        this.c = new CLC(applicationContext);
        long m2 = insightConfig.m2();
        this.f = m2;
        IS is = new IS(applicationContext);
        this.g = is;
        this.i = new ArrayList<>();
        if (is.A() > SystemClock.elapsedRealtime()) {
            is.j(m2 * -1);
        }
    }

    /* access modifiers changed from: private */
    public void b(Intent intent) {
        if (SystemClock.elapsedRealtime() - this.g.A() >= this.f) {
            this.g.j(SystemClock.elapsedRealtime());
            if (this.h.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                boolean z = false;
                boolean booleanExtra = Build.VERSION.SDK_INT >= 23 ? intent.getBooleanExtra("resultsUpdated", false) : true;
                List<ScanResult> g2 = InsightCore.getWifiController().g();
                if (booleanExtra) {
                    z = InsightCore.getWifiController().a(g2);
                }
                if (z) {
                    return;
                }
                if (booleanExtra) {
                    a(g2, (List<RangingResult>) null);
                } else {
                    a((List<ScanResult>) null, (List<RangingResult>) null);
                }
            }
        }
    }

    public ArrayList<me> c() {
        return b(InsightCore.getWifiController().g(), (List<RangingResult>) null);
    }

    public void d() {
        InsightCore.getWifiController().a((ne) this);
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a());
    }

    public void e() {
        InsightCore.getWifiController().b((ne) this);
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new b());
    }

    public void f() {
        this.b = false;
        this.d.removeCallbacks(this.j);
    }

    public void a(long j2) {
        this.b = true;
        this.a = j2;
        this.d.removeCallbacks(this.j);
        this.d.postDelayed(this.j, this.a);
    }

    public void a(List<ScanResult> list, List<RangingResult> list2) {
        ArrayList<me> b2 = b(list, list2);
        if (b2 != null && !b2.isEmpty()) {
            a(a(b2));
        }
        if (this.b) {
            this.d.removeCallbacks(this.j);
            this.d.postDelayed(this.j, this.a);
        }
    }

    public void a(Intent intent) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new d(intent));
    }

    private pe a(ArrayList<me> arrayList) {
        ub timeInfo = TimeServer.getTimeInfo();
        String q = InsightCore.getInsightSettings().q();
        pe peVar = new pe(this.e, q);
        peVar.ScanId = k3.a(timeInfo, q);
        peVar.LocationInfo = this.c.getLastLocationInfo();
        peVar.TimeInfo = timeInfo;
        peVar.RadioInfo = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
        peVar.WifiInfo = InsightCore.getWifiController().getWifiInfo();
        peVar.TrafficInfo = CDC.f();
        peVar.DeviceInfo = CDC.getDeviceInfo(this.h);
        peVar.WifiScanInfoList = (me[]) arrayList.toArray(new me[0]);
        return peVar;
    }

    private ArrayList<me> b(List<ScanResult> list, List<RangingResult> list2) {
        ArrayList<me> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        DWI wifiInfo = InsightCore.getWifiController().getWifiInfo();
        String str = wifiInfo.WifiDetailedState == fe.CONNECTED ? wifiInfo.WifiBSSID_Full : null;
        long timeInMillis = TimeServer.getTimeInMillis();
        long elapsedRealtime = timeInMillis - SystemClock.elapsedRealtime();
        for (ScanResult next : list) {
            me meVar = new me();
            meVar.SSID = b(next.SSID);
            meVar.BSSID = a(next.BSSID);
            meVar.Capabilities = next.capabilities;
            meVar.Frequency = next.frequency;
            meVar.RxLev = next.level;
            int i2 = Build.VERSION.SDK_INT;
            long j2 = (next.timestamp / 1000) + elapsedRealtime;
            meVar.Timestamp = j2;
            meVar.Age = timeInMillis - j2;
            if (i2 >= 23) {
                meVar.ChannelWidth = next.channelWidth;
            }
            if (i2 >= 30) {
                meVar.Standard = qe.getWifiStandard(next.getWifiStandard());
            }
            if (list2 != null) {
                for (RangingResult next2 : list2) {
                    MacAddress fromString = MacAddress.fromString(next.BSSID);
                    MacAddress macAddress = next2.getMacAddress();
                    if (macAddress != null && macAddress.equals(fromString) && next2.getStatus() == 0) {
                        meVar.DistanceMm = next2.getDistanceMm();
                        meVar.DistanceStdDevMm = next2.getDistanceStdDevMm();
                        meVar.RangingSuccessful = true;
                    }
                }
            }
            if (str != null && str.equals(next.BSSID)) {
                meVar.Connected = true;
            }
            arrayList.add(meVar);
        }
        this.i.clear();
        this.i.addAll(arrayList);
        return arrayList;
    }

    private void a(pe peVar) {
        InsightCore.getDatabaseHelper().a(w2.WSR, (RBR) peVar);
    }

    public ArrayList<me> a() {
        return this.i;
    }

    private String a(String str) {
        int i2;
        if (str.length() == 0 || (i2 = e.a[InsightCore.getInsightConfig().g2().ordinal()]) == 1) {
            return str;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return "";
            }
            return "SHA256:" + k3.a(str, b());
        } else if (str.length() != 17) {
            return "xx:xx:xx:xx:xx:xx";
        } else {
            return str.substring(0, 9) + "xx:xx:xx";
        }
    }

    private String b(String str) {
        int i2;
        if (str.length() == 0 || (i2 = e.a[InsightCore.getInsightConfig().i2().ordinal()]) == 1) {
            return str;
        }
        if (i2 == 2) {
            return "HASH:" + k3.a(InsightCore.getGUID() + InsightCore.getInsightSettings().D() + str);
        } else if (i2 != 3) {
            return "";
        } else {
            return "SHA256:" + k3.a(str, b());
        }
    }

    private String b() {
        return InsightCore.getInsightConfig().h2();
    }
}
