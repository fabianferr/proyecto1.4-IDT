package com.wortise.ads;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¨\u0006\u0005"}, d2 = {"", "algorithm", "", "a", "b", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: Hash.kt */
public final class p3 {
    public static final byte[] a(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str2);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "getInstance(algorithm).digest(toByteArray())");
        return digest;
    }

    public static final String b(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "algorithm");
        return w0.a(a(str, str2));
    }
}
