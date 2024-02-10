package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.environment.StringUtils;
import com.ironsource.environment.c.a;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface;
import com.ironsource.mediationsdk.adunit.adapter.BaseAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.events.e;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.c  reason: case insensitive filesystem */
public final class C0213c {
    private static final C0213c e = new C0213c();
    private static final Object f = new Object();
    public final ConcurrentHashMap<String, AdapterBaseWrapper> a = new ConcurrentHashMap<>();
    String b;
    String c;
    public final ConcurrentHashMap<String, List<String>> d = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AbstractAdapter> g = new ConcurrentHashMap<>();
    private Boolean h;
    private Boolean i;
    private final ConcurrentHashMap<IronSource.AD_UNIT, JSONObject> j = new ConcurrentHashMap<>();
    private final AtomicBoolean k = new AtomicBoolean(false);

    /* renamed from: com.ironsource.mediationsdk.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.ironsource.mediationsdk.IronSource$AD_UNIT[] r0 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.NATIVE_AD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0213c.AnonymousClass1.<clinit>():void");
        }
    }

    private C0213c() {
    }

    private AbstractAdapter a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.ironsource.adapters." + StringUtils.toLowerCase(str2) + "." + str2 + "Adapter");
            return (AbstractAdapter) cls.getMethod(IronSourceConstants.START_ADAPTER, new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e2) {
            String str3 = "Error while loading adapter - exception = " + e2.getLocalizedMessage();
            a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str3);
            a(str3);
            return null;
        }
    }

    private AdapterBaseInterface a(String str, String str2, NetworkSettings networkSettings) {
        if (!networkSettings.isCustomNetwork() || !TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            String str3 = (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkPackage() : "com.ironsource.adapters") + "." + str2;
            try {
                BaseAdapter baseAdapter = (BaseAdapter) Class.forName(str3).newInstance();
                IronLog.INTERNAL.info(str3 + " was allocated (adapter version: " + baseAdapter.getAdapterVersion() + ", sdk version: " + baseAdapter.getNetworkSDKVersion() + ")");
                Boolean bool = this.i;
                if (bool != null && (baseAdapter instanceof AdapterDebugInterface)) {
                    try {
                        baseAdapter.setAdapterDebug(bool.booleanValue());
                    } catch (Exception e2) {
                        String str4 = "error while setting adapterDebug of " + baseAdapter.getClass().getSimpleName() + ": " + e2.getLocalizedMessage();
                        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str4);
                        b(str4);
                        e2.printStackTrace();
                    }
                }
                this.a.put(str, new AdapterBaseWrapper(baseAdapter, networkSettings));
                return baseAdapter;
            } catch (Exception unused) {
                if (networkSettings.isCustomNetwork()) {
                    String str5 = "failed to load " + str3;
                    IronLog.INTERNAL.error(str5);
                    a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str5);
                }
                return null;
            }
        } else {
            IronLog.INTERNAL.error("missing package definition for " + str);
            return null;
        }
    }

    public static C0213c a() {
        return e;
    }

    private static void a(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
            }
            e.d().a(new a(i2, jSONObject));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(AbstractAdapter abstractAdapter) {
        try {
            Boolean bool = this.h;
            if (bool != null) {
                abstractAdapter.setConsent(bool.booleanValue());
            }
        } catch (Throwable th) {
            String str = "error while setting consent of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
            a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
            b(str);
            th.printStackTrace();
        }
    }

    private void a(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_APS_INTERNAL_ERROR, "APSData is empty");
            a("APSData is empty");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            if (!this.g.isEmpty()) {
                for (AbstractAdapter next : this.g.values()) {
                    if (StringUtils.toLowerCase(next.getProviderName()).equals("aps") && (next instanceof SetAPSInterface)) {
                        ((SetAPSInterface) next).setAPSData(ad_unit, jSONObject2);
                        return;
                    }
                }
            }
            for (AdapterBaseWrapper next2 : this.a.values()) {
                AdapterBaseInterface adapterBaseInterface = next2.getAdapterBaseInterface();
                if (!next2.getSettings().isCustomNetwork() && (adapterBaseInterface instanceof AdapterAPSDataInterface)) {
                    ((AdapterAPSDataInterface) adapterBaseInterface).setAPSData(ad_unit, jSONObject2);
                    return;
                }
            }
            synchronized (f) {
                this.j.put(ad_unit, jSONObject2);
            }
        } catch (Exception e2) {
            String str = "error while setting APSData: " + e2.getLocalizedMessage();
            a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_APS_INTERNAL_ERROR, str);
            a(str);
            e2.printStackTrace();
        }
    }

    private static void a(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "AdapterRepository: " + str, 3);
    }

    private static String b(NetworkSettings networkSettings) {
        return networkSettings.isMultipleInstances() ? networkSettings.getProviderDefaultInstance() : networkSettings.getProviderName();
    }

    private void b(AbstractAdapter abstractAdapter) {
        Boolean bool = this.i;
        if (bool != null) {
            try {
                abstractAdapter.setAdapterDebug(bool);
            } catch (Throwable th) {
                String str = "error while setting adapterDebug of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
                a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                b(str);
                th.printStackTrace();
            }
        }
    }

    private static void b(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "AdapterRepository: " + str, 0);
    }

    private BaseAdAdapter<?, ?> c(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        if (!networkSettings.isCustomNetwork() || !TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            String str = (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkPackage() : "com.ironsource.adapters") + "." + (networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkAdapterName(ad_unit) : networkSettings.getProviderTypeForReflection());
            try {
                return (BaseAdAdapter) Class.forName(str).getConstructor(new Class[]{NetworkSettings.class}).newInstance(new Object[]{networkSettings});
            } catch (Exception unused) {
                if (networkSettings.isCustomNetwork()) {
                    String str2 = "failed to load " + str;
                    IronLog.INTERNAL.error(str2);
                    a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                }
                return null;
            }
        } else {
            IronLog.INTERNAL.error("missing package definition for " + networkSettings.getProviderTypeForReflection());
            return null;
        }
    }

    private void c(AbstractAdapter abstractAdapter) {
        for (String next : this.d.keySet()) {
            try {
                List list = this.d.get(next);
                IronSourceUtils.sendAutomationLog(abstractAdapter.getProviderName() + "Adapter setMetaData key = " + next + ", values = " + list);
                if (list != null) {
                    abstractAdapter.setMetaData(next, list);
                }
            } catch (Throwable th) {
                String str = "error while setting metadata of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
                a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                b(str);
                th.printStackTrace();
            }
        }
    }

    private void d(AbstractAdapter abstractAdapter) {
        if (StringUtils.toLowerCase(abstractAdapter.getProviderName()).equals("aps") && this.j.size() != 0) {
            for (IronSource.AD_UNIT next : this.j.keySet()) {
                try {
                    JSONObject jSONObject = this.j.get(next);
                    if (jSONObject != null && jSONObject.length() > 0 && (abstractAdapter instanceof SetAPSInterface)) {
                        ((SetAPSInterface) abstractAdapter).setAPSData(next, jSONObject);
                    }
                } catch (Exception e2) {
                    String str = "error while setting aps data: " + e2.getLocalizedMessage();
                    a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_APS_INTERNAL_ERROR, str);
                    b(str);
                    e2.printStackTrace();
                }
            }
            this.j.clear();
        }
    }

    public final AbstractAdapter a(NetworkSettings networkSettings) {
        String b2 = b(networkSettings);
        return networkSettings.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME) ? this.g.get(b2) : a(b2, networkSettings.getProviderTypeForReflection());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010d, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.ironsource.mediationsdk.AbstractAdapter a(com.ironsource.mediationsdk.model.NetworkSettings r7, org.json.JSONObject r8, boolean r9, boolean r10) {
        /*
            r6 = this;
            java.lang.String r0 = b((com.ironsource.mediationsdk.model.NetworkSettings) r7)
            if (r9 == 0) goto L_0x0009
            java.lang.String r7 = "IronSource"
            goto L_0x000d
        L_0x0009:
            java.lang.String r7 = r7.getProviderTypeForReflection()
        L_0x000d:
            java.lang.Object r9 = f
            monitor-enter(r9)
            if (r10 != 0) goto L_0x0024
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.AbstractAdapter> r1 = r6.g     // Catch:{ all -> 0x010e }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x010e }
            if (r1 == 0) goto L_0x0024
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.AbstractAdapter> r7 = r6.g     // Catch:{ all -> 0x010e }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x010e }
            com.ironsource.mediationsdk.AbstractAdapter r7 = (com.ironsource.mediationsdk.AbstractAdapter) r7     // Catch:{ all -> 0x010e }
            monitor-exit(r9)     // Catch:{ all -> 0x010e }
            return r7
        L_0x0024:
            com.ironsource.mediationsdk.AbstractAdapter r1 = r6.a((java.lang.String) r0, (java.lang.String) r7)     // Catch:{ all -> 0x010e }
            if (r1 != 0) goto L_0x0041
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r7.<init>()     // Catch:{ all -> 0x010e }
            r7.append(r0)     // Catch:{ all -> 0x010e }
            java.lang.String r8 = " adapter was not loaded"
            r7.append(r8)     // Catch:{ all -> 0x010e }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x010e }
            a((java.lang.String) r7)     // Catch:{ all -> 0x010e }
            monitor-exit(r9)     // Catch:{ all -> 0x010e }
            r7 = 0
            return r7
        L_0x0041:
            r2 = 88001(0x157c1, float:1.23316E-40)
            java.lang.String r3 = r1.getCoreSDKVersion()     // Catch:{ all -> 0x0049 }
            goto L_0x0072
        L_0x0049:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            java.lang.String r5 = "error while retrieving coreSDKVersion "
            r4.<init>(r5)     // Catch:{ all -> 0x010e }
            java.lang.String r5 = r1.getProviderName()     // Catch:{ all -> 0x010e }
            r4.append(r5)     // Catch:{ all -> 0x010e }
            java.lang.String r5 = ": "
            r4.append(r5)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r3.getLocalizedMessage()     // Catch:{ all -> 0x010e }
            r4.append(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x010e }
            a((int) r2, (java.lang.String) r3)     // Catch:{ all -> 0x010e }
            com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x010e }
            r4.error(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = "Unknown"
        L_0x0072:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r4.<init>()     // Catch:{ all -> 0x010e }
            r4.append(r0)     // Catch:{ all -> 0x010e }
            java.lang.String r5 = " was allocated (adapter version: "
            r4.append(r5)     // Catch:{ all -> 0x010e }
            java.lang.String r5 = r1.getVersion()     // Catch:{ all -> 0x010e }
            r4.append(r5)     // Catch:{ all -> 0x010e }
            java.lang.String r5 = ", sdk version: "
            r4.append(r5)     // Catch:{ all -> 0x010e }
            r4.append(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = ")"
            r4.append(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x010e }
            b((java.lang.String) r3)     // Catch:{ all -> 0x010e }
            r6.c(r1)     // Catch:{ all -> 0x010e }
            r6.d(r1)     // Catch:{ all -> 0x010e }
            r6.a((com.ironsource.mediationsdk.AbstractAdapter) r1)     // Catch:{ all -> 0x010e }
            r6.b((com.ironsource.mediationsdk.AbstractAdapter) r1)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = "SupersonicAds"
            boolean r3 = r7.equalsIgnoreCase(r3)     // Catch:{ all -> 0x010e }
            if (r3 != 0) goto L_0x00b6
            java.lang.String r3 = "IronSource"
            boolean r3 = r7.equalsIgnoreCase(r3)     // Catch:{ all -> 0x010e }
            if (r3 == 0) goto L_0x0105
        L_0x00b6:
            java.util.concurrent.atomic.AtomicBoolean r3 = r6.k     // Catch:{ all -> 0x010e }
            r4 = 0
            r5 = 1
            boolean r3 = r3.compareAndSet(r4, r5)     // Catch:{ all -> 0x010e }
            if (r3 == 0) goto L_0x0105
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            java.lang.String r4 = "SDK5 earlyInit  <"
            r3.<init>(r4)     // Catch:{ all -> 0x010e }
            r3.append(r7)     // Catch:{ all -> 0x010e }
            java.lang.String r7 = ">"
            r3.append(r7)     // Catch:{ all -> 0x010e }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x010e }
            b((java.lang.String) r7)     // Catch:{ all -> 0x010e }
            java.lang.String r7 = r6.b     // Catch:{ Exception -> 0x00de }
            java.lang.String r3 = r6.c     // Catch:{ Exception -> 0x00de }
            r1.earlyInit(r7, r3, r8)     // Catch:{ Exception -> 0x00de }
            goto L_0x0105
        L_0x00de:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            java.lang.String r3 = "error while calling early init for "
            r8.<init>(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r1.getProviderName()     // Catch:{ all -> 0x010e }
            r8.append(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r3 = ": "
            r8.append(r3)     // Catch:{ all -> 0x010e }
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x010e }
            r8.append(r7)     // Catch:{ all -> 0x010e }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x010e }
            a((int) r2, (java.lang.String) r7)     // Catch:{ all -> 0x010e }
            com.ironsource.mediationsdk.logger.IronLog r8 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x010e }
            r8.error(r7)     // Catch:{ all -> 0x010e }
        L_0x0105:
            if (r10 != 0) goto L_0x010c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.AbstractAdapter> r7 = r6.g     // Catch:{ all -> 0x010e }
            r7.put(r0, r1)     // Catch:{ all -> 0x010e }
        L_0x010c:
            monitor-exit(r9)     // Catch:{ all -> 0x010e }
            return r1
        L_0x010e:
            r7 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x010e }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0213c.a(com.ironsource.mediationsdk.model.NetworkSettings, org.json.JSONObject, boolean, boolean):com.ironsource.mediationsdk.AbstractAdapter");
    }

    public final AdapterBaseInterface a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        ConcurrentHashMap<String, AdapterBaseWrapper> concurrentHashMap;
        AdapterBaseWrapper adapterBaseWrapper;
        String b2 = b(networkSettings);
        if (this.a.containsKey(b2)) {
            return this.a.get(b2).getAdapterBaseInterface();
        }
        AdapterBaseInterface a2 = a(b2, networkSettings.isCustomNetwork() ? networkSettings.getCustomNetworkAdapterName((IronSource.AD_UNIT) null) : networkSettings.getProviderTypeForReflection(), networkSettings);
        if (a2 != null || networkSettings.isCustomNetwork()) {
            concurrentHashMap = this.a;
            adapterBaseWrapper = new AdapterBaseWrapper(a2, networkSettings);
        } else {
            int i2 = AnonymousClass1.a[ad_unit.ordinal()];
            AbstractAdapter a3 = a(networkSettings, i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : networkSettings.getNativeAdSettings() : networkSettings.getBannerSettings() : networkSettings.getInterstitialSettings() : networkSettings.getRewardedVideoSettings(), false, true);
            if (a3 != null) {
                a2 = new G(a3);
                concurrentHashMap = this.a;
                adapterBaseWrapper = new AdapterBaseWrapper(a2, networkSettings);
            } else {
                String str = "error creating network adapter " + networkSettings.getProviderName();
                a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                IronLog.INTERNAL.error(str);
                return null;
            }
        }
        concurrentHashMap.put(b2, adapterBaseWrapper);
        return a2;
    }

    public final void a(String str, List<String> list) {
        synchronized (f) {
            this.d.put(str, list);
            if (!this.g.isEmpty()) {
                IronSourceUtils.sendAutomationLog("setMetaData key = " + str + ", values = " + list);
                for (AbstractAdapter next : this.g.values()) {
                    try {
                        next.setMetaData(str, list);
                    } catch (Throwable th) {
                        String str2 = "error while setting metadata of " + next.getProviderName() + ": " + th.getLocalizedMessage();
                        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                        b(str2);
                        th.printStackTrace();
                    }
                }
            }
            for (AdapterBaseWrapper next2 : this.a.values()) {
                AdapterBaseInterface adapterBaseInterface = next2.getAdapterBaseInterface();
                if (!next2.getSettings().isCustomNetwork() && (adapterBaseInterface instanceof AdapterMetaDataInterface)) {
                    try {
                        ((AdapterMetaDataInterface) adapterBaseInterface).setMetaData(str, list);
                    } catch (Exception e2) {
                        String str3 = "error while setting metadata of " + adapterBaseInterface.getClass().getSimpleName() + ": " + e2.getLocalizedMessage();
                        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str3);
                        b(str3);
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        String str2;
        IronSource.AD_UNIT ad_unit;
        if (TextUtils.isEmpty(str)) {
            str2 = "Calling setNetworkData on an empty network";
        } else if (jSONObject == null || jSONObject.length() == 0) {
            str2 = "Calling setNetworkData with empty networkData";
        } else if (StringUtils.toLowerCase(str).equals("aps")) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (next.equalsIgnoreCase(IronSource.AD_UNIT.BANNER.toString())) {
                    ad_unit = IronSource.AD_UNIT.BANNER;
                } else if (next.equalsIgnoreCase(IronSource.AD_UNIT.INTERSTITIAL.toString())) {
                    ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
                } else if (next.equalsIgnoreCase(IronSource.AD_UNIT.REWARDED_VIDEO.toString())) {
                    ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
                }
                a(ad_unit, optJSONObject);
            }
            return;
        } else {
            str2 = "Calling setNetworkData on an unsupported network: " + str;
        }
        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_APS_INTERNAL_ERROR, str2);
        a(str2);
    }

    public final void a(boolean z) {
        synchronized (f) {
            this.h = Boolean.valueOf(z);
            for (AbstractAdapter a2 : this.g.values()) {
                a(a2);
            }
            for (AdapterBaseWrapper next : this.a.values()) {
                AdapterBaseInterface adapterBaseInterface = next.getAdapterBaseInterface();
                if (!next.getSettings().isCustomNetwork() && (adapterBaseInterface instanceof AdapterConsentInterface)) {
                    try {
                        ((AdapterConsentInterface) adapterBaseInterface).setConsent(z);
                    } catch (Exception e2) {
                        String str = "error while setting consent of " + adapterBaseInterface.getClass().getSimpleName() + ": " + e2.getLocalizedMessage();
                        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                        b(str);
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final BaseAdAdapter<?, ?> b(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        BaseAdAdapter<?, ?> c2 = c(networkSettings, ad_unit);
        if (c2 != null || networkSettings.isCustomNetwork()) {
            return c2;
        }
        AbstractAdapter a2 = a(networkSettings);
        if (a2 != null) {
            return C0211a.a(a2, networkSettings, ad_unit);
        }
        String str = "error creating ad adapter " + networkSettings.getProviderName();
        a((int) IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
        IronLog.INTERNAL.error(str);
        return null;
    }

    public final void b(boolean z) {
        synchronized (f) {
            this.i = Boolean.valueOf(z);
            for (AbstractAdapter b2 : this.g.values()) {
                b(b2);
            }
        }
    }
}
