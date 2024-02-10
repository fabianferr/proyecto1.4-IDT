package com.wortise.ads;

import android.content.Context;
import com.wortise.ads.consent.ConsentManager;
import com.wortise.ads.consent.models.ConsentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"Lcom/wortise/ads/consent/ConsentManager;", "Landroid/content/Context;", "context", "Lcom/wortise/ads/l6;", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: ConsentManager.kt */
public final class t1 {
    public static final l6 a(ConsentManager consentManager, Context context) {
        Intrinsics.checkNotNullParameter(consentManager, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        ConsentData consentData = ConsentManager.get(context);
        if (consentData == null) {
            return null;
        }
        return q1.a(consentData);
    }
}
