package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShineAnimation */
public class k extends d {
    public k(View view, a aVar) {
        super(view, aVar);
    }

    /* access modifiers changed from: package-private */
    public List<ObjectAnimator> a() {
        int i;
        int i2;
        this.c.setTag(com.bytedance.sdk.component.adexpress.dynamic.a.b, Integer.valueOf(this.b.d()));
        if (this.c == null || !b.a(this.c.getContext())) {
            i2 = 0;
            i = 1;
        } else {
            i2 = 1;
            i = 0;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.c, "shineValue", new float[]{(float) i2, (float) i}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
