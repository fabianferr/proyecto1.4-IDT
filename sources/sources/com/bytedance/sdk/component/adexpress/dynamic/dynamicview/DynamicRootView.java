package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b.k;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.adexpress.dynamic.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.f;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.c;
import com.bytedance.sdk.component.adexpress.dynamic.d;
import com.bytedance.sdk.component.adexpress.dynamic.e;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.theme.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DynamicRootView extends FrameLayout implements d, a {
    protected final n a;
    boolean b;
    public View c;
    private k d;
    private DynamicBaseWidget e;
    private com.bytedance.sdk.component.adexpress.dynamic.d.a f;
    private ThemeStatusBroadcastReceiver g;
    private b h;
    private ViewGroup i = null;
    private int j = 0;
    private List<c> k = new ArrayList();
    private e l;
    private int m = 0;
    private int n = 0;
    private m o;
    private Context p;
    private String q;
    private Map<Integer, String> r;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, m mVar, com.bytedance.sdk.component.adexpress.dynamic.d.a aVar) {
        super(context);
        this.p = context;
        n nVar = new n();
        this.a = nVar;
        nVar.a(2);
        this.f = aVar;
        aVar.a((View) this);
        this.g = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.a(this);
        this.b = z;
        this.o = mVar;
    }

    public String getBgColor() {
        return this.q;
    }

    public void setBgColor(String str) {
        this.q = str;
    }

    public void setRenderListener(k kVar) {
        this.d = kVar;
        this.f.a(kVar);
    }

    public void a(h hVar, int i2) {
        this.e = a(hVar, this, i2);
        this.a.a(true);
        this.a.a((double) this.e.e);
        this.a.b((double) this.e.f);
        this.a.a(this.c);
        this.d.a(this.a);
    }

    public DynamicBaseWidget a(h hVar, ViewGroup viewGroup, int i2) {
        if (hVar == null) {
            return null;
        }
        List<h> k2 = hVar.k();
        DynamicBaseWidget a2 = com.bytedance.sdk.component.adexpress.dynamic.a.b.a(this.p, this, hVar);
        if (a2 instanceof DynamicUnKnowView) {
            a(i2 == 3 ? 128 : 118);
            return null;
        }
        a(hVar);
        a2.c();
        if (viewGroup != null) {
            viewGroup.addView(a2);
            a(viewGroup, hVar);
        }
        if (k2 == null || k2.size() <= 0) {
            return null;
        }
        for (h a3 : k2) {
            a(a3, a2, i2);
        }
        return a2;
    }

    private void a(h hVar) {
        f e2;
        com.bytedance.sdk.component.adexpress.dynamic.b.e j2 = hVar.j();
        if (j2 != null && (e2 = j2.e()) != null) {
            this.a.b(e2.aC());
        }
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.r;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.r = map;
    }

    private void a(ViewGroup viewGroup, h hVar) {
        ViewGroup viewGroup2;
        if (viewGroup != null && (viewGroup2 = (ViewGroup) viewGroup.getParent()) != null && hVar.v()) {
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 != null) {
                viewGroup3.setClipChildren(false);
                viewGroup3.setClipToPadding(false);
            }
        }
    }

    public void a(double d2, double d3, double d4, double d5, float f2) {
        this.a.c(d2);
        this.a.d(d3);
        this.a.e(d4);
        this.a.f(d5);
        this.a.a(f2);
        this.a.b(f2);
        this.a.c(f2);
        this.a.d(f2);
    }

    public void a(int i2) {
        this.a.a(false);
        this.a.b(i2);
        this.d.a(this.a);
    }

    public void setMuteListener(b bVar) {
        this.h = bVar;
    }

    public void setDislikeView(View view) {
        this.f.b(view);
    }

    public k getRenderListener() {
        return this.d;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.d.a getDynamicClickListener() {
        return this.f;
    }

    public void b(int i2) {
        DynamicBaseWidget dynamicBaseWidget = this.e;
        if (dynamicBaseWidget != null) {
            dynamicBaseWidget.a(i2);
        }
    }

    public void a(CharSequence charSequence, int i2, int i3, boolean z) {
        for (int i4 = 0; i4 < this.k.size(); i4++) {
            if (this.k.get(i4) != null) {
                c cVar = this.k.get(i4);
                boolean z2 = true;
                if (i2 != 1) {
                    z2 = false;
                }
                cVar.a(charSequence, z2, i3, z);
            }
        }
    }

    public void setSoundMute(boolean z) {
        b bVar = this.h;
        if (bVar != null) {
            bVar.setSoundMute(z);
        }
    }

    public void setTimeUpdate(int i2) {
        this.l.setTimeUpdate(i2);
    }

    public void f() {
        try {
            this.l.a();
        } catch (Exception unused) {
        }
    }

    public ViewGroup getTimeOut() {
        return this.i;
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.i = viewGroup;
    }

    public int getTimedown() {
        return this.j;
    }

    public void setTimedown(int i2) {
        this.j = i2;
    }

    public List<c> getTimeOutListener() {
        return this.k;
    }

    public void setTimeOutListener(c cVar) {
        this.k.add(cVar);
    }

    public void setVideoListener(e eVar) {
        this.l = eVar;
    }

    public int getScoreCountWithIcon() {
        return this.n;
    }

    public void setScoreCountWithIcon(int i2) {
        this.n = i2;
    }

    public int getLogoUnionHeight() {
        return this.m;
    }

    public void setLogoUnionHeight(int i2) {
        this.m = i2;
    }

    public m getRenderRequest() {
        return this.o;
    }
}
