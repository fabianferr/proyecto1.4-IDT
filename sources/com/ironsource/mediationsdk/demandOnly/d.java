package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.C0214d;
import com.ironsource.mediationsdk.C0215e;
import com.ironsource.mediationsdk.C0216f;
import com.ironsource.mediationsdk.C0220j;
import com.ironsource.mediationsdk.C0221k;
import com.ironsource.mediationsdk.C0224n;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.a;
import com.ironsource.mediationsdk.demandOnly.b;
import com.ironsource.mediationsdk.demandOnly.j;
import com.ironsource.mediationsdk.events.e;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.sdk.controller.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

public final class d extends j implements BannerSmashListener, h {
    private com.ironsource.mediationsdk.utils.d i;
    private com.ironsource.mediationsdk.utils.d j;
    private String k;
    private String l;
    private C0220j m;
    /* access modifiers changed from: private */
    public C0216f n;
    private ISDemandOnlyBannerLayout o;
    private final a p = MediationServices.getProvider().getSessionDepthService();
    private final a.C0114a q = MediationServices.getEditor().getSessionDepthServiceEditor();

    public d(String str, String str2, NetworkSettings networkSettings, long j2, AbstractAdapter abstractAdapter, C0216f fVar) {
        super(new com.ironsource.mediationsdk.model.a(networkSettings, networkSettings.getBannerSettings(), IronSource.AD_UNIT.BANNER), abstractAdapter);
        this.d = j2;
        this.k = str;
        this.l = str2;
        this.m = new C0220j();
        this.a.initBannerForBidding(str, str2, this.c, this);
        this.n = fVar;
    }

