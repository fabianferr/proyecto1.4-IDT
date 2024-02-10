package com.umlaut.crowd.internal;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.NetworkRegistrationInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.gms.cast.MediaTrack;
import com.umlaut.crowd.IC;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.enums.NetworkGenerations;
import com.umlaut.crowd.enums.NetworkTypes;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.utils.PermissionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.slf4j.Marker;

public class l7 {
    /* access modifiers changed from: private */
    public static final String W = "l7";
    private static final boolean X = false;
    private static final int Y = 16;
    private static final int Z = 17;
    private static final int a0 = 18;
    public static final int b0 = 19;
    /* access modifiers changed from: private */
    public Method A;
    /* access modifiers changed from: private */
    public Method B;
    /* access modifiers changed from: private */
    public Method C;
    /* access modifiers changed from: private */
    public Method D;
    /* access modifiers changed from: private */
    public Method E;
    /* access modifiers changed from: private */
    public Field F;
    private Field G;
    private Field H;
    private Field I;
    private Field J;
    private Method K;
    private Method L;
    private Method M;
    /* access modifiers changed from: private */
    public Method N;
    private Method O;
    private Method P;
    private Method Q;
    private final ContentResolver R;
    private int[] S;
    /* access modifiers changed from: private */
    public boolean T = false;
    /* access modifiers changed from: private */
    public final Set<m7> U;
    /* access modifiers changed from: private */
    public volatile boolean V;
    /* access modifiers changed from: private */
    public final TelephonyManager a;
    /* access modifiers changed from: private */
    public SparseArray<TelephonyManager> b;
    /* access modifiers changed from: private */
    public final Context c;
    /* access modifiers changed from: private */
    public u d;
    /* access modifiers changed from: private */
    public ArrayList<u> e;
    private final ConnectivityManager f;
    /* access modifiers changed from: private */
    public final o g;
    private SubscriptionManager.OnSubscriptionsChangedListener h;
    /* access modifiers changed from: private */
    public y5 i;
    private p j;
    /* access modifiers changed from: private */
    public List<CellInfo> k;
    /* access modifiers changed from: private */
    public Method l;
    /* access modifiers changed from: private */
    public Method m;
    /* access modifiers changed from: private */
    public Method n;
    /* access modifiers changed from: private */
    public Method o;
    /* access modifiers changed from: private */
    public Method p;
    /* access modifiers changed from: private */
    public Method q;
    /* access modifiers changed from: private */
    public Method r;
    /* access modifiers changed from: private */
    public Method s;
    private Method t;
    private Method u;
    /* access modifiers changed from: private */
    public Field v;
    private Field w;
    /* access modifiers changed from: private */
    public Field x;
    /* access modifiers changed from: private */
    public Field y;
    /* access modifiers changed from: private */
    public Field z;

    class a implements Callable<z0[]> {
        a() {
        }

        /* renamed from: a */
        public z0[] call() {
            try {
                return l7.this.d();
            } catch (Exception e) {
                String a2 = l7.W;
                Log.e(a2, "getFutureCellInfo#call: " + e.toString());
                return new z0[0];
            }
        }
    }

    class b implements Callable<g[]> {
        b() {
        }

