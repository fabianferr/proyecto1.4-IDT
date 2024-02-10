package com.vungle.ads;

import android.view.View;
import com.vungle.ads.internal.ImpressionTracker;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NativeAd$$ExternalSyntheticLambda2 implements ImpressionTracker.ImpressionListener {
    public final /* synthetic */ NativeAd f$0;

    public /* synthetic */ NativeAd$$ExternalSyntheticLambda2(NativeAd nativeAd) {
        this.f$0 = nativeAd;
    }

    public final void onImpression(View view) {
        NativeAd.m2263registerViewForInteraction$lambda4(this.f$0, view);
    }
}
