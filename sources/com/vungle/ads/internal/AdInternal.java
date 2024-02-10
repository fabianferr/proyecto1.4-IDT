package com.vungle.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.vungle.ads.AdExpiredError;
import com.vungle.ads.AdExpiredOnPlayError;
import com.vungle.ads.AdNotLoadedCantPlay;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.ConcurrentPlaybackUnsupported;
import com.vungle.ads.InvalidAdStateError;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.SDKExecutors;
import com.vungle.ads.internal.load.AdLoaderCallback;
import com.vungle.ads.internal.load.BaseAdLoader;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.task.CleanupJob;
import com.vungle.ads.internal.task.JobRunner;
import com.vungle.ads.internal.ui.AdActivity;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.PathProvider;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b&\u0018\u0000 L2\u00020\u0001:\u0002KLB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010-\u001a\u00020.2\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b/J\u0012\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203J\r\u00104\u001a\u00020.H\u0000¢\u0006\u0002\b5J\b\u00106\u001a\u000207H&J\u0015\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:H\u0000¢\u0006\u0002\b;J\u0010\u0010<\u001a\u0002032\u0006\u0010=\u001a\u000207H&J\u0010\u0010>\u001a\u0002032\u0006\u0010\u001d\u001a\u00020\u001eH&J \u0010?\u001a\u00020.2\u0006\u0010@\u001a\u0002072\b\u0010A\u001a\u0004\u0018\u0001072\u0006\u0010\u0005\u001a\u00020\u0001J\u0010\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u000201H\u0016J\u0010\u0010D\u001a\u00020.2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010E\u001a\u00020.2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010F\u001a\u00020GJ'\u0010H\u001a\u00020.2\b\u0010I\u001a\u0004\u0018\u00010G2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\bJR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*¨\u0006M²\u0006\n\u0010N\u001a\u00020OX\u0002²\u0006\n\u0010P\u001a\u00020QX\u0002²\u0006\n\u0010R\u001a\u00020SX\u0002²\u0006\n\u0010T\u001a\u00020UX\u0002²\u0006\n\u0010V\u001a\u00020WX\u0002"}, d2 = {"Lcom/vungle/ads/internal/AdInternal;", "Lcom/vungle/ads/internal/load/AdLoaderCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adLoaderCallback", "value", "Lcom/vungle/ads/internal/AdInternal$AdState;", "adState", "getAdState", "()Lcom/vungle/ads/internal/AdInternal$AdState;", "setAdState", "(Lcom/vungle/ads/internal/AdInternal$AdState;)V", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "getAdvertisement", "()Lcom/vungle/ads/internal/model/AdPayload;", "setAdvertisement", "(Lcom/vungle/ads/internal/model/AdPayload;)V", "baseAdLoader", "Lcom/vungle/ads/internal/load/BaseAdLoader;", "bidPayload", "Lcom/vungle/ads/internal/model/BidPayload;", "getBidPayload", "()Lcom/vungle/ads/internal/model/BidPayload;", "setBidPayload", "(Lcom/vungle/ads/internal/model/BidPayload;)V", "getContext", "()Landroid/content/Context;", "placement", "Lcom/vungle/ads/internal/model/Placement;", "getPlacement", "()Lcom/vungle/ads/internal/model/Placement;", "setPlacement", "(Lcom/vungle/ads/internal/model/Placement;)V", "playContext", "Ljava/lang/ref/WeakReference;", "requestMetric", "Lcom/vungle/ads/TimeIntervalMetric;", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "getVungleApiClient", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "vungleApiClient$delegate", "Lkotlin/Lazy;", "adLoadedAndUpdateConfigure", "", "adLoadedAndUpdateConfigure$vungle_ads_release", "canPlayAd", "Lcom/vungle/ads/VungleError;", "onPlay", "", "cancelDownload", "cancelDownload$vungle_ads_release", "getAdSizeForAdRequest", "", "isErrorTerminal", "errorCode", "", "isErrorTerminal$vungle_ads_release", "isValidAdSize", "adSize", "isValidAdTypeForPlacement", "loadAd", "placementId", "adMarkup", "onFailure", "error", "onSuccess", "play", "adPlayCallback", "Lcom/vungle/ads/internal/presenter/AdPlayCallback;", "renderAd", "listener", "renderAd$vungle_ads_release", "AdState", "Companion", "vungle-ads_release", "jobRunner", "Lcom/vungle/ads/internal/task/JobRunner;", "omInjector", "Lcom/vungle/ads/internal/omsdk/OMInjector;", "sdkExecutors", "Lcom/vungle/ads/internal/executor/SDKExecutors;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "downloader", "Lcom/vungle/ads/internal/downloader/Downloader;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdInternal.kt */
public abstract class AdInternal implements AdLoaderCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG = Reflection.getOrCreateKotlinClass(AdInternal.class).getSimpleName();
    /* access modifiers changed from: private */
    public static final boolean THROW_ON_ILLEGAL_TRANSITION = false;
    private static final Json json = JsonKt.Json$default((Json) null, AdInternal$Companion$json$1.INSTANCE, 1, (Object) null);
    private AdLoaderCallback adLoaderCallback;
    private AdState adState = AdState.NEW;
    private AdPayload advertisement;
    private BaseAdLoader baseAdLoader;
    private BidPayload bidPayload;
    private final Context context;
    private Placement placement;
    private WeakReference<Context> playContext;
    private TimeIntervalMetric requestMetric;
    private final Lazy vungleApiClient$delegate;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdInternal.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdState.values().length];
            iArr[AdState.NEW.ordinal()] = 1;
            iArr[AdState.LOADING.ordinal()] = 2;
            iArr[AdState.READY.ordinal()] = 3;
            iArr[AdState.PLAYING.ordinal()] = 4;
            iArr[AdState.FINISHED.ordinal()] = 5;
            iArr[AdState.ERROR.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void adLoadedAndUpdateConfigure$vungle_ads_release(AdPayload adPayload) {
        Intrinsics.checkNotNullParameter(adPayload, "advertisement");
    }

    public abstract String getAdSizeForAdRequest();

    public abstract boolean isValidAdSize(String str);

    public abstract boolean isValidAdTypeForPlacement(Placement placement2);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$Companion;", "", "()V", "TAG", "", "THROW_ON_ILLEGAL_TRANSITION", "", "json", "Lkotlinx/serialization/json/Json;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdInternal.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AdInternal(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.vungleApiClient$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new AdInternal$special$$inlined$inject$1(context2));
    }

    public final Context getContext() {
        return this.context;
    }

    public final AdState getAdState() {
        return this.adState;
    }

    public final void setAdState(AdState adState2) {
        AdPayload adPayload;
        String eventId;
        Intrinsics.checkNotNullParameter(adState2, "value");
        if (!(!adState2.isTerminalState() || (adPayload = this.advertisement) == null || (eventId = adPayload.eventId()) == null)) {
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new AdInternal$_set_adState_$lambda1$$inlined$inject$1(this.context));
            m264_set_adState_$lambda1$lambda0(lazy).execute(CleanupJob.Companion.makeJobInfo(eventId));
        }
        this.adState = this.adState.transitionTo(adState2);
    }

    /* renamed from: _set_adState_$lambda-1$lambda-0  reason: not valid java name */
    private static final JobRunner m264_set_adState_$lambda1$lambda0(Lazy<? extends JobRunner> lazy) {
        return (JobRunner) lazy.getValue();
    }

    public final AdPayload getAdvertisement() {
        return this.advertisement;
    }

    public final void setAdvertisement(AdPayload adPayload) {
        this.advertisement = adPayload;
    }

    public final Placement getPlacement() {
        return this.placement;
    }

    public final void setPlacement(Placement placement2) {
        this.placement = placement2;
    }

    public final BidPayload getBidPayload() {
        return this.bidPayload;
    }

    public final void setBidPayload(BidPayload bidPayload2) {
        this.bidPayload = bidPayload2;
    }

    private final VungleApiClient getVungleApiClient() {
        return (VungleApiClient) this.vungleApiClient$delegate.getValue();
    }

    public static /* synthetic */ VungleError canPlayAd$default(AdInternal adInternal, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            return adInternal.canPlayAd(z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canPlayAd");
    }

    public final VungleError canPlayAd(boolean z) {
        VungleError vungleError;
        AdPayload adPayload = this.advertisement;
        String str = null;
        if (adPayload == null) {
            vungleError = new AdNotLoadedCantPlay();
        } else {
            boolean z2 = false;
            if (adPayload != null && adPayload.hasExpired()) {
                z2 = true;
            }
            if (z2) {
                if (z) {
                    vungleError = new AdExpiredOnPlayError();
                } else {
                    vungleError = new AdExpiredError();
                }
            } else if (this.adState == AdState.PLAYING) {
                vungleError = new ConcurrentPlaybackUnsupported();
            } else if (this.adState == AdState.READY) {
                return null;
            } else {
                vungleError = new InvalidAdStateError(0, (Sdk.SDKError.Reason) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
            }
        }
        if (z) {
            Placement placement2 = this.placement;
            VungleError placementId$vungle_ads_release = vungleError.setPlacementId$vungle_ads_release(placement2 != null ? placement2.getReferenceId() : null);
            AdPayload adPayload2 = this.advertisement;
            VungleError creativeId$vungle_ads_release = placementId$vungle_ads_release.setCreativeId$vungle_ads_release(adPayload2 != null ? adPayload2.getCreativeId() : null);
            AdPayload adPayload3 = this.advertisement;
            if (adPayload3 != null) {
                str = adPayload3.eventId();
            }
            creativeId$vungle_ads_release.setEventId$vungle_ads_release(str).logErrorNoReturnValue$vungle_ads_release();
        }
        return vungleError;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        if ((r5 == null || r5.length() == 0) == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009e, code lost:
        if ((r5 == null || r5.length() == 0) == false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a0, code lost:
        r10.onFailure(new com.vungle.ads.InvalidWaterfallPlacementError(r6).logError$vungle_ads_release());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadAd(java.lang.String r20, java.lang.String r21, com.vungle.ads.internal.load.AdLoaderCallback r22) {
        /*
            r19 = this;
            r1 = r19
            r6 = r20
            r0 = r21
            r10 = r22
            java.lang.String r2 = "Unable to decode payload into BidPayload object. Error: "
            java.lang.String r3 = "placementId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            java.lang.String r3 = "adLoaderCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r3)
            r1.adLoaderCallback = r10
            com.vungle.ads.VungleAds$Companion r3 = com.vungle.ads.VungleAds.Companion
            boolean r3 = r3.isInitialized()
            if (r3 != 0) goto L_0x0029
            com.vungle.ads.SdkNotInitialized r0 = new com.vungle.ads.SdkNotInitialized
            r0.<init>()
            com.vungle.ads.VungleError r0 = (com.vungle.ads.VungleError) r0
            r10.onFailure(r0)
            return
        L_0x0029:
            com.vungle.ads.internal.ConfigManager r3 = com.vungle.ads.internal.ConfigManager.INSTANCE
            com.vungle.ads.internal.model.Placement r3 = r3.getPlacement(r6)
            if (r3 != 0) goto L_0x003e
            com.vungle.ads.PlacementNotFoundError r0 = new com.vungle.ads.PlacementNotFoundError
            r0.<init>(r6)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            r10.onFailure(r0)
            return
        L_0x003e:
            r1.placement = r3
            boolean r4 = r1.isValidAdTypeForPlacement(r3)
            if (r4 != 0) goto L_0x0057
            com.vungle.ads.PlacementAdTypeMismatchError r0 = new com.vungle.ads.PlacementAdTypeMismatchError
            java.lang.String r2 = r3.getReferenceId()
            r0.<init>(r2)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            r10.onFailure(r0)
            return
        L_0x0057:
            java.lang.String r4 = r19.getAdSizeForAdRequest()
            boolean r5 = r1.isValidAdSize(r4)
            r7 = 0
            if (r5 != 0) goto L_0x0070
            com.vungle.ads.InternalError r0 = new com.vungle.ads.InternalError
            r2 = 10028(0x272c, float:1.4052E-41)
            r3 = 2
            r0.<init>(r2, r7, r3, r7)
            com.vungle.ads.VungleError r0 = (com.vungle.ads.VungleError) r0
            r10.onFailure(r0)
            return
        L_0x0070:
            boolean r5 = r3.getHeaderBidding()
            r8 = 0
            r9 = 1
            if (r5 == 0) goto L_0x0089
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0086
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            r5 = 0
            goto L_0x0087
        L_0x0086:
            r5 = 1
        L_0x0087:
            if (r5 != 0) goto L_0x00a0
        L_0x0089:
            boolean r5 = r3.getHeaderBidding()
            if (r5 != 0) goto L_0x00ad
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x009d
            int r5 = r5.length()
            if (r5 != 0) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            r5 = 0
            goto L_0x009e
        L_0x009d:
            r5 = 1
        L_0x009e:
            if (r5 != 0) goto L_0x00ad
        L_0x00a0:
            com.vungle.ads.InvalidWaterfallPlacementError r0 = new com.vungle.ads.InvalidWaterfallPlacementError
            r0.<init>(r6)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            r10.onFailure(r0)
            return
        L_0x00ad:
            com.vungle.ads.internal.AdInternal$AdState r5 = r1.adState
            com.vungle.ads.internal.AdInternal$AdState r11 = com.vungle.ads.internal.AdInternal.AdState.NEW
            if (r5 == r11) goto L_0x011b
            com.vungle.ads.internal.AdInternal$AdState r0 = r1.adState
            int[] r2 = com.vungle.ads.internal.AdInternal.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r2[r0]
            switch(r0) {
                case 1: goto L_0x0115;
                case 2: goto L_0x00d2;
                case 3: goto L_0x00cf;
                case 4: goto L_0x00cc;
                case 5: goto L_0x00c9;
                case 6: goto L_0x00c6;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00c6:
            r0 = 206(0xce, float:2.89E-43)
            goto L_0x00d4
        L_0x00c9:
            r0 = 202(0xca, float:2.83E-43)
            goto L_0x00d4
        L_0x00cc:
            r0 = 205(0xcd, float:2.87E-43)
            goto L_0x00d4
        L_0x00cf:
            r0 = 204(0xcc, float:2.86E-43)
            goto L_0x00d4
        L_0x00d2:
            r0 = 203(0xcb, float:2.84E-43)
        L_0x00d4:
            com.vungle.ads.InvalidAdStateError r9 = new com.vungle.ads.InvalidAdStateError
            r3 = 10042(0x273a, float:1.4072E-41)
            com.vungle.ads.VungleError$Companion r2 = com.vungle.ads.VungleError.Companion
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r4 = r2.codeToLoggableReason(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.vungle.ads.internal.AdInternal$AdState r2 = r1.adState
            r0.append(r2)
            java.lang.String r2 = " state is incorrect for load"
            r0.append(r2)
            java.lang.String r5 = r0.toString()
            com.vungle.ads.internal.model.AdPayload r0 = r1.advertisement
            if (r0 == 0) goto L_0x00fa
            java.lang.String r0 = r0.getCreativeId()
            goto L_0x00fb
        L_0x00fa:
            r0 = r7
        L_0x00fb:
            com.vungle.ads.internal.model.AdPayload r2 = r1.advertisement
            if (r2 == 0) goto L_0x0105
            java.lang.String r2 = r2.eventId()
            r8 = r2
            goto L_0x0106
        L_0x0105:
            r8 = r7
        L_0x0106:
            r2 = r9
            r6 = r20
            r7 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            com.vungle.ads.VungleError r0 = r9.logError$vungle_ads_release()
            r10.onFailure(r0)
            return
        L_0x0115:
            kotlin.NotImplementedError r0 = new kotlin.NotImplementedError
            r0.<init>(r7, r9, r7)
            throw r0
        L_0x011b:
            com.vungle.ads.internal.ConfigManager r5 = com.vungle.ads.internal.ConfigManager.INSTANCE
            boolean r5 = r5.adLoadOptimizationEnabled()
            if (r5 == 0) goto L_0x0126
            com.vungle.ads.internal.protos.Sdk$SDKMetric$SDKMetricType r5 = com.vungle.ads.internal.protos.Sdk.SDKMetric.SDKMetricType.AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS
            goto L_0x0128
        L_0x0126:
            com.vungle.ads.internal.protos.Sdk$SDKMetric$SDKMetricType r5 = com.vungle.ads.internal.protos.Sdk.SDKMetric.SDKMetricType.AD_REQUEST_TO_CALLBACK_DURATION_MS
        L_0x0128:
            com.vungle.ads.TimeIntervalMetric r11 = new com.vungle.ads.TimeIntervalMetric
            r11.<init>(r5)
            r1.requestMetric = r11
            r11.markStart()
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0140
            int r11 = r5.length()
            if (r11 != 0) goto L_0x013e
            goto L_0x0140
        L_0x013e:
            r11 = 0
            goto L_0x0141
        L_0x0140:
            r11 = 1
        L_0x0141:
            if (r11 != 0) goto L_0x01d6
            kotlinx.serialization.json.Json r11 = json     // Catch:{ IllegalArgumentException -> 0x019e, Exception -> 0x0166 }
            kotlinx.serialization.StringFormat r11 = (kotlinx.serialization.StringFormat) r11     // Catch:{ IllegalArgumentException -> 0x019e, Exception -> 0x0166 }
            kotlinx.serialization.modules.SerializersModule r12 = r11.getSerializersModule()     // Catch:{ IllegalArgumentException -> 0x019e, Exception -> 0x0166 }
            java.lang.Class<com.vungle.ads.internal.model.BidPayload> r13 = com.vungle.ads.internal.model.BidPayload.class
            kotlin.reflect.KType r13 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r13)     // Catch:{ IllegalArgumentException -> 0x019e, Exception -> 0x0166 }
            kotlinx.serialization.KSerializer r12 = kotlinx.serialization.SerializersKt.serializer((kotlinx.serialization.modules.SerializersModule) r12, (kotlin.reflect.KType) r13)     // Catch:{ IllegalArgumentException -> 0x019e, Exception -> 0x0166 }
            java.lang.String r13 = "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r13)     // Catch:{ IllegalArgumentException -> 0x019e, Exception -> 0x0166 }
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12     // Catch:{ IllegalArgumentException -> 0x019e, Exception -> 0x0166 }
            java.lang.Object r0 = r11.decodeFromString(r12, r0)     // Catch:{ IllegalArgumentException -> 0x019e, Exception -> 0x0166 }
            com.vungle.ads.internal.model.BidPayload r0 = (com.vungle.ads.internal.model.BidPayload) r0     // Catch:{ IllegalArgumentException -> 0x019e, Exception -> 0x0166 }
            r1.bidPayload = r0     // Catch:{ IllegalArgumentException -> 0x019e, Exception -> 0x0166 }
            goto L_0x01d6
        L_0x0166:
            r0 = move-exception
            com.vungle.ads.AnalyticsClient r3 = com.vungle.ads.AnalyticsClient.INSTANCE
            r4 = 209(0xd1, float:2.93E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r2)
            java.lang.String r0 = r0.getLocalizedMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r8 = 0
            com.vungle.ads.internal.model.AdPayload r2 = r1.advertisement
            if (r2 == 0) goto L_0x0185
            java.lang.String r2 = r2.eventId()
            r7 = r2
        L_0x0185:
            r9 = 8
            r11 = 0
            r2 = r3
            r3 = r4
            r4 = r0
            r5 = r20
            r6 = r8
            r8 = r9
            r9 = r11
            com.vungle.ads.AnalyticsClient.logError$vungle_ads_release$default((com.vungle.ads.AnalyticsClient) r2, (int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (int) r8, (java.lang.Object) r9)
            com.vungle.ads.AdMarkupInvalidError r0 = new com.vungle.ads.AdMarkupInvalidError
            r0.<init>()
            com.vungle.ads.VungleError r0 = (com.vungle.ads.VungleError) r0
            r10.onFailure(r0)
            return
        L_0x019e:
            r0 = move-exception
            com.vungle.ads.AnalyticsClient r3 = com.vungle.ads.AnalyticsClient.INSTANCE
            r4 = 213(0xd5, float:2.98E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r2)
            java.lang.String r0 = r0.getLocalizedMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r8 = 0
            com.vungle.ads.internal.model.AdPayload r2 = r1.advertisement
            if (r2 == 0) goto L_0x01bd
            java.lang.String r2 = r2.eventId()
            r7 = r2
        L_0x01bd:
            r9 = 8
            r11 = 0
            r2 = r3
            r3 = r4
            r4 = r0
            r5 = r20
            r6 = r8
            r8 = r9
            r9 = r11
            com.vungle.ads.AnalyticsClient.logError$vungle_ads_release$default((com.vungle.ads.AnalyticsClient) r2, (int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (int) r8, (java.lang.Object) r9)
            com.vungle.ads.AdMarkupInvalidError r0 = new com.vungle.ads.AdMarkupInvalidError
            r0.<init>()
            com.vungle.ads.VungleError r0 = (com.vungle.ads.VungleError) r0
            r10.onFailure(r0)
            return
        L_0x01d6:
            com.vungle.ads.internal.AdInternal$AdState r0 = com.vungle.ads.internal.AdInternal.AdState.LOADING
            r1.setAdState(r0)
            com.vungle.ads.ServiceLocator$Companion r0 = com.vungle.ads.ServiceLocator.Companion
            android.content.Context r0 = r1.context
            kotlin.LazyThreadSafetyMode r2 = kotlin.LazyThreadSafetyMode.SYNCHRONIZED
            com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$1 r6 = new com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$1
            r6.<init>(r0)
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            kotlin.Lazy r0 = kotlin.LazyKt.lazy((kotlin.LazyThreadSafetyMode) r2, r6)
            com.vungle.ads.ServiceLocator$Companion r2 = com.vungle.ads.ServiceLocator.Companion
            android.content.Context r2 = r1.context
            kotlin.LazyThreadSafetyMode r6 = kotlin.LazyThreadSafetyMode.SYNCHRONIZED
            com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$2 r10 = new com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$2
            r10.<init>(r2)
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            kotlin.Lazy r2 = kotlin.LazyKt.lazy((kotlin.LazyThreadSafetyMode) r6, r10)
            com.vungle.ads.ServiceLocator$Companion r6 = com.vungle.ads.ServiceLocator.Companion
            android.content.Context r6 = r1.context
            kotlin.LazyThreadSafetyMode r10 = kotlin.LazyThreadSafetyMode.SYNCHRONIZED
            com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$3 r11 = new com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$3
            r11.<init>(r6)
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            kotlin.Lazy r6 = kotlin.LazyKt.lazy((kotlin.LazyThreadSafetyMode) r10, r11)
            com.vungle.ads.ServiceLocator$Companion r10 = com.vungle.ads.ServiceLocator.Companion
            android.content.Context r10 = r1.context
            kotlin.LazyThreadSafetyMode r11 = kotlin.LazyThreadSafetyMode.SYNCHRONIZED
            com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$4 r12 = new com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$4
            r12.<init>(r10)
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            kotlin.Lazy r10 = kotlin.LazyKt.lazy((kotlin.LazyThreadSafetyMode) r11, r12)
            if (r5 == 0) goto L_0x0227
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0228
        L_0x0227:
            r8 = 1
        L_0x0228:
            if (r8 == 0) goto L_0x025c
            com.vungle.ads.internal.load.AdRequest r5 = new com.vungle.ads.internal.load.AdRequest
            r5.<init>(r3, r7, r4)
            com.vungle.ads.internal.load.DefaultAdLoader r3 = new com.vungle.ads.internal.load.DefaultAdLoader
            android.content.Context r12 = r1.context
            com.vungle.ads.internal.network.VungleApiClient r13 = r19.getVungleApiClient()
            com.vungle.ads.internal.executor.SDKExecutors r2 = m266loadAd$lambda3(r2)
            r14 = r2
            com.vungle.ads.internal.executor.Executors r14 = (com.vungle.ads.internal.executor.Executors) r14
            com.vungle.ads.internal.omsdk.OMInjector r15 = m265loadAd$lambda2(r0)
            com.vungle.ads.internal.downloader.Downloader r16 = m268loadAd$lambda5(r10)
            com.vungle.ads.internal.util.PathProvider r17 = m267loadAd$lambda4(r6)
            r11 = r3
            r18 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            r0 = r3
            com.vungle.ads.internal.load.BaseAdLoader r0 = (com.vungle.ads.internal.load.BaseAdLoader) r0
            r1.baseAdLoader = r0
            r0 = r1
            com.vungle.ads.internal.load.AdLoaderCallback r0 = (com.vungle.ads.internal.load.AdLoaderCallback) r0
            r3.loadAd(r0)
            goto L_0x028e
        L_0x025c:
            com.vungle.ads.internal.load.AdRequest r11 = new com.vungle.ads.internal.load.AdRequest
            com.vungle.ads.internal.model.BidPayload r5 = r1.bidPayload
            r11.<init>(r3, r5, r4)
            com.vungle.ads.internal.load.RealtimeAdLoader r3 = new com.vungle.ads.internal.load.RealtimeAdLoader
            android.content.Context r5 = r1.context
            com.vungle.ads.internal.network.VungleApiClient r7 = r19.getVungleApiClient()
            com.vungle.ads.internal.executor.SDKExecutors r2 = m266loadAd$lambda3(r2)
            com.vungle.ads.internal.executor.Executors r2 = (com.vungle.ads.internal.executor.Executors) r2
            com.vungle.ads.internal.omsdk.OMInjector r8 = m265loadAd$lambda2(r0)
            com.vungle.ads.internal.downloader.Downloader r9 = m268loadAd$lambda5(r10)
            com.vungle.ads.internal.util.PathProvider r10 = m267loadAd$lambda4(r6)
            r4 = r3
            r6 = r7
            r7 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r0 = r3
            com.vungle.ads.internal.load.BaseAdLoader r0 = (com.vungle.ads.internal.load.BaseAdLoader) r0
            r1.baseAdLoader = r0
            r0 = r1
            com.vungle.ads.internal.load.AdLoaderCallback r0 = (com.vungle.ads.internal.load.AdLoaderCallback) r0
            r3.loadAd(r0)
        L_0x028e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.AdInternal.loadAd(java.lang.String, java.lang.String, com.vungle.ads.internal.load.AdLoaderCallback):void");
    }

    /* renamed from: loadAd$lambda-2  reason: not valid java name */
    private static final OMInjector m265loadAd$lambda2(Lazy<OMInjector> lazy) {
        return lazy.getValue();
    }

    /* renamed from: loadAd$lambda-3  reason: not valid java name */
    private static final SDKExecutors m266loadAd$lambda3(Lazy<SDKExecutors> lazy) {
        return lazy.getValue();
    }

    /* renamed from: loadAd$lambda-4  reason: not valid java name */
    private static final PathProvider m267loadAd$lambda4(Lazy<PathProvider> lazy) {
        return lazy.getValue();
    }

    /* renamed from: loadAd$lambda-5  reason: not valid java name */
    private static final Downloader m268loadAd$lambda5(Lazy<? extends Downloader> lazy) {
        return (Downloader) lazy.getValue();
    }

    public final void cancelDownload$vungle_ads_release() {
        BaseAdLoader baseAdLoader2 = this.baseAdLoader;
        if (baseAdLoader2 != null) {
            baseAdLoader2.cancel();
        }
    }

    public final void play(Context context2, AdPlayCallback adPlayCallback) {
        WeakReference<Context> weakReference;
        AdPayload adPayload;
        Intrinsics.checkNotNullParameter(adPlayCallback, "adPlayCallback");
        if (context2 != null) {
            weakReference = new WeakReference<>(context2);
        } else {
            weakReference = null;
            WeakReference weakReference2 = null;
        }
        this.playContext = weakReference;
        VungleError canPlayAd = canPlayAd(true);
        if (canPlayAd != null) {
            adPlayCallback.onFailure(canPlayAd);
            if (isErrorTerminal$vungle_ads_release(canPlayAd.getCode())) {
                setAdState(AdState.ERROR);
                return;
            }
            return;
        }
        Placement placement2 = this.placement;
        if (placement2 != null && (adPayload = this.advertisement) != null) {
            AdInternal$play$callbackWrapper$1 adInternal$play$callbackWrapper$1 = new AdInternal$play$callbackWrapper$1(adPlayCallback, this);
            cancelDownload$vungle_ads_release();
            renderAd$vungle_ads_release(adInternal$play$callbackWrapper$1, placement2, adPayload);
        }
    }

    public void renderAd$vungle_ads_release(AdPlayCallback adPlayCallback, Placement placement2, AdPayload adPayload) {
        Context context2;
        Intrinsics.checkNotNullParameter(placement2, "placement");
        Intrinsics.checkNotNullParameter(adPayload, "advertisement");
        AdActivity.Companion.setEventListener$vungle_ads_release(new AdInternal$renderAd$1(adPlayCallback, placement2));
        AdActivity.Companion.setAdvertisement$vungle_ads_release(adPayload);
        AdActivity.Companion.setBidPayload$vungle_ads_release(this.bidPayload);
        WeakReference<Context> weakReference = this.playContext;
        if (weakReference == null || (context2 = (Context) weakReference.get()) == null) {
            context2 = this.context;
        }
        Intrinsics.checkNotNullExpressionValue(context2, "playContext?.get() ?: context");
        ActivityManager.Companion.startWhenForeground(context2, (Intent) null, AdActivity.Companion.createIntent(context2, placement2.getReferenceId(), adPayload.eventId()), (ActivityManager.LeftApplicationCallback) null);
    }

    public void onSuccess(AdPayload adPayload) {
        Intrinsics.checkNotNullParameter(adPayload, "advertisement");
        this.advertisement = adPayload;
        setAdState(AdState.READY);
        adLoadedAndUpdateConfigure$vungle_ads_release(adPayload);
        AdLoaderCallback adLoaderCallback2 = this.adLoaderCallback;
        if (adLoaderCallback2 != null) {
            adLoaderCallback2.onSuccess(adPayload);
        }
        TimeIntervalMetric timeIntervalMetric = this.requestMetric;
        if (timeIntervalMetric != null) {
            timeIntervalMetric.markEnd();
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            Placement placement2 = this.placement;
            AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, timeIntervalMetric, placement2 != null ? placement2.getReferenceId() : null, adPayload.getCreativeId(), adPayload.eventId(), (String) null, 16, (Object) null);
        }
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.checkNotNullParameter(vungleError, "error");
        setAdState(AdState.ERROR);
        AdLoaderCallback adLoaderCallback2 = this.adLoaderCallback;
        if (adLoaderCallback2 != null) {
            adLoaderCallback2.onFailure(vungleError);
        }
    }

    public final boolean isErrorTerminal$vungle_ads_release(int i) {
        return this.adState == AdState.READY && i == 304;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000H&J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState;", "", "(Ljava/lang/String;I)V", "canTransitionTo", "", "adState", "isTerminalState", "transitionTo", "NEW", "LOADING", "READY", "PLAYING", "FINISHED", "ERROR", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdInternal.kt */
    public enum AdState {
        ;

        public abstract boolean canTransitionTo(AdState adState);

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$NEW;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdInternal.kt */
        static final class NEW extends AdState {
            NEW(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }

            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return adState == AdState.LOADING || adState == AdState.READY || adState == AdState.ERROR;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$LOADING;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdInternal.kt */
        static final class LOADING extends AdState {
            LOADING(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }

            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return adState == AdState.READY || adState == AdState.ERROR;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$READY;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdInternal.kt */
        static final class READY extends AdState {
            READY(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }

            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return adState == AdState.PLAYING || adState == AdState.FINISHED || adState == AdState.ERROR;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$PLAYING;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdInternal.kt */
        static final class PLAYING extends AdState {
            PLAYING(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }

            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return adState == AdState.FINISHED || adState == AdState.ERROR;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$FINISHED;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdInternal.kt */
        static final class FINISHED extends AdState {
            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return false;
            }

            FINISHED(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$ERROR;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AdInternal.kt */
        static final class ERROR extends AdState {
            ERROR(String str, int i) {
                super(str, i, (DefaultConstructorMarker) null);
            }

            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return adState == AdState.FINISHED;
            }
        }

        public final AdState transitionTo(AdState adState) {
            Intrinsics.checkNotNullParameter(adState, "adState");
            if (this != adState && !canTransitionTo(adState)) {
                String str = "Cannot transition from " + name() + " to " + adState.name();
                if (!AdInternal.THROW_ON_ILLEGAL_TRANSITION) {
                    Log.e(AdInternal.TAG, "Illegal state transition", new IllegalStateException(str));
                } else {
                    throw new IllegalStateException(str);
                }
            }
            return adState;
        }

        public final boolean isTerminalState() {
            return CollectionsKt.listOf(FINISHED, ERROR).contains(this);
        }
    }
}
