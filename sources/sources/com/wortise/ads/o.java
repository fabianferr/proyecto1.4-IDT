package com.wortise.ads;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/wortise/ads/o;", "", "", "json", "Lcom/wortise/ads/AdResult;", "a", "adResult", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdResultConverter.kt */
public final class o {

    @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/wortise/ads/utils/JsonParser$fromJson$1", "Lcom/google/gson/reflect/TypeToken;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: JsonParser.kt */
    public static final class a extends TypeToken<AdResult> {
    }

    public final String a(AdResult adResult) {
        if (adResult == null) {
            return null;
        }
        return p4.a(adResult);
    }

    public final AdResult a(String str) {
        if (str == null) {
            return null;
        }
        q4 q4Var = q4.a;
        Type type = new a().getType();
        Intrinsics.checkNotNullExpressionValue(type, "object: TypeToken<T>() {}.type");
        return (AdResult) q4Var.a(str, type);
    }
}
