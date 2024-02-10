package com.bytedance.sdk.openadsdk.core.g;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.l;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.AdSessionConfiguration;
import com.iab.omid.library.bytedance2.adsession.AdSessionContext;
import com.iab.omid.library.bytedance2.adsession.CreativeType;
import com.iab.omid.library.bytedance2.adsession.ImpressionType;
import com.iab.omid.library.bytedance2.adsession.Owner;
import com.iab.omid.library.bytedance2.adsession.Partner;
import com.iab.omid.library.bytedance2.adsession.VerificationScriptResource;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: ViewabilityTrackerFactory */
public class h {
    public static g a(View view, Set<j> set) {
        AdSession a = a(CreativeType.VIDEO, set, Owner.NATIVE);
        return new i(a, AdEvents.createAdEvents(a), view, MediaEvents.createMediaEvents(a));
    }

    public static g a(WebView webView) {
        Partner a = e.a();
        if (a != null) {
            AdSession createAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(a, webView, "", ""));
            return new g(createAdSession, AdEvents.createAdEvents(createAdSession), webView);
        }
        throw new IllegalArgumentException("Parameter 'partner' may not be null.");
    }

    private static AdSession a(CreativeType creativeType, Set<j> set, Owner owner) {
        List<VerificationScriptResource> a = a(set);
        if (a.isEmpty()) {
            l.d("verificationScriptResources is empty");
        }
        Partner a2 = e.a();
        if (a2 == null) {
            return null;
        }
        return AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, owner, false), AdSessionContext.createNativeAdSessionContext(a2, e.b(), a, "", ""));
    }

    private static List<VerificationScriptResource> a(Set<j> set) {
        ArrayList arrayList = new ArrayList();
        for (j next : set) {
            try {
                if (!TextUtils.isEmpty(next.a())) {
                    if (!TextUtils.isEmpty(next.b())) {
                        arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(next.a(), next.c(), next.b()));
                    }
                }
                arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(next.c()));
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}
