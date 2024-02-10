package com.mbridge.msdk.activity;

import android.os.Build;
import android.os.Bundle;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.foundation.webview.b;

public class MBCommonActivity extends DomainMBCommonActivity {
    private boolean b = false;

    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
    }

    public void finish() {
        if (this.browserView != null) {
            this.browserView.setListener((BrowserView.a) null);
            this.browserView.destroy();
        }
        BrowserView remove = b.a.remove(this.a);
        if (remove != null) {
            remove.setListener((BrowserView.a) null);
            remove.destroy();
        }
        this.b = true;
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (!this.b) {
            if (this.browserView != null) {
                this.browserView.setListener((BrowserView.a) null);
                this.browserView.destroy();
            }
            BrowserView remove = b.a.remove(this.a);
            if (remove != null) {
                remove.setListener((BrowserView.a) null);
                remove.destroy();
            }
        }
    }
}
