package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.utils.s;

public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        if (d.b()) {
            this.o = new ImageView(context);
            ((ImageView) this.o).setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.g = this.h;
        } else {
            this.o = new TextView(context);
        }
        this.o.setTag(3);
        addView(this.o, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.o);
        if (dynamicRootView.getRenderRequest() != null && !dynamicRootView.getRenderRequest().h()) {
            this.o.setVisibility(8);
            setVisibility(8);
        }
    }

    public boolean i() {
        super.i();
        if (d.b()) {
            GradientDrawable gradientDrawable = (GradientDrawable) s.c(getContext(), "tt_ad_skip_btn_bg");
            GradientDrawable gradientDrawable2 = gradientDrawable;
            gradientDrawable.setCornerRadius((float) (this.h / 2));
            gradientDrawable.setColor(this.l.y());
            ((ImageView) this.o).setBackgroundDrawable(gradientDrawable);
            ((ImageView) this.o).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.o).setImageResource(s.d(getContext(), "tt_reward_full_feedback"));
            return true;
        }
        ((TextView) this.o).setText(getText());
        this.o.setTextAlignment(this.l.h());
        ((TextView) this.o).setTextColor(this.l.g());
        ((TextView) this.o).setTextSize(this.l.e());
        this.o.setBackground(getBackgroundDrawable());
        if (!this.l.v()) {
            ((TextView) this.o).setMaxLines(1);
            ((TextView) this.o).setGravity(17);
            ((TextView) this.o).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int w = this.l.w();
            if (w > 0) {
                ((TextView) this.o).setLines(w);
                ((TextView) this.o).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        this.o.setPadding((int) e.a(d.a(), (float) this.l.c()), (int) e.a(d.a(), (float) this.l.b()), (int) e.a(d.a(), (float) this.l.d()), (int) e.a(d.a(), (float) this.l.a()));
        ((TextView) this.o).setGravity(17);
        return true;
    }

    public String getText() {
        return s.a(d.a(), "tt_reward_feedback");
    }
}
