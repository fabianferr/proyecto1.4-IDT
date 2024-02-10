package com.applovin.impl.adview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.adview.i;

public class m extends FrameLayout {
    private i a;
    private int b;

    public m(i.a aVar, Activity activity) {
        super(activity);
        setBackgroundColor(0);
        i a2 = i.a(aVar, activity);
        this.a = a2;
        addView(a2);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.b = i;
        int i5 = i2 + i + i3;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i5;
            layoutParams.width = i5;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(i5, i5));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i, i4);
        layoutParams2.setMargins(i3, i3, i3, 0);
        this.a.setLayoutParams(layoutParams2);
        this.a.a(i);
    }

    public void a(i.a aVar) {
        if (aVar != null && aVar != this.a.getStyle()) {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            removeView(this.a);
            i a2 = i.a(aVar, getContext());
            this.a = a2;
            addView(a2);
            this.a.setLayoutParams(layoutParams);
            this.a.a(this.b);
        }
    }
}
