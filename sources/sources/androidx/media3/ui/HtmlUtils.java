package androidx.media3.ui;

import android.graphics.Color;
import androidx.media3.common.util.Util;

final class HtmlUtils {
    private HtmlUtils() {
    }

    public static String toCssRgba(int i) {
        double alpha = (double) Color.alpha(i);
        Double.isNaN(alpha);
        return Util.formatInvariant("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(alpha / 255.0d));
    }

    public static String cssAllClassDescendantsSelector(String str) {
        return "." + str + ",." + str + " *";
    }
}
