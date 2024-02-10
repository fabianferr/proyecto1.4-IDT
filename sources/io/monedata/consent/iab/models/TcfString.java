package io.monedata.consent.iab.models;

import io.monedata.iabtcf.decoder.DecoderOption;
import io.monedata.iabtcf.decoder.TCString;
import io.monedata.iabtcf.decoder.TCStringFactory;
import io.monedata.iabtcf.utils.IntIterable;
import io.monedata.w1;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b3\u00104B\u0011\b\u0016\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b3\u00107J!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ!\u0010\u000e\u001a\u00020\u00062\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J!\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\f\"\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR#\u0010$\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0011\u0010(\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010,\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010.\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0011\u00100\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b/\u0010'R\u0011\u00102\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b1\u0010'¨\u00068"}, d2 = {"Lio/monedata/consent/iab/models/TcfString;", "", "Lio/monedata/iabtcf/utils/IntIterable;", "it", "Lio/monedata/w1;", "entity", "", "contains", "(Lio/monedata/iabtcf/utils/IntIterable;Lio/monedata/w1;)Ljava/lang/Boolean;", "Lio/monedata/consent/iab/models/TcfPurpose;", "purpose", "isPurposeAccepted", "", "purposes", "isPurposesAccepted", "([Lio/monedata/consent/iab/models/TcfPurpose;)Z", "Lio/monedata/consent/iab/models/TcfSpecialFeature;", "feature", "isSpecialFeatureAccepted", "features", "isSpecialFeaturesAccepted", "([Lio/monedata/consent/iab/models/TcfSpecialFeature;)Z", "Lio/monedata/consent/iab/models/TcfVendor;", "vendor", "isVendorAccepted", "", "iabString", "Ljava/lang/String;", "getIabString", "()Ljava/lang/String;", "Lio/monedata/iabtcf/decoder/TCString;", "kotlin.jvm.PlatformType", "tcString$delegate", "Lkotlin/Lazy;", "getTcString", "()Lio/monedata/iabtcf/decoder/TCString;", "tcString", "", "getCmpId", "()I", "cmpId", "Ljava/util/Date;", "getCreated", "()Ljava/util/Date;", "created", "getLastUpdated", "lastUpdated", "getTcfPolicyVersion", "tcfPolicyVersion", "getVendorListVersion", "vendorListVersion", "<init>", "(Ljava/lang/String;)V", "Lio/monedata/consent/models/ConsentData;", "consent", "(Lio/monedata/consent/models/ConsentData;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class TcfString {
    private final String iabString;
    private final Lazy tcString$delegate;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/monedata/iabtcf/decoder/TCString;", "kotlin.jvm.PlatformType", "a", "()Lio/monedata/iabtcf/decoder/TCString;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<TCString> {
        final /* synthetic */ TcfString a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(TcfString tcfString) {
            super(0);
            this.a = tcfString;
        }

        /* renamed from: a */
        public final TCString invoke() {
            return TCStringFactory.decode(this.a.getIabString(), new DecoderOption[0]);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TcfString(io.monedata.consent.models.ConsentData r2) {
        /*
            r1 = this;
            java.lang.String r0 = "consent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = r2.getIabString()
            if (r2 == 0) goto L_0x000f
            r1.<init>((java.lang.String) r2)
            return
        L_0x000f:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Required value was null."
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.consent.iab.models.TcfString.<init>(io.monedata.consent.models.ConsentData):void");
    }

    public TcfString(String str) {
        Intrinsics.checkNotNullParameter(str, "iabString");
        this.iabString = str;
        this.tcString$delegate = LazyKt.lazy(new a(this));
    }

    private final Boolean contains(IntIterable intIterable, w1 w1Var) {
        if (w1Var.getVersion() > getVendorListVersion()) {
            return null;
        }
        return Boolean.valueOf(intIterable.contains(w1Var.getId()));
    }

    private final TCString getTcString() {
        return (TCString) this.tcString$delegate.getValue();
    }

    public final int getCmpId() {
        return getTcString().getCmpId();
    }

    public final Date getCreated() {
        Date created = getTcString().getCreated();
        Intrinsics.checkNotNullExpressionValue(created, "tcString.created");
        return created;
    }

    public final String getIabString() {
        return this.iabString;
    }

    public final Date getLastUpdated() {
        Date lastUpdated = getTcString().getLastUpdated();
        Intrinsics.checkNotNullExpressionValue(lastUpdated, "tcString.lastUpdated");
        return lastUpdated;
    }

    public final int getTcfPolicyVersion() {
        return getTcString().getTcfPolicyVersion();
    }

    public final int getVendorListVersion() {
        return getTcString().getVendorListVersion();
    }

    public final boolean isPurposeAccepted(TcfPurpose tcfPurpose) {
        Intrinsics.checkNotNullParameter(tcfPurpose, "purpose");
        IntIterable purposesConsent = getTcString().getPurposesConsent();
        Intrinsics.checkNotNullExpressionValue(purposesConsent, "tcString.purposesConsent");
        return !Intrinsics.areEqual((Object) contains(purposesConsent, tcfPurpose), (Object) Boolean.FALSE);
    }

    public final boolean isPurposesAccepted(TcfPurpose... tcfPurposeArr) {
        Intrinsics.checkNotNullParameter(tcfPurposeArr, "purposes");
        for (TcfPurpose isPurposeAccepted : tcfPurposeArr) {
            if (!isPurposeAccepted(isPurposeAccepted)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isSpecialFeatureAccepted(TcfSpecialFeature tcfSpecialFeature) {
        Intrinsics.checkNotNullParameter(tcfSpecialFeature, "feature");
        IntIterable specialFeatureOptIns = getTcString().getSpecialFeatureOptIns();
        Intrinsics.checkNotNullExpressionValue(specialFeatureOptIns, "tcString.specialFeatureOptIns");
        return !Intrinsics.areEqual((Object) contains(specialFeatureOptIns, tcfSpecialFeature), (Object) Boolean.FALSE);
    }

    public final boolean isSpecialFeaturesAccepted(TcfSpecialFeature... tcfSpecialFeatureArr) {
        Intrinsics.checkNotNullParameter(tcfSpecialFeatureArr, "features");
        for (TcfSpecialFeature isSpecialFeatureAccepted : tcfSpecialFeatureArr) {
            if (!isSpecialFeatureAccepted(isSpecialFeatureAccepted)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isVendorAccepted(TcfVendor tcfVendor) {
        Intrinsics.checkNotNullParameter(tcfVendor, "vendor");
        IntIterable vendorConsent = getTcString().getVendorConsent();
        Intrinsics.checkNotNullExpressionValue(vendorConsent, "tcString.vendorConsent");
        return !Intrinsics.areEqual((Object) contains(vendorConsent, tcfVendor), (Object) Boolean.FALSE);
    }
}
