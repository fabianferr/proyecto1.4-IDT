package com.wortise.ads;

import com.wortise.ads.consent.models.ConsentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/wortise/ads/consent/models/ConsentData;", "Lcom/wortise/ads/l6;", "a", "(Lcom/wortise/ads/consent/models/ConsentData;)Lcom/wortise/ads/l6;", "tcf", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: ConsentData.kt */
public final class q1 {
    public static final l6 a(ConsentData consentData) {
        Intrinsics.checkNotNullParameter(consentData, "<this>");
        try {
            return new l6(consentData);
        } catch (Throwable unused) {
            return null;
        }
    }
}
