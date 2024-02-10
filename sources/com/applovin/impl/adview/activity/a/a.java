package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;

abstract class a {
    final m a;
    final Activity b;
    final e c;
    final ViewGroup d;
    final FrameLayout.LayoutParams e;

    a(e eVar, Activity activity, m mVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.e = layoutParams;
        this.c = eVar;
        this.a = mVar;
        this.b = activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.d = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void a(e.c cVar, int i, com.applovin.impl.adview.m mVar) {
        mVar.a(cVar.a, cVar.e, cVar.d, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(mVar.getLayoutParams());
        layoutParams.setMargins(cVar.c, cVar.b, cVar.c, 0);
        layoutParams.gravity = i;
        this.d.addView(mVar, layoutParams);
    }
}
