package com.mbridge.msdk.dycreator.baseview;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;

public class GradientOrientationUtils {
    public static GradientDrawable.Orientation getOrientation(String str) {
        try {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            if (!TextUtils.equals(str, GradientDrawable.Orientation.TOP_BOTTOM.name())) {
                if (TextUtils.equals(str, GradientDrawable.Orientation.BL_TR.name())) {
                    return GradientDrawable.Orientation.BL_TR;
                }
                if (TextUtils.equals(str, GradientDrawable.Orientation.BOTTOM_TOP.name())) {
                    return GradientDrawable.Orientation.BOTTOM_TOP;
                }
                if (TextUtils.equals(str, GradientDrawable.Orientation.BR_TL.name())) {
                    return GradientDrawable.Orientation.BR_TL;
                }
                if (TextUtils.equals(str, GradientDrawable.Orientation.LEFT_RIGHT.name())) {
                    return GradientDrawable.Orientation.LEFT_RIGHT;
                }
                if (TextUtils.equals(str, GradientDrawable.Orientation.RIGHT_LEFT.name())) {
                    return GradientDrawable.Orientation.RIGHT_LEFT;
                }
                if (TextUtils.equals(str, GradientDrawable.Orientation.TL_BR.name())) {
                    return GradientDrawable.Orientation.TL_BR;
                }
                if (TextUtils.equals(str, GradientDrawable.Orientation.BR_TL.name())) {
                    return GradientDrawable.Orientation.BR_TL;
                }
            }
            return GradientDrawable.Orientation.TOP_BOTTOM;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.TOP_BOTTOM;
        }
    }
}
