package com.wortise.ads;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\f"}, d2 = {"Lcom/wortise/ads/q4;", "", "T", "", "json", "Ljava/lang/reflect/Type;", "type", "a", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "obj", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: JsonParser.kt */
public final class q4 {
    public static final q4 a = new q4();

    private q4() {
    }

    public final <T> T a(String str, Type type) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(type, "type");
        return r4.a().fromJson(str, type);
    }

    public final String a(Object obj, Type type) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Gson a2 = r4.a();
        if (type == null) {
            type = obj.getClass();
        }
        String json = a2.toJson(obj, type);
        Intrinsics.checkNotNullExpressionValue(json, "GSON.toJson(obj, type ?: obj.javaClass)");
        return json;
    }

    public static /* synthetic */ String a(q4 q4Var, Object obj, Type type, int i, Object obj2) {
        if ((i & 2) != 0) {
            type = null;
        }
        return q4Var.a(obj, type);
    }
}
