package com.wortise.ads;

import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"Landroid/net/Uri;", "", "scheme", "", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: Uri.kt */
public final class p6 {
    /* access modifiers changed from: private */
    public static final List<String> a = CollectionsKt.listOf("about");

    public static final boolean a(Uri uri, String str) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(str, "scheme");
        return StringsKt.equals(uri.getScheme(), str, true);
    }
}
