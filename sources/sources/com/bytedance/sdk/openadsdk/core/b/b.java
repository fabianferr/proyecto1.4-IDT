package com.bytedance.sdk.openadsdk.core.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.i;
import com.bytedance.sdk.openadsdk.core.model.m;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.com.bytedance.overseas.sdk.a.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ClickListener */
public class b extends c {
    private boolean G;
    private String a;
    private WeakReference<Activity> b;
    protected Context c;
    public m d;
    protected final q e;
    protected final String f;
    protected final int g;
    protected WeakReference<View> h;
    protected WeakReference<View> i;
    protected i j;
    protected a k;
    protected PAGNativeAd l;
    protected c m;
    protected boolean n;
    protected com.com.bytedance.overseas.sdk.a.c o;
    protected Map<String, Object> p;
    protected PangleAd q;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.a r;
    protected int s;

    /* compiled from: ClickListener */
    public interface a {
        void a(View view, int i);
    }

    public b(Context context, q qVar, String str, int i2) {
        this.n = false;
        this.s = 0;
        this.G = false;
        this.c = context;
        this.e = qVar;
        this.f = str;
        this.g = i2;
    }

    public b(Context context, q qVar, String str, int i2, boolean z) {
        this(context, qVar, str, i2);
        this.G = z;
    }

