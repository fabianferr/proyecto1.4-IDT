package com.wortise.ads;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.protocol.HTTP;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"Lcom/wortise/ads/f1;", "", "identity", "Lcom/wortise/ads/d1;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CellIdentityFactory.kt */
public final class f1 {
    public static final f1 a = new f1();

    private f1() {
    }

    public final d1 a(Object obj) {
        Intrinsics.checkNotNullParameter(obj, HTTP.IDENTITY_CODING);
        return new d1(new e1(obj).a());
    }
}
