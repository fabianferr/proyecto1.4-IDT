package com.wortise.ads;

import android.content.Context;
import com.google.android.gms.ads.RequestConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/wortise/ads/v5;", "", "Landroid/content/Context;", "context", "", "b", "Lcom/google/android/gms/ads/RequestConfiguration;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: RequestConfigurationFactory.kt */
public final class v5 {
    public static final v5 a = new v5();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: RequestConfigurationFactory.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AdContentRating.values().length];
            iArr[AdContentRating.G.ordinal()] = 1;
            iArr[AdContentRating.MA.ordinal()] = 2;
            iArr[AdContentRating.PG.ordinal()] = 3;
            iArr[AdContentRating.T.ordinal()] = 4;
            a = iArr;
        }
    }

    private v5() {
    }

    private final String b(Context context) {
        AdContentRating maxAdContentRating = AdSettings.getMaxAdContentRating(context);
        int i = maxAdContentRating == null ? -1 : a.a[maxAdContentRating.ordinal()];
        if (i == 1) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_G;
        }
        if (i == 2) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_MA;
        }
        if (i != 3) {
            return i != 4 ? "" : "T";
        }
        return RequestConfiguration.MAX_AD_CONTENT_RATING_PG;
    }

    public final RequestConfiguration a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestConfiguration.Builder builder = new RequestConfiguration.Builder();
        if (AdSettings.isChildDirected(context)) {
            builder.setTagForChildDirectedTreatment(1);
        }
        builder.setMaxAdContentRating(a.b(context));
        RequestConfiguration build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build");
        return build;
    }
}
