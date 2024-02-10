package com.mbridge.msdk.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.d.c;
import com.mbridge.msdk.videocommon.download.g;
import com.mbridge.msdk.videocommon.download.h;

public class MBridgeAlertWebview extends MBridgeH5EndCardView {
    /* access modifiers changed from: private */
    public String y;

    public MBridgeAlertWebview(Context context) {
        super(context);
    }

    public MBridgeAlertWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final String a() {
        if (TextUtils.isEmpty(this.v)) {
            return "";
        }
        b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.v, false);
        String str = c.a;
        this.y = str;
        return !TextUtils.isEmpty(str) ? g.a().b(this.y) : "";
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        String a = a();
        if (!this.f || this.b == null || TextUtils.isEmpty(a)) {
            this.e.a(101, "");
            return;
        }
        BrowserView.MBDownloadListener mBDownloadListener = new BrowserView.MBDownloadListener(this.b);
        mBDownloadListener.setTitle(this.b.getAppName());
        this.q.setDownloadListener(mBDownloadListener);
        this.q.setCampaignId(this.b.getId());
        setCloseVisible(8);
        this.q.setApiManagerJSFactory(bVar);
        this.q.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() {
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                aa.d("MBridgeAlertWebview", "finish+" + str);
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView, "onSignalCommunication", "");
            }

            public final void a(WebView webView, int i, String str, String str2) {
                super.a(webView, i, str, str2);
                aa.d("MBridgeAlertWebview", "onReceivedError");
                if (!MBridgeAlertWebview.this.u) {
                    aa.a(MBridgeBaseView.TAG, "onReceivedError,url:" + str2);
                    q.a(MBridgeAlertWebview.this.a, MBridgeAlertWebview.this.b, MBridgeAlertWebview.this.y, MBridgeAlertWebview.this.v, 2, str);
                    MBridgeAlertWebview.this.u = true;
                }
            }

            public final void a(WebView webView, int i) {
                String str;
                super.a(webView, i);
                aa.d("MBridgeAlertWebview", "readyState  :  " + i);
                if (!MBridgeAlertWebview.this.u) {
                    MBridgeAlertWebview mBridgeAlertWebview = MBridgeAlertWebview.this;
                    boolean z = true;
                    if (i != 1) {
                        z = false;
                    }
                    mBridgeAlertWebview.t = z;
                    if (MBridgeAlertWebview.this.t) {
                        str = "readyState state is " + i;
                    } else {
                        str = "";
                    }
                    q.a(MBridgeAlertWebview.this.a, MBridgeAlertWebview.this.b, MBridgeAlertWebview.this.y, MBridgeAlertWebview.this.v, i, str);
                }
            }
        });
        setHtmlSource(h.a().b(a));
        this.t = false;
        if (TextUtils.isEmpty(this.s)) {
            aa.a(MBridgeBaseView.TAG, "load url:" + a);
            this.q.loadUrl(a);
        } else {
            aa.a(MBridgeBaseView.TAG, "load html...");
            this.q.loadDataWithBaseURL(a, this.s, "text/html", "UTF-8", (String) null);
        }
        this.q.setBackgroundColor(0);
        setBackgroundColor(0);
    }

    public void webviewshow() {
        if (this.o != null) {
            this.o.setBackgroundColor(0);
        }
        super.webviewshow();
        q.a(this.a, this.b, this.y, this.v, 2);
    }

    /* access modifiers changed from: protected */
    public final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }
}
