package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.c.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: LayoutUnitSizeUtils */
public class j {
    private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"dislike", "close", "close-fill", "webview-close"})));
    private static String b;

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x03f5: MOVE  (r1v8 int) = (r23v0 int)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    public static com.bytedance.sdk.component.adexpress.dynamic.c.a.c a(java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21, boolean r22, int r23, com.bytedance.sdk.component.adexpress.dynamic.b.h r24, double r25, int r27, double r28, java.lang.String r30, com.bytedance.sdk.component.adexpress.b.m r31) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r27
            java.lang.String r4 = "getDomSizeFromNative letterSpacing=="
            java.lang.String r5 = r31.d()
            int r6 = r31.g()
            boolean r7 = com.bytedance.sdk.component.adexpress.d.b()
            java.lang.String r8 = "score-count-type-2"
            java.lang.String r9 = "score-count"
            java.lang.String r10 = "text_star"
            r11 = 4
            r12 = 0
            if (r7 == 0) goto L_0x0042
            if (r3 == r11) goto L_0x0042
            boolean r7 = android.text.TextUtils.equals(r1, r10)
            if (r7 != 0) goto L_0x003c
            boolean r7 = android.text.TextUtils.equals(r1, r9)
            if (r7 != 0) goto L_0x003c
            java.lang.String r7 = "score-count-type-1"
            boolean r7 = android.text.TextUtils.equals(r1, r7)
            if (r7 != 0) goto L_0x003c
            boolean r7 = android.text.TextUtils.equals(r1, r8)
            if (r7 == 0) goto L_0x0042
        L_0x003c:
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r0.<init>(r12, r12)
            return r0
        L_0x0042:
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r7 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r7.<init>()
            java.lang.String r13 = "<svg"
            boolean r13 = r0.startsWith(r13)
            java.lang.String r14 = "fontSize"
            r15 = 1092616192(0x41200000, float:10.0)
            if (r13 != 0) goto L_0x047d
            java.util.Set<java.lang.String> r13 = a
            boolean r13 = r13.contains(r1)
            if (r13 == 0) goto L_0x005d
            goto L_0x047d
        L_0x005d:
            java.lang.String r13 = "logo"
            boolean r13 = r13.equals(r1)
            if (r13 == 0) goto L_0x00d2
            boolean r3 = com.bytedance.sdk.component.adexpress.d.b()
            if (r3 != 0) goto L_0x0093
            boolean r3 = android.text.TextUtils.isEmpty(r18)
            if (r3 != 0) goto L_0x0079
            java.lang.String r3 = "adx:"
            boolean r3 = r0.contains(r3)
            if (r3 != 0) goto L_0x007f
        L_0x0079:
            boolean r3 = b()
            if (r3 == 0) goto L_0x0093
        L_0x007f:
            boolean r1 = b()
            if (r1 == 0) goto L_0x008c
            java.lang.String r1 = b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r7, r0, r2, r1)
            return r0
        L_0x008c:
            java.lang.String r1 = ""
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r7, r0, r2, r1)
            return r0
        L_0x0093:
            java.lang.String r3 = "union"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x009e
            r3 = 1092616192(0x41200000, float:10.0)
            goto L_0x00a0
        L_0x009e:
            r3 = 1101004800(0x41a00000, float:20.0)
        L_0x00a0:
            r7.a = r3
            r7.b = r15
            boolean r3 = com.bytedance.sdk.component.adexpress.d.b()
            if (r3 == 0) goto L_0x00d1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            double r3 = b(r20)
            float r1 = (float) r3
            java.lang.String r3 = "logoad"
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x00cf
            java.lang.String r0 = "AD"
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            r0.b = r1
            return r0
        L_0x00cf:
            r7.b = r1
        L_0x00d1:
            return r7
        L_0x00d2:
            java.lang.String r13 = "development-name"
            boolean r15 = r13.equals(r1)
            if (r15 == 0) goto L_0x00f3
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            android.content.Context r11 = com.bytedance.sdk.component.adexpress.d.a()
            java.lang.String r12 = "tt_text_privacy_development"
            java.lang.String r11 = com.bytedance.sdk.component.utils.s.a(r11, r12)
            r15.append(r11)
            r15.append(r0)
            java.lang.String r0 = r15.toString()
        L_0x00f3:
            java.lang.String r11 = "app-version"
            boolean r12 = r11.equals(r1)
            if (r12 == 0) goto L_0x0117
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            android.content.Context r15 = com.bytedance.sdk.component.adexpress.d.a()
            r16 = r6
            java.lang.String r6 = "tt_text_privacy_app_version"
            java.lang.String r6 = com.bytedance.sdk.component.utils.s.a(r15, r6)
            r12.append(r6)
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            goto L_0x0119
        L_0x0117:
            r16 = r6
        L_0x0119:
            boolean r6 = r9.equals(r1)
            java.lang.String r9 = ")"
            java.lang.String r12 = "("
            r15 = 1
            r17 = 0
            if (r6 == 0) goto L_0x0166
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x012b }
            goto L_0x012d
        L_0x012b:
            r0 = 0
        L_0x012d:
            boolean r1 = com.bytedance.sdk.component.adexpress.d.b()
            if (r1 == 0) goto L_0x013c
            if (r0 >= 0) goto L_0x013c
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r1 = 0
            r0.<init>(r1, r1)
            return r0
        L_0x013c:
            android.content.Context r1 = com.bytedance.sdk.component.adexpress.d.a()
            java.lang.String r3 = "tt_comment_num"
            java.lang.String r1 = com.bytedance.sdk.component.utils.s.a(r1, r3)
            java.lang.Object[] r3 = new java.lang.Object[r15]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r17] = r0
            java.lang.String r0 = java.lang.String.format(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r12)
            r1.append(r0)
            r1.append(r9)
            java.lang.String r0 = r1.toString()
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x0166:
            boolean r6 = r8.equals(r1)
            if (r6 == 0) goto L_0x01ae
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0171 }
            goto L_0x0173
        L_0x0171:
            r0 = 0
        L_0x0173:
            boolean r1 = com.bytedance.sdk.component.adexpress.d.b()
            if (r1 == 0) goto L_0x0182
            if (r0 >= 0) goto L_0x0182
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r1 = 0
            r0.<init>(r1, r1)
            return r0
        L_0x0182:
            java.text.DecimalFormat r1 = new java.text.DecimalFormat
            java.lang.String r3 = "###,###,###"
            r1.<init>(r3)
            long r3 = (long) r0
            java.lang.String r1 = r1.format(r3)
            java.lang.Object[] r3 = new java.lang.Object[r15]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r17] = r0
            java.lang.String r0 = java.lang.String.format(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r12)
            r1.append(r0)
            r1.append(r9)
            java.lang.String r0 = r1.toString()
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x01ae:
            java.lang.String r6 = "feedback-dislike"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x01cf
            android.content.Context r0 = com.bytedance.sdk.component.adexpress.d.a()
            java.lang.String r1 = "tt_reward_feedback"
            java.lang.String r0 = com.bytedance.sdk.component.utils.s.a(r0, r1)
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            boolean r1 = com.bytedance.sdk.component.adexpress.d.b()
            if (r1 == 0) goto L_0x01ce
            float r1 = r0.b
            r0.a = r1
        L_0x01ce:
            return r0
        L_0x01cf:
            java.lang.String r6 = "skip-with-time-countdown"
            boolean r6 = r6.equals(r1)
            java.lang.String r8 = "00"
            r9 = 10
            if (r6 != 0) goto L_0x0426
            java.lang.String r6 = "skip-with-countdowns-video-countdown"
            boolean r6 = android.text.TextUtils.equals(r6, r1)
            if (r6 == 0) goto L_0x01e5
            goto L_0x0426
        L_0x01e5:
            java.lang.String r5 = "skip-with-countdowns-skip-btn"
            boolean r5 = android.text.TextUtils.equals(r5, r1)
            java.lang.String r6 = "tt_reward_screen_skip_tx"
            java.lang.String r12 = "| "
            if (r5 == 0) goto L_0x020a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            android.content.Context r1 = com.bytedance.sdk.component.adexpress.d.a()
            java.lang.String r1 = com.bytedance.sdk.component.utils.s.a(r1, r6)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x020a:
            java.lang.String r5 = "skip-with-countdowns-skip-countdown"
            boolean r5 = android.text.TextUtils.equals(r5, r1)
            if (r5 == 0) goto L_0x0235
            android.content.Context r0 = com.bytedance.sdk.component.adexpress.d.a()
            java.lang.String r1 = "tt_reward_full_skip_count_down"
            java.lang.String r0 = com.bytedance.sdk.component.utils.s.a(r0, r1)
            java.lang.Object[] r1 = new java.lang.Object[r15]
            r1[r17] = r8
            java.lang.String r0 = java.lang.String.format(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r12)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x0235:
            java.lang.String r5 = "skip-with-time-skip-btn"
            boolean r5 = r5.equals(r1)
            java.lang.String r8 = "lineHeight"
            r16 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            if (r5 == 0) goto L_0x027d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            android.content.Context r1 = com.bytedance.sdk.component.adexpress.d.a()
            java.lang.String r1 = com.bytedance.sdk.component.utils.s.a(r1, r6)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            boolean r1 = com.bytedance.sdk.component.adexpress.d.b()
            if (r1 == 0) goto L_0x027c
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0278 }
            r1.<init>(r2)     // Catch:{ all -> 0x0278 }
            double r1 = r1.optDouble(r8)     // Catch:{ all -> 0x0278 }
            float r3 = r0.b     // Catch:{ all -> 0x0278 }
            double r3 = (double) r3
            java.lang.Double.isNaN(r3)
            double r3 = r3 * r1
            double r3 = r3 / r16
            float r1 = (float) r3
            r0.b = r1     // Catch:{ all -> 0x0278 }
        L_0x0278:
            float r1 = r0.b
            r0.a = r1
        L_0x027c:
            return r0
        L_0x027d:
            java.lang.String r5 = "skip"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0292
            android.content.Context r0 = com.bytedance.sdk.component.adexpress.d.a()
            java.lang.String r0 = com.bytedance.sdk.component.utils.s.a(r0, r6)
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x0292:
            java.lang.String r5 = "timedown"
            boolean r5 = r5.equals(r1)
            java.lang.String r6 = "0.0"
            if (r5 == 0) goto L_0x02a1
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r6, r2)
            return r0
        L_0x02a1:
            boolean r5 = r10.equals(r1)
            if (r5 == 0) goto L_0x02c5
            boolean r0 = com.bytedance.sdk.component.adexpress.d.b()
            if (r0 == 0) goto L_0x02c0
            r0 = 0
            int r3 = (r28 > r0 ? 1 : (r28 == r0 ? 0 : -1))
            if (r3 < 0) goto L_0x02b9
            r0 = 4617315517961601024(0x4014000000000000, double:5.0)
            int r3 = (r28 > r0 ? 1 : (r28 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x02c0
        L_0x02b9:
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r1 = 0
            r0.<init>(r1, r1)
            return r0
        L_0x02c0:
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r6, r2)
            return r0
        L_0x02c5:
            java.lang.String r5 = "privacy-detail"
            boolean r5 = android.text.TextUtils.equals(r5, r1)
            if (r5 == 0) goto L_0x02d4
            java.lang.String r0 = "Permission list | Privacy policy"
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x02d4:
            java.lang.String r5 = "arrowButton"
            boolean r6 = r5.equals(r1)
            if (r6 == 0) goto L_0x02e3
            java.lang.String r0 = "Download"
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x02e3:
            java.lang.String r6 = "title"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x02f7
            r6 = 32
            java.lang.String r6 = r0.replace(r9, r6)     // Catch:{ Exception -> 0x02f6 }
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a((java.lang.String) r6, (java.lang.String) r2, (boolean) r15)     // Catch:{ Exception -> 0x02f6 }
            return r0
        L_0x02f6:
        L_0x02f7:
            java.lang.String r6 = "fillButton"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0421
            java.lang.String r6 = "text"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0421
            java.lang.String r6 = "button"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0421
            java.lang.String r6 = "downloadWithIcon"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0421
            java.lang.String r6 = "downloadButton"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0421
            java.lang.String r6 = "laceButton"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0421
            java.lang.String r6 = "cardButton"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0421
            java.lang.String r6 = "colourMixtureButton"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0421
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0421
            java.lang.String r5 = "source"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0421
            boolean r5 = android.text.TextUtils.equals(r11, r1)
            if (r5 != 0) goto L_0x0421
            boolean r5 = android.text.TextUtils.equals(r13, r1)
            if (r5 == 0) goto L_0x0353
            goto L_0x0421
        L_0x0353:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x041c }
            r5.<init>(r2)     // Catch:{ JSONException -> 0x041c }
            int r0 = r0.length()     // Catch:{ JSONException -> 0x041c }
            double r9 = r5.optDouble(r14)     // Catch:{ JSONException -> 0x041c }
            float r6 = (float) r9     // Catch:{ JSONException -> 0x041c }
            java.lang.String r9 = "letterSpacing"
            double r9 = r5.optDouble(r9)     // Catch:{ JSONException -> 0x041c }
            float r9 = (float) r9     // Catch:{ JSONException -> 0x041c }
            double r10 = r5.optDouble(r8)     // Catch:{ JSONException -> 0x041c }
            float r8 = (float) r10     // Catch:{ JSONException -> 0x041c }
            java.lang.String r10 = "maxWidth"
            double r10 = r5.optDouble(r10)     // Catch:{ JSONException -> 0x041c }
            float r5 = (float) r10     // Catch:{ JSONException -> 0x041c }
            float r0 = (float) r0     // Catch:{ JSONException -> 0x041c }
            float r10 = r6 + r9
            float r0 = r0 * r10
            float r0 = r0 - r9
            java.lang.String r10 = "DynamicBaseWidget"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x041c }
            r11.<init>(r4)     // Catch:{ JSONException -> 0x041c }
            r11.append(r9)     // Catch:{ JSONException -> 0x041c }
            java.lang.String r4 = ",lineHeight=="
            r11.append(r4)     // Catch:{ JSONException -> 0x041c }
            r11.append(r8)     // Catch:{ JSONException -> 0x041c }
            java.lang.String r4 = ",maxWidth =="
            r11.append(r4)     // Catch:{ JSONException -> 0x041c }
            r11.append(r5)     // Catch:{ JSONException -> 0x041c }
            java.lang.String r4 = ",totalStrLength"
            r11.append(r4)     // Catch:{ JSONException -> 0x041c }
            r11.append(r0)     // Catch:{ JSONException -> 0x041c }
            java.lang.String r4 = r11.toString()     // Catch:{ JSONException -> 0x041c }
            com.bytedance.sdk.component.utils.l.e(r10, r4)     // Catch:{ JSONException -> 0x041c }
            java.lang.String r4 = "muted"
            boolean r4 = r4.equals(r1)     // Catch:{ JSONException -> 0x041c }
            if (r4 == 0) goto L_0x03b0
            r7.a = r6     // Catch:{ JSONException -> 0x041c }
            r7.b = r6     // Catch:{ JSONException -> 0x041c }
            return r7
        L_0x03b0:
            java.lang.String r4 = "star"
            boolean r4 = r4.equals(r1)     // Catch:{ JSONException -> 0x041c }
            if (r4 == 0) goto L_0x03e1
            boolean r0 = com.bytedance.sdk.component.adexpress.d.b()     // Catch:{ JSONException -> 0x041c }
            if (r0 == 0) goto L_0x03d4
            r0 = 0
            int r4 = (r28 > r0 ? 1 : (r28 == r0 ? 0 : -1))
            if (r4 < 0) goto L_0x03cd
            r0 = 4617315517961601024(0x4014000000000000, double:5.0)
            int r4 = (r28 > r0 ? 1 : (r28 == r0 ? 0 : -1))
            if (r4 > 0) goto L_0x03cd
            r0 = 4
            if (r3 == r0) goto L_0x03d4
        L_0x03cd:
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c     // Catch:{ JSONException -> 0x041c }
            r1 = 0
            r0.<init>(r1, r1)     // Catch:{ JSONException -> 0x041c }
            return r0
        L_0x03d4:
            java.lang.String r0 = "str"
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)     // Catch:{ JSONException -> 0x041c }
            r1 = 1084227584(0x40a00000, float:5.0)
            float r6 = r6 * r1
            r0.a = r6     // Catch:{ JSONException -> 0x041c }
            return r0
        L_0x03e1:
            java.lang.String r2 = "icon"
            boolean r1 = r2.equals(r1)     // Catch:{ JSONException -> 0x041c }
            if (r1 == 0) goto L_0x03ee
            r7.a = r6     // Catch:{ JSONException -> 0x041c }
            r7.b = r6     // Catch:{ JSONException -> 0x041c }
            return r7
        L_0x03ee:
            if (r21 == 0) goto L_0x0407
            float r0 = r0 / r5
            int r0 = (int) r0
            int r0 = r0 + r15
            if (r22 == 0) goto L_0x03fa
            r1 = r23
            if (r0 < r1) goto L_0x03fa
            r0 = r1
        L_0x03fa:
            float r8 = r8 * r6
            float r0 = (float) r0
            float r8 = r8 * r0
            double r0 = (double) r8
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r16
            float r0 = (float) r0
            goto L_0x0417
        L_0x0407:
            float r8 = r8 * r6
            double r1 = (double) r8
            java.lang.Double.isNaN(r1)
            double r1 = r1 * r16
            float r1 = (float) r1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0415
            goto L_0x0416
        L_0x0415:
            r5 = r0
        L_0x0416:
            r0 = r1
        L_0x0417:
            r7.a = r5     // Catch:{ JSONException -> 0x041c }
            r7.b = r0     // Catch:{ JSONException -> 0x041c }
            goto L_0x0420
        L_0x041c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0420:
            return r7
        L_0x0421:
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x0426:
            boolean r0 = r31.a()
            if (r0 == 0) goto L_0x0469
            boolean r0 = com.bytedance.sdk.component.adexpress.c.d.b(r5)
            if (r0 == 0) goto L_0x0469
            r0 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r0 = r25 + r0
            int r0 = (int) r0
            int r0 = r0 - r16
            java.lang.String r1 = "tt_reward_full_skip"
            if (r0 >= r9) goto L_0x0454
            android.content.Context r0 = com.bytedance.sdk.component.adexpress.d.a()
            java.lang.String r0 = com.bytedance.sdk.component.utils.s.a(r0, r1)
            java.lang.Object[] r1 = new java.lang.Object[r15]
            java.lang.String r3 = "0"
            r1[r17] = r3
            java.lang.String r0 = java.lang.String.format(r0, r1)
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x0454:
            android.content.Context r0 = com.bytedance.sdk.component.adexpress.d.a()
            java.lang.String r0 = com.bytedance.sdk.component.utils.s.a(r0, r1)
            java.lang.Object[] r1 = new java.lang.Object[r15]
            r1[r17] = r8
            java.lang.String r0 = java.lang.String.format(r0, r1)
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x0469:
            r0 = 4621819117588971520(0x4024000000000000, double:10.0)
            int r3 = (r25 > r0 ? 1 : (r25 == r0 ? 0 : -1))
            if (r3 >= 0) goto L_0x0476
            java.lang.String r0 = "0S"
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x0476:
            java.lang.String r0 = "00S"
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r0 = a(r0, r2)
            return r0
        L_0x047d:
            java.lang.String r0 = "close"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0494 }
            if (r0 == 0) goto L_0x0494
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0494 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0494 }
            double r0 = r0.optDouble(r14)     // Catch:{ Exception -> 0x0494 }
            float r0 = (float) r0     // Catch:{ Exception -> 0x0494 }
            r7.a = r0     // Catch:{ Exception -> 0x0494 }
            r7.b = r0     // Catch:{ Exception -> 0x0494 }
            return r7
        L_0x0494:
            r7.a = r15
            r7.b = r15
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.c.j.a(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, com.bytedance.sdk.component.adexpress.dynamic.b.h, double, int, double, java.lang.String, com.bytedance.sdk.component.adexpress.b.m):com.bytedance.sdk.component.adexpress.dynamic.c.a$c");
    }

    public static String a(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("adx:")) != null && split.length >= 2) {
            return split[1];
        }
        return "";
    }

    private static a.c a(a.c cVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            cVar.a = 0.0f;
            cVar.b = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = a(str);
            }
            if (!TextUtils.isEmpty(str3)) {
                return a(str3, str2);
            }
            cVar.a = 0.0f;
            cVar.b = 0.0f;
        }
        return cVar;
    }

    public static a.c a(String str, String str2) {
        return a(str, str2, false);
    }

    public static a.c a(String str, String str2, boolean z) {
        a.c cVar = new a.c();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] a2 = a(str, (float) b(str2), z);
            cVar.a = (float) a2[0];
            cVar.b = (float) a2[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                cVar.b = 0.0f;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cVar;
    }

    public static double b(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] a(String str, float f, boolean z) {
        int[] b2 = b(str, f, z);
        return new int[]{e.b(d.a(), (float) b2[0]), e.b(d.a(), (float) b2[1])};
    }

    public static int[] b(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(d.a());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static String a() {
        return b;
    }

    public static boolean b() {
        return !TextUtils.isEmpty(b);
    }
}
