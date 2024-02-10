package com.ironsource.mediationsdk;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

public class AdapterUtils {
    public static final int MIN_TABLET_DP_SIZE = 600;

    public static int dpToPixels(Context context, int i) {
        if (context != null) {
            return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "AdapterUtils dpToPixels - context is null, returning dpSize", 3);
        return i;
    }

    public static String getScreenSizeParams(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float min = Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
        float f = displayMetrics.xdpi;
        float f2 = displayMetrics.ydpi;
        float f3 = ((float) displayMetrics.widthPixels) / f;
        float f4 = ((float) displayMetrics.heightPixels) / f2;
        double sqrt = Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
        int i = context.getResources().getConfiguration().smallestScreenWidthDp;
        return "smallestWidth = " + min + " diagonalInches = " + sqrt + " smallScreenDpApi =  " + i;
    }

    public static boolean isLargeScreen(Context context) {
        if (context != null) {
            return context.getResources().getConfiguration().smallestScreenWidthDp >= 600;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "AdapterUtils isLargeScreen - context is null", 3);
        return false;
    }
}