        /* renamed from: a */
        public g[] call() throws Exception {
            try {
                return l7.this.b();
            } catch (Exception e) {
                String a2 = l7.W;
                Log.d(a2, "getFutureApnInfo: " + e.toString());
                return new g[0];
            }
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(53:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x009b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00b3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00bf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00cb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00d7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00ef */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0107 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0113 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x011f */
        static {
            /*
                com.umlaut.crowd.enums.NetworkGenerations[] r0 = com.umlaut.crowd.enums.NetworkGenerations.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                com.umlaut.crowd.enums.NetworkGenerations r2 = com.umlaut.crowd.enums.NetworkGenerations.Gen2     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.enums.NetworkGenerations r3 = com.umlaut.crowd.enums.NetworkGenerations.Gen3     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.enums.NetworkGenerations r4 = com.umlaut.crowd.enums.NetworkGenerations.Gen4     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.enums.NetworkGenerations r5 = com.umlaut.crowd.enums.NetworkGenerations.Gen5SA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.umlaut.crowd.enums.NetworkTypes[] r4 = com.umlaut.crowd.enums.NetworkTypes.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                a = r4
                com.umlaut.crowd.enums.NetworkTypes r5 = com.umlaut.crowd.enums.NetworkTypes.GPRS     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.umlaut.crowd.enums.NetworkTypes r4 = com.umlaut.crowd.enums.NetworkTypes.EDGE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.GSM     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.Cdma1xRTT     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006d }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.CDMA     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.IDEN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.UMTS     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x008f }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.EVDO_0     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x009b }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.EVDO_A     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00a7 }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.EVDO_B     // Catch:{ NoSuchFieldError -> 0x00a7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a7 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a7 }
            L_0x00a7:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00b3 }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.HSPA     // Catch:{ NoSuchFieldError -> 0x00b3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b3 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b3 }
            L_0x00b3:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00bf }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.HSDPA     // Catch:{ NoSuchFieldError -> 0x00bf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bf }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00bf }
            L_0x00bf:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00cb }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.HSPAP     // Catch:{ NoSuchFieldError -> 0x00cb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cb }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cb }
            L_0x00cb:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00d7 }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.HSUPA     // Catch:{ NoSuchFieldError -> 0x00d7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d7 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d7 }
            L_0x00d7:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00e3 }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.EHRPD     // Catch:{ NoSuchFieldError -> 0x00e3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e3 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e3 }
            L_0x00e3:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00ef }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.TD_SCDMA     // Catch:{ NoSuchFieldError -> 0x00ef }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ef }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ef }
            L_0x00ef:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00fb }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.LTE     // Catch:{ NoSuchFieldError -> 0x00fb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fb }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fb }
            L_0x00fb:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0107 }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.LTE_CA     // Catch:{ NoSuchFieldError -> 0x0107 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0107 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0107 }
            L_0x0107:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0113 }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.NR     // Catch:{ NoSuchFieldError -> 0x0113 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0113 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0113 }
            L_0x0113:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x011f }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.WiFi     // Catch:{ NoSuchFieldError -> 0x011f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011f }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x011f }
            L_0x011f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x012b }
                com.umlaut.crowd.enums.NetworkTypes r1 = com.umlaut.crowd.enums.NetworkTypes.Unknown     // Catch:{ NoSuchFieldError -> 0x012b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012b }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012b }
            L_0x012b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.l7.c.<clinit>():void");
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            l7.this.x();
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            l7.this.u();
            l7.this.v();
            l7.this.w();
            l7.this.t();
        }
    }

    class f extends SubscriptionManager.OnSubscriptionsChangedListener {
        f() {
        }

        public void onSubscriptionsChanged() {
            super.onSubscriptionsChanged();
            l7.this.r();
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            if (l7.this.T) {
                l7.this.c(false);
                l7.this.b(false);
            }
            boolean unused = l7.this.V = false;
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
            for (int uVar : this.a) {
                l7.this.e.add(new u(uVar));
            }
            this.b.countDown();
        }
    }

    class i implements Runnable {
        i() {
        }

        public void run() {
            boolean unused = l7.this.T = true;
            l7.this.b(true);
            l7 l7Var = l7.this;
            l7Var.b(l7Var.c);
        }
    }

    class j implements Runnable {
        final /* synthetic */ CountDownLatch a;

        j(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        public void run() {
            u unused = l7.this.d = new u();
            this.a.countDown();
        }
    }

    class k implements Runnable {
        k() {
        }

        public void run() {
            boolean unused = l7.this.T = false;
            l7.this.c(true);
            l7 l7Var = l7.this;
            l7Var.c(l7Var.c);
        }
    }

    class l extends TelephonyManager.CellInfoCallback {
        final /* synthetic */ CountDownLatch a;

        l(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        public void onCellInfo(List<CellInfo> list) {
            if (list != null) {
                synchronized (l7.this) {
                    List unused = l7.this.k = list;
                }
            }
            this.a.countDown();
        }
    }

    private class o {
        private SparseArray<t> a = new SparseArray<>();
        private SparseArray<s> b = new SparseArray<>();
        private SparseArray<n> c = new SparseArray<>();
        private HashMap<String, q> d = new HashMap<>();
        private SparseArray<j6[]> e = new SparseArray<>();
        private SparseArray<r> f = new SparseArray<>();
        private SparseIntArray g = new SparseIntArray();
        private SparseIntArray h = new SparseIntArray();
        private Map<String, String> i = new HashMap();

        o() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, t tVar) {
            this.a.put(i2, tVar);
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3) {
            this.g.put(i2, i3);
        }

        /* access modifiers changed from: package-private */
        public int c(int i2) {
            return this.h.get(i2, -1);
        }

        /* access modifiers changed from: package-private */
        public int d(int i2) {
            return this.g.get(i2, -1);
        }

        /* access modifiers changed from: package-private */
        public r e(int i2) {
            return this.f.get(i2);
        }

        /* access modifiers changed from: package-private */
        public s f(int i2) {
            s sVar = this.b.get(i2);
            return sVar == null ? new s(l7.this, (d) null) : sVar;
        }

        /* access modifiers changed from: package-private */
        public t g(int i2) {
            t tVar = this.a.get(i2);
            return tVar == null ? new t(l7.this, (d) null) : tVar;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, s sVar) {
            this.b.put(i2, sVar);
        }

        /* access modifiers changed from: package-private */
        public j6[] b(int i2) {
            return this.e.get(i2);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, n nVar) {
            this.c.put(i2, nVar);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, j6[] j6VarArr) {
            this.e.put(i2, j6VarArr);
        }

        /* access modifiers changed from: package-private */
        public void a(String str, q qVar) {
            this.d.put(str, qVar);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, String str, String str2) {
            Map<String, String> map = this.i;
            map.put(i2 + str, str2);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, r rVar) {
            this.f.put(i2, rVar);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            this.h.put(i2, i3);
        }

        /* access modifiers changed from: package-private */
        public n a(int i2) {
            return this.c.get(i2);
        }

        /* access modifiers changed from: package-private */
        public q a(String str) {
            return this.d.get(str);
        }

        /* access modifiers changed from: package-private */
        public String a(int i2, String str) {
            Map<String, String> map = this.i;
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(str != null ? str.split(",")[0] : "");
            String str2 = map.get(sb.toString());
            return str2 == null ? "" : str2;
        }
    }

    public l7(Context context) {
        this.c = context;
        this.a = (TelephonyManager) context.getSystemService("phone");
        this.f = (ConnectivityManager) context.getSystemService("connectivity");
        this.S = new int[0];
        this.U = new HashSet();
        this.i = new y5();
        this.g = new o();
        this.R = context.getContentResolver();
        new Handler(Looper.getMainLooper()).post(new d());
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new e());
    }

    private static int b(int i2) {
        if (i2 == 99 || i2 < -5 || i2 > 91) {
            return 0;
        }
        return i2 - 116;
    }

    /* access modifiers changed from: private */
    public static int c(int i2) {
        if (i2 == 99 || i2 < 0 || i2 > 31) {
            return 0;
        }
        return (i2 * 2) - 113;
    }

    public DRI getRadioInfoForDefaultDataSim() {
        return i(this.i.DefaultDataSimId);
    }

    private void B() {
        y5 e2 = CDC.e(this.c);
        this.i = e2;
        o9[] o9VarArr = e2.SimInfos;
        int[] iArr = new int[o9VarArr.length];
        for (int i2 = 0; i2 < o9VarArr.length; i2++) {
            iArr[i2] = o9VarArr[i2].SubscriptionId;
        }
        this.S = iArr;
    }

    private void e(CellInfo cellInfo, z0 z0Var, long j2) {
        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
        z0Var.IsRegistered = cellInfoWcdma.isRegistered();
        z0Var.CellNetworkType = a1.Wcdma;
        z0Var.CellInfoAge = j2 - (cellInfoWcdma.getTimeStamp() / 1000000);
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            z0Var.Mcc = cellIdentity.getMcc();
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            z0Var.Mnc = cellIdentity.getMnc();
        }
        if (cellIdentity.getCid() != Integer.MAX_VALUE) {
            int cid = cellIdentity.getCid();
            z0Var.Cid = cid;
            z0Var.CellId = (long) cid;
        }
        if (cellIdentity.getLac() != Integer.MAX_VALUE) {
            z0Var.Lac = cellIdentity.getLac();
        }
        if (cellIdentity.getPsc() != Integer.MAX_VALUE) {
            z0Var.Psc = cellIdentity.getPsc();
        }
        if (Build.VERSION.SDK_INT >= 24 && cellIdentity.getUarfcn() != Integer.MAX_VALUE) {
            z0Var.Arfcn = cellIdentity.getUarfcn();
        }
        z0Var.Dbm = cellInfoWcdma.getCellSignalStrength().getDbm();
    }

    private boolean l(int i2) {
        return this.i.getSimInfoSubId(i2).SubscriptionId != -1;
    }

    private List<m> s() {
        Network[] allNetworks;
        ArrayList arrayList = new ArrayList();
        if (this.f != null && Build.VERSION.SDK_INT >= 21 && this.c.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && (allNetworks = this.f.getAllNetworks()) != null && allNetworks.length > 0) {
            for (Network network : allNetworks) {
                NetworkCapabilities networkCapabilities = this.f.getNetworkCapabilities(network);
                if (networkCapabilities != null && networkCapabilities.hasTransport(0)) {
                    m mVar = new m(this, (d) null);
                    NetworkInfo networkInfo = this.f.getNetworkInfo(network);
                    LinkProperties linkProperties = this.f.getLinkProperties(network);
                    ArrayList arrayList2 = new ArrayList();
                    if (networkCapabilities.hasCapability(4)) {
                        arrayList2.add("ims");
                    }
                    if (networkCapabilities.hasCapability(1)) {
                        arrayList2.add("supl");
                    }
                    if (networkCapabilities.hasCapability(9)) {
                        arrayList2.add("xcap");
                    }
                    if (networkCapabilities.hasCapability(2)) {
                        arrayList2.add("dun");
                    }
                    if (networkCapabilities.hasCapability(5)) {
                        arrayList2.add("cbs");
                    }
                    if (networkCapabilities.hasCapability(3)) {
                        arrayList2.add("fota");
                    }
                    if (networkCapabilities.hasCapability(10)) {
                        arrayList2.add(MediaTrack.ROLE_EMERGENCY);
                    }
                    if (networkCapabilities.hasCapability(7)) {
                        arrayList2.add(ia.j);
                    }
                    if (networkCapabilities.hasCapability(0)) {
                        arrayList2.add("mms");
                    }
                    if (networkCapabilities.hasCapability(8)) {
                        arrayList2.add("rcs");
                    }
                    if (networkCapabilities.hasCapability(23)) {
                        arrayList2.add("mcx");
                    }
                    mVar.d = TextUtils.join(",", arrayList2);
                    if (networkInfo != null) {
                        mVar.b = networkInfo.getExtraInfo();
                        mVar.a = networkInfo.getSubtype();
                        mVar.k = fe.fromDetailedState(networkInfo.getDetailedState());
                    }
                    if (linkProperties != null) {
                        mVar.e = h.a(networkCapabilities);
                        mVar.g = h.b(networkCapabilities);
                        mVar.f = h.a(linkProperties);
                        String interfaceName = linkProperties.getInterfaceName();
                        if (interfaceName != null) {
                            try {
                                mVar.h = pc.b(interfaceName);
                                mVar.i = pc.a(interfaceName);
                            } catch (Exception unused) {
                            }
                            mVar.j = interfaceName;
                        }
                    }
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void t() {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                Field declaredField = CellSignalStrengthLte.class.getDeclaredField("mSignalStrength");
                this.G = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            try {
                Field declaredField2 = CellSignalStrengthLte.class.getDeclaredField("mRsrq");
                this.H = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            try {
                Field declaredField3 = CellSignalStrengthLte.class.getDeclaredField("mRssnr");
                this.I = declaredField3;
                declaredField3.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
            try {
                Field declaredField4 = CellSignalStrengthLte.class.getDeclaredField("mCqi");
                this.J = declaredField4;
                declaredField4.setAccessible(true);
            } catch (NoSuchFieldException unused4) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        if (Build.VERSION.SDK_INT >= 25) {
            try {
                Field declaredField = ServiceState.class.getDeclaredField("mIsUsingCarrierAggregation");
                this.F = declaredField;
                declaredField.setAccessible(true);
            } catch (Exception unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                this.D = SignalStrength.class.getDeclaredMethod("isUsingCarrierAggregation", new Class[0]);
            } catch (Exception unused2) {
            }
        }
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                this.E = NetworkRegistrationInfo.class.getDeclaredMethod("getNrState", new Class[0]);
            } catch (Exception unused3) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void v() {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                this.m = SignalStrength.class.getDeclaredMethod("getLteSignalStrength", new Class[0]);
            } catch (Exception unused) {
            }
            try {
                this.p = SignalStrength.class.getDeclaredMethod("getLteCqi", new Class[0]);
            } catch (Exception unused2) {
            }
            try {
                this.q = SignalStrength.class.getDeclaredMethod("getLteRsrp", new Class[0]);
            } catch (Exception unused3) {
            }
            try {
                this.r = SignalStrength.class.getDeclaredMethod("getLteRsrq", new Class[0]);
            } catch (Exception unused4) {
            }
            try {
                this.s = SignalStrength.class.getDeclaredMethod("getLteRssnr", new Class[0]);
            } catch (Exception unused5) {
            }
            try {
                this.n = SignalStrength.class.getDeclaredMethod("getLteDbm", new Class[0]);
            } catch (Exception unused6) {
            }
            try {
                this.l = SignalStrength.class.getDeclaredMethod("getDbm", new Class[0]);
            } catch (Exception unused7) {
            }
        }
        try {
            this.o = SignalStrength.class.getDeclaredMethod("getGsmEcno", new Class[0]);
        } catch (Exception unused8) {
        }
        try {
            Field declaredField = SignalStrength.class.getDeclaredField("mWcdmaRscp");
            this.v = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused9) {
        }
        try {
            Field declaredField2 = SignalStrength.class.getDeclaredField("mWcdmaEcio");
            this.w = declaredField2;
            declaredField2.setAccessible(true);
        } catch (NoSuchFieldException unused10) {
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Field declaredField3 = SignalStrength.class.getDeclaredField("mNrRsrp");
                this.x = declaredField3;
                declaredField3.setAccessible(true);
            } catch (NoSuchFieldException unused11) {
            }
            try {
                Field declaredField4 = SignalStrength.class.getDeclaredField("mNrRsrq");
                this.y = declaredField4;
                declaredField4.setAccessible(true);
            } catch (NoSuchFieldException unused12) {
            }
            try {
                Field declaredField5 = SignalStrength.class.getDeclaredField("mNrRssnr");
                this.z = declaredField5;
                declaredField5.setAccessible(true);
            } catch (NoSuchFieldException unused13) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|8|9|10|11|12|(1:14)|16|(9:18|19|20|21|22|23|24|25|(2:27|29)(1:32))(1:31)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:18|19|20|21|22|23|24|25|(2:27|29)(1:32)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0084 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0098 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00ac */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003a */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0063 A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070 A[SYNTHETIC, Splitter:B:18:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c6 A[Catch:{ Exception -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void w() {
        /*
            r7 = this;
            java.lang.String r0 = "getVoiceNetworkType"
            java.lang.String r1 = "getDataEnabled"
            r2 = 0
            android.telephony.TelephonyManager r3 = r7.a     // Catch:{ Exception -> 0x0013 }
            java.lang.Class r3 = r3.getClass()     // Catch:{ Exception -> 0x0013 }
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0013 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r1, r4)     // Catch:{ Exception -> 0x0013 }
            r7.K = r3     // Catch:{ Exception -> 0x0013 }
        L_0x0013:
            r3 = 1
            android.telephony.TelephonyManager r4 = r7.a     // Catch:{ Exception -> 0x0026 }
            java.lang.Class r4 = r4.getClass()     // Catch:{ Exception -> 0x0026 }
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0026 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0026 }
            r5[r2] = r6     // Catch:{ Exception -> 0x0026 }
            java.lang.reflect.Method r1 = r4.getDeclaredMethod(r1, r5)     // Catch:{ Exception -> 0x0026 }
            r7.L = r1     // Catch:{ Exception -> 0x0026 }
        L_0x0026:
            android.telephony.TelephonyManager r1 = r7.a     // Catch:{ Exception -> 0x003a }
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x003a }
            java.lang.String r4 = "isNetworkRoaming"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x003a }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x003a }
            r5[r2] = r6     // Catch:{ Exception -> 0x003a }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x003a }
            r7.M = r1     // Catch:{ Exception -> 0x003a }
        L_0x003a:
            android.telephony.TelephonyManager r1 = r7.a     // Catch:{ Exception -> 0x004e }
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x004e }
            java.lang.String r4 = "getNetworkOperatorForSubscription"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x004e }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x004e }
            r5[r2] = r6     // Catch:{ Exception -> 0x004e }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x004e }
            r7.Q = r1     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            android.telephony.TelephonyManager r1 = r7.a     // Catch:{ Exception -> 0x0069 }
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x0069 }
            r4 = 0
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r0, r4)     // Catch:{ Exception -> 0x0069 }
            int r4 = r1.getModifiers()     // Catch:{ Exception -> 0x0069 }
            boolean r4 = java.lang.reflect.Modifier.isAbstract(r4)     // Catch:{ Exception -> 0x0069 }
            if (r4 != 0) goto L_0x006a
            r7.t = r1     // Catch:{ Exception -> 0x0069 }
            r1.setAccessible(r3)     // Catch:{ Exception -> 0x0069 }
            goto L_0x006a
        L_0x0069:
        L_0x006a:
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r1 > r4) goto L_0x00cb
            android.telephony.TelephonyManager r1 = r7.a     // Catch:{ Exception -> 0x0084 }
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x0084 }
            java.lang.String r4 = "getNetworkType"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0084 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0084 }
            r5[r2] = r6     // Catch:{ Exception -> 0x0084 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0084 }
            r7.N = r1     // Catch:{ Exception -> 0x0084 }
        L_0x0084:
            android.telephony.TelephonyManager r1 = r7.a     // Catch:{ Exception -> 0x0098 }
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = "getNetworkOperatorName"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0098 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0098 }
            r5[r2] = r6     // Catch:{ Exception -> 0x0098 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0098 }
            r7.O = r1     // Catch:{ Exception -> 0x0098 }
        L_0x0098:
            android.telephony.TelephonyManager r1 = r7.a     // Catch:{ Exception -> 0x00ac }
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "getNetworkOperator"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00ac }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00ac }
            r5[r2] = r6     // Catch:{ Exception -> 0x00ac }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x00ac }
            r7.P = r1     // Catch:{ Exception -> 0x00ac }
        L_0x00ac:
            android.telephony.TelephonyManager r1 = r7.a     // Catch:{ Exception -> 0x00cb }
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x00cb }
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00cb }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00cb }
            r4[r2] = r5     // Catch:{ Exception -> 0x00cb }
            java.lang.reflect.Method r0 = r1.getDeclaredMethod(r0, r4)     // Catch:{ Exception -> 0x00cb }
            int r1 = r0.getModifiers()     // Catch:{ Exception -> 0x00cb }
            boolean r1 = java.lang.reflect.Modifier.isAbstract(r1)     // Catch:{ Exception -> 0x00cb }
            if (r1 != 0) goto L_0x00cb
            r7.u = r0     // Catch:{ Exception -> 0x00cb }
            r0.setAccessible(r3)     // Catch:{ Exception -> 0x00cb }
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.l7.w():void");
    }

    /* access modifiers changed from: private */
    public void x() {
        if (Build.VERSION.SDK_INT >= 22) {
            this.h = new f();
        }
    }

    private void y() {
        this.b = new SparseArray<>();
        int i2 = 0;
        while (true) {
            int[] iArr = this.S;
            if (i2 < iArr.length) {
                SparseArray<TelephonyManager> sparseArray = this.b;
                int i3 = iArr[i2];
                sparseArray.put(i3, this.a.createForSubscriptionId(i3));
                i2++;
            } else {
                return;
            }
        }
    }

    public void A() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new k());
    }

    public Future<g[]> f() {
        return ThreadManager.getInstance().getCachedThreadPool().submit(new b());
    }

    public Future<z0[]> g() {
        return ThreadManager.getInstance().getCachedThreadPool().submit(new a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x046f  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0498  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x049c  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.umlaut.crowd.internal.DRI h() {
        /*
            r17 = this;
            r1 = r17
            com.umlaut.crowd.internal.DRI r2 = new com.umlaut.crowd.internal.DRI
            r2.<init>()
            android.telephony.TelephonyManager r0 = r1.a
            if (r0 == 0) goto L_0x049f
            android.content.Context r0 = r1.c
            android.util.SparseArray r0 = r1.a((android.content.Context) r0)
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            com.umlaut.crowd.internal.z6 r0 = (com.umlaut.crowd.internal.z6) r0
            if (r0 == 0) goto L_0x001c
            r2.PreferredNetwork = r0
        L_0x001c:
            r4 = 3
            r5 = 1
            android.telephony.TelephonyManager r0 = r1.a     // Catch:{ SecurityException -> 0x0046 }
            int r0 = r0.getDataState()     // Catch:{ SecurityException -> 0x0046 }
            if (r0 == 0) goto L_0x0041
            if (r0 == r5) goto L_0x003c
            r6 = 2
            if (r0 == r6) goto L_0x0037
            if (r0 == r4) goto L_0x0032
            com.umlaut.crowd.internal.t1 r0 = com.umlaut.crowd.internal.t1.Unknown     // Catch:{ SecurityException -> 0x0046 }
            r2.MobileDataConnectionState = r0     // Catch:{ SecurityException -> 0x0046 }
            goto L_0x005e
        L_0x0032:
            com.umlaut.crowd.internal.t1 r0 = com.umlaut.crowd.internal.t1.Suspended     // Catch:{ SecurityException -> 0x0046 }
            r2.MobileDataConnectionState = r0     // Catch:{ SecurityException -> 0x0046 }
            goto L_0x005e
        L_0x0037:
            com.umlaut.crowd.internal.t1 r0 = com.umlaut.crowd.internal.t1.Connected     // Catch:{ SecurityException -> 0x0046 }
            r2.MobileDataConnectionState = r0     // Catch:{ SecurityException -> 0x0046 }
            goto L_0x005e
        L_0x003c:
            com.umlaut.crowd.internal.t1 r0 = com.umlaut.crowd.internal.t1.Connecting     // Catch:{ SecurityException -> 0x0046 }
            r2.MobileDataConnectionState = r0     // Catch:{ SecurityException -> 0x0046 }
            goto L_0x005e
        L_0x0041:
            com.umlaut.crowd.internal.t1 r0 = com.umlaut.crowd.internal.t1.Disconnected     // Catch:{ SecurityException -> 0x0046 }
            r2.MobileDataConnectionState = r0     // Catch:{ SecurityException -> 0x0046 }
            goto L_0x005e
        L_0x0046:
            r0 = move-exception
            java.lang.String r6 = W
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "getRadioInfo: getDataState: "
            r7.<init>(r8)
            java.lang.String r0 = r0.toString()
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            android.util.Log.e(r6, r0)
        L_0x005e:
            boolean r0 = r17.n()
            if (r0 == 0) goto L_0x0067
            com.umlaut.crowd.internal.y2 r0 = com.umlaut.crowd.internal.y2.Enabled
            goto L_0x0069
        L_0x0067:
            com.umlaut.crowd.internal.y2 r0 = com.umlaut.crowd.internal.y2.Disabled
        L_0x0069:
            r2.FlightMode = r0
            com.umlaut.crowd.enums.ThreeState r0 = com.umlaut.crowd.enums.ThreeState.Unknown
            r2.MobileDataEnabled = r0
            java.lang.reflect.Method r0 = r1.K
            java.lang.String r6 = "getRadioInfo: MobileDataEnabled: "
            if (r0 == 0) goto L_0x00a4
            android.telephony.TelephonyManager r7 = r1.a     // Catch:{ Exception -> 0x008d }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x008d }
            java.lang.Object r0 = r0.invoke(r7, r8)     // Catch:{ Exception -> 0x008d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x008d }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x008d }
            if (r0 == 0) goto L_0x0088
            com.umlaut.crowd.enums.ThreeState r0 = com.umlaut.crowd.enums.ThreeState.Enabled     // Catch:{ Exception -> 0x008d }
            goto L_0x008a
        L_0x0088:
            com.umlaut.crowd.enums.ThreeState r0 = com.umlaut.crowd.enums.ThreeState.Disabled     // Catch:{ Exception -> 0x008d }
        L_0x008a:
            r2.MobileDataEnabled = r0     // Catch:{ Exception -> 0x008d }
            goto L_0x00cc
        L_0x008d:
            r0 = move-exception
            java.lang.String r7 = W
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r6)
            java.lang.String r0 = r0.toString()
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            android.util.Log.e(r7, r0)
            goto L_0x00cc
        L_0x00a4:
            android.content.ContentResolver r0 = r1.R     // Catch:{ all -> 0x00b6 }
            java.lang.String r7 = "mobile_data"
            int r0 = android.provider.Settings.Global.getInt(r0, r7)     // Catch:{ all -> 0x00b6 }
            if (r0 != r5) goto L_0x00b1
            com.umlaut.crowd.enums.ThreeState r0 = com.umlaut.crowd.enums.ThreeState.Enabled     // Catch:{ all -> 0x00b6 }
            goto L_0x00b3
        L_0x00b1:
            com.umlaut.crowd.enums.ThreeState r0 = com.umlaut.crowd.enums.ThreeState.Disabled     // Catch:{ all -> 0x00b6 }
        L_0x00b3:
            r2.MobileDataEnabled = r0     // Catch:{ all -> 0x00b6 }
            goto L_0x00cc
        L_0x00b6:
            r0 = move-exception
            java.lang.String r7 = W
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r6)
            java.lang.String r0 = r0.toString()
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            android.util.Log.e(r7, r0)
        L_0x00cc:
            android.telephony.TelephonyManager r0 = r1.a
            boolean r0 = r0.isNetworkRoaming()
            r2.IsRoaming = r0
            com.umlaut.crowd.internal.tb r0 = r17.p()
            r2.IsMetered = r0
            com.umlaut.crowd.internal.tb r0 = r17.o()
            int r0 = com.umlaut.crowd.internal.i1.a((com.umlaut.crowd.internal.tb) r0)
            r2.IsVpn = r0
            com.umlaut.crowd.enums.ConnectionTypes r0 = r17.e()
            r2.ConnectionType = r0
            com.umlaut.crowd.internal.l7$o r0 = r1.g
            r6 = -1
            int r0 = r0.d(r6)
            com.umlaut.crowd.enums.NetworkTypes r0 = e((int) r0)
            r2.DisplayNetworkType = r0
            com.umlaut.crowd.enums.NetworkTypes r0 = r2.NetworkType
            com.umlaut.crowd.enums.NetworkTypes r7 = com.umlaut.crowd.enums.NetworkTypes.Unknown
            if (r0 != r7) goto L_0x0130
            int r0 = android.os.Build.VERSION.SDK_INT
            r7 = 30
            if (r0 < r7) goto L_0x010b
            android.content.Context r0 = r1.c
            boolean r0 = com.umlaut.crowd.utils.PermissionUtils.hasReadPhoneStatePermission(r0)
            if (r0 == 0) goto L_0x0130
        L_0x010b:
            android.telephony.TelephonyManager r0 = r1.a     // Catch:{ Exception -> 0x0118 }
            int r0 = r0.getNetworkType()     // Catch:{ Exception -> 0x0118 }
            com.umlaut.crowd.enums.NetworkTypes r0 = d((int) r0)     // Catch:{ Exception -> 0x0118 }
            r2.NetworkType = r0     // Catch:{ Exception -> 0x0118 }
            goto L_0x0130
        L_0x0118:
            r0 = move-exception
            java.lang.String r7 = W
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "getRadioInfo: getNetworkType:"
            r8.<init>(r9)
            java.lang.String r0 = r0.toString()
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            android.util.Log.e(r7, r0)
        L_0x0130:
            com.umlaut.crowd.enums.NetworkTypes r0 = r2.NetworkType
            com.umlaut.crowd.enums.NetworkTypes r7 = com.umlaut.crowd.enums.NetworkTypes.Unknown
            if (r0 != r7) goto L_0x0142
            com.umlaut.crowd.internal.l7$o r0 = r1.g
            int r0 = r0.c(r6)
            com.umlaut.crowd.enums.NetworkTypes r0 = d((int) r0)
            r2.NetworkType = r0
        L_0x0142:
            android.telephony.TelephonyManager r0 = r1.a
            java.lang.String r0 = r0.getNetworkOperatorName()
            java.lang.String r0 = com.umlaut.crowd.internal.aa.a((java.lang.String) r0)
            r2.OperatorName = r0
            android.telephony.TelephonyManager r0 = r1.a
            java.lang.String r0 = r0.getNetworkOperator()
            if (r0 == 0) goto L_0x0169
            int r7 = r0.length()
            r8 = 4
            if (r7 <= r8) goto L_0x0169
            java.lang.String r7 = r0.substring(r3, r4)
            r2.MCC = r7
            java.lang.String r0 = r0.substring(r4)
            r2.MNC = r0
        L_0x0169:
            com.umlaut.crowd.internal.j6[] r4 = r1.h((int) r6)
            com.umlaut.crowd.internal.l7$o r0 = r1.g
            com.umlaut.crowd.internal.l7$s r7 = r0.f(r6)
            int r0 = r7.e
            r2.ARFCN = r0
            com.umlaut.crowd.internal.l7$o r0 = r1.g
            com.umlaut.crowd.internal.l7$n r0 = r0.a((int) r6)
            if (r0 != 0) goto L_0x0185
            com.umlaut.crowd.internal.l7$n r0 = new com.umlaut.crowd.internal.l7$n
            r8 = 0
            r0.<init>(r1, r8)
        L_0x0185:
            r8 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r9 = 29
            if (r0 >= r9) goto L_0x0196
            android.content.Context r0 = r1.c
            java.lang.String r9 = "android.permission.ACCESS_COARSE_LOCATION"
            int r0 = r0.checkCallingOrSelfPermission(r9)
            if (r0 == 0) goto L_0x01b4
        L_0x0196:
            android.content.Context r0 = r1.c
            java.lang.String r9 = "android.permission.ACCESS_FINE_LOCATION"
            int r0 = r0.checkCallingOrSelfPermission(r9)
            if (r0 != 0) goto L_0x01da
            com.umlaut.crowd.internal.d3 r0 = com.umlaut.crowd.InsightCore.getForegroundTestManager()
            int r0 = r0.d()
            if (r0 == r5) goto L_0x01b4
            android.content.Context r0 = r1.c
            java.lang.String r9 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            int r0 = r0.checkCallingOrSelfPermission(r9)
            if (r0 != 0) goto L_0x01da
        L_0x01b4:
            android.telephony.CellLocation r0 = r8.a
            if (r0 != 0) goto L_0x01dc
            android.telephony.TelephonyManager r0 = r1.a     // Catch:{ Exception -> 0x01c1 }
            android.telephony.CellLocation r0 = r0.getCellLocation()     // Catch:{ Exception -> 0x01c1 }
            r8.a = r0     // Catch:{ Exception -> 0x01c1 }
            goto L_0x01dc
        L_0x01c1:
            r0 = move-exception
            java.lang.String r5 = W
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "getRadioInfo: getCellLocation:"
            r9.<init>(r10)
            java.lang.String r0 = r0.toString()
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            android.util.Log.e(r5, r0)
            goto L_0x01dc
        L_0x01da:
            r2.MissingPermission = r5
        L_0x01dc:
            android.telephony.CellLocation r0 = r8.a
            r9 = 0
            r11 = 2147483647(0x7fffffff, double:1.060997895E-314)
            java.lang.String r13 = ""
            if (r0 == 0) goto L_0x02dc
            long r14 = r8.b
            long r5 = r8.g
            int r16 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r16 <= 0) goto L_0x02dc
            java.lang.Class r0 = r0.getClass()
            java.lang.Class<android.telephony.gsm.GsmCellLocation> r5 = android.telephony.gsm.GsmCellLocation.class
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0244
            android.telephony.CellLocation r0 = r8.a
            android.telephony.gsm.GsmCellLocation r0 = (android.telephony.gsm.GsmCellLocation) r0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r0.getLac()
            r5.append(r6)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r2.GsmLAC = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r0.getCid()
            r5.append(r6)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r2.GsmCellId = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r0 = r0.getPsc()
            r5.append(r0)
            r5.append(r13)
            java.lang.String r0 = r5.toString()
            r2.PrimaryScramblingCode = r0
            com.umlaut.crowd.internal.y0 r0 = com.umlaut.crowd.internal.y0.Default
            r2.GsmCellIdSource = r0
            goto L_0x02c3
        L_0x0244:
            android.telephony.CellLocation r0 = r8.a
            java.lang.Class r0 = r0.getClass()
            java.lang.Class<android.telephony.cdma.CdmaCellLocation> r5 = android.telephony.cdma.CdmaCellLocation.class
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x02c3
            android.telephony.CellLocation r0 = r8.a
            android.telephony.cdma.CdmaCellLocation r0 = (android.telephony.cdma.CdmaCellLocation) r0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r0.getBaseStationId()
            r5.append(r6)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r2.CdmaBaseStationId = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r0.getBaseStationLatitude()
            r5.append(r6)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r2.CdmaBaseStationLatitude = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r0.getBaseStationLongitude()
            r5.append(r6)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r2.CdmaBaseStationLongitude = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r0.getNetworkId()
            r5.append(r6)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r2.CdmaNetworkId = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r0 = r0.getSystemId()
            r5.append(r0)
            r5.append(r13)
            java.lang.String r0 = r5.toString()
            r2.CdmaSystemId = r0
            com.umlaut.crowd.internal.y0 r0 = com.umlaut.crowd.internal.y0.Default
            r2.GsmCellIdSource = r0
        L_0x02c3:
            long r5 = r8.b
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0312
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r14 = r8.b
            long r5 = r5 - r14
            int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x02d8
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02d9
        L_0x02d8:
            int r0 = (int) r5
        L_0x02d9:
            r2.GsmCellIdAge = r0
            goto L_0x0312
        L_0x02dc:
            java.lang.String r0 = r8.c
            if (r0 == 0) goto L_0x0312
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0312
            java.lang.String r0 = r8.c
            r2.GsmCellId = r0
            java.lang.String r0 = r8.d
            r2.GsmLAC = r0
            int r0 = r8.f
            r2.ARFCN = r0
            int r0 = r8.e
            r2.LtePci = r0
            com.umlaut.crowd.internal.y0 r0 = com.umlaut.crowd.internal.y0.Samsung
            r2.GsmCellIdSource = r0
            long r5 = r8.g
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0312
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r14 = r8.g
            long r5 = r5 - r14
            int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x030f
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0310
        L_0x030f:
            int r0 = (int) r5
        L_0x0310:
            r2.GsmCellIdAge = r0
        L_0x0312:
            if (r4 == 0) goto L_0x0376
            int r5 = r4.length
            r6 = 0
        L_0x0316:
            if (r6 >= r5) goto L_0x0376
            r0 = r4[r6]
            com.umlaut.crowd.internal.i2 r8 = r0.Domain
            com.umlaut.crowd.internal.i2 r14 = com.umlaut.crowd.internal.i2.CS
            if (r8 != r14) goto L_0x0373
            java.lang.String r8 = r2.GsmCellId
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x0340
            java.lang.String r8 = r0.CellId
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x0340
            java.lang.String r8 = r0.CellId
            r2.GsmCellId = r8
            java.lang.String r8 = r0.Tac
            r2.GsmLAC = r8
            int r8 = r0.Age
            r2.GsmCellIdAge = r8
            com.umlaut.crowd.internal.y0 r8 = com.umlaut.crowd.internal.y0.Default
            r2.GsmCellIdSource = r8
        L_0x0340:
            java.lang.String r8 = r2.GsmCellId
            java.lang.String r14 = r0.CellId
            boolean r8 = r8.equals(r14)
            if (r8 == 0) goto L_0x0373
            java.lang.String r8 = r0.Pci
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x0373
            java.lang.String r0 = r0.Pci     // Catch:{ NumberFormatException -> 0x035b }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x035b }
            r2.LtePci = r0     // Catch:{ NumberFormatException -> 0x035b }
            goto L_0x0373
        L_0x035b:
            r0 = move-exception
            java.lang.String r8 = W
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "getRadioInfo: parseInt:"
            r14.<init>(r15)
            java.lang.String r0 = r0.toString()
            r14.append(r0)
            java.lang.String r0 = r14.toString()
            android.util.Log.d(r8, r0)
        L_0x0373:
            int r6 = r6 + 1
            goto L_0x0316
        L_0x0376:
            com.umlaut.crowd.internal.g9 r0 = r7.a
            r2.ServiceState = r0
            com.umlaut.crowd.internal.j2 r0 = r7.c
            r2.DuplexMode = r0
            java.lang.String r0 = r7.g
            r2.Bandwidth = r0
            com.umlaut.crowd.internal.tb r0 = r7.d
            r2.ManualSelection = r0
            com.umlaut.crowd.internal.tb r0 = r7.f
            r2.CarrierAggregation = r0
            long r5 = r7.b
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x03a2
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r7 = r7.b
            long r5 = r5 - r7
            int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x039f
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x03a0
        L_0x039f:
            int r0 = (int) r5
        L_0x03a0:
            r2.ServiceStateAge = r0
        L_0x03a2:
            com.umlaut.crowd.internal.o6 r0 = c((com.umlaut.crowd.internal.j6[]) r4)
            r2.NrState = r0
            com.umlaut.crowd.internal.tb r0 = r1.d((com.umlaut.crowd.internal.j6[]) r4)
            r2.NrAvailable = r0
            com.umlaut.crowd.enums.NetworkTypes r0 = r2.NetworkType
            com.umlaut.crowd.enums.NetworkTypes r5 = com.umlaut.crowd.enums.NetworkTypes.Unknown
            if (r0 != r5) goto L_0x03ba
            com.umlaut.crowd.enums.NetworkTypes r0 = r1.b((com.umlaut.crowd.internal.j6[]) r4)
            r2.NetworkType = r0
        L_0x03ba:
            com.umlaut.crowd.internal.l7$o r0 = r1.g
            r5 = -1
            com.umlaut.crowd.internal.l7$t r6 = r0.g(r5)
            int r0 = r6.k
            r2.RSCP = r0
            int r0 = r6.c
            r2.CdmaEcIo = r0
            int r0 = r6.a
            r2.RXLevel = r0
            int r5 = r6.b
            r2.NativeDbm = r5
            int r5 = r6.i
            r2.GsmBitErrorRate = r5
            int r5 = r6.j
            r2.EcN0 = r5
            int r5 = r6.d
            r2.LteCqi = r5
            int r5 = r6.e
            r2.LteRsrp = r5
            int r7 = r6.g
            r2.LteRsrq = r7
            int r7 = r6.f
            r2.LteRssnr = r7
            int r7 = r6.h
            r2.LteRssi = r7
            int r7 = r6.m
            r2.NrCsiRsrp = r7
            int r7 = r6.n
            r2.NrCsiRsrq = r7
            int r7 = r6.o
            r2.NrCsiSinr = r7
            int r7 = r6.p
            r2.NrSsRsrp = r7
            int r7 = r6.q
            r2.NrSsRsrq = r7
            int r7 = r6.r
            r2.NrSsSinr = r7
            com.umlaut.crowd.enums.NetworkTypes r7 = r2.NetworkType
            com.umlaut.crowd.enums.NetworkTypes r8 = com.umlaut.crowd.enums.NetworkTypes.LTE
            if (r7 == r8) goto L_0x040f
            com.umlaut.crowd.enums.NetworkTypes r9 = com.umlaut.crowd.enums.NetworkTypes.LTE_CA
            if (r7 != r9) goto L_0x0414
        L_0x040f:
            r9 = -1
            if (r0 <= r9) goto L_0x0414
            r2.RXLevel = r5
        L_0x0414:
            com.umlaut.crowd.enums.NetworkTypes r0 = com.umlaut.crowd.enums.NetworkTypes.LTE_CA
            if (r7 != r0) goto L_0x041c
            com.umlaut.crowd.internal.tb r0 = com.umlaut.crowd.internal.tb.Yes
            r2.CarrierAggregation = r0
        L_0x041c:
            com.umlaut.crowd.internal.tb r0 = r2.CarrierAggregation
            com.umlaut.crowd.internal.tb r5 = com.umlaut.crowd.internal.tb.Unknown
            if (r0 != r5) goto L_0x0428
            com.umlaut.crowd.internal.tb r0 = r1.a((com.umlaut.crowd.internal.j6[]) r4)
            r2.CarrierAggregation = r0
        L_0x0428:
            com.umlaut.crowd.enums.NetworkTypes r0 = r2.NetworkType
            if (r0 == r8) goto L_0x0430
            com.umlaut.crowd.enums.NetworkTypes r4 = com.umlaut.crowd.enums.NetworkTypes.NR
            if (r0 != r4) goto L_0x048d
        L_0x0430:
            java.lang.String r0 = r2.MCC     // Catch:{ NumberFormatException -> 0x043f }
            int r4 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x043f }
            java.lang.String r0 = r2.MNC     // Catch:{ NumberFormatException -> 0x043d }
            int r3 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x043d }
            goto L_0x0458
        L_0x043d:
            r0 = move-exception
            goto L_0x0441
        L_0x043f:
            r0 = move-exception
            r4 = 0
        L_0x0441:
            java.lang.String r5 = W
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "radioInfo: "
            r7.<init>(r8)
            java.lang.String r0 = r0.getMessage()
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            android.util.Log.d(r5, r0)
        L_0x0458:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r13)
            r0.append(r4)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.umlaut.crowd.internal.l7$o r3 = r1.g
            com.umlaut.crowd.internal.l7$q r0 = r3.a((java.lang.String) r0)
            if (r0 == 0) goto L_0x048d
            long r3 = r0.a
            r2.NrCellId = r3
            int r3 = r0.b
            r2.NrTac = r3
            int r3 = r0.c
            r2.NrPci = r3
            int r3 = r0.e
            r2.NrARFCN = r3
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r7 = r0.d
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r7 / r9
            long r3 = r3 - r7
            int r0 = (int) r3
            r2.NrCellIdAge = r0
        L_0x048d:
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r5 = r6.l
            long r3 = r3 - r5
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x049c
            r5 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x049d
        L_0x049c:
            int r5 = (int) r3
        L_0x049d:
            r2.RXLevelAge = r5
        L_0x049f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.l7.h():com.umlaut.crowd.internal.DRI");
    }

    public DRI i() {
        return i(this.i.DefaultSmsSimId);
    }

    public DRI j() {
        return i(this.i.DefaultVoiceSimId);
    }

    public boolean k(int i2) {
        Method method = this.M;
        if (method == null) {
            return q();
        }
        try {
            return ((Boolean) method.invoke(this.a, new Object[]{Integer.valueOf(i2)})).booleanValue();
        } catch (Exception e2) {
            String str = W;
            Log.e(str, "isRoaming: " + e2.toString());
            return q();
        }
    }

    public boolean m() {
        ConnectivityManager connectivityManager;
        LinkProperties linkProperties;
        if (Build.VERSION.SDK_INT < 23 || this.c.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (connectivityManager = this.f) == null) {
            try {
                g[] b2 = b();
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    Iterator<InterfaceAddress> it = nextElement.getInterfaceAddresses().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            InetAddress address = it.next().getAddress();
                            if ((address instanceof Inet6Address) && !address.isSiteLocalAddress() && !address.isLinkLocalAddress() && !address.isLoopbackAddress() && !a(nextElement, b2)) {
                                return true;
                            }
                        }
                    }
                }
            } catch (NullPointerException | SocketException unused) {
            }
            return false;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (!(activeNetwork == null || (linkProperties = this.f.getLinkProperties(activeNetwork)) == null || linkProperties.getLinkAddresses() == null)) {
            for (LinkAddress address2 : linkProperties.getLinkAddresses()) {
                InetAddress address3 = address2.getAddress();
                if ((address3 instanceof Inet6Address) && !address3.isSiteLocalAddress() && !address3.isLinkLocalAddress() && !address3.isLoopbackAddress()) {
                    return true;
                }
            }
        }
        return false;
    }

    public tb o() {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        tb tbVar = tb.Unknown;
        if (Build.VERSION.SDK_INT < 23 || this.c.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (connectivityManager = this.f) == null || (networkCapabilities = this.f.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
            return tbVar;
        }
        return networkCapabilities.hasTransport(4) ? tb.Yes : tb.No;
    }

    public tb p() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        int i2 = Build.VERSION.SDK_INT;
        if (this.c.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return tb.Unknown;
        }
        boolean isActiveNetworkMetered = this.f.isActiveNetworkMetered();
        if (!(i2 < 30 || (activeNetwork = this.f.getActiveNetwork()) == null || (networkCapabilities = this.f.getNetworkCapabilities(activeNetwork)) == null)) {
            isActiveNetworkMetered = !networkCapabilities.hasCapability(11) && !networkCapabilities.hasCapability(25);
        }
        return isActiveNetworkMetered ? tb.Yes : tb.No;
    }

    public boolean q() {
        return this.a.isNetworkRoaming();
    }

    public void r() {
        if (!this.V) {
            this.V = true;
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new g());
        }
    }

    public void z() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new i());
    }

    private class u extends PhoneStateListener {
        private Field a;
        private int b;

        class a implements Runnable {
            final /* synthetic */ SignalStrength a;
            final /* synthetic */ int b;

            a(SignalStrength signalStrength, int i) {
                this.a = signalStrength;
                this.b = i;
            }

            public void run() {
                u.this.a(this.a, this.b);
            }
        }

        class b implements Runnable {
            final /* synthetic */ ServiceState a;
            final /* synthetic */ int b;

            b(ServiceState serviceState, int i) {
                this.a = serviceState;
                this.b = i;
            }

            public void run() {
                u.this.a(this.a, this.b);
            }
        }

        class c implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ TelephonyDisplayInfo b;

            c(int i, TelephonyDisplayInfo telephonyDisplayInfo) {
                this.a = i;
                this.b = telephonyDisplayInfo;
            }

            public void run() {
                l7.this.g.b(this.a, this.b.getOverrideNetworkType());
                l7.this.g.a(this.a, this.b.getNetworkType());
                o6 c2 = l7.c(l7.this.g.b(this.a));
                for (m7 a2 : l7.this.U) {
                    a2.a(this.b, c2, this.a);
                }
            }
        }

        class d implements Runnable {
            final /* synthetic */ List a;

            d(List list) {
                this.a = list;
            }

            public void run() {
                u.this.a(this.a);
            }
        }

        class e implements Runnable {
            final /* synthetic */ CellLocation a;
            final /* synthetic */ int b;

            e(CellLocation cellLocation, int i) {
                this.a = cellLocation;
                this.b = i;
            }

            public void run() {
                u.this.a(this.a, this.b);
            }
        }

        public u() {
            this.b = -1;
        }

        public void onCellInfoChanged(List<CellInfo> list) {
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new d(list));
        }

        public void onCellLocationChanged(CellLocation cellLocation) {
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new e(cellLocation, a()));
        }

        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new c(a(), telephonyDisplayInfo));
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new b(serviceState, a()));
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a(signalStrength, a()));
        }

        public u(int i) {
            this.b = i;
            try {
                Field declaredField = getClass().getSuperclass().getDeclaredField("mSubId");
                this.a = declaredField;
                declaredField.setAccessible(true);
                this.a.set(this, Integer.valueOf(i));
            } catch (Exception unused) {
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0031  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a() {
            /*
                r5 = this;
                java.lang.reflect.Field r0 = r5.a
                r1 = -1
                if (r0 == 0) goto L_0x002a
                java.lang.Object r0 = r0.get(r5)     // Catch:{ IllegalAccessException -> 0x0010 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ IllegalAccessException -> 0x0010 }
                int r0 = r0.intValue()     // Catch:{ IllegalAccessException -> 0x0010 }
                goto L_0x002b
            L_0x0010:
                r0 = move-exception
                java.lang.String r2 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "getHiddenSubscriptionId: "
                r3.<init>(r4)
                java.lang.String r0 = r0.toString()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                android.util.Log.e(r2, r0)
            L_0x002a:
                r0 = -1
            L_0x002b:
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 29
                if (r2 < r3) goto L_0x003a
                if (r0 == r1) goto L_0x0038
                r1 = 2147483647(0x7fffffff, float:NaN)
                if (r0 != r1) goto L_0x003a
            L_0x0038:
                int r0 = r5.b
            L_0x003a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.l7.u.a():int");
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0098  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x009b  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.util.List<android.telephony.CellInfo> r11) {
            /*
                r10 = this;
                if (r11 != 0) goto L_0x0003
                return
            L_0x0003:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                monitor-enter(r0)
                com.umlaut.crowd.internal.l7 r1 = com.umlaut.crowd.internal.l7.this     // Catch:{ all -> 0x00c1 }
                java.util.List unused = r1.k = r11     // Catch:{ all -> 0x00c1 }
                monitor-exit(r0)     // Catch:{ all -> 0x00c1 }
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 29
                if (r0 < r1) goto L_0x00c0
                java.util.Iterator r11 = r11.iterator()
            L_0x0016:
                boolean r0 = r11.hasNext()
                if (r0 == 0) goto L_0x00c0
                java.lang.Object r0 = r11.next()
                android.telephony.CellInfo r0 = (android.telephony.CellInfo) r0
                boolean r1 = r0.isRegistered()
                if (r1 == 0) goto L_0x0016
                boolean r1 = r0 instanceof android.telephony.CellInfoNr
                if (r1 == 0) goto L_0x0016
                android.telephony.CellInfoNr r0 = (android.telephony.CellInfoNr) r0
                android.telephony.CellIdentity r1 = r0.getCellIdentity()
                boolean r2 = r1 instanceof android.telephony.CellIdentityNr
                if (r2 == 0) goto L_0x0016
                android.telephony.CellIdentityNr r1 = (android.telephony.CellIdentityNr) r1
                r2 = 0
                java.lang.String r3 = r1.getMccString()     // Catch:{ NumberFormatException -> 0x004c }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x004c }
                java.lang.String r4 = r1.getMncString()     // Catch:{ NumberFormatException -> 0x004a }
                int r2 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x004a }
                goto L_0x0068
            L_0x004a:
                r4 = move-exception
                goto L_0x004e
            L_0x004c:
                r4 = move-exception
                r3 = 0
            L_0x004e:
                java.lang.String r5 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "updateCellInfo: "
                r6.<init>(r7)
                java.lang.String r4 = r4.getMessage()
                r6.append(r4)
                java.lang.String r4 = r6.toString()
                android.util.Log.d(r5, r4)
            L_0x0068:
                long r4 = r1.getNci()
                int r6 = r1.getTac()
                int r7 = r1.getPci()
                int r1 = r1.getNrarfcn()
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r9 = ""
                r8.<init>(r9)
                r8.append(r3)
                r8.append(r2)
                java.lang.String r2 = r8.toString()
                r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
                int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r3 != 0) goto L_0x0092
                r4 = -1
            L_0x0092:
                r3 = -1
                r8 = 2147483647(0x7fffffff, float:NaN)
                if (r6 != r8) goto L_0x0099
                r6 = -1
            L_0x0099:
                if (r7 != r8) goto L_0x009c
                r7 = -1
            L_0x009c:
                if (r1 != r8) goto L_0x009f
                r1 = -1
            L_0x009f:
                com.umlaut.crowd.internal.l7$q r3 = new com.umlaut.crowd.internal.l7$q
                com.umlaut.crowd.internal.l7 r8 = com.umlaut.crowd.internal.l7.this
                r9 = 0
                r3.<init>(r8, r9)
                r3.a = r4
                r3.b = r6
                r3.c = r7
                long r4 = r0.getTimeStamp()
                r3.d = r4
                r3.e = r1
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                com.umlaut.crowd.internal.l7$o r0 = r0.g
                r0.a((java.lang.String) r2, (com.umlaut.crowd.internal.l7.q) r3)
                goto L_0x0016
            L_0x00c0:
                return
            L_0x00c1:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00c1 }
                goto L_0x00c5
            L_0x00c4:
                throw r11
            L_0x00c5:
                goto L_0x00c4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.l7.u.a(java.util.List):void");
        }

        /* access modifiers changed from: private */
        public void a(ServiceState serviceState, int i) {
            g9 g9Var;
            o6 o6Var;
            j2 j2Var;
            s sVar = new s(l7.this, (d) null);
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 25) {
                if (l7.this.F != null) {
                    try {
                        sVar.f = l7.this.F.getBoolean(serviceState) ? tb.Yes : tb.No;
                    } catch (IllegalAccessException e2) {
                        String a2 = l7.W;
                        Log.e(a2, "updateSignalStrengthData.mFieldIsUsingCarrierAggregation: " + e2.toString());
                    }
                }
                if (sVar.f == tb.Unknown && l7.this.D != null) {
                    try {
                        sVar.f = ((Boolean) l7.this.D.invoke(serviceState, new Object[0])).booleanValue() ? tb.Yes : tb.No;
                    } catch (Exception e3) {
                        String a3 = l7.W;
                        Log.e(a3, "updateSignalStrengthData.mMethodIsUsingCarrierAggregation: " + e3.toString());
                    }
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    int duplexMode = serviceState.getDuplexMode();
                    if (duplexMode == 1) {
                        j2Var = j2.FDD;
                    } else if (duplexMode != 2) {
                        j2Var = j2.Unknown;
                    } else {
                        j2Var = j2.TDD;
                    }
                    sVar.c = j2Var;
                    sVar.g = l7.this.a(serviceState.getCellBandwidths());
                    sVar.e = serviceState.getChannelNumber();
                }
            }
            sVar.d = serviceState.getIsManualSelection() ? tb.Yes : tb.No;
            int state = serviceState.getState();
            if (state == 0) {
                g9Var = g9.InService;
            } else if (state == 1) {
                g9Var = g9.OutOfService;
            } else if (state == 2) {
                g9Var = g9.EmergencyOnly;
            } else if (state != 3) {
                g9Var = g9.Unknown;
            } else {
                g9Var = g9.PowerOff;
            }
            sVar.a = g9Var;
            sVar.b = SystemClock.elapsedRealtime();
            j6[] a4 = k6.a(serviceState);
            if (l7.this.E != null && Build.VERSION.SDK_INT >= 31) {
                Iterator it = serviceState.getNetworkRegistrationInfoList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    NetworkRegistrationInfo networkRegistrationInfo = (NetworkRegistrationInfo) it.next();
                    if (networkRegistrationInfo.getDomain() == 2 && networkRegistrationInfo.getTransportType() == 1) {
                        try {
                            int intValue = ((Integer) l7.this.E.invoke(networkRegistrationInfo, new Object[0])).intValue();
                            if (intValue == 0) {
                                o6Var = o6.NONE;
                            } else if (intValue == 1) {
                                o6Var = o6.RESTRICTED;
                            } else if (intValue == 2) {
                                o6Var = o6.NOT_RESTRICTED;
                            } else if (intValue != 3) {
                                o6Var = o6.Unknown;
                            } else {
                                o6Var = o6.CONNECTED;
                            }
                            int length = a4.length;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                j6 j6Var = a4[i2];
                                if (j6Var.Domain == i2.PS && j6Var.TransportType == qc.WWAN) {
                                    j6Var.NrState = o6Var;
                                    break;
                                }
                                i2++;
                            }
                        } catch (Exception e4) {
                            String a5 = l7.W;
                            Log.e(a5, "updateSignalStrengthData.mMethodIsUsingCarrierAggregation: " + e4.toString());
                        }
                    }
                }
            }
            l7.this.g.a(i, sVar);
            l7.this.g.a(i, a4);
            for (m7 a6 : l7.this.U) {
                a6.a(serviceState, a4, i);
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:123:0x02c1  */
        /* JADX WARNING: Removed duplicated region for block: B:147:0x0390  */
        /* JADX WARNING: Removed duplicated region for block: B:150:0x039d  */
        /* JADX WARNING: Removed duplicated region for block: B:173:0x040d A[Catch:{ Exception -> 0x0424 }] */
        /* JADX WARNING: Removed duplicated region for block: B:180:0x0445 A[SYNTHETIC, Splitter:B:180:0x0445] */
        /* JADX WARNING: Removed duplicated region for block: B:209:0x052d A[Catch:{ Exception -> 0x0543 }] */
        /* JADX WARNING: Removed duplicated region for block: B:216:0x0568 A[Catch:{ Exception -> 0x057e }] */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x05aa  */
        /* JADX WARNING: Removed duplicated region for block: B:246:0x063e A[Catch:{ Exception -> 0x0653 }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:251:0x067f  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00fa  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x018a A[Catch:{ Exception -> 0x01a0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x01c5 A[Catch:{ Exception -> 0x01d9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0209  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.telephony.SignalStrength r34, int r35) {
            /*
                r33 = this;
                r1 = r33
                r2 = r34
                r3 = r35
                java.lang.Integer r0 = com.umlaut.crowd.internal.DRI.INVALID
                int r4 = r0.intValue()
                int r5 = r0.intValue()
                int r6 = r0.intValue()
                int r7 = r0.intValue()
                int r8 = r0.intValue()
                int r9 = r0.intValue()
                int r10 = r0.intValue()
                int r11 = r0.intValue()
                int r12 = r0.intValue()
                int r13 = r0.intValue()
                int r14 = r0.intValue()
                int r15 = r0.intValue()
                int r16 = r0.intValue()
                int r17 = r0.intValue()
                int r18 = r0.intValue()
                int r19 = r0.intValue()
                int r20 = r0.intValue()
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                android.util.SparseArray r0 = r0.b
                r21 = r4
                if (r0 == 0) goto L_0x0063
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                android.util.SparseArray r0 = r0.b
                java.lang.Object r0 = r0.get(r3)
                android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
                goto L_0x0064
            L_0x0063:
                r0 = 0
            L_0x0064:
                if (r0 != 0) goto L_0x006c
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                android.telephony.TelephonyManager r0 = r0.a
            L_0x006c:
                com.umlaut.crowd.enums.NetworkTypes r22 = com.umlaut.crowd.enums.NetworkTypes.Unknown
                com.umlaut.crowd.internal.l7 r4 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x00b9 }
                android.util.SparseArray r4 = r4.b     // Catch:{ Exception -> 0x00b9 }
                if (r4 != 0) goto L_0x00a8
                com.umlaut.crowd.internal.l7 r4 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x00b9 }
                java.lang.reflect.Method r4 = r4.N     // Catch:{ Exception -> 0x00b9 }
                if (r4 == 0) goto L_0x00a8
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x00b9 }
                java.lang.reflect.Method r0 = r0.N     // Catch:{ Exception -> 0x00b9 }
                com.umlaut.crowd.internal.l7 r4 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x00b9 }
                android.telephony.TelephonyManager r4 = r4.a     // Catch:{ Exception -> 0x00b9 }
                r25 = r5
                r26 = r6
                r5 = 1
                java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00b7 }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r35)     // Catch:{ Exception -> 0x00b7 }
                r24 = 0
                r6[r24] = r5     // Catch:{ Exception -> 0x00b7 }
                java.lang.Object r0 = r0.invoke(r4, r6)     // Catch:{ Exception -> 0x00b7 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x00b7 }
                int r0 = r0.intValue()     // Catch:{ Exception -> 0x00b7 }
                com.umlaut.crowd.enums.NetworkTypes r0 = com.umlaut.crowd.internal.l7.d((int) r0)     // Catch:{ Exception -> 0x00b7 }
                goto L_0x00b4
            L_0x00a8:
                r25 = r5
                r26 = r6
                int r0 = r0.getNetworkType()     // Catch:{ Exception -> 0x00b7 }
                com.umlaut.crowd.enums.NetworkTypes r0 = com.umlaut.crowd.internal.l7.d((int) r0)     // Catch:{ Exception -> 0x00b7 }
            L_0x00b4:
                r22 = r0
                goto L_0x00d8
            L_0x00b7:
                r0 = move-exception
                goto L_0x00be
            L_0x00b9:
                r0 = move-exception
                r25 = r5
                r26 = r6
            L_0x00be:
                java.lang.String r4 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r6 = "updateSignalStrengthData: "
                r5.<init>(r6)
                java.lang.String r0 = r0.getMessage()
                r5.append(r0)
                java.lang.String r0 = r5.toString()
                android.util.Log.d(r4, r0)
            L_0x00d8:
                r0 = r22
                com.umlaut.crowd.enums.NetworkTypes r4 = com.umlaut.crowd.enums.NetworkTypes.Unknown
                if (r0 != r4) goto L_0x00ee
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                com.umlaut.crowd.internal.l7$o r0 = r0.g
                com.umlaut.crowd.internal.j6[] r0 = r0.b(r3)
                com.umlaut.crowd.internal.l7 r5 = com.umlaut.crowd.internal.l7.this
                com.umlaut.crowd.enums.NetworkTypes r0 = r5.b((com.umlaut.crowd.internal.j6[]) r0)
            L_0x00ee:
                com.umlaut.crowd.internal.o6 r5 = com.umlaut.crowd.internal.o6.Unknown
                com.umlaut.crowd.enums.NetworkGenerations r4 = com.umlaut.crowd.internal.l7.a((com.umlaut.crowd.enums.NetworkTypes) r0, (com.umlaut.crowd.internal.o6) r5, (com.umlaut.crowd.enums.NetworkTypes) r4)
                int r0 = android.os.Build.VERSION.SDK_INT
                r5 = 29
                if (r0 < r5) goto L_0x0390
                java.util.List r0 = r34.getCellSignalStrengths()
                java.util.Iterator r0 = r0.iterator()
                r6 = r26
                r5 = 0
            L_0x0105:
                boolean r22 = r0.hasNext()
                if (r22 == 0) goto L_0x0379
                java.lang.Object r22 = r0.next()
                r27 = r0
                r0 = r22
                android.telephony.CellSignalStrength r0 = (android.telephony.CellSignalStrength) r0
                r22 = r5
                com.umlaut.crowd.enums.NetworkGenerations r5 = com.umlaut.crowd.enums.NetworkGenerations.Gen2
                r26 = r6
                if (r4 != r5) goto L_0x0137
                boolean r6 = r0 instanceof android.telephony.CellSignalStrengthGsm
                if (r6 == 0) goto L_0x0137
                android.telephony.CellSignalStrengthGsm r0 = (android.telephony.CellSignalStrengthGsm) r0
                int r6 = r0.getDbm()
                int r0 = r0.getBitErrorRate()
                r21 = r0
                r13 = r6
                r26 = r13
                r5 = r16
                r16 = r25
                r6 = 1
                goto L_0x0395
            L_0x0137:
                com.umlaut.crowd.enums.NetworkGenerations r6 = com.umlaut.crowd.enums.NetworkGenerations.Gen3
                if (r4 != r6) goto L_0x02d8
                boolean r6 = r0 instanceof android.telephony.CellSignalStrengthWcdma
                if (r6 == 0) goto L_0x02d8
                r5 = r0
                android.telephony.CellSignalStrengthWcdma r5 = (android.telephony.CellSignalStrengthWcdma) r5
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0163 }
                java.lang.reflect.Method r0 = r0.B     // Catch:{ Exception -> 0x0163 }
                if (r0 == 0) goto L_0x0160
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0163 }
                java.lang.reflect.Method r0 = r0.B     // Catch:{ Exception -> 0x0163 }
                r6 = 0
                java.lang.Object[] r13 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0163 }
                java.lang.Object r0 = r0.invoke(r5, r13)     // Catch:{ Exception -> 0x0163 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x0163 }
                int r6 = r0.intValue()     // Catch:{ Exception -> 0x0163 }
                r28 = r7
                goto L_0x0182
            L_0x0160:
                r28 = r7
                goto L_0x0180
            L_0x0163:
                r0 = move-exception
                java.lang.String r6 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r28 = r7
                java.lang.String r7 = "updateSignalStrengthData.cellSignalStrengthWcdma.getRssi: "
                r13.<init>(r7)
                java.lang.String r0 = r0.toString()
                r13.append(r0)
                java.lang.String r0 = r13.toString()
                android.util.Log.e(r6, r0)
            L_0x0180:
                r6 = r26
            L_0x0182:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x01a0 }
                java.lang.reflect.Method r0 = r0.A     // Catch:{ Exception -> 0x01a0 }
                if (r0 == 0) goto L_0x019d
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x01a0 }
                java.lang.reflect.Method r0 = r0.A     // Catch:{ Exception -> 0x01a0 }
                r7 = 0
                java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x01a0 }
                java.lang.Object r0 = r0.invoke(r5, r13)     // Catch:{ Exception -> 0x01a0 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x01a0 }
                int r14 = r0.intValue()     // Catch:{ Exception -> 0x01a0 }
            L_0x019d:
                r22 = r6
                goto L_0x01bd
            L_0x01a0:
                r0 = move-exception
                java.lang.String r7 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r22 = r6
                java.lang.String r6 = "updateSignalStrengthData.cellSignalStrengthWcdma.getRscp: "
                r13.<init>(r6)
                java.lang.String r0 = r0.toString()
                r13.append(r0)
                java.lang.String r0 = r13.toString()
                android.util.Log.e(r7, r0)
            L_0x01bd:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x01d9 }
                java.lang.reflect.Method r0 = r0.C     // Catch:{ Exception -> 0x01d9 }
                if (r0 == 0) goto L_0x01f4
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x01d9 }
                java.lang.reflect.Method r0 = r0.C     // Catch:{ Exception -> 0x01d9 }
                r6 = 0
                java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x01d9 }
                java.lang.Object r0 = r0.invoke(r5, r7)     // Catch:{ Exception -> 0x01d9 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x01d9 }
                int r12 = r0.intValue()     // Catch:{ Exception -> 0x01d9 }
                goto L_0x01f4
            L_0x01d9:
                r0 = move-exception
                java.lang.String r6 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r13 = "updateSignalStrengthData.cellSignalStrengthWcdma.getEcNo: "
                r7.<init>(r13)
                java.lang.String r0 = r0.toString()
                r7.append(r0)
                java.lang.String r0 = r7.toString()
                android.util.Log.e(r6, r0)
            L_0x01f4:
                java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x02a5 }
                java.lang.String r6 = " "
                java.lang.String[] r0 = r0.split(r6)     // Catch:{ Exception -> 0x02a5 }
                int r6 = r0.length     // Catch:{ Exception -> 0x02a5 }
                r29 = r8
                r13 = r12
                r7 = r21
                r12 = r22
                r8 = 0
            L_0x0207:
                if (r8 >= r6) goto L_0x029f
                r26 = r6
                r6 = r0[r8]     // Catch:{ Exception -> 0x0298 }
                r27 = r0
                java.lang.String r0 = "="
                java.lang.String[] r0 = r6.split(r0)     // Catch:{ Exception -> 0x0298 }
                r30 = r9
                r6 = 0
                r9 = r0[r6]     // Catch:{ Exception -> 0x0296 }
                int r6 = r0.length     // Catch:{ Exception -> 0x0296 }
                r31 = r10
                r10 = 1
                if (r6 <= r10) goto L_0x0238
                java.lang.String r6 = "ss"
                boolean r6 = r9.equals(r6)     // Catch:{ Exception -> 0x0288 }
                if (r6 == 0) goto L_0x023a
                java.lang.Integer r6 = com.umlaut.crowd.internal.DRI.INVALID     // Catch:{ Exception -> 0x0288 }
                int r6 = r6.intValue()     // Catch:{ Exception -> 0x0288 }
                if (r12 != r6) goto L_0x023a
                r0 = r0[r10]     // Catch:{ Exception -> 0x0288 }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0288 }
                r12 = r0
            L_0x0238:
                r6 = 1
                goto L_0x028a
            L_0x023a:
                java.lang.String r6 = "rscp"
                boolean r6 = r9.equals(r6)     // Catch:{ Exception -> 0x0288 }
                if (r6 == 0) goto L_0x0256
                java.lang.Integer r6 = com.umlaut.crowd.internal.DRI.INVALID     // Catch:{ Exception -> 0x0288 }
                int r6 = r6.intValue()     // Catch:{ Exception -> 0x0288 }
                if (r14 != r6) goto L_0x0256
                r6 = 1
                r0 = r0[r6]     // Catch:{ Exception -> 0x0253 }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0288 }
                r14 = r0
                goto L_0x0238
            L_0x0253:
                r0 = move-exception
                goto L_0x02b2
            L_0x0256:
                java.lang.String r6 = "ecno"
                boolean r6 = r9.equals(r6)     // Catch:{ Exception -> 0x0288 }
                if (r6 == 0) goto L_0x026f
                java.lang.Integer r6 = com.umlaut.crowd.internal.DRI.INVALID     // Catch:{ Exception -> 0x0288 }
                int r6 = r6.intValue()     // Catch:{ Exception -> 0x0288 }
                if (r13 != r6) goto L_0x026f
                r6 = 1
                r0 = r0[r6]     // Catch:{ Exception -> 0x0253 }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0288 }
                r13 = r0
                goto L_0x0238
            L_0x026f:
                java.lang.String r6 = "ber"
                boolean r6 = r9.equals(r6)     // Catch:{ Exception -> 0x0288 }
                if (r6 == 0) goto L_0x0238
                java.lang.Integer r6 = com.umlaut.crowd.internal.DRI.INVALID     // Catch:{ Exception -> 0x0288 }
                int r6 = r6.intValue()     // Catch:{ Exception -> 0x0288 }
                if (r7 != r6) goto L_0x0238
                r6 = 1
                r0 = r0[r6]     // Catch:{ Exception -> 0x0253 }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0253 }
                r7 = r0
                goto L_0x028a
            L_0x0288:
                r0 = move-exception
                goto L_0x029d
            L_0x028a:
                int r8 = r8 + 1
                r6 = r26
                r0 = r27
                r9 = r30
                r10 = r31
                goto L_0x0207
            L_0x0296:
                r0 = move-exception
                goto L_0x029b
            L_0x0298:
                r0 = move-exception
                r30 = r9
            L_0x029b:
                r31 = r10
            L_0x029d:
                r6 = 1
                goto L_0x02b2
            L_0x029f:
                r30 = r9
                r31 = r10
                r6 = 1
                goto L_0x02b5
            L_0x02a5:
                r0 = move-exception
                r29 = r8
                r30 = r9
                r31 = r10
                r6 = 1
                r13 = r12
                r7 = r21
                r12 = r22
            L_0x02b2:
                r0.printStackTrace()
            L_0x02b5:
                int r0 = r5.getDbm()
                java.lang.Integer r5 = com.umlaut.crowd.internal.DRI.INVALID
                int r5 = r5.intValue()
                if (r12 != r5) goto L_0x02c2
                r12 = r0
            L_0x02c2:
                r21 = r7
                r26 = r12
                r12 = r13
                r5 = r16
                r7 = r17
                r16 = r25
                r17 = r28
                r8 = r29
                r9 = r30
                r10 = r31
                r13 = r0
                goto L_0x039b
            L_0x02d8:
                r28 = r7
                r29 = r8
                r30 = r9
                r31 = r10
                r6 = 1
                com.umlaut.crowd.enums.NetworkGenerations r7 = com.umlaut.crowd.enums.NetworkGenerations.Gen4
                if (r4 != r7) goto L_0x0309
                boolean r8 = r0 instanceof android.telephony.CellSignalStrengthLte
                if (r8 == 0) goto L_0x0309
                android.telephony.CellSignalStrengthLte r0 = (android.telephony.CellSignalStrengthLte) r0
                int r13 = r0.getDbm()
                int r7 = r0.getCqi()
                int r8 = r0.getRsrp()
                int r9 = r0.getRssnr()
                int r10 = r0.getRsrq()
                int r11 = r0.getRssi()
                r6 = r13
                r0 = r27
            L_0x0306:
                r5 = 1
                goto L_0x0105
            L_0x0309:
                if (r4 == r7) goto L_0x030f
                com.umlaut.crowd.enums.NetworkGenerations r7 = com.umlaut.crowd.enums.NetworkGenerations.Gen5SA
                if (r4 != r7) goto L_0x0345
            L_0x030f:
                boolean r7 = r0 instanceof android.telephony.CellSignalStrengthNr
                if (r7 == 0) goto L_0x0345
                android.telephony.CellSignalStrengthNr r0 = (android.telephony.CellSignalStrengthNr) r0
                com.umlaut.crowd.enums.NetworkGenerations r5 = com.umlaut.crowd.enums.NetworkGenerations.Gen5SA
                if (r4 != r5) goto L_0x031f
                int r5 = r0.getDbm()
                r13 = r5
                goto L_0x0321
            L_0x031f:
                r5 = r26
            L_0x0321:
                int r15 = r0.getCsiRsrp()
                int r16 = r0.getCsiRsrq()
                int r17 = r0.getCsiSinr()
                int r18 = r0.getSsRsrp()
                int r19 = r0.getSsRsrq()
                int r20 = r0.getSsSinr()
                r6 = r5
                r0 = r27
                r7 = r28
                r8 = r29
                r9 = r30
                r10 = r31
                goto L_0x0306
            L_0x0345:
                if (r4 != r5) goto L_0x0369
                boolean r5 = r0 instanceof android.telephony.CellSignalStrengthCdma
                if (r5 == 0) goto L_0x0369
                android.telephony.CellSignalStrengthCdma r0 = (android.telephony.CellSignalStrengthCdma) r0
                int r5 = r0.getCdmaEcio()
                int r0 = r0.getDbm()
                r13 = r0
                r26 = r13
                r7 = r17
                r17 = r28
                r8 = r29
                r9 = r30
                r10 = r31
                r32 = r16
                r16 = r5
                r5 = r32
                goto L_0x039b
            L_0x0369:
                r5 = r22
                r6 = r26
                r0 = r27
                r7 = r28
                r8 = r29
                r9 = r30
                r10 = r31
                goto L_0x0105
            L_0x0379:
                r22 = r5
                r26 = r6
                r28 = r7
                r29 = r8
                r30 = r9
                r31 = r10
                r5 = r16
                r7 = r17
                r6 = r22
                r16 = r25
                r17 = r28
                goto L_0x039b
            L_0x0390:
                r5 = r16
                r16 = r25
                r6 = 0
            L_0x0395:
                r32 = r17
                r17 = r7
                r7 = r32
            L_0x039b:
                if (r6 != 0) goto L_0x067f
                boolean r0 = r34.isGsm()
                if (r0 == 0) goto L_0x03f5
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                java.lang.reflect.Field r0 = r0.v
                if (r0 == 0) goto L_0x03b9
                com.umlaut.crowd.enums.NetworkGenerations r0 = com.umlaut.crowd.enums.NetworkGenerations.Gen3
                if (r4 != r0) goto L_0x03b9
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ IllegalAccessException -> 0x03be }
                java.lang.reflect.Field r0 = r0.v     // Catch:{ IllegalAccessException -> 0x03be }
                int r14 = r0.getInt(r2)     // Catch:{ IllegalAccessException -> 0x03be }
            L_0x03b9:
                r22 = r8
                r23 = r9
                goto L_0x03dd
            L_0x03be:
                r0 = move-exception
                java.lang.String r6 = com.umlaut.crowd.internal.l7.W
                r22 = r8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r23 = r9
                java.lang.String r9 = "updateSignalStrengthData.WcdmaRscp: "
                r8.<init>(r9)
                java.lang.String r0 = r0.toString()
                r8.append(r0)
                java.lang.String r0 = r8.toString()
                android.util.Log.e(r6, r0)
            L_0x03dd:
                int r0 = r34.getGsmSignalStrength()
                if (r0 != 0) goto L_0x03ed
                java.lang.Integer r6 = com.umlaut.crowd.internal.DRI.INVALID
                int r6 = r6.intValue()
                if (r14 == r6) goto L_0x03ed
                r6 = r14
                goto L_0x0405
            L_0x03ed:
                if (r0 >= 0) goto L_0x03f0
                goto L_0x0403
            L_0x03f0:
                int r0 = com.umlaut.crowd.internal.l7.c((int) r0)
                goto L_0x0403
            L_0x03f5:
                r22 = r8
                r23 = r9
                int r0 = r34.getCdmaDbm()
                int r6 = r34.getCdmaEcio()
                r16 = r6
            L_0x0403:
                r6 = r14
                r14 = r0
            L_0x0405:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0424 }
                java.lang.reflect.Method r0 = r0.l     // Catch:{ Exception -> 0x0424 }
                if (r0 == 0) goto L_0x0421
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0424 }
                java.lang.reflect.Method r0 = r0.l     // Catch:{ Exception -> 0x0424 }
                r8 = 0
                java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0424 }
                java.lang.Object r0 = r0.invoke(r2, r9)     // Catch:{ Exception -> 0x0424 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x0424 }
                int r0 = r0.intValue()     // Catch:{ Exception -> 0x0424 }
                r13 = r0
            L_0x0421:
                r21 = r6
                goto L_0x0441
            L_0x0424:
                r0 = move-exception
                java.lang.String r8 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r21 = r6
                java.lang.String r6 = "updateSignalStrengthData.GetDbm: "
                r9.<init>(r6)
                java.lang.String r0 = r0.toString()
                r9.append(r0)
                java.lang.String r0 = r9.toString()
                android.util.Log.e(r8, r0)
            L_0x0441:
                com.umlaut.crowd.enums.NetworkGenerations r0 = com.umlaut.crowd.enums.NetworkGenerations.Gen4
                if (r4 != r0) goto L_0x05a0
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0461 }
                java.lang.reflect.Method r0 = r0.n     // Catch:{ Exception -> 0x0461 }
                if (r0 == 0) goto L_0x047c
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0461 }
                java.lang.reflect.Method r0 = r0.n     // Catch:{ Exception -> 0x0461 }
                r6 = 0
                java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0461 }
                java.lang.Object r0 = r0.invoke(r2, r8)     // Catch:{ Exception -> 0x0461 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x0461 }
                int r14 = r0.intValue()     // Catch:{ Exception -> 0x0461 }
                goto L_0x047c
            L_0x0461:
                r0 = move-exception
                java.lang.String r6 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r9 = "updateSignalStrengthData.GetLTEDbm: "
                r8.<init>(r9)
                java.lang.String r0 = r0.toString()
                r8.append(r0)
                java.lang.String r0 = r8.toString()
                android.util.Log.e(r6, r0)
            L_0x047c:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                java.lang.reflect.Method r0 = r0.m
                if (r0 == 0) goto L_0x04b3
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0498 }
                java.lang.reflect.Method r0 = r0.m     // Catch:{ Exception -> 0x0498 }
                r6 = 0
                java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0498 }
                java.lang.Object r0 = r0.invoke(r2, r8)     // Catch:{ Exception -> 0x0498 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x0498 }
                int r11 = r0.intValue()     // Catch:{ Exception -> 0x0498 }
                goto L_0x04b3
            L_0x0498:
                r0 = move-exception
                java.lang.String r6 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r9 = "updateSignalStrengthData.GetLteSignalStrength: "
                r8.<init>(r9)
                java.lang.String r0 = r0.toString()
                r8.append(r0)
                java.lang.String r0 = r8.toString()
                android.util.Log.e(r6, r0)
            L_0x04b3:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x04d1 }
                java.lang.reflect.Method r0 = r0.p     // Catch:{ Exception -> 0x04d1 }
                if (r0 == 0) goto L_0x04ec
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x04d1 }
                java.lang.reflect.Method r0 = r0.p     // Catch:{ Exception -> 0x04d1 }
                r6 = 0
                java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x04d1 }
                java.lang.Object r0 = r0.invoke(r2, r8)     // Catch:{ Exception -> 0x04d1 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x04d1 }
                int r0 = r0.intValue()     // Catch:{ Exception -> 0x04d1 }
                r17 = r0
                goto L_0x04ec
            L_0x04d1:
                r0 = move-exception
                java.lang.String r6 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r9 = "updateSignalStrengthData.GetLteCqi: "
                r8.<init>(r9)
                java.lang.String r0 = r0.toString()
                r8.append(r0)
                java.lang.String r0 = r8.toString()
                android.util.Log.e(r6, r0)
            L_0x04ec:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0508 }
                java.lang.reflect.Method r0 = r0.q     // Catch:{ Exception -> 0x0508 }
                if (r0 == 0) goto L_0x0523
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0508 }
                java.lang.reflect.Method r0 = r0.q     // Catch:{ Exception -> 0x0508 }
                r6 = 0
                java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0508 }
                java.lang.Object r0 = r0.invoke(r2, r8)     // Catch:{ Exception -> 0x0508 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x0508 }
                int r8 = r0.intValue()     // Catch:{ Exception -> 0x0508 }
                goto L_0x0525
            L_0x0508:
                r0 = move-exception
                java.lang.String r6 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r9 = "updateSignalStrengthData.GetLteRsrp: "
                r8.<init>(r9)
                java.lang.String r0 = r0.toString()
                r8.append(r0)
                java.lang.String r0 = r8.toString()
                android.util.Log.e(r6, r0)
            L_0x0523:
                r8 = r22
            L_0x0525:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0543 }
                java.lang.reflect.Method r0 = r0.r     // Catch:{ Exception -> 0x0543 }
                if (r0 == 0) goto L_0x0540
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0543 }
                java.lang.reflect.Method r0 = r0.r     // Catch:{ Exception -> 0x0543 }
                r6 = 0
                java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0543 }
                java.lang.Object r0 = r0.invoke(r2, r9)     // Catch:{ Exception -> 0x0543 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x0543 }
                int r10 = r0.intValue()     // Catch:{ Exception -> 0x0543 }
            L_0x0540:
                r22 = r8
                goto L_0x0560
            L_0x0543:
                r0 = move-exception
                java.lang.String r6 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r22 = r8
                java.lang.String r8 = "updateSignalStrengthData.GetLteRsrq: "
                r9.<init>(r8)
                java.lang.String r0 = r0.toString()
                r9.append(r0)
                java.lang.String r0 = r9.toString()
                android.util.Log.e(r6, r0)
            L_0x0560:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x057e }
                java.lang.reflect.Method r0 = r0.s     // Catch:{ Exception -> 0x057e }
                if (r0 == 0) goto L_0x05a0
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x057e }
                java.lang.reflect.Method r0 = r0.s     // Catch:{ Exception -> 0x057e }
                r6 = 0
                java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x057e }
                java.lang.Object r0 = r0.invoke(r2, r8)     // Catch:{ Exception -> 0x057e }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x057e }
                int r9 = r0.intValue()     // Catch:{ Exception -> 0x057e }
                r8 = r22
                goto L_0x05a4
            L_0x057e:
                r0 = move-exception
                java.lang.String r6 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r9 = "updateSignalStrengthData.GetLteRssnr: "
                r8.<init>(r9)
                java.lang.String r0 = r0.toString()
                r8.append(r0)
                java.lang.String r0 = r8.toString()
                android.util.Log.e(r6, r0)
                r26 = r14
                r8 = r22
                r9 = r23
                goto L_0x05a6
            L_0x05a0:
                r8 = r22
                r9 = r23
            L_0x05a4:
                r26 = r14
            L_0x05a6:
                com.umlaut.crowd.enums.NetworkGenerations r0 = com.umlaut.crowd.enums.NetworkGenerations.Gen5SA
                if (r4 != r0) goto L_0x0636
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                java.lang.reflect.Field r0 = r0.x
                if (r0 == 0) goto L_0x05d8
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ IllegalAccessException -> 0x05bd }
                java.lang.reflect.Field r0 = r0.x     // Catch:{ IllegalAccessException -> 0x05bd }
                int r18 = r0.getInt(r2)     // Catch:{ IllegalAccessException -> 0x05bd }
                goto L_0x05d8
            L_0x05bd:
                r0 = move-exception
                java.lang.String r4 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r14 = "updateSignalStrengthData.NrCsiRsrp: "
                r6.<init>(r14)
                java.lang.String r0 = r0.toString()
                r6.append(r0)
                java.lang.String r0 = r6.toString()
                android.util.Log.e(r4, r0)
            L_0x05d8:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                java.lang.reflect.Field r0 = r0.y
                if (r0 == 0) goto L_0x0606
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ IllegalAccessException -> 0x05eb }
                java.lang.reflect.Field r0 = r0.y     // Catch:{ IllegalAccessException -> 0x05eb }
                int r19 = r0.getInt(r2)     // Catch:{ IllegalAccessException -> 0x05eb }
                goto L_0x0606
            L_0x05eb:
                r0 = move-exception
                java.lang.String r4 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r14 = "updateSignalStrengthData.NrCsiRsrq: "
                r6.<init>(r14)
                java.lang.String r0 = r0.toString()
                r6.append(r0)
                java.lang.String r0 = r6.toString()
                android.util.Log.e(r4, r0)
            L_0x0606:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                java.lang.reflect.Field r0 = r0.z
                if (r0 == 0) goto L_0x0636
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ IllegalAccessException -> 0x061b }
                java.lang.reflect.Field r0 = r0.z     // Catch:{ IllegalAccessException -> 0x061b }
                int r0 = r0.getInt(r2)     // Catch:{ IllegalAccessException -> 0x061b }
                r20 = r0
                goto L_0x0636
            L_0x061b:
                r0 = move-exception
                java.lang.String r4 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r14 = "updateSignalStrengthData.NrCsiSinr: "
                r6.<init>(r14)
                java.lang.String r0 = r0.toString()
                r6.append(r0)
                java.lang.String r0 = r6.toString()
                android.util.Log.e(r4, r0)
            L_0x0636:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0653 }
                java.lang.reflect.Method r0 = r0.o     // Catch:{ Exception -> 0x0653 }
                if (r0 == 0) goto L_0x066e
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x0653 }
                java.lang.reflect.Method r0 = r0.o     // Catch:{ Exception -> 0x0653 }
                r4 = 0
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0653 }
                java.lang.Object r0 = r0.invoke(r2, r4)     // Catch:{ Exception -> 0x0653 }
                java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x0653 }
                int r0 = r0.intValue()     // Catch:{ Exception -> 0x0653 }
                r12 = r0
                goto L_0x066e
            L_0x0653:
                r0 = move-exception
                java.lang.String r4 = com.umlaut.crowd.internal.l7.W
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r14 = "updateSignalStrengthData.GetEcno: "
                r6.<init>(r14)
                java.lang.String r0 = r0.toString()
                r6.append(r0)
                java.lang.String r0 = r6.toString()
                android.util.Log.e(r4, r0)
            L_0x066e:
                int r0 = r34.getGsmBitErrorRate()
                r2 = r17
                r6 = r19
                r19 = r20
                r14 = r21
                r17 = r0
                r0 = r16
                goto L_0x068d
            L_0x067f:
                r22 = r8
                r23 = r9
                r0 = r16
                r2 = r17
                r6 = r19
                r19 = r20
                r17 = r21
            L_0x068d:
                r16 = r12
                r12 = r26
                long r3 = android.os.SystemClock.elapsedRealtime()
                r20 = r3
                com.umlaut.crowd.internal.l7$t r3 = new com.umlaut.crowd.internal.l7$t
                com.umlaut.crowd.internal.l7 r4 = com.umlaut.crowd.internal.l7.this
                r1 = 0
                r3.<init>(r4, r1)
                r3.c = r0
                r3.a = r12
                r3.b = r13
                r3.d = r2
                r3.e = r8
                r3.f = r9
                r3.g = r10
                r3.h = r11
                r3.m = r15
                r3.n = r5
                r3.o = r7
                r0 = r18
                r3.p = r0
                r3.q = r6
                r0 = r19
                r3.r = r0
                r3.k = r14
                r0 = r17
                r3.i = r0
                r12 = r16
                r3.j = r12
                r0 = r20
                r3.l = r0
                r1 = r33
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this
                com.umlaut.crowd.internal.l7$o r0 = r0.g
                r2 = r35
                r0.a((int) r2, (com.umlaut.crowd.internal.l7.t) r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.l7.u.a(android.telephony.SignalStrength, int):void");
        }

        /* access modifiers changed from: private */
        public void a(CellLocation cellLocation, int i) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            n a2 = l7.this.g.a(i);
            if (a2 == null) {
                a2 = new n(l7.this, (d) null);
            }
            a2.a = cellLocation;
            a2.b = elapsedRealtime;
            l7.this.g.a(i, a2);
            for (m7 a3 : l7.this.U) {
                a3.a(cellLocation, i);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        SubscriptionManager subscriptionManager;
        if (z2 && this.h != null && this.c.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && Build.VERSION.SDK_INT >= 22 && (subscriptionManager = (SubscriptionManager) this.c.getSystemService("telephony_subscription_service")) != null) {
            subscriptionManager.removeOnSubscriptionsChangedListener(this.h);
        }
        TelephonyManager telephonyManager = this.a;
        if (telephonyManager != null) {
            u uVar = this.d;
            if (uVar != null) {
                telephonyManager.listen(uVar, 0);
            }
            Iterator<u> it = this.e.iterator();
            while (it.hasNext()) {
                u next = it.next();
                SparseArray<TelephonyManager> sparseArray = this.b;
                TelephonyManager telephonyManager2 = (sparseArray == null || sparseArray.size() <= 0) ? null : this.b.get(next.a());
                if (telephonyManager2 == null) {
                    telephonyManager2 = this.a;
                }
                telephonyManager2.listen(next, 0);
            }
        }
    }

    private static z6 f(int i2) {
        switch (i2) {
            case 0:
                return z6.WCDMA_PREF;
            case 1:
                return z6.GSM_ONLY;
            case 2:
                return z6.WCDMA_ONLY;
            case 3:
                return z6.GSM_UMTS;
            case 4:
                return z6.CDMA;
            case 5:
                return z6.CDMA_NO_EVDO;
            case 6:
                return z6.EVDO_NO_CDMA;
            case 7:
                return z6.GLOBAL;
            case 8:
                return z6.LTE_CDMA_EVDO;
            case 9:
                return z6.LTE_GSM_WCDMA;
            case 10:
                return z6.LTE_CDMA_EVDO_GSM_WCDMA;
            case 11:
                return z6.LTE_ONLY;
            case 12:
                return z6.LTE_WCDMA;
            case 13:
                return z6.TDSCDMA_ONLY;
            case 14:
                return z6.TDSCDMA_WCDMA;
            case 15:
                return z6.LTE_TDSCDMA;
            case 16:
                return z6.TDSCDMA_GSM;
            case 17:
                return z6.LTE_TDSCDMA_GSM;
            case 18:
                return z6.TDSCDMA_GSM_WCDMA;
            case 19:
                return z6.LTE_TDSCDMA_WCDMA;
            case 20:
                return z6.LTE_TDSCDMA_GSM_WCDMA;
            case 21:
                return z6.TDSCDMA_CDMA_EVDO_GSM_WCDMA;
            case 22:
                return z6.LTE_TDSCDMA_CDMA_EVDO_GSM_WCDMA;
            case 23:
                return z6.NR_ONLY;
            case 24:
                return z6.NR_LTE;
            case 25:
                return z6.NR_LTE_CDMA_EVDO;
            case 26:
                return z6.NR_LTE_GSM_WCDMA;
            case 27:
                return z6.NR_LTE_CDMA_EVDO_GSM_WCDMA;
            case 28:
                return z6.NR_LTE_WCDMA;
            case 29:
                return z6.NR_LTE_TDSCDMA;
            case 30:
                return z6.NR_LTE_TDSCDMA_GSM;
            case 31:
                return z6.NR_LTE_TDSCDMA_WCDMA;
            case 32:
                return z6.NR_LTE_TDSCDMA_GSM_WCDMA;
            case 33:
                return z6.NR_LTE_TDSCDMA_CDMA_EVDO_GSM_WCDMA;
            default:
                return z6.Unknown;
        }
    }

    private static x0 g(int i2) {
        if (i2 == 0) {
            return x0.None;
        }
        if (i2 == 1) {
            return x0.Primary;
        }
        if (i2 != 2) {
            return x0.Unknown;
        }
        return x0.Secondary;
    }

    public z0[] d() {
        return a(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:225:0x05a2  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x05ce  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x05d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.umlaut.crowd.internal.DRI i(int r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = -1
            if (r2 == r3) goto L_0x05d6
            boolean r0 = r16.l((int) r17)
            if (r0 == 0) goto L_0x05d6
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 22
            if (r0 < r4) goto L_0x05d6
            int[] r0 = r1.S
            int r0 = r0.length
            if (r0 != 0) goto L_0x001a
            goto L_0x05d6
        L_0x001a:
            com.umlaut.crowd.internal.DRI r4 = new com.umlaut.crowd.internal.DRI
            r4.<init>()
            r4.SubscriptionId = r2
            com.umlaut.crowd.internal.y5 r0 = r1.i
            int r5 = r0.DefaultVoiceSimId
            r6 = 1
            r7 = 0
            if (r2 != r5) goto L_0x002b
            r5 = 1
            goto L_0x002c
        L_0x002b:
            r5 = 0
        L_0x002c:
            r4.IsDefaultVoiceSim = r5
            int r0 = r0.DefaultDataSimId
            if (r2 != r0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r4.IsDefaultDataSim = r0
            android.content.Context r0 = r1.c
            com.umlaut.crowd.internal.z6 r0 = r1.a((android.content.Context) r0, (int) r2)
            r4.PreferredNetwork = r0
            com.umlaut.crowd.internal.z6 r5 = com.umlaut.crowd.internal.z6.Unknown
            if (r0 != r5) goto L_0x005b
            android.content.Context r0 = r1.c
            android.util.SparseArray r0 = r1.a((android.content.Context) r0)
            com.umlaut.crowd.internal.y5 r5 = r1.i
            com.umlaut.crowd.internal.o9 r5 = r5.getSimInfoSubId(r2)
            int r5 = r5.SimSlotIndex
            java.lang.Object r0 = r0.get(r5)
            com.umlaut.crowd.internal.z6 r0 = (com.umlaut.crowd.internal.z6) r0
            if (r0 == 0) goto L_0x005b
            r4.PreferredNetwork = r0
        L_0x005b:
            android.telephony.TelephonyManager r0 = r1.a
            if (r0 == 0) goto L_0x05d5
            android.util.SparseArray<android.telephony.TelephonyManager> r0 = r1.b
            r5 = 0
            if (r0 == 0) goto L_0x0074
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0074
            android.util.SparseArray<android.telephony.TelephonyManager> r0 = r1.b
            java.lang.Object r0 = r0.get(r2)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            r8 = r0
            goto L_0x0075
        L_0x0074:
            r8 = r5
        L_0x0075:
            r9 = 4
            r10 = 3
            android.telephony.TelephonyManager r0 = r1.a     // Catch:{ SecurityException -> 0x00a6 }
            int r0 = r0.getDataState()     // Catch:{ SecurityException -> 0x00a6 }
            if (r0 == 0) goto L_0x00a1
            if (r0 == r6) goto L_0x009c
            r11 = 2
            if (r0 == r11) goto L_0x0097
            if (r0 == r10) goto L_0x0092
            if (r0 == r9) goto L_0x008d
            com.umlaut.crowd.internal.t1 r0 = com.umlaut.crowd.internal.t1.Unknown     // Catch:{ SecurityException -> 0x00a6 }
            r4.MobileDataConnectionState = r0     // Catch:{ SecurityException -> 0x00a6 }
            goto L_0x00be
        L_0x008d:
            com.umlaut.crowd.internal.t1 r0 = com.umlaut.crowd.internal.t1.Disconnecting     // Catch:{ SecurityException -> 0x00a6 }
            r4.MobileDataConnectionState = r0     // Catch:{ SecurityException -> 0x00a6 }
            goto L_0x00be
        L_0x0092:
            com.umlaut.crowd.internal.t1 r0 = com.umlaut.crowd.internal.t1.Suspended     // Catch:{ SecurityException -> 0x00a6 }
            r4.MobileDataConnectionState = r0     // Catch:{ SecurityException -> 0x00a6 }
            goto L_0x00be
        L_0x0097:
            com.umlaut.crowd.internal.t1 r0 = com.umlaut.crowd.internal.t1.Connected     // Catch:{ SecurityException -> 0x00a6 }
            r4.MobileDataConnectionState = r0     // Catch:{ SecurityException -> 0x00a6 }
            goto L_0x00be
        L_0x009c:
            com.umlaut.crowd.internal.t1 r0 = com.umlaut.crowd.internal.t1.Connecting     // Catch:{ SecurityException -> 0x00a6 }
            r4.MobileDataConnectionState = r0     // Catch:{ SecurityException -> 0x00a6 }
            goto L_0x00be
        L_0x00a1:
            com.umlaut.crowd.internal.t1 r0 = com.umlaut.crowd.internal.t1.Disconnected     // Catch:{ SecurityException -> 0x00a6 }
            r4.MobileDataConnectionState = r0     // Catch:{ SecurityException -> 0x00a6 }
            goto L_0x00be
        L_0x00a6:
            r0 = move-exception
            java.lang.String r11 = W
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "getRadioInfo(subscriptionID): getDataState: "
            r12.<init>(r13)
            java.lang.String r0 = r0.toString()
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            android.util.Log.e(r11, r0)
        L_0x00be:
            boolean r0 = r16.n()
            if (r0 == 0) goto L_0x00c7
            com.umlaut.crowd.internal.y2 r0 = com.umlaut.crowd.internal.y2.Enabled
            goto L_0x00c9
        L_0x00c7:
            com.umlaut.crowd.internal.y2 r0 = com.umlaut.crowd.internal.y2.Disabled
        L_0x00c9:
            r4.FlightMode = r0
            com.umlaut.crowd.enums.ThreeState r0 = com.umlaut.crowd.enums.ThreeState.Unknown
            r4.MobileDataEnabled = r0
            if (r8 == 0) goto L_0x00e5
            int r0 = android.os.Build.VERSION.SDK_INT
            r11 = 26
            if (r0 < r11) goto L_0x00e5
            boolean r0 = r8.isDataEnabled()
            if (r0 == 0) goto L_0x00e0
            com.umlaut.crowd.enums.ThreeState r0 = com.umlaut.crowd.enums.ThreeState.Enabled
            goto L_0x00e2
        L_0x00e0:
            com.umlaut.crowd.enums.ThreeState r0 = com.umlaut.crowd.enums.ThreeState.Disabled
        L_0x00e2:
            r4.MobileDataEnabled = r0
            goto L_0x011f
        L_0x00e5:
            java.lang.reflect.Method r0 = r1.L
            if (r0 == 0) goto L_0x011f
            android.telephony.TelephonyManager r11 = r1.a     // Catch:{ Exception -> 0x0107 }
            java.lang.Object[] r12 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0107 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x0107 }
            r12[r7] = r13     // Catch:{ Exception -> 0x0107 }
            java.lang.Object r0 = r0.invoke(r11, r12)     // Catch:{ Exception -> 0x0107 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0107 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0107 }
            if (r0 == 0) goto L_0x0102
            com.umlaut.crowd.enums.ThreeState r0 = com.umlaut.crowd.enums.ThreeState.Enabled     // Catch:{ Exception -> 0x0107 }
            goto L_0x0104
        L_0x0102:
            com.umlaut.crowd.enums.ThreeState r0 = com.umlaut.crowd.enums.ThreeState.Disabled     // Catch:{ Exception -> 0x0107 }
        L_0x0104:
            r4.MobileDataEnabled = r0     // Catch:{ Exception -> 0x0107 }
            goto L_0x011f
        L_0x0107:
            r0 = move-exception
            java.lang.String r11 = W
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "getRadioInfo(subscriptionID): MobileDataEnabled: "
            r12.<init>(r13)
            java.lang.String r0 = r0.toString()
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            android.util.Log.e(r11, r0)
        L_0x011f:
            if (r8 == 0) goto L_0x0128
            boolean r0 = r8.isNetworkRoaming()
            r4.IsRoaming = r0
            goto L_0x015b
        L_0x0128:
            java.lang.reflect.Method r0 = r1.M
            if (r0 == 0) goto L_0x015b
            android.telephony.TelephonyManager r11 = r1.a     // Catch:{ Exception -> 0x0143 }
            java.lang.Object[] r12 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0143 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x0143 }
            r12[r7] = r13     // Catch:{ Exception -> 0x0143 }
            java.lang.Object r0 = r0.invoke(r11, r12)     // Catch:{ Exception -> 0x0143 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0143 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0143 }
            r4.IsRoaming = r0     // Catch:{ Exception -> 0x0143 }
            goto L_0x015b
        L_0x0143:
            r0 = move-exception
            java.lang.String r11 = W
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "getRadioInfo(subscriptionID): IsRoaming: "
            r12.<init>(r13)
            java.lang.String r0 = r0.toString()
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            android.util.Log.e(r11, r0)
        L_0x015b:
            com.umlaut.crowd.internal.tb r0 = r16.p()
            r4.IsMetered = r0
            com.umlaut.crowd.internal.tb r0 = r16.o()
            int r0 = com.umlaut.crowd.internal.i1.a((com.umlaut.crowd.internal.tb) r0)
            r4.IsVpn = r0
            com.umlaut.crowd.enums.ConnectionTypes r0 = r16.e()
            r4.ConnectionType = r0
            com.umlaut.crowd.internal.l7$o r0 = r1.g
            int r0 = r0.d(r2)
            com.umlaut.crowd.enums.NetworkTypes r0 = e((int) r0)
            r4.DisplayNetworkType = r0
            com.umlaut.crowd.enums.NetworkTypes r0 = r4.NetworkType
            com.umlaut.crowd.enums.NetworkTypes r11 = com.umlaut.crowd.enums.NetworkTypes.Unknown
            if (r0 != r11) goto L_0x01d5
            if (r8 == 0) goto L_0x019e
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01bd }
            r11 = 30
            if (r0 < r11) goto L_0x0193
            android.content.Context r0 = r1.c     // Catch:{ Exception -> 0x01bd }
            boolean r0 = com.umlaut.crowd.utils.PermissionUtils.hasReadPhoneStatePermission(r0)     // Catch:{ Exception -> 0x01bd }
            if (r0 == 0) goto L_0x019e
        L_0x0193:
            int r0 = r8.getNetworkType()     // Catch:{ Exception -> 0x01bd }
            com.umlaut.crowd.enums.NetworkTypes r0 = d((int) r0)     // Catch:{ Exception -> 0x01bd }
            r4.NetworkType = r0     // Catch:{ Exception -> 0x01bd }
            goto L_0x01d5
        L_0x019e:
            java.lang.reflect.Method r0 = r1.N     // Catch:{ Exception -> 0x01bd }
            if (r0 == 0) goto L_0x01d5
            android.telephony.TelephonyManager r11 = r1.a     // Catch:{ Exception -> 0x01bd }
            java.lang.Object[] r12 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x01bd }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x01bd }
            r12[r7] = r13     // Catch:{ Exception -> 0x01bd }
            java.lang.Object r0 = r0.invoke(r11, r12)     // Catch:{ Exception -> 0x01bd }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x01bd }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x01bd }
            com.umlaut.crowd.enums.NetworkTypes r0 = d((int) r0)     // Catch:{ Exception -> 0x01bd }
            r4.NetworkType = r0     // Catch:{ Exception -> 0x01bd }
            goto L_0x01d5
        L_0x01bd:
            r0 = move-exception
            java.lang.String r11 = W
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "getRadioInfo(subscriptionID): getNetworkType: "
            r12.<init>(r13)
            java.lang.String r0 = r0.toString()
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            android.util.Log.e(r11, r0)
        L_0x01d5:
            com.umlaut.crowd.enums.NetworkTypes r0 = r4.NetworkType
            com.umlaut.crowd.enums.NetworkTypes r11 = com.umlaut.crowd.enums.NetworkTypes.Unknown
            if (r0 != r11) goto L_0x01e7
            com.umlaut.crowd.internal.l7$o r0 = r1.g
            int r0 = r0.c(r2)
            com.umlaut.crowd.enums.NetworkTypes r0 = d((int) r0)
            r4.NetworkType = r0
        L_0x01e7:
            java.lang.String r11 = "getRadioInfo(subscriptionID): OperatorName: "
            if (r8 == 0) goto L_0x01f6
            java.lang.String r0 = r8.getNetworkOperatorName()
            java.lang.String r0 = com.umlaut.crowd.internal.aa.a((java.lang.String) r0)
            r4.OperatorName = r0
            goto L_0x0227
        L_0x01f6:
            java.lang.reflect.Method r0 = r1.O
            if (r0 == 0) goto L_0x0227
            android.telephony.TelephonyManager r12 = r1.a     // Catch:{ Exception -> 0x0211 }
            java.lang.Object[] r13 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0211 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x0211 }
            r13[r7] = r14     // Catch:{ Exception -> 0x0211 }
            java.lang.Object r0 = r0.invoke(r12, r13)     // Catch:{ Exception -> 0x0211 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0211 }
            java.lang.String r0 = com.umlaut.crowd.internal.aa.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0211 }
            r4.OperatorName = r0     // Catch:{ Exception -> 0x0211 }
            goto L_0x0227
        L_0x0211:
            r0 = move-exception
            java.lang.String r12 = W
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            java.lang.String r0 = r0.toString()
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            android.util.Log.e(r12, r0)
        L_0x0227:
            java.lang.String r12 = ""
            if (r8 == 0) goto L_0x0230
            java.lang.String r0 = r8.getNetworkOperator()
            goto L_0x0288
        L_0x0230:
            java.lang.reflect.Method r0 = r1.Q
            if (r0 == 0) goto L_0x025c
            android.telephony.TelephonyManager r8 = r1.a     // Catch:{ Exception -> 0x0245 }
            java.lang.Object[] r13 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0245 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x0245 }
            r13[r7] = r14     // Catch:{ Exception -> 0x0245 }
            java.lang.Object r0 = r0.invoke(r8, r13)     // Catch:{ Exception -> 0x0245 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0245 }
            goto L_0x0288
        L_0x0245:
            r0 = move-exception
            java.lang.String r8 = W
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            java.lang.String r0 = r0.toString()
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            android.util.Log.e(r8, r0)
            goto L_0x0287
        L_0x025c:
            java.lang.reflect.Method r0 = r1.P
            if (r0 == 0) goto L_0x0287
            android.telephony.TelephonyManager r8 = r1.a     // Catch:{ Exception -> 0x0271 }
            java.lang.Object[] r13 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0271 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x0271 }
            r13[r7] = r14     // Catch:{ Exception -> 0x0271 }
            java.lang.Object r0 = r0.invoke(r8, r13)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0288
        L_0x0271:
            r0 = move-exception
            java.lang.String r8 = W
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            java.lang.String r0 = r0.toString()
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            android.util.Log.e(r8, r0)
        L_0x0287:
            r0 = r12
        L_0x0288:
            int r8 = r0.length()
            if (r8 <= r9) goto L_0x029a
            java.lang.String r8 = r0.substring(r7, r10)
            r4.MCC = r8
            java.lang.String r0 = r0.substring(r10)
            r4.MNC = r0
        L_0x029a:
            com.umlaut.crowd.internal.j6[] r8 = r16.h((int) r17)
            com.umlaut.crowd.internal.l7$o r0 = r1.g
            com.umlaut.crowd.internal.l7$s r9 = r0.f(r2)
            int r0 = r9.e
            r4.ARFCN = r0
            com.umlaut.crowd.internal.l7$o r0 = r1.g
            com.umlaut.crowd.internal.l7$n r0 = r0.a((int) r2)
            if (r0 != 0) goto L_0x02b5
            com.umlaut.crowd.internal.l7$n r0 = new com.umlaut.crowd.internal.l7$n
            r0.<init>(r1, r5)
        L_0x02b5:
            r5 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r10 = 29
            if (r0 >= r10) goto L_0x02c6
            android.content.Context r0 = r1.c
            java.lang.String r10 = "android.permission.ACCESS_COARSE_LOCATION"
            int r0 = r0.checkCallingOrSelfPermission(r10)
            if (r0 == 0) goto L_0x02e4
        L_0x02c6:
            android.content.Context r0 = r1.c
            java.lang.String r10 = "android.permission.ACCESS_FINE_LOCATION"
            int r0 = r0.checkCallingOrSelfPermission(r10)
            if (r0 != 0) goto L_0x030a
            com.umlaut.crowd.internal.d3 r0 = com.umlaut.crowd.InsightCore.getForegroundTestManager()
            int r0 = r0.d()
            if (r0 == r6) goto L_0x02e4
            android.content.Context r0 = r1.c
            java.lang.String r10 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            int r0 = r0.checkCallingOrSelfPermission(r10)
            if (r0 != 0) goto L_0x030a
        L_0x02e4:
            android.telephony.CellLocation r0 = r5.a
            if (r0 != 0) goto L_0x030c
            android.telephony.TelephonyManager r0 = r1.a     // Catch:{ Exception -> 0x02f1 }
            android.telephony.CellLocation r0 = r0.getCellLocation()     // Catch:{ Exception -> 0x02f1 }
            r5.a = r0     // Catch:{ Exception -> 0x02f1 }
            goto L_0x030c
        L_0x02f1:
            r0 = move-exception
            java.lang.String r6 = W
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "getRadioInfo(subscriptionID): getCellLocation:"
            r10.<init>(r11)
            java.lang.String r0 = r0.toString()
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            android.util.Log.e(r6, r0)
            goto L_0x030c
        L_0x030a:
            r4.MissingPermission = r6
        L_0x030c:
            android.telephony.CellLocation r0 = r5.a
            r10 = 0
            if (r0 == 0) goto L_0x040a
            long r6 = r5.b
            long r13 = r5.g
            int r15 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x040a
            java.lang.Class r0 = r0.getClass()
            java.lang.Class<android.telephony.gsm.GsmCellLocation> r6 = android.telephony.gsm.GsmCellLocation.class
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x036f
            android.telephony.CellLocation r0 = r5.a
            android.telephony.gsm.GsmCellLocation r0 = (android.telephony.gsm.GsmCellLocation) r0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r7 = r0.getLac()
            r6.append(r7)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            r4.GsmLAC = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r7 = r0.getCid()
            r6.append(r7)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            r4.GsmCellId = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r0 = r0.getPsc()
            r6.append(r0)
            r6.append(r12)
            java.lang.String r0 = r6.toString()
            r4.PrimaryScramblingCode = r0
            com.umlaut.crowd.internal.y0 r0 = com.umlaut.crowd.internal.y0.Default
            r4.GsmCellIdSource = r0
            goto L_0x03ee
        L_0x036f:
            android.telephony.CellLocation r0 = r5.a
            java.lang.Class r0 = r0.getClass()
            java.lang.Class<android.telephony.cdma.CdmaCellLocation> r6 = android.telephony.cdma.CdmaCellLocation.class
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x03ee
            android.telephony.CellLocation r0 = r5.a
            android.telephony.cdma.CdmaCellLocation r0 = (android.telephony.cdma.CdmaCellLocation) r0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r7 = r0.getBaseStationId()
            r6.append(r7)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            r4.CdmaBaseStationId = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r7 = r0.getBaseStationLatitude()
            r6.append(r7)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            r4.CdmaBaseStationLatitude = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r7 = r0.getBaseStationLongitude()
            r6.append(r7)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            r4.CdmaBaseStationLongitude = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r7 = r0.getNetworkId()
            r6.append(r7)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            r4.CdmaNetworkId = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r0 = r0.getSystemId()
            r6.append(r0)
            r6.append(r12)
            java.lang.String r0 = r6.toString()
            r4.CdmaSystemId = r0
            com.umlaut.crowd.internal.y0 r0 = com.umlaut.crowd.internal.y0.Default
            r4.GsmCellIdSource = r0
        L_0x03ee:
            long r6 = r5.b
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0443
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r13 = r5.b
            long r6 = r6 - r13
            r13 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x0406
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0407
        L_0x0406:
            int r0 = (int) r6
        L_0x0407:
            r4.GsmCellIdAge = r0
            goto L_0x0443
        L_0x040a:
            java.lang.String r0 = r5.c
            if (r0 == 0) goto L_0x0443
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0443
            java.lang.String r0 = r5.c
            r4.GsmCellId = r0
            java.lang.String r0 = r5.d
            r4.GsmLAC = r0
            int r0 = r5.f
            r4.ARFCN = r0
            int r0 = r5.e
            r4.LtePci = r0
            com.umlaut.crowd.internal.y0 r0 = com.umlaut.crowd.internal.y0.Samsung
            r4.GsmCellIdSource = r0
            long r6 = r5.g
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0443
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r13 = r5.g
            long r6 = r6 - r13
            r13 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x0440
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0441
        L_0x0440:
            int r0 = (int) r6
        L_0x0441:
            r4.GsmCellIdAge = r0
        L_0x0443:
            if (r8 == 0) goto L_0x04a7
            int r5 = r8.length
            r6 = 0
        L_0x0447:
            if (r6 >= r5) goto L_0x04a7
            r0 = r8[r6]
            com.umlaut.crowd.internal.i2 r7 = r0.Domain
            com.umlaut.crowd.internal.i2 r13 = com.umlaut.crowd.internal.i2.CS
            if (r7 != r13) goto L_0x04a4
            java.lang.String r7 = r4.GsmCellId
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0471
            java.lang.String r7 = r0.CellId
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x0471
            java.lang.String r7 = r0.CellId
            r4.GsmCellId = r7
            java.lang.String r7 = r0.Tac
            r4.GsmLAC = r7
            int r7 = r0.Age
            r4.GsmCellIdAge = r7
            com.umlaut.crowd.internal.y0 r7 = com.umlaut.crowd.internal.y0.Default
            r4.GsmCellIdSource = r7
        L_0x0471:
            java.lang.String r7 = r4.GsmCellId
            java.lang.String r13 = r0.CellId
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x04a4
            java.lang.String r7 = r0.Pci
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x04a4
            java.lang.String r0 = r0.Pci     // Catch:{ NumberFormatException -> 0x048c }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x048c }
            r4.LtePci = r0     // Catch:{ NumberFormatException -> 0x048c }
            goto L_0x04a4
        L_0x048c:
            r0 = move-exception
            java.lang.String r7 = W
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "getRadioInfo(subscriptionID): parseInt:"
            r13.<init>(r14)
            java.lang.String r0 = r0.toString()
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            android.util.Log.d(r7, r0)
        L_0x04a4:
            int r6 = r6 + 1
            goto L_0x0447
        L_0x04a7:
            com.umlaut.crowd.internal.g9 r0 = r9.a
            r4.ServiceState = r0
            com.umlaut.crowd.internal.j2 r0 = r9.c
            r4.DuplexMode = r0
            java.lang.String r0 = r9.g
            r4.Bandwidth = r0
            com.umlaut.crowd.internal.tb r0 = r9.d
            r4.ManualSelection = r0
            com.umlaut.crowd.internal.tb r0 = r9.f
            r4.CarrierAggregation = r0
            long r5 = r9.b
            int r0 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x04d6
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r9 = r9.b
            long r5 = r5 - r9
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x04d3
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x04d4
        L_0x04d3:
            int r0 = (int) r5
        L_0x04d4:
            r4.ServiceStateAge = r0
        L_0x04d6:
            com.umlaut.crowd.internal.o6 r0 = c((com.umlaut.crowd.internal.j6[]) r8)
            r4.NrState = r0
            com.umlaut.crowd.internal.tb r0 = r1.d((com.umlaut.crowd.internal.j6[]) r8)
            r4.NrAvailable = r0
            com.umlaut.crowd.enums.NetworkTypes r0 = r4.NetworkType
            com.umlaut.crowd.enums.NetworkTypes r5 = com.umlaut.crowd.enums.NetworkTypes.Unknown
            if (r0 != r5) goto L_0x04ee
            com.umlaut.crowd.enums.NetworkTypes r0 = r1.b((com.umlaut.crowd.internal.j6[]) r8)
            r4.NetworkType = r0
        L_0x04ee:
            com.umlaut.crowd.internal.l7$o r0 = r1.g
            com.umlaut.crowd.internal.l7$t r2 = r0.g(r2)
            int r0 = r2.k
            r4.RSCP = r0
            int r0 = r2.c
            r4.CdmaEcIo = r0
            int r0 = r2.a
            r4.RXLevel = r0
            int r5 = r2.b
            r4.NativeDbm = r5
            int r5 = r2.i
            r4.GsmBitErrorRate = r5
            int r5 = r2.j
            r4.EcN0 = r5
            int r5 = r2.d
            r4.LteCqi = r5
            int r5 = r2.e
            r4.LteRsrp = r5
            int r6 = r2.g
            r4.LteRsrq = r6
            int r6 = r2.f
            r4.LteRssnr = r6
            int r6 = r2.h
            r4.LteRssi = r6
            int r6 = r2.m
            r4.NrCsiRsrp = r6
            int r6 = r2.n
            r4.NrCsiRsrq = r6
            int r6 = r2.o
            r4.NrCsiSinr = r6
            int r6 = r2.p
            r4.NrSsRsrp = r6
            int r6 = r2.q
            r4.NrSsRsrq = r6
            int r6 = r2.r
            r4.NrSsSinr = r6
            com.umlaut.crowd.enums.NetworkTypes r6 = r4.NetworkType
            com.umlaut.crowd.enums.NetworkTypes r7 = com.umlaut.crowd.enums.NetworkTypes.LTE
            if (r6 == r7) goto L_0x0542
            com.umlaut.crowd.enums.NetworkTypes r9 = com.umlaut.crowd.enums.NetworkTypes.LTE_CA
            if (r6 != r9) goto L_0x0546
        L_0x0542:
            if (r0 <= r3) goto L_0x0546
            r4.RXLevel = r5
        L_0x0546:
            com.umlaut.crowd.enums.NetworkTypes r0 = com.umlaut.crowd.enums.NetworkTypes.LTE_CA
            if (r6 != r0) goto L_0x054e
            com.umlaut.crowd.internal.tb r0 = com.umlaut.crowd.internal.tb.Yes
            r4.CarrierAggregation = r0
        L_0x054e:
            com.umlaut.crowd.internal.tb r0 = r4.CarrierAggregation
            com.umlaut.crowd.internal.tb r3 = com.umlaut.crowd.internal.tb.Unknown
            if (r0 != r3) goto L_0x055a
            com.umlaut.crowd.internal.tb r0 = r1.a((com.umlaut.crowd.internal.j6[]) r8)
            r4.CarrierAggregation = r0
        L_0x055a:
            com.umlaut.crowd.enums.NetworkTypes r0 = r4.NetworkType
            if (r0 == r7) goto L_0x0562
            com.umlaut.crowd.enums.NetworkTypes r3 = com.umlaut.crowd.enums.NetworkTypes.NR
            if (r0 != r3) goto L_0x05c0
        L_0x0562:
            java.lang.String r0 = r4.MCC     // Catch:{ NumberFormatException -> 0x0571 }
            int r3 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0571 }
            java.lang.String r0 = r4.MNC     // Catch:{ NumberFormatException -> 0x056f }
            int r7 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x056f }
            goto L_0x058b
        L_0x056f:
            r0 = move-exception
            goto L_0x0573
        L_0x0571:
            r0 = move-exception
            r3 = 0
        L_0x0573:
            java.lang.String r5 = W
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "radioInfo: "
            r6.<init>(r7)
            java.lang.String r0 = r0.getMessage()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            android.util.Log.d(r5, r0)
            r7 = 0
        L_0x058b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            r0.append(r3)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.umlaut.crowd.internal.l7$o r3 = r1.g
            com.umlaut.crowd.internal.l7$q r0 = r3.a((java.lang.String) r0)
            if (r0 == 0) goto L_0x05c0
            long r5 = r0.a
            r4.NrCellId = r5
            int r3 = r0.b
            r4.NrTac = r3
            int r3 = r0.c
            r4.NrPci = r3
            int r3 = r0.e
            r4.NrARFCN = r3
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r7 = r0.d
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r7 / r9
            long r5 = r5 - r7
            int r0 = (int) r5
            r4.NrCellIdAge = r0
        L_0x05c0:
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r2 = r2.l
            long r5 = r5 - r2
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x05d2
            r6 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x05d3
        L_0x05d2:
            int r6 = (int) r5
        L_0x05d3:
            r4.RXLevelAge = r6
        L_0x05d5:
            return r4
        L_0x05d6:
            com.umlaut.crowd.internal.DRI r0 = r16.h()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.l7.i(int):com.umlaut.crowd.internal.DRI");
    }

    public NetworkTypes j(int i2) {
        if (l(i2) && PermissionUtils.hasReadPhoneStatePermission(this.c)) {
            SparseArray<TelephonyManager> sparseArray = this.b;
            if (sparseArray != null && sparseArray.get(i2) != null && Build.VERSION.SDK_INT >= 24) {
                return d(this.b.get(i2).getVoiceNetworkType());
            }
            Method method = this.u;
            if (method != null) {
                try {
                    return d(((Integer) method.invoke(this.a, new Object[]{Integer.valueOf(i2)})).intValue());
                } catch (Exception e2) {
                    String str = W;
                    Log.e(str, "getVoiceNetworkType: " + e2.toString());
                }
            }
        }
        return k();
    }

    public boolean l() {
        NetworkInfo activeNetworkInfo;
        if (this.f == null || this.c.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (activeNetworkInfo = this.f.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    private class r {
        int a;
        String b;

        private r() {
            this.a = -1;
            this.b = "";
        }

        /* synthetic */ r(l7 l7Var, d dVar) {
            this();
        }
    }

    private void b(int[] iArr) {
        this.e = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Handler(Looper.getMainLooper()).post(new h(iArr, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            Log.d(W, e2.toString());
        }
    }

    private void d(CellInfo cellInfo, z0 z0Var, long j2) {
        CellInfoNr cellInfoNr = (CellInfoNr) cellInfo;
        z0Var.IsRegistered = cellInfoNr.isRegistered();
        z0Var.CellNetworkType = a1.Nr;
        z0Var.CellInfoAge = j2 - (cellInfoNr.getTimeStamp() / 1000000);
        CellIdentity cellIdentity = cellInfoNr.getCellIdentity();
        if (cellIdentity instanceof CellIdentityNr) {
            CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity;
            z0Var.Arfcn = cellIdentityNr.getNrarfcn();
            z0Var.LtePci = cellIdentityNr.getPci();
            z0Var.LteTac = cellIdentityNr.getTac();
            z0Var.CellId = cellIdentityNr.getNci();
            if (cellIdentityNr.getMccString() != null) {
                try {
                    z0Var.Mcc = Integer.parseInt(cellIdentityNr.getMccString());
                } catch (NumberFormatException e2) {
                    String str = W;
                    Log.d(str, "cellIdentityNr.getMccString: " + e2.getMessage());
                }
            }
            if (cellIdentityNr.getMncString() != null) {
                try {
                    z0Var.Mnc = Integer.parseInt(cellIdentityNr.getMncString());
                } catch (NumberFormatException e3) {
                    String str2 = W;
                    Log.d(str2, "cellIdentityNr.getMncString: " + e3.getMessage());
                }
            }
        }
        CellSignalStrength cellSignalStrength = cellInfoNr.getCellSignalStrength();
        if (cellSignalStrength instanceof CellSignalStrengthNr) {
            CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) cellSignalStrength;
            z0Var.Dbm = cellSignalStrengthNr.getDbm();
            z0Var.NrCsiRsrp = cellSignalStrengthNr.getCsiRsrp();
            z0Var.NrCsiRsrq = cellSignalStrengthNr.getCsiRsrq();
            z0Var.NrCsiSinr = cellSignalStrengthNr.getCsiSinr();
            z0Var.NrSsRsrp = cellSignalStrengthNr.getSsRsrp();
            z0Var.NrSsRsrq = cellSignalStrengthNr.getSsRsrq();
            z0Var.NrSsSinr = cellSignalStrengthNr.getSsSinr();
        }
    }

    private class p extends BroadcastReceiver {
        public final String a;
        public final String b;
        public final String c;

        private p() {
            this.a = "android.intent.action.ANY_DATA_STATE";
            this.b = "com.samsung.ims.action.IMS_REGISTRATION";
            this.c = "com.samsung.intent.action.BIG_DATA_INFO";
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: boolean} */
        /* JADX WARNING: type inference failed for: r5v0 */
        /* JADX WARNING: type inference failed for: r5v2 */
        /* JADX WARNING: type inference failed for: r5v3, types: [int] */
        /* JADX WARNING: type inference failed for: r5v5 */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:36|(1:48)(3:42|(3:44|(2:46|82)(1:83)|47)|81)|49|(1:53)|54|55|56|59|60|61|62|63|(1:67)|(3:69|(1:71)|72)|73|(2:76|74)|84|93) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x014f */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x015e A[Catch:{ Exception -> 0x019e }] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0194 A[Catch:{ Exception -> 0x019e }, LOOP:2: B:74:0x018e->B:76:0x0194, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r13, android.content.Intent r14) {
            /*
                r12 = this;
                java.lang.String r13 = "bigdata_info"
                java.lang.String r0 = "subscription"
                if (r14 == 0) goto L_0x01a2
                java.lang.String r1 = r14.getAction()
                if (r1 != 0) goto L_0x000f
                goto L_0x01a2
            L_0x000f:
                java.lang.String r1 = r14.getAction()     // Catch:{ Exception -> 0x019e }
                android.os.Bundle r14 = r14.getExtras()     // Catch:{ Exception -> 0x019e }
                java.lang.String r2 = "android.intent.action.ANY_DATA_STATE"
                boolean r2 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x019e }
                java.lang.String r3 = ""
                r4 = -1
                if (r2 == 0) goto L_0x0057
                if (r14 == 0) goto L_0x0057
                java.lang.String r13 = "reason"
                java.lang.String r13 = r14.getString(r13, r3)     // Catch:{ Exception -> 0x019e }
                java.lang.String r1 = "apnType"
                java.lang.String r1 = r14.getString(r1, r3)     // Catch:{ Exception -> 0x019e }
                java.lang.Object r2 = r14.get(r0)     // Catch:{ Exception -> 0x019e }
                boolean r2 = r2 instanceof java.lang.Integer     // Catch:{ Exception -> 0x019e }
                if (r2 == 0) goto L_0x003d
                int r4 = r14.getInt(r0, r4)     // Catch:{ Exception -> 0x019e }
                goto L_0x004c
            L_0x003d:
                java.lang.Object r2 = r14.get(r0)     // Catch:{ Exception -> 0x019e }
                boolean r2 = r2 instanceof java.lang.Long     // Catch:{ Exception -> 0x019e }
                if (r2 == 0) goto L_0x004c
                r2 = -1
                long r2 = r14.getLong(r0, r2)     // Catch:{ Exception -> 0x019e }
                int r4 = (int) r2     // Catch:{ Exception -> 0x019e }
            L_0x004c:
                com.umlaut.crowd.internal.l7 r14 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.l7$o r14 = r14.g     // Catch:{ Exception -> 0x019e }
                r14.a(r4, r1, r13)     // Catch:{ Exception -> 0x019e }
                goto L_0x01a2
            L_0x0057:
                java.lang.String r0 = "com.samsung.ims.action.IMS_REGISTRATION"
                boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x019e }
                r2 = 0
                r5 = 0
                if (r0 == 0) goto L_0x00c6
                if (r14 == 0) goto L_0x00c6
                java.lang.String r13 = "SERVICE"
                java.lang.String r13 = r14.getString(r13)     // Catch:{ Exception -> 0x019e }
                java.lang.String r0 = "PHONE_ID"
                int r0 = r14.getInt(r0, r4)     // Catch:{ Exception -> 0x019e }
                java.lang.String r1 = "SIP_ERROR"
                int r1 = r14.getInt(r1, r4)     // Catch:{ Exception -> 0x019e }
                java.lang.String r6 = "VOWIFI"
                r14.getBoolean(r6, r5)     // Catch:{ Exception -> 0x019e }
                java.lang.String r6 = "REGISTERED"
                r14.getBoolean(r6, r5)     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.l7$r r14 = new com.umlaut.crowd.internal.l7$r     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.l7 r6 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x019e }
                r14.<init>(r6, r2)     // Catch:{ Exception -> 0x019e }
                r14.a = r1     // Catch:{ Exception -> 0x019e }
                if (r13 == 0) goto L_0x00a0
                java.lang.String r1 = "\\["
                java.lang.String r13 = r13.replaceAll(r1, r3)     // Catch:{ Exception -> 0x019e }
                java.lang.String r1 = "\\]"
                java.lang.String r13 = r13.replaceAll(r1, r3)     // Catch:{ Exception -> 0x019e }
                java.lang.String r1 = ", "
                java.lang.String r2 = ","
                java.lang.String r13 = r13.replace(r1, r2)     // Catch:{ Exception -> 0x019e }
                r14.b = r13     // Catch:{ Exception -> 0x019e }
            L_0x00a0:
                com.umlaut.crowd.internal.l7 r13 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x019e }
                android.content.Context r13 = r13.c     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.y5 r13 = com.umlaut.crowd.internal.CDC.e(r13)     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.o9[] r13 = r13.SimInfos     // Catch:{ Exception -> 0x019e }
                int r1 = r13.length     // Catch:{ Exception -> 0x019e }
            L_0x00ad:
                if (r5 >= r1) goto L_0x00bb
                r2 = r13[r5]     // Catch:{ Exception -> 0x019e }
                int r3 = r2.SimSlotIndex     // Catch:{ Exception -> 0x019e }
                if (r3 != r0) goto L_0x00b8
                int r4 = r2.SubscriptionId     // Catch:{ Exception -> 0x019e }
                goto L_0x00bb
            L_0x00b8:
                int r5 = r5 + 1
                goto L_0x00ad
            L_0x00bb:
                com.umlaut.crowd.internal.l7 r13 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.l7$o r13 = r13.g     // Catch:{ Exception -> 0x019e }
                r13.a((int) r4, (com.umlaut.crowd.internal.l7.r) r14)     // Catch:{ Exception -> 0x019e }
                goto L_0x01a2
            L_0x00c6:
                java.lang.String r0 = "com.samsung.intent.action.BIG_DATA_INFO"
                boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x019e }
                if (r0 == 0) goto L_0x01a2
                if (r14 == 0) goto L_0x01a2
                java.lang.Object r0 = r14.get(r13)     // Catch:{ Exception -> 0x019e }
                if (r0 == 0) goto L_0x01a2
                long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x019e }
                java.lang.String r3 = "simslot"
                int r3 = r14.getInt(r3, r4)     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.l7 r6 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.y5 r6 = r6.i     // Catch:{ Exception -> 0x019e }
                if (r6 == 0) goto L_0x00ff
                com.umlaut.crowd.internal.o9[] r6 = r6.SimInfos     // Catch:{ Exception -> 0x019e }
                if (r6 == 0) goto L_0x00ff
                int r7 = r6.length     // Catch:{ Exception -> 0x019e }
                if (r7 <= 0) goto L_0x00ff
                int r7 = r6.length     // Catch:{ Exception -> 0x019e }
                r8 = 0
                r9 = -1
            L_0x00f2:
                if (r8 >= r7) goto L_0x0100
                r10 = r6[r8]     // Catch:{ Exception -> 0x019e }
                int r11 = r10.SimSlotIndex     // Catch:{ Exception -> 0x019e }
                if (r11 != r3) goto L_0x00fc
                int r9 = r10.SubscriptionId     // Catch:{ Exception -> 0x019e }
            L_0x00fc:
                int r8 = r8 + 1
                goto L_0x00f2
            L_0x00ff:
                r9 = -1
            L_0x0100:
                java.lang.Object r13 = r14.get(r13)     // Catch:{ Exception -> 0x019e }
                java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x019e }
                org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x019e }
                r14.<init>(r13)     // Catch:{ Exception -> 0x019e }
                java.lang.String r3 = "C_ID"
                java.lang.String r3 = r14.optString(r3)     // Catch:{ Exception -> 0x019e }
                java.lang.String r3 = com.umlaut.crowd.internal.i1.a((java.lang.String) r3)     // Catch:{ Exception -> 0x019e }
                java.lang.String r6 = "LAC_"
                java.lang.String r6 = r14.optString(r6)     // Catch:{ Exception -> 0x019e }
                java.lang.String r6 = com.umlaut.crowd.internal.i1.a((java.lang.String) r6)     // Catch:{ Exception -> 0x019e }
                boolean r7 = r6.isEmpty()     // Catch:{ Exception -> 0x019e }
                if (r7 != 0) goto L_0x012f
                java.lang.String r7 = "0"
                boolean r7 = r6.equals(r7)     // Catch:{ Exception -> 0x019e }
                if (r7 == 0) goto L_0x0139
            L_0x012f:
                java.lang.String r6 = "TAC_"
                java.lang.String r6 = r14.optString(r6)     // Catch:{ Exception -> 0x019e }
                java.lang.String r6 = com.umlaut.crowd.internal.i1.a((java.lang.String) r6)     // Catch:{ Exception -> 0x019e }
            L_0x0139:
                java.lang.String r7 = "PhID"
                java.lang.String r7 = r14.optString(r7)     // Catch:{ Exception -> 0x0144 }
                int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x0144 }
                goto L_0x0145
            L_0x0144:
                r7 = -1
            L_0x0145:
                java.lang.String r8 = "DLCh"
                java.lang.String r14 = r14.optString(r8)     // Catch:{ Exception -> 0x014f }
                int r4 = java.lang.Integer.parseInt(r14)     // Catch:{ Exception -> 0x014f }
            L_0x014f:
                boolean r14 = r3.isEmpty()     // Catch:{ Exception -> 0x019e }
                if (r14 != 0) goto L_0x015c
                boolean r14 = r6.isEmpty()     // Catch:{ Exception -> 0x019e }
                if (r14 != 0) goto L_0x015c
                r5 = 1
            L_0x015c:
                if (r5 == 0) goto L_0x0184
                com.umlaut.crowd.internal.l7 r14 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.l7$o r14 = r14.g     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.l7$n r14 = r14.a((int) r9)     // Catch:{ Exception -> 0x019e }
                if (r14 != 0) goto L_0x0171
                com.umlaut.crowd.internal.l7$n r14 = new com.umlaut.crowd.internal.l7$n     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.l7 r8 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x019e }
                r14.<init>(r8, r2)     // Catch:{ Exception -> 0x019e }
            L_0x0171:
                r14.d = r6     // Catch:{ Exception -> 0x019e }
                r14.e = r7     // Catch:{ Exception -> 0x019e }
                r14.c = r3     // Catch:{ Exception -> 0x019e }
                r14.f = r4     // Catch:{ Exception -> 0x019e }
                r14.g = r0     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.l7$o r0 = r0.g     // Catch:{ Exception -> 0x019e }
                r0.a((int) r9, (com.umlaut.crowd.internal.l7.n) r14)     // Catch:{ Exception -> 0x019e }
            L_0x0184:
                com.umlaut.crowd.internal.l7 r14 = com.umlaut.crowd.internal.l7.this     // Catch:{ Exception -> 0x019e }
                java.util.Set r14 = r14.U     // Catch:{ Exception -> 0x019e }
                java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x019e }
            L_0x018e:
                boolean r0 = r14.hasNext()     // Catch:{ Exception -> 0x019e }
                if (r0 == 0) goto L_0x01a2
                java.lang.Object r0 = r14.next()     // Catch:{ Exception -> 0x019e }
                com.umlaut.crowd.internal.m7 r0 = (com.umlaut.crowd.internal.m7) r0     // Catch:{ Exception -> 0x019e }
                r0.a((java.lang.String) r13, (boolean) r5, (int) r9)     // Catch:{ Exception -> 0x019e }
                goto L_0x018e
            L_0x019e:
                r13 = move-exception
                r13.printStackTrace()
            L_0x01a2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.l7.p.onReceive(android.content.Context, android.content.Intent):void");
        }

        /* synthetic */ p(l7 l7Var, d dVar) {
            this();
        }
    }

    private boolean n() {
        return Settings.Global.getInt(this.R, "airplane_mode_on", 0) != 0;
    }

    private class q {
        long a;
        int b;
        int c;
        long d;
        int e;

        private q() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
        }

        /* synthetic */ q(l7 l7Var, d dVar) {
            this();
        }
    }

    private class s {
        g9 a;
        long b;
        j2 c;
        tb d;
        int e;
        tb f;
        public String g;

        private s() {
            this.a = g9.Unknown;
            this.b = 0;
            this.c = j2.Unknown;
            tb tbVar = tb.Unknown;
            this.d = tbVar;
            this.e = -1;
            this.f = tbVar;
            this.g = "";
        }

        /* synthetic */ s(l7 l7Var, d dVar) {
            this();
        }
    }

    public z0[] a(boolean z2) {
        List<CellInfo> list;
        if (this.c.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0 || (this.c.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && Build.VERSION.SDK_INT >= 29)) {
            return new z0[0];
        }
        ArrayList arrayList = new ArrayList();
        TelephonyManager telephonyManager = this.a;
        if (telephonyManager != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (z2 || (list = this.k) == null) {
                if (i2 >= 29) {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.a.requestCellInfoUpdate(ThreadManager.getInstance().getCachedThreadPool(), new l(countDownLatch));
                    try {
                        countDownLatch.await(500, TimeUnit.MILLISECONDS);
                        list = null;
                    } catch (InterruptedException unused) {
                        list = this.a.getAllCellInfo();
                    }
                } else {
                    list = telephonyManager.getAllCellInfo();
                }
                if (this.k != null && (list == null || list.isEmpty())) {
                    list = this.k;
                }
            }
            if (list == null) {
                return new z0[0];
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (CellInfo next : list) {
                z0 z0Var = new z0();
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 28) {
                    z0Var.CellConnectionStatus = g(next.getCellConnectionStatus());
                }
                if (next instanceof CellInfoGsm) {
                    b(next, z0Var, elapsedRealtime);
                } else if (next instanceof CellInfoLte) {
                    c(next, z0Var, elapsedRealtime);
                } else if (next instanceof CellInfoWcdma) {
                    e(next, z0Var, elapsedRealtime);
                } else if (next instanceof CellInfoCdma) {
                    a(next, z0Var, elapsedRealtime);
                } else if (i3 >= 29 && (next instanceof CellInfoNr)) {
                    try {
                        d(next, z0Var, elapsedRealtime);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                arrayList.add(z0Var);
            }
        }
        return (z0[]) arrayList.toArray(new z0[arrayList.size()]);
    }

    private class n {
        CellLocation a;
        long b;
        String c;
        String d;
        int e;
        int f;
        long g;

        private n() {
            this.b = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
        }

        /* synthetic */ n(l7 l7Var, d dVar) {
            this();
        }
    }

    public NetworkTypes k() {
        if (PermissionUtils.hasReadPhoneStatePermission(this.c)) {
            TelephonyManager telephonyManager = this.a;
            if (telephonyManager != null && Build.VERSION.SDK_INT >= 24) {
                return d(telephonyManager.getVoiceNetworkType());
            }
            Method method = this.t;
            if (method != null) {
                try {
                    return d(((Integer) method.invoke(telephonyManager, new Object[0])).intValue());
                } catch (Exception e2) {
                    String str = W;
                    Log.e(str, "getVoiceNetworkType: " + e2.toString());
                }
            }
        }
        return NetworkTypes.Unknown;
    }

    private class m {
        int a;
        String b;
        String c;
        String d;
        String e;
        String f;
        int g;
        long h;
        long i;
        String j;
        fe k;

        private m() {
            this.a = -1;
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = "";
            this.k = fe.Unknown;
        }

        /* synthetic */ m(l7 l7Var, d dVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        SubscriptionManager subscriptionManager;
        this.S = new int[0];
        B();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            y();
        }
        if (z2 && this.h != null && this.c.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && i2 >= 22 && (subscriptionManager = (SubscriptionManager) this.c.getSystemService("telephony_subscription_service")) != null) {
            subscriptionManager.addOnSubscriptionsChangedListener(this.h);
        }
        if (this.a != null) {
            int i3 = ((i2 >= 29 || this.c.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) && !(this.c.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && (InsightCore.getForegroundTestManager().d() == 1 || this.c.checkCallingOrSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") == 0))) ? 257 : (i2 < 31 || (i2 >= 31 && PermissionUtils.hasReadPhoneStatePermission(this.c))) ? 1297 : 273;
            if ((i2 >= 30 && PermissionUtils.hasReadPhoneStatePermission(this.c)) || i2 >= 31) {
                i3 |= 1048576;
            }
            b(this.S);
            if (this.e.size() == 0) {
                if (this.d == null) {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    new Handler(Looper.getMainLooper()).post(new j(countDownLatch));
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e2) {
                        Log.d(W, e2.toString());
                    }
                }
                try {
                    this.a.listen(this.d, i3);
                } catch (SecurityException e3) {
                    String str = W;
                    Log.e(str, "startListening: " + e3.toString());
                    this.a.listen(this.d, 257);
                }
            } else {
                Iterator<u> it = this.e.iterator();
                while (it.hasNext()) {
                    u next = it.next();
                    SparseArray<TelephonyManager> sparseArray = this.b;
                    TelephonyManager telephonyManager = (sparseArray == null || sparseArray.size() <= 0) ? null : this.b.get(next.a());
                    if (telephonyManager == null) {
                        telephonyManager = this.a;
                    }
                    try {
                        telephonyManager.listen(next, i3);
                    } catch (SecurityException e4) {
                        String str2 = W;
                        Log.e(str2, "startListening: " + e4.toString());
                        telephonyManager.listen(next, 257);
                    }
                }
            }
        }
    }

    private class t {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;
        int j;
        int k;
        long l;
        int m;
        int n;
        int o;
        int p;
        int q;
        int r;

        private t() {
            Integer num = DRI.INVALID;
            this.a = num.intValue();
            this.b = num.intValue();
            this.c = num.intValue();
            this.d = num.intValue();
            this.e = num.intValue();
            this.f = num.intValue();
            this.g = num.intValue();
            this.h = num.intValue();
            this.i = num.intValue();
            this.j = num.intValue();
            this.k = num.intValue();
            this.m = num.intValue();
            this.n = num.intValue();
            this.o = num.intValue();
            this.p = num.intValue();
            this.q = num.intValue();
            this.r = num.intValue();
        }

        /* synthetic */ t(l7 l7Var, d dVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public void c(Context context) {
        p pVar;
        if (context != null && (pVar = this.j) != null) {
            try {
                context.unregisterReceiver(pVar);
            } catch (Exception e2) {
                String str = W;
                Log.e(str, "stopNetworkBroadcastReceiver: " + e2.toString());
            }
        }
    }

    public ConnectionTypes e() {
        NetworkInfo activeNetworkInfo;
        ConnectionTypes connectionTypes = ConnectionTypes.Unknown;
        if (this.f == null || this.c.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (activeNetworkInfo = this.f.getActiveNetworkInfo()) == null) {
            return connectionTypes;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            return ConnectionTypes.Mobile;
        }
        if (type == 1) {
            return ConnectionTypes.WiFi;
        }
        if (type == 6) {
            return ConnectionTypes.WiMAX;
        }
        if (type == 7) {
            return ConnectionTypes.Bluetooth;
        }
        if (type != 9) {
            return connectionTypes;
        }
        return ConnectionTypes.Ethernet;
    }

    private void c(CellInfo cellInfo, z0 z0Var, long j2) {
        CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
        z0Var.IsRegistered = cellInfoLte.isRegistered();
        z0Var.CellNetworkType = a1.Lte;
        z0Var.CellInfoAge = j2 - (cellInfoLte.getTimeStamp() / 1000000);
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            z0Var.Mcc = cellIdentity.getMcc();
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            z0Var.Mnc = cellIdentity.getMnc();
        }
        if (cellIdentity.getCi() != Integer.MAX_VALUE) {
            int ci = cellIdentity.getCi();
            z0Var.Cid = ci;
            z0Var.CellId = (long) ci;
        }
        if (cellIdentity.getPci() != Integer.MAX_VALUE) {
            z0Var.LtePci = cellIdentity.getPci();
        }
        if (cellIdentity.getTac() != Integer.MAX_VALUE) {
            z0Var.LteTac = cellIdentity.getTac();
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24 && cellIdentity.getEarfcn() != Integer.MAX_VALUE) {
            int earfcn = cellIdentity.getEarfcn();
            z0Var.Arfcn = earfcn;
            x4 a2 = y4.a(earfcn);
            if (a2 != null) {
                z0Var.LteBand = a2.band;
                z0Var.LteUploadEarfcn = a2.upload_earfcn;
                z0Var.LteDownloadEarfcn = a2.download_earfcn;
                z0Var.LteUploadFrequency = a2.upload_frequency;
                z0Var.LteDonwloadFrequency = a2.download_frequency;
            }
        }
        CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
        z0Var.Dbm = cellSignalStrength.getDbm();
        if (cellSignalStrength.getTimingAdvance() != Integer.MAX_VALUE) {
            z0Var.LteTimingAdvance = cellSignalStrength.getTimingAdvance();
        }
        if (i2 >= 29) {
            int cqi = cellSignalStrength.getCqi();
            if (cqi != Integer.MAX_VALUE) {
                z0Var.LteCqi = cqi;
            }
            z0Var.LteRssnr = cellSignalStrength.getRssnr();
            z0Var.LteRsrq = cellSignalStrength.getRsrq();
            z0Var.LteRssi = cellSignalStrength.getRssi();
            return;
        }
        Field field = this.J;
        if (field != null) {
            try {
                int i3 = field.getInt(cellSignalStrength);
                if (i3 != Integer.MAX_VALUE) {
                    z0Var.LteCqi = i3;
                }
            } catch (IllegalAccessException unused) {
            }
        }
        Field field2 = this.H;
        if (field2 != null) {
            try {
                z0Var.LteRsrq = field2.getInt(cellSignalStrength);
            } catch (IllegalAccessException unused2) {
            }
        }
        Field field3 = this.I;
        if (field3 != null) {
            try {
                z0Var.LteRssnr = field3.getInt(cellSignalStrength);
            } catch (IllegalAccessException unused3) {
            }
        }
        Field field4 = this.G;
        if (field4 != null) {
            try {
                z0Var.LteRssi = field4.getInt(cellSignalStrength);
            } catch (IllegalAccessException unused4) {
            }
        }
    }

    public static NetworkTypes d(int i2) {
        switch (i2) {
            case 1:
                return NetworkTypes.GPRS;
            case 2:
                return NetworkTypes.EDGE;
            case 3:
                return NetworkTypes.UMTS;
            case 4:
                return NetworkTypes.CDMA;
            case 5:
                return NetworkTypes.EVDO_0;
            case 6:
                return NetworkTypes.EVDO_A;
            case 7:
                return NetworkTypes.Cdma1xRTT;
            case 8:
                return NetworkTypes.HSDPA;
            case 9:
                return NetworkTypes.HSUPA;
            case 10:
                return NetworkTypes.HSPA;
            case 11:
                return NetworkTypes.IDEN;
            case 12:
                return NetworkTypes.EVDO_B;
            case 13:
                return NetworkTypes.LTE;
            case 14:
                return NetworkTypes.EHRPD;
            case 15:
                return NetworkTypes.HSPAP;
            case 16:
                return NetworkTypes.GSM;
            case 17:
                return NetworkTypes.TD_SCDMA;
            case 18:
                return NetworkTypes.WiFi;
            case 19:
                return NetworkTypes.LTE_CA;
            case 20:
                return NetworkTypes.NR;
            default:
                return NetworkTypes.Unknown;
        }
    }

    public static NetworkTypes e(int i2) {
        if (i2 == 0) {
            return NetworkTypes.None;
        }
        if (i2 == 1) {
            return NetworkTypes.LTE_CA;
        }
        if (i2 == 2) {
            return NetworkTypes.LTE_AP;
        }
        if (i2 == 3) {
            return NetworkTypes.NR_NSA;
        }
        if (i2 == 4) {
            return NetworkTypes.NR_NSA_MMWAVE;
        }
        if (i2 != 5) {
            return NetworkTypes.Unknown;
        }
        return NetworkTypes.NR_ADVANCED;
    }

    /* access modifiers changed from: private */
    public void b(Context context) {
        if (this.j == null) {
            this.j = new p(this, (d) null);
        }
        Objects.requireNonNull(this.j);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.ANY_DATA_STATE");
        Objects.requireNonNull(this.j);
        intentFilter.addAction("com.samsung.ims.action.IMS_REGISTRATION");
        Objects.requireNonNull(this.j);
        intentFilter.addAction("com.samsung.intent.action.BIG_DATA_INFO");
        context.registerReceiver(this.j, intentFilter);
    }

    private void b(CellInfo cellInfo, z0 z0Var, long j2) {
        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
        z0Var.IsRegistered = cellInfoGsm.isRegistered();
        z0Var.CellNetworkType = a1.Gsm;
        z0Var.CellInfoAge = j2 - (cellInfoGsm.getTimeStamp() / 1000000);
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            z0Var.Mcc = cellIdentity.getMcc();
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            z0Var.Mnc = cellIdentity.getMnc();
        }
        if (cellIdentity.getCid() != Integer.MAX_VALUE) {
            int cid = cellIdentity.getCid();
            z0Var.Cid = cid;
            z0Var.CellId = (long) cid;
        }
        if (cellIdentity.getLac() != Integer.MAX_VALUE) {
            z0Var.Lac = cellIdentity.getLac();
        }
        if (cellIdentity.getPsc() != Integer.MAX_VALUE) {
            z0Var.Psc = cellIdentity.getPsc();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            if (cellIdentity.getArfcn() != Integer.MAX_VALUE) {
                z0Var.Arfcn = cellIdentity.getArfcn();
            }
            if (cellIdentity.getBsic() != Integer.MAX_VALUE) {
                z0Var.GsmBsic = cellIdentity.getBsic();
            }
        }
        z0Var.Dbm = cellInfoGsm.getCellSignalStrength().getDbm();
    }

    public y5 c() {
        return this.i;
    }

    public static o6 c(j6[] j6VarArr) {
        if (j6VarArr != null) {
            for (j6 j6Var : j6VarArr) {
                if (j6Var.Domain == i2.PS && j6Var.TransportType == qc.WWAN) {
                    return j6Var.NrState;
                }
            }
        }
        return o6.Unknown;
    }

    public g[] b() {
        r e2;
        ArrayList arrayList = new ArrayList();
        for (m next : s()) {
            g gVar = new g();
            gVar.Apn = next.b;
            gVar.TxBytes = next.h;
            gVar.RxBytes = next.i;
            gVar.ApnTypes = next.d;
            gVar.Capabilities = next.e;
            gVar.InterfaceName = next.j;
            gVar.SubscriptionId = next.g;
            String str = next.f;
            gVar.PcscfAddresses_Full = str;
            gVar.PcscfAddresses = h.a(str, InsightCore.getInsightConfig().b());
            gVar.MobileDataConnectionState = next.k;
            gVar.NetworkType = d(next.a);
            gVar.Reason = this.g.a(next.g, next.d);
            if (gVar.ApnTypes.contains("ims") && (e2 = this.g.e(next.g)) != null) {
                gVar.SamsungSipError = e2.a;
                gVar.SamsungImsServices = e2.b;
            }
            arrayList.add(gVar);
        }
        return (g[]) arrayList.toArray(new g[arrayList.size()]);
    }

    public tb d(j6[] j6VarArr) {
        if (j6VarArr != null) {
            for (j6 j6Var : j6VarArr) {
                if (j6Var.Domain == i2.PS && j6Var.TransportType == qc.WWAN) {
                    return j6Var.NrAvailable;
                }
            }
        }
        return tb.Unknown;
    }

    private void a(CellInfo cellInfo, z0 z0Var, long j2) {
        CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
        z0Var.IsRegistered = cellInfoCdma.isRegistered();
        z0Var.CellNetworkType = a1.Cdma;
        z0Var.CellInfoAge = j2 - (cellInfoCdma.getTimeStamp() / 1000000);
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        z0Var.CdmaBaseStationLatitude = cellIdentity.getLatitude();
        z0Var.CdmaBaseStationLongitude = cellIdentity.getLongitude();
        if (cellIdentity.getSystemId() != Integer.MAX_VALUE) {
            z0Var.CdmaSystemId = cellIdentity.getSystemId();
        }
        if (cellIdentity.getNetworkId() != Integer.MAX_VALUE) {
            z0Var.CdmaNetworkId = cellIdentity.getNetworkId();
        }
        if (cellIdentity.getBasestationId() != Integer.MAX_VALUE) {
            z0Var.CdmaBaseStationId = cellIdentity.getBasestationId();
        }
        CellSignalStrengthCdma cellSignalStrength = cellInfoCdma.getCellSignalStrength();
        z0Var.Dbm = cellSignalStrength.getDbm();
        z0Var.CdmaDbm = cellSignalStrength.getCdmaDbm();
        z0Var.CdmaEcio = cellSignalStrength.getCdmaEcio();
        z0Var.EvdoDbm = cellSignalStrength.getEvdoDbm();
        z0Var.EvdoEcio = cellSignalStrength.getEvdoEcio();
        z0Var.EvdoSnr = cellSignalStrength.getEvdoSnr();
    }

    public static l9 b(DRI dri) {
        int i2;
        if (dri == null) {
            return l9.Unknown;
        }
        int i3 = dri.RXLevel;
        NetworkGenerations a2 = a(dri.NetworkType, o6.Unknown, NetworkTypes.Unknown);
        NetworkGenerations networkGenerations = NetworkGenerations.Gen5SA;
        if (a2 == networkGenerations && (i2 = dri.NrCsiRsrp) < -1) {
            i3 = i2;
        }
        if (i3 == 0) {
            return l9.Unknown;
        }
        IC insightConfig = InsightCore.getInsightConfig();
        int[] p1 = insightConfig.p1();
        int[] q1 = insightConfig.q1();
        int[] r1 = insightConfig.r1();
        int[] s1 = insightConfig.s1();
        if (a2 == NetworkGenerations.Gen2) {
            if (i3 >= p1[0]) {
                return l9.Excellent;
            }
            if (i3 >= p1[1]) {
                return l9.Good;
            }
            if (i3 >= p1[2]) {
                return l9.Fair;
            }
            if (i3 >= p1[3]) {
                return l9.Poor;
            }
            return l9.Bad;
        } else if (a2 == NetworkGenerations.Gen3) {
            if (i3 >= q1[0]) {
                return l9.Excellent;
            }
            if (i3 >= q1[1]) {
                return l9.Good;
            }
            if (i3 >= q1[2]) {
                return l9.Fair;
            }
            if (i3 >= q1[3]) {
                return l9.Poor;
            }
            return l9.Bad;
        } else if (a2 == NetworkGenerations.Gen4) {
            if (i3 >= r1[0]) {
                return l9.Excellent;
            }
            if (i3 >= r1[1]) {
                return l9.Good;
            }
            if (i3 >= r1[2]) {
                return l9.Fair;
            }
            if (i3 >= r1[3]) {
                return l9.Poor;
            }
            return l9.Bad;
        } else if (a2 != networkGenerations) {
            return l9.Unknown;
        } else {
            if (i3 >= s1[0]) {
                return l9.Excellent;
            }
            if (i3 >= s1[1]) {
                return l9.Good;
            }
            if (i3 >= s1[2]) {
                return l9.Fair;
            }
            if (i3 >= s1[3]) {
                return l9.Poor;
            }
            return l9.Bad;
        }
    }

    private boolean a(z0 z0Var, DRI dri) {
        try {
            if (dri.MCC.isEmpty() || dri.MNC.isEmpty() || !z0Var.IsRegistered || z0Var.Mcc != Integer.parseInt(dri.MCC) || z0Var.Mnc != Integer.parseInt(dri.MNC)) {
                return false;
            }
            NetworkTypes j2 = j(dri.SubscriptionId);
            NetworkTypes networkTypes = NetworkTypes.Unknown;
            if (j2 == networkTypes) {
                j2 = dri.NetworkType;
            }
            if (j2 == networkTypes || z0Var.CellNetworkType == a(j2)) {
                return true;
            }
            return false;
        } catch (NumberFormatException e2) {
            String str = W;
            Log.e(str, "isRegisteredCell: " + e2.toString());
            return false;
        }
    }

    @Deprecated
    private c6[] a(DRI dri) {
        if (this.a == null) {
            return null;
        }
        try {
            if (this.c.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
                dri.MissingPermission = true;
            }
            return null;
        } catch (Exception e2) {
            String str = W;
            Log.e(str, "getNeighboringCells: " + e2.toString());
            return null;
        }
    }

    public static NetworkTypes a(String str) {
        str.hashCode();
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2039427040:
                if (str.equals("LTE_CA")) {
                    c2 = 0;
                    break;
                }
                break;
            case -908593671:
                if (str.equals("TD_SCDMA")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2500:
                if (str.equals("NR")) {
                    c2 = 2;
                    break;
                }
                break;
            case 70881:
                if (str.equals("GSM")) {
                    c2 = 3;
                    break;
                }
                break;
            case 75709:
                if (str.equals("LTE")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2063797:
                if (str.equals("CDMA")) {
                    c2 = 5;
                    break;
                }
                break;
            case 2123197:
                if (str.equals("EDGE")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2194666:
                if (str.equals("GPRS")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2227260:
                if (str.equals("HSPA")) {
                    c2 = 8;
                    break;
                }
                break;
            case 2608919:
                if (str.equals("UMTS")) {
                    c2 = 9;
                    break;
                }
                break;
            case 3195620:
                if (str.equals("iDEN")) {
                    c2 = 10;
                    break;
                }
                break;
            case 69034058:
                if (str.equals("HSDPA")) {
                    c2 = 11;
                    break;
                }
                break;
            case 69045140:
                if (str.equals("HSPAP")) {
                    c2 = 12;
                    break;
                }
                break;
            case 69050395:
                if (str.equals("HSUPA")) {
                    c2 = 13;
                    break;
                }
                break;
            case 70083979:
                if (str.equals("IWLAN")) {
                    c2 = 14;
                    break;
                }
                break;
            case 836263277:
                if (str.equals("CDMA - 1xRTT")) {
                    c2 = 15;
                    break;
                }
                break;
            case 882856261:
                if (str.equals("CDMA - eHRPD")) {
                    c2 = 16;
                    break;
                }
                break;
            case 893165057:
                if (str.equals("CDMA - EvDo rev. 0")) {
                    c2 = 17;
                    break;
                }
                break;
            case 893165074:
                if (str.equals("CDMA - EvDo rev. A")) {
                    c2 = 18;
                    break;
                }
                break;
            case 893165075:
                if (str.equals("CDMA - EvDo rev. B")) {
                    c2 = 19;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return NetworkTypes.LTE_CA;
            case 1:
                return NetworkTypes.TD_SCDMA;
            case 2:
                return NetworkTypes.NR;
            case 3:
                return NetworkTypes.GSM;
            case 4:
                return NetworkTypes.LTE;
            case 5:
                return NetworkTypes.CDMA;
            case 6:
                return NetworkTypes.EDGE;
            case 7:
                return NetworkTypes.GPRS;
            case 8:
                return NetworkTypes.HSPA;
            case 9:
                return NetworkTypes.UMTS;
            case 10:
                return NetworkTypes.IDEN;
            case 11:
                return NetworkTypes.HSDPA;
            case 12:
                return NetworkTypes.HSPAP;
            case 13:
                return NetworkTypes.HSUPA;
            case 14:
                return NetworkTypes.WiFi;
            case 15:
                return NetworkTypes.Cdma1xRTT;
            case 16:
                return NetworkTypes.EHRPD;
            case 17:
                return NetworkTypes.EVDO_0;
            case 18:
                return NetworkTypes.EVDO_A;
            case 19:
                return NetworkTypes.EVDO_B;
            default:
                return NetworkTypes.Unknown;
        }
    }

    public void b(m7 m7Var) {
        this.U.remove(m7Var);
    }

    public NetworkTypes b(j6[] j6VarArr) {
        if (j6VarArr != null) {
            for (j6 j6Var : j6VarArr) {
                if (j6Var.Domain == i2.PS && j6Var.TransportType == qc.WWAN) {
                    return j6Var.NetworkTechnology;
                }
            }
        }
        return NetworkTypes.Unknown;
    }

    public j6[] h(int i2) {
        j6[] b2 = this.g.b(i2);
        if (b2 == null) {
            return new j6[0];
        }
        s f2 = this.g.f(i2);
        for (j6 j6Var : b2) {
            if (f2 != null && f2.b > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - f2.b;
                j6Var.Age = elapsedRealtime > 2147483647L ? Integer.MAX_VALUE : (int) elapsedRealtime;
            }
        }
        return b2;
    }

    public static NetworkGenerations a(NetworkTypes networkTypes, o6 o6Var, NetworkTypes networkTypes2) {
        if (networkTypes == NetworkTypes.LTE && (o6Var == o6.CONNECTED || (Build.VERSION.SDK_INT >= 31 && (networkTypes2 == NetworkTypes.NR_ADVANCED || networkTypes2 == NetworkTypes.NR_NSA || networkTypes2 == NetworkTypes.NR_NSA_MMWAVE)))) {
            return NetworkGenerations.Gen5NSA;
        }
        switch (c.a[networkTypes.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return NetworkGenerations.Gen2;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                return NetworkGenerations.Gen3;
            case 17:
            case 18:
                return NetworkGenerations.Gen4;
            case 19:
                return NetworkGenerations.Gen5SA;
            default:
                return NetworkGenerations.Unknown;
        }
    }

    private static a1 a(NetworkTypes networkTypes) {
        if (networkTypes == NetworkTypes.CDMA) {
            return a1.Cdma;
        }
        int i2 = c.b[a(networkTypes, o6.Unknown, NetworkTypes.Unknown).ordinal()];
        if (i2 == 1) {
            return a1.Gsm;
        }
        if (i2 == 2) {
            return a1.Wcdma;
        }
        if (i2 == 3) {
            return a1.Lte;
        }
        if (i2 != 4) {
            return a1.Unknown;
        }
        return a1.Nr;
    }

    private z6 a(Context context, int i2) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return f(Settings.Global.getInt(contentResolver, "preferred_network_mode" + i2));
        } catch (Exception unused) {
            return z6.Unknown;
        }
    }

    private SparseArray<z6> a(Context context) {
        SparseArray<z6> sparseArray = new SparseArray<>();
        try {
            String[] split = Settings.Global.getString(context.getContentResolver(), "preferred_network_mode").split(",");
            for (int i2 = 0; i2 < split.length; i2++) {
                sparseArray.put(i2, f(Integer.valueOf(split[i2]).intValue()));
            }
        } catch (Exception unused) {
        }
        return sparseArray;
    }

    public void a(m7 m7Var) {
        this.U.add(m7Var);
    }

    public tb a(j6[] j6VarArr) {
        if (j6VarArr != null) {
            for (j6 j6Var : j6VarArr) {
                if (j6Var.Domain == i2.PS && j6Var.TransportType == qc.WWAN) {
                    return j6Var.CarrierAggregation;
                }
            }
        }
        return tb.Unknown;
    }

    private static boolean a(NetworkInterface networkInterface, g[] gVarArr) {
        if (gVarArr != null && gVarArr.length > 0) {
            for (g gVar : gVarArr) {
                if (networkInterface.getName().equalsIgnoreCase(gVar.InterfaceName) && !gVar.Capabilities.toLowerCase().contains("internet")) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public String a(int[] iArr) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));
        StringBuilder sb = new StringBuilder();
        for (int i2 : iArr) {
            sb.append(Marker.ANY_NON_NULL_MARKER);
            double d2 = (double) i2;
            Double.isNaN(d2);
            sb.append(decimalFormat.format(d2 / 1000.0d));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
