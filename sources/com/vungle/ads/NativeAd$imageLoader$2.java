package com.vungle.ads;

import com.vungle.ads.internal.util.ImageLoader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/vungle/ads/internal/util/ImageLoader;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NativeAd.kt */
final class NativeAd$imageLoader$2 extends Lambda implements Function0<ImageLoader> {
    final /* synthetic */ NativeAd this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NativeAd$imageLoader$2(NativeAd nativeAd) {
        super(0);
        this.this$0 = nativeAd;
    }

    public final ImageLoader invoke() {
        ImageLoader instance = ImageLoader.Companion.getInstance();
        instance.init(this.this$0.getExecutors().getIoExecutor());
        return instance;
    }
}
