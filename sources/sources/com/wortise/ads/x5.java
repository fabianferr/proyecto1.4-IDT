package com.wortise.ads;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Lokhttp3/ResponseBody;", "", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: ResponseBody.kt */
public final class x5 {
    public static final long a(ResponseBody responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        return responseBody.source().readAll(new h5());
    }
}
