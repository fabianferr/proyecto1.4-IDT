package com.wortise.ads;

import android.app.Activity;
import android.content.Context;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.wortise.ads.device.ScreenOrientation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u0006\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u0010\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/wortise/ads/q2;", "", "Lcom/wortise/ads/device/ScreenOrientation;", "orientation", "", "current", "a", "Landroid/content/Context;", "context", "", "Landroid/app/Activity;", "activity", "", "isEmulator$delegate", "Lkotlin/Lazy;", "()Z", "isEmulator", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: DeviceUtils.kt */
public final class q2 {
    public static final q2 a = new q2();
    private static final Lazy b = LazyKt.lazy(b.a);

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DeviceUtils.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScreenOrientation.values().length];
            iArr[ScreenOrientation.LANDSCAPE.ordinal()] = 1;
            iArr[ScreenOrientation.PORTRAIT.ordinal()] = 2;
            a = iArr;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000b\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: DeviceUtils.kt */
    static final class b extends Lambda implements Function0<Boolean> {
        public static final b a = new b();

        b() {
            super(0);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0083, code lost:
            if (kotlin.text.StringsKt.startsWith$default(r0, "generic", false, 2, (java.lang.Object) null) == false) goto L_0x0085;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0095, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) android.os.Build.PRODUCT, (java.lang.Object) "google_sdk") == false) goto L_0x0098;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Boolean invoke() {
            /*
                r12 = this;
                java.lang.String r0 = android.os.Build.FINGERPRINT
                java.lang.String r1 = "FINGERPRINT"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.String r2 = "generic"
                r3 = 0
                r4 = 2
                r5 = 0
                boolean r6 = kotlin.text.StringsKt.startsWith$default(r0, r2, r3, r4, r5)
                r7 = 1
                if (r6 != 0) goto L_0x0097
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.String r1 = "unknown"
                boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r1, r3, r4, r5)
                if (r0 != 0) goto L_0x0097
                java.lang.String r0 = android.os.Build.DEVICE
                java.lang.String r1 = "DEVICE"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.String r6 = "emulator"
                boolean r8 = kotlin.text.StringsKt.contains((java.lang.CharSequence) r0, (java.lang.CharSequence) r6, (boolean) r7)
                if (r8 != 0) goto L_0x0097
                java.lang.String r8 = android.os.Build.MODEL
                java.lang.String r9 = "MODEL"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
                java.lang.String r10 = "google_sdk"
                boolean r11 = kotlin.text.StringsKt.contains((java.lang.CharSequence) r8, (java.lang.CharSequence) r10, (boolean) r7)
                if (r11 != 0) goto L_0x0097
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
                boolean r6 = kotlin.text.StringsKt.contains((java.lang.CharSequence) r8, (java.lang.CharSequence) r6, (boolean) r7)
                if (r6 != 0) goto L_0x0097
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
                java.lang.String r6 = "Android SDK built for x86"
                boolean r6 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r6, (boolean) r3, (int) r4, (java.lang.Object) r5)
                if (r6 != 0) goto L_0x0097
                java.lang.String r6 = android.os.Build.MANUFACTURER
                java.lang.String r8 = "MANUFACTURER"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
                java.lang.String r8 = "genymotion"
                boolean r6 = kotlin.text.StringsKt.contains((java.lang.CharSequence) r6, (java.lang.CharSequence) r8, (boolean) r7)
                if (r6 != 0) goto L_0x0097
                java.lang.String r6 = android.os.Build.HOST
                java.lang.String r8 = "HOST"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
                java.lang.String r8 = "Build"
                boolean r6 = kotlin.text.StringsKt.startsWith$default(r6, r8, r3, r4, r5)
                if (r6 != 0) goto L_0x0097
                java.lang.String r6 = android.os.Build.BRAND
                java.lang.String r8 = "BRAND"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
                boolean r6 = kotlin.text.StringsKt.startsWith$default(r6, r2, r3, r4, r5)
                if (r6 == 0) goto L_0x0085
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r2, r3, r4, r5)
                if (r0 != 0) goto L_0x0097
            L_0x0085:
                java.lang.String r0 = android.os.Build.BOARD
                java.lang.String r1 = "QC_Reference_Phone"
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
                if (r0 != 0) goto L_0x0097
                java.lang.String r0 = android.os.Build.PRODUCT
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r10)
                if (r0 == 0) goto L_0x0098
            L_0x0097:
                r3 = 1
            L_0x0098:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.q2.b.invoke():java.lang.Boolean");
        }
    }

    private q2() {
    }

    public final boolean a() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public final void a(Activity activity, ScreenOrientation screenOrientation) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(screenOrientation, AdUnitActivity.EXTRA_ORIENTATION);
        activity.setRequestedOrientation(a(screenOrientation, activity.getResources().getConfiguration().orientation));
    }

    private final int a(ScreenOrientation screenOrientation, int i) {
        int i2 = a.a[screenOrientation.ordinal()];
        if (i2 == 1) {
            return i == 8 ? 8 : 0;
        }
        if (i2 == 2) {
            return i == 9 ? 9 : 1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
