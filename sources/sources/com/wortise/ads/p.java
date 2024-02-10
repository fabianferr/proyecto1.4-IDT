package com.wortise.ads;

import com.google.android.gms.ads.AdSize;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/p;", "", "Lcom/google/android/gms/ads/AdSize;", "Lcom/wortise/ads/google/extensions/GoogleAdSize;", "size", "Lcom/wortise/ads/AdSize;", "a", "", "value", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdSizeFactory.kt */
public final class p {
    public static final p a = new p();

    private p() {
    }

    public final AdSize a(AdSize adSize) {
        Intrinsics.checkNotNullParameter(adSize, "size");
        AdSize adSize2 = new AdSize(adSize.getWidth(), adSize.getHeight());
        adSize2.setGoogleAdSize$sdk_productionRelease(adSize);
        return adSize2;
    }

    public final AdSize a(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            str2 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        if (str2 == null) {
            return null;
        }
        switch (str2.hashCode()) {
            case -1614482253:
                if (!str2.equals("height_50")) {
                    return null;
                }
                return AdSize.HEIGHT_50;
            case -1614482129:
                if (!str2.equals("height_90")) {
                    return null;
                }
                return AdSize.HEIGHT_90;
            case 1490655029:
                if (!str2.equals("height_250")) {
                    return null;
                }
                return AdSize.HEIGHT_250;
            case 1490655122:
                if (!str2.equals("height_280")) {
                    return null;
                }
                return AdSize.HEIGHT_280;
            case 1865313503:
                if (!str2.equals("match_view")) {
                    return null;
                }
                return AdSize.MATCH_VIEW;
            default:
                return null;
        }
    }
}
