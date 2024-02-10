package com.ironsource.mediationsdk.ads.nativead.internal;

import android.view.View;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayMediaView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/ironsource/mediationsdk/ads/nativead/internal/NativeAdViewHolder;", "", "()V", "advertiserView", "Landroid/view/View;", "getAdvertiserView", "()Landroid/view/View;", "setAdvertiserView", "(Landroid/view/View;)V", "bodyView", "getBodyView", "setBodyView", "callToActionView", "getCallToActionView", "setCallToActionView", "iconView", "getIconView", "setIconView", "mediaView", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayMediaView;", "getMediaView", "()Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayMediaView;", "setMediaView", "(Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayMediaView;)V", "titleView", "getTitleView", "setTitleView", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NativeAdViewHolder {
    private View a;
    private View b;
    private View c;
    private View d;
    private LevelPlayMediaView e;
    private View f;

    public final View getAdvertiserView() {
        return this.b;
    }

    public final View getBodyView() {
        return this.d;
    }

    public final View getCallToActionView() {
        return this.f;
    }

    public final View getIconView() {
        return this.c;
    }

    public final LevelPlayMediaView getMediaView() {
        return this.e;
    }

    public final View getTitleView() {
        return this.a;
    }

    public final void setAdvertiserView(View view) {
        this.b = view;
    }

    public final void setBodyView(View view) {
        this.d = view;
    }

    public final void setCallToActionView(View view) {
        this.f = view;
    }

    public final void setIconView(View view) {
        this.c = view;
    }

    public final void setMediaView(LevelPlayMediaView levelPlayMediaView) {
        this.e = levelPlayMediaView;
    }

    public final void setTitleView(View view) {
        this.a = view;
    }
}
