package io.monedata;

import android.content.Context;
import io.monedata.consent.ConsentManager;
import io.monedata.consent.models.ConsentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"Lio/monedata/consent/ConsentManager;", "Landroid/content/Context;", "context", "Lio/monedata/consent/models/ConsentData;", "a", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class y {
    public static final ConsentData a(ConsentManager consentManager, Context context) {
        Intrinsics.checkNotNullParameter(consentManager, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        ConsentData consentData = consentManager.get(context);
        if (consentData != null) {
            return consentData;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
