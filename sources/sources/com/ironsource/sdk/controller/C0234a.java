package com.ironsource.sdk.controller;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.environment.a;
import com.ironsource.sdk.b.a;
import com.ironsource.sdk.c.e;
import org.json.JSONObject;

/* renamed from: com.ironsource.sdk.controller.a  reason: case insensitive filesystem */
public final class C0234a implements a {
    C a;
    private e b = e.a();
    private Context c;

    /* renamed from: com.ironsource.sdk.controller.a$a  reason: collision with other inner class name */
    static class C0117a {
        String a;
        JSONObject b;
        String c;
        String d;

        private C0117a() {
        }

        /* synthetic */ C0117a(byte b2) {
            this();
        }
    }

    public C0234a(Context context) {
        this.c = context;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r14, com.ironsource.sdk.controller.A.d.a r15) {
        /*
            r13 = this;
            java.lang.String r0 = "adViewId"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r14)
            com.ironsource.sdk.controller.a$a r14 = new com.ironsource.sdk.controller.a$a
            r2 = 0
            r14.<init>(r2)
            java.lang.String r3 = "functionName"
            java.lang.String r3 = r1.optString(r3)
            r14.a = r3
            java.lang.String r3 = "functionParams"
            org.json.JSONObject r3 = r1.optJSONObject(r3)
            r14.b = r3
            java.lang.String r3 = "success"
            java.lang.String r3 = r1.optString(r3)
            r14.c = r3
            java.lang.String r3 = "fail"
            java.lang.String r1 = r1.optString(r3)
            r14.d = r1
            com.ironsource.sdk.g.f r1 = new com.ironsource.sdk.g.f
            r1.<init>()
            java.lang.String r3 = r14.a     // Catch:{ Exception -> 0x021b }
            int r4 = r3.hashCode()     // Catch:{ Exception -> 0x021b }
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r4) {
                case -1384357108: goto L_0x006a;
                case 691453791: goto L_0x0060;
                case 842351363: goto L_0x0056;
                case 1182065477: goto L_0x004c;
                case 1491535759: goto L_0x0041;
                default: goto L_0x0040;
            }     // Catch:{ Exception -> 0x021b }
        L_0x0040:
            goto L_0x0074
        L_0x0041:
            java.lang.String r4 = "webviewAction"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x021b }
            if (r3 == 0) goto L_0x0074
            r3 = 4
            goto L_0x0075
        L_0x004c:
            java.lang.String r4 = "handleGetViewVisibility"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x021b }
            if (r3 == 0) goto L_0x0074
            r3 = 3
            goto L_0x0075
        L_0x0056:
            java.lang.String r4 = "loadWithUrl"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x021b }
            if (r3 == 0) goto L_0x0074
            r3 = 0
            goto L_0x0075
        L_0x0060:
            java.lang.String r4 = "sendMessage"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x021b }
            if (r3 == 0) goto L_0x0074
            r3 = 1
            goto L_0x0075
        L_0x006a:
            java.lang.String r4 = "removeAdView"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x021b }
            if (r3 == 0) goto L_0x0074
            r3 = 2
            goto L_0x0075
        L_0x0074:
            r3 = -1
        L_0x0075:
            java.lang.String r4 = "adViewId is empty"
            if (r3 == 0) goto L_0x01b3
            java.lang.String r9 = "collection does not contain adViewId"
            if (r3 == r8) goto L_0x0165
            java.lang.String r10 = "removeAdView fail - collection does not contain adViewId"
            java.lang.String r11 = "removeAdView fail - adViewId is empty"
            if (r3 == r7) goto L_0x0121
            if (r3 == r6) goto L_0x00e2
            if (r3 != r5) goto L_0x00d0
            com.ironsource.sdk.c.e r3 = r13.b     // Catch:{ Exception -> 0x021b }
            org.json.JSONObject r5 = r14.b     // Catch:{ Exception -> 0x021b }
            java.lang.String r6 = r14.c     // Catch:{ Exception -> 0x021b }
            java.lang.String r7 = r14.d     // Catch:{ Exception -> 0x021b }
            java.lang.String r8 = r5.getString(r0)     // Catch:{ Exception -> 0x021b }
            boolean r10 = r8.isEmpty()     // Catch:{ Exception -> 0x021b }
            if (r10 != 0) goto L_0x00c3
            java.util.Map<java.lang.String, com.ironsource.sdk.c.f> r4 = r3.b     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.containsKey(r8)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x00b6
            java.util.Map<java.lang.String, com.ironsource.sdk.c.f> r3 = r3.b     // Catch:{ Exception -> 0x021b }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ Exception -> 0x021b }
            com.ironsource.sdk.c.f r3 = (com.ironsource.sdk.c.f) r3     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = "actionName"
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x021b }
            if (r3 == 0) goto L_0x0239
            r3.a((java.lang.String) r4, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x021b }
            goto L_0x0239
        L_0x00b6:
            java.lang.String r3 = com.ironsource.sdk.c.e.a     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = "performWebViewAction fail - collection does not contain adViewId"
            com.ironsource.sdk.utils.Logger.i(r3, r4)     // Catch:{ Exception -> 0x021b }
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x021b }
            r3.<init>(r9)     // Catch:{ Exception -> 0x021b }
            throw r3     // Catch:{ Exception -> 0x021b }
        L_0x00c3:
            java.lang.String r3 = com.ironsource.sdk.c.e.a     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = "performWebViewAction fail - adViewId is empty"
            com.ironsource.sdk.utils.Logger.i(r3, r5)     // Catch:{ Exception -> 0x021b }
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x021b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x021b }
            throw r3     // Catch:{ Exception -> 0x021b }
        L_0x00d0:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = "%s | unsupported AdViews API"
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x021b }
            java.lang.String r6 = r14.a     // Catch:{ Exception -> 0x021b }
            r5[r2] = r6     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x021b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x021b }
            throw r3     // Catch:{ Exception -> 0x021b }
        L_0x00e2:
            com.ironsource.sdk.c.e r3 = r13.b     // Catch:{ Exception -> 0x021b }
            org.json.JSONObject r5 = r14.b     // Catch:{ Exception -> 0x021b }
            java.lang.String r6 = r14.c     // Catch:{ Exception -> 0x021b }
            java.lang.String r7 = r14.d     // Catch:{ Exception -> 0x021b }
            java.lang.String r8 = r5.getString(r0)     // Catch:{ Exception -> 0x021b }
            boolean r12 = r8.isEmpty()     // Catch:{ Exception -> 0x021b }
            if (r12 != 0) goto L_0x0116
            java.util.Map<java.lang.String, com.ironsource.sdk.c.f> r4 = r3.b     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.containsKey(r8)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x010b
            java.util.Map<java.lang.String, com.ironsource.sdk.c.f> r3 = r3.b     // Catch:{ Exception -> 0x021b }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ Exception -> 0x021b }
            com.ironsource.sdk.c.f r3 = (com.ironsource.sdk.c.f) r3     // Catch:{ Exception -> 0x021b }
            if (r3 == 0) goto L_0x0239
            r3.a((org.json.JSONObject) r5, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x021b }
            goto L_0x0239
        L_0x010b:
            java.lang.String r3 = com.ironsource.sdk.c.e.a     // Catch:{ Exception -> 0x021b }
            com.ironsource.sdk.utils.Logger.i(r3, r10)     // Catch:{ Exception -> 0x021b }
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x021b }
            r3.<init>(r9)     // Catch:{ Exception -> 0x021b }
            throw r3     // Catch:{ Exception -> 0x021b }
        L_0x0116:
            java.lang.String r3 = com.ironsource.sdk.c.e.a     // Catch:{ Exception -> 0x021b }
            com.ironsource.sdk.utils.Logger.i(r3, r11)     // Catch:{ Exception -> 0x021b }
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x021b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x021b }
            throw r3     // Catch:{ Exception -> 0x021b }
        L_0x0121:
            com.ironsource.sdk.c.e r3 = r13.b     // Catch:{ Exception -> 0x021b }
            org.json.JSONObject r5 = r14.b     // Catch:{ Exception -> 0x021b }
            java.lang.String r6 = r14.c     // Catch:{ Exception -> 0x021b }
            java.lang.String r7 = r14.d     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = r5.getString(r0)     // Catch:{ Exception -> 0x021b }
            boolean r8 = r5.isEmpty()     // Catch:{ Exception -> 0x021b }
            if (r8 != 0) goto L_0x015a
            java.util.Map<java.lang.String, com.ironsource.sdk.c.f> r4 = r3.b     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.containsKey(r5)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x014f
            java.util.Map<java.lang.String, com.ironsource.sdk.c.f> r4 = r3.b     // Catch:{ Exception -> 0x021b }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x021b }
            com.ironsource.sdk.c.f r4 = (com.ironsource.sdk.c.f) r4     // Catch:{ Exception -> 0x021b }
            java.util.Map<java.lang.String, com.ironsource.sdk.c.f> r3 = r3.b     // Catch:{ Exception -> 0x021b }
            r3.remove(r5)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x0239
            r4.a(r6, r7)     // Catch:{ Exception -> 0x021b }
            goto L_0x0239
        L_0x014f:
            java.lang.String r3 = com.ironsource.sdk.c.e.a     // Catch:{ Exception -> 0x021b }
            com.ironsource.sdk.utils.Logger.i(r3, r10)     // Catch:{ Exception -> 0x021b }
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x021b }
            r3.<init>(r9)     // Catch:{ Exception -> 0x021b }
            throw r3     // Catch:{ Exception -> 0x021b }
        L_0x015a:
            java.lang.String r3 = com.ironsource.sdk.c.e.a     // Catch:{ Exception -> 0x021b }
            com.ironsource.sdk.utils.Logger.i(r3, r11)     // Catch:{ Exception -> 0x021b }
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x021b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x021b }
            throw r3     // Catch:{ Exception -> 0x021b }
        L_0x0165:
            com.ironsource.sdk.c.e r3 = r13.b     // Catch:{ Exception -> 0x021b }
            org.json.JSONObject r5 = r14.b     // Catch:{ Exception -> 0x021b }
            java.lang.String r6 = r14.c     // Catch:{ Exception -> 0x021b }
            java.lang.String r7 = r14.d     // Catch:{ Exception -> 0x021b }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x021b }
            java.lang.String r10 = "params"
            java.lang.String r10 = r5.getString(r10)     // Catch:{ Exception -> 0x021b }
            r8.<init>(r10)     // Catch:{ Exception -> 0x021b }
            java.lang.String r8 = r8.getString(r0)     // Catch:{ Exception -> 0x021b }
            boolean r10 = r8.isEmpty()     // Catch:{ Exception -> 0x021b }
            if (r10 != 0) goto L_0x01a6
            java.util.Map<java.lang.String, com.ironsource.sdk.c.f> r4 = r3.b     // Catch:{ Exception -> 0x021b }
            boolean r4 = r4.containsKey(r8)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x0199
            java.util.Map<java.lang.String, com.ironsource.sdk.c.f> r3 = r3.b     // Catch:{ Exception -> 0x021b }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ Exception -> 0x021b }
            com.ironsource.sdk.c.f r3 = (com.ironsource.sdk.c.f) r3     // Catch:{ Exception -> 0x021b }
            if (r3 == 0) goto L_0x0239
            r3.b(r5, r6, r7)     // Catch:{ Exception -> 0x021b }
            goto L_0x0239
        L_0x0199:
            java.lang.String r3 = com.ironsource.sdk.c.e.a     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = "sendMessageToAd fail - collection does not contain adViewId"
            com.ironsource.sdk.utils.Logger.i(r3, r4)     // Catch:{ Exception -> 0x021b }
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x021b }
            r3.<init>(r9)     // Catch:{ Exception -> 0x021b }
            throw r3     // Catch:{ Exception -> 0x021b }
        L_0x01a6:
            java.lang.String r3 = com.ironsource.sdk.c.e.a     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = "sendMessageToAd fail - adViewId is empty"
            com.ironsource.sdk.utils.Logger.i(r3, r5)     // Catch:{ Exception -> 0x021b }
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x021b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x021b }
            throw r3     // Catch:{ Exception -> 0x021b }
        L_0x01b3:
            com.ironsource.sdk.c.e r3 = r13.b     // Catch:{ Exception -> 0x021b }
            org.json.JSONObject r5 = r14.b     // Catch:{ Exception -> 0x021b }
            android.content.Context r6 = r13.c     // Catch:{ Exception -> 0x021b }
            java.lang.String r7 = r14.c     // Catch:{ Exception -> 0x021b }
            java.lang.String r8 = r14.d     // Catch:{ Exception -> 0x021b }
            java.lang.String r9 = r5.getString(r0)     // Catch:{ Exception -> 0x021b }
            boolean r10 = r9.isEmpty()     // Catch:{ Exception -> 0x021b }
            if (r10 != 0) goto L_0x020e
            com.ironsource.sdk.a r4 = r3.c(r5)     // Catch:{ Exception -> 0x021b }
            java.util.Map<java.lang.String, com.ironsource.sdk.c.f> r10 = r3.b     // Catch:{ Exception -> 0x021b }
            boolean r10 = r10.containsKey(r9)     // Catch:{ Exception -> 0x021b }
            if (r10 != 0) goto L_0x01ff
            com.ironsource.sdk.c.d r10 = new com.ironsource.sdk.c.d     // Catch:{ Exception -> 0x021b }
            r10.<init>(r13, r6, r9, r4)     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = com.ironsource.sdk.utils.IronSourceStorageUtils.getNetworkStorageDir(r6)     // Catch:{ Exception -> 0x021b }
            r10.a = r4     // Catch:{ Exception -> 0x021b }
            com.ironsource.environment.thread.a r4 = com.ironsource.environment.thread.a.a     // Catch:{ Exception -> 0x021b }
            com.ironsource.sdk.c.d$1 r11 = new com.ironsource.sdk.c.d$1     // Catch:{ Exception -> 0x021b }
            r11.<init>(r8, r5, r7)     // Catch:{ Exception -> 0x021b }
            r4.a(r11)     // Catch:{ Exception -> 0x021b }
            boolean r4 = com.ironsource.sdk.c.e.b(r5)     // Catch:{ Exception -> 0x021b }
            if (r4 == 0) goto L_0x01f9
            com.ironsource.environment.thread.a r4 = com.ironsource.environment.thread.a.a     // Catch:{ Exception -> 0x021b }
            com.ironsource.sdk.c.e$1 r5 = new com.ironsource.sdk.c.e$1     // Catch:{ Exception -> 0x021b }
            r5.<init>(r10, r6, r9)     // Catch:{ Exception -> 0x021b }
            r4.a(r5)     // Catch:{ Exception -> 0x021b }
            return
        L_0x01f9:
            java.util.Map<java.lang.String, com.ironsource.sdk.c.f> r3 = r3.b     // Catch:{ Exception -> 0x021b }
            r3.put(r9, r10)     // Catch:{ Exception -> 0x021b }
            goto L_0x0239
        L_0x01ff:
            java.lang.String r3 = com.ironsource.sdk.c.e.a     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = "sendMessageToAd fail - collection already contain adViewId"
            com.ironsource.sdk.utils.Logger.i(r3, r4)     // Catch:{ Exception -> 0x021b }
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x021b }
            java.lang.String r4 = "collection already contain adViewId"
            r3.<init>(r4)     // Catch:{ Exception -> 0x021b }
            throw r3     // Catch:{ Exception -> 0x021b }
        L_0x020e:
            java.lang.String r3 = com.ironsource.sdk.c.e.a     // Catch:{ Exception -> 0x021b }
            java.lang.String r5 = "loadWithUrl fail - adViewId is empty"
            com.ironsource.sdk.utils.Logger.i(r3, r5)     // Catch:{ Exception -> 0x021b }
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x021b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x021b }
            throw r3     // Catch:{ Exception -> 0x021b }
        L_0x021b:
            r3 = move-exception
            java.lang.String r4 = "errMsg"
            java.lang.String r3 = r3.getMessage()
            r1.a((java.lang.String) r4, (java.lang.String) r3)
            org.json.JSONObject r3 = r14.b
            java.lang.String r3 = com.ironsource.sdk.c.e.a((org.json.JSONObject) r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0234
            r1.a((java.lang.String) r0, (java.lang.String) r3)
        L_0x0234:
            java.lang.String r14 = r14.d
            r15.a((boolean) r2, (java.lang.String) r14, (com.ironsource.sdk.g.f) r1)
        L_0x0239:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.C0234a.a(java.lang.String, com.ironsource.sdk.controller.A$d$a):void");
    }

    public final void a(String str, String str2, String str3) {
        a(str, a.AnonymousClass1.b(str2, str3));
    }

    public final void a(String str, JSONObject jSONObject) {
        if (this.a != null && !TextUtils.isEmpty(str)) {
            this.a.a(str, jSONObject);
        }
    }
}
