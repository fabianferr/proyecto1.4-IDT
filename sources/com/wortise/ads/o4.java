package com.wortise.ads;

import android.net.Uri;
import android.webkit.JavascriptInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0002H\u0007¨\u0006\f"}, d2 = {"Lcom/wortise/ads/o4;", "", "", "close", "", "url", "open", "showClose", "Lcom/wortise/ads/v3;", "webView", "<init>", "(Lcom/wortise/ads/v3;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: JsInterface.kt */
public final class o4 {
    private final v3 a;

    public o4(v3 v3Var) {
        Intrinsics.checkNotNullParameter(v3Var, "webView");
        this.a = v3Var;
    }

    @JavascriptInterface
    public final void close() {
        this.a.onAdEvent$sdk_productionRelease(AdEvent.CLOSE);
    }

    @JavascriptInterface
    public final void open(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Uri b = h6.b(str);
        if (b != null) {
            this.a.handleUrl$sdk_productionRelease(b);
        }
    }

    @JavascriptInterface
    public final void showClose() {
        this.a.onAdEvent$sdk_productionRelease(AdEvent.SHOW_CLOSE);
    }
}
