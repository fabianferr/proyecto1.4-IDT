package io.monedata;

import android.content.Context;
import io.monedata.consent.models.ConsentData;
import io.monedata.partners.PartnerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\b"}, d2 = {"Lio/monedata/j1;", "Landroid/content/Context;", "context", "Lio/monedata/consent/models/ConsentData;", "consent", "", "a", "b", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class i1 {
    public static final void a(j1 j1Var, Context context) {
        Intrinsics.checkNotNullParameter(j1Var, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        for (PartnerAdapter start : j1Var.d()) {
            start.start(context);
        }
    }

    public static final void a(j1 j1Var, Context context, ConsentData consentData) {
        Intrinsics.checkNotNullParameter(j1Var, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consentData, "consent");
        for (PartnerAdapter notifyConsentChange : j1Var.b()) {
            notifyConsentChange.notifyConsentChange(context, consentData);
        }
    }

    public static final void b(j1 j1Var, Context context) {
        Intrinsics.checkNotNullParameter(j1Var, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        for (PartnerAdapter stop : j1Var.a()) {
            stop.stop(context);
        }
    }
}
