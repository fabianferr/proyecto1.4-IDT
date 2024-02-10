package com.umlaut.crowd.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.ims.ImsReasonInfo;
import android.util.Log;
import android.util.SparseArray;
import androidx.media3.common.C;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.database.StatsDatabase;
import com.umlaut.crowd.enums.ThreeState;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.PermissionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class sd {
    private static final long Q = 1000;
    private static final int R = 10000;
    private static final int S = 3000;
    private static final boolean T = false;
    /* access modifiers changed from: private */
    public static final String U = "sd";
    private static final String V = "p3insrvc";
    private static final String W = "P3INS_PFK_PREV_VCID_RVC";
    private static final String X = "P3INS_PFK_PREV_MSISDN_RVC";
    /* access modifiers changed from: private */
    public String A = "";
    /* access modifiers changed from: private */
    public int B = -1;
    /* access modifiers changed from: private */
    public int C = -1;
    /* access modifiers changed from: private */
    public volatile boolean D;
    /* access modifiers changed from: private */
    public volatile boolean E = false;
    private int[] F;
    private final SharedPreferences G;
    /* access modifiers changed from: private */
    public volatile int H = -1;
    private Method I;
    private Method J;
    private Method K;
    private Method L;
    private Method M;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<td> N;
    private final BroadcastReceiver O = new l();
    /* access modifiers changed from: private */
    public final Runnable P = new c();
    /* access modifiers changed from: private */
    public final Context a;
    /* access modifiers changed from: private */
    public volatile ArrayList<j5> b;
    /* access modifiers changed from: private */
    public n c;
    /* access modifiers changed from: private */
    public ArrayList<n> d;
    private SubscriptionManager.OnSubscriptionsChangedListener e;
    /* access modifiers changed from: private */
    public final CLC f;
    private final TelephonyManager g;
    private SparseArray<TelephonyManager> h;
    /* access modifiers changed from: private */
    public final x i;
    /* access modifiers changed from: private */
    public final IS j;
    private final String k;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> l;
    /* access modifiers changed from: private */
    public volatile RVR m;
    /* access modifiers changed from: private */
    public volatile t0 n;
    /* access modifiers changed from: private */
    public volatile long o;
    /* access modifiers changed from: private */
    public volatile long p;
    /* access modifiers changed from: private */
    public volatile long q;
    /* access modifiers changed from: private */
    public volatile String r;
    /* access modifiers changed from: private */
    public volatile String s;
    /* access modifiers changed from: private */
    public volatile s0 t;
    /* access modifiers changed from: private */
    public volatile boolean u;
    /* access modifiers changed from: private */
    public volatile boolean v;
    /* access modifiers changed from: private */
    public volatile long w;
    /* access modifiers changed from: private */
    public long x;
    /* access modifiers changed from: private */
    public long y;
    /* access modifiers changed from: private */
    public String z = "";

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ r0 b;
        final /* synthetic */ int c;

        a(String str, r0 r0Var, int i) {
            this.a = str;
            this.b = r0Var;
            this.c = i;
        }

        public void run() {
            sd.this.f.startListening(InsightCore.getInsightConfig().O1());
            if (!this.a.isEmpty()) {
                if (sd.this.z == null || sd.this.z.isEmpty()) {
                    sd sdVar = sd.this;
                    String unused = sdVar.z = sdVar.d();
                }
                sd.this.m.BMSISDN = aa.a(this.a, sd.this.j.O());
                String a2 = rd.a(this.a);
                if (!a2.isEmpty()) {
                    sd.this.m.IsIdenticalBParty = a2.equals(sd.this.z);
                }
                String unused2 = sd.this.z = a2;
                sd.this.a(a2);
            }
            sd.this.m.CallDirection = this.b;
            sd.this.m.LocationInfoOnStart = sd.this.f.getLastLocationInfo();
            sd.this.m.RadioInfoOnStart = InsightCore.getRadioController().i(this.c);
            sd.this.m.WifiInfoOnStart = InsightCore.getWifiController().getWifiInfo();
            sd.this.m.CellInfoOnStart = InsightCore.getRadioController().d();
            sd.this.m.ApnInfoOnStart = InsightCore.getRadioController().b();
            sd.this.m.BatteryInfoOnStart = sd.this.i.a();
            if (!sd.this.v && !sd.this.u && this.b == r0.MOC) {
                sd.this.m.TimeInfoOnEstablished = sd.this.m.TimeInfoOnStart;
                sd.this.m.TimestampOnEstablished = sd.this.m.TimestampOnStart;
            }
            sd.this.m.VcId = k3.a(sd.this.m.TimeInfoOnStart, sd.this.m.GUID);
            if (sd.this.A == null || sd.this.A.isEmpty()) {
                sd sdVar2 = sd.this;
                String unused3 = sdVar2.A = sdVar2.e();
            }
            sd.this.m.PreviousVcId = sd.this.A;
            sd sdVar3 = sd.this;
            String unused4 = sdVar3.A = sdVar3.m.VcId;
            sd sdVar4 = sd.this;
            sdVar4.b(sdVar4.A);
            sd.this.m.IsVoLteEnabled = sd.this.g();
            sd.this.m.IsVoWiFiEnabled = sd.this.h();
            if (sd.this.u) {
                sd.this.m.CallStateRecognition = u0.Precise;
            }
            Iterator it = sd.this.N.iterator();
            while (it.hasNext()) {
                ((td) it.next()).b(sd.this.m);
            }
            ScheduledFuture unused5 = sd.this.l = ThreadManager.getInstance().getSingleThreadScheduledExecutor().scheduleWithFixedDelay(sd.this.P, 0, 1000, TimeUnit.MILLISECONDS);
            sd.this.m.DeviceInfo = CDC.getDeviceInfo(sd.this.a);
            sd.this.m.SimInfo = CDC.a(this.c, sd.this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        public void run() {
            sd sdVar = sd.this;
            ThreadManager.getInstance().getCachedThreadPool().execute(new m(sdVar.m, sd.this.b, this.a));
            synchronized (sd.this) {
                ArrayList unused = sd.this.b = null;
                RVR unused2 = sd.this.m = null;
            }
        }
    }

    class c implements Runnable {

        class a implements Runnable {
            final /* synthetic */ td a;
            final /* synthetic */ j5 b;

            a(td tdVar, j5 j5Var) {
                this.a = tdVar;
                this.b = j5Var;
            }

            public void run() {
                this.a.a(this.b);
            }
        }

        c() {
        }

        public void run() {
            if (sd.this.m == null || sd.this.b == null || sd.this.H == -1 || sd.this.H == 0) {
                sd.this.f.stopListening();
                return;
            }
            sd sdVar = sd.this;
            j5 a2 = sdVar.a(sdVar.m, sd.this.n, sd.this.w);
            sd.this.b.add(a2);
            Iterator it = sd.this.N.iterator();
            while (it.hasNext()) {
                new Handler(Looper.getMainLooper()).post(new a((td) it.next(), a2));
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            sd.this.j();
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            sd.this.b();
        }
    }

    class f extends SubscriptionManager.OnSubscriptionsChangedListener {
        f() {
        }

        public void onSubscriptionsChanged() {
            super.onSubscriptionsChanged();
            sd.this.i();
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            if (sd.this.E) {
                sd.this.b(false);
                sd.this.a(false);
            }
            boolean unused = sd.this.D = false;
        }
    }

    class h implements Runnable {
        final /* synthetic */ int[] a;
        final /* synthetic */ CountDownLatch b;

        h(int[] iArr, CountDownLatch countDownLatch) {
            this.a = iArr;
            this.b = countDownLatch;
        }

        public void run() {
            for (int nVar : this.a) {
                sd.this.d.add(new n(nVar));
            }
            this.b.countDown();
        }
    }

    class i implements Runnable {
        i() {
        }

        public void run() {
            boolean unused = sd.this.E = true;
            sd.this.a(true);
        }
    }

    class j implements Runnable {
        final /* synthetic */ CountDownLatch a;

        j(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        public void run() {
            n unused = sd.this.c = new n();
            this.a.countDown();
        }
    }

    class k implements Runnable {
        k() {
        }

        public void run() {
            boolean unused = sd.this.E = false;
            sd.this.b(true);
        }
    }

    class l extends BroadcastReceiver {
        l() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|(6:8|(2:10|(2:16|17))|18|20|21|(2:23|(1:29)))(2:30|(1:32)(2:33|(6:35|(6:37|38|(2:40|41)|44|46|47)(1:42)|43|44|46|47)(2:48|(2:50|(4:52|(2:54|(1:(1:57)(2:58|(1:62))))|63|(5:67|(1:71)|72|(1:74)|75)))(2:76|(4:80|81|82|(1:84)(2:85|(1:87)))))))|88|89) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:88:0x031e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r17, android.content.Intent r18) {
            /*
                r16 = this;
                r1 = r16
                r0 = r18
                java.lang.String r2 = r18.getAction()
                if (r2 != 0) goto L_0x000b
                return
            L_0x000b:
                com.umlaut.crowd.internal.sd r2 = com.umlaut.crowd.internal.sd.this
                monitor-enter(r2)
                java.lang.String r3 = r18.getAction()     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = "android.intent.action.PHONE_STATE"
                boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x009e
                java.lang.String r3 = "android.telecom.extra.CALL_DISCONNECT_CAUSE"
                boolean r3 = r0.hasExtra(r3)     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x0062
                android.os.Bundle r3 = r18.getExtras()     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = "android.telecom.extra.CALL_DISCONNECT_CAUSE"
                java.lang.String r3 = r3.getString(r4)     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r4 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r4 = r4.m     // Catch:{ all -> 0x0320 }
                if (r4 == 0) goto L_0x0062
                com.umlaut.crowd.internal.sd r4 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r4 = r4.m     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = r4.CallDisconnectCause     // Catch:{ all -> 0x0320 }
                if (r4 == 0) goto L_0x004c
                com.umlaut.crowd.internal.sd r4 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r4 = r4.m     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = r4.CallDisconnectCause     // Catch:{ all -> 0x0320 }
                boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0320 }
                if (r4 == 0) goto L_0x0062
            L_0x004c:
                com.umlaut.crowd.internal.sd r4 = com.umlaut.crowd.internal.sd.this     // Catch:{ Exception -> 0x0062 }
                com.umlaut.crowd.internal.RVR r4 = r4.m     // Catch:{ Exception -> 0x0062 }
                com.umlaut.crowd.internal.sd r5 = com.umlaut.crowd.internal.sd.this     // Catch:{ Exception -> 0x0062 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0062 }
                int r3 = r3.intValue()     // Catch:{ Exception -> 0x0062 }
                java.lang.String r3 = r5.b((int) r3)     // Catch:{ Exception -> 0x0062 }
                r4.CallDisconnectCause = r3     // Catch:{ Exception -> 0x0062 }
            L_0x0062:
                java.lang.String r3 = "android.telecom.extra.CALL_DISCONNECT_MESSAGE"
                boolean r3 = r0.hasExtra(r3)     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x031e
                android.os.Bundle r0 = r18.getExtras()     // Catch:{ all -> 0x0320 }
                java.lang.String r3 = "android.telecom.extra.CALL_DISCONNECT_MESSAGE"
                java.lang.String r0 = r0.getString(r3)     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x031e
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                java.lang.String r3 = r3.CallDisconnectCause     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x0094
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                java.lang.String r3 = r3.CallDisconnectCause     // Catch:{ all -> 0x0320 }
                boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x031e
            L_0x0094:
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                r3.CallDisconnectCause = r0     // Catch:{ all -> 0x0320 }
                goto L_0x031e
            L_0x009e:
                java.lang.String r3 = r18.getAction()     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = "com.samsung.intent.action.CALL_DROP"
                boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x00c0
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0320 }
                long unused = r3.p = r4     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = "calldrop_log"
                java.lang.String r0 = r0.getStringExtra(r4)     // Catch:{ all -> 0x0320 }
                java.lang.String unused = r3.r = r0     // Catch:{ all -> 0x0320 }
                goto L_0x031e
            L_0x00c0:
                java.lang.String r3 = r18.getAction()     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = "com.samsung.intent.action.IMS_CALL_DROP"
                boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0320 }
                r4 = 2
                r5 = -1
                r6 = 0
                if (r3 == 0) goto L_0x01b7
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0320 }
                long unused = r3.q = r7     // Catch:{ all -> 0x0320 }
                java.lang.String r3 = "ErrorString"
                java.lang.String r3 = r0.getStringExtra(r3)     // Catch:{ all -> 0x0320 }
                java.lang.String r7 = "CallType"
                int r7 = r0.getIntExtra(r7, r6)     // Catch:{ all -> 0x0320 }
                java.lang.String r8 = "NetworkType"
                int r8 = r0.getIntExtra(r8, r6)     // Catch:{ all -> 0x0320 }
                java.lang.String r9 = "TimeInfo"
                java.lang.String r9 = r0.getStringExtra(r9)     // Catch:{ all -> 0x0320 }
                if (r9 == 0) goto L_0x0147
                int r10 = r9.length()     // Catch:{ all -> 0x0320 }
                r11 = 12
                if (r10 != r11) goto L_0x014a
                long r12 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()     // Catch:{ Exception -> 0x014a }
                java.lang.String r4 = r9.substring(r6, r4)     // Catch:{ Exception -> 0x014a }
                int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x014a }
                r10 = 3
                r14 = 5
                java.lang.String r10 = r9.substring(r10, r14)     // Catch:{ Exception -> 0x014a }
                int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x014a }
                r14 = 6
                r15 = 8
                java.lang.String r14 = r9.substring(r14, r15)     // Catch:{ Exception -> 0x014a }
                int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ Exception -> 0x014a }
                r15 = 9
                java.lang.String r15 = r9.substring(r15, r11)     // Catch:{ Exception -> 0x014a }
                int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ Exception -> 0x014a }
                java.util.Calendar r6 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x014a }
                r6.setTimeInMillis(r12)     // Catch:{ Exception -> 0x014a }
                r12 = 11
                r6.set(r12, r4)     // Catch:{ Exception -> 0x014a }
                r6.set(r11, r10)     // Catch:{ Exception -> 0x014a }
                r4 = 13
                r6.set(r4, r14)     // Catch:{ Exception -> 0x014a }
                r4 = 14
                r6.set(r4, r15)     // Catch:{ Exception -> 0x014a }
                long r10 = r6.getTimeInMillis()     // Catch:{ Exception -> 0x014a }
                java.lang.String r4 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x014a }
                goto L_0x0149
            L_0x0147:
                java.lang.String r4 = ""
            L_0x0149:
                r9 = r4
            L_0x014a:
                java.lang.String r4 = "RSRP"
                int r4 = r0.getIntExtra(r4, r5)     // Catch:{ all -> 0x0320 }
                java.lang.String r6 = "RSRQ"
                int r5 = r0.getIntExtra(r6, r5)     // Catch:{ all -> 0x0320 }
                java.lang.String r6 = "ErrorReason"
                r10 = 0
                int r0 = r0.getIntExtra(r6, r10)     // Catch:{ all -> 0x0320 }
                int r6 = com.umlaut.crowd.internal.rd.a((int) r0)     // Catch:{ all -> 0x0320 }
                int r10 = com.umlaut.crowd.internal.rd.b(r6)     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r11 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                java.lang.String unused = r11.s = r3     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0320 }
                r11.<init>()     // Catch:{ all -> 0x0320 }
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0320 }
                r11.append(r10)     // Catch:{ all -> 0x0320 }
                r10 = 44
                r11.append(r10)     // Catch:{ all -> 0x0320 }
                r11.append(r6)     // Catch:{ all -> 0x0320 }
                java.lang.String r6 = ",-1,"
                r11.append(r6)     // Catch:{ all -> 0x0320 }
                r11.append(r4)     // Catch:{ all -> 0x0320 }
                r11.append(r10)     // Catch:{ all -> 0x0320 }
                r11.append(r5)     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = ",-1,-1,-1,-1,-1,"
                r11.append(r4)     // Catch:{ all -> 0x0320 }
                r11.append(r0)     // Catch:{ all -> 0x0320 }
                java.lang.String r0 = ","
                r11.append(r0)     // Catch:{ all -> 0x0320 }
                r11.append(r7)     // Catch:{ all -> 0x0320 }
                java.lang.String r0 = ","
                r11.append(r0)     // Catch:{ all -> 0x0320 }
                r11.append(r8)     // Catch:{ all -> 0x0320 }
                java.lang.String r0 = ","
                r11.append(r0)     // Catch:{ all -> 0x0320 }
                r11.append(r9)     // Catch:{ all -> 0x0320 }
                java.lang.String r0 = r11.toString()     // Catch:{ all -> 0x0320 }
                java.lang.String unused = r3.r = r0     // Catch:{ all -> 0x0320 }
                goto L_0x031e
            L_0x01b7:
                java.lang.String r3 = r18.getAction()     // Catch:{ all -> 0x0320 }
                java.lang.String r6 = "com.samsung.rcs.CALL_STATE_CHANGED"
                boolean r3 = r3.equals(r6)     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x02d8
                java.lang.String r3 = "EXTRA_CALL_EVENT"
                int r3 = r0.getIntExtra(r3, r5)     // Catch:{ all -> 0x0320 }
                java.lang.String r5 = "EXTRA_TEL_NUMBER"
                java.lang.String r0 = r0.getStringExtra(r5)     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r5 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r5 = r5.m     // Catch:{ all -> 0x0320 }
                if (r5 == 0) goto L_0x031e
                com.umlaut.crowd.internal.sd r5 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                boolean r5 = r5.u     // Catch:{ all -> 0x0320 }
                if (r5 != 0) goto L_0x026a
                com.umlaut.crowd.internal.sd r5 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r5 = r5.m     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.u0 r6 = com.umlaut.crowd.internal.u0.Samsung     // Catch:{ all -> 0x0320 }
                r5.CallStateRecognition = r6     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r5 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.t0 r5 = r5.n     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.t0 r6 = com.umlaut.crowd.internal.t0.Connecting     // Catch:{ all -> 0x0320 }
                if (r5 != r6) goto L_0x026a
                if (r3 != r4) goto L_0x0239
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0320 }
                long unused = r3.y = r4     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r4 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                long r4 = r4.y     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r6 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                long r6 = r6.w     // Catch:{ all -> 0x0320 }
                long r4 = r4 - r6
                r3.TimeToConnect = r4     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.ub r4 = com.umlaut.crowd.timeserver.TimeServer.getTimeInfo()     // Catch:{ all -> 0x0320 }
                r3.TimeInfoOnEstablished = r4     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r4 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r4 = r4.m     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.ub r4 = r4.TimeInfoOnEstablished     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = r4.TimestampTableau     // Catch:{ all -> 0x0320 }
                r3.TimestampOnEstablished = r4     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.t0 r4 = com.umlaut.crowd.internal.t0.Active     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.t0 unused = r3.n = r4     // Catch:{ all -> 0x0320 }
                goto L_0x026a
            L_0x0239:
                r4 = 1
                if (r3 != r4) goto L_0x026a
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                long r3 = r3.TimeToConnect     // Catch:{ all -> 0x0320 }
                r5 = 0
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 != 0) goto L_0x026a
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.ub r4 = new com.umlaut.crowd.internal.ub     // Catch:{ all -> 0x0320 }
                r4.<init>()     // Catch:{ all -> 0x0320 }
                r3.TimeInfoOnEstablished = r4     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = ""
                r3.TimestampOnEstablished = r4     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                r4 = 0
                r3.CallSuccessful = r4     // Catch:{ all -> 0x0320 }
            L_0x026a:
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                java.lang.String r3 = r3.BMSISDN     // Catch:{ all -> 0x0320 }
                boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x031e
                boolean r3 = com.umlaut.crowd.internal.aa.c(r0)     // Catch:{ all -> 0x0320 }
                if (r3 != 0) goto L_0x031e
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                java.lang.String r3 = r3.z     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x0292
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                java.lang.String r3 = r3.z     // Catch:{ all -> 0x0320 }
                boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x029b
            L_0x0292:
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = r3.d()     // Catch:{ all -> 0x0320 }
                java.lang.String unused = r3.z = r4     // Catch:{ all -> 0x0320 }
            L_0x029b:
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r4 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.IS r4 = r4.j     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.d r4 = r4.O()     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = com.umlaut.crowd.internal.aa.a((java.lang.String) r0, (com.umlaut.crowd.internal.d) r4)     // Catch:{ all -> 0x0320 }
                r3.BMSISDN = r4     // Catch:{ all -> 0x0320 }
                java.lang.String r0 = com.umlaut.crowd.internal.rd.a((java.lang.String) r0)     // Catch:{ all -> 0x0320 }
                boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0320 }
                if (r3 != 0) goto L_0x02cd
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.RVR r3 = r3.m     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r4 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = r4.z     // Catch:{ all -> 0x0320 }
                boolean r4 = r0.equals(r4)     // Catch:{ all -> 0x0320 }
                r3.IsIdenticalBParty = r4     // Catch:{ all -> 0x0320 }
            L_0x02cd:
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                java.lang.String unused = r3.z = r0     // Catch:{ all -> 0x0320 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                r3.a((java.lang.String) r0)     // Catch:{ all -> 0x0320 }
                goto L_0x031e
            L_0x02d8:
                java.lang.String r3 = r18.getAction()     // Catch:{ all -> 0x0320 }
                java.lang.String r4 = "com.samsung.intent.action.BIG_DATA_INFO"
                boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0320 }
                if (r3 == 0) goto L_0x031e
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x0320 }
                boolean r3 = r3.u     // Catch:{ all -> 0x0320 }
                if (r3 != 0) goto L_0x031e
                java.lang.String r3 = "bigdata_info"
                java.lang.String r0 = r0.getStringExtra(r3)     // Catch:{ Exception -> 0x031e }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x031e }
                r3.<init>(r0)     // Catch:{ Exception -> 0x031e }
                java.lang.String r0 = "Etyp"
                java.lang.String r4 = "-1"
                java.lang.String r0 = r3.optString(r0, r4)     // Catch:{ Exception -> 0x031e }
                java.lang.String r3 = "12"
                boolean r3 = r0.equals(r3)     // Catch:{ Exception -> 0x031e }
                if (r3 == 0) goto L_0x030f
                com.umlaut.crowd.internal.sd r0 = com.umlaut.crowd.internal.sd.this     // Catch:{ Exception -> 0x031e }
                com.umlaut.crowd.internal.s0 r3 = com.umlaut.crowd.internal.s0.Remote     // Catch:{ Exception -> 0x031e }
                com.umlaut.crowd.internal.s0 unused = r0.t = r3     // Catch:{ Exception -> 0x031e }
                goto L_0x031e
            L_0x030f:
                java.lang.String r3 = "20"
                boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x031e }
                if (r0 == 0) goto L_0x031e
                com.umlaut.crowd.internal.sd r0 = com.umlaut.crowd.internal.sd.this     // Catch:{ Exception -> 0x031e }
                com.umlaut.crowd.internal.s0 r3 = com.umlaut.crowd.internal.s0.Local     // Catch:{ Exception -> 0x031e }
                com.umlaut.crowd.internal.s0 unused = r0.t = r3     // Catch:{ Exception -> 0x031e }
            L_0x031e:
                monitor-exit(r2)     // Catch:{ all -> 0x0320 }
                return
            L_0x0320:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0320 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.sd.l.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    private class m implements Runnable {
        /* access modifiers changed from: private */
        public final ArrayList<j5> a;
        /* access modifiers changed from: private */
        public final RVR b;
        private final long c;
        private final int d;

        class a implements Runnable {
            final /* synthetic */ td a;

            a(td tdVar) {
                this.a = tdVar;
            }

            public void run() {
                this.a.a(m.this.b);
            }
        }

        class b implements Runnable {
            final /* synthetic */ td a;
            final /* synthetic */ j5 b;

            b(td tdVar, j5 j5Var) {
                this.a = tdVar;
                this.b = j5Var;
            }

            public void run() {
                this.a.a(this.b);
            }
        }

        class c implements Runnable {
            final /* synthetic */ td a;

            c(td tdVar) {
                this.a = tdVar;
            }

            public void run() {
                this.a.a(m.this.b, (j5[]) m.this.a.toArray(new j5[0]));
            }
        }

        public m(RVR rvr, List<j5> list, int i) {
            this.b = rvr;
            this.a = new ArrayList<>(list);
            this.d = i;
            this.c = sd.this.w;
        }

        public void run() {
            this.b.RadioInfoOnEnd = InsightCore.getRadioController().i(this.d);
            this.b.WifiInfoOnEnd = InsightCore.getWifiController().getWifiInfo();
            this.b.CellInfoOnEnd = InsightCore.getRadioController().d();
            this.b.ApnInfoOnEnd = InsightCore.getRadioController().b();
            this.b.BatteryInfoOnEnd = sd.this.i.a();
            this.b.LocationInfoOnEnd = sd.this.f.getLastLocationInfo();
            sd.this.f.stopListening();
            Iterator it = sd.this.N.iterator();
            while (it.hasNext()) {
                new Handler(Looper.getMainLooper()).post(new a((td) it.next()));
            }
            boolean R1 = InsightCore.getInsightConfig().R1();
            if (R1) {
                sd.this.f.startListening(InsightCore.getInsightConfig().P1());
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime + 10000;
            long j2 = elapsedRealtime + C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
            long max = Math.max(j, j2);
            boolean z = false;
            while (SystemClock.elapsedRealtime() < max) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e2) {
                    Log.d(sd.U, e2.getMessage());
                }
                if (R1) {
                    j5 a2 = sd.this.a(this.b, t0.PostCall, this.c);
                    this.a.add(a2);
                    Iterator it2 = sd.this.N.iterator();
                    while (it2.hasNext()) {
                        new Handler(Looper.getMainLooper()).post(new b((td) it2.next(), a2));
                    }
                }
                if (!sd.this.v) {
                    this.b.MissingPermissionCallLog = true;
                } else if (!z && SystemClock.elapsedRealtime() > j2) {
                    this.b.MissingPermissionCallLog = !rd.a(sd.this.a, this.b, sd.this.z);
                    z = true;
                }
            }
            if (R1) {
                sd.this.f.stopListening();
            }
            if (sd.this.u) {
                if (this.b.CallDisconnectCause.equals(sd.this.b(2)) || this.b.CallDisconnectCause.equals(rd.c(510))) {
                    this.b.CallEndType = s0.Remote;
                } else if (this.b.CallDisconnectCause.equals(sd.this.b(3)) || this.b.CallDisconnectCause.equals(rd.c(501))) {
                    this.b.CallEndType = s0.Local;
                }
            } else if (this.b.CallEndType != s0.Dropped) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - sd.this.o;
                if (elapsedRealtime2 < 10000) {
                    RVR rvr = this.b;
                    rvr.CallEndType = s0.DroppedInWindow;
                    rvr.DropInWindowTime = (int) elapsedRealtime2;
                } else if (sd.this.p >= 0) {
                    this.b.CallEndType = s0.DroppedSamsung;
                } else if (sd.this.q >= 0) {
                    this.b.CallEndType = s0.DroppedSamsungIms;
                } else if (!(sd.this.t == null || sd.this.t == s0.Unknown)) {
                    this.b.CallEndType = sd.this.t;
                }
            }
            if (sd.this.r != null && this.b.CallDisconnectCause.isEmpty()) {
                this.b.CallDisconnectCause = sd.this.r;
            }
            if (sd.this.s != null && this.b.CallPreciseDisconnectCause.isEmpty()) {
                this.b.CallPreciseDisconnectCause = sd.this.s;
            }
            if (!sd.this.u && !this.b.TimestampOnEstablished.isEmpty()) {
                RVR rvr2 = this.b;
                ub ubVar = rvr2.TimeInfoOnEnd;
                long j3 = ubVar.TimestampMillis + ubVar.DeviceDriftMillis;
                ub ubVar2 = rvr2.TimeInfoOnEstablished;
                long j4 = ubVar2.TimestampMillis + ubVar2.DeviceDriftMillis;
                rvr2.CallDuration = j3 - j4;
                if (rvr2.TimeToConnect == 0) {
                    ub ubVar3 = rvr2.TimeInfoOnStart;
                    rvr2.TimeToConnect = j4 - (ubVar3.TimestampMillis + ubVar3.DeviceDriftMillis);
                }
                long j5 = rvr2.TimeToConnect;
                if (j5 > 0 && rvr2.CallAlertingTime == -1) {
                    rvr2.CallAlertingTime = j5;
                }
            }
            if (!sd.this.u) {
                RVR rvr3 = this.b;
                if (rvr3.CallDuration > 0) {
                    rd.c(rvr3, this.a);
                }
            }
            long b2 = rd.b(this.b, this.a);
            rd.a(this.b, this.a);
            if (InsightCore.getInsightConfig().F()) {
                this.b.LocationInfoOnStart = new q4();
                this.b.LocationInfoOnEnd = new q4();
            }
            InsightCore.getDatabaseHelper().a(w2.VC, (RBR) this.b);
            InsightCore.getDatabaseHelper().a(w2.MPV, (RBR[]) this.a.toArray(new j5[0]));
            Iterator it3 = sd.this.N.iterator();
            while (it3.hasNext()) {
                new Handler(Looper.getMainLooper()).post(new c((td) it3.next()));
            }
            if (InsightCore.getInsightConfig().m1()) {
                InsightCore.getStatsDatabase().a(this.b);
                if (b2 > 0) {
                    StatsDatabase statsDatabase = InsightCore.getStatsDatabase();
                    RVR rvr4 = this.b;
                    ub ubVar4 = rvr4.TimeInfoOnEnd;
                    double d2 = (double) b2;
                    double d3 = rvr4.VoiceRatShare2G;
                    Double.isNaN(d2);
                    int i = (int) (d3 * d2);
                    double d4 = rvr4.VoiceRatShare3G;
                    Double.isNaN(d2);
                    int i2 = (int) (d4 * d2);
                    double d5 = rvr4.VoiceRatShare4G;
                    Double.isNaN(d2);
                    int i3 = (int) (d5 * d2);
                    double d6 = rvr4.VoiceRatShare5G;
                    Double.isNaN(d2);
                    int i4 = (int) (d6 * d2);
                    double d7 = rvr4.VoiceRatShareVoWiFi;
                    Double.isNaN(d2);
                    int i5 = (int) (d7 * d2);
                    double d8 = rvr4.VoiceRatShareUnknown;
                    Double.isNaN(d2);
                    statsDatabase.b(ubVar4, i, i2, i3, i4, i5, (int) (d2 * d8));
                }
            }
            if (InsightCore.getInsightConfig().o1()) {
                InsightCore.getStatsDatabase().b(this.b);
            }
        }
    }

    private class n extends PhoneStateListener {
        private Field a;

        public n() {
        }

        public void onCallDisconnectCauseChanged(int i, int i2) {
            synchronized (sd.this) {
                if (!(sd.this.m == null || i == -1)) {
                    sd.this.m.CallDisconnectCause = sd.this.b(i);
                }
                if (!(sd.this.m == null || i2 == -1)) {
                    sd.this.m.CallPreciseDisconnectCause = rd.e(i2);
                }
            }
        }

        public void onCallStateChanged(int i, String str) {
            int unused = sd.this.H = i;
            if (i != 0 && sd.this.m == null && !CDC.l(sd.this.a)) {
                return;
            }
            if (i == 0) {
                sd.this.a(a());
            } else if (i == 1) {
                synchronized (sd.this) {
                    if (sd.this.m == null) {
                        int unused2 = sd.this.B = a();
                        sd sdVar = sd.this;
                        sdVar.a(sdVar.B, str, r0.MTC);
                    } else {
                        sd.this.m.MultiCalls++;
                    }
                }
            } else if (i == 2) {
                synchronized (sd.this) {
                    if (sd.this.m == null) {
                        int unused3 = sd.this.B = a();
                        sd sdVar2 = sd.this;
                        sdVar2.a(sdVar2.B, str, r0.MOC);
                    } else if (!sd.this.u && sd.this.m.TimestampOnEstablished.isEmpty()) {
                        t0 unused4 = sd.this.n = t0.Active;
                        sd.this.m.TimeInfoOnEstablished = TimeServer.getTimeInfo();
                        sd.this.m.TimestampOnEstablished = sd.this.m.TimeInfoOnEstablished.TimestampTableau;
                    }
                    if (!sd.this.u) {
                        sd.this.m.CallSuccessful = true;
                    }
                }
            }
        }

        public void onImsCallDisconnectCauseChanged(ImsReasonInfo imsReasonInfo) {
            synchronized (sd.this) {
                if (!(sd.this.m == null || imsReasonInfo == null || imsReasonInfo.getCode() == 0)) {
                    sd.this.m.CallDisconnectCause = rd.c(imsReasonInfo.getCode());
                }
                if (!(sd.this.m == null || imsReasonInfo == null || imsReasonInfo.getExtraMessage() == null)) {
                    sd.this.m.CallPreciseDisconnectCause = imsReasonInfo.getExtraMessage();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f1, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPreciseCallStateChanged(android.telephony.PreciseCallState r7) {
            /*
                r6 = this;
                com.umlaut.crowd.internal.sd r0 = com.umlaut.crowd.internal.sd.this
                monitor-enter(r0)
                com.umlaut.crowd.internal.sd r1 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.RVR r1 = r1.m     // Catch:{ all -> 0x00f2 }
                if (r1 != 0) goto L_0x000d
                monitor-exit(r0)     // Catch:{ all -> 0x00f2 }
                return
            L_0x000d:
                int r1 = r7.getDisconnectCause()     // Catch:{ all -> 0x00f2 }
                r2 = -1
                if (r1 == r2) goto L_0x0026
                com.umlaut.crowd.internal.sd r1 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.RVR r1 = r1.m     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                int r4 = r7.getDisconnectCause()     // Catch:{ all -> 0x00f2 }
                java.lang.String r3 = r3.b((int) r4)     // Catch:{ all -> 0x00f2 }
                r1.CallDisconnectCause = r3     // Catch:{ all -> 0x00f2 }
            L_0x0026:
                int r1 = r7.getPreciseDisconnectCause()     // Catch:{ all -> 0x00f2 }
                if (r1 == r2) goto L_0x003c
                com.umlaut.crowd.internal.sd r1 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.RVR r1 = r1.m     // Catch:{ all -> 0x00f2 }
                int r2 = r7.getPreciseDisconnectCause()     // Catch:{ all -> 0x00f2 }
                java.lang.String r2 = com.umlaut.crowd.internal.rd.e(r2)     // Catch:{ all -> 0x00f2 }
                r1.CallPreciseDisconnectCause = r2     // Catch:{ all -> 0x00f2 }
            L_0x003c:
                int r1 = r7.getForegroundCallState()     // Catch:{ all -> 0x00f2 }
                int r2 = r7.getRingingCallState()     // Catch:{ all -> 0x00f2 }
                if (r2 <= 0) goto L_0x004a
                int r1 = r7.getRingingCallState()     // Catch:{ all -> 0x00f2 }
            L_0x004a:
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                int r7 = r7.C     // Catch:{ all -> 0x00f2 }
                if (r7 != r1) goto L_0x0054
                monitor-exit(r0)     // Catch:{ all -> 0x00f2 }
                return
            L_0x0054:
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                int unused = r7.C = r1     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                int r7 = r7.C     // Catch:{ all -> 0x00f2 }
                r1 = 1
                if (r7 == r1) goto L_0x0090
                r1 = 4
                if (r7 == r1) goto L_0x006a
                r1 = 5
                if (r7 == r1) goto L_0x006a
                goto L_0x00f0
            L_0x006a:
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00f2 }
                long unused = r7.x = r1     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.RVR r7 = r7.m     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r1 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                long r1 = r1.x     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r3 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                long r3 = r3.w     // Catch:{ all -> 0x00f2 }
                long r1 = r1 - r3
                r7.CallSetupTime = r1     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.t0 r1 = com.umlaut.crowd.internal.t0.Alerting     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.t0 unused = r7.n = r1     // Catch:{ all -> 0x00f2 }
                goto L_0x00f0
            L_0x0090:
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00f2 }
                long unused = r7.y = r2     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.RVR r7 = r7.m     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r2 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                long r2 = r2.y     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r4 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                long r4 = r4.x     // Catch:{ all -> 0x00f2 }
                long r2 = r2 - r4
                r7.CallAlertingTime = r2     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.RVR r7 = r7.m     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r2 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                long r2 = r2.y     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r4 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                long r4 = r4.w     // Catch:{ all -> 0x00f2 }
                long r2 = r2 - r4
                r7.TimeToConnect = r2     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.RVR r7 = r7.m     // Catch:{ all -> 0x00f2 }
                r7.CallSuccessful = r1     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.RVR r7 = r7.m     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.ub r1 = com.umlaut.crowd.timeserver.TimeServer.getTimeInfo()     // Catch:{ all -> 0x00f2 }
                r7.TimeInfoOnEstablished = r1     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.RVR r7 = r7.m     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r1 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.RVR r1 = r1.m     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.ub r1 = r1.TimeInfoOnEstablished     // Catch:{ all -> 0x00f2 }
                java.lang.String r1 = r1.TimestampTableau     // Catch:{ all -> 0x00f2 }
                r7.TimestampOnEstablished = r1     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.sd r7 = com.umlaut.crowd.internal.sd.this     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.t0 r1 = com.umlaut.crowd.internal.t0.Active     // Catch:{ all -> 0x00f2 }
                com.umlaut.crowd.internal.t0 unused = r7.n = r1     // Catch:{ all -> 0x00f2 }
            L_0x00f0:
                monitor-exit(r0)     // Catch:{ all -> 0x00f2 }
                return
            L_0x00f2:
                r7 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00f2 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.sd.n.onPreciseCallStateChanged(android.telephony.PreciseCallState):void");
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            if (serviceState.getState() == 1) {
                long unused = sd.this.o = SystemClock.elapsedRealtime();
            }
            super.onServiceStateChanged(serviceState);
        }

        /* access modifiers changed from: private */
        public int a() {
            Field field = this.a;
            if (field != null) {
                try {
                    return ((Integer) field.get(this)).intValue();
                } catch (IllegalAccessException e) {
                    String a2 = sd.U;
                    Log.d(a2, "getHiddenSubscriptionId: " + e.getMessage());
                }
            }
            return -1;
        }

        public n(int i) {
            try {
                Field declaredField = getClass().getSuperclass().getDeclaredField("mSubId");
                this.a = declaredField;
                declaredField.setAccessible(true);
                this.a.set(this, Integer.valueOf(i));
            } catch (Exception e) {
                String a2 = sd.U;
                Log.d(a2, "SignalStrengthListener: " + e.getMessage());
            }
        }
    }

    public sd(Context context) {
        this.a = context;
        this.G = context.getApplicationContext().getSharedPreferences(V, 0);
        this.j = InsightCore.getInsightSettings();
        this.k = InsightCore.getInsightConfig().f1();
        this.g = (TelephonyManager) context.getSystemService("phone");
        this.f = new CLC(context);
        this.i = new x(context);
        this.N = new CopyOnWriteArrayList<>();
        new Handler(Looper.getMainLooper()).post(new d());
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new e());
    }

    /* access modifiers changed from: private */
    public boolean g() {
        Method method = this.I;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(this.g, new Object[0])).booleanValue();
            } catch (Exception e2) {
                String str = U;
                Log.d(str, "isVolteEnabled: " + e2.getMessage());
            }
        } else {
            Method method2 = this.J;
            if (method2 != null) {
                try {
                    return ((Boolean) method2.invoke(this.g, new Object[0])).booleanValue();
                } catch (Exception e3) {
                    String str2 = U;
                    Log.d(str2, "isVolteEnabled: " + e3.getMessage());
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean h() {
        Method method = this.K;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(this.g, new Object[0])).booleanValue();
            } catch (Exception e2) {
                String str = U;
                Log.d(str, "isWifiCallingEnabled: " + e2.getMessage());
            }
        } else {
            Method method2 = this.L;
            if (method2 != null) {
                try {
                    return ((Boolean) method2.invoke(this.g, new Object[0])).booleanValue();
                } catch (Exception e3) {
                    String str2 = U;
                    Log.d(str2, "isWifiCallingEnabled: " + e3.getMessage());
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        if (Build.VERSION.SDK_INT >= 22) {
            this.e = new f();
        }
    }

    private void k() {
        this.h = new SparseArray<>();
        for (int i2 : this.F) {
            this.h.put(i2, this.g.createForSubscriptionId(i2));
        }
    }

    public void i() {
        if (!this.D && this.m == null) {
            this.D = true;
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new g());
        }
    }

    public void l() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new i());
    }

    public void m() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new k());
    }

    private int[] f() {
        return CDC.k(this.a);
    }

    private ThreeState c() {
        Method method = this.K;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(this.g, new Object[0])).booleanValue() ? ThreeState.Enabled : ThreeState.Disabled;
            } catch (Exception e2) {
                String str = U;
                Log.d(str, "getIsVoWifiEnabled: " + e2.getMessage());
            }
        } else {
            Method method2 = this.L;
            if (method2 != null) {
                try {
                    return ((Boolean) method2.invoke(this.g, new Object[0])).booleanValue() ? ThreeState.Enabled : ThreeState.Disabled;
                } catch (Exception e3) {
                    String str2 = U;
                    Log.d(str2, "getIsVoWifiEnabled: " + e3.getMessage());
                }
            }
            return ThreeState.Unknown;
        }
    }

    /* access modifiers changed from: private */
    public String d() {
        SharedPreferences sharedPreferences = this.G;
        return sharedPreferences != null ? sharedPreferences.getString(X, "") : "";
    }

    /* access modifiers changed from: private */
    public String e() {
        SharedPreferences sharedPreferences = this.G;
        return sharedPreferences != null ? sharedPreferences.getString(W, "") : "";
    }

    public void b(td tdVar) {
        this.N.remove(tdVar);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(3:2|3|(1:5))(3:7|8|(1:10))|11|(3:13|14|(1:16))(2:17|(1:19))|20|21|(1:23)|24|25|(1:27)|28|30|31|(2:33|35)(1:37)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x007c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0097 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0092 A[Catch:{ NoSuchMethodException -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ad A[Catch:{ NoSuchMethodException -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc A[Catch:{ NoClassDefFoundError | NoSuchMethodException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r6 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 1
            r3 = 23
            if (r0 >= r3) goto L_0x0026
            android.telephony.TelephonyManager r0 = r6.g     // Catch:{ NoSuchMethodException -> 0x0024 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x0024 }
            java.lang.String r4 = "isVolteEnabled"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r4, r1)     // Catch:{ NoSuchMethodException -> 0x0024 }
            int r4 = r0.getModifiers()     // Catch:{ NoSuchMethodException -> 0x0024 }
            boolean r4 = java.lang.reflect.Modifier.isAbstract(r4)     // Catch:{ NoSuchMethodException -> 0x0024 }
            if (r4 != 0) goto L_0x0041
            r6.I = r0     // Catch:{ NoSuchMethodException -> 0x0024 }
            r0.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x0024 }
            goto L_0x0041
        L_0x0024:
            goto L_0x0041
        L_0x0026:
            android.telephony.TelephonyManager r0 = r6.g     // Catch:{  }
            java.lang.Class r0 = r0.getClass()     // Catch:{  }
            java.lang.String r4 = "isVolteAvailable"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r4, r1)     // Catch:{  }
            int r4 = r0.getModifiers()     // Catch:{  }
            boolean r4 = java.lang.reflect.Modifier.isAbstract(r4)     // Catch:{  }
            if (r4 != 0) goto L_0x0041
            r6.I = r0     // Catch:{  }
            r0.setAccessible(r2)     // Catch:{  }
        L_0x0041:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 >= r3) goto L_0x0061
            android.telephony.TelephonyManager r0 = r6.g     // Catch:{ NoSuchMethodException -> 0x007c }
            java.lang.Class r0 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x007c }
            java.lang.String r3 = "isWifiCallingEnabled"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r3, r1)     // Catch:{ NoSuchMethodException -> 0x007c }
            int r3 = r0.getModifiers()     // Catch:{ NoSuchMethodException -> 0x007c }
            boolean r3 = java.lang.reflect.Modifier.isAbstract(r3)     // Catch:{ NoSuchMethodException -> 0x007c }
            if (r3 != 0) goto L_0x007c
            r6.K = r0     // Catch:{ NoSuchMethodException -> 0x007c }
            r0.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x007c }
            goto L_0x007c
        L_0x0061:
            android.telephony.TelephonyManager r0 = r6.g     // Catch:{ NoSuchMethodException -> 0x007c }
            java.lang.Class r0 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x007c }
            java.lang.String r3 = "isWifiCallingAvailable"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r3, r1)     // Catch:{ NoSuchMethodException -> 0x007c }
            int r3 = r0.getModifiers()     // Catch:{ NoSuchMethodException -> 0x007c }
            boolean r3 = java.lang.reflect.Modifier.isAbstract(r3)     // Catch:{ NoSuchMethodException -> 0x007c }
            if (r3 != 0) goto L_0x007c
            r6.K = r0     // Catch:{ NoSuchMethodException -> 0x007c }
            r0.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x007c }
        L_0x007c:
            android.telephony.TelephonyManager r0 = r6.g     // Catch:{ NoSuchMethodException -> 0x0097 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x0097 }
            java.lang.String r3 = "isVolteRegistered"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r3, r1)     // Catch:{ NoSuchMethodException -> 0x0097 }
            int r3 = r0.getModifiers()     // Catch:{ NoSuchMethodException -> 0x0097 }
            boolean r3 = java.lang.reflect.Modifier.isAbstract(r3)     // Catch:{ NoSuchMethodException -> 0x0097 }
            if (r3 != 0) goto L_0x0097
            r6.J = r0     // Catch:{ NoSuchMethodException -> 0x0097 }
            r0.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x0097 }
        L_0x0097:
            android.telephony.TelephonyManager r0 = r6.g     // Catch:{ NoSuchMethodException -> 0x00b2 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x00b2 }
            java.lang.String r3 = "isWfcRegistered"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r3, r1)     // Catch:{ NoSuchMethodException -> 0x00b2 }
            int r1 = r0.getModifiers()     // Catch:{ NoSuchMethodException -> 0x00b2 }
            boolean r1 = java.lang.reflect.Modifier.isAbstract(r1)     // Catch:{ NoSuchMethodException -> 0x00b2 }
            if (r1 != 0) goto L_0x00b2
            r6.L = r0     // Catch:{ NoSuchMethodException -> 0x00b2 }
            r0.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x00b2 }
        L_0x00b2:
            java.lang.Class<android.telephony.DisconnectCause> r0 = android.telephony.DisconnectCause.class
            java.lang.String r1 = "toString"
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ NoClassDefFoundError | NoSuchMethodException -> 0x00d1 }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ NoClassDefFoundError | NoSuchMethodException -> 0x00d1 }
            r5 = 0
            r3[r5] = r4     // Catch:{ NoClassDefFoundError | NoSuchMethodException -> 0x00d1 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r3)     // Catch:{ NoClassDefFoundError | NoSuchMethodException -> 0x00d1 }
            int r1 = r0.getModifiers()     // Catch:{ NoClassDefFoundError | NoSuchMethodException -> 0x00d1 }
            boolean r1 = java.lang.reflect.Modifier.isAbstract(r1)     // Catch:{ NoClassDefFoundError | NoSuchMethodException -> 0x00d1 }
            if (r1 != 0) goto L_0x00d1
            r6.M = r0     // Catch:{ NoClassDefFoundError | NoSuchMethodException -> 0x00d1 }
            r0.setAccessible(r2)     // Catch:{ NoClassDefFoundError | NoSuchMethodException -> 0x00d1 }
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.sd.b():void");
    }

    public void a(td tdVar) {
        this.N.add(tdVar);
    }

    private void a(int[] iArr) {
        this.d = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Handler(Looper.getMainLooper()).post(new h(iArr, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            Log.d(U, e2.toString());
        }
    }

    public void a(boolean z2) {
        SubscriptionManager subscriptionManager;
        this.F = f();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            k();
        }
        if (this.g != null) {
            if (z2 && this.e != null && this.a.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && i2 >= 22 && (subscriptionManager = (SubscriptionManager) this.a.getSystemService("telephony_subscription_service")) != null) {
                subscriptionManager.addOnSubscriptionsChangedListener(this.e);
            }
            boolean z3 = false;
            this.u = this.a.checkCallingOrSelfPermission("android.permission.READ_PRECISE_PHONE_STATE") == 0;
            if (PermissionUtils.hasReadCallLogPermission(this.a) && InsightCore.getInsightConfig().S1()) {
                z3 = true;
            }
            this.v = z3;
            int i3 = this.u ? i2 >= 30 ? 167774241 : 2081 : 33;
            if (this.a.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 || (i2 >= 23 && i2 < 31)) {
                a(this.F);
                if (this.d.size() == 0) {
                    if (this.c == null) {
                        CountDownLatch countDownLatch = new CountDownLatch(1);
                        new Handler(Looper.getMainLooper()).post(new j(countDownLatch));
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e2) {
                            Log.d(U, e2.toString());
                        }
                    }
                    this.g.listen(this.c, i3);
                } else {
                    Iterator<n> it = this.d.iterator();
                    while (it.hasNext()) {
                        n next = it.next();
                        SparseArray<TelephonyManager> sparseArray = this.h;
                        TelephonyManager telephonyManager = (sparseArray == null || sparseArray.size() <= 0) ? null : this.h.get(next.a());
                        if (telephonyManager == null) {
                            telephonyManager = this.g;
                        }
                        telephonyManager.listen(next, i3);
                    }
                }
            }
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PHONE_STATE");
            intentFilter.addAction("com.samsung.intent.action.CALL_DROP");
            intentFilter.addAction("com.samsung.intent.action.IMS_CALL_DROP");
            intentFilter.addAction("com.samsung.rcs.CALL_STATE_CHANGED");
            intentFilter.addAction("com.samsung.intent.action.BIG_DATA_INFO");
            this.a.registerReceiver(this.O, intentFilter);
        }
    }

    public void b(boolean z2) {
        SubscriptionManager subscriptionManager;
        if (z2 && this.e != null && this.a.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && Build.VERSION.SDK_INT >= 22 && (subscriptionManager = (SubscriptionManager) this.a.getSystemService("telephony_subscription_service")) != null) {
            subscriptionManager.removeOnSubscriptionsChangedListener(this.e);
        }
        TelephonyManager telephonyManager = this.g;
        if (telephonyManager != null) {
            n nVar = this.c;
            if (nVar != null) {
                telephonyManager.listen(nVar, 0);
            }
            Iterator<n> it = this.d.iterator();
            while (it.hasNext()) {
                n next = it.next();
                SparseArray<TelephonyManager> sparseArray = this.h;
                TelephonyManager telephonyManager2 = (sparseArray == null || sparseArray.size() <= 0) ? null : this.h.get(next.a());
                if (telephonyManager2 == null) {
                    telephonyManager2 = this.g;
                }
                telephonyManager2.listen(next, 0);
            }
            try {
                Context context = this.a;
                if (context != null) {
                    context.unregisterReceiver(this.O);
                }
            } catch (IllegalArgumentException e2) {
                String str = U;
                Log.e(str, "stopListening: " + e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, r0 r0Var) {
        this.w = SystemClock.elapsedRealtime();
        this.b = new ArrayList<>();
        this.m = new RVR(this.k, this.j.q());
        this.m.TimeInfoOnStart = TimeServer.getTimeInfo();
        this.m.TimestampOnStart = this.m.TimeInfoOnStart.TimestampTableau;
        this.p = -1;
        this.q = -1;
        this.t = null;
        this.r = null;
        this.s = null;
        if (r0Var != r0.MOC) {
            this.n = t0.Ringing;
        } else if (this.u) {
            this.n = t0.CallSetup;
        } else {
            this.n = t0.Connecting;
        }
        if (str == null) {
            str = "";
        }
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a(str, r0Var, i2));
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences sharedPreferences = this.G;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(W, str).apply();
        }
    }

    /* access modifiers changed from: private */
    public String b(int i2) {
        Method method = this.M;
        if (method == null) {
            return "";
        }
        try {
            return (String) method.invoke((Object) null, new Object[]{Integer.valueOf(i2)});
        } catch (Exception e2) {
            String str = U;
            Log.d(str, "isVolteEnabled: " + e2.getMessage());
            return "";
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (this.m != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.m.TimeInfoOnEnd = TimeServer.getTimeInfo();
            this.m.TimestampOnEnd = this.m.TimeInfoOnEnd.TimestampTableau;
            if (!this.u) {
                long j2 = elapsedRealtime - this.o;
                if (j2 < 10000) {
                    this.m.CallEndType = s0.Dropped;
                    this.m.DropInWindowTime = (int) j2;
                }
                if (!this.m.CallSuccessful && this.m.CallAlertingTime == -1) {
                    this.m.CallAlertingTime = elapsedRealtime - this.w;
                }
            } else if (!this.m.CallSuccessful && this.x > 0) {
                this.m.CallAlertingTime = elapsedRealtime - this.x;
            } else if (this.y > 0) {
                this.m.CallDuration = elapsedRealtime - this.y;
            }
            ScheduledFuture<?> scheduledFuture = this.l;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new b(i2));
        }
    }

    /* access modifiers changed from: private */
    public j5 a(RVR rvr, t0 t0Var, long j2) {
        j5 j5Var = new j5(this.k, this.j.q());
        j5Var.FkVcId = rvr.VcId;
        j5Var.Delta = SystemClock.elapsedRealtime() - j2;
        j5Var.TimeInfo = TimeServer.getTimeInfo();
        j5Var.CallPhase = t0Var;
        j5Var.RadioInfo = InsightCore.getRadioController().i(this.B);
        j5Var.VoiceNetworkType = InsightCore.getRadioController().j(this.B);
        j5Var.WifiInfo = InsightCore.getWifiController().getWifiInfo();
        j5Var.ScreenState = CDC.f(this.a);
        j5Var.IsVoWiFiAvailable = c();
        if (!InsightCore.getInsightConfig().F()) {
            j5Var.LocationInfo = this.f.getLastLocationInfo();
        }
        return j5Var;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        SharedPreferences sharedPreferences = this.G;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(X, str).apply();
        }
    }
}
