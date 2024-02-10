package com.wortise.ads;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0000\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0010\u0010\u0004\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0001¨\u0006\t"}, d2 = {"", "", "values", "", "a", "([Ljava/lang/String;)V", "value", "Landroid/net/Uri;", "b", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: String.kt */
public final class h6 {
    public static final void a(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "values");
        for (String a : strArr) {
            a(a);
        }
    }

    public static final Uri b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Uri.parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final String a(String str) {
        if (str == null || str.length() == 0) {
            str = null;
        }
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null or empty.".toString());
    }
}
