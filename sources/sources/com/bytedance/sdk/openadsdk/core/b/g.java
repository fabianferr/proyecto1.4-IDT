package com.bytedance.sdk.openadsdk.core.b;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.g.a;
import com.bytedance.sdk.openadsdk.utils.i;

/* compiled from: VastClickListenerWrapper */
public abstract class g extends c {
    private final String a;
    private final a b;
    private c c;

    public abstract void a();

    public g(String str, a aVar) {
        this(str, aVar, (c) null);
    }

    public g(String str, a aVar, c cVar) {
        this.a = str;
        this.b = aVar;
        this.c = cVar;
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    /* access modifiers changed from: protected */
    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        View view2 = view;
        a aVar = this.b;
        if (aVar != null) {
            aVar.e(this.a);
        }
        if (view2 != null) {
            if (view.getId() == i.c) {
                view.setTag(570425345, "VAST_TITLE");
            } else if (view.getId() == i.g) {
                view.setTag(570425345, "VAST_DESCRIPTION");
            } else {
                view.setTag(570425345, this.a);
            }
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.x = this.x;
            this.c.y = this.y;
            this.c.z = this.z;
            this.c.A = this.z;
            this.c.B = this.z;
            this.c.a(view, f, f2, f3, f4, sparseArray, z);
        }
        a();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }
}
