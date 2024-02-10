package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.dynamic.b.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.f;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ComputeRuler */
public class a {
    public Map<String, c> a = new HashMap();
    public Map<String, c> b = new HashMap();
    public Map<String, c> c = new HashMap();
    private double d = Math.random();
    private double e;
    private int f;
    private double g;
    private String h;
    private m i;

    public a(double d2, int i2, double d3, String str, m mVar) {
        this.e = d2;
        this.f = i2;
        this.g = d3;
        this.h = str;
        this.i = mVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.adexpress.dynamic.c.a.c a(com.bytedance.sdk.component.adexpress.dynamic.b.h r13, float r14, float r15) {
        /*
            r12 = this;
            com.bytedance.sdk.component.adexpress.dynamic.b.e r0 = r13.j()
            java.lang.String r0 = r0.c()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0023
            com.bytedance.sdk.component.adexpress.dynamic.b.e r0 = r13.j()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r0 = r0.e()
            java.lang.String r0 = r0.ab()
            if (r0 != 0) goto L_0x0023
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r13.<init>(r1, r1)
            return r13
        L_0x0023:
            com.bytedance.sdk.component.adexpress.dynamic.b.e r0 = r13.j()
            java.lang.String r0 = r0.b()
            java.lang.String r2 = "creative-playable-bait"
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x0039
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r13.<init>(r1, r1)
            return r13
        L_0x0039:
            float r0 = r13.h()
            float r1 = r13.i()
            com.bytedance.sdk.component.adexpress.dynamic.b.e r2 = r13.j()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r2 = r2.e()
            java.lang.String r3 = r2.A()
            java.lang.String r2 = r2.z()
            int r4 = r13.m()
            float r4 = (float) r4
            int r5 = r13.n()
            float r5 = (float) r5
            float r6 = r13.o()
            float r7 = r13.p()
            java.lang.String r8 = "fixed"
            boolean r9 = android.text.TextUtils.equals(r3, r8)
            java.lang.String r10 = "flex"
            java.lang.String r11 = "auto"
            if (r9 == 0) goto L_0x0086
            float r14 = java.lang.Math.min(r0, r14)
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto L_0x00b7
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = r12.b((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13, (float) r0, (float) r1)
            float r13 = r13.b
        L_0x0083:
            float r1 = r13 + r7
            goto L_0x00b7
        L_0x0086:
            boolean r9 = android.text.TextUtils.equals(r3, r11)
            if (r9 == 0) goto L_0x009f
            float r14 = r14 - r6
            float r0 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = r12.b((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13, (float) r14, (float) r0)
            float r14 = r13.a
            float r14 = r14 + r6
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto L_0x00b7
            float r13 = r13.b
            goto L_0x0083
        L_0x009f:
            boolean r3 = android.text.TextUtils.equals(r3, r10)
            if (r3 == 0) goto L_0x00b6
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto L_0x00b7
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = r12.b((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13, (float) r0, (float) r1)
            float r13 = r13.b
            goto L_0x0083
        L_0x00b6:
            r14 = r0
        L_0x00b7:
            java.lang.String r13 = "scale"
            boolean r13 = android.text.TextUtils.equals(r2, r13)
            if (r13 == 0) goto L_0x00da
            float r13 = r14 - r4
            float r13 = r13 / r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r13 = r13 + r5
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d8
            float r13 = r15 - r5
            float r13 = r13 * r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r14 = r13 + r4
            goto L_0x00ee
        L_0x00d8:
            r15 = r13
            goto L_0x00ee
        L_0x00da:
            boolean r13 = android.text.TextUtils.equals(r2, r8)
            if (r13 == 0) goto L_0x00e6
            float r1 = r1 + r5
            float r15 = java.lang.Math.min(r1, r15)
            goto L_0x00ee
        L_0x00e6:
            boolean r13 = android.text.TextUtils.equals(r2, r10)
            if (r13 == 0) goto L_0x00ed
            goto L_0x00ee
        L_0x00ed:
            r15 = r1
        L_0x00ee:
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r13.<init>()
            r13.a = r14
            r13.b = r15
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.c.a.a(com.bytedance.sdk.component.adexpress.dynamic.b.h, float, float):com.bytedance.sdk.component.adexpress.dynamic.c.a$c");
    }

    public c b(h hVar, float f2, float f3) {
        c cVar = new c();
        if (hVar.j().e() == null) {
            return cVar;
        }
        c e2 = e(hVar, f2, f3);
        float f4 = e2.a;
        float f5 = e2.b;
        cVar.a = Math.min(f4, f2);
        cVar.b = Math.min(f5, f3);
        return cVar;
    }

    private c e(h hVar, float f2, float f3) {
        String str = hVar.c() + "_" + f2 + "_" + f3;
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        c f4 = f(hVar, f2, f3);
        this.c.put(str, f4);
        return f4;
    }

    private c f(h hVar, float f2, float f3) {
        new c();
        f e2 = hVar.j().e();
        hVar.j().c();
        e2.S();
        float r = e2.r();
        int R = e2.R();
        double Q = e2.Q();
        int T = e2.T();
        boolean K = e2.K();
        boolean U = e2.U();
        int L = e2.L();
        b bVar = new b();
        bVar.a = r;
        bVar.b = R;
        bVar.c = T;
        bVar.d = Q;
        bVar.e = f2;
        return a(hVar.j().c(), bVar, K, U, L, hVar);
    }

    private c a(String str, b bVar, boolean z, boolean z2, int i2, h hVar) {
        return j.a(str, hVar.j().b(), b.a(bVar).toString(), z, z2, i2, hVar, this.e, this.f, this.g, this.h, this.i);
    }

    public c c(h hVar, float f2, float f3) {
        if (hVar == null) {
            return null;
        }
        c a2 = a(hVar);
        if (a2 != null && (a2.a != 0.0f || a2.b != 0.0f)) {
            return a2;
        }
        c d2 = d(hVar, f2, f3);
        a(hVar, d2);
        return d2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.adexpress.dynamic.c.a.c d(com.bytedance.sdk.component.adexpress.dynamic.b.h r21, float r22, float r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            r2 = r23
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r3.<init>()
            r4 = 0
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0149
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x0016
            goto L_0x0149
        L_0x0016:
            boolean r5 = r21.r()
            if (r5 == 0) goto L_0x0021
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r1 = r20.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r21, (float) r22, (float) r23)
            return r1
        L_0x0021:
            float r5 = r21.h()
            float r6 = r21.i()
            float r7 = r21.o()
            float r8 = r21.p()
            com.bytedance.sdk.component.adexpress.dynamic.b.e r9 = r21.j()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r9 = r9.e()
            java.lang.String r10 = r9.A()
            java.lang.String r9 = r9.z()
            java.lang.String r11 = "flex"
            boolean r12 = android.text.TextUtils.equals(r10, r11)
            java.lang.String r13 = "auto"
            if (r12 != 0) goto L_0x0057
            boolean r12 = android.text.TextUtils.equals(r10, r13)
            if (r12 == 0) goto L_0x0052
            goto L_0x0057
        L_0x0052:
            float r5 = java.lang.Math.min(r5, r1)
            goto L_0x0058
        L_0x0057:
            r5 = r1
        L_0x0058:
            float r5 = r5 - r7
            java.lang.String r12 = "scale"
            boolean r12 = android.text.TextUtils.equals(r9, r12)
            if (r12 == 0) goto L_0x0077
            float r12 = r5 / r6
            int r12 = java.lang.Math.round(r12)
            float r12 = (float) r12
            float r12 = r12 + r8
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 <= 0) goto L_0x008a
            float r5 = r2 - r8
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            float r5 = (float) r5
            goto L_0x0089
        L_0x0077:
            boolean r12 = android.text.TextUtils.equals(r9, r13)
            if (r12 != 0) goto L_0x0089
            boolean r12 = android.text.TextUtils.equals(r9, r11)
            if (r12 == 0) goto L_0x0084
            goto L_0x0089
        L_0x0084:
            float r12 = java.lang.Math.min(r6, r2)
            goto L_0x008a
        L_0x0089:
            r12 = r2
        L_0x008a:
            float r12 = r12 - r8
            java.util.List r6 = r21.q()
            java.util.Iterator r14 = r6.iterator()
            r15 = 0
            r16 = 0
        L_0x0096:
            boolean r17 = r14.hasNext()
            if (r17 == 0) goto L_0x00e7
            java.lang.Object r17 = r14.next()
            r18 = r14
            r14 = r17
            java.util.List r14 = (java.util.List) r14
            r17 = r3
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = r0.b((java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>) r14, (float) r5, (float) r12)
            boolean r14 = r0.b((java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>) r14)
            if (r14 == 0) goto L_0x00b6
            r14 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 + r14
            goto L_0x00bd
        L_0x00b6:
            float r14 = r3.a
            float r14 = java.lang.Math.max(r15, r14)
            r15 = r14
        L_0x00bd:
            com.bytedance.sdk.component.adexpress.dynamic.b.e r14 = r21.j()
            java.lang.String r14 = r14.b()
            r19 = r4
            java.lang.String r4 = "carousel"
            boolean r4 = r14.equals(r4)
            if (r4 == 0) goto L_0x00dc
            float r4 = r21.i()
            float r3 = r3.b
            float r3 = java.lang.Math.max(r4, r3)
            r16 = r3
            goto L_0x00e0
        L_0x00dc:
            float r3 = r3.b
            float r16 = r16 + r3
        L_0x00e0:
            r3 = r17
            r14 = r18
            r4 = r19
            goto L_0x0096
        L_0x00e7:
            r17 = r3
            boolean r3 = android.text.TextUtils.equals(r10, r13)
            if (r3 == 0) goto L_0x0112
            int r3 = r6.size()
            float r3 = (float) r3
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x00fa
            r5 = r1
            goto L_0x0112
        L_0x00fa:
            java.util.Iterator r3 = r6.iterator()
        L_0x00fe:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0111
            java.lang.Object r4 = r3.next()
            java.util.List r4 = (java.util.List) r4
            r0.c((java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>) r4)
            r0.b((java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>) r4, (float) r15, (float) r12)
            goto L_0x00fe
        L_0x0111:
            r5 = r15
        L_0x0112:
            boolean r3 = android.text.TextUtils.equals(r9, r13)
            if (r3 == 0) goto L_0x0123
            int r3 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x011f
            r12 = r16
            goto L_0x0138
        L_0x011f:
            r0.a((java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>>) r6, (float) r5, (float) r12)
            goto L_0x0138
        L_0x0123:
            java.lang.String r3 = "fixed"
            boolean r3 = android.text.TextUtils.equals(r9, r3)
            if (r3 != 0) goto L_0x0131
            boolean r3 = android.text.TextUtils.equals(r9, r11)
            if (r3 == 0) goto L_0x0138
        L_0x0131:
            int r3 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x0138
            r0.a((java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>>) r6, (float) r5, (float) r12)
        L_0x0138:
            float r5 = r5 + r7
            float r12 = r12 + r8
            float r1 = java.lang.Math.min(r5, r1)
            r3 = r17
            r3.a = r1
            float r1 = java.lang.Math.min(r12, r2)
            r3.b = r1
            return r3
        L_0x0149:
            r3.a = r4
            r3.b = r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.c.a.d(com.bytedance.sdk.component.adexpress.dynamic.b.h, float, float):com.bytedance.sdk.component.adexpress.dynamic.c.a$c");
    }

    private void a(List<List<h>> list, float f2, float f3) {
        float f4;
        if (list != null && list.size() > 0) {
            boolean z = false;
            for (List<h> a2 : list) {
                if (a(a2, false)) {
                    z = true;
                }
            }
            ArrayList arrayList = new ArrayList();
            for (List next : list) {
                C0045a aVar = new C0045a();
                boolean a3 = a((List<h>) next, !z);
                c b2 = b((List<h>) next, f2, f3);
                if (a3) {
                    f4 = 1.0f;
                } else {
                    f4 = b2.b;
                }
                aVar.a = f4;
                aVar.b = !a3;
                arrayList.add(aVar);
            }
            List<C0045a> a4 = i.a(f3, arrayList);
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((C0045a) arrayList.get(i2)).a != a4.get(i2).a) {
                    List list2 = list.get(i2);
                    c((List<h>) list2);
                    b((List<h>) list2, f2, a4.get(i2).a);
                }
            }
        }
    }

    private boolean b(List<h> list) {
        boolean z;
        List<List<h>> q;
        Iterator<h> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (TextUtils.equals(it.next().j().e().A(), "flex")) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            return true;
        }
        Iterator<h> it2 = list.iterator();
        while (true) {
            boolean z2 = false;
            while (true) {
                if (!it2.hasNext()) {
                    return z2;
                }
                h next = it2.next();
                if (TextUtils.equals(next.j().e().A(), "auto") && (q = next.q()) != null) {
                    Iterator<List<h>> it3 = q.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it3.hasNext()) {
                            continue;
                            break;
                        }
                        List next2 = it3.next();
                        i2++;
                        if (b((List<h>) next2)) {
                            if (i2 == next2.size()) {
                                z2 = true;
                            }
                        }
                    }
                }
            }
        }
    }

    private c b(List<h> list, float f2, float f3) {
        c a2 = a(list);
        if (a2 != null && (a2.a != 0.0f || a2.b != 0.0f)) {
            return a2;
        }
        c c2 = c(list, f2, f3);
        a(list, c2);
        return c2;
    }

    private c c(List<h> list, float f2, float f3) {
        float f4;
        d(list);
        c cVar = new c();
        ArrayList<h> arrayList = new ArrayList<>();
        ArrayList<h> arrayList2 = new ArrayList<>();
        for (h next : list) {
            f e2 = next.j().e();
            if (e2.V() == 1 || e2.V() == 2) {
                arrayList.add(next);
            }
            if (!(e2.V() == 1 || e2.V() == 2)) {
                arrayList2.add(next);
            }
        }
        for (h c2 : arrayList) {
            c(c2, f2, f3);
        }
        if (arrayList2.size() <= 0) {
            return cVar;
        }
        ArrayList arrayList3 = new ArrayList();
        for (h c3 : arrayList2) {
            arrayList3.add(Float.valueOf(c(c3, f2, f3).a));
        }
        ArrayList arrayList4 = new ArrayList();
        int i2 = 0;
        while (true) {
            f4 = 0.0f;
            if (i2 >= arrayList2.size()) {
                break;
            }
            h hVar = (h) arrayList2.get(i2);
            String A = hVar.j().e().A();
            float h2 = hVar.h();
            boolean equals = TextUtils.equals(A, "flex");
            if (TextUtils.equals(A, "auto")) {
                List<List<h>> q = hVar.q();
                if (q != null && q.size() > 0) {
                    Iterator<List<h>> it = q.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (b(it.next())) {
                                equals = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                equals = false;
            }
            C0045a aVar = new C0045a();
            if (!equals) {
                h2 = ((Float) arrayList3.get(i2)).floatValue();
            }
            aVar.a = h2;
            aVar.b = !equals;
            if (equals) {
                f4 = ((Float) arrayList3.get(i2)).floatValue();
            }
            aVar.c = f4;
            arrayList4.add(aVar);
            i2++;
        }
        a((List<C0045a>) arrayList4, f2, (List<h>) arrayList2);
        List<C0045a> a2 = i.a(f2, arrayList4);
        float f5 = 0.0f;
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            f5 += a2.get(i3).a;
            if (((Float) arrayList3.get(i3)).floatValue() != a2.get(i3).a) {
                d((h) arrayList2.get(i3));
            }
        }
        Iterator it2 = arrayList2.iterator();
        int i4 = 0;
        boolean z = false;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            i4++;
            if (!b((h) it2.next())) {
                z = false;
                break;
            } else if (i4 == arrayList2.size()) {
                z = true;
            }
        }
        if (z) {
            f4 = f3;
        }
        ArrayList<c> arrayList5 = new ArrayList<>();
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            h hVar2 = (h) arrayList2.get(i5);
            c c4 = c(hVar2, a2.get(i5).a, f3);
            if (!b(hVar2)) {
                f4 = Math.max(f4, c4.b);
            }
            arrayList5.add(c4);
        }
        ArrayList arrayList6 = new ArrayList();
        for (c cVar2 : arrayList5) {
            arrayList6.add(Float.valueOf(cVar2.b));
        }
        if (!z) {
            for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                h hVar3 = (h) arrayList2.get(i6);
                if (b(hVar3) && ((Float) arrayList6.get(i6)).floatValue() != f4) {
                    d(hVar3);
                    c(hVar3, a2.get(i6).a, f4);
                }
            }
        }
        cVar.a = f5;
        cVar.b = f4;
        return cVar;
    }

    private boolean b(h hVar) {
        if (hVar == null) {
            return false;
        }
        if (TextUtils.equals(hVar.j().e().z(), "flex")) {
            return true;
        }
        return c(hVar);
    }

    private boolean c(h hVar) {
        List<List<h>> q;
        if (!hVar.r() && TextUtils.equals(hVar.j().e().z(), "auto") && (q = hVar.q()) != null && q.size() > 0) {
            if (q.size() == 1) {
                for (h b2 : q.get(0)) {
                    if (!b(b2)) {
                        return false;
                    }
                }
                return true;
            }
            for (List<h> a2 : q) {
                if (a(a2, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(List<h> list, boolean z) {
        boolean z2;
        Iterator<h> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            h next = it.next();
            f e2 = next.j().e();
            String z3 = e2.z();
            if (!TextUtils.equals(z3, "flex") && (!z || ((!TextUtils.equals(e2.A(), "flex") || !TextUtils.equals(e2.z(), "scale") || e.a.get(next.j().b()).intValue() != 7) && !TextUtils.equals(z3, "flex")))) {
            }
        }
        z2 = true;
        if (z2) {
            return true;
        }
        for (h c2 : list) {
            if (c(c2)) {
                return true;
            }
        }
        return false;
    }

    private void a(List<C0045a> list, float f2, List<h> list2) {
        float f3 = 0.0f;
        for (C0045a next : list) {
            if (next.b) {
                f3 += next.a;
            }
        }
        if (f3 > f2) {
            int i2 = 0;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (list.get(i3).b && list2.get(i3).t()) {
                    i2++;
                }
            }
            if (i2 > 0) {
                float ceil = (float) (Math.ceil((double) (((f3 - f2) / ((float) i2)) * 1000.0f)) / 1000.0d);
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    C0045a aVar = list.get(i4);
                    if (aVar.b && list2.get(i4).t()) {
                        aVar.a -= ceil;
                    }
                }
            }
        }
    }

    public void a() {
        this.c.clear();
        this.a.clear();
        this.b.clear();
    }

    public c a(h hVar) {
        return this.a.get(e(hVar));
    }

    public c a(List<h> list) {
        return this.b.get(d(list));
    }

    private void d(h hVar) {
        this.a.remove(e(hVar));
        List<List<h>> q = hVar.q();
        if (q != null && q.size() > 0) {
            for (List<h> c2 : q) {
                c(c2);
            }
        }
    }

    private void c(List<h> list) {
        if (list != null && list.size() > 0) {
            this.b.remove(d(list));
            for (h d2 : list) {
                d(d2);
            }
        }
    }

    private String e(h hVar) {
        return hVar.c();
    }

    private String d(List<h> list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String c2 = list.get(i2).c();
            if (i2 < list.size() - 1) {
                sb.append(c2);
                sb.append("-");
            } else {
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    private void a(h hVar, c cVar) {
        this.a.put(e(hVar), cVar);
    }

    private void a(List<h> list, c cVar) {
        this.b.put(d(list), cVar);
    }

    /* compiled from: ComputeRuler */
    static class c {
        float a;
        float b;

        public c() {
        }

        public c(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.a + ", height=" + this.b + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* compiled from: ComputeRuler */
    static class b {
        float a;
        int b;
        int c;
        double d;
        float e;

        b() {
        }

        static JSONObject a(b bVar) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", (double) bVar.a);
                jSONObject.put("letterSpacing", bVar.b);
                jSONObject.put("lineHeight", bVar.d);
                jSONObject.put("maxWidth", (double) bVar.e);
                jSONObject.put("fontWeight", bVar.c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.c.a$a  reason: collision with other inner class name */
    /* compiled from: ComputeRuler */
    static class C0045a implements Cloneable {
        float a;
        boolean b;
        float c;

        C0045a() {
        }

        public Object clone() {
            try {
                return (C0045a) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
