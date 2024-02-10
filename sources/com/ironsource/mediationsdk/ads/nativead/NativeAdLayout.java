package com.ironsource.mediationsdk.ads.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdViewBinderInterface;
import com.ironsource.mediationsdk.ads.nativead.internal.NativeAdViewHolder;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ironsource/mediationsdk/ads/nativead/NativeAdLayout;", "Landroid/widget/FrameLayout;", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdViewBinderInterface;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mAdViewHolder", "Lcom/ironsource/mediationsdk/ads/nativead/internal/NativeAdViewHolder;", "addAllViews", "", "viewGroup", "Landroid/view/ViewGroup;", "views", "", "Landroid/view/View;", "getAllChildViews", "setAdvertiserView", "view", "setBodyView", "setCallToActionView", "setIconView", "setMediaView", "mediaView", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayMediaView;", "setNativeAd", "nativeAd", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd;", "setTitleView", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NativeAdLayout extends FrameLayout implements NativeAdViewBinderInterface {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final NativeAdViewHolder a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeAdLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new NativeAdViewHolder();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeAdLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new NativeAdViewHolder();
    }

    private static void a(ViewGroup viewGroup, List<? extends View> list) {
        for (View addView : list) {
            viewGroup.addView(addView);
        }
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void setAdvertiserView(View view) {
        this.a.setAdvertiserView(view);
    }

    public final void setBodyView(View view) {
        this.a.setBodyView(view);
    }

    public final void setCallToActionView(View view) {
        this.a.setCallToActionView(view);
    }

    public final void setIconView(View view) {
        this.a.setIconView(view);
    }

    public final void setMediaView(LevelPlayMediaView levelPlayMediaView) {
        this.a.setMediaView(levelPlayMediaView);
    }

    public final void setNativeAd(LevelPlayNativeAd levelPlayNativeAd) {
        Intrinsics.checkNotNullParameter(levelPlayNativeAd, "nativeAd");
        ViewGroup viewGroup = this;
        List arrayList = new ArrayList();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "child");
            arrayList.add(childAt);
        }
        removeAllViews();
        ViewGroup frameLayout = new FrameLayout(getContext());
        a(frameLayout, arrayList);
        AdapterNativeAdViewBinder nativeAdViewBinder = levelPlayNativeAd.getNativeAdViewBinder();
        if (nativeAdViewBinder != null) {
            nativeAdViewBinder.setBodyView(this.a.getBodyView());
            nativeAdViewBinder.setMediaView(this.a.getMediaView());
            nativeAdViewBinder.setCallToActionView(this.a.getCallToActionView());
            nativeAdViewBinder.setTitleView(this.a.getTitleView());
            nativeAdViewBinder.setIconView(this.a.getIconView());
            nativeAdViewBinder.setAdvertiserView(this.a.getAdvertiserView());
            nativeAdViewBinder.setNativeAdView(frameLayout);
            addView(nativeAdViewBinder.getNetworkNativeAdView());
        }
    }

    public final void setTitleView(View view) {
        this.a.setTitleView(view);
    }
}
