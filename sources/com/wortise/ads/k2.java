package com.wortise.ads;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/wortise/ads/k2;", "Lcom/wortise/ads/o0;", "Landroid/net/Uri;", "uri", "", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: DefaultUriHandler.kt */
public final class k2 extends o0 {
    public static final k2 a = new k2();

    private k2() {
    }

    public boolean a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        String scheme = uri.getScheme();
        boolean z = false;
        if ((scheme == null || scheme.length() == 0) || CollectionsKt.contains(p6.a, uri.getScheme())) {
            z = true;
        }
        return !z;
    }
}
