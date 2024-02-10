package com.startapp;

import android.os.Handler;
import android.webkit.WebView;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.startapp.d4;

/* compiled from: Sta */
public class h6 extends d4 {

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ WebView a;

        public a(h6 h6Var, WebView webView) {
            this.a = webView;
        }

        public void run() {
            try {
                this.a.setBackgroundColor(0);
            } catch (Exception unused) {
            }
        }
    }

    public void a(WebView webView) {
        new Handler().postDelayed(new a(this, webView), 1000);
    }

    public void b(WebView webView) {
        this.B = false;
        webView.setOnTouchListener(new d4.e());
        if (this.h.equals(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE)) {
            webView.setBackgroundColor(0);
        }
    }
}
