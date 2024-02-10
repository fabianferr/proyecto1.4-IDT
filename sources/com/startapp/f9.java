package com.startapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Set;

/* compiled from: Sta */
public class f9 {
    public static int a(Context context, int i) {
        return i0.a(context, 1, (float) i);
    }

    public static int b(Context context, int i) {
        return Math.round(((float) i) / context.getResources().getDisplayMetrics().density);
    }

    public static void a(TextView textView, Set<String> set) {
        int i;
        if (set.contains("UNDERLINE")) {
            textView.setPaintFlags(textView.getPaintFlags() | 8);
        }
        if (set.contains("BOLD") && set.contains("ITALIC")) {
            i = 3;
        } else if (set.contains("BOLD")) {
            i = 1;
        } else {
            i = set.contains("ITALIC") ? 2 : 0;
        }
        textView.setTypeface((Typeface) null, i);
    }

    public static TextView a(Context context, TextView textView, Typeface typeface, int i, float f, int i2, int i3) {
        TextView textView2 = new TextView(context);
        textView2.setTypeface(typeface, i);
        textView2.setTextSize(1, f);
        textView2.setSingleLine(true);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTextColor(i2);
        textView2.setId(i3);
        return textView2;
    }

    public static RelativeLayout.LayoutParams a(Context context, int[] iArr, int[] iArr2) {
        int i;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        for (int addRule : iArr2) {
            layoutParams.addRule(addRule);
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                i = 0;
            } else {
                i = i0.a(context, 1, (float) i3);
            }
            iArr[i2] = i;
        }
        layoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        return layoutParams;
    }

    public static ImageView a(Context context, ImageView imageView, Bitmap bitmap, int i) {
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageBitmap(bitmap);
        imageView2.setId(i);
        return imageView2;
    }

    public static void a(Context context, WindowManager windowManager, Point point) {
        windowManager.getDefaultDisplay().getSize(point);
        point.x = Math.round(((float) point.x) / context.getResources().getDisplayMetrics().density);
        point.y = Math.round(((float) point.y) / context.getResources().getDisplayMetrics().density);
    }
}
