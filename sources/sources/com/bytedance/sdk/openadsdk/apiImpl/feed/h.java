package com.bytedance.sdk.openadsdk.apiImpl.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.bannerexpress.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.n.a.e;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: TTNativeAdImpl */
public class h extends PAGNativeAd {
    /* access modifiers changed from: protected */
    public n a;
    /* access modifiers changed from: protected */
    public final q b;
    protected final Context c;
    /* access modifiers changed from: protected */
    public a d;
    protected int e;
    protected int f;
    protected String g;
    private boolean h;
    private boolean i;

    private String a(int i2) {
        return i2 != 1 ? i2 != 2 ? "embeded_ad" : "interaction" : "banner_ad";
    }

    public void showPrivacyActivity() {
    }

    public h(Context context, q qVar, int i2, boolean z) {
        if (qVar == null) {
            l.d("materialMeta can't been null");
        }
        this.b = qVar;
        this.c = context;
        this.e = i2;
        this.f = qVar.aZ();
        String c2 = ac.c(i2);
        this.g = c2;
        if (z) {
            this.d = new a(context, qVar, c2);
            this.a = new n(context, this, qVar, a(i2), this.d);
        }
    }

    private List<View> a(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                linkedList.add(list.get(i2));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                linkedList.add(list2.get(i3));
            }
        }
        return linkedList;
    }

    public Map<String, Object> getMediaExtraInfo() {
        q qVar = this.b;
        if (qVar != null) {
            return qVar.ai();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        q qVar = this.b;
        if (qVar == null || qVar.M() == 5 || o.d().c(this.f) != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        this.g = str;
    }

    public void win(Double d2) {
        if (!this.h) {
            w.a(this.b, d2);
            this.h = true;
        }
    }

    public void loss(Double d2, String str, String str2) {
        if (!this.i) {
            w.a(this.b, d2, str, str2);
            this.i = true;
        }
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        if (viewGroup == null) {
            l.d("container can't been null");
        } else if (list == null) {
            l.d("clickView can't been null");
        } else if (list.size() <= 0) {
            l.d("clickViews size must been more than 1");
        } else {
            a(viewGroup, (List<View>) null, list, list2, view, new g(pAGNativeAdInteractionListener));
        }
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionCallback pAGNativeAdInteractionCallback) {
        registerViewForInteraction(viewGroup, list, list2, view, (PAGNativeAdInteractionListener) pAGNativeAdInteractionCallback);
    }

    public void a(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, final f fVar) {
        if (viewGroup == null) {
            l.d("container can't been null");
        } else if (list2 == null) {
            l.d("clickView can't been null");
        } else if (list2.size() <= 0) {
            l.d("clickViews size must been more than 1");
        } else {
            if (h()) {
                list3 = a(list2, list3);
            }
            List<View> list4 = list3;
            if (!(view == null || fVar == null || !fVar.b())) {
                view.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        final String a2 = r.a();
                        TTDelegateActivity.a(h.this.b, a2, new a.C0062a() {
                            public void a() {
                                fVar.a();
                                com.bytedance.sdk.openadsdk.core.h.b().d(a2);
                                PAGMediaView a2 = h.this.i().a();
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                        });
                    }
                });
            }
            this.a.a(viewGroup, list, list2, list4, view, fVar);
            e.a(viewGroup, this.b, -1);
        }
    }

    public PAGNativeAdData getNativeAdData() {
        return new d(i());
    }

    public a i() {
        return this.d;
    }
}
