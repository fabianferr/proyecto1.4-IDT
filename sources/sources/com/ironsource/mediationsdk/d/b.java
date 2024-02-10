package com.ironsource.mediationsdk.d;

import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0007J%\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\u0010\u0005\u001a\u0004\u0018\u0001H\n2\u0006\u0010\u000b\u001a\u0002H\nH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/ironsource/mediationsdk/utilities/IronSourcePreconditions;", "", "()V", "checkNotNull", "", "reference", "errorMessage", "", "shouldThrowException", "protectNonNull", "T", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {
    static {
        new b();
    }

    private b() {
    }

    @JvmStatic
    public static final <T> T a(T t, T t2) {
        return t == null ? t2 : t;
    }

    @JvmStatic
    public static final boolean a(Object obj, String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        if (obj != null) {
            return true;
        }
        IronLog.API.error(str);
        return false;
    }
}
