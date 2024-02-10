package com.wortise.ads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/l4;", "Lcom/wortise/ads/f0;", "Landroid/net/Uri;", "uri", "", "a", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: IntentUriHandler.kt */
public final class l4 extends f0 {
    public static final l4 a = new l4();

    private l4() {
    }

    public boolean a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return p6.a(uri, "intent");
    }

    /* access modifiers changed from: protected */
    public Intent a(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intent parseUri = Intent.parseUri(uri.toString(), 1);
        Intrinsics.checkNotNullExpressionValue(parseUri, "parseUri(uri.toString(), URI_INTENT_SCHEME)");
        return parseUri;
    }
}
