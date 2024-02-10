package io.monedata;

import io.monedata.consent.iab.models.TcfString;
import io.monedata.consent.models.ConsentData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lio/monedata/consent/models/ConsentData;", "Lio/monedata/consent/iab/models/TcfString;", "a", "(Lio/monedata/consent/models/ConsentData;)Lio/monedata/consent/iab/models/TcfString;", "tcf", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class v {
    public static final TcfString a(ConsentData consentData) {
        Object obj;
        Intrinsics.checkNotNullParameter(consentData, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m2344constructorimpl(new TcfString(consentData));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2350isFailureimpl(obj)) {
            obj = null;
        }
        return (TcfString) obj;
    }
}
