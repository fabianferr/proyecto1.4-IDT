package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StretchAnimation */
public class l extends d {
    public l(View view, a aVar) {
        super(view, aVar);
    }

    /* access modifiers changed from: package-private */
    public List<ObjectAnimator> a() {
        if ((this.c instanceof ImageView) && (this.c.getParent() instanceof DynamicImageView)) {
            View view = (View) this.c.getParent();
            View view2 = view;
            this.c = view;
            ViewGroup viewGroup = (ViewGroup) this.c;
            ViewGroup viewGroup2 = viewGroup;
            viewGroup.setClipChildren(true);
            ViewGroup viewGroup3 = (ViewGroup) this.c.getParent();
            ViewGroup viewGroup4 = viewGroup3;
            viewGroup3.setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.c, "stretchValue", new float[]{0.0f, 1.0f}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
