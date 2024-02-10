package com.wortise.ads;

import android.content.Context;
import android.view.View;
import com.wortise.ads.device.Dimensions;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\"\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/wortise/ads/AdSize;", "", "width", "", "height", "(II)V", "googleAdSize", "Lcom/google/android/gms/ads/AdSize;", "Lcom/wortise/ads/google/extensions/GoogleAdSize;", "getGoogleAdSize$sdk_productionRelease", "()Lcom/google/android/gms/ads/AdSize;", "setGoogleAdSize$sdk_productionRelease", "(Lcom/google/android/gms/ads/AdSize;)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "getHeightPixelSize", "context", "Landroid/content/Context;", "getWidthPixelSize", "hashCode", "toString", "", "Companion", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AdSize.kt */
public final class AdSize {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final AdSize HEIGHT_250 = new AdSize(0, 250, 1, (DefaultConstructorMarker) null);
    public static final AdSize HEIGHT_280 = new AdSize(0, 280, 1, (DefaultConstructorMarker) null);
    public static final AdSize HEIGHT_50 = new AdSize(0, 50, 1, (DefaultConstructorMarker) null);
    public static final AdSize HEIGHT_90 = new AdSize(0, 90, 1, (DefaultConstructorMarker) null);
    public static final AdSize MATCH_VIEW = new AdSize(0, 0, 3, (DefaultConstructorMarker) null);
    private com.google.android.gms.ads.AdSize googleAdSize;
    private final int height;
    private final int width;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J$\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0010H\u0007J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0010H\u0007J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/wortise/ads/AdSize$Companion;", "", "()V", "HEIGHT_250", "Lcom/wortise/ads/AdSize;", "HEIGHT_280", "HEIGHT_50", "HEIGHT_90", "MATCH_VIEW", "from", "value", "", "getAnchoredAdaptiveBannerAdSize", "context", "Landroid/content/Context;", "width", "", "container", "Landroid/view/View;", "getInlineAdaptiveBannerAdSize", "maxHeight", "getWidth", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AdSize.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ AdSize getAnchoredAdaptiveBannerAdSize$default(Companion companion, Context context, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.getAnchoredAdaptiveBannerAdSize(context, i);
        }

        public static /* synthetic */ AdSize getInlineAdaptiveBannerAdSize$default(Companion companion, View view, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.getInlineAdaptiveBannerAdSize(view, i);
        }

        private final int getWidth(Context context, int i) {
            Integer valueOf = Integer.valueOf(i);
            if (!(valueOf.intValue() > 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                return valueOf.intValue();
            }
            Dimensions a = o2.a.a(context);
            if (a == null) {
                return 0;
            }
            return a.b(context);
        }

        @JvmStatic
        public final AdSize from(String str) {
            return p.a.a(str);
        }

        @JvmStatic
        public final AdSize getAnchoredAdaptiveBannerAdSize(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getAnchoredAdaptiveBannerAdSize$default(this, context, 0, 2, (Object) null);
        }

        @JvmStatic
        public final AdSize getAnchoredAdaptiveBannerAdSize(View view) {
            Intrinsics.checkNotNullParameter(view, "container");
            Companion companion = AdSize.Companion;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            return companion.getAnchoredAdaptiveBannerAdSize(context, r2.d(context2, Integer.valueOf(view.getWidth())));
        }

        @JvmStatic
        public final AdSize getInlineAdaptiveBannerAdSize(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getInlineAdaptiveBannerAdSize$default(this, context, 0, 0, 6, (Object) null);
        }

        @JvmStatic
        public final AdSize getInlineAdaptiveBannerAdSize(Context context, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getInlineAdaptiveBannerAdSize$default(this, context, i, 0, 4, (Object) null);
        }

        @JvmStatic
        public final AdSize getInlineAdaptiveBannerAdSize(View view) {
            Intrinsics.checkNotNullParameter(view, "container");
            return getInlineAdaptiveBannerAdSize$default(this, view, 0, 2, (Object) null);
        }

        @JvmStatic
        public final AdSize getInlineAdaptiveBannerAdSize(View view, int i) {
            Intrinsics.checkNotNullParameter(view, "container");
            Companion companion = AdSize.Companion;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            return companion.getInlineAdaptiveBannerAdSize(context, r2.d(context2, Integer.valueOf(view.getWidth())), i);
        }

        public static /* synthetic */ AdSize getInlineAdaptiveBannerAdSize$default(Companion companion, Context context, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            return companion.getInlineAdaptiveBannerAdSize(context, i, i2);
        }

        @JvmStatic
        public final AdSize getAnchoredAdaptiveBannerAdSize(Context context, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            com.google.android.gms.ads.AdSize currentOrientationAnchoredAdaptiveBannerAdSize = com.google.android.gms.ads.AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, getWidth(context, i));
            Intrinsics.checkNotNullExpressionValue(currentOrientationAnchoredAdaptiveBannerAdSize, "getCurrentOrientationAnc…ext, width)\n            )");
            return p.a.a(currentOrientationAnchoredAdaptiveBannerAdSize);
        }

        @JvmStatic
        public final AdSize getInlineAdaptiveBannerAdSize(Context context, int i, int i2) {
            com.google.android.gms.ads.AdSize adSize;
            Intrinsics.checkNotNullParameter(context, "context");
            int width = getWidth(context, i);
            if (i2 >= 32) {
                adSize = com.google.android.gms.ads.AdSize.getInlineAdaptiveBannerAdSize(width, i2);
            } else {
                adSize = com.google.android.gms.ads.AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(context, width);
            }
            Intrinsics.checkNotNullExpressionValue(adSize, "if (maxHeight >= 32) {\n …context, w)\n            }");
            return p.a.a(adSize);
        }
    }

    public AdSize() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public AdSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public static /* synthetic */ AdSize copy$default(AdSize adSize, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = adSize.width;
        }
        if ((i3 & 2) != 0) {
            i2 = adSize.height;
        }
        return adSize.copy(i, i2);
    }

    @JvmStatic
    public static final AdSize from(String str) {
        return Companion.from(str);
    }

    @JvmStatic
    public static final AdSize getAnchoredAdaptiveBannerAdSize(Context context) {
        return Companion.getAnchoredAdaptiveBannerAdSize(context);
    }

    @JvmStatic
    public static final AdSize getAnchoredAdaptiveBannerAdSize(Context context, int i) {
        return Companion.getAnchoredAdaptiveBannerAdSize(context, i);
    }

    @JvmStatic
    public static final AdSize getAnchoredAdaptiveBannerAdSize(View view) {
        return Companion.getAnchoredAdaptiveBannerAdSize(view);
    }

    @JvmStatic
    public static final AdSize getInlineAdaptiveBannerAdSize(Context context) {
        return Companion.getInlineAdaptiveBannerAdSize(context);
    }

    @JvmStatic
    public static final AdSize getInlineAdaptiveBannerAdSize(Context context, int i) {
        return Companion.getInlineAdaptiveBannerAdSize(context, i);
    }

    @JvmStatic
    public static final AdSize getInlineAdaptiveBannerAdSize(Context context, int i, int i2) {
        return Companion.getInlineAdaptiveBannerAdSize(context, i, i2);
    }

    @JvmStatic
    public static final AdSize getInlineAdaptiveBannerAdSize(View view) {
        return Companion.getInlineAdaptiveBannerAdSize(view);
    }

    @JvmStatic
    public static final AdSize getInlineAdaptiveBannerAdSize(View view, int i) {
        return Companion.getInlineAdaptiveBannerAdSize(view, i);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final AdSize copy(int i, int i2) {
        return new AdSize(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.width == adSize.width && this.height == adSize.height;
    }

    public final com.google.android.gms.ads.AdSize getGoogleAdSize$sdk_productionRelease() {
        return this.googleAdSize;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getHeightPixelSize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return r2.b(context, Integer.valueOf(this.height));
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getWidthPixelSize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return r2.b(context, Integer.valueOf(this.width));
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public final void setGoogleAdSize$sdk_productionRelease(com.google.android.gms.ads.AdSize adSize) {
        this.googleAdSize = adSize;
    }

    public String toString() {
        return "AdSize(width=" + this.width + ", height=" + this.height + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdSize(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? -1 : i2);
    }
}
