package io.monedata;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lio/monedata/z1;", "", "", "value", "", "a", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class z1 {
    public static final z1 a = new z1();
    private static final Regex b = new Regex("^[0]+$");

    private z1() {
    }

    public final String a() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    public final boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return b.matches(StringsKt.replace$default(str, "-", "", false, 4, (Object) null));
    }
}
