package com.ironsource.mediationsdk.ads.nativead;

import android.app.Activity;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdInterface;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.adunit.c.g;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.i;
import com.ironsource.mediationsdk.model.j;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.z;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u0004\u0018\u00010(J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0016J\u0012\u0010,\u001a\u00020&2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010/\u001a\u00020&2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00100\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\"\u00103\u001a\u00020&2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00104\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u00105\u001a\u00020&2\b\u00106\u001a\u0004\u0018\u00010\u0018R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\n¨\u00068"}, d2 = {"Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd;", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdInterface;", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface;", "Lcom/ironsource/mediationsdk/ads/nativead/internal/InternalNativeAdListener;", "builder", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd$Builder;", "(Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd$Builder;)V", "advertiser", "", "getAdvertiser", "()Ljava/lang/String;", "body", "getBody", "callToAction", "getCallToAction", "icon", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface$Image;", "getIcon", "()Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface$Image;", "mAdManager", "Lcom/ironsource/mediationsdk/adunit/manager/NativeAdManager;", "mAdapterNativeAdData", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "mListener", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAdListener;", "mPlacement", "Lcom/ironsource/mediationsdk/model/Placement;", "mPlacementName", "mWasInitCalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<set-?>", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "nativeAdViewBinder", "getNativeAdViewBinder", "()Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "title", "getTitle", "destroyAd", "", "getObjectId", "Ljava/util/UUID;", "handleInitFailedError", "initAdManagerOnceIfNeeded", "loadAd", "onNativeAdClicked", "adInfo", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "onNativeAdImpression", "onNativeAdLoadFailed", "error", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "onNativeAdLoaded", "adapterNativeAdData", "setListener", "listener", "Builder", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LevelPlayNativeAd implements NativeAdDataInterface, NativeAdInterface, InternalNativeAdListener {
    private String a;
    private Placement b;
    private LevelPlayNativeAdListener c;
    private g d;
    private AdapterNativeAdData e;
    private AdapterNativeAdViewBinder f;
    private final AtomicBoolean g;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd$Builder;", "", "()V", "mListener", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAdListener;", "getMListener$mediationsdk_release", "()Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAdListener;", "setMListener$mediationsdk_release", "(Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAdListener;)V", "mPlacementName", "", "getMPlacementName$mediationsdk_release", "()Ljava/lang/String;", "setMPlacementName$mediationsdk_release", "(Ljava/lang/String;)V", "build", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd;", "withActivity", "activity", "Landroid/app/Activity;", "withListener", "listener", "withPlacementName", "placementName", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        private String a;
        private LevelPlayNativeAdListener b;

        public final LevelPlayNativeAd build() {
            return new LevelPlayNativeAd(this, (DefaultConstructorMarker) null);
        }

        public final LevelPlayNativeAdListener getMListener$mediationsdk_release() {
            return this.b;
        }

        public final String getMPlacementName$mediationsdk_release() {
            return this.a;
        }

        public final void setMListener$mediationsdk_release(LevelPlayNativeAdListener levelPlayNativeAdListener) {
            this.b = levelPlayNativeAdListener;
        }

        public final void setMPlacementName$mediationsdk_release(String str) {
            this.a = str;
        }

        public final Builder withActivity(Activity activity) {
            ContextProvider.getInstance().updateActivity(activity);
            IronLog ironLog = IronLog.INTERNAL;
            StringBuilder sb = new StringBuilder("activity is updated to: ");
            sb.append(activity != null ? activity.hashCode() : 0);
            ironLog.verbose(sb.toString());
            return this;
        }

        public final Builder withListener(LevelPlayNativeAdListener levelPlayNativeAdListener) {
            Intrinsics.checkNotNullParameter(levelPlayNativeAdListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b = levelPlayNativeAdListener;
            return this;
        }

        public final Builder withPlacementName(String str) {
            this.a = str;
            return this;
        }
    }

    private LevelPlayNativeAd(Builder builder) {
        this.g = new AtomicBoolean(false);
        this.a = builder.getMPlacementName$mediationsdk_release();
        this.c = builder.getMListener$mediationsdk_release();
    }

    public /* synthetic */ LevelPlayNativeAd(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    /* access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd levelPlayNativeAd) {
        LevelPlayNativeAdListener levelPlayNativeAdListener;
        j jVar;
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "this$0");
        Unit unit = null;
        if (levelPlayNativeAd.g.compareAndSet(false, true)) {
            g b2 = z.a().b();
            levelPlayNativeAd.d = b2;
            if (b2 != null) {
                b2.a((InternalNativeAdListener) levelPlayNativeAd);
                z a2 = z.a();
                String str = levelPlayNativeAd.a;
                i iVar = a2.f.c.a;
                if (iVar == null) {
                    jVar = null;
                } else if (TextUtils.isEmpty(str) || (jVar = iVar.a(str)) == null) {
                    jVar = iVar.b();
                }
                Intrinsics.checkNotNullExpressionValue(jVar, "getInstance().getNativeAdPlacement(mPlacementName)");
                levelPlayNativeAd.b = new Placement(jVar);
            }
        }
        g gVar = levelPlayNativeAd.d;
        if (gVar != null) {
            gVar.a(levelPlayNativeAd.b);
            unit = Unit.INSTANCE;
        }
        if (unit == null && (levelPlayNativeAdListener = levelPlayNativeAd.c) != null) {
            levelPlayNativeAdListener.onAdLoadFailed(levelPlayNativeAd, ErrorBuilder.buildInitFailedError("init() has failed", IronSourceConstants.NATIVE_AD_UNIT));
        }
    }

    /* access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd levelPlayNativeAd, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "this$0");
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "$adapterNativeAdData");
        Intrinsics.checkNotNullParameter(adapterNativeAdViewBinder, "$nativeAdViewBinder");
        levelPlayNativeAd.e = adapterNativeAdData;
        levelPlayNativeAd.f = adapterNativeAdViewBinder;
        LevelPlayNativeAdListener levelPlayNativeAdListener = levelPlayNativeAd.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoaded(levelPlayNativeAd, adInfo);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd levelPlayNativeAd, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = levelPlayNativeAd.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdImpression(levelPlayNativeAd, adInfo);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd levelPlayNativeAd, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = levelPlayNativeAd.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(levelPlayNativeAd, ironSourceError);
        }
    }

    /* access modifiers changed from: private */
    public static final void b(LevelPlayNativeAd levelPlayNativeAd, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = levelPlayNativeAd.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdClicked(levelPlayNativeAd, adInfo);
        }
    }

    public final void destroyAd() {
        IronLog.API.info(String.valueOf(this));
        try {
            g gVar = this.d;
            if (gVar != null) {
                gVar.h();
            }
        } catch (Throwable unused) {
            IronLog.API.error("destroyNativeAd()");
        }
    }

    public final String getAdvertiser() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getAdvertiser();
        }
        return null;
    }

    public final String getBody() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getBody();
        }
        return null;
    }

    public final String getCallToAction() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getCallToAction();
        }
        return null;
    }

    public final NativeAdDataInterface.Image getIcon() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getIcon();
        }
        return null;
    }

    public final AdapterNativeAdViewBinder getNativeAdViewBinder() {
        return this.f;
    }

    public final UUID getObjectId() {
        g gVar = this.d;
        if (gVar != null) {
            return gVar.a;
        }
        return null;
    }

    public final String getTitle() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getTitle();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadAd() {
        /*
            r6 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.API
            java.lang.String r1 = java.lang.String.valueOf(r6)
            r0.info(r1)
            com.ironsource.mediationsdk.z r0 = com.ironsource.mediationsdk.z.a()
            boolean r1 = r0.v
            r2 = 1
            if (r1 != 0) goto L_0x0015
            java.lang.String r1 = "init() must be called first"
            goto L_0x003a
        L_0x0015:
            com.ironsource.mediationsdk.E r1 = com.ironsource.mediationsdk.E.a()
            int[] r3 = com.ironsource.mediationsdk.z.AnonymousClass2.b
            com.ironsource.mediationsdk.E$a r4 = r1.b()
            int r4 = r4.ordinal()
            r3 = r3[r4]
            java.lang.String r4 = "init() had failed"
            if (r3 == r2) goto L_0x0039
            r5 = 2
            if (r3 == r5) goto L_0x002f
            java.lang.String r1 = ""
            goto L_0x003a
        L_0x002f:
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x0036
            goto L_0x0039
        L_0x0036:
            java.lang.String r1 = "init() not finished yet"
            goto L_0x003a
        L_0x0039:
            r1 = r4
        L_0x003a:
            boolean r3 = r0.j()
            r4 = 0
            if (r3 == 0) goto L_0x0066
            com.ironsource.mediationsdk.utils.k r3 = r0.f
            if (r3 == 0) goto L_0x0061
            com.ironsource.mediationsdk.utils.k r3 = r0.f
            com.ironsource.mediationsdk.model.o r3 = r3.a
            if (r3 == 0) goto L_0x0061
            com.ironsource.mediationsdk.utils.k r3 = r0.f
            com.ironsource.mediationsdk.model.o r3 = r3.a
            java.util.ArrayList<java.lang.String> r3 = r3.d
            if (r3 == 0) goto L_0x0061
            com.ironsource.mediationsdk.utils.k r0 = r0.f
            com.ironsource.mediationsdk.model.o r0 = r0.a
            java.util.ArrayList<java.lang.String> r0 = r0.d
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0061
            r0 = 1
            goto L_0x0062
        L_0x0061:
            r0 = 0
        L_0x0062:
            if (r0 == 0) goto L_0x0066
            r0 = 1
            goto L_0x0067
        L_0x0066:
            r0 = 0
        L_0x0067:
            if (r0 != 0) goto L_0x0071
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x0071
            java.lang.String r1 = "No Native Ad configurations found"
        L_0x0071:
            java.lang.String r0 = "initError"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r2 = 0
        L_0x0081:
            if (r2 == 0) goto L_0x0097
            com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAdListener r0 = r6.c
            if (r0 == 0) goto L_0x0096
            java.lang.String r2 = "loadAd(): "
            java.lang.String r1 = r2.concat(r1)
            java.lang.String r2 = "Native Ad"
            com.ironsource.mediationsdk.logger.IronSourceError r1 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r1, r2)
            r0.onAdLoadFailed(r6, r1)
        L_0x0096:
            return
        L_0x0097:
            com.ironsource.environment.thread.IronSourceThreadManager r0 = com.ironsource.environment.thread.IronSourceThreadManager.INSTANCE
            android.os.Handler r0 = r0.getInitHandler()
            com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd$$ExternalSyntheticLambda0 r1 = new com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd$$ExternalSyntheticLambda0
            r1.<init>(r6)
            r0.post(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd.loadAd():void");
    }

    public final void onNativeAdClicked(AdInfo adInfo) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new LevelPlayNativeAd$$ExternalSyntheticLambda4(this, adInfo), 0, 2, (Object) null);
    }

    public final void onNativeAdImpression(AdInfo adInfo) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new LevelPlayNativeAd$$ExternalSyntheticLambda1(this, adInfo), 0, 2, (Object) null);
    }

    public final void onNativeAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new LevelPlayNativeAd$$ExternalSyntheticLambda3(this, ironSourceError), 0, 2, (Object) null);
    }

    public final void onNativeAdLoaded(AdInfo adInfo, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "adapterNativeAdData");
        Intrinsics.checkNotNullParameter(adapterNativeAdViewBinder, "nativeAdViewBinder");
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new LevelPlayNativeAd$$ExternalSyntheticLambda2(this, adapterNativeAdData, adapterNativeAdViewBinder, adInfo), 0, 2, (Object) null);
    }

    public final void setListener(LevelPlayNativeAdListener levelPlayNativeAdListener) {
        this.c = levelPlayNativeAdListener;
    }
}
