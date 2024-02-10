package com.unity3d.services.banners;

import android.content.Context;
import com.unity3d.services.core.misc.ViewUtilities;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/unity3d/services/banners/UnityBannerSize;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UnityBannerSize.kt */
public final class UnityBannerSize {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final UnityBannerSize iabStandard = new UnityBannerSize(468, 60);
    /* access modifiers changed from: private */
    public static final UnityBannerSize leaderboard = new UnityBannerSize(728, 90);
    /* access modifiers changed from: private */
    public static final UnityBannerSize standard = new UnityBannerSize(320, 50);
    private final int height;
    private final int width;

    @JvmStatic
    public static final UnityBannerSize getDynamicSize(Context context) {
        return Companion.getDynamicSize(context);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/unity3d/services/banners/UnityBannerSize$Companion;", "", "()V", "iabStandard", "Lcom/unity3d/services/banners/UnityBannerSize;", "getIabStandard", "()Lcom/unity3d/services/banners/UnityBannerSize;", "leaderboard", "getLeaderboard", "standard", "getStandard", "getDynamicSize", "context", "Landroid/content/Context;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UnityBannerSize.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UnityBannerSize getLeaderboard() {
            return UnityBannerSize.leaderboard;
        }

        public final UnityBannerSize getIabStandard() {
            return UnityBannerSize.iabStandard;
        }

        public final UnityBannerSize getStandard() {
            return UnityBannerSize.standard;
        }

        @JvmStatic
        public final UnityBannerSize getDynamicSize(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int roundToInt = MathKt.roundToInt(ViewUtilities.dpFromPx(context, (float) context.getResources().getDisplayMetrics().widthPixels));
            if (roundToInt >= getLeaderboard().getWidth()) {
                return getLeaderboard();
            }
            if (roundToInt >= getIabStandard().getWidth()) {
                return getIabStandard();
            }
            return getStandard();
        }
    }

    public UnityBannerSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }
}
