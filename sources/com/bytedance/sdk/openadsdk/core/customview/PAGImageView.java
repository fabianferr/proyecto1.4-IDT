package com.bytedance.sdk.openadsdk.core.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PAGImageView extends ImageView {
    public PAGImageView(Context context) {
        super(context);
    }

    public PAGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PAGImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        a.a(layoutParams);
        super.setLayoutParams(layoutParams);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
    }
}
