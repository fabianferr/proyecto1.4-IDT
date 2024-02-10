package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.events.i;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.l;
import com.ironsource.mediationsdk.sdk.d;
import com.ironsource.mediationsdk.sdk.f;
import com.ironsource.mediationsdk.services.IMediationServiceEditor;
import com.ironsource.mediationsdk.services.IMediationServiceProvider;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.k;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

final class H implements d {
    f a;
    d b;
    private final String c;
    private IronSourceLoggerManager d;
    private AtomicBoolean e;
    private AtomicBoolean f;
    private k g;
    private NetworkSettings h;
    private String i;
    private final a j;
    private final a.C0114a k;

    H() {
        this(MediationServices.getProvider(), MediationServices.getEditor());
    }

    private H(IMediationServiceProvider iMediationServiceProvider, IMediationServiceEditor iMediationServiceEditor) {
        this.c = getClass().getName();
        this.j = iMediationServiceProvider.getSessionDepthService();
        this.k = iMediationServiceEditor.getSessionDepthServiceEditor();
        this.e = new AtomicBoolean(true);
        this.f = new AtomicBoolean(false);
        this.d = IronSourceLoggerManager.getLogger();
    }

    private synchronized void a(IronSourceError ironSourceError) {
        AtomicBoolean atomicBoolean = this.f;
        if (atomicBoolean != null) {
            atomicBoolean.set(false);
        }
        AtomicBoolean atomicBoolean2 = this.e;
        if (atomicBoolean2 != null) {
            atomicBoolean2.set(true);
        }
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(false, ironSourceError);
        }
    }

    private AbstractAdapter b(String str) {
        try {
            z a2 = z.a();
            AbstractAdapter b2 = a2.b(str);
            if (b2 == null) {
                Class<?> cls = Class.forName("com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter");
                b2 = (AbstractAdapter) cls.getMethod(IronSourceConstants.START_ADAPTER, new Class[]{String.class}).invoke(cls, new Object[]{str});
                if (b2 == null) {
                    return null;
                }
            }
            a2.a(b2);
            return b2;
        } catch (Throwable th) {
            IronSourceLoggerManager ironSourceLoggerManager = this.d;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, str + " initialization failed - please verify that required dependencies are in you build path.", 2);
            IronSourceLoggerManager ironSourceLoggerManager2 = this.d;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager2.logException(ironSourceTag2, this.c + ":startOfferwallAdapter", th);
            return null;
        }
    }

    public final void a(String str) {
        f fVar;
        String str2 = "OWManager:showOfferwall(" + str + ")";
        try {
            if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                this.b.onOfferwallShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.OFFERWALL_AD_UNIT, "Activity must be provided when initializing SDK"));
            } else if (!IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getCurrentActiveActivity())) {
                this.b.onOfferwallShowFailed(ErrorBuilder.buildNoInternetConnectionShowFailError(IronSourceConstants.OFFERWALL_AD_UNIT));
            } else {
                this.i = str;
                l a2 = this.g.c.c().a(str);
                if (a2 == null) {
                    this.d.log(IronSourceLogger.IronSourceTag.INTERNAL, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
                    a2 = this.g.c.c().a();
                    if (a2 == null) {
                        this.d.log(IronSourceLogger.IronSourceTag.INTERNAL, "Default placement was not found, please make sure you are using the right placements.", 3);
                        return;
                    }
                }
                this.d.log(IronSourceLogger.IronSourceTag.INTERNAL, str2, 1);
                AtomicBoolean atomicBoolean = this.f;
                if (atomicBoolean != null && atomicBoolean.get() && (fVar = this.a) != null) {
                    fVar.showOfferwall(String.valueOf(a2.getPlacementId()), this.h.getRewardedVideoSettings());
                }
            }
        } catch (Exception e2) {
            this.d.logException(IronSourceLogger.IronSourceTag.INTERNAL, str2, e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0090 A[Catch:{ Exception -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009d A[SYNTHETIC, Splitter:B:30:0x009d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r7.d     // Catch:{ all -> 0x0109 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.NATIVE     // Catch:{ all -> 0x0109 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
            r2.<init>()     // Catch:{ all -> 0x0109 }
            java.lang.String r3 = r7.c     // Catch:{ all -> 0x0109 }
            r2.append(r3)     // Catch:{ all -> 0x0109 }
            java.lang.String r3 = ":initOfferwall(appKey: "
            r2.append(r3)     // Catch:{ all -> 0x0109 }
            r2.append(r8)     // Catch:{ all -> 0x0109 }
            java.lang.String r3 = ", userId: "
            r2.append(r3)     // Catch:{ all -> 0x0109 }
            r2.append(r9)     // Catch:{ all -> 0x0109 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x0109 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0109 }
            r3 = 1
            r0.log(r1, r2, r3)     // Catch:{ all -> 0x0109 }
            com.ironsource.mediationsdk.z r0 = com.ironsource.mediationsdk.z.a()     // Catch:{ all -> 0x0109 }
            com.ironsource.mediationsdk.utils.k r0 = r0.f     // Catch:{ all -> 0x0109 }
            r7.g = r0     // Catch:{ all -> 0x0109 }
            if (r0 != 0) goto L_0x0043
            java.lang.String r8 = "Please check configurations for Offerwall adapters"
            java.lang.String r9 = "Offerwall"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r9)     // Catch:{ all -> 0x0109 }
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x0109 }
            monitor-exit(r7)
            return
        L_0x0043:
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0109 }
            android.app.Activity r0 = r0.getCurrentActiveActivity()     // Catch:{ all -> 0x0109 }
            if (r0 != 0) goto L_0x005a
            java.lang.String r8 = "Activity must be provided when initializing SDK"
            java.lang.String r9 = "Offerwall"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r9)     // Catch:{ all -> 0x0109 }
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x0109 }
            monitor-exit(r7)
            return
        L_0x005a:
            com.ironsource.mediationsdk.utils.k r0 = r7.g     // Catch:{ all -> 0x0109 }
            if (r0 == 0) goto L_0x0082
            com.ironsource.mediationsdk.model.f r1 = r0.c     // Catch:{ all -> 0x0109 }
            if (r1 == 0) goto L_0x0082
            com.ironsource.mediationsdk.model.f r1 = r0.c     // Catch:{ all -> 0x0109 }
            com.ironsource.mediationsdk.model.k r1 = r1.c()     // Catch:{ all -> 0x0109 }
            if (r1 == 0) goto L_0x0082
            com.ironsource.mediationsdk.model.f r1 = r0.c     // Catch:{ all -> 0x0109 }
            com.ironsource.mediationsdk.model.k r1 = r1.c()     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = r1.b()     // Catch:{ all -> 0x0109 }
            if (r1 != 0) goto L_0x0077
            goto L_0x0082
        L_0x0077:
            com.ironsource.mediationsdk.model.f r0 = r0.c     // Catch:{ all -> 0x0109 }
            com.ironsource.mediationsdk.model.k r0 = r0.c()     // Catch:{ all -> 0x0109 }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x0109 }
            goto L_0x0084
        L_0x0082:
            java.lang.String r0 = "SupersonicAds"
        L_0x0084:
            com.ironsource.mediationsdk.utils.k r1 = r7.g     // Catch:{ all -> 0x0109 }
            com.ironsource.mediationsdk.model.p r1 = r1.b     // Catch:{ all -> 0x0109 }
            com.ironsource.mediationsdk.model.NetworkSettings r1 = r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0109 }
            r7.h = r1     // Catch:{ all -> 0x0109 }
            if (r1 != 0) goto L_0x009d
            java.lang.String r8 = "Please check configurations for Offerwall adapters"
            java.lang.String r9 = "Offerwall"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r9)     // Catch:{ all -> 0x0109 }
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x0109 }
            monitor-exit(r7)
            return
        L_0x009d:
            com.ironsource.mediationsdk.AbstractAdapter r0 = r7.b(r0)     // Catch:{ all -> 0x0109 }
            if (r0 != 0) goto L_0x00b0
            java.lang.String r8 = "Please check configurations for Offerwall adapters"
            java.lang.String r9 = "Offerwall"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r9)     // Catch:{ all -> 0x0109 }
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x0109 }
            monitor-exit(r7)
            return
        L_0x00b0:
            com.ironsource.mediationsdk.z r1 = com.ironsource.mediationsdk.z.a()     // Catch:{ Exception -> 0x00da }
            java.lang.Boolean r1 = r1.w     // Catch:{ Exception -> 0x00da }
            if (r1 == 0) goto L_0x00f5
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r2 = r7.d     // Catch:{ Exception -> 0x00da }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.ADAPTER_API     // Catch:{ Exception -> 0x00da }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00da }
            java.lang.String r6 = "Offerwall | setConsent(consent:"
            r5.<init>(r6)     // Catch:{ Exception -> 0x00da }
            r5.append(r1)     // Catch:{ Exception -> 0x00da }
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ Exception -> 0x00da }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00da }
            r2.log(r4, r5, r3)     // Catch:{ Exception -> 0x00da }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x00da }
            r0.setConsent(r1)     // Catch:{ Exception -> 0x00da }
            goto L_0x00f5
        L_0x00da:
            r1 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r2 = r7.d     // Catch:{ all -> 0x0109 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r3 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x0109 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
            java.lang.String r5 = ":setCustomParams():"
            r4.<init>(r5)     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0109 }
            r4.append(r1)     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0109 }
            r4 = 3
            r2.log(r3, r1, r4)     // Catch:{ all -> 0x0109 }
        L_0x00f5:
            com.ironsource.mediationsdk.sdk.f r0 = (com.ironsource.mediationsdk.sdk.f) r0     // Catch:{ all -> 0x0109 }
            r7.a = r0     // Catch:{ all -> 0x0109 }
            r0.setInternalOfferwallListener(r7)     // Catch:{ all -> 0x0109 }
            com.ironsource.mediationsdk.sdk.f r0 = r7.a     // Catch:{ all -> 0x0109 }
            com.ironsource.mediationsdk.model.NetworkSettings r1 = r7.h     // Catch:{ all -> 0x0109 }
            org.json.JSONObject r1 = r1.getRewardedVideoSettings()     // Catch:{ all -> 0x0109 }
            r0.initOfferwall(r8, r9, r1)     // Catch:{ all -> 0x0109 }
            monitor-exit(r7)
            return
        L_0x0109:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.a(java.lang.String, java.lang.String):void");
    }

    public final void a(boolean z, IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onOfferwallAvailable(isAvailable: " + z + ")", 1);
        if (z) {
            this.f.set(true);
            d dVar = this.b;
            if (dVar != null) {
                dVar.onOfferwallAvailable(true);
                return;
            }
            return;
        }
        a(ironSourceError);
    }

    public final synchronized boolean a() {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.f;
        return atomicBoolean != null ? atomicBoolean.get() : false;
    }

    public final void onGetOfferwallCreditsFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onGetOfferwallCreditsFailed(" + ironSourceError + ")", 1);
        d dVar = this.b;
        if (dVar != null) {
            dVar.onGetOfferwallCreditsFailed(ironSourceError);
        }
    }

    public final boolean onOfferwallAdCredited(int i2, int i3, boolean z) {
        this.d.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallAdCredited()", 1);
        d dVar = this.b;
        if (dVar != null) {
            return dVar.onOfferwallAdCredited(i2, i3, z);
        }
        return false;
    }

    public final void onOfferwallAvailable(boolean z) {
        a(z, (IronSourceError) null);
    }

    public final void onOfferwallClosed() {
        this.d.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallClosed()", 1);
        d dVar = this.b;
        if (dVar != null) {
            dVar.onOfferwallClosed();
        }
    }

    public final void onOfferwallOpened() {
        this.d.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallOpened()", 1);
        int a2 = this.j.a(IronSource.AD_UNIT.OFFERWALL);
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            if (!TextUtils.isEmpty(this.i)) {
                mediationAdditionalData.put("placement", this.i);
            }
            mediationAdditionalData.put(IronSourceConstants.KEY_SESSION_DEPTH, a2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        i.d().a(new com.ironsource.environment.c.a(305, mediationAdditionalData));
        this.k.b(IronSource.AD_UNIT.OFFERWALL);
        d dVar = this.b;
        if (dVar != null) {
            dVar.onOfferwallOpened();
        }
    }

    public final void onOfferwallShowFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.d;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onOfferwallShowFailed(" + ironSourceError + ")", 1);
        d dVar = this.b;
        if (dVar != null) {
            dVar.onOfferwallShowFailed(ironSourceError);
        }
    }
}
