package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.c.d;
import com.bytedance.sdk.component.adexpress.dynamic.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.utils.s;

public class DynamicMutedView extends DynamicBaseWidgetImp implements b {
    public boolean e() {
        return true;
    }

    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.o = new ImageView(context);
        this.o.setTag(5);
        addView(this.o, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
    }

    public boolean i() {
        super.i();
        if (d.b(this.n.getRenderRequest().d())) {
            ((ImageView) this.o).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.o).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.n.b);
        GradientDrawable gradientDrawable = (GradientDrawable) s.c(getContext(), "tt_ad_skip_btn_bg");
        GradientDrawable gradientDrawable2 = gradientDrawable;
        gradientDrawable.setCornerRadius((float) (this.h / 2));
        gradientDrawable.setColor(this.l.y());
        ((ImageView) this.o).setBackgroundDrawable(gradientDrawable);
        return true;
    }

    public void setSoundMute(boolean z) {
        int i;
        if (d.b(this.n.getRenderRequest().d())) {
            if (z) {
                i = s.d(getContext(), "tt_reward_full_mute");
            } else {
                i = s.d(getContext(), "tt_reward_full_unmute");
            }
        } else if (z) {
            i = s.d(getContext(), "tt_mute");
        } else {
            i = s.d(getContext(), "tt_unmute");
        }
        ((ImageView) this.o).setImageResource(i);
        if (((ImageView) this.o).getDrawable() != null) {
            ((ImageView) this.o).getDrawable().setAutoMirrored(true);
        }
    }
}
