package com.startapp.sdk.inappbrowser;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.CastStatusCodes;
import com.startapp.f9;
import com.startapp.u5;
import java.util.Map;

/* compiled from: Sta */
public class NavigationBarLayout extends RelativeLayout {
    public static final int j = Color.rgb(78, 86, 101);
    public static final int k = Color.rgb(148, 155, 166);
    public RelativeLayout a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public Boolean h = Boolean.FALSE;
    public Map<String, u5> i;

    public NavigationBarLayout(Context context) {
        super(context);
    }

    public void a(WebView webView) {
        if (this.h.booleanValue()) {
            if (webView.canGoBack()) {
                this.e.setImageBitmap(this.i.get("BACK_DARK").a);
                this.e.setEnabled(true);
            } else {
                this.e.setImageBitmap(this.i.get("BACK").a);
                this.e.setEnabled(false);
            }
            if (webView.canGoForward()) {
                this.c.setImageBitmap(this.i.get("FORWARD_DARK").a);
                this.c.setEnabled(true);
            } else {
                this.c.setImageBitmap(this.i.get("FORWARD").a);
                this.c.setEnabled(false);
            }
            if (webView.getTitle() != null) {
                this.f.setText(webView.getTitle());
            }
        } else if (webView.canGoBack()) {
            this.e.setImageBitmap(this.i.get("BACK_DARK").a);
            addView(this.e, f9.a(getContext(), new int[]{6, 0, 0, 0}, new int[]{15, 9}));
            ImageView imageView = this.c;
            RelativeLayout.LayoutParams a2 = f9.a(getContext(), new int[]{9, 0, 0, 0}, new int[]{15});
            a2.addRule(1, 2105);
            addView(imageView, a2);
            removeView(this.a);
            this.a.removeView(this.g);
            this.a.removeView(this.f);
            this.a.addView(this.f, f9.a(getContext(), new int[]{0, 0, 0, 0}, new int[]{14}));
            RelativeLayout relativeLayout = this.a;
            TextView textView = this.g;
            RelativeLayout.LayoutParams a3 = f9.a(getContext(), new int[]{0, 0, 0, 0}, new int[]{14});
            a3.addRule(3, 2102);
            relativeLayout.addView(textView, a3);
            RelativeLayout.LayoutParams a4 = f9.a(getContext(), new int[]{16, 0, 16, 0}, new int[]{15});
            a4.addRule(1, 2106);
            a4.addRule(0, CastStatusCodes.MEDIA_ERROR);
            addView(this.a, a4);
            this.h = Boolean.TRUE;
        }
    }

    public void setButtonsListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
        this.e.setOnClickListener(onClickListener);
        this.c.setOnClickListener(onClickListener);
        this.d.setOnClickListener(onClickListener);
    }

    public void a() {
        this.i = null;
    }
}
