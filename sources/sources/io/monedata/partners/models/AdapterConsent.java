package io.monedata.partners.models;

import android.content.Context;
import io.monedata.consent.models.ConsentData;
import io.monedata.partners.consent.SfbxConsent;
import io.monedata.partners.consent.TcfConsent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lio/monedata/partners/models/AdapterConsent;", "", "sfbx", "Lio/monedata/partners/consent/SfbxConsent;", "tcf", "Lio/monedata/partners/consent/TcfConsent;", "(Lio/monedata/partners/consent/SfbxConsent;Lio/monedata/partners/consent/TcfConsent;)V", "getSfbx", "()Lio/monedata/partners/consent/SfbxConsent;", "getTcf", "()Lio/monedata/partners/consent/TcfConsent;", "validate", "", "context", "Landroid/content/Context;", "consent", "Lio/monedata/consent/models/ConsentData;", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class AdapterConsent {
    private final SfbxConsent sfbx;
    private final TcfConsent tcf;

    public AdapterConsent() {
        this((SfbxConsent) null, (TcfConsent) null, 3, (DefaultConstructorMarker) null);
    }

    public AdapterConsent(SfbxConsent sfbxConsent, TcfConsent tcfConsent) {
        this.sfbx = sfbxConsent;
        this.tcf = tcfConsent;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdapterConsent(SfbxConsent sfbxConsent, TcfConsent tcfConsent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sfbxConsent, (i & 2) != 0 ? null : tcfConsent);
    }

    public final SfbxConsent getSfbx() {
        return this.sfbx;
    }

    public final TcfConsent getTcf() {
        return this.tcf;
    }

    public boolean validate(Context context, ConsentData consentData) {
        Boolean validate;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consentData, "consent");
        SfbxConsent sfbxConsent = this.sfbx;
        if (sfbxConsent != null ? Intrinsics.areEqual((Object) sfbxConsent.validate(context, consentData), (Object) Boolean.FALSE) : false) {
            return false;
        }
        TcfConsent tcfConsent = this.tcf;
        return (tcfConsent == null || (validate = tcfConsent.validate(consentData)) == null) ? consentData.canCollectPersonalData(context) : validate.booleanValue();
    }
}
