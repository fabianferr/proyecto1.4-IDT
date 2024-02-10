package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.DspHtmlWebView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.widget.DSPAdChoice;
import com.bytedance.sdk.openadsdk.utils.ad;

public class PAGAppOpenHtmlLayout extends PAGAppOpenBaseLayout {
    a n;

    public interface a {
        void a();

        void a(View view, int i);

        void b();
    }

    public PAGAppOpenHtmlLayout(Context context, q qVar) {
        super(context);
        a(context, qVar);
    }

    private void a(Context context, q qVar) {
        DspHtmlWebView dspHtmlWebView = new DspHtmlWebView(context);
        c.a().c(dspHtmlWebView);
        dspHtmlWebView.a(qVar, new DspHtmlWebView.b() {
            public View a() {
                if (PAGAppOpenHtmlLayout.this.i != null) {
                    return PAGAppOpenHtmlLayout.this.i.getTopDislike();
                }
                return null;
            }

            public View b() {
                return PAGAppOpenHtmlLayout.this;
            }

            public void a(View view, int i) {
                if (PAGAppOpenHtmlLayout.this.n != null) {
                    PAGAppOpenHtmlLayout.this.n.a(view, i);
                }
            }

            public void b_() {
                if (PAGAppOpenHtmlLayout.this.n != null) {
                    PAGAppOpenHtmlLayout.this.n.a();
                }
            }

            public void a(int i, int i2) {
                if (PAGAppOpenHtmlLayout.this.n != null) {
                    PAGAppOpenHtmlLayout.this.n.b();
                }
            }
        }, "open_ad");
        addView(dspHtmlWebView, new ViewGroup.LayoutParams(-1, -1));
        dspHtmlWebView.p();
        int b = ad.b(context, 9.0f);
        int b2 = ad.b(context, 10.0f);
        this.d = new PAGTextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ad.b(context, 31.0f), ad.b(context, 14.0f));
        layoutParams.leftMargin = b2;
        layoutParams.bottomMargin = b2;
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        this.d.setBackgroundResource(s.d(context, "tt_ad_logo_new"));
        this.d.setGravity(17);
        addView(this.d, layoutParams);
        this.m = new DSPAdChoice(context);
        this.m.setPadding(b, 0, b, 0);
        this.m.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ad.b(context, 32.0f), ad.b(context, 14.0f));
        layoutParams2.addRule(12);
        layoutParams2.addRule(11);
        layoutParams2.setMargins(0, 0, b2, b2);
        addView(this.m, layoutParams2);
        if (this.i != null) {
            addView(this.i);
        }
    }

    public void setRenderListener(a aVar) {
        this.n = aVar;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n = null;
    }
}
