package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.f.c.e;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.apiImpl.feed.f;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.settings.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ae;
import com.com.bytedance.overseas.sdk.a.c;
import com.com.bytedance.overseas.sdk.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: InteractionManager */
public class n {
    /* access modifiers changed from: private */
    public final q a;
    private c b;
    private final Context c;
    /* access modifiers changed from: private */
    public final PAGNativeAd d;
    private List<View> e = new ArrayList();
    private final String f;
    /* access modifiers changed from: private */
    public f g;
    private long h;
    private final g i = new g();
    /* access modifiers changed from: private */
    public final com.bytedance.sdk.openadsdk.apiImpl.feed.a j;
    private com.bykv.vk.openvk.component.video.api.d.c k;
    private final AtomicBoolean l = new AtomicBoolean(false);
    private b m;
    private com.bytedance.sdk.openadsdk.core.b.a n;

    /* compiled from: InteractionManager */
    private static class a implements View.OnLayoutChangeListener {
        private final g a;
        private final ViewGroup b;

        public a(g gVar, ViewGroup viewGroup) {
            this.a = gVar;
            this.b = viewGroup;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a.a(System.currentTimeMillis(), y.a(this.b));
            while (true) {
                char c = 15;
                while (true) {
                    switch (c) {
                        case 13:
                        case 14:
                            return;
                        default:
                            c = 14;
                    }
                }
            }
        }
    }

    public n(Context context, PAGNativeAd pAGNativeAd, q qVar, String str, com.bytedance.sdk.openadsdk.apiImpl.feed.a aVar) {
        this.d = pAGNativeAd;
        this.a = qVar;
        this.c = context;
        this.f = str;
        this.j = aVar;
        if (qVar.M() == 4) {
            this.b = d.a(context, qVar, str);
        }
    }

    private void a(final ViewGroup viewGroup) {
        ae.a(viewGroup, true, 5, new ae.b() {
            public void a() {
                n.this.b(viewGroup);
            }

            public void a(View view, boolean z) {
                if (z) {
                    n.this.b(viewGroup, view);
                }
            }

            public void a(boolean z) {
                n.this.a(z, viewGroup);
            }

            public void b() {
                n.this.b();
            }
        }, (List<ViewGroup>) null);
    }

