package com.bytedance.sdk.component.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class PangleWebView extends WebView {
    public long a = System.currentTimeMillis();
    private final HashSet<String> b = new HashSet<>();
    private boolean c;
    private boolean d;
    private boolean e;

    public PangleWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PangleWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        l.b("TTAD.PangleWebView", "init: ");
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportMultipleWindows(false);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        setWebViewClient(new SSWebView.a());
    }

    public void addJavascriptInterface(Object obj, String str) {
        l.b("TTAD.PangleWebView", "addJavascriptInterface: " + str + ", " + this);
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "addJavascriptInterface: has destroyed or has recycler");
            return;
        }
        super.addJavascriptInterface(obj, str);
        this.b.add(str);
    }

    public void removeJavascriptInterface(String str) {
        if (this.c || this.e) {
            l.b("TTAD.PangleWebView", "removeJavascriptInterface: has destroyed or recycler, name=" + str);
            return;
        }
        super.removeJavascriptInterface(str);
        this.b.remove(str);
    }

    public void onPause() {
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "onPause: has destroyed or recycler");
            return;
        }
        try {
            super.onPause();
        } catch (Exception e2) {
            l.c("TTAD.PangleWebView", "onPause: ", e2);
        }
    }

    public void onResume() {
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "onResume: has destroyed or recycler");
            return;
        }
        try {
            super.onResume();
        } catch (Exception e2) {
            l.c("TTAD.PangleWebView", "onResume: ", e2);
        }
    }

    public void stopLoading() {
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "stopLoading: has destroyed or recycler");
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e2) {
            l.c("TTAD.PangleWebView", "stopLoading: ", e2);
        }
    }

    public void reload() {
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "reload: has destroyed or recycler");
        } else {
            super.reload();
        }
    }

    public void goBack() {
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "goBack: has destroyed or recycler");
        } else {
            super.goBack();
        }
    }

    public void goForward() {
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "goForward: has destroyed or recycler");
        } else {
            super.goForward();
        }
    }

    public void goBackOrForward(int i) {
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "goBackOrForward: has destroyed or recycler");
        } else {
            super.goBackOrForward(i);
        }
    }

    public void clearCache(boolean z) {
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "clearCache: has destroyed or recycler");
        } else {
            super.clearCache(z);
        }
    }

    public void loadUrl(String str) {
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "loadUrl: has destroyed or recycler");
            return;
        }
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e2) {
            l.c("TTAD.PangleWebView", "loadUrl: ", e2);
        }
    }

    public void loadUrl(String str, Map<String, String> map) {
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "loadUrl: has destroyed or recycler");
            return;
        }
        try {
            super.loadUrl(str, map);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e2) {
            l.c("TTAD.PangleWebView", "loadUrl: ", e2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.c || this.e) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.c || this.e) {
            l.e("TTAD.PangleWebView", "loadDataWithBaseURL: has destroyed or recycler");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.c && !this.e) {
            super.evaluateJavascript(str, valueCallback);
        } else if (valueCallback != null) {
            l.e("TTAD.PangleWebView", "evaluateJavascript: has destroyed or recycler, " + str);
            valueCallback.onReceiveValue("");
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l.b("TTAD.PangleWebView", "onAttachedToWindow: " + this);
    }

    public void setDestroyOnDetached(boolean z) {
        l.b("TTAD.PangleWebView", "setDestroyOnDetached() called with: destroyOnDetached = [" + z + "]");
        this.d = z;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l.b("TTAD.PangleWebView", "onDetachedFromWindow: " + this);
        if (this.d) {
            destroy();
        }
    }

    public void resumeTimers() {
        l.b("TTAD.PangleWebView", "resumeTimers: ");
        if (!this.c && !this.e) {
            super.resumeTimers();
        }
    }

    public void pauseTimers() {
        l.b("TTAD.PangleWebView", "pauseTimers: ");
        if (!this.c && !this.e) {
            super.pauseTimers();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.c && !this.e) {
            super.onDraw(canvas);
        }
    }

    public void destroy() {
        l.b("TTAD.PangleWebView", "destroy() called, " + this);
        if (!this.c) {
            this.c = true;
            b();
            super.destroy();
        }
    }

    private void b() {
        if (!this.c) {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            setOnClickListener((View.OnClickListener) null);
            setOnTouchListener((View.OnTouchListener) null);
            Iterator<String> it = this.b.iterator();
            while (it.hasNext()) {
                String next = it.next();
                l.b("TTAD.PangleWebView", "destroy: auto remove js obj " + next);
                super.removeJavascriptInterface(next);
            }
        }
    }

    public void setRecycler(boolean z) {
        this.e = z;
    }
}
