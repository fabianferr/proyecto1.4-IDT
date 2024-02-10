package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.c;
import com.bytedance.sdk.component.utils.s;

public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements c {
    private boolean a;

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.a = dynamicRootView.getRenderRequest().m();
        }
        this.g = this.h;
        this.o = new ImageView(context);
        this.o.setTag(Integer.valueOf(getClickArea()));
        addView(this.o, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
    }

    public boolean i() {
        int i;
        super.i();
        ((ImageView) this.o).setScaleType(ImageView.ScaleType.CENTER_CROP);
        GradientDrawable gradientDrawable = (GradientDrawable) s.c(getContext(), "tt_ad_skip_btn_bg");
        GradientDrawable gradientDrawable2 = gradientDrawable;
        gradientDrawable.setCornerRadius((float) (this.h / 2));
        gradientDrawable.setColor(this.l.y());
        ((ImageView) this.o).setBackgroundDrawable(gradientDrawable);
        if (this.a) {
            i = s.d(getContext(), "tt_close_move_details_normal");
        } else {
            i = s.d(getContext(), "tt_skip_btn_wrapper");
        }
        ((ImageView) this.o).setImageResource(i);
        setVisibility(8);
        return true;
    }

    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (z) {
            setVisibility(0);
            return;
        }
        if (!z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
