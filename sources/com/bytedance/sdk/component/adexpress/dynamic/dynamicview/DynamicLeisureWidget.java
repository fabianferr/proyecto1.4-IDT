package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;

public class DynamicLeisureWidget extends DynamicBaseWidgetImp {
    public DynamicLeisureWidget(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        this.g = 0;
        this.h = 0;
        return super.getWidgetLayoutParams();
    }
}