    public static boolean a(View view, q qVar, boolean z) {
        if (view == null || qVar == null) {
            return true;
        }
        try {
            String valueOf = String.valueOf(view.getTag(com.bytedance.sdk.component.adexpress.dynamic.a.t));
            if (view.getTag(com.bytedance.sdk.component.adexpress.dynamic.a.t) != null && !TextUtils.isEmpty(valueOf)) {
                if (CampaignEx.JSON_NATIVE_VIDEO_CLICK.equals(valueOf)) {
                    return z;
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return c(view) ? qVar.r() != 1 || z : qVar.q() != 1 || z;
    }

    public static boolean c(View view) {
        return 520093705 == view.getId() || 520093707 == view.getId() || 520093703 == view.getId() || s.e(view.getContext(), "btn_native_creative") == view.getId() || com.bytedance.sdk.openadsdk.utils.i.at == view.getId() || com.bytedance.sdk.openadsdk.utils.i.bf == view.getId();
    }

    /* access modifiers changed from: protected */
    public i a(float f2, float f3, float f4, float f5, SparseArray<c.a> sparseArray, long j2, long j3, View view, View view2, String str, float f6, int i2, float f7, int i3, JSONObject jSONObject) {
        float f8 = f2;
        float f9 = f3;
        float f10 = f4;
        float f11 = f5;
        long j4 = j2;
        long j5 = j3;
        SparseArray<c.a> sparseArray2 = sparseArray;
        return new i.a().f(f2).e(f3).d(f4).c(f5).b(j2).a(j3).b(ad.a(view)).a(ad.a(view2)).c(ad.c(view)).d(ad.c(view2)).d(this.z).e(this.A).f(this.B).a(sparseArray).b(h.b().a() ? 1 : 2).a(str).a(f6).c(i2).b(f7).a(i3).a(jSONObject).a();
    }

    public void a(int i2) {
        this.B = i2;
    }

    public void a(Activity activity) {
        if (activity != null) {
            this.b = new WeakReference<>(activity);
        }
    }

    public void a(View view) {
        if (view != null) {
            this.h = new WeakReference<>(view);
        }
    }

    public void a(View view, float f2, float f3, float f4, float f5, SparseArray<c.a> sparseArray, boolean z) {
        JSONObject jSONObject;
        int i2;
        String str;
        q qVar;
        i iVar;
        String str2;
        boolean z2;
        Map<String, Object> map;
        q qVar2;
        View view2 = view;
        boolean z3 = z;
        if (this.c == null) {
            this.c = o.a();
        }
        if ((this.G || !a(view, 1, f2, f3, f4, f5, sparseArray, z)) && this.c != null) {
            m mVar = this.d;
            if (mVar != null) {
                i2 = mVar.l;
                jSONObject = this.d.m;
            } else {
                jSONObject = null;
                i2 = -1;
            }
            long j2 = this.x;
            long j3 = this.y;
            WeakReference<View> weakReference = this.h;
            View view3 = weakReference == null ? null : (View) weakReference.get();
            WeakReference<View> weakReference2 = this.i;
            i a2 = a(f2, f3, f4, f5, sparseArray, j2, j3, view3, weakReference2 == null ? null : (View) weakReference2.get(), f(), ad.e(this.c), ad.g(this.c), ad.f(this.c), i2, jSONObject);
            this.j = a2;
            if (!a(a2, this.p)) {
                if (this.m != null) {
                    if (this.p == null) {
                        this.p = new HashMap();
                    }
                    this.p.put("duration", Long.valueOf(this.m.e()));
                }
                int i3 = 1;
                if (this.G) {
                    q qVar3 = this.e;
                    i iVar2 = this.j;
                    String str3 = this.f;
                    Map<String, Object> map2 = this.p;
                    if (!z) {
                        i3 = 2;
                    }
                    str = CampaignEx.JSON_NATIVE_VIDEO_CLICK;
                    qVar = qVar3;
                    iVar = iVar2;
                    str2 = str3;
                    z2 = true;
                    map = map2;
                } else {
                    boolean z4 = z;
                    a aVar = this.k;
                    View view4 = view;
                    if (aVar != null) {
                        aVar.a(view4, -1);
                    }
                    if (a(view4, z4)) {
                        boolean b2 = t.b(this.e);
                        String a3 = b2 ? this.f : ac.a(this.g);
                        if (view4 != null) {
                            try {
                                Boolean bool = (Boolean) view4.getTag(520093762);
                                Boolean bool2 = bool;
                                if (bool.booleanValue()) {
                                    z.a(true);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        boolean a4 = z.a(this.c, this.e, this.g, this.l, this.q, a3, this.o, b2, 0);
                        z.a(false);
                        if (a4 || (qVar2 = this.e) == null || qVar2.ab() == null || this.e.ab().c() != 2) {
                            q qVar4 = this.e;
                            if (qVar4 != null && !a4 && TextUtils.isEmpty(qVar4.P()) && com.bytedance.sdk.openadsdk.b.b.a(this.f)) {
                                d.a(this.c, this.e, this.f).d();
                            }
                            q qVar5 = this.e;
                            i iVar3 = this.j;
                            String str4 = this.f;
                            Map<String, Object> map3 = this.p;
                            if (!z4) {
                                i3 = 2;
                            }
                            str = CampaignEx.JSON_NATIVE_VIDEO_CLICK;
                            qVar = qVar5;
                            iVar = iVar3;
                            str2 = str4;
                            z2 = a4;
                            map = map3;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.b.c.a(str, qVar, iVar, str2, z2, map, i3);
            }
        }
    }

    public void a(com.bykv.vk.openvk.component.video.api.d.c cVar) {
        this.m = cVar;
    }

    public void a(PangleAd pangleAd) {
        this.q = pangleAd;
    }

    public void a(PAGNativeAd pAGNativeAd) {
        this.l = pAGNativeAd;
    }

    public void a(a aVar) {
        this.k = aVar;
    }

    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar) {
        this.r = aVar;
    }

    public void a(com.com.bytedance.overseas.sdk.a.c cVar) {
        this.o = cVar;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(Map<String, Object> map) {
        Map<String, Object> map2 = this.p;
        if (map2 != null) {
            map2.putAll(map);
            map.putAll(this.p);
        }
        this.p = map;
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, int i2, float f2, float f3, float f4, float f5, SparseArray<c.a> sparseArray, boolean z) {
        if (this.r == null) {
            return false;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.i;
        if (weakReference != null) {
            iArr = ad.a((View) weakReference.get());
            iArr2 = ad.c((View) this.i.get());
        }
        this.r.a(view, i2, new m.a().d(f2).c(f3).b(f4).a(f5).b(this.x).a(this.y).c(iArr[0]).d(iArr[1]).e(iArr2[0]).f(iArr2[1]).a(sparseArray).a(z).a());
        return true;
    }

    public boolean a(View view, boolean z) {
        return a(view, this.e, z);
    }

    public boolean a(i iVar, Map<String, Object> map) {
        return false;
    }

    public void b(int i2) {
        this.A = i2;
    }

    public void b(View view) {
        if (view != null) {
            this.i = new WeakReference<>(view);
        }
    }

    public void c(int i2) {
        this.z = i2;
    }

    public View d() {
        WeakReference<Activity> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return ((Activity) this.b.get()).findViewById(16908290);
    }

    public void d(int i2) {
        this.s = i2;
    }

    public void d(boolean z) {
        this.n = z;
    }

    public View e() {
        WeakReference<Activity> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        View findViewById = ((Activity) this.b.get()).findViewById(520093713);
        return findViewById == null ? ((Activity) this.b.get()).findViewById(520093713) : findViewById;
    }

    public String f() {
        return this.a;
    }
}
