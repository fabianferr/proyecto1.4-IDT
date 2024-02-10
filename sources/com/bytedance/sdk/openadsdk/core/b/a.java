package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.i;
import java.lang.ref.WeakReference;

/* compiled from: ClickCreativeListener */
public class a extends b {
    private boolean G = false;
    private WeakReference<C0061a> H;
    private int I;
    private boolean a = true;
    private boolean b = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* compiled from: ClickCreativeListener */
    public interface C0061a {
        long getVideoProgress();
    }

    public a(Context context, q qVar, String str, int i) {
        super(context, qVar, str, i);
    }

    private String b(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c = 0;
                    break;
                }
                break;
            case -1263194568:
                if (str.equals("open_ad")) {
                    c = 1;
                    break;
                }
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c = 2;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c = 3;
                    break;
                }
                break;
            case 2091589896:
                if (str.equals("slide_banner_ad")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "banner_call";
            case 1:
                return "open_ad";
            case 2:
                return "feed_call";
            case 3:
                return "interaction_call";
            case 4:
                return "banner_call";
            default:
                return "";
        }
    }

    private boolean d(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if (view instanceof NativeVideoTsView) {
            str = "NativeVideoTsView....";
        } else if (view.getId() == i.aE || view.getId() == i.K || view.getId() == i.L || view.getId() == i.M || view.getId() == i.N) {
            str = "tt_video_ad_cover_center_layout....";
        } else if (view.getId() == 520093726 || view.getId() == i.aJ) {
            str = "tt_root_view....";
        } else if (!(view instanceof ViewGroup)) {
            return false;
        } else {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return false;
                }
                if (d(viewGroup.getChildAt(i))) {
                    return true;
                }
                i++;
            }
        }
        l.c("ClickCreativeListener", str);
        return true;
    }

    private boolean h() {
        return q.c(this.e) && this.e.w() == 1;
    }

    private boolean i() {
        return this instanceof f;
    }

    private boolean j() {
        if (this.e == null || i()) {
            return false;
        }
        if (this.e.ad() != 5 && this.e.ad() != 15) {
            return false;
        }
        if (this.I == 0) {
            this.I = this.e.aS();
        }
        StringBuilder sb = new StringBuilder("!isViewVisibility()=");
        sb.append(!b());
        sb.append(",isAutoPlay()=");
        sb.append(a());
        sb.append(",!isCoverPageVisibility()=");
        sb.append(!c());
        l.b("ClickCreativeListener", sb.toString());
        if (this.I == 5 && h() && a() && !b() && !c()) {
            return false;
        }
        int i = this.I;
        return i == 1 || i == 2 || i == 5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0389, code lost:
        if ((r2 instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView) == false) goto L_0x038b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x039b, code lost:
        if (r3.booleanValue() != false) goto L_0x039d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03df  */
    /* JADX WARNING: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r35, float r36, float r37, float r38, float r39, android.util.SparseArray<com.bytedance.sdk.openadsdk.core.b.c.a> r40, boolean r41) {
        /*
            r34 = this;
            r11 = r34
            r10 = r35
            r9 = r41
            r2 = 2
            r0 = r34
            r1 = r35
            r3 = r36
            r4 = r37
            r5 = r38
            r6 = r39
            r7 = r40
            r8 = r41
            boolean r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r0 == 0) goto L_0x001e
            return
        L_0x001e:
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            r0.bl()
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            boolean r0 = r0.d()
            r8 = 1
            if (r0 != 0) goto L_0x0031
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            r0.a((boolean) r8)
        L_0x0031:
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.q.c((com.bytedance.sdk.openadsdk.core.model.q) r0)
            if (r0 == 0) goto L_0x0046
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            java.lang.String r1 = r11.f
            com.bytedance.sdk.openadsdk.core.model.q r2 = r11.e
            long r2 = r2.bm()
            com.bytedance.sdk.openadsdk.b.c.b((com.bytedance.sdk.openadsdk.core.model.q) r0, (java.lang.String) r1, (long) r2)
        L_0x0046:
            com.bykv.vk.openvk.component.video.api.d.c r0 = r11.m
            if (r0 == 0) goto L_0x0066
            java.util.Map r0 = r11.p
            if (r0 != 0) goto L_0x0055
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r11.p = r0
        L_0x0055:
            java.util.Map r0 = r11.p
            com.bykv.vk.openvk.component.video.api.d.c r1 = r11.m
            long r1 = r1.e()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "duration"
            r0.put(r2, r1)
        L_0x0066:
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            int r6 = r0.aI()
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            r7 = 0
            r0.E(r7)
            com.com.bytedance.overseas.sdk.a.c r0 = r11.o
            if (r0 == 0) goto L_0x0080
            com.com.bytedance.overseas.sdk.a.c r0 = r11.o
            if (r6 <= 0) goto L_0x007c
            r1 = r6
            goto L_0x007d
        L_0x007c:
            r1 = 0
        L_0x007d:
            r0.a((int) r1)
        L_0x0080:
            java.util.Map r0 = r11.p
            java.lang.String r1 = "click_probability_jump"
            java.lang.String r2 = "dsp_click_type"
            java.lang.String r5 = "auto_click"
            if (r0 == 0) goto L_0x0099
            java.util.Map r0 = r11.p
            r0.remove(r2)
            java.util.Map r0 = r11.p
            r0.remove(r1)
            java.util.Map r0 = r11.p
            r0.remove(r5)
        L_0x0099:
            if (r6 <= 0) goto L_0x00d2
            java.util.Map r0 = r11.p
            if (r0 != 0) goto L_0x00a6
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r11.p = r0
        L_0x00a6:
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            boolean r0 = r0.at()
            r3 = 11
            if (r0 == 0) goto L_0x00bb
            if (r6 >= r3) goto L_0x00bb
            java.util.Map r0 = r11.p
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r0.put(r2, r4)
        L_0x00bb:
            if (r6 < r3) goto L_0x00d2
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            int r0 = r0.be()
            if (r0 != 0) goto L_0x00d2
            int r0 = com.bytedance.sdk.openadsdk.core.model.e.a(r6)
            java.util.Map r2 = r11.p
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.put(r1, r0)
        L_0x00d2:
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            boolean r0 = r0.at()
            if (r0 == 0) goto L_0x016b
            if (r10 == 0) goto L_0x00ea
            r0 = 570425345(0x22000001, float:1.7347237E-18)
            java.lang.Object r0 = r10.getTag(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x00ea
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x00ec
        L_0x00ea:
            java.lang.String r0 = "VAST_ACTION_BUTTON"
        L_0x00ec:
            com.bytedance.sdk.openadsdk.core.model.q r1 = r11.e
            com.bytedance.sdk.openadsdk.core.g.a r1 = r1.au()
            r1.e(r0)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0101
            r11.a((java.lang.String) r0)
        L_0x0101:
            java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.b.a$a> r1 = r11.H
            if (r1 == 0) goto L_0x0118
            java.lang.Object r1 = r1.get()
            if (r1 == 0) goto L_0x0118
            java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.b.a$a> r1 = r11.H
            java.lang.Object r1 = r1.get()
            com.bytedance.sdk.openadsdk.core.b.a$a r1 = (com.bytedance.sdk.openadsdk.core.b.a.C0061a) r1
            long r1 = r1.getVideoProgress()
            goto L_0x011a
        L_0x0118:
            r1 = 0
        L_0x011a:
            java.lang.String r3 = "VAST_ICON"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x013c
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            com.bytedance.sdk.openadsdk.core.g.a r0 = r0.au()
            com.bytedance.sdk.openadsdk.core.g.b r0 = r0.b()
            if (r0 == 0) goto L_0x016b
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            com.bytedance.sdk.openadsdk.core.g.a r0 = r0.au()
            com.bytedance.sdk.openadsdk.core.g.b r0 = r0.b()
            r0.a((long) r1)
            goto L_0x016b
        L_0x013c:
            java.lang.String r3 = "VAST_END_CARD"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x015e
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            com.bytedance.sdk.openadsdk.core.g.a r0 = r0.au()
            com.bytedance.sdk.openadsdk.core.g.c r0 = r0.c()
            if (r0 == 0) goto L_0x016b
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            com.bytedance.sdk.openadsdk.core.g.a r0 = r0.au()
            com.bytedance.sdk.openadsdk.core.g.c r0 = r0.c()
            r0.a((long) r1)
            goto L_0x016b
        L_0x015e:
            com.bytedance.sdk.openadsdk.core.model.q r0 = r11.e
            com.bytedance.sdk.openadsdk.core.g.a r0 = r0.au()
            com.bytedance.sdk.openadsdk.core.g.d r0 = r0.a()
            r0.g((long) r1)
        L_0x016b:
            boolean r0 = r34.j()
            java.lang.String r1 = "ClickCreativeListener"
            if (r0 == 0) goto L_0x0186
            boolean r0 = r34.d(r35)
            if (r0 == 0) goto L_0x0186
            boolean r0 = r11.G
            if (r0 != 0) goto L_0x0186
            java.lang.String r0 = "Intercept the native video view , Select the normal click event....."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)
            super.a(r35, r36, r37, r38, r39, r40, r41)
            return
        L_0x0186:
            java.lang.String r0 = "Select creative area click event....."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)
            android.content.Context r0 = r11.c
            if (r0 != 0) goto L_0x0195
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.o.a()
            r11.c = r0
        L_0x0195:
            android.content.Context r0 = r11.c
            if (r0 != 0) goto L_0x019a
            return
        L_0x019a:
            boolean r0 = r11.a((android.view.View) r10, (boolean) r9)
            if (r0 != 0) goto L_0x01a1
            return
        L_0x01a1:
            org.json.JSONObject r0 = com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.a((android.view.View) r35)
            com.bytedance.sdk.openadsdk.core.model.m r1 = r11.d
            r18 = -1
            if (r1 == 0) goto L_0x01b8
            com.bytedance.sdk.openadsdk.core.model.m r0 = r11.d
            int r0 = r0.l
            com.bytedance.sdk.openadsdk.core.model.m r1 = r11.d
            org.json.JSONObject r1 = r1.m
            r16 = r0
            r17 = r1
            goto L_0x01bc
        L_0x01b8:
            r17 = r0
            r16 = -1
        L_0x01bc:
            long r3 = r11.x
            long r1 = r11.y
            java.lang.ref.WeakReference r0 = r11.h
            if (r0 != 0) goto L_0x01c9
            android.view.View r0 = r34.d()
            goto L_0x01d1
        L_0x01c9:
            java.lang.ref.WeakReference r0 = r11.h
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
        L_0x01d1:
            r19 = r0
            java.lang.ref.WeakReference r0 = r11.i
            if (r0 != 0) goto L_0x01dc
            android.view.View r0 = r34.e()
            goto L_0x01e4
        L_0x01dc:
            java.lang.ref.WeakReference r0 = r11.i
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
        L_0x01e4:
            r20 = r0
            java.lang.String r12 = r34.f()
            android.content.Context r0 = r11.c
            float r13 = com.bytedance.sdk.openadsdk.utils.ad.e((android.content.Context) r0)
            android.content.Context r0 = r11.c
            int r14 = com.bytedance.sdk.openadsdk.utils.ad.g(r0)
            android.content.Context r0 = r11.c
            float r15 = com.bytedance.sdk.openadsdk.utils.ad.f((android.content.Context) r0)
            r0 = r34
            r21 = r1
            r1 = r36
            r2 = r37
            r23 = r3
            r3 = r38
            r4 = r39
            r25 = r5
            r5 = r40
            r26 = r6
            r6 = r23
            r23 = 1
            r8 = r21
            r10 = r19
            r11 = r20
            com.bytedance.sdk.openadsdk.core.model.i r0 = r0.a(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17)
            r1 = r34
            r1.j = r0
            com.bytedance.sdk.openadsdk.core.model.q r0 = r1.e
            int r0 = r0.M()
            r2 = 4
            r3 = 3
            r8 = 2
            if (r0 == r8) goto L_0x0313
            if (r0 == r3) goto L_0x0313
            if (r0 == r2) goto L_0x027b
            r2 = 5
            if (r0 == r2) goto L_0x0239
            r2 = r35
            r0 = -1
            goto L_0x03db
        L_0x0239:
            java.lang.String r2 = r1.f
            java.lang.String r12 = r1.b((java.lang.String) r2)
            r2 = r12
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0259
            com.bytedance.sdk.openadsdk.core.model.q r10 = r1.e
            com.bytedance.sdk.openadsdk.core.model.i r11 = r1.j
            java.util.Map r14 = r1.p
            if (r41 == 0) goto L_0x0252
            r15 = 1
            goto L_0x0253
        L_0x0252:
            r15 = 2
        L_0x0253:
            java.lang.String r9 = "click_call"
            r13 = 1
            com.bytedance.sdk.openadsdk.b.c.a((java.lang.String) r9, (com.bytedance.sdk.openadsdk.core.model.q) r10, (com.bytedance.sdk.openadsdk.core.model.i) r11, (java.lang.String) r12, (boolean) r13, (java.util.Map<java.lang.String, java.lang.Object>) r14, (int) r15)
        L_0x0259:
            android.content.Context r2 = r35.getContext()
            com.bytedance.sdk.openadsdk.core.model.q r3 = r1.e
            java.lang.String r3 = r3.R()
            boolean r13 = com.bytedance.sdk.openadsdk.utils.ac.c(r2, r3)
            com.bytedance.sdk.openadsdk.core.model.q r10 = r1.e
            com.bytedance.sdk.openadsdk.core.model.i r11 = r1.j
            java.lang.String r12 = r1.f
            java.util.Map r14 = r1.p
            if (r41 == 0) goto L_0x0273
            r15 = 1
            goto L_0x0274
        L_0x0273:
            r15 = 2
        L_0x0274:
            java.lang.String r9 = "click"
        L_0x0276:
            com.bytedance.sdk.openadsdk.b.c.a((java.lang.String) r9, (com.bytedance.sdk.openadsdk.core.model.q) r10, (com.bytedance.sdk.openadsdk.core.model.i) r11, (java.lang.String) r12, (boolean) r13, (java.util.Map<java.lang.String, java.lang.Object>) r14, (int) r15)
            goto L_0x030f
        L_0x027b:
            com.bytedance.sdk.openadsdk.core.model.q r2 = r1.e
            boolean r2 = com.bytedance.sdk.openadsdk.core.model.t.b(r2)
            if (r2 == 0) goto L_0x02c2
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r2 = r1.l
            if (r2 != 0) goto L_0x028b
            com.bytedance.sdk.openadsdk.api.PangleAd r2 = r1.q
            if (r2 == 0) goto L_0x02c2
        L_0x028b:
            android.content.Context r9 = r1.c
            com.bytedance.sdk.openadsdk.core.model.q r10 = r1.e
            int r11 = r1.g
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r12 = r1.l
            com.bytedance.sdk.openadsdk.api.PangleAd r13 = r1.q
            java.lang.String r14 = r1.f
            com.com.bytedance.overseas.sdk.a.c r15 = r1.o
            r16 = 1
            r17 = r26
            boolean r31 = com.bytedance.sdk.openadsdk.core.z.a((android.content.Context) r9, (com.bytedance.sdk.openadsdk.core.model.q) r10, (int) r11, (com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd) r12, (com.bytedance.sdk.openadsdk.api.PangleAd) r13, (java.lang.String) r14, (com.com.bytedance.overseas.sdk.a.c) r15, (boolean) r16, (int) r17)
            boolean r2 = r1.a
            if (r2 == 0) goto L_0x030f
            com.bytedance.sdk.openadsdk.core.model.q r2 = r1.e
            com.bytedance.sdk.openadsdk.core.model.i r3 = r1.j
            java.lang.String r4 = r1.f
            java.util.Map r5 = r1.p
            if (r41 == 0) goto L_0x02b2
            r33 = 1
            goto L_0x02b4
        L_0x02b2:
            r33 = 2
        L_0x02b4:
            java.lang.String r27 = "click"
            r28 = r2
            r29 = r3
            r30 = r4
            r32 = r5
            com.bytedance.sdk.openadsdk.b.c.a((java.lang.String) r27, (com.bytedance.sdk.openadsdk.core.model.q) r28, (com.bytedance.sdk.openadsdk.core.model.i) r29, (java.lang.String) r30, (boolean) r31, (java.util.Map<java.lang.String, java.lang.Object>) r32, (int) r33)
            goto L_0x030f
        L_0x02c2:
            com.com.bytedance.overseas.sdk.a.c r2 = r1.o
            if (r2 == 0) goto L_0x030f
            com.com.bytedance.overseas.sdk.a.c r2 = r1.o
            r2.d()
            java.util.Map r14 = r1.p
            com.bytedance.sdk.openadsdk.core.model.q r2 = r1.e
            boolean r2 = r2.d()
            if (r2 == 0) goto L_0x02fb
            com.bytedance.sdk.openadsdk.core.model.q r2 = r1.e
            boolean r2 = r2.c()
            if (r2 != 0) goto L_0x02fb
            com.bytedance.sdk.openadsdk.core.model.q r2 = r1.e
            boolean r2 = r2.e()
            if (r2 == 0) goto L_0x02ec
            java.lang.Integer r2 = java.lang.Integer.valueOf(r23)
            r3 = r25
            goto L_0x02f2
        L_0x02ec:
            r3 = r25
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
        L_0x02f2:
            r14.put(r3, r2)
            com.bytedance.sdk.openadsdk.core.model.q r2 = r1.e
            r4 = 0
            r2.b((boolean) r4)
        L_0x02fb:
            boolean r2 = r1.a
            if (r2 == 0) goto L_0x030f
            com.bytedance.sdk.openadsdk.core.model.q r10 = r1.e
            com.bytedance.sdk.openadsdk.core.model.i r11 = r1.j
            java.lang.String r12 = r1.f
            if (r41 == 0) goto L_0x0309
            r15 = 1
            goto L_0x030a
        L_0x0309:
            r15 = 2
        L_0x030a:
            java.lang.String r9 = "click"
            r13 = 1
            goto L_0x0276
        L_0x030f:
            r2 = r35
            goto L_0x03db
        L_0x0313:
            r4 = 0
            if (r0 != r3) goto L_0x035c
            com.bytedance.sdk.openadsdk.core.model.q r3 = r1.e
            java.lang.String r3 = r3.P()
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x035c
            java.lang.String r5 = "play.google.com/store"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = r3.contains(r5)
            if (r5 == 0) goto L_0x035c
            java.lang.String r5 = "?id="
            int r5 = r3.indexOf(r5)
            int r5 = r5 + r2
            java.lang.String r2 = r3.substring(r5)
            android.content.Context r5 = r1.c
            java.lang.String r6 = r1.f
            com.bytedance.sdk.openadsdk.core.model.q r7 = r1.e
            boolean r2 = com.com.bytedance.overseas.sdk.a.b.a(r5, r3, r2, r6, r7)
            if (r2 == 0) goto L_0x035c
            boolean r2 = r1.a
            if (r2 == 0) goto L_0x030f
            com.bytedance.sdk.openadsdk.core.model.q r10 = r1.e
            com.bytedance.sdk.openadsdk.core.model.i r11 = r1.j
            java.lang.String r12 = r1.f
            java.util.Map r14 = r1.p
            if (r41 == 0) goto L_0x0356
            r15 = 1
            goto L_0x0357
        L_0x0356:
            r15 = 2
        L_0x0357:
            java.lang.String r9 = "click"
            r13 = 1
            goto L_0x0276
        L_0x035c:
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r2 = r1.l
            if (r2 != 0) goto L_0x0368
            boolean r2 = r1.b
            if (r2 == 0) goto L_0x0365
            goto L_0x0368
        L_0x0365:
            r2 = r35
            goto L_0x037c
        L_0x0368:
            com.bytedance.sdk.openadsdk.core.model.q r10 = r1.e
            com.bytedance.sdk.openadsdk.core.model.i r11 = r1.j
            java.lang.String r12 = r1.f
            java.util.Map r14 = r1.p
            if (r41 == 0) goto L_0x0374
            r15 = 1
            goto L_0x0375
        L_0x0374:
            r15 = 2
        L_0x0375:
            java.lang.String r9 = "click_button"
            r13 = 1
            com.bytedance.sdk.openadsdk.b.c.a((java.lang.String) r9, (com.bytedance.sdk.openadsdk.core.model.q) r10, (com.bytedance.sdk.openadsdk.core.model.i) r11, (java.lang.String) r12, (boolean) r13, (java.util.Map<java.lang.String, java.lang.Object>) r14, (int) r15)
            goto L_0x0365
        L_0x037c:
            if (r2 == 0) goto L_0x038b
            int r3 = r35.getId()     // Catch:{ Exception -> 0x03a1 }
            r5 = 520093726(0x1f00001e, float:2.710515E-20)
            if (r3 == r5) goto L_0x039d
            boolean r3 = r2 instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView     // Catch:{ Exception -> 0x03a1 }
            if (r3 != 0) goto L_0x039d
        L_0x038b:
            r3 = 520093762(0x1f000042, float:2.7105268E-20)
            java.lang.Object r3 = r2.getTag(r3)     // Catch:{ Exception -> 0x03a1 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x03a1 }
            r5 = r3
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x03a1 }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x03a1 }
            if (r3 == 0) goto L_0x03a2
        L_0x039d:
            com.bytedance.sdk.openadsdk.core.z.a((boolean) r23)     // Catch:{ Exception -> 0x03a1 }
            goto L_0x03a2
        L_0x03a1:
        L_0x03a2:
            android.content.Context r9 = r1.c
            com.bytedance.sdk.openadsdk.core.model.q r10 = r1.e
            int r11 = r1.g
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r12 = r1.l
            com.bytedance.sdk.openadsdk.api.PangleAd r13 = r1.q
            java.lang.String r14 = r1.f
            com.com.bytedance.overseas.sdk.a.c r15 = r1.o
            r16 = 1
            r17 = r26
            boolean r31 = com.bytedance.sdk.openadsdk.core.z.a((android.content.Context) r9, (com.bytedance.sdk.openadsdk.core.model.q) r10, (int) r11, (com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd) r12, (com.bytedance.sdk.openadsdk.api.PangleAd) r13, (java.lang.String) r14, (com.com.bytedance.overseas.sdk.a.c) r15, (boolean) r16, (int) r17)
            com.bytedance.sdk.openadsdk.core.z.a((boolean) r4)
            boolean r3 = r1.a
            if (r3 == 0) goto L_0x03db
            com.bytedance.sdk.openadsdk.core.model.q r3 = r1.e
            com.bytedance.sdk.openadsdk.core.model.i r4 = r1.j
            java.lang.String r5 = r1.f
            java.util.Map r6 = r1.p
            if (r41 == 0) goto L_0x03cc
            r33 = 1
            goto L_0x03ce
        L_0x03cc:
            r33 = 2
        L_0x03ce:
            java.lang.String r27 = "click"
            r28 = r3
            r29 = r4
            r30 = r5
            r32 = r6
            com.bytedance.sdk.openadsdk.b.c.a((java.lang.String) r27, (com.bytedance.sdk.openadsdk.core.model.q) r28, (com.bytedance.sdk.openadsdk.core.model.i) r29, (java.lang.String) r30, (boolean) r31, (java.util.Map<java.lang.String, java.lang.Object>) r32, (int) r33)
        L_0x03db:
            com.bytedance.sdk.openadsdk.core.b.b$a r3 = r1.k
            if (r3 == 0) goto L_0x03e4
            com.bytedance.sdk.openadsdk.core.b.b$a r3 = r1.k
            r3.a(r2, r0)
        L_0x03e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.b.a.a(android.view.View, float, float, float, float, android.util.SparseArray, boolean):void");
    }

    public void a(C0061a aVar) {
        this.H = new WeakReference<>(aVar);
    }

    public void a(boolean z) {
        this.a = z;
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        if (this.e == null) {
            return true;
        }
        int b2 = o.d().b(this.e.aZ());
        int c = com.bytedance.sdk.component.utils.o.c(o.a());
        if (b2 == 1) {
            return ac.d(c);
        }
        if (b2 == 2) {
            return ac.e(c) || ac.d(c) || ac.f(c);
        }
        if (b2 != 3) {
            return b2 != 5 || ac.d(c) || ac.f(c);
        }
        return false;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return false;
    }

    public void c(boolean z) {
        this.G = z;
    }

    public boolean c() {
        return false;
    }
}
