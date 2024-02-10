package io.monedata.partners.bases;

import android.content.Context;
import io.monedata.consent.ConsentManager;
import io.monedata.consent.models.ConsentData;
import io.monedata.partners.models.AdapterConsent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0012\u0010\u0007\u001a\u00020\bX¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lio/monedata/partners/bases/BaseConsentPartnerAdapter;", "Lio/monedata/partners/bases/BasePartnerAdapter;", "id", "", "name", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "consentConfig", "Lio/monedata/partners/models/AdapterConsent;", "getConsentConfig", "()Lio/monedata/partners/models/AdapterConsent;", "hasConsent", "", "context", "Landroid/content/Context;", "consent", "Lio/monedata/consent/models/ConsentData;", "onConsentChange", "", "(Landroid/content/Context;Lio/monedata/consent/models/ConsentData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BaseConsentPartnerAdapter extends BasePartnerAdapter {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseConsentPartnerAdapter(String str, String str2, String str3) {
        super(str, str2, str3);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
    }

    public static /* synthetic */ boolean hasConsent$default(BaseConsentPartnerAdapter baseConsentPartnerAdapter, Context context, ConsentData consentData, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                consentData = ConsentManager.INSTANCE.get(context);
            }
            return baseConsentPartnerAdapter.hasConsent(context, consentData);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hasConsent");
    }

    /* access modifiers changed from: protected */
    public abstract AdapterConsent getConsentConfig();

    /* access modifiers changed from: protected */
    public boolean hasConsent(Context context, ConsentData consentData) {
        Intrinsics.checkNotNullParameter(context, "context");
        return consentData != null && getConsentConfig().validate(context, consentData);
    }

    /* access modifiers changed from: protected */
    public Object onConsentChange(Context context, ConsentData consentData, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
