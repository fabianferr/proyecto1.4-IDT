package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RippleAnimation */
public class g extends d {
    public g(View view, a aVar) {
        super(view, aVar);
    }

    /* access modifiers changed from: package-private */
    public List<ObjectAnimator> a() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.c, "rippleValue", new float[]{0.0f, 1.0f}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ViewGroup viewGroup = (ViewGroup) this.c.getParent();
        ViewGroup viewGroup2 = viewGroup;
        viewGroup.setClipChildren(false);
        ViewGroup viewGroup3 = (ViewGroup) this.c.getParent().getParent();
        ViewGroup viewGroup4 = viewGroup3;
        viewGroup3.setClipChildren(false);
        ViewGroup viewGroup5 = (ViewGroup) this.c.getParent().getParent().getParent();
        ViewGroup viewGroup6 = viewGroup5;
        viewGroup5.setClipChildren(false);
        this.c.setTag(com.bytedance.sdk.component.adexpress.dynamic.a.e, this.b.h());
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
