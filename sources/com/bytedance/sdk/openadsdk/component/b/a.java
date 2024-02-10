package com.bytedance.sdk.openadsdk.component.b;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.e.a;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.s;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FeedAdManager */
public class a {
    private static volatile a a;
    private final p b = o.c();

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private a() {
    }

    public void a(Context context, AdSlot adSlot, b bVar) {
        final ab a2 = ab.a();
        final b bVar2 = bVar;
        final Context context2 = context;
        final AdSlot adSlot2 = adSlot;
        this.b.a(adSlot, new s(), 5, (p.a) new p.a() {
            public void a(int i, String str) {
                bVar2.onError(i, str);
            }

            public void a(com.bytedance.sdk.openadsdk.core.model.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
                boolean z;
                if (aVar.c() == null || aVar.c().isEmpty()) {
                    bVar2.onError(-3, g.a(-3));
                    bVar.a(-3);
                    com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                    return;
                }
                List<q> c2 = aVar.c();
                ArrayList arrayList = new ArrayList(c2.size());
                Iterator<q> it = c2.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (q.c(next) || (next != null && next.am())) {
                        PAGNativeAd a2 = a(context2, next, adSlot2);
                        if (bVar2 instanceof PAGNativeAdLoadListener) {
                            arrayList.add(a2);
                        }
                    }
                    if (!(!q.c(next) || next.K() == null || next.K().k() == null)) {
                        if (o.d().e(String.valueOf(next.aZ())) && o.d().X()) {
                            if (next.K() != null) {
                                next.K().f(1);
                            }
                            if (next.aN() != null) {
                                next.aN().f(1);
                            }
                            com.bytedance.sdk.openadsdk.core.video.a.b a3 = q.a(CacheDirFactory.getICacheDir(next.aK()).c(), next);
                            a3.a("material_meta", next);
                            a3.a("ad_slot", adSlot2);
                            com.bytedance.sdk.openadsdk.core.video.d.a.a(a3, (a.C0036a) null);
                        }
                    }
                }
                if (!(bVar2 instanceof PAGNativeAdLoadListener) || arrayList.isEmpty()) {
                    z = false;
                }
                if (z) {
                    AdSlot adSlot = adSlot2;
                    if (adSlot == null) {
                        c.b(c2.get(0), ac.c(5), a2);
                    } else if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                        c.c(c2.get(0), "embeded_ad", a2.c());
                    } else {
                        c.b(c2.get(0), ac.c(adSlot2.getDurationSlotType()), a2);
                    }
                    b bVar2 = bVar2;
                    if (bVar2 instanceof PAGNativeAdLoadListener) {
                        ((PAGNativeAdLoadListener) bVar2).onAdLoaded(arrayList.get(0));
                    }
                    if (bVar.e() != null && !bVar.e().isEmpty()) {
                        com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                        return;
                    }
                    return;
                }
                bVar2.onError(-4, g.a(-4));
                bVar.a(-4);
                com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
            }

            private PAGNativeAd a(Context context, q qVar, AdSlot adSlot) {
                if (qVar.u() != 2) {
                    return new com.bytedance.sdk.openadsdk.apiImpl.feed.b(context, qVar, 5, adSlot);
                }
                if (qVar.K() != null) {
                    return new com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress.a(context, qVar, adSlot);
                }
                return new com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress.b(context, qVar, adSlot);
            }
        });
    }
}