    private void a(ViewGroup viewGroup, View view) {
        b bVar;
        com.bytedance.sdk.openadsdk.core.b.a aVar;
        HashMap hashMap = new HashMap();
        hashMap.put(e.e1699434667871dc("cmk`oZudmgin"), 1);
        if (this.a.u() == 2) {
            Context context = this.c;
            q qVar = this.a;
            String str = this.f;
            bVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.g(context, qVar, str, ac.a(str));
        } else {
            Context context2 = this.c;
            q qVar2 = this.a;
            String str2 = this.f;
            bVar = new b(context2, qVar2, str2, ac.a(str2));
        }
        this.m = bVar;
        this.m.a((View) viewGroup);
        this.m.a(this.k);
        this.m.b(view);
        this.m.a(this.b);
        this.m.a(this.d);
        this.m.a((Map<String, Object>) hashMap);
        this.m.a((b.a) new b.a() {
            public void a(View view, int i) {
                if (n.this.g != null) {
                    n.this.g.a(view, n.this.d);
                }
            }
        });
        if (this.a.u() == 2) {
            Context context3 = this.c;
            q qVar3 = this.a;
            String str3 = this.f;
            aVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.f(context3, qVar3, str3, ac.a(str3));
        } else {
            Context context4 = this.c;
            q qVar4 = this.a;
            String str4 = this.f;
            aVar = new com.bytedance.sdk.openadsdk.core.b.a(context4, qVar4, str4, ac.a(str4));
        }
        this.n = aVar;
        this.n.a((View) viewGroup);
        this.n.a(this.k);
        this.n.b(view);
        this.n.a(this.b);
        this.n.a(this.d);
        this.n.a((Map<String, Object>) hashMap);
        this.n.a((b.a) new b.a() {
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
                continue;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0034, code lost:
                switch(r3) {
                    case 52: goto L_0x002e;
                    case 53: goto L_0x0038;
                    case 54: goto L_0x0043;
                    default: goto L_0x0037;
                };
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
                switch(r2) {
                    case 29: goto L_0x0042;
                    case 30: goto L_0x002e;
                    case 31: goto L_0x0034;
                    default: goto L_0x003b;
                };
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
                r2 = 30;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(android.view.View r2, int r3) {
                /*
                    r1 = this;
                    com.bytedance.sdk.openadsdk.core.n r3 = com.bytedance.sdk.openadsdk.core.n.this
                    com.bytedance.sdk.openadsdk.apiImpl.feed.f r3 = r3.g
                    if (r3 == 0) goto L_0x0017
                    com.bytedance.sdk.openadsdk.core.n r3 = com.bytedance.sdk.openadsdk.core.n.this
                    com.bytedance.sdk.openadsdk.apiImpl.feed.f r3 = r3.g
                    com.bytedance.sdk.openadsdk.core.n r0 = com.bytedance.sdk.openadsdk.core.n.this
                    com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r0 = r0.d
                    r3.b(r2, r0)
                L_0x0017:
                    com.bytedance.sdk.openadsdk.core.n r2 = com.bytedance.sdk.openadsdk.core.n.this
                    com.bytedance.sdk.openadsdk.core.model.q r2 = r2.a
                    r3 = 9
                    com.bytedance.sdk.openadsdk.n.a.e.a((com.bytedance.sdk.openadsdk.core.model.q) r2, (int) r3)
                    com.bytedance.sdk.openadsdk.core.n r2 = com.bytedance.sdk.openadsdk.core.n.this
                    com.bytedance.sdk.openadsdk.apiImpl.feed.a r2 = r2.j
                    r2.m()
                    r2 = 55
                    r3 = 0
                L_0x002e:
                    r0 = 72
                L_0x0030:
                    switch(r0) {
                        case 72: goto L_0x0043;
                        case 73: goto L_0x003e;
                        case 74: goto L_0x0034;
                        default: goto L_0x0033;
                    }
                L_0x0033:
                    goto L_0x002e
                L_0x0034:
                    switch(r3) {
                        case 52: goto L_0x002e;
                        case 53: goto L_0x0038;
                        case 54: goto L_0x0043;
                        default: goto L_0x0037;
                    }
                L_0x0037:
                    goto L_0x0043
                L_0x0038:
                    switch(r2) {
                        case 29: goto L_0x0042;
                        case 30: goto L_0x002e;
                        case 31: goto L_0x0034;
                        default: goto L_0x003b;
                    }
                L_0x003b:
                    r2 = 30
                    goto L_0x0038
                L_0x003e:
                    r0 = 57
                    if (r3 > r0) goto L_0x0043
                L_0x0042:
                    return
                L_0x0043:
                    r0 = 73
                    r3 = 16
                    goto L_0x0030
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.n.AnonymousClass2.a(android.view.View, int):void");
            }
        });
    }

    private void a(ViewGroup viewGroup, EmptyView emptyView, List<View> list, List<View> list2) {
        b bVar = this.m;
        if (bVar != null && this.n != null) {
            emptyView.a(list, (com.bytedance.sdk.openadsdk.core.b.c) bVar);
            emptyView.a(list2, (com.bytedance.sdk.openadsdk.core.b.c) this.n);
            a(this.m, this.n);
            a(emptyView, viewGroup);
        }
    }

    private void a(ViewGroup viewGroup, List<View> list, List<View> list2) {
        b bVar = this.m;
        if (bVar != null && this.n != null) {
            a(list, (com.bytedance.sdk.openadsdk.core.b.c) bVar);
            a(list2, (com.bytedance.sdk.openadsdk.core.b.c) this.n);
            a(this.m, this.n);
            a(viewGroup);
        }
    }

    private void a(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, f fVar) {
        this.g = fVar;
        viewGroup.addOnLayoutChangeListener(new a(this.i, viewGroup));
        this.e = list;
        a(list2, (com.bytedance.sdk.openadsdk.core.b.c) null);
        if (list != null) {
            for (View next : this.e) {
                if (next != null) {
                    next.setTag(520093762, true);
                }
            }
            if (list3 != null) {
                list3.addAll(list);
            }
        }
        a(list3, (com.bytedance.sdk.openadsdk.core.b.c) null);
    }

    private void a(EmptyView emptyView, final ViewGroup viewGroup) {
        emptyView.setCallback(new EmptyView.a() {
            public void a() {
                n.this.b(viewGroup);
            }

            @JProtect
            public void a(View view) {
                n.this.b(viewGroup, view);
            }

            public void a(boolean z) {
                n.this.a(z, viewGroup);
            }

            public void b() {
                n.this.b();
            }
        });
    }

    private void a(com.bytedance.sdk.openadsdk.core.b.a aVar) {
        if (o.ai().d(String.valueOf(this.a.aZ()))) {
            com.bytedance.sdk.openadsdk.apiImpl.feed.a aVar2 = this.j;
            if (!(aVar2 == null || aVar2.a() == null)) {
                this.j.a().setOnClickListener(aVar);
                this.j.a().setOnTouchListener(aVar);
            }
            com.bytedance.sdk.openadsdk.apiImpl.feed.a aVar3 = this.j;
            if (aVar3 != null) {
                aVar3.a(aVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.apiImpl.feed.a aVar4 = this.j;
        if (!(aVar4 == null || aVar4.a() == null)) {
            PAGMediaView a2 = this.j.a();
            AnonymousClass3 r0 = new com.bytedance.sdk.openadsdk.core.b.c() {
                /* access modifiers changed from: protected */
                public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
                    if (view instanceof PAGVideoMediaView) {
                        ((PAGVideoMediaView) view).handleInterruptVideo();
                    }
                }
            };
            a2.setOnClickListener(r0);
            a2.setOnTouchListener(r0);
        }
        com.bytedance.sdk.openadsdk.apiImpl.feed.a aVar5 = this.j;
        if (aVar5 != null) {
            aVar5.a((com.bytedance.sdk.openadsdk.core.b.a) null);
        }
    }

