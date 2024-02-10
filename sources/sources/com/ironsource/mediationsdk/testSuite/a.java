package com.ironsource.mediationsdk.testSuite;

import android.app.Activity;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0016\u001a\u00020\u0010J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J&\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010$\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020\u0010J\u0006\u0010&\u001a\u00020\u0010R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00030\u00030\rX\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/TestSuiteAdsManager;", "", "activity", "Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;", "handler", "Landroid/os/Handler;", "(Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;Landroid/os/Handler;)V", "mBannerContainer", "Landroid/widget/RelativeLayout;", "mBannerLayout", "Lcom/ironsource/mediationsdk/IronSourceBannerLayout;", "mHandler", "mTestSuiteActivityWeakReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "addBannerAdToScreen", "", "marginPercentageFromTop", "", "createBannerContainer", "createBannerLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "destroyBannerAd", "getActivity", "isInterstitialReady", "", "isRewardedVideoReady", "loadBannerAd", "loadAdConfig", "Lcom/ironsource/mediationsdk/testSuite/TestSuiteLoadAdConfig;", "description", "", "width", "", "height", "loadInterstitialAd", "loadRewardedVideoAd", "showInterstitialAd", "showRewardedVideoAd", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {
    public final WeakReference<TestSuiteActivity> a;
    private final Handler b;
    private RelativeLayout c;
    private IronSourceBannerLayout d;

    public a(TestSuiteActivity testSuiteActivity, Handler handler) {
        Intrinsics.checkNotNullParameter(testSuiteActivity, "activity");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.a = new WeakReference<>(testSuiteActivity);
        this.b = handler;
    }

    /* access modifiers changed from: private */
    public static final void a(a aVar) {
        RelativeLayout container;
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        RelativeLayout relativeLayout = aVar.c;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        TestSuiteActivity b2 = aVar.b();
        if (!(b2 == null || (container = b2.getContainer()) == null)) {
            container.removeView(aVar.c);
        }
        aVar.c = null;
    }

    /* access modifiers changed from: private */
    public static final void a(a aVar, TestSuiteActivity testSuiteActivity) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        RelativeLayout relativeLayout = aVar.c;
        if (relativeLayout != null) {
            relativeLayout.addView(aVar.d);
        }
        testSuiteActivity.getContainer().addView(aVar.c);
    }

    private final TestSuiteActivity b() {
        return (TestSuiteActivity) this.a.get();
    }

    public final void a() {
        if (this.d != null) {
            d dVar = d.a;
            d.b(this.d);
        }
        this.b.post(new a$$ExternalSyntheticLambda0(this));
        this.d = null;
    }

    public final void a(double d2) {
        if (this.c == null) {
            IronSourceBannerLayout ironSourceBannerLayout = this.d;
            if (ironSourceBannerLayout != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                d dVar = d.a;
                double d3 = (double) d.d();
                Double.isNaN(d3);
                layoutParams.topMargin = (int) (d3 * d2);
                ironSourceBannerLayout.setLayoutParams(layoutParams);
            }
            TestSuiteActivity b2 = b();
            if (b2 != null) {
                RelativeLayout relativeLayout = new RelativeLayout(b2);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.c = relativeLayout;
                this.b.post(new a$$ExternalSyntheticLambda1(this, b2));
            }
        }
    }

    public final void a(c cVar, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(cVar, "loadAdConfig");
        Intrinsics.checkNotNullParameter(str, "description");
        a();
        d dVar = d.a;
        d.a(IronSource.AD_UNIT.BANNER, cVar);
        TestSuiteActivity b2 = b();
        if (b2 != null) {
            d dVar2 = d.a;
            d dVar3 = d.a;
            this.d = d.a((Activity) b2, d.a(str, i, i2));
            d dVar4 = d.a;
            d.a(this.d);
        }
    }
}
