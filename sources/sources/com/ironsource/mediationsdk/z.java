package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.a;
import com.ironsource.mediationsdk.E;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adquality.AdQualityBridge;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.adunit.c.f;
import com.ironsource.mediationsdk.adunit.data.DataKeys;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.demandOnly.c;
import com.ironsource.mediationsdk.demandOnly.e;
import com.ironsource.mediationsdk.demandOnly.n;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.demandOnly.r;
import com.ironsource.mediationsdk.events.ISErrorListener;
import com.ironsource.mediationsdk.events.i;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.d;
import com.ironsource.mediationsdk.model.g;
import com.ironsource.mediationsdk.model.l;
import com.ironsource.mediationsdk.model.q;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.e;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.h;
import com.ironsource.mediationsdk.utils.j;
import com.ironsource.mediationsdk.utils.k;
import com.ironsource.sdk.controller.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class z implements h {
    private static boolean ao = false;
    public f A;
    public com.ironsource.mediationsdk.adunit.c.h B;
    public com.ironsource.mediationsdk.adunit.c.b C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    int J;
    com.ironsource.mediationsdk.demandOnly.f K;
    c L;
    com.ironsource.mediationsdk.impressionData.a M;
    com.ironsource.mediationsdk.b.a N;
    public boolean O;
    AdQualityBridge P;
    n<ISDemandOnlyInterstitialListener> Q;
    private final String R;
    private AbstractAdapter S;
    private AtomicBoolean T;
    private final Object U;
    private String V;
    private AtomicBoolean W;
    private List<IronSource.AD_UNIT> X;
    private Set<IronSource.AD_UNIT> Y;
    private Set<IronSource.AD_UNIT> Z;
    final String a;
    private boolean aa;
    private final String ab;
    private boolean ac;
    private boolean ad;
    private Boolean ae;
    private IronSourceBannerLayout af;
    private String ag;
    private InitializationListener ah;
    private AtomicBoolean ai;
    private final ConcurrentHashMap<String, p.c> aj;
    private final ConcurrentHashMap<String, p.b> ak;
    private CopyOnWriteArraySet<String> al;
    private com.ironsource.mediationsdk.demandOnly.h am;
    private W an;
    private ISErrorListener ap;
    H b;
    IronSourceLoggerManager c;
    e d;
    com.ironsource.mediationsdk.logger.b e;
    public k f;
    public String g;
    public String h;
    public String i;
    public Map<String, String> j;
    public String k;
    boolean l;
    public String m;
    Context n;
    Boolean o;
    IronSourceSegment p;
    int q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    public boolean v;
    Boolean w;
    C0230t x;
    L y;
    I z;

    /* renamed from: com.ironsource.mediationsdk.z$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006e */
        static {
            /*
                int[] r0 = com.ironsource.mediationsdk.utils.j.a.a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                c = r0
                r1 = 1
                int r2 = com.ironsource.mediationsdk.utils.j.a.a     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = c     // Catch:{ NoSuchFieldError -> 0x0016 }
                int r3 = com.ironsource.mediationsdk.utils.j.a.b     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r2 = 3
                int[] r3 = c     // Catch:{ NoSuchFieldError -> 0x001d }
                int r4 = com.ironsource.mediationsdk.utils.j.a.c     // Catch:{ NoSuchFieldError -> 0x001d }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r3 = 4
                int[] r4 = c     // Catch:{ NoSuchFieldError -> 0x0024 }
                int r5 = com.ironsource.mediationsdk.utils.j.a.d     // Catch:{ NoSuchFieldError -> 0x0024 }
                r4[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                com.ironsource.mediationsdk.E$a[] r4 = com.ironsource.mediationsdk.E.a.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                b = r4
                com.ironsource.mediationsdk.E$a r5 = com.ironsource.mediationsdk.E.a.INIT_FAILED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x003f }
                com.ironsource.mediationsdk.E$a r5 = com.ironsource.mediationsdk.E.a.INIT_IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x003f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003f }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x003f }
            L_0x003f:
                com.ironsource.mediationsdk.IronSource$AD_UNIT[] r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                a = r4
                com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x005a }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.NATIVE_AD     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.AnonymousClass2.<clinit>():void");
        }
    }

    public interface a {
        void a(String str);
    }

    static class b {
        static volatile z a = new z((byte) 0);
    }

    private z() {
        this.a = getClass().getName();
        this.R = "!SDK-VERSION-STRING!:com.ironsource:mediationsdk:​7.5.1";
        this.U = new Object();
        this.f = null;
        this.g = null;
        this.h = "";
        this.V = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.o = null;
        this.aa = true;
        this.ab = IronSourceConstants.KEY_SESSION_DEPTH;
        this.w = null;
        this.O = false;
        this.c = IronSourceLoggerManager.getLogger(0);
        com.ironsource.mediationsdk.logger.b bVar = new com.ironsource.mediationsdk.logger.b((LogListener) null, 1);
        this.e = bVar;
        this.c.addLogger(bVar);
        this.d = new e();
        H h2 = new H();
        this.b = h2;
        h2.b = this.d;
        this.T = new AtomicBoolean();
        this.Y = new HashSet();
        this.Z = new HashSet();
        this.s = false;
        this.r = false;
        this.ac = false;
        this.W = new AtomicBoolean(true);
        this.ai = new AtomicBoolean(false);
        this.q = 0;
        this.t = false;
        this.u = false;
        this.ad = false;
        this.v = false;
        this.m = IronSourceUtils.getSessionId();
        this.ae = Boolean.FALSE;
        this.H = false;
        this.ag = null;
        this.x = null;
        this.y = null;
        this.ah = null;
        this.z = null;
        this.D = false;
        this.aj = new ConcurrentHashMap<>();
        this.al = new CopyOnWriteArraySet<>();
        this.ak = new ConcurrentHashMap<>();
        this.K = null;
        this.am = null;
        this.L = null;
        this.J = 1;
        this.M = new com.ironsource.mediationsdk.impressionData.a();
        this.N = new com.ironsource.mediationsdk.b.a();
        this.an = new W();
        this.ap = new ISErrorListener() {
            public final void onError(Throwable th) {
                IronLog.INTERNAL.error(th.getMessage());
            }
        };
        this.P = null;
        this.Q = new n.a();
    }

    /* synthetic */ z(byte b2) {
        this();
    }

    private boolean A() {
        k kVar = this.f;
        return (kVar == null || kVar.a == null || this.f.a.a == null || this.f.a.a.size() <= 0) ? false : true;
    }

    private InterstitialPlacement B() {
        com.ironsource.mediationsdk.model.h b2 = this.f.c.b();
        if (b2 != null) {
            return b2.a();
        }
        return null;
    }

    private boolean C() {
        k kVar = this.f;
        return (kVar == null || kVar.c == null || this.f.c.b() == null) ? false : true;
    }

    private boolean D() {
        k kVar = this.f;
        return (kVar == null || kVar.a == null || this.f.a.b == null || this.f.a.b.size() <= 0) ? false : true;
    }

    private boolean E() {
        k kVar = this.f;
        return (kVar == null || kVar.c == null || this.f.c.d() == null) ? false : true;
    }

    private boolean F() {
        if (E()) {
            k kVar = this.f;
            if ((kVar == null || kVar.a == null || this.f.a.c == null || this.f.a.c.size() <= 0) ? false : true) {
                return true;
            }
        }
        return false;
    }

    private void G() {
        if (this.ah != null && this.ai.compareAndSet(false, true)) {
            IronLog.CALLBACK.verbose("onInitializationCompleted()");
            i.d().a(new com.ironsource.environment.c.a(IronSourceConstants.TROUBLESHOOTING_INIT_COMPLETED, IronSourceUtils.getMediationAdditionalData(false)));
            this.ah.onInitializationComplete();
        }
    }

    private static boolean H() {
        Class<IronSourceAdQuality> cls = IronSourceAdQuality.class;
        try {
            IronLog.INTERNAL.verbose("AdQuality SDK exist");
            return true;
        } catch (Throwable unused) {
            IronLog.INTERNAL.verbose("No AdQuality SDK found");
            return false;
        }
    }

    private int a(q qVar) {
        return !this.F && !this.D && qVar.m.j ? 2 : 1;
    }

    private IronSourceError a(E.a aVar) {
        if (!this.ad) {
            return new IronSourceError(510, "ironSource SDK was not initialized");
        }
        if (!this.ac) {
            return new IronSourceError(510, "ironSource SDK was not initialized using Demand Only mode");
        }
        if (aVar == E.a.INIT_FAILED) {
            return new IronSourceError(510, "ironSource initialization failed");
        }
        if (aVar != E.a.INIT_IN_PROGRESS || !E.a().c()) {
            return null;
        }
        return new IronSourceError(510, "ironSource initialization in progress");
    }

    private static k a(Context context, String str) {
        if (IronSourceUtils.isInitResponseCached(context)) {
            String cachedValueByKeyOfCachedInitResponse = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, "appKey");
            String cachedValueByKeyOfCachedInitResponse2 = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, DataKeys.USER_ID);
            String cachedValueByKeyOfCachedInitResponse3 = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, "response");
            if (cachedValueByKeyOfCachedInitResponse.equals(str)) {
                k kVar = new k(context, cachedValueByKeyOfCachedInitResponse, cachedValueByKeyOfCachedInitResponse2, cachedValueByKeyOfCachedInitResponse3);
                kVar.e = k.a.b;
                return kVar;
            }
        }
        return null;
    }

    public static z a() {
        return b.a;
    }

    public static String a(Context context) {
        String C2 = com.ironsource.environment.h.C(context);
        return !TextUtils.isEmpty(C2) ? C2 : "";
    }

    private List<NetworkSettings> a(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = arrayList.get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList2.add(this.f.b.a(str));
            }
        }
        return arrayList2;
    }

    static void a(int i2, JSONObject jSONObject) {
        i.d().a(new com.ironsource.environment.c.a(i2, jSONObject));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0134, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(android.app.Activity r7, com.ironsource.mediationsdk.demandOnly.p.c r8, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = r8.a()     // Catch:{ all -> 0x0156 }
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x0156 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0156 }
            java.lang.String r3 = "instanceId="
            r2.<init>(r3)     // Catch:{ all -> 0x0156 }
            r2.append(r0)     // Catch:{ all -> 0x0156 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0156 }
            r1.info(r2)     // Catch:{ all -> 0x0156 }
            r1 = 510(0x1fe, float:7.15E-43)
            boolean r2 = r6.u     // Catch:{ all -> 0x013e }
            if (r2 != 0) goto L_0x002f
            java.lang.String r7 = "initISDemandOnly() must be called before loadISDemandOnlyInterstitial()"
            com.ironsource.mediationsdk.logger.IronLog r8 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x013e }
            r8.error(r7)     // Catch:{ all -> 0x013e }
            com.ironsource.mediationsdk.logger.IronSourceError r8 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x013e }
            r8.<init>(r1, r7)     // Catch:{ all -> 0x013e }
            r9.onInterstitialAdLoadFailed(r0, r8)     // Catch:{ all -> 0x013e }
            monitor-exit(r6)
            return
        L_0x002f:
            boolean r2 = r6.s     // Catch:{ all -> 0x013e }
            if (r2 != 0) goto L_0x0044
            java.lang.String r7 = "Interstitial was initialized in mediation mode. Use loadInterstitial instead"
            com.ironsource.mediationsdk.logger.IronLog r8 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x013e }
            r8.error(r7)     // Catch:{ all -> 0x013e }
            com.ironsource.mediationsdk.logger.IronSourceError r8 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x013e }
            r8.<init>(r1, r7)     // Catch:{ all -> 0x013e }
            r9.onInterstitialAdLoadFailed(r0, r8)     // Catch:{ all -> 0x013e }
            monitor-exit(r6)
            return
        L_0x0044:
            java.lang.String r2 = r8.b()     // Catch:{ all -> 0x013e }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x013e }
            r3 = 1
            if (r2 != 0) goto L_0x0051
            r2 = 1
            goto L_0x0052
        L_0x0051:
            r2 = 0
        L_0x0052:
            org.json.JSONObject r2 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r2, r3)     // Catch:{ all -> 0x013e }
            if (r7 == 0) goto L_0x005c
            c((android.app.Activity) r7)     // Catch:{ all -> 0x013e }
            goto L_0x007f
        L_0x005c:
            com.ironsource.environment.ContextProvider r7 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x013e }
            android.app.Activity r7 = r7.getCurrentActiveActivity()     // Catch:{ all -> 0x013e }
            if (r7 != 0) goto L_0x007f
            r7 = 82321(0x14191, float:1.15356E-40)
            b((int) r7, (org.json.JSONObject) r2)     // Catch:{ all -> 0x013e }
            java.lang.String r7 = "Interstitial was initialized and loaded without Activity"
            com.ironsource.mediationsdk.logger.IronLog r8 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x013e }
            r8.error(r7)     // Catch:{ all -> 0x013e }
            com.ironsource.mediationsdk.logger.IronSourceError r8 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x013e }
            r2 = 1061(0x425, float:1.487E-42)
            r8.<init>(r2, r7)     // Catch:{ all -> 0x013e }
            r9.onInterstitialAdLoadFailed(r0, r8)     // Catch:{ all -> 0x013e }
            monitor-exit(r6)
            return
        L_0x007f:
            com.ironsource.mediationsdk.E r7 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x013e }
            com.ironsource.mediationsdk.E$a r7 = r7.b()     // Catch:{ all -> 0x013e }
            com.ironsource.mediationsdk.E$a r3 = com.ironsource.mediationsdk.E.a.INIT_FAILED     // Catch:{ all -> 0x013e }
            if (r7 != r3) goto L_0x009f
            com.ironsource.mediationsdk.logger.IronLog r7 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x013e }
            java.lang.String r8 = "init() had failed"
            r7.error(r8)     // Catch:{ all -> 0x013e }
            java.lang.String r7 = "init() had failed"
            java.lang.String r8 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r7 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r7, r8)     // Catch:{ all -> 0x013e }
            r9.onInterstitialAdLoadFailed(r0, r7)     // Catch:{ all -> 0x013e }
            monitor-exit(r6)
            return
        L_0x009f:
            com.ironsource.mediationsdk.logger.IronSourceError r3 = r8.c()     // Catch:{ all -> 0x013e }
            if (r3 == 0) goto L_0x00b3
            com.ironsource.mediationsdk.logger.IronLog r7 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x013e }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x013e }
            r7.error(r8)     // Catch:{ all -> 0x013e }
            r9.onInterstitialAdLoadFailed(r0, r3)     // Catch:{ all -> 0x013e }
            monitor-exit(r6)
            return
        L_0x00b3:
            com.ironsource.mediationsdk.E$a r3 = com.ironsource.mediationsdk.E.a.INIT_IN_PROGRESS     // Catch:{ all -> 0x013e }
            r4 = 83003(0x1443b, float:1.16312E-40)
            if (r7 != r3) goto L_0x00f7
            com.ironsource.mediationsdk.E r7 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x013e }
            boolean r7 = r7.c()     // Catch:{ all -> 0x013e }
            if (r7 == 0) goto L_0x00d8
            com.ironsource.mediationsdk.logger.IronLog r7 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x013e }
            java.lang.String r8 = "init() had failed"
            r7.error(r8)     // Catch:{ all -> 0x013e }
            java.lang.String r7 = "init() had failed"
            java.lang.String r8 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r7 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r7, r8)     // Catch:{ all -> 0x013e }
            r9.onInterstitialAdLoadFailed(r0, r7)     // Catch:{ all -> 0x013e }
            monitor-exit(r6)
            return
        L_0x00d8:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.p$c> r7 = r6.aj     // Catch:{ all -> 0x013e }
            monitor-enter(r7)     // Catch:{ all -> 0x013e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.p$c> r3 = r6.aj     // Catch:{ all -> 0x00f4 }
            java.lang.String r5 = r8.a()     // Catch:{ all -> 0x00f4 }
            r3.put(r5, r8)     // Catch:{ all -> 0x00f4 }
            monitor-exit(r7)     // Catch:{ all -> 0x00f4 }
            java.lang.String r7 = r8.b()     // Catch:{ all -> 0x013e }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x013e }
            if (r7 != 0) goto L_0x00f2
            b((int) r4, (org.json.JSONObject) r2)     // Catch:{ all -> 0x013e }
        L_0x00f2:
            monitor-exit(r6)
            return
        L_0x00f4:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00f4 }
            throw r8     // Catch:{ all -> 0x013e }
        L_0x00f7:
            boolean r7 = r6.g()     // Catch:{ all -> 0x013e }
            if (r7 != 0) goto L_0x0115
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r7 = r6.c     // Catch:{ all -> 0x013e }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r8 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x013e }
            java.lang.String r2 = "No interstitial configurations found"
            r3 = 3
            r7.log(r8, r2, r3)     // Catch:{ all -> 0x013e }
            java.lang.String r7 = "the server response does not contain interstitial data"
            java.lang.String r8 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r7 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r7, r8)     // Catch:{ all -> 0x013e }
            r9.onInterstitialAdLoadFailed(r0, r7)     // Catch:{ all -> 0x013e }
            monitor-exit(r6)
            return
        L_0x0115:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.p$c> r7 = r6.aj     // Catch:{ all -> 0x013e }
            monitor-enter(r7)     // Catch:{ all -> 0x013e }
            com.ironsource.mediationsdk.demandOnly.f r3 = r6.K     // Catch:{ all -> 0x013b }
            if (r3 != 0) goto L_0x0135
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.p$c> r3 = r6.aj     // Catch:{ all -> 0x013b }
            java.lang.String r5 = r8.a()     // Catch:{ all -> 0x013b }
            r3.put(r5, r8)     // Catch:{ all -> 0x013b }
            java.lang.String r8 = r8.b()     // Catch:{ all -> 0x013b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x013b }
            if (r8 != 0) goto L_0x0132
            b((int) r4, (org.json.JSONObject) r2)     // Catch:{ all -> 0x013b }
        L_0x0132:
            monitor-exit(r7)     // Catch:{ all -> 0x013b }
            monitor-exit(r6)
            return
        L_0x0135:
            monitor-exit(r7)     // Catch:{ all -> 0x013b }
            r3.a((com.ironsource.mediationsdk.demandOnly.p.c) r8)     // Catch:{ all -> 0x013e }
            monitor-exit(r6)
            return
        L_0x013b:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x013b }
            throw r8     // Catch:{ all -> 0x013e }
        L_0x013e:
            r7 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r8 = r6.c     // Catch:{ all -> 0x0156 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0156 }
            java.lang.String r3 = "loadDemandOnlyInterstitial"
            r8.logException(r2, r3, r7)     // Catch:{ all -> 0x0156 }
            com.ironsource.mediationsdk.logger.IronSourceError r8 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0156 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0156 }
            r8.<init>(r1, r7)     // Catch:{ all -> 0x0156 }
            r9.onInterstitialAdLoadFailed(r0, r8)     // Catch:{ all -> 0x0156 }
            monitor-exit(r6)
            return
        L_0x0156:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.a(android.app.Activity, com.ironsource.mediationsdk.demandOnly.p$c, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener):void");
    }

    private void a(IronSource.AD_UNIT ad_unit) {
        String str = ad_unit + " ad unit has already been initialized";
        this.c.log(IronSourceLogger.IronSourceTag.API, str, 3);
        IronSourceUtils.sendAutomationLog(str);
    }

    private void a(IronSource.AD_UNIT ad_unit, boolean z2) {
        int i2 = AnonymousClass2.a[ad_unit.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        if (this.ac) {
                            for (p.b next : this.ak.values()) {
                                ISDemandOnlyBannerLayout c2 = next.c();
                                if (c2 != null) {
                                    c2.getListener().a(next.a(), ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", IronSourceConstants.BANNER_AD_UNIT));
                                }
                            }
                            this.ak.clear();
                        } else if (this.ae.booleanValue()) {
                            this.ae = Boolean.FALSE;
                            C0227q.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(602, "init() had failed"));
                            this.af = null;
                            this.ag = null;
                        }
                    }
                } else if (z2 || h() || this.Z.contains(ad_unit)) {
                    this.d.onOfferwallAvailable(false);
                }
            } else if (this.s) {
                for (p.c a2 : this.aj.values()) {
                    String a3 = a2.a();
                    this.Q.a(a3).onInterstitialAdLoadFailed(a3, ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
                }
                this.aj.clear();
            } else if (this.H) {
                this.H = false;
                C0227q.a().a(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
            }
        } else if (this.r) {
            Iterator<String> it = this.al.iterator();
            while (it.hasNext()) {
                r.a().a(it.next(), ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            this.al.clear();
        } else if (this.D) {
            if (this.E) {
                this.E = false;
                C0227q.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
        } else if (z2 || z() || this.Z.contains(ad_unit)) {
            P.a().a(false, (AdInfo) null);
        }
    }

    static void a(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        r.a().a = iSDemandOnlyRewardedVideoListener;
    }

    public static void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        IronLog ironLog = IronLog.API;
        if (levelPlayInterstitialListener == null) {
            ironLog.info("ISListener is null");
        } else {
            ironLog.info();
        }
        C0231u.a().a(levelPlayInterstitialListener);
    }

    public static void a(LevelPlayRewardedVideoListener levelPlayRewardedVideoListener) {
        IronLog ironLog = IronLog.API;
        if (levelPlayRewardedVideoListener == null) {
            ironLog.info("RVListener is null");
        } else {
            ironLog.info();
        }
        P.a().b = levelPlayRewardedVideoListener;
    }

    private static void a(x xVar, Context context, k kVar) {
        i.d().b(xVar.e(), context);
        i.d().a(xVar.d(), context);
        i.d().b(xVar.g());
        i.d().c(xVar.h());
        i.d().a(xVar.f());
        i.d().a(xVar.i(), context);
        i.d().b(xVar.j(), context);
        i.d().c(xVar.k(), context);
        i.d().d(xVar.l(), context);
        i.d().a(kVar.c.f().b());
        i.d().c = xVar.b();
        i.d().d = xVar.c();
    }

    public static void a(String str, JSONObject jSONObject) {
        String str2 = "networkKey = " + str;
        if (jSONObject != null) {
            str2 = str2 + " networkData = " + jSONObject;
        }
        IronLog.API.verbose(str2);
        C0213c.a().a(str, jSONObject);
    }

    static void a(JSONObject jSONObject, Object[][] objArr) {
        int i2 = 0;
        while (i2 <= 0) {
            try {
                Object[] objArr2 = objArr[0];
                jSONObject.put(objArr2[0].toString(), objArr2[1]);
                i2++;
            } catch (Exception e2) {
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                logger.log(ironSourceTag, "IronSourceObject addToDictionary: " + Log.getStackTraceString(e2), 3);
                return;
            }
        }
    }

    public static void a(boolean z2) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        logger.log(ironSourceTag, "setAdaptersDebug : " + z2, 1);
        C0213c.a().b(z2);
    }

    private static void a(boolean z2, boolean z3, int i2, JSONObject jSONObject) {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            if (a.AnonymousClass1.d()) {
                sb.append(IronSourceConstants.IS_APP_LANGUAGE_KOTLIN);
                str = a.AnonymousClass1.c();
            } else {
                str = IronSourceConstants.IS_APP_LANGUAGE_JAVA;
            }
            sb.append(str);
            sb.append(String.format(",androidx=%s", new Object[]{Boolean.valueOf(IronSourceUtils.isAndroidXAvailable())}));
            if (z3) {
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(ContextProvider.getInstance().getCurrentActiveActivity() != null);
                sb.append(String.format(",Activity=%s", objArr));
            } else if (!z2) {
                sb.append(",init_context_flow");
            }
            sb.append(String.format(",cachedUserAgent=%s", new Object[]{Boolean.valueOf(com.ironsource.environment.h.a)}));
            jSONObject.put(IronSourceConstants.EVENTS_EXT1, sb.toString());
            jSONObject.put(IronSourceConstants.KEY_SESSION_DEPTH, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        i.d().a(new com.ironsource.environment.c.a(14, jSONObject));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b7, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0112, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(boolean r10, boolean r11, com.ironsource.mediationsdk.IronSource.AD_UNIT... r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r0 = r12.length     // Catch:{ all -> 0x0113 }
            r1 = 0
            r2 = 0
        L_0x0004:
            r3 = 1
            if (r2 >= r0) goto L_0x0037
            r4 = r12[r2]     // Catch:{ all -> 0x0113 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x0113 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x0113 }
            if (r5 == 0) goto L_0x0014
            r9.u = r3     // Catch:{ all -> 0x0113 }
            goto L_0x0034
        L_0x0014:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x0113 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x0113 }
            if (r5 == 0) goto L_0x001f
            r9.ad = r3     // Catch:{ all -> 0x0113 }
            goto L_0x0034
        L_0x001f:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x0113 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x0113 }
            if (r5 == 0) goto L_0x002a
            r9.t = r3     // Catch:{ all -> 0x0113 }
            goto L_0x0034
        L_0x002a:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.NATIVE_AD     // Catch:{ all -> 0x0113 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0113 }
            if (r4 == 0) goto L_0x0034
            r9.v = r3     // Catch:{ all -> 0x0113 }
        L_0x0034:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0037:
            com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x0113 }
            com.ironsource.mediationsdk.E$a r0 = r0.b()     // Catch:{ all -> 0x0113 }
            com.ironsource.mediationsdk.E$a r2 = com.ironsource.mediationsdk.E.a.INIT_FAILED     // Catch:{ all -> 0x0113 }
            if (r0 != r2) goto L_0x0062
            com.ironsource.mediationsdk.sdk.e r10 = r9.d     // Catch:{ Exception -> 0x005c }
            if (r10 == 0) goto L_0x005a
            int r10 = r12.length     // Catch:{ Exception -> 0x005c }
        L_0x0048:
            if (r1 >= r10) goto L_0x005a
            r11 = r12[r1]     // Catch:{ Exception -> 0x005c }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r0 = r9.Y     // Catch:{ Exception -> 0x005c }
            boolean r0 = r0.contains(r11)     // Catch:{ Exception -> 0x005c }
            if (r0 != 0) goto L_0x0057
            r9.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r11, (boolean) r3)     // Catch:{ Exception -> 0x005c }
        L_0x0057:
            int r1 = r1 + 1
            goto L_0x0048
        L_0x005a:
            monitor-exit(r9)
            return
        L_0x005c:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x0113 }
            monitor-exit(r9)
            return
        L_0x0062:
            boolean r0 = r9.l     // Catch:{ all -> 0x0113 }
            if (r0 != 0) goto L_0x00b8
            org.json.JSONObject r0 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r11)     // Catch:{ all -> 0x0113 }
            int r2 = r12.length     // Catch:{ all -> 0x0113 }
            r4 = 0
        L_0x006c:
            if (r1 >= r2) goto L_0x00ac
            r5 = r12[r1]     // Catch:{ all -> 0x0113 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r6 = r9.Y     // Catch:{ all -> 0x0113 }
            boolean r6 = r6.contains(r5)     // Catch:{ all -> 0x0113 }
            if (r6 != 0) goto L_0x0090
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r4 = r9.Y     // Catch:{ all -> 0x0113 }
            r4.add(r5)     // Catch:{ all -> 0x0113 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r4 = r9.Z     // Catch:{ all -> 0x0113 }
            r4.add(r5)     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x008a }
            r0.put(r4, r3)     // Catch:{ Exception -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x0113 }
        L_0x008e:
            r4 = 1
            goto L_0x00a9
        L_0x0090:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r6 = r9.c     // Catch:{ all -> 0x0113 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r8.<init>()     // Catch:{ all -> 0x0113 }
            r8.append(r5)     // Catch:{ all -> 0x0113 }
            java.lang.String r5 = " ad unit has started initializing."
            r8.append(r5)     // Catch:{ all -> 0x0113 }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x0113 }
            r8 = 3
            r6.log(r7, r5, r8)     // Catch:{ all -> 0x0113 }
        L_0x00a9:
            int r1 = r1 + 1
            goto L_0x006c
        L_0x00ac:
            if (r4 == 0) goto L_0x00b6
            int r12 = r9.q     // Catch:{ all -> 0x0113 }
            int r12 = r12 + r3
            r9.q = r12     // Catch:{ all -> 0x0113 }
            a((boolean) r10, (boolean) r11, (int) r12, (org.json.JSONObject) r0)     // Catch:{ all -> 0x0113 }
        L_0x00b6:
            monitor-exit(r9)
            return
        L_0x00b8:
            com.ironsource.mediationsdk.E r0 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x0113 }
            r0.b(r11)     // Catch:{ all -> 0x0113 }
            java.util.List<com.ironsource.mediationsdk.IronSource$AD_UNIT> r0 = r9.X     // Catch:{ all -> 0x0113 }
            if (r0 != 0) goto L_0x00c5
            monitor-exit(r9)
            return
        L_0x00c5:
            org.json.JSONObject r0 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r11)     // Catch:{ all -> 0x0113 }
            int r2 = r12.length     // Catch:{ all -> 0x0113 }
            r4 = 0
            r5 = 0
        L_0x00cc:
            if (r4 >= r2) goto L_0x0107
            r6 = r12[r4]     // Catch:{ all -> 0x0113 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r7 = r9.Y     // Catch:{ all -> 0x0113 }
            boolean r7 = r7.contains(r6)     // Catch:{ all -> 0x0113 }
            if (r7 != 0) goto L_0x0101
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.Y     // Catch:{ all -> 0x0113 }
            r5.add(r6)     // Catch:{ all -> 0x0113 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.Z     // Catch:{ all -> 0x0113 }
            r5.add(r6)     // Catch:{ all -> 0x0113 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x00ea }
            r0.put(r5, r3)     // Catch:{ Exception -> 0x00ea }
            goto L_0x00ee
        L_0x00ea:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0113 }
        L_0x00ee:
            java.util.List<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.X     // Catch:{ all -> 0x0113 }
            if (r5 == 0) goto L_0x00fc
            boolean r5 = r5.contains(r6)     // Catch:{ all -> 0x0113 }
            if (r5 == 0) goto L_0x00fc
            r9.b((com.ironsource.mediationsdk.IronSource.AD_UNIT) r6)     // Catch:{ all -> 0x0113 }
            goto L_0x00ff
        L_0x00fc:
            r9.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r6, (boolean) r1)     // Catch:{ all -> 0x0113 }
        L_0x00ff:
            r5 = 1
            goto L_0x0104
        L_0x0101:
            r9.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r6)     // Catch:{ all -> 0x0113 }
        L_0x0104:
            int r4 = r4 + 1
            goto L_0x00cc
        L_0x0107:
            if (r5 == 0) goto L_0x0111
            int r12 = r9.q     // Catch:{ all -> 0x0113 }
            int r12 = r12 + r3
            r9.q = r12     // Catch:{ all -> 0x0113 }
            a((boolean) r10, (boolean) r11, (int) r12, (org.json.JSONObject) r0)     // Catch:{ all -> 0x0113 }
        L_0x0111:
            monitor-exit(r9)
            return
        L_0x0113:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x0117
        L_0x0116:
            throw r10
        L_0x0117:
            goto L_0x0116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.a(boolean, boolean, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    private boolean a(p.b bVar) {
        synchronized (this.ak) {
            if (this.L != null) {
                return false;
            }
            this.ak.put(bVar.a(), bVar);
            return true;
        }
    }

    static boolean a(k kVar) {
        return kVar != null && kVar.c();
    }

    private static boolean a(String str, int i2, int i3) {
        return str != null && str.length() >= i2 && str.length() <= i3;
    }

    private k b(Context context, String str, a aVar) {
        k kVar = null;
        if (!IronSourceUtils.isNetworkConnected(context)) {
            return null;
        }
        try {
            String a2 = a(context);
            if (TextUtils.isEmpty(a2)) {
                a2 = com.ironsource.environment.h.x(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String str2 = a2;
            IronSourceSegment ironSourceSegment = this.p;
            String stringFromURL = HttpFunctions.getStringFromURL(ServerURL.getCPVProvidersURL(context, this.g, str, str2, this.k, this.D, ironSourceSegment != null ? ironSourceSegment.getSegmentData() : null, k()), aVar);
            if (stringFromURL == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return null;
            }
            if (IronSourceUtils.isEncryptedResponse()) {
                IronLog.INTERNAL.verbose("encrypt");
                String optString = new JSONObject(stringFromURL).optString("response", (String) null);
                if (TextUtils.isEmpty(optString)) {
                    IronLog.INTERNAL.warning("encryptedResponse is empty - return null");
                    return null;
                }
                stringFromURL = IronSourceAES.decode(com.ironsource.mediationsdk.utils.e.a().b(), optString);
                if (TextUtils.isEmpty(stringFromURL)) {
                    IronLog.INTERNAL.warning("encoded response invalid - return null");
                    if (!ao) {
                        ao = true;
                        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                        try {
                            mediationAdditionalData.put("status", "false");
                            mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, 1);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        i.d().a(new com.ironsource.environment.c.a(114, mediationAdditionalData));
                    }
                    return null;
                }
            }
            k kVar2 = new k(context, this.g, str, stringFromURL);
            try {
                kVar2.e = k.a.c;
                if (kVar2.b()) {
                    return kVar2;
                }
                IronLog.INTERNAL.warning("response invalid - return null");
                return null;
            } catch (Exception e3) {
                e = e3;
                kVar = kVar2;
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.warning("exception = " + e);
                e.printStackTrace();
                return kVar;
            }
        } catch (Exception e4) {
            e = e4;
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.warning("exception = " + e);
            e.printStackTrace();
            return kVar;
        }
    }

    private static void b(int i2, JSONObject jSONObject) {
        com.ironsource.mediationsdk.events.e.d().a(new com.ironsource.environment.c.a(i2, jSONObject));
    }

    private void b(IronSource.AD_UNIT ad_unit) {
        int i2 = AnonymousClass2.a[ad_unit.ordinal()];
        if (i2 == 1) {
            n();
        } else if (i2 == 2) {
            u();
        } else if (i2 == 3) {
            this.b.a(this.g, this.h);
        } else if (i2 == 4) {
            v();
        }
    }

    private static void b(x xVar, Context context, k kVar) {
        com.ironsource.mediationsdk.events.e.d().b(xVar.e(), context);
        com.ironsource.mediationsdk.events.e.d().a(xVar.d(), context);
        com.ironsource.mediationsdk.events.e.d().b(xVar.g());
        com.ironsource.mediationsdk.events.e.d().c(xVar.h());
        com.ironsource.mediationsdk.events.e.d().a(xVar.f());
        com.ironsource.mediationsdk.events.e.d().a(xVar.i(), context);
        com.ironsource.mediationsdk.events.e.d().b(xVar.j(), context);
        com.ironsource.mediationsdk.events.e.d().c(xVar.k(), context);
        com.ironsource.mediationsdk.events.e.d().d(xVar.l(), context);
        com.ironsource.mediationsdk.events.e.d().a(kVar.c.f().b());
        com.ironsource.mediationsdk.events.e.d().c = xVar.b();
        com.ironsource.mediationsdk.events.e.d().d = xVar.c();
    }

    private boolean b(p.b bVar) {
        if (E.a().b() != E.a.INIT_IN_PROGRESS) {
            return false;
        }
        synchronized (this.ak) {
            this.ak.put(bVar.a(), bVar);
        }
        return true;
    }

    private static void c(Activity activity) {
        ContextProvider.getInstance().updateActivity(activity);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("activity is updated to: " + activity.hashCode());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(android.app.Activity r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 3
            r1 = 0
            com.ironsource.mediationsdk.model.Placement r8 = r6.n(r8)     // Catch:{ Exception -> 0x0029 }
            if (r8 != 0) goto L_0x000f
            com.ironsource.mediationsdk.model.Placement r8 = r6.y()     // Catch:{ Exception -> 0x000d }
            goto L_0x000f
        L_0x000d:
            r2 = move-exception
            goto L_0x002b
        L_0x000f:
            if (r8 != 0) goto L_0x0034
            java.lang.String r2 = "showProgrammaticRewardedVideo error: empty default placement in response"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r6.c     // Catch:{ Exception -> 0x000d }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ Exception -> 0x000d }
            r3.log(r4, r2, r0)     // Catch:{ Exception -> 0x000d }
            com.ironsource.mediationsdk.logger.IronSourceError r3 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ Exception -> 0x000d }
            r4 = 1021(0x3fd, float:1.431E-42)
            r3.<init>(r4, r2)     // Catch:{ Exception -> 0x000d }
            com.ironsource.mediationsdk.P r2 = com.ironsource.mediationsdk.P.a()     // Catch:{ Exception -> 0x000d }
            r2.a((com.ironsource.mediationsdk.logger.IronSourceError) r3, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r1)     // Catch:{ Exception -> 0x000d }
            return
        L_0x0029:
            r2 = move-exception
            r8 = r1
        L_0x002b:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r6.c
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r5 = "showProgrammaticRewardedVideo()"
            r3.logException(r4, r5, r2)
        L_0x0034:
            if (r7 == 0) goto L_0x003a
            c((android.app.Activity) r7)
            goto L_0x005b
        L_0x003a:
            com.ironsource.environment.ContextProvider r2 = com.ironsource.environment.ContextProvider.getInstance()
            android.app.Activity r2 = r2.getCurrentActiveActivity()
            if (r2 != 0) goto L_0x005b
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r7 = r6.c
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r8 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r2 = "Activity must be provided in showRewardedVideo when initializing SDK with context"
            r7.log(r8, r2, r0)
            com.ironsource.mediationsdk.P r7 = com.ironsource.mediationsdk.P.a()
            java.lang.String r8 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r2, r8)
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r8, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r1)
            return
        L_0x005b:
            com.ironsource.mediationsdk.adunit.c.h r2 = r6.B
            if (r2 == 0) goto L_0x006b
            boolean r3 = r6.D
            if (r3 != 0) goto L_0x0067
            boolean r3 = r6.F
            if (r3 == 0) goto L_0x006b
        L_0x0067:
            r2.a((android.app.Activity) r7, (com.ironsource.mediationsdk.model.Placement) r8)
            return
        L_0x006b:
            com.ironsource.mediationsdk.t r2 = r6.x
            if (r2 == 0) goto L_0x0073
            r2.a((android.app.Activity) r7, (com.ironsource.mediationsdk.model.Placement) r8)
            return
        L_0x0073:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r7 = r6.c
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r8 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r2 = "showProgrammaticRewardedVideo - show called before init completed, managers not initiated yet"
            r7.log(r8, r2, r0)
            com.ironsource.mediationsdk.logger.IronSourceError r7 = new com.ironsource.mediationsdk.logger.IronSourceError
            r8 = 1023(0x3ff, float:1.434E-42)
            r7.<init>(r8, r2)
            com.ironsource.mediationsdk.P r8 = com.ironsource.mediationsdk.P.a()
            r8.a((com.ironsource.mediationsdk.logger.IronSourceError) r7, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.d(android.app.Activity, java.lang.String):void");
    }

    private void e(Activity activity, String str) {
        try {
            InterstitialPlacement o2 = o(str);
            if (o2 == null) {
                o2 = B();
            }
            if (o2 == null) {
                this.c.log(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticInterstitial error: empty default placement in response", 3);
                C0231u.a().a(new IronSourceError(1020, "showProgrammaticInterstitial error: empty default placement in response"), (AdInfo) null);
                return;
            }
            if (activity != null) {
                c(activity);
            } else if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                this.c.log(IronSourceLogger.IronSourceTag.API, "Activity must be provided in showInterstitial when initializing SDK with context", 3);
                C0231u.a().a(new IronSourceError(510, "Activity must be provided in showInterstitial when initializing SDK with context"), (AdInfo) null);
                return;
            }
            if (this.G) {
                this.A.a(activity, new Placement(o2));
            } else {
                this.y.a(activity, o2.getPlacementName());
            }
        } catch (Exception e2) {
            this.c.logException(IronSourceLogger.IronSourceTag.API, "showProgrammaticInterstitial()", e2);
        }
    }

    private void l() {
        this.c.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in programmatic mode", 0);
        List<NetworkSettings> a2 = a(this.f.a.a);
        if (a2.size() > 0) {
            A a3 = new A(a2, this.f.c.a(), this.g, IronSourceUtils.getUserIdForNetworks(), com.ironsource.mediationsdk.d.c.a().b(), this.p);
            this.x = a3;
            Boolean bool = this.o;
            if (bool != null) {
                a3.a(this.n, bool.booleanValue());
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.J);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        a((int) IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private void m() {
        this.c.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f.a.a.size(); i2++) {
            String str = this.f.a.a.get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.f.b.a(str));
            }
        }
        if (arrayList.size() > 0) {
            synchronized (this.al) {
                this.am = new com.ironsource.mediationsdk.demandOnly.h(arrayList, this.f.c.a(), this.g, this.h);
            }
            if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
                return;
            }
            Iterator<String> it = this.al.iterator();
            while (it.hasNext()) {
                this.am.a(it.next(), (String) null, false);
            }
            this.al.clear();
            return;
        }
        a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private Placement n(String str) {
        q a2 = this.f.c.a();
        if (a2 != null) {
            Iterator<Placement> it = a2.a.iterator();
            while (it.hasNext()) {
                Placement next = it.next();
                if (next.getPlacementName().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    private void n() {
        if (this.r) {
            m();
            return;
        }
        q a2 = this.f.c.a();
        this.F = a2.m.a;
        this.J = a(a2);
        if (this.D || this.F) {
            o();
        } else {
            l();
        }
    }

    private InterstitialPlacement o(String str) {
        com.ironsource.mediationsdk.model.h b2 = this.f.c.b();
        if (b2 != null) {
            Iterator<InterstitialPlacement> it = b2.a.iterator();
            while (it.hasNext()) {
                InterstitialPlacement next = it.next();
                if (next.getPlacementName().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    private void o() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.f.a.a);
        if (a2.size() > 0) {
            com.ironsource.mediationsdk.adunit.c.h hVar = new com.ironsource.mediationsdk.adunit.c.h(a2, this.f.c.a(), IronSourceUtils.getUserIdForNetworks(), this.D, com.ironsource.mediationsdk.d.c.a(), this.p, this.f.d());
            this.B = hVar;
            Boolean bool = this.o;
            if (bool != null) {
                hVar.a(this.n, bool.booleanValue());
            }
            if (this.E && this.D) {
                this.E = false;
                this.B.i();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.J);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        a((int) IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private void p() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.f.a.b);
        if (a2.size() > 0) {
            f fVar = new f(a2, this.f.c.b(), IronSourceUtils.getUserIdForNetworks(), com.ironsource.mediationsdk.d.c.a(), this.p, this.f.d());
            this.A = fVar;
            Boolean bool = this.o;
            if (bool != null) {
                fVar.a(this.n, bool.booleanValue());
            }
            if (this.H) {
                this.H = false;
                this.A.i();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b((int) IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private static boolean p(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int q(java.lang.String r5) {
        /*
            r4 = this;
            com.ironsource.mediationsdk.utils.k r0 = r4.f
            if (r0 == 0) goto L_0x0043
            com.ironsource.mediationsdk.model.f r0 = r0.c
            if (r0 == 0) goto L_0x0043
            com.ironsource.mediationsdk.utils.k r0 = r4.f
            com.ironsource.mediationsdk.model.f r0 = r0.c
            com.ironsource.mediationsdk.model.h r0 = r0.b()
            if (r0 != 0) goto L_0x0013
            goto L_0x0043
        L_0x0013:
            com.ironsource.mediationsdk.model.InterstitialPlacement r5 = r4.o(r5)     // Catch:{ Exception -> 0x002c }
            if (r5 != 0) goto L_0x0031
            com.ironsource.mediationsdk.model.InterstitialPlacement r5 = r4.B()     // Catch:{ Exception -> 0x002a }
            if (r5 != 0) goto L_0x0031
            java.lang.String r0 = "Default placement was not found"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r4.c     // Catch:{ Exception -> 0x002a }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ Exception -> 0x002a }
            r3 = 3
            r1.log(r2, r0, r3)     // Catch:{ Exception -> 0x002a }
            goto L_0x0031
        L_0x002a:
            r0 = move-exception
            goto L_0x002e
        L_0x002c:
            r0 = move-exception
            r5 = 0
        L_0x002e:
            r0.printStackTrace()
        L_0x0031:
            if (r5 != 0) goto L_0x0036
            int r5 = com.ironsource.mediationsdk.utils.j.a.d
            return r5
        L_0x0036:
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r0 = r0.getApplicationContext()
            int r5 = com.ironsource.mediationsdk.utils.j.b((android.content.Context) r0, (com.ironsource.mediationsdk.model.InterstitialPlacement) r5)
            return r5
        L_0x0043:
            int r5 = com.ironsource.mediationsdk.utils.j.a.d
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.q(java.lang.String):int");
    }

    private void q() {
        this.c.log(IronSourceLogger.IronSourceTag.INTERNAL, "Adunit: Interstitial is now initiated - programmatic mode", 0);
        List<NetworkSettings> a2 = a(this.f.a.b);
        if (a2.size() > 0) {
            L l2 = new L(a2, this.f.c.b(), this.g, IronSourceUtils.getUserIdForNetworks(), this.f.c.b().f, com.ironsource.mediationsdk.d.c.a().b(), this.p);
            this.y = l2;
            Boolean bool = this.o;
            if (bool != null) {
                l2.a(bool.booleanValue());
            }
            if (this.H) {
                this.H = false;
                this.y.d();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b((int) IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private com.ironsource.mediationsdk.model.e r(String str) {
        d d2 = this.f.c.d();
        if (d2 == null) {
            return new g();
        }
        if (TextUtils.isEmpty(str)) {
            return d2.a();
        }
        com.ironsource.mediationsdk.model.e a2 = d2.a(str);
        return a2 != null ? a2 : d2.a();
    }

    private void r() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.f.a.c);
        if (a2.size() > 0) {
            this.c.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in programmatic mode", 0);
            this.z = new I(a2, new com.ironsource.mediationsdk.events.d(this.g, IronSourceUtils.getUserIdForNetworks(), this.f.c.d()), com.ironsource.mediationsdk.d.c.a().b(), this.p);
            x();
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b((int) IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.BANNER, false);
    }

    private void s() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.f.a.c);
        if (a2.size() > 0) {
            this.C = new com.ironsource.mediationsdk.adunit.c.b(a2, this.f.c.d(), IronSourceUtils.getUserIdForNetworks(), com.ironsource.mediationsdk.d.c.a(), this.p, this.f.d());
            x();
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b((int) IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.BANNER, false);
    }

    private void t() {
        this.c.log(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f.a.b.size(); i2++) {
            String str = this.f.a.b.get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.f.b.a(str));
            }
        }
        if (!arrayList.isEmpty()) {
            synchronized (this.aj) {
                com.ironsource.mediationsdk.model.h b2 = this.f.c.b();
                e.a aVar = new e.a("Mediation");
                if (b2.h) {
                    aVar.a("isOneFlow", 1);
                }
                this.K = new com.ironsource.mediationsdk.demandOnly.f(arrayList, b2, C0213c.a(), this.Q, this.g, this.h, new e.b(com.ironsource.mediationsdk.events.e.d(), aVar));
            }
            for (p.c a2 : this.aj.values()) {
                this.K.a(a2);
            }
            this.aj.clear();
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b((int) IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private void u() {
        if (this.s) {
            t();
            return;
        }
        boolean z2 = this.f.c.b().g.a;
        this.G = z2;
        if (z2) {
            p();
        } else {
            q();
        }
    }

    private void v() {
        if (this.ac) {
            w();
            return;
        }
        boolean z2 = this.f.c.d().i.a;
        this.I = z2;
        if (z2) {
            s();
        } else {
            r();
        }
    }

    private void w() {
        this.c.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f.a.c.size(); i2++) {
            String str = this.f.a.c.get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.f.b.a(str));
            }
        }
        if (!arrayList.isEmpty()) {
            synchronized (this.ak) {
                d d2 = this.f.c.d();
                e.a aVar = new e.a("Mediation");
                if (d2.j) {
                    aVar.a("isOneFlow", 1);
                }
                this.L = new c(arrayList, d2, this.g, this.h, new e.b(com.ironsource.mediationsdk.events.e.d(), aVar));
            }
            for (p.b next : this.ak.values()) {
                this.L.a(next.c(), next.a());
            }
            this.ak.clear();
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b((int) IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.BANNER, false);
    }

    private void x() {
        if (this.ae.booleanValue()) {
            IronLog.INTERNAL.verbose("load banner after init");
            this.ae = Boolean.FALSE;
            a(this.af, this.ag);
            this.af = null;
            this.ag = null;
        }
    }

    private Placement y() {
        q a2 = this.f.c.a();
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    private boolean z() {
        k kVar = this.f;
        return (kVar == null || kVar.c == null || this.f.c.a() == null) ? false : true;
    }

    public final IronSourceBannerLayout a(Activity activity, ISBannerSize iSBannerSize) {
        this.c.log(IronSourceLogger.IronSourceTag.API, "createBanner()", 1);
        if (activity == null) {
            this.c.log(IronSourceLogger.IronSourceTag.API, "createBanner() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new IronSourceBannerLayout(activity, iSBannerSize);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a0, code lost:
        return r13;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0164  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.ironsource.mediationsdk.utils.k a(android.content.Context r11, java.lang.String r12, com.ironsource.mediationsdk.z.a r13) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.U
            monitor-enter(r0)
            com.ironsource.mediationsdk.utils.k r1 = r10.f     // Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x000e
            com.ironsource.mediationsdk.utils.k r11 = new com.ironsource.mediationsdk.utils.k     // Catch:{ all -> 0x01a1 }
            r11.<init>(r1)     // Catch:{ all -> 0x01a1 }
            monitor-exit(r0)     // Catch:{ all -> 0x01a1 }
            return r11
        L_0x000e:
            com.ironsource.mediationsdk.utils.k r13 = r10.b((android.content.Context) r11, (java.lang.String) r12, (com.ironsource.mediationsdk.z.a) r13)     // Catch:{ all -> 0x01a1 }
            r1 = 1
            r2 = 0
            if (r13 == 0) goto L_0x001c
            boolean r3 = r13.b()     // Catch:{ all -> 0x01a1 }
            if (r3 != 0) goto L_0x006a
        L_0x001c:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r13 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r3 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = "Null or invalid response. Trying to get cached response"
            r13.log(r3, r4, r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r13 = r10.g     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.utils.k r13 = a((android.content.Context) r11, (java.lang.String) r13)     // Catch:{ all -> 0x01a1 }
            if (r13 == 0) goto L_0x006a
            java.lang.String r3 = r10.g     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceError r12 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildUsingCachedConfigurationError(r3, r12)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r10.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x01a1 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r5.<init>()     // Catch:{ all -> 0x01a1 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01a1 }
            r5.append(r12)     // Catch:{ all -> 0x01a1 }
            java.lang.String r12 = ": "
            r5.append(r12)     // Catch:{ all -> 0x01a1 }
            java.lang.String r12 = r13.toString()     // Catch:{ all -> 0x01a1 }
            r5.append(r12)     // Catch:{ all -> 0x01a1 }
            java.lang.String r12 = r5.toString()     // Catch:{ all -> 0x01a1 }
            r3.log(r4, r12, r1)     // Catch:{ all -> 0x01a1 }
            org.json.JSONObject r12 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r2)     // Catch:{ all -> 0x01a1 }
            com.ironsource.environment.c.a r3 = new com.ironsource.environment.c.a     // Catch:{ all -> 0x01a1 }
            r4 = 140(0x8c, float:1.96E-43)
            r3.<init>(r4, r12)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.events.i r12 = com.ironsource.mediationsdk.events.i.d()     // Catch:{ all -> 0x01a1 }
            r12.a((com.ironsource.environment.c.a) r3)     // Catch:{ all -> 0x01a1 }
        L_0x006a:
            if (r13 == 0) goto L_0x019f
            r10.f = r13     // Catch:{ all -> 0x01a1 }
            java.lang.String r12 = r13.toString()     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.saveLastResponse(r11, r12)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.utils.k r12 = r10.f     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.b r3 = r10.e     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.model.f r4 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.a.g r4 = r4.f()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.g.d r4 = r4.a()     // Catch:{ all -> 0x01a1 }
            int r4 = r4.a()     // Catch:{ all -> 0x01a1 }
            r3.setDebugLevel(r4)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r10.c     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = "console"
            com.ironsource.mediationsdk.model.f r5 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.a.g r5 = r5.f()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.g.d r5 = r5.a()     // Catch:{ all -> 0x01a1 }
            int r5 = r5.b()     // Catch:{ all -> 0x01a1 }
            r3.setLoggerDebugLevel(r4, r5)     // Catch:{ all -> 0x01a1 }
            boolean r3 = r10.z()     // Catch:{ all -> 0x01a1 }
            if (r3 == 0) goto L_0x00b2
            com.ironsource.mediationsdk.model.f r3 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.model.q r3 = r3.a()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.controller.x r3 = r3.b     // Catch:{ all -> 0x01a1 }
            boolean r3 = r3.a()     // Catch:{ all -> 0x01a1 }
            goto L_0x00b3
        L_0x00b2:
            r3 = 0
        L_0x00b3:
            boolean r4 = r10.C()     // Catch:{ all -> 0x01a1 }
            if (r4 == 0) goto L_0x00c6
            com.ironsource.mediationsdk.model.f r4 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.model.h r4 = r4.b()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.controller.x r4 = r4.b     // Catch:{ all -> 0x01a1 }
            boolean r4 = r4.a()     // Catch:{ all -> 0x01a1 }
            goto L_0x00c7
        L_0x00c6:
            r4 = 0
        L_0x00c7:
            boolean r5 = r10.E()     // Catch:{ all -> 0x01a1 }
            if (r5 == 0) goto L_0x00da
            com.ironsource.mediationsdk.model.f r5 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.model.d r5 = r5.d()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.controller.x r5 = r5.a     // Catch:{ all -> 0x01a1 }
            boolean r5 = r5.a()     // Catch:{ all -> 0x01a1 }
            goto L_0x00db
        L_0x00da:
            r5 = 0
        L_0x00db:
            boolean r6 = r10.j()     // Catch:{ all -> 0x01a1 }
            if (r6 == 0) goto L_0x00f0
            com.ironsource.mediationsdk.model.f r6 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.model.i r6 = r6.e()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.controller.x r6 = r6.a()     // Catch:{ all -> 0x01a1 }
            boolean r6 = r6.a()     // Catch:{ all -> 0x01a1 }
            goto L_0x00f1
        L_0x00f0:
            r6 = 0
        L_0x00f1:
            boolean r7 = r10.h()     // Catch:{ all -> 0x01a1 }
            if (r7 == 0) goto L_0x0104
            com.ironsource.mediationsdk.model.f r7 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.model.k r7 = r7.c()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.controller.x r7 = r7.c     // Catch:{ all -> 0x01a1 }
            boolean r7 = r7.a()     // Catch:{ all -> 0x01a1 }
            goto L_0x0105
        L_0x0104:
            r7 = 0
        L_0x0105:
            com.ironsource.mediationsdk.model.f r8 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.a.g r8 = r8.f()     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.utils.i r8 = r8.h()     // Catch:{ all -> 0x01a1 }
            boolean r9 = r8.a()     // Catch:{ all -> 0x01a1 }
            if (r3 == 0) goto L_0x0121
            com.ironsource.mediationsdk.model.f r3 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.model.q r3 = r3.a()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.controller.x r3 = r3.b     // Catch:{ all -> 0x01a1 }
        L_0x011d:
            a((com.ironsource.sdk.controller.x) r3, (android.content.Context) r11, (com.ironsource.mediationsdk.utils.k) r12)     // Catch:{ all -> 0x01a1 }
            goto L_0x0132
        L_0x0121:
            if (r7 == 0) goto L_0x012c
            com.ironsource.mediationsdk.model.f r3 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.model.k r3 = r3.c()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.controller.x r3 = r3.c     // Catch:{ all -> 0x01a1 }
            goto L_0x011d
        L_0x012c:
            com.ironsource.mediationsdk.events.i r3 = com.ironsource.mediationsdk.events.i.d()     // Catch:{ all -> 0x01a1 }
            r3.g = r2     // Catch:{ all -> 0x01a1 }
        L_0x0132:
            if (r4 == 0) goto L_0x0140
            com.ironsource.mediationsdk.model.f r2 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.model.h r2 = r2.b()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.controller.x r2 = r2.b     // Catch:{ all -> 0x01a1 }
        L_0x013c:
            b((com.ironsource.sdk.controller.x) r2, (android.content.Context) r11, (com.ironsource.mediationsdk.utils.k) r12)     // Catch:{ all -> 0x01a1 }
            goto L_0x015e
        L_0x0140:
            if (r5 == 0) goto L_0x014b
            com.ironsource.mediationsdk.model.f r2 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.model.d r2 = r2.d()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.controller.x r2 = r2.a     // Catch:{ all -> 0x01a1 }
            goto L_0x013c
        L_0x014b:
            if (r6 == 0) goto L_0x0158
            com.ironsource.mediationsdk.model.f r2 = r12.c     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.model.i r2 = r2.e()     // Catch:{ all -> 0x01a1 }
            com.ironsource.sdk.controller.x r2 = r2.a()     // Catch:{ all -> 0x01a1 }
            goto L_0x013c
        L_0x0158:
            com.ironsource.mediationsdk.events.e r12 = com.ironsource.mediationsdk.events.e.d()     // Catch:{ all -> 0x01a1 }
            r12.g = r2     // Catch:{ all -> 0x01a1 }
        L_0x015e:
            com.ironsource.mediationsdk.events.h r12 = com.ironsource.mediationsdk.events.h.x     // Catch:{ all -> 0x01a1 }
            r12.g = r9     // Catch:{ all -> 0x01a1 }
            if (r9 == 0) goto L_0x018f
            java.lang.String r12 = r8.b()     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.events.h r2 = com.ironsource.mediationsdk.events.h.x     // Catch:{ all -> 0x01a1 }
            r2.a((java.lang.String) r12, (android.content.Context) r11)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.events.h r12 = com.ironsource.mediationsdk.events.h.x     // Catch:{ all -> 0x01a1 }
            int[] r2 = r8.e()     // Catch:{ all -> 0x01a1 }
            r12.a((int[]) r2, (android.content.Context) r11)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.events.h r12 = com.ironsource.mediationsdk.events.h.x     // Catch:{ all -> 0x01a1 }
            int[] r2 = r8.f()     // Catch:{ all -> 0x01a1 }
            r12.b((int[]) r2, (android.content.Context) r11)     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.events.h r11 = com.ironsource.mediationsdk.events.h.x     // Catch:{ all -> 0x01a1 }
            boolean r12 = r8.c()     // Catch:{ all -> 0x01a1 }
            r11.c = r12     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.events.h r11 = com.ironsource.mediationsdk.events.h.x     // Catch:{ all -> 0x01a1 }
            int r12 = r8.d()     // Catch:{ all -> 0x01a1 }
            r11.d = r12     // Catch:{ all -> 0x01a1 }
        L_0x018f:
            com.ironsource.mediationsdk.events.e r11 = com.ironsource.mediationsdk.events.e.d()     // Catch:{ all -> 0x01a1 }
            r11.a = r1     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.events.i r11 = com.ironsource.mediationsdk.events.i.d()     // Catch:{ all -> 0x01a1 }
            r11.a = r1     // Catch:{ all -> 0x01a1 }
            com.ironsource.mediationsdk.events.h r11 = com.ironsource.mediationsdk.events.h.x     // Catch:{ all -> 0x01a1 }
            r11.a = r1     // Catch:{ all -> 0x01a1 }
        L_0x019f:
            monitor-exit(r0)     // Catch:{ all -> 0x01a1 }
            return r13
        L_0x01a1:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01a1 }
            goto L_0x01a5
        L_0x01a4:
            throw r11
        L_0x01a5:
            goto L_0x01a4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.a(android.content.Context, java.lang.String, com.ironsource.mediationsdk.z$a):com.ironsource.mediationsdk.utils.k");
    }

    public final void a(Activity activity) {
        if (!z()) {
            P.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            this.c.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", 3);
            return;
        }
        Placement y2 = y();
        if (y2 == null) {
            this.c.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo error: empty default placement in response", 3);
            P.a().a(new IronSourceError(1021, "showRewardedVideo error: empty default placement in response"), (AdInfo) null);
            return;
        }
        a(activity, y2.getPlacementName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.app.Activity r5, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout r6, java.lang.String r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.ironsource.mediationsdk.demandOnly.p$b r0 = new com.ironsource.mediationsdk.demandOnly.p$b     // Catch:{ all -> 0x008a }
            r0.<init>(r7)     // Catch:{ all -> 0x008a }
            r0.a((android.app.Activity) r5)     // Catch:{ all -> 0x008a }
            r0.a((com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout) r6)     // Catch:{ all -> 0x008a }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = r0.d()     // Catch:{ all -> 0x008a }
            r2 = 3
            if (r1 == 0) goto L_0x0029
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r4.c     // Catch:{ all -> 0x008a }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x008a }
            java.lang.String r3 = r1.getErrorMessage()     // Catch:{ all -> 0x008a }
            r5.log(r0, r3, r2)     // Catch:{ all -> 0x008a }
            if (r6 == 0) goto L_0x0027
            com.ironsource.mediationsdk.demandOnly.a r5 = r6.getListener()     // Catch:{ all -> 0x008a }
            r5.a(r7, r1)     // Catch:{ all -> 0x008a }
        L_0x0027:
            monitor-exit(r4)
            return
        L_0x0029:
            com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x008a }
            com.ironsource.mediationsdk.E$a r1 = r1.b()     // Catch:{ all -> 0x008a }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = r4.a((com.ironsource.mediationsdk.E.a) r1)     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x004b
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r4.c     // Catch:{ all -> 0x008a }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x008a }
            java.lang.String r3 = r1.getErrorMessage()     // Catch:{ all -> 0x008a }
            r5.log(r0, r3, r2)     // Catch:{ all -> 0x008a }
            com.ironsource.mediationsdk.demandOnly.a r5 = r6.getListener()     // Catch:{ all -> 0x008a }
            r5.a(r7, r1)     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return
        L_0x004b:
            com.ironsource.environment.ContextProvider r1 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x008a }
            r1.updateActivity(r5)     // Catch:{ all -> 0x008a }
            boolean r5 = r4.b((com.ironsource.mediationsdk.demandOnly.p.b) r0)     // Catch:{ all -> 0x008a }
            if (r5 == 0) goto L_0x005a
            monitor-exit(r4)
            return
        L_0x005a:
            boolean r5 = r4.F()     // Catch:{ all -> 0x008a }
            if (r5 != 0) goto L_0x007b
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r4.c     // Catch:{ all -> 0x008a }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x008a }
            java.lang.String r1 = "No banner configurations found"
            r5.log(r0, r1, r2)     // Catch:{ all -> 0x008a }
            com.ironsource.mediationsdk.demandOnly.a r5 = r6.getListener()     // Catch:{ all -> 0x008a }
            java.lang.String r6 = "the server response does not contain banner data"
            java.lang.String r0 = "Banner"
            com.ironsource.mediationsdk.logger.IronSourceError r6 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r6, r0)     // Catch:{ all -> 0x008a }
            r5.a(r7, r6)     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return
        L_0x007b:
            boolean r5 = r4.a((com.ironsource.mediationsdk.demandOnly.p.b) r0)     // Catch:{ all -> 0x008a }
            if (r5 == 0) goto L_0x0083
            monitor-exit(r4)
            return
        L_0x0083:
            com.ironsource.mediationsdk.demandOnly.c r5 = r4.L     // Catch:{ all -> 0x008a }
            r5.a(r6, r7)     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return
        L_0x008a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.a(android.app.Activity, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.app.Activity r4, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.ironsource.mediationsdk.demandOnly.p$b r0 = new com.ironsource.mediationsdk.demandOnly.p$b     // Catch:{ all -> 0x00c7 }
            r0.<init>(r6)     // Catch:{ all -> 0x00c7 }
            r0.a((java.lang.String) r7)     // Catch:{ all -> 0x00c7 }
            r0.a((android.app.Activity) r4)     // Catch:{ all -> 0x00c7 }
            r0.a((com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout) r5)     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = r0.d()     // Catch:{ all -> 0x00c7 }
            r2 = 3
            if (r1 == 0) goto L_0x002c
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r3.c     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00c7 }
            java.lang.String r0 = r1.getErrorMessage()     // Catch:{ all -> 0x00c7 }
            r4.log(r7, r0, r2)     // Catch:{ all -> 0x00c7 }
            if (r5 == 0) goto L_0x002a
            com.ironsource.mediationsdk.demandOnly.a r4 = r5.getListener()     // Catch:{ all -> 0x00c7 }
            r4.a(r6, r1)     // Catch:{ all -> 0x00c7 }
        L_0x002a:
            monitor-exit(r3)
            return
        L_0x002c:
            com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.E$a r1 = r1.b()     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = r3.a((com.ironsource.mediationsdk.E.a) r1)     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x004e
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r3.c     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00c7 }
            java.lang.String r0 = r1.getErrorMessage()     // Catch:{ all -> 0x00c7 }
            r4.log(r7, r0, r2)     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.demandOnly.a r4 = r5.getListener()     // Catch:{ all -> 0x00c7 }
            r4.a(r6, r1)     // Catch:{ all -> 0x00c7 }
            monitor-exit(r3)
            return
        L_0x004e:
            com.ironsource.environment.ContextProvider r1 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x00c7 }
            r1.updateActivity(r4)     // Catch:{ all -> 0x00c7 }
            boolean r4 = r3.b((com.ironsource.mediationsdk.demandOnly.p.b) r0)     // Catch:{ all -> 0x00c7 }
            if (r4 == 0) goto L_0x005d
            monitor-exit(r3)
            return
        L_0x005d:
            boolean r4 = r3.F()     // Catch:{ all -> 0x00c7 }
            if (r4 != 0) goto L_0x007e
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r3.c     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00c7 }
            java.lang.String r0 = "No banner configurations found"
            r4.log(r7, r0, r2)     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.demandOnly.a r4 = r5.getListener()     // Catch:{ all -> 0x00c7 }
            java.lang.String r5 = "the server response does not contain banner data"
            java.lang.String r7 = "Banner"
            com.ironsource.mediationsdk.logger.IronSourceError r5 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r5, r7)     // Catch:{ all -> 0x00c7 }
            r4.a(r6, r5)     // Catch:{ all -> 0x00c7 }
            monitor-exit(r3)
            return
        L_0x007e:
            boolean r4 = r3.a((com.ironsource.mediationsdk.demandOnly.p.b) r0)     // Catch:{ all -> 0x00c7 }
            if (r4 == 0) goto L_0x0086
            monitor-exit(r3)
            return
        L_0x0086:
            com.ironsource.mediationsdk.demandOnly.c r4 = r3.L     // Catch:{ all -> 0x00c7 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.d> r0 = r4.a     // Catch:{ all -> 0x00c7 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.demandOnly.d r0 = (com.ironsource.mediationsdk.demandOnly.d) r0     // Catch:{ all -> 0x00c7 }
            if (r0 != 0) goto L_0x00b1
            com.ironsource.mediationsdk.demandOnly.e r4 = r4.b     // Catch:{ all -> 0x00c7 }
            r7 = 3503(0xdaf, float:4.909E-42)
            r4.a(r7, r6)     // Catch:{ all -> 0x00c7 }
            java.lang.String r4 = "Banner"
            com.ironsource.mediationsdk.logger.IronSourceError r4 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildNonExistentInstanceError(r4)     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.logger.IronLog r7 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x00c7 }
            java.lang.String r0 = r4.getErrorMessage()     // Catch:{ all -> 0x00c7 }
            r7.error(r0)     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.demandOnly.a r5 = r5.getListener()     // Catch:{ all -> 0x00c7 }
            r5.a(r6, r4)     // Catch:{ all -> 0x00c7 }
            monitor-exit(r3)
            return
        L_0x00b1:
            com.ironsource.mediationsdk.demandOnly.o$a r4 = new com.ironsource.mediationsdk.demandOnly.o$a     // Catch:{ all -> 0x00c7 }
            com.ironsource.mediationsdk.utils.e r6 = com.ironsource.mediationsdk.utils.e.a()     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = com.ironsource.mediationsdk.utils.IronSourceAES.decode(r6, r7)     // Catch:{ all -> 0x00c7 }
            r4.<init>(r6)     // Catch:{ all -> 0x00c7 }
            r0.a((com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout) r5, (com.ironsource.mediationsdk.demandOnly.o) r4)     // Catch:{ all -> 0x00c7 }
            monitor-exit(r3)
            return
        L_0x00c7:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.a(android.app.Activity, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout, java.lang.String, java.lang.String):void");
    }

    public final void a(Activity activity, String str) {
        String str2 = "showRewardedVideo(" + str + ")";
        this.c.log(IronSourceLogger.IronSourceTag.API, str2, 1);
        try {
            if (this.r) {
                this.c.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", 3);
                P.a().a(ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            } else if (!z()) {
                P.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            } else {
                d(activity, str);
            }
        } catch (Exception e2) {
            this.c.logException(IronSourceLogger.IronSourceTag.API, str2, e2);
            P.a().a(new IronSourceError(510, e2.getMessage()), (AdInfo) null);
        }
    }

    public final synchronized void a(Activity activity, String str, String str2) {
        if (str2 == null) {
            this.c.log(IronSourceLogger.IronSourceTag.API, "adm cannot be null", 3);
            r.a().a(str, new IronSourceError(510, "adm cannot be null"));
            return;
        }
        b(activity, str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x029e, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x021e A[SYNTHETIC, Splitter:B:86:0x021e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r10, java.lang.String r11, boolean r12, com.ironsource.mediationsdk.sdk.InitializationListener r13, com.ironsource.mediationsdk.IronSource.AD_UNIT... r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x029f }
            r0.verbose()     // Catch:{ all -> 0x029f }
            java.lang.String r0 = "Init Failed - provided context is null"
            boolean r0 = com.ironsource.mediationsdk.d.b.a((java.lang.Object) r10, (java.lang.String) r0)     // Catch:{ all -> 0x029f }
            if (r0 != 0) goto L_0x0015
            java.lang.String r10 = "Provided context is null"
            r9.a((java.lang.String) r10)     // Catch:{ all -> 0x029f }
            monitor-exit(r9)
            return
        L_0x0015:
            boolean r0 = r10 instanceof android.app.Activity     // Catch:{ all -> 0x029f }
            if (r0 == 0) goto L_0x001f
            r1 = r10
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ all -> 0x029f }
            c((android.app.Activity) r1)     // Catch:{ all -> 0x029f }
        L_0x001f:
            if (r13 == 0) goto L_0x0023
            r9.ah = r13     // Catch:{ all -> 0x029f }
        L_0x0023:
            java.util.concurrent.atomic.AtomicBoolean r13 = r9.W     // Catch:{ all -> 0x029f }
            if (r13 == 0) goto L_0x027b
            r1 = 0
            r2 = 1
            boolean r13 = r13.compareAndSet(r2, r1)     // Catch:{ all -> 0x029f }
            if (r13 == 0) goto L_0x027b
            if (r14 == 0) goto L_0x0070
            int r13 = r14.length     // Catch:{ all -> 0x029f }
            if (r13 != 0) goto L_0x0035
            goto L_0x0070
        L_0x0035:
            int r13 = r14.length     // Catch:{ all -> 0x029f }
            r3 = 0
        L_0x0037:
            if (r3 >= r13) goto L_0x008a
            r4 = r14[r3]     // Catch:{ all -> 0x029f }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.Y     // Catch:{ all -> 0x029f }
            r5.add(r4)     // Catch:{ all -> 0x029f }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.Z     // Catch:{ all -> 0x029f }
            r5.add(r4)     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x029f }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x029f }
            if (r5 == 0) goto L_0x004f
            r9.u = r2     // Catch:{ all -> 0x029f }
        L_0x004f:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x029f }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x029f }
            if (r5 == 0) goto L_0x0059
            r9.ad = r2     // Catch:{ all -> 0x029f }
        L_0x0059:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.NATIVE_AD     // Catch:{ all -> 0x029f }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x029f }
            if (r5 == 0) goto L_0x0063
            r9.v = r2     // Catch:{ all -> 0x029f }
        L_0x0063:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x029f }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x029f }
            if (r4 == 0) goto L_0x006d
            r9.t = r2     // Catch:{ all -> 0x029f }
        L_0x006d:
            int r3 = r3 + 1
            goto L_0x0037
        L_0x0070:
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r13 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()     // Catch:{ all -> 0x029f }
            int r3 = r13.length     // Catch:{ all -> 0x029f }
            r4 = 0
        L_0x0076:
            if (r4 >= r3) goto L_0x0082
            r5 = r13[r4]     // Catch:{ all -> 0x029f }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r6 = r9.Y     // Catch:{ all -> 0x029f }
            r6.add(r5)     // Catch:{ all -> 0x029f }
            int r4 = r4 + 1
            goto L_0x0076
        L_0x0082:
            r9.t = r2     // Catch:{ all -> 0x029f }
            r9.u = r2     // Catch:{ all -> 0x029f }
            r9.ad = r2     // Catch:{ all -> 0x029f }
            r9.v = r2     // Catch:{ all -> 0x029f }
        L_0x008a:
            com.ironsource.mediationsdk.logger.IronLog r13 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x029f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
            java.lang.String r4 = "init(appKey:"
            r3.<init>(r4)     // Catch:{ all -> 0x029f }
            r3.append(r11)     // Catch:{ all -> 0x029f }
            java.lang.String r4 = ")"
            r3.append(r4)     // Catch:{ all -> 0x029f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x029f }
            r13.info(r3)     // Catch:{ all -> 0x029f }
            com.ironsource.d.a r13 = new com.ironsource.d.a     // Catch:{ all -> 0x029f }
            r13.<init>()     // Catch:{ all -> 0x029f }
            if (r11 == 0) goto L_0x00cd
            r3 = 5
            r4 = 10
            boolean r3 = a((java.lang.String) r11, (int) r3, (int) r4)     // Catch:{ all -> 0x029f }
            if (r3 == 0) goto L_0x00c4
            boolean r3 = p(r11)     // Catch:{ all -> 0x029f }
            if (r3 != 0) goto L_0x00d7
            java.lang.String r3 = "appKey"
            java.lang.String r4 = "should contain only english characters and numbers"
            com.ironsource.mediationsdk.logger.IronSourceError r3 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInvalidCredentialsError(r3, r11, r4)     // Catch:{ all -> 0x029f }
        L_0x00c0:
            r13.a((com.ironsource.mediationsdk.logger.IronSourceError) r3)     // Catch:{ all -> 0x029f }
            goto L_0x00d7
        L_0x00c4:
            java.lang.String r3 = "appKey"
            java.lang.String r4 = "length should be between 5-10 characters"
            com.ironsource.mediationsdk.logger.IronSourceError r3 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInvalidCredentialsError(r3, r11, r4)     // Catch:{ all -> 0x029f }
            goto L_0x00c0
        L_0x00cd:
            com.ironsource.mediationsdk.logger.IronSourceError r3 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x029f }
            java.lang.String r4 = "Init Fail - appKey is missing"
            r5 = 506(0x1fa, float:7.09E-43)
            r3.<init>(r5, r4)     // Catch:{ all -> 0x029f }
            goto L_0x00c0
        L_0x00d7:
            boolean r3 = r13.a()     // Catch:{ all -> 0x029f }
            if (r3 == 0) goto L_0x00df
            r9.g = r11     // Catch:{ all -> 0x029f }
        L_0x00df:
            java.lang.String r3 = r9.g     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.utils.k r3 = a((android.content.Context) r10, (java.lang.String) r3)     // Catch:{ all -> 0x029f }
            if (r3 == 0) goto L_0x010c
            com.ironsource.mediationsdk.model.f r3 = r3.c     // Catch:{ all -> 0x029f }
            com.ironsource.sdk.a.g r3 = r3.f()     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.utils.b r3 = r3.f()     // Catch:{ all -> 0x029f }
            com.ironsource.environment.g r4 = com.ironsource.environment.g.a     // Catch:{ all -> 0x029f }
            boolean r4 = r3.a()     // Catch:{ all -> 0x029f }
            com.ironsource.environment.g.a((boolean) r4)     // Catch:{ all -> 0x029f }
            com.ironsource.environment.g r4 = com.ironsource.environment.g.a     // Catch:{ all -> 0x029f }
            boolean r4 = r3.b()     // Catch:{ all -> 0x029f }
            com.ironsource.environment.g.c(r4)     // Catch:{ all -> 0x029f }
            com.ironsource.environment.g r4 = com.ironsource.environment.g.a     // Catch:{ all -> 0x029f }
            int r3 = r3.c()     // Catch:{ all -> 0x029f }
            com.ironsource.environment.g.a((int) r3)     // Catch:{ all -> 0x029f }
        L_0x010c:
            com.ironsource.environment.ContextProvider r3 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x029f }
            android.content.Context r4 = r10.getApplicationContext()     // Catch:{ all -> 0x029f }
            r3.updateAppContext(r4)     // Catch:{ all -> 0x029f }
            android.content.Context r3 = r10.getApplicationContext()     // Catch:{ all -> 0x029f }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ all -> 0x029f }
            com.ironsource.environment.g r5 = com.ironsource.environment.g.a     // Catch:{ all -> 0x029f }
            int r5 = com.ironsource.environment.g.d()     // Catch:{ all -> 0x029f }
            long r5 = (long) r5     // Catch:{ all -> 0x029f }
            long r4 = r4.toMillis(r5)     // Catch:{ all -> 0x029f }
            com.ironsource.environment.h.a((android.content.Context) r3, (long) r4)     // Catch:{ all -> 0x029f }
            java.lang.String r3 = com.ironsource.mediationsdk.utils.IronSourceUtils.getSDKVersion()     // Catch:{ all -> 0x029f }
            java.lang.String r4 = "medv"
            com.ironsource.environment.c.e.a((java.lang.String) r4, (java.lang.Object) r3)     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.b.a r3 = r9.N     // Catch:{ all -> 0x029f }
            com.ironsource.c.b r4 = com.ironsource.c.a.a()     // Catch:{ all -> 0x029f }
            r3.a((com.ironsource.c.b) r4)     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.b.a r3 = r9.N     // Catch:{ all -> 0x029f }
            boolean r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.isGooglePlayInstalled(r10)     // Catch:{ all -> 0x029f }
            r3.a((boolean) r4)     // Catch:{ all -> 0x029f }
            com.ironsource.environment.ContextProvider r3 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x029f }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x029f }
            boolean r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.isInitResponseCached(r3)     // Catch:{ all -> 0x029f }
            long r5 = com.ironsource.mediationsdk.utils.IronSourceUtils.getFirstSessionTimestamp(r3)     // Catch:{ all -> 0x029f }
            if (r4 != 0) goto L_0x0178
            r7 = -1
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x0178
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.logger.IronLog r6 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x029f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
            java.lang.String r8 = "get first session timestamp = "
            r7.<init>(r8)     // Catch:{ all -> 0x029f }
            r7.append(r4)     // Catch:{ all -> 0x029f }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x029f }
            r6.verbose(r7)     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.utils.IronSourceUtils.saveFirstSessionTimestamp(r3, r4)     // Catch:{ all -> 0x029f }
        L_0x0178:
            com.ironsource.mediationsdk.d.c r3 = com.ironsource.mediationsdk.d.c.a()     // Catch:{ all -> 0x029f }
            java.util.concurrent.ConcurrentHashMap r3 = r3.c()     // Catch:{ all -> 0x029f }
            java.lang.String r4 = "is_deviceid_optout"
            boolean r4 = r3.containsKey(r4)     // Catch:{ all -> 0x029f }
            if (r4 == 0) goto L_0x01aa
            java.lang.String r4 = "is_deviceid_optout"
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x029f }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x029f }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x029f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x029f }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x029f }
            if (r4 != 0) goto L_0x01aa
            boolean r3 = com.ironsource.mediationsdk.metadata.MetaDataUtils.getMetaDataBooleanValue(r3)     // Catch:{ all -> 0x029f }
            if (r3 != 0) goto L_0x01a4
            r3 = 1
            goto L_0x01a5
        L_0x01a4:
            r3 = 0
        L_0x01a5:
            com.ironsource.environment.g r4 = com.ironsource.environment.g.a     // Catch:{ all -> 0x029f }
            com.ironsource.environment.g.b(r3)     // Catch:{ all -> 0x029f }
        L_0x01aa:
            java.util.concurrent.atomic.AtomicBoolean r3 = r9.T     // Catch:{ all -> 0x029f }
            if (r3 == 0) goto L_0x01d9
            boolean r3 = r3.compareAndSet(r1, r2)     // Catch:{ all -> 0x029f }
            if (r3 == 0) goto L_0x01d9
            com.ironsource.mediationsdk.events.j r3 = com.ironsource.mediationsdk.events.j.a()     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.utils.f r4 = new com.ironsource.mediationsdk.utils.f     // Catch:{ all -> 0x029f }
            r4.<init>(r10)     // Catch:{ all -> 0x029f }
            r3.a(r4)     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.events.e r3 = com.ironsource.mediationsdk.events.e.d()     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.IronSourceSegment r4 = r9.p     // Catch:{ all -> 0x029f }
            r3.a((android.content.Context) r10, (com.ironsource.mediationsdk.IronSourceSegment) r4)     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.events.i r3 = com.ironsource.mediationsdk.events.i.d()     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.IronSourceSegment r4 = r9.p     // Catch:{ all -> 0x029f }
            r3.a((android.content.Context) r10, (com.ironsource.mediationsdk.IronSourceSegment) r4)     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.events.h r3 = com.ironsource.mediationsdk.events.h.x     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.IronSourceSegment r4 = r9.p     // Catch:{ all -> 0x029f }
            r3.a((android.content.Context) r10, (com.ironsource.mediationsdk.IronSourceSegment) r4)     // Catch:{ all -> 0x029f }
        L_0x01d9:
            java.lang.String r3 = r9.g     // Catch:{ all -> 0x029f }
            if (r3 != 0) goto L_0x021e
            com.ironsource.mediationsdk.E r10 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.E$a r11 = com.ironsource.mediationsdk.E.a.INIT_FAILED     // Catch:{ all -> 0x029f }
            r10.a((com.ironsource.mediationsdk.E.a) r11)     // Catch:{ all -> 0x029f }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r10 = r9.Y     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x029f }
            boolean r10 = r10.contains(r11)     // Catch:{ all -> 0x029f }
            if (r10 == 0) goto L_0x01f8
            com.ironsource.mediationsdk.P r10 = com.ironsource.mediationsdk.P.a()     // Catch:{ all -> 0x029f }
            r11 = 0
            r10.a((boolean) r1, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r11)     // Catch:{ all -> 0x029f }
        L_0x01f8:
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r10 = r9.Y     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ all -> 0x029f }
            boolean r10 = r10.contains(r11)     // Catch:{ all -> 0x029f }
            if (r10 == 0) goto L_0x020b
            com.ironsource.mediationsdk.sdk.e r10 = r9.d     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = r13.b()     // Catch:{ all -> 0x029f }
            r10.a(r1, r11)     // Catch:{ all -> 0x029f }
        L_0x020b:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r10 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r11 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.logger.IronSourceError r12 = r13.b()     // Catch:{ all -> 0x029f }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x029f }
            r10.log(r11, r12, r2)     // Catch:{ all -> 0x029f }
            monitor-exit(r9)
            return
        L_0x021e:
            com.ironsource.environment.c.e.a((android.content.Context) r10)     // Catch:{ all -> 0x029f }
            java.lang.String r13 = r9.g     // Catch:{ all -> 0x029f }
            java.lang.String r3 = "apky"
            com.ironsource.environment.c.e.a((java.lang.String) r3, (java.lang.Object) r13)     // Catch:{ all -> 0x029f }
            java.lang.String r13 = r9.m     // Catch:{ all -> 0x029f }
            java.lang.String r3 = "sid"
            com.ironsource.environment.c.e.a((java.lang.String) r3, (java.lang.Object) r13)     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.config.ConfigFile r13 = com.ironsource.mediationsdk.config.ConfigFile.getConfigFile()     // Catch:{ all -> 0x029f }
            java.lang.String r13 = r13.getPluginType()     // Catch:{ all -> 0x029f }
            java.lang.String r3 = "plugin"
            com.ironsource.environment.c.e.a((java.lang.String) r3, (java.lang.Object) r13)     // Catch:{ all -> 0x029f }
            boolean r13 = r9.aa     // Catch:{ all -> 0x029f }
            if (r13 == 0) goto L_0x0260
            org.json.JSONObject r13 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r12)     // Catch:{ all -> 0x029f }
            if (r14 == 0) goto L_0x0256
            int r3 = r14.length     // Catch:{ all -> 0x029f }
            r4 = 0
        L_0x0248:
            if (r4 >= r3) goto L_0x0256
            r5 = r14[r4]     // Catch:{ all -> 0x029f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0253 }
            r13.put(r5, r2)     // Catch:{ Exception -> 0x0253 }
        L_0x0253:
            int r4 = r4 + 1
            goto L_0x0248
        L_0x0256:
            int r14 = r9.q     // Catch:{ all -> 0x029f }
            int r14 = r14 + r2
            r9.q = r14     // Catch:{ all -> 0x029f }
            a((boolean) r0, (boolean) r12, (int) r14, (org.json.JSONObject) r13)     // Catch:{ all -> 0x029f }
            r9.aa = r1     // Catch:{ all -> 0x029f }
        L_0x0260:
            com.ironsource.mediationsdk.E r12 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x029f }
            r12.a((com.ironsource.mediationsdk.utils.h) r9)     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.E r12 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.impressionData.a r13 = r9.M     // Catch:{ all -> 0x029f }
            r12.a((com.ironsource.mediationsdk.utils.h) r13)     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.E r12 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x029f }
            java.lang.String r13 = r9.h     // Catch:{ all -> 0x029f }
            r12.a(r10, r11, r13)     // Catch:{ all -> 0x029f }
            monitor-exit(r9)
            return
        L_0x027b:
            if (r14 == 0) goto L_0x0293
            r9.a((boolean) r0, (boolean) r12, (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r14)     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.E r10 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.E$a r10 = r10.b()     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.E$a r11 = com.ironsource.mediationsdk.E.a.INITIATED     // Catch:{ all -> 0x029f }
            if (r10 != r11) goto L_0x029d
            if (r12 != 0) goto L_0x029d
            r9.G()     // Catch:{ all -> 0x029f }
            monitor-exit(r9)
            return
        L_0x0293:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r10 = r9.c     // Catch:{ all -> 0x029f }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r11 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x029f }
            java.lang.String r12 = "Multiple calls to init without ad units are not allowed"
            r13 = 3
            r10.log(r11, r12, r13)     // Catch:{ all -> 0x029f }
        L_0x029d:
            monitor-exit(r9)
            return
        L_0x029f:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x02a3
        L_0x02a2:
            throw r10
        L_0x02a3:
            goto L_0x02a2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.a(android.content.Context, java.lang.String, boolean, com.ironsource.mediationsdk.sdk.InitializationListener, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r9, java.lang.String r10, com.ironsource.mediationsdk.IronSource.AD_UNIT... r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00f1 }
            r0.<init>()     // Catch:{ all -> 0x00f1 }
            r1 = 1
            if (r11 == 0) goto L_0x008a
            int r2 = r11.length     // Catch:{ all -> 0x00f1 }
            if (r2 != 0) goto L_0x000e
            goto L_0x008a
        L_0x000e:
            int r2 = r11.length     // Catch:{ all -> 0x00f1 }
            r3 = 0
        L_0x0010:
            if (r3 >= r2) goto L_0x00bd
            r4 = r11[r3]     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ all -> 0x00f1 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x0036
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r8.c     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r6 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00f1 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r7.<init>()     // Catch:{ all -> 0x00f1 }
            r7.append(r4)     // Catch:{ all -> 0x00f1 }
            java.lang.String r4 = " ad unit cannot be initialized in demand only mode"
            r7.append(r4)     // Catch:{ all -> 0x00f1 }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x00f1 }
            r7 = 3
            r5.log(r6, r4, r7)     // Catch:{ all -> 0x00f1 }
            goto L_0x0087
        L_0x0036:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x00f1 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x0051
            boolean r5 = r8.u     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x0046
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r4)     // Catch:{ all -> 0x00f1 }
            goto L_0x0051
        L_0x0046:
            r8.s = r1     // Catch:{ all -> 0x00f1 }
            boolean r5 = r0.contains(r4)     // Catch:{ all -> 0x00f1 }
            if (r5 != 0) goto L_0x0051
            r0.add(r4)     // Catch:{ all -> 0x00f1 }
        L_0x0051:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x00f1 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x006c
            boolean r5 = r8.t     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x0061
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r4)     // Catch:{ all -> 0x00f1 }
            goto L_0x006c
        L_0x0061:
            r8.r = r1     // Catch:{ all -> 0x00f1 }
            boolean r5 = r0.contains(r4)     // Catch:{ all -> 0x00f1 }
            if (r5 != 0) goto L_0x006c
            r0.add(r4)     // Catch:{ all -> 0x00f1 }
        L_0x006c:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x00f1 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x0087
            boolean r5 = r8.ad     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x007c
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r4)     // Catch:{ all -> 0x00f1 }
            goto L_0x0087
        L_0x007c:
            r8.ac = r1     // Catch:{ all -> 0x00f1 }
            boolean r5 = r0.contains(r4)     // Catch:{ all -> 0x00f1 }
            if (r5 != 0) goto L_0x0087
            r0.add(r4)     // Catch:{ all -> 0x00f1 }
        L_0x0087:
            int r3 = r3 + 1
            goto L_0x0010
        L_0x008a:
            boolean r11 = r8.t     // Catch:{ all -> 0x00f1 }
            if (r11 == 0) goto L_0x0094
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x00f1 }
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r11)     // Catch:{ all -> 0x00f1 }
            goto L_0x009b
        L_0x0094:
            r8.r = r1     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x00f1 }
            r0.add(r11)     // Catch:{ all -> 0x00f1 }
        L_0x009b:
            boolean r11 = r8.u     // Catch:{ all -> 0x00f1 }
            if (r11 == 0) goto L_0x00a5
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x00f1 }
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r11)     // Catch:{ all -> 0x00f1 }
            goto L_0x00ac
        L_0x00a5:
            r8.s = r1     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x00f1 }
            r0.add(r11)     // Catch:{ all -> 0x00f1 }
        L_0x00ac:
            boolean r11 = r8.ad     // Catch:{ all -> 0x00f1 }
            if (r11 == 0) goto L_0x00b6
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x00f1 }
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r11)     // Catch:{ all -> 0x00f1 }
            goto L_0x00bd
        L_0x00b6:
            r8.ac = r1     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x00f1 }
            r0.add(r11)     // Catch:{ all -> 0x00f1 }
        L_0x00bd:
            if (r9 == 0) goto L_0x00d4
            boolean r11 = r9 instanceof android.app.Activity     // Catch:{ all -> 0x00f1 }
            if (r11 == 0) goto L_0x00c9
            r11 = r9
            android.app.Activity r11 = (android.app.Activity) r11     // Catch:{ all -> 0x00f1 }
            c((android.app.Activity) r11)     // Catch:{ all -> 0x00f1 }
        L_0x00c9:
            com.ironsource.environment.ContextProvider r11 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x00f1 }
            android.content.Context r1 = r9.getApplicationContext()     // Catch:{ all -> 0x00f1 }
            r11.updateAppContext(r1)     // Catch:{ all -> 0x00f1 }
        L_0x00d4:
            boolean r11 = r0.isEmpty()     // Catch:{ all -> 0x00f1 }
            if (r11 != 0) goto L_0x00ef
            int r11 = r0.size()     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r11 = new com.ironsource.mediationsdk.IronSource.AD_UNIT[r11]     // Catch:{ all -> 0x00f1 }
            java.lang.Object[] r11 = r0.toArray(r11)     // Catch:{ all -> 0x00f1 }
            r5 = r11
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r5 = (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r5     // Catch:{ all -> 0x00f1 }
            r3 = 1
            r4 = 0
            r0 = r8
            r1 = r9
            r2 = r10
            r0.a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00f1 }
        L_0x00ef:
            monitor-exit(r8)
            return
        L_0x00f1:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x00f5
        L_0x00f4:
            throw r9
        L_0x00f5:
            goto L_0x00f4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.a(android.content.Context, java.lang.String, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(AbstractAdapter abstractAdapter) {
        this.S = abstractAdapter;
    }

    public final void a(IronSourceBannerLayout ironSourceBannerLayout, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("placementName = " + str);
        if (this.ac) {
            this.c.log(IronSourceLogger.IronSourceTag.API, "Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", 3);
            C0227q.a().a(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildInitFailedError("Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", IronSourceConstants.BANNER_AD_UNIT));
        } else if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            String concat = "loadBanner can't be called - ".concat(ironSourceBannerLayout == null ? "banner layout is null " : "banner layout is destroyed");
            this.c.log(IronSourceLogger.IronSourceTag.API, concat, 3);
            C0227q.a().a(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildLoadFailedError(concat));
        } else if (!this.ad) {
            this.c.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadBanner()", 3);
            C0227q.a().a(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildLoadFailedError("init() must be called before loadBanner()"));
        } else if (!ironSourceBannerLayout.getSize().getDescription().equals("CUSTOM") || (ironSourceBannerLayout.getSize().getWidth() > 0 && ironSourceBannerLayout.getSize().getHeight() > 0)) {
            E.a b2 = E.a().b();
            if (b2 == E.a.INIT_FAILED) {
                this.c.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                C0227q.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(600, "Init() had failed"));
            } else if (b2 == E.a.INIT_IN_PROGRESS) {
                if (E.a().c()) {
                    this.c.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    C0227q.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(601, "Init() had failed"));
                    return;
                }
                this.af = ironSourceBannerLayout;
                this.ae = Boolean.TRUE;
                this.ag = str;
            } else if (!F()) {
                this.c.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
                C0227q.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(IronSourceError.ERROR_BN_LOAD_NO_CONFIG, "the server response does not contain banner data"));
            } else {
                I i2 = this.z;
                if (i2 == null && this.C == null) {
                    this.af = ironSourceBannerLayout;
                    this.ae = Boolean.TRUE;
                    this.ag = str;
                } else if (this.I) {
                    this.C.a(ironSourceBannerLayout, new Placement(r(str)));
                } else {
                    i2.a(ironSourceBannerLayout, r(str));
                }
            }
        } else {
            this.c.log(IronSourceLogger.IronSourceTag.API, "loadBanner: Unsupported banner size. Height and width must be bigger than 0", 3);
            C0227q.a().a(IronSource.AD_UNIT.BANNER, ErrorBuilder.unsupportedBannerSize(""));
        }
    }

    public final synchronized void a(LevelPlayRewardedVideoManualListener levelPlayRewardedVideoManualListener) {
        IronLog ironLog;
        String str;
        if (levelPlayRewardedVideoManualListener == null) {
            IronLog.API.info("RVListener is null");
        } else {
            IronLog.API.info();
        }
        if (!this.t) {
            if (levelPlayRewardedVideoManualListener == null) {
                this.D = false;
                ironLog = IronLog.API;
                str = "Disabling rewarded video manual mode";
            } else {
                this.D = true;
                ironLog = IronLog.API;
                str = "Enabling rewarded video manual mode";
            }
            ironLog.info(str);
        }
        P.a().b = levelPlayRewardedVideoManualListener;
    }

    public final synchronized void a(RewardedVideoManualListener rewardedVideoManualListener) {
        IronLog ironLog;
        String str;
        if (rewardedVideoManualListener == null) {
            IronLog.API.info("RVListener is null");
        } else {
            IronLog.API.info();
        }
        if (!this.t) {
            if (rewardedVideoManualListener == null) {
                this.D = false;
                ironLog = IronLog.API;
                str = "Disabling rewarded video manual mode";
            } else {
                this.D = true;
                ironLog = IronLog.API;
                str = "Enabling rewarded video manual mode";
            }
            ironLog.info(str);
        }
        this.d.a = rewardedVideoManualListener;
        P.a().a = rewardedVideoManualListener;
    }

    public final void a(String str) {
        try {
            IronSourceLoggerManager ironSourceLoggerManager = this.c;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "onInitFailed(reason:" + str + ")", 1);
            IronSourceUtils.sendAutomationLog("Mediation init failed");
            if (this.d != null) {
                for (IronSource.AD_UNIT a2 : this.Y) {
                    a(a2, true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, List<String> list) {
        IronLog ironLog = IronLog.API;
        ironLog.verbose("key = " + str + ", values = " + list.toString());
        String checkMetaDataKeyValidity = MetaDataUtils.checkMetaDataKeyValidity(str);
        String checkMetaDataValueValidity = MetaDataUtils.checkMetaDataValueValidity(list);
        if (checkMetaDataKeyValidity.length() > 0) {
            IronLog.API.verbose(checkMetaDataKeyValidity);
        } else if (checkMetaDataValueValidity.length() > 0) {
            IronLog.API.verbose(checkMetaDataValueValidity);
        } else {
            MetaData formatMetaData = MetaDataUtils.formatMetaData(str, list);
            String metaDataKey = formatMetaData.getMetaDataKey();
            List<String> metaDataValue = formatMetaData.getMetaDataValue();
            if (!MetaDataUtils.isMediationOnlyKey(metaDataKey)) {
                C0213c.a().a(metaDataKey, metaDataValue);
            } else if (E.a().b() != E.a.INITIATED || !MetaDataUtils.isMediationKeysBeforeInit(metaDataKey)) {
                com.ironsource.mediationsdk.d.c.a().a(metaDataKey, metaDataValue);
            } else {
                IronLog ironLog2 = IronLog.API;
                ironLog2.error("setMetaData with key = " + metaDataKey + " must to be called before init");
            }
            try {
                ConcurrentHashMap<String, List<String>> concurrentHashMap = C0213c.a().d;
                concurrentHashMap.putAll(com.ironsource.mediationsdk.d.c.a().c());
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry next : concurrentHashMap.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
                com.ironsource.environment.c.e.a("md", (Object) jSONObject);
            } catch (JSONException e2) {
                IronLog ironLog3 = IronLog.INTERNAL;
                ironLog3.error("got the following error " + e2.getMessage());
                e2.printStackTrace();
            }
            i.d().a(new com.ironsource.environment.c.a(E.a().b() == E.a.INITIATED ? 51 : 50, IronSourceUtils.getJsonForMetaData(str, list, metaDataValue)));
        }
    }

    public final void a(List<IronSource.AD_UNIT> list, boolean z2, com.ironsource.mediationsdk.model.f fVar) {
        IronLog.INTERNAL.verbose();
        try {
            this.e.d = fVar.f().a().c();
            this.X = list;
            boolean z3 = true;
            this.l = true;
            this.c.log(IronSourceLogger.IronSourceTag.API, "onInitSuccess()", 1);
            IronSourceUtils.sendAutomationLog("init success");
            if (z2) {
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                try {
                    mediationAdditionalData.put("revived", true);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                i.d().a(new com.ironsource.environment.c.a(114, mediationAdditionalData));
            }
            com.ironsource.mediationsdk.events.e.d().b();
            i.d().b();
            C0213c a2 = C0213c.a();
            String str = this.g;
            String str2 = this.h;
            a2.b = str;
            a2.c = str2;
            for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                if (this.Y.contains(ad_unit)) {
                    if (list.contains(ad_unit)) {
                        b(ad_unit);
                    } else {
                        a(ad_unit, false);
                    }
                }
            }
            if (H()) {
                if (this.P != null || !this.f.c.h().a() || !AdQualityBridge.adQualityAvailable()) {
                    z3 = false;
                }
                if (z3) {
                    AdQualityBridge adQualityBridge = new AdQualityBridge(ContextProvider.getInstance().getApplicationContext(), this.g, this.h, this.f.c.f().a().b());
                    this.P = adQualityBridge;
                    IronSourceSegment ironSourceSegment = this.p;
                    if (ironSourceSegment != null) {
                        adQualityBridge.setSegment(ironSourceSegment);
                    }
                }
            }
            G();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized AbstractAdapter b(String str) {
        try {
            AbstractAdapter abstractAdapter = this.S;
            if (abstractAdapter != null && abstractAdapter.getProviderName().equals(str)) {
                return this.S;
            }
        } catch (Exception e2) {
            IronSourceLoggerManager ironSourceLoggerManager = this.c;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, "getOfferwallAdapter exception: " + e2, 1);
        }
        return null;
    }

    public final com.ironsource.mediationsdk.adunit.c.g b() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.f.a.d);
        if (a2.size() > 0) {
            return new com.ironsource.mediationsdk.adunit.c.g(a2, this.f.c.e(), IronSourceUtils.getUserIdForNetworks(), com.ironsource.mediationsdk.d.c.a(), this.p, this.f.d());
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b((int) IronSourceConstants.TROUBLESHOOTING_NT_INIT_FAILED, mediationAdditionalData);
        return null;
    }

    public final String b(Context context) {
        String str;
        com.ironsource.mediationsdk.utils.n nVar;
        a((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED, (JSONObject) null);
        if (context == null) {
            IronLog.API.error("bidding data cannot be retrieved, context required");
            return null;
        }
        E.a b2 = E.a().b();
        if (b2 == E.a.NOT_INIT) {
            IronLog.API.error("bidding data cannot be retrieved, SDK not initialized");
            a((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, (JSONObject) null);
            return null;
        } else if (b2 == E.a.INIT_FAILED) {
            IronLog.API.error("bidding data cannot be retrieved, SDK failed to initialize");
            a((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, (JSONObject) null);
            return null;
        } else {
            try {
                k kVar = this.f;
                if (kVar == null) {
                    kVar = C0233w.a(context);
                }
                if (b2 == E.a.NOT_INIT) {
                    com.ironsource.environment.c.e.a(context);
                    com.ironsource.environment.c.e.a("medv", (Object) IronSourceUtils.getSDKVersion());
                    com.ironsource.environment.c.e.a(CmcdConfiguration.KEY_SESSION_ID, (Object) this.m);
                    com.ironsource.environment.c.e.a("plugin", (Object) ConfigFile.getConfigFile().getPluginType());
                    this.N.a(com.ironsource.c.a.a());
                    this.N.a(IronSourceUtils.isGooglePlayInstalled(context));
                }
                if (b2 != E.a.INITIATED) {
                    E.a().a(kVar);
                    if (kVar != null) {
                        E.a().a(context, kVar);
                    }
                }
                if (kVar == null || !kVar.b()) {
                    nVar = new com.ironsource.mediationsdk.utils.n();
                } else {
                    nVar = kVar.c.f().c();
                    if (!nVar.d) {
                        nVar.b = kVar.b.a(IronSourceConstants.IRONSOURCE_CONFIG_NAME);
                    }
                }
                JSONObject a2 = W.a(context, nVar);
                C0215e.a().a(a2, true);
                str = nVar.e ? IronSourceAES.compressAndEncrypt(a2.toString()) : IronSourceAES.encrypt(a2.toString());
            } catch (Throwable th) {
                a((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_ENRICH_TOKEN_ERROR, (JSONObject) null);
                IronLog ironLog = IronLog.API;
                ironLog.error("got error during token creation: " + th.getMessage());
                str = null;
            }
            if (str == null) {
                a((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, (JSONObject) null);
            }
            return str;
        }
    }

    public final void b(Activity activity) {
        this.c.log(IronSourceLogger.IronSourceTag.API, "showInterstitial()", 1);
        try {
            if (this.s) {
                this.c.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                C0231u.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else if (!C()) {
                C0231u.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", IronSourceConstants.INTERSTITIAL_AD_UNIT), (AdInfo) null);
            } else {
                InterstitialPlacement B2 = B();
                if (B2 != null) {
                    b(activity, B2.getPlacementName());
                } else {
                    C0231u.a().a(new IronSourceError(1020, "showInterstitial error: empty default placement in response"), (AdInfo) null);
                }
            }
        } catch (Exception e2) {
            this.c.logException(IronSourceLogger.IronSourceTag.API, "showInterstitial()", e2);
            C0231u.a().a(new IronSourceError(510, e2.getMessage()), (AdInfo) null);
        }
    }

    public final void b(Activity activity, String str) {
        String str2 = "showInterstitial(" + str + ")";
        this.c.log(IronSourceLogger.IronSourceTag.API, str2, 1);
        try {
            if (this.s) {
                this.c.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                C0231u.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else if (!C()) {
                C0231u.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", IronSourceConstants.INTERSTITIAL_AD_UNIT), (AdInfo) null);
            } else {
                e(activity, str);
            }
        } catch (Exception e2) {
            this.c.logException(IronSourceLogger.IronSourceTag.API, str2, e2);
            C0231u.a().a(new IronSourceError(510, e2.getMessage()), (AdInfo) null);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized void b(android.app.Activity r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r5.c     // Catch:{ all -> 0x015b }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x015b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x015b }
            java.lang.String r3 = "loadISDemandOnlyRewardedVideo() instanceId="
            r2.<init>(r3)     // Catch:{ all -> 0x015b }
            r2.append(r7)     // Catch:{ all -> 0x015b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x015b }
            r3 = 1
            r0.log(r1, r2, r3)     // Catch:{ all -> 0x015b }
            boolean r0 = r5.t     // Catch:{ all -> 0x013d }
            r1 = 508(0x1fc, float:7.12E-43)
            r2 = 3
            if (r0 != 0) goto L_0x0035
            java.lang.String r6 = "initISDemandOnly() must be called before loadISDemandOnlyRewardedVideo()"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r8 = r5.c     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x013d }
            r8.log(r0, r6, r2)     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.demandOnly.r r8 = com.ironsource.mediationsdk.demandOnly.r.a()     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x013d }
            r0.<init>(r1, r6)     // Catch:{ all -> 0x013d }
            r8.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r0)     // Catch:{ all -> 0x013d }
            monitor-exit(r5)
            return
        L_0x0035:
            boolean r0 = r5.r     // Catch:{ all -> 0x013d }
            if (r0 != 0) goto L_0x0050
            java.lang.String r6 = "Rewarded video was initialized in mediation mode"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r8 = r5.c     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x013d }
            r8.log(r0, r6, r2)     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.demandOnly.r r8 = com.ironsource.mediationsdk.demandOnly.r.a()     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x013d }
            r0.<init>(r1, r6)     // Catch:{ all -> 0x013d }
            r8.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r0)     // Catch:{ all -> 0x013d }
            monitor-exit(r5)
            return
        L_0x0050:
            r0 = 0
            if (r6 == 0) goto L_0x0057
            c((android.app.Activity) r6)     // Catch:{ all -> 0x013d }
            goto L_0x0088
        L_0x0057:
            com.ironsource.environment.ContextProvider r6 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x013d }
            android.app.Activity r6 = r6.getCurrentActiveActivity()     // Catch:{ all -> 0x013d }
            if (r6 != 0) goto L_0x0088
            if (r8 != 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r0 = 1
        L_0x0065:
            org.json.JSONObject r6 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r0, r3)     // Catch:{ all -> 0x013d }
            r8 = 81321(0x13da9, float:1.13955E-40)
            a((int) r8, (org.json.JSONObject) r6)     // Catch:{ all -> 0x013d }
            java.lang.String r6 = "Rewarded video was initialized and loaded without Activity"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r8 = r5.c     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x013d }
            r8.log(r0, r6, r2)     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.demandOnly.r r8 = com.ironsource.mediationsdk.demandOnly.r.a()     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x013d }
            r1 = 1060(0x424, float:1.485E-42)
            r0.<init>(r1, r6)     // Catch:{ all -> 0x013d }
            r8.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r0)     // Catch:{ all -> 0x013d }
            monitor-exit(r5)
            return
        L_0x0088:
            com.ironsource.mediationsdk.E r6 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.E$a r6 = r6.b()     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.E$a r1 = com.ironsource.mediationsdk.E.a.INIT_FAILED     // Catch:{ all -> 0x013d }
            if (r6 != r1) goto L_0x00ae
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r6 = r5.c     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r8 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x013d }
            java.lang.String r0 = "init() had failed"
            r6.log(r8, r0, r2)     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.demandOnly.r r6 = com.ironsource.mediationsdk.demandOnly.r.a()     // Catch:{ all -> 0x013d }
            java.lang.String r8 = "init() had failed"
            java.lang.String r0 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r0)     // Catch:{ all -> 0x013d }
            r6.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x013d }
            monitor-exit(r5)
            return
        L_0x00ae:
            com.ironsource.mediationsdk.E$a r1 = com.ironsource.mediationsdk.E.a.INIT_IN_PROGRESS     // Catch:{ all -> 0x013d }
            r4 = 83002(0x1443a, float:1.1631E-40)
            if (r6 != r1) goto L_0x00f2
            com.ironsource.mediationsdk.E r6 = com.ironsource.mediationsdk.E.a()     // Catch:{ all -> 0x013d }
            boolean r6 = r6.c()     // Catch:{ all -> 0x013d }
            if (r6 == 0) goto L_0x00d9
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r6 = r5.c     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r8 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x013d }
            java.lang.String r0 = "init() had failed"
            r6.log(r8, r0, r2)     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.demandOnly.r r6 = com.ironsource.mediationsdk.demandOnly.r.a()     // Catch:{ all -> 0x013d }
            java.lang.String r8 = "init() had failed"
            java.lang.String r0 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r0)     // Catch:{ all -> 0x013d }
            r6.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x013d }
            monitor-exit(r5)
            return
        L_0x00d9:
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r6 = r5.al     // Catch:{ all -> 0x013d }
            monitor-enter(r6)     // Catch:{ all -> 0x013d }
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r0 = r5.al     // Catch:{ all -> 0x00ef }
            r0.add(r7)     // Catch:{ all -> 0x00ef }
            monitor-exit(r6)     // Catch:{ all -> 0x00ef }
            if (r8 == 0) goto L_0x00ed
            int r6 = r5.J     // Catch:{ all -> 0x013d }
            org.json.JSONObject r6 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r3, r6)     // Catch:{ all -> 0x013d }
            a((int) r4, (org.json.JSONObject) r6)     // Catch:{ all -> 0x013d }
        L_0x00ed:
            monitor-exit(r5)
            return
        L_0x00ef:
            r8 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00ef }
            throw r8     // Catch:{ all -> 0x013d }
        L_0x00f2:
            boolean r6 = r5.e()     // Catch:{ all -> 0x013d }
            if (r6 != 0) goto L_0x0113
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r6 = r5.c     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r8 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x013d }
            java.lang.String r0 = "No rewarded video configurations found"
            r6.log(r8, r0, r2)     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.demandOnly.r r6 = com.ironsource.mediationsdk.demandOnly.r.a()     // Catch:{ all -> 0x013d }
            java.lang.String r8 = "the server response does not contain rewarded video data"
            java.lang.String r0 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r0)     // Catch:{ all -> 0x013d }
            r6.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x013d }
            monitor-exit(r5)
            return
        L_0x0113:
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r6 = r5.al     // Catch:{ all -> 0x013d }
            monitor-enter(r6)     // Catch:{ all -> 0x013d }
            com.ironsource.mediationsdk.demandOnly.h r1 = r5.am     // Catch:{ all -> 0x013a }
            if (r1 != 0) goto L_0x012d
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r0 = r5.al     // Catch:{ all -> 0x013a }
            r0.add(r7)     // Catch:{ all -> 0x013a }
            if (r8 == 0) goto L_0x012a
            int r8 = r5.J     // Catch:{ all -> 0x013a }
            org.json.JSONObject r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r3, r8)     // Catch:{ all -> 0x013a }
            a((int) r4, (org.json.JSONObject) r8)     // Catch:{ all -> 0x013a }
        L_0x012a:
            monitor-exit(r6)     // Catch:{ all -> 0x013a }
            monitor-exit(r5)
            return
        L_0x012d:
            monitor-exit(r6)     // Catch:{ all -> 0x013a }
            if (r8 != 0) goto L_0x0135
            r6 = 0
            r1.a((java.lang.String) r7, (java.lang.String) r6, (boolean) r0)     // Catch:{ all -> 0x013d }
            goto L_0x0159
        L_0x0135:
            r1.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r3)     // Catch:{ all -> 0x013d }
            monitor-exit(r5)
            return
        L_0x013a:
            r8 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x013a }
            throw r8     // Catch:{ all -> 0x013d }
        L_0x013d:
            r6 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r8 = r5.c     // Catch:{ all -> 0x015b }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x015b }
            java.lang.String r1 = "loadISDemandOnlyRewardedVideo"
            r8.logException(r0, r1, r6)     // Catch:{ all -> 0x015b }
            com.ironsource.mediationsdk.demandOnly.r r8 = com.ironsource.mediationsdk.demandOnly.r.a()     // Catch:{ all -> 0x015b }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x015b }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x015b }
            r1 = 510(0x1fe, float:7.15E-43)
            r0.<init>(r1, r6)     // Catch:{ all -> 0x015b }
            r8.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r0)     // Catch:{ all -> 0x015b }
        L_0x0159:
            monitor-exit(r5)
            return
        L_0x015b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.b(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public final void b(boolean z2) {
        this.w = Boolean.valueOf(z2);
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        logger.log(ironSourceTag, "setConsent : " + z2, 1);
        C0213c.a().a(z2);
        if (this.S != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.c;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.ADAPTER_API;
            ironSourceLoggerManager.log(ironSourceTag2, "Offerwall | setConsent(consent:" + z2 + ")", 1);
            this.S.setConsent(z2);
        }
        int i2 = !z2 ? 41 : 40;
        com.ironsource.environment.c.e.a("cnst", (Object) Boolean.valueOf(z2));
        i.d().a(new com.ironsource.environment.c.a(i2, IronSourceUtils.getMediationAdditionalData(false)));
    }

    public final void c() {
        if (this.ae.booleanValue()) {
            this.ae = Boolean.FALSE;
            C0227q.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(603, "init() had failed"));
            this.af = null;
            this.ag = null;
        }
        if (this.H) {
            this.H = false;
            C0227q.a().a(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
        }
        if (this.E) {
            this.E = false;
            C0227q.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        synchronized (this.aj) {
            for (p.c a2 : this.aj.values()) {
                String a3 = a2.a();
                this.Q.a(a3).onInterstitialAdLoadFailed(a3, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
            }
            this.aj.clear();
        }
        synchronized (this.al) {
            Iterator<String> it = this.al.iterator();
            while (it.hasNext()) {
                r.a().a(it.next(), ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            this.al.clear();
        }
        synchronized (this.ak) {
            for (p.b next : this.ak.values()) {
                ISDemandOnlyBannerLayout c2 = next.c();
                if (c2 != null) {
                    c2.getListener().a(next.a(), ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.BANNER_AD_UNIT));
                }
            }
            this.ak.clear();
        }
    }

    public final synchronized void c(Activity activity, String str) {
        a(activity, new p.c(str), this.Q.a(str));
    }

    public final synchronized void c(Activity activity, String str, String str2) {
        p.c cVar = new p.c(str);
        cVar.a(str2);
        cVar.a(true);
        a(activity, cVar, this.Q.a(str));
    }

    public final boolean c(String str) {
        try {
            this.c.log(IronSourceLogger.IronSourceTag.API, this.a + ":setDynamicUserId(dynamicUserId:" + str + ")", 1);
            com.ironsource.d.a aVar = new com.ironsource.d.a();
            if (!a(str, 1, 128)) {
                aVar.a(ErrorBuilder.buildInvalidKeyValueError(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, IronSourceConstants.SUPERSONIC_CONFIG_NAME, "dynamicUserId is invalid, should be between 1-128 chars in length."));
            }
            if (aVar.a()) {
                this.i = str;
                i.d().a(new com.ironsource.environment.c.a(52, IronSourceUtils.getJsonForUserId(true)));
                return true;
            }
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, aVar.b().toString(), 2);
            return false;
        } catch (Exception e2) {
            IronSourceLoggerManager ironSourceLoggerManager = this.c;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.logException(ironSourceTag, this.a + ":setDynamicUserId(dynamicUserId:" + str + ")", e2);
            return false;
        }
    }

    public final void d(String str) {
        try {
            this.c.log(IronSourceLogger.IronSourceTag.INTERNAL, this.a + ":setMediationType(mediationType:" + str + ")", 1);
            if (!a(str, 1, 64) || !p(str)) {
                this.c.log(IronSourceLogger.IronSourceTag.INTERNAL, " mediationType value is invalid - should be alphanumeric and 1-64 chars in length", 1);
                return;
            }
            this.k = str;
            com.ironsource.environment.c.e.a("mt", (Object) str);
        } catch (Exception e2) {
            IronSourceLoggerManager ironSourceLoggerManager = this.c;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.logException(ironSourceTag, this.a + ":setMediationType(mediationType:" + str + ")", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        if (r3.b() != false) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        if (r3.g() != false) goto L_0x0026;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053 A[Catch:{ all -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056 A[Catch:{ all -> 0x0077 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d() {
        /*
            r9 = this;
            java.lang.String r0 = "isRewardedVideoAvailable():"
            r1 = 1
            r2 = 0
            boolean r3 = r9.r     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x0013
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r9.c     // Catch:{ all -> 0x007c }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "Rewarded Video was initialized in demand only mode. Use isISDemandOnlyRewardedVideoAvailable instead"
            r6 = 3
            r3.log(r4, r5, r6)     // Catch:{ all -> 0x007c }
            return r2
        L_0x0013:
            boolean r3 = r9.D     // Catch:{ all -> 0x007c }
            if (r3 != 0) goto L_0x002a
            boolean r3 = r9.F     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x001c
            goto L_0x002a
        L_0x001c:
            com.ironsource.mediationsdk.t r3 = r9.x     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x0028
            boolean r3 = r3.b()     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x0028
        L_0x0026:
            r3 = 1
            goto L_0x0035
        L_0x0028:
            r3 = 0
            goto L_0x0035
        L_0x002a:
            com.ironsource.mediationsdk.adunit.c.h r3 = r9.B     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x0028
            boolean r3 = r3.g()     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x0028
            goto L_0x0026
        L_0x0035:
            org.json.JSONObject r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r2)     // Catch:{ all -> 0x0077 }
            java.lang.Object[][] r5 = new java.lang.Object[r1][]     // Catch:{ all -> 0x0077 }
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = "programmatic"
            r6[r2] = r7     // Catch:{ all -> 0x0077 }
            int r7 = r9.J     // Catch:{ all -> 0x0077 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0077 }
            r6[r1] = r7     // Catch:{ all -> 0x0077 }
            r5[r2] = r6     // Catch:{ all -> 0x0077 }
            a((org.json.JSONObject) r4, (java.lang.Object[][]) r5)     // Catch:{ all -> 0x0077 }
            com.ironsource.environment.c.a r5 = new com.ironsource.environment.c.a     // Catch:{ all -> 0x0077 }
            if (r3 == 0) goto L_0x0056
            r6 = 1101(0x44d, float:1.543E-42)
            goto L_0x0058
        L_0x0056:
            r6 = 1102(0x44e, float:1.544E-42)
        L_0x0058:
            r5.<init>(r6, r4)     // Catch:{ all -> 0x0077 }
            com.ironsource.mediationsdk.events.i r4 = com.ironsource.mediationsdk.events.i.d()     // Catch:{ all -> 0x0077 }
            r4.a((com.ironsource.environment.c.a) r5)     // Catch:{ all -> 0x0077 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r9.c     // Catch:{ all -> 0x0077 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r5 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r6.<init>(r0)     // Catch:{ all -> 0x0077 }
            r6.append(r3)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0077 }
            r4.log(r5, r6, r1)     // Catch:{ all -> 0x0077 }
            r2 = r3
            goto L_0x009a
        L_0x0077:
            r4 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x007e
        L_0x007c:
            r3 = move-exception
            r4 = 0
        L_0x007e:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r9.c
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r6 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r0)
            r7.append(r4)
            java.lang.String r0 = r7.toString()
            r5.log(r6, r0, r1)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r9.c
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r4 = "isRewardedVideoAvailable()"
            r0.logException(r1, r4, r3)
        L_0x009a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.d():boolean");
    }

    public final synchronized void e(String str) {
        IronSourceLoggerManager ironSourceLoggerManager = this.c;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "showISDemandOnlyRewardedVideo() instanceId=" + str, 1);
        try {
            if (!this.r) {
                this.c.log(IronSourceLogger.IronSourceTag.API, "Rewarded video was initialized in mediation mode. Use showRewardedVideo instead", 3);
                r.a().b(str, new IronSourceError(508, "Rewarded video was initialized in mediation mode. Use showRewardedVideo instead"));
                return;
            }
            com.ironsource.mediationsdk.demandOnly.h hVar = this.am;
            if (hVar == null) {
                this.c.log(IronSourceLogger.IronSourceTag.API, "Rewarded video was not initiated", 3);
                r.a().b(str, new IronSourceError(508, "Rewarded video was not initiated"));
                return;
            } else if (!hVar.a.containsKey(str)) {
                com.ironsource.mediationsdk.demandOnly.h.a(1500, str);
                r.a().b(str, ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                com.ironsource.mediationsdk.demandOnly.i iVar = hVar.a.get(str);
                hVar.a((int) IronSourceConstants.RV_INSTANCE_SHOW, iVar);
                iVar.a();
                return;
            }
        } catch (Exception e2) {
            this.c.logException(IronSourceLogger.IronSourceTag.API, "showISDemandOnlyRewardedVideo", e2);
            r.a().b(str, new IronSourceError(510, e2.getMessage()));
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return z() && A();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r3 = r9.y;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r3 = r9.A;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f() {
        /*
            r9 = this;
            java.lang.String r0 = "isInterstitialReady():"
            r1 = 1
            r2 = 0
            boolean r3 = r9.s     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x0013
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r9.c     // Catch:{ all -> 0x0061 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "Interstitial was initialized in demand only mode. Use isISDemandOnlyInterstitialReady instead"
            r6 = 3
            r3.log(r4, r5, r6)     // Catch:{ all -> 0x0061 }
            return r2
        L_0x0013:
            boolean r3 = r9.G     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x0025
            com.ironsource.mediationsdk.adunit.c.f r3 = r9.A     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x0023
            boolean r3 = r3.g()     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x0023
        L_0x0021:
            r3 = 1
            goto L_0x0030
        L_0x0023:
            r3 = 0
            goto L_0x0030
        L_0x0025:
            com.ironsource.mediationsdk.L r3 = r9.y     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x0023
            boolean r3 = r3.e()     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x0023
            goto L_0x0021
        L_0x0030:
            org.json.JSONObject r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r2, r1, r1)     // Catch:{ all -> 0x005c }
            com.ironsource.environment.c.a r5 = new com.ironsource.environment.c.a     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x003b
            r6 = 2101(0x835, float:2.944E-42)
            goto L_0x003d
        L_0x003b:
            r6 = 2102(0x836, float:2.946E-42)
        L_0x003d:
            r5.<init>(r6, r4)     // Catch:{ all -> 0x005c }
            com.ironsource.mediationsdk.events.e r4 = com.ironsource.mediationsdk.events.e.d()     // Catch:{ all -> 0x005c }
            r4.a((com.ironsource.environment.c.a) r5)     // Catch:{ all -> 0x005c }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r9.c     // Catch:{ all -> 0x005c }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r5 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x005c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x005c }
            r6.<init>(r0)     // Catch:{ all -> 0x005c }
            r6.append(r3)     // Catch:{ all -> 0x005c }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x005c }
            r4.log(r5, r6, r1)     // Catch:{ all -> 0x005c }
            r2 = r3
            goto L_0x007f
        L_0x005c:
            r4 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x0063
        L_0x0061:
            r3 = move-exception
            r4 = 0
        L_0x0063:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r9.c
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r6 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r0)
            r7.append(r4)
            java.lang.String r0 = r7.toString()
            r5.log(r6, r0, r1)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r9.c
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r4 = "isInterstitialReady()"
            r0.logException(r1, r4, r3)
        L_0x007f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.f():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean f(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.ironsource.mediationsdk.demandOnly.h r0 = r4.am     // Catch:{ all -> 0x0038 }
            r1 = 0
            if (r0 == 0) goto L_0x0036
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.i> r2 = r0.a     // Catch:{ all -> 0x0038 }
            boolean r2 = r2.containsKey(r5)     // Catch:{ all -> 0x0038 }
            r3 = 1
            if (r2 != 0) goto L_0x0016
            r0 = 1500(0x5dc, float:2.102E-42)
            com.ironsource.mediationsdk.demandOnly.h.a((int) r0, (java.lang.String) r5)     // Catch:{ all -> 0x0038 }
        L_0x0014:
            r5 = 0
            goto L_0x0032
        L_0x0016:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.i> r0 = r0.a     // Catch:{ all -> 0x0038 }
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x0038 }
            com.ironsource.mediationsdk.demandOnly.i r5 = (com.ironsource.mediationsdk.demandOnly.i) r5     // Catch:{ all -> 0x0038 }
            boolean r0 = r5.c()     // Catch:{ all -> 0x0038 }
            r2 = 0
            if (r0 == 0) goto L_0x002c
            r0 = 1210(0x4ba, float:1.696E-42)
            com.ironsource.mediationsdk.demandOnly.h.a((int) r0, (com.ironsource.mediationsdk.demandOnly.i) r5, (java.lang.Object[][]) r2)     // Catch:{ all -> 0x0038 }
            r5 = 1
            goto L_0x0032
        L_0x002c:
            r0 = 1211(0x4bb, float:1.697E-42)
            com.ironsource.mediationsdk.demandOnly.h.a((int) r0, (com.ironsource.mediationsdk.demandOnly.i) r5, (java.lang.Object[][]) r2)     // Catch:{ all -> 0x0038 }
            goto L_0x0014
        L_0x0032:
            if (r5 == 0) goto L_0x0036
            monitor-exit(r4)
            return r3
        L_0x0036:
            monitor-exit(r4)
            return r1
        L_0x0038:
            r5 = move-exception
            monitor-exit(r4)
            goto L_0x003c
        L_0x003b:
            throw r5
        L_0x003c:
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.f(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return C() && D();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean g(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.ironsource.mediationsdk.demandOnly.f r0 = r3.K     // Catch:{ all -> 0x0024 }
            r1 = 0
            if (r0 == 0) goto L_0x0022
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.g> r2 = r0.b     // Catch:{ all -> 0x0024 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x0024 }
            com.ironsource.mediationsdk.demandOnly.g r2 = (com.ironsource.mediationsdk.demandOnly.g) r2     // Catch:{ all -> 0x0024 }
            if (r2 != 0) goto L_0x0019
            com.ironsource.mediationsdk.demandOnly.e r0 = r0.a     // Catch:{ all -> 0x0024 }
            r2 = 2500(0x9c4, float:3.503E-42)
            r0.a(r2, r4)     // Catch:{ all -> 0x0024 }
            r4 = 0
            goto L_0x001d
        L_0x0019:
            boolean r4 = r2.d()     // Catch:{ all -> 0x0024 }
        L_0x001d:
            if (r4 == 0) goto L_0x0022
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0022:
            monitor-exit(r3)
            return r1
        L_0x0024:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.g(java.lang.String):boolean");
    }

    public final void h(String str) {
        String str2 = "showOfferwall(" + str + ")";
        this.c.log(IronSourceLogger.IronSourceTag.API, str2, 1);
        try {
            if (!h()) {
                this.d.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
                return;
            }
            l a2 = this.f.c.c().a(str);
            if (a2 == null) {
                this.c.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
                a2 = this.f.c.c().a();
                if (a2 == null) {
                    this.c.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                    return;
                }
            }
            this.b.a(a2.getPlacementName());
        } catch (Exception e2) {
            this.c.logException(IronSourceLogger.IronSourceTag.API, str2, e2);
            this.d.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        k kVar = this.f;
        return (kVar == null || kVar.c == null || this.f.c.c() == null) ? false : true;
    }

    public final InterstitialPlacement i(String str) {
        try {
            InterstitialPlacement o2 = o(str);
            if (o2 == null) {
                try {
                    this.c.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    o2 = B();
                } catch (Exception unused) {
                    return o2;
                }
            }
            IronSourceLoggerManager ironSourceLoggerManager = this.c;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "getPlacementInfo(placement: " + str + "):" + o2, 1);
            return o2;
        } catch (Exception unused2) {
            return null;
        }
    }

    public final boolean i() {
        try {
            H h2 = this.b;
            if (h2 != null) {
                return h2.a();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final Placement j(String str) {
        try {
            Placement n2 = n(str);
            if (n2 == null) {
                try {
                    this.c.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    n2 = y();
                } catch (Exception unused) {
                    return n2;
                }
            }
            IronSourceLoggerManager ironSourceLoggerManager = this.c;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "getPlacementInfo(placement: " + str + "):" + n2, 1);
            return n2;
        } catch (Exception unused2) {
            return null;
        }
    }

    public boolean j() {
        k kVar = this.f;
        return (kVar == null || kVar.c == null || this.f.c.e() == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final boolean k() {
        return this.r || this.s || this.ac;
    }

    /* access modifiers changed from: package-private */
    public final boolean k(String str) {
        boolean z2 = false;
        if (this.s) {
            return false;
        }
        if (q(str) != j.a.d) {
            z2 = true;
        }
        if (z2) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.s, true, 1);
            try {
                mediationAdditionalData.put("placement", str);
                mediationAdditionalData.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
            } catch (Exception unused) {
            }
            com.ironsource.mediationsdk.events.e.d().a(new com.ironsource.environment.c.a(2103, mediationAdditionalData));
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final boolean l(String str) {
        if (!E()) {
            return false;
        }
        com.ironsource.mediationsdk.model.e eVar = null;
        try {
            eVar = this.f.c.d().a(str);
            if (eVar == null && (eVar = this.f.c.d().a()) == null) {
                this.c.log(IronSourceLogger.IronSourceTag.API, "Banner default placement was not found", 3);
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (eVar == null) {
            return false;
        }
        return j.b(ContextProvider.getInstance().getApplicationContext(), eVar.getPlacementName());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m(java.lang.String r5) {
        /*
            r4 = this;
            com.ironsource.mediationsdk.utils.k r0 = r4.f
            if (r0 == 0) goto L_0x0043
            com.ironsource.mediationsdk.model.f r0 = r0.c
            if (r0 == 0) goto L_0x0043
            com.ironsource.mediationsdk.utils.k r0 = r4.f
            com.ironsource.mediationsdk.model.f r0 = r0.c
            com.ironsource.mediationsdk.model.q r0 = r0.a()
            if (r0 != 0) goto L_0x0013
            goto L_0x0043
        L_0x0013:
            com.ironsource.mediationsdk.model.Placement r5 = r4.n(r5)     // Catch:{ Exception -> 0x002c }
            if (r5 != 0) goto L_0x0031
            com.ironsource.mediationsdk.model.Placement r5 = r4.y()     // Catch:{ Exception -> 0x002a }
            if (r5 != 0) goto L_0x0031
            java.lang.String r0 = "Default placement was not found"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r4.c     // Catch:{ Exception -> 0x002a }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ Exception -> 0x002a }
            r3 = 3
            r1.log(r2, r0, r3)     // Catch:{ Exception -> 0x002a }
            goto L_0x0031
        L_0x002a:
            r0 = move-exception
            goto L_0x002e
        L_0x002c:
            r0 = move-exception
            r5 = 0
        L_0x002e:
            r0.printStackTrace()
        L_0x0031:
            if (r5 != 0) goto L_0x0036
            int r5 = com.ironsource.mediationsdk.utils.j.a.d
            return r5
        L_0x0036:
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r0 = r0.getApplicationContext()
            int r5 = com.ironsource.mediationsdk.utils.j.b((android.content.Context) r0, (com.ironsource.mediationsdk.model.Placement) r5)
            return r5
        L_0x0043:
            int r5 = com.ironsource.mediationsdk.utils.j.a.d
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.z.m(java.lang.String):int");
    }
}
