package com.startapp;

import android.view.View;
import android.widget.AdapterView;
import com.startapp.sdk.ads.list3d.List3DView;

/* compiled from: Sta */
public class r4 implements Runnable {
    public final /* synthetic */ List3DView a;

    public r4(List3DView list3DView) {
        this.a = list3DView;
    }

    public void run() {
        int b;
        List3DView list3DView = this.a;
        if (list3DView.b == 1 && (b = list3DView.b(list3DView.c, list3DView.d)) != -1) {
            List3DView list3DView2 = this.a;
            View childAt = list3DView2.getChildAt(b);
            int i = list3DView2.i + b;
            long itemId = list3DView2.a.getItemId(i);
            AdapterView.OnItemLongClickListener onItemLongClickListener = list3DView2.getOnItemLongClickListener();
            if (onItemLongClickListener != null) {
                onItemLongClickListener.onItemLongClick(list3DView2, childAt, i, itemId);
            }
        }
    }
}
