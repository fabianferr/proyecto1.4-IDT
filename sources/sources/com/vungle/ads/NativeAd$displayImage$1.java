package com.vungle.ads;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.vungle.ads.internal.util.ThreadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NativeAd.kt */
final class NativeAd$displayImage$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ ImageView $imageView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NativeAd$displayImage$1(ImageView imageView) {
        super(1);
        this.$imageView = imageView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Bitmap) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "it");
        if (this.$imageView != null) {
            ThreadUtil.INSTANCE.runOnUiThread(new NativeAd$displayImage$1$$ExternalSyntheticLambda0(this.$imageView, bitmap));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2271invoke$lambda0(ImageView imageView, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "$it");
        imageView.setImageBitmap(bitmap);
    }
}
