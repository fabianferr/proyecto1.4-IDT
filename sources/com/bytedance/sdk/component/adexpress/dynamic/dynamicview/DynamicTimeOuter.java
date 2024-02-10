package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.bytedance.sdk.component.adexpress.c.d;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.c;
import com.bytedance.sdk.component.adexpress.dynamic.c.j;
import com.bytedance.sdk.component.utils.s;

public class DynamicTimeOuter extends DynamicButton implements c {
    private boolean a;
    private boolean b;
    private boolean t;

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(hVar.j().b())) {
            dynamicRootView.setTimedown(this.h);
        }
    }

    public boolean i() {
        super.i();
        if (d.b(this.n.getRenderRequest().d())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.m.j().b())) {
            ((TextView) this.o).setText(String.valueOf((int) Double.parseDouble(this.l.j())));
            return true;
        }
        ((TextView) this.o).setText(((int) Double.parseDouble(this.l.j())) + CmcdHeadersFactory.STREAMING_FORMAT_SS);
        return true;
    }

    public void f() {
        if (TextUtils.equals("skip-with-countdowns-video-countdown", this.m.j().b()) || TextUtils.equals("skip-with-time-countdown", this.m.j().b())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.g, this.h);
            layoutParams.gravity = 8388627;
            if (com.bytedance.sdk.component.adexpress.d.b()) {
                layoutParams.leftMargin = this.i;
            }
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
            setLayoutParams(layoutParams);
            return;
        }
        super.f();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.o).getText())) {
            setMeasuredDimension(0, this.h);
        }
    }

    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        String str = "";
        if (z2 || this.t) {
            ((TextView) this.o).setText(str);
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z && this.n.getRenderRequest().a() && d.b(this.n.getRenderRequest().d())) {
            ((TextView) this.o).setText(String.format(s.a(com.bytedance.sdk.component.adexpress.d.a(), "tt_reward_full_skip"), new Object[]{Integer.valueOf(i)}));
            this.a = true;
        } else if (com.bytedance.sdk.component.adexpress.d.b() && !"open_ad".equals(this.n.getRenderRequest().d()) && this.n.getRenderRequest().a()) {
            this.t = true;
            setVisibility(8);
        } else if ("timedown".equals(this.m.j().b())) {
            ((TextView) this.o).setText(charSequence);
        } else {
            ((TextView) this.o).setText(charSequence + CmcdHeadersFactory.STREAMING_FORMAT_SS);
            this.b = true;
            if (this.a) {
                CharSequence text = ((TextView) this.o).getText();
                if (text != null) {
                    str = text.toString();
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((float) j.b(str, this.l.e(), true)[0]) + e.a(com.bytedance.sdk.component.adexpress.d.a(), (float) (this.l.c() + this.l.d()))), this.h);
                layoutParams.gravity = 8388629;
                this.o.setLayoutParams(layoutParams);
                this.a = false;
                requestLayout();
            }
        }
    }
}
