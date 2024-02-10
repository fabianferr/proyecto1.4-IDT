package com.bytedance.sdk.openadsdk.component.reward.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.d;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.top.b;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

/* compiled from: RewardFullTopProxyManager */
public class j {
    TopProxyLayout a;
    d b;
    private final Activity c;
    private final a d;
    private boolean e = false;

    public j(a aVar) {
        this.c = aVar.V;
        this.d = aVar;
    }

    public void a() {
        if (!this.e) {
            this.e = true;
            TopProxyLayout topProxyLayout = (TopProxyLayout) this.c.findViewById(i.bj);
            this.a = topProxyLayout;
            if (topProxyLayout != null) {
                topProxyLayout.a(this.d.f, this.d.a);
                if (this.d.a.at()) {
                    a(false);
                } else {
                    a(this.d.a.an());
                }
            }
        }
    }

    public void a(boolean z) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setShowDislike(z);
        }
    }

    public void b(boolean z) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setSoundMute(z);
        }
        d dVar = this.b;
        if (dVar != null) {
            dVar.setSoundMute(z);
        }
    }

    public void c(boolean z) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSound(z);
        }
    }

    public void d(boolean z) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSkip(z);
        }
    }

    public void a(String str, CharSequence charSequence) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.a((CharSequence) String.valueOf(str), charSequence);
        }
    }

    public void a(CharSequence charSequence) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setSkipText(charSequence);
        }
    }

    public void b() {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.d();
        }
    }

    public void e(boolean z) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setSkipEnable(z);
        }
    }

    public void c() {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.e();
        }
    }

    public void d() {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.a();
        }
    }

    public void e() {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.b();
        }
    }

    public void f() {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.c();
        }
    }

    public void a(b bVar) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setListener(bVar);
        }
    }

    public void a(d dVar) {
        this.b = dVar;
    }

    public void a(int i) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null && (topProxyLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.a.getLayoutParams()).topMargin = i - ad.b((Context) this.c, 20.0f);
        }
    }

    public void b(int i) {
        View findViewById;
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null && topProxyLayout.getITopLayout() != null && i != 0 && (findViewById = this.a.getITopLayout().findViewById(520093713)) != null && (findViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && findViewById.getWidth() > 0 && findViewById.getVisibility() == 0) {
            int[] iArr = new int[2];
            findViewById.getLocationOnScreen(iArr);
            int width = i - (iArr[0] + findViewById.getWidth());
            if (width < ad.b((Context) this.c, 16.0f)) {
                ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).rightMargin += ad.b((Context) this.c, 16.0f) - width;
                findViewById.requestLayout();
            }
        }
    }
}
