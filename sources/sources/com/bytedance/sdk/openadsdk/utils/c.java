package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.model.q;

/* compiled from: AdmobOverlayHelper */
public class c {
    public static void a(ViewGroup viewGroup, q qVar) {
        if (viewGroup != null && qVar != null && !TextUtils.isEmpty(qVar.bq())) {
            try {
                if (viewGroup.getTag(i.bu) == null) {
                    viewGroup.setTag(i.bu, Integer.valueOf(i.bu));
                    Drawable a2 = a(viewGroup.getResources(), qVar);
                    if (a2 != null) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            viewGroup.setForeground(a2);
                            return;
                        }
                        viewGroup.getOverlay().add(a2);
                        viewGroup.addOnLayoutChangeListener(new a(a2));
                    }
                }
            } catch (Throwable th) {
                l.e("add overlay fail", th.getMessage());
            }
        }
    }

    public static void a(Activity activity, q qVar) {
        if (activity != null && qVar != null && !TextUtils.isEmpty(qVar.bq())) {
            try {
                if (activity.getWindow().getDecorView().getTag(i.bu) == null) {
                    activity.getWindow().getDecorView().setTag(i.bu, Integer.valueOf(i.bu));
                    Drawable a2 = a(activity.getResources(), qVar);
                    if (a2 != null) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            activity.getWindow().getDecorView().setForeground(a2);
                            return;
                        }
                        activity.getWindow().getDecorView().getOverlay().add(a2);
                        activity.getWindow().getDecorView().addOnLayoutChangeListener(new a(a2));
                    }
                }
            } catch (Throwable th) {
                l.e("add overlay fail", th.getMessage());
            }
        }
    }

    private static Drawable a(Resources resources, q qVar) {
        try {
            String bq = qVar.bq();
            if (TextUtils.isEmpty(bq)) {
                return null;
            }
            byte[] decode = Base64.decode(bq, 0);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeByteArray(decode, 0, decode.length));
            bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            bitmapDrawable.setTargetDensity(resources.getDisplayMetrics());
            return bitmapDrawable;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* compiled from: AdmobOverlayHelper */
    private static class a implements View.OnLayoutChangeListener {
        private final Drawable a;
        private int b;
        private int c;

        public a(Drawable drawable) {
            this.a = drawable;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i4 - i2;
            if (i9 != this.b || i10 != this.c) {
                this.b = i9;
                this.c = i10;
                this.a.setBounds(0, 0, i9, i10);
            }
        }
    }
}
