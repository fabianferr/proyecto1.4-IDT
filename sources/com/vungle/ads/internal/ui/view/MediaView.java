package com.vungle.ads.internal.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\r\u001a\u00020\u000eJ\r\u0010\u000f\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MediaView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageView", "Landroid/widget/ImageView;", "destroy", "", "getMainImage", "getMainImage$vungle_ads_release", "initView", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MediaView.kt */
public final class MediaView extends RelativeLayout {
    private ImageView imageView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }

    private final void initView(Context context) {
        this.imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ImageView imageView2 = this.imageView;
        ImageView imageView3 = null;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView2 = null;
        }
        imageView2.setLayoutParams(layoutParams);
        ImageView imageView4 = this.imageView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView4 = null;
        }
        imageView4.setAdjustViewBounds(true);
        ImageView imageView5 = this.imageView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        } else {
            imageView3 = imageView5;
        }
        addView(imageView3);
        requestLayout();
    }

    public final ImageView getMainImage$vungle_ads_release() {
        ImageView imageView2 = this.imageView;
        if (imageView2 != null) {
            return imageView2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        return null;
    }

    public final void destroy() {
        ImageView imageView2 = this.imageView;
        ImageView imageView3 = null;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView2 = null;
        }
        imageView2.setImageDrawable((Drawable) null);
        ImageView imageView4 = this.imageView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView4 = null;
        }
        if (imageView4.getParent() != null) {
            ImageView imageView5 = this.imageView;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
                imageView5 = null;
            }
            ViewParent parent = imageView5.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            ImageView imageView6 = this.imageView;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            } else {
                imageView3 = imageView6;
            }
            viewGroup.removeView(imageView3);
        }
    }
}
