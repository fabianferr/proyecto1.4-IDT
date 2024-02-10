package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.debugger.a;
import com.applovin.impl.mediation.e;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.b.f;
import com.applovin.impl.sdk.e.c;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.f.i;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdService;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.network.d;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.p;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinTargetingData;
import com.applovin.sdk.AppLovinUserSegment;
import com.applovin.sdk.AppLovinUserService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class m {
    protected static Context a;
    private static a c;
    private q A;
    private c B;
    private x C;
    private s D;
    /* access modifiers changed from: private */
    public d E;
    private i F;
    private n G;
    private h H;
    private n I;
    private f J;
    private t K;
    private com.applovin.impl.sdk.a.c L;
    private PostbackServiceImpl M;
    private com.applovin.impl.sdk.network.f N;
    private e O;
    private com.applovin.impl.mediation.f P;
    private e Q;
    private MediationServiceImpl R;
    private h S;
    private a T;
    private v U;
    private com.applovin.impl.mediation.d V;
    private com.applovin.impl.mediation.debugger.ui.testmode.c W;
    /* access modifiers changed from: private */
    public List<MaxAdFormat> X;
    /* access modifiers changed from: private */
    public final Object Y = new Object();
    private final AtomicBoolean Z = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public boolean aa = false;
    private boolean ab = false;
    private boolean ac = false;
    private boolean ad = false;
    private int ae = 0;
    private AppLovinSdk.SdkInitializationListener af;
    private AppLovinSdk.SdkInitializationListener ag;
    /* access modifiers changed from: private */
    public AppLovinSdkConfiguration ah;
    protected com.applovin.impl.sdk.d.c b;
    private String d;
    private WeakReference<Activity> e;
    private long f;
    private AppLovinSdkSettings g;
    private AppLovinUserSegment h;
    private AppLovinTargetingData i;
    private String j;
    private AppLovinAdServiceImpl k;
    private AppLovinNativeAdService l;
    private EventServiceImpl m;
    private UserServiceImpl n;
    private VariableServiceImpl o;
    private AppLovinSdk p;
    /* access modifiers changed from: private */
    public u q;
    /* access modifiers changed from: private */
    public o r;
    private b s;
    private g t;
    private o u;
    private com.applovin.impl.sdk.d.e v;
    private l w;
    private p x;
    private c y;
    private r z;

    public static Context M() {
        return a;
    }

    public static a a(Context context) {
        if (c == null) {
            c = new a(context);
        }
        return c;
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (u.a()) {
            for (String i2 : JsonUtils.getList(jSONObject, "error_messages", Collections.emptyList())) {
                u.i("AppLovinSdk", i2);
            }
        }
    }

    private void ap() {
        this.E.a((d.a) new d.a() {
            public void a() {
                if (u.a()) {
                    m.this.q.c("AppLovinSdk", "Connected to internet - re-initializing SDK");
                }
                synchronized (m.this.Y) {
                    if (!m.this.aa) {
                        m.this.b();
                    }
                }
                m.this.E.b(this);
            }

            public void b() {
            }
        });
    }

    /* access modifiers changed from: private */
    public List<MaxAdFormat> b(JSONObject jSONObject) {
        List<String> asList = Arrays.asList(JsonUtils.getString(jSONObject, "eaf", "").split(","));
        ArrayList arrayList = new ArrayList(asList.size());
        for (String formatFromString : asList) {
            MaxAdFormat formatFromString2 = MaxAdFormat.formatFromString(formatFromString);
            if (formatFromString2 != null) {
                arrayList.add(formatFromString2);
            }
        }
        return arrayList;
    }

    public u A() {
        return this.q;
    }

    public e B() {
        return this.O;
    }

    public com.applovin.impl.mediation.f C() {
        return this.P;
    }

    public e D() {
        return this.Q;
    }

    public MediationServiceImpl E() {
        return this.R;
    }

    public v F() {
        return this.U;
    }

    public a G() {
        return this.T;
    }

    public h H() {
        return this.S;
    }

    public com.applovin.impl.mediation.d I() {
        return this.V;
    }

    public com.applovin.impl.mediation.debugger.ui.testmode.c J() {
        return this.W;
    }

    public com.applovin.impl.sdk.d.c K() {
        return this.b;
    }

    public Context L() {
        return a;
    }

    public Activity N() {
        WeakReference<Activity> weakReference = this.e;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public long O() {
        return this.f;
    }

    public boolean P() {
        return this.ac;
    }

    public boolean Q() {
        return this.ad;
    }

    public b R() {
        return this.s;
    }

    public o S() {
        return this.r;
    }

    public g T() {
        return this.t;
    }

    public com.applovin.impl.sdk.network.f U() {
        return this.N;
    }

    public o V() {
        return this.u;
    }

    public l W() {
        return this.w;
    }

    public PostbackServiceImpl X() {
        return this.M;
    }

    public AppLovinSdk Y() {
        return this.p;
    }

    public c Z() {
        return this.y;
    }

    public <T> T a(com.applovin.impl.sdk.d.b<T> bVar) {
        return this.b.a(bVar);
    }

    public <T> T a(com.applovin.impl.sdk.d.d<T> dVar) {
        return b(dVar, (Object) null);
    }

    public <T> T a(String str, T t2, Class<?> cls, SharedPreferences sharedPreferences) {
        return com.applovin.impl.sdk.d.e.a(str, t2, (Class) cls, sharedPreferences);
    }

    public void a() {
        synchronized (this.Y) {
            if (!this.aa && !this.ab) {
                b();
            }
        }
    }

    public void a(long j2) {
        this.w.a(j2);
    }

    public void a(SharedPreferences sharedPreferences) {
        this.v.a(sharedPreferences);
    }

    public void a(com.applovin.impl.mediation.a.f fVar) {
        if (!this.r.a()) {
            List<String> b2 = b(com.applovin.impl.sdk.d.a.a);
            if (b2.size() > 0 && this.Q.b().containsAll(b2)) {
                if (u.a()) {
                    this.q.b("AppLovinSdk", "All required adapters initialized");
                }
                this.r.d();
                j();
            }
        }
    }

    public <T> void a(com.applovin.impl.sdk.d.d<T> dVar, T t2) {
        this.v.a(dVar, t2);
    }

    public <T> void a(com.applovin.impl.sdk.d.d<T> dVar, T t2, SharedPreferences sharedPreferences) {
        this.v.a(dVar, t2, sharedPreferences);
    }

    public void a(final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (!d()) {
            this.af = sdkInitializationListener;
        } else if (sdkInitializationListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    sdkInitializationListener.onSdkInitialized(m.this.ah);
                }
            });
        }
    }

    public void a(AppLovinSdk appLovinSdk) {
        this.p = appLovinSdk;
    }

    public void a(String str) {
        if (u.a()) {
            u.f("AppLovinSdk", "Setting plugin version: " + str);
        }
        this.b.a((com.applovin.impl.sdk.d.b<?>) com.applovin.impl.sdk.d.b.dC, (Object) str);
    }

    public void a(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        com.applovin.impl.sdk.d.e eVar;
        String str2;
        com.applovin.impl.sdk.d.d<String> dVar;
        this.d = str;
        this.f = System.currentTimeMillis();
        this.g = appLovinSdkSettings;
        this.h = new g();
        this.i = new AppLovinTargetingDataImpl();
        this.ah = new SdkConfigurationImpl(this);
        a = context.getApplicationContext();
        if (context instanceof Activity) {
            this.e = new WeakReference<>((Activity) context);
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.v = new com.applovin.impl.sdk.d.e(this);
        this.b = new com.applovin.impl.sdk.d.c(this);
        this.q = new u(this);
        if (((Boolean) a(com.applovin.impl.sdk.d.b.bt)).booleanValue()) {
            this.z = new r(this);
        }
        this.A = new q(this);
        this.y = new c(this);
        this.m = new EventServiceImpl(this);
        this.n = new UserServiceImpl(this);
        this.o = new VariableServiceImpl(this);
        this.B = new c(this);
        this.r = new o(this);
        this.s = new b(this);
        this.t = new g(this);
        this.J = new f(this);
        this.u = new o(this);
        this.k = new AppLovinAdServiceImpl(this);
        this.l = new AppLovinNativeAdService(this);
        this.C = new x(this);
        this.D = new s(this);
        this.M = new PostbackServiceImpl(this);
        this.N = new com.applovin.impl.sdk.network.f(this);
        this.O = new e(this);
        this.P = new com.applovin.impl.mediation.f(this);
        this.Q = new e(this);
        this.R = new MediationServiceImpl(this);
        this.U = new v(this);
        this.T = new a(this);
        this.S = new h();
        this.V = new com.applovin.impl.mediation.d(this);
        this.w = new l(this);
        this.G = new n(this);
        this.H = new h(this);
        this.W = new com.applovin.impl.mediation.debugger.ui.testmode.c(this);
        this.I = new n(this);
        this.K = new t(this);
        this.L = new com.applovin.impl.sdk.a.c(this);
        this.F = new i(this);
        this.x = new p(this);
        this.Q.a(MaxAdapter.InitializationStatus.INITIALIZING);
        if (((Boolean) a(com.applovin.impl.sdk.d.b.da)).booleanValue()) {
            this.E = new d(context);
        }
        if (u.a() && TextUtils.isEmpty(str)) {
            u.i("AppLovinSdk", "Unable to find AppLovin SDK key. Please add  meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
            u.i("AppLovinSdk", "Called with an invalid SDK key from: " + Log.getStackTraceString(new Throwable("")));
        }
        if (str.length() != 86 && Utils.isPubInDebugMode(context, this) && u.a()) {
            u.i("AppLovinSdk", "Please double-check that you entered your SDK key correctly (" + str + ") : " + Log.getStackTraceString(new Throwable("")));
        }
        if (Utils.isProguardRulesOmitted() && u.a()) {
            u.i("AppLovinSdk", "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!Utils.hasAndroidCoreJsonLibrary(this) && u.a()) {
            u.i("AppLovinSdk", "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (Utils.isVerboseLoggingEnabled(context)) {
            appLovinSdkSettings.setVerboseLogging(true);
        }
        K().a((com.applovin.impl.sdk.d.b<?>) com.applovin.impl.sdk.d.b.Z, (Object) Boolean.valueOf(appLovinSdkSettings.isVerboseLoggingEnabled()));
        Class<com.applovin.impl.adview.d> cls = com.applovin.impl.adview.d.class;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (TextUtils.isEmpty((String) this.v.b(com.applovin.impl.sdk.d.d.a, null, defaultSharedPreferences))) {
            this.ac = true;
            eVar = this.v;
            dVar = com.applovin.impl.sdk.d.d.a;
            str2 = Boolean.toString(true);
        } else {
            eVar = this.v;
            dVar = com.applovin.impl.sdk.d.d.a;
            str2 = Boolean.toString(false);
        }
        eVar.a(dVar, str2, defaultSharedPreferences);
        if (((Boolean) this.v.b(com.applovin.impl.sdk.d.d.b, false)).booleanValue()) {
            if (u.a()) {
                this.q.b("AppLovinSdk", "Initializing SDK for non-maiden launch");
            }
            this.ad = true;
        } else {
            if (u.a()) {
                this.q.b("AppLovinSdk", "Initializing SDK for maiden launch");
            }
            this.v.a(com.applovin.impl.sdk.d.d.b, true);
        }
        String str3 = (String) this.v.b(com.applovin.impl.sdk.d.d.c, null);
        if (!StringUtils.isValidString(str3) || AppLovinSdk.VERSION_CODE > Utils.toVersionCode(str3)) {
            this.v.a(com.applovin.impl.sdk.d.d.c, AppLovinSdk.VERSION);
        }
        boolean a2 = com.applovin.impl.sdk.utils.h.a(L());
        if (!((Boolean) a(com.applovin.impl.sdk.d.b.db)).booleanValue() || a2) {
            b();
        }
        if (((Boolean) a(com.applovin.impl.sdk.d.b.da)).booleanValue() && !a2) {
            if (u.a()) {
                this.q.c("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
            }
            ap();
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    public <T> void a(String str, T t2, SharedPreferences.Editor editor) {
        this.v.a(str, t2, editor);
    }

    public void a(Map<String, List<?>> map) {
        this.T.a(map);
    }

    public void a(boolean z2) {
        synchronized (this.Y) {
            this.aa = false;
            this.ab = z2;
        }
        if (this.b != null && this.r != null) {
            List<String> b2 = b(com.applovin.impl.sdk.d.a.a);
            if (b2.isEmpty()) {
                this.r.d();
                j();
                return;
            }
            long longValue = ((Long) a(com.applovin.impl.sdk.d.a.b)).longValue();
            z zVar = new z(this, true, new Runnable() {
                public void run() {
                    if (!m.this.r.a()) {
                        if (u.a()) {
                            m.this.q.b("AppLovinSdk", "Timing out adapters init...");
                        }
                        m.this.r.d();
                        m.this.j();
                    }
                }
            });
            if (u.a()) {
                u uVar = this.q;
                uVar.b("AppLovinSdk", "Waiting for required adapters to init: " + b2 + " - timing out in " + longValue + "ms...");
            }
            this.r.a(zVar, o.a.MEDIATION_TIMEOUT, longValue, true);
        }
    }

    public boolean a(com.applovin.impl.sdk.d.b<String> bVar, MaxAdFormat maxAdFormat) {
        return c(bVar).contains(maxAdFormat);
    }

    public boolean a(MaxAdFormat maxAdFormat) {
        List<MaxAdFormat> list = this.X;
        return list != null && list.size() > 0 && !this.X.contains(maxAdFormat);
    }

    public r aa() {
        return this.z;
    }

    public q ab() {
        return this.A;
    }

    public c ac() {
        return this.B;
    }

    public x ad() {
        return this.C;
    }

    public s ae() {
        return this.D;
    }

    public a af() {
        return c;
    }

    public i ag() {
        return this.F;
    }

    public n ah() {
        return this.G;
    }

    public h ai() {
        return this.H;
    }

    public AppLovinBroadcastManager aj() {
        return AppLovinBroadcastManager.getInstance(a);
    }

    public n ak() {
        return this.I;
    }

    public f al() {
        return this.J;
    }

    public t am() {
        return this.K;
    }

    public com.applovin.impl.sdk.a.c an() {
        return this.L;
    }

    public Activity ao() {
        Activity a2 = a(a).a();
        return a2 != null ? a2 : N();
    }

    public <T> T b(com.applovin.impl.sdk.d.d<T> dVar, T t2) {
        return this.v.b(dVar, t2);
    }

    public <T> T b(com.applovin.impl.sdk.d.d<T> dVar, T t2, SharedPreferences sharedPreferences) {
        return this.v.b(dVar, t2, sharedPreferences);
    }

    public List<String> b(com.applovin.impl.sdk.d.b<String> bVar) {
        return this.b.b(bVar);
    }

    public void b() {
        synchronized (this.Y) {
            this.aa = true;
            S().c();
            int i2 = this.ae + 1;
            this.ae = i2;
            S().a((com.applovin.impl.sdk.f.a) new i(i2, this, new i.a() {
                public void a(JSONObject jSONObject) {
                    boolean z = jSONObject.length() > 0;
                    com.applovin.impl.sdk.utils.h.d(jSONObject, m.this);
                    com.applovin.impl.sdk.utils.h.c(jSONObject, m.this);
                    f.a(m.this);
                    com.applovin.impl.sdk.utils.h.e(jSONObject, m.this);
                    com.applovin.impl.sdk.utils.h.a(jSONObject, z, m.this);
                    com.applovin.impl.mediation.d.b.a(jSONObject, m.this);
                    com.applovin.impl.mediation.d.b.b(jSONObject, m.this);
                    m.this.G().a(JsonUtils.getBoolean(jSONObject, "smd", false).booleanValue(), JsonUtils.getInt(jSONObject, "smd_delay_sec", 2));
                    m mVar = m.this;
                    List unused = mVar.X = mVar.b(jSONObject);
                    com.applovin.impl.sdk.utils.h.f(jSONObject, m.this);
                    m.this.J().a(jSONObject);
                    m.this.a(jSONObject);
                    m.this.S().a((com.applovin.impl.sdk.f.a) new com.applovin.impl.sdk.f.n(m.this));
                }
            }), o.a.MAIN, (long) ((Integer) a(com.applovin.impl.sdk.d.b.dY)).intValue());
        }
    }

    public <T> void b(com.applovin.impl.sdk.d.d<T> dVar) {
        this.v.a(dVar);
    }

    public void b(String str) {
        if (u.a()) {
            u uVar = this.q;
            uVar.b("AppLovinSdk", "Setting user id: " + str);
        }
        if (StringUtils.isValidString(str) && str.length() > Utils.kilobytesToByes(8)) {
            u.i("AppLovinSdk", "Provided user id longer than supported (" + str.length() + " bytes, " + Utils.kilobytesToByes(8) + " maximum)");
        }
        this.x.a(str);
    }

    public List<MaxAdFormat> c(com.applovin.impl.sdk.d.b<String> bVar) {
        return this.b.c(bVar);
    }

    public void c(String str) {
        this.j = str;
        b(com.applovin.impl.sdk.d.d.A);
    }

    public boolean c() {
        boolean z2;
        synchronized (this.Y) {
            z2 = this.aa;
        }
        return z2;
    }

    public boolean d() {
        boolean z2;
        synchronized (this.Y) {
            z2 = this.ab;
        }
        return z2;
    }

    public boolean e() {
        return "HSrCHRtOan6wp2kwOIGJC1RDtuSrF2mWVbio2aBcMHX9KF3iTJ1lLSzCKP1ZSo5yNolPNw1kCTtWpxELFF4ah1".equalsIgnoreCase(z());
    }

    public boolean f() {
        return StringUtils.containsIgnoreCase(t(), AppLovinMediationProvider.MAX);
    }

    public boolean g() {
        return Utils.checkClassExistence("com.unity3d.player.UnityPlayerActivity");
    }

    public void h() {
        String str = (String) this.v.b(com.applovin.impl.sdk.d.d.c, null);
        if (StringUtils.isValidString(str) && AppLovinSdk.VERSION_CODE < Utils.toVersionCode(str) && u.a()) {
            u.i("AppLovinSdk", "Current version (" + AppLovinSdk.VERSION + ") is older than earlier installed version (" + str + "), which may cause compatibility issues.");
        }
    }

    public void i() {
        this.F.a();
    }

    public void j() {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener = this.af;
        if (sdkInitializationListener != null) {
            if (d()) {
                this.af = null;
                this.ag = null;
                this.Q.a(MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS);
            } else if (this.ag != sdkInitializationListener) {
                this.Q.a(MaxAdapter.InitializationStatus.INITIALIZED_FAILURE);
                if (((Boolean) a(com.applovin.impl.sdk.d.b.ah)).booleanValue()) {
                    this.af = null;
                } else {
                    this.ag = sdkInitializationListener;
                }
            } else {
                return;
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (u.a()) {
                        m.this.q.b("AppLovinSdk", "Calling back publisher's initialization completion handler...");
                    }
                    sdkInitializationListener.onSdkInitialized(m.this.ah);
                }
            }, Math.max(0, ((Long) a(com.applovin.impl.sdk.d.b.ai)).longValue()));
        }
    }

    public void k() {
        if (u.a()) {
            u.i("AppLovinSdk", "Resetting SDK state...");
        }
        long b2 = this.t.b(com.applovin.impl.sdk.e.f.i);
        this.b.c();
        this.b.a();
        this.t.a();
        this.t.b(com.applovin.impl.sdk.e.f.i, b2 + 1);
        if (this.Z.compareAndSet(true, false)) {
            b();
        } else {
            this.Z.set(true);
        }
    }

    public void l() {
        this.T.c();
    }

    public String m() {
        return this.x.a();
    }

    public String n() {
        return this.x.b();
    }

    public String o() {
        return this.x.c();
    }

    public AppLovinSdkSettings p() {
        return this.g;
    }

    public AppLovinUserSegment q() {
        return this.h;
    }

    public AppLovinTargetingDataImpl r() {
        return (AppLovinTargetingDataImpl) this.i;
    }

    public AppLovinSdkConfiguration s() {
        return this.ah;
    }

    public String t() {
        String str = (String) a(com.applovin.impl.sdk.d.d.A);
        return StringUtils.isValidString(str) ? str : this.j;
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.d + "', enabled=" + this.ab + ", isFirstSession=" + this.ac + AbstractJsonLexerKt.END_OBJ;
    }

    public AppLovinAdServiceImpl u() {
        return this.k;
    }

    public AppLovinNativeAdService v() {
        return this.l;
    }

    public AppLovinEventService w() {
        return this.m;
    }

    public AppLovinUserService x() {
        return this.n;
    }

    public VariableServiceImpl y() {
        return this.o;
    }

    public String z() {
        return this.d;
    }
}
