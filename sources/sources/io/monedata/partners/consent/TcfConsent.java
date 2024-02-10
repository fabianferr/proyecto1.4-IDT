package io.monedata.partners.consent;

import io.monedata.consent.iab.models.TcfPurpose;
import io.monedata.consent.iab.models.TcfSpecialFeature;
import io.monedata.consent.iab.models.TcfString;
import io.monedata.consent.iab.models.TcfVendor;
import io.monedata.consent.models.ConsentData;
import io.monedata.v;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B5\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010\u0018R\u001b\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lio/monedata/partners/consent/TcfConsent;", "", "purposes", "", "Lio/monedata/consent/iab/models/TcfPurpose;", "specialFeatures", "Lio/monedata/consent/iab/models/TcfSpecialFeature;", "vendor", "Lio/monedata/consent/iab/models/TcfVendor;", "([Lio/monedata/consent/iab/models/TcfPurpose;[Lio/monedata/consent/iab/models/TcfSpecialFeature;Lio/monedata/consent/iab/models/TcfVendor;)V", "getPurposes", "()[Lio/monedata/consent/iab/models/TcfPurpose;", "[Lio/monedata/consent/iab/models/TcfPurpose;", "getSpecialFeatures", "()[Lio/monedata/consent/iab/models/TcfSpecialFeature;", "[Lio/monedata/consent/iab/models/TcfSpecialFeature;", "getVendor", "()Lio/monedata/consent/iab/models/TcfVendor;", "validate", "", "tcf", "Lio/monedata/consent/iab/models/TcfString;", "consent", "Lio/monedata/consent/models/ConsentData;", "(Lio/monedata/consent/models/ConsentData;)Ljava/lang/Boolean;", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class TcfConsent {
    private final TcfPurpose[] purposes;
    private final TcfSpecialFeature[] specialFeatures;
    private final TcfVendor vendor;

    public TcfConsent() {
        this((TcfPurpose[]) null, (TcfSpecialFeature[]) null, (TcfVendor) null, 7, (DefaultConstructorMarker) null);
    }

    public TcfConsent(TcfPurpose[] tcfPurposeArr, TcfSpecialFeature[] tcfSpecialFeatureArr, TcfVendor tcfVendor) {
        this.purposes = tcfPurposeArr;
        this.specialFeatures = tcfSpecialFeatureArr;
        this.vendor = tcfVendor;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TcfConsent(TcfPurpose[] tcfPurposeArr, TcfSpecialFeature[] tcfSpecialFeatureArr, TcfVendor tcfVendor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tcfPurposeArr, (i & 2) != 0 ? null : tcfSpecialFeatureArr, (i & 4) != 0 ? null : tcfVendor);
    }

    public final TcfPurpose[] getPurposes() {
        return this.purposes;
    }

    public final TcfSpecialFeature[] getSpecialFeatures() {
        return this.specialFeatures;
    }

    public final TcfVendor getVendor() {
        return this.vendor;
    }

    public Boolean validate(ConsentData consentData) {
        Intrinsics.checkNotNullParameter(consentData, "consent");
        TcfString a = v.a(consentData);
        if (a != null) {
            return Boolean.valueOf(validate(a));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean validate(TcfString tcfString) {
        Object obj;
        Intrinsics.checkNotNullParameter(tcfString, "tcf");
        try {
            Result.Companion companion = Result.Companion;
            TcfVendor tcfVendor = this.vendor;
            Boolean bool = null;
            Boolean valueOf = tcfVendor != null ? Boolean.valueOf(tcfString.isVendorAccepted(tcfVendor)) : null;
            Boolean bool2 = Boolean.FALSE;
            if (!Intrinsics.areEqual((Object) valueOf, (Object) bool2)) {
                TcfPurpose[] tcfPurposeArr = this.purposes;
                if (!Intrinsics.areEqual((Object) tcfPurposeArr != null ? Boolean.valueOf(tcfString.isPurposesAccepted(tcfPurposeArr)) : null, (Object) bool2)) {
                    TcfSpecialFeature[] tcfSpecialFeatureArr = this.specialFeatures;
                    if (tcfSpecialFeatureArr != null) {
                        bool = Boolean.valueOf(tcfString.isSpecialFeaturesAccepted(tcfSpecialFeatureArr));
                    }
                    if (!Intrinsics.areEqual((Object) bool, (Object) bool2)) {
                        obj = Result.m2344constructorimpl(Unit.INSTANCE);
                        return Result.m2351isSuccessimpl(obj);
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
    }
}
