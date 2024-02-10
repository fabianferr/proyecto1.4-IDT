package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.graphics.Paint;
import android.os.Build;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BrandBannerWebViewPool */
public class c {
    private static int b;
    private static volatile c c;
    private final List<DspHtmlWebView> a = new ArrayList();

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public DspHtmlWebView b() {
        DspHtmlWebView remove;
        if (c() > 0 && (remove = this.a.remove(0)) != null) {
            return remove;
        }
        return null;
    }

    public void a(DspHtmlWebView dspHtmlWebView) {
        if (dspHtmlWebView != null) {
            b(dspHtmlWebView);
        }
    }

    public void b(DspHtmlWebView dspHtmlWebView) {
        if (dspHtmlWebView == null) {
            return;
        }
        if (this.a.size() >= b) {
            dspHtmlWebView.l();
        } else if (!this.a.contains(dspHtmlWebView)) {
            c(dspHtmlWebView);
            this.a.add(dspHtmlWebView);
        }
    }

    public int c() {
        return this.a.size();
    }

    public void c(DspHtmlWebView dspHtmlWebView) {
        if (dspHtmlWebView != null && dspHtmlWebView.getWebView() != null) {
            if (dspHtmlWebView.getParent() != null) {
                ((ViewGroup) dspHtmlWebView.getParent()).removeView(dspHtmlWebView);
            }
            try {
                dspHtmlWebView.removeAllViews();
                dspHtmlWebView.c();
                dspHtmlWebView.setWebChromeClient((WebChromeClient) null);
                dspHtmlWebView.setWebViewClient((WebViewClient) null);
                dspHtmlWebView.setDownloadListener((DownloadListener) null);
                dspHtmlWebView.setDefaultTextEncodingName("UTF-8");
                dspHtmlWebView.setAllowFileAccess(false);
                dspHtmlWebView.setJavaScriptEnabled(true);
                dspHtmlWebView.setAppCacheEnabled(true);
                dspHtmlWebView.setDatabaseEnabled(true);
                dspHtmlWebView.setSupportZoom(false);
                dspHtmlWebView.getWebView().setLayerType(0, (Paint) null);
                dspHtmlWebView.setBackgroundColor(0);
                dspHtmlWebView.getWebView().setHorizontalScrollBarEnabled(false);
                dspHtmlWebView.getWebView().setHorizontalScrollbarOverlay(false);
                dspHtmlWebView.getWebView().setVerticalScrollBarEnabled(false);
                dspHtmlWebView.getWebView().setVerticalScrollbarOverlay(false);
                dspHtmlWebView.a(true);
                dspHtmlWebView.j();
                if (Build.VERSION.SDK_INT >= 21) {
                    dspHtmlWebView.setMixedContentMode(0);
                }
            } catch (Exception unused) {
            }
        }
    }
}
