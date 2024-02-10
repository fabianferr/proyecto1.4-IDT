package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.startapp.sdk.adsbase.remoteconfig.RscMetadata;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public class c7 {
    public final Context a;
    public final i2<RscMetadata> b;
    public RscMetadata c;
    public List<f7> d;
    public List<e7> e;
    public final Map<l1, Pair<Long, SoftReference<JSONObject>>> f = new WeakHashMap();

    public c7(Context context, i2<RscMetadata> i2Var) {
        this.a = context;
        this.b = i2Var;
    }

    public static JSONArray a(e7 e7Var) {
        l1 l1Var = e7Var.a;
        String[] strArr = l1Var.c;
        Object[] objArr = l1Var.e;
        if (strArr.length == objArr.length) {
            int length = strArr.length;
            if (length == 0) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(strArr[i], objArr[i]);
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            } catch (JSONException e2) {
                if (e7Var.a(32)) {
                    i3.a((Throwable) e2);
                }
            }
        } else {
            if (e7Var.a(512)) {
                i3 i3Var = new i3(j3.e);
                i3Var.d = "c690e4ef5365d88b";
                i3Var.e = Arrays.toString(strArr) + ", " + Arrays.toString(objArr);
                i3Var.a();
            }
            return null;
        }
    }

    public final boolean a(int i) {
        RscMetadata a2 = this.b.a();
        if (a2 == null || !a2.d()) {
            a2 = null;
        }
        return (a2 == null || (i & a2.a()) == 0) ? false : true;
    }

    public static boolean a(RscMetadata rscMetadata, int i) {
        return (rscMetadata == null || (rscMetadata.a() & i) == 0) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01a6, code lost:
        r11 = r10.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01ad, code lost:
        if (r11 != null) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01b0, code lost:
        r0 = r11.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01c5, code lost:
        r14 = com.startapp.m1.a(a(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01c8, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01ce, code lost:
        if ((r3.a(r11) & r4) != 0) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01d0, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01d2, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01d3, code lost:
        if (r0 != false) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01d5, code lost:
        com.startapp.i3.a(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01d9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01da, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01e0, code lost:
        if ((r3.a(r11) & r5) != 0) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01e2, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01e4, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01e5, code lost:
        if (r0 != false) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01e7, code lost:
        com.startapp.i3.a(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01ea, code lost:
        r14 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01eb, code lost:
        if (r14 != null) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01ee, code lost:
        r0 = r11.h();
        r12 = r11.d();
        r15 = new java.util.ArrayList(java.lang.Math.min(r8.size(), java.lang.Integer.bitCount(r0)));
        r4 = r8.iterator();
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0210, code lost:
        if (r4.hasNext() != false) goto L_0x0212;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0212, code lost:
        r5 = (com.startapp.f7) r4.next();
        r16 = 1 << r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x021e, code lost:
        if ((r0 & r16) == 0) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0222, code lost:
        if ((r12 & r16) != 0) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0224, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0227, code lost:
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0229, code lost:
        r15.add(new android.util.Pair(r5, java.lang.Boolean.valueOf(r16)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0235, code lost:
        r13 = r13 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x023f, code lost:
        if (r15.size() >= 1) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0241, code lost:
        r2 = null;
        r4 = 4;
        r5 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x024d, code lost:
        if (r11.i() != null) goto L_0x024f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x024f, code lost:
        r16 = r11.i().intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x025a, code lost:
        r16 = 300;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x025e, code lost:
        r17 = r11.g();
        r18 = r11.c();
        r19 = r11.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x026e, code lost:
        if (r11.e() != null) goto L_0x0270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0270, code lost:
        r20 = r11.e().intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x027b, code lost:
        r20 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x027d, code lost:
        r9.add(new com.startapp.e7(r14, r15, r16, r17, r18, r19, r20, r3.a(r11)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x028d, code lost:
        return a(r3, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0292, code lost:
        return a(r3, (java.util.List<com.startapp.f7>) null, (java.util.List<com.startapp.e7>) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0297, code lost:
        return a(r3, (java.util.List<com.startapp.f7>) null, (java.util.List<com.startapp.e7>) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        r0 = r3.c();
        r4 = 4;
        r5 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        if (r0 == null) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        if (r0.length() >= 1) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0 = com.startapp.m4.a(new android.util.JsonReader(new java.io.StringReader(a(r0))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004f, code lost:
        r8 = new java.util.ArrayList();
        r0 = ((java.util.ArrayList) r0).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        if (r0.hasNext() == false) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
        r9 = r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if ((r9 instanceof java.util.Map) != false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        r9 = new com.startapp.f7();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006f, code lost:
        r9 = (java.util.Map) r9;
        r10 = r9.get("type");
        r9 = r9.get(com.facebook.internal.NativeProtocol.WEB_DIALOG_PARAMS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0080, code lost:
        if ((r10 instanceof java.lang.Number) == false) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0082, code lost:
        r10 = ((java.lang.Number) r10).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0088, code lost:
        if (r10 == 1) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        if (r10 == 2) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008d, code lost:
        if (r10 == 3) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008f, code lost:
        if (r10 == 4) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0095, code lost:
        if ((r9 instanceof java.util.List) == false) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0097, code lost:
        r9 = (java.util.List) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009d, code lost:
        if (r9.size() <= 0) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009f, code lost:
        r10 = com.startapp.j3.a(java.lang.String.valueOf(r9.get(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ab, code lost:
        if (r10 == null) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b1, code lost:
        if (r9.size() <= 1) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b3, code lost:
        r9 = java.lang.String.valueOf(r9.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bc, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bd, code lost:
        r9 = new com.startapp.y6(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c7, code lost:
        if ((r9 instanceof java.util.Map) == false) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c9, code lost:
        r9 = (java.util.Map) r9;
        r10 = r9.get(com.facebook.internal.NativeProtocol.WEB_DIALOG_ACTION);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d3, code lost:
        if ((r10 instanceof java.lang.String) == false) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d5, code lost:
        r9 = r9.get(com.facebook.bolts.AppLinks.KEY_NAME_EXTRAS);
        r11 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e2, code lost:
        if ((r9 instanceof java.util.Map) == false) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e4, code lost:
        r9 = ((java.util.Map) r9).entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f2, code lost:
        if (r9.hasNext() == false) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f4, code lost:
        r12 = (java.util.Map.Entry) r9.next();
        r13 = r12.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0100, code lost:
        if ((r13 instanceof java.lang.String) == false) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0102, code lost:
        r11.put((java.lang.String) r13, java.lang.String.valueOf(r12.getValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0110, code lost:
        r9 = new com.startapp.x6((java.lang.String) r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011a, code lost:
        if ((r9 instanceof java.util.List) == false) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011c, code lost:
        r10 = new java.util.LinkedList();
        r9 = ((java.util.List) r9).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012b, code lost:
        if (r9.hasNext() == false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012d, code lost:
        r11 = r9.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0133, code lost:
        if ((r11 instanceof java.lang.String) == false) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0135, code lost:
        r11 = com.startapp.j3.a((java.lang.String) r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x013b, code lost:
        if (r11 == null) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x013d, code lost:
        r10.add(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0145, code lost:
        if (r10.size() <= 0) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0147, code lost:
        r9 = new com.startapp.z6(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x014f, code lost:
        if ((r9 instanceof java.lang.Number) == false) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0151, code lost:
        r9 = new com.startapp.w6(((java.lang.Number) r9).intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x015e, code lost:
        r9 = new com.startapp.f7();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0163, code lost:
        r8.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0168, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x016d, code lost:
        if (a(r3, 1) != false) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x016f, code lost:
        com.startapp.i3.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0173, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0174, code lost:
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0179, code lost:
        if (a(r3, 1) != false) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x017b, code lost:
        com.startapp.i3.a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x017e, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x017f, code lost:
        if (r8 == null) goto L_0x0293;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0189, code lost:
        r0 = r3.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x018d, code lost:
        if (r0 == null) goto L_0x028e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0197, code lost:
        r9 = new java.util.LinkedList();
        r10 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01a4, code lost:
        if (r10.hasNext() != false) goto L_0x01a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x01a0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.startapp.e7> a() {
        /*
            r22 = this;
            r1 = r22
            com.startapp.i2<com.startapp.sdk.adsbase.remoteconfig.RscMetadata> r0 = r1.b
            java.lang.Object r0 = r0.a()
            com.startapp.sdk.adsbase.remoteconfig.RscMetadata r0 = (com.startapp.sdk.adsbase.remoteconfig.RscMetadata) r0
            r2 = 0
            if (r0 == 0) goto L_0x0015
            boolean r3 = r0.d()
            if (r3 == 0) goto L_0x0015
            r3 = r0
            goto L_0x0016
        L_0x0015:
            r3 = r2
        L_0x0016:
            if (r3 != 0) goto L_0x001d
            java.util.List r0 = r1.a(r2, r2, r2)
            return r0
        L_0x001d:
            monitor-enter(r22)
            com.startapp.sdk.adsbase.remoteconfig.RscMetadata r0 = r1.c     // Catch:{ all -> 0x0298 }
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0298 }
            if (r0 == 0) goto L_0x002a
            java.util.List<com.startapp.e7> r0 = r1.e     // Catch:{ all -> 0x0298 }
            monitor-exit(r22)     // Catch:{ all -> 0x0298 }
            return r0
        L_0x002a:
            monitor-exit(r22)     // Catch:{ all -> 0x0298 }
            java.lang.String r0 = r3.c()
            r4 = 4
            r5 = 2
            r6 = 0
            r7 = 1
            if (r0 == 0) goto L_0x017e
            int r8 = r0.length()
            if (r8 >= r7) goto L_0x003d
            goto L_0x017e
        L_0x003d:
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x0173 }
            android.util.JsonReader r8 = new android.util.JsonReader     // Catch:{ all -> 0x0168 }
            java.io.StringReader r9 = new java.io.StringReader     // Catch:{ all -> 0x0168 }
            r9.<init>(r0)     // Catch:{ all -> 0x0168 }
            r8.<init>(r9)     // Catch:{ all -> 0x0168 }
            java.util.List r0 = com.startapp.m4.a(r8)     // Catch:{ all -> 0x0168 }
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x005a:
            boolean r9 = r0.hasNext()
            if (r9 == 0) goto L_0x017f
            java.lang.Object r9 = r0.next()
            boolean r10 = r9 instanceof java.util.Map
            if (r10 != 0) goto L_0x006f
            com.startapp.f7 r9 = new com.startapp.f7
            r9.<init>()
            goto L_0x0163
        L_0x006f:
            java.util.Map r9 = (java.util.Map) r9
            java.lang.String r10 = "type"
            java.lang.Object r10 = r9.get(r10)
            java.lang.String r11 = "params"
            java.lang.Object r9 = r9.get(r11)
            boolean r11 = r10 instanceof java.lang.Number
            if (r11 == 0) goto L_0x015e
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            if (r10 == r7) goto L_0x014d
            if (r10 == r5) goto L_0x0118
            r11 = 3
            if (r10 == r11) goto L_0x00c5
            if (r10 == r4) goto L_0x0093
            goto L_0x015e
        L_0x0093:
            boolean r10 = r9 instanceof java.util.List
            if (r10 == 0) goto L_0x015e
            java.util.List r9 = (java.util.List) r9
            int r10 = r9.size()
            if (r10 <= 0) goto L_0x015e
            java.lang.Object r10 = r9.get(r6)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            com.startapp.j3 r10 = com.startapp.j3.a(r10)
            if (r10 == 0) goto L_0x015e
            int r11 = r9.size()
            if (r11 <= r7) goto L_0x00bc
            java.lang.Object r9 = r9.get(r7)
            java.lang.String r9 = java.lang.String.valueOf(r9)
            goto L_0x00bd
        L_0x00bc:
            r9 = r2
        L_0x00bd:
            com.startapp.y6 r11 = new com.startapp.y6
            r11.<init>(r10, r9)
            r9 = r11
            goto L_0x0163
        L_0x00c5:
            boolean r10 = r9 instanceof java.util.Map
            if (r10 == 0) goto L_0x015e
            java.util.Map r9 = (java.util.Map) r9
            java.lang.String r10 = "action"
            java.lang.Object r10 = r9.get(r10)
            boolean r11 = r10 instanceof java.lang.String
            if (r11 == 0) goto L_0x015e
            java.lang.String r11 = "extras"
            java.lang.Object r9 = r9.get(r11)
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            boolean r12 = r9 instanceof java.util.Map
            if (r12 == 0) goto L_0x0110
            java.util.Map r9 = (java.util.Map) r9
            java.util.Set r9 = r9.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x00ee:
            boolean r12 = r9.hasNext()
            if (r12 == 0) goto L_0x0110
            java.lang.Object r12 = r9.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r13 = r12.getKey()
            boolean r14 = r13 instanceof java.lang.String
            if (r14 == 0) goto L_0x00ee
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r12 = r12.getValue()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r11.put(r13, r12)
            goto L_0x00ee
        L_0x0110:
            com.startapp.x6 r9 = new com.startapp.x6
            java.lang.String r10 = (java.lang.String) r10
            r9.<init>(r10, r11)
            goto L_0x0163
        L_0x0118:
            boolean r10 = r9 instanceof java.util.List
            if (r10 == 0) goto L_0x015e
            java.util.LinkedList r10 = new java.util.LinkedList
            r10.<init>()
            java.util.List r9 = (java.util.List) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0127:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0141
            java.lang.Object r11 = r9.next()
            boolean r12 = r11 instanceof java.lang.String
            if (r12 == 0) goto L_0x0127
            java.lang.String r11 = (java.lang.String) r11
            com.startapp.j3 r11 = com.startapp.j3.a(r11)
            if (r11 == 0) goto L_0x0127
            r10.add(r11)
            goto L_0x0127
        L_0x0141:
            int r9 = r10.size()
            if (r9 <= 0) goto L_0x015e
            com.startapp.z6 r9 = new com.startapp.z6
            r9.<init>(r10)
            goto L_0x0163
        L_0x014d:
            boolean r10 = r9 instanceof java.lang.Number
            if (r10 == 0) goto L_0x015e
            com.startapp.w6 r10 = new com.startapp.w6
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r10.<init>(r9)
            r9 = r10
            goto L_0x0163
        L_0x015e:
            com.startapp.f7 r9 = new com.startapp.f7
            r9.<init>()
        L_0x0163:
            r8.add(r9)
            goto L_0x005a
        L_0x0168:
            r0 = move-exception
            boolean r8 = a(r3, r7)
            if (r8 == 0) goto L_0x017e
            com.startapp.i3.a((java.lang.Throwable) r0)
            goto L_0x017e
        L_0x0173:
            r0 = move-exception
            r8 = r0
            boolean r0 = a(r3, r7)
            if (r0 == 0) goto L_0x017e
            com.startapp.i3.a((java.lang.Throwable) r8)
        L_0x017e:
            r8 = r2
        L_0x017f:
            if (r8 == 0) goto L_0x0293
            int r0 = r8.size()
            if (r0 >= r7) goto L_0x0189
            goto L_0x0293
        L_0x0189:
            java.util.List r0 = r3.b()
            if (r0 == 0) goto L_0x028e
            int r9 = r0.size()
            if (r9 >= r7) goto L_0x0197
            goto L_0x028e
        L_0x0197:
            java.util.LinkedList r9 = new java.util.LinkedList
            r9.<init>()
            java.util.Iterator r10 = r0.iterator()
        L_0x01a0:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0289
            java.lang.Object r0 = r10.next()
            r11 = r0
            com.startapp.sdk.adsbase.remoteconfig.RscMetadataItem r11 = (com.startapp.sdk.adsbase.remoteconfig.RscMetadataItem) r11
            if (r11 != 0) goto L_0x01b0
            goto L_0x01a0
        L_0x01b0:
            java.lang.String r0 = r11.a()
            if (r0 == 0) goto L_0x01ea
            int r12 = r0.length()
            if (r12 >= r7) goto L_0x01bd
            goto L_0x01ea
        L_0x01bd:
            java.lang.String r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x01d9 }
            com.startapp.l1 r0 = com.startapp.m1.a(r0)     // Catch:{ all -> 0x01c7 }
            r14 = r0
            goto L_0x01eb
        L_0x01c7:
            r0 = move-exception
            r12 = r0
            int r0 = r3.a(r11)
            r0 = r0 & r4
            if (r0 == 0) goto L_0x01d2
            r0 = 1
            goto L_0x01d3
        L_0x01d2:
            r0 = 0
        L_0x01d3:
            if (r0 == 0) goto L_0x01ea
            com.startapp.i3.a((java.lang.Throwable) r12)
            goto L_0x01ea
        L_0x01d9:
            r0 = move-exception
            r12 = r0
            int r0 = r3.a(r11)
            r0 = r0 & r5
            if (r0 == 0) goto L_0x01e4
            r0 = 1
            goto L_0x01e5
        L_0x01e4:
            r0 = 0
        L_0x01e5:
            if (r0 == 0) goto L_0x01ea
            com.startapp.i3.a((java.lang.Throwable) r12)
        L_0x01ea:
            r14 = r2
        L_0x01eb:
            if (r14 != 0) goto L_0x01ee
            goto L_0x01a0
        L_0x01ee:
            int r0 = r11.h()
            int r12 = r11.d()
            java.util.ArrayList r15 = new java.util.ArrayList
            int r13 = r8.size()
            int r4 = java.lang.Integer.bitCount(r0)
            int r4 = java.lang.Math.min(r13, r4)
            r15.<init>(r4)
            java.util.Iterator r4 = r8.iterator()
            r13 = 0
        L_0x020c:
            boolean r16 = r4.hasNext()
            if (r16 == 0) goto L_0x023b
            java.lang.Object r16 = r4.next()
            r5 = r16
            com.startapp.f7 r5 = (com.startapp.f7) r5
            int r16 = r7 << r13
            r17 = r0 & r16
            if (r17 == 0) goto L_0x0235
            r16 = r12 & r16
            if (r16 == 0) goto L_0x0227
            r16 = 1
            goto L_0x0229
        L_0x0227:
            r16 = 0
        L_0x0229:
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r16)
            r6.<init>(r5, r2)
            r15.add(r6)
        L_0x0235:
            int r13 = r13 + 1
            r2 = 0
            r5 = 2
            r6 = 0
            goto L_0x020c
        L_0x023b:
            int r0 = r15.size()
            if (r0 >= r7) goto L_0x0247
        L_0x0241:
            r2 = 0
            r4 = 4
            r5 = 2
            r6 = 0
            goto L_0x01a0
        L_0x0247:
            com.startapp.e7 r0 = new com.startapp.e7
            java.lang.Integer r2 = r11.i()
            if (r2 == 0) goto L_0x025a
            java.lang.Integer r2 = r11.i()
            int r2 = r2.intValue()
            r16 = r2
            goto L_0x025e
        L_0x025a:
            r2 = 300(0x12c, float:4.2E-43)
            r16 = 300(0x12c, float:4.2E-43)
        L_0x025e:
            int[] r17 = r11.g()
            java.lang.Integer r18 = r11.c()
            java.lang.Integer r19 = r11.f()
            java.lang.Integer r2 = r11.e()
            if (r2 == 0) goto L_0x027b
            java.lang.Integer r2 = r11.e()
            int r2 = r2.intValue()
            r20 = r2
            goto L_0x027d
        L_0x027b:
            r20 = 0
        L_0x027d:
            int r21 = r3.a(r11)
            r13 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
            r9.add(r0)
            goto L_0x0241
        L_0x0289:
            java.util.List r0 = r1.a(r3, r8, r9)
            return r0
        L_0x028e:
            java.util.List r0 = r1.a(r3, r2, r2)
            return r0
        L_0x0293:
            java.util.List r0 = r1.a(r3, r2, r2)
            return r0
        L_0x0298:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0298 }
            goto L_0x029c
        L_0x029b:
            throw r0
        L_0x029c:
            goto L_0x029b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.c7.a():java.util.List");
    }

    public final synchronized List<e7> a(RscMetadata rscMetadata, List<f7> list, List<e7> list2) {
        List<f7> list3 = this.d;
        if (list3 != null) {
            for (f7 a2 : list3) {
                try {
                    a2.a(this.a);
                } catch (Throwable th) {
                    if (a(this.c, 64)) {
                        i3.a(th);
                    }
                }
            }
        }
        this.c = rscMetadata;
        this.d = list;
        this.e = list2;
        if (list != null) {
            for (f7 a3 : list) {
                try {
                    a3.a(this.a, this);
                } catch (Throwable th2) {
                    if (a(rscMetadata, 128)) {
                        i3.a(th2);
                    }
                }
            }
        }
        return list2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009f, code lost:
        if ((((java.lang.Long) r10.first).longValue() + ((long) (r0 * 1000))) < android.os.SystemClock.elapsedRealtime()) goto L_0x00a7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.Object r19) {
        /*
            r18 = this;
            r1 = r18
            java.util.List r0 = r18.a()
            r2 = 0
            if (r0 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.Iterator r3 = r0.iterator()
            r4 = r2
        L_0x000f:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x01c2
            java.lang.Object r0 = r3.next()
            r5 = r0
            com.startapp.e7 r5 = (com.startapp.e7) r5
            r6 = 2
            r8 = 1
            java.util.List<android.util.Pair<com.startapp.f7, java.lang.Boolean>> r0 = r5.b     // Catch:{ all -> 0x0050 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0050 }
        L_0x0024:
            boolean r9 = r0.hasNext()     // Catch:{ all -> 0x0050 }
            if (r9 == 0) goto L_0x004d
            java.lang.Object r9 = r0.next()     // Catch:{ all -> 0x0050 }
            android.util.Pair r9 = (android.util.Pair) r9     // Catch:{ all -> 0x0050 }
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0050 }
            com.startapp.f7 r10 = (com.startapp.f7) r10     // Catch:{ all -> 0x0050 }
            r11 = r19
            boolean r10 = r10.a((java.lang.Object) r11)     // Catch:{ all -> 0x004b }
            if (r10 == 0) goto L_0x0024
            java.lang.Object r0 = r9.second     // Catch:{ all -> 0x004b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0048
            r0 = 2
            goto L_0x0049
        L_0x0048:
            r0 = 0
        L_0x0049:
            r0 = r0 | r8
            goto L_0x005f
        L_0x004b:
            r0 = move-exception
            goto L_0x0053
        L_0x004d:
            r11 = r19
            goto L_0x005e
        L_0x0050:
            r0 = move-exception
            r11 = r19
        L_0x0053:
            r9 = 256(0x100, float:3.59E-43)
            boolean r9 = r5.a(r9)
            if (r9 == 0) goto L_0x005e
            com.startapp.i3.a((java.lang.Throwable) r0)
        L_0x005e:
            r0 = 0
        L_0x005f:
            r9 = r0 & 1
            if (r9 != 0) goto L_0x0067
            r17 = r3
            goto L_0x0183
        L_0x0067:
            com.startapp.l1 r9 = r5.a
            r0 = r0 & 2
            if (r0 != 0) goto L_0x00a5
            int r0 = r5.c
            monitor-enter(r18)
            java.util.Map<com.startapp.l1, android.util.Pair<java.lang.Long, java.lang.ref.SoftReference<org.json.JSONObject>>> r10 = r1.f     // Catch:{ all -> 0x00a2 }
            java.lang.Object r10 = r10.get(r9)     // Catch:{ all -> 0x00a2 }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x00a2 }
            monitor-exit(r18)     // Catch:{ all -> 0x00a2 }
            if (r10 != 0) goto L_0x007e
        L_0x007b:
            r17 = r3
            goto L_0x00a1
        L_0x007e:
            java.lang.Object r12 = r10.second
            java.lang.ref.SoftReference r12 = (java.lang.ref.SoftReference) r12
            java.lang.Object r12 = r12.get()
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            if (r12 != 0) goto L_0x008b
            goto L_0x007b
        L_0x008b:
            java.lang.Object r10 = r10.first
            java.lang.Long r10 = (java.lang.Long) r10
            long r13 = r10.longValue()
            long r15 = android.os.SystemClock.elapsedRealtime()
            int r0 = r0 * 1000
            r17 = r3
            long r2 = (long) r0
            long r13 = r13 + r2
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a8
        L_0x00a1:
            goto L_0x00a7
        L_0x00a2:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x00a2 }
            throw r0
        L_0x00a5:
            r17 = r3
        L_0x00a7:
            r12 = 0
        L_0x00a8:
            r2 = 32
            if (r12 != 0) goto L_0x0181
            android.content.Context r0 = r1.a     // Catch:{ all -> 0x00b8 }
            int[] r3 = r5.d     // Catch:{ all -> 0x00b8 }
            java.lang.Integer r13 = r5.e     // Catch:{ all -> 0x00b8 }
            org.json.JSONArray r0 = r9.a((android.content.Context) r0, (int[]) r3, (java.lang.Integer) r13)     // Catch:{ all -> 0x00b8 }
            r3 = r0
            goto L_0x00c5
        L_0x00b8:
            r0 = move-exception
            r3 = 8
            boolean r3 = r5.a(r3)
            if (r3 == 0) goto L_0x00c4
            com.startapp.i3.a((java.lang.Throwable) r0)
        L_0x00c4:
            r3 = 0
        L_0x00c5:
            if (r3 == 0) goto L_0x0116
            java.lang.Integer r0 = r5.f
            if (r0 == 0) goto L_0x0116
            int r0 = r0.intValue()     // Catch:{ all -> 0x010a }
            if (r0 != r8) goto L_0x00d7
            com.startapp.d7 r0 = new com.startapp.d7     // Catch:{ all -> 0x010a }
            r0.<init>()     // Catch:{ all -> 0x010a }
            goto L_0x00d8
        L_0x00d7:
            r0 = 0
        L_0x00d8:
            if (r0 == 0) goto L_0x0116
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x010a }
            r0.<init>()     // Catch:{ all -> 0x010a }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x010a }
            int r14 = r3.length()     // Catch:{ all -> 0x010a }
            r13.<init>(r14)     // Catch:{ all -> 0x010a }
            int r14 = r3.length()     // Catch:{ all -> 0x010a }
            r15 = 0
        L_0x00ed:
            if (r15 >= r14) goto L_0x0101
            org.json.JSONObject r7 = r3.getJSONObject(r15)     // Catch:{ all -> 0x010a }
            if (r7 == 0) goto L_0x00fe
            java.lang.String r10 = com.startapp.d7.a     // Catch:{ all -> 0x010a }
            java.lang.String r7 = r7.getString(r10)     // Catch:{ all -> 0x010a }
            r13.add(r7)     // Catch:{ all -> 0x010a }
        L_0x00fe:
            int r15 = r15 + 1
            goto L_0x00ed
        L_0x0101:
            java.lang.String r7 = com.startapp.w7.a(r13)     // Catch:{ all -> 0x010a }
            r0.put(r7)     // Catch:{ all -> 0x010a }
            r3 = r0
            goto L_0x0116
        L_0x010a:
            r0 = move-exception
            r7 = 2048(0x800, float:2.87E-42)
            boolean r7 = r5.a(r7)
            if (r7 == 0) goto L_0x0116
            com.startapp.i3.a((java.lang.Throwable) r0)
        L_0x0116:
            if (r3 == 0) goto L_0x0181
            int r0 = r3.length()
            if (r0 <= 0) goto L_0x0181
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            int r0 = r5.g     // Catch:{ JSONException -> 0x015a }
            r0 = r0 & r8
            if (r0 == 0) goto L_0x012a
            r0 = 1
            goto L_0x012b
        L_0x012a:
            r0 = 0
        L_0x012b:
            if (r0 == 0) goto L_0x0136
            java.lang.String r0 = "currentTimeMillis"
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x015a }
            r12.put(r0, r13)     // Catch:{ JSONException -> 0x015a }
        L_0x0136:
            int r0 = r5.g     // Catch:{ JSONException -> 0x015a }
            r0 = r0 & r6
            if (r0 == 0) goto L_0x013d
            r7 = 1
            goto L_0x013e
        L_0x013d:
            r7 = 0
        L_0x013e:
            if (r7 == 0) goto L_0x0149
            java.lang.String r0 = "bootTimeMillis"
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x015a }
            r12.put(r0, r6)     // Catch:{ JSONException -> 0x015a }
        L_0x0149:
            org.json.JSONArray r0 = a((com.startapp.e7) r5)     // Catch:{ JSONException -> 0x015a }
            if (r0 == 0) goto L_0x0154
            java.lang.String r6 = "params"
            r12.put(r6, r0)     // Catch:{ JSONException -> 0x015a }
        L_0x0154:
            java.lang.String r0 = "items"
            r12.put(r0, r3)     // Catch:{ JSONException -> 0x015a }
            goto L_0x0164
        L_0x015a:
            r0 = move-exception
            boolean r3 = r5.a(r2)
            if (r3 == 0) goto L_0x0164
            com.startapp.i3.a((java.lang.Throwable) r0)
        L_0x0164:
            monitor-enter(r18)
            java.util.Map<com.startapp.l1, android.util.Pair<java.lang.Long, java.lang.ref.SoftReference<org.json.JSONObject>>> r0 = r1.f     // Catch:{ all -> 0x017e }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x017e }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x017e }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x017e }
            java.lang.ref.SoftReference r7 = new java.lang.ref.SoftReference     // Catch:{ all -> 0x017e }
            r7.<init>(r12)     // Catch:{ all -> 0x017e }
            r3.<init>(r6, r7)     // Catch:{ all -> 0x017e }
            r0.put(r9, r3)     // Catch:{ all -> 0x017e }
            monitor-exit(r18)
            goto L_0x0181
        L_0x017e:
            r0 = move-exception
            monitor-exit(r18)
            throw r0
        L_0x0181:
            if (r12 != 0) goto L_0x0188
        L_0x0183:
            r3 = r17
            r2 = 0
            goto L_0x000f
        L_0x0188:
            if (r4 != 0) goto L_0x018f
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
        L_0x018f:
            java.lang.String r0 = r9.a     // Catch:{ JSONException -> 0x01b7 }
            org.json.JSONObject r0 = r4.optJSONObject(r0)     // Catch:{ JSONException -> 0x01b7 }
            if (r0 != 0) goto L_0x01a1
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01b7 }
            r0.<init>()     // Catch:{ JSONException -> 0x01b7 }
            java.lang.String r3 = r9.a     // Catch:{ JSONException -> 0x01b7 }
            r4.put(r3, r0)     // Catch:{ JSONException -> 0x01b7 }
        L_0x01a1:
            java.lang.String r3 = r9.b     // Catch:{ JSONException -> 0x01b7 }
            org.json.JSONArray r3 = r0.optJSONArray(r3)     // Catch:{ JSONException -> 0x01b7 }
            if (r3 != 0) goto L_0x01b3
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x01b7 }
            r3.<init>()     // Catch:{ JSONException -> 0x01b7 }
            java.lang.String r6 = r9.b     // Catch:{ JSONException -> 0x01b7 }
            r0.put(r6, r3)     // Catch:{ JSONException -> 0x01b7 }
        L_0x01b3:
            r3.put(r12)     // Catch:{ JSONException -> 0x01b7 }
            goto L_0x0183
        L_0x01b7:
            r0 = move-exception
            boolean r2 = r5.a(r2)
            if (r2 == 0) goto L_0x0183
            com.startapp.i3.a((java.lang.Throwable) r0)
            goto L_0x0183
        L_0x01c2:
            r2 = 0
            if (r4 != 0) goto L_0x01c6
            return r2
        L_0x01c6:
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x01cf }
            java.lang.String r2 = com.startapp.k9.b((java.lang.String) r0)     // Catch:{ all -> 0x01cf }
            goto L_0x01db
        L_0x01cf:
            r0 = move-exception
            r3 = 16
            boolean r3 = r1.a((int) r3)
            if (r3 == 0) goto L_0x01db
            com.startapp.i3.a((java.lang.Throwable) r0)
        L_0x01db:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.c7.a(java.lang.Object):java.lang.String");
    }

    public static String a(String str) throws IOException {
        byte[] a2 = a.a(Base64.decode(str, 8));
        Map<Activity, Integer> map = k9.a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(byteArrayOutputStream, new Inflater(true));
        inflaterOutputStream.write(a2);
        inflaterOutputStream.close();
        return new String(byteArrayOutputStream.toByteArray());
    }
}
