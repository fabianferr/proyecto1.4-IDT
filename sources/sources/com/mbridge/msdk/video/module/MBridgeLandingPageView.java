package com.mbridge.msdk.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.mbridge.msdk.click.b;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.BaseTrackingListener;

public class MBridgeLandingPageView extends MBridgeH5EndCardView {
    public MBridgeLandingPageView(Context context) {
        super(context);
    }

    public MBridgeLandingPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init(Context context) {
        super.init(context);
    }

    /* access modifiers changed from: protected */
    public final String a() {
        if (this.b != null) {
            return b.a(this.b.getClickURL(), "-999", "-999");
        }
        return null;
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        if (this.f) {
            this.q.setFilter(new a());
        }
        super.preLoadData(bVar);
        setVisibility(0);
        setCloseVisible(0);
    }

    public void webviewshow() {
        try {
            aa.a(MBridgeBaseView.TAG, "webviewshow");
            g.a().a((WebView) this.q, "webviewshow", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final class a implements com.mbridge.msdk.mbsignalcommon.base.a {
        private a() {
        }

        public final boolean a(String str) {
            if (TextUtils.isEmpty(str) || URLUtil.isNetworkUrl(str)) {
                return false;
            }
            ae.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, (BaseTrackingListener) null);
            return true;
        }
    }
}
