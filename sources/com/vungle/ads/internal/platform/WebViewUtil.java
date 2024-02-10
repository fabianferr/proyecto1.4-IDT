package com.vungle.ads.internal.platform;

import android.content.Context;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.webkit.WebSettings;
import androidx.core.util.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vungle/ads/internal/platform/WebViewUtil;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getUserAgent", "", "consumer", "Landroidx/core/util/Consumer;", "", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WebViewUtil.kt */
public final class WebViewUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "WebViewUtil";
    private final Context context;

    public WebViewUtil(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/platform/WebViewUtil$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WebViewUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void getUserAgent(Consumer<String> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        try {
            consumer.accept(WebSettings.getDefaultUserAgent(this.context));
        } catch (Exception e) {
            if (e instanceof AndroidRuntimeException) {
                Log.e(TAG, "WebView could be missing here");
            }
            consumer.accept(null);
        }
    }
}
