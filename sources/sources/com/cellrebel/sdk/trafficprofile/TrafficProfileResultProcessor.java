package com.cellrebel.sdk.trafficprofile;

import com.cellrebel.sdk.trafficprofile.models.TrafficProfile;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileResult;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileType;
import com.cellrebel.sdk.trafficprofile.udp.messages.UdpPackageMessage;
import java.util.ArrayList;
import java.util.List;

public class TrafficProfileResultProcessor {
    private TrafficProfile a;
    private final List<UdpPackageMessage> b = new ArrayList();
    private final List<UdpPackageMessage> c = new ArrayList();
    private boolean d = false;
    private List<TrafficProfileErrorType> e = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x02f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.cellrebel.sdk.trafficprofile.models.TrafficProfileResult> a(java.util.List<com.cellrebel.sdk.trafficprofile.models.TrafficProfileConfig> r30, com.cellrebel.sdk.trafficprofile.models.TrafficProfileType r31, java.util.List<com.cellrebel.sdk.trafficprofile.udp.messages.UdpPackageMessage> r32) {
        /*
            r29 = this;
            r0 = r29
            r1 = r31
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileType r3 = com.cellrebel.sdk.trafficprofile.models.TrafficProfileType.DOWNLINK
            if (r1 != r3) goto L_0x001b
            boolean r3 = r32.isEmpty()
            if (r3 == 0) goto L_0x001b
            java.util.List<com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType> r3 = r0.e
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType r4 = com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType.DOWNLINK_FAILURE
        L_0x0017:
            r3.add(r4)
            goto L_0x002a
        L_0x001b:
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileType r3 = com.cellrebel.sdk.trafficprofile.models.TrafficProfileType.UPLINK
            if (r1 != r3) goto L_0x002a
            boolean r3 = r32.isEmpty()
            if (r3 == 0) goto L_0x002a
            java.util.List<com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType> r3 = r0.e
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType r4 = com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType.UPLINK_FAILURE
            goto L_0x0017
        L_0x002a:
            java.util.Iterator r3 = r30.iterator()
        L_0x002e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0440
            java.lang.Object r4 = r3.next()
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileConfig r4 = (com.cellrebel.sdk.trafficprofile.models.TrafficProfileConfig) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = r32
            r7.<init>(r8)
            java.util.Iterator r7 = r7.iterator()
            r9 = 0
            r12 = r9
            r14 = 0
            r15 = 0
        L_0x0054:
            boolean r16 = r7.hasNext()
            if (r16 == 0) goto L_0x015e
            java.lang.Object r16 = r7.next()
            r11 = r16
            com.cellrebel.sdk.trafficprofile.udp.messages.UdpPackageMessage r11 = (com.cellrebel.sdk.trafficprofile.udp.messages.UdpPackageMessage) r11
            r16 = r3
            int r3 = r11.e
            r18 = r7
            com.cellrebel.sdk.trafficprofile.models.TrafficProfile r7 = r0.a
            int r7 = r7.a
            if (r3 == r7) goto L_0x006f
            goto L_0x0075
        L_0x006f:
            int r3 = r11.f
            int r7 = r4.a
            if (r3 == r7) goto L_0x007a
        L_0x0075:
            r3 = r16
            r7 = r18
            goto L_0x0054
        L_0x007a:
            int r14 = r14 + 1
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileType r3 = com.cellrebel.sdk.trafficprofile.models.TrafficProfileType.DOWNLINK
            if (r1 != r3) goto L_0x0088
            long r7 = r11.b
            r3 = r2
            long r1 = r11.d
            long r7 = r7 - r1
            int r1 = (int) r7
            goto L_0x008f
        L_0x0088:
            r3 = r2
            long r1 = r11.d
            long r7 = r11.b
            long r1 = r1 - r7
            int r1 = (int) r1
        L_0x008f:
            long r7 = r11.b
            r19 = r3
            long r2 = r11.d
            long r2 = java.lang.Math.min(r7, r2)
            long r7 = r11.b
            r21 = r14
            r20 = r15
            long r14 = r11.d
            long r7 = java.lang.Math.max(r7, r14)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r1)
            r5.add(r14)
            int r14 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r14 <= 0) goto L_0x00b1
            r9 = r2
        L_0x00b1:
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 >= 0) goto L_0x00b6
            r12 = r7
        L_0x00b6:
            int r14 = r11.g
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            boolean r14 = r6.containsKey(r14)
            if (r14 == 0) goto L_0x0125
            int r14 = r11.g
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.Object r14 = r6.get(r14)
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegmentResult r14 = (com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegmentResult) r14
            if (r14 != 0) goto L_0x00d5
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegmentResult r14 = new com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegmentResult
            r14.<init>()
        L_0x00d5:
            java.util.List<java.lang.Integer> r15 = r14.a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r15.add(r1)
            int r1 = r14.b
            r15 = 1
            int r1 = r1 + r15
            r14.b = r1
            int r1 = r14.c
            int r15 = r11.c
            if (r1 <= r15) goto L_0x00f5
            int r1 = r14.d
            r17 = 1
            int r1 = r1 + 1
            r14.d = r1
            int r1 = r20 + 1
            goto L_0x00f7
        L_0x00f5:
            r1 = r20
        L_0x00f7:
            r14.c = r15
            r22 = r9
            long r9 = r14.e
            int r15 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r15 <= 0) goto L_0x0103
            r14.e = r2
        L_0x0103:
            long r2 = r14.f
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x010b
            r14.f = r7
        L_0x010b:
            int r2 = r11.g
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.put(r2, r14)
            r8 = r32
            r15 = r1
            r3 = r16
            r7 = r18
            r2 = r19
            r14 = r21
            r9 = r22
            r1 = r31
            goto L_0x0054
        L_0x0125:
            r22 = r9
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegmentResult r9 = new com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegmentResult
            r9.<init>()
            java.util.List<java.lang.Integer> r10 = r9.a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.add(r1)
            int r1 = r9.b
            r10 = 1
            int r1 = r1 + r10
            r9.b = r1
            int r1 = r11.c
            r9.c = r1
            r9.e = r2
            r9.f = r7
            int r1 = r11.g
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.put(r1, r9)
            r1 = r31
            r8 = r32
            r3 = r16
            r7 = r18
            r2 = r19
            r15 = r20
            r14 = r21
            r9 = r22
            goto L_0x0054
        L_0x015e:
            r19 = r2
            r16 = r3
            r20 = r15
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "["
            r1.append(r2)
            java.util.List<com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegment> r2 = r4.b
            java.util.Iterator r2 = r2.iterator()
            r3 = 0
            r11 = 0
        L_0x0176:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x030e
            java.lang.Object r7 = r2.next()
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegment r7 = (com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegment) r7
            int r15 = r1.length()
            r8 = 1
            if (r15 <= r8) goto L_0x018e
            java.lang.String r8 = ","
            r1.append(r8)
        L_0x018e:
            java.lang.String r8 = r7.toString()
            r1.append(r8)
            int r8 = r7.d
            int r11 = r11 + r8
            int r8 = r7.a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.Object r8 = r6.get(r8)
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegmentResult r8 = (com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegmentResult) r8
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileResult r15 = new com.cellrebel.sdk.trafficprofile.models.TrafficProfileResult
            r15.<init>()
            r18 = r2
            com.cellrebel.sdk.trafficprofile.models.TrafficProfile r2 = r0.a
            java.lang.String r2 = r2.b
            r15.a = r2
            java.lang.String r2 = r7.toString()
            r15.b = r2
            int r2 = r31.a()
            r15.c = r2
            if (r8 == 0) goto L_0x02da
            java.util.List<java.lang.Integer> r2 = r8.a
            if (r2 == 0) goto L_0x02da
            int r2 = r2.size()
            r21 = r6
            r6 = 2
            if (r2 >= r6) goto L_0x01ce
            goto L_0x02dc
        L_0x01ce:
            java.util.List<java.lang.Integer> r2 = r8.a
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r6 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int[] r6 = r6.a((java.util.List<java.lang.Integer>) r2)
            r22 = r9
            long r9 = r8.e
            r24 = r12
            r13 = r11
            long r11 = r8.f
            r26 = r13
            int r13 = r7.b
            int r27 = r2.size()
            int r13 = r13 * r27
            int r3 = r3 + r13
            int r8 = r8.d
            r15.u = r8
            r27 = r3
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            r28 = r14
            int r14 = r7.d
            int r3 = r3.a((int) r8, (int) r14)
            r15.s = r3
            int r3 = r2.size()
            r15.t = r3
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r8 = r2.size()
            int r7 = r7.d
            int r3 = r3.b(r8, r7)
            long r7 = (long) r3
            r15.r = r7
            java.lang.Object r2 = java.util.Collections.min(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 >= 0) goto L_0x022a
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType r2 = com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType.TIME_SYNC_FAILURE
            r0.a((com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType) r2)
            goto L_0x02d7
        L_0x022a:
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r2 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            long r11 = r11 - r9
            double r2 = r2.a((int) r13, (long) r11)
            r15.v = r2
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r2 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int[] r2 = r2.b(r6)
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.d(r6)
            long r7 = (long) r3
            r15.d = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.e(r6)
            long r7 = (long) r3
            r15.e = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.f(r6)
            long r7 = (long) r3
            r15.f = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.c(r6)
            long r7 = (long) r3
            r15.g = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.g(r6)
            long r7 = (long) r3
            r15.h = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.h(r6)
            long r7 = (long) r3
            r15.i = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.a((int[]) r6)
            long r6 = (long) r3
            r15.j = r6
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.d(r2)
            long r6 = (long) r3
            r15.k = r6
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.e(r2)
            long r6 = (long) r3
            r15.l = r6
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.f(r2)
            long r6 = (long) r3
            r15.m = r6
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.c(r2)
            long r6 = (long) r3
            r15.n = r6
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.g(r2)
            long r6 = (long) r3
            r15.o = r6
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.h(r2)
            long r6 = (long) r3
            r15.p = r6
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r2 = r3.a((int[]) r2)
            long r2 = (long) r2
            r15.q = r2
        L_0x02d7:
            r3 = r27
            goto L_0x02e9
        L_0x02da:
            r21 = r6
        L_0x02dc:
            r22 = r9
            r26 = r11
            r24 = r12
            r28 = r14
            int r2 = r7.d
            long r6 = (long) r2
            r15.r = r6
        L_0x02e9:
            java.util.List<com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType> r2 = r0.e
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x02f3
            r8 = 0
            goto L_0x02f9
        L_0x02f3:
            java.util.List<com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType> r2 = r0.e
            java.lang.String r8 = r2.toString()
        L_0x02f9:
            r15.x = r8
            r2 = r19
            r2.add(r15)
            r2 = r18
            r6 = r21
            r9 = r22
            r12 = r24
            r11 = r26
            r14 = r28
            goto L_0x0176
        L_0x030e:
            r22 = r9
            r24 = r12
            r28 = r14
            r2 = r19
            java.lang.String r6 = "]"
            r1.append(r6)
            java.util.List<com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegment> r4 = r4.b
            int r4 = r4.size()
            r6 = 1
            if (r4 <= r6) goto L_0x043a
            com.cellrebel.sdk.trafficprofile.models.TrafficProfileResult r4 = new com.cellrebel.sdk.trafficprofile.models.TrafficProfileResult
            r4.<init>()
            com.cellrebel.sdk.trafficprofile.models.TrafficProfile r6 = r0.a
            java.lang.String r6 = r6.b
            r4.a = r6
            java.lang.String r1 = r1.toString()
            r4.b = r1
            int r1 = r31.a()
            r4.c = r1
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L_0x0346
            long r5 = (long) r11
            r4.r = r5
            goto L_0x0425
        L_0x0346:
            r15 = r20
            r4.u = r15
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r1 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r1 = r1.a((int) r15, (int) r11)
            r4.s = r1
            r14 = r28
            r4.t = r14
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r1 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r1 = r1.b(r14, r11)
            long r6 = (long) r1
            r4.r = r6
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r1 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int[] r1 = r1.a((java.util.List<java.lang.Integer>) r5)
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r6 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int[] r6 = r6.b(r1)
            java.lang.Object r5 = java.util.Collections.min(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 <= 0) goto L_0x0425
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r5 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            long r12 = r24 - r22
            double r7 = r5.a((int) r3, (long) r12)
            r4.v = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.d(r1)
            long r7 = (long) r3
            r4.d = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.e(r1)
            long r7 = (long) r3
            r4.e = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.f(r1)
            long r7 = (long) r3
            r4.f = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.c(r1)
            long r7 = (long) r3
            r4.g = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.g(r1)
            long r7 = (long) r3
            r4.h = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r3 = r3.h(r1)
            long r7 = (long) r3
            r4.i = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r3 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r1 = r3.a((int[]) r1)
            long r7 = (long) r1
            r4.j = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r1 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r1 = r1.d(r6)
            long r7 = (long) r1
            r4.k = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r1 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r1 = r1.e(r6)
            long r7 = (long) r1
            r4.l = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r1 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r1 = r1.f(r6)
            long r7 = (long) r1
            r4.m = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r1 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r1 = r1.c(r6)
            long r7 = (long) r1
            r4.n = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r1 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r1 = r1.g(r6)
            long r7 = (long) r1
            r4.o = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r1 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r1 = r1.h(r6)
            long r7 = (long) r1
            r4.p = r7
            com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils r1 = com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurementUtils.a()
            int r1 = r1.a((int[]) r6)
            long r5 = (long) r1
            r4.q = r5
        L_0x0425:
            java.util.List<com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType> r1 = r0.e
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x042f
            r8 = 0
            goto L_0x0435
        L_0x042f:
            java.util.List<com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType> r1 = r0.e
            java.lang.String r8 = r1.toString()
        L_0x0435:
            r4.x = r8
            r2.add(r4)
        L_0x043a:
            r1 = r31
            r3 = r16
            goto L_0x002e
        L_0x0440:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.trafficprofile.TrafficProfileResultProcessor.a(java.util.List, com.cellrebel.sdk.trafficprofile.models.TrafficProfileType, java.util.List):java.util.List");
    }

    public List<TrafficProfileResult> a() {
        if (this.d) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a(this.a.c, TrafficProfileType.DOWNLINK, this.b));
        arrayList.addAll(a(this.a.d, TrafficProfileType.UPLINK, this.c));
        return arrayList;
    }

    public void a(TrafficProfile trafficProfile) {
        this.a = trafficProfile;
    }

    public void a(TrafficProfileErrorType trafficProfileErrorType) {
        if (!this.e.contains(trafficProfileErrorType)) {
            this.e.add(trafficProfileErrorType);
        }
    }

    public void a(UdpPackageMessage udpPackageMessage) {
        this.b.add(udpPackageMessage);
    }

    public void a(List<UdpPackageMessage> list) {
        this.c.addAll(list);
    }
}
