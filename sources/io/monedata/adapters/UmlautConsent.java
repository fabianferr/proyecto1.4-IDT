package io.monedata.adapters;

import io.monedata.partners.consent.SfbxConsent;
import io.monedata.partners.models.AdapterConsent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/monedata/adapters/UmlautConsent;", "Lio/monedata/partners/models/AdapterConsent;", "()V", "adapter-umlaut_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UmlautConsent.kt */
public final class UmlautConsent extends AdapterConsent {
    public static final UmlautConsent INSTANCE = new UmlautConsent();

    private UmlautConsent() {
        super((SfbxConsent) null, UmlautConsentKt.tcf, 1, (DefaultConstructorMarker) null);
    }
}