    private void a(b bVar, com.bytedance.sdk.openadsdk.core.b.a aVar) {
        if (this.a.u() == 2) {
            b(bVar, aVar);
            while (true) {
                char c2 = 15;
                while (true) {
                    switch (c2) {
                        case 13:
                        case 14:
                            return;
                        default:
                            c2 = 14;
                    }
                }
            }
        } else {
            a(aVar);
        }
    }

    private void a(List<View> list, com.bytedance.sdk.openadsdk.core.b.c cVar) {
        if (j.b(list)) {
            for (View next : list) {
                if (next != null) {
                    next.setOnClickListener(cVar);
                    next.setOnTouchListener(cVar);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z, ViewGroup viewGroup) {
        if (z && this.a.bj() && !this.a.bo()) {
            this.a.f(true);
            q qVar = this.a;
            com.bytedance.sdk.openadsdk.b.c.a(qVar, this.f, qVar.bk());
        }
        if (z || this.h <= 0) {
            this.i.a(System.currentTimeMillis(), y.a(viewGroup));
            this.h = SystemClock.elapsedRealtime();
            while (true) {
                char c2 = 27;
                while (true) {
                    switch (c2) {
                        case 25:
                        case 26:
                            return;
                        case 27:
                            c2 = 25;
                    }
                }
            }
        } else {
            String valueOf = String.valueOf(SystemClock.elapsedRealtime() - this.h);
            this.i.a(System.currentTimeMillis(), y.a(viewGroup));
            com.bytedance.sdk.openadsdk.b.c.a(valueOf, this.a, this.f, this.i);
            this.h = 0;
        }
    }

    private EmptyView b(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, f fVar) {
        this.g = fVar;
        viewGroup.addOnLayoutChangeListener(new a(this.i, viewGroup));
        this.e = list;
        EmptyView d2 = d(viewGroup);
        if (d2 == null) {
            d2 = new EmptyView(this.c, viewGroup);
            viewGroup.addView(d2);
        }
        d2.a();
        d2.setRefClickViews(list2);
        if (list != null) {
            for (View next : this.e) {
                if (next != null) {
                    next.setTag(520093762, true);
                }
            }
            if (list3 != null) {
                list3.addAll(list);
            }
        }
        d2.setRefCreativeViews(list3);
        return d2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0027, code lost:
        switch(r1) {
            case 52: goto L_0x0021;
            case 53: goto L_0x002b;
            case 54: goto L_0x0036;
            default: goto L_0x002a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002b, code lost:
        switch(r0) {
            case 29: goto L_0x003b;
            case 30: goto L_0x0021;
            case 31: goto L_0x0027;
            default: goto L_0x002e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        r0 = 30;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r6 = this;
            long r0 = r6.h
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x003b
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r4 = r6.h
            long r0 = r0 - r4
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.bytedance.sdk.openadsdk.core.model.q r1 = r6.a
            java.lang.String r4 = r6.f
            com.bytedance.sdk.openadsdk.b.g r5 = r6.i
            com.bytedance.sdk.openadsdk.b.c.a((java.lang.String) r0, (com.bytedance.sdk.openadsdk.core.model.q) r1, (java.lang.String) r4, (com.bytedance.sdk.openadsdk.b.g) r5)
            r6.h = r2
            r0 = 55
            r1 = 0
        L_0x0021:
            r2 = 72
        L_0x0023:
            switch(r2) {
                case 72: goto L_0x0036;
                case 73: goto L_0x0031;
                case 74: goto L_0x0027;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x0021
        L_0x0027:
            switch(r1) {
                case 52: goto L_0x0021;
                case 53: goto L_0x002b;
                case 54: goto L_0x0036;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0036
        L_0x002b:
            switch(r0) {
                case 29: goto L_0x003b;
                case 30: goto L_0x0021;
                case 31: goto L_0x0027;
                default: goto L_0x002e;
            }
        L_0x002e:
            r0 = 30
            goto L_0x002b
        L_0x0031:
            r2 = 57
            if (r1 > r2) goto L_0x0036
            goto L_0x003b
        L_0x0036:
            r2 = 73
            r1 = 16
            goto L_0x0023
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.n.b():void");
    }

    /* access modifiers changed from: private */
    public void b(ViewGroup viewGroup) {
        this.i.a(System.currentTimeMillis(), y.a(viewGroup));
    }

    /* access modifiers changed from: private */
    public void b(ViewGroup viewGroup, View view) {
        if (!this.l.get()) {
            this.l.set(true);
            if (this.d instanceof com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress.b) {
                NativeExpressView b2 = this.j.b();
                if (b2 != null) {
                    b2.i();
                }
                ((com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress.b) this.d).a(true);
            }
            this.i.a(System.currentTimeMillis(), y.a(viewGroup));
            this.h = SystemClock.elapsedRealtime();
            c(viewGroup);
            f fVar = this.g;
            if (fVar != null) {
                fVar.a(this.d);
            }
            if (this.a.ah()) {
                ac.a(this.a, view);
            }
            if (this.a.au() != null) {
                this.a.au().a().a(0);
            }
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055 A[RETURN] */
    private void b(com.bytedance.sdk.openadsdk.core.b.b r3, com.bytedance.sdk.openadsdk.core.b.a r4) {
        /*
            r2 = this;
            com.bytedance.sdk.openadsdk.apiImpl.feed.a r0 = r2.j
            if (r0 == 0) goto L_0x0024
            com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView r0 = r0.b()
            if (r0 == 0) goto L_0x0024
            com.bytedance.sdk.openadsdk.apiImpl.feed.a r0 = r2.j
            com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView r0 = r0.b()
            boolean r1 = r3 instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.g
            if (r1 == 0) goto L_0x0024
            boolean r1 = r4 instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.f
            if (r1 == 0) goto L_0x0024
            r1 = r3
            com.bytedance.sdk.openadsdk.core.nativeexpress.g r1 = (com.bytedance.sdk.openadsdk.core.nativeexpress.g) r1
            r0.setClickListener(r1)
            r1 = r4
            com.bytedance.sdk.openadsdk.core.nativeexpress.f r1 = (com.bytedance.sdk.openadsdk.core.nativeexpress.f) r1
            r0.setClickCreativeListener(r1)
        L_0x0024:
            com.bytedance.sdk.openadsdk.apiImpl.feed.a r0 = r2.j
            if (r0 == 0) goto L_0x0040
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView r0 = r0.a()
            if (r0 == 0) goto L_0x0040
            com.bytedance.sdk.openadsdk.apiImpl.feed.a r0 = r2.j
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView r0 = r0.a()
            r0.setOnClickListener(r4)
            com.bytedance.sdk.openadsdk.apiImpl.feed.a r0 = r2.j
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView r0 = r0.a()
            r0.setOnTouchListener(r4)
        L_0x0040:
            com.bytedance.sdk.openadsdk.apiImpl.feed.a r0 = r2.j
            if (r0 == 0) goto L_0x004f
            r0.a((com.bytedance.sdk.openadsdk.core.b.a) r4)
            com.bytedance.sdk.openadsdk.apiImpl.feed.a r4 = r2.j
            r4.a((com.bytedance.sdk.openadsdk.core.b.b) r3)
            r3 = 93
            goto L_0x0051
        L_0x004f:
            r3 = 92
        L_0x0051:
            switch(r3) {
                case 92: goto L_0x0055;
                case 93: goto L_0x0055;
                case 94: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x004f
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.n.b(com.bytedance.sdk.openadsdk.core.b.b, com.bytedance.sdk.openadsdk.core.b.a):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(android.view.ViewGroup r12) {
        /*
            r11 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
            r0.<init>()     // Catch:{ JSONException -> 0x0101 }
            java.util.List<android.view.View> r1 = r11.e     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r2 = "amrke"
            java.lang.String r3 = "hdkdlq"
            java.lang.String r4 = "whfwl"
            if (r1 == 0) goto L_0x0060
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0101 }
            r1.<init>()     // Catch:{ JSONException -> 0x0101 }
            java.util.List<android.view.View> r5 = r11.e     // Catch:{ JSONException -> 0x0101 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ JSONException -> 0x0101 }
        L_0x001a:
            boolean r6 = r5.hasNext()     // Catch:{ JSONException -> 0x0101 }
            if (r6 == 0) goto L_0x0053
            java.lang.Object r6 = r5.next()     // Catch:{ JSONException -> 0x0101 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ JSONException -> 0x0101 }
            if (r6 == 0) goto L_0x001a
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
            r7.<init>()     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r8 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r4)     // Catch:{ all -> 0x004f }
            int r9 = r6.getWidth()     // Catch:{ all -> 0x004f }
            r7.put(r8, r9)     // Catch:{ all -> 0x004f }
            java.lang.String r8 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r3)     // Catch:{ all -> 0x004f }
            int r9 = r6.getHeight()     // Catch:{ all -> 0x004f }
            r7.put(r8, r9)     // Catch:{ all -> 0x004f }
            java.lang.String r8 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r2)     // Catch:{ all -> 0x004f }
            float r6 = r6.getAlpha()     // Catch:{ all -> 0x004f }
            double r9 = (double) r6     // Catch:{ all -> 0x004f }
            r7.put(r8, r9)     // Catch:{ all -> 0x004f }
        L_0x004f:
            r1.put(r7)     // Catch:{ JSONException -> 0x0101 }
            goto L_0x001a
        L_0x0053:
            java.lang.String r5 = "ilcdaZpnm~"
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r5)     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0101 }
            r0.put(r5, r1)     // Catch:{ JSONException -> 0x0101 }
        L_0x0060:
            if (r12 == 0) goto L_0x0096
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
            r1.<init>()     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r4)     // Catch:{ all -> 0x0089 }
            int r6 = r12.getWidth()     // Catch:{ all -> 0x0089 }
            r1.put(r5, r6)     // Catch:{ all -> 0x0089 }
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r3)     // Catch:{ all -> 0x0089 }
            int r6 = r12.getHeight()     // Catch:{ all -> 0x0089 }
            r1.put(r5, r6)     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r2)     // Catch:{ all -> 0x0089 }
            float r12 = r12.getAlpha()     // Catch:{ all -> 0x0089 }
            double r5 = (double) r12     // Catch:{ all -> 0x0089 }
            r1.put(r2, r5)     // Catch:{ all -> 0x0089 }
        L_0x0089:
            java.lang.String r12 = "rnmw[sob"
            java.lang.String r12 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r12)     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0101 }
            r0.put(r12, r1)     // Catch:{ JSONException -> 0x0101 }
        L_0x0096:
            com.bytedance.sdk.openadsdk.apiImpl.feed.a r12 = r11.j     // Catch:{ JSONException -> 0x0101 }
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView r12 = r12.h()     // Catch:{ JSONException -> 0x0101 }
            if (r12 == 0) goto L_0x00de
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
            r1.<init>()     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r2 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r4)     // Catch:{ all -> 0x00d1 }
            android.content.Context r4 = r11.c     // Catch:{ all -> 0x00d1 }
            int r5 = r12.getWidth()     // Catch:{ all -> 0x00d1 }
            float r5 = (float) r5     // Catch:{ all -> 0x00d1 }
            int r4 = com.bytedance.sdk.openadsdk.utils.ad.c(r4, r5)     // Catch:{ all -> 0x00d1 }
            float r4 = (float) r4     // Catch:{ all -> 0x00d1 }
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 * r5
            double r6 = (double) r4     // Catch:{ all -> 0x00d1 }
            r1.put(r2, r6)     // Catch:{ all -> 0x00d1 }
            java.lang.String r2 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r3)     // Catch:{ all -> 0x00d1 }
            android.content.Context r3 = r11.c     // Catch:{ all -> 0x00d1 }
            int r12 = r12.getHeight()     // Catch:{ all -> 0x00d1 }
            float r12 = (float) r12     // Catch:{ all -> 0x00d1 }
            int r12 = com.bytedance.sdk.openadsdk.utils.ad.c(r3, r12)     // Catch:{ all -> 0x00d1 }
            float r12 = (float) r12     // Catch:{ all -> 0x00d1 }
            float r12 = r12 * r5
            double r3 = (double) r12     // Catch:{ all -> 0x00d1 }
            r1.put(r2, r3)     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            java.lang.String r12 = "mdfjeZpnm~"
            java.lang.String r12 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r12)     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0101 }
            r0.put(r12, r1)     // Catch:{ JSONException -> 0x0101 }
        L_0x00de:
            com.bytedance.sdk.openadsdk.apiImpl.feed.a r12 = r11.j     // Catch:{ JSONException -> 0x0101 }
            com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView r12 = r12.b()     // Catch:{ JSONException -> 0x0101 }
            if (r12 == 0) goto L_0x00f9
            com.bytedance.sdk.openadsdk.core.model.q r12 = r11.a     // Catch:{ JSONException -> 0x0101 }
            if (r12 == 0) goto L_0x00f9
            java.lang.String r12 = "dxlbileX{ae|Sywu"
            java.lang.String r12 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r12)     // Catch:{ JSONException -> 0x0101 }
            com.bytedance.sdk.openadsdk.core.model.q r1 = r11.a     // Catch:{ JSONException -> 0x0101 }
            int r1 = r1.x()     // Catch:{ JSONException -> 0x0101 }
            r0.put(r12, r1)     // Catch:{ JSONException -> 0x0101 }
        L_0x00f9:
            com.bytedance.sdk.openadsdk.core.model.q r12 = r11.a     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r1 = r11.f     // Catch:{ JSONException -> 0x0101 }
            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.openadsdk.core.model.q) r12, (java.lang.String) r1, (org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x0101 }
            goto L_0x0111
        L_0x0101:
            r12 = move-exception
            java.lang.String r0 = "IovfvdesafdFmcohuc"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r0)
            java.lang.String r1 = "ooQkkr@rf)`xcc.jbc}a"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r1)
            com.bytedance.sdk.component.utils.l.c(r0, r1, r12)
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.n.c(android.view.ViewGroup):void");
    }

    private EmptyView d(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public g a() {
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0012  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r2, int r3) {
        /*
            r1 = this;
            com.bytedance.sdk.openadsdk.apiImpl.feed.f r3 = r1.g
            if (r3 == 0) goto L_0x000a
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r0 = r1.d
            r3.b(r2, r0)
            goto L_0x001d
        L_0x000a:
            r2 = 95
            r3 = 95
        L_0x000e:
            switch(r2) {
                case 94: goto L_0x001a;
                case 95: goto L_0x0012;
                case 96: goto L_0x0015;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x001d
        L_0x0012:
            switch(r3) {
                case 94: goto L_0x000a;
                case 95: goto L_0x0019;
                case 96: goto L_0x000a;
                default: goto L_0x0015;
            }
        L_0x0015:
            switch(r3) {
                case 55: goto L_0x0019;
                case 56: goto L_0x001d;
                case 57: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x000a
        L_0x0019:
            return
        L_0x001a:
            r2 = 39
            goto L_0x000a
        L_0x001d:
            r2 = 94
            r3 = 125(0x7d, float:1.75E-43)
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.n.a(android.view.View, int):void");
    }

    public void a(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, f fVar) {
        a(viewGroup, list, list2, list3, fVar);
        a(viewGroup, view);
        a(viewGroup, list2, list3);
    }

    public void a(com.bykv.vk.openvk.component.video.api.d.c cVar) {
        this.k = cVar;
        b bVar = this.m;
        if (bVar != null) {
            bVar.a(cVar);
        }
        com.bytedance.sdk.openadsdk.core.b.a aVar = this.n;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }
}
