package com.wortise.ads;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/wortise/ads/x4;", "Lcom/wortise/ads/o0;", "Landroid/net/Uri;", "uri", "", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: MarketUriHandler.kt */
public final class x4 extends o0 {
    public static final x4 a = new x4();
    private static final List<String> b = CollectionsKt.listOf("market.android.com", "play.google.com");
    private static final Lazy c = LazyKt.lazy(a.a);

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Landroid/net/Uri;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: MarketUriHandler.kt */
    static final class a extends Lambda implements Function0<Uri> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final Uri invoke() {
            return Uri.parse("market://details");
        }
    }

    private x4() {
    }

    public boolean a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return CollectionsKt.contains(b, uri.getHost());
    }
}
