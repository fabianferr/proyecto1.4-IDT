package com.bytedance.sdk.openadsdk.core.customview;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* compiled from: RTLUtil */
public class a {
    public static int a(int i) {
        return ((i & 3) == 3 || (i & 5) == 5) ? i | 8388608 : i;
    }

    public static void a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMarginStart(marginLayoutParams.leftMargin);
                marginLayoutParams.setMarginEnd(marginLayoutParams.rightMargin);
            }
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = a(layoutParams2.gravity);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams3.gravity = a(layoutParams3.gravity);
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams4.getRules();
                if (rules[9] != 0) {
                    layoutParams4.addRule(20);
                }
                if (rules[11] != 0) {
                    layoutParams4.addRule(21);
                }
                int i = rules[0];
                if (i != 0) {
                    layoutParams4.addRule(16, i);
                }
                int i2 = rules[1];
                if (i2 != 0) {
                    layoutParams4.addRule(17, i2);
                }
                int i3 = rules[5];
                if (i3 != 0) {
                    layoutParams4.addRule(18, i3);
                }
                int i4 = rules[7];
                if (i4 != 0) {
                    layoutParams4.addRule(19, i4);
                }
            }
        }
    }
}
