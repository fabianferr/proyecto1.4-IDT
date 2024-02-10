package com.wortise.ads.renderers.modules;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.AdError;
import com.wortise.ads.AdEvent;
import com.wortise.ads.AdFormat;
import com.wortise.ads.AdResponse;
import com.wortise.ads.device.Dimensions;
import com.wortise.ads.renderers.modules.a;
import com.wortise.ads.v3;
import com.wortise.ads.x3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\f\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/wortise/ads/renderers/modules/d;", "Lcom/wortise/ads/renderers/modules/a;", "Lcom/wortise/ads/v3;", "webView", "", "load", "onDestroy", "onPause", "Landroid/content/Context;", "context", "onRender", "onResume", "com/wortise/ads/renderers/modules/d$b", "webViewListener", "Lcom/wortise/ads/renderers/modules/d$b;", "", "getHtml", "()Ljava/lang/String;", "html", "getUrl", "url", "Landroid/view/View;", "adView", "Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/renderers/modules/a$a;", "listener", "<init>", "(Landroid/view/View;Lcom/wortise/ads/AdResponse;Lcom/wortise/ads/renderers/modules/a$a;)V", "Companion", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: HtmlAdRenderer.kt */
public final class d extends a<v3> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private v3 webView;
    private final b webViewListener = new b(this);

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/wortise/ads/renderers/modules/d$a;", "", "Lcom/wortise/ads/AdResponse;", "response", "", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: HtmlAdRenderer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(AdResponse adResponse) {
            Intrinsics.checkNotNullParameter(adResponse, "response");
            return adResponse.a(AdFormat.HTML);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view, AdResponse adResponse, a.C0192a aVar) {
        super(view, adResponse, aVar);
        Intrinsics.checkNotNullParameter(view, "adView");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    @JvmStatic
    public static final boolean canRender(AdResponse adResponse) {
        return Companion.a(adResponse);
    }

    private final String getHtml() {
        return getAdResponse().f();
    }

    private final String getUrl() {
        return getAdResponse().o();
    }

    private final void load(v3 v3Var) {
        Unit unit;
        String html = getHtml();
        boolean z = false;
        Unit unit2 = null;
        if (html == null || html.length() == 0) {
            html = null;
        }
        String url = getUrl();
        if (url == null || url.length() == 0) {
            z = true;
        }
        if (z) {
            url = null;
        }
        if (html == null) {
            unit = null;
        } else {
            v3Var.loadHtml(html, url);
            unit = Unit.INSTANCE;
        }
        if (unit != null) {
            unit2 = unit;
        } else if (url != null) {
            v3Var.loadUrl(url);
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            deliverError(AdError.NO_FILL);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            v3 v3Var = this.webView;
            if (v3Var != null) {
                v3Var.destroy();
            }
        } finally {
            this.webView = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        v3 v3Var = this.webView;
        if (v3Var != null) {
            v3Var.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onRender(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        v3 a2 = x3.a.a(context, this.webViewListener);
        load(a2);
        Unit unit = Unit.INSTANCE;
        this.webView = a2;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        v3 v3Var = this.webView;
        if (v3Var != null) {
            v3Var.onResume();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"com/wortise/ads/renderers/modules/d$b", "Lcom/wortise/ads/v3$a;", "Lcom/wortise/ads/AdEvent;", "event", "", "onAdEvent", "Lcom/wortise/ads/v3;", "view", "", "url", "a", "b", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: HtmlAdRenderer.kt */
    public static final class b implements v3.a {
        final /* synthetic */ d a;

        b(d dVar) {
            this.a = dVar;
        }

        public void a(v3 v3Var, String str) {
            Intrinsics.checkNotNullParameter(v3Var, "view");
            Intrinsics.checkNotNullParameter(str, "url");
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            this.a.deliverClick(true, bundle);
        }

        public void b(v3 v3Var) {
            Intrinsics.checkNotNullParameter(v3Var, "view");
            this.a.deliverError(AdError.RENDER_PROCESS_GONE);
        }

        public void onAdEvent(AdEvent adEvent) {
            Intrinsics.checkNotNullParameter(adEvent, "event");
            this.a.deliverEvent(adEvent);
        }

        public void a(v3 v3Var) {
            Intrinsics.checkNotNullParameter(v3Var, "view");
            a.deliverView$default(this.a, v3Var, (Dimensions) null, 2, (Object) null);
        }
    }
}
