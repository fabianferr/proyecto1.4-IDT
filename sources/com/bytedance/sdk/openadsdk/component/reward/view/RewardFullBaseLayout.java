package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.component.reward.b.b;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;

public class RewardFullBaseLayout extends PAGFrameLayout {
    public RewardFullBaseLayout(Context context) {
        super(context);
    }

    public void a(b bVar) {
        bVar.a(this);
        RFEndCardBackUpLayout h = bVar.h();
        if (h != null) {
            addView(h, new FrameLayout.LayoutParams(-1, -1));
        }
        a(bVar.i(), this);
        a(bVar.j(), this);
    }

    private void a(View view, ViewGroup viewGroup) {
        if (view != null) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }
}
