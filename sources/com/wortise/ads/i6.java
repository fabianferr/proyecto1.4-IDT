package com.wortise.ads;

import com.wortise.ads.consent.models.ConsentData;
import com.wortise.ads.consent.models.ConsentSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/wortise/ads/i6;", "", "Lcom/wortise/ads/l6;", "consent", "Lcom/wortise/ads/consent/models/ConsentData;", "a", "", "value", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: TcfConsentFactory.kt */
public final class i6 {
    public static final i6 a = new i6();

    private i6() {
    }

    public final ConsentData a(l6 l6Var) {
        Intrinsics.checkNotNullParameter(l6Var, "consent");
        return new ConsentData(l6Var.b(), m6.a(l6Var), l6Var.a(), ConsentSource.IAB);
    }

    public final ConsentData a(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return a(new l6(str));
    }
}
