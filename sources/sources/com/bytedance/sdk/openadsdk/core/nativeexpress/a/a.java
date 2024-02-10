package com.bytedance.sdk.openadsdk.core.nativeexpress.a;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.utils.ad;

/* compiled from: DynamicViewUtils */
public class a {
    public static Pair<Float, Float> a(Window window, int i) {
        View decorView = window.getDecorView();
        float[] fArr = {(float) (decorView.getWidth() - (decorView.getPaddingLeft() * 2)), (float) (decorView.getHeight() - (decorView.getPaddingTop() * 2))};
        fArr[0] = (float) ad.c(window.getContext(), fArr[0]);
        float c = (float) ad.c(window.getContext(), fArr[1]);
        fArr[1] = c;
        if (fArr[0] < 10.0f || c < 10.0f) {
            l.b("DynamicViewUtils", "get root view size error, so run backup");
            fArr = a(window.getContext(), ad.c(window.getContext(), ad.a()), i);
        }
        float max = Math.max(fArr[0], fArr[1]);
        float min = Math.min(fArr[0], fArr[1]);
        if (i == 1) {
            fArr[0] = min;
            fArr[1] = max;
        } else {
            fArr[0] = max;
            fArr[1] = min;
        }
        return new Pair<>(Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
    }

    private static float[] a(Context context, int i, int i2) {
        float a = a(context);
        float b = b(context);
        if ((i2 == 1) != (a > b)) {
            float f = a + b;
            b = f - b;
            a = f - b;
        }
        if (i2 == 1) {
            a -= (float) i;
        } else {
            b -= (float) i;
        }
        return new float[]{b, a};
    }

    public static float a(Context context) {
        return (float) ad.c(context, (float) ad.i(context));
    }

    public static float b(Context context) {
        return (float) ad.c(context, (float) ad.j(context));
    }
}
