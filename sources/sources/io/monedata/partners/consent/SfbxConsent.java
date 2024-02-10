package io.monedata.partners.consent;

import android.content.Context;
import io.monedata.consent.iab.models.TcfString;
import io.monedata.consent.models.ConsentData;
import io.monedata.s1;
import io.monedata.v;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001f\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000f"}, d2 = {"Lio/monedata/partners/consent/SfbxConsent;", "", "vendor", "", "(Ljava/lang/String;)V", "getVendor", "()Ljava/lang/String;", "setVendor", "validate", "", "context", "Landroid/content/Context;", "consent", "Lio/monedata/consent/models/ConsentData;", "(Landroid/content/Context;Lio/monedata/consent/models/ConsentData;)Ljava/lang/Boolean;", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class SfbxConsent {
    private String vendor;

    public SfbxConsent() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public SfbxConsent(String str) {
        this.vendor = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SfbxConsent(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    private final boolean validate(Context context) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            String str = this.vendor;
            if (!Intrinsics.areEqual((Object) str != null ? s1.a.b(context, str) : null, (Object) Boolean.FALSE)) {
                obj = Result.m2344constructorimpl(Unit.INSTANCE);
                return Result.m2351isSuccessimpl(obj);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final String getVendor() {
        return this.vendor;
    }

    public final void setVendor(String str) {
        this.vendor = str;
    }

    public Boolean validate(Context context, ConsentData consentData) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consentData, "consent");
        try {
            Result.Companion companion = Result.Companion;
            if (s1.a.b()) {
                TcfString a = v.a(consentData);
                if (a != null && a.getCmpId() == 2) {
                    obj = Result.m2344constructorimpl(Boolean.valueOf(validate(context)));
                    if (Result.m2350isFailureimpl(obj)) {
                        obj = null;
                    }
                    return (Boolean) obj;
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
