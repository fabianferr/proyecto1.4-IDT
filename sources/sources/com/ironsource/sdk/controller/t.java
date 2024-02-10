package com.ironsource.sdk.controller;

import android.content.Context;
import org.json.JSONObject;

public class t {
    private static final String a = "t";
    private final Context b;
    private final com.ironsource.sdk.e.a.a c = new com.ironsource.sdk.e.a.a();

    static class a {
        String a;
        JSONObject b;
        String c;
        String d;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public t(Context context) {
        this.b = context;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r13, com.ironsource.sdk.controller.A.d.a r14) {
        /*
            r12 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r13)
            com.ironsource.sdk.controller.t$a r13 = new com.ironsource.sdk.controller.t$a
            r1 = 0
            r13.<init>(r1)
            java.lang.String r2 = "omidFunction"
            java.lang.String r2 = r0.optString(r2)
            r13.a = r2
            java.lang.String r2 = "omidParams"
            org.json.JSONObject r2 = r0.optJSONObject(r2)
            r13.b = r2
            java.lang.String r2 = "success"
            java.lang.String r2 = r0.optString(r2)
            r13.c = r2
            java.lang.String r2 = "fail"
            java.lang.String r0 = r0.optString(r2)
            r13.d = r0
            com.ironsource.sdk.g.f r0 = new com.ironsource.sdk.g.f
            r0.<init>()
            org.json.JSONObject r2 = r13.b
            java.lang.String r3 = "adViewId"
            if (r2 == 0) goto L_0x0048
            org.json.JSONObject r2 = r13.b
            java.lang.String r4 = ""
            java.lang.String r2 = r2.optString(r3, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L_0x0048
            r0.a((java.lang.String) r3, (java.lang.String) r2)
        L_0x0048:
            java.lang.String r2 = r13.a     // Catch:{ Exception -> 0x0192 }
            int r4 = r2.hashCode()     // Catch:{ Exception -> 0x0192 }
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r4) {
                case -1655974669: goto L_0x007f;
                case -984459207: goto L_0x0075;
                case 70701699: goto L_0x006b;
                case 1208109646: goto L_0x0061;
                case 1850541012: goto L_0x0056;
                default: goto L_0x0055;
            }     // Catch:{ Exception -> 0x0192 }
        L_0x0055:
            goto L_0x0089
        L_0x0056:
            java.lang.String r4 = "startSession"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0192 }
            if (r2 == 0) goto L_0x0089
            r2 = 1
            goto L_0x008a
        L_0x0061:
            java.lang.String r4 = "impressionOccurred"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0192 }
            if (r2 == 0) goto L_0x0089
            r2 = 3
            goto L_0x008a
        L_0x006b:
            java.lang.String r4 = "finishSession"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0192 }
            if (r2 == 0) goto L_0x0089
            r2 = 2
            goto L_0x008a
        L_0x0075:
            java.lang.String r4 = "getOmidData"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0192 }
            if (r2 == 0) goto L_0x0089
            r2 = 4
            goto L_0x008a
        L_0x007f:
            java.lang.String r4 = "activate"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0192 }
            if (r2 == 0) goto L_0x0089
            r2 = 0
            goto L_0x008a
        L_0x0089:
            r2 = -1
        L_0x008a:
            if (r2 == 0) goto L_0x017b
            if (r2 == r8) goto L_0x0104
            java.lang.String r4 = "OMID Session has not started"
            if (r2 == r7) goto L_0x00df
            if (r2 == r6) goto L_0x00b0
            if (r2 != r5) goto L_0x009e
            com.ironsource.sdk.e.a.a r2 = r12.c     // Catch:{ Exception -> 0x0192 }
        L_0x0098:
            com.ironsource.sdk.g.f r0 = r2.a()     // Catch:{ Exception -> 0x0192 }
            goto L_0x018c
        L_0x009e:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0192 }
            java.lang.String r3 = "%s | unsupported OMID API"
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0192 }
            java.lang.String r5 = r13.a     // Catch:{ Exception -> 0x0192 }
            r4[r1] = r5     // Catch:{ Exception -> 0x0192 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ Exception -> 0x0192 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0192 }
            throw r2     // Catch:{ Exception -> 0x0192 }
        L_0x00b0:
            com.ironsource.sdk.e.a.a r2 = r12.c     // Catch:{ Exception -> 0x0192 }
            org.json.JSONObject r5 = r13.b     // Catch:{ Exception -> 0x0192 }
            r2.a(r5)     // Catch:{ Exception -> 0x0192 }
            java.util.HashMap<java.lang.String, com.iab.omid.library.ironsrc.adsession.AdSession> r2 = r2.c     // Catch:{ Exception -> 0x0192 }
            java.lang.String r3 = r5.optString(r3)     // Catch:{ Exception -> 0x0192 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0192 }
            com.iab.omid.library.ironsrc.adsession.AdSession r2 = (com.iab.omid.library.ironsrc.adsession.AdSession) r2     // Catch:{ Exception -> 0x0192 }
            if (r2 == 0) goto L_0x00d9
            com.iab.omid.library.ironsrc.adsession.AdEvents r2 = com.iab.omid.library.ironsrc.adsession.AdEvents.createAdEvents(r2)     // Catch:{ Exception -> 0x0192 }
            java.lang.String r3 = "signalLoaded"
            boolean r3 = r5.optBoolean(r3)     // Catch:{ Exception -> 0x0192 }
            if (r3 == 0) goto L_0x00d4
            r2.loaded()     // Catch:{ Exception -> 0x0192 }
        L_0x00d4:
            r2.impressionOccurred()     // Catch:{ Exception -> 0x0192 }
            goto L_0x018c
        L_0x00d9:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0192 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0192 }
            throw r2     // Catch:{ Exception -> 0x0192 }
        L_0x00df:
            com.ironsource.sdk.e.a.a r2 = r12.c     // Catch:{ Exception -> 0x0192 }
            org.json.JSONObject r5 = r13.b     // Catch:{ Exception -> 0x0192 }
            r2.a(r5)     // Catch:{ Exception -> 0x0192 }
            java.lang.String r3 = r5.optString(r3)     // Catch:{ Exception -> 0x0192 }
            java.util.HashMap<java.lang.String, com.iab.omid.library.ironsrc.adsession.AdSession> r5 = r2.c     // Catch:{ Exception -> 0x0192 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ Exception -> 0x0192 }
            com.iab.omid.library.ironsrc.adsession.AdSession r5 = (com.iab.omid.library.ironsrc.adsession.AdSession) r5     // Catch:{ Exception -> 0x0192 }
            if (r5 == 0) goto L_0x00fe
            r5.finish()     // Catch:{ Exception -> 0x0192 }
            java.util.HashMap<java.lang.String, com.iab.omid.library.ironsrc.adsession.AdSession> r2 = r2.c     // Catch:{ Exception -> 0x0192 }
            r2.remove(r3)     // Catch:{ Exception -> 0x0192 }
            goto L_0x018c
        L_0x00fe:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0192 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0192 }
            throw r2     // Catch:{ Exception -> 0x0192 }
        L_0x0104:
            com.ironsource.sdk.e.a.a r2 = r12.c     // Catch:{ Exception -> 0x0192 }
            org.json.JSONObject r3 = r13.b     // Catch:{ Exception -> 0x0192 }
            com.ironsource.sdk.e.a.a$a r3 = com.ironsource.sdk.e.a.a.C0119a.a(r3)     // Catch:{ Exception -> 0x0192 }
            boolean r4 = r2.d     // Catch:{ Exception -> 0x0192 }
            if (r4 == 0) goto L_0x0173
            java.lang.String r4 = r3.g     // Catch:{ Exception -> 0x0192 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0192 }
            if (r4 != 0) goto L_0x016b
            java.lang.String r4 = r3.g     // Catch:{ Exception -> 0x0192 }
            java.util.HashMap<java.lang.String, com.iab.omid.library.ironsrc.adsession.AdSession> r5 = r2.c     // Catch:{ Exception -> 0x0192 }
            boolean r5 = r5.containsKey(r4)     // Catch:{ Exception -> 0x0192 }
            if (r5 != 0) goto L_0x0163
            com.ironsource.sdk.c.e r5 = com.ironsource.sdk.c.e.a()     // Catch:{ Exception -> 0x0192 }
            com.ironsource.sdk.c.f r5 = r5.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0192 }
            if (r5 == 0) goto L_0x015b
            com.iab.omid.library.ironsrc.adsession.CreativeType r6 = r3.f     // Catch:{ Exception -> 0x0192 }
            com.iab.omid.library.ironsrc.adsession.ImpressionType r7 = r3.e     // Catch:{ Exception -> 0x0192 }
            com.iab.omid.library.ironsrc.adsession.Owner r9 = r3.b     // Catch:{ Exception -> 0x0192 }
            com.iab.omid.library.ironsrc.adsession.Owner r10 = r3.c     // Catch:{ Exception -> 0x0192 }
            boolean r11 = r3.a     // Catch:{ Exception -> 0x0192 }
            com.iab.omid.library.ironsrc.adsession.AdSessionConfiguration r6 = com.iab.omid.library.ironsrc.adsession.AdSessionConfiguration.createAdSessionConfiguration(r6, r7, r9, r10, r11)     // Catch:{ Exception -> 0x0192 }
            com.iab.omid.library.ironsrc.adsession.Partner r7 = r2.b     // Catch:{ Exception -> 0x0192 }
            android.webkit.WebView r9 = r5.a()     // Catch:{ Exception -> 0x0192 }
            java.lang.String r3 = r3.d     // Catch:{ Exception -> 0x0192 }
            r10 = 0
            com.iab.omid.library.ironsrc.adsession.AdSessionContext r3 = com.iab.omid.library.ironsrc.adsession.AdSessionContext.createHtmlAdSessionContext(r7, r9, r10, r3)     // Catch:{ Exception -> 0x0192 }
            com.iab.omid.library.ironsrc.adsession.AdSession r3 = com.iab.omid.library.ironsrc.adsession.AdSession.createAdSession(r6, r3)     // Catch:{ Exception -> 0x0192 }
            android.webkit.WebView r5 = r5.a()     // Catch:{ Exception -> 0x0192 }
            r3.registerAdView(r5)     // Catch:{ Exception -> 0x0192 }
            r3.start()     // Catch:{ Exception -> 0x0192 }
            java.util.HashMap<java.lang.String, com.iab.omid.library.ironsrc.adsession.AdSession> r2 = r2.c     // Catch:{ Exception -> 0x0192 }
            r2.put(r4, r3)     // Catch:{ Exception -> 0x0192 }
            goto L_0x018c
        L_0x015b:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0192 }
            java.lang.String r3 = "No adview found with the provided adViewId"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0192 }
            throw r2     // Catch:{ Exception -> 0x0192 }
        L_0x0163:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0192 }
            java.lang.String r3 = "OMID Session has already started"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0192 }
            throw r2     // Catch:{ Exception -> 0x0192 }
        L_0x016b:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0192 }
            java.lang.String r3 = "Missing adview id in OMID params"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0192 }
            throw r2     // Catch:{ Exception -> 0x0192 }
        L_0x0173:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0192 }
            java.lang.String r3 = "OMID has not been activated"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0192 }
            throw r2     // Catch:{ Exception -> 0x0192 }
        L_0x017b:
            com.ironsource.sdk.e.a.a r2 = r12.c     // Catch:{ Exception -> 0x0192 }
            android.content.Context r3 = r12.b     // Catch:{ Exception -> 0x0192 }
            boolean r4 = r2.d     // Catch:{ Exception -> 0x0192 }
            if (r4 != 0) goto L_0x0188
            com.iab.omid.library.ironsrc.Omid.activate(r3)     // Catch:{ Exception -> 0x0192 }
            r2.d = r8     // Catch:{ Exception -> 0x0192 }
        L_0x0188:
            com.ironsource.sdk.e.a.a r2 = r12.c     // Catch:{ Exception -> 0x0192 }
            goto L_0x0098
        L_0x018c:
            java.lang.String r2 = r13.c     // Catch:{ Exception -> 0x0192 }
            r14.a((boolean) r8, (java.lang.String) r2, (com.ironsource.sdk.g.f) r0)     // Catch:{ Exception -> 0x0192 }
            return
        L_0x0192:
            r2 = move-exception
            java.lang.String r3 = "errMsg"
            java.lang.String r4 = r2.getMessage()
            r0.a((java.lang.String) r3, (java.lang.String) r4)
            java.lang.String r3 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "OMIDJSAdapter "
            r4.<init>(r5)
            java.lang.String r5 = r13.a
            r4.append(r5)
            java.lang.String r5 = " Exception: "
            r4.append(r5)
            java.lang.String r2 = r2.getMessage()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.ironsource.sdk.utils.Logger.i(r3, r2)
            java.lang.String r13 = r13.d
            r14.a((boolean) r1, (java.lang.String) r13, (com.ironsource.sdk.g.f) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.t.a(java.lang.String, com.ironsource.sdk.controller.A$d$a):void");
    }
}
