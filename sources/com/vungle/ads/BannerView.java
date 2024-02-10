package com.vungle.ads;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.ImpressionTracker;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.omsdk.OMTracker;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.ui.VungleWebClient;
import com.vungle.ads.internal.ui.WatermarkView;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import com.vungle.ads.internal.util.ViewUtility;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020!J\b\u0010(\u001a\u00020&H\u0014J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0014H\u0014J\b\u0010+\u001a\u00020&H\u0002J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020!H\u0002R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006/²\u0006\n\u00100\u001a\u000201X\u0002²\u0006\n\u00102\u001a\u000203X\u0002"}, d2 = {"Lcom/vungle/ads/BannerView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "placement", "Lcom/vungle/ads/internal/model/Placement;", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "adSize", "Lcom/vungle/ads/BannerAdSize;", "adConfig", "Lcom/vungle/ads/AdConfig;", "adPlayCallback", "Lcom/vungle/ads/internal/presenter/AdPlayCallback;", "bidPayload", "Lcom/vungle/ads/internal/model/BidPayload;", "(Landroid/content/Context;Lcom/vungle/ads/internal/model/Placement;Lcom/vungle/ads/internal/model/AdPayload;Lcom/vungle/ads/BannerAdSize;Lcom/vungle/ads/AdConfig;Lcom/vungle/ads/internal/presenter/AdPlayCallback;Lcom/vungle/ads/internal/model/BidPayload;)V", "adWidget", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget;", "calculatedPixelHeight", "", "calculatedPixelWidth", "destroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "imageView", "Lcom/vungle/ads/internal/ui/WatermarkView;", "impressionTracker", "Lcom/vungle/ads/internal/ImpressionTracker;", "getImpressionTracker", "()Lcom/vungle/ads/internal/ImpressionTracker;", "impressionTracker$delegate", "Lkotlin/Lazy;", "isOnImpressionCalled", "", "presenter", "Lcom/vungle/ads/internal/presenter/MRAIDPresenter;", "presenterStarted", "finishAdInternal", "", "isFinishedByApi", "onAttachedToWindow", "onWindowVisibilityChanged", "visibility", "renderAd", "setAdVisibility", "isVisible", "Companion", "vungle-ads_release", "executors", "Lcom/vungle/ads/internal/executor/Executors;", "omTrackerFactory", "Lcom/vungle/ads/internal/omsdk/OMTracker$Factory;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BannerView.kt */
public final class BannerView extends RelativeLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "BannerView";
    private MRAIDAdWidget adWidget;
    private int calculatedPixelHeight;
    private int calculatedPixelWidth;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private WatermarkView imageView;
    private final Lazy impressionTracker$delegate;
    private boolean isOnImpressionCalled;
    private MRAIDPresenter presenter;
    private final AtomicBoolean presenterStarted = new AtomicBoolean(false);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerView(Context context, Placement placement, AdPayload adPayload, BannerAdSize bannerAdSize, AdConfig adConfig, AdPlayCallback adPlayCallback, BidPayload bidPayload) throws InstantiationException {
        super(context);
        Context context2 = context;
        Placement placement2 = placement;
        AdPayload adPayload2 = adPayload;
        AdPlayCallback adPlayCallback2 = adPlayCallback;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(adPayload2, "advertisement");
        Intrinsics.checkNotNullParameter(bannerAdSize, "adSize");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(adPlayCallback2, "adPlayCallback");
        boolean z = false;
        this.impressionTracker$delegate = LazyKt.lazy(new BannerView$impressionTracker$2(context));
        this.calculatedPixelHeight = ViewUtility.INSTANCE.dpToPixels(context, bannerAdSize.getHeight());
        this.calculatedPixelWidth = ViewUtility.INSTANCE.dpToPixels(context, bannerAdSize.getWidth());
        BannerView$adEventListener$1 bannerView$adEventListener$1 = new BannerView$adEventListener$1(adPlayCallback2, placement);
        try {
            MRAIDAdWidget mRAIDAdWidget = new MRAIDAdWidget(context);
            this.adWidget = mRAIDAdWidget;
            mRAIDAdWidget.setCloseDelegate(new MRAIDAdWidget.CloseDelegate(this) {
                final /* synthetic */ BannerView this$0;

                {
                    this.this$0 = r1;
                }

                public void close() {
                    this.this$0.finishAdInternal(false);
                }
            });
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new BannerView$special$$inlined$inject$1(context));
            ServiceLocator.Companion companion2 = ServiceLocator.Companion;
            OMTracker.Factory r6 = m2259_init_$lambda3(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new BannerView$special$$inlined$inject$2(context)));
            if (ConfigManager.INSTANCE.omEnabled() && adPayload.omEnabled()) {
                z = true;
            }
            OMTracker make = r6.make(z);
            VungleWebClient vungleWebClient = new VungleWebClient(adPayload2, placement, m2258_init_$lambda2(lazy).getOffloadExecutor());
            vungleWebClient.setWebViewObserver(make);
            MRAIDPresenter mRAIDPresenter = new MRAIDPresenter(mRAIDAdWidget, adPayload, placement, vungleWebClient, m2258_init_$lambda2(lazy).getJobExecutor(), make, bidPayload);
            mRAIDPresenter.setEventListener(bannerView$adEventListener$1);
            this.presenter = mRAIDPresenter;
            String watermark$vungle_ads_release = adConfig.getWatermark$vungle_ads_release();
            if (watermark$vungle_ads_release != null) {
                this.imageView = new WatermarkView(context, watermark$vungle_ads_release);
            }
        } catch (InstantiationException e) {
            AdCantPlayWithoutWebView adCantPlayWithoutWebView = new AdCantPlayWithoutWebView();
            adCantPlayWithoutWebView.setPlacementId$vungle_ads_release(placement.getReferenceId());
            adCantPlayWithoutWebView.setEventId$vungle_ads_release(adPayload.eventId());
            adCantPlayWithoutWebView.setCreativeId$vungle_ads_release(adPayload.getCreativeId());
            bannerView$adEventListener$1.onError(adCantPlayWithoutWebView.logError$vungle_ads_release(), placement.getReferenceId());
            throw e;
        }
    }

    private final ImpressionTracker getImpressionTracker() {
        return (ImpressionTracker) this.impressionTracker$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        setAdVisibility(i == 0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "onAttachedToWindow()");
        if (!this.presenterStarted.getAndSet(true)) {
            MRAIDPresenter mRAIDPresenter = this.presenter;
            if (mRAIDPresenter != null) {
                mRAIDPresenter.prepare();
            }
            MRAIDPresenter mRAIDPresenter2 = this.presenter;
            if (mRAIDPresenter2 != null) {
                mRAIDPresenter2.start();
            }
            getImpressionTracker().addView(this, new BannerView$$ExternalSyntheticLambda0(this));
        }
        renderAd();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-0  reason: not valid java name */
    public static final void m2260onAttachedToWindow$lambda0(BannerView bannerView, View view) {
        Intrinsics.checkNotNullParameter(bannerView, "this$0");
        Log.d(TAG, "ImpressionTracker checked the banner view become visible.");
        boolean z = true;
        bannerView.isOnImpressionCalled = true;
        if (bannerView.getVisibility() != 0) {
            z = false;
        }
        bannerView.setAdVisibility(z);
    }

    private final void setAdVisibility(boolean z) {
        MRAIDPresenter mRAIDPresenter;
        if (this.isOnImpressionCalled && !this.destroyed.get() && (mRAIDPresenter = this.presenter) != null) {
            mRAIDPresenter.setAdVisibility(z);
        }
    }

    public final void finishAdInternal(boolean z) {
        if (!this.destroyed.get()) {
            this.destroyed.set(true);
            int i = (z ? 4 : 0) | 2;
            MRAIDPresenter mRAIDPresenter = this.presenter;
            if (mRAIDPresenter != null) {
                mRAIDPresenter.stop();
            }
            MRAIDPresenter mRAIDPresenter2 = this.presenter;
            if (mRAIDPresenter2 != null) {
                mRAIDPresenter2.detach(i);
            }
            getImpressionTracker().destroy();
            try {
                removeAllViews();
            } catch (Exception e) {
                Log.d(TAG, "Removing webView error: " + e);
            }
        }
    }

    private final void renderAd() {
        if (getVisibility() == 0) {
            MRAIDAdWidget mRAIDAdWidget = this.adWidget;
            if (mRAIDAdWidget != null) {
                if (!Intrinsics.areEqual((Object) mRAIDAdWidget != null ? mRAIDAdWidget.getParent() : null, (Object) this)) {
                    addView(this.adWidget, this.calculatedPixelWidth, this.calculatedPixelHeight);
                    WatermarkView watermarkView = this.imageView;
                    if (watermarkView != null) {
                        addView(watermarkView, this.calculatedPixelWidth, this.calculatedPixelHeight);
                        WatermarkView watermarkView2 = this.imageView;
                        if (watermarkView2 != null) {
                            watermarkView2.bringToFront();
                        }
                    }
                }
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = this.calculatedPixelHeight;
                layoutParams.width = this.calculatedPixelWidth;
                requestLayout();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/BannerView$Companion;", "", "()V", "TAG", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BannerView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: _init_$lambda-2  reason: not valid java name */
    private static final Executors m2258_init_$lambda2(Lazy<? extends Executors> lazy) {
        return (Executors) lazy.getValue();
    }

    /* renamed from: _init_$lambda-3  reason: not valid java name */
    private static final OMTracker.Factory m2259_init_$lambda3(Lazy<OMTracker.Factory> lazy) {
        return lazy.getValue();
    }
}
