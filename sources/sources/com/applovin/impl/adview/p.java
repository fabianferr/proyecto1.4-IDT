package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.impl.adview.i;

public final class p extends i {
    public p(Context context) {
        super(context);
    }

    public void a(int i) {
        setViewScale(((float) i) / 30.0f);
    }

    public i.a getStyle() {
        return i.a.INVISIBLE;
    }
}
