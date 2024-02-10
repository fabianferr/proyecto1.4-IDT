package com.applovin.impl.sdk.b;

import android.webkit.WebView;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.u;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

public class c extends b {
    public c(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    public AdSessionConfiguration a() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.LOADED, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            if (u.a()) {
                this.c.b(this.d, "Failed to create ad session configuration", th);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public AdSessionContext a(WebView webView) {
        try {
            return AdSessionContext.createHtmlAdSessionContext(this.b.al().d(), webView, this.a.getOpenMeasurementContentUrl(), this.a.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th) {
            if (u.a()) {
                this.c.b(this.d, "Failed to create ad session context", th);
            }
            return null;
        }
    }
}
