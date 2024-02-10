package com.apm.insight.b;

import android.content.Context;
import android.os.SystemClock;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.c;
import com.apm.insight.i;
import com.apm.insight.l.l;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.a;
import com.apm.insight.runtime.o;
import com.facebook.internal.security.CertificateUtil;
import com.umlaut.crowd.CCS;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    static volatile boolean a = true;
    private static volatile boolean f;
    private long A = 0;
    private final Runnable B = new Runnable() {
        public void run() {
            try {
                b.this.a(200, 25);
            } catch (Throwable th) {
                c.a().a("NPTH_CATCH", th);
            }
        }
    };
    private int C = 0;
    private List<Pattern> D = null;
    private File E = null;
    Pattern b = null;
    private c c;
    private final Context d;
    private volatile boolean e;
    private long g = -1;
    private File h = null;
    /* access modifiers changed from: private */
    public boolean i = true;
    private JSONObject j;
    private JSONObject k;
    private String l = "unknown";
    private String m = "unknown";
    private String n = "unknown";
    private String o = "npth_inner_default";
    private JSONArray p;
    private JSONObject q;
    private int r = 0;
    private long s = -1;
    private JSONArray t;
    private JSONArray u;
    private JSONObject v;
    private boolean w;
    private final Object x = new Object();
    private volatile boolean y;
    private long z = -1;

    public b(Context context) {
        this.d = context;
    }

    private static String a(float f2) {
        return f2 <= 0.0f ? "0%" : f2 <= 0.1f ? "0% - 10%" : f2 <= 0.3f ? "10% - 30%" : f2 <= 0.6f ? "30% - 60%" : f2 <= 0.9f ? "60% - 90%" : "90% - 100%";
    }

    private static String a(float f2, float f3) {
        return f3 > 0.0f ? a(f2 / f3) : f2 > 0.0f ? "100%" : "0%";
    }

    private JSONObject a(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray a2 = l.a(256, 128, jSONArray);
        if (a2.length() != jSONArray.length()) {
            this.r++;
        }
        try {
            jSONObject.put("thread_name", str);
            jSONObject.put("thread_stack", a2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0207, code lost:
        if (r8 != 5) goto L_0x0263;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x02c6 A[LOOP:3: B:102:0x01f1->B:162:0x02c6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03e9 A[EDGE_INSN: B:223:0x03e9->B:210:0x03e9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x03d2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0394 A[EDGE_INSN: B:229:0x0394->B:199:0x0394 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r30, org.json.JSONObject r31) {
        /*
            r29 = this;
            r0 = r29
            r1 = r31
            android.os.SystemClock.uptimeMillis()
            java.lang.String r2 = "\n"
            r3 = r30
            java.lang.String[] r2 = r3.split(r2)
            r3 = 3
            float[] r4 = new float[r3]
            r4 = {-1082130432, -1082130432, -1082130432} // fill-array
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            int r10 = r2.length
            java.lang.String r12 = "unknown"
            r15 = r12
            r16 = r15
            r13 = 0
            r14 = 0
            r17 = 0
        L_0x0038:
            java.lang.String r11 = "total"
            if (r13 >= r10) goto L_0x03e5
            r3 = r2[r13]
            boolean r18 = android.text.TextUtils.isEmpty(r3)
            if (r18 == 0) goto L_0x0053
            r18 = r2
            r25 = r8
            r26 = r9
            r19 = r10
            r20 = r12
            r8 = 3
            r23 = 0
            goto L_0x03d2
        L_0x0053:
            r18 = r2
            java.lang.String r2 = ""
            r19 = r10
            r10 = 1
            if (r14 == 0) goto L_0x03a9
            r20 = r12
            r12 = 2
            if (r14 == r10) goto L_0x02de
            if (r14 == r12) goto L_0x02d4
            r10 = 3
            if (r14 == r10) goto L_0x0071
            r25 = r8
            r26 = r9
            r22 = r14
        L_0x006c:
            r8 = 3
            r23 = 0
            goto L_0x03cc
        L_0x0071:
            java.lang.String r10 = "\\s"
            java.lang.String[] r10 = r3.split(r10)
            r22 = r14
            int r14 = r10.length
            if (r14 >= r12) goto L_0x0081
            r25 = r8
            r26 = r9
            goto L_0x006c
        L_0x0081:
            java.lang.String r14 = "CPU"
            r23 = 0
            r12 = r10[r23]
            boolean r12 = r14.equalsIgnoreCase(r12)
            if (r12 == 0) goto L_0x00d4
            java.lang.String r12 = "usage"
            r14 = 1
            r1 = r10[r14]
            boolean r1 = r12.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00d4
            java.lang.String r1 = "ago"
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x00a2
            r17 = 1
        L_0x00a2:
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L_0x00cb
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L_0x00cb
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L_0x00cb
            boolean r1 = r9.isEmpty()
            if (r1 == 0) goto L_0x00cb
            boolean r1 = r8.isEmpty()
            if (r1 != 0) goto L_0x00c1
            goto L_0x00cb
        L_0x00c1:
            r25 = r8
            r26 = r9
            r14 = r22
            r0 = 4
            r8 = 3
            goto L_0x03cf
        L_0x00cb:
            r25 = r8
            r26 = r9
            r0 = 4
            r8 = 3
            r14 = 4
            goto L_0x03cf
        L_0x00d4:
            boolean r1 = r5.isEmpty()
            if (r1 != 0) goto L_0x00f3
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L_0x00f3
            boolean r1 = r7.isEmpty()
            if (r1 != 0) goto L_0x00f3
            boolean r1 = r9.isEmpty()
            if (r1 != 0) goto L_0x00f3
            boolean r1 = r8.isEmpty()
            if (r1 != 0) goto L_0x00f3
            goto L_0x00cb
        L_0x00f3:
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L_0x0108
            r1 = 1
            r14 = r10[r1]
            java.lang.String r1 = "TOTAL:"
            boolean r1 = r14.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0108
            r3 = r2
            r0 = r5
            goto L_0x018c
        L_0x0108:
            android.content.Context r1 = r0.d
            java.lang.String r1 = r1.getPackageName()
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x0157
            r3 = r2
            r1 = 0
        L_0x0116:
            int r14 = r10.length
            if (r1 >= r14) goto L_0x0155
            r14 = r10[r1]
            android.content.Context r12 = r0.d
            java.lang.String r12 = r12.getPackageName()
            boolean r12 = r14.contains(r12)
            if (r12 == 0) goto L_0x0150
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r12 = r10[r1]
            r14 = 47
            int r14 = r12.indexOf(r14)
            r21 = 1
            int r14 = r14 + 1
            r24 = r10[r1]
            int r24 = r24.length()
            int r0 = r24 + -1
            java.lang.String r0 = r12.substring(r14, r0)
            r3.append(r0)
            r0 = 95
            r3.append(r0)
            java.lang.String r3 = r3.toString()
        L_0x0150:
            int r1 = r1 + 1
            r0 = r29
            goto L_0x0116
        L_0x0155:
            r0 = r7
            goto L_0x018c
        L_0x0157:
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0168
            java.lang.String r0 = "system_server:"
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L_0x0168
            r3 = r2
            r0 = r6
            goto L_0x018c
        L_0x0168:
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L_0x0179
            java.lang.String r0 = "kswapd"
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L_0x0179
            r3 = r2
            r0 = r9
            goto L_0x018c
        L_0x0179:
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x018a
            java.lang.String r0 = "dex2oat"
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L_0x018a
            r3 = r2
            r0 = r8
            goto L_0x018c
        L_0x018a:
            r3 = r2
            r0 = 0
        L_0x018c:
            if (r0 == 0) goto L_0x02ce
            r1 = 0
        L_0x018f:
            r12 = r10[r1]
            java.lang.String r14 = "%"
            boolean r12 = r12.contains(r14)
            if (r12 != 0) goto L_0x019e
            int r1 = r1 + 1
            int r12 = r10.length
            if (r1 < r12) goto L_0x018f
        L_0x019e:
            r12 = r10[r1]     // Catch:{ all -> 0x01d2 }
            java.lang.String r12 = r12.replace(r14, r2)     // Catch:{ all -> 0x01d2 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x01d2 }
            float r12 = r12.floatValue()     // Catch:{ all -> 0x01d2 }
            r25 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r8.<init>()     // Catch:{ all -> 0x01d4 }
            r8.append(r3)     // Catch:{ all -> 0x01d4 }
            r8.append(r11)     // Catch:{ all -> 0x01d4 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x01d4 }
            if (r0 != r5) goto L_0x01c2
            r26 = r9
            goto L_0x01ca
        L_0x01c2:
            r26 = r9
            int r9 = com.apm.insight.l.d.e()     // Catch:{ all -> 0x01d6 }
            float r9 = (float) r9     // Catch:{ all -> 0x01d6 }
            float r12 = r12 / r9
        L_0x01ca:
            java.lang.Float r9 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x01d6 }
            r0.put(r8, r9)     // Catch:{ all -> 0x01d6 }
            goto L_0x01ee
        L_0x01d2:
            r25 = r8
        L_0x01d4:
            r26 = r9
        L_0x01d6:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            java.lang.Float r12 = java.lang.Float.valueOf(r9)
            r0.put(r8, r12)
        L_0x01ee:
            int r1 = r1 + 3
            r8 = 0
        L_0x01f1:
            int r9 = r10.length
            if (r1 >= r9) goto L_0x0394
            java.lang.String r12 = "softirq"
            if (r8 == 0) goto L_0x0216
            r9 = 1
            if (r8 == r9) goto L_0x0213
            r9 = 2
            if (r8 == r9) goto L_0x0210
            r9 = 3
            if (r8 == r9) goto L_0x020d
            r9 = 4
            if (r8 == r9) goto L_0x020a
            r9 = 5
            r28 = r8
            if (r8 == r9) goto L_0x0259
            goto L_0x0263
        L_0x020a:
            r28 = r8
            goto L_0x024f
        L_0x020d:
            r28 = r8
            goto L_0x0241
        L_0x0210:
            r28 = r8
            goto L_0x0233
        L_0x0213:
            r28 = r8
            goto L_0x0226
        L_0x0216:
            java.lang.String r9 = "user"
            r28 = r8
            r8 = r10[r1]
            boolean r8 = r9.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x0226
            java.lang.String r12 = "user"
            r8 = 1
            goto L_0x0266
        L_0x0226:
            r8 = r10[r1]
            java.lang.String r9 = "kernel"
            boolean r8 = r9.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x0233
            r12 = r9
            r8 = 2
            goto L_0x0266
        L_0x0233:
            java.lang.String r8 = "iowait"
            r9 = r10[r1]
            boolean r8 = r8.equalsIgnoreCase(r9)
            if (r8 == 0) goto L_0x0241
            java.lang.String r12 = "iowait"
            r8 = 3
            goto L_0x0266
        L_0x0241:
            java.lang.String r8 = "irq"
            r9 = r10[r1]
            boolean r8 = r8.equalsIgnoreCase(r9)
            if (r8 == 0) goto L_0x024f
            java.lang.String r12 = "irq"
            r8 = 4
            goto L_0x0266
        L_0x024f:
            r8 = r10[r1]
            boolean r8 = r12.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x0259
            r8 = 5
            goto L_0x0266
        L_0x0259:
            r8 = r10[r1]
            boolean r8 = r12.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x0263
            r8 = 6
            goto L_0x0266
        L_0x0263:
            r8 = r28
            r12 = 0
        L_0x0266:
            if (r12 == 0) goto L_0x02bb
            int r9 = r1 + -1
            r9 = r10[r9]     // Catch:{ all -> 0x029e }
            java.lang.String r9 = r9.replace(r14, r2)     // Catch:{ all -> 0x029e }
            java.lang.Float r9 = java.lang.Float.valueOf(r9)     // Catch:{ all -> 0x029e }
            float r9 = r9.floatValue()     // Catch:{ all -> 0x029e }
            r27 = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r10.<init>()     // Catch:{ all -> 0x02a0 }
            r10.append(r3)     // Catch:{ all -> 0x02a0 }
            r10.append(r12)     // Catch:{ all -> 0x02a0 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x02a0 }
            if (r0 != r5) goto L_0x028e
            r28 = r14
            goto L_0x0296
        L_0x028e:
            r28 = r14
            int r14 = com.apm.insight.l.d.e()     // Catch:{ all -> 0x02a2 }
            float r14 = (float) r14     // Catch:{ all -> 0x02a2 }
            float r9 = r9 / r14
        L_0x0296:
            java.lang.Float r9 = java.lang.Float.valueOf(r9)     // Catch:{ all -> 0x02a2 }
            r0.put(r10, r9)     // Catch:{ all -> 0x02a2 }
            goto L_0x02bf
        L_0x029e:
            r27 = r10
        L_0x02a0:
            r28 = r14
        L_0x02a2:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r3)
            r9.append(r12)
            java.lang.String r9 = r9.toString()
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            java.lang.Float r12 = java.lang.Float.valueOf(r10)
            r0.put(r9, r12)
            goto L_0x02c1
        L_0x02bb:
            r27 = r10
            r28 = r14
        L_0x02bf:
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x02c1:
            r9 = 6
            if (r8 < r9) goto L_0x02c6
            goto L_0x0394
        L_0x02c6:
            int r1 = r1 + 3
            r10 = r27
            r14 = r28
            goto L_0x01f1
        L_0x02ce:
            r25 = r8
            r26 = r9
            goto L_0x0394
        L_0x02d4:
            r25 = r8
            r26 = r9
            r22 = r14
            r23 = 0
            goto L_0x0360
        L_0x02de:
            r25 = r8
            r26 = r9
            r22 = r14
            r23 = 0
            java.lang.String r3 = r3.trim()
            java.lang.String r0 = r3.toLowerCase()
            java.lang.String r1 = "shortmsg"
            boolean r1 = r0.startsWith(r1)
            r8 = 58
            if (r1 == 0) goto L_0x0301
            int r1 = r3.indexOf(r8)
            r3.substring(r1)
            r10 = 0
            goto L_0x0311
        L_0x0301:
            java.lang.String r1 = "reason:"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0396
            int r1 = r3.indexOf(r8)
            r3.substring(r1)
            r10 = 1
        L_0x0311:
            java.lang.String r1 = "input dispatch"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x031e
            java.lang.String r0 = "Input dispatching timed out"
        L_0x031b:
            r16 = r0
            goto L_0x0359
        L_0x031e:
            java.lang.String r1 = "broadcast of intent"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x0329
            java.lang.String r0 = "Broadcast of Intent"
            goto L_0x031b
        L_0x0329:
            java.lang.String r1 = "executing service"
            boolean r8 = r0.contains(r1)
            if (r8 == 0) goto L_0x034c
            java.lang.String r0 = "null"
            boolean r0 = r0.equalsIgnoreCase(r15)
            if (r0 == 0) goto L_0x0349
            java.lang.String r0 = "service "
            int r0 = r3.indexOf(r0)
            int r0 = r0 + 8
            java.lang.String r0 = r3.substring(r0)
            java.lang.String r15 = r0.trim()
        L_0x0349:
            r16 = r1
            goto L_0x0359
        L_0x034c:
            java.lang.String r1 = "service.startforeground"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0357
            java.lang.String r0 = "not call Service.startForeground"
            goto L_0x031b
        L_0x0357:
            r16 = r20
        L_0x0359:
            if (r10 == 0) goto L_0x0360
            r0 = 4
            r8 = 3
            r14 = 2
            goto L_0x03cf
        L_0x0360:
            java.lang.String r0 = r3.trim()
            java.lang.String r1 = "Load:"
            boolean r3 = r0.startsWith(r1)
            if (r3 == 0) goto L_0x0394
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r0 = r0.trim()
            java.lang.String r1 = "/"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r8 = 3
            if (r8 != r1) goto L_0x0391
            r1 = 0
        L_0x037f:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x0391
            r2 = r0[r1]
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            float r2 = r2.floatValue()
            r4[r1] = r2
            int r1 = r1 + 1
            goto L_0x037f
        L_0x0391:
            r0 = 4
            r14 = 3
            goto L_0x03cf
        L_0x0394:
            r8 = 3
            goto L_0x03cc
        L_0x0396:
            r8 = 3
            java.lang.String r1 = "appfreeze"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x03cc
            java.lang.String r0 = "AppFreeze"
            r1 = 10
            r16 = r0
            r0 = 4
            r14 = 10
            goto L_0x03cf
        L_0x03a9:
            r25 = r8
            r26 = r9
            r20 = r12
            r22 = r14
            r8 = 3
            r23 = 0
            java.lang.String r0 = r3.trim()
            java.lang.String r1 = "tag:"
            boolean r3 = r0.startsWith(r1)
            if (r3 == 0) goto L_0x03cc
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r0 = r0.trim()
            r15 = r0
            r0 = 4
            r14 = 1
            goto L_0x03cf
        L_0x03cc:
            r14 = r22
            r0 = 4
        L_0x03cf:
            if (r14 < r0) goto L_0x03d2
            goto L_0x03e9
        L_0x03d2:
            int r13 = r13 + 1
            r0 = r29
            r1 = r31
            r2 = r18
            r10 = r19
            r12 = r20
            r8 = r25
            r9 = r26
            r3 = 3
            goto L_0x0038
        L_0x03e5:
            r25 = r8
            r26 = r9
        L_0x03e9:
            r0 = r16
            java.lang.String r1 = "anr_tag"
            r2 = r31
            r2.put(r1, r15)
            java.lang.String r1 = "anr_has_ago"
            java.lang.String r3 = java.lang.String.valueOf(r17)
            r2.put(r1, r3)
            java.lang.String r1 = "anr_reason"
            r2.put(r1, r0)
            java.lang.String r0 = "app"
            a(r7, r2, r0)
            a(r5, r2, r11)
            boolean r0 = r6.isEmpty()
            java.lang.String r1 = "npth_anr_systemserver_total"
            java.lang.String r3 = "not found"
            if (r0 == 0) goto L_0x0416
            r2.put(r1, r3)
            goto L_0x0425
        L_0x0416:
            java.lang.Float r0 = com.apm.insight.l.r.a((java.util.Map<? super java.lang.String, java.lang.Float>) r6)
            float r0 = r0.floatValue()
            java.lang.String r0 = b((float) r0)
            r2.put(r1, r0)
        L_0x0425:
            boolean r0 = r26.isEmpty()
            java.lang.String r1 = "npth_anr_kswapd_total"
            if (r0 == 0) goto L_0x0431
            r2.put(r1, r3)
            goto L_0x0440
        L_0x0431:
            java.lang.Float r0 = com.apm.insight.l.r.a((java.util.Map<? super java.lang.String, java.lang.Float>) r26)
            float r0 = r0.floatValue()
            java.lang.String r0 = b((float) r0)
            r2.put(r1, r0)
        L_0x0440:
            boolean r0 = r25.isEmpty()
            java.lang.String r1 = "npth_anr_dex2oat_total"
            if (r0 == 0) goto L_0x044c
            r2.put(r1, r3)
            goto L_0x045b
        L_0x044c:
            java.lang.Float r0 = com.apm.insight.l.r.a((java.util.Map<? super java.lang.String, java.lang.Float>) r25)
            float r0 = r0.floatValue()
            java.lang.String r0 = b((float) r0)
            r2.put(r1, r0)
        L_0x045b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(java.lang.String, org.json.JSONObject):void");
    }

    private static void a(HashMap<String, Float> hashMap, JSONObject jSONObject, String str) {
        String str2;
        String a2;
        String str3 = "npth_anr_" + str;
        if (hashMap.isEmpty()) {
            str2 = str3 + "_total";
            a2 = "not found";
        } else {
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            for (Map.Entry next : hashMap.entrySet()) {
                String str4 = (String) next.getKey();
                if (str4.endsWith("user")) {
                    f2 += ((Float) next.getValue()).floatValue();
                } else if (str4.endsWith("kernel")) {
                    f3 += ((Float) next.getValue()).floatValue();
                } else if (str4.endsWith("iowait")) {
                    f4 += ((Float) next.getValue()).floatValue();
                } else if (str4.endsWith("irq")) {
                    f5 += ((Float) next.getValue()).floatValue();
                } else if (str4.endsWith("softirq")) {
                    f6 += ((Float) next.getValue()).floatValue();
                }
            }
            float f7 = f2 + f3 + f4 + f5 + f6;
            jSONObject.put(str3 + "_total", b(f7));
            jSONObject.put(str3 + "_kernel_user_ratio", a(f3, f7));
            str2 = str3 + "_iowait_user_ratio";
            a2 = a(f4, f7);
        }
        jSONObject.put(str2, a2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0190, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x01ac;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONArray r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            if (r2 != 0) goto L_0x0007
            return
        L_0x0007:
            r3 = 0
            r1.j = r3
            r1.q = r3
            r4 = 0
            r1.r = r4
            org.json.JSONArray r5 = new org.json.JSONArray
            r5.<init>()
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>()
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.String r7 = "unknown"
            r1.l = r7
            r1.m = r7
            r1.n = r7
            r7 = 3
            int[] r7 = new int[r7]
            r7 = {0, 0, 0} // fill-array
            r8 = r0
            r0 = r3
            r9 = 0
            r10 = 0
        L_0x0030:
            int r11 = r17.length()
            if (r9 >= r11) goto L_0x01b4
            java.lang.String r11 = r2.optString(r9)
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            java.lang.String r13 = "NPTH_CATCH"
            r14 = 40
            java.lang.String r15 = "main"
            r3 = 1
            if (r12 == 0) goto L_0x00c8
            int r11 = r8.length()
            if (r11 <= 0) goto L_0x00b9
            boolean r11 = android.text.TextUtils.isEmpty(r0)
            if (r11 != 0) goto L_0x00b9
            org.json.JSONObject r11 = r1.j
            if (r11 != 0) goto L_0x0064
            boolean r11 = r15.equals(r0)
            if (r11 == 0) goto L_0x0064
            org.json.JSONObject r11 = r1.c((org.json.JSONArray) r8)
            r1.j = r11
            goto L_0x006b
        L_0x0064:
            org.json.JSONObject r11 = r1.a((java.lang.String) r0, (org.json.JSONArray) r8)
            r5.put(r11)
        L_0x006b:
            boolean r11 = r15.equals(r0)     // Catch:{ all -> 0x007e }
            if (r11 != 0) goto L_0x007f
            int r11 = r0.indexOf(r14)     // Catch:{ all -> 0x007e }
            java.lang.String r11 = r0.substring(r4, r11)     // Catch:{ all -> 0x007e }
            java.lang.String r0 = r11.trim()     // Catch:{ all -> 0x007e }
            goto L_0x007f
        L_0x007e:
        L_0x007f:
            r11 = r0
            boolean r0 = r1.a((java.lang.String) r11)
            if (r0 != 0) goto L_0x00b9
            int[] r0 = r1.b((org.json.JSONArray) r8)     // Catch:{ IllegalArgumentException -> 0x008d, all -> 0x008b }
            goto L_0x0097
        L_0x008b:
            goto L_0x0096
        L_0x008d:
            r0 = move-exception
            r12 = r0
            com.apm.insight.d r0 = com.apm.insight.c.a()
            r0.a((java.lang.String) r13, (java.lang.Throwable) r12)
        L_0x0096:
            r0 = 0
        L_0x0097:
            if (r0 != 0) goto L_0x009a
            goto L_0x00b9
        L_0x009a:
            r12 = r0[r4]
            r13 = r7[r4]
            if (r12 <= r13) goto L_0x00a4
            r7[r4] = r12
            r1.l = r11
        L_0x00a4:
            r12 = r0[r3]
            r13 = r7[r3]
            if (r12 <= r13) goto L_0x00ae
            r7[r3] = r12
            r1.m = r11
        L_0x00ae:
            r3 = 2
            r0 = r0[r3]
            r12 = r7[r3]
            if (r0 <= r12) goto L_0x00b9
            r7[r3] = r0
            r1.n = r11
        L_0x00b9:
            int r0 = r8.length()
            if (r0 <= 0) goto L_0x00c5
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r8 = r0
        L_0x00c5:
            r0 = 0
            goto L_0x01af
        L_0x00c8:
            if (r10 == 0) goto L_0x0193
            if (r10 == r3) goto L_0x00ce
            goto L_0x01af
        L_0x00ce:
            java.lang.String r12 = " prio="
            boolean r12 = r11.contains(r12)
            if (r12 == 0) goto L_0x018c
            int r12 = r8.length()
            if (r12 <= 0) goto L_0x0148
            boolean r12 = android.text.TextUtils.isEmpty(r0)
            if (r12 != 0) goto L_0x0148
            org.json.JSONObject r12 = r1.j
            if (r12 != 0) goto L_0x00f3
            boolean r12 = r15.equals(r0)
            if (r12 == 0) goto L_0x00f3
            org.json.JSONObject r12 = r1.c((org.json.JSONArray) r8)
            r1.j = r12
            goto L_0x00fa
        L_0x00f3:
            org.json.JSONObject r12 = r1.a((java.lang.String) r0, (org.json.JSONArray) r8)
            r5.put(r12)
        L_0x00fa:
            boolean r12 = r15.equals(r0)     // Catch:{ all -> 0x010d }
            if (r12 != 0) goto L_0x010e
            int r12 = r0.indexOf(r14)     // Catch:{ all -> 0x010d }
            java.lang.String r12 = r0.substring(r4, r12)     // Catch:{ all -> 0x010d }
            java.lang.String r0 = r12.trim()     // Catch:{ all -> 0x010d }
            goto L_0x010e
        L_0x010d:
        L_0x010e:
            r12 = r0
            boolean r0 = r1.a((java.lang.String) r12)
            if (r0 != 0) goto L_0x0148
            int[] r0 = r1.b((org.json.JSONArray) r8)     // Catch:{ IllegalArgumentException -> 0x011c, all -> 0x011a }
            goto L_0x0126
        L_0x011a:
            goto L_0x0125
        L_0x011c:
            r0 = move-exception
            r14 = r0
            com.apm.insight.d r0 = com.apm.insight.c.a()
            r0.a((java.lang.String) r13, (java.lang.Throwable) r14)
        L_0x0125:
            r0 = 0
        L_0x0126:
            if (r0 != 0) goto L_0x0129
            goto L_0x0148
        L_0x0129:
            r13 = r0[r4]
            r14 = r7[r4]
            if (r13 <= r14) goto L_0x0133
            r7[r4] = r13
            r1.l = r12
        L_0x0133:
            r13 = r0[r3]
            r14 = r7[r3]
            if (r13 <= r14) goto L_0x013d
            r7[r3] = r13
            r1.m = r12
        L_0x013d:
            r13 = 2
            r0 = r0[r13]
            r14 = r7[r13]
            if (r0 <= r14) goto L_0x0148
            r7[r13] = r0
            r1.n = r12
        L_0x0148:
            r0 = 34
            int r12 = r11.indexOf(r0, r3)
            java.lang.String r12 = r11.substring(r3, r12)
            boolean r13 = r15.equals(r12)
            if (r13 != 0) goto L_0x017c
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r12)
            java.lang.String r12 = "  ("
            r13.append(r12)
            r12 = 2
            int r0 = r11.indexOf(r0, r12)
            int r0 = r0 + r3
            java.lang.String r0 = r11.substring(r0)
            r13.append(r0)
            java.lang.String r0 = " )"
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            goto L_0x017d
        L_0x017c:
            r0 = r12
        L_0x017d:
            int r3 = r8.length()
            if (r3 <= 0) goto L_0x0188
            org.json.JSONArray r8 = new org.json.JSONArray
            r8.<init>()
        L_0x0188:
            r8.put(r11)
            goto L_0x01af
        L_0x018c:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0188
            goto L_0x01ac
        L_0x0193:
            java.lang.String r12 = "DALVIK THREADS"
            boolean r12 = r11.startsWith(r12)
            if (r12 != 0) goto L_0x01ab
            java.lang.String r12 = "suspend"
            boolean r12 = r11.startsWith(r12)
            if (r12 != 0) goto L_0x01ab
            java.lang.String r12 = "\""
            boolean r12 = r11.startsWith(r12)
            if (r12 == 0) goto L_0x01ac
        L_0x01ab:
            r10 = 1
        L_0x01ac:
            r6.put(r11)
        L_0x01af:
            int r9 = r9 + 1
            r3 = 0
            goto L_0x0030
        L_0x01b4:
            int r0 = r5.length()
            if (r0 <= 0) goto L_0x01d8
            r1.p = r6
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01d4 }
            r0.<init>()     // Catch:{ JSONException -> 0x01d4 }
            r1.q = r0     // Catch:{ JSONException -> 0x01d4 }
            java.lang.String r2 = "thread_all_count"
            int r3 = r5.length()     // Catch:{ JSONException -> 0x01d4 }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x01d4 }
            org.json.JSONObject r0 = r1.q     // Catch:{ JSONException -> 0x01d4 }
            java.lang.String r2 = "thread_stacks"
            r0.put(r2, r5)     // Catch:{ JSONException -> 0x01d4 }
            goto L_0x01d8
        L_0x01d4:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(org.json.JSONArray):void");
    }

    private boolean a(long j2) {
        if (this.y) {
            this.y = false;
            b(j2);
        }
        return false;
    }

    private boolean a(String str) {
        if (this.D == null) {
            JSONArray c2 = a.c();
            if (c2 != null) {
                this.D = new LinkedList();
                this.o = c2.optString(0);
                for (int i2 = 1; i2 < c2.length(); i2++) {
                    try {
                        this.D.add(Pattern.compile(c2.optString(i2)));
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.D == null) {
                LinkedList linkedList = new LinkedList();
                this.D = linkedList;
                linkedList.add(Pattern.compile("^main$"));
                this.D.add(Pattern.compile("^default_npth_thread$"));
                this.D.add(Pattern.compile("^RenderThread$"));
                this.D.add(Pattern.compile("^Jit thread pool worker thread.*$"));
            }
        }
        for (Pattern matcher : this.D) {
            if (matcher.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private static String b(float f2) {
        return a(f2 / 100.0f);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:2|3|(1:5)(1:6)|7|8|9|(3:11|12|13)|17|(1:20)|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00db, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        com.apm.insight.c.a().a("NPTH_CATCH", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ee, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ef, code lost:
        com.apm.insight.c.a().a("NPTH_CATCH", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0063 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0067 A[Catch:{ IOException -> 0x00e3, all -> 0x00db, all -> 0x00ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00e7 A[Catch:{ IOException -> 0x00e3, all -> 0x00db, all -> 0x00ee }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(long r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            java.lang.String r0 = "trace_"
            java.lang.String r4 = "trace"
            long r5 = r1.A
            long r7 = r1.z
            java.lang.String r9 = "anr_trace"
            java.lang.String r10 = "\n"
            java.lang.String r11 = ".txt"
            r12 = 95
            r13 = 58
            r14 = 21
            r16 = 1
            java.lang.String r15 = "NPTH_CATCH"
            int r17 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r17 == 0) goto L_0x00fb
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0063 }
            r1.s = r4     // Catch:{ all -> 0x0063 }
            com.apm.insight.b.h r4 = com.apm.insight.b.g.b()     // Catch:{ all -> 0x0063 }
            org.json.JSONArray r4 = r4.c()     // Catch:{ all -> 0x0063 }
            r1.u = r4     // Catch:{ all -> 0x0063 }
            r4 = 100
            org.json.JSONArray r4 = com.apm.insight.b.k.a((int) r4, (long) r2)     // Catch:{ all -> 0x0063 }
            r1.t = r4     // Catch:{ all -> 0x0063 }
            com.apm.insight.b.h r4 = com.apm.insight.b.g.b()     // Catch:{ all -> 0x0063 }
            com.apm.insight.b.h$e r2 = r4.a((long) r2)     // Catch:{ all -> 0x0063 }
            org.json.JSONObject r2 = r2.a()     // Catch:{ all -> 0x0063 }
            r1.k = r2     // Catch:{ all -> 0x0063 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0063 }
            r2.<init>()     // Catch:{ all -> 0x0063 }
            r1.v = r2     // Catch:{ all -> 0x0063 }
            android.content.Context r3 = r1.d     // Catch:{ all -> 0x0063 }
            com.apm.insight.l.a.a((android.content.Context) r3, (org.json.JSONObject) r2)     // Catch:{ all -> 0x0063 }
            boolean r2 = r18.g()     // Catch:{ all -> 0x0063 }
            r1.w = r2     // Catch:{ all -> 0x0063 }
            boolean r2 = com.apm.insight.Npth.hasCrash()     // Catch:{ all -> 0x0063 }
            if (r2 != 0) goto L_0x0060
            r2 = 1
            goto L_0x0061
        L_0x0060:
            r2 = 0
        L_0x0061:
            r1.i = r2     // Catch:{ all -> 0x0063 }
        L_0x0063:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00ee }
            if (r2 < r14) goto L_0x00e3
            long r2 = r1.s     // Catch:{ all -> 0x00ee }
            r1.g = r2     // Catch:{ all -> 0x00ee }
            java.lang.String r2 = com.apm.insight.l.o.b()     // Catch:{ all -> 0x00ee }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x00ee }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00ee }
            android.content.Context r5 = r1.d     // Catch:{ all -> 0x00ee }
            java.io.File r5 = com.apm.insight.l.o.f((android.content.Context) r5)     // Catch:{ all -> 0x00ee }
            r4.<init>(r5, r2)     // Catch:{ all -> 0x00ee }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r5.<init>(r0)     // Catch:{ all -> 0x00ee }
            android.content.Context r0 = r1.d     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = com.apm.insight.l.a.c(r0)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = r0.replace(r13, r12)     // Catch:{ all -> 0x00ee }
            r5.append(r0)     // Catch:{ all -> 0x00ee }
            r5.append(r11)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00ee }
            r3.<init>(r4, r0)     // Catch:{ all -> 0x00ee }
            java.io.File r0 = r3.getParentFile()     // Catch:{ all -> 0x00ee }
            r0.mkdirs()     // Catch:{ all -> 0x00ee }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r0.<init>()     // Catch:{ all -> 0x00ee }
            java.text.DateFormat r4 = com.apm.insight.l.b.a()     // Catch:{ all -> 0x00ee }
            java.util.Date r5 = new java.util.Date     // Catch:{ all -> 0x00ee }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ee }
            r5.<init>(r6)     // Catch:{ all -> 0x00ee }
            java.lang.String r4 = r4.format(r5)     // Catch:{ all -> 0x00ee }
            r0.append(r4)     // Catch:{ all -> 0x00ee }
            r0.append(r10)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ee }
            r4 = 0
            com.apm.insight.l.i.a((java.io.File) r3, (java.lang.String) r0, (boolean) r4)     // Catch:{ all -> 0x00ee }
            com.apm.insight.runtime.r.a((java.lang.String) r9, (java.lang.String) r2)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = r3.getAbsolutePath()     // Catch:{ all -> 0x00ee }
            com.apm.insight.nativecrash.NativeImpl.i(r0)     // Catch:{ all -> 0x00ee }
            java.lang.String r0 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x00e3, all -> 0x00db }
            org.json.JSONArray r0 = com.apm.insight.l.i.b((java.lang.String) r0)     // Catch:{ IOException -> 0x00e3, all -> 0x00db }
            r1.p = r0     // Catch:{ IOException -> 0x00e3, all -> 0x00db }
            r1.a((org.json.JSONArray) r0)     // Catch:{ IOException -> 0x00e3, all -> 0x00db }
            goto L_0x00e3
        L_0x00db:
            r0 = move-exception
            com.apm.insight.d r2 = com.apm.insight.c.a()     // Catch:{ all -> 0x00ee }
            r2.a((java.lang.String) r15, (java.lang.Throwable) r0)     // Catch:{ all -> 0x00ee }
        L_0x00e3:
            org.json.JSONObject r0 = r1.j     // Catch:{ all -> 0x00ee }
            if (r0 != 0) goto L_0x00f6
            org.json.JSONObject r0 = com.apm.insight.b.d.a((boolean) r16)     // Catch:{ all -> 0x00ee }
            r1.j = r0     // Catch:{ all -> 0x00ee }
            goto L_0x00f6
        L_0x00ee:
            r0 = move-exception
            com.apm.insight.d r2 = com.apm.insight.c.a()
            r2.a((java.lang.String) r15, (java.lang.Throwable) r0)
        L_0x00f6:
            com.apm.insight.l.f.a()
            goto L_0x018e
        L_0x00fb:
            long r2 = r1.s     // Catch:{ all -> 0x0186 }
            r1.g = r2     // Catch:{ all -> 0x0186 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0186 }
            if (r0 < r14) goto L_0x017b
            java.lang.String r0 = com.apm.insight.l.o.b()     // Catch:{ all -> 0x0186 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0186 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0186 }
            android.content.Context r5 = r1.d     // Catch:{ all -> 0x0186 }
            java.io.File r5 = com.apm.insight.l.o.f((android.content.Context) r5)     // Catch:{ all -> 0x0186 }
            r3.<init>(r5, r0)     // Catch:{ all -> 0x0186 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0186 }
            r5.<init>(r4)     // Catch:{ all -> 0x0186 }
            android.content.Context r4 = r1.d     // Catch:{ all -> 0x0186 }
            java.lang.String r4 = com.apm.insight.l.a.c(r4)     // Catch:{ all -> 0x0186 }
            java.lang.String r4 = r4.replace(r13, r12)     // Catch:{ all -> 0x0186 }
            r5.append(r4)     // Catch:{ all -> 0x0186 }
            r5.append(r11)     // Catch:{ all -> 0x0186 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0186 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0186 }
            java.io.File r3 = r2.getParentFile()     // Catch:{ all -> 0x0186 }
            r3.mkdirs()     // Catch:{ all -> 0x0186 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0186 }
            r3.<init>()     // Catch:{ all -> 0x0186 }
            java.text.DateFormat r4 = com.apm.insight.l.b.a()     // Catch:{ all -> 0x0186 }
            java.util.Date r5 = new java.util.Date     // Catch:{ all -> 0x0186 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0186 }
            r5.<init>(r6)     // Catch:{ all -> 0x0186 }
            java.lang.String r4 = r4.format(r5)     // Catch:{ all -> 0x0186 }
            r3.append(r4)     // Catch:{ all -> 0x0186 }
            r3.append(r10)     // Catch:{ all -> 0x0186 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0186 }
            r4 = 0
            com.apm.insight.l.i.a((java.io.File) r2, (java.lang.String) r3, (boolean) r4)     // Catch:{ all -> 0x0186 }
            com.apm.insight.runtime.r.a((java.lang.String) r9, (java.lang.String) r0)     // Catch:{ all -> 0x0186 }
            java.lang.String r0 = r2.getAbsolutePath()     // Catch:{ all -> 0x0186 }
            com.apm.insight.nativecrash.NativeImpl.i(r0)     // Catch:{ all -> 0x0186 }
            java.lang.String r0 = r2.getAbsolutePath()     // Catch:{ IOException -> 0x017b, all -> 0x0173 }
            org.json.JSONArray r0 = com.apm.insight.l.i.b((java.lang.String) r0)     // Catch:{ IOException -> 0x017b, all -> 0x0173 }
            r1.p = r0     // Catch:{ IOException -> 0x017b, all -> 0x0173 }
            r1.a((org.json.JSONArray) r0)     // Catch:{ IOException -> 0x017b, all -> 0x0173 }
            goto L_0x017b
        L_0x0173:
            r0 = move-exception
            com.apm.insight.d r2 = com.apm.insight.c.a()     // Catch:{ all -> 0x0186 }
            r2.a((java.lang.String) r15, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0186 }
        L_0x017b:
            org.json.JSONObject r0 = r1.j     // Catch:{ all -> 0x0186 }
            if (r0 != 0) goto L_0x018e
            org.json.JSONObject r0 = com.apm.insight.b.d.a((boolean) r16)     // Catch:{ all -> 0x0186 }
            r1.j = r0     // Catch:{ all -> 0x0186 }
            goto L_0x018e
        L_0x0186:
            r0 = move-exception
            com.apm.insight.d r2 = com.apm.insight.c.a()
            r2.a((java.lang.String) r15, (java.lang.Throwable) r0)
        L_0x018e:
            long r2 = r1.z
            r1.A = r2
            r4 = -1
            r1.z = r4
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x019f
            r2 = 1
            long r4 = r4 - r2
            r1.A = r4
        L_0x019f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.b(long):void");
    }

    private static void b(String str, JSONArray jSONArray) {
        for (ICrashCallback next : o.a().e()) {
            try {
                if (next instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) next).a(CrashType.ANR, str, (Thread) null, jSONArray);
                } else {
                    next.onCrash(CrashType.ANR, str, (Thread) null);
                }
            } catch (Throwable th) {
                c.a().a("NPTH_CATCH", th);
            }
        }
    }

    private int[] b(JSONArray jSONArray) {
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            String optString = jSONArray.optString(i2);
            int indexOf = (optString == null || optString.isEmpty()) ? -1 : optString.indexOf("utm=");
            if (indexOf > 0) {
                if (this.b == null) {
                    this.b = Pattern.compile("[^0-9]+");
                }
                String[] split = this.b.split(optString.substring(indexOf));
                if (split == null || split.length < 2) {
                    return null;
                }
                try {
                    int intValue = Integer.decode(split[1]).intValue();
                    int intValue2 = Integer.decode(split[2]).intValue();
                    return new int[]{intValue, intValue2, intValue + intValue2};
                } catch (Throwable unused) {
                    throw new IllegalArgumentException("Err stack line: " + optString);
                }
            } else {
                i2++;
            }
        }
        return null;
    }

    private String c(long j2) {
        long j3 = j2 - i.j();
        return j3 < 30000 ? "0 - 30s" : j3 < 60000 ? "30s - 1min" : j3 < 120000 ? "1min - 2min" : j3 < 300000 ? "2min - 5min" : j3 < 600000 ? "5min - 10min" : j3 < 1800000 ? "10min - 30min" : j3 < CCS.a ? "30min - 1h" : "1h - ";
    }

    private JSONObject c(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray a2 = l.a(256, 128, jSONArray);
        if (a2.length() != jSONArray.length()) {
            this.r++;
        }
        try {
            jSONObject.put("thread_number", 1);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < a2.length(); i2++) {
                sb.append(a2.getString(i2));
                sb.append(10);
            }
            jSONObject.put("mainStackFromTrace", sb.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private boolean g() {
        boolean z2 = !com.apm.insight.l.a.a(this.d);
        if (!z2 || com.apm.insight.runtime.a.b.d().e() > 2000) {
            return z2;
        }
        return false;
    }

    private File h() {
        if (this.E == null) {
            File filesDir = this.d.getFilesDir();
            this.E = new File(filesDir, "has_anr_signal_" + com.apm.insight.l.a.c(this.d).replaceAll(CertificateUtil.DELIMITER, "_"));
        }
        return this.E;
    }

    private boolean i() {
        return a.i();
    }

    public void a() {
        if (!this.e) {
            this.c = new c(this);
            this.g = i.j();
            this.e = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:137|(1:139)|140|141|142|(1:144)|145|146|(1:148)|149|151|152) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:145:0x043e */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x03e9 A[SYNTHETIC, Splitter:B:135:0x03e9] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0412 A[Catch:{ all -> 0x048d }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0465 A[Catch:{ all -> 0x0471 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r26, int r27) {
        /*
            r25 = this;
            r1 = r25
            boolean r0 = com.apm.insight.b.f.a()
            long r2 = android.os.SystemClock.uptimeMillis()
            boolean r4 = r1.a((long) r2)
            android.content.Context r5 = r1.d
            r6 = 1
            java.lang.String r5 = com.apm.insight.b.d.a((android.content.Context) r5, (int) r6)
            long r7 = java.lang.System.currentTimeMillis()
            java.lang.String r9 = "normal"
            boolean r10 = android.text.TextUtils.isEmpty(r5)
            r11 = 0
            if (r10 == 0) goto L_0x0026
            if (r4 == 0) goto L_0x0026
            r10 = 1
            goto L_0x0027
        L_0x0026:
            r10 = 0
        L_0x0027:
            java.lang.String r12 = "unknown"
            java.lang.String r13 = "unknown"
            java.lang.String r14 = "unknown"
            r15 = 20000(0x4e20, double:9.8813E-320)
            if (r4 != 0) goto L_0x004a
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 != 0) goto L_0x0038
            goto L_0x004a
        L_0x0038:
            r6 = r14
            r4 = 0
            r11 = 0
            r15 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r14 = r13
            r13 = r12
            r12 = r9
            r9 = 0
            goto L_0x00c1
        L_0x004a:
            java.lang.Object r4 = r1.x
            monitor-enter(r4)
            if (r10 != 0) goto L_0x0051
            r7 = 1
            goto L_0x0052
        L_0x0051:
            r7 = 0
        L_0x0052:
            monitor-exit(r4)     // Catch:{ all -> 0x0498 }
            org.json.JSONObject r4 = r1.j
            if (r4 == 0) goto L_0x006c
            long r12 = java.lang.System.currentTimeMillis()
            r8 = r7
            long r6 = r1.g
            long r12 = r12 - r6
            int r4 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r4 > 0) goto L_0x006d
            if (r10 == 0) goto L_0x0068
            java.lang.String r4 = "trace_only"
            goto L_0x006a
        L_0x0068:
            java.lang.String r4 = "trace_last"
        L_0x006a:
            r9 = r4
            goto L_0x0078
        L_0x006c:
            r8 = r7
        L_0x006d:
            boolean r4 = r1.y
            if (r4 == 0) goto L_0x0075
            r1.y = r11
            java.lang.String r9 = "trace_after"
        L_0x0075:
            r1.b((long) r2)
        L_0x0078:
            org.json.JSONObject r4 = r1.j
            java.lang.String r12 = r1.l
            java.lang.String r13 = r1.m
            java.lang.String r14 = r1.n
            org.json.JSONArray r6 = r1.p
            org.json.JSONArray r7 = r1.u
            org.json.JSONArray r15 = r1.t
            org.json.JSONObject r11 = r1.v
            r19 = r4
            org.json.JSONObject r4 = r1.k
            r20 = r4
            boolean r4 = r1.w
            r21 = r6
            r22 = r7
            long r6 = r1.s
            r23 = r4
            if (r10 != 0) goto L_0x00b4
            r4 = 0
            r1.j = r4
            r1.p = r4
            r1.t = r4
            r1.k = r4
            r1.u = r4
            java.lang.String r4 = "unknown"
            r1.l = r4
            java.lang.String r4 = "unknown"
            r1.m = r4
            java.lang.String r4 = "unknown"
            r1.n = r4
            r4 = 0
            r1.r = r4
        L_0x00b4:
            r4 = r21
            r21 = r22
            r24 = r9
            r9 = r8
            r7 = r6
            r6 = r14
            r14 = r13
            r13 = r12
            r12 = r24
        L_0x00c1:
            if (r10 != 0) goto L_0x0121
            boolean r22 = android.text.TextUtils.isEmpty(r5)
            if (r22 == 0) goto L_0x0121
            org.json.JSONObject r0 = r1.j
            if (r0 == 0) goto L_0x00ff
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r1.g
            long r2 = r2 - r4
            r4 = 20000(0x4e20, double:9.8813E-320)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ff
            r2 = 0
            r1.j = r2
            r1.p = r2
            r1.t = r2
            r1.k = r2
            r1.u = r2
            java.lang.String r0 = "unknown"
            r1.l = r0
            java.lang.String r0 = "unknown"
            r1.m = r0
            java.lang.String r0 = "unknown"
            r1.n = r0
            r2 = 0
            r1.r = r2
            java.io.File r0 = r1.h
            if (r0 == 0) goto L_0x00fb
            com.apm.insight.l.i.a((java.io.File) r0)
        L_0x00fb:
            r3 = 0
            r1.h = r3
            return r2
        L_0x00ff:
            org.json.JSONObject r0 = r1.j
            if (r0 == 0) goto L_0x011f
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r1.g
            long r2 = r2 - r4
            r4 = 2000(0x7d0, double:9.88E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x011f
            boolean r0 = com.apm.insight.nativecrash.NativeImpl.g()
            if (r0 == 0) goto L_0x011d
            java.io.File r0 = r25.h()
            com.apm.insight.l.i.a((java.io.File) r0)
        L_0x011d:
            r2 = 0
            return r2
        L_0x011f:
            r2 = 0
            return r2
        L_0x0121:
            if (r19 != 0) goto L_0x016f
            if (r15 != 0) goto L_0x015a
            com.apm.insight.b.h r17 = com.apm.insight.b.g.b()     // Catch:{ all -> 0x0154 }
            org.json.JSONArray r17 = r17.c()     // Catch:{ all -> 0x0154 }
            r18 = r11
            r11 = 100
            org.json.JSONArray r15 = com.apm.insight.b.k.a((int) r11, (long) r2)     // Catch:{ all -> 0x0150 }
            com.apm.insight.b.h r11 = com.apm.insight.b.g.b()     // Catch:{ all -> 0x0150 }
            com.apm.insight.b.h$e r2 = r11.a((long) r2)     // Catch:{ all -> 0x0150 }
            org.json.JSONObject r20 = r2.a()     // Catch:{ all -> 0x0150 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0150 }
            r2.<init>()     // Catch:{ all -> 0x0150 }
            android.content.Context r3 = r1.d     // Catch:{ all -> 0x014d }
            com.apm.insight.l.a.a((android.content.Context) r3, (org.json.JSONObject) r2)     // Catch:{ all -> 0x014d }
            r11 = r2
            goto L_0x015e
        L_0x014d:
            r11 = r2
            goto L_0x0166
        L_0x0150:
            r11 = r18
            goto L_0x0166
        L_0x0154:
            r18 = r11
            r17 = r21
            goto L_0x0166
        L_0x015a:
            r18 = r11
            r17 = r21
        L_0x015e:
            boolean r2 = a     // Catch:{ all -> 0x0165 }
            org.json.JSONObject r19 = com.apm.insight.b.d.a((boolean) r2)     // Catch:{ all -> 0x0165 }
            goto L_0x0166
        L_0x0165:
        L_0x0166:
            r2 = r17
            r3 = r19
            r17 = r9
            r9 = r20
            goto L_0x0179
        L_0x016f:
            r18 = r11
            r17 = r9
            r3 = r19
            r9 = r20
            r2 = r21
        L_0x0179:
            if (r3 == 0) goto L_0x0497
            int r18 = r3.length()
            if (r18 <= 0) goto L_0x0497
            r18 = r5
            java.lang.String r5 = "pid"
            r19 = r0
            int r0 = android.os.Process.myPid()     // Catch:{ all -> 0x048d }
            r3.put(r5, r0)     // Catch:{ all -> 0x048d }
            java.lang.String r0 = "package"
            android.content.Context r5 = r1.d     // Catch:{ all -> 0x048d }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x048d }
            r3.put(r0, r5)     // Catch:{ all -> 0x048d }
            java.lang.String r0 = "is_remote_process"
            r5 = 0
            r3.put(r0, r5)     // Catch:{ all -> 0x048d }
            java.lang.String r0 = "is_new_stack"
            r5 = 10
            r3.put(r0, r5)     // Catch:{ all -> 0x048d }
            com.apm.insight.entity.a r0 = new com.apm.insight.entity.a     // Catch:{ all -> 0x048d }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x048d }
            r5.<init>()     // Catch:{ all -> 0x048d }
            r0.<init>(r5)     // Catch:{ all -> 0x048d }
            java.lang.String r5 = "data"
            r20 = r6
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x048d }
            r0.a((java.lang.String) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x048d }
            java.lang.String r5 = "is_anr"
            r26 = r3
            r6 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x048d }
            r0.a((java.lang.String) r5, (java.lang.Object) r3)     // Catch:{ all -> 0x048d }
            java.lang.String r3 = "anrType"
            r0.a((java.lang.String) r3, (java.lang.Object) r12)     // Catch:{ all -> 0x048d }
            java.lang.String r3 = "history_message"
            r0.a((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ all -> 0x048d }
            java.lang.String r2 = "current_message"
            r0.a((java.lang.String) r2, (java.lang.Object) r9)     // Catch:{ all -> 0x048d }
            java.lang.String r2 = "pending_messages"
            r0.a((java.lang.String) r2, (java.lang.Object) r15)     // Catch:{ all -> 0x048d }
            java.lang.String r2 = "anr_time"
            long r21 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x048d }
            java.lang.Long r3 = java.lang.Long.valueOf(r21)     // Catch:{ all -> 0x048d }
            r0.a((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x048d }
            java.lang.String r2 = "crash_time"
            java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x048d }
            r0.a((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x048d }
            com.apm.insight.c.b.b()     // Catch:{ all -> 0x048d }
            r0.c((org.json.JSONObject) r11)     // Catch:{ all -> 0x048d }
            java.lang.String r2 = "anr_info"
            if (r10 == 0) goto L_0x01fe
            java.lang.String r3 = "Resons for no ANR_INFO:\n1. User click close button too quickly as soon as the ANR dialog appear.\n2. User close the app since can not stand the carton.\n3. Some OS force stop the process group without any hint dialog.\n\nThe ANR will be upload by the follow ways only:\n1. Receive the ANR signal(SIGQUIT).\n2. The app is forground or was forground last 2s.\n3. Happens in main process.\n4. Process was killed exactly."
            goto L_0x0200
        L_0x01fe:
            r3 = r18
        L_0x0200:
            r0.a((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x048d }
            if (r4 == 0) goto L_0x020a
            java.lang.String r2 = "dump_trace"
            r0.a((java.lang.String) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x048d }
        L_0x020a:
            java.lang.String r2 = "all_thread_stacks"
            if (r10 != 0) goto L_0x021e
            org.json.JSONObject r3 = r1.q     // Catch:{ all -> 0x048d }
            if (r3 == 0) goto L_0x0218
            int r3 = r3.length()     // Catch:{ all -> 0x048d }
            if (r3 != 0) goto L_0x021e
        L_0x0218:
            r3 = 0
            org.json.JSONObject r4 = com.apm.insight.l.v.b((java.lang.String) r3)     // Catch:{ all -> 0x048d }
            goto L_0x0220
        L_0x021e:
            org.json.JSONObject r4 = r1.q     // Catch:{ all -> 0x048d }
        L_0x0220:
            r0.a((java.lang.String) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x048d }
            com.apm.insight.runtime.a.f r2 = com.apm.insight.runtime.a.f.a()     // Catch:{ all -> 0x048d }
            com.apm.insight.CrashType r3 = com.apm.insight.CrashType.ANR     // Catch:{ all -> 0x048d }
            com.apm.insight.entity.a r2 = r2.a((com.apm.insight.CrashType) r3, (com.apm.insight.entity.a) r0)     // Catch:{ all -> 0x048d }
            java.lang.String r0 = "is_background"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r23)     // Catch:{ all -> 0x048d }
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x048d }
            java.lang.String r0 = "logcat"
            java.lang.String r3 = com.apm.insight.i.f()     // Catch:{ all -> 0x048d }
            org.json.JSONArray r3 = com.apm.insight.runtime.k.b(r3)     // Catch:{ all -> 0x048d }
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x048d }
            java.lang.String r0 = "has_dump"
            java.lang.String r3 = "true"
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x048d }
            java.lang.String r0 = "crash_uuid"
            com.apm.insight.CrashType r3 = com.apm.insight.CrashType.ANR     // Catch:{ all -> 0x048d }
            r4 = 0
            java.lang.String r3 = com.apm.insight.i.a(r7, r3, r4, r4)     // Catch:{ all -> 0x048d }
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x048d }
            java.lang.String r0 = "jiffy"
            long r3 = com.apm.insight.runtime.q.a.a()     // Catch:{ all -> 0x048d }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x048d }
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x048d }
            org.json.JSONObject r0 = r2.h()     // Catch:{ all -> 0x048d }
            java.lang.String r3 = "filters"
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch:{ all -> 0x048d }
            org.json.JSONObject r3 = r2.h()     // Catch:{ all -> 0x048d }
            com.apm.insight.entity.d.b(r3)     // Catch:{ all -> 0x048d }
            if (r0 != 0) goto L_0x0284
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0281 }
            r3.<init>()     // Catch:{ all -> 0x0281 }
            java.lang.String r0 = "filters"
            r2.a((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x03e4 }
            goto L_0x0285
        L_0x0281:
            goto L_0x03e6
        L_0x0284:
            r3 = r0
        L_0x0285:
            java.lang.String r0 = "anrType"
            r3.put(r0, r12)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "max_utm_thread"
            r3.put(r0, r13)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "max_stm_thread"
            r3.put(r0, r14)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "max_utm_stm_thread"
            r14 = r20
            r3.put(r0, r14)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "max_utm_thread_version"
            java.lang.String r4 = r1.o     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "crash_length"
            java.lang.String r4 = r1.c((long) r7)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "disable_looper_monitor"
            boolean r4 = com.apm.insight.runtime.a.d()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "npth_force_apm_crash"
            boolean r4 = com.apm.insight.c.b.b()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "sdk_version"
            java.lang.String r4 = "1.3.8.nourl-alpha.18"
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "has_logcat"
            boolean r4 = r2.a()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "memory_leak"
            boolean r4 = r2.f()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "fd_leak"
            boolean r4 = r2.d()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "threads_leak"
            boolean r4 = r2.e()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "is_64_devices"
            boolean r4 = com.apm.insight.entity.Header.a()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "is_64_runtime"
            boolean r4 = com.apm.insight.nativecrash.NativeImpl.e()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "is_x86_devices"
            boolean r4 = com.apm.insight.entity.Header.b()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "has_meminfo_file"
            boolean r4 = r2.g()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "is_root"
            boolean r4 = com.apm.insight.nativecrash.c.m()     // Catch:{ all -> 0x03e4 }
            if (r4 == 0) goto L_0x033f
            java.lang.String r4 = "true"
            goto L_0x0341
        L_0x033f:
            java.lang.String r4 = "false"
        L_0x0341:
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "anr_normal_trace"
            boolean r4 = r1.y     // Catch:{ all -> 0x03e4 }
            if (r4 != 0) goto L_0x034b
            goto L_0x034c
        L_0x034b:
            r6 = 0
        L_0x034c:
            java.lang.String r4 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "anr_no_run"
            java.lang.String r4 = java.lang.String.valueOf(r19)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "crash_after_crash"
            boolean r4 = com.apm.insight.Npth.hasCrash()     // Catch:{ all -> 0x03e4 }
            if (r4 == 0) goto L_0x0367
            java.lang.String r4 = "true"
            goto L_0x0369
        L_0x0367:
            java.lang.String r4 = "false"
        L_0x0369:
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "from_file"
            boolean r4 = com.apm.insight.b.d.a()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "has_dump"
            java.lang.String r4 = "true"
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "from_kill"
            java.lang.String r4 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "last_resume_activity"
            com.apm.insight.runtime.a.b r4 = com.apm.insight.runtime.a.b.d()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = r4.h()     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            int r0 = r1.r     // Catch:{ all -> 0x03e4 }
            if (r0 <= 0) goto L_0x03a3
            java.lang.String r4 = "may_have_stack_overflow"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x03e4 }
            r3.put(r4, r0)     // Catch:{ all -> 0x03e4 }
        L_0x03a3:
            if (r10 != 0) goto L_0x03b7
            r0 = r18
            r1.a((java.lang.String) r0, (org.json.JSONObject) r3)     // Catch:{ all -> 0x03ab }
            goto L_0x03e7
        L_0x03ab:
            r0 = move-exception
            r4 = r0
            com.apm.insight.d r0 = com.apm.insight.c.a()     // Catch:{ all -> 0x03e4 }
            java.lang.String r5 = "NPTH_CATCH"
            r0.a((java.lang.String) r5, (java.lang.Throwable) r4)     // Catch:{ all -> 0x03e4 }
            goto L_0x03e7
        L_0x03b7:
            boolean r0 = r25.i()     // Catch:{ all -> 0x03e4 }
            if (r0 != 0) goto L_0x03e7
            java.lang.String r0 = "aid"
            com.apm.insight.entity.Header r4 = r2.i()     // Catch:{ all -> 0x03e4 }
            org.json.JSONObject r4 = r4.f()     // Catch:{ all -> 0x03e4 }
            java.lang.String r5 = "aid"
            java.lang.Object r4 = r4.opt(r5)     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x03e4 }
            r3.put(r0, r4)     // Catch:{ all -> 0x03e4 }
            com.apm.insight.entity.Header r0 = r2.i()     // Catch:{ all -> 0x03e4 }
            org.json.JSONObject r0 = r0.f()     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = "aid"
            r5 = 2010(0x7da, float:2.817E-42)
            r0.put(r4, r5)     // Catch:{ all -> 0x03e4 }
            goto L_0x03e7
        L_0x03e4:
            r0 = r3
        L_0x03e6:
            r3 = r0
        L_0x03e7:
            if (r10 == 0) goto L_0x0412
            java.lang.String r0 = com.apm.insight.k.e.c()     // Catch:{ all -> 0x048d }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x048d }
            android.content.Context r4 = r1.d     // Catch:{ all -> 0x048d }
            java.io.File r4 = com.apm.insight.l.o.a((android.content.Context) r4)     // Catch:{ all -> 0x048d }
            com.apm.insight.CrashType r5 = com.apm.insight.CrashType.ANR     // Catch:{ all -> 0x048d }
            r6 = 0
            java.lang.String r5 = com.apm.insight.i.a(r7, r5, r6, r6)     // Catch:{ all -> 0x048d }
            r3.<init>(r4, r5)     // Catch:{ all -> 0x048d }
            r1.h = r3     // Catch:{ all -> 0x048d }
            java.lang.String r4 = r3.getName()     // Catch:{ all -> 0x048d }
            org.json.JSONObject r2 = r2.h()     // Catch:{ all -> 0x048d }
            boolean r5 = com.apm.insight.k.e.b()     // Catch:{ all -> 0x048d }
            com.apm.insight.l.i.a(r3, r4, r0, r2, r5)     // Catch:{ all -> 0x048d }
            goto L_0x0497
        L_0x0412:
            java.io.File r0 = r1.h     // Catch:{ all -> 0x048d }
            if (r0 == 0) goto L_0x041c
            com.apm.insight.l.i.a((java.io.File) r0)     // Catch:{ all -> 0x048d }
            r4 = 0
            r1.h = r4     // Catch:{ all -> 0x048d }
        L_0x041c:
            com.apm.insight.a.a r0 = com.apm.insight.a.a.a()     // Catch:{ all -> 0x048d }
            com.apm.insight.CrashType r4 = com.apm.insight.CrashType.ANR     // Catch:{ all -> 0x048d }
            java.lang.String r5 = com.apm.insight.i.e()     // Catch:{ all -> 0x048d }
            r0.a((com.apm.insight.CrashType) r4, (long) r7, (java.lang.String) r5)     // Catch:{ all -> 0x048d }
            java.io.File r0 = com.apm.insight.l.f.f()     // Catch:{ all -> 0x043e }
            long r4 = r0.length()     // Catch:{ all -> 0x043e }
            r9 = 1024(0x400, double:5.06E-321)
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x043e
            java.lang.String r0 = "has_system_traces"
            java.lang.String r4 = "true"
            r2.a((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ all -> 0x043e }
        L_0x043e:
            java.lang.String r0 = com.apm.insight.i.f()     // Catch:{ all -> 0x0471 }
            java.io.File r0 = com.apm.insight.l.o.e((java.lang.String) r0)     // Catch:{ all -> 0x0471 }
            java.lang.String r4 = com.apm.insight.i.f()     // Catch:{ all -> 0x0471 }
            java.io.File r4 = com.apm.insight.l.o.f((java.lang.String) r4)     // Catch:{ all -> 0x0471 }
            org.json.JSONArray r0 = com.apm.insight.nativecrash.d.a(r0, r4)     // Catch:{ all -> 0x0471 }
            java.lang.String r4 = "leak_threads_count"
            int r5 = r0.length()     // Catch:{ all -> 0x0471 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0471 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0471 }
            int r3 = r0.length()     // Catch:{ all -> 0x0471 }
            if (r3 <= 0) goto L_0x0471
            java.lang.String r3 = com.apm.insight.i.f()     // Catch:{ all -> 0x0471 }
            java.io.File r3 = com.apm.insight.l.o.g((java.lang.String) r3)     // Catch:{ all -> 0x0471 }
            r4 = 0
            com.apm.insight.l.i.a((java.io.File) r3, (org.json.JSONArray) r0, (boolean) r4)     // Catch:{ all -> 0x0471 }
        L_0x0471:
            java.lang.String r0 = "mainStackFromTrace"
            r3 = r26
            java.lang.String r0 = r3.optString(r0)     // Catch:{ all -> 0x048d }
            org.json.JSONArray r3 = com.apm.insight.entity.b.a((java.lang.String) r0)     // Catch:{ all -> 0x048d }
            org.json.JSONObject r2 = r2.h()     // Catch:{ all -> 0x048d }
            com.apm.insight.b.b$2 r4 = new com.apm.insight.b.b$2     // Catch:{ all -> 0x048d }
            r4.<init>(r7)     // Catch:{ all -> 0x048d }
            com.apm.insight.entity.b.a((org.json.JSONObject) r2, (org.json.JSONArray) r3, (com.apm.insight.entity.b.a) r4)     // Catch:{ all -> 0x048d }
            b(r0, r3)     // Catch:{ all -> 0x048d }
            goto L_0x0497
        L_0x048d:
            r0 = move-exception
            com.apm.insight.d r2 = com.apm.insight.c.a()
            java.lang.String r3 = "NPTH_CATCH"
            r2.a((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x0497:
            return r17
        L_0x0498:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0498 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.b.b.a(int, int):boolean");
    }

    public void b() {
        if (this.e) {
            this.e = false;
            c cVar = this.c;
            if (cVar != null) {
                cVar.b();
            }
            this.c = null;
        }
    }

    public void c() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        if (!f) {
            synchronized (this.x) {
                if (!f) {
                    this.B.run();
                }
            }
        }
    }

    public void e() {
        if (NativeImpl.g()) {
            try {
                com.apm.insight.l.i.a(h(), String.valueOf(this.C + 1), false);
            } catch (Throwable th) {
                c.a().a("NPTH_CATCH", th);
            }
        }
        this.z = SystemClock.uptimeMillis();
        this.y = true;
    }

    public void f() {
        File h2 = h();
        try {
            int intValue = Integer.decode(com.apm.insight.l.i.c(h2.getAbsolutePath())).intValue();
            this.C = intValue;
            if (intValue >= 2) {
                NativeImpl.a(false);
            } else {
                NativeImpl.a(true);
            }
        } catch (IOException unused) {
            NativeImpl.a(true);
        } catch (Throwable unused2) {
            com.apm.insight.l.i.a(h2);
        }
    }
}