    /* access modifiers changed from: private */
    public void a(int i2, Object[][] objArr) {
        Map<String, Object> b = b();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    if (objArr2[1] != null) {
                        b.put(objArr2[0].toString(), objArr2[1]);
                    }
                }
            } catch (Exception e) {
                IronLog.INTERNAL.error(e.getMessage());
            }
        }
        e.d().a(new com.ironsource.environment.c.a(i2, new JSONObject(b)));
    }

    /* access modifiers changed from: private */
    public void a(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error = " + ironSourceError.getErrorMessage() + " smash - " + n());
        if (a(j.a.LOAD_IN_PROGRESS, j.a.NOT_LOADED)) {
            j();
            a(ironSourceError, com.ironsource.mediationsdk.utils.d.a(this.i));
            a(this.m.b(), IronSourceUtils.getCurrentMethodName());
            if (!c()) {
                this.o.getListener().a(g(), ironSourceError);
            }
        }
    }

    private void a(IronSourceError ironSourceError, long j2) {
        if (ironSourceError.getErrorCode() == 606) {
            a((int) IronSourceConstants.BN_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"duration", Long.valueOf(j2)}});
        } else {
            a((int) IronSourceConstants.BN_INSTANCE_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(j2)}});
        }
    }

    private void a(List<String> list, String str) {
        a(list, e(), f(), this.h, str);
    }

    private boolean c() {
        ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout = this.o;
        return iSDemandOnlyBannerLayout == null || iSDemandOnlyBannerLayout.isDestroyed();
    }

    private void d() {
        this.e = null;
        this.f = null;
        this.m = new C0220j();
    }

    private void l() {
        IronLog.INTERNAL.verbose();
        final C0221k m2 = m();
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new Runnable() {
            public final void run() {
                d.this.a(83500, (Object[][]) null);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("auction waterfallString = " + m2.j());
                d.this.a(83510, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, m2.j()}});
                d.this.n.a(ContextProvider.getInstance().getApplicationContext(), m2, (C0214d) d.this);
            }
        });
    }

    private C0221k m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(e());
        C0221k kVar = new C0221k(IronSource.AD_UNIT.BANNER);
        kVar.a((List<String>) arrayList);
        kVar.b("" + f() + e());
        kVar.a(g());
        kVar.b(IronSourceUtils.isEncryptedResponse());
        kVar.c(true);
        kVar.a(true);
        kVar.a(this.o.getSize());
        return kVar;
    }

    private String n() {
        return this.b.a.isMultipleInstances() ? this.b.a.getProviderTypeForReflection() : this.b.a.getProviderName();
    }

    private void o() {
        IronLog.INTERNAL.verbose();
        a((TimerTask) new TimerTask() {
            public final void run() {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("load timed out state=" + d.this.i());
                d.this.a(new IronSourceError(608, "load timed out"));
            }
        });
    }

    public final void a() {
        IronLog.INTERNAL.verbose();
        a(new j.a[]{j.a.LOADED, j.a.LOAD_IN_PROGRESS, j.a.SHOW_IN_PROGRESS}, j.a.NOT_LOADED);
        if (c()) {
            IronLog.INTERNAL.error("Banner is null or already destroyed and can't be used anymore");
            return;
        }
        j();
        ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout = this.o;
        if (iSDemandOnlyBannerLayout != null) {
            iSDemandOnlyBannerLayout.e = true;
            iSDemandOnlyBannerLayout.d = null;
            iSDemandOnlyBannerLayout.b = null;
            iSDemandOnlyBannerLayout.c = null;
            iSDemandOnlyBannerLayout.a = null;
            iSDemandOnlyBannerLayout.removeBannerListener();
        }
        this.o = null;
        if (this.a == null) {
            IronLog.INTERNAL.error("can't destroy adapter. mAdapter == null");
        } else {
            this.a.destroyBanner(this.c);
        }
        a((int) IronSourceConstants.BN_INSTANCE_DESTROY, (Object[][]) null);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("banner layout was destroyed. bannerId: " + g());
    }

    public final void a(int i2, String str, int i3, String str2, long j2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("Auction failed. error " + i2 + " - " + str);
        this.e = null;
        this.f = null;
        a(83501, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{"duration", Long.valueOf(j2)}, new Object[]{IronSourceConstants.EVENTS_EXT1, i()}});
        if (b(j.a.LOAD_IN_PROGRESS)) {
            a(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_AUCTION_FAILED, "No available ad to load"));
        }
    }

    public final void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout) {
        IronSourceError ironSourceError;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + i());
        j.a a = a(new j.a[]{j.a.NOT_LOADED, j.a.LOADED}, j.a.LOAD_IN_PROGRESS);
        if (a != j.a.LOAD_IN_PROGRESS && a != j.a.SHOW_IN_PROGRESS) {
            d();
            a(3002, (Object[][]) null);
            if (!h()) {
                IronLog.INTERNAL.verbose("can't load banner when isOneFlow = false");
                ironSourceError = new IronSourceError(IronSourceError.ERROR_CODE_MISSING_CONFIGURATION, "Missing configuration settings");
            } else {
                this.o = iSDemandOnlyBannerLayout;
                this.i = new com.ironsource.mediationsdk.utils.d();
                o();
                if (this.n.a.a()) {
                    l();
                    return;
                } else {
                    IronLog.INTERNAL.verbose("can't load the banner the auction isn't enabled");
                    ironSourceError = new IronSourceError(IronSourceError.ERROR_CODE_MISSING_CONFIGURATION, "Missing server configuration");
                }
            }
            a(ironSourceError);
        } else if (iSDemandOnlyBannerLayout != null && !iSDemandOnlyBannerLayout.isDestroyed()) {
            this.o.getListener().a(g(), new IronSourceError(IronSourceError.ERROR_DO_BN_LOAD_ALREADY_IN_PROGRESS, a == j.a.LOAD_IN_PROGRESS ? "load already in progress" : "cannot load because show is in progress"));
        }
    }

    public final void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, o oVar) {
        IronSourceError buildLoadFailedError;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + i());
        j.a a = a(new j.a[]{j.a.NOT_LOADED, j.a.LOADED}, j.a.LOAD_IN_PROGRESS);
        if (a != j.a.LOAD_IN_PROGRESS && a != j.a.SHOW_IN_PROGRESS) {
            d();
            a(3002, (Object[][]) null);
            if (c()) {
                buildLoadFailedError = new IronSourceError(610, "bannerLayout is null or destroyed");
            } else if (!k()) {
                buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadBannerForBidder in IAB flow must be called by bidder instances");
                a((int) IronSourceConstants.BN_INSTANCE_LOAD_ERROR, (Object[][]) null);
            } else {
                try {
                    C0215e.a aVar = (C0215e.a) oVar.a(new k());
                    com.ironsource.mediationsdk.adunit.a.a a2 = new b.a(aVar.b).a(e());
                    if (a2 == null) {
                        IronSourceError buildLoadFailedError2 = ErrorBuilder.buildLoadFailedError("loadBannerForBidder invalid enriched ADM");
                        a((int) IronSourceConstants.BN_INSTANCE_LOAD_ERROR, (Object[][]) null);
                        a(buildLoadFailedError2);
                        return;
                    }
                    String b = a2.b();
                    if (b == null) {
                        IronLog.INTERNAL.error("serverData is null");
                        a(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_SERVER_DATA, "No available ad to load"));
                        return;
                    }
                    a(b);
                    b(aVar.a);
                    a(aVar.d);
                    a(83302, (Object[][]) null);
                    this.m.c(a2.g());
                    this.i = new com.ironsource.mediationsdk.utils.d();
                    o();
                    this.a.initBannerForBidding(this.k, this.l, this.c, this);
                    this.a.loadBannerForDemandOnlyForBidding(this.c, b, iSDemandOnlyBannerLayout, this);
                    return;
                } catch (Exception e) {
                    buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadBannerForBidder: Exception= " + e.getMessage());
                }
            }
            a(buildLoadFailedError);
        } else if (iSDemandOnlyBannerLayout != null && !iSDemandOnlyBannerLayout.isDestroyed()) {
            this.o.getListener().a(g(), new IronSourceError(IronSourceError.ERROR_DO_BN_LOAD_ALREADY_IN_PROGRESS, a == j.a.LOAD_IN_PROGRESS ? "load already in progress" : "cannot load because show is in progress"));
        }
    }

    public final void a(C0215e.a aVar, long j2, int i2, String str) {
        IronSourceError ironSourceError;
        IronLog.INTERNAL.verbose();
        this.e = aVar.a;
        this.f = aVar.d;
        b.a aVar2 = new b.a(aVar.b);
        if (!TextUtils.isEmpty(str)) {
            a((int) IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}});
        }
        a(83502, new Object[][]{new Object[]{"duration", Long.valueOf(j2)}});
        a(83511, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, aVar2.a()}});
        if (b(j.a.LOAD_IN_PROGRESS)) {
            if (aVar2.b()) {
                ironSourceError = new IronSourceError(IronSourceConstants.BN_INSTANCE_LOAD_NO_FILL, "There is no available ad to load");
                IronLog.INTERNAL.error("loadBanner - empty waterfall");
            } else {
                com.ironsource.mediationsdk.adunit.a.a a = aVar2.a(0);
                this.m.c(a.g());
                this.m.a(a.i());
                this.m.b(a.h());
                String b = a.b();
                a(b);
                IronLog.INTERNAL.verbose();
                if (!b(j.a.LOAD_IN_PROGRESS)) {
                    return;
                }
                if (b == null) {
                    IronLog.INTERNAL.verbose("serverData is null");
                    ironSourceError = new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_SERVER_DATA, "No available ad to load");
                } else {
                    a(83302, (Object[][]) null);
                    this.j = new com.ironsource.mediationsdk.utils.d();
                    this.a.initBannerForBidding(this.k, this.l, this.c, this);
                    this.a.loadBannerForDemandOnlyForBidding(this.c, b, this.o, this);
                    return;
                }
            }
            a(ironSourceError);
        }
    }

    public final void a(List<com.ironsource.mediationsdk.adunit.a.a> list, String str, com.ironsource.mediationsdk.adunit.a.a aVar, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        IronLog.INTERNAL.error("onAuctionSuccess - Deprecated: Please use onAuctionSuccess(AuctionDataUtils.AuctionData auctionData, int auctionTrial, long elapsedTime, int troubleshootingErrorCode, String troubleshootingErrorMessage)");
    }

    public final Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        try {
            if (c()) {
                hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed");
            } else {
                C0224n.a(hashMap, this.o.getSize());
            }
            String str = "";
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, this.a != null ? this.a.getVersion() : str);
            if (this.a != null) {
                str = this.a.getCoreSDKVersion();
            }
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, str);
            hashMap.put(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, this.b.a.getSubProviderId());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.b.a.getAdSourceNameForEvents());
            hashMap.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
            if (h()) {
                hashMap.put("isOneFlow", 1);
            }
            hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
            hashMap.put("instanceType", Integer.valueOf(this.b.f));
            if (!TextUtils.isEmpty(this.e)) {
                hashMap.put("auctionId", this.e);
            }
            if (this.f != null && this.f.length() > 0) {
                hashMap.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.f);
            }
            if (!TextUtils.isEmpty(this.h)) {
                hashMap.put(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID, this.h);
            }
        } catch (Exception e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Instance: " + e() + " " + e.getMessage());
        }
        return hashMap;
    }

    public final void onBannerAdClicked() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + n());
        a((int) IronSourceConstants.BN_INSTANCE_CLICK, (Object[][]) null);
        if (!c()) {
            a listener = this.o.getListener();
            String g = g();
            ISDemandOnlyBannerListener iSDemandOnlyBannerListener = (ISDemandOnlyBannerListener) listener.a();
            a.a((Runnable) new Runnable(g, iSDemandOnlyBannerListener) {
                private /* synthetic */ String a;
                private /* synthetic */ ISDemandOnlyBannerListener b;

                public final void run(
/*
Method generation error in method: com.ironsource.mediationsdk.demandOnly.a.4.run():void, dex: classes5.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ironsource.mediationsdk.demandOnly.a.4.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            }, iSDemandOnlyBannerListener != null);
        }
    }

    public final void onBannerAdLeftApplication() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + n());
        a((int) IronSourceConstants.BN_INSTANCE_LEAVE_APP, (Object[][]) null);
        if (!c()) {
            a listener = this.o.getListener();
            String g = g();
            ISDemandOnlyBannerListener iSDemandOnlyBannerListener = (ISDemandOnlyBannerListener) listener.a();
            a.a((Runnable) new Runnable(g, iSDemandOnlyBannerListener) {
                private /* synthetic */ String a;
                private /* synthetic */ ISDemandOnlyBannerListener b;

                public final void run(
/*
Method generation error in method: com.ironsource.mediationsdk.demandOnly.a.5.run():void, dex: classes5.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ironsource.mediationsdk.demandOnly.a.5.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            }, iSDemandOnlyBannerListener != null);
        }
    }

    public final void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + n());
        long a = com.ironsource.mediationsdk.utils.d.a(this.j);
        a(83300, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(a)}});
        a(ironSourceError);
    }

    public final void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash = " + n());
        int a = this.p.a(IronSource.AD_UNIT.BANNER);
        long a2 = com.ironsource.mediationsdk.utils.d.a(this.j);
        boolean z = false;
        a(83305, new Object[][]{new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(a)}, new Object[]{"duration", Long.valueOf(a2)}});
        if (a(j.a.LOAD_IN_PROGRESS, j.a.LOADED)) {
            j();
            if (!c()) {
                IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable(view, layoutParams) {
                    private /* synthetic */ View a;
                    private /* synthetic */ FrameLayout.LayoutParams b;

                    public final void run(
/*
Method generation error in method: com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout.1.run():void, dex: classes5.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout.1.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                });
            }
            long a3 = com.ironsource.mediationsdk.utils.d.a(this.i);
            a(3005, new Object[][]{new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(a)}, new Object[]{"duration", Long.valueOf(a3)}});
            this.q.b(IronSource.AD_UNIT.BANNER);
            a(this.m.a(), IronSourceUtils.getCurrentMethodName());
            if (!c()) {
                a listener = this.o.getListener();
                String g = g();
                ISDemandOnlyBannerListener iSDemandOnlyBannerListener = (ISDemandOnlyBannerListener) listener.a();
                a.AnonymousClass2 r1 = new Runnable(g, iSDemandOnlyBannerListener) {
                    private /* synthetic */ String a;
                    private /* synthetic */ ISDemandOnlyBannerListener b;

                    public final void run(
/*
Method generation error in method: com.ironsource.mediationsdk.demandOnly.a.2.run():void, dex: classes5.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ironsource.mediationsdk.demandOnly.a.2.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                };
                if (iSDemandOnlyBannerListener != null) {
                    z = true;
                }
                a.a((Runnable) r1, z);
            }
        }
    }

    public final void onBannerAdScreenDismissed() {
    }

    public final void onBannerAdScreenPresented() {
    }

    public final void onBannerAdShown() {
        if (a(j.a.LOADED, j.a.SHOW_IN_PROGRESS)) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("smash - " + n());
            a((int) IronSourceConstants.BN_INSTANCE_SHOW, (Object[][]) null);
            a(this.m.c(), IronSourceUtils.getCurrentMethodName());
            if (!c()) {
                a listener = this.o.getListener();
                String g = g();
                ISDemandOnlyBannerListener iSDemandOnlyBannerListener = (ISDemandOnlyBannerListener) listener.a();
                a.a((Runnable) new Runnable(g, iSDemandOnlyBannerListener) {
                    private /* synthetic */ String a;
                    private /* synthetic */ ISDemandOnlyBannerListener b;

                    public final void run(
/*
Method generation error in method: com.ironsource.mediationsdk.demandOnly.a.3.run():void, dex: classes5.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ironsource.mediationsdk.demandOnly.a.3.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                }, iSDemandOnlyBannerListener != null);
            }
        }
    }

    public final void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + n() + " " + ironSourceError.toString());
    }

    public final void onBannerInitSuccess() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + n());
    }
}
