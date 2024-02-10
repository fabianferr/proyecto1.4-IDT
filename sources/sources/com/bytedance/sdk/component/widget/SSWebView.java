package com.bytedance.sdk.component.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class SSWebView extends FrameLayout {
    private static c x;
    private com.bytedance.sdk.component.widget.b.a a;
    private String b;
    private JSONObject c;
    private boolean d;
    private float e;
    private float f;
    private long g;
    private long h;
    private long i;
    private boolean j;
    private volatile WebView k;
    private float l;
    private float m;
    private float n;
    private int o;
    private b p;
    private t q;
    private AttributeSet r;
    private Context s;
    private AtomicBoolean t;
    private AtomicBoolean u;
    private AtomicBoolean v;
    private d w;
    private long y;
    private long z;

    public interface b {
    }

    public interface c {
        WebView createWebView(Context context, AttributeSet attributeSet, int i);
    }

    public interface d {
        void a(boolean z);
    }

    public SSWebView(Context context) {
        this(a(context), false);
    }

    public SSWebView(Context context, boolean z2) {
        super(a(context));
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.l = 20.0f;
        this.n = 50.0f;
        this.t = new AtomicBoolean();
        this.u = new AtomicBoolean();
        this.v = new AtomicBoolean();
        this.s = context;
        if (!z2) {
            try {
                this.k = a((AttributeSet) null, 0);
                b();
            } catch (Throwable unused) {
            }
            b(a(context));
        }
    }

    private static Context a(Context context) {
        return (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    private WebView a(AttributeSet attributeSet, int i2) {
        c cVar = x;
        return cVar != null ? cVar.createWebView(getContext(), attributeSet, i2) : attributeSet == null ? new WebView(a(this.s)) : new WebView(a(this.s), attributeSet);
    }

    private void a(MotionEvent motionEvent) {
        if (this.d && this.a != null) {
            if ((this.b != null || this.c != null) && motionEvent != null) {
                try {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        this.e = motionEvent.getRawX();
                        this.f = motionEvent.getRawY();
                        this.g = System.currentTimeMillis();
                        this.c = new JSONObject();
                        if (this.k != null) {
                            this.y = this.g;
                        }
                    } else if (action == 1 || action == 3) {
                        this.c.put("start_x", String.valueOf(this.e));
                        this.c.put("start_y", String.valueOf(this.f));
                        this.c.put("offset_x", String.valueOf(motionEvent.getRawX() - this.e));
                        this.c.put("offset_y", String.valueOf(motionEvent.getRawY() - this.f));
                        this.c.put("url", String.valueOf(getUrl()));
                        this.c.put(ViewHierarchyConstants.TAG_KEY, "");
                        this.h = System.currentTimeMillis();
                        if (this.k != null) {
                            this.z = this.h;
                        }
                        this.c.put("down_time", this.g);
                        this.c.put("up_time", this.h);
                        if (com.bytedance.sdk.component.widget.a.a.a().b() != null) {
                            long j2 = this.i;
                            long j3 = this.g;
                            if (j2 != j3) {
                                this.i = j3;
                                com.bytedance.sdk.component.widget.a.a.a().b().a(this.a, this.b, "in_web_click", this.c, this.h - this.g);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private void b(Context context) {
        c(context);
        p();
        o();
    }

    private static boolean b(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (loadClass != null && loadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            return loadClass2 != null && loadClass2.isInstance(view);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    private static void c(Context context) {
    }

    private static boolean c(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (loadClass != null && loadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            return loadClass2 != null && loadClass2.isInstance(view);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    private void o() {
        if (this.k != null) {
            try {
                this.k.removeJavascriptInterface("searchBoxJavaBridge_");
                this.k.removeJavascriptInterface("accessibility");
                this.k.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
            }
        }
    }

    private void p() {
        try {
            WebSettings settings = this.k.getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    private void q() {
        if (this.q == null) {
            this.v.set(false);
            this.q = new t(getContext());
        }
        this.q.a(this.l);
        this.q.c(this.m);
        this.q.b(this.n);
        this.q.a(this.o);
        this.q.a((t.a) new t.a() {
        });
        this.v.set(true);
        this.q.a();
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            WebView.setDataDirectorySuffix(str);
        }
    }

    private void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (!TextUtils.isEmpty(str) && (settings = this.k.getSettings()) != null) {
                settings.setJavaScriptEnabled(!Uri.parse(str).getScheme().equals(ShareInternalUtility.STAGING_PARAM));
            }
        } catch (Throwable unused) {
        }
    }

    public static void setWebViewProvider(c cVar) {
        x = cVar;
    }

    /* access modifiers changed from: protected */
    public ViewParent a(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (b(view2) || c(view2)) ? parent : a(view2);
    }

    public void a(Object obj, String str) {
        try {
            this.k.addJavascriptInterface(obj, str);
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        try {
            setJavaScriptEnabled(str);
            this.k.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Map<String, String> map) {
        try {
            setJavaScriptEnabled(str);
            this.k.loadUrl(str, map);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z2) {
        try {
            this.k.clearCache(z2);
        } catch (Throwable unused) {
        }
    }

    public void a_(String str) {
        try {
            setJavaScriptEnabled(str);
            this.k.loadUrl(str);
        } catch (Throwable unused) {
        }
    }

    public void b() {
        if (this.k != null) {
            removeAllViews();
            setBackground((Drawable) null);
            try {
                this.k.setId(520093704);
            } catch (Throwable unused) {
            }
            addView(this.k, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void b_(String str) {
        try {
            this.k.removeJavascriptInterface(str);
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            this.k.stopLoading();
        } catch (Throwable unused) {
        }
    }

    public void c_() {
        try {
            this.k = a(this.r, 0);
            b();
            b(a(this.s));
        } catch (Throwable th) {
            l.e("SSWebView.TAG", "initWebview: " + th.getMessage());
        }
    }

    public void computeScroll() {
        if (this.k != null) {
            try {
                this.k.computeScroll();
            } catch (Throwable unused) {
            }
        }
    }

    public void d() {
        try {
            this.k.reload();
        } catch (Throwable unused) {
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        d dVar = this.w;
        if (dVar != null) {
            dVar.a(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean e() {
        if (this.k == null) {
            return false;
        }
        try {
            return this.k.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void f() {
        try {
            this.k.goBack();
        } catch (Throwable unused) {
        }
    }

    public boolean g() {
        if (this.k == null) {
            return false;
        }
        try {
            return this.k.canGoForward();
        } catch (Throwable unused) {
            return false;
        }
    }

    public int getContentHeight() {
        if (this.k == null) {
            return 0;
        }
        try {
            return this.k.getContentHeight();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public long getLandingPageClickBegin() {
        return this.y;
    }

    public long getLandingPageClickEnd() {
        return this.z;
    }

    public com.bytedance.sdk.component.widget.b.a getMaterialMeta() {
        return this.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        r2 = r4.k.getUrl();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getOriginalUrl() {
        /*
            r4 = this;
            android.webkit.WebView r0 = r4.k
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            android.webkit.WebView r0 = r4.k     // Catch:{ all -> 0x0028 }
            java.lang.String r0 = r0.getOriginalUrl()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0027
            java.lang.String r2 = "data:text/html"
            boolean r2 = r0.startsWith(r2)     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0027
            android.webkit.WebView r2 = r4.k     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = r2.getUrl()     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0027
            java.lang.String r3 = "file://"
            boolean r1 = r2.startsWith(r3)     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0027
            r0 = r2
        L_0x0027:
            return r0
        L_0x0028:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.SSWebView.getOriginalUrl():java.lang.String");
    }

    public int getProgress() {
        if (this.k == null) {
            return 0;
        }
        try {
            return this.k.getProgress();
        } catch (Throwable unused) {
            return 100;
        }
    }

    public String getTag() {
        return this.b;
    }

    public String getUrl() {
        if (this.k == null) {
            return null;
        }
        try {
            return this.k.getUrl();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getUserAgentString() {
        if (this.k == null) {
            return "";
        }
        try {
            return this.k.getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public WebView getWebView() {
        return this.k;
    }

    public void h() {
        try {
            this.k.goForward();
        } catch (Throwable unused) {
        }
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void i() {
        if (this.k != null) {
            this.k.onResume();
        }
    }

    public void j() {
        try {
            this.k.clearHistory();
        } catch (Throwable unused) {
        }
    }

    public void k() {
        if (this.k != null) {
            try {
                this.k.onPause();
                d dVar = this.w;
                if (dVar != null) {
                    dVar.a(false);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void l() {
        if (this.k != null) {
            try {
                this.k.destroy();
            } catch (Throwable unused) {
            }
        }
    }

    public void m() {
        try {
            this.k.clearView();
        } catch (Throwable unused) {
        }
    }

    public void n() {
        try {
            this.k.pauseTimers();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.t.set(true);
        if (this.u.get() && !this.v.get()) {
            q();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.t.set(false);
        t tVar = this.q;
        if (tVar != null) {
            tVar.b();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent a2;
        try {
            a(motionEvent);
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.j && (a2 = a((View) this)) != null) {
                a2.requestDisallowInterceptTouchEvent(true);
            }
            return onInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        t tVar = this.q;
        if (tVar == null) {
            return;
        }
        if (z2) {
            tVar.a();
        } else {
            tVar.b();
        }
    }

    public void removeAllViews() {
        try {
            this.k.removeAllViews();
        } catch (Throwable unused) {
        }
    }

    public void setAllowFileAccess(boolean z2) {
        try {
            this.k.getSettings().setAllowFileAccess(z2);
        } catch (Throwable unused) {
        }
    }

    public void setAlpha(float f2) {
        try {
            super.setAlpha(f2);
            this.k.setAlpha(f2);
        } catch (Throwable unused) {
        }
    }

    public void setAppCacheEnabled(boolean z2) {
        try {
            this.k.getSettings().setAppCacheEnabled(z2);
        } catch (Throwable unused) {
        }
    }

    public void setBackgroundColor(int i2) {
        try {
            this.k.setBackgroundColor(i2);
        } catch (Throwable unused) {
        }
    }

    public void setBuiltInZoomControls(boolean z2) {
        try {
            this.k.getSettings().setBuiltInZoomControls(z2);
        } catch (Throwable unused) {
        }
    }

    public void setCacheMode(int i2) {
        try {
            this.k.getSettings().setCacheMode(i2);
        } catch (Throwable unused) {
        }
    }

    public void setCalculationMethod(int i2) {
        this.o = i2;
    }

    public void setDatabaseEnabled(boolean z2) {
        try {
            this.k.getSettings().setDatabaseEnabled(z2);
        } catch (Throwable unused) {
        }
    }

    public void setDeepShakeValue(float f2) {
        this.m = f2;
    }

    public void setDefaultFontSize(int i2) {
        try {
            this.k.getSettings().setDefaultFontSize(i2);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultTextEncodingName(String str) {
        try {
            this.k.getSettings().setDefaultTextEncodingName(str);
        } catch (Throwable unused) {
        }
    }

    public void setDisplayZoomControls(boolean z2) {
        try {
            this.k.getSettings().setDisplayZoomControls(z2);
        } catch (Throwable unused) {
        }
    }

    public void setDomStorageEnabled(boolean z2) {
        try {
            this.k.getSettings().setDomStorageEnabled(z2);
        } catch (Throwable unused) {
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            this.k.setDownloadListener(downloadListener);
        } catch (Throwable unused) {
        }
    }

    public void setIsPreventTouchEvent(boolean z2) {
        this.j = z2;
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z2) {
        try {
            this.k.getSettings().setJavaScriptCanOpenWindowsAutomatically(z2);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptEnabled(boolean z2) {
        try {
            this.k.getSettings().setJavaScriptEnabled(z2);
        } catch (Throwable unused) {
        }
    }

    public void setLandingPage(boolean z2) {
        this.d = z2;
    }

    public void setLandingPageClickBegin(long j2) {
        this.y = j2;
    }

    public void setLandingPageClickEnd(long j2) {
        this.z = j2;
    }

    public void setLayerType(int i2, Paint paint) {
        try {
            this.k.setLayerType(i2, paint);
        } catch (Throwable unused) {
        }
    }

    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        try {
            this.k.getSettings().setLayoutAlgorithm(layoutAlgorithm);
        } catch (Throwable unused) {
        }
    }

    public void setLoadWithOverviewMode(boolean z2) {
        try {
            this.k.getSettings().setLoadWithOverviewMode(z2);
        } catch (Throwable unused) {
        }
    }

    public void setMaterialMeta(com.bytedance.sdk.component.widget.b.a aVar) {
        this.a = aVar;
    }

    public void setMixedContentMode(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                this.k.getSettings().setMixedContentMode(i2);
            } catch (Throwable unused) {
            }
        }
    }

    public void setNetworkAvailable(boolean z2) {
        try {
            this.k.setNetworkAvailable(z2);
        } catch (Throwable unused) {
        }
    }

    public void setOnShakeListener(b bVar) {
        this.p = bVar;
    }

    public void setOverScrollMode(int i2) {
        try {
            this.k.setOverScrollMode(i2);
            super.setOverScrollMode(i2);
        } catch (Throwable unused) {
        }
    }

    public void setRecycler(boolean z2) {
        if (this.k != null && (this.k instanceof PangleWebView)) {
            ((PangleWebView) this.k).setRecycler(z2);
        }
    }

    public void setShakeValue(float f2) {
        this.l = f2;
    }

    public void setSupportZoom(boolean z2) {
        try {
            this.k.getSettings().setSupportZoom(z2);
        } catch (Throwable unused) {
        }
    }

    public void setTag(String str) {
        this.b = str;
    }

    public void setTouchStateListener(d dVar) {
        this.w = dVar;
    }

    public void setUseWideViewPort(boolean z2) {
        try {
            this.k.getSettings().setUseWideViewPort(z2);
        } catch (Throwable unused) {
        }
    }

    public void setUserAgentString(String str) {
        try {
            this.k.getSettings().setUserAgentString(str);
        } catch (Throwable unused) {
        }
    }

    public void setVisibility(int i2) {
        try {
            super.setVisibility(i2);
            this.k.setVisibility(i2);
        } catch (Throwable unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            this.k.setWebChromeClient(webChromeClient);
        } catch (Throwable unused) {
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            if (webViewClient instanceof d) {
                setTouchStateListener((d) webViewClient);
            } else {
                setTouchStateListener((d) null);
            }
            if (webViewClient == null) {
                webViewClient = new a();
            }
            this.k.setWebViewClient(webViewClient);
        } catch (Throwable unused) {
        }
    }

    public void setWriggleValue(float f2) {
        this.n = f2;
    }

    public static class a extends WebViewClient {
        public boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView == null) {
                return true;
            }
            webView.post(new Runnable() {
                public void run() {
                    try {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return true;
        }
    }
}
