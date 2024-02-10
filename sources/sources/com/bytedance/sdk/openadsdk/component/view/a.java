package com.bytedance.sdk.openadsdk.component.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.ad;

/* compiled from: TTAppOpenAdUserInfoLayoutHelper */
public class a {
    private static boolean a;
    private static Drawable b;
    private LinearLayout c;
    private TTRoundRectImageView d;
    private TextView e;

    public void a(PAGAppOpenBaseLayout pAGAppOpenBaseLayout, q qVar, float f, float f2, boolean z) {
        if (pAGAppOpenBaseLayout != null) {
            this.c = pAGAppOpenBaseLayout.getUserInfo();
            this.d = pAGAppOpenBaseLayout.getAppIcon();
            this.e = pAGAppOpenBaseLayout.getAppName();
            this.c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                }
            });
        }
        a(qVar, f, f2, z);
    }

    public void a() {
        String e2 = h.b().e();
        if (TextUtils.isEmpty(e2)) {
            this.e.setVisibility(8);
        } else {
            this.e.setText(e2);
        }
        b();
        try {
            Drawable drawable = b;
            if (drawable == null) {
                this.d.setVisibility(8);
                return;
            }
            this.d.setImageDrawable(drawable);
            if (this.e.getVisibility() == 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, 0);
                this.d.setLayoutParams(marginLayoutParams);
            }
        } catch (Throwable unused) {
            this.d.setVisibility(8);
        }
    }

    public void b() {
        if (!a) {
            try {
                int f = h.b().f();
                if (f != 0) {
                    b = ResourcesCompat.getDrawable(o.a().getResources(), f, (Resources.Theme) null);
                }
            } catch (Throwable unused) {
            }
            a = true;
        }
    }

    public static Drawable c() {
        return b;
    }

    private void a(q qVar, float f, float f2, boolean z) {
        int i;
        int i2;
        int l = qVar.l();
        if (l == 1 || l == 3) {
            if (z) {
                i = qVar.K().c();
                i2 = qVar.K().b();
            } else {
                i = qVar.Q().get(0).b();
                i2 = qVar.Q().get(0).c();
            }
            if (i > 0 && i2 > 0) {
                float f3 = (float) i2;
                float min = f2 - (f3 * Math.min(f / ((float) i), f2 / f3));
                try {
                    float b2 = (float) ad.b(o.a(), 60.0f);
                    if (min < b2) {
                        min = b2;
                    }
                    this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) min));
                } catch (Throwable unused) {
                }
            }
        }
    }
}
