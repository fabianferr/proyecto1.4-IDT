package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.i;

public class TopProxyLayout extends View implements a<TopProxyLayout> {
    private a<TopProxyLayout> a;

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public TopProxyLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TopProxyLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopProxyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View getITopLayout() {
        a<TopProxyLayout> aVar = this.a;
        if (!(aVar instanceof View)) {
            return null;
        }
        return (View) aVar;
    }

    public TopProxyLayout a(boolean z, q qVar) {
        TopLayoutDislike2 a2 = new TopLayoutDislike2(getContext()).a(z, qVar);
        this.a = a2;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            a((View) a2, (ViewGroup) parent);
        }
        return this;
    }

    private void a(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
        if (view != null) {
            view.setId(i.bs);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setShowSkip(boolean z) {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.setShowSkip(z);
        }
    }

    public void setSkipEnable(boolean z) {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.setSkipEnable(z);
        }
    }

    public void c() {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void setSkipText(CharSequence charSequence) {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.setSkipText(charSequence);
        }
    }

    public void d() {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void e() {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void setShowSound(boolean z) {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.setShowSound(z);
        }
    }

    public void setSoundMute(boolean z) {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.setSoundMute(z);
        }
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.a(charSequence, charSequence2);
        }
    }

    public void setShowDislike(boolean z) {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.setShowDislike(z);
        }
    }

    public void setListener(b bVar) {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.setListener(bVar);
        }
    }

    public void a() {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void b() {
        a<TopProxyLayout> aVar = this.a;
        if (aVar != null) {
            aVar.b();
        }
    }
}
