package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.dynamic.b.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.f;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.b.i;
import com.bytedance.sdk.component.adexpress.dynamic.c.a;
import com.bytedance.sdk.component.utils.l;
import java.util.List;

/* compiled from: DynamicCanvas */
public class d {
    public b a;
    protected a b;
    private h c;
    private a d;

    /* compiled from: DynamicCanvas */
    static class a {
        float a;
        float b;
        float c;

        a() {
        }
    }

    public d(double d2, int i, double d3, String str, m mVar) {
        this.b = new a(d2, i, d3, str, mVar);
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void a() {
        this.b.a();
    }

    public void a(h hVar, float f, float f2) {
        if (hVar != null) {
            this.c = hVar;
        }
        h hVar2 = this.c;
        float h = hVar2.h();
        float i = hVar2.i();
        float f3 = TextUtils.equals(hVar2.j().e().z(), "fixed") ? i : 65536.0f;
        this.b.a();
        this.b.c(hVar2, h, f3);
        a.c a2 = this.b.a(hVar2);
        b bVar = new b();
        bVar.a = f;
        bVar.b = f2;
        if (a2 != null) {
            h = a2.a;
        }
        bVar.c = h;
        if (a2 != null) {
            i = a2.b;
        }
        bVar.d = i;
        bVar.e = "root";
        bVar.i = 1280.0f;
        bVar.f = hVar2;
        bVar.f.c(bVar.a);
        bVar.f.d(bVar.b);
        bVar.f.e(bVar.c);
        bVar.f.f(bVar.d);
        b a3 = a(bVar, 0.0f);
        this.a = a3;
        a(a3);
    }

    public void a(b bVar) {
        if (bVar != null) {
            l.b("DynamicCanvas", "native parser: type = " + bVar.f.j().b() + "; width = " + bVar.c + "; height = " + bVar.d + "; x = " + bVar.a + "; y = " + bVar.b);
            List<List<b>> list = bVar.g;
            if (list != null && list.size() > 0) {
                for (List<b> next : list) {
                    if (next != null && next.size() > 0) {
                        for (b a2 : next) {
                            a(a2);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0205  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.adexpress.dynamic.b.b a(com.bytedance.sdk.component.adexpress.dynamic.b.b r37, float r38) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            com.bytedance.sdk.component.adexpress.dynamic.b.h r2 = r1.f
            if (r2 != 0) goto L_0x0009
            return r1
        L_0x0009:
            r2.s()
            java.util.List r3 = r2.q()
            if (r3 == 0) goto L_0x03f3
            int r4 = r3.size()
            if (r4 > 0) goto L_0x001a
            goto L_0x03f3
        L_0x001a:
            com.bytedance.sdk.component.adexpress.dynamic.b.e r4 = r2.j()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r4 = r4.e()
            float r5 = r4.q()
            float r6 = r4.p()
            float r7 = r4.n()
            float r8 = r4.o()
            float r9 = r4.l()
            java.lang.String r10 = r4.I()
            java.lang.String r11 = r4.J()
            float r12 = r1.a
            float r12 = r12 + r8
            float r13 = r1.b
            float r13 = r13 + r5
            float r14 = r1.c
            float r14 = r14 - r8
            float r14 = r14 - r6
            r6 = 1073741824(0x40000000, float:2.0)
            float r9 = r9 * r6
            float r14 = r14 - r9
            float r8 = r1.d
            float r8 = r8 - r5
            float r8 = r8 - r7
            float r8 = r8 - r9
            com.bytedance.sdk.component.adexpress.dynamic.b.i r5 = new com.bytedance.sdk.component.adexpress.dynamic.b.i
            r5.<init>(r12, r13)
            java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.b>> r7 = r1.g
            if (r7 != 0) goto L_0x0062
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r1.g = r7
        L_0x0062:
            java.util.Iterator r7 = r3.iterator()
            r13 = 0
        L_0x0067:
            boolean r15 = r7.hasNext()
            if (r15 == 0) goto L_0x007f
            java.lang.Object r15 = r7.next()
            java.util.List r15 = (java.util.List) r15
            com.bytedance.sdk.component.adexpress.dynamic.c.a r9 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r9 = r9.a((java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>) r15)
            if (r9 == 0) goto L_0x0067
            float r9 = r9.b
            float r13 = r13 + r9
            goto L_0x0067
        L_0x007f:
            java.lang.String r7 = "space-between"
            java.lang.String r9 = "space-around"
            java.lang.String r15 = "flex-end"
            java.lang.String r6 = "center"
            r17 = r12
            r12 = 1
            int r18 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r18 >= 0) goto L_0x00d0
            boolean r18 = android.text.TextUtils.equals(r11, r6)
            if (r18 == 0) goto L_0x0099
            float r8 = r8 - r13
            r11 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r11
            goto L_0x00d1
        L_0x0099:
            boolean r18 = android.text.TextUtils.equals(r11, r15)
            if (r18 == 0) goto L_0x00a1
            float r8 = r8 - r13
            goto L_0x00d1
        L_0x00a1:
            boolean r18 = android.text.TextUtils.equals(r11, r9)
            if (r18 == 0) goto L_0x00b5
            float r8 = r8 - r13
            int r11 = r3.size()
            int r11 = r11 + r12
            float r11 = (float) r11
            float r8 = r8 / r11
            float r8 = com.bytedance.sdk.component.adexpress.dynamic.c.i.a(r8)
            r11 = r8
            goto L_0x00d2
        L_0x00b5:
            boolean r11 = android.text.TextUtils.equals(r11, r7)
            if (r11 == 0) goto L_0x00d0
            int r11 = r3.size()
            if (r11 <= r12) goto L_0x00d0
            float r8 = r8 - r13
            int r11 = r3.size()
            int r11 = r11 - r12
            float r11 = (float) r11
            float r8 = r8 / r11
            float r8 = com.bytedance.sdk.component.adexpress.dynamic.c.i.a(r8)
            r11 = r8
            r8 = 0
            goto L_0x00d2
        L_0x00d0:
            r8 = 0
        L_0x00d1:
            r11 = 0
        L_0x00d2:
            float r13 = r5.b
            float r13 = r13 + r8
            r5.b = r13
            r13 = r38
            r8 = 0
        L_0x00da:
            int r12 = r3.size()
            if (r8 >= r12) goto L_0x03f1
            java.lang.Object r12 = r3.get(r8)
            java.util.List r12 = (java.util.List) r12
            int r8 = r8 + 1
            r20 = r3
            java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.b>> r3 = r1.g
            int r3 = r3.size()
            if (r8 < r3) goto L_0x011b
            java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.b>> r3 = r1.g
            int r3 = r3.size()
            int r3 = r8 - r3
            r19 = 1
            int r3 = r3 + 1
            r38 = r13
            r13 = 0
        L_0x0101:
            if (r13 >= r3) goto L_0x0118
            r21 = r3
            java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.b>> r3 = r1.g
            r22 = r11
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r3.add(r11)
            int r13 = r13 + 1
            r3 = r21
            r11 = r22
            goto L_0x0101
        L_0x0118:
            r22 = r11
            goto L_0x011f
        L_0x011b:
            r22 = r11
            r38 = r13
        L_0x011f:
            java.util.Iterator r3 = r12.iterator()
            r11 = 0
        L_0x0124:
            boolean r13 = r3.hasNext()
            r21 = r4
            if (r13 == 0) goto L_0x0165
            java.lang.Object r13 = r3.next()
            com.bytedance.sdk.component.adexpress.dynamic.b.h r13 = (com.bytedance.sdk.component.adexpress.dynamic.b.h) r13
            com.bytedance.sdk.component.adexpress.dynamic.b.e r23 = r13.j()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r23 = r23.e()
            java.lang.String r4 = r23.A()
            r24 = r3
            int r3 = r23.V()
            java.lang.String r1 = "flex"
            boolean r1 = android.text.TextUtils.equals(r4, r1)
            if (r1 != 0) goto L_0x015e
            r1 = 1
            if (r3 == r1) goto L_0x015e
            r1 = 2
            if (r3 != r1) goto L_0x0153
            goto L_0x015e
        L_0x0153:
            com.bytedance.sdk.component.adexpress.dynamic.c.a r1 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r1 = r1.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13)
            if (r1 == 0) goto L_0x015e
            float r1 = r1.a
            float r11 = r11 + r1
        L_0x015e:
            r1 = r37
            r4 = r21
            r3 = r24
            goto L_0x0124
        L_0x0165:
            float r1 = r14 - r11
            r3 = 0
            float r1 = java.lang.Math.max(r1, r3)
            java.util.Iterator r4 = r12.iterator()
            r11 = 0
        L_0x0171:
            boolean r13 = r4.hasNext()
            if (r13 == 0) goto L_0x01a5
            java.lang.Object r13 = r4.next()
            com.bytedance.sdk.component.adexpress.dynamic.b.h r13 = (com.bytedance.sdk.component.adexpress.dynamic.b.h) r13
            com.bytedance.sdk.component.adexpress.dynamic.b.e r16 = r13.j()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r16 = r16.e()
            int r3 = r16.V()
            r24 = r4
            r4 = 1
            if (r3 == r4) goto L_0x01a1
            int r3 = r16.V()
            r4 = 2
            if (r3 != r4) goto L_0x0196
            goto L_0x01a1
        L_0x0196:
            com.bytedance.sdk.component.adexpress.dynamic.c.a r3 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = r3.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13)
            if (r3 == 0) goto L_0x01a1
            float r3 = r3.a
            float r11 = r11 + r3
        L_0x01a1:
            r4 = r24
            r3 = 0
            goto L_0x0171
        L_0x01a5:
            int r3 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r3 >= 0) goto L_0x01f3
            boolean r3 = android.text.TextUtils.equals(r10, r6)
            if (r3 == 0) goto L_0x01b5
            float r3 = r14 - r11
            r4 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 / r4
            goto L_0x01f4
        L_0x01b5:
            boolean r3 = android.text.TextUtils.equals(r10, r15)
            if (r3 == 0) goto L_0x01be
            float r3 = r14 - r11
            goto L_0x01f4
        L_0x01be:
            boolean r3 = android.text.TextUtils.equals(r10, r9)
            if (r3 == 0) goto L_0x01d4
            float r3 = r14 - r11
            int r4 = r12.size()
            r13 = 1
            int r4 = r4 + r13
            float r4 = (float) r4
            float r3 = r3 / r4
            float r3 = com.bytedance.sdk.component.adexpress.dynamic.c.i.a(r3)
            r4 = r3
            goto L_0x01f5
        L_0x01d4:
            r13 = 1
            boolean r3 = android.text.TextUtils.equals(r10, r7)
            if (r3 == 0) goto L_0x01f3
            int r3 = r12.size()
            if (r3 <= r13) goto L_0x01f3
            float r3 = r14 - r11
            int r4 = r12.size()
            float r4 = (float) r4
            r11 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 - r11
            float r3 = r3 / r4
            float r3 = com.bytedance.sdk.component.adexpress.dynamic.c.i.a(r3)
            r4 = r3
            r3 = 0
            goto L_0x01f5
        L_0x01f3:
            r3 = 0
        L_0x01f4:
            r4 = 0
        L_0x01f5:
            float r11 = r5.a
            float r11 = r11 + r3
            r5.a = r11
            java.util.Iterator r3 = r12.iterator()
            r11 = 0
        L_0x01ff:
            boolean r13 = r3.hasNext()
            if (r13 == 0) goto L_0x0247
            java.lang.Object r13 = r3.next()
            com.bytedance.sdk.component.adexpress.dynamic.b.h r13 = (com.bytedance.sdk.component.adexpress.dynamic.b.h) r13
            r16 = r3
            com.bytedance.sdk.component.adexpress.dynamic.c.a r3 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = r3.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13)
            if (r3 == 0) goto L_0x021e
            com.bytedance.sdk.component.adexpress.dynamic.c.a r3 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = r3.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13)
            float r3 = r3.b
            goto L_0x021f
        L_0x021e:
            r3 = 0
        L_0x021f:
            com.bytedance.sdk.component.adexpress.dynamic.b.e r13 = r13.j()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r13 = r13.e()
            r24 = r3
            int r3 = r13.V()
            r25 = r7
            r7 = 1
            if (r3 == r7) goto L_0x023d
            int r3 = r13.V()
            r7 = 2
            if (r3 != r7) goto L_0x023a
            goto L_0x023d
        L_0x023a:
            r3 = r24
            goto L_0x023e
        L_0x023d:
            r3 = 0
        L_0x023e:
            float r11 = java.lang.Math.max(r11, r3)
            r3 = r16
            r7 = r25
            goto L_0x01ff
        L_0x0247:
            r25 = r7
            java.util.Iterator r3 = r12.iterator()
            r13 = r38
        L_0x024f:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x03c7
            java.lang.Object r7 = r3.next()
            com.bytedance.sdk.component.adexpress.dynamic.b.h r7 = (com.bytedance.sdk.component.adexpress.dynamic.b.h) r7
            r38 = r3
            com.bytedance.sdk.component.adexpress.dynamic.c.a r3 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = r3.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r7)
            com.bytedance.sdk.component.adexpress.dynamic.b.e r16 = r7.j()
            r24 = r9
            com.bytedance.sdk.component.adexpress.dynamic.b.f r9 = r16.e()
            r16 = r10
            int r10 = r9.M()
            float r10 = (float) r10
            r26 = r13
            int r13 = r9.P()
            float r13 = (float) r13
            r27 = r14
            int r14 = r9.N()
            float r14 = (float) r14
            r28 = r4
            int r4 = r9.O()
            float r4 = (float) r4
            r29 = r5
            if (r3 != 0) goto L_0x028f
            r5 = 0
            goto L_0x0291
        L_0x028f:
            float r5 = r3.a
        L_0x0291:
            if (r3 != 0) goto L_0x0297
            r30 = r12
            r3 = 0
            goto L_0x029b
        L_0x0297:
            float r3 = r3.b
            r30 = r12
        L_0x029b:
            java.lang.String r12 = r2.c()
            r31 = r2
            java.lang.String r2 = "root"
            boolean r2 = android.text.TextUtils.equals(r12, r2)
            if (r2 == 0) goto L_0x02ab
            float r2 = (float) r8
            goto L_0x02ad
        L_0x02ab:
            r2 = r26
        L_0x02ad:
            int r12 = r9.V()
            r32 = r8
            r8 = 1
            if (r12 != r8) goto L_0x02c5
            float r8 = r5 - r13
            float r8 = r8 - r4
            float r12 = r3 - r10
            float r12 = r12 - r14
            r26 = r2
            r2 = r37
            com.bytedance.sdk.component.adexpress.dynamic.b.i r8 = r0.a(r2, r9, r8, r12)
            goto L_0x02cb
        L_0x02c5:
            r26 = r2
            r2 = r37
            r8 = r29
        L_0x02cb:
            int r12 = r9.V()
            r33 = r8
            r8 = 2
            if (r12 != r8) goto L_0x02f1
            com.bytedance.sdk.component.adexpress.dynamic.c.a r8 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.b.h r12 = r0.c
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r8 = r8.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r12)
            float r12 = r5 - r13
            float r12 = r12 - r4
            float r33 = r3 - r10
            r34 = r1
            float r1 = r33 - r14
            r35 = r7
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r7 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r7.<init>(r12, r1)
            com.bytedance.sdk.component.adexpress.dynamic.b.i r8 = r0.a((com.bytedance.sdk.component.adexpress.dynamic.b.f) r9, (com.bytedance.sdk.component.adexpress.dynamic.c.a.c) r8, (com.bytedance.sdk.component.adexpress.dynamic.c.a.c) r7)
            goto L_0x02f7
        L_0x02f1:
            r34 = r1
            r35 = r7
            r8 = r33
        L_0x02f7:
            java.lang.String r1 = r21.ak()
            int r7 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0322
            java.lang.String r7 = "flex-start"
            boolean r7 = android.text.TextUtils.equals(r1, r7)
            if (r7 != 0) goto L_0x0322
            r1.hashCode()
            boolean r7 = r1.equals(r6)
            if (r7 != 0) goto L_0x031c
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0317
            goto L_0x0322
        L_0x0317:
            float r1 = r11 - r3
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x0325
        L_0x031c:
            float r1 = r11 - r3
            r7 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r7
            goto L_0x0325
        L_0x0322:
            r7 = 1073741824(0x40000000, float:2.0)
            r1 = 0
        L_0x0325:
            com.bytedance.sdk.component.adexpress.dynamic.b.b r12 = new com.bytedance.sdk.component.adexpress.dynamic.b.b
            r12.<init>()
            float r7 = r8.a
            float r7 = r7 + r4
            r12.a = r7
            float r7 = r8.b
            float r7 = r7 + r10
            float r7 = r7 + r1
            r12.b = r7
            float r1 = r5 - r13
            float r1 = r1 - r4
            r12.c = r1
            float r3 = r3 - r10
            float r3 = r3 - r14
            r12.d = r3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r2.e
            r1.append(r3)
            java.lang.String r3 = "."
            r1.append(r3)
            java.lang.String r3 = r35.c()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r12.e = r1
            r12.h = r2
            r7 = r35
            r12.f = r7
            r1 = r34
            r12.i = r1
            r3 = r30
            r12.j = r3
            com.bytedance.sdk.component.adexpress.dynamic.b.h r4 = r12.f
            float r7 = r12.a
            r4.c((float) r7)
            com.bytedance.sdk.component.adexpress.dynamic.b.h r4 = r12.f
            float r7 = r12.b
            r4.d(r7)
            com.bytedance.sdk.component.adexpress.dynamic.b.h r4 = r12.f
            float r7 = r12.c
            r4.e(r7)
            com.bytedance.sdk.component.adexpress.dynamic.b.h r4 = r12.f
            float r7 = r12.d
            r4.f(r7)
            r4 = r26
            com.bytedance.sdk.component.adexpress.dynamic.b.b r7 = r0.a(r12, r4)
            java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.b>> r8 = r2.g
            r10 = r32
            java.lang.Object r8 = r8.get(r10)
            java.util.List r8 = (java.util.List) r8
            r8.add(r7)
            int r7 = r9.V()
            r8 = 1
            if (r7 == r8) goto L_0x03b2
            int r7 = r9.V()
            r9 = 2
            if (r7 == r9) goto L_0x03af
            r7 = r29
            float r12 = r7.a
            float r5 = r5 + r28
            float r12 = r12 + r5
            r7.a = r12
            goto L_0x03b5
        L_0x03af:
            r7 = r29
            goto L_0x03b5
        L_0x03b2:
            r7 = r29
            r9 = 2
        L_0x03b5:
            r12 = r3
            r13 = r4
            r5 = r7
            r8 = r10
            r10 = r16
            r9 = r24
            r14 = r27
            r4 = r28
            r2 = r31
            r3 = r38
            goto L_0x024f
        L_0x03c7:
            r31 = r2
            r7 = r5
            r24 = r9
            r16 = r10
            r26 = r13
            r27 = r14
            r12 = r17
            r2 = r37
            r10 = r8
            r8 = 1
            r7.a = r12
            float r1 = r7.b
            float r11 = r11 + r22
            float r1 = r1 + r11
            r7.b = r1
            r1 = r2
            r8 = r10
            r10 = r16
            r3 = r20
            r4 = r21
            r11 = r22
            r7 = r25
            r2 = r31
            goto L_0x00da
        L_0x03f1:
            r2 = r1
            return r2
        L_0x03f3:
            r2 = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.c.d.a(com.bytedance.sdk.component.adexpress.dynamic.b.b, float):com.bytedance.sdk.component.adexpress.dynamic.b.b");
    }

    private i a(f fVar, a.c cVar, a.c cVar2) {
        float ag = (float) fVar.ag();
        float ai = (float) fVar.ai();
        float ah = (float) fVar.ah();
        float aj = (float) fVar.aj();
        boolean X = fVar.X();
        boolean Y = fVar.Y();
        boolean Z = fVar.Z();
        boolean aa = fVar.aa();
        if (!X) {
            if (Y) {
                ag = ((this.d.a != 0.0f ? this.d.a : cVar.a) - ah) - cVar2.a;
            } else {
                ag = 0.0f;
            }
        }
        if (!Z) {
            if (aa) {
                ai = ((this.d.b != 0.0f ? this.d.b : cVar.b) - aj) - cVar2.b;
            } else {
                ai = 0.0f;
            }
        }
        return new i(ag, ai);
    }

    private i a(b bVar, f fVar, float f, float f2) {
        float f3;
        float f4;
        b bVar2 = bVar;
        float f5 = bVar2.a;
        float f6 = bVar2.b;
        float ag = (float) fVar.ag();
        float ai = (float) fVar.ai();
        float ah = (float) fVar.ah();
        float aj = (float) fVar.aj();
        boolean X = fVar.X();
        boolean Y = fVar.Y();
        boolean Z = fVar.Z();
        boolean aa = fVar.aa();
        String W = fVar.W();
        float f7 = bVar2.c;
        float f8 = bVar2.d;
        if (TextUtils.equals(W, "0")) {
            if (X) {
                f5 = bVar2.a + ag;
            } else if (Y) {
                f5 = ((bVar2.a + f7) - ah) - f;
            }
            if (Z) {
                f4 = bVar2.b;
            } else {
                if (aa) {
                    f3 = bVar2.b;
                    f6 = ((f3 + f8) - aj) - f2;
                }
                return new i(f5, f6);
            }
        } else {
            if (TextUtils.equals(W, "1")) {
                f5 = bVar2.a + ((f7 - f) / 2.0f);
                if (Z) {
                    f4 = bVar2.b;
                } else if (aa) {
                    f3 = bVar2.b;
                    f6 = ((f3 + f8) - aj) - f2;
                }
            } else if (TextUtils.equals(W, "2")) {
                f6 = bVar2.b + ((f8 - f2) / 2.0f);
                if (X) {
                    f5 = bVar2.a + ag;
                } else if (Y) {
                    f5 = ((bVar2.a + f7) - ah) - f;
                }
            } else if (TextUtils.equals(W, ExifInterface.GPS_MEASUREMENT_3D)) {
                f5 = bVar2.a + ((f7 - f) / 2.0f);
                f6 = bVar2.b + ((f8 - f2) / 2.0f);
            }
            return new i(f5, f6);
        }
        f6 = f4 + ai;
        return new i(f5, f6);
    }
}
