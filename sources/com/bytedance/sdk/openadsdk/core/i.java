package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.model.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;

/* compiled from: H5AdInteractionManager */
public class i {
    private final g a;
    private final f b;
    private final View c;

    public void a(int i, m mVar) {
        f fVar;
        if (i != -1 && mVar != null) {
            float f = mVar.a;
            float f2 = mVar.b;
            float f3 = mVar.c;
            float f4 = mVar.d;
            SparseArray<c.a> sparseArray = mVar.n;
            if (i == 1) {
                g gVar = this.a;
                if (gVar != null) {
                    gVar.a(mVar);
                    this.a.a(this.c, f, f2, f3, f4, sparseArray, true);
                }
            } else if (i == 2 && (fVar = this.b) != null) {
                fVar.a(mVar);
                this.b.a(this.c, f, f2, f3, f4, sparseArray, true);
            }
        }
    }
}
