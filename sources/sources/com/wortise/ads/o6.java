package com.wortise.ads;

import android.content.Context;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/wortise/ads/o6;", "", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "", "a", "", "url", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: UriHandler.kt */
public final class o6 {
    public static final o6 a = new o6();
    private static final List<f0> b = CollectionsKt.listOf(l4.a, x4.a, k2.a);

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n"}, d2 = {"T", "", "R", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: TryMapper.kt */
    public static final class a extends Lambda implements Function1<f0, Boolean> {
        final /* synthetic */ Context a;
        final /* synthetic */ Uri b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context, Uri uri) {
            super(1);
            this.a = context;
            this.b = uri;
        }

        public final Boolean invoke(f0 f0Var) {
            try {
                return Boolean.valueOf(f0Var.b(this.a, this.b));
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/f0;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: UriHandler.kt */
    static final class b extends Lambda implements Function1<f0, Boolean> {
        final /* synthetic */ Uri a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Uri uri) {
            super(1);
            this.a = uri;
        }

        /* renamed from: a */
        public final Boolean invoke(f0 f0Var) {
            Intrinsics.checkNotNullParameter(f0Var, "it");
            return Boolean.valueOf(f0Var.a(this.a));
        }
    }

    private o6() {
    }

    public final boolean a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
        return a(context, parse);
    }

    public final boolean a(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        String scheme = uri.getScheme();
        if ((scheme == null || scheme.length() == 0) || CollectionsKt.contains(p6.a, uri.getScheme())) {
            return false;
        }
        for (R booleanValue : SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(b), new b(uri)), new a(context, uri))) {
            if (booleanValue.booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
