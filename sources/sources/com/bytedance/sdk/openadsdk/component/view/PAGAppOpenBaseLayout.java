package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.DSPAdChoice;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;

public class PAGAppOpenBaseLayout extends PAGRelativeLayout {
    PAGImageView a;
    PAGFrameLayout b;
    PAGImageView c;
    PAGTextView d;
    ButtonFlash e;
    PAGLinearLayout f;
    TTRoundRectImageView g;
    PAGTextView h;
    final PAGAppOpenTopBarView i;
    TTRoundRectImageView j;
    PAGTextView k;
    PAGTextView l;
    DSPAdChoice m;

    public PAGAppOpenBaseLayout(Context context) {
        super(context);
        this.i = new PAGAppOpenTopBarView(context);
    }

    public TTRoundRectImageView getIconOnlyView() {
        return this.j;
    }

    public PAGTextView getTitle() {
        return this.k;
    }

    public PAGTextView getContent() {
        return this.l;
    }

    public PAGImageView getBackImage() {
        return this.a;
    }

    public PAGFrameLayout getVideoContainer() {
        return this.b;
    }

    public PAGImageView getImageView() {
        return this.c;
    }

    public PAGTextView getAdLogo() {
        return this.d;
    }

    public ButtonFlash getClickButton() {
        return this.e;
    }

    public PAGLinearLayout getUserInfo() {
        return this.f;
    }

    public TTRoundRectImageView getAppIcon() {
        return this.g;
    }

    public PAGTextView getAppName() {
        return this.h;
    }

    public DSPAdChoice getDspAdChoice() {
        return this.m;
    }

    public TextView getTopDisLike() {
        PAGAppOpenTopBarView pAGAppOpenTopBarView = this.i;
        if (pAGAppOpenTopBarView != null) {
            return pAGAppOpenTopBarView.getTopDislike();
        }
        return null;
    }

    public TextView getTopSkip() {
        PAGAppOpenTopBarView pAGAppOpenTopBarView = this.i;
        if (pAGAppOpenTopBarView != null) {
            return pAGAppOpenTopBarView.getTopSkip();
        }
        return null;
    }
}
