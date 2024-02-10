package com.bytedance.sdk.openadsdk.apiImpl.feed;

import android.view.View;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.core.model.q;

/* compiled from: PAGNativeAdDataImpl */
public class d implements PAGNativeAdData {
    private final a a;

    public d(a aVar) {
        this.a = aVar;
    }

    public PAGImageItem getIcon() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public String getTitle() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public String getDescription() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    public String getButtonText() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.f();
        }
        return null;
    }

    public PAGMediaView getMediaView() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.g();
        }
        return null;
    }

    public View getAdLogoView() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.j();
        }
        return null;
    }

    public PAGNativeAdData.PAGNativeMediaType getMediaType() {
        if (q.c(this.a.a)) {
            return PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeVideo;
        }
        return PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeImage;
    }

    public View getAdChoicesView() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.k();
        }
        return null;
    }
}
