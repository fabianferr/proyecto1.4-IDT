package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.AdInternal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/vungle/ads/FullscreenAdInternal;", "Lcom/vungle/ads/internal/AdInternal;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getAdSizeForAdRequest", "", "isValidAdSize", "", "adSize", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BaseFullscreenAd.kt */
public abstract class FullscreenAdInternal extends AdInternal {
    public String getAdSizeForAdRequest() {
        return "unknown";
    }

    public boolean isValidAdSize(String str) {
        Intrinsics.checkNotNullParameter(str, "adSize");
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FullscreenAdInternal(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
