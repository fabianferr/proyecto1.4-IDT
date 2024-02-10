package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.k.c;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

public class DSPAdChoice extends PAGImageView {
    public DSPAdChoice(Context context) {
        super(context);
        a();
    }

    private void a() {
        setVisibility(8);
        setId(i.bh);
    }

    public void a(int i, q qVar) {
        if (qVar.at() || (qVar.av() && qVar.h())) {
            ad.a((View) this, 0);
            c.a().a((int) ad.a(getContext(), (float) i, true), (ImageView) this, qVar);
        }
    }
}
