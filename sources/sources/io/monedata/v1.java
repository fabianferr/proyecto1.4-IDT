package io.monedata;

import io.monedata.consent.iab.models.TcfString;
import io.monedata.consent.models.ConsentData;
import io.monedata.consent.models.ConsentSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lio/monedata/v1;", "", "Lio/monedata/consent/iab/models/TcfString;", "consent", "Lio/monedata/consent/models/ConsentData;", "a", "", "value", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class v1 {
    public static final v1 a = new v1();

    private v1() {
    }

    public final ConsentData a(TcfString tcfString) {
        Intrinsics.checkNotNullParameter(tcfString, "consent");
        return new ConsentData(tcfString.getLastUpdated(), y1.a(tcfString), tcfString.getIabString(), ConsentSource.IAB);
    }

    public final ConsentData a(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return a(new TcfString(str));
    }
}
