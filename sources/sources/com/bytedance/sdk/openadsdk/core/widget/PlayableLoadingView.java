package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import java.util.Locale;

public class PlayableLoadingView extends PAGFrameLayout {
    private PAGProgressBar a;
    private TextView b;
    private TextView c;
    private boolean d;

    public PlayableLoadingView(Context context) {
        super(context);
        setVisibility(8);
    }

    private void c() {
        if (!this.d) {
            this.d = true;
            setBackgroundColor(Color.parseColor("#0D1833"));
            setClickable(true);
            Context context = getContext();
            int b2 = ad.b(context, 80.0f);
            int b3 = ad.b(context, 10.0f);
            LinearLayout linearLayout = new LinearLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams);
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b2, ad.b(context, 53.0f));
            layoutParams2.gravity = 17;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setBackgroundResource(s.d(context, "tt_pangle_logo_white"));
            linearLayout.addView(imageView, layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(context);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = b3;
            layoutParams3.gravity = 17;
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(layoutParams3);
            linearLayout.addView(linearLayout2);
            this.a = new PAGProgressBar(context, (AttributeSet) null, 16842872);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(b2, ad.b(context, 3.0f));
            layoutParams4.gravity = 17;
            this.a.setProgress(1);
            this.a.setProgressDrawable(s.c(context, "tt_playable_progress_style"));
            this.a.setLayoutParams(layoutParams4);
            linearLayout2.addView(this.a);
            this.b = new TextView(context);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.leftMargin = b3;
            this.b.setGravity(16);
            int parseColor = Color.parseColor("#EEEEEE");
            this.b.setTextColor(parseColor);
            this.b.setTextSize(12.0f);
            this.b.setLayoutParams(layoutParams5);
            linearLayout2.addView(this.b);
            int b4 = ad.b(context, 24.0f);
            int b5 = ad.b(context, 8.0f);
            TextView textView = new TextView(context);
            this.c = textView;
            textView.setId(i.bf);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams6.topMargin = ad.b(context, 72.0f);
            layoutParams6.gravity = 17;
            this.c.setBackgroundResource(s.d(context, "tt_playable_btn_bk"));
            this.c.setClickable(true);
            this.c.setPadding(b4, b5, b4, b5);
            this.c.setMaxLines(1);
            this.c.setEllipsize(TextUtils.TruncateAt.END);
            this.c.setTextColor(parseColor);
            this.c.setTextSize(14.0f);
            this.c.setText(s.a(context, "tt_try_now"));
            this.c.setLayoutParams(layoutParams6);
            linearLayout.addView(this.c);
            addView(linearLayout);
        }
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        PAGProgressBar pAGProgressBar = this.a;
        if (pAGProgressBar != null) {
            pAGProgressBar.setProgress(i);
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf(i)}));
        }
    }

    public void a() {
        setVisibility(8);
    }

    public void b() {
        c();
        setVisibility(0);
    }

    public TextView getPlayView() {
        return this.c;
    }
}
