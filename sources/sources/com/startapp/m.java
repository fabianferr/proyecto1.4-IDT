package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig;

/* compiled from: Sta */
public class m {
    public final i2<AnalyticsConfig> a;

    public m(Context context, i2<AnalyticsConfig> i2Var) {
        this.a = i2Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x019b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.startapp.n r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.startapp.i2<com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig> r2 = r0.a
            java.lang.Object r2 = r2.a()
            com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig r2 = (com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig) r2
            if (r2 != 0) goto L_0x000f
            return
        L_0x000f:
            double r3 = java.lang.Math.random()
            double r5 = r2.c()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x020d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            boolean r4 = r1.c
            java.lang.String r5 = "preLoading="
            r3.append(r5)
            r3.append(r4)
            java.lang.String r4 = ", "
            r3.append(r4)
            boolean r5 = r1.d
            if (r5 == 0) goto L_0x0040
            boolean r5 = r1.f
            java.lang.String r6 = "appPresent="
            r3.append(r6)
            r3.append(r5)
            r3.append(r4)
        L_0x0040:
            com.startapp.n.a((java.lang.StringBuilder) r3)
            java.lang.String r5 = r3.toString()
            int r6 = r3.length()
            r7 = 0
            r3.delete(r7, r6)
            java.util.List r2 = r2.b()
            java.lang.String r6 = r1.a
            java.lang.String r8 = "adId"
            r9 = 1
            com.startapp.n.a(r3, r8, r6, r9)
            com.startapp.z5$a r6 = r1.b
            long r10 = r6.e
            java.lang.String r6 = "start"
            r3.append(r6)
            r6 = 61
            r3.append(r6)
            r3.append(r10)
            r3.append(r4)
            com.startapp.z5$a r8 = r1.b
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r8 = r8.d
            r10 = 0
            if (r8 == 0) goto L_0x00bb
            java.lang.String r12 = "Server-Timing"
            java.lang.Object r8 = r8.get(r12)
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L_0x00bb
            java.util.regex.Pattern r12 = com.startapp.n.m
            if (r12 != 0) goto L_0x008e
            java.lang.String r12 = "^total;dur=(\\d+(\\.\\d*)?)$"
            java.util.regex.Pattern r12 = java.util.regex.Pattern.compile(r12)
            com.startapp.n.m = r12
        L_0x008e:
            java.util.Iterator r8 = r8.iterator()
        L_0x0092:
            boolean r13 = r8.hasNext()
            if (r13 == 0) goto L_0x00bb
            java.lang.Object r13 = r8.next()
            java.lang.String r13 = (java.lang.String) r13
            java.util.regex.Matcher r13 = r12.matcher(r13)
            boolean r14 = r13.matches()
            if (r14 == 0) goto L_0x0092
            java.lang.String r13 = r13.group(r9)
            if (r13 == 0) goto L_0x0092
            double r12 = java.lang.Double.parseDouble(r13)
            r14 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r12 = r12 * r14
            long r12 = (long) r12
            goto L_0x00bc
        L_0x00bb:
            r12 = r10
        L_0x00bc:
            int r8 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x00c9
            java.lang.String r8 = com.startapp.n.a((long) r12)
            java.lang.String r14 = "serverTotal"
            com.startapp.n.a(r3, r14, r8, r7)
        L_0x00c9:
            com.startapp.z5$a r8 = r1.b
            long r14 = r8.g
            long r9 = r8.f
            long r14 = r14 - r9
            long r14 = r14 - r12
            java.lang.String r8 = com.startapp.n.a((long) r14)
            java.lang.String r9 = "network"
            com.startapp.n.a(r3, r9, r8, r7)
            long r8 = r1.g
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x0168
            com.startapp.z5$a r12 = r1.b
            long r12 = r12.g
            long r8 = r8 - r12
            java.lang.String r8 = com.startapp.n.a((long) r8)
            java.lang.String r9 = "parsing"
            com.startapp.n.a(r3, r9, r8, r7)
            boolean r8 = r1.c
            if (r8 == 0) goto L_0x0165
            long r8 = r1.h
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x0165
            long r10 = r1.g
            long r8 = r8 - r10
            java.lang.String r8 = com.startapp.n.a((long) r8)
            java.lang.String r9 = "beforeLoad"
            com.startapp.n.a(r3, r9, r8, r7)
            boolean r8 = r1.e
            if (r8 == 0) goto L_0x011c
            java.lang.String r8 = "preLoadingSkipped"
            r3.append(r8)
            r3.append(r6)
            r6 = 1
            r3.append(r6)
            r3.append(r4)
            long r8 = r1.h
            goto L_0x016c
        L_0x011c:
            long r8 = r1.i
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x0151
            long r10 = r1.h
            long r8 = r8 - r10
            java.lang.String r8 = com.startapp.n.a((long) r8)
            java.lang.String r9 = "init"
            com.startapp.n.a(r3, r9, r8, r7)
            long r8 = r1.j
            long r10 = r1.i
            long r8 = r8 - r10
            java.lang.String r8 = com.startapp.n.a((long) r8)
            java.lang.String r9 = "loading"
            com.startapp.n.a(r3, r9, r8, r7)
            boolean r8 = r1.l
            java.lang.String r9 = "pageFinished"
            r3.append(r9)
            r3.append(r6)
            r3.append(r8)
            r3.append(r4)
            long r8 = r1.j
            goto L_0x016c
        L_0x0151:
            int r8 = r1.k
            long r8 = (long) r8
            java.lang.String r10 = "error"
            r3.append(r10)
            r3.append(r6)
            r3.append(r8)
            r3.append(r4)
            long r8 = r1.h
            goto L_0x016c
        L_0x0165:
            long r8 = r1.g
            goto L_0x016c
        L_0x0168:
            com.startapp.z5$a r6 = r1.b
            long r8 = r6.g
        L_0x016c:
            com.startapp.z5$a r6 = r1.b
            long r10 = r6.f
            long r8 = r8 - r10
            java.lang.String r6 = com.startapp.n.a((long) r8)
            java.lang.String r8 = "total"
            com.startapp.n.a(r3, r8, r6, r7)
            com.startapp.z5$a r1 = r1.b
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r1 = r1.d
            if (r1 == 0) goto L_0x01f4
            if (r2 == 0) goto L_0x01f4
            java.lang.String r6 = "headers"
            r3.append(r6)
            java.lang.String r6 = "={"
            r3.append(r6)
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0195:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x01e8
            java.lang.Object r6 = r1.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getKey()
            boolean r7 = r2.contains(r7)
            if (r7 == 0) goto L_0x0195
            java.lang.Object r7 = r6.getValue()
            if (r7 == 0) goto L_0x0195
            java.lang.Object r7 = r6.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r6.getValue()
            java.util.List r6 = (java.util.List) r6
            r3.append(r7)
            java.lang.String r7 = "=["
            r3.append(r7)
            java.util.Iterator r6 = r6.iterator()
        L_0x01c9:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x01db
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            r8 = 0
            r9 = 1
            com.startapp.n.a(r3, r8, r7, r9)
            goto L_0x01c9
        L_0x01db:
            r9 = 1
            com.startapp.n.a((java.lang.StringBuilder) r3)
            r6 = 93
            r3.append(r6)
            r3.append(r4)
            goto L_0x0195
        L_0x01e8:
            com.startapp.n.a((java.lang.StringBuilder) r3)
            java.lang.String r1 = "}"
            r3.append(r1)
            r3.append(r4)
        L_0x01f4:
            com.startapp.n.a((java.lang.StringBuilder) r3)
            java.lang.String r1 = r3.toString()
            com.startapp.i3 r2 = new com.startapp.i3
            com.startapp.j3 r3 = com.startapp.j3.d
            r2.<init>((com.startapp.j3) r3)
            java.lang.String r3 = "ADM"
            r2.d = r3
            r2.i = r5
            r2.e = r1
            r2.a()
        L_0x020d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.m.a(com.startapp.n):void");
    }
}
