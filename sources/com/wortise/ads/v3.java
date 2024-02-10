package com.wortise.ads;

import android.content.Context;
import android.net.Uri;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.share.internal.ShareConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\r\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0010H\u0017J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002R\u001b\u0010!\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010/R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00109\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00118\u0006@BX\u000e¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/wortise/ads/v3;", "Landroid/webkit/WebView;", "", "url", "", "a", "Lcom/wortise/ads/AdEvent;", "event", "onAdEvent$sdk_productionRelease", "(Lcom/wortise/ads/AdEvent;)V", "onAdEvent", "onReady$sdk_productionRelease", "()V", "onReady", "onRenderProcessGone$sdk_productionRelease", "onRenderProcessGone", "Landroid/view/MotionEvent;", "", "onTouchEvent", "Landroid/net/Uri;", "uri", "handleUrl$sdk_productionRelease", "(Landroid/net/Uri;)V", "handleUrl", "destroy", "html", "baseUrl", "loadHtml", "Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector", "Lcom/wortise/ads/o4;", "jsInterface$delegate", "getJsInterface", "()Lcom/wortise/ads/o4;", "jsInterface", "Lcom/wortise/ads/t3;", "webChromeClient$delegate", "getWebChromeClient", "()Lcom/wortise/ads/t3;", "webChromeClient", "Lcom/wortise/ads/w3;", "webViewClient$delegate", "getWebViewClient", "()Lcom/wortise/ads/w3;", "webViewClient", "Lcom/wortise/ads/v3$a;", "listener", "Lcom/wortise/ads/v3$a;", "getListener", "()Lcom/wortise/ads/v3$a;", "setListener", "(Lcom/wortise/ads/v3$a;)V", "<set-?>", "wasClicked", "Z", "getWasClicked", "()Z", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: HtmlWebView.kt */
public final class v3 extends WebView {
    private final Lazy a;
    private final Lazy b = LazyKt.lazy(new d(this));
    private final Lazy c = LazyKt.lazy(e.a);
    private final Lazy d = LazyKt.lazy(f.a);
    private a e;
    /* access modifiers changed from: private */
    public boolean f;
    /* access modifiers changed from: private */
    public final c g;

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\f"}, d2 = {"Lcom/wortise/ads/v3$a;", "", "Lcom/wortise/ads/AdEvent;", "event", "", "onAdEvent", "Lcom/wortise/ads/v3;", "view", "", "url", "a", "b", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: HtmlWebView.kt */
    public interface a {
        void a(v3 v3Var);

        void a(v3 v3Var, String str);

        void b(v3 v3Var);

        void onAdEvent(AdEvent adEvent);
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/view/GestureDetector;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: HtmlWebView.kt */
    static final class b extends Lambda implements Function0<GestureDetector> {
        final /* synthetic */ Context a;
        final /* synthetic */ v3 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, v3 v3Var) {
            super(0);
            this.a = context;
            this.b = v3Var;
        }

        /* renamed from: a */
        public final GestureDetector invoke() {
            return new GestureDetector(this.a, this.b.g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/wortise/ads/v3$c", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapUp", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: HtmlWebView.kt */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ v3 a;

        c(v3 v3Var) {
            this.a = v3Var;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.a.f = true;
            return true;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/o4;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: HtmlWebView.kt */
    static final class d extends Lambda implements Function0<o4> {
        final /* synthetic */ v3 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(v3 v3Var) {
            super(0);
            this.a = v3Var;
        }

        /* renamed from: a */
        public final o4 invoke() {
            return new o4(this.a);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/t3;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: HtmlWebView.kt */
    static final class e extends Lambda implements Function0<t3> {
        public static final e a = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final t3 invoke() {
            return new t3();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/w3;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: HtmlWebView.kt */
    static final class f extends Lambda implements Function0<w3> {
        public static final f a = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final w3 invoke() {
            return new w3();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v3(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt.lazy(new b(context, this));
        a();
        this.g = new c(this);
    }

    private final void a(String str) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.a(this, str);
        }
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.a.getValue();
    }

    private final o4 getJsInterface() {
        return (o4) this.b.getValue();
    }

    private final t3 getWebChromeClient() {
        return (t3) this.c.getValue();
    }

    private final w3 getWebViewClient() {
        return (w3) this.d.getValue();
    }

    public static /* synthetic */ void loadHtml$default(v3 v3Var, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        v3Var.loadHtml(str, str2);
    }

    public void destroy() {
        super.destroy();
        y6.a(this);
        removeAllViews();
    }

    public final a getListener() {
        return this.e;
    }

    public final boolean getWasClicked() {
        return this.f;
    }

    public final void handleUrl$sdk_productionRelease(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        if (p6.a(uri, "wortise")) {
            AdEvent a2 = AdEvent.Companion.a(uri);
            if (a2 != null) {
                onAdEvent$sdk_productionRelease(a2);
                return;
            }
            return;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        a(uri2);
    }

    public final void onAdEvent$sdk_productionRelease(AdEvent adEvent) {
        Intrinsics.checkNotNullParameter(adEvent, "event");
        a aVar = this.e;
        if (aVar != null) {
            aVar.onAdEvent(adEvent);
        }
    }

    public final void onReady$sdk_productionRelease() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void onRenderProcessGone$sdk_productionRelease() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        this.f = false;
        getGestureDetector().onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public final void setListener(a aVar) {
        this.e = aVar;
    }

    private final void a() {
        setBackgroundColor(0);
        setWebChromeClient(getWebChromeClient());
        setWebViewClient(getWebViewClient());
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
        settings.setSupportZoom(false);
        addJavascriptInterface(getJsInterface(), "Wortise");
    }

    public final void loadHtml(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "html");
        if (str2 == null) {
            loadData(str, "text/html", "utf-8");
        } else {
            loadDataWithBaseURL(str2, str, "text/html", "utf-8", (String) null);
        }
    }
}
