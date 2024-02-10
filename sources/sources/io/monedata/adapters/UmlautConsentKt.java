package io.monedata.adapters;

import io.monedata.consent.iab.models.TcfPurpose;
import io.monedata.consent.iab.models.TcfSpecialFeature;
import io.monedata.consent.iab.models.TcfVendor;
import io.monedata.partners.consent.TcfConsent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"tcf", "Lio/monedata/partners/consent/TcfConsent;", "adapter-umlaut_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: UmlautConsent.kt */
public final class UmlautConsentKt {
    /* access modifiers changed from: private */
    public static final TcfConsent tcf = new TcfConsent(new TcfPurpose[]{TcfPurpose.STORE_INFORMATION, TcfPurpose.MARKET_RESEARCH, TcfPurpose.DEVELOP_AND_IMPROVE_PRODUCTS}, new TcfSpecialFeature[]{TcfSpecialFeature.PRECISE_GEOLOCATION}, new TcfVendor(1078, 0, 2, (DefaultConstructorMarker) null));
}
